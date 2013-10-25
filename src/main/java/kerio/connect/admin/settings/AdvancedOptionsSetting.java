package kerio.connect.admin.settings;

import kerio.connect.admin.common.ByteValueWithUnits;
import kerio.connect.admin.common.DistanceOrNull;
import kerio.connect.admin.common.TimeLimit;
import kerio.connect.admin.policies.SecurityPolicyOptions;

public class AdvancedOptionsSetting {

  private MiscellaneousOptions miscellaneous;
  private StoreDirectoryOptions storeDirectory;
  private MasterAuthenticationOptions masterAuthentication;
  private HttpProxyOptions httpProxy;
  private UpdateCheckerOptions updateChecker;
  private WebMailOptions webMail;
  private UserQuota userQuota;
  private FulltextSetting fulltext;
  private KoffOptions koffOptions;
  private SecurityPolicyOptions securityPolicy;

  public AdvancedOptionsSetting() {

  }

  public MiscellaneousOptions getMiscellaneous() {
    return miscellaneous;
  }

  public void setMiscellaneous(MiscellaneousOptions miscellaneous) {
    this.miscellaneous = miscellaneous;
  }

  public StoreDirectoryOptions getStoreDirectory() {
    return storeDirectory;
  }

  public void setStoreDirectory(StoreDirectoryOptions storeDirectory) {
    this.storeDirectory = storeDirectory;
  }

  public MasterAuthenticationOptions getMasterAuthentication() {
    return masterAuthentication;
  }

  public void setMasterAuthentication(MasterAuthenticationOptions masterAuthentication) {
    this.masterAuthentication = masterAuthentication;
  }

  public HttpProxyOptions getHttpProxy() {
    return httpProxy;
  }

  public void setHttpProxy(HttpProxyOptions httpProxy) {
    this.httpProxy = httpProxy;
  }

  public UpdateCheckerOptions getUpdateChecker() {
    return updateChecker;
  }

  public void setUpdateChecker(UpdateCheckerOptions updateChecker) {
    this.updateChecker = updateChecker;
  }

  public WebMailOptions getWebMail() {
    return webMail;
  }

  public void setWebMail(WebMailOptions webMail) {
    this.webMail = webMail;
  }

  public UserQuota getUserQuota() {
    return userQuota;
  }

  public void setUserQuota(UserQuota userQuota) {
    this.userQuota = userQuota;
  }

  public FulltextSetting getFulltext() {
    return fulltext;
  }

  public void setFulltext(FulltextSetting fulltext) {
    this.fulltext = fulltext;
  }

  public KoffOptions getKoffOptions() {
    return koffOptions;
  }

  public void setKoffOptions(KoffOptions koffOptions) {
    this.koffOptions = koffOptions;
  }

  public SecurityPolicyOptions getSecurityPolicy() {
    return securityPolicy;
  }

  public void setSecurityPolicy(SecurityPolicyOptions securityPolicy) {
    this.securityPolicy = securityPolicy;
  }

  public static class MiscellaneousOptions {
    boolean logHostNames;            ///< Log hostnames for incoming connections
    boolean showProgramNameAndVersion;  ///< Show program name and version in network communication for non-authenticated users
    boolean insertXEnvelopeTo;       ///< Insert X-Envelope-To header to locally delivered messages
    boolean enableTNEFDecoding;         ///< Enable decoding of TNEF messages (winmail.dat attachments)
    boolean enableUUEncodedConversion;  ///< Enable conversion of uuencoded messages to MIME
    boolean allowUnsupportedActiveSyncDevices;  ///< Allow access for unsupported activeSync devices
    
    public MiscellaneousOptions() {
      
    }

    public boolean isLogHostNames() {
      return logHostNames;
    }

    public void setLogHostNames(boolean logHostNames) {
      this.logHostNames = logHostNames;
    }

    public boolean isShowProgramNameAndVersion() {
      return showProgramNameAndVersion;
    }

    public void setShowProgramNameAndVersion(boolean showProgramNameAndVersion) {
      this.showProgramNameAndVersion = showProgramNameAndVersion;
    }

    public boolean isInsertXEnvelopeTo() {
      return insertXEnvelopeTo;
    }

    public void setInsertXEnvelopeTo(boolean insertXEnvelopeTo) {
      this.insertXEnvelopeTo = insertXEnvelopeTo;
    }

    public boolean isEnableTNEFDecoding() {
      return enableTNEFDecoding;
    }

    public void setEnableTNEFDecoding(boolean enableTNEFDecoding) {
      this.enableTNEFDecoding = enableTNEFDecoding;
    }

    public boolean isEnableUUEncodedConversion() {
      return enableUUEncodedConversion;
    }

