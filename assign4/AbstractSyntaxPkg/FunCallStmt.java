package AbstractSyntaxPkg;
import VisitorPkg.*;

public class FunCallStmt extends Stmt {
  public String name;
  public ExprList elist;

  public FunCallStmt( String aname, ExprList aelist) {
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
