package com.jakmobius.bonk.psi;

import com.intellij.lang.ASTNode;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import com.jakmobius.bonk.BonkLanguage;
import com.jakmobius.bonk.BonkParser;
import org.jetbrains.annotations.NotNull;

public class BonkParserDefinition implements ParserDefinition {

    public static final IFileElementType FILE = new IFileElementType(BonkLanguage.INSTANCE);

    @NotNull
    @Override
    public Lexer createLexer(Project project) {
        return new BonkLexerAdapter();
    }

    @NotNull
    @Override
    public TokenSet getCommentTokens() {
        return BonkTokenSets.COMMENTS;
    }

    @NotNull
    @Override
    public TokenSet getStringLiteralElements() {
        return BonkTokenSets.STRING_LITERALS;
    }

    @NotNull
    @Override
    public PsiParser createParser(final Project project) {
        return new BonkParser();
    }

    @NotNull
    @Override
    public IFileElementType getFileNodeType() {
        return FILE;
    }

    @NotNull
    @Override
    public PsiFile createFile(@NotNull FileViewProvider viewProvider) {
        return new BonkFile(viewProvider);
    }

    @NotNull
    @Override
    public PsiElement createElement(ASTNode node) {
        return BonkTypes.Factory.createElement(node);
    }
}
