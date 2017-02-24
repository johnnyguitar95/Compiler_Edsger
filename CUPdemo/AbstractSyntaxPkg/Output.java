package AbstractSyntaxPkg;

import VisitorPkg.Visitor;

public class Output extends Stmt {

  public ExprList elist;

  public Output(ExprList aelist){
    elist = aelist;
  }

  public void accept(Visitor v){
    v.visit(this);
  }
}
