package AbstractSyntaxPkg;
import VisitorPkg.*;

public class Assign extends Stmt {
  public String idname;
  public Expr e;

  public Assign( String aidname, Expr ae) {
    idname = aidname;
    e = ae;
  }

  public void accept(Visitor v) {
    v.visit(this);
  }

  public Object accept(ValueVisitor v) {
    return v.visit(this);
  }
}
