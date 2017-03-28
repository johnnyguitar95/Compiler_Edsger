package VisitorPkg;

import AbstractSyntaxPkg.*;

public interface ValueVisitor {
  public Object visit(Program n);
  public Object visit(Assign n);
  public Object visit(Output n);
  public Object visit(Unless n);
  public Object visit(Plus n);
  public Object visit(Minus n);
  public Object visit(Times n);
  public Object visit(Divide n);
  public Object visit(Leq n);
  public Object visit(Id n);
  public Object visit(Num n);
}
