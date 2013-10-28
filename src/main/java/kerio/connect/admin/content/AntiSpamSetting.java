package kerio.connect.admin.content;

import kerio.connect.admin.common.OptionalEntity;
import kerio.connect.admin.common.OptionalString;

public class AntiSpamSetting {

  boolean                 isRatingEnabled;        ///< is spam filter rating enabled?
  boolean                 isRatingRelayEnabled;      ///< is rating of messages sent from trustworthy relay agents enabled?
  long                 tagScore;
  long                 blockScore;
  OptionalString subjectPrefix;          ///< SPAM is marked with this prefix
  boolean                 sendBounce;             ///< send bounce message to the sender of SPAM?
  OptionalString quarantineAddress;         ///< forward SPAM to a Quarantine address?
  OptionalEntity customWhiteList;        ///< switchable custom white list IP group
  BlackListSetting        customBlackList;        ///< switchable custom blacklist list IP group
  boolean                 sendBounceCustom;       ///< send bounce message to the sender if rejection was done by custom rule(s)?
  OptionalString quarantineAddressCustom;   ///< forward custom rules identified SPAM to a Quarantine address?
  boolean                 useSurbl;               ///< use Spam URI Realtime Block List database?
  BayesState              filterStatus;           ///< read only: Bayesian filter status
  long                 learnedAsSpam;          ///< read only: number of messages that Bayesian filter learned as Spam
  long                 learnedAsNotSpam;       ///< read only: number of messages that Bayesian filter learned as NOT a Spam
  boolean                 isCustomSigningKey;        ///< Custom signing key is used for DKIM validation
  CallerId             callerSetting;          ///< Caller ID setting
  String                  callerUrl;              ///< read only: Caller ID URL with detailed info
  Spf                     spfSetting;             ///< Sender Policy Framework setting
  Repellent               repellentSetting;
  Greylisting             greylistingStatus;
  boolean                 useCustomRulesInSmtp;
  boolean                 isDkimEnabled;     

  public AntiSpamSetting() {

  }

  public boolean isIsRatingEnabled() {
    return isRatingEnabled;
  }

  public void setIsRatingEnabled(boolean isRatingEnabled) {
    this.isRatingEnabled = isRatingEnabled;
  }

  public boolean isIsRatingRelayEnabled() {
    return isRatingRelayEnabled;
  }

  public void setIsRatingRelayEnabled(boolean isRatingRelayEnabled) {
    this.isRatingRelayEnabled = isRatingRelayEnabled;
  }

  public long getTagScore() {
    return tagScore;
  }

  public void setTagScore(long tagScore) {
    this.tagScore = tagScore;
  }

  public long getBlockScore() {
    return blockScore;
  }

  public void setBlockScore(long blockScore) {
    this.blockScore = blockScore;
  }

  public OptionalString getSubjectPrefix() {
    return subjectPrefix;
  }

  public void setSubjectPrefix(OptionalString subjectPrefix) {
    this.subjectPrefix = subjectPrefix;
  }

  public boolean isSendBounce() {
    return sendBounce;
  }

  public void setSendBounce(boolean sendBounce) {
    this.sendBounce = sendBounce;
  }

  public OptionalString getQuarantineAddress() {
    return quarantineAddress;
  }

  public void setQuarantineAddress(OptionalString quarantineAddress) {
    this.quarantineAddress = quarantineAddress;
  }

  public OptionalEntity getCustomWhiteList() {
    return customWhiteList;
  }

  public void setCustomWhiteList(OptionalEntity customWhiteList) {
    this.customWhiteList = customWhiteList;
  }

  public BlackListSetting getCustomBlackList() {
    return customBlackList;
  }

  public void setCustomBlackList(BlackListSetting customBlackList) {
    this.customBlackList = customBlackList;
  }

  public boolean isSendBounceCustom() {
    return sendBounceCustom;
  }

  public void setSendBounceCustom(boolean sendBounceCustom) {
    this.sendBounceCustom = sendBounceCustom;
  }

  public OptionalString getQuarantineAddressCustom() {
    return quarantineAddressCustom;
  }

