import java_cup.runtime.*;
import ParsePkg.*;
import AbstractSyntaxPkg.Program;
import VisitorPkg.*;
import java.io.Reader;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws java.lang.Exception {
	Reader inp = new InputStreamReader(System.in);
    Program root = new parser(new Yylex(inp)).getTree();
    //root.accept(new TreePrintVisitor());
    //root.accept(new PrettyPrintVisitor());
    root.accept(new Interp());
  }
}
