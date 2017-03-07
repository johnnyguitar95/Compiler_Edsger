package AbstractSyntaxPkg;
import VisitorPkg.*;

public class Or extends Guard {
  public Guard g1;
  public Guard g2;

  public Or( Guard ag1, Guard ag2) {
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
