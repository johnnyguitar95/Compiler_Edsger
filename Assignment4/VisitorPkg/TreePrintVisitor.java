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
    for (int i=0; n.globals != null && i < n.globals.size(); i++){
      if(i == 0) System.out.println("Global vars(");
      n.globals.get(i).accept(this);
      System.out.println();
      if(i == n.globals.size()-1) System.out.println(")");
    }//end for loop for global variables
    

    for(int i=0; i<n.funs.size(); i++){
      if(i == 0) System.out.println("Functions(");
      doIndent();
      n.funs.get(i).accept(this);
      System.out.println();
      undoIndent();
      if(i == n.funs.size()-1) System.out.println(")");
    }//end for loop for function list

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
	System.out.print(indent + "EXPR:");
	n.cond.accept(this);
	System.out.println("\n" + indent + "Statement{");
	doIndent();
	n.stmt.accept(this);
	undoIndent();
	undoIndent();
	System.out.println(indent + "}end GCommand");
  }
  public void visit(IntArrayType n){
  	System.out.print("int indexes " + n.begin + ".." + n.end);
  }
  public void visit(BoolArrayType n){
  	System.out.print("bool indexes " + n.begin + ".." + n.end);
  }
  public void visit(CompoundStmt n){
	n.stmt.accept(this);
//	System.out.println(indent + ";");
	if(n.rest != null)
		n.rest.accept(this);
  }

  public void visit(Assign n){ 
      if(n.dlist.size() != n.elist.size()){
	      System.out.println("ERROR!!!!! ASSIGNMENT!!!");
	      System.exit(0);
      }
      System.out.println(indent + "Assign(");
      doIndent();
      for(int i = 0; i<n.dlist.size(); i++){
	System.out.print(indent);
	n.dlist.get(i).accept(this);
        System.out.print("<-");
	n.elist.get(i).accept(this);
	System.out.println();
      }
      undoIndent();
      System.out.println(indent + ") End Assign");
  }
  public void visit(If n){   
      System.out.println(indent + "if{");
      doIndent();
      for(int i = 0; i<n.glist.size(); i++){
	      n.glist.get(i).accept(this);
      }
      undoIndent();
      System.out.println(indent + "} end if");
    }
  public void visit(IfThen n){
      System.out.println(indent + "if (then){");
      doIndent();
      n.cond.accept(this);
      undoIndent();
      System.out.println(indent + "} end if (then)");
      System.out.println(indent + "then{ ");
      doIndent();
      n.stmt.accept(this);
      undoIndent();
      System.out.println(indent + "} END then");
  }
  public void visit(Do n){
      System.out.println(indent + "DO{");
      doIndent();
      for(int i = 0; i<n.glist.size(); i++){
         n.glist.get(i).accept(this);
      }
      undoIndent();
      System.out.println(indent + "} END DO");
  }
  public void visit(Skip n){
      System.out.println(indent + "SKIP");
  }
  public void visit(Display n){
      System.out.print(indent + "Display(");
      for(int i = 0; i<n.elist.size(); i++){
         n.elist.get(i).accept(this);
	 if(i < n.elist.size()-1)
		 System.out.print(indent);
      }
      
      System.out.println(") End Display");
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
  	System.out.print("ADD{");
	n.e1.accept(this);
	System.out.print(" + ");
	n.e2.accept(this);
	System.out.print("} END ADD");
  }
  public void visit(Minus n){
	System.out.print("SUB{");	
	n.e1.accept(this);
	System.out.print(" - ");
	n.e2.accept(this);
	System.out.print("} END SUB");
  }
  public void visit(Times n){
  	System.out.print("MULT{");	
	n.e1.accept(this);
	System.out.print(" * ");
	n.e2.accept(this);
	System.out.print("} END MULT");
  }
  public void visit(Div n){
  	System.out.print("DIVIDE {");
	n.e1.accept(this);
	System.out.print(" / ");
	n.e2.accept(this);
	System.out.print("} End DIVIDE");
  }
  public void visit(Neg n){
  	System.out.print("NEG {");
	n.e.accept(this);
	System.out.print("}END NEG");
  }
  public void visit(Num n){
  	System.out.print(n.value);
  }
  public void visit(Equal n){
	System.out.print("EQUAL {");
  	n.e1.accept(this);
	System.out.print(" == ");
	n.e2.accept(this);
	System.out.print("}END EQUAL");
  }
  public void visit(NotEqual n){
	System.out.print("NOTEQUAL {");
  	n.e1.accept(this);
	System.out.print(" <> ");
	n.e2.accept(this);
	System.out.print("}END NOTEQUAL");
  }
  public void visit(LessThan n){
	System.out.print("LESSTHAN {");
  	n.e1.accept(this);
	System.out.print(" < " );
	n.e2.accept(this);
	System.out.print("} END LESSTHAN");
  }
  public void visit(LessEqual n){
	System.out.print("LESSEQUAL {");
  	n.e1.accept(this);
	System.out.print(" <= " );
	n.e2.accept(this);
	System.out.print("} END LESSEQUAL");
  }
  public void visit(GreaterThan n){
	System.out.print("GREATERTHAN {");
  	n.e1.accept(this);
	System.out.print(" > ");
	n.e2.accept(this);
	System.out.print("}END GREATERTHAN");
  }
  public void visit(GreaterEqual n){
	System.out.print("GREATEREQUAL {");
  	n.e1.accept(this);
	System.out.print(" >= ");
	n.e2.accept(this);
	System.out.print("} END GREATEREQUAL");
  }
  public void visit(Not n){
  	System.out.print("NOT{ ");
	n.g.accept(this);
	System.out.print("}END NOT");
  }
  public void visit(And n){
	System.out.print("AND {");
  	n.g1.accept(this);
	System.out.print(" and ");
	n.g2.accept(this);
	System.out.print("} END AND");
  }
  public void visit(Or n){
	System.out.print("OR {");
	n.g1.accept(this);
	System.out.print(" or ");
	n.g2.accept(this);
	System.out.print("}END OR");
  }
  public void visit(True n){
  	System.out.print("true");
  }
  public void visit(False n){
  	System.out.print("false");
  }
  public void visit(Id n){
  	System.out.print("ID:" + n.name);
  }
  public void visit(ArrayElt n){
  	System.out.print("ArrayElt{");
	System.out.print("ID:" + n.name);
	System.out.print("\tIndex:");
	n.index.accept(this);
	System.out.print("}END ArrayElt");
  }
  public void visit(FunCallExpr n){
  	System.out.print("FunCall Expr { ");
	System.out.println("Name: " + n.name);
	doIndent();
	for(int i = 0; i<n.elist.size(); i++){
		System.out.print(indent);
		n.elist.get(i).accept(this);
	}
	undoIndent();
	System.out.println();
	System.out.println(indent + "}End FunCall Expr for " + n.name);
  }
 
}
