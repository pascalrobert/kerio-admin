package kerio.connect.admin.backup;

import kerio.connect.admin.common.Directories;

public class BackupOptions {

  Directories paths;      ///< Paths to store/archive/backup, this field is used in both, archive and backup, options
  boolean isEnabled;      ///< Enable message store and configuration recovery backup
  BackupStatus status; ///< Current backup status
  long splitSizeLimit; ///< Split backup files if size reaches 'splitSizeLimit' (MB)
  long rotationLimit;     ///< Keep at most 'rotationLimit' complete backups
  String networkDiskUserName;   ///< If the backup directory is on the network disk, you may need to specify user name
  String networkDiskPassword;   ///< ... and password
  String notificationEmailAddress; ///< An email address of person that will be notified when backup is completed or if any problems arise
  
  public BackupOptions() {
    
  }

  public Directories getPaths() {
    return paths;
  }

  public void setPaths(Directories paths) {
    this.paths = paths;
  }

  public boolean isIsEnabled() {
    return isEnabled;
  }

  public void setIsEnabled(boolean isEnabled) {
    this.isEnabled = isEnabled;
  }

  public BackupStatus getStatus() {
    return status;
  }

  public void setStatus(BackupStatus status) {
    this.status = status;
  }

  public long getSplitSizeLimit() {
    return splitSizeLimit;
  }

  public void setSplitSizeLimit(long splitSizeLimit) {
    this.splitSizeLimit = splitSizeLimit;
  }

  public long getRotationLimit() {
    return rotationLimit;
  }

  public void setRotationLimit(long rotationLimit) {
    this.rotationLimit = rotationLimit;
  }

  public String getNetworkDiskUserName() {
    return networkDiskUserName;
  }

  public void setNetworkDiskUserName(String networkDiskUserName) {
    this.networkDiskUserName = networkDiskUserName;
  }

  public String getNetworkDiskPassword() {
    return networkDiskPassword;
  }

  public void setNetworkDiskPassword(String networkDiskPassword) {
    this.networkDiskPassword = networkDiskPassword;
  }

  public String getNotificationEmailAddress() {
    return notificationEmailAddress;
  }

  public void setNotificationEmailAddress(String notificationEmailAddress) {
    this.notificationEmailAddress = notificationEmailAddress;
  }

}
