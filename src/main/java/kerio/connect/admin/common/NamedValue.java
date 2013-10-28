package kerio.connect.admin.common;

public class NamedValue {

  String name;
  String value;
  
  public NamedValue() {
    
  }
  
  public NamedValue(String name, String value) {
    this.name = name;
    this.value = value;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }
  
}
