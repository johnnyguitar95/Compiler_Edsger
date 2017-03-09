package VisitorPkg;

import AbstractSyntaxPkg.*;
import ParsePkg.*;

public class TreePrintVisitor implements Visitor {

  // Author John Halloran
  String indent = "";

  void doIndent() {
    indent = indent + "    ";
  }

  void undoIndent() {
    indent = indent.substring(0, indent.length()-4);
  }

  public void visit(Program n){
    indent = "";
    doIndent();
    for (int i=0; n.globals != null && i < n.globals.size(); i++){
      if(i == 0) System.out.println("Global vars(");
      n.globals.get(i).accept(this);
      System.out.println();
      if(i == n.globals.size()-1) System.out.println(")");
    }//end for loop for global variables
    undoIndent();

    doIndent();
    for(int i=0; i<n.funs.size(); i++){
      if(i == 0) System.out.println("Functions(");
      n.funs.get(i).accept(this);
      System.out.println();
      if(i == n.funs.size()-1) System.out.println(")");
    }//end for loop for function list
    undoIndent();

    System.out.println("Body {");
    doIndent();
    for(int i = 0; i<n.body.size(); i++){
	n.body.get(i).accept(this);
    }
    undoIndent();
    System.out.println("}");
    System.out.println("END OF FILE");
  }//end visit for Program

  public void visit(VarDecl n){
    System.out.print(indent + n.name);
    System.out.print(" , ");
    n.type.accept(this);
  }

  public void visit(IntType n){
    System.out.print("int");
  }

  public void visit(BoolType n){
    System.out.print("bool");
  }

  public void visit(FunDef n){
    System.out.println(indent + n.name + "{");
    doIndent();
    System.out.println(indent + "Outer Arguments (");
    doIndent();
    for(int i = 0; i<n.outargs.size(); i++){
	    n.outargs.get(i).accept(this);
	    System.out.println();
    }
    undoIndent();
    System.out.println(indent + ")");
    System.out.println(indent + "Inner Arguments (");
    doIndent();
    for(int i = 0; i<n.inargs.size(); i++){
	    n.inargs.get(i).accept(this);
	    System.out.println();
    }
    undoIndent();
    System.out.println(indent + ")");
    System.out.println(indent + "Local Variables (");
    doIndent();
    for(int i = 0; i<n.locals.size(); i++){
	    n.locals.get(i).accept(this);
	    System.out.println();
    }
    undoIndent();
    System.out.println(indent + ")");
    System.out.println(indent + "Body {");
    doIndent();
    for(int i = 0; i<n.body.size(); i++){
	    n.body.get(i).accept(this);
	    System.out.println();
    }
    undoIndent();
    System.out.println(indent + "}");
    undoIndent();
    System.out.println(indent + "}"); 
  }

  public void visit(GCommand n){
  	System.out.println(indent + "GCommand {");
	doIndent();
	n.cond.accept(this);
	System.out.println("\n" + indent + "Statement");
	n.stmt.accept(this);
	undoIndent();
  }
  public void visit(IntArrayType n){}
  public void visit(BoolArrayType n){}
  public void visit(CompoundStmt n){
	n.stmt.accept(this);
	System.out.println(indent + ";");
	if(n.rest != null)
		n.rest.accept(this);
  }

