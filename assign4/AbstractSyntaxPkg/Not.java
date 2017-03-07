package AbstractSyntaxPkg;
import VisitorPkg.*;

public class Not extends Guard {
  public Guard g;

  public Not( Guard ag) {
    g = ag;
  }

  public void accept(Visitor v) {
    v.visit(this);
  }

  public Object accept(ValueVisitor v) {
    return v.visit(this);
  }
}
