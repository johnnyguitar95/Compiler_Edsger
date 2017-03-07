package AbstractSyntaxPkg;
import VisitorPkg.*;
import java.util.ArrayList;

public class StmtList {
  public ArrayList<Stmt> slist;

  public StmtList() {
    slist = new ArrayList<Stmt>();
  }

  public StmtList(Stmt e) {
    this();
    slist.add(e);
  }

  public void add(Stmt e){
    slist.add(e);
  }

  public Stmt get(int i){
    return slist.get(i);
  }

  public int size(){
    return slist.size();
  }
}
