package AbstractSyntaxPkg;
import VisitorPkg.*;

public class VarDecl {
  public String name;
  public Type type;

  public VarDecl( String aname, Type atype) {
    name = aname;
    type = atype;
  }

  public void accept(Visitor v) {
    v.visit(this);
  }

  public Object accept(ValueVisitor v) {
    return v.visit(this);
  }
}
