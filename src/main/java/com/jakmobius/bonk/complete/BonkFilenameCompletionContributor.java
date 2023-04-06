package com.jakmobius.bonk.complete;

import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.PsiElement;
import com.intellij.util.ProcessingContext;
import com.jakmobius.bonk.BonkLanguage;
import com.jakmobius.bonk.BonkReference;
import com.jakmobius.bonk.psi.BonkExpressionString;
import com.jakmobius.bonk.psi.BonkHelpStatement;
import com.jakmobius.bonk.psi.BonkTypes;
import org.jetbrains.annotations.NotNull;

public class BonkFilenameCompletionContributor extends CompletionContributor {
    public BonkFilenameCompletionContributor() {
        extend(CompletionType.BASIC,
                PlatformPatterns.psiElement(BonkTypes.STRING)
                        .withSuperParent(2, BonkHelpStatement.class),
//                        .withLanguage(BonkLanguage.INSTANCE),
                new BonkFilenameCompletionProvider());

//        extend(CompletionType.BASIC,
//                PlatformPatterns.psiElement(PsiElement.class),
//                new CompletionProvider<CompletionParameters>() {
//                    @Override
//                    protected void addCompletions(@NotNull CompletionParameters parameters,
//                                                  @NotNull ProcessingContext context,
//                                                  @NotNull CompletionResultSet resultSet) {
//                        PsiElement position = parameters.getPosition();
//                        PsiElement parent = position.getParent();
//                        if (parent instanceof BonkReference) {
//                            BonkReference bonkPsiReference = (BonkReference) parent;
//                            Object[] variants = bonkPsiReference.getVariants();
//                            for (Object variant : variants) {
//                                if (variant instanceof LookupElement) {
//                                    resultSet.addElement((LookupElement) variant);
//                                }
//                            }
//                        }
//                    }
//                }
//        );
    }
}


