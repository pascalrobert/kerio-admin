package kerio.connect.admin.common;

import java.util.ArrayList;

public class NamedMultiValue {

  String name;
  ArrayList<String> value;
  
  public NamedMultiValue() {
    
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ArrayList<String> getValue() {
    return value;
  }

  public void setValue(ArrayList<String> value) {
    this.value = value;
  }
  
}
