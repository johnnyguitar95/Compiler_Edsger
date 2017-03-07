package AbstractSyntaxPkg;
import VisitorPkg.*;

public abstract class Stmt{

 public abstract void accept(Visitor v);

 public abstract Object accept(ValueVisitor v);

}

