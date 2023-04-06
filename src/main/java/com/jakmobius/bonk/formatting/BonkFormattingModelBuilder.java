package com.jakmobius.bonk.formatting;

import com.intellij.formatting.*;
import com.intellij.psi.PsiElement;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.jakmobius.bonk.BonkLanguage;
import com.jakmobius.bonk.psi.BonkTypes;
import org.jetbrains.annotations.NotNull;

public class BonkFormattingModelBuilder implements FormattingModelBuilder {
    @Override
    @NotNull
    public FormattingModel createModel(FormattingContext formattingContext) {
        PsiElement element = formattingContext.getPsiElement();
        CodeStyleSettings settings = formattingContext.getCodeStyleSettings();
        BonkFormattingBlock block = new BonkFormattingBlock(element, Wrap.createWrap(WrapType.NONE, false), Alignment.createAlignment(), null, null, settings);
        return FormattingModelProvider.createFormattingModelForPsiFile(element.getContainingFile(), block, settings);
    }
}
