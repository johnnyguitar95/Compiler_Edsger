package AbstractSyntaxPkg;
import VisitorPkg.*;

public class Unless extends Stmt {
  public StmtList slist;
  public Expr cond;

  public Unless( StmtList aslist, Expr acond) {
    slist = aslist;
    cond = acond;
  }

  public void accept(Visitor v) {
    v.visit(this);
  }

  public Object accept(ValueVisitor v) {
    return v.visit(this);
  }
}
