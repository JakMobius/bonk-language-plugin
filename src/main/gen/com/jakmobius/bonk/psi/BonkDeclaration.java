// This is a generated file. Not intended for manual editing.
package com.jakmobius.bonk.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface BonkDeclaration extends PsiElement {

  @Nullable
  BonkBlokDeclaration getBlokDeclaration();

  @Nullable
  BonkHiveDeclaration getHiveDeclaration();

  @Nullable
  BonkVariableDeclaration getVariableDeclaration();

  String getName();

  PsiElement setName(String newName);

  BonkIdentifier getIdentifier();

}
