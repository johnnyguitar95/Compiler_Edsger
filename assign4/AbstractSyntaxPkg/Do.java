package AbstractSyntaxPkg;
import VisitorPkg.*;

public class Do extends Stmt {
  public GuardList glist;

  public Do( GuardList aglist) {
    glist = aglist;
  }

  public void accept(Visitor v) {
    v.visit(this);
  }

  public Object accept(ValueVisitor v) {
    return v.visit(this);
  }
}
