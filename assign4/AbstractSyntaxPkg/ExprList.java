package AbstractSyntaxPkg;

import java.util.ArrayList;

public class ExprList {
  public ArrayList<Expr> elist;

  public ExprList() {
	  elist = new ArrayList<Expr>();
  }

  public ExprList(Expr e) {
    this();
    elist.add(e);
  }

   public void add(Expr e){
     elist.add(e);
   }

   public Expr get(int i){
     return elist.get(i);
   }

   public int size(){
     return elist.size();
  }

}
