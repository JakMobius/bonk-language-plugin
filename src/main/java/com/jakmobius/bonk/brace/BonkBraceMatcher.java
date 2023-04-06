package com.jakmobius.bonk.brace;

import com.intellij.lang.BracePair;
import com.intellij.lang.PairedBraceMatcher;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;
import com.jakmobius.bonk.psi.BonkTypes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class BonkBraceMatcher implements PairedBraceMatcher {
    private static final BracePair[] PAIRS = new BracePair[]{
            new BonkBracePair(BonkTypes.LEFT_PAREN, BonkTypes.RIGHT_PAREN),
            new BonkBracePair(BonkTypes.LEFT_BRACKET, BonkTypes.RIGHT_BRACKET),
            new BonkBracePair(BonkTypes.LEFT_CURLY, BonkTypes.RIGHT_CURLY)
    };

    @Override
    public BracePair[] getPairs() {
        return PAIRS;
    }

    @Override
    public boolean isPairedBracesAllowedBeforeType(@NotNull IElementType lbraceType, @Nullable IElementType contextType) {
        return true;
    }

    @Override
    public int getCodeConstructStart(PsiFile file, int openingBraceOffset) {
        return openingBraceOffset;
    }
}