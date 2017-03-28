package AbstractSyntaxPkg;
import VisitorPkg.*;

public class Output extends Stmt {
  public ExprList elist;

  public Output( ExprList aelist) {
    elist = aelist;
  }

  public void accept(Visitor v) {
    v.visit(this);
  }

  public Object accept(ValueVisitor v) {
    return v.visit(this);
  }
}
