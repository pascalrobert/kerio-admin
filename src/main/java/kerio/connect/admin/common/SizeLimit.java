package kerio.connect.admin.common;


public class SizeLimit {

  boolean   isActive;
  ByteValueWithUnits  limit;
  
  public SizeLimit() {
    
  }
  
  public boolean isActive() {
    return isActive;
  }
  public void setIsActive(boolean isActive) {
    this.isActive = isActive;
  }
  public ByteValueWithUnits getLimit() {
    return limit;
  }
  public void setLimit(ByteValueWithUnits limit) {
    this.limit = limit;
  }
  
}
