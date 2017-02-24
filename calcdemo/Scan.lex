/*
 * Simple scanner for the calc demo
 *
 * written by mike slattery - feb 2001
 */

import java_cup.runtime.Symbol;
%%
%cup

%eofval{
	{ return new Symbol(sym.EOF); }
%eofval}

digit=[0-9]
%%
";" { return new Symbol(sym.SEMI); }
"(" { return new Symbol(sym.LPAREN); }
")" { return new Symbol(sym.RPAREN); }
"+" { return new Symbol(sym.PLUS); }
"-" { return new Symbol(sym.MINUS); }
"*" { return new Symbol(sym.TIMES); }
"/" { return new Symbol(sym.DIVIDE); }
{digit}+ { return new Symbol(sym.NUMBER, new Integer(yytext())); }
[ \t\n] { /* ignore white space. */ }
. { System.err.println("Illegal character: "+yytext()); }
