#
# makefile for calc demo
#
# written by mike slattery - feb 2017
#
JAVA=java
JAVAC=javac
JFLEX=/users/faculty/mikes/cosc4400/jflex-1.6.1/bin/jflex
CUPJAR=/users/faculty/mikes/cosc4400/jflex-1.6.1/lib/java-cup-11a.jar
CUP=$(JAVA) -jar $(CUPJAR) <
# Specify classpath
CP=.:$(CUPJAR)

Main.class: Main.java Yylex.java parser.java calc
	$(JAVAC) -classpath $(CP) *.java

parser.java: parser.cup
	${CUP} parser.cup

Yylex.java: Scan.lex
	${JFLEX} Scan.lex

#
# Create a one-line shell script to run the
# scanner with the correct classpath
#
# Usage: calc
#  (reads expressions from standard input)
#
calc: makefile
	echo "java -classpath $(CP) Main" > calc
	chmod a+x calc

clean:
	rm *.class Yylex.java parser.java sym.java calc
