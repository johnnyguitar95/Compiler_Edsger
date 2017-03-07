package AbstractSyntaxPkg;
import VisitorPkg.*;

public class False extends Guard {

  public False() {
  }

  public void accept(Visitor v) {
    v.visit(this);
  }

  public Object accept(ValueVisitor v) {
    return v.visit(this);
  }
}
