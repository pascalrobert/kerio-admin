package kerio.connect.admin.content;

import kerio.connect.admin.common.OptionalString;

public class AttachmentSetting {

  boolean                 enabled;       ///< attachment filter is on/off
  boolean                 warnSender;       ///< sender will (not) obtain warning message
  OptionalString forwardOriginal;  ///< where to forward original message
  OptionalString forwardFiltered;  ///< where to forward filtered message
  
  public AttachmentSetting() {
    
  }

  public boolean isEnabled() {
    return enabled;
  }

  public void setEnabled(boolean enabled) {
    this.enabled = enabled;
  }

  public boolean isWarnSender() {
    return warnSender;
  }

  public void setWarnSender(boolean warnSender) {
    this.warnSender = warnSender;
  }

  public OptionalString getForwardOriginal() {
    return forwardOriginal;
  }

  public void setForwardOriginal(OptionalString forwardOriginal) {
    this.forwardOriginal = forwardOriginal;
  }

  public OptionalString getForwardFiltered() {
    return forwardFiltered;
  }

  public void setForwardFiltered(OptionalString forwardFiltered) {
    this.forwardFiltered = forwardFiltered;
  }

}
