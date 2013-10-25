package kerio.connect.admin.common;

import java.util.ArrayList;

public class LocalizableMessageParameters {

  ArrayList<String> positionalParameters;  ///< additional strings to replace the placeholders in message (first string replaces %1 etc.)
  long       plurality;
  
  public LocalizableMessageParameters() {
    
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