  public void visit(Assign n){
      doIndent(); 
      if(n.dlist.size() != n.elist.size()){
	      System.out.println("ERROR!!!!! ASSIGNMENT!!!");
	      System.exit(0);
      }
      for(int i = 0; i<n.dlist.size(); i++){
	n.dlist.get(i).accept(this);
        System.out.print(indent + "<-");
	n.elist.get(i).accept(this);
	System.out.println();
      }
      undoIndent();
  }
  public void visit(If n){
      doIndent();
      System.out.println(indent + "if");
      for(int i = 0; i<n.glist.size(); i++){
	      n.glist.get(i).accept(this);
      }
      undoIndent();
  }
  public void visit(IfThen n){
      System.out.println(indent + "if");
      doIndent();
      n.cond.accept(this);
      undoIndent();
      System.out.println(indent + "then");
      doIndent();
      n.stmt.accept(this);
      undoIndent();
  }
  public void visit(Do n){
      System.out.println(indent + "DO{");
      doIndent();
      for(int i = 0; i<n.glist.size(); i++){
         n.glist.get(i).accept(this);
      }
      undoIndent();
      System.out.println(indent + "}");
  }
  public void visit(Skip n){
      System.out.println(indent + "SKIP");
  }
  public void visit(Display n){
      System.out.print(indent + "Display(");
      for(int i = 0; i<n.elist.size(); i++){
         n.elist.get(i).accept(this);
      }
      
      System.out.println(indent + ")");
  }

  public void visit(FunCallStmt n){
      System.out.println(indent + "Function Call:");
      doIndent();
      System.out.println(indent + "Name: " + n.name);
      doIndent();
      for(int i = 0; i<n.elist.size(); i++){
	      n.elist.get(i).accept(this);
      }
      undoIndent();
      undoIndent();
      System.out.println("End function Call");
  }
  public void visit(Plus n){
	System.out.print(indent);
  	n.e1.accept(this);
	System.out.print(" + ");
	n.e2.accept(this);
  }
  public void visit(Minus n){
  	
	System.out.print(indent);
  	n.e1.accept(this);
	n.e1.accept(this);
	System.out.print(" - ");
	n.e2.accept(this);
  }
  public void visit(Times n){
  	
	System.out.print(indent);
	n.e1.accept(this);
	System.out.print(" * ");
	n.e2.accept(this);
  }
  public void visit(Div n){
  	System.out.print(indent);
	n.e1.accept(this);
	System.out.print(" / ");
	n.e2.accept(this);
  }
  public void visit(Neg n){
  	
  }
  public void visit(Num n){
  	System.out.print(n.value);
  }
  public void visit(Equal n){
  	System.out.print(indent);
	n.e1.accept(this);
	System.out.print(" = ");
	n.e2.accept(this);
  }
  public void visit(NotEqual n){
  	System.out.print(indent);
	n.e1.accept(this);
	System.out.print(" <> ");
	n.e2.accept(this);
  }
  public void visit(LessThan n){
  	System.out.print(indent);
	n.e1.accept(this);
	System.out.print(" < " );
	n.e2.accept(this);
  }
  public void visit(LessEqual n){
  	System.out.print(indent);
	n.e1.accept(this);
	System.out.print(" <= " );
	n.e2.accept(this);
  }
  public void visit(GreaterThan n){
  	System.out.print(indent);
	n.e1.accept(this);
	System.out.print(" > ");
	n.e2.accept(this);
  }
  public void visit(GreaterEqual n){
  	System.out.print(indent);
	n.e1.accept(this);
	System.out.print(" >= ");
	n.e2.accept(this);
  }
  public void visit(Not n){
  	System.out.print(indent + "not ");
	n.g.accept(this);
  }
  public void visit(And n){
  	System.out.print(indent);
	n.g1.accept(this);
	System.out.print(" and ");
	n.g2.accept(this);
  }
  public void visit(Or n){
	System.out.print(indent);
	n.g1.accept(this);
	System.out.print(" or ");
	n.g2.accept(this);
  }
  public void visit(True n){
  	System.out.print("true");
  }
  public void visit(False n){
  	System.out.print("false");
  }
  public void visit(Id n){
  	System.out.print(n.name);
  }
  public void visit(ArrayElt n){}
  public void visit(FunCallExpr n){
  	System.out.println(indent + "FunCall Expr { ");
	doIndent();
	System.out.println(indent + "Name: " + n.name);
	doIndent();
	for(int i = 0; i<n.elist.size(); i++){
		n.elist.get(i).accept(this);
	}
	undoIndent();
	undoIndent();
	System.out.println(indent + "}");
  }
 
}
