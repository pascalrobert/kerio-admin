package kerio.connect.admin.users;

import java.util.ArrayList;

import kerio.connect.admin.common.ActionAfterDays;
import kerio.connect.admin.common.ByteValueWithUnits;
import kerio.connect.admin.common.HomeServer;
import kerio.connect.admin.common.IdEntity;
import kerio.connect.admin.common.OptionalEntity;
import kerio.connect.admin.common.SizeLimit;
import kerio.connect.admin.common.UserAuthType;
import kerio.connect.admin.common.enums.DataSource;

public class User {

  String   id; // [READ-ONLY] global identification 
  String  loginName; // [REQUIRED FOR CREATE] [USED BY QUICKSEARCH] loginName name 
  String  fullName; // [USED BY QUICKSEARCH] 
  String  description; // [USED BY QUICKSEARCH] 
  boolean   isEnabled; // user account is enabled/disabled 
  DataSource  itemSource; // is user stored internally or by LDAP? This field cannot be used with Or queries. 
  UserAuthType  authType; // supported values must be retrieved from engine by ServerInfo::getSupportedAuthTypes() 
  String  password; // [WRITE-ONLY] 
  boolean   isPasswordReversible; // typically triple DES 
  boolean   allowPasswordChange; // if it is set to false the password can be changed only by the administrator 
  boolean   hasDefaultSpamRule; // now: available only on user creation 
  UserRight   role; // user role 
  UserRight   groupRole; // the mightiest user role obtained via group membership 
  UserRight   effectiveRole; // the mightiest user role from role and groupRole 
  boolean   isWritableByMe; // Does caller have right to change the user? E.g. if Account Admin gets User structure for Full Admin, isWritableByMe will be false. This field is read-only and cannot be used in kerio::web::SearchQuery conditions. 
  String   domainId; // [REQUIRED FOR CREATE] ID of domain where user belongs to 
  ArrayList<String>  emailAddresses; // List of user email addresses. His default one (loginName) is not listed here. 
  EmailForwarding   emailForwarding; // email forwarding setting 
  ArrayList<UserGroup>   userGroups; // groups membership 
  ItemCountLimit  itemLimit; // max. number of items 
  SizeLimit   diskSizeLimit; // max. disk usage 
  long  consumedItems; // current items used 
  ByteValueWithUnits  consumedSize; // current disk usage 
  boolean   hasDomainRestriction; // user can send/receive from/to his/her domain only 
  SizeLimit   outMessageLimit; // limit of outgoing message 
  LastLogin   lastLoginInfo; // information about last login datetime and protocol 
  boolean   publishInGal; // publish user in global address list? Default is true - the user will be published in Global Address Book. 
  CleanOut  cleanOutItems; // Items clean-out settings. 
  IdEntity  accessPolicy; // ID and name of Access Policy applied for user. Only ID is writable. 
  HomeServer  homeServer; // [READ-ONLY] Id of user's homeserver if server is in a distributed domain. 
  OptionalEntity  migration; // [READ-ONLY] migration.enabled is true if user's store is just being migrated and migration.id contains migration task id 
  
