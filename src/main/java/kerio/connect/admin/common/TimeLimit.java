package kerio.connect.admin.common;

public class TimeLimit {

  long     value;      ///< how many
  TimeUnit units;
  
  public TimeLimit() {
    
  }

  public long getValue() {
    return value;
  }

  public void setValue(long value) {
    this.value = value;
  }

  public TimeUnit getUnits() {
    return units;
  }

  public void setUnits(TimeUnit units) {
    this.units = units;
  }

  public enum TimeUnit {
    Minutes,
    Hours,
    Days,
    Weeks
  }
}
