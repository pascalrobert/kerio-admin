package kerio.connect.admin.common;

public class Download {

  String url; ///< download url
  String name;   ///< filename
  long length;   ///< file size in bytes
  
  public Download() {
    
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public long getLength() {
    return length;
  }

  public void setLength(long length) {
    this.length = length;
  }
  
}
