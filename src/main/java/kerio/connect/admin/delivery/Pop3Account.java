package kerio.connect.admin.delivery;

import kerio.connect.admin.common.ByteValueWithUnits;
import kerio.connect.admin.common.OptionalLong;

public class Pop3Account {

  String      id;
  boolean           isActive;
  String            server;        ///< POP3 server name
  String            userName;      ///< username on POP3 server
  String            password;      ///< password appropriate to username
  String            description;
  String            deliveryAddress;
  boolean           useSortingRules;///< If value is true sortType will save otherwise deliveryAddress will save. Default is false.
  String            sortType;
  boolean           dropDuplicates;   ///< drop duplicate messages?
  SslMode           mode;
  long           port;
  Pop3Authentication   authentication;
  ByteValueWithUnits   messageLimit;  ///< per session download limit - total message size
  long           maxCount;      ///< per session download limit - maximum message count
  LeaveOnServer leaveOnServer;

  public Pop3Account() {

  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public boolean isActive() {
    return isActive;
  }

  public void setActive(boolean isActive) {
    this.isActive = isActive;
  }

  public String getServer() {
    return server;
  }

  public void setServer(String server) {
    this.server = server;
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

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getDeliveryAddress() {
    return deliveryAddress;
  }

  public void setDeliveryAddress(String deliveryAddress) {
    this.deliveryAddress = deliveryAddress;
  }

  public boolean isUseSortingRules() {
    return useSortingRules;
  }

  public void setUseSortingRules(boolean useSortingRules) {
    this.useSortingRules = useSortingRules;
  }

  public String getSortType() {
    return sortType;
  }

  public void setSortType(String sortType) {
    this.sortType = sortType;
  }

  public boolean isDropDuplicates() {
    return dropDuplicates;
  }

  public void setDropDuplicates(boolean dropDuplicates) {
    this.dropDuplicates = dropDuplicates;
  }

  public SslMode getMode() {
    return mode;
  }

  public void setMode(SslMode mode) {
    this.mode = mode;
  }

  public long getPort() {
    return port;
  }

  public void setPort(long port) {
    this.port = port;
  }

  public Pop3Authentication getAuthentication() {
    return authentication;
  }

  public void setAuthentication(Pop3Authentication authentication) {
    this.authentication = authentication;
  }

  public ByteValueWithUnits getMessageLimit() {
    return messageLimit;
  }

  public void setMessageLimit(ByteValueWithUnits messageLimit) {
    this.messageLimit = messageLimit;
  }

  public long getMaxCount() {
    return maxCount;
  }

  public void setMaxCount(long maxCount) {
    this.maxCount = maxCount;
  }

  public LeaveOnServer getLeaveOnServer() {
    return leaveOnServer;
  }

  public void setLeaveOnServer(LeaveOnServer leaveOnServer) {
    this.leaveOnServer = leaveOnServer;
  }

  public static class LeaveOnServer {
    boolean enabled;
    OptionalLong removeAfterPeriod;

    public LeaveOnServer() {

    }

    public boolean isEnabled() {
      return enabled;
    }

    public void setEnabled(boolean enabled) {
      this.enabled = enabled;
    }

    public OptionalLong getRemoveAfterPeriod() {
      return removeAfterPeriod;
    }

    public void setRemoveAfterPeriod(OptionalLong removeAfterPeriod) {
      this.removeAfterPeriod = removeAfterPeriod;
    }
  }

  public enum Pop3Authentication {
    PlainPop3,
    Apop
  }

  enum SslMode {
    NoSsl,
    SpecialPort,
    StlsCommand
  }

}
