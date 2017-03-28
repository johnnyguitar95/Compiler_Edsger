package AbstractSyntaxPkg;
import VisitorPkg.*;

public class Display extends Stmt {
  public ExprList elist;

  public Display( ExprList aelist) {
    elist = aelist;
  }

  public void accept(Visitor v) {
	v.visit(this);
  }

  public Object accept(ValueVisitor v) {
    return v.visit(this);
  }
}
