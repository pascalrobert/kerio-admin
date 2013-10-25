package kerio.connect.admin.policies;

import java.util.ArrayList;

public class AccessPolicy {

  enum ServiceType {
    ServiceActiveSync,   ///< ActiveSync
    ServiceEWS,       ///< EWS
    ServiceIMAP,      ///< IMAP, Kerio Outlook Connector
    ServiceKoff,      ///< Kerio Outlook Connector (Offline Edition)
    ServicePOP3,      ///< POP3
    ServiceWebDAV,    ///< WebDAV, CalDAV, CardDAV
    ServiceWebMail,      ///< WebMail
    ServiceXMPP    ///< XMPP
  }
  
  enum AccessPolicyConnectionRuleType {
    ServiceAllowed,      ///< service is allowed
    ServiceDenied,       ///< service is forbidden
    ServiceIpAllowed,    ///< service is allowed for specific IP group
    ServiceIpDenied      ///< service is forbidden for specific IP group
  }
  
  public static class AccessPolicyConnectionRule {
    AccessPolicyConnectionRuleType type;   ///< type of rule
    String groupId;            ///< if type of rule is 'ServiceIpAllowed/Denied' there is ID of IP Group
    
    public AccessPolicyConnectionRule() {
      
    }

    public AccessPolicyConnectionRuleType getType() {
      return type;
    }

    public void setType(AccessPolicyConnectionRuleType type) {
      this.type = type;
    }

    public String getGroupId() {
      return groupId;
    }

    public void setGroupId(String groupId) {
      this.groupId = groupId;
    }
  }
  
  /**
   * Access policy rule details.
   */
  public static class AccessPolicyRule {
    String id;              ///< [READ-ONLY] [REQUIRED FOR SET] global identification
    String groupId;         ///< [REQUIRED FOR CREATE] global identification of AccessPolicyGroup
    ServiceType service;          ///< type of service
    AccessPolicyConnectionRule rule; ///< rule for connections
    
    public AccessPolicyRule() {
      
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

    public ServiceType getService() {
      return service;
    }

    public void setService(ServiceType service) {
      this.service = service;
    }

    public AccessPolicyConnectionRule getRule() {
      return rule;
    }

    public void setRule(AccessPolicyConnectionRule rule) {
      this.rule = rule;
    }
  }
  
  /**
   * List of AccessPolicyRule.
   */
  public static class ServiceTypeInfo {
    ServiceType service; ///< type of service
    String description;     ///< description of service enum
    
    public ServiceTypeInfo() {
      
    }

    public ServiceType getService() {
      return service;
    }

    public void setService(ServiceType service) {
      this.service = service;
    }

    public String getDescription() {
      return description;
    }

    public void setDescription(String description) {
      this.description = description;
    }
  }
  
  /**
   * Access policy group details.
   */
  public static class AccessPolicyGroup {
    String id;        ///< [READ-ONLY] [REQUIRED FOR SET] global identification
    String name;            ///< name of policy
    boolean isDefault;         ///< [READ-ONLY]
    
    public AccessPolicyGroup() {
      
    }

    public String getId() {
      return id;
    }

    public void setId(String id) {
      this.id = id;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public boolean isIsDefault() {
      return isDefault;
    }

    public void setIsDefault(boolean isDefault) {
      this.isDefault = isDefault;
    }
  }
  
  public static class AccessPolicyList {
    ArrayList<AccessPolicyRule> list;
    long totalItems;
    
    public AccessPolicyList() {
      
    }

    public ArrayList<AccessPolicyRule> getList() {
      return list;
    }

    public void setList(ArrayList<AccessPolicyRule> list) {
      this.list = list;
    }

    public long getTotalItems() {
      return totalItems;
    }

    public void setTotalItems(long totalItems) {
      this.totalItems = totalItems;
    }
  }
 
}
