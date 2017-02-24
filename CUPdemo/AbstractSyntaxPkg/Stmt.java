package AbstractSyntaxPkg;

import VisitorPkg.Visitor;

public abstract class Stmt {
  public abstract void accept(Visitor v);
}
