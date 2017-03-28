package VisitorPkg;

import AbstractSyntaxPkg.*;

public class RawTreePrinter implements Visitor {

  // Print out AbstractSyntax trees (mostly for
  // debugging the parser).
  // Prints out every node in tree format
  //
  // mike slattery - feb 2017

  String indent = "";

  void doIndent() {
    indent = indent + "    ";
  }

  void undoIndent() {
    indent = indent.substring(0, indent.length()-4);
  }

  void printStmtList(StmtList slist)
  {
      System.out.println(indent+"StmtList[");
      doIndent();
      for (int i=0; i < slist.size(); i++){
  		if (i > 0){
  			System.out.println(indent+", ");
        }
        (slist.get(i)).accept(this);
      }
      undoIndent();
    System.out.println(indent+"]");
  }

  void printExprList(ExprList elist)
    {
        System.out.println(indent+"ExprList[");
        doIndent();
        for (int i=0; i < elist.size(); i++){
    		if (i > 0){
    			System.out.println(indent+", ");
          }
          (elist.get(i)).accept(this);
        }
        undoIndent();
      System.out.println(indent+"]");
  }

  public void visit(Program n){
    indent = "";
    System.out.println("Program(");
    doIndent();
	printStmtList(n.slist);
    undoIndent();
    System.out.println(")");
  }

  public void visit(Assign n){
    System.out.print(indent+"Assign(");
    System.out.print(n.idname);
    System.out.println(", ");
    doIndent();
    n.e.accept(this);
    undoIndent();
    System.out.println(indent+")");
  }

  public void visit(Output n){
    System.out.println(indent+"Output(");
    doIndent();
    printExprList(n.elist);
    undoIndent();
    System.out.println(indent+")");
  }

  public void visit(Unless n){
    System.out.println(indent+"Unless(");
    doIndent();
    printStmtList(n.slist);
    System.out.println(indent+",");
    n.cond.accept(this);
    undoIndent();
    System.out.println(indent+")");
  }

  public void visit(Num n){
    System.out.println(indent+n.value);
  }

  public void visit(Id n){
    System.out.println(indent+n.name);
  }

  public void visit(Plus n){
    System.out.println(indent + "Plus(");
    doIndent();
    n.e1.accept(this);
    System.out.println(indent+",");
    n.e2.accept(this);
    undoIndent();
    System.out.println(indent+")");
  }

  public void visit(Minus n){
      System.out.println(indent + "Minus(");
      doIndent();
      n.e1.accept(this);
      System.out.println(indent+",");
      n.e2.accept(this);
      undoIndent();
      System.out.println(indent+")");
  }

  public void visit(Times n){
      System.out.println(indent + "Times(");
      doIndent();
      n.e1.accept(this);
      System.out.println(indent+",");
      n.e2.accept(this);
      undoIndent();
      System.out.println(indent+")");
  }

  public void visit(Divide n){
      System.out.println(indent + "Divide(");
      doIndent();
      n.e1.accept(this);
      System.out.println(indent+",");
      n.e2.accept(this);
      undoIndent();
      System.out.println(indent+")");
  }

  public void visit(Leq n){
      System.out.println(indent + "Leq(");
      doIndent();
      n.e1.accept(this);
      System.out.println(indent+",");
      n.e2.accept(this);
      undoIndent();
      System.out.println(indent+")");
  }


  public static void main(String[] args)
  {
	  // Demo driver
	  //
	  // Build a tree to print
	  StmtList s = new StmtList();
	  s.add(new Assign("temp",new Plus(new Num(77),
	  					new Num(88))));
	    ExprList e = new ExprList();
	    e.add(new Num(99));
	    e.add(new Id("hello"));
	  s.add(new Output(e));
	    StmtList s2 = new StmtList();
	    s2.add(new Assign("later",new Divide(new Num(432),
	  					new Num(123))));

	    s2.add(new Output(e));
	  s.add(new Unless(s2, new Id("flag")));
	  Program p = new Program(s);
	  p.accept(new PrettyPrintVisitor());
	  System.out.println("==============");
	p.accept(new RawTreePrinter());

  }

}
