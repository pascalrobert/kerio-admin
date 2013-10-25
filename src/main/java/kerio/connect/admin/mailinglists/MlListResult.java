package kerio.connect.admin.mailinglists;

import java.util.ArrayList;


public class MlListResult {

  ArrayList<Ml> list;
  long totalItems;
  
  public MlListResult() {
    
  }

  public ArrayList<Ml> getList() {
    return list;
  }

  public void setList(ArrayList<Ml> list) {
    this.list = list;
  }

  public long getTotalItems() {
    return totalItems;
  }

  public void setTotalItems(long totalItems) {
    this.totalItems = totalItems;
  }
}
