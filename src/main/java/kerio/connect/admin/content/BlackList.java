package kerio.connect.admin.content;

import kerio.connect.admin.content.AntiSpamSetting.BlockOrScore;

public class BlackList {

  String      id;            ///< global identifier
  boolean           enabled;
  String            dnsSuffix;
  String            description;
  BlockOrScore      action;        ///< what to do if IP address is found on blacklist
  long           score;
  boolean           askDirectly;
  
  public BlackList() {
    
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

  public String getDnsSuffix() {
    return dnsSuffix;
  }

  public void setDnsSuffix(String dnsSuffix) {
    this.dnsSuffix = dnsSuffix;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
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

  public boolean isAskDirectly() {
    return askDirectly;
  }

  public void setAskDirectly(boolean askDirectly) {
    this.askDirectly = askDirectly;
  }


}
