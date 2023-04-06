// This is a generated file. Not intended for manual editing.
package com.jakmobius.bonk.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface BonkPlusMinus extends PsiElement {

  @Nullable
  BonkAssignmentOperator getAssignmentOperator();

  @Nullable
  BonkComparisonOperator getComparisonOperator();

  @Nullable
  BonkEqComparisonOperator getEqComparisonOperator();

  @Nullable
  BonkExpression getExpression();

  @Nullable
  BonkMulDiv getMulDiv();

  @Nullable
  BonkPlusMinus getPlusMinus();

  @Nullable
  BonkStatement getStatement();

  @Nullable
  BonkUnaryOperator getUnaryOperator();

}
