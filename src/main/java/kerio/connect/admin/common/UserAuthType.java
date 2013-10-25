package kerio.connect.admin.common;

public enum UserAuthType {

  /**
   * Internal authorization
   */
  UInternalAuth,
  /**
   * Windows NT domain authorization
   */
  UWindowsNTAuth,
  /**
   * Authorization for linux
   */
  UPamAuth,
  /**
   * Kerberos authorization
   */
  UKerberosAuth,
  /**
   * Apple authorization
   */
  UAppleAuth,
  /**
   * LDAP authorization
   */
  ULDAPAuth

}
