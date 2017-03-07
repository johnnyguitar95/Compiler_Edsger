package AbstractSyntaxPkg;
import VisitorPkg.*;

public class If extends Stmt {
  public GuardList glist;

  public If( GuardList aglist) {
    glist = aglist;
  }

  public void accept(Visitor v) {
    v.visit(this);
  }

  public Object accept(ValueVisitor v) {
    return v.visit(this);
  }
}
