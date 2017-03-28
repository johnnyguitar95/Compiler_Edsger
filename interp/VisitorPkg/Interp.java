package VisitorPkg;

import AbstractSyntaxPkg.*;
import java.util.HashMap;

public class Interp implements Visitor
{

  HashMap<String, Integer> symTable = new HashMap<String, Integer>();

  ValueVisitor eval = new ExprEval(symTable);


  public void visit(Program n){
    for (int i = 0; i < n.slist.size(); i++)
      (n.slist.get(i)).accept(this);
  }

  public void visit(Assign n){
    Integer v = (Integer)(n.e.accept(eval));
    symTable.put(n.idname, v);
  }

  public void visit(Output n){
    for (int i = 0; i < n.elist.size(); i++)
    {
      if (i > 0)
        System.out.print(", ");
      System.out.print(n.elist.get(i).accept(eval));
    }
    System.out.println();
  }
    
  public void visit(Unless n){
    int v = (Integer)(n.cond.accept(eval));
    if (v == 0)
      for (int i = 0; i < n.slist.size(); i++)
        (n.slist.get(i)).accept(this);
  }

  public void visit(Plus n){}
  public void visit(Minus n){}
  public void visit(Times n){}
  public void visit(Divide n){}
  public void visit(Leq n){}
  public void visit(Id n){}
  public void visit(Num n){}
}

