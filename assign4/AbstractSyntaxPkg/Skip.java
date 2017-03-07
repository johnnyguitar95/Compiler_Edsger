package AbstractSyntaxPkg;
import VisitorPkg.*;

public class Skip extends Stmt {

  public Skip() {
  }

  public void accept(Visitor v) {
    v.visit(this);
  }

  public Object accept(ValueVisitor v) {
    return v.visit(this);
  }
}
