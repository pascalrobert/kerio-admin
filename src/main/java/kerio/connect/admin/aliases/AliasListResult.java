package kerio.connect.admin.aliases;

import java.util.ArrayList;

import kerio.connect.admin.aliases.Aliases.Alias;

public class AliasListResult {

  private ArrayList<Alias> list;
  private long totalItems;
  
  public AliasListResult() {
    
  }

  public ArrayList<Alias> getList() {
    return list;
  }

  public void setList(ArrayList<Alias> list) {
    this.list = list;
  }

  public long getTotalItems() {
    return totalItems;
  }

  public void setTotalItems(long totalItems) {
    this.totalItems = totalItems;
  }
  
}
