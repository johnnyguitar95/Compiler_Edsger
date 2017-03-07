package AbstractSyntaxPkg;
import VisitorPkg.*;

public class Neg extends Expr {
  public Expr e;

  public Neg( Expr ae) {
    e = ae;
  }

  public void accept(Visitor v) {
    v.visit(this);
  }

  public Object accept(ValueVisitor v) {
    return v.visit(this);
  }
}
