package kerio.connect.admin.delivery;

public class InternetSettings {

  InternetConnection   type;             ///< type of Internet settings connection
  String            rasLine;          ///< name of RAS line
  boolean           useSystemCredentials;   ///< use username and password defined in system
  String            rasUser;          ///< RAS username
  String            rasPassword;         ///< write only; password to RAS
  boolean           dialOnHigh;          ///< enable dial-up on high priority message
  
  public InternetSettings() {
    
  }

  public InternetConnection getType() {
    return type;
  }

  public void setType(InternetConnection type) {
    this.type = type;
  }

  public String getRasLine() {
    return rasLine;
  }

  public void setRasLine(String rasLine) {
    this.rasLine = rasLine;
  }

  public boolean isUseSystemCredentials() {
    return useSystemCredentials;
  }

  public void setUseSystemCredentials(boolean useSystemCredentials) {
    this.useSystemCredentials = useSystemCredentials;
  }

  public String getRasUser() {
    return rasUser;
  }

  public void setRasUser(String rasUser) {
    this.rasUser = rasUser;
  }

  public String getRasPassword() {
    return rasPassword;
  }

  public void setRasPassword(String rasPassword) {
    this.rasPassword = rasPassword;
  }

  public boolean isDialOnHigh() {
    return dialOnHigh;
  }

  public void setDialOnHigh(boolean dialOnHigh) {
    this.dialOnHigh = dialOnHigh;
  }

  public enum InternetConnection {
    Permanent,        ///< permanent Internet connection
    Triggered,        ///< connection is established by scheduler
    TriggeredOnRas    ///< Remote Access Service - Windows only option
  }

}
