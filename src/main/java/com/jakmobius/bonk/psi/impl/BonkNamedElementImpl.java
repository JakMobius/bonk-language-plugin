package com.jakmobius.bonk.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import com.intellij.psi.impl.source.resolve.reference.ReferenceProvidersRegistry;
import com.jakmobius.bonk.psi.BonkNamedElement;
import com.jakmobius.bonk.psi.BonkTypes;
import org.jetbrains.annotations.NotNull;

public abstract class BonkNamedElementImpl extends ASTWrapperPsiElement implements BonkNamedElement {

    public BonkNamedElementImpl(@NotNull ASTNode node) {
        super(node);
    }

    @Override
    public PsiElement getNameIdentifier() {
        return findChildByType(BonkTypes.ID);
    }

    @Override
    public PsiReference @NotNull [] getReferences() {
        return ReferenceProvidersRegistry.getReferencesFromProviders(this);
    }
}
