package kerio.connect.admin.certificates;

import java.util.ArrayList;

public class CertificateListResult {

  private ArrayList<Certificate> list;
  private long totalItems;
  
  public CertificateListResult() {
    
  }
  
  public ArrayList<Certificate> getList() {
    return list;
  }

  public void setList(ArrayList<Certificate> list) {
    this.list = list;
  }

  public long getTotalItems() {
    return totalItems;
  }

  public void setTotalItems(long totalItems) {
    this.totalItems = totalItems;
  }
  
}
