package com.jakmobius.bonk.psi;

import com.intellij.lexer.FlexAdapter;
import com.jakmobius.bonk.grammar._BonkLexer;

public class BonkLexerAdapter extends FlexAdapter {

    public BonkLexerAdapter() {
        super(new _BonkLexer(null));
    }

}
