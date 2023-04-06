package com.jakmobius.bonk;

import com.intellij.openapi.util.TextRange;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.*;
import com.intellij.util.ProcessingContext;
import com.jakmobius.bonk.psi.BonkIdentifier;
import com.jakmobius.bonk.psi.BonkParameterList;
import com.jakmobius.bonk.psi.BonkParameterListItem;
import com.jakmobius.bonk.psi.BonkVariableDeclaration;
import org.jetbrains.annotations.NotNull;

public class BonkReferenceContributor extends PsiReferenceContributor {

    BonkReferenceContributor() {
        super();
    }
    @Override
    public void registerReferenceProviders(@NotNull PsiReferenceRegistrar registrar) {
        registrar.registerReferenceProvider(PlatformPatterns.psiElement(BonkIdentifier.class),
        new PsiReferenceProvider() {
            @Override
            public PsiReference @NotNull [] getReferencesByElement(@NotNull PsiElement element,
                                                                   @NotNull ProcessingContext context) {
                BonkIdentifier identifier = (BonkIdentifier) element;

                // If the identifier is a parameter name in a call, don't create a reference

                if (identifier.getParent() instanceof BonkParameterListItem) {
                    return PsiReference.EMPTY_ARRAY;
                }

                return new PsiReference[]{new BonkReference(identifier)};
            }
        });
    }
}
