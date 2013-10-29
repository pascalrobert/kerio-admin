package kerio.connect.admin.delivery;

public class EtrnDownload {

  String   id;
  boolean        isActive;
  String         server;              ///< server URL
  String         domains;          ///< semicolon separated list of domain names
  String         description;
  boolean        requireAuthentication;  ///< Is authentication required?
  String         userName;            ///< make sense only if authentication is required
  String         password;            ///< make sense only if authentication is required
  
  public EtrnDownload() {
    
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public boolean isIsActive() {
    return isActive;
  }

  public void setIsActive(boolean isActive) {
    this.isActive = isActive;
  }

  public String getServer() {
    return server;
  }

  public void setServer(String server) {
    this.server = server;
  }

  public String getDomains() {
    return domains;
  }

  public void setDomains(String domains) {
    this.domains = domains;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public boolean isRequireAuthentication() {
    return requireAuthentication;
  }

  public void setRequireAuthentication(boolean requireAuthentication) {
    this.requireAuthentication = requireAuthentication;
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
