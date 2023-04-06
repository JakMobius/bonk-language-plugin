package com.jakmobius.bonk;

import com.intellij.psi.PsiDirectory;
import com.intellij.psi.PsiFile;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PsiFileUtils {

    @Nullable
    public static PsiFile getNeighborPsiFile(@NotNull PsiFile psiFile, @NotNull String neighborFileName) {
        PsiDirectory parent = psiFile.getParent();
        if (parent == null) {
            return null;
        }
        return parent.findFile(neighborFileName);
    }
}