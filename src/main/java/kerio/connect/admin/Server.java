package kerio.connect.admin;

import java.util.ArrayList;

import kerio.connect.admin.common.WebComponent;
import kerio.connect.admin.common.enums.ItemName;
import kerio.connect.admin.common.enums.RestrictionKind;
import kerio.connect.admin.domains.MaximumUsers;

public class Server {

  enum DirectoryAccessResult {
    directoryExists,        ///< Directory exist, read/write allowed
    directoryDoesNotExist,     ///< Directory does not exist (or unable to create)
    directoryExistAccessDenied, ///< Directory exist, read or write permission not granted
    directoryUnaccessible      ///< Unable to connect network device
  }

  /**
   * Information about directory
   */
  public static class Directory {
    String name;
    boolean hasSubdirectory;
  }

  /**
   * List of restrictions
   */
  ArrayList<Directory> DirectoryList;

  /**
   * Available entities, entity prefix due to name collision
   */
  enum Entity {
    EntityUser,          ///< User Entity
    EntityAlias,         ///< Alias Entity
    EntityGroup,         ///< Group Entity
    EntityMailingList,      ///< Mailing List Entity
    EntityResource,         ///< Resource Scheduling Entity
    EntityTimeRange,     ///< Time Range Entity
    EntityTimeRangeGroup,   ///< Time Range Group Entity
    EntityIpAddress,     ///< Ip Address Entity
    EntityIpAddressGroup,   ///< Ip Address Group Entity
    EntityService,       ///< Service Entity
    EntityDomain
  }

  /**
   * Restriction Items
   */
  public static class RestrictionTuple {
    ItemName name;
    RestrictionKind kind;
    ArrayList<String> values;
  }

  /**
   * Entity name restriction definition
   */
  public static class Restriction {
    Entity entityName;            ///< IDL entity name, eg. User
    ArrayList<RestrictionTuple> tuples;  ///< Restriction tuples
  }

  /**
   * List of restrictions
   */
  ArrayList<Restriction> RestrictionList;
  /**
   * A way how to say client that the server has a constant
   */
  public static class NamedConstant {
    String   name; ///< constant name with KMS_ prefix
    String   value;   ///< a value of constant
  }

  /**
   * Subscription information
   */
  public static class SubscriptionInfo {
    boolean        isUnlimited;      ///< is it a special license with expiration == never ?
    boolean        showAlert;        ///< show subscription expiration alert
    long        remainingDays;    ///< days remaining to subscription expiration
    String subscriptionDate; ///< last date of subscription
  }

  /**
   * Operating System Family
   */
  enum ServerOs {
    Windows,
    MacOs,
    Linux
  }

  /**
   * About information
   */
  public static class AboutInfo {
    long           currentUsers;     ///< number of created users on domain
    MaximumUsers      allowedUsers;     ///< number of allowed users, take stricter limit from max. number for domain, max. number by license
    String            serverSoftware;      ///< product name and version String, same as SERVER_SOFTWARE
    SubscriptionInfo  subscription;     ///< information about subscription
    String            copyright;        ///< copyright String
    String            productHomepage;  ///< url to homepage of product
  }

  /**
   * Value Type of setting Client Statistics
   */
  enum ClientStatisticsValue {
    agree,
    disagree,
    notSet
  }

  /**
   * Type of Alert
   */
  enum AlertName {
    LicenseExpired,               ///< License has expired
    LicenseInvalidMinVersion,     ///< Invalid minimal version of a product found
    LicenseInvalidEdition,        ///< The license was not issued for this edition of the product
    LicenseInvalidUser,           ///< The license was not issued for this user
    LicenseInvalidDomain,         ///< The license was not issued for this domain
    LicenseInvalidOS,          ///< The license was not issued for this operating system
    LicenseCheckForwardingEnabled,  ///< The license was not alowed forward the message to another host
    LicenseTooManyUsers,       ///< More users try login to their mailboxes then allowed License.
    StorageSpaceLow,           ///< Low space in storage
    ClientStatisticsNotSet,       ///< Administrator was not confirm Client Statistics
    SubscriptionExpired,       ///< Subscription has expired
    SubscriptionSoonExpire,       ///< Subscription soon expire
    LicenseSoonExpire,            ///< License soon expire
    CoredumpFound,             ///< Some coredump was found after crash
    MacOSServicesKeepsPorts,      ///< Apache on Lion server keeps ports (Eg. port 443), which are assigned to our services. See Services.stopMacOSServices()
    WelcomeMailKCCNotSet       ///< The welcome mail of Kerio Connect Client was not sent yet or sending was not declined yet.
  }

  /**
   * Type of Alert
   */
  enum TypeAlert {
    Warning,
    Critical
  }

  /**
   * Alert
   */
  public static class Alert {
    AlertName alertName;    ///< Alert Id
    TypeAlert alertType;    ///< Alert type
    String    currentValue;    ///< Current Value
    String    criticalValue;   ///< Critical Value
  }

