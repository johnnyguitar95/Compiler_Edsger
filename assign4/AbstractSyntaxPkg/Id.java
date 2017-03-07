package AbstractSyntaxPkg;
import VisitorPkg.*;

public class Id extends Guard {
  public String name;

  public Id( String aname) {
    name = aname;
  }

  public void accept(Visitor v) {
    v.visit(this);
  }

  public Object accept(ValueVisitor v) {
    return v.visit(this);
  }
}
