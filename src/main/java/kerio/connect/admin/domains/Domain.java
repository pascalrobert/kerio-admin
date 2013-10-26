package kerio.connect.admin.domains;

import kerio.connect.admin.common.ActionAfterDays;
import kerio.connect.admin.common.OptionalString;
import kerio.connect.admin.common.SizeLimit;

public class Domain {

  String   id; // [READ-ONLY] global identification of domain 
  String  name; // [REQUIRED FOR CREATE] [WRITE-ONCE] name 
  String  description; // description 
  boolean   isPrimary; // is this domain primary? 
  long  userMaxCount; // maximum users per domain, 'unlimited' constant can be used 
  SizeLimit   outgoingMessageLimit; // outgoing message size limit ;
  ActionAfterDays   deletedItems; // clean Deleted Items folder (AC maximum: 24855) 
  ActionAfterDays   junkEmail; // clean Junk Email folder (AC maximum: 24855) 
  ActionAfterDays   sentItems; // clean Sent Items folder (AC maximum: 24855) 
  ActionAfterDays   autoDelete; // clean all folders (AC minimun:30, maximum: 24855) 
  ActionAfterDays   keepForRecovery; // keep deleted messages for recovery 
  String[]  aliasList; // list of domain alternative names 
  Forwarding  forwardingOptions; // forwarding settings 
  DirectoryService  service; // directory service configuration 
  Footer  domainFooter; // domain footer setting 
  String  kerberosRealm; // Kerberos Realm name. 
  String  winNtName; // Windows NT domain name - available on windows only. 
  String  pamRealm; // PAM Realm name - available on linux only. 
  OptionalString  ipAddressBind; // specific IP address bind 
  WebmailLogo   logo; // user defined logo 
  DomainRenameInfo  renameInfo; // [READ-ONLY] if domain was renamed, contain old and new domain name 
  boolean   isDistributed; // [READ-ONLY] if domain is distributed 

