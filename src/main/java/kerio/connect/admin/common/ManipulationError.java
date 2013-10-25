package kerio.connect.admin.common;

public class ManipulationError {

  String               id;         ///< entity KId, can be user, group, alias, ML...
  LocalizableMessage   errorMessage;
 
  public ManipulationError() {
    
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public LocalizableMessage getErrorMessage() {
    return errorMessage;
  }

  public void setErrorMessage(LocalizableMessage errorMessage) {
    this.errorMessage = errorMessage;
  }

}