  public void setQuarantineAddressCustom(OptionalString quarantineAddressCustom) {
    this.quarantineAddressCustom = quarantineAddressCustom;
  }

  public boolean isUseSurbl() {
    return useSurbl;
  }

  public void setUseSurbl(boolean useSurbl) {
    this.useSurbl = useSurbl;
  }

  public BayesState getFilterStatus() {
    return filterStatus;
  }

  public void setFilterStatus(BayesState filterStatus) {
    this.filterStatus = filterStatus;
  }

  public long getLearnedAsSpam() {
    return learnedAsSpam;
  }

  public void setLearnedAsSpam(long learnedAsSpam) {
    this.learnedAsSpam = learnedAsSpam;
  }

  public long getLearnedAsNotSpam() {
    return learnedAsNotSpam;
  }

  public void setLearnedAsNotSpam(long learnedAsNotSpam) {
    this.learnedAsNotSpam = learnedAsNotSpam;
  }

  public boolean isIsCustomSigningKey() {
    return isCustomSigningKey;
  }

  public void setIsCustomSigningKey(boolean isCustomSigningKey) {
    this.isCustomSigningKey = isCustomSigningKey;
  }

  public CallerId getCallerSetting() {
    return callerSetting;
  }

  public void setCallerSetting(CallerId callerSetting) {
    this.callerSetting = callerSetting;
  }

  public String getCallerUrl() {
    return callerUrl;
  }

  public void setCallerUrl(String callerUrl) {
    this.callerUrl = callerUrl;
  }

  public Spf getSpfSetting() {
    return spfSetting;
  }

  public void setSpfSetting(Spf spfSetting) {
    this.spfSetting = spfSetting;
  }

  public Repellent getRepellentSetting() {
    return repellentSetting;
  }

  public void setRepellentSetting(Repellent repellentSetting) {
    this.repellentSetting = repellentSetting;
  }

  public Greylisting getGreylistingStatus() {
    return greylistingStatus;
  }

  public void setGreylistingStatus(Greylisting greylistingStatus) {
    this.greylistingStatus = greylistingStatus;
  }

  public boolean isUseCustomRulesInSmtp() {
    return useCustomRulesInSmtp;
  }

  public void setUseCustomRulesInSmtp(boolean useCustomRulesInSmtp) {
    this.useCustomRulesInSmtp = useCustomRulesInSmtp;
  }

  public boolean isIsDkimEnabled() {
    return isDkimEnabled;
  }

  public void setIsDkimEnabled(boolean isDkimEnabled) {
    this.isDkimEnabled = isDkimEnabled;
  }

  public static class Greylisting {
    boolean enabled;        ///< is greylisting enabled? 
    OptionalEntity customWhiteList; ///< switchable custom whitelist IP group
    GreylistingState state;    ///< read only: current state
    String messagesAccepted;   ///< read only: messages accepted
    String messagesDelayed;    ///< read only: messages temoprarily rejected
    String messagesSkipped;    ///< read only: messages skipped
    
    public Greylisting() {
      
    }

    public boolean isEnabled() {
      return enabled;
    }

    public void setEnabled(boolean enabled) {
      this.enabled = enabled;
    }

    public OptionalEntity getCustomWhiteList() {
      return customWhiteList;
    }

    public void setCustomWhiteList(OptionalEntity customWhiteList) {
      this.customWhiteList = customWhiteList;
    }

    public GreylistingState getState() {
      return state;
    }

    public void setState(GreylistingState state) {
      this.state = state;
    }

    public String getMessagesAccepted() {
      return messagesAccepted;
    }

    public void setMessagesAccepted(String messagesAccepted) {
      this.messagesAccepted = messagesAccepted;
    }

    public String getMessagesDelayed() {
      return messagesDelayed;
    }

    public void setMessagesDelayed(String messagesDelayed) {
      this.messagesDelayed = messagesDelayed;
    }

    public String getMessagesSkipped() {
      return messagesSkipped;
    }

    public void setMessagesSkipped(String messagesSkipped) {
      this.messagesSkipped = messagesSkipped;
    }
  }

