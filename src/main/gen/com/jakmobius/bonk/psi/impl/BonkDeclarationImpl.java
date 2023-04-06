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

public class BonkDeclarationImpl extends ASTWrapperPsiElement implements BonkDeclaration {

  public BonkDeclarationImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull BonkVisitor visitor) {
    visitor.visitDeclaration(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof BonkVisitor) accept((BonkVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public BonkBlokDeclaration getBlokDeclaration() {
    return findChildByClass(BonkBlokDeclaration.class);
  }

  @Override
  @Nullable
  public BonkHiveDeclaration getHiveDeclaration() {
    return findChildByClass(BonkHiveDeclaration.class);
  }

  @Override
  @Nullable
  public BonkVariableDeclaration getVariableDeclaration() {
    return findChildByClass(BonkVariableDeclaration.class);
  }

  @Override
  public String getName() {
    return BonkPsiImplUtil.getName(this);
  }

  @Override
  public PsiElement setName(String newName) {
    return BonkPsiImplUtil.setName(this, newName);
  }

  @Override
  public BonkIdentifier getIdentifier() {
    return BonkPsiImplUtil.getIdentifier(this);
  }

}
