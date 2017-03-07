package AbstractSyntaxPkg;
import VisitorPkg.*;

public class GExpr extends Expr {

  public GExpr() {
  }

  public void accept(Visitor v) {
    v.visit(this);
  }

  public Object accept(ValueVisitor v) {
    return v.visit(this);
  }
}
