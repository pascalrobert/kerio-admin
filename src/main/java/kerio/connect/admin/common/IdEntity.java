package kerio.connect.admin.common;

public class IdEntity {

  String id;     ///< global identifier of entity
  String name;         ///< [READ-ONLY] name or description of entity
  
  public IdEntity() {
    
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
