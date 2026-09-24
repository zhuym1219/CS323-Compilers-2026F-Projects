//grammar Calc1;
lexer grammar Calc1;
@lexer::members {
    public boolean java5 = false; // 注入到生成的 CalculatorLexer.java 中的成员变量
}


channels { WHITESPACE, COMMENTS }
//词法
INT: 'int';
CHAR: 'char';
FLOAT: 'float';
IF: 'if';
RETURN: 'return';
PRINTF: 'printf';
STRING_DECLARE: 'String';
ENUM: 'enum' {java5}? ;
LPAREN : '(' ;
RPAREN : ')' ;
LARGE_LPAREN: '{';
LARGE_RPAREN: '}';
LARGER : '>';
SMARLL : '<';
EQUAL : '=';
LARGE_EQUAL: '>=';
SMARLL_EQUAL: '<=';
ADD : '+' ;
SUB : '-' ;
MUL : '*' ;
DIV : '/' ;
SEMICOLON: ';';
COMMA: ',';
COLON: ':';
MAIN: 'main';
NUMBER: [0-9]+;
FLOAT_NUMBER: [0-9]+ '.' [0-9]+ ;
IDENTIFIER: [a-zA-Z_][a-zA-Z0-9_]* ;
STRING: '"' .*? '"';
//STRING: '"' ( Escape | ~["\\] )* '"';
//fragment Escape: '\\'('"'|'\\');
fragment Escape: '\\' ( '"' | '\\' | 'n' | 'r' | 't' | 'b' | 'f' );
WS: [ \t\r\n]+     ->skip;
//WS  : [ \t\r\n]+     -> channel(WHITESPACE);
SL_COMMENT : '//' .*? '\n' -> channel(COMMENTS);
ML_COMMENT : '/*' ( . | '\n' )*? '*/' -> channel(COMMENTS);