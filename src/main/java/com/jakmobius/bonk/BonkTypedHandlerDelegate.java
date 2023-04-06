package com.jakmobius.bonk;

import com.intellij.codeInsight.editorActions.TypedHandlerDelegate;
import com.intellij.openapi.editor.CaretModel;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.util.PsiTreeUtil;
import com.jakmobius.bonk.psi.BonkIdentifier;
import org.jetbrains.annotations.NotNull;

public class BonkTypedHandlerDelegate extends TypedHandlerDelegate {

    @Override
    public @NotNull Result beforeCharTyped(char c, @NotNull Project project, @NotNull Editor editor, @NotNull PsiFile file, @NotNull FileType fileType) {
        if (fileType instanceof BonkFileType) {
            int offset = editor.getCaretModel().getOffset();
            Document document = editor.getDocument();
            CaretModel caretModel = editor.getCaretModel();

            if (c == '"') {
                document.insertString(offset, String.valueOf(c));
                caretModel.moveToOffset(offset);
                return Result.CONTINUE;
            } else if (c == '.') {
                PsiElement elementAtCaret = file.findElementAt(offset - 1);
                if (elementAtCaret != null) {
                    PsiElement identifier = PsiTreeUtil.getParentOfType(elementAtCaret, BonkIdentifier.class);
                    if (identifier != null) {
                        int identifierStartOffset = identifier.getTextRange().getStartOffset();
                        document.insertString(identifierStartOffset, " of ");
                        caretModel.moveToOffset(identifierStartOffset);
                        return Result.STOP;
                    }
                }
            }
        }
        return Result.CONTINUE;
    }
}
