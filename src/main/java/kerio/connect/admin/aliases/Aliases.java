package kerio.connect.admin.aliases;

import kerio.connect.admin.common.HomeServer;
import kerio.connect.admin.common.enums.DataSource;

public class Aliases {

  enum AliasType {
    TypePublicFolder, ///< messages are delivered to public folder
    TypeEmailAddress  ///< messages are delivered to email account
  }

  /**
   * Alias details
   */
  public static class Alias {
    String   id;            ///< global identification of alias
    String   domainId;      ///< [REQUIRED FOR CREATE] identification in which domain alias exists
    String      name;          ///< [REQUIRED FOR CREATE] [USED BY QUICKSEARCH] left side of alias
    String   deliverToId;   ///< empty if email or contains public folder kid
    String      deliverTo;        ///< [REQUIRED FOR CREATE] [USED BY QUICKSEARCH] email address or public folder name
    AliasType   type;          ///< type of the alias
    String      description;      ///< description
    HomeServer  homeServer;       ///< [READ-ONLY] Id of alias homeserver if server is in Cluster
    
    public Alias() {
      
    }

    public String getId() {
      return id;
    }

    public void setId(String id) {
      this.id = id;
    }

    public String getDomainId() {
      return domainId;
    }

    public void setDomainId(String domainId) {
      this.domainId = domainId;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public String getDeliverToId() {
      return deliverToId;
    }

    public void setDeliverToId(String deliverToId) {
      this.deliverToId = deliverToId;
    }

    public String getDeliverTo() {
      return deliverTo;
    }

    public void setDeliverTo(String deliverTo) {
      this.deliverTo = deliverTo;
    }

    public AliasType getType() {
      return type;
    }

    public void setType(AliasType type) {
      this.type = type;
    }

    public String getDescription() {
      return description;
    }

    public void setDescription(String description) {
      this.description = description;
    }

    public HomeServer getHomeServer() {
      return homeServer;
    }

    public void setHomeServer(HomeServer homeServer) {
      this.homeServer = homeServer;
    }
  }
  
  /**
   * Alias Target discriminator
   */
  enum AliasTargetType {
    TypeUser,   ///< user
    TypeGroup   ///< group
  }

  /**
   * Alias target can be a user or group
   */
  public static class AliasTarget {
    String      id;   ///< unique identifier
    AliasTargetType   type;          ///< item type discriminator
    String         name;          ///< loginName for the User, name in square brackets for the Group
    String         fullName;         ///< fullname for the User, empty String for the Group
    String         description;      ///< description of User/Group
    boolean        isEnabled;        ///< is the User/Group enabled?
    DataSource     itemSource;       ///< is the User/Group stored internally or by LDAP?
    String         emailAddress;     ///< first email address
    HomeServer     homeServer;       ///< id of users homeserver if server is in Cluster; groups haven't homeserver
  }

}
