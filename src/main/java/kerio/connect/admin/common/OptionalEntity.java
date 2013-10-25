package kerio.connect.admin.common;

public class OptionalEntity {

  boolean enabled;
  String      id;         ///< global identifier
  String   name;
  
  public OptionalEntity() {
    
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

}
