package kerio.connect.admin.common;

public class HomeServer {

  String id; ///< server's id
  String name; ///< server's Internet hostname
  
  public HomeServer() {
    
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
