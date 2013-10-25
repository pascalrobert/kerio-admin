package kerio.connect.admin.common;


public class DistanceOrNull {

  DistanceType   type;
  Distance    timeSpan;

  public DistanceOrNull() {
    
  }
  
  public DistanceType getType() {
    return type;
  }

  public void setType(DistanceType type) {
    this.type = type;
  }

  public Distance getTimeSpan() {
    return timeSpan;
  }

  public void setTimeSpan(Distance timeSpan) {
    this.timeSpan = timeSpan;
  }

  enum DistanceType {
    dtNull,
    dtTimeSpan
  }
  
}
