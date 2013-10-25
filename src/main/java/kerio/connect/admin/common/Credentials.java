package kerio.connect.admin.common;

public class Credentials {

  String userName;     ///< UserName
  String password;     ///< Password
  
  public Credentials() {
    
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
