package kerio.connect.admin.mailinglists;

import java.util.ArrayList;

import kerio.connect.admin.common.HomeServer;
import kerio.connect.admin.common.enums.DataSource;

public class Ml {

  String         id;               ///< [READ-ONLY] global identification of ML
  String         domainId;         ///< [REQUIRED FOR CREATE] [WRITE-ONCE] identification in which domain ML exists
  String               name;          ///< [REQUIRED FOR CREATE] [WRITE-ONCE] ML name, name@domain is email address
  String               description;      ///< description
  String         languageId;       ///< language to be spoken withing mailing list
  String               welcomeString;    ///< String to be sent as welcome of a new memeber
  String               footerString;     ///< String to be sent as footer of each contribution
  SubscriptionPolicy      subscription;     ///< type of ML subscription policy
  PostingPolicy        posting;       ///< type of ML posting policy
  MlReplyTo            replyTo;       ///< how should be replied to
  String               otherAddress;     ///< if replyTo is OtherAddress, it contains email address
  String               subjectPrefix;    ///< prefix for each subject
  boolean              hideSenderAddress;   ///< replace sender's email address by ML address
  boolean              allowEmptySubject;   ///< allow posting with empty subject
  ArchiveSettings         archive;       ///< archive settings
  long              membersCount;     ///< [READ-ONLY] Number of members.
  HomeServer           homeServer;       ///< [READ-ONLY] Id of users homeserver if server is in Cluster

