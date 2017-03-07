package AbstractSyntaxPkg;
import VisitorPkg.*;

public class Num extends Expr {
  public int value;

  public Num( int avalue) {
    value = avalue;
  }

  public void accept(Visitor v) {
    v.visit(this);
  }

  public Object accept(ValueVisitor v) {
    return v.visit(this);
  }
}
