package VisitorPkg;

import AbstractSyntaxPkg.*;
import ParsePkg.*;
import java.util.HashMap;
import java.util.ArrayList;
public class ExprEval implements ValueVisitor {
	
	HashMap<String, VarInfo> symTable;
	
	private final Integer trueInt = 1;
	private final Integer falseInt = 0;
	public ExprEval(HashMap<String, VarInfo> symTable){
		this.symTable = symTable;
	}

  	public Object visit(Program n){
		return null;
	}
	public Object visit(VarDecl n){
		return null;
	}
  	public Object visit(FunDef n){
		return null;
	}
  	public Object visit(GCommand n){
		return null;
	}
  	public Object visit(IntType n){
		return null;
	}
  	public Object visit(BoolType n){
		return null;
	}
  	public Object visit(IntArrayType n){
		return null;
	}
  	public Object visit(BoolArrayType n){
		return null;
	}
  	public Object visit(CompoundStmt n){
		return null;
	}
  	public Object visit(Assign n){
		return null;
	}
  	public Object visit(If n){
		return null;
	}
  	public Object visit(IfThen n){
		return null;
	}
  	public Object visit(Do n){
		return null;
	}
  	public Object visit(Skip n){
		return null;
	}
  	public Object visit(Display n){
		return null;
	}
  	public Object visit(FunCallStmt n){
		return null;
	}
  	public Object visit(Plus n){
		return (Integer)((Integer)(n.e1.accept(this)) + (Integer)(n.e2.accept(this)));
	}
  	public Object visit(Minus n){
		return (Integer)((Integer)(n.e1.accept(this)) - (Integer)(n.e2.accept(this)));
	}
  	public Object visit(Times n){
		return (Integer)((Integer)(n.e1.accept(this)) * (Integer)(n.e2.accept(this)));
	}
  	public Object visit(Div n){
		Integer num = (Integer)n.e2.accept(this);
		if(num.equals(new Integer(0))){
			System.out.println("DIVIDE BY ZERO");
			System.out.println("SHUTTING DOWN EDSGER");
			System.exit(0);
		}
		return (Integer)((Integer)(n.e1.accept(this)) / num);
	}
  	public Object visit(Neg n){
		return -1*(Integer)(n.e.accept(this));
	}
  	public Object visit(Num n){
		return (Integer) n.value;
	}
  	public Object visit(Equal n){
		return (Boolean)((Integer)n.e1.accept(this) == (Integer)n.e2.accept(this));
	}
  	public Object visit(NotEqual n){
		return (Boolean)((Integer)n.e1.accept(this) != (Integer)n.e2.accept(this));
	}
  	public Object visit(LessThan n){
		return (Boolean)((Integer)n.e1.accept(this) < (Integer)n.e2.accept(this));
	}
  	public Object visit(LessEqual n){
		return (Boolean)((Integer)n.e1.accept(this) <= (Integer)n.e2.accept(this));
	}
  	public Object visit(GreaterThan n){
		return (Boolean)((Integer)n.e1.accept(this) > (Integer)n.e2.accept(this));
	}
  	public Object visit(GreaterEqual n){
		return (Boolean)((Integer)n.e1.accept(this) >= (Integer)n.e2.accept(this));
	}
  	public Object visit(Not n){
		return (Boolean)(!(Boolean)n.g.accept(this));
	}
  	public Object visit(And n){
		return (Boolean)((Boolean)n.g1.accept(this) && (Boolean)n.g2.accept(this));
	}
  	public Object visit(Or n){
		return (Boolean)((Boolean)n.g1.accept(this) || (Boolean)n.g2.accept(this));
	}
  	public Object visit(True n){
		return (Boolean)true;
	}
  	public Object visit(False n){
		return (Boolean)false;
	}
  	public Object visit(Id n){
		Object v = symTable.get(n.name).value;
		if(v == null){
		    System.out.println("Uninitialized variable: " + n.name);
		    System.out.println("Closing Edsger");
		    System.exit(0);
		}
		return v;
	}
  	public Object visit(ArrayElt n){
		int buffer;
		if(symTable.get(n.name).type instanceof IntArrayType)
			buffer = ((IntArrayType)symTable.get(n.name).type).begin;
		else
			buffer = ((BoolArrayType)symTable.get(n.name).type).begin;
//		Object v = ((ArrayList<Object>)symTable.get(n.name).value).get((Integer)n.index.accept(this));
		Object v = ((ArrayList<Object>)symTable.get(n.name).value).get((Integer)n.index.accept(this)-buffer);
		if(v == null){
			System.out.println("Uninitialized variable: " + n.name);
			System.out.println("Closing Edsger");
			System.exit(0);
		}
		return v;
	}
  	public Object visit(FunCallExpr n){
		return null;
	}

	public String toString(){
		return "I am still here";
	}
}
