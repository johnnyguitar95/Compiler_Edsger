package AbstractSyntaxPkg;
import VisitorPkg.*;

public class IntType extends Type {

  public IntType() {
  }

  public void accept(Visitor v) {
    v.visit(this);
  }

  public Object accept(ValueVisitor v) {
    return v.visit(this);
  }
}