    public void setEnableUUEncodedConversion(boolean enableUUEncodedConversion) {
      this.enableUUEncodedConversion = enableUUEncodedConversion;
    }

    public boolean isAllowUnsupportedActiveSyncDevices() {
      return allowUnsupportedActiveSyncDevices;
    }

    public void setAllowUnsupportedActiveSyncDevices(boolean allowUnsupportedActiveSyncDevices) {
      this.allowUnsupportedActiveSyncDevices = allowUnsupportedActiveSyncDevices;
    }
  }
  
  public static class StoreDirectoryOptions {
    String storePath;                         ///< Path to the store directory
    String archivePath;                          ///< Path to the archive
    String backupPath;                           ///< Path to the backup
    ByteValueWithUnits watchdogSoftLimit;  ///< If the available disk space falls below this value, a warning message is displayed
    ByteValueWithUnits watchdogHardLimit;  ///< If the available disk space falls below this value, Kerio MailServer is stopped and an error message is displayed. Administrator's action is required.
  
    public StoreDirectoryOptions() {
      
    }

    public String getStorePath() {
      return storePath;
    }

    public void setStorePath(String storePath) {
      this.storePath = storePath;
    }

    public String getArchivePath() {
      return archivePath;
    }

    public void setArchivePath(String archivePath) {
      this.archivePath = archivePath;
    }

    public String getBackupPath() {
      return backupPath;
    }

    public void setBackupPath(String backupPath) {
      this.backupPath = backupPath;
    }

    public ByteValueWithUnits getWatchdogSoftLimit() {
      return watchdogSoftLimit;
    }

    public void setWatchdogSoftLimit(ByteValueWithUnits watchdogSoftLimit) {
      this.watchdogSoftLimit = watchdogSoftLimit;
    }

    public ByteValueWithUnits getWatchdogHardLimit() {
      return watchdogHardLimit;
    }

    public void setWatchdogHardLimit(ByteValueWithUnits watchdogHardLimit) {
      this.watchdogHardLimit = watchdogHardLimit;
    }
    
  }
  
  public static class MasterAuthenticationOptions {
    boolean isEnabled;               ///< Enable master authentication to this server
    String groupRestriction;   ///< Allow master authentication only from IP address group
    String password;              ///< [WriteOnly] Master password
    
    public MasterAuthenticationOptions() {
      
    }

    public boolean isIsEnabled() {
      return isEnabled;
    }

    public void setIsEnabled(boolean isEnabled) {
      this.isEnabled = isEnabled;
    }

    public String getGroupRestriction() {
      return groupRestriction;
    }

    public void setGroupRestriction(String groupRestriction) {
      this.groupRestriction = groupRestriction;
    }

    public String getPassword() {
      return password;
    }

    public void setPassword(String password) {
      this.password = password;
    }
  }
  
  public static class HttpProxyOptions {
    boolean isEnabled;   ///< Use HTTP proxy for antivirus updates, Kerio update checker and other web services
    String address;
    long port;
    boolean requiresAuthentication;  ///< Proxy requires authentication
    String userName;
    String password;
    
    public HttpProxyOptions() {
      
    }

    public boolean isIsEnabled() {
      return isEnabled;
    }

    public void setIsEnabled(boolean isEnabled) {
      this.isEnabled = isEnabled;
    }

    public String getAddress() {
      return address;
    }

    public void setAddress(String address) {
      this.address = address;
    }

    public long getPort() {
      return port;
    }

    public void setPort(long port) {
      this.port = port;
    }

    public boolean isRequiresAuthentication() {
      return requiresAuthentication;
    }

