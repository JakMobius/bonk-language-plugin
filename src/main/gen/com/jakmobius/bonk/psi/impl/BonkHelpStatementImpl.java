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

public class BonkHelpStatementImpl extends BonkStatementImpl implements BonkHelpStatement {

  public BonkHelpStatementImpl(@NotNull ASTNode node) {
    super(node);
  }

  @Override
  public void accept(@NotNull BonkVisitor visitor) {
    visitor.visitHelpStatement(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof BonkVisitor) accept((BonkVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public BonkExpressionString getExpressionString() {
    return findNotNullChildByClass(BonkExpressionString.class);
  }

}
