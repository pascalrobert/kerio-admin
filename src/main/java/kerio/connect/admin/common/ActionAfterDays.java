package kerio.connect.admin.common;

public class ActionAfterDays {

  boolean   isEnabled; // is action on/off? 
  long  days; // after how many days is an action performed? 
  
  public ActionAfterDays() {
    
  }

  public boolean isIsEnabled() {
    return isEnabled;
  }

  public void setIsEnabled(boolean isEnabled) {
    this.isEnabled = isEnabled;
  }

  public long getDays() {
    return days;
  }

  public void setDays(long days) {
    this.days = days;
  }
  
}