  public Domain() {

  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public boolean isIsPrimary() {
    return isPrimary;
  }

  public void setIsPrimary(boolean isPrimary) {
    this.isPrimary = isPrimary;
  }

  public long getUserMaxCount() {
    return userMaxCount;
  }

  public void setUserMaxCount(long userMaxCount) {
    this.userMaxCount = userMaxCount;
  }

  public SizeLimit getOutgoingMessageLimit() {
    return outgoingMessageLimit;
  }

  public void setOutgoingMessageLimit(SizeLimit outgoingMessageLimit) {
    this.outgoingMessageLimit = outgoingMessageLimit;
  }

  public ActionAfterDays getDeletedItems() {
    return deletedItems;
  }

  public void setDeletedItems(ActionAfterDays deletedItems) {
    this.deletedItems = deletedItems;
  }

  public ActionAfterDays getJunkEmail() {
    return junkEmail;
  }

  public void setJunkEmail(ActionAfterDays junkEmail) {
    this.junkEmail = junkEmail;
  }

  public ActionAfterDays getSentItems() {
    return sentItems;
  }

  public void setSentItems(ActionAfterDays sentItems) {
    this.sentItems = sentItems;
  }

  public ActionAfterDays getAutoDelete() {
    return autoDelete;
  }

  public void setAutoDelete(ActionAfterDays autoDelete) {
    this.autoDelete = autoDelete;
  }

  public ActionAfterDays getKeepForRecovery() {
    return keepForRecovery;
  }

  public void setKeepForRecovery(ActionAfterDays keepForRecovery) {
    this.keepForRecovery = keepForRecovery;
  }

  public String[] getAliasList() {
    return aliasList;
  }

  public void setAliasList(String[] aliasList) {
    this.aliasList = aliasList;
  }

  public Forwarding getForwardingOptions() {
    return forwardingOptions;
  }

  public void setForwardingOptions(Forwarding forwardingOptions) {
    this.forwardingOptions = forwardingOptions;
  }

  public DirectoryService getService() {
    return service;
  }

  public void setService(DirectoryService service) {
    this.service = service;
  }

  public Footer getDomainFooter() {
    return domainFooter;
  }

  public void setDomainFooter(Footer domainFooter) {
    this.domainFooter = domainFooter;
  }

  public String getKerberosRealm() {
    return kerberosRealm;
  }

  public void setKerberosRealm(String kerberosRealm) {
    this.kerberosRealm = kerberosRealm;
  }

  public String getWinNtName() {
    return winNtName;
  }

  public void setWinNtName(String winNtName) {
    this.winNtName = winNtName;
  }

  public String getPamRealm() {
    return pamRealm;
  }

  public void setPamRealm(String pamRealm) {
    this.pamRealm = pamRealm;
  }

  public OptionalString getIpAddressBind() {
    return ipAddressBind;
  }

  public void setIpAddressBind(OptionalString ipAddressBind) {
    this.ipAddressBind = ipAddressBind;
  }

  public WebmailLogo getLogo() {
    return logo;
  }

  public void setLogo(WebmailLogo logo) {
    this.logo = logo;
  }

  public DomainRenameInfo getRenameInfo() {
    return renameInfo;
  }

  public void setRenameInfo(DomainRenameInfo renameInfo) {
    this.renameInfo = renameInfo;
  }

  public boolean isIsDistributed() {
    return isDistributed;
  }

  public void setIsDistributed(boolean isDistributed) {
    this.isDistributed = isDistributed;
  }

  public static class DomainRenameInfo {

    boolean   isRenamed;
    String  oldName;
    String  newName;

    public DomainRenameInfo() {

    }

    public boolean isIsRenamed() {
      return isRenamed;
    }

    public void setIsRenamed(boolean isRenamed) {
      this.isRenamed = isRenamed;
    }

    public String getOldName() {
      return oldName;
    }

    public void setOldName(String oldName) {
      this.oldName = oldName;
    }

    public String getNewName() {
      return newName;
    }

    public void setNewName(String newName) {
      this.newName = newName;
    }

  }

  public static class WebmailLogo {

    boolean   isUsed;
    // has domain user defined logo? 
        String  url;
    // user defined logo URL 

    public WebmailLogo() {

    }

    public boolean isIsUsed() {
      return isUsed;
    }

    public void setIsUsed(boolean isUsed) {
      this.isUsed = isUsed;
    }

    public String getUrl() {
      return url;
    }

    public void setUrl(String url) {
      this.url = url;
    }
  }

  public static class Forwarding {

    boolean   isEnabled; // is forwarding enabled? 
    String  host; // hostname or IP address to forward 
    long  port; // host port 
    DeliveryType  how; // how to deliver 
    boolean   preventLoop; // do not deliver to domain alias (applicable when Domain.aliasList is not empty) 

    public Forwarding() {

    }

    public boolean isIsEnabled() {
      return isEnabled;
    }

    public void setIsEnabled(boolean isEnabled) {
      this.isEnabled = isEnabled;
    }

    public String getHost() {
      return host;
    }

    public void setHost(String host) {
      this.host = host;
    }

    public long getPort() {
      return port;
    }

    public void setPort(long port) {
      this.port = port;
    }

    public DeliveryType getHow() {
      return how;
    }

    public void setHow(DeliveryType how) {
      this.how = how;
    }

    public boolean isPreventLoop() {
      return preventLoop;
    }

    public void setPreventLoop(boolean preventLoop) {
      this.preventLoop = preventLoop;
    }

  }

  public static class Footer {

    boolean   isUsed; // is footer used 
    String  text; // text that will be appended to every message sent from this domain 
    boolean   isHtml; // if is value false the text is precessed as plaintext 
    boolean isUsedInDomain;

    public Footer() {

    }

    public boolean isIsUsed() {
      return isUsed;
    }

    public void setIsUsed(boolean isUsed) {
      this.isUsed = isUsed;
    }

    public String getText() {
      return text;
    }

    public void setText(String text) {
      this.text = text;
    }

    public boolean isIsHtml() {
      return isHtml;
    }

    public void seIstHtml(boolean isHtml) {
      this.isHtml = isHtml;
    }

    public boolean isIsUsedInDomain() {
      return isUsedInDomain;
    }

    public void seIsUsedInDomain(boolean isUsedInDomain) {
      this.isUsedInDomain = isUsedInDomain;
    }
  }

  public static class DirectoryService {

    boolean   isEnabled;
    // directory service is in use / isEnabled must be always assigned if used in set methods 
    DirectoryServiceType  serviceType;
    // type of the service 
    DirectoryAuthentication   authentication;
    // authentication information 
    String  hostname;
    // directory service hostname 
    String  backupHostname;
    // directory service backup hostname 
    String  directoryName;
    // Active Directory only: Directory name. 
    String  ldapSuffix;
    // Apple Directory, Kerio Directory: LDAP Search Suffix. 

    public DirectoryService() {

    }

    public boolean isIsEnabled() {
      return isEnabled;
    }

    public void setIsEnabled(boolean isEnabled) {
      this.isEnabled = isEnabled;
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

    public String getHostname() {
      return hostname;
    }

    public void setHostname(String hostname) {
      this.hostname = hostname;
    }

    public String getBackupHostname() {
      return backupHostname;
    }

    public void setBackupHostname(String backupHostname) {
      this.backupHostname = backupHostname;
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
  
  public static class DirectoryAuthentication {

    String  username;
    String  password;
    boolean   isSecure; //  is used LDAPS? 

    public DirectoryAuthentication() {

    }

    public String getUsername() {
      return username;
    }

    public void setUsername(String username) {
      this.username = username;
    }

    public String getPassword() {
      return password;
    }

    public void setPassword(String password) {
      this.password = password;
    }

    public boolean isIsSecure() {
      return isSecure;
    }

    public void setIsSecure(boolean isSecure) {
      this.isSecure = isSecure;
    }

  }
  
  public enum DeliveryType {
    Online,           ///< deliver online, immediatelly
    OfflineScheduler, ///< delivery is started by scheduler
    OfflineEtrn       ///< delivery is started by ETRN command from remote host
  }

  public enum DirectoryServiceType {
    WindowsActiveDirectory,    ///< Windows Active Directory
    AppleDirectoryKerberos, ///< Apple Open Directory with Kerberos authentication
    AppleDirectoryPassword, ///< Apple Open Directory with Password Server authentication
    KerioDirectory          ///< Kerio Directory (reserved for future use)
  }

}
