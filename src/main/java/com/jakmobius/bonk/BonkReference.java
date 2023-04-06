package com.jakmobius.bonk;

import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.*;
import com.intellij.util.IncorrectOperationException;
import com.jakmobius.bonk.psi.BonkIdentifier;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class BonkReference extends PsiReferenceBase<PsiElement> {

    private final String key;
    BonkIdentifier id;

    public BonkReference(@NotNull BonkIdentifier element) {
        super(element, new TextRange(0, element.getTextLength()));
        this.id = element;
        key = element.getText();
    }

    @Nullable
    @Override
    public PsiElement resolve() {
        return BonkUtil.findDefinitionFor(id);
    }

    @Override
    public Object @NotNull [] getVariants() {
        final List<BonkIdentifier> identifiers = BonkUtil.getVisibleIdentifiers(myElement);
        List<LookupElement> variants = new ArrayList<>();
        for (BonkIdentifier identifier : identifiers) {

            Icon properIcon = BonkUtil.properIconForDefId(identifier);

            LookupElement element = LookupElementBuilder
                    .create(identifier)
                    .withPsiElement(identifier)
                    .withIcon(properIcon)
                    .withTailText(" (" + identifier.getContainingFile().getName() + ")", true);

            variants.add(element);
        }
        return variants.toArray();
    }

    @Override
    public PsiElement bindToElement(@NotNull PsiElement element) throws IncorrectOperationException {
        if (element instanceof BonkIdentifier) {
            BonkIdentifier identifier = (BonkIdentifier) element;
            PsiElement parent = myElement.getParent();
            if (parent instanceof BonkIdentifier) {
                BonkIdentifier parentIdentifier = (BonkIdentifier) parent;
                return parentIdentifier.setName(identifier.getName());
            }
        }

        throw new IncorrectOperationException("Cannot bind to element of type " + element.getClass().getName());
    }

    @Override
    public PsiElement handleElementRename(@NotNull String newElementName) throws IncorrectOperationException {
        return id.setName(newElementName);
    }
}
