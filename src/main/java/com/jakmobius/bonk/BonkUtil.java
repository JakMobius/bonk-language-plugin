package com.jakmobius.bonk;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.search.FileTypeIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.util.PlatformIcons;
import com.jakmobius.bonk.psi.*;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.util.*;

public class BonkUtil {
    /**
     * Searches the entire project for Bonk language files with instances of the Bonk property with the given key.
     *
     * @param project current project
     * @param key     to check
     * @return matching properties
     */
    public static List<BonkIdentifier> getIdentifiers(Project project, String key) {
        List<BonkIdentifier> result = new ArrayList<>();
        Collection<VirtualFile> virtualFiles =
                FileTypeIndex.getFiles(BonkFileType.INSTANCE, GlobalSearchScope.allScope(project));
        for (VirtualFile virtualFile : virtualFiles) {
            BonkFile simpleFile = (BonkFile) PsiManager.getInstance(project).findFile(virtualFile);
            if (simpleFile != null) {
                BonkIdentifier[] properties = PsiTreeUtil.getChildrenOfType(simpleFile, BonkIdentifier.class);
                if (properties != null) {
                    for (BonkIdentifier property : properties) {
                        if (key.equals(property.getName())) {
                            result.add(property);
                        }
                    }
                }
            }
        }
        return result;
    }

    public static BonkIdentifier findDefinitionFor(BonkIdentifier identifier) {
        PsiElement scope = identifier.getParent();
        while(scope != null) {
            List<BonkIdentifier> definitions = getScopeDefinitions(scope);
            for(BonkIdentifier definition : definitions) {
                if(Objects.equals(definition.getName(), identifier.getName())) {
                    return definition;
                }
            }
            scope = scope.getParent();
        }
        return null;
    }

    // Returns all external declarations of a file
    public static @NotNull List<BonkIdentifier> findDeclarations(BonkFile file) {
        BonkProgram[] programs = PsiTreeUtil.getChildrenOfType(file, BonkProgram.class);

        if(programs != null) {
            List<BonkIdentifier> result = new ArrayList<>();
            for (BonkProgram program : programs) {
                result.addAll(getScopeDefinitions(program));
            }
            return result;
        } else {
            return new ArrayList<>();
        }
    }

    public static @NotNull List<BonkIdentifier> getScopeDefinitions(BonkCodeBlock scope) {
        List<BonkIdentifier> result = new ArrayList<>();

        for(BonkStatement statement : scope.getStatementList()) {
            if(statement.getVariableDeclaration() != null) {
                result.add(statement.getVariableDeclaration().getIdentifier());
            }
        }

        return result;
    }

    public static @NotNull List<BonkIdentifier> getScopeDefinitions(BonkLoopStatement scope) {
        if(scope.getParameterListDeclaration() != null) {
            return getScopeDefinitions(scope.getParameterListDeclaration());
        } else {
            return new ArrayList<>();
        }
    }

    public static @NotNull List<BonkIdentifier> getScopeDefinitions(BonkParameterListDeclaration scope) {
        List<BonkIdentifier> result = new ArrayList<>();

        BonkVariableDeclaration[] varDefinitions = PsiTreeUtil.getChildrenOfType(scope, BonkVariableDeclaration.class);

        if (varDefinitions != null) {
            for(BonkVariableDeclaration varDefinition : varDefinitions) {
                result.add(varDefinition.getIdentifier());
            }
        }

        return result;
    }

    public static @NotNull List<BonkIdentifier> getScopeDefinitions(BonkBlokDeclaration scope) {
        List<BonkIdentifier> result = new ArrayList<>();

        if(scope.getParameterListDeclaration() != null) {
            result.addAll(getScopeDefinitions(scope.getParameterListDeclaration()));
        }

        return result;
    }

    public static @NotNull List<BonkIdentifier> getLocalDefinitions(BonkProgram scope) {
        List<BonkIdentifier> result = new ArrayList<>();

        List<BonkDeclaration> declarationList = scope.getDeclarationList();

        for (BonkDeclaration property : declarationList) {
            result.add(property.getIdentifier());
        }

        return result;
    }

    public static @NotNull List<BonkIdentifier> getScopeDefinitions(BonkProgram scope) {

        List<BonkIdentifier> result = getLocalDefinitions(scope);

        // Also, iterate on the help statements to populate the definitions with
        // external ones

        List<BonkHelpStatement> helpStatementList = scope.getHelpStatementList();

        for (BonkHelpStatement helpStatement : helpStatementList) {
            BonkProgram includedProgram = resolveImport(scope.getContainingFile().getOriginalFile(), helpStatement.getExpressionString().getValue());

            if(includedProgram != null) {
                result.addAll(getLocalDefinitions(includedProgram));
            }
        }

        return result;
    }

    public static BonkProgram resolveImport(PsiFile file, String importName) {
        if(file == null) {
            return null;
        }

        // Get the psi file
        PsiFile psiFile = PsiFileUtils.getNeighborPsiFile(file, importName);

        // Get BonkProgram children of the psi file
        BonkProgram[] programs = PsiTreeUtil.getChildrenOfType(psiFile, BonkProgram.class);

        if(programs != null && programs.length > 0) {
            return programs[0];
        }

        return null;
    }

