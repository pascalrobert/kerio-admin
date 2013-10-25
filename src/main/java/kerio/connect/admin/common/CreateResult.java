package kerio.connect.admin.common;

public class CreateResult {
  long inputIndex;    ///< 0-based index to input array, e.g. 3 means that the relates to the 4th element of the input parameter array
  String  id;
  
  public CreateResult() {
    
  }

  public long getInputIndex() {
    return inputIndex;
  }

  public void setInputIndex(long inputIndex) {
    this.inputIndex = inputIndex;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }
  
}
