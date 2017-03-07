package AbstractSyntaxPkg;

import java.util.ArrayList;

public class DestList {
  public ArrayList<Guard> dlist;

  public DestList() {
  	  dlist = new ArrayList<Guard>();
    }

    public DestList(Guard e) {
      this();
      dlist.add(e);
    }

     public void add(Guard e){
       dlist.add(e);
     }

     public Guard get(int i){
       return dlist.get(i);
     }

     public int size(){
       return dlist.size();
    }

}
