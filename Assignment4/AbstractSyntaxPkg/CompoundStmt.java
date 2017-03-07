package AbstractSyntaxPkg;
import VisitorPkg.*;

public class CompoundStmt extends Stmt {
  public Stmt stmt;
  public CompoundStmt rest;

  public CompoundStmt( Stmt astmt, CompoundStmt arest) {
    stmt = astmt;
    rest = arest;
  }

  public void accept(Visitor v) {
    v.visit(this);
  }

  public Object accept(ValueVisitor v) {
    return v.visit(this);
  }
}
