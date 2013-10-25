package kerio.connect.admin.settings;

public class SignOn {

  boolean isEnabled;
  String hostName;     ///< Hostname to the Kerio Unity Sign On server. Non default port can be added Eg: example.com:4444
  String userName;     ///< Administrator username
  String password;     ///< [WRITE-ONLY] Administrator password
  
  public SignOn() {
    
  }

  public boolean isIsEnabled() {
    return isEnabled;
  }

  public void setIsEnabled(boolean isEnabled) {
    this.isEnabled = isEnabled;
  }

  public String getHostName() {
    return hostName;
  }

  public void setHostName(String hostName) {
    this.hostName = hostName;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
  
}
