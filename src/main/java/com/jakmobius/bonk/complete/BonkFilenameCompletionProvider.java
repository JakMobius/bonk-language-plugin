package com.jakmobius.bonk.complete;

import com.intellij.codeInsight.completion.CompletionParameters;
import com.intellij.codeInsight.completion.CompletionProvider;
import com.intellij.codeInsight.completion.CompletionResultSet;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.psi.PsiDirectory;
import com.intellij.psi.PsiFile;
import com.intellij.util.ProcessingContext;
import com.jakmobius.bonk.BonkIcons;
import org.jetbrains.annotations.NotNull;

public class BonkFilenameCompletionProvider extends CompletionProvider<CompletionParameters> {
    @Override
    protected void addCompletions(@NotNull CompletionParameters parameters,
                                  @NotNull ProcessingContext context,
                                  @NotNull CompletionResultSet resultSet) {
        PsiFile currentFile = parameters.getOriginalFile();
        PsiDirectory currentDirectory = currentFile.getParent();

        if (currentDirectory != null) {
            for (PsiFile file : currentDirectory.getFiles()) {
                String fileName = file.getName();
                if(fileName.endsWith(".bs")) {
                    resultSet.addElement(LookupElementBuilder.create(fileName).withIcon(BonkIcons.FILE));
                }
            }
        }
    }
}