  public Ml() {

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

  public String getLanguageId() {
    return languageId;
  }

  public void setLanguageId(String languageId) {
    this.languageId = languageId;
  }

  public String getWelcomeString() {
    return welcomeString;
  }

  public void setWelcomeString(String welcomeString) {
    this.welcomeString = welcomeString;
  }

  public String getFooterString() {
    return footerString;
  }

  public void setFooterString(String footerString) {
    this.footerString = footerString;
  }

  public SubscriptionPolicy getSubscription() {
    return subscription;
  }

  public void setSubscription(SubscriptionPolicy subscription) {
    this.subscription = subscription;
  }

  public PostingPolicy getPosting() {
    return posting;
  }

  public void setPosting(PostingPolicy posting) {
    this.posting = posting;
  }

  public MlReplyTo getReplyTo() {
    return replyTo;
  }

  public void setReplyTo(MlReplyTo replyTo) {
    this.replyTo = replyTo;
  }

  public String getOtherAddress() {
    return otherAddress;
  }

  public void setOtherAddress(String otherAddress) {
    this.otherAddress = otherAddress;
  }

  public String getSubjectPrefix() {
    return subjectPrefix;
  }

  public void setSubjectPrefix(String subjectPrefix) {
    this.subjectPrefix = subjectPrefix;
  }

  public boolean isHideSenderAddress() {
    return hideSenderAddress;
  }

  public void setHideSenderAddress(boolean hideSenderAddress) {
    this.hideSenderAddress = hideSenderAddress;
  }

  public boolean isAllowEmptySubject() {
    return allowEmptySubject;
  }

  public void setAllowEmptySubject(boolean allowEmptySubject) {
    this.allowEmptySubject = allowEmptySubject;
  }

  public ArchiveSettings getArchive() {
    return archive;
  }

  public void setArchive(ArchiveSettings archive) {
    this.archive = archive;
  }

  public long getMembersCount() {
    return membersCount;
  }

  public void setMembersCount(long membersCount) {
    this.membersCount = membersCount;
  }

  public HomeServer getHomeServer() {
    return homeServer;
  }

  public void setHomeServer(HomeServer homeServer) {
    this.homeServer = homeServer;
  }

  /**
   * Mailing List (=ML) Action Access Right Type
   */
  public enum MlPermission {
    Allowed, ///< certain action is allowed
    Moderated,  ///< certain action must be approved by moderator
    Denied      ///< certain action is denied
  }
  
  /**
   * Moderator Posting Access Right Type
   */
  public enum ModeratorPermission {
    PostAllowed,            ///< certain action is allowed
    PostModerated,          ///< certain action must be approved by moderator
    PostAccordingMembership    ///< certain action is ruled according modarator membership
  }
  
  /**
   * ML Addressee Type
   */
  public enum MlReplyTo {
    Sender,        ///< email address of the sender
    ThisList,      ///< email address of the ML
    OtherAddress,  ///< the address of the original sender will be substituted by a user defined email address
    SenderThisList ///< Sender + ThisList
  }
  
  /**
   * Type of Mailing List Membership
   */
  public enum MlMembership {
    Member,           ///< obtains contributions
    Moderator         ///< can manipulate with members but does not obtain contributions
  }
  
  /**
   * ML member
   */
  public static class UserOrEmail {
    boolean        hasId;      ///< is a real user or email address only?
    String      userId;     ///< global user identification
    String         emailAddress;  ///< email address, filled only if hasId is false
    String         fullName;      ///< fullName of user or associated email
    MlMembership   kind;       ///< a kind of membership
    
    public UserOrEmail() {
      
    }

    public boolean isHasId() {
      return hasId;
    }

    public void setHasId(boolean hasId) {
      this.hasId = hasId;
    }

    public String getUserId() {
      return userId;
    }

    public void setUserId(String userId) {
      this.userId = userId;
    }

    public String getEmailAddress() {
      return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
      this.emailAddress = emailAddress;
    }

    public String getFullName() {
      return fullName;
    }

    public void setFullName(String fullName) {
      this.fullName = fullName;
    }

    public MlMembership getKind() {
      return kind;
    }

    public void setKind(MlMembership kind) {
      this.kind = kind;
    }
  }
  
  /**
   * A ML member being imported from CSV file.
   */
  public static class MLMemberImportee {
    UserOrEmail member;     ///< ML member data
    boolean  isImportable;  ///< ML member can be imported
    String   message;    ///< error message if ML member is not importable
  }
  
  /**
   * type indicator
   */
  public enum TrusteeKind {
    TrusteeUser,   // the type is the user
    TrusteeGroup   // the type is the group
  }
  
  /**
   * Entities that have access rights to read ML archive
   */
  public static class Trustee {
    TrusteeKind kind;       ///< is user or group?
    String   readerId;   ///< group or user KId
    String displayString;      ///< login name or group name with domain name
    boolean     isEnabled;      ///< true if user account is enabled
    DataSource  itemSource;    ///< internal/LDAP
    
    public Trustee() {
      
    }

    public TrusteeKind getKind() {
      return kind;
    }

    public void setKind(TrusteeKind kind) {
      this.kind = kind;
    }

    public String getReaderId() {
      return readerId;
    }

    public void setReaderId(String readerId) {
      this.readerId = readerId;
    }

    public String getDisplayString() {
      return displayString;
    }

    public void setDisplayString(String displayString) {
      this.displayString = displayString;
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
  }
  
  /**
   * Trustee target can be user or group
   */
  public static class TrusteeTarget {
    String   id;            ///< unique identifier
    TrusteeKind    type;       ///< is user or group?
    String         name;       ///< loginName for the User, name in square brackets for the Group
    String         fullName;      ///< fullname for the User, empty String for the Group
    String         description;   ///< description of User/Group
    boolean        isEnabled;     ///< is the User/Group enabled?
    DataSource     itemSource;    ///< is the User/Group stored internally or by LDAP?
    HomeServer     homeServer;    ///< id of users homeserver if server is in Cluster; groups haven't homeserver
    
    public TrusteeTarget() {
      
    }

    public String getId() {
      return id;
    }

    public void setId(String id) {
      this.id = id;
    }

    public TrusteeKind getType() {
      return type;
    }

    public void setType(TrusteeKind type) {
      this.type = type;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
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

    public HomeServer getHomeServer() {
      return homeServer;
    }

    public void setHomeServer(HomeServer homeServer) {
      this.homeServer = homeServer;
    }
  }
    
  /**
   * Rules for subscription
   */
  public static class SubscriptionPolicy {
    MlPermission   type;
    boolean        moderatorReview;
    boolean        moderatorNotification;
    
    public SubscriptionPolicy() {
      
    }

    public MlPermission getType() {
      return type;
    }

    public void setType(MlPermission type) {
      this.type = type;
    }

    public boolean isModeratorReview() {
      return moderatorReview;
    }

    public void setModeratorReview(boolean moderatorReview) {
      this.moderatorReview = moderatorReview;
    }

    public boolean isModeratorNotification() {
      return moderatorNotification;
    }

    public void setModeratorNotification(boolean moderatorNotification) {
      this.moderatorNotification = moderatorNotification;
    }
  }
  
  /**
   * Rules for posting
   */
  public static class PostingPolicy {
    MlPermission      memberPosting;          ///< posting policy for ML member(s)
    MlPermission      nonMemberPosting;       ///< posting policy for ML non-member(s)
    ModeratorPermission  moderatorPosting;       ///< posting policy for ML moderator(s)
    boolean           userPostingNotification;   ///< notify user that the posting will be reviewed by a moderator
    boolean           sendErrorsToModerator;     ///< send delivery errors to moderator(s)
    
    public PostingPolicy() {
      
    }

    public MlPermission getMemberPosting() {
      return memberPosting;
    }

    public void setMemberPosting(MlPermission memberPosting) {
      this.memberPosting = memberPosting;
    }

    public MlPermission getNonMemberPosting() {
      return nonMemberPosting;
    }

    public void setNonMemberPosting(MlPermission nonMemberPosting) {
      this.nonMemberPosting = nonMemberPosting;
    }

    public ModeratorPermission getModeratorPosting() {
      return moderatorPosting;
    }

    public void setModeratorPosting(ModeratorPermission moderatorPosting) {
      this.moderatorPosting = moderatorPosting;
    }

    public boolean isUserPostingNotification() {
      return userPostingNotification;
    }

    public void setUserPostingNotification(boolean userPostingNotification) {
      this.userPostingNotification = userPostingNotification;
    }

    public boolean isSendErrorsToModerator() {
      return sendErrorsToModerator;
    }

    public void setSendErrorsToModerator(boolean sendErrorsToModerator) {
      this.sendErrorsToModerator = sendErrorsToModerator;
    }
  }
  
  /**
   * How is the archive organized?
   */
  public static class ArchiveSettings {
    boolean     keepArchive;            ///< maintain archive
    boolean     archiveOnlyForLogged;      ///< the archive is available for logged users only
    ArrayList<Trustee> archiveReaderList;         ///< list of archive readers, can be either user or group, meaningful only if onlyForLogged is true
    
    public ArchiveSettings() {
      
    }

    public boolean isKeepArchive() {
      return keepArchive;
    }

    public void setKeepArchive(boolean keepArchive) {
      this.keepArchive = keepArchive;
    }

    public boolean isArchiveOnlyForLogged() {
      return archiveOnlyForLogged;
    }

    public void setArchiveOnlyForLogged(boolean archiveOnlyForLogged) {
      this.archiveOnlyForLogged = archiveOnlyForLogged;
    }

    public ArrayList<Trustee> getArchiveReaderList() {
      return archiveReaderList;
    }

    public void setArchiveReaderList(ArrayList<Trustee> archiveReaderList) {
      this.archiveReaderList = archiveReaderList;
    }
  }

}
