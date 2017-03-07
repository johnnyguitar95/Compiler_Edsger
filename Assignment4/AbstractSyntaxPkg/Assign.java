package AbstractSyntaxPkg;
import VisitorPkg.*;

public class Assign extends Stmt {
  public DestList dlist;
  public ExprList elist;

  public Assign( DestList adlist, ExprList aelist) {
    dlist = adlist;
    elist = aelist;
  }

  public void accept(Visitor v) {
    v.visit(this);
  }

  public Object accept(ValueVisitor v) {
    return v.visit(this);
  }
}
