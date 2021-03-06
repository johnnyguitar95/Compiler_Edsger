package AbstractSyntaxPkg;
import VisitorPkg.*;

public class GreaterEqual extends Guard {
  public Expr e1;
  public Expr e2;

  public GreaterEqual( Expr ae1, Expr ae2) {
    e1 = ae1;
    e2 = ae2;
  }

  public void accept(Visitor v) {
    v.visit(this);
  }

  public Object accept(ValueVisitor v) {
    return v.visit(this);
  }
}
