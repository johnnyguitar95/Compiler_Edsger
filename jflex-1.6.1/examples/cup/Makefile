JAVA=java
JAVAC=javac
JFLEX=/users/faculty/mikes/cosc4400/jflex-1.6.1/bin/jflex
CUPJAR=/users/faculty/mikes/cosc4400/jflex-1.6.1/lib/java-cup-11a.jar
CUP=$(JAVA) -jar $(CUPJAR) <
CP=.:$(CUPJAR)

all: test

test: output.txt
	@(diff output.txt output.good && echo "Test OK!") || echo "Test failed!"

output.txt: Main.class test.txt
	$(JAVA) -cp $(CP) Main test.txt > output.txt

Main.class: Main.java Lexer.java parser.java

%.class: %.java
	$(JAVAC) -cp $(CP) $^

Lexer.java: lcalc.flex
	$(JFLEX) lcalc.flex

parser.java: ycalc.cup
	$(CUP) ycalc.cup

clean:
	rm -f parser.java Lexer.java sym.java output.txt *.class *~
