#
# Makefile for JFlex demo program
#
# written by mike slattery
#


JAVA=java
JAVAC=javac
JFLEX=/users/faculty/mikes/cosc4400/jflex-1.6.1/bin/jflex
CUPJAR=/users/faculty/mikes/cosc4400/jflex-1.6.1/lib/java-cup-11a.jar
CUP=$(JAVA) -jar $(CUPJAR) <
# Specify classpath
CP=.:$(CUPJAR)

Main.class: Main.java sym.java Yylex.java jgo
	$(JAVAC) -classpath $(CP) *.java

sym.java: one.cup
	$(CUP) one.cup
	rm parser.java

Yylex.java: one.flex
	$(JFLEX) one.flex

#
# Create a one-line shell script to run the
# scanner with the correct classpath
#
# Usage: jgo file
#  (where file is the sample input program)
#
jgo: makefile
	echo "java -classpath $(CP) Main \$$1" > jgo
	chmod a+x jgo

clean:
	rm *.class sym.java Yylex.java jgo

