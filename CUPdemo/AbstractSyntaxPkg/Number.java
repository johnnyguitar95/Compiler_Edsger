package AbstractSyntaxPkg;

import VisitorPkg.Visitor;

public class Number extends Expr {
  public int value;

  public Number(int v){
    value = v;
  }

  public void accept(Visitor v){
    v.visit(this);
  }
}
