package AbstractSyntaxPkg;
import VisitorPkg.*;

public class GCommand {
  public Guard cond;
  public Stmt stmt;

  public GCommand( Guard acond, Stmt astmt) {
    cond = acond;
    stmt = astmt;
  }

  public void accept(Visitor v) {
    v.visit(this);
  }

  public Object accept(ValueVisitor v) {
    return v.visit(this);
  }
}
