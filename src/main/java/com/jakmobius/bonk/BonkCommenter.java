package com.jakmobius.bonk;

import com.intellij.lang.Commenter;
import org.jetbrains.annotations.Nullable;

public class BonkCommenter implements Commenter {

    @Nullable
    @Override
    public String getLineCommentPrefix() {
        return "dogo:";
    }

    @Nullable
    @Override
    public String getBlockCommentPrefix() {
        return "-dogo->";
    }

    @Nullable
    @Override
    public String getBlockCommentSuffix() {
        return "<-dogo-";
    }

    @Nullable
    @Override
    public String getCommentedBlockCommentPrefix() {
        return null;
    }

    @Nullable
    @Override
    public String getCommentedBlockCommentSuffix() {
        return null;
    }
}