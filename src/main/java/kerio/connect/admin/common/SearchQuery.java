package kerio.connect.admin.common;

import java.util.ArrayList;

import kerio.connect.admin.common.enums.LogicalOperator;

public class SearchQuery {

  ArrayList<String>        fields;     ///< empty = give me all fields, applicable constants: ADD_USERS, LIST_USERS
  ArrayList<SubCondition>  conditions; ///< empty = without condition
  LogicalOperator      combining;  ///< the list of conditions can be either combined by 'ORs' or 'ANDs'
  long           start;      ///< how many items to skip before filling a result list (0 means skip none)
  long           limit;      ///< how many items to put to a result list (if there are enough items); applicable constant: Unlimited
  ArrayList<SortOrder>     orderBy;
  
  public SearchQuery() {
    
  }

  public ArrayList<String> getFields() {
    return fields;
  }

  public void setFields(ArrayList<String> fields) {
    this.fields = fields;
  }

  public ArrayList<SubCondition> getConditions() {
    return conditions;
  }

  public void setConditions(ArrayList<SubCondition> conditions) {
    this.conditions = conditions;
  }

  public LogicalOperator getCombining() {
    return combining;
  }

  public void setCombining(LogicalOperator combining) {
    this.combining = combining;
  }

  public long getStart() {
    return start;
  }

  public void setStart(long start) {
    this.start = start;
  }

  public long getLimit() {
    return limit;
  }

  public void setLimit(long limit) {
    this.limit = limit;
  }

  public ArrayList<SortOrder> getOrderBy() {
    return orderBy;
  }

  public void setOrderBy(ArrayList<SortOrder> orderBy) {
    this.orderBy = orderBy;
  }

}
