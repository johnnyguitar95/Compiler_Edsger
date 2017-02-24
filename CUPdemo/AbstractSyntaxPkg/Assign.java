package AbstractSyntaxPkg;

import VisitorPkg.Visitor;

public class Assign extends Stmt {

  public String idname;
  public Expr e;

  public Assign(String aid, Expr ae){
    idname = aid;
    e = ae;
  }

  public void accept(Visitor v){
    v.visit(this);
  }
}
