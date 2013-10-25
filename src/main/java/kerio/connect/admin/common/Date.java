package kerio.connect.admin.common;

public class Date {

  long year;
  long month;    ///< 0-11
  long day;      ///< 1-31 max day is limited by month
  
  public Date() {
    
  }

  public long getYear() {
    return year;
  }

  public void setYear(long year) {
    this.year = year;
  }

  public long getMonth() {
    return month;
  }

  public void setMonth(long month) {
    this.month = month;
  }

  public long getDay() {
    return day;
  }

  public void setDay(long day) {
    this.day = day;
  }

}
