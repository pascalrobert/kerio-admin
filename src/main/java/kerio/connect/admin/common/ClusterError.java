package kerio.connect.admin.common;

import java.util.ArrayList;

public class ClusterError {

  ClusterErrorType type;
  LocalizableMessage errorMessage; ///< is assigned if type is clError
  ArrayList<ClusterConflict> conflictList; ///< List of Resources/Aliases/MLists which are already defined in cluster. The conflictList is empty if type is different from dataConflict.

  public ClusterError() {
    
  }
  
  public ClusterErrorType getType() {
    return type;
  }

  public void setType(ClusterErrorType type) {
    this.type = type;
  }

  public LocalizableMessage getErrorMessage() {
    return errorMessage;
  }

  public void setErrorMessage(LocalizableMessage errorMessage) {
    this.errorMessage = errorMessage;
  }

  public ArrayList<ClusterConflict> getConflictList() {
    return conflictList;
  }

  public void setConflictList(ArrayList<ClusterConflict> conflictList) {
    this.conflictList = conflictList;
  }

  public static class ClusterConflict {
    ClusterConflictTarget type;
    String name;
    String domain;
    String homeServer;
    
    public ClusterConflict() {
      
    }

    public ClusterConflictTarget getType() {
      return type;
    }

    public void setType(ClusterConflictTarget type) {
      this.type = type;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public String getDomain() {
      return domain;
    }

    public void setDomain(String domain) {
      this.domain = domain;
    }

    public String getHomeServer() {
      return homeServer;
    }

    public void setHomeServer(String homeServer) {
      this.homeServer = homeServer;
    }
  }

  enum ClusterConflictTarget {
    clResource,
    clAlias,
    clMailingList,
    clDomainAlias,
    clDomain
  }

  enum ClusterErrorType {
    clSuccess,
    clError,             ///< Generic cluster error, see ClusterError.errorMessage for details
    clSelfConnectError,        ///< The master cannot be the same as slave
    clConnectToSlaveError,     ///< Connection to slave is not allowed
    clInaccessibleHost,        ///< Cannot connect to the specified host
    clInvalidUserOrPassword,   ///< User name or password are invalid or has insufficient rights
    clIncorrectClusterVersion, ///< Remote server has incompatible implementation of cluster services
    clDataConflict,            ///< There are multiple resources/aliases or mailing lists with the same name, server cannot be connected to cluster
    clDirServiceRemoteEmpty,   ///< Specified distributed domain has no Directory Service configured on remote distributed domain host
    clDirServiceLocalEmpty,    ///< Specified distributed domain has no Directory Service configured on local distributed domain host
    clDirServiceDifferent      ///< Specified distributed domain has different Directory Service configured on local and remote distributed domain host
  }
}
