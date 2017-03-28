package VisitorPkg;

import AbstractSyntaxPkg.*;
import ParsePkg.*;
import java.util.HashMap;
import java.util.ArrayList;
public class Interp implements Visitor
{
	HashMap<String, VarInfo> symTable = new HashMap<String, VarInfo>();
	ValueVisitor eval = new ExprEval(symTable);

	public void visit(Program n){
	    for(int x = 0; x<n.globals.vlist.size(); x++){
		n.globals.vlist.get(x).accept(this);
	    }
	    
	    for(int i = 0; i<n.body.size(); i++){
		    n.body.get(i).accept(this);
	    }


	    System.out.println("Fin");	
	}

  	public void visit(VarDecl n){
	    if(n.type instanceof IntType || n.type instanceof BoolType)
	    {	//System.out.println("Adding new variable");
		    if(n.type instanceof IntType)
      		        symTable.put(n.name, new VarInfo(new IntType(), null));
		    if(n.type instanceof BoolType)
			symTable.put(n.name, new VarInfo(new BoolType(), null));
	    }
	    //System.out.println("Added: " + n.name);
	    
	}

	//not necessary
  	public void visit(FunDef n){}
  	
	public void visit(GCommand n){}
  	
	//not necessary - yet?
	public void visit(IntType n){}
  	public void visit(BoolType n){}
  	public void visit(IntArrayType n){}
  	public void visit(BoolArrayType n){}
  	
	public void visit(CompoundStmt n){
	    //System.out.println("COMPOUND");
	    n.stmt.accept(this);
	    if(n.rest != null)
	        n.rest.accept(this);
	}
  	public void visit(Assign n){

	    VarInfo temp[] = new VarInfo[n.elist.elist.size()];
	    for(int x = 0; x < temp.length; x++){
		Object v = n.elist.elist.get(x).accept(eval);
		if(v instanceof Integer)
		    temp[x] = new VarInfo(new IntType(), v);
		else if(v instanceof Boolean)
		    temp[x] = new VarInfo(new BoolType(), v);
	    }
	    for(int x = 0; x < temp.length; x++){
	        symTable.put(((Id) n.dlist.dlist.get(x)).name, temp[x]);
	}}
  	public void visit(If n){
	    for(int x = 0; x<n.glist.size(); x++){
		if((Boolean)n.glist.get(x).cond.accept(eval)){
		    n.glist.get(x).stmt.accept(this);
		    break;
		}
	        if(x == (n.glist.size()-1)){
		    System.out.println("INVALID IF");
		    System.exit(0);
		}
	    }
	}
  	public void visit(IfThen n){
	    if((Boolean)n.cond.accept(eval))
		    n.stmt.accept(this);
	}
  	public void visit(Do n){
	    //System.out.println("DO");
	    //System.out.println("Glist size: " + n.glist.size());
	    for(int i = 0; i<n.glist.size(); i++){
	    	if((Boolean)n.glist.get(i).cond.accept(eval)){
			//System.out.println("Success");
			n.glist.get(i).stmt.accept(this);
			i = -1;
			//System.out.println("Start from the top again");
		}
	     }
	}
  	public void visit(Skip n){}
  	
	public void visit(Display n){
	    for(int x = 0; x < n.elist.size(); x++){
		if( x > 0)
		    System.out.print(",");
		System.out.print(n.elist.get(x).accept(eval));
	    }
	    System.out.println();
	}

  	//Not necessary
	public void visit(FunCallStmt n){}
  	public void visit(Plus n){}
  	public void visit(Minus n){}
  	public void visit(Times n){}
  	public void visit(Div n){}
  	public void visit(Neg n){}
  	public void visit(Num n){}
  	public void visit(Equal n){}
  	public void visit(NotEqual n){}
  	public void visit(LessThan n){}
  	public void visit(LessEqual n){}
  	public void visit(GreaterThan n){}
  	public void visit(GreaterEqual n){}
  	public void visit(Not n){}
  	public void visit(And n){}
  	public void visit(Or n){}
  	public void visit(True n){}
  	public void visit(False n){}
  	public void visit(Id n){}
  	public void visit(ArrayElt n){}
  	public void visit(FunCallExpr n){}

}
