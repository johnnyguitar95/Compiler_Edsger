package VisitorPkg;

import AbstractSyntaxPkg.*;

public class TreePrintVisitor implements Visitor {

  // Print out AbstractSyntax trees (mostly for
  // debugging the parser).
  // I didn't take the time to print the expression
  // trees, but you certainly could do that.
  //
  // mike slattery - mar 2005

  String indent = "";

  void doIndent() {
    indent = indent + "    ";
  }

  void undoIndent() {
    indent = indent.substring(0, indent.length()-4);
  }

  public void visit(Program n){
    indent = "";
    for (int i=0; i < n.slist.size(); i++){
      (n.slist.get(i)).accept(this);
      System.out.println();
    }
  }

  public void visit(Assign n){
    System.out.print(indent);
    System.out.print("Assign(");
    System.out.print(n.idname);
    System.out.println(", ");
    doIndent();
    System.out.print(indent);
    n.e.accept(this);
    undoIndent();
    System.out.println(")");
  }

  public void visit(Output n){
    System.out.print(indent);
    System.out.print("Output(");
    doIndent();
    for (int i = 0; i < n.elist.size(); i++){
      if (i > 0){
	System.out.println(", ");
        System.out.print(indent);
      }
      n.elist.get(i).accept(this);
    }
    undoIndent();
    System.out.println(")");
  }

  public void visit(Unless n){
    System.out.print(indent);
    System.out.println("Unless(");
    doIndent();
    for (int i = 0; i < n.slist.size(); i++){
      n.slist.get(i).accept(this);
      System.out.print(indent);
      System.out.println(",");
    }
    System.out.print(indent);
    n.cond.accept(this);
    undoIndent();
    System.out.println(")");
  }

  public void visit(Num n){
    System.out.print(n.value);
  }

  public void visit(Id n){
    System.out.print(n.name);
  }

  public void visit(Plus n){
    System.out.print("(");
    n.e1.accept(this);
    System.out.print(" + ");
    n.e2.accept(this);
    System.out.print(")");
  }

  public void visit(Minus n){
    System.out.print("(");
    n.e1.accept(this);
    System.out.print(" - ");
    n.e2.accept(this);
    System.out.print(")");
  }

  public void visit(Times n){
    n.e1.accept(this);
    System.out.print(" * ");
    n.e2.accept(this);
  }

  public void visit(Divide n){
    n.e1.accept(this);
    System.out.print(" / ");
    n.e2.accept(this);
  }

  public void visit(Leq n){
    n.e1.accept(this);
    System.out.print(" <= ");
    n.e2.accept(this);
  }

}
