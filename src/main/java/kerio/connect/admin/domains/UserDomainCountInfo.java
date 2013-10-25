package kerio.connect.admin.domains;

public class UserDomainCountInfo {

  long           currentUsers;     ///< number of created users on domain
  MaximumUsers      allowedUsers;     ///< number of allowed users, take stricter limit from max. number for domain, max. number by license
  
  public UserDomainCountInfo() {
    
  }

  public long getCurrentUsers() {
    return currentUsers;
  }

  public void setCurrentUsers(long currentUsers) {
    this.currentUsers = currentUsers;
  }

  public MaximumUsers getAllowedUsers() {
    return allowedUsers;
  }

  public void setAllowedUsers(MaximumUsers allowedUsers) {
    this.allowedUsers = allowedUsers;
  }

}
