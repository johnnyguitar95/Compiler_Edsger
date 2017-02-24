package AbstractSyntaxPkg;

import VisitorPkg.Visitor;

public class Times extends Expr {
  public Expr e1, e2;

  public Times(Expr ae1, Expr ae2) { 
    e1=ae1; e2=ae2;
  }

  public void accept(Visitor v) {
    v.visit(this);
  }
}
