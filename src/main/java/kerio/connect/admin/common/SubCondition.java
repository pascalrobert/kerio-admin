package kerio.connect.admin.common;

import kerio.connect.admin.common.enums.CompareOperator;

public class SubCondition {

  String               fieldName;           ///< left side of condition
  CompareOperator      comparator;                ///< middle of condition
  String               value;
  
  public SubCondition() {
    
  }

  public String getFieldName() {
    return fieldName;
  }

  public void setFieldName(String fieldName) {
    this.fieldName = fieldName;
  }

  public CompareOperator getComparator() {
    return comparator;
  }

  public void setComparator(CompareOperator comparator) {
    this.comparator = comparator;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

}
