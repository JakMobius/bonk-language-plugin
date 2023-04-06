// This is a generated file. Not intended for manual editing.
package com.jakmobius.bonk.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.jakmobius.bonk.psi.impl.*;

public interface BonkTypes {

  IElementType AND_EXPRESSION = new BonkElementType("AND_EXPRESSION");
  IElementType ARRAY_CONSTANT = new BonkElementType("ARRAY_CONSTANT");
  IElementType ASSIGNMENT_OPERATOR = new BonkElementType("ASSIGNMENT_OPERATOR");
  IElementType ASSIGN_EXPRESSION = new BonkElementType("ASSIGN_EXPRESSION");
  IElementType BLOK_DECLARATION = new BonkElementType("BLOK_DECLARATION");
  IElementType BLOK_RETURN_TYPE = new BonkElementType("BLOK_RETURN_TYPE");
  IElementType BONK_STATEMENT = new BonkElementType("BONK_STATEMENT");
  IElementType BREK_STATEMENT = new BonkElementType("BREK_STATEMENT");
  IElementType CODE_BLOCK = new BonkElementType("CODE_BLOCK");
  IElementType COMPARE_EXPRESSION = new BonkElementType("COMPARE_EXPRESSION");
  IElementType COMPARISON_OPERATOR = new BonkElementType("COMPARISON_OPERATOR");
  IElementType DECLARATION = new BonkElementType("DECLARATION");
  IElementType EQUALS_EXPRESSION = new BonkElementType("EQUALS_EXPRESSION");
  IElementType EQ_COMPARISON_OPERATOR = new BonkElementType("EQ_COMPARISON_OPERATOR");
  IElementType EXPRESSION = new BonkElementType("EXPRESSION");
  IElementType EXPRESSION_CALL = new BonkElementType("EXPRESSION_CALL");
  IElementType EXPRESSION_STRING = new BonkElementType("EXPRESSION_STRING");
  IElementType EXPRESSION_UNARY = new BonkElementType("EXPRESSION_UNARY");
  IElementType HELP_STATEMENT = new BonkElementType("HELP_STATEMENT");
  IElementType HIVE_ACCESS = new BonkElementType("HIVE_ACCESS");
  IElementType HIVE_BODY = new BonkElementType("HIVE_BODY");
  IElementType HIVE_DECLARATION = new BonkElementType("HIVE_DECLARATION");
  IElementType IDENTIFIER = new BonkElementType("IDENTIFIER");
  IElementType LOOP_STATEMENT = new BonkElementType("LOOP_STATEMENT");
  IElementType MUL_DIV = new BonkElementType("MUL_DIV");
  IElementType MUL_DIV_EXPRESSION = new BonkElementType("MUL_DIV_EXPRESSION");
  IElementType OR_EXPRESSION = new BonkElementType("OR_EXPRESSION");
  IElementType PARAMETER_LIST = new BonkElementType("PARAMETER_LIST");
  IElementType PARAMETER_LIST_DECLARATION = new BonkElementType("PARAMETER_LIST_DECLARATION");
  IElementType PARAMETER_LIST_ITEM = new BonkElementType("PARAMETER_LIST_ITEM");
  IElementType PLUS_MINUS = new BonkElementType("PLUS_MINUS");
  IElementType PLUS_MINUS_EXPRESSION = new BonkElementType("PLUS_MINUS_EXPRESSION");
  IElementType PRIMARY_EXPRESSION = new BonkElementType("PRIMARY_EXPRESSION");
  IElementType PROGRAM = new BonkElementType("PROGRAM");
  IElementType SEMICOLON_STATEMENT = new BonkElementType("SEMICOLON_STATEMENT");
  IElementType STATEMENT = new BonkElementType("STATEMENT");
  IElementType TRIVIAL_TYPE = new BonkElementType("TRIVIAL_TYPE");
  IElementType TYPE = new BonkElementType("TYPE");
  IElementType UNARY_OPERATOR = new BonkElementType("UNARY_OPERATOR");
  IElementType VARIABLE_DECLARATION = new BonkElementType("VARIABLE_DECLARATION");
  IElementType WRAPPER_STATEMENT = new BonkElementType("WRAPPER_STATEMENT");

