package AbstractSyntaxPkg;
import VisitorPkg.*;
import java.util.ArrayList;

public class FunList {
  public ArrayList<FunDef> flist;

  public FunList() {
    flist = new ArrayList<FunDef>();
  }

  public FunList(FunDef e) {
    this();
    flist.add(e);
  }

  public void add(FunDef e){
    flist.add(e);
  }

  public FunDef get(int i){
    return flist.get(i);
  }

  public int size(){
    return flist.size();
  }
}
