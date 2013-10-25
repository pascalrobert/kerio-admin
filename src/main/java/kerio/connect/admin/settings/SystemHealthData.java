package kerio.connect.admin.settings;

import java.util.ArrayList;

public class SystemHealthData {

  ArrayList<Double> cpu;
  ArrayList<Double>  memory;
  double memoryTotal;        ///< memory histogram has to have fixed maximum to this value
  double diskTotal;          ///< total number of bytes on data partition (install dir on windows)
  double diskFree;
  
  public  SystemHealthData() {
  
  }

  public ArrayList<Double> getCpu() {
    return cpu;
  }

  public void setCpu(ArrayList<Double> cpu) {
    this.cpu = cpu;
  }

  public ArrayList<Double> getMemory() {
    return memory;
  }

  public void setMemory(ArrayList<Double> memory) {
    this.memory = memory;
  }

  public double getMemoryTotal() {
    return memoryTotal;
  }

  public void setMemoryTotal(double memoryTotal) {
    this.memoryTotal = memoryTotal;
  }

  public double getDiskTotal() {
    return diskTotal;
  }

  public void setDiskTotal(double diskTotal) {
    this.diskTotal = diskTotal;
  }

  public double getDiskFree() {
    return diskFree;
  }

  public void setDiskFree(double diskFree) {
    this.diskFree = diskFree;
  }

  public enum HistogramIntervalType {
    HistogramInterval5m,  ///< Data interval: 5min,  Max samples: 288, Length 1day
    HistogramInterval20s  ///< Data interval: 20sec, Max samples: 360, Length 2Hours
  }

  public enum HistogramType {
    HistogramOneDay,  ///< Data interval: 5min,  Max samples: 288
    HistogramTwoHours ///< Data interval: 20sec, Max samples: 360
  }
}
