// This is a generated file. Not intended for manual editing.
package com.jakmobius.bonk;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static com.jakmobius.bonk.psi.BonkTypes.*;
import static com.jakmobius.bonk.grammar.BonkParserUtil.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class BonkParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, EXTENDS_SETS_);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return root(b, l + 1);
  }

  public static final TokenSet[] EXTENDS_SETS_ = new TokenSet[] {
    create_token_set_(BONK_STATEMENT, BREK_STATEMENT, HELP_STATEMENT, LOOP_STATEMENT,
      SEMICOLON_STATEMENT, STATEMENT, WRAPPER_STATEMENT),
    create_token_set_(AND_EXPRESSION, ASSIGN_EXPRESSION, COMPARE_EXPRESSION, EQUALS_EXPRESSION,
      EXPRESSION, MUL_DIV_EXPRESSION, OR_EXPRESSION, PLUS_MINUS_EXPRESSION,
      PRIMARY_EXPRESSION),
  };

  /* ********************************************************** */
  // EqualsExpression ("and" EqualsExpression) *
  public static boolean AndExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AndExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, AND_EXPRESSION, "<and expression>");
    r = EqualsExpression(b, l + 1);
    r = r && AndExpression_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ("and" EqualsExpression) *
  private static boolean AndExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AndExpression_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!AndExpression_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "AndExpression_1", c)) break;
    }
    return true;
  }

  // "and" EqualsExpression
  private static boolean AndExpression_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AndExpression_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, AND_OPERATOR);
    r = r && EqualsExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // "[" (Expression)* "]"
  public static boolean ArrayConstant(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArrayConstant")) return false;
    if (!nextTokenIs(b, LEFT_BRACKET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LEFT_BRACKET);
    r = r && ArrayConstant_1(b, l + 1);
    r = r && consumeToken(b, RIGHT_BRACKET);
    exit_section_(b, m, ARRAY_CONSTANT, r);
    return r;
  }

  // (Expression)*
  private static boolean ArrayConstant_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArrayConstant_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!ArrayConstant_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ArrayConstant_1", c)) break;
    }
    return true;
  }

  // (Expression)
  private static boolean ArrayConstant_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArrayConstant_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // OrExpression (AssignmentOperator OrExpression) *
  public static boolean AssignExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AssignExpression")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _COLLAPSE_, ASSIGN_EXPRESSION, "<assign expression>");
    r = OrExpression(b, l + 1);
    p = r; // pin = 1
    r = r && AssignExpression_1(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (AssignmentOperator OrExpression) *
  private static boolean AssignExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AssignExpression_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!AssignExpression_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "AssignExpression_1", c)) break;
    }
    return true;
  }

  // AssignmentOperator OrExpression
  private static boolean AssignExpression_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AssignExpression_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = AssignmentOperator(b, l + 1);
    r = r && OrExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // "=" | "+=" | "-=" | "*=" | "/="
  public static boolean AssignmentOperator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AssignmentOperator")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ASSIGNMENT_OPERATOR, "<assignment operator>");
    r = consumeToken(b, ASSIGN);
    if (!r) r = consumeToken(b, PLUS_ASSIGN);
    if (!r) r = consumeToken(b, MINUS_ASSIGN);
    if (!r) r = consumeToken(b, MUL_ASSIGN);
    if (!r) r = consumeToken(b, DIV_ASSIGN);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "blok" Identifier ParameterListDeclaration? BlokReturnType? (CodeBlock | ";")
  public static boolean BlokDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BlokDeclaration")) return false;
    if (!nextTokenIs(b, BLOK_OPERATOR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BLOK_OPERATOR);
    r = r && Identifier(b, l + 1);
    r = r && BlokDeclaration_2(b, l + 1);
    r = r && BlokDeclaration_3(b, l + 1);
    r = r && BlokDeclaration_4(b, l + 1);
    exit_section_(b, m, BLOK_DECLARATION, r);
    return r;
  }

  // ParameterListDeclaration?
  private static boolean BlokDeclaration_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BlokDeclaration_2")) return false;
    ParameterListDeclaration(b, l + 1);
    return true;
  }

  // BlokReturnType?
  private static boolean BlokDeclaration_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BlokDeclaration_3")) return false;
    BlokReturnType(b, l + 1);
    return true;
  }

  // CodeBlock | ";"
  private static boolean BlokDeclaration_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BlokDeclaration_4")) return false;
    boolean r;
    r = CodeBlock(b, l + 1);
    if (!r) r = consumeToken(b, SEMICOLON);
    return r;
  }

  /* ********************************************************** */
  // ":" Type
  public static boolean BlokReturnType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BlokReturnType")) return false;
    if (!nextTokenIs(b, COLON)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && Type(b, l + 1);
    exit_section_(b, m, BLOK_RETURN_TYPE, r);
    return r;
  }

  /* ********************************************************** */
  // "bonk" Expression?
  public static boolean BonkStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BonkStatement")) return false;
    if (!nextTokenIs(b, BONK_OPERATOR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BONK_OPERATOR);
    r = r && BonkStatement_1(b, l + 1);
    exit_section_(b, m, BONK_STATEMENT, r);
    return r;
  }

  // Expression?
  private static boolean BonkStatement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BonkStatement_1")) return false;
    Expression(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // "brek"
  public static boolean BrekStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BrekStatement")) return false;
    if (!nextTokenIs(b, BREK_OPERATOR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BREK_OPERATOR);
    exit_section_(b, m, BREK_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // "{" (LoopStatement | WrapperStatement)* "}"
  public static boolean CodeBlock(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CodeBlock")) return false;
    if (!nextTokenIs(b, LEFT_CURLY)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LEFT_CURLY);
    r = r && CodeBlock_1(b, l + 1);
    r = r && consumeToken(b, RIGHT_CURLY);
    exit_section_(b, m, CODE_BLOCK, r);
    return r;
  }

  // (LoopStatement | WrapperStatement)*
  private static boolean CodeBlock_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CodeBlock_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!CodeBlock_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "CodeBlock_1", c)) break;
    }
    return true;
  }

  // LoopStatement | WrapperStatement
  private static boolean CodeBlock_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CodeBlock_1_0")) return false;
    boolean r;
    r = LoopStatement(b, l + 1);
    if (!r) r = WrapperStatement(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // PlusMinusExpression (ComparisonOperator PlusMinusExpression) *
  public static boolean CompareExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CompareExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, COMPARE_EXPRESSION, "<compare expression>");
    r = PlusMinusExpression(b, l + 1);
    r = r && CompareExpression_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (ComparisonOperator PlusMinusExpression) *
  private static boolean CompareExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CompareExpression_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!CompareExpression_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "CompareExpression_1", c)) break;
    }
    return true;
  }

  // ComparisonOperator PlusMinusExpression
  private static boolean CompareExpression_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CompareExpression_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ComparisonOperator(b, l + 1);
    r = r && PlusMinusExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // "<" | ">" | "<=" | ">="
  public static boolean ComparisonOperator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ComparisonOperator")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _LEFT_, COMPARISON_OPERATOR, "<comparison operator>");
    r = consumeToken(b, LESS);
    if (!r) r = consumeToken(b, GREATER);
    if (!r) r = consumeToken(b, LESS_EQ);
    if (!r) r = consumeToken(b, GREATER_EQ);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // BlokDeclaration | VariableDeclaration ";" | HiveDeclaration
  public static boolean Declaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Declaration")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DECLARATION, "<declaration>");
    r = BlokDeclaration(b, l + 1);
    if (!r) r = Declaration_1(b, l + 1);
    if (!r) r = HiveDeclaration(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // VariableDeclaration ";"
  private static boolean Declaration_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Declaration_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = VariableDeclaration(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // "==" | "!="
  public static boolean EqComparisonOperator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "EqComparisonOperator")) return false;
    if (!nextTokenIs(b, "<eq comparison operator>", EQUALS, NOT_EQUALS)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _LEFT_, EQ_COMPARISON_OPERATOR, "<eq comparison operator>");
    r = consumeToken(b, EQUALS);
    if (!r) r = consumeToken(b, NOT_EQUALS);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // CompareExpression (EqComparisonOperator CompareExpression) *
  public static boolean EqualsExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "EqualsExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, EQUALS_EXPRESSION, "<equals expression>");
    r = CompareExpression(b, l + 1);
    r = r && EqualsExpression_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (EqComparisonOperator CompareExpression) *
  private static boolean EqualsExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "EqualsExpression_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!EqualsExpression_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "EqualsExpression_1", c)) break;
    }
    return true;
  }

  // EqComparisonOperator CompareExpression
  private static boolean EqualsExpression_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "EqualsExpression_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = EqComparisonOperator(b, l + 1);
    r = r && CompareExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // AssignExpression
  public static boolean Expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Expression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, EXPRESSION, "<expression>");
    r = AssignExpression(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "@" Expression ParameterList?
  public static boolean ExpressionCall(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpressionCall")) return false;
    if (!nextTokenIs(b, CALL_OPERATOR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CALL_OPERATOR);
    r = r && Expression(b, l + 1);
    r = r && ExpressionCall_2(b, l + 1);
    exit_section_(b, m, EXPRESSION_CALL, r);
    return r;
  }

  // ParameterList?
  private static boolean ExpressionCall_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpressionCall_2")) return false;
    ParameterList(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // string
  public static boolean ExpressionString(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpressionString")) return false;
    if (!nextTokenIs(b, STRING)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, STRING);
    exit_section_(b, m, EXPRESSION_STRING, r);
    return r;
  }

  /* ********************************************************** */
  // UnaryOperator Expression
  public static boolean ExpressionUnary(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpressionUnary")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EXPRESSION_UNARY, "<expression unary>");
    r = UnaryOperator(b, l + 1);
    r = r && Expression(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "help" ExpressionString
  public static boolean HelpStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "HelpStatement")) return false;
    if (!nextTokenIs(b, HELP_OPERATOR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, HELP_OPERATOR);
    r = r && ExpressionString(b, l + 1);
    exit_section_(b, m, HELP_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // Identifier "of" PrimaryExpression
  public static boolean HiveAccess(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "HiveAccess")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Identifier(b, l + 1);
    r = r && consumeToken(b, OF_OPERATOR);
    r = r && PrimaryExpression(b, l + 1);
    exit_section_(b, m, HIVE_ACCESS, r);
    return r;
  }

  /* ********************************************************** */
  // "{" (BlokDeclaration | VariableDeclaration ";")* "}"
  public static boolean HiveBody(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "HiveBody")) return false;
    if (!nextTokenIs(b, LEFT_CURLY)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LEFT_CURLY);
    r = r && HiveBody_1(b, l + 1);
    r = r && consumeToken(b, RIGHT_CURLY);
    exit_section_(b, m, HIVE_BODY, r);
    return r;
  }

  // (BlokDeclaration | VariableDeclaration ";")*
  private static boolean HiveBody_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "HiveBody_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!HiveBody_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "HiveBody_1", c)) break;
    }
    return true;
  }

  // BlokDeclaration | VariableDeclaration ";"
  private static boolean HiveBody_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "HiveBody_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = BlokDeclaration(b, l + 1);
    if (!r) r = HiveBody_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // VariableDeclaration ";"
  private static boolean HiveBody_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "HiveBody_1_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = VariableDeclaration(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // "hive" Identifier HiveBody
  public static boolean HiveDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "HiveDeclaration")) return false;
    if (!nextTokenIs(b, HIVE_OPERATOR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, HIVE_OPERATOR);
    r = r && Identifier(b, l + 1);
    r = r && HiveBody(b, l + 1);
    exit_section_(b, m, HIVE_DECLARATION, r);
    return r;
  }

  /* ********************************************************** */
  // id
  public static boolean Identifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Identifier")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ID);
    exit_section_(b, m, IDENTIFIER, r);
    return r;
  }

  /* ********************************************************** */
  // "loop" ParameterListDeclaration? CodeBlock
  public static boolean LoopStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LoopStatement")) return false;
    if (!nextTokenIs(b, LOOP_OPERATOR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LOOP_OPERATOR);
    r = r && LoopStatement_1(b, l + 1);
    r = r && CodeBlock(b, l + 1);
    exit_section_(b, m, LOOP_STATEMENT, r);
    return r;
  }

  // ParameterListDeclaration?
  private static boolean LoopStatement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LoopStatement_1")) return false;
    ParameterListDeclaration(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // "*" | "/"
  public static boolean MulDiv(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MulDiv")) return false;
    if (!nextTokenIs(b, "<mul div>", DIV, MUL)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _LEFT_, MUL_DIV, "<mul div>");
    r = consumeToken(b, MUL);
    if (!r) r = consumeToken(b, DIV);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // PrimaryExpression (MulDiv PrimaryExpression) *
  public static boolean MulDivExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MulDivExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, MUL_DIV_EXPRESSION, "<mul div expression>");
    r = PrimaryExpression(b, l + 1);
    r = r && MulDivExpression_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (MulDiv PrimaryExpression) *
  private static boolean MulDivExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MulDivExpression_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!MulDivExpression_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "MulDivExpression_1", c)) break;
    }
    return true;
  }

  // MulDiv PrimaryExpression
  private static boolean MulDivExpression_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MulDivExpression_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = MulDiv(b, l + 1);
    r = r && PrimaryExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // AndExpression ("or" AndExpression) *
  public static boolean OrExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "OrExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, OR_EXPRESSION, "<or expression>");
    r = AndExpression(b, l + 1);
    r = r && OrExpression_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ("or" AndExpression) *
  private static boolean OrExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "OrExpression_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!OrExpression_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "OrExpression_1", c)) break;
    }
    return true;
  }

  // "or" AndExpression
  private static boolean OrExpression_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "OrExpression_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OR_OPERATOR);
    r = r && AndExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // "[" (ParameterListItem ("," ParameterListItem)*)? "]"
  public static boolean ParameterList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParameterList")) return false;
    if (!nextTokenIs(b, LEFT_BRACKET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LEFT_BRACKET);
    r = r && ParameterList_1(b, l + 1);
    r = r && consumeToken(b, RIGHT_BRACKET);
    exit_section_(b, m, PARAMETER_LIST, r);
    return r;
  }

  // (ParameterListItem ("," ParameterListItem)*)?
  private static boolean ParameterList_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParameterList_1")) return false;
    ParameterList_1_0(b, l + 1);
    return true;
  }

  // ParameterListItem ("," ParameterListItem)*
  private static boolean ParameterList_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParameterList_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ParameterListItem(b, l + 1);
    r = r && ParameterList_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ("," ParameterListItem)*
  private static boolean ParameterList_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParameterList_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!ParameterList_1_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ParameterList_1_0_1", c)) break;
    }
    return true;
  }

  // "," ParameterListItem
  private static boolean ParameterList_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParameterList_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && ParameterListItem(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // "[" (VariableDeclaration ("," VariableDeclaration)*)? "]"
  public static boolean ParameterListDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParameterListDeclaration")) return false;
    if (!nextTokenIs(b, LEFT_BRACKET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LEFT_BRACKET);
    r = r && ParameterListDeclaration_1(b, l + 1);
    r = r && consumeToken(b, RIGHT_BRACKET);
    exit_section_(b, m, PARAMETER_LIST_DECLARATION, r);
    return r;
  }

  // (VariableDeclaration ("," VariableDeclaration)*)?
  private static boolean ParameterListDeclaration_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParameterListDeclaration_1")) return false;
    ParameterListDeclaration_1_0(b, l + 1);
    return true;
  }

  // VariableDeclaration ("," VariableDeclaration)*
  private static boolean ParameterListDeclaration_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParameterListDeclaration_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = VariableDeclaration(b, l + 1);
    r = r && ParameterListDeclaration_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ("," VariableDeclaration)*
  private static boolean ParameterListDeclaration_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParameterListDeclaration_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!ParameterListDeclaration_1_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ParameterListDeclaration_1_0_1", c)) break;
    }
    return true;
  }

  // "," VariableDeclaration
  private static boolean ParameterListDeclaration_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParameterListDeclaration_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && VariableDeclaration(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // Identifier "=" Expression
  public static boolean ParameterListItem(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParameterListItem")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, PARAMETER_LIST_ITEM, "<parameter list item>");
    r = Identifier(b, l + 1);
    p = r; // pin = 1
    r = r && report_error_(b, consumeToken(b, ASSIGN));
    r = p && Expression(b, l + 1) && r;
    exit_section_(b, l, m, r, p, BonkParser::parameterListItemRecovery);
    return r || p;
  }

  /* ********************************************************** */
  // "+" | "-"
  public static boolean PlusMinus(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PlusMinus")) return false;
    if (!nextTokenIs(b, "<plus minus>", MINUS, PLUS)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _LEFT_, PLUS_MINUS, "<plus minus>");
    r = consumeToken(b, PLUS);
    if (!r) r = consumeToken(b, MINUS);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // MulDivExpression (PlusMinus MulDivExpression) *
  public static boolean PlusMinusExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PlusMinusExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, PLUS_MINUS_EXPRESSION, "<plus minus expression>");
    r = MulDivExpression(b, l + 1);
    r = r && PlusMinusExpression_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (PlusMinus MulDivExpression) *
  private static boolean PlusMinusExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PlusMinusExpression_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!PlusMinusExpression_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "PlusMinusExpression_1", c)) break;
    }
    return true;
  }

  // PlusMinus MulDivExpression
  private static boolean PlusMinusExpression_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PlusMinusExpression_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = PlusMinus(b, l + 1);
    r = r && MulDivExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // HiveAccess | Identifier | number | ExpressionString | ArrayConstant | "(" Expression ")" | CodeBlock | "null" | ExpressionCall | ExpressionUnary
  public static boolean PrimaryExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PrimaryExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PRIMARY_EXPRESSION, "<primary expression>");
    r = HiveAccess(b, l + 1);
    if (!r) r = Identifier(b, l + 1);
    if (!r) r = consumeToken(b, NUMBER);
    if (!r) r = ExpressionString(b, l + 1);
    if (!r) r = ArrayConstant(b, l + 1);
    if (!r) r = PrimaryExpression_5(b, l + 1);
    if (!r) r = CodeBlock(b, l + 1);
    if (!r) r = consumeToken(b, NULL_KEYWORD);
    if (!r) r = ExpressionCall(b, l + 1);
    if (!r) r = ExpressionUnary(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // "(" Expression ")"
  private static boolean PrimaryExpression_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PrimaryExpression_5")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LEFT_PAREN);
    r = r && Expression(b, l + 1);
    r = r && consumeToken(b, RIGHT_PAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // HelpStatement* Declaration*
  public static boolean Program(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Program")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PROGRAM, "<program>");
    r = Program_0(b, l + 1);
    r = r && Program_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // HelpStatement*
  private static boolean Program_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Program_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!HelpStatement(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "Program_0", c)) break;
    }
    return true;
  }

  // Declaration*
  private static boolean Program_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Program_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!Declaration(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "Program_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // Statement ";"
  public static boolean SemicolonStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SemicolonStatement")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _COLLAPSE_, SEMICOLON_STATEMENT, "<semicolon statement>");
    r = Statement(b, l + 1);
    p = r; // pin = 1
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // Expression | BonkStatement | BrekStatement | VariableDeclaration
  public static boolean Statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Statement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, STATEMENT, "<statement>");
    r = Expression(b, l + 1);
    if (!r) r = BonkStatement(b, l + 1);
    if (!r) r = BrekStatement(b, l + 1);
    if (!r) r = VariableDeclaration(b, l + 1);
    exit_section_(b, l, m, r, false, BonkParser::statementRecovery);
    return r;
  }

  /* ********************************************************** */
  // "buul" | "shrt" | "nubr" | "long" | "flot" | "dabl" | "strg" | "nothing" | "null"
  public static boolean TrivialType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TrivialType")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TRIVIAL_TYPE, "<trivial type>");
    r = consumeToken(b, BUUL_KEYWORD);
    if (!r) r = consumeToken(b, SHRT_KEYWORD);
    if (!r) r = consumeToken(b, NUBR_KEYWORD);
    if (!r) r = consumeToken(b, LONG_KEYWORD);
    if (!r) r = consumeToken(b, FLOT_KEYWORD);
    if (!r) r = consumeToken(b, DABL_KEYWORD);
    if (!r) r = consumeToken(b, STRG_KEYWORD);
    if (!r) r = consumeToken(b, NOTHING_KEYWORD);
    if (!r) r = consumeToken(b, NULL_KEYWORD);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "many" Type | TrivialType | Identifier
  public static boolean Type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Type")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TYPE, "<type>");
    r = Type_0(b, l + 1);
    if (!r) r = TrivialType(b, l + 1);
    if (!r) r = Identifier(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // "many" Type
  private static boolean Type_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Type_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, MANY_KEYWORD);
    r = r && Type(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // "not" | PlusMinus
  public static boolean UnaryOperator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "UnaryOperator")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, UNARY_OPERATOR, "<unary operator>");
    r = consumeToken(b, NOT_OPERATOR);
    if (!r) r = PlusMinus(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "bowl" Identifier (":" Type)? ("=" Expression)?
  public static boolean VariableDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VariableDeclaration")) return false;
    if (!nextTokenIs(b, BOWL_OPERATOR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BOWL_OPERATOR);
    r = r && Identifier(b, l + 1);
    r = r && VariableDeclaration_2(b, l + 1);
    r = r && VariableDeclaration_3(b, l + 1);
    exit_section_(b, m, VARIABLE_DECLARATION, r);
    return r;
  }

  // (":" Type)?
  private static boolean VariableDeclaration_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VariableDeclaration_2")) return false;
    VariableDeclaration_2_0(b, l + 1);
    return true;
  }

  // ":" Type
  private static boolean VariableDeclaration_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VariableDeclaration_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && Type(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ("=" Expression)?
  private static boolean VariableDeclaration_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VariableDeclaration_3")) return false;
    VariableDeclaration_3_0(b, l + 1);
    return true;
  }

  // "=" Expression
  private static boolean VariableDeclaration_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VariableDeclaration_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ASSIGN);
    r = r && Expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // SemicolonStatement | ";"
  public static boolean WrapperStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "WrapperStatement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, WRAPPER_STATEMENT, "<wrapper statement>");
    r = SemicolonStatement(b, l + 1);
    if (!r) r = consumeToken(b, SEMICOLON);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // !(","|"]")
  static boolean parameterListItemRecovery(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameterListItemRecovery")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !parameterListItemRecovery_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ","|"]"
  private static boolean parameterListItemRecovery_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameterListItemRecovery_0")) return false;
    boolean r;
    r = consumeToken(b, COMMA);
    if (!r) r = consumeToken(b, RIGHT_BRACKET);
    return r;
  }

  /* ********************************************************** */
  // Program
  static boolean root(PsiBuilder b, int l) {
    return Program(b, l + 1);
  }

  /* ********************************************************** */
  // !(";" | "{" | "}" | "(" | ")" | "bonk" | "blok" | "loop" | "hive" | "brek")
  static boolean statementRecovery(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statementRecovery")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !statementRecovery_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ";" | "{" | "}" | "(" | ")" | "bonk" | "blok" | "loop" | "hive" | "brek"
  private static boolean statementRecovery_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statementRecovery_0")) return false;
    boolean r;
    r = consumeToken(b, SEMICOLON);
    if (!r) r = consumeToken(b, LEFT_CURLY);
    if (!r) r = consumeToken(b, RIGHT_CURLY);
    if (!r) r = consumeToken(b, LEFT_PAREN);
    if (!r) r = consumeToken(b, RIGHT_PAREN);
    if (!r) r = consumeToken(b, BONK_OPERATOR);
    if (!r) r = consumeToken(b, BLOK_OPERATOR);
    if (!r) r = consumeToken(b, LOOP_OPERATOR);
    if (!r) r = consumeToken(b, HIVE_OPERATOR);
    if (!r) r = consumeToken(b, BREK_OPERATOR);
    return r;
  }

}
