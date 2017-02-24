package AbstractSyntaxPkg;

import java.util.ArrayList;

public class ExprList{
  ArrayList exprs;

  public ExprList() {
    exprs = new ArrayList();
  }

  public ExprList(Expr e) {
    exprs = new ArrayList();
    exprs.add(e);
  }

  public void add(Expr e){
    exprs.add(e);
  }

  public Expr get(int i){
    return (Expr)(exprs.get(i));
  }

  public int size(){
    return exprs.size();
  }
}
