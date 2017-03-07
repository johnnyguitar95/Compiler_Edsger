package AbstractSyntaxPkg;
import VisitorPkg.*;

public class BoolType extends Type {

  public BoolType() {
  }

  public void accept(Visitor v) {
    v.visit(this);
  }

  public Object accept(ValueVisitor v) {
    return v.visit(this);
  }
}
