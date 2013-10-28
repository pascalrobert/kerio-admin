package kerio.connect.admin.content;

public class AttachmentItem {

  String            id;
  boolean           enabled;    ///< the rule is in use
  AttachmentType    type;       ///< type of the rule
  String            content;    ///< *,? wildcards are supported
  AttachmentAction  action;        ///< what to do if the rule maches
  String            description;   ///<

  public AttachmentItem() {
    
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

  public AttachmentType getType() {
    return type;
  }

  public void setType(AttachmentType type) {
    this.type = type;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public AttachmentAction getAction() {
    return action;
  }

  public void setAction(AttachmentAction action) {
    this.action = action;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public enum AttachmentAction {
    Block,
    Accept
  }

  public enum AttachmentType {
    FileName,
    MimeType
  }

}
