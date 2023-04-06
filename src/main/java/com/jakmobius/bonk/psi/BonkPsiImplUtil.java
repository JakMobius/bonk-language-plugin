package com.jakmobius.bonk.psi;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.jakmobius.bonk.BonkElementFactory;

public class BonkPsiImplUtil {
    public static String getValue(BonkExpressionString element) {
        ASTNode valueNode = element.getNode().findChildByType(BonkTypes.STRING);

        if(valueNode == null) {
            return null;
        }

        String rawText = valueNode.getText();
        StringBuilder sb = new StringBuilder();

        for(int i = 1; i < rawText.length() - 1; i++) {
            char c = rawText.charAt(i);
            if(c == '\\') {
                i++;
                if(i == rawText.length() - 1) {
                    sb.append('\\');
                    break;
                }
                c = rawText.charAt(i);
                switch(c) {
                    case 'n':
                        sb.append('\n');
                        break;
                    case 'r':
                        sb.append('\r');
                        break;
                    case 't':
                        sb.append('\t');
                        break;
                    case '"':
                        sb.append('"');
                        break;
                    case '\\':
                        sb.append('\\');
                        break;
                    case '\n':
                        break;
                    default:
                        sb.append('\\');
                        sb.append(c);
                }
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    public static String getName(BonkIdentifier element) {
            ASTNode keyNode = element.getNode().findChildByType(BonkTypes.ID);
        if (keyNode != null) {
            return keyNode.getText();
        } else {
            return null;
        }
    }

    public static PsiElement setName(BonkIdentifier element, String newName) {

        BonkIdentifier newIdentifier = BonkElementFactory.createIdentifier(element.getProject(), newName);
        if(newIdentifier == null) {
            return null;
        }

        element.replace(newIdentifier);

        return element;
    }

    public static BonkIdentifier getIdentifier(BonkDeclaration element) {
        BonkBlokDeclaration blokDeclaration = element.getBlokDeclaration();
        if(blokDeclaration != null) {
            return blokDeclaration.getIdentifier();
        }

        BonkHiveDeclaration hiveDeclaration = element.getHiveDeclaration();
        if(hiveDeclaration != null) {
            return hiveDeclaration.getIdentifier();
        }

        BonkVariableDeclaration variableDeclaration = element.getVariableDeclaration();
        if(variableDeclaration != null) {
            return variableDeclaration.getIdentifier();
        }
        return null;
    }

    public static String getName(BonkDeclaration element) {
        return getName(getIdentifier(element));
    }

    public static String getName(BonkBlokDeclaration element) {
        return getName(element.getIdentifier());
    }

    public static String getName(BonkHiveDeclaration element) {
        return getName(element.getIdentifier());
    }

    public static String getName(BonkVariableDeclaration element) {
        return getName(element.getIdentifier());
    }

    public static PsiElement setName(BonkDeclaration element, String newName) {
        BonkIdentifier id = getIdentifier(element);
        if(id == null) {
            return null;
        }
        return setName(id, newName);
    }

    public static PsiElement setName(BonkBlokDeclaration element, String newName) {
        return setName(element.getIdentifier(), newName);
    }

    public static PsiElement setName(BonkHiveDeclaration element, String newName) {
        return setName(element.getIdentifier(), newName);
    }

    public static PsiElement setName(BonkVariableDeclaration element, String newName) {
        return setName(element.getIdentifier(), newName);
    }
}
