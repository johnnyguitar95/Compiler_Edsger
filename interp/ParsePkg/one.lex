package ParsePkg;

/*
 * Simple demo scanner for
 * demo language
 *
 * Use scanner states to check for comments
 *
 * written by mike slattery - feb 2005
 */

import java_cup.runtime.Symbol;
%%
%cup
%public

%eofval{
	{ return new Symbol(sym.EOF); }
%eofval}

digit=[0-9]
letter=[A-Za-z]

%state COMMENT
%%
<YYINITIAL>"output" { return new Symbol(sym.OUTPUT); }
<YYINITIAL>"do" { return new Symbol(sym.DO); }
<YYINITIAL>"unless" { return new Symbol(sym.UNLESS); }
<YYINITIAL>"." { return new Symbol(sym.DOT); }
<YYINITIAL>"<-" { return new Symbol(sym.ASSIGN); }
<YYINITIAL>"(" { return new Symbol(sym.LPAREN); }
<YYINITIAL>")" { return new Symbol(sym.RPAREN); }
<YYINITIAL>"," { return new Symbol(sym.COMMA); }
<YYINITIAL>"+" { return new Symbol(sym.PLUS); }
<YYINITIAL>"-" { return new Symbol(sym.MINUS); }
<YYINITIAL>"*" { return new Symbol(sym.TIMES); }
<YYINITIAL>"/" { return new Symbol(sym.DIV); }
<YYINITIAL>"<=" { return new Symbol(sym.LEQ); }
<YYINITIAL>{digit}+ { return new Symbol(sym.NUMBER, new Integer(yytext())); }
<YYINITIAL>{letter}({letter}|{digit})* { return new Symbol(sym.ID, yytext()); }
<YYINITIAL>[ \t\n] { /* ignore white space. */ }
<YYINITIAL>"$" { yybegin(COMMENT); }
<YYINITIAL>. { System.err.println("Illegal character: "+yytext()); }
<COMMENT>"$" { yybegin(YYINITIAL); }
<COMMENT>. { /* skip over body of comment */ }
<COMMENT>\n { /* including multiple lines */ }
