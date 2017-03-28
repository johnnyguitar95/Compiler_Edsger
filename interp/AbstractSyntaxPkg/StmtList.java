package AbstractSyntaxPkg;
import VisitorPkg.*;
import java.util.ArrayList;

public class StmtList {
  public ArrayList<Stmt> stmts;

  public StmtList() {
    stmts = new ArrayList<Stmt>();
  }

  public StmtList(Stmt e) {
    this();
    stmts.add(e);
  }

  public void add(Stmt e){
    stmts.add(e);
  }

  public Stmt get(int i){
    return stmts.get(i);
  }

  public int size(){
    return stmts.size();
  }
}
