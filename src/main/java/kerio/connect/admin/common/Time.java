package kerio.connect.admin.common;

public class Time {

  long hour;  ///< 0-23
  long min;   ///< 0-59
  
  public Time() {
    
  }

  public long getHour() {
    return hour;
  }

  public void setHour(long hour) {
    this.hour = hour;
  }

  public long getMin() {
    return min;
  }

  public void setMin(long min) {
    this.min = min;
  }
  
}
