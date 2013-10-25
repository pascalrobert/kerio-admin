package kerio.connect.admin.common;

import kerio.connect.admin.common.enums.SortDirection;

public class SortOrder {

  String         columnName;
  SortDirection  direction;
  boolean        caseSensitive;
  
  public SortOrder() {
    
  }

  public String getColumnName() {
    return columnName;
  }

  public void setColumnName(String columnName) {
    this.columnName = columnName;
  }

  public SortDirection getDirection() {
    return direction;
  }

  public void setDirection(SortDirection direction) {
    this.direction = direction;
  }

  public boolean isCaseSensitive() {
    return caseSensitive;
  }

  public void setCaseSensitive(boolean caseSensitive) {
    this.caseSensitive = caseSensitive;
  }

}
