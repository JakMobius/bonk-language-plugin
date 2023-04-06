package com.jakmobius.bonk;

import com.intellij.openapi.project.Project;
import com.intellij.psi.*;
import com.jakmobius.bonk.psi.*;

import java.util.List;

public class BonkElementFactory {
    public static BonkIdentifier createIdentifier(Project project, String newName) {
        final BonkFile file = createFile(project, "bowl " + newName + ";");

        if(file.getChildren().length == 0 || !(file.getFirstChild() instanceof BonkProgram)) {
            return null;
        }

        BonkProgram program = (BonkProgram) file.getFirstChild();
        List<BonkDeclaration> declarationList = program.getDeclarationList();
        if(declarationList.size() == 0) {
            return null;
        }

        BonkDeclaration declaration = declarationList.get(0);
        BonkVariableDeclaration variableDeclaration = declaration.getVariableDeclaration();

        if(variableDeclaration == null) {
            return null;
        }

        return variableDeclaration.getIdentifier();
    }

    private static BonkFile createFile(Project project, String text) {
        return (BonkFile) PsiFileFactory.getInstance(project).
                createFileFromText("dummy.bonk", BonkFileType.INSTANCE, text);
    }
}