    public static @NotNull List<BonkIdentifier> getScopeDefinitions(PsiElement scope) {
        if(scope instanceof BonkProgram) {
            return getScopeDefinitions((BonkProgram) scope);
        } else if(scope instanceof BonkBlokDeclaration) {
            return getScopeDefinitions((BonkBlokDeclaration) scope);
        } else if(scope instanceof BonkParameterListDeclaration) {
            return getScopeDefinitions((BonkParameterListDeclaration) scope);
        } else if(scope instanceof BonkLoopStatement) {
            return getScopeDefinitions((BonkLoopStatement) scope);
        } else if(scope instanceof BonkCodeBlock) {
            return getScopeDefinitions((BonkCodeBlock) scope);
        } else {
            return new ArrayList<>();
        }
    }

    public static @NotNull List<BonkIdentifier> getVisibleIdentifiers(PsiElement scope) {
        List<BonkIdentifier> result = new ArrayList<>();

        PsiElement currentScope = scope;

        while(currentScope != null) {
            result.addAll(getScopeDefinitions(currentScope));
            currentScope = currentScope.getParent();
        }

        return result;
    }

    public static PsiElement getDeclarationScope(PsiElement variable) {
        PsiElement parent = variable.getParent();

        if(parent instanceof BonkDeclaration) {
            return parent.getParent(); // Program
        }
        if(parent instanceof BonkCodeBlock || parent instanceof BonkProgram) {
            return parent;
        }
        if(parent instanceof BonkParameterListDeclaration) {
            return parent.getParent(); // Hive parameter / loop body
        }
        return null;
    }

    public static PsiElement getScope(BonkIdentifier identifier) {
        PsiElement parent = identifier.getParent();
        if(parent instanceof BonkVariableDeclaration) {
            return getDeclarationScope(parent);
        } else if(parent instanceof BonkHiveDeclaration) {
            return getDeclarationScope(parent.getParent());
        } else if(parent instanceof BonkBlokDeclaration) {
            return getDeclarationScope(parent.getParent());
        }
        return null;
    }

    public static List<BonkIdentifier> getUsages(BonkIdentifier identifier, PsiElement scope) {
        if(scope instanceof BonkIdentifier) {
            // Check if identifier has the same name
            if(!identifier.getText().equals(((BonkIdentifier) scope).getText())) {
                return null;
            }

            // Make sure that the definition of the identifier is the same
            if(scope != findDefinitionFor(identifier)) {
                return null;
            }

            return Collections.singletonList((BonkIdentifier) scope);
        }

        List<BonkIdentifier> result = new ArrayList<>();

        // Iterate on all children
        for (PsiElement child : scope.getChildren()) {
            List<BonkIdentifier> usages = getUsages(identifier, child);
            if(usages != null) {
                result.addAll(usages);
            }
        }

        return result;
    }

    public static @NotNull List<BonkIdentifier> getUsages(BonkIdentifier identifier) {
        // Check if the definition is global or not

        PsiElement scope = getScope(identifier);
        if(scope == null) {
            return new ArrayList<>();
        }

        boolean isGlobal = identifier instanceof BonkProgram;

        List<BonkIdentifier> result = new ArrayList<>();

        if(isGlobal) {
            // Iterate on all files in the project

            Project project = identifier.getProject();
            Collection<VirtualFile> virtualFiles = FileTypeIndex.getFiles(BonkFileType.INSTANCE, GlobalSearchScope.allScope(project));

            for (VirtualFile virtualFile : virtualFiles) {
                PsiFile psiFile = PsiManager.getInstance(project).findFile(virtualFile);

                if(psiFile instanceof BonkFile) {
                    BonkFile bonkFile = (BonkFile) psiFile;

                    List<BonkIdentifier> declarations = getUsages(identifier, bonkFile);

                    for (BonkIdentifier declaration : declarations) {
                        if(declaration.getText().equals(identifier.getText())) {
                            result.add(declaration);
                        }
                    }
                }
            }
        } else {
            // Iterate on the file

            PsiFile file = identifier.getContainingFile();

            if(file instanceof BonkFile) {
                BonkFile bonkFile = (BonkFile) file;

                List<BonkIdentifier> declarations = getUsages(identifier, bonkFile);

                for (BonkIdentifier declaration : declarations) {
                    if(declaration.getText().equals(identifier.getText())) {
                        result.add(declaration);
                    }
                }
            }
        }

        return result;
    }

    public static Icon properIconForDefId(BonkIdentifier identifier) {
        PsiElement parent = identifier.getParent();

        if(parent instanceof BonkVariableDeclaration) {
            return PlatformIcons.VARIABLE_ICON;
        } else if(parent instanceof BonkHiveDeclaration) {
            return PlatformIcons.CLASS_ICON;
        } else if(parent instanceof BonkBlokDeclaration) {
            return PlatformIcons.FUNCTION_ICON;
        }

        return null;
    }
}
