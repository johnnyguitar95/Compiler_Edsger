#
# makefile for CUPdemo
#
# written by mike slattery - feb 2001
# rewritten by mike slattery - mar 2005
# rewritten by mike slattery - feb 2017
#
JAVA=java
JAVAC=javac
JFLEX=/users/faculty/mikes/cosc4400/jflex-1.6.1/bin/jflex
CUPJAR=/users/faculty/mikes/cosc4400/jflex-1.6.1/lib/java-cup-11a.jar
CUP=$(JAVA) -jar $(CUPJAR) <
# Specify classpath
CP=.:$(CUPJAR)

#Uncomment next line to compile with debug
#JFLAGS=-g

Main.class: ParsePkg/Grm.class
	$(JAVAC) $(JFLAGS) -classpath $(CP) Main.java

ParsePkg/Grm.class: ParsePkg/Yylex.java ParsePkg/Grm.java AbstractSyntaxPkg/AbstractSyntaxPkg.class jgo
	$(JAVAC) $(JFLAGS) -classpath $(CP) ParsePkg/*.java

ParsePkg/Grm.java: ParsePkg/Grm.cup
	cd ParsePkg; $(CUP) Grm.cup

ParsePkg/Yylex.java: ParsePkg/one.flex
	cd ParsePkg; $(JFLEX) one.flex

AbstractSyntaxPkg/AbstractSyntaxPkg.class:  AbstractSyntaxPkg/*.java
	$(JAVAC) $(JFLAGS) -classpath $(CP) AbstractSyntaxPkg/*.java

#
# Create a one-line shell script to run the
# scanner with the correct classpath
#
# Usage: jgo file
#  (where file is the input program)
#
jgo: makefile
	echo "java -classpath $(CP) Main < \$$1" > jgo
	chmod a+x jgo

clean:
	rm ParsePkg/*.class AbstractSyntaxPkg/*.class ParsePkg/parser.java ParsePkg/sym.java ParsePkg/Yylex.java jgo VisitorPkg/*.class Main.class