  ArrayList<Alert> AlertList;
  /**
   * Potential duplicate
   */
  public static class EntityDuplicate {
    Entity   kind;    ///< which entity was found as first duplicate
    String   name;    ///< name of duplicate
    String  collisionAddress;
    boolean win;      ///< if entity is winner in this collision of mail address
    boolean isPattern;   ///< is true if it is the pattern to check (self duplicity)
  }

  ArrayList<EntityDuplicate> EntityDuplicateList;
  /**
   * Detail about entity to be checked. Kind or id must be filled.
   */
  public static class EntityDetail {
    Entity         kind;       ///< which entity is inserting
    String   id;            ///< entity global identification of updated entity
  }

  /**
   * List of server constants
   */
  public static class FolderInfo {
    String folderName;
    long referenceCount;
    boolean indexLoaded;
    ArrayList<String> users;
  }

  ArrayList<FolderInfo> FolderInfoList;

  public static class WebSession {
    String         userName;
    String         clientAddress;    ///< IPv4 address
    String         expirationTime;      ///< format dd.mm.yyyy hh:mm:ss
    WebComponent   componentType;       ///< what about CalDav, WebDav,  ActiveSync
    boolean        isSecure;         ///< is protocol secure
  }

  ArrayList<WebSession> WebSessionList;

  enum Protocol {
    protocolAdmin,
    protocolSmtp,
    protocolSmtps,
    protocolSubmission,
    protocolPop3,
    protocolPop3s,
    protocolImap,
    protocolImaps,
    protocolNntp,
    protocolNntps,
    protocolLdap,
    protocolLdaps,
    protocolHttp,
    protocolHttps,
    protocolXmpp,
    protocolXmpps
  }

  enum HttpExtension {
    NoExtension,
    WebGeneric,    ///< WebMail or WebMail Mini or WebAdmin
    WebDav,
    CalDav,
    ActiveSync,
    KocOffline,
    KBC,        ///< Kerio Connector for BlackBerry Enterprise Server
    EWS            ///< Exchange Web Services
  }

  public static class Connection {
    Protocol    proto;
    HttpExtension  extension;
    boolean        isSecure;
    String         time;
    String         from;
    String         user;
    String         description;
  }

  ArrayList<Connection> ConnectionList;

  /**
   *
   * Note: isEnabled, isLimited and groupId fields must be assigned if any of them is used in set methods
   */
  public static class Administration {
    boolean        isEnabled;     ///< administration from other that local machine is enabled/disabled
    boolean        isLimited;     ///< administration is limited
    String   groupId;    ///< IP Address Group identifier on which is limit applied
    String         groupName;     ///< [READ-ONLY] IP Address Group name on which is limit applied
    boolean        builtInAdminEnabled;       ///< if is enabled field builtInAdminPassword is required
    String         builtInAdminUsername;         ///< [READ-ONLY] user name
    String         builtInAdminPassword;         ///< password
    boolean         builtInAdminPasswordIsEmpty; ///< [READ-ONLY] password is empty
    boolean        builtInAdminUsernameCollide;  ///< [READ-ONLY] username colide with user in primary domain
  }

  enum BuildType {
    Alpha,
    Beta,
    Rc,
    Final,
    Patch
  }

  enum DeployedType {
    DeployedStandalone,  ///< Normal instalation    
    DeployedCloud,       ///< Kerio Connect is running in a cloud   
    DeployedKerioVA      ///< Kerio Connect VMWare Virtual Appliance
  }

  public static class ProductInfo {
    String productName;
    String version;
    String buildNumber;
    String osName;
    ServerOs os;
    BuildType releaseType;
    DeployedType deployedType;
    String newVersionInfoUrl;
    
    public ProductInfo() {
      
    }

    public String getProductName() {
      return productName;
    }

    public void setProductName(String productName) {
      this.productName = productName;
    }

    public String getVersion() {
      return version;
    }

    public void setVersion(String version) {
      this.version = version;
    }

    public String getBuildNumber() {
      return buildNumber;
    }

    public void setBuildNumber(String buildNumber) {
      this.buildNumber = buildNumber;
    }

    public String getOsName() {
      return osName;
    }

    public void setOsName(String osName) {
      this.osName = osName;
    }

    public ServerOs getOs() {
      return os;
    }

    public void setOs(ServerOs os) {
      this.os = os;
    }

    public BuildType getReleaseType() {
      return releaseType;
    }

    public void setReleaseType(BuildType releaseType) {
      this.releaseType = releaseType;
    }

    public DeployedType getDeployedType() {
      return deployedType;
    }

    public void setDeployedType(DeployedType deployedType) {
      this.deployedType = deployedType;
    }

    public String getNewVersionInfoUrl() {
      return newVersionInfoUrl;
    }

    public void setNewVersionInfoUrl(String newVersionInfoUrl) {
      this.newVersionInfoUrl = newVersionInfoUrl;
    }
  }

  /**
   * Server time information
   */
  public static class ServerTimeInfo {
    long timezoneOffset;       ///< +/- offset in minutes
    long startTime;      ///< +/- start time of server
    long currentTime;    ///< +/- current time on server
  }

}
