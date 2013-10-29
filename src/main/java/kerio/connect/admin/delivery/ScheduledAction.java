package kerio.connect.admin.delivery;

public class ScheduledAction {

  String   id;
  boolean        isActive;      ///< record is active
  String         description;
  TimeCondition  condition;
  boolean        allowDialUp;   ///< allow to establish dial-up connection if necessary
  ScheduledActionAction action;

  public ScheduledAction() {

  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public boolean isIsActive() {
    return isActive;
  }

  public void setIsActive(boolean isActive) {
    this.isActive = isActive;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public TimeCondition getCondition() {
    return condition;
  }

  public void setCondition(TimeCondition condition) {
    this.condition = condition;
  }

  public boolean isAllowDialUp() {
    return allowDialUp;
  }

  public void setAllowDialUp(boolean allowDialUp) {
    this.allowDialUp = allowDialUp;
  }

  public ScheduledActionAction getAction() {
    return action;
  }

  public void setAction(ScheduledActionAction action) {
    this.action = action;
  }

  public static class TimeCondition {
    TriggerType    type;
    long        number;     ///< for type "every"
    TiedTimeUnit   units;      ///< for type "every"
    long        minutes; ///< for type "at"
    long        hours;      ///< for type "at"
    boolean        isLimited;  ///< is trigger limited to specified time range?
    String   groupId; ///< time range identifier; (ID should be ok because should show all available time ranges anyway)
  }

  public static class ScheduledActionAction {

    boolean        sendFromQueue; ///< send messages from outgoing queue
    boolean        pop3Download;  ///< download messages from POP3 mailboxes
    boolean        sendEtrn;      ///< send ETRN command to invoke mail transfer

    public ScheduledActionAction() {

    }

    public boolean isSendFromQueue() {
      return sendFromQueue;
    }

    public void setSendFromQueue(boolean sendFromQueue) {
      this.sendFromQueue = sendFromQueue;
    }

    public boolean isPop3Download() {
      return pop3Download;
    }

    public void setPop3Download(boolean pop3Download) {
      this.pop3Download = pop3Download;
    }

    public boolean isSendEtrn() {
      return sendEtrn;
    }

    public void setSendEtrn(boolean sendEtrn) {
      this.sendEtrn = sendEtrn;
    }
  }

  public enum TiedTimeUnit {
    TMinutes,
    THours
  }

  public enum TriggerType {
    Every,
    At
  }

}
