package AbstractSyntaxPkg;
import VisitorPkg.*;

public class And extends Expr {
  public Expr g1;
  public Expr g2;

  public And( Expr ag1, Expr ag2) {
    g1 = ag1;
    g2 = ag2;
  }

  public void accept(Visitor v) {
    v.visit(this);
  }

  public Object accept(ValueVisitor v) {
    return v.visit(this);
  }
}
