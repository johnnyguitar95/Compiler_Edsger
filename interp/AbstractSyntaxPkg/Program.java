package AbstractSyntaxPkg;
import VisitorPkg.*;

public class Program {
  public StmtList slist;

  public Program( StmtList aslist) {
    slist = aslist;
  }

  public void accept(Visitor v) {
    v.visit(this);
  }

  public Object accept(ValueVisitor v) {
    return v.visit(this);
  }
}
