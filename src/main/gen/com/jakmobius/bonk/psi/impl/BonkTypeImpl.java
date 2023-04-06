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

public class BonkTypeImpl extends ASTWrapperPsiElement implements BonkType {

  public BonkTypeImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull BonkVisitor visitor) {
    visitor.visitType(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof BonkVisitor) accept((BonkVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public BonkIdentifier getIdentifier() {
    return findChildByClass(BonkIdentifier.class);
  }

  @Override
  @Nullable
  public BonkTrivialType getTrivialType() {
    return findChildByClass(BonkTrivialType.class);
  }

  @Override
  @Nullable
  public BonkType getType() {
    return findChildByClass(BonkType.class);
  }

}
