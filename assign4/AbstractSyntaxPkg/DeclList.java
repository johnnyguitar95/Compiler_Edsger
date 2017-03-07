package AbstractSyntaxPkg;

import java.util.ArrayList;

public class DeclList {
  public ArrayList<VarDecl> vlist;

  public DeclList() {
  	  vlist = new ArrayList<VarDecl>();
    }

    public DeclList(VarDecl e) {
      this();
      vlist.add(e);
    }

     public void add(VarDecl e){
       vlist.add(e);
     }

     public VarDecl get(int i){
       return vlist.get(i);
     }

     public int size(){
       return vlist.size();
  }
}
