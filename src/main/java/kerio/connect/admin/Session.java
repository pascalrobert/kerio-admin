package kerio.connect.admin;

import kerio.connect.admin.users.User.UserRight;


public class Session {
  
  public Session() {
  }
  
  public static class AdminInfo {

    String               id;                  ///< ID of logged user
    String               domainId;            ///< ID of domain where user belongs to
    String                     loginName;           ///< loginName name
    String                     fullName;            ///< full name
    UserRight                  effectiveRole;
    
    public AdminInfo() {
      
    }

    public String getId() {
      return id;
    }

    public void setId(String id) {
      this.id = id;
    }

    public String getDomainId() {
      return domainId;
    }

    public void setDomainId(String domainId) {
      this.domainId = domainId;
    }

    public String getLoginName() {
      return loginName;
    }

    public void setLoginName(String loginName) {
      this.loginName = loginName;
    }

    public String getFullName() {
      return fullName;
    }

    public void setFullName(String fullName) {
      this.fullName = fullName;
    }

    public UserRight getEffectiveRole() {
      return effectiveRole;
    }

    public void setEffectiveRole(UserRight effectiveRole) {
      this.effectiveRole = effectiveRole;
    }
  }

}
