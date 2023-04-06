package com.jakmobius.bonk.formatting;

import com.intellij.formatting.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.TokenType;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.intellij.psi.formatter.common.AbstractBlock;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.ILeafElementType;
import com.intellij.psi.tree.TokenSet;
import com.jakmobius.bonk.BonkLanguage;
import com.jakmobius.bonk.psi.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class BonkFormattingBlock extends AbstractBlock {
    private final SpacingBuilder spacingBuilder;
    private final CodeStyleSettings settings;

    private final Indent indent;

    private static final TokenSet BLOCKS_TOKEN_SET = TokenSet.create(
            BonkTypes.CODE_BLOCK,
            BonkTypes.HIVE_DECLARATION,
            BonkTypes.PARAMETER_LIST_DECLARATION,
            BonkTypes.PARAMETER_LIST,
            BonkTypes.STRING
    );

    private static final TokenSet BRACES_TOKEN_SET = TokenSet.create(
            BonkTypes.LEFT_BRACKET,
            BonkTypes.RIGHT_BRACKET,
            BonkTypes.LEFT_PAREN,
            BonkTypes.RIGHT_PAREN,
            BonkTypes.LEFT_CURLY,
            BonkTypes.RIGHT_CURLY
    );

    public BonkFormattingBlock(@NotNull PsiElement element, @Nullable Wrap wrap, @Nullable Alignment alignment, Indent indent, SpacingBuilder spacingBuilder, CodeStyleSettings settings) {
        super(element.getNode(), wrap, alignment);

        if (spacingBuilder == null) {
            spacingBuilder = createSpaceBuilder(settings);
        }

        this.spacingBuilder = spacingBuilder;
        this.settings = settings;
        this.indent = indent;
    }

    @NotNull
    private static Indent indentIfNotBrace(@NotNull ASTNode child) {
        return BRACES_TOKEN_SET.contains(child.getElementType()) ? Indent.getNoneIndent() : Indent.getNormalIndent();
    }

    @NotNull
    private Indent calcIndent(@NotNull ASTNode child) {
        IElementType parentType = myNode.getElementType();
        IElementType type = child.getElementType();

        if (parentType == BonkTypes.PARAMETER_LIST && type != BonkTypes.LEFT_BRACKET && type != BonkTypes.RIGHT_BRACKET)
            return Indent.getNormalIndent();
        if (BLOCKS_TOKEN_SET.contains(parentType)) return indentIfNotBrace(child);
        if (parentType == BonkTypes.HELP_STATEMENT) return indentOfMultipleDeclarationChild(type, BonkTypes.STRING);
        if (parentType == BonkTypes.VARIABLE_DECLARATION)
            return indentOfMultipleDeclarationChild(type, BonkTypes.EXPRESSION);

        return Indent.getNoneIndent();
    }

    private Indent indentOfMultipleDeclarationChild(@NotNull IElementType childType, @NotNull IElementType specType) {
        if (childType == specType) {
            return Indent.getNormalIndent();
        }
        return BonkTokenSets.COMMENTS.contains(childType) && myNode.findChildByType(specType) != null ? Indent.getNormalIndent() : Indent.getNoneIndent();
    }

    @NotNull
    @Override
    protected List<Block> buildChildren() {
        if (myNode.getElementType() instanceof ILeafElementType) {
            return EMPTY;
        }

        List<Block> blocks = new ArrayList<>();
        PsiElement child = myNode.getPsi().getFirstChild();
        while (child != null) {
            if (child.getNode().getElementType() != TokenType.WHITE_SPACE) {
                Indent indent = calcIndent(child.getNode());
                Block block = new BonkFormattingBlock(child, null, null, indent, spacingBuilder, settings);
                blocks.add(block);
            }
            child = child.getNextSibling();
        }
        return blocks;
    }

    @Nullable
    @Override
    public Indent getIndent() {
        return indent;
    }

    @NotNull
    @Override
    public ChildAttributes getChildAttributes(int newChildIndex) {
        Indent childIndent = Indent.getNoneIndent();
        IElementType parentType = myNode.getElementType();
        if (BLOCKS_TOKEN_SET.contains(parentType)) {
            childIndent = Indent.getNormalIndent();
        }
        return new ChildAttributes(childIndent, null);
    }


    @Nullable
    @Override
    public Spacing getSpacing(@Nullable Block child1, @NotNull Block child2) {
        if (child1 == null) {
            return null;
        }
        return spacingBuilder.getSpacing(this, child1, child2);
    }

    @Override
    public boolean isLeaf() {
        return myNode.getElementType() instanceof ILeafElementType;
    }

    private static SpacingBuilder createSpaceBuilder(CodeStyleSettings settings) {
        return new SpacingBuilder(settings, BonkLanguage.INSTANCE)
                // Add rules for spacing between elements, e.g.:
                .around(BonkTypes.OR_OPERATOR).spaces(1)
                .around(BonkTypes.AND_OPERATOR).spaces(1)
                .around(BonkTypes.ASSIGNMENT_OPERATOR).spaces(1)
                .around(BonkTypes.EQ_COMPARISON_OPERATOR).spaces(1)
                .around(BonkTypes.COMPARISON_OPERATOR).spaces(1)
                .around(BonkTypes.LESS).spaces(1)
                .around(BonkTypes.GREATER).spaces(1)
                .around(BonkTypes.LESS_EQ).spaces(1)
                .around(BonkTypes.GREATER_EQ).spaces(1)
                .around(BonkTypes.PLUS).spaces(1)
                .around(BonkTypes.MINUS).spaces(1)
                .around(BonkTypes.MUL).spaces(1)
                .around(BonkTypes.DIV).spaces(1)
                .around(BonkTypes.PLUS_ASSIGN).spaces(1)
                .around(BonkTypes.MINUS_ASSIGN).spaces(1)
                .after(BonkTypes.CALL_OPERATOR).spaceIf(false)
                ;
    }
}