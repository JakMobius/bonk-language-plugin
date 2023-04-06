package com.jakmobius.bonk.grammar;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static com.jakmobius.bonk.psi.BonkTypes.*;

%%

%{
  public _BonkLexer() {
    this((java.io.Reader)null);
  }
%}

%public
%class _BonkLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

EOL=\R
WHITE_SPACE=\s+

ID=[:letter:][a-zA-Z_0-9]*
STRING=(\"([^\"\\]|\\.)*\")
NUMBER=([0-9]+(\.[0-9]*)?)|(\.[0-9]+)(([Ee])([+-])?[0-9]+)?
LINE_COMMENT=dogo:.*
BLOCK_COMMENT=-dogo->(.|\n)*<-dogo-
SPACE=[ \t]+
NEWLINE=\n|(\r\n)

%%
<YYINITIAL> {
  {WHITE_SPACE}        { return WHITE_SPACE; }

  "buul"               { return BUUL_KEYWORD; }
  "shrt"               { return SHRT_KEYWORD; }
  "nubr"               { return NUBR_KEYWORD; }
  "long"               { return LONG_KEYWORD; }
  "flot"               { return FLOT_KEYWORD; }
  "dabl"               { return DABL_KEYWORD; }
  "strg"               { return STRG_KEYWORD; }
  "many"               { return MANY_KEYWORD; }
  "nothing"            { return NOTHING_KEYWORD; }
  "null"               { return NULL_KEYWORD; }
  "blok"               { return BLOK_OPERATOR; }
  "help"               { return HELP_OPERATOR; }
  "brek"               { return BREK_OPERATOR; }
  "hive"               { return HIVE_OPERATOR; }
  "bowl"               { return BOWL_OPERATOR; }
  "bonk"               { return BONK_OPERATOR; }
  "loop"               { return LOOP_OPERATOR; }
  "of"                 { return OF_OPERATOR; }
  "and"                { return AND_OPERATOR; }
  "or"                 { return OR_OPERATOR; }
  "not"                { return NOT_OPERATOR; }
  "<="                 { return LESS_EQ; }
  ">="                 { return GREATER_EQ; }
  "+="                 { return PLUS_ASSIGN; }
  "-="                 { return MINUS_ASSIGN; }
  "*="                 { return MUL_ASSIGN; }
  "/="                 { return DIV_ASSIGN; }
  "=="                 { return EQUALS; }
  "="                  { return ASSIGN; }
  "!="                 { return NOT_EQUALS; }
  "<"                  { return LESS; }
  ">"                  { return GREATER; }
  "+"                  { return PLUS; }
  "-"                  { return MINUS; }
  "*"                  { return MUL; }
  "/"                  { return DIV; }
  ","                  { return COMMA; }
  ";"                  { return SEMICOLON; }
  ":"                  { return COLON; }
  "["                  { return LEFT_BRACKET; }
  "]"                  { return RIGHT_BRACKET; }
  "("                  { return LEFT_PAREN; }
  ")"                  { return RIGHT_PAREN; }
  "{"                  { return LEFT_CURLY; }
  "}"                  { return RIGHT_CURLY; }
  "@"                  { return CALL_OPERATOR; }

  {ID}                 { return ID; }
  {STRING}             { return STRING; }
  {NUMBER}             { return NUMBER; }
  {LINE_COMMENT}       { return LINE_COMMENT; }
  {BLOCK_COMMENT}      { return BLOCK_COMMENT; }
  {SPACE}              { return SPACE; }
  {NEWLINE}            { return NEWLINE; }

}

[^] { return BAD_CHARACTER; }
