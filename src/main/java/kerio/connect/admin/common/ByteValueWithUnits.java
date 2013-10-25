package kerio.connect.admin.common;

import kerio.connect.admin.common.enums.ByteUnits;

public class ByteValueWithUnits {

  long  value;
  ByteUnits   units;
  
  public ByteValueWithUnits() {
    
  }
  
  public long getValue() {
    return value;
  }
  
  public void setValue(long value) {
    this.value = value;
  }
  
  public ByteUnits getUnits() {
    return units;
  }
  
  public void setUnits(ByteUnits units) {
    this.units = units;
  }

}
