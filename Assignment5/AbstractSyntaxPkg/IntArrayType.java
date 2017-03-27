package AbstractSyntaxPkg;
import VisitorPkg.*;

public class IntArrayType extends Type {
  public int begin;
  public int end;

  public IntArrayType( int abegin, int aend) {
    begin = abegin;
    end = aend;
  }

  public void accept(Visitor v) {
    v.visit(this);
  }

  public Object accept(ValueVisitor v) {
    return v.visit(this);
  }
}
