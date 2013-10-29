package kerio.connect.admin.domains;

import kerio.connect.admin.domains.Domain.DirectoryAuthentication;
import kerio.connect.admin.domains.Domain.DirectoryServiceType;

public class DirectoryServiceConfiguration {

  DirectoryServiceType serviceType;   ///< type of the service
  DirectoryAuthentication authentication;   ///< authentication information
  String               directoryName; ///< Active Directory only: Directory name
  String               ldapSuffix;    ///< Apple Directory, Kerio Directory: LDAP Search Suffix  
  
  public DirectoryServiceConfiguration() {
    
  }

  public DirectoryServiceType getServiceType() {
    return serviceType;
  }

  public void setServiceType(DirectoryServiceType serviceType) {
    this.serviceType = serviceType;
  }

  public DirectoryAuthentication getAuthentication() {
    return authentication;
  }

  public void setAuthentication(DirectoryAuthentication authentication) {
    this.authentication = authentication;
  }

  public String getDirectoryName() {
    return directoryName;
  }

  public void setDirectoryName(String directoryName) {
    this.directoryName = directoryName;
  }

  public String getLdapSuffix() {
    return ldapSuffix;
  }

  public void setLdapSuffix(String ldapSuffix) {
    this.ldapSuffix = ldapSuffix;
  }

}
