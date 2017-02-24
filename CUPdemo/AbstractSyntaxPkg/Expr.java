package AbstractSyntaxPkg;

import VisitorPkg.Visitor;

public abstract class Expr {
  public abstract void accept(Visitor v);
}
