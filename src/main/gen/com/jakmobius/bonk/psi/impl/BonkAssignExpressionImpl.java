// This is a generated file. Not intended for manual editing.
package com.jakmobius.bonk.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.jakmobius.bonk.psi.BonkTypes.*;
import com.jakmobius.bonk.psi.*;

public class BonkAssignExpressionImpl extends BonkExpressionImpl implements BonkAssignExpression {

  public BonkAssignExpressionImpl(@NotNull ASTNode node) {
    super(node);
  }

  @Override
  public void accept(@NotNull BonkVisitor visitor) {
    visitor.visitAssignExpression(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof BonkVisitor) accept((BonkVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<BonkAssignmentOperator> getAssignmentOperatorList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, BonkAssignmentOperator.class);
  }

  @Override
  @NotNull
  public List<BonkExpression> getExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, BonkExpression.class);
  }

}
