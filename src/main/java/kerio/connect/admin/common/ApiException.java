package kerio.connect.admin.common;

public class ApiException extends Exception {

  String message;         ///< text with placeholders %1, %2
  long code;              ///< -32767..-1 (JSON-RPC) or 1..32767 (application)
  LocalizableMessageParameters messageParameters;
  
  public ApiException(String message, long code, LocalizableMessageParameters messageParameters) {
    super(message);
    this.code = code;
    this.messageParameters = messageParameters;
  }

  public String getMessage() {
    return message;
  }

  public long getCode() {
    return code;
  }

  public LocalizableMessageParameters getMessageParameters() {
    return messageParameters;
  }

}
