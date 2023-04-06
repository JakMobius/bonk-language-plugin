package com.jakmobius.bonk.psi;

import com.intellij.psi.tree.IElementType;
import com.jakmobius.bonk.BonkLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class BonkElementType extends IElementType {

    public BonkElementType(@NotNull @NonNls String debugName) {
        super(debugName, BonkLanguage.INSTANCE);
    }

}
