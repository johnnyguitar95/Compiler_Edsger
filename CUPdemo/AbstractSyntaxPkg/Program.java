package AbstractSyntaxPkg;

import VisitorPkg.Visitor;

public class Program {

  public StmtList slist;

  public Program(StmtList aslist){
    slist = aslist;
  }

  public void accept(Visitor v){
    v.visit(this);
  }
}
