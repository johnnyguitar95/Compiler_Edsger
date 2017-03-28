package VisitorPkg;

import AbstractSyntaxPkg.*;

public interface Visitor {
  public void visit(Program n);
  public void visit(Assign n);
  public void visit(Output n);
  public void visit(Unless n);
  public void visit(Plus n);
  public void visit(Minus n);
  public void visit(Times n);
  public void visit(Divide n);
  public void visit(Leq n);
  public void visit(Id n);
  public void visit(Num n);
}