  public static class Repellent {
    boolean                 enabled;
    long                 delay;
    OptionalEntity customWhiteList;        ///< switchable custom white list IP group
    boolean                 reportToSecurity;       ///< do (not) report a spam attack to security log
    
    public Repellent() {
      
    }

    public boolean isEnabled() {
      return enabled;
    }

    public void setEnabled(boolean enabled) {
      this.enabled = enabled;
    }

    public long getDelay() {
      return delay;
    }

    public void setDelay(long delay) {
      this.delay = delay;
    }

    public OptionalEntity getCustomWhiteList() {
      return customWhiteList;
    }

    public void setCustomWhiteList(OptionalEntity customWhiteList) {
      this.customWhiteList = customWhiteList;
    }

    public boolean isReportToSecurity() {
      return reportToSecurity;
    }

    public void setReportToSecurity(boolean reportToSecurity) {
      this.reportToSecurity = reportToSecurity;
    }
  }

  public static class Spf {
    boolean                 enabled;
    SpamAction              action;
    long                 score;
    OptionalEntity exceptionIpGroup;       ///< switchable custom white list IP group
    
    public Spf() {
      
    }

    public boolean isEnabled() {
      return enabled;
    }

    public void setEnabled(boolean enabled) {
      this.enabled = enabled;
    }

    public SpamAction getAction() {
      return action;
    }

    public void setAction(SpamAction action) {
      this.action = action;
    }

    public long getScore() {
      return score;
    }

    public void setScore(long score) {
      this.score = score;
    }

    public OptionalEntity getExceptionIpGroup() {
      return exceptionIpGroup;
    }

    public void setExceptionIpGroup(OptionalEntity exceptionIpGroup) {
      this.exceptionIpGroup = exceptionIpGroup;
    }
  }

  public static class BlackListSetting {
    boolean        enabled;
    String   id;         ///< global identifier
    String         name;
    BlockOrScore   action;
    long        score;
    
    public BlackListSetting() {
      
    }

    public boolean isEnabled() {
      return enabled;
    }

    public void setEnabled(boolean enabled) {
      this.enabled = enabled;
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

    public BlockOrScore getAction() {
      return action;
    }

    public void setAction(BlockOrScore action) {
      this.action = action;
    }

    public long getScore() {
      return score;
    }

    public void setScore(long score) {
      this.score = score;
    }
  }

  public static class CallerId {
    boolean                 enabled;
    SpamAction              action;
    long                 score;
    boolean                 applyOnTesting;
    OptionalEntity exceptionIpGroup;       ///< switchable custom white list IP group
    
    public CallerId() {
      
    }

    public boolean isEnabled() {
      return enabled;
    }

    public void setEnabled(boolean enabled) {
      this.enabled = enabled;
    }

    public SpamAction getAction() {
      return action;
    }

    public void setAction(SpamAction action) {
      this.action = action;
    }

    public long getScore() {
      return score;
    }

    public void setScore(long score) {
      this.score = score;
    }

    public boolean isApplyOnTesting() {
      return applyOnTesting;
    }

    public void setApplyOnTesting(boolean applyOnTesting) {
      this.applyOnTesting = applyOnTesting;
    }

    public OptionalEntity getExceptionIpGroup() {
      return exceptionIpGroup;
    }

    public void setExceptionIpGroup(OptionalEntity exceptionIpGroup) {
      this.exceptionIpGroup = exceptionIpGroup;
    }
  }

  public enum  BlockOrScore {
    BlockMessage,  ///< block the message
    ScoreMessage   ///< add SPAM score to the message
  }

  public enum SpamAction {
    LogToSecurity, ///< only log to security log
    BlockAction,   ///< block the meassage
    ScoreAction    ///< increase spam score
  }

  public enum BayesState {
    Learning,
    Active
  }

  public enum GreylistingState {
    GreylistingOff,
    GreylistingOn,
    GreylistingError     ///< Greylisting encountered an error. Call Content.testGreylistConnection() for a more detailed error description.
  }

}
