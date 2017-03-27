package AbstractSyntaxPkg;
import VisitorPkg.*;

public class FunDef {
  public DeclList outargs;
  public String name;
  public DeclList inargs;
  public DeclList locals;
  public StmtList body;

  public FunDef( DeclList aoutargs, String aname, DeclList ainargs, DeclList alocals, StmtList abody) {
    outargs = aoutargs;
    name = aname;
    inargs = ainargs;
    locals = alocals;
    body = abody;
  }

  public void accept(Visitor v) {
    v.visit(this);
  }

  public Object accept(ValueVisitor v) {
    return v.visit(this);
  }
}
