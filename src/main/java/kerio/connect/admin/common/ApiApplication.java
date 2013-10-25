package kerio.connect.admin.common;

public class ApiApplication {

  private String _name;
  private String _vendor;
  private String _version;

  public ApiApplication(String name, String vendor, String version) {
    _name = name;
    _vendor = vendor;
    _version = version;
  }

  public String getName() {
    return _name;
  }

  public void setName(String name) {
    _name = name;
  }

  public String getVendor() {
    return _vendor;
  }

  public void setVendor(String vendor) {
    _vendor = vendor;
  }

  public String getVersion() {
    return _version;
  }

  public void setVersion(String version) {
    _version = version;
  }

}
