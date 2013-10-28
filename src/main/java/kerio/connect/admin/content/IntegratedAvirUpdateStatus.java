package kerio.connect.admin.content;

public class IntegratedAvirUpdateStatus {

  UpdateStatus status;                ///< state of update process
  long percent;                       ///< percent of downloaded data
  
  public IntegratedAvirUpdateStatus() {
    
  }

  public UpdateStatus getStatus() {
    return status;
  }

  public void setStatus(UpdateStatus status) {
    this.status = status;
  }

  public long getPercent() {
    return percent;
  }

  public void setPercent(long percent) {
    this.percent = percent;
  }

  public enum UpdateStatus {
    UpdateStarted,
    UpdateFinished,
    UpdateError,
    UpdateDownloadIni,
    UpdateDownloadData,
    UpdateUpToDate
  }

}
