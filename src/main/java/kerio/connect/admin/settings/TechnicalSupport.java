package kerio.connect.admin.settings;

import java.util.ArrayList;

public class TechnicalSupport {
  
  public static class ProductInfo {

    String productVersion;
    String productName;
    String operatingSystem;
    String licenseNumber; // first 11 chars only
      
    public ProductInfo() {
      
    }

    public String getProductVersion() {
      return productVersion;
    }

    public void setProductVersion(String productVersion) {
      this.productVersion = productVersion;
    }

    public String getProductName() {
      return productName;
    }

    public void setProductName(String productName) {
      this.productName = productName;
    }

    public String getOperatingSystem() {
      return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
      this.operatingSystem = operatingSystem;
    }

    public String getLicenseNumber() {
      return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
      this.licenseNumber = licenseNumber;
    }
    
  }

  public static class SystemInfo {

    ArrayList<String> files;
    String description;
    
    public SystemInfo() {
      
    }

    public ArrayList<String> getFiles() {
      return files;
    }

    public void setFiles(ArrayList<String> files) {
      this.files = files;
    }

    public String getDescription() {
      return description;
    }

    public void setDescription(String description) {
      this.description = description;
    }
    
  }
  
  public static class UserInfo {

    String name;
    String email;
    
    public UserInfo() {
      
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public String getEmail() {
      return email;
    }

    public void setEmail(String email) {
      this.email = email;
    }

  }
  
}
