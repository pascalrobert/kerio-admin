package kerio.connect.admin.settings;

public class Version {

  long ApiVersion;
  ProductVersion productVersion;
  
  public Version() {
    
  }

  public long getApiVersion() {
    return ApiVersion;
  }

  public void setApiVersion(long apiVersion) {
    ApiVersion = apiVersion;
  }

  public ProductVersion getProductVersion() {
    return productVersion;
  }

  public void setProductVersion(ProductVersion productVersion) {
    this.productVersion = productVersion;
  }
  
  public enum BuildType {

    Alpha,
    Beta,
    Rc,
    Final,
    Patch
    
  }

  public static class ProductVersion {

    String productName;     ///< e.g. "Kerio Connect"
    long major;             ///< e.g. 7
    long minor;             ///< e.g. 4
    long revision;          ///< e.g. 0
    long build;             ///< e.g. 4528
    long order;          ///< e.g. 1 for alpha/beta/rc/patch 1
    BuildType releaseType;  ///< e.g. Patch
    String displayNumber;   ///< e.g. "7.4.0 patch 1"
    
    public ProductVersion() {
      
    }

    public String getProductName() {
      return productName;
    }

    public void setProductName(String productName) {
      this.productName = productName;
    }

    public long getMajor() {
      return major;
    }

    public void setMajor(long major) {
      this.major = major;
    }

    public long getMinor() {
      return minor;
    }

    public void setMinor(long minor) {
      this.minor = minor;
    }

    public long getRevision() {
      return revision;
    }

    public void setRevision(long revision) {
      this.revision = revision;
    }

    public long getBuild() {
      return build;
    }

    public void setBuild(long build) {
      this.build = build;
    }

    public long getOrder() {
      return order;
    }

    public void setOrder(long order) {
      this.order = order;
    }

    public BuildType getReleaseType() {
      return releaseType;
    }

    public void setReleaseType(BuildType releaseType) {
      this.releaseType = releaseType;
    }

    public String getDisplayNumber() {
      return displayNumber;
    }

    public void setDisplayNumber(String displayNumber) {
      this.displayNumber = displayNumber;
    }

  }

  
}
