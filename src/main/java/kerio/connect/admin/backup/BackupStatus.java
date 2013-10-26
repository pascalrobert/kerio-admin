package kerio.connect.admin.backup;

import kerio.connect.admin.common.ByteValueWithUnits;
import kerio.connect.admin.common.Distance;

public class BackupStatus {

  boolean backupInProgress;     ///< True, if backup is in progress; otherwise, false
  long percents;             ///< Backup progress in percents (form 0 to 100)
  LastBackupStatus lastBackupStatus;  ///< Status of the last backup run
  Distance elapsedTime;         ///< Time from last started backup
  Distance remainingTime;       ///< Approximated time to end of current backup
  BackupInfo lastFull;       ///< Information about last full backup
  BackupInfo lastDifferential;  ///< Information about last differential backup
  BackupInfo lastMirror;        ///< Information about last mirror backup
  
  public BackupStatus() {
    
  }

  public boolean isBackupInProgress() {
    return backupInProgress;
  }

  public void setBackupInProgress(boolean backupInProgress) {
    this.backupInProgress = backupInProgress;
  }

  public long getPercents() {
    return percents;
  }

  public void setPercents(long percents) {
    this.percents = percents;
  }

  public LastBackupStatus getLastBackupStatus() {
    return lastBackupStatus;
  }

  public void setLastBackupStatus(LastBackupStatus lastBackupStatus) {
    this.lastBackupStatus = lastBackupStatus;
  }

  public Distance getElapsedTime() {
    return elapsedTime;
  }

  public void setElapsedTime(Distance elapsedTime) {
    this.elapsedTime = elapsedTime;
  }

  public Distance getRemainingTime() {
    return remainingTime;
  }

  public void setRemainingTime(Distance remainingTime) {
    this.remainingTime = remainingTime;
  }

  public BackupInfo getLastFull() {
    return lastFull;
  }

  public void setLastFull(BackupInfo lastFull) {
    this.lastFull = lastFull;
  }

  public BackupInfo getLastDifferential() {
    return lastDifferential;
  }

  public void setLastDifferential(BackupInfo lastDifferential) {
    this.lastDifferential = lastDifferential;
  }

  public BackupInfo getLastMirror() {
    return lastMirror;
  }

  public void setLastMirror(BackupInfo lastMirror) {
    this.lastMirror = lastMirror;
  }

  public enum LastBackupStatus {
    backupStatusNone,
    backupStatusSuccessful,
    backupStatusFailed
  }

  public static class BackupInfo {
    boolean isCreated;                  ///< True, if backup was successfully created
    String created;             ///< Time when backup started (always in GTM)
    ByteValueWithUnits size;   ///< Compressed size of a backup
    
    public BackupInfo() {
      
    }

    public boolean isIsCreated() {
      return isCreated;
    }

    public void setIsCreated(boolean isCreated) {
      this.isCreated = isCreated;
    }

    public String getCreated() {
      return created;
    }

    public void setCreated(String created) {
      this.created = created;
    }

    public ByteValueWithUnits getSize() {
      return size;
    }

    public void setSize(ByteValueWithUnits size) {
      this.size = size;
    }
  }

}
