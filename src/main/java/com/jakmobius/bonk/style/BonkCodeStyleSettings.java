package com.jakmobius.bonk.style;

import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.intellij.psi.codeStyle.CustomCodeStyleSettings;

public class BonkCodeStyleSettings extends CustomCodeStyleSettings {
    public int SPECIAL_INDENT = 2;

    public BonkCodeStyleSettings(CodeStyleSettings container) {
        super("BonkCodeStyleSettings", container);
    }
}
