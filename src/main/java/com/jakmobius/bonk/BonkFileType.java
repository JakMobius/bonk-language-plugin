
package com.jakmobius.bonk;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class BonkFileType extends LanguageFileType {

    public static final BonkFileType INSTANCE = new BonkFileType();

    private BonkFileType() {
        super(BonkLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "Bonk file";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Bonk language file";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "bs";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return BonkIcons.FILE;
    }

}