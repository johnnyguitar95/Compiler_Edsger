package AbstractSyntaxPkg;
import VisitorPkg.*;

public abstract class Expr{

 public abstract void accept(Visitor v);

 public abstract Object accept(ValueVisitor v);

}

