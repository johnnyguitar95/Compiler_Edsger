package AbstractSyntaxPkg;
import VisitorPkg.*;

public class Not extends Expr {
  public Expr g;

  public Not( Expr ag) {
    g = ag;
  }

  public void accept(Visitor v) {
    v.visit(this);
  }

  public Object accept(ValueVisitor v) {
    return v.visit(this);
  }
}
