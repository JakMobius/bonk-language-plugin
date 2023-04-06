// This is a generated file. Not intended for manual editing.
package com.jakmobius.bonk.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface BonkBlokDeclaration extends PsiElement {

  @Nullable
  BonkBlokReturnType getBlokReturnType();

  @Nullable
  BonkCodeBlock getCodeBlock();

  @NotNull
  BonkIdentifier getIdentifier();

  @Nullable
  BonkParameterListDeclaration getParameterListDeclaration();

}
