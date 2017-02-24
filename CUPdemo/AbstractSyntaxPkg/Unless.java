package AbstractSyntaxPkg;

import VisitorPkg.Visitor;

public class Unless extends Stmt {

  public StmtList slist;
  public Expr cond;

  public Unless(StmtList aslist, Expr ac){
    slist = aslist;
    cond = ac;
  }

  public void accept(Visitor v){
    v.visit(this);
  }
}
