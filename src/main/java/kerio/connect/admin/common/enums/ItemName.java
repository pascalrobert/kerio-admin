package kerio.connect.admin.common.enums;

public enum ItemName {

  Name,       ///< Entity Name
  Description,   ///< Entity Description
  Email,         ///< Entity Email Address
  FullName,      ///< Entity Full Name
  TimeItem,      ///< Entity Time - it cannot be simply Time because of C++ conflict - see bug 34684 comment #3
  DateItem,      ///< Entity Date - I expect same problem with Date as with Time
  DomainName     ///< differs from name (eg. cannot contains underscore)

}
