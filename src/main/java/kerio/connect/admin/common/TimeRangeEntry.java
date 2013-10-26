package kerio.connect.admin.common;

import java.util.ArrayList;

import kerio.connect.admin.common.enums.Day;
import kerio.connect.admin.common.enums.StoreStatus;
import kerio.connect.admin.common.enums.TimeRangeType;

public class TimeRangeEntry {

  String id;
  String groupId;
  String groupName;
  String description;
  TimeRangeType type;
  boolean enabled;
  StoreStatus status;
  Time fromTime;  ///< This doesn't contain seconds, so we round data created by QT admin
  Time toTime;    ///< This doesn't contain seconds, so we round data created by QT admin
  ArrayList<Day> days;
  Day fromDay;
  Day toDay;
  Date fromDate;  ///< hour and min used from Time
  Date toDate;   ///< hour and min used from Time
  String childGroupId;
  String childGroupName;
  
  public TimeRangeEntry() {
    
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getGroupId() {
    return groupId;
  }

  public void setGroupId(String groupId) {
    this.groupId = groupId;
  }

  public String getGroupName() {
    return groupName;
  }

  public void setGroupName(String groupName) {
    this.groupName = groupName;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public TimeRangeType getType() {
    return type;
  }

  public void setType(TimeRangeType type) {
    this.type = type;
  }

  public boolean isEnabled() {
    return enabled;
  }

  public void setEnabled(boolean enabled) {
    this.enabled = enabled;
  }

  public StoreStatus getStatus() {
    return status;
  }

  public void setStatus(StoreStatus status) {
    this.status = status;
  }

  public Time getFromTime() {
    return fromTime;
  }

  public void setFromTime(Time fromTime) {
    this.fromTime = fromTime;
  }

  public Time getToTime() {
    return toTime;
  }

  public void setToTime(Time toTime) {
    this.toTime = toTime;
  }

  public ArrayList<Day> getDays() {
    return days;
  }

  public void setDays(ArrayList<Day> days) {
    this.days = days;
  }

  public Day getFromDay() {
    return fromDay;
  }

  public void setFromDay(Day fromDay) {
    this.fromDay = fromDay;
  }

  public Day getToDay() {
    return toDay;
  }

  public void setToDay(Day toDay) {
    this.toDay = toDay;
  }

  public Date getFromDate() {
    return fromDate;
  }

  public void setFromDate(Date fromDate) {
    this.fromDate = fromDate;
  }

  public Date getToDate() {
    return toDate;
  }

  public void setToDate(Date toDate) {
    this.toDate = toDate;
  }

  public String getChildGroupId() {
    return childGroupId;
  }

  public void setChildGroupId(String childGroupId) {
    this.childGroupId = childGroupId;
  }

  public String getChildGroupName() {
    return childGroupName;
  }

  public void setChildGroupName(String childGroupName) {
    this.childGroupName = childGroupName;
  }

}
