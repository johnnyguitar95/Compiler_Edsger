package AbstractSyntaxPkg;
import VisitorPkg.*;
import java.util.ArrayList;

public class DestList {
  public ArrayList<Expr> dlist;

  public DestList() {
    dlist = new ArrayList<Expr>();
  }

  public DestList(Expr e) {
    this();
    dlist.add(e);
  }

  public void add(Expr e){
    dlist.add(e);
  }

  public Expr get(int i){
    return dlist.get(i);
  }

  public int size(){
    return dlist.size();
  }
}