  IElementType AND_OPERATOR = new BonkTokenType("and");
  IElementType ASSIGN = new BonkTokenType("=");
  IElementType BLOCK_COMMENT = new BonkTokenType("block_comment");
  IElementType BLOK_OPERATOR = new BonkTokenType("blok");
  IElementType BONK_OPERATOR = new BonkTokenType("bonk");
  IElementType BOWL_OPERATOR = new BonkTokenType("bowl");
  IElementType BREK_OPERATOR = new BonkTokenType("brek");
  IElementType BUUL_KEYWORD = new BonkTokenType("buul");
  IElementType CALL_OPERATOR = new BonkTokenType("@");
  IElementType COLON = new BonkTokenType(":");
  IElementType COMMA = new BonkTokenType(",");
  IElementType DABL_KEYWORD = new BonkTokenType("dabl");
  IElementType DIV = new BonkTokenType("/");
  IElementType DIV_ASSIGN = new BonkTokenType("/=");
  IElementType EQUALS = new BonkTokenType("==");
  IElementType FLOT_KEYWORD = new BonkTokenType("flot");
  IElementType GREATER = new BonkTokenType(">");
  IElementType GREATER_EQ = new BonkTokenType(">=");
  IElementType HELP_OPERATOR = new BonkTokenType("help");
  IElementType HIVE_OPERATOR = new BonkTokenType("hive");
  IElementType ID = new BonkTokenType("id");
  IElementType LEFT_BRACKET = new BonkTokenType("[");
  IElementType LEFT_CURLY = new BonkTokenType("{");
  IElementType LEFT_PAREN = new BonkTokenType("(");
  IElementType LESS = new BonkTokenType("<");
  IElementType LESS_EQ = new BonkTokenType("<=");
  IElementType LINE_COMMENT = new BonkTokenType("line_comment");
  IElementType LONG_KEYWORD = new BonkTokenType("long");
  IElementType LOOP_OPERATOR = new BonkTokenType("loop");
  IElementType MANY_KEYWORD = new BonkTokenType("many");
  IElementType MINUS = new BonkTokenType("-");
  IElementType MINUS_ASSIGN = new BonkTokenType("-=");
  IElementType MUL = new BonkTokenType("*");
  IElementType MUL_ASSIGN = new BonkTokenType("*=");
  IElementType NOTHING_KEYWORD = new BonkTokenType("nothing");
  IElementType NOT_EQUALS = new BonkTokenType("!=");
  IElementType NOT_OPERATOR = new BonkTokenType("not");
  IElementType NUBR_KEYWORD = new BonkTokenType("nubr");
  IElementType NULL_KEYWORD = new BonkTokenType("null");
  IElementType NUMBER = new BonkTokenType("number");
  IElementType OF_OPERATOR = new BonkTokenType("of");
  IElementType OR_OPERATOR = new BonkTokenType("or");
  IElementType PLUS = new BonkTokenType("+");
  IElementType PLUS_ASSIGN = new BonkTokenType("+=");
  IElementType RIGHT_BRACKET = new BonkTokenType("]");
  IElementType RIGHT_CURLY = new BonkTokenType("}");
  IElementType RIGHT_PAREN = new BonkTokenType(")");
  IElementType SEMICOLON = new BonkTokenType(";");
  IElementType SHRT_KEYWORD = new BonkTokenType("shrt");
  IElementType STRG_KEYWORD = new BonkTokenType("strg");
  IElementType STRING = new BonkTokenType("string");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == AND_EXPRESSION) {
        return new BonkAndExpressionImpl(node);
      }
      else if (type == ARRAY_CONSTANT) {
        return new BonkArrayConstantImpl(node);
      }
      else if (type == ASSIGNMENT_OPERATOR) {
        return new BonkAssignmentOperatorImpl(node);
      }
      else if (type == ASSIGN_EXPRESSION) {
        return new BonkAssignExpressionImpl(node);
      }
      else if (type == BLOK_DECLARATION) {
        return new BonkBlokDeclarationImpl(node);
      }
      else if (type == BLOK_RETURN_TYPE) {
        return new BonkBlokReturnTypeImpl(node);
      }
      else if (type == BONK_STATEMENT) {
        return new BonkBonkStatementImpl(node);
      }
      else if (type == BREK_STATEMENT) {
        return new BonkBrekStatementImpl(node);
      }
      else if (type == CODE_BLOCK) {
        return new BonkCodeBlockImpl(node);
      }
      else if (type == COMPARE_EXPRESSION) {
        return new BonkCompareExpressionImpl(node);
      }
      else if (type == COMPARISON_OPERATOR) {
        return new BonkComparisonOperatorImpl(node);
      }
      else if (type == DECLARATION) {
        return new BonkDeclarationImpl(node);
      }
      else if (type == EQUALS_EXPRESSION) {
        return new BonkEqualsExpressionImpl(node);
      }
      else if (type == EQ_COMPARISON_OPERATOR) {
        return new BonkEqComparisonOperatorImpl(node);
      }
      else if (type == EXPRESSION_CALL) {
        return new BonkExpressionCallImpl(node);
      }
      else if (type == EXPRESSION_STRING) {
        return new BonkExpressionStringImpl(node);
      }
      else if (type == EXPRESSION_UNARY) {
        return new BonkExpressionUnaryImpl(node);
      }
      else if (type == HELP_STATEMENT) {
        return new BonkHelpStatementImpl(node);
      }
      else if (type == HIVE_ACCESS) {
        return new BonkHiveAccessImpl(node);
      }
      else if (type == HIVE_BODY) {
        return new BonkHiveBodyImpl(node);
      }
      else if (type == HIVE_DECLARATION) {
        return new BonkHiveDeclarationImpl(node);
      }
      else if (type == IDENTIFIER) {
        return new BonkIdentifierImpl(node);
      }
      else if (type == LOOP_STATEMENT) {
        return new BonkLoopStatementImpl(node);
      }
      else if (type == MUL_DIV) {
        return new BonkMulDivImpl(node);
      }
      else if (type == MUL_DIV_EXPRESSION) {
        return new BonkMulDivExpressionImpl(node);
      }
      else if (type == OR_EXPRESSION) {
        return new BonkOrExpressionImpl(node);
      }
      else if (type == PARAMETER_LIST) {
        return new BonkParameterListImpl(node);
      }
      else if (type == PARAMETER_LIST_DECLARATION) {
        return new BonkParameterListDeclarationImpl(node);
      }
      else if (type == PARAMETER_LIST_ITEM) {
        return new BonkParameterListItemImpl(node);
      }
      else if (type == PLUS_MINUS) {
        return new BonkPlusMinusImpl(node);
      }
      else if (type == PLUS_MINUS_EXPRESSION) {
        return new BonkPlusMinusExpressionImpl(node);
      }
      else if (type == PRIMARY_EXPRESSION) {
        return new BonkPrimaryExpressionImpl(node);
      }
      else if (type == PROGRAM) {
        return new BonkProgramImpl(node);
      }
      else if (type == SEMICOLON_STATEMENT) {
        return new BonkSemicolonStatementImpl(node);
      }
      else if (type == STATEMENT) {
        return new BonkStatementImpl(node);
      }
      else if (type == TRIVIAL_TYPE) {
        return new BonkTrivialTypeImpl(node);
      }
      else if (type == TYPE) {
        return new BonkTypeImpl(node);
      }
      else if (type == UNARY_OPERATOR) {
        return new BonkUnaryOperatorImpl(node);
      }
      else if (type == VARIABLE_DECLARATION) {
        return new BonkVariableDeclarationImpl(node);
      }
      else if (type == WRAPPER_STATEMENT) {
        return new BonkWrapperStatementImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
