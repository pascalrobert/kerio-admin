package kerio.connect.admin.delivery;

public class Pop3Sorting {

  String   id;
  boolean        isActive;
  String         sortAddress;
  String         deliverTo;
  String         description;
  
  public Pop3Sorting() {
    
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public boolean isIsActive() {
    return isActive;
  }

  public void setIsActive(boolean isActive) {
    this.isActive = isActive;
  }

  public String getSortAddress() {
    return sortAddress;
  }

  public void setSortAddress(String sortAddress) {
    this.sortAddress = sortAddress;
  }

  public String getDeliverTo() {
    return deliverTo;
  }

  public void setDeliverTo(String deliverTo) {
    this.deliverTo = deliverTo;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

}
