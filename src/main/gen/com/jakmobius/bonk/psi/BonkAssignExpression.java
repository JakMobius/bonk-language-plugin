// This is a generated file. Not intended for manual editing.
package com.jakmobius.bonk.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface BonkAssignExpression extends BonkExpression {

  @NotNull
  List<BonkAssignmentOperator> getAssignmentOperatorList();

  @NotNull
  List<BonkExpression> getExpressionList();

}
