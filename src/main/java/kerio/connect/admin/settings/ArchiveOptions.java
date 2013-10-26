package kerio.connect.admin.settings;

import kerio.connect.admin.common.Directories;
import kerio.connect.admin.common.OptionalString;
import kerio.connect.admin.common.Time;

public class ArchiveOptions {

  Directories paths;               ///< Paths to store/archive/backup
  boolean isEnabled;               ///< Enable mail archiving
  OptionalString remoteArchive; ///< Archive to remote email address
  boolean archiveToLocalFolder;    ///< Archive to local folder
  DayWeekMonthPeriod archiveFoldersInterval;   ///< Interval used for creating of new archive folders (in days/weeks/months)
  boolean compressOldArchiveFolders;  ///< Compress old archive folders
  Time compressionStartTime; ///< Time in the day when an archive compression shall start
  boolean archiveLocalMessages;    ///< Local messages (local sender, local recipient)
  boolean archiveIncomingMessages; ///< Incoming messages (remote sender, local recipient)
  boolean archiveOutgoingMessages; ///< Outgoing messages (local sender, remote recipient)
  boolean archiveRelayedMessages;     ///< Relayed messages (remote sender, remote recipient)
  boolean archiveBeforeFilter;     ///< Archive messages before content filter check (viruses and spams will be stored intact in the archive folders)
  
  public ArchiveOptions() {
    
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


  public void setIEnabled(boolean isEnabled) {
    this.isEnabled = isEnabled;
  }


  public OptionalString getRemoteArchive() {
    return remoteArchive;
  }


  public void setRemoteArchive(OptionalString remoteArchive) {
    this.remoteArchive = remoteArchive;
  }


  public boolean isArchiveToLocalFolder() {
    return archiveToLocalFolder;
  }


  public void setArchiveToLocalFolder(boolean archiveToLocalFolder) {
    this.archiveToLocalFolder = archiveToLocalFolder;
  }


  public DayWeekMonthPeriod getArchiveFoldersInterval() {
    return archiveFoldersInterval;
  }


  public void setArchiveFoldersInterval(DayWeekMonthPeriod archiveFoldersInterval) {
    this.archiveFoldersInterval = archiveFoldersInterval;
  }


  public boolean isCompressOldArchiveFolders() {
    return compressOldArchiveFolders;
  }


  public void setCompressOldArchiveFolders(boolean compressOldArchiveFolders) {
    this.compressOldArchiveFolders = compressOldArchiveFolders;
  }


  public Time getCompressionStartTime() {
    return compressionStartTime;
  }


  public void setCompressionStartTime(Time compressionStartTime) {
    this.compressionStartTime = compressionStartTime;
  }


  public boolean isArchiveLocalMessages() {
    return archiveLocalMessages;
  }


  public void setArchiveLocalMessages(boolean archiveLocalMessages) {
    this.archiveLocalMessages = archiveLocalMessages;
  }


  public boolean isArchiveIncomingMessages() {
    return archiveIncomingMessages;
  }


  public void setArchiveIncomingMessages(boolean archiveIncomingMessages) {
    this.archiveIncomingMessages = archiveIncomingMessages;
  }


  public boolean isArchiveOutgoingMessages() {
    return archiveOutgoingMessages;
  }


  public void setArchiveOutgoingMessages(boolean archiveOutgoingMessages) {
    this.archiveOutgoingMessages = archiveOutgoingMessages;
  }


  public boolean isArchiveRelayedMessages() {
    return archiveRelayedMessages;
  }


  public void setArchiveRelayedMessages(boolean archiveRelayedMessages) {
    this.archiveRelayedMessages = archiveRelayedMessages;
  }


  public boolean isArchiveBeforeFilter() {
    return archiveBeforeFilter;
  }


  public void setArchiveBeforeFilter(boolean archiveBeforeFilter) {
    this.archiveBeforeFilter = archiveBeforeFilter;
  }

  public enum DayWeekMonthPeriod {
    periodDay,
    periodWeek,
    periodMonth
  }

}
