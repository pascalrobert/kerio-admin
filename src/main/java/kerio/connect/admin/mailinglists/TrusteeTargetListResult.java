package kerio.connect.admin.mailinglists;

import java.util.ArrayList;

import kerio.connect.admin.mailinglists.Ml.TrusteeTarget;

public class TrusteeTargetListResult {

  ArrayList<TrusteeTarget> list;
  long totalItems;
  
  public TrusteeTargetListResult() {
    
  }

  public ArrayList<TrusteeTarget> getList() {
    return list;
  }

  public void setList(ArrayList<TrusteeTarget> list) {
    this.list = list;
  }

  public long getTotalItems() {
    return totalItems;
  }

  public void setTotalItems(long totalItems) {
    this.totalItems = totalItems;
  }
}
