package kerio.connect.admin.common;


public class Error {

  long                         inputIndex;        ///< 0-based index to input array, e.g. 3 means that the relates to the 4th element of the input parameter array
  long                         code;              ///< -32767..-1 (JSON-RPC) or 1..32767 (application)
  String                       message;           ///< text with placeholders %1, %2, etc., e.g. "User %1 cannot be deleted."
  LocalizableMessageParameters messageParameters;
  
  public Error() {
    
  }

  public long getInputIndex() {
    return inputIndex;
  }

  public void setInputIndex(long inputIndex) {
    this.inputIndex = inputIndex;
  }

  public long getCode() {
    return code;
  }

  public void setCode(long code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public LocalizableMessageParameters getMessageParameters() {
    return messageParameters;
  }

  public void setMessageParameters(LocalizableMessageParameters messageParameters) {
    this.messageParameters = messageParameters;
  }

}
