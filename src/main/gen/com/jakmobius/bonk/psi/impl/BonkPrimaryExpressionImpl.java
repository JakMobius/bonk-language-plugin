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

public class BonkPrimaryExpressionImpl extends BonkExpressionImpl implements BonkPrimaryExpression {

  public BonkPrimaryExpressionImpl(@NotNull ASTNode node) {
    super(node);
  }

  @Override
  public void accept(@NotNull BonkVisitor visitor) {
    visitor.visitPrimaryExpression(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof BonkVisitor) accept((BonkVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public BonkArrayConstant getArrayConstant() {
    return findChildByClass(BonkArrayConstant.class);
  }

  @Override
  @Nullable
  public BonkCodeBlock getCodeBlock() {
    return findChildByClass(BonkCodeBlock.class);
  }

  @Override
  @Nullable
  public BonkExpression getExpression() {
    return findChildByClass(BonkExpression.class);
  }

  @Override
  @Nullable
  public BonkExpressionCall getExpressionCall() {
    return findChildByClass(BonkExpressionCall.class);
  }

  @Override
  @Nullable
  public BonkExpressionString getExpressionString() {
    return findChildByClass(BonkExpressionString.class);
  }

  @Override
  @Nullable
  public BonkExpressionUnary getExpressionUnary() {
    return findChildByClass(BonkExpressionUnary.class);
  }

  @Override
  @Nullable
  public BonkHiveAccess getHiveAccess() {
    return findChildByClass(BonkHiveAccess.class);
  }

  @Override
  @Nullable
  public BonkIdentifier getIdentifier() {
    return findChildByClass(BonkIdentifier.class);
  }

  @Override
  @Nullable
  public PsiElement getNumber() {
    return findChildByType(NUMBER);
  }

}
