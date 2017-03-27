package AbstractSyntaxPkg;
import VisitorPkg.*;

public class ArrayElt extends Expr {
  public String name;
  public Expr index;

  public ArrayElt( String aname, Expr aindex) {
    name = aname;
    index = aindex;
  }

  public void accept(Visitor v) {
    v.visit(this);
  }

  public Object accept(ValueVisitor v) {
    return v.visit(this);
  }
}
