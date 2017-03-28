package VisitorPkg;

import AbstractSyntaxPkg.*;
import java.util.HashMap;

public class ExprEval implements ValueVisitor {

  HashMap<String, Integer> symTable;

  public ExprEval(HashMap<String, Integer> st){
    symTable = st;
  }

  public Object visit(Plus n){
    int v1 = (Integer)(n.e1.accept(this));
    int v2 = (Integer)(n.e2.accept(this));
    return new Integer(v1+v2);
  }

  public Object visit(Minus n){
    int v1 = (Integer)(n.e1.accept(this));
    int v2 = (Integer)(n.e2.accept(this));
    return new Integer(v1-v2);
  }

  public Object visit(Times n){
    int v1 = (Integer)(n.e1.accept(this));
    int v2 = (Integer)(n.e2.accept(this));
    return new Integer(v1*v2);
  }

  public Object visit(Divide n){
    int v1 = (Integer)(n.e1.accept(this));
    int v2 = (Integer)(n.e2.accept(this));
    if (v2 != 0)
      return new Integer(v1/v2);
    else {
      System.out.println("Attempt to divide by zero");
      return new Integer(0);
    }
  }

  public Object visit(Leq n){
    int v1 = (Integer)(n.e1.accept(this));
    int v2 = (Integer)(n.e2.accept(this));
    if (v1 <= v2)
      return new Integer(1);
    else
      return new Integer(0);
  }

  public Object visit(Id n){
    Integer v = symTable.get(n.name);
    if (v == null){
      System.out.println("Attempt to use uninitialized variable: "+n.name);
      v = new Integer(0);
      symTable.put(n.name, v);
    }
    return v;
  }

  public Object visit(Num n){
    return new Integer(n.value);
  }

  public Object visit(Program n){ return null; }
  public Object visit(Assign n){ return null; }
  public Object visit(Output n){ return null; }
  public Object visit(Unless n){ return null; }
}
