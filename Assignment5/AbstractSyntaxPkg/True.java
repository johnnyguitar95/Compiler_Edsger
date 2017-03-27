package AbstractSyntaxPkg;
import VisitorPkg.*;

public class True extends Expr {

  public True() {
  }

  public void accept(Visitor v) {
    v.visit(this);
  }

  public Object accept(ValueVisitor v) {
    return v.visit(this);
  }
}
