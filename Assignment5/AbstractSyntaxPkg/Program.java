package AbstractSyntaxPkg;
import VisitorPkg.*;

public class Program {
  public DeclList globals;
  public FunList funs;
  public StmtList body;

  public Program( DeclList aglobals, FunList afuns, StmtList abody) {
    globals = aglobals;
    funs = afuns;
    body = abody;
  }

  public void accept(Visitor v) {
    v.visit(this);
  }

  public Object accept(ValueVisitor v) {
    return v.visit(this);
  }
}
