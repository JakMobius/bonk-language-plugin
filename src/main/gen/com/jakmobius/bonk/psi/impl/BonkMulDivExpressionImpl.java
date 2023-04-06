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

public class BonkMulDivExpressionImpl extends BonkExpressionImpl implements BonkMulDivExpression {

  public BonkMulDivExpressionImpl(@NotNull ASTNode node) {
    super(node);
  }

  @Override
  public void accept(@NotNull BonkVisitor visitor) {
    visitor.visitMulDivExpression(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof BonkVisitor) accept((BonkVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public BonkMulDiv getMulDiv() {
    return findChildByClass(BonkMulDiv.class);
  }

  @Override
  @NotNull
  public BonkPrimaryExpression getPrimaryExpression() {
    return findNotNullChildByClass(BonkPrimaryExpression.class);
  }

}
