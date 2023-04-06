// This is a generated file. Not intended for manual editing.
package com.jakmobius.bonk.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.jakmobius.bonk.psi.BonkTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.jakmobius.bonk.psi.*;

public class BonkPlusMinusImpl extends ASTWrapperPsiElement implements BonkPlusMinus {

  public BonkPlusMinusImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull BonkVisitor visitor) {
    visitor.visitPlusMinus(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof BonkVisitor) accept((BonkVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public BonkAssignmentOperator getAssignmentOperator() {
    return findChildByClass(BonkAssignmentOperator.class);
  }

  @Override
  @Nullable
  public BonkComparisonOperator getComparisonOperator() {
    return findChildByClass(BonkComparisonOperator.class);
  }

  @Override
  @Nullable
  public BonkEqComparisonOperator getEqComparisonOperator() {
    return findChildByClass(BonkEqComparisonOperator.class);
  }

  @Override
  @Nullable
  public BonkExpression getExpression() {
    return findChildByClass(BonkExpression.class);
  }

  @Override
  @Nullable
  public BonkMulDiv getMulDiv() {
    return findChildByClass(BonkMulDiv.class);
  }

  @Override
  @Nullable
  public BonkPlusMinus getPlusMinus() {
    return findChildByClass(BonkPlusMinus.class);
  }

  @Override
  @Nullable
  public BonkStatement getStatement() {
    return findChildByClass(BonkStatement.class);
  }

  @Override
  @Nullable
  public BonkUnaryOperator getUnaryOperator() {
    return findChildByClass(BonkUnaryOperator.class);
  }

}
