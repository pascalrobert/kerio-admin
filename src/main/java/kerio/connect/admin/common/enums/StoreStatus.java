package kerio.connect.admin.common.enums;

public enum StoreStatus {

  StoreStatusClean,        ///< already present in configuration store
  StoreStatusModified,     ///< update waiting for apply()
  StoreStatusNew           ///< added to manager but not synced to configuration store

}
