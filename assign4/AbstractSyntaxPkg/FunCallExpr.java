package AbstractSyntaxPkg;
import VisitorPkg.*;

public class FunCallExpr extends Guard {
  public String name;
  public ExprList elist;

  public FunCallExpr( String aname, ExprList aelist) {
    name = aname;
    elist = aelist;
  }

  public void accept(Visitor v) {
    v.visit(this);
  }

  public Object accept(ValueVisitor v) {
    return v.visit(this);
  }
}
