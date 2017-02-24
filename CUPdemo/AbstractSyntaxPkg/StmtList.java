package AbstractSyntaxPkg;

import java.util.ArrayList;

public class StmtList{
  ArrayList stmts;

  public StmtList() {
    stmts = new ArrayList();
  }

  public StmtList(Stmt s) {
    stmts = new ArrayList();
    stmts.add(s);
  }

  public void add(Stmt e){
    stmts.add(e);
  }

  public Stmt get(int i){
    return (Stmt)(stmts.get(i));
  }

  public int size(){
    return stmts.size();
  }
}
