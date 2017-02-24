package AbstractSyntaxPkg;

import VisitorPkg.Visitor;

public class Id extends Expr {
  public String name;

  public Id(String n){
    name = n;
  }

  public void accept(Visitor v){
    v.visit(this);
  }
}
