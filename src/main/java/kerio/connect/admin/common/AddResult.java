package kerio.connect.admin.common;

public class AddResult {

  String id;                       ///< purposely not id - loginName is shown
  boolean  success;             ///< was operation successful? if yes so id is new id for this item else errorMessage tells why it failed
  LocalizableMessage errorMessage; ///< contains number of recovered user messages or error message
  
  public AddResult() {
    
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public boolean isIsSuccess() {
    return success;
  }

  public void setIsSuccess(boolean success) {
    this.success = success;
  }

  public LocalizableMessage getErrorMessage() {
    return errorMessage;
  }

  public void setErrorMessage(LocalizableMessage errorMessage) {
    this.errorMessage = errorMessage;
  }

}
