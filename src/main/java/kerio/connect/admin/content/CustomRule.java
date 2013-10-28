package kerio.connect.admin.content;

import kerio.connect.admin.common.DistanceOrNull;

public class CustomRule {

  String      id;            ///< global identifier
  boolean           enabled;
  CustomRuleKind    kind;
  String            header;
  String            content;
  String            description;
  CustomRuleType    type;
  CustomRuleAction  action;
  long           score;
  DistanceOrNull    lastUsed;
  
  public CustomRule() {
    
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public boolean isEnabled() {
    return enabled;
  }

  public void setEnabled(boolean enabled) {
    this.enabled = enabled;
  }

  public CustomRuleKind getKind() {
    return kind;
  }

  public void setKind(CustomRuleKind kind) {
    this.kind = kind;
  }

  public String getHeader() {
    return header;
  }

  public void setHeader(String header) {
    this.header = header;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public CustomRuleType getType() {
    return type;
  }

  public void setType(CustomRuleType type) {
    this.type = type;
  }

  public CustomRuleAction getAction() {
    return action;
  }

  public void setAction(CustomRuleAction action) {
    this.action = action;
  }

  public long getScore() {
    return score;
  }

  public void setScore(long score) {
    this.score = score;
  }

  public DistanceOrNull getLastUsed() {
    return lastUsed;
  }

  public void setLastUsed(DistanceOrNull lastUsed) {
    this.lastUsed = lastUsed;
  }

  public enum CustomRuleKind {
    Header,
    Body
  }

  public enum CustomRuleType {
    IsEmpty,
    IsMissing,
    ContainsAddress,
    ContainsDomain,
    ContainsSubstring,
    ContainsBinary
  }

  public enum CustomRuleAction {
    TreatAsSpam,
    TreatAsNotSpam,
    IncreaseSpamScore
  }
}
