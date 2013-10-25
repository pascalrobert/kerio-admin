package kerio.connect.admin.domains;

public class MaximumUsers {

  boolean        isUnlimited;      ///< is it a special case with no limit for users ?
  long        allowedUsers;     ///< number of allowed users (take minimum of server and domain limit)
  long            limit;           ///< max. user limit
  UserLimitType  limitType;

  public MaximumUsers() {
    
  }
  
  public boolean isIsUnlimited() {
    return isUnlimited;
  }

  public void setIsUnlimited(boolean isUnlimited) {
    this.isUnlimited = isUnlimited;
  }

  public long getAllowedUsers() {
    return allowedUsers;
  }

  public void setAllowedUsers(long allowedUsers) {
    this.allowedUsers = allowedUsers;
  }

  public long getLimit() {
    return limit;
  }

  public void setLimit(long limit) {
    this.limit = limit;
  }

  public UserLimitType getLimitType() {
    return limitType;
  }

  public void setLimitType(UserLimitType limitType) {
    this.limitType = limitType;
  }

  enum UserLimitType {
    DomainLimit,   ///< stricter limit for amount of users is on domain
    LicenseLimit   ///< stricter limit for amount of users is on license
  }
  
}
