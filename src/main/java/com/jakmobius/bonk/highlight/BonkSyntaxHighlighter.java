package com.jakmobius.bonk.highlight;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import com.jakmobius.bonk.psi.BonkLexerAdapter;
import com.jakmobius.bonk.psi.BonkTokenSets;
import com.jakmobius.bonk.psi.BonkTypes;
import org.jetbrains.annotations.NotNull;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public class BonkSyntaxHighlighter extends SyntaxHighlighterBase {

    public static final TextAttributesKey SEPARATOR =
            createTextAttributesKey("BONK_SEPARATOR", DefaultLanguageHighlighterColors.OPERATION_SIGN);
    public static final TextAttributesKey KEYWORD =
            createTextAttributesKey("BONK_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey STRING =
            createTextAttributesKey("BONK_STRING", DefaultLanguageHighlighterColors.STRING);
    public static final TextAttributesKey COMMENT =
            createTextAttributesKey("BONK_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
    public static final TextAttributesKey NUMBER =
            createTextAttributesKey("BONK_NUMBER", DefaultLanguageHighlighterColors.NUMBER);
    public static final TextAttributesKey PAREN =
            createTextAttributesKey("BONK_PAREN", DefaultLanguageHighlighterColors.PARENTHESES);
    public static final TextAttributesKey SEMICOLON =
            createTextAttributesKey("BONK_SEMICOLON", DefaultLanguageHighlighterColors.SEMICOLON);
    public static final TextAttributesKey BAD_CHARACTER =
            createTextAttributesKey("BONK_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER);


    private static final TextAttributesKey[] BAD_CHAR_KEYS = new TextAttributesKey[]{BAD_CHARACTER};
    private static final TextAttributesKey[] SEPARATOR_KEYS = new TextAttributesKey[]{SEPARATOR};
    private static final TextAttributesKey[] KEYWORD_KEYS = new TextAttributesKey[]{KEYWORD};
    private static final TextAttributesKey[] STRING_KEYS = new TextAttributesKey[]{STRING};
    private static final TextAttributesKey[] COMMENT_KEYS = new TextAttributesKey[]{COMMENT};

    private static final TextAttributesKey[] PAREN_KEYS = new TextAttributesKey[]{PAREN};
    private static final TextAttributesKey[] SEMICOLON_KEYS = new TextAttributesKey[]{SEMICOLON};
    private static final TextAttributesKey[] NUMBER_KEYS = new TextAttributesKey[]{NUMBER};
    private static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];

    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new BonkLexerAdapter();
    }

    @Override
    public TextAttributesKey @NotNull [] getTokenHighlights(IElementType tokenType) {

        if (tokenType.equals(BonkTypes.SEMICOLON)) {
            return SEMICOLON_KEYS;
        }

        if (BonkTokenSets.PAREN.contains(tokenType)) {
            return PAREN_KEYS;
        }

        if (BonkTokenSets.COMMENTS.contains(tokenType)) {
            return COMMENT_KEYS;
        }

        if (BonkTokenSets.SEPARATORS.contains(tokenType)) {
            return SEPARATOR_KEYS;
        }

        if (BonkTokenSets.STRING_LITERALS.contains(tokenType)) {
            return STRING_KEYS;
        }

        if (BonkTokenSets.KEYWORDS.contains(tokenType)) {
            return KEYWORD_KEYS;
        }

        if (BonkTokenSets.OPERATORS.contains(tokenType)) {
            return KEYWORD_KEYS;
        }

        if (BonkTokenSets.NUMBERS.contains(tokenType)) {
            return NUMBER_KEYS;
        }

        if (tokenType.equals(TokenType.BAD_CHARACTER)) {
            return BAD_CHAR_KEYS;
        }
        return EMPTY_KEYS;
    }

}