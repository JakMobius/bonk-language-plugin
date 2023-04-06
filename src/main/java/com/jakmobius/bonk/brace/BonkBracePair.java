package com.jakmobius.bonk.brace;

import com.intellij.lang.BracePair;
import com.intellij.psi.tree.IElementType;
import com.jakmobius.bonk.psi.BonkTypes;

class BonkBracePair extends BracePair {
    private final IElementType myLeft;
    private final IElementType myRight;
    private boolean structural = false;

    BonkBracePair(IElementType left, IElementType right) {
        super(left, right, false);
        myLeft = left;
        myRight = right;

        if(left == BonkTypes.LEFT_BRACKET || left == BonkTypes.LEFT_CURLY) {
            structural = true;
        }
    }

    @Override
    public IElementType getLeftBraceType() {
        return myLeft;
    }

    @Override
    public IElementType getRightBraceType() {
        return myRight;
    }

    @Override
    public boolean isStructural() {
        return structural;
    }
}
