package AbstractSyntaxPkg;
import VisitorPkg.*;
import java.util.ArrayList;

public class GuardList {
  public ArrayList<GCommand> glist;

  public GuardList() {
    glist = new ArrayList<GCommand>();
  }

  public GuardList(GCommand e) {
    this();
    glist.add(e);
  }

  public void add(GCommand e){
    glist.add(e);
  }

  public GCommand get(int i){
    return glist.get(i);
  }

  public int size(){
    return glist.size();
  }
}
