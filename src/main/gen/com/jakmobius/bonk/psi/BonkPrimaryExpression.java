// This is a generated file. Not intended for manual editing.
package com.jakmobius.bonk.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface BonkPrimaryExpression extends BonkExpression {

  @Nullable
  BonkArrayConstant getArrayConstant();

  @Nullable
  BonkCodeBlock getCodeBlock();

  @Nullable
  BonkExpression getExpression();

  @Nullable
  BonkExpressionCall getExpressionCall();

  @Nullable
  BonkExpressionString getExpressionString();

  @Nullable
  BonkExpressionUnary getExpressionUnary();

  @Nullable
  BonkHiveAccess getHiveAccess();

  @Nullable
  BonkIdentifier getIdentifier();

  @Nullable
  PsiElement getNumber();

}