  public User() {
    
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
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

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public boolean isIsEnabled() {
    return isEnabled;
  }

  public void setIsEnabled(boolean isEnabled) {
    this.isEnabled = isEnabled;
  }

  public DataSource getItemSource() {
    return itemSource;
  }

  public void setItemSource(DataSource itemSource) {
    this.itemSource = itemSource;
  }

  public UserAuthType getAuthType() {
    return authType;
  }

  public void setAuthType(UserAuthType authType) {
    this.authType = authType;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public boolean isIsPasswordReversible() {
    return isPasswordReversible;
  }

  public void setIsPasswordReversible(boolean isPasswordReversible) {
    this.isPasswordReversible = isPasswordReversible;
  }

  public boolean isAllowPasswordChange() {
    return allowPasswordChange;
  }

  public void setAllowPasswordChange(boolean allowPasswordChange) {
    this.allowPasswordChange = allowPasswordChange;
  }

  public boolean isHasDefaultSpamRule() {
    return hasDefaultSpamRule;
  }

  public void setHasDefaultSpamRule(boolean hasDefaultSpamRule) {
    this.hasDefaultSpamRule = hasDefaultSpamRule;
  }

  public UserRight getRole() {
    return role;
  }

  public void setRole(UserRight role) {
    this.role = role;
  }

  public UserRight getGroupRole() {
    return groupRole;
  }

  public void setGroupRole(UserRight groupRole) {
    this.groupRole = groupRole;
  }

  public UserRight getEffectiveRole() {
    return effectiveRole;
  }

  public void setEffectiveRole(UserRight effectiveRole) {
    this.effectiveRole = effectiveRole;
  }

  public boolean isIsWritableByMe() {
    return isWritableByMe;
  }

  public void setIsWritableByMe(boolean isWritableByMe) {
    this.isWritableByMe = isWritableByMe;
  }

  public String getDomainId() {
    return domainId;
  }

  public void setDomainId(String domainId) {
    this.domainId = domainId;
  }

  public ArrayList<String> getEmailAddresses() {
    return emailAddresses;
  }

  public void setEmailAddresses(ArrayList<String> emailAddresses) {
    this.emailAddresses = emailAddresses;
  }

  public EmailForwarding getEmailForwarding() {
    return emailForwarding;
  }

  public void setEmailForwarding(EmailForwarding emailForwarding) {
    this.emailForwarding = emailForwarding;
  }

  public ArrayList<UserGroup> getUserGroups() {
    return userGroups;
  }

  public void setUserGroups(ArrayList<UserGroup> userGroups) {
    this.userGroups = userGroups;
  }

  public ItemCountLimit getItemLimit() {
    return itemLimit;
  }

  public void setItemLimit(ItemCountLimit itemLimit) {
    this.itemLimit = itemLimit;
  }

  public SizeLimit getDiskSizeLimit() {
    return diskSizeLimit;
  }

  public void setDiskSizeLimit(SizeLimit diskSizeLimit) {
    this.diskSizeLimit = diskSizeLimit;
  }

  public long getConsumedItems() {
    return consumedItems;
  }

  public void setConsumedItems(long consumedItems) {
    this.consumedItems = consumedItems;
  }

  public ByteValueWithUnits getConsumedSize() {
    return consumedSize;
  }

  public void setConsumedSize(ByteValueWithUnits consumedSize) {
    this.consumedSize = consumedSize;
  }

  public boolean isHasDomainRestriction() {
    return hasDomainRestriction;
  }

  public void setHasDomainRestriction(boolean hasDomainRestriction) {
    this.hasDomainRestriction = hasDomainRestriction;
  }

  public SizeLimit getOutMessageLimit() {
    return outMessageLimit;
  }

  public void setOutMessageLimit(SizeLimit outMessageLimit) {
    this.outMessageLimit = outMessageLimit;
  }

  public LastLogin getLastLoginInfo() {
    return lastLoginInfo;
  }

  public void setLastLoginInfo(LastLogin lastLoginInfo) {
    this.lastLoginInfo = lastLoginInfo;
  }

  public boolean isPublishInGal() {
    return publishInGal;
  }

  public void setPublishInGal(boolean publishInGal) {
    this.publishInGal = publishInGal;
  }

  public CleanOut getCleanOutItems() {
    return cleanOutItems;
  }

  public void setCleanOutItems(CleanOut cleanOutItems) {
    this.cleanOutItems = cleanOutItems;
  }

  public IdEntity getAccessPolicy() {
    return accessPolicy;
  }

  public void setAccessPolicy(IdEntity accessPolicy) {
    this.accessPolicy = accessPolicy;
  }

  public HomeServer getHomeServer() {
    return homeServer;
  }

  public void setHomeServer(HomeServer homeServer) {
    this.homeServer = homeServer;
  }

  public OptionalEntity getMigration() {
    return migration;
  }

  public void setMigration(OptionalEntity migration) {
    this.migration = migration;
  }
  
  public enum FileFormatType {
    TypeXml, ///< Extensible Markup Language
    TypeCsv  ///< Comma Separated Values
  }
  
  public enum UserRoleType {
    UserRole,      ///< regular user without any administration rights
    Auditor,    ///< read only access to administration
    AccountAdmin,  ///< can administer Users,Groups,Aliases,MLs
    FullAdmin,     ///< unlimited administration
    BuiltInAdmin   ///< BuiltIn admin role can be returned only in Session::WhoAmI method for built-in administrator. This role must NOT be assigned.
  }
  
  public enum UserForwardMode {
    UForwardNone,  ///< Forwarding is disabled
    UForwardYes,   ///< Forward all messages for this user to some addresses, don't deliver the message to the mailbox.
    UForwardDeliver   ///< Forward all messages for this user to some addresses, and also deliver the message to user's mailbox.
  }

  public enum UserDeleteFolderMode {
    UDeleteUser,   ///< Delete user without deleting his folder.
    UDeleteFolder, ///< Delete user and delete his folder.
    UMoveFolder    ///< Delete user and his folder will move into another user's folder.
  }
  
  public enum FolderIcon {
    FIMail,
    FIContact,
    FICalendar,
    FITodo,
    FIJournal,
    FINote,
    FIInbox,
    FIDeleted
  }
  
  public enum DeviceStatus {
    OK,                  ///< no wipe
    DeviceWipeInitiated, ///< wipe process submitted
    DeviceWipeInProgress,   ///< wipe process in progress
    DeviceWipeFinished,     ///< wipe process finished
    DeviceConnected,
    DeviceDisconnected
  }
  
  public enum SyncMethod {
    ServerWins,
    ClientWins
  }

  public enum ProtocolType {
    protocolASync,
    protocolKBC
  }
  
  public enum ServerDirectoryType {
    WinNT,            ///< Windows NT Domain directory (Win NT 4.0)
    ActiveDirectory,  ///< Active Directory (Windows 2000 and newer)
    NovellEDirectory  ///< Novell eDirectory
  }
  
  public enum AuthResult {
    AuthOK,           ///< User was autenticated
    AuthFail,         ///< Wrong login name or password.
    AuthUserDisabled, ///< User cannot to log in, because his account is disabled.
    AuthLicense,      ///< User cannot log in, because license limit was reached.
    AuthDenied,       ///< User is denied to log in.
    AuthTryLater      ///< User cannot to log in at this moment, try later.
  }

  public static class UserRight {

    UserRoleType  userRole;
    boolean   publicFolderRight;
    boolean   archiveFolderRight;
    
    public UserRight() {
      
    }

    public UserRoleType getUserRole() {
      return userRole;
    }

    public void setUserRole(UserRoleType userRole) {
      this.userRole = userRole;
    }

    public boolean isPublicFolderRight() {
      return publicFolderRight;
    }

    public void setPublicFolderRight(boolean publicFolderRight) {
      this.publicFolderRight = publicFolderRight;
    }

    public boolean isArchiveFolderRight() {
      return archiveFolderRight;
    }

    public void setArchiveFolderRight(boolean archiveFolderRight) {
      this.archiveFolderRight = archiveFolderRight;
    }
    
  }
  
  public static class EmailForwarding {
    UserForwardMode mode;
    ArrayList<String>  emailAddresses;
    
    public EmailForwarding() {
      
    }

    public UserForwardMode getMode() {
      return mode;
    }

    public void setMode(UserForwardMode mode) {
      this.mode = mode;
    }

    public ArrayList<String> getEmailAddresses() {
      return emailAddresses;
    }

    public void setEmailAddresses(ArrayList<String> emailAddresses) {
      this.emailAddresses = emailAddresses;
    }
  }
  
  public static class UserGroup {

    String id;  
    String name;
    String description;
    
    public UserGroup() {
      
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
    
  }
  
  public static class ItemCountLimit {

    boolean              isActive;
    long                 limit;
    
    public ItemCountLimit() {
      
    }

    public boolean isIsActive() {
      return isActive;
    }

    public void setIsActive(boolean isActive) {
      this.isActive = isActive;
    }

    public long getLimit() {
      return limit;
    }

    public void setLimit(long limit) {
      this.limit = limit;
    }
    
  }
  
  public static class QuotaUsage {
    long                 items;
    ByteValueWithUnits   storage;
    
    public QuotaUsage() {
      
    }

    public long getItems() {
      return items;
    }

    public void setItems(long items) {
      this.items = items;
    }

    public ByteValueWithUnits getStorage() {
      return storage;
    }

    public void setStorage(ByteValueWithUnits storage) {
      this.storage = storage;
    }
  }

  public static class LastLogin {

    long  dateTime;   ///< date and time of last login
    String         protocol;   ///< protocol name of last login, example POP3

    public LastLogin() {

    }

    public long getDateTime() {
      return dateTime;
    }

    public void setDateTime(long dateTime) {
      this.dateTime = dateTime;
    }

    public String getProtocol() {
      return protocol;
    }

    public void setProtocol(String protocol) {
      this.protocol = protocol;
    }
  }

  public static class CleanOut {

    boolean        isUsedDomain;  ///< use domain settings
    ActionAfterDays   deletedItems;  ///< clean Deleted Items folder (maximum: 24855)
    ActionAfterDays   junkEmail;     ///< clean Junk Email folder (maximum: 24855)
    ActionAfterDays sentItems;    ///< clean Sent Items folder (maximum: 24855)
    ActionAfterDays   autoDelete;    ///< clean all folders (maximum: 24855)
    
    public CleanOut() {
      
    }

    public boolean isIsUsedDomain() {
      return isUsedDomain;
    }

    public void setIsUsedDomain(boolean isUsedDomain) {
      this.isUsedDomain = isUsedDomain;
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

  }
  
  public static class SyncFolder {
    String         folderName;       ///< folder name
    FolderIcon     folderTypeIcon;         ///< mail,contact...
    long  lastSyncDate;     ///< date of last synchronization
    
    public SyncFolder() {
      
    }

    public String getFolderName() {
      return folderName;
    }

    public void setFolderName(String folderName) {
      this.folderName = folderName;
    }

    public FolderIcon getFolderTypeIcon() {
      return folderTypeIcon;
    }

    public void setFolderTypeIcon(FolderIcon folderTypeIcon) {
      this.folderTypeIcon = folderTypeIcon;
    }

    public long getLastSyncDate() {
      return lastSyncDate;
    }

    public void setLastSyncDate(long lastSyncDate) {
      this.lastSyncDate = lastSyncDate;
    }
  }
  
  public static class MobileDevice {
    ProtocolType    protocolType;
    String         deviceId;
    String         protocolVersion;  ///< used ActiveSync protocol version
    long  registrationDate; ///< date of registration
    long  lastSyncDate;     ///< date of last synchronization
    ArrayList<SyncFolder>  folderList;         ///< list of synchronized folders
    DeviceStatus   status;           ///< wipe status
    SyncMethod     method;           ///< synchronization method
    String         remoteHost;       ///< typically IP address of device
    String         os;               ///< operating system - eg. Windows Mobile(R) 2003
    String         platform;         ///< PocketPC
    String         deviceIcon;       ///< Device icon Eg. 'pocketpc' or 'unknown'
    
    public MobileDevice() {
      
    }

    public ProtocolType getProtocolType() {
      return protocolType;
    }

    public void setProtocolType(ProtocolType protocolType) {
      this.protocolType = protocolType;
    }

    public String getDeviceId() {
      return deviceId;
    }

    public void setDeviceId(String deviceId) {
      this.deviceId = deviceId;
    }

    public String getProtocolVersion() {
      return protocolVersion;
    }

    public void setProtocolVersion(String protocolVersion) {
      this.protocolVersion = protocolVersion;
    }

    public long getRegistrationDate() {
      return registrationDate;
    }

    public void setRegistrationDate(long registrationDate) {
      this.registrationDate = registrationDate;
    }

    public long getLastSyncDate() {
      return lastSyncDate;
    }

    public void setLastSyncDate(long lastSyncDate) {
      this.lastSyncDate = lastSyncDate;
    }

    public ArrayList<SyncFolder> getFolderList() {
      return folderList;
    }

    public void setFolderList(ArrayList<SyncFolder> folderList) {
      this.folderList = folderList;
    }

    public DeviceStatus getStatus() {
      return status;
    }

    public void setStatus(DeviceStatus status) {
      this.status = status;
    }

    public SyncMethod getMethod() {
      return method;
    }

    public void setMethod(SyncMethod method) {
      this.method = method;
    }

    public String getRemoteHost() {
      return remoteHost;
    }

    public void setRemoteHost(String remoteHost) {
      this.remoteHost = remoteHost;
    }

    public String getOs() {
      return os;
    }

    public void setOs(String os) {
      this.os = os;
    }

    public String getPlatform() {
      return platform;
    }

    public void setPlatform(String platform) {
      this.platform = platform;
    }

    public String getDeviceIcon() {
      return deviceIcon;
    }

    public void setDeviceIcon(String deviceIcon) {
      this.deviceIcon = deviceIcon;
    }
  }

  public static class ImportServer {
    ServerDirectoryType   directoryType;
    String      remoteDomainName;
    String      address;    ///< server IP or FQDN
    String      loginName;
    String      password;
    String      ldapFilter;
    boolean     isSecureConnection;

    public ImportServer() {

    }

    public ServerDirectoryType getDirectoryType() {
      return directoryType;
    }

    public void setDirectoryType(ServerDirectoryType directoryType) {
      this.directoryType = directoryType;
    }

    public String getRemoteDomainName() {
      return remoteDomainName;
    }

    public void setRemoteDomainName(String remoteDomainName) {
      this.remoteDomainName = remoteDomainName;
    }

    public String getAddress() {
      return address;
    }

    public void setAddress(String address) {
      this.address = address;
    }

    public String getLoginName() {
      return loginName;
    }

    public void setLoginName(String loginName) {
      this.loginName = loginName;
    }

    public String getPassword() {
      return password;
    }

    public void setPassword(String password) {
      this.password = password;
    }

    public String getLdapFilter() {
      return ldapFilter;
    }

    public void setLdapFilter(String ldapFilter) {
      this.ldapFilter = ldapFilter;
    }

    public boolean isSecureConnection() {
      return isSecureConnection;
    }

    public void setSecureConnection(boolean isSecureConnection) {
      this.isSecureConnection = isSecureConnection;
    }
  }
  
  public static class LoginStats {
    long       count;
    String     lastLogin;
    
    public LoginStats() {
      
    }

    public long getCount() {
      return count;
    }

    public void setCount(long count) {
      this.count = count;
    }

    public String getLastLogin() {
      return lastLogin;
    }

    public void setLastLogin(String lastLogin) {
      this.lastLogin = lastLogin;
    }
  }
  
  public static class UserStats {
    String      name;          ///< user's loginName
    QuotaUsage  occupiedSpace;
    LoginStats  pop3;
    LoginStats  securePop3;
    LoginStats  imap;
    LoginStats  secureImap;
    LoginStats  http;
    LoginStats  secureHttp;
    LoginStats  ldap;
    LoginStats  secureLdap;
    LoginStats  nntp;
    LoginStats  secureNntp;
    LoginStats  activeSync;
    LoginStats  secureActiveSync;
    LoginStats  xmpp;
    LoginStats  secureXmpp;
    
    public UserStats() {
      
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public QuotaUsage getOccupiedSpace() {
      return occupiedSpace;
    }

    public void setOccupiedSpace(QuotaUsage occupiedSpace) {
      this.occupiedSpace = occupiedSpace;
    }

    public LoginStats getPop3() {
      return pop3;
    }

    public void setPop3(LoginStats pop3) {
      this.pop3 = pop3;
    }

    public LoginStats getSecurePop3() {
      return securePop3;
    }

    public void setSecurePop3(LoginStats securePop3) {
      this.securePop3 = securePop3;
    }

    public LoginStats getImap() {
      return imap;
    }

    public void setImap(LoginStats imap) {
      this.imap = imap;
    }

    public LoginStats getSecureImap() {
      return secureImap;
    }

    public void setSecureImap(LoginStats secureImap) {
      this.secureImap = secureImap;
    }

    public LoginStats getHttp() {
      return http;
    }

    public void setHttp(LoginStats http) {
      this.http = http;
    }

    public LoginStats getSecureHttp() {
      return secureHttp;
    }

    public void setSecureHttp(LoginStats secureHttp) {
      this.secureHttp = secureHttp;
    }

    public LoginStats getLdap() {
      return ldap;
    }

    public void setLdap(LoginStats ldap) {
      this.ldap = ldap;
    }

    public LoginStats getSecureLdap() {
      return secureLdap;
    }

    public void setSecureLdap(LoginStats secureLdap) {
      this.secureLdap = secureLdap;
    }

    public LoginStats getNntp() {
      return nntp;
    }

    public void setNntp(LoginStats nntp) {
      this.nntp = nntp;
    }

    public LoginStats getSecureNntp() {
      return secureNntp;
    }

    public void setSecureNntp(LoginStats secureNntp) {
      this.secureNntp = secureNntp;
    }

    public LoginStats getActiveSync() {
      return activeSync;
    }

    public void setActiveSync(LoginStats activeSync) {
      this.activeSync = activeSync;
    }

    public LoginStats getSecureActiveSync() {
      return secureActiveSync;
    }

    public void setSecureActiveSync(LoginStats secureActiveSync) {
      this.secureActiveSync = secureActiveSync;
    }

    public LoginStats getXmpp() {
      return xmpp;
    }

    public void setXmpp(LoginStats xmpp) {
      this.xmpp = xmpp;
    }

    public LoginStats getSecureXmpp() {
      return secureXmpp;
    }

    public void setSecureXmpp(LoginStats secureXmpp) {
      this.secureXmpp = secureXmpp;
    }
  }
  
  public static class ResultTriplet {
    long inputIndex;
    long itemsCount;
    
    public ResultTriplet() {
      
    }

    public long getInputIndex() {
      return inputIndex;
    }

    public void setInputIndex(long inputIndex) {
      this.inputIndex = inputIndex;
    }

    public long getItemsCount() {
      return itemsCount;
    }

    public void setItemsCount(long itemsCount) {
      this.itemsCount = itemsCount;
    }
  }
  
  public static class RemovalRequest {
    String      userId;        ///< ID of user to be removed
    UserDeleteFolderMode method;        ///< removal method
    boolean        removeReferences;    ///< if true all reference to this user is going to be removed as well
    String         targetUserId;  ///< applicable only when moving user's store to another user, use empty string if not moving user's messages to target mailbox
    
    public RemovalRequest() {
      
    }

    public String getUserId() {
      return userId;
    }

    public void setUserId(String userId) {
      this.userId = userId;
    }

    public UserDeleteFolderMode getMethod() {
      return method;
    }

    public void setMethod(UserDeleteFolderMode method) {
      this.method = method;
    }

    public boolean isRemoveReferences() {
      return removeReferences;
    }

    public void setRemoveReferences(boolean removeReferences) {
      this.removeReferences = removeReferences;
    }

    public String getTargetUserId() {
      return targetUserId;
    }

    public void setTargetUserId(String targetUserId) {
      this.targetUserId = targetUserId;
    }
  }
  
  public static class Importee {
    User  userItem;      ///< user data
    boolean  isImportable;  ///< user can be imported
    String   message;    ///< error message if user is not importable
    
    public Importee() {
      
    }

    public User getUserItem() {
      return userItem;
    }

    public void setUserItem(User userItem) {
      this.userItem = userItem;
    }

    public boolean isImportable() {
      return isImportable;
    }

    public void setImportable(boolean isImportable) {
      this.isImportable = isImportable;
    }

    public String getMessage() {
      return message;
    }

    public void setMessage(String message) {
      this.message = message;
    }
  }
  
  public static class MailboxCount {
    long active;   ///< the number of active mailboxes on server
    long total;    ///< the number of created users on server
    
    public MailboxCount() {
      
    }

    public long getActive() {
      return active;
    }

    public void setActive(long active) {
      this.active = active;
    }

    public long getTotal() {
      return total;
    }

    public void setTotal(long total) {
      this.total = total;
    }
  }

}
