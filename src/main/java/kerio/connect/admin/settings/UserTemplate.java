package kerio.connect.admin.settings;

import java.util.ArrayList;

import kerio.connect.admin.common.IdEntity;
import kerio.connect.admin.common.SizeLimit;
import kerio.connect.admin.common.UserAuthType;
import kerio.connect.admin.users.User.CleanOut;
import kerio.connect.admin.users.User.EmailForwarding;
import kerio.connect.admin.users.User.ItemCountLimit;
import kerio.connect.admin.users.User.UserGroup;
import kerio.connect.admin.users.User.UserRight;

public class UserTemplate {

  String         id;
  String               name;             ///< [REQUIRED FOR CREATE] [USED BY QUICKSEARCH] name of template (displayed in list of templates)
  String               description;         ///< [USED BY QUICKSEARCH] description of template (displayed after its selection)
  UserAuthType         authType;            ///< supported values must be retrieved from engine by ServerInfo::getSupportedAuthTypes()
  boolean              isPasswordReversible;   ///< typically SHA
  boolean              hasDefaultSpamRule;     ///< should be spam rule enabled?
  UserRight           role;             ///< list of user roles (excluding public/archive folder rights)
  ValidFor          scope;               ///< scope of template
  String         domainId;            ///< not relevant for templating, only for filter (condition)
  ArrayList<String> emailAddresses;         ///< filled only if domain is set
  ArrayList<UserGroup>       userGroups;          ///< filled only if domain is set
  EmailForwarding         emailForwarding;     ///< email forwarding setting
  ItemCountLimit       itemLimit;           ///< max. number of items
  SizeLimit   diskSizeLimit;       ///< max. disk usage
  boolean              hasDomainRestriction;   ///< user can send/receive from/to his domain only
  SizeLimit   outMessageLimit;     ///< limit of outgoing message
  boolean              publishInGal;        ///< publish user in global address list
  CleanOut          cleanOutItems;       ///< Items clean-out settings
  boolean              allowPasswordChange; ///< if it is set to false the password can be changed only by the administrator
  IdEntity          accessPolicy;        ///< ID and name of Access Policy applied for user. Only ID is writable.

  public UserTemplate() {

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

  public UserAuthType getAuthType() {
    return authType;
  }

  public void setAuthType(UserAuthType authType) {
    this.authType = authType;
  }

  public boolean isIsPasswordReversible() {
    return isPasswordReversible;
  }

  public void setIsPasswordReversible(boolean isPasswordReversible) {
    this.isPasswordReversible = isPasswordReversible;
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

  public ValidFor getScope() {
    return scope;
  }

  public void setScope(ValidFor scope) {
    this.scope = scope;
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

  public ArrayList<UserGroup> getUserGroups() {
    return userGroups;
  }

  public void setUserGroups(ArrayList<UserGroup> userGroups) {
    this.userGroups = userGroups;
  }

  public EmailForwarding getEmailForwarding() {
    return emailForwarding;
  }

  public void setEmailForwarding(EmailForwarding emailForwarding) {
    this.emailForwarding = emailForwarding;
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

  public boolean isAllowPasswordChange() {
    return allowPasswordChange;
  }

  public void setAllowPasswordChange(boolean allowPasswordChange) {
    this.allowPasswordChange = allowPasswordChange;
  }

  public IdEntity getAccessPolicy() {
    return accessPolicy;
  }

  public void setAccessPolicy(IdEntity accessPolicy) {
    this.accessPolicy = accessPolicy;
  }
  
  public enum ValidFor {

    OneDomain,
    AllDomains
    
  }


}
