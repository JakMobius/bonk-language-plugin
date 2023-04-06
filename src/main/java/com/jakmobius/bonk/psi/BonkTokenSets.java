package com.jakmobius.bonk.psi;

import com.intellij.psi.tree.TokenSet;
import io.netty.channel.group.DefaultChannelGroup;

public interface BonkTokenSets {

    TokenSet IDENTIFIERS = TokenSet.create(BonkTypes.ID);
    TokenSet COMMENTS = TokenSet.create(BonkTypes.BLOCK_COMMENT, BonkTypes.LINE_COMMENT);
    TokenSet STRING_LITERALS = TokenSet.create(BonkTypes.STRING);
    TokenSet NUMBERS = TokenSet.create(BonkTypes.NUMBER);
    TokenSet SEPARATORS = TokenSet.create(BonkTypes.COMMA, BonkTypes.COLON, BonkTypes.SEMICOLON);

    TokenSet KEYWORDS = TokenSet.create(
            BonkTypes.BUUL_KEYWORD,
            BonkTypes.DABL_KEYWORD,
            BonkTypes.FLOT_KEYWORD,
            BonkTypes.LONG_KEYWORD,
            BonkTypes.MANY_KEYWORD,
            BonkTypes.NOTHING_KEYWORD,
            BonkTypes.NUBR_KEYWORD,
            BonkTypes.NULL_KEYWORD,
            BonkTypes.SHRT_KEYWORD,
            BonkTypes.STRG_KEYWORD);

    TokenSet OPERATORS = TokenSet.create(
            BonkTypes.AND_OPERATOR,
            BonkTypes.BLOK_OPERATOR,
            BonkTypes.BONK_OPERATOR,
            BonkTypes.BOWL_OPERATOR,
            BonkTypes.BREK_OPERATOR,
            BonkTypes.CALL_OPERATOR,
            BonkTypes.HELP_OPERATOR,
            BonkTypes.HIVE_OPERATOR,
            BonkTypes.LOOP_OPERATOR,
            BonkTypes.NOT_OPERATOR,
            BonkTypes.OF_OPERATOR,
            BonkTypes.OR_OPERATOR
    );

    TokenSet PAREN = TokenSet.create(
            BonkTypes.LEFT_PAREN,
            BonkTypes.RIGHT_PAREN,
            BonkTypes.LEFT_BRACKET,
            BonkTypes.RIGHT_BRACKET,
            BonkTypes.LEFT_CURLY,
            BonkTypes.RIGHT_CURLY
    );
}