    public void setRequiresAuthentication(boolean requiresAuthentication) {
      this.requiresAuthentication = requiresAuthentication;
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
  
  enum UpdateCheckerStatus {
    updNoUpdate,   ///< Update status: No update
    updNewVersion,    ///< Update status: New version
    updError    ///< Update status: Error
  }
  
  public static class UpdateInfo {
    UpdateCheckerStatus result;
    String description;
    String downloadUrl;
    String infoUrl;
    
    public UpdateInfo() {
      
    }

    public UpdateCheckerStatus getResult() {
      return result;
    }

    public void setResult(UpdateCheckerStatus result) {
      this.result = result;
    }

    public String getDescription() {
      return description;
    }

    public void setDescription(String description) {
      this.description = description;
    }

    public String getDownloadUrl() {
      return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
      this.downloadUrl = downloadUrl;
    }

    public String getInfoUrl() {
      return infoUrl;
    }

    public void setInfoUrl(String infoUrl) {
      this.infoUrl = infoUrl;
    }
  }
  
  public static class UpdateCheckerOptions {
    boolean autoCheck;            ///< Automatically check for new versions
    boolean checkBetaVersion;     ///< Check also for beta versions
    DistanceOrNull timeFromLastCheck;      ///< [ReadOnly]
    String downloadedFile;        ///< [ReadOnly]
    UpdateInfo updateInfo;        ///< [ReadOnly]
    String kocVersion;            ///< [ReadOnly]
    String koffVersion;           ///< [ReadOnly]
    String kspVersion;            ///< [ReadOnly]
    String kscVersion;            ///< [ReadOnly]
    
    public UpdateCheckerOptions() {
      
    }

    public boolean isAutoCheck() {
      return autoCheck;
    }

    public void setAutoCheck(boolean autoCheck) {
      this.autoCheck = autoCheck;
    }

    public boolean isCheckBetaVersion() {
      return checkBetaVersion;
    }

    public void setCheckBetaVersion(boolean checkBetaVersion) {
      this.checkBetaVersion = checkBetaVersion;
    }

    public DistanceOrNull getTimeFromLastCheck() {
      return timeFromLastCheck;
    }

    public void setTimeFromLastCheck(DistanceOrNull timeFromLastCheck) {
      this.timeFromLastCheck = timeFromLastCheck;
    }

    public String getDownloadedFile() {
      return downloadedFile;
    }

    public void setDownloadedFile(String downloadedFile) {
      this.downloadedFile = downloadedFile;
    }

    public UpdateInfo getUpdateInfo() {
      return updateInfo;
    }

    public void setUpdateInfo(UpdateInfo updateInfo) {
      this.updateInfo = updateInfo;
    }

    public String getKocVersion() {
      return kocVersion;
    }

    public void setKocVersion(String kocVersion) {
      this.kocVersion = kocVersion;
    }

    public String getKoffVersion() {
      return koffVersion;
    }

    public void setKoffVersion(String koffVersion) {
      this.koffVersion = koffVersion;
    }

    public String getKspVersion() {
      return kspVersion;
    }

    public void setKspVersion(String kspVersion) {
      this.kspVersion = kspVersion;
    }

    public String getKscVersion() {
      return kscVersion;
    }

    public void setKscVersion(String kscVersion) {
      this.kscVersion = kscVersion;
    }
  }
  
  enum KoffUpgradePolicy {
    KoffUPolicyAskVoluntary,         ///< Ask user for each version change and do not allow the update.
    KoffUPolicyAskRequired,          ///< Ask user for each version change and require the update.
    KoffUPolicyAlwaysSilent,         ///< Do update for each version change. Update silently when Outlook starts. Ask users when Outlook is running and require update.
    KoffUPolicyOnStartSilent,        ///< default, available in WebAdmin. Do update for each version change. Update silently when Outlook starts. When Outlook is running do nothing and wait for next Outlook start.
    KoffUPolicyOnlyIfNecessaryAsk,      ///< Update only if necessary. Ask users and require the update.
    KoffUPolicyOnlyIfNecessarySilent ///< available in WebAdmin, Update only if necessary. Update silently when Outlook starts. Ask users when Outlook is running and require update.
  }
  
  public static class KoffOptions {
    KoffUpgradePolicy upgradePolicy;
    
    public KoffOptions() {
      
    }

    public KoffUpgradePolicy getUpgradePolicy() {
      return upgradePolicy;
    }

    public void setUpgradePolicy(KoffUpgradePolicy upgradePolicy) {
      this.upgradePolicy = upgradePolicy;
    }
  }
  
  /** State of index */
  enum FulltextStatus {
    IndexRebuilding,  ///< reindexing is in progress
    IndexMessages,    ///< indexing new delivered messages
    IndexFinished,    ///< reindexing is finnished, it also mean "Up To Date"
    IndexDisabled,    ///< indexing is disabled
    IndexError,       ///< some error occured
    IndexErrorLowSpace   ///< available disk space is below Soft Limit
  }
  
  /** [READ ONLY] progres of index */
  public static class FulltextRebuildStatus {
    FulltextStatus status;  ///< [READ ONLY] state of rebuild process
    long usersLeft;         ///< [status IndexRebuilding] - the current number of user re-indexed mailboxes
    long messagesLeft;      ///< [status IndexMessages] - number of new delivered messages to index
    long size;           ///< index size or estimate size in status IndexMessages or IndexRebuilding
    long freeSpace;         ///< free space in path for index files
    
    public FulltextRebuildStatus() {
      
    }

    public FulltextStatus getStatus() {
      return status;
    }

    public void setStatus(FulltextStatus status) {
      this.status = status;
    }

    public long getUsersLeft() {
      return usersLeft;
    }

    public void setUsersLeft(long usersLeft) {
      this.usersLeft = usersLeft;
    }

    public long getMessagesLeft() {
      return messagesLeft;
    }

    public void setMessagesLeft(long messagesLeft) {
      this.messagesLeft = messagesLeft;
    }

    public long getSize() {
      return size;
    }

    public void setSize(long size) {
      this.size = size;
    }

    public long getFreeSpace() {
      return freeSpace;
    }

    public void setFreeSpace(long freeSpace) {
      this.freeSpace = freeSpace;
    }
  }
  
  public static class FulltextSetting {
    boolean enabled;  ///< enabled/disabled
    String  path;     ///< path to directory where are indexes
    
    public FulltextSetting() {
      
    }

    public boolean isEnabled() {
      return enabled;
    }

    public void setEnabled(boolean enabled) {
      this.enabled = enabled;
    }

    public String getPath() {
      return path;
    }

    public void setPath(String path) {
      this.path = path;
    }
  }
  
  /** Scope of reindex */
  enum FulltextScope {
    IndexAll,      ///< all users to reindex
    IndexDomain,   ///< only users from domain to reindex
    IndexUser      ///< only user to reindex
  }
  
  public static class FulltextRebuildingCommand {
    FulltextScope  scope;
    String id;     ///< domain id for scope 'IndexDomain' or user id for scope 'IndexUser'
  }
  
  enum WebmailLoginMode {
    DefaultOldWebmail,
    DefaultConnectClient,
    UserPreferred
  }
  
  public static class WebMailOptions {
    long messageSizeLimit;           ///< Maximum size of message that can be sent from the WebMail interface (HTTP POST size)
    TimeLimit sessionExpireTimeout;     ///< Session expire timeout
    TimeLimit maximumSessionDuration;   ///< Maximum session duration
    boolean forceLogout;          ///< Force WebMail logout if user's IP address changes (prevents session hijacking and session fixation attacks)
    boolean useCustomLogo;           ///< Use custom logo in WebMail
    String logoUrl;                  ///< [ReadOnly]
    WebmailLoginMode loginMode;         ///< Determine whether is used old Webmail as default web client. Property is valid only for this version of API. It will be removed in the next version. 
    
    public WebMailOptions() {
      
    }

    public long getMessageSizeLimit() {
      return messageSizeLimit;
    }

    public void setMessageSizeLimit(long messageSizeLimit) {
      this.messageSizeLimit = messageSizeLimit;
    }

    public TimeLimit getSessionExpireTimeout() {
      return sessionExpireTimeout;
    }

    public void setSessionExpireTimeout(TimeLimit sessionExpireTimeout) {
      this.sessionExpireTimeout = sessionExpireTimeout;
    }

    public TimeLimit getMaximumSessionDuration() {
      return maximumSessionDuration;
    }

    public void setMaximumSessionDuration(TimeLimit maximumSessionDuration) {
      this.maximumSessionDuration = maximumSessionDuration;
    }

    public boolean isForceLogout() {
      return forceLogout;
    }

    public void setForceLogout(boolean forceLogout) {
      this.forceLogout = forceLogout;
    }

    public boolean isUseCustomLogo() {
      return useCustomLogo;
    }

    public void setUseCustomLogo(boolean useCustomLogo) {
      this.useCustomLogo = useCustomLogo;
    }

    public String getLogoUrl() {
      return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
      this.logoUrl = logoUrl;
    }

    public WebmailLoginMode getLoginMode() {
      return loginMode;
    }

    public void setLoginMode(WebmailLoginMode loginMode) {
      this.loginMode = loginMode;
    }
  }
  
  enum NotificationType {
    notifyOnce,
    notifyEvery
  }
  
  public static class QuotaNotification {
    NotificationType  type;
    TimeLimit         period;
    
    public QuotaNotification() {
      
    }

    public NotificationType getType() {
      return type;
    }

    public void setType(NotificationType type) {
      this.type = type;
    }

    public TimeLimit getPeriod() {
      return period;
    }

    public void setPeriod(TimeLimit period) {
      this.period = period;
    }
  }
  
  public static class UserQuota {
    QuotaNotification notification; ///< option for notification
    long warningLimit;            ///< limit in per cent
    String email;              ///< if quota is exceeded the notification will be sent to this address
    
    public UserQuota() {
      
    }

    public QuotaNotification getNotification() {
      return notification;
    }

    public void setNotification(QuotaNotification notification) {
      this.notification = notification;
    }

    public long getWarningLimit() {
      return warningLimit;
    }

    public void setWarningLimit(long warningLimit) {
      this.warningLimit = warningLimit;
    }

    public String getEmail() {
      return email;
    }

    public void setEmail(String email) {
      this.email = email;
    }
  }

}
