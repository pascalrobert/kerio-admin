package kerio.connect.admin.backup;

import kerio.connect.admin.common.TimeHMS;
import kerio.connect.admin.common.enums.Day;

public class BackupSchedule {

  String id;        ///< [READ-ONLY]
  boolean isEnabled;         ///< True if backup schedule is enabled
  BackupType type;        ///< Backup type
  Day day;    ///< Backup schedule day of week
  TimeHMS time;           ///< Backup schedule start time - days are ignored!
  String description;        ///< description of the backup schedule
  
  public BackupSchedule() {
    
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public boolean isIsEnabled() {
    return isEnabled;
  }

  public void setIsEnabled(boolean isEnabled) {
    this.isEnabled = isEnabled;
  }

  public BackupType getType() {
    return type;
  }

  public void setType(BackupType type) {
    this.type = type;
  }

  public Day getDay() {
    return day;
  }

  public void setDay(Day day) {
    this.day = day;
  }

  public TimeHMS getTime() {
    return time;
  }

  public void setTime(TimeHMS time) {
    this.time = time;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public enum BackupType {
    backupTypeFull,
    backupTypeDifferential,
    backupTypeMirror
  }
}
