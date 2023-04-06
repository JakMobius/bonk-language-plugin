package com.jakmobius.bonk;

import com.intellij.lang.refactoring.RefactoringSupportProvider;
import com.intellij.psi.PsiElement;
import com.jakmobius.bonk.psi.BonkIdentifier;
import com.jakmobius.bonk.psi.BonkProgram;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class BonkRefactoringSupportProvider extends RefactoringSupportProvider {

    @Override
    public boolean isMemberInplaceRenameAvailable(@NotNull PsiElement elementToRename, @Nullable PsiElement context) {
        if(!(elementToRename instanceof BonkIdentifier)) {
            return false;
        }

        BonkIdentifier identifier = (BonkIdentifier) elementToRename;
        return !(BonkUtil.getScope(identifier) instanceof BonkProgram);
    }

}