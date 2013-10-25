package kerio.connect.admin.domains;

public class DomainSetting {

  String   hostname;            ///< internet hostname - how this machine introduces itself in SMTP,POP3...
  boolean  publicFoldersPerDomain; ///< true=public folders are unique per each domain / false=global for all domains
  String serverId;     ///< id of server primary used in cluster
  
  public DomainSetting() {
    
  }

  public String getHostname() {
    return hostname;
  }

  public void setHostname(String hostname) {
    this.hostname = hostname;
  }

  public boolean isPublicFoldersPerDomain() {
    return publicFoldersPerDomain;
  }

  public void setPublicFoldersPerDomain(boolean publicFoldersPerDomain) {
    this.publicFoldersPerDomain = publicFoldersPerDomain;
  }

  public String getServerId() {
    return serverId;
  }

  public void setServerId(String serverId) {
    this.serverId = serverId;
  }

}
