/*
 * Flex file
 * Written by John Halloran
 */

import java_cup.runtime.Symbol;
%%
%state COMMENT
%{
	int commentCount;
%}

%cup

digit=[0-9]
letter=[A-Za-z]
%%

<YYINITIAL>{
"(" { return new Symbol(sym.LPAREN); }
")" { return new Symbol(sym.RPAREN); }
"," { return new Symbol(sym.COMMA); }
"+" { return new Symbol(sym.PLUS); }
"-" { return new Symbol(sym.MINUS); }
"*" { return new Symbol(sym.TIMES); }
"/" { return new Symbol(sym.DIV); }
">" {return new Symbol(sym.GREATER);}
"<" {return new Symbol(sym.LESSER);}
"not" {return new Symbol(sym.NOT);}
"and" {return new Symbol(sym.AND);}
"or" {return new Symbol(sym.OR);}
"true" {return new Symbol(sym.TRUE);}
"false" {return new Symbol(sym.FALSE);}
"<=" { return new Symbol(sym.LEQ); }
">=" {return new Symbol(sym.GEQ);}
"=" { return new Symbol(sym.EQ); }
"<>" { return new Symbol(sym.NEQ); }
"int" {return new Symbol(sym.INT);}
"bool" {return new Symbol(sym.BOOL);}
"[" {return new Symbol(sym.LBRACK);}
"]" {return new Symbol(sym.RBRACK);}
":" {return new Symbol(sym.COLON);}
";" {return new Symbol(sym.SEMICOLON);}
"fun" {return new Symbol(sym.FUN);}
"nuf" {return new Symbol(sym.NUF);}
"<<" {return new Symbol(sym.DOUBLARROW);}
">>" {return new Symbol(sym.DOUBRARROW);}
"skip" {return new Symbol(sym.SKIP);}
"<-" {return new Symbol(sym.LARROW);}
"->" {return new Symbol(sym.RARROW);}
"[]" {return new Symbol(sym.BOX);}
"if" {return new Symbol(sym.IF);}
"fi" {return new Symbol(sym.FI);}
"then" {return new Symbol(sym.THEN);}
"do" {return new Symbol(sym.DO); }
"od" {return new Symbol(sym.OD);}
"display" {return new Symbol(sym.DISPLAY);}
{digit}+ { return new Symbol(sym.NUMBER, new Integer(yytext())); }
{letter}({letter}|{digit})* { return new Symbol(sym.ID, yytext()); }
[ \t\n] { /* ignore white space. */ }
"{" {commentCount = 1; yybegin(COMMENT);}
}



<COMMENT>{

"{" {commentCount++;}

"}" {commentCount--; 
	if(commentCount == 0)
		yybegin(YYINITIAL);
}


. { /* ignore any string */ }

[ \t\n] { /* ignore white space. */}

<<EOF>> { System.err.println("Did not close comment properly. "); yybegin(YYINITIAL); }

}





. { System.err.println("Illegal character: "+yytext()); }
