package kerio.connect.admin.mailinglists;

import java.util.ArrayList;

import kerio.connect.admin.mailinglists.Ml.UserOrEmail;

public class MlUserListResult {

  ArrayList<UserOrEmail> list;
  long totalItems;
  
  public MlUserListResult() {
    
  }

  public ArrayList<UserOrEmail> getList() {
    return list;
  }

  public void setList(ArrayList<UserOrEmail> list) {
    this.list = list;
  }

  public long getTotalItems() {
    return totalItems;
  }

  public void setTotalItems(long totalItems) {
    this.totalItems = totalItems;
  }
  
}
