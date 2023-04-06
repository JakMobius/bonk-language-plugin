package com.jakmobius.bonk.psi;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import com.jakmobius.bonk.BonkFileType;
import com.jakmobius.bonk.BonkLanguage;
import org.jetbrains.annotations.NotNull;

public class BonkFile extends PsiFileBase {

    public BonkFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, BonkLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return BonkFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "Bonk File";
    }

}