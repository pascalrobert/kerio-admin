package kerio.connect.admin.common;

public class Directories {

  String storePath; ///< Path to the store directory
  String archivePath;  ///< Path to the archive directory
  String backupPath;   ///< Path to the backup directory
  
  public Directories() {
    
  }

  public String getStorePath() {
    return storePath;
  }

  public void setStorePath(String storePath) {
    this.storePath = storePath;
  }

  public String getArchivePath() {
    return archivePath;
  }

  public void setArchivePath(String archivePath) {
    this.archivePath = archivePath;
  }

  public String getBackupPath() {
    return backupPath;
  }

  public void setBackupPath(String backupPath) {
    this.backupPath = backupPath;
  }

}
