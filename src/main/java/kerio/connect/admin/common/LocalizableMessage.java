package kerio.connect.admin.common;

import java.util.ArrayList;

public class LocalizableMessage {

  String message;                    ///< text with placeholders %1, %2, etc., e.g. "User %1 cannot be deleted."
  ArrayList<String> positionalParameters; ///< additional strings to replace the placeholders in message (first string replaces %1 etc.)
  long plurality;
  
  public LocalizableMessage() {
    
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public ArrayList<String> getPositionalParameters() {
    return positionalParameters;
  }

  public void setPositionalParameters(ArrayList<String> positionalParameters) {
    this.positionalParameters = positionalParameters;
  }

  public long getPlurality() {
    return plurality;
  }

  public void setPlurality(long plurality) {
    this.plurality = plurality;
  }

}
