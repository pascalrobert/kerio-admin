package kerio.connect.admin;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import kerio.connect.admin.Session.AdminInfo;
import kerio.connect.admin.aliases.AliasListResult;
import kerio.connect.admin.aliases.AliasTargetListResult;
import kerio.connect.admin.aliases.Aliases.Alias;
import kerio.connect.admin.backup.BackupOptions;
import kerio.connect.admin.backup.BackupSchedule;
import kerio.connect.admin.backup.BackupSchedule.BackupType;
import kerio.connect.admin.backup.BackupStatus;
import kerio.connect.admin.certificates.Certificate;
import kerio.connect.admin.common.ApiApplication;
import kerio.connect.admin.common.CreateResult;
import kerio.connect.admin.common.Download;
import kerio.connect.admin.common.Error;
import kerio.connect.admin.common.NamedValue;
import kerio.connect.admin.common.SearchQuery;
import kerio.connect.admin.common.enums.HourOrDay;
import kerio.connect.admin.content.AntiSpamSetting;
import kerio.connect.admin.content.AntivirusSetting;
import kerio.connect.admin.content.AttachmentItem;
import kerio.connect.admin.content.AttachmentSetting;
import kerio.connect.admin.content.BlackList;
import kerio.connect.admin.content.CustomRule;
import kerio.connect.admin.content.IntegratedAvirUpdateStatus;
import kerio.connect.admin.delivery.EtrnDownload;
import kerio.connect.admin.delivery.InternetSettings;
import kerio.connect.admin.delivery.Pop3Account;
import kerio.connect.admin.delivery.Pop3Sorting;
import kerio.connect.admin.delivery.ScheduledAction;
import kerio.connect.admin.domains.Domain;
import kerio.connect.admin.mailinglists.Ml;
import kerio.connect.admin.mailinglists.Ml.MlMembership;
import kerio.connect.admin.mailinglists.Ml.TrusteeTarget;
import kerio.connect.admin.mailinglists.Ml.UserOrEmail;
import kerio.connect.admin.mailinglists.MlListResult;
import kerio.connect.admin.mailinglists.MlUserListResult;
import kerio.connect.admin.mailinglists.TrusteeTargetListResult;
import kerio.connect.admin.policies.AccessPolicy;
import kerio.connect.admin.policies.AccessPolicy.AccessPolicyGroup;
import kerio.connect.admin.policies.AccessPolicy.AccessPolicyList;
import kerio.connect.admin.policies.AccessPolicy.AccessPolicyRule;
import kerio.connect.admin.policies.AccessPolicy.ServiceTypeInfo;
import kerio.connect.admin.policies.CreateGroupListResult;
import kerio.connect.admin.settings.AdvancedOptionsSetting;
import kerio.connect.admin.settings.AdvancedOptionsSetting.FulltextRebuildStatus;
import kerio.connect.admin.settings.AdvancedOptionsSetting.FulltextRebuildingCommand;
import kerio.connect.admin.settings.AdvancedOptionsSetting.UpdateCheckerOptions;
import kerio.connect.admin.settings.ArchiveOptions;
import kerio.connect.admin.settings.ServerStatistics;
import kerio.connect.admin.settings.SignOn;
import kerio.connect.admin.settings.SmtpServerSettings;
import kerio.connect.admin.settings.SystemHealthData;
import kerio.connect.admin.settings.TechnicalSupport;
import kerio.connect.admin.settings.TypeExpStatistics;
import kerio.connect.admin.settings.UserTemplate;
import kerio.connect.admin.settings.Version;
import kerio.connect.admin.users.PublicFolder;
import kerio.connect.admin.users.User;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.thetransactioncompany.jsonrpc2.JSONRPC2Error;
import com.thetransactioncompany.jsonrpc2.JSONRPC2Request;
import com.thetransactioncompany.jsonrpc2.JSONRPC2Response;
import com.thetransactioncompany.jsonrpc2.client.JSONRPC2Session;
import com.thetransactioncompany.jsonrpc2.client.JSONRPC2SessionException;

public class KCApi {

  protected JSONRPC2Session jsonSession;
  protected ObjectMapper mapper;

  public KCApi(URL apiUrl) {
    jsonSession = new JSONRPC2Session(apiUrl);
    jsonSession.getOptions().acceptCookies(true);
    jsonSession.getOptions().trustAllCerts(true);

    mapper = new ObjectMapper();
    mapper.setSerializationInclusion(Include.NON_NULL);
    mapper.configure(SerializationFeature.WRITE_NULL_MAP_VALUES, false);
  }

  public Domain getDomain() throws JSONRPC2Error, JsonParseException, JsonMappingException, IOException, SessionExpired, RequestTimeout, InvalidRequest, InvalidParameters, InvalidJSON, RequestTooLarge, ResourceAlreadyExists, ResourceDontExists, Forbidden, GeneralException {
    JSONObject domainAsJson = (JSONObject)executeJSONRPCRequest("Session.getDomain", "domain");
    Domain domain = mapper.readValue(domainAsJson.toJSONString(), Domain.class);
    return domain;
  }

  /*
  public JSONObject getSettings(ArrayList<ArrayList<String>> query) {

  }
   */

  public void login(String userName, String password, ApiApplication application) throws JSONRPC2Error, JsonParseException, JsonMappingException, IOException, SessionExpired, RequestTimeout, InvalidRequest, InvalidParameters, InvalidJSON, RequestTooLarge, ResourceAlreadyExists, ResourceDontExists, Forbidden, GeneralException {
    HashMap<String, Object> params = new HashMap<String, Object>();
    params.put("userName", userName);
    params.put("password", password);
    params.put("application", application);

    JSONObject result = (JSONObject)executeJSONRPCRequest("Session.login", null, params);
    LoginResponse user = mapper.readValue(result.toJSONString(), LoginResponse.class);
    MyConfigurator configurator = new MyConfigurator();
    configurator.setToken(user.getToken());
    jsonSession.setConnectionConfigurator(configurator);
  }

  public String logout() throws JSONRPC2Error, SessionExpired, RequestTimeout, InvalidRequest, InvalidParameters, InvalidJSON, RequestTooLarge, ResourceAlreadyExists, ResourceDontExists, Forbidden, GeneralException {
    JSONObject result = (JSONObject)executeJSONRPCRequest("Session.logout");
    return (String)result.get("redirectUrl");
  }

  /**
   * TODO
   * 
   * @param settings
   */
  public void setSettings(JSONObject settings) {

  }

  public AdminInfo whoAmI() throws JSONRPC2Error, JsonParseException, JsonMappingException, IOException, SessionExpired, RequestTimeout, InvalidRequest, InvalidParameters, InvalidJSON, RequestTooLarge, ResourceAlreadyExists, ResourceDontExists, Forbidden, GeneralException {
    JSONObject userDetails = (JSONObject)executeJSONRPCRequest("Session.whoAmI", "userDetails");
    AdminInfo info = mapper.readValue(userDetails.toJSONString(), AdminInfo.class);    
    return info;
  }

  public Server.ProductInfo getProductInfo() throws JSONRPC2Error, JsonParseException, JsonMappingException, IOException, SessionExpired, RequestTimeout, InvalidRequest, InvalidParameters, InvalidJSON, RequestTooLarge, ResourceAlreadyExists, ResourceDontExists, Forbidden, GeneralException {
    JSONObject infoAsJson = (JSONObject)executeJSONRPCRequest("Server.getProductInfo", "info");
    Server.ProductInfo productInfo = mapper.readValue(((JSONObject)infoAsJson).toJSONString(), Server.ProductInfo.class);
    return productInfo;
  }

  public ArrayList<Domain> getDomains() throws JSONRPC2Error, SessionExpired, RequestTimeout, InvalidRequest, InvalidParameters, InvalidJSON, RequestTooLarge, ResourceAlreadyExists, ResourceDontExists, Forbidden, GeneralException {
    ArrayList<Domain> domains = new ArrayList<Domain>();

    HashMap query = new HashMap();
    query.put("fields", new String[] { "id", "name", "description", "isPrimary", "outgoingMessageLimit"});
    query.put("limit", -1);
    HashMap<String, Object> params = new HashMap<String, Object>();
    params.put("query", query);

    try {
      JSONArray domainsAsJson = (JSONArray)executeJSONRPCRequest("Domains.get", "list", params);
      for (Object domainAsJson: domainsAsJson) {
        if (domainAsJson instanceof JSONObject) {
          Domain domain = mapper.readValue(((JSONObject)domainAsJson).toJSONString(), Domain.class);
          domains.add(domain);
        }
      }
    }
    catch (JsonParseException e) {
      e.printStackTrace();
    }
    catch (JsonMappingException e) {
      e.printStackTrace();
    }
    catch (IOException e) {
      e.printStackTrace();
    }

    return domains;
  }

  public ArrayList<User> getUsers(String[] fields, int limit, String domainId) throws JSONRPC2Error, SessionExpired, RequestTimeout, InvalidRequest, InvalidParameters, InvalidJSON, RequestTooLarge, ResourceAlreadyExists, ResourceDontExists, Forbidden, GeneralException {
    ArrayList<User> users = new ArrayList<User>();

    HashMap query = new HashMap();
    query.put("fields", fields);
    query.put("limit", limit);

    HashMap<String, Object> params = new HashMap<String, Object>();
    params.put("query", query);
    params.put("domainId", domainId);

    JSONArray usersAsJson = (JSONArray)executeJSONRPCRequest("Users.get", "list", params);
    for (Object userAsJson: usersAsJson) {
      User user;
      try {
        user = mapper.readValue(((JSONObject)userAsJson).toJSONString(), User.class);
        users.add(user);
      }
      catch (JsonParseException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      catch (JsonMappingException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }

    return users;
  }

  public long getApiVersion() throws JSONRPC2Error, SessionExpired, RequestTimeout, InvalidRequest, InvalidParameters, InvalidJSON, RequestTooLarge, ResourceAlreadyExists, ResourceDontExists, Forbidden, GeneralException {
    long apiVersion = (Long)executeJSONRPCRequest("Version.getApiVersion", "apiVersion");
    return apiVersion;
  }

  public Version getProductVersion() throws JsonParseException, JsonMappingException, IOException, JSONRPC2Error, SessionExpired, RequestTimeout, InvalidRequest, InvalidParameters, InvalidJSON, RequestTooLarge, ResourceAlreadyExists, ResourceDontExists, Forbidden, GeneralException {
    JSONObject result = (JSONObject)executeJSONRPCRequest("Version.getProductVersion");
    Version version = mapper.readValue(result.toJSONString(), Version.class);
    return version;
  }

  public void getUserTemplates() throws JSONRPC2Error, SessionExpired, RequestTimeout, InvalidRequest, InvalidParameters, InvalidJSON, RequestTooLarge, ResourceAlreadyExists, ResourceDontExists, Forbidden, GeneralException {
    ArrayList<UserTemplate> templates = new ArrayList<UserTemplate>();

    HashMap query = new HashMap();
    query.put("fields", new String[] { "id", "name", "description"});
    query.put("limit", -1);

    HashMap<String, Object> params = new HashMap<String, Object>();
    params.put("query", query);

    try {
      JSONArray userTemplateListAsJson = (JSONArray)executeJSONRPCRequest("UserTemplates.get", "userTemplateList", params);
      for (Object userTemplateAsJson: userTemplateListAsJson) {
        UserTemplate userTemplate = mapper.readValue(((JSONObject)userTemplateAsJson).toJSONString(), UserTemplate.class);
        templates.add(userTemplate);
      }
    } 
    catch (JsonParseException e) {
      e.printStackTrace();
    }
    catch (JsonMappingException e) {
      e.printStackTrace();
    }
    catch (IOException e) {
      e.printStackTrace();
    }
  }

  public SignOn getUnitySignOn() throws JSONRPC2Error, JsonParseException, JsonMappingException, IOException, SessionExpired, RequestTimeout, InvalidRequest, InvalidParameters, InvalidJSON, RequestTooLarge, ResourceAlreadyExists, ResourceDontExists, Forbidden, GeneralException {
    JSONObject settingsAsJson = (JSONObject)executeJSONRPCRequest("UnitySignOn.get", "settings");
    SignOn signOn = mapper.readValue(settingsAsJson.toJSONString(), SignOn.class);
    return signOn;
  }

  public HashMap<String, Object> getTechSupportInfo() {
    HashMap<String, Object> results = new HashMap<String, Object>();

    JSONRPC2Request request = new JSONRPC2Request("TechnicalSupport.getInfo", 2);

    try {
      JSONRPC2Response response = jsonSession.send(request);

      JSONObject result = (JSONObject)response.getResult();
      JSONObject userInfoAsJson = (JSONObject)result.get("userInfo");
      JSONObject productInfoAsJson = (JSONObject)result.get("productInfo");
      JSONObject systemInfoAsJson = (JSONObject)result.get("systemInfo");

      TechnicalSupport.UserInfo userInfo = mapper.readValue(userInfoAsJson.toJSONString(), TechnicalSupport.UserInfo.class);
      results.put("userInfo", userInfo);

      TechnicalSupport.ProductInfo productInfo = mapper.readValue(productInfoAsJson.toJSONString(), TechnicalSupport.ProductInfo.class);
      results.put("productInfo", productInfo);

      TechnicalSupport.SystemInfo remoteInfo = mapper.readValue(systemInfoAsJson.toJSONString(), TechnicalSupport.SystemInfo.class);
      results.put("remoteInfo", remoteInfo);

    } catch (JSONRPC2SessionException e) {

      System.err.println(e.getMessage());
      // handle exception...
    }
    catch (JsonParseException e) {
      e.printStackTrace();
    }
    catch (JsonMappingException e) {
      e.printStackTrace();
    }
    catch (IOException e) {
      e.printStackTrace();
    }

    return results;

  }

  public ServerStatistics getStatistics() throws JSONRPC2Error, JsonParseException, JsonMappingException, IOException, SessionExpired, RequestTimeout, InvalidRequest, InvalidParameters, InvalidJSON, RequestTooLarge, ResourceAlreadyExists, ResourceDontExists, Forbidden, GeneralException {
    JSONObject userInfo = (JSONObject)executeJSONRPCRequest("Statistics.get", "statistics");
    ServerStatistics statistics = mapper.readValue(userInfo.toJSONString(), ServerStatistics.class);
    return statistics;
  }

  public String exportStatisticsAsHTML(TypeExpStatistics type, String lang) throws JSONRPC2Error, SessionExpired, RequestTimeout, InvalidRequest, InvalidParameters, InvalidJSON, RequestTooLarge, ResourceAlreadyExists, ResourceDontExists, Forbidden, GeneralException {
    HashMap<String, Object> params = new HashMap<String, Object>();
    params.put("type", type);
    params.put("lang", lang);

    JSONObject userInfo = (JSONObject)executeJSONRPCRequest("Statistics.exportToHtml", "fileDownload", params);
    String urlDownload = (String)userInfo.get("url");
    return urlDownload;
  }

  public SystemHealthData getSystemHealth(SystemHealthData.HistogramType type) throws JSONRPC2Error, JsonParseException, JsonMappingException, IOException, SessionExpired, RequestTimeout, InvalidRequest, InvalidParameters, InvalidJSON, RequestTooLarge, ResourceAlreadyExists, ResourceDontExists, Forbidden, GeneralException {
    HashMap<String, Object> params = new HashMap<String, Object>();
    params.put("type", type);

    JSONObject dataAsJson = (JSONObject)executeJSONRPCRequest("SystemHealth.get", "data", params);
    SystemHealthData data = mapper.readValue(dataAsJson.toJSONString(), SystemHealthData.class);
    return data;
  }

  public SmtpServerSettings getSMTPSettings() throws JSONRPC2Error, JsonParseException, JsonMappingException, IOException, SessionExpired, RequestTimeout, InvalidRequest, InvalidParameters, InvalidJSON, RequestTooLarge, ResourceAlreadyExists, ResourceDontExists, Forbidden, GeneralException {
    JSONObject data = (JSONObject)executeJSONRPCRequest("Smtp.get", "server");
    SmtpServerSettings settings = mapper.readValue(data.toJSONString(), SmtpServerSettings.class);
    return settings;
  }

  private Integer _requestId = 1;

  protected int requestId() {
    if (_requestId == null) {
      _requestId = 1;
    }
    _requestId++;
    return _requestId;
  }

  protected Object executeJSONRPCRequest(String method, String nameOfRootElement) throws JSONRPC2Error, SessionExpired, RequestTimeout, InvalidRequest, InvalidParameters, InvalidJSON, RequestTooLarge, ResourceAlreadyExists, ResourceDontExists, Forbidden, GeneralException {
    return executeJSONRPCRequest(method, nameOfRootElement, null);
  }

  protected Object executeJSONRPCRequest(String method) throws JSONRPC2Error, SessionExpired, RequestTimeout, InvalidRequest, InvalidParameters, InvalidJSON, RequestTooLarge, ResourceAlreadyExists, ResourceDontExists, Forbidden, GeneralException {
    return executeJSONRPCRequest(method, null, null);
  }

  protected Object executeJSONRPCRequest(String method, String nameOfRootElement, HashMap<String, Object> params) throws SessionExpired, RequestTimeout, InvalidRequest, InvalidParameters, InvalidJSON, RequestTooLarge, ResourceAlreadyExists, ResourceDontExists, Forbidden, GeneralException {
    JSONRPC2Request request = new JSONRPC2Request(method, requestId());
    if (params != null && !params.isEmpty()) {
      request.setNamedParams(params);
    }

    try {
      JSONRPC2Response response = jsonSession.send(request);

      if (response.indicatesSuccess()) {

        JSONObject result = (JSONObject)response.getResult();
        if (nameOfRootElement == null) {
          return result;
        }
        Object rootElement = result.get(nameOfRootElement);
        return rootElement;
      } else {
        switch (response.getError().getCode()) {
        case -32001:
          throw new SessionExpired(response.getError().getMessage());
        case -32002:
          throw new RequestTimeout(response.getError().getMessage());
        case -32600:
          throw new InvalidRequest(response.getError().getMessage());
        case -32602:
          throw new InvalidParameters(response.getError().getMessage());
        case -32700:
          throw new InvalidJSON(response.getError().getMessage());
        case 413:
          throw new RequestTooLarge(response.getError().getMessage());
        case 1001:
          throw new ResourceAlreadyExists(response.getError().getMessage());
        case 1002:
          throw new ResourceDontExists(response.getError().getMessage());
        case 1003:
          throw new Forbidden(response.getError().getMessage());
        case 1004:
          throw new Forbidden(response.getError().getMessage());
        default:
          throw new GeneralException(response.getError().getMessage());
        }
      }
    } catch (JSONRPC2SessionException e) {
      throw new GeneralException(e);      
    }
  }

  /* begin AccessPolicy requests */

  /**
   * TODO 
   * Add new policies.
   *
   * @return error message list and list of IDs of created rules
   * @param rules - new policies rules
   * @throws GeneralException 
   * @throws Forbidden 
   * @throws ResourceDontExists 
   * @throws ResourceAlreadyExists 
   * @throws RequestTooLarge 
   * @throws InvalidJSON 
   * @throws InvalidParameters 
   * @throws InvalidRequest 
   * @throws RequestTimeout 
   * @throws SessionExpired 
   * @throws JSONRPC2Error 
   */
  public CreateGroupListResult createAccessPolicies(ArrayList<AccessPolicyRule> rules) throws JSONRPC2Error, SessionExpired, RequestTimeout, InvalidRequest, InvalidParameters, InvalidJSON, RequestTooLarge, ResourceAlreadyExists, ResourceDontExists, Forbidden, GeneralException {
    HashMap<String, Object> params = new HashMap<String, Object>();
    params.put("rules", rules);

    CreateGroupListResult createResult = new CreateGroupListResult();

    try {
      JSONObject result = (JSONObject)executeJSONRPCRequest("AccessPolicy.create", null, params);

      ArrayList<CreateResult> results = new ArrayList<CreateResult>();
      JSONArray success = (JSONArray)result.get("result");
      for (Object successElement: success) {
        CreateResult createElement = mapper.readValue(((JSONObject)successElement).toJSONString(), CreateResult.class);
        results.add(createElement);
      }
      createResult.setCreateResultList(results);

      ArrayList<Error> errors = new ArrayList<Error>();
      JSONArray errorsAsJson = (JSONArray)result.get("errors");
      for (Object errorElement: errorsAsJson) {
        Error createElement = mapper.readValue(((JSONObject)errorElement).toJSONString(), Error.class);
        errors.add(createElement);
      }
      createResult.setErrorList(errors);

    } 
    catch (JsonParseException e) {
      e.printStackTrace();
    }
    catch (JsonMappingException e) {
      e.printStackTrace();
    }
    catch (IOException e) {
      e.printStackTrace();
    }

    return createResult;
  }

  /**
   * TODO
   * 
   * Create the list of groups.
   *
   * @return error message list and list of IDs of created groups
   * @param groups - list of groups to create
   * @throws GeneralException 
   * @throws Forbidden 
   * @throws ResourceDontExists 
   * @throws ResourceAlreadyExists 
   * @throws RequestTooLarge 
   * @throws InvalidJSON 
   * @throws InvalidParameters 
   * @throws InvalidRequest 
   * @throws RequestTimeout 
   * @throws SessionExpired 
   * @throws Throwable 
   */
  /*
{
  "jsonrpc": "2.0",
  "id": 1,
  "method": "AccessPolicy.createGroupList",
  "params": {
    "groups": [{
      "name": "Groupe"
    }]
  }
}

{"jsonrpc":"2.0","id":1,"result":{"errors":[],"result":[{"inputIndex":0,"id":"keriodb://accesspolicygroup/2499a0c9-f1c7-49dc-a40d-2949819a5e8b"}]}}
   */
  public CreateGroupListResult createGroupList(ArrayList<AccessPolicyGroup> groups) throws JSONRPC2Error, SessionExpired, RequestTimeout, InvalidRequest, InvalidParameters, InvalidJSON, RequestTooLarge, ResourceAlreadyExists, ResourceDontExists, Forbidden, GeneralException {
    HashMap<String, Object> params = new HashMap<String, Object>();
    params.put("groups", groups);

    CreateGroupListResult createResult = new CreateGroupListResult();

    try {
      JSONObject result = (JSONObject)executeJSONRPCRequest("AccessPolicy.createGroupList", null, params);

      ArrayList<CreateResult> results = new ArrayList<CreateResult>();
      JSONArray success = (JSONArray)result.get("result");
      for (Object successElement: success) {
        CreateResult createElement = mapper.readValue(((JSONObject)successElement).toJSONString(), CreateResult.class);
        results.add(createElement);
      }
      createResult.setCreateResultList(results);

      ArrayList<Error> errors = new ArrayList<Error>();
      JSONArray errorsAsJson = (JSONArray)result.get("errors");
      for (Object errorElement: errorsAsJson) {
        Error createElement = mapper.readValue(((JSONObject)errorElement).toJSONString(), Error.class);
        errors.add(createElement);
      }
      createResult.setErrorList(errors);

    }
    catch (JsonParseException e) {
      e.printStackTrace();
    }
    catch (JsonMappingException e) {
      e.printStackTrace();
    }
    catch (IOException e) {
      e.printStackTrace();
    }

    return createResult;
  }

  /**
   * Obtain a list of policies.
   *
   * @param list - policies
   * @param totalItems - number of policies found
   * @param query - query attributes and limits
   * @throws GeneralException 
   * @throws Forbidden 
   * @throws ResourceDontExists 
   * @throws ResourceAlreadyExists 
   * @throws RequestTooLarge 
   * @throws InvalidJSON 
   * @throws InvalidParameters 
   * @throws InvalidRequest 
   * @throws RequestTimeout 
   * @throws SessionExpired 
   * @throws JSONRPC2Error 
   */
  public AccessPolicyList getAccessPolicyList() throws JSONRPC2Error, SessionExpired, RequestTimeout, InvalidRequest, InvalidParameters, InvalidJSON, RequestTooLarge, ResourceAlreadyExists, ResourceDontExists, Forbidden, GeneralException {
    AccessPolicyList accessPolicyList = new AccessPolicyList();

    HashMap<String, Object> query = new HashMap<String, Object>();

    query.put("fields", new String[] { "id", "groupId", "service", "rule" } );

    HashMap<String, String> orderByItem = new HashMap<String, String>();
    orderByItem.put("columnName", "service");
    orderByItem.put("direction", "Asc");
    ArrayList<HashMap<String,String>> orderBy = new ArrayList<HashMap<String,String>>();
    orderBy.add(orderByItem);
    query.put("orderBy", orderBy);

    HashMap<String, Object> params = new HashMap<String, Object>();
    params.put("query", query);

    try {
      ArrayList<AccessPolicyRule> policyList = new ArrayList<AccessPolicy.AccessPolicyRule>();

      JSONObject result = (JSONObject)executeJSONRPCRequest("AccessPolicy.get", null, params);

      JSONArray list = (JSONArray)result.get("list");
      for (Object policyAsJson: list) {
        AccessPolicyRule policyRule = mapper.readValue(((JSONObject)policyAsJson).toJSONString(), AccessPolicyRule.class);
        policyList.add(policyRule);
      }
      accessPolicyList.setList(policyList);

      long totalItems = (Long)result.get("totalItems");
      accessPolicyList.setTotalItems(totalItems);

    }
    catch (JsonParseException e) {
      e.printStackTrace();
    }
    catch (JsonMappingException e) {
      e.printStackTrace();
    }
    catch (IOException e) {
      e.printStackTrace();
    }

    return accessPolicyList;
  }

  /**
   * Get the list of groups, sorted in ascending order.
   *
   * @param groups - list of Access policy groups
   * @throws GeneralException 
   * @throws Forbidden 
   * @throws ResourceDontExists 
   * @throws ResourceAlreadyExists 
   * @throws RequestTooLarge 
   * @throws InvalidJSON 
   * @throws InvalidParameters 
   * @throws InvalidRequest 
   * @throws RequestTimeout 
   * @throws SessionExpired 
   * @throws JSONRPC2Error 
   */
  public ArrayList<AccessPolicyGroup> getAccessPolicyGroupList() throws JSONRPC2Error, SessionExpired, RequestTimeout, InvalidRequest, InvalidParameters, InvalidJSON, RequestTooLarge, ResourceAlreadyExists, ResourceDontExists, Forbidden, GeneralException {
    ArrayList<AccessPolicyGroup> policyList = new ArrayList<AccessPolicy.AccessPolicyGroup>();

    try {
      JSONArray list = (JSONArray)executeJSONRPCRequest("AccessPolicy.getGroupList", "groups");
      for (Object policyAsJson: list) {
        AccessPolicyGroup policyRule = mapper.readValue(((JSONObject)policyAsJson).toJSONString(), AccessPolicyGroup.class);
        policyList.add(policyRule);
      }
    }
    catch (JsonParseException e) {
      e.printStackTrace();
    }
    catch (JsonMappingException e) {
      e.printStackTrace();
    }
    catch (IOException e) {
      e.printStackTrace();
    }

    return policyList;
  }

  /**
   * Get the list of services.
   *
   * @param services - list of service info
   * @throws GeneralException 
   * @throws Forbidden 
   * @throws ResourceDontExists 
   * @throws ResourceAlreadyExists 
   * @throws RequestTooLarge 
   * @throws InvalidJSON 
   * @throws InvalidParameters 
   * @throws InvalidRequest 
   * @throws RequestTimeout 
   * @throws SessionExpired 
   * @throws JSONRPC2Error 
   */
  public ArrayList<ServiceTypeInfo> getServiceList() throws JSONRPC2Error, SessionExpired, RequestTimeout, InvalidRequest, InvalidParameters, InvalidJSON, RequestTooLarge, ResourceAlreadyExists, ResourceDontExists, Forbidden, GeneralException {
    ArrayList<ServiceTypeInfo> typeInfos = new ArrayList<AccessPolicy.ServiceTypeInfo>();

    try {

      JSONObject result = (JSONObject)executeJSONRPCRequest("AccessPolicy.getServiceList");

      JSONArray list = (JSONArray)result.get("services");
      for (Object policyAsJson: list) {
        ServiceTypeInfo typeInfo = mapper.readValue(((JSONObject)policyAsJson).toJSONString(), ServiceTypeInfo.class);
        typeInfos.add(typeInfo);
      }
    }
    catch (JsonParseException e) {
      e.printStackTrace();
    }
    catch (JsonMappingException e) {
      e.printStackTrace();
    }
    catch (IOException e) {
      e.printStackTrace();
    }

    return typeInfos;
  }

  /**
   * TODO
   * 
   * Remove policies.
   *
   * @param errors - error message list
   * @param ruleIds - list of IDs of policy to be removed
   */
  public ArrayList<Error> removeAccessPolicies(ArrayList<String> ruleIds) {
    return new ArrayList<Error>();
  }

  /**
   * TODO
   * 
   * Remove the list of groups.
   *
   * @param errors - error message list
   * @param groupIds - list of IDs of group policy to be removed
   */
  public ArrayList<Error> removeGroupList(ArrayList<String> groupIds) {
    return new ArrayList<Error>();
  }

  /**
   * TODO
   * 
   * Set policy details.
   *
   * @param errors - error message list
   * @param rules - rules to save
   */
  public ArrayList<Error> setPolicyRules(ArrayList<AccessPolicyRule> rules) {
    return new ArrayList<Error>();
  }

  /**
   * TODO 
   * 
   * Set the list of groups.
   *
   * @param errors - error message list
   * @param groups - list of group to set
   */
  public ArrayList<Error> setGroupList(ArrayList<AccessPolicyGroup> groups) {
    return new ArrayList<Error>();
  }

  /* end AccessPolicy requests */

  /* begin AdvancedOptions */

  /**
   * Check for updates.
   *
   * @param options - new version details
   * @throws GeneralException 
   * @throws Forbidden 
   * @throws ResourceDontExists 
   * @throws ResourceAlreadyExists 
   * @throws RequestTooLarge 
   * @throws InvalidJSON 
   * @throws InvalidParameters 
   * @throws InvalidRequest 
   * @throws RequestTimeout 
   * @throws SessionExpired 
   * @throws JSONRPC2Error 
   * @throws IOException 
   * @throws JsonMappingException 
   * @throws JsonParseException 
   */
  public UpdateCheckerOptions checkUpdates() throws JSONRPC2Error, SessionExpired, RequestTimeout, InvalidRequest, InvalidParameters, InvalidJSON, RequestTooLarge, ResourceAlreadyExists, ResourceDontExists, Forbidden, GeneralException, JsonParseException, JsonMappingException, IOException {
    JSONObject optionsAsJson = (JSONObject)executeJSONRPCRequest("AdvancedOptions.checkUpdates", "options");
    UpdateCheckerOptions options = mapper.readValue(optionsAsJson.toJSONString(), UpdateCheckerOptions.class);
    return options;
  }

  /**
   * Obtain Advanced options.
   *
   * @param options - current advanced options
   * @throws GeneralException 
   * @throws Forbidden 
   * @throws ResourceDontExists 
   * @throws ResourceAlreadyExists 
   * @throws RequestTooLarge 
   * @throws InvalidJSON 
   * @throws InvalidParameters 
   * @throws InvalidRequest 
   * @throws RequestTimeout 
   * @throws SessionExpired 
   * @throws JSONRPC2Error 
   * @throws IOException 
   * @throws JsonMappingException 
   * @throws JsonParseException 
   */
  public AdvancedOptionsSetting getAvancedOptions() throws JSONRPC2Error, SessionExpired, RequestTimeout, InvalidRequest, InvalidParameters, InvalidJSON, RequestTooLarge, ResourceAlreadyExists, ResourceDontExists, Forbidden, GeneralException, JsonParseException, JsonMappingException, IOException {
    JSONObject optionsAsJson = (JSONObject)executeJSONRPCRequest("AdvancedOptions.get", "options");
    AdvancedOptionsSetting options = mapper.readValue(optionsAsJson.toJSONString(), AdvancedOptionsSetting.class);
    return options;
  }

  /**
   * Get information about index status.
   *
   * @param info - structure with information
   * @throws GeneralException 
   * @throws Forbidden 
   * @throws ResourceDontExists 
   * @throws ResourceAlreadyExists 
   * @throws RequestTooLarge 
   * @throws InvalidJSON 
   * @throws InvalidParameters 
   * @throws InvalidRequest 
   * @throws RequestTimeout 
   * @throws SessionExpired 
   * @throws JSONRPC2Error 
   * @throws IOException 
   * @throws JsonMappingException 
   * @throws JsonParseException 
   */
  public FulltextRebuildStatus getFulltextStatus() throws JSONRPC2Error, SessionExpired, RequestTimeout, InvalidRequest, InvalidParameters, InvalidJSON, RequestTooLarge, ResourceAlreadyExists, ResourceDontExists, Forbidden, GeneralException, JsonParseException, JsonMappingException, IOException {
    JSONObject optionsAsJson = (JSONObject)executeJSONRPCRequest("AdvancedOptions.getFulltextStatus", "info");
    FulltextRebuildStatus options = mapper.readValue(optionsAsJson.toJSONString(), FulltextRebuildStatus.class);
    return options;
  }
  /**
   * Save a new logo.
   *
   * @param logoUrl - path to the saved file
   * @param fileId - ID of the uploaded file
   */
  public String saveWebMailLogo(String fileId) {
    return null;
  }

  /**
   * Set advanced options.
   *
   * @param options - options to be updated
   */
  void setAvancedOptions(AdvancedOptionsSetting options) {

  }

  /**
   * Launch re-index according parameters.
   *
   * @param parameters - parameters for launching re-index
   */
  void startRebuildFulltext(FulltextRebuildingCommand parameters) {

  }

  /* end AdvancedOptions */

  /* begin Aliases */

  /**
   * Obtain a list of mail addresses and/or public folders on which given string will be expanded.
   *
   * @param result - list of expansions
   * @param checkString - string to be checked
   * @throws GeneralException 
   * @throws Forbidden 
   * @throws ResourceDontExists 
   * @throws ResourceAlreadyExists 
   * @throws RequestTooLarge 
   * @throws InvalidJSON 
   * @throws InvalidParameters 
   * @throws InvalidRequest 
   * @throws RequestTimeout 
   * @throws SessionExpired 
   * @throws JSONRPC2Error 
   * @throws IOException 
   * @throws JsonMappingException 
   * @throws JsonParseException 
   */
  public ArrayList<String> checkAliases(String checkString) throws JSONRPC2Error, SessionExpired, RequestTimeout, InvalidRequest, InvalidParameters, InvalidJSON, RequestTooLarge, ResourceAlreadyExists, ResourceDontExists, Forbidden, GeneralException, JsonParseException, JsonMappingException, IOException {
    ArrayList<String> expansions = new ArrayList<String>();

    HashMap<String, Object> params = new HashMap<String, Object>();
    params.put("checkString", checkString);

    JSONRPC2Request request = new JSONRPC2Request("Aliases.check", 3);
    request.setNamedParams(params);

    JSONArray arrayAsJSON = (JSONArray)executeJSONRPCRequest("Aliases.check", null, params);
    expansions = mapper.readValue(arrayAsJSON.toJSONString(), ArrayList.class);
    return expansions;
  }

  /**
   * TODO
   * 
   * Create new aliases
   *
   * @param errors - list of error messages for appropriate new aliases
   * @param result - list of IDs of created aliases
   * @param aliases - new alias entities
   */
  public AliasListResult createAliases(ArrayList<Alias> aliases) {
    return new AliasListResult();
  }

  /**
   * Obtain list of aliases.
   *
   * @param list - aliases
   * @param totalItems - amount of aliases for given search condition, useful when limit is defined in query
   * @param query - query conditions and limits
   * @param domainKId - domain identification
   * @throws GeneralException 
   * @throws Forbidden 
   * @throws ResourceDontExists 
   * @throws ResourceAlreadyExists 
   * @throws RequestTooLarge 
   * @throws InvalidJSON 
   * @throws InvalidParameters 
   * @throws InvalidRequest 
   * @throws RequestTimeout 
   * @throws SessionExpired 
   * @throws JSONRPC2Error 
   */
  public AliasListResult getAliases(String domainId) throws JSONRPC2Error, SessionExpired, RequestTimeout, InvalidRequest, InvalidParameters, InvalidJSON, RequestTooLarge, ResourceAlreadyExists, ResourceDontExists, Forbidden, GeneralException {
    AliasListResult listResult = new AliasListResult(); 

    HashMap<String, Object> query = new HashMap<String, Object>();

    query.put("fields", new String[] { "id", "name", "deliverTo", "description", "type", "homeServer" } );

    HashMap<String, String> orderByItem = new HashMap<String, String>();
    orderByItem.put("columnName", "name");
    orderByItem.put("direction", "Asc");
    ArrayList<HashMap<String,String>> orderBy = new ArrayList<HashMap<String,String>>();
    orderBy.add(orderByItem);
    query.put("orderBy", orderBy);

    HashMap<String, Object> params = new HashMap<String, Object>();
    params.put("query", query);
    params.put("domainId", domainId);

    try {
      JSONObject result = (JSONObject)executeJSONRPCRequest("Aliases.get", null, params);

      JSONArray arrayAsJSON = (JSONArray)result.get("list");
      ArrayList<Alias> aliases = new ArrayList<Alias>();

      for (Object aliasAsJson: arrayAsJSON) {
        if (aliasAsJson instanceof JSONObject) {
          Alias alias = mapper.readValue(((JSONObject)aliasAsJson).toJSONString(), Alias.class);
          aliases.add(alias);
        }
      }
      listResult.setList(aliases);

      long totalItems = (Long)result.get("totalItems");
      listResult.setTotalItems(totalItems);
    }
    catch (JsonParseException e) {
      e.printStackTrace();
    }
    catch (JsonMappingException e) {
      e.printStackTrace();
    }
    catch (IOException e) {
      e.printStackTrace();
    }

    return listResult;
  }

  /**
   * Obtain a list of mail public folders in the given domain.
   *
   * @param publicFolderList - list of public folders
   * @param domainId - global identification of the domain
   * @throws GeneralException 
   * @throws Forbidden 
   * @throws ResourceDontExists 
   * @throws ResourceAlreadyExists 
   * @throws RequestTooLarge 
   * @throws InvalidJSON 
   * @throws InvalidParameters 
   * @throws InvalidRequest 
   * @throws RequestTimeout 
   * @throws SessionExpired 
   * @throws JSONRPC2Error 
   */
  public ArrayList<PublicFolder> getMailPublicFolderList(String domainId) throws JSONRPC2Error, SessionExpired, RequestTimeout, InvalidRequest, InvalidParameters, InvalidJSON, RequestTooLarge, ResourceAlreadyExists, ResourceDontExists, Forbidden, GeneralException {
    ArrayList<PublicFolder> listResult = new ArrayList<PublicFolder>(); 

    HashMap<String, Object> params = new HashMap<String, Object>();
    params.put("domainId", domainId);

    try {
      JSONArray arrayAsJSON = (JSONArray)executeJSONRPCRequest("Aliases.getMailPublicFolderList", "publicFolderList", params);

      for (Object folderAsJson: arrayAsJSON) {
        if (folderAsJson instanceof JSONObject) {
          PublicFolder folder = mapper.readValue(((JSONObject)folderAsJson).toJSONString(), PublicFolder.class);
          listResult.add(folder);
        }
      }
    }
    catch (JsonParseException e) {
      e.printStackTrace();
    }
    catch (JsonMappingException e) {
      e.printStackTrace();
    }
    catch (IOException e) {
      e.printStackTrace();
    }

    return listResult;
  }

  /**
   * TODO
   * 
   * Obtain a list of alias targets.
   *
   * @param list - alias targets
   * @param totalItems - amount of aliases for given search condition, useful when a limit is defined in the query
   * @param query - query conditions and limits
   * @param domainId - global identification of the domain
   */
  public AliasTargetListResult getTargetList(SearchQuery query, String domainId) {
    return new AliasTargetListResult();
  }

  /**
   * TODO
   * 
   * Delete aliases.
   *
   * @param errors - error message list
   * @param aliasList - list of global identifiers of aliases to be deleted
   */
  public ArrayList<Error> removeAliases(ArrayList<String> aliasIds) {
    return new ArrayList<Error>();
  }

  /**
   * TODO
   * 
   * Set an existing alias.
   *
   * @param errors - error message list
   * @param aliasIds - list of alias global identifier(s)
   * @param pattern - pattern to use for new values
   */
  public ArrayList<Error> setAliases(ArrayList<String> aliasIds, Alias pattern) {
    return new ArrayList<Error>();
  }

  /* end Aliases */

  /* begin MailingLists */

  public Download exportMlUsersToCsv(MlMembership kind, String mlId) throws SessionExpired, RequestTimeout, InvalidRequest, InvalidParameters, InvalidJSON, RequestTooLarge, ResourceAlreadyExists, ResourceDontExists, Forbidden, GeneralException, JsonParseException, JsonMappingException, IOException {
    HashMap<String, Object> params = new HashMap<String, Object>();
    params.put("mlId", mlId);
    params.put("kind", kind);

    JSONObject downloadAsJson = (JSONObject)executeJSONRPCRequest("MailingLists.exportMlUsersToCsv", "fileDownload", params);
    Download download = mapper.readValue(downloadAsJson.toJSONString(), Download.class);
    return download;
  }

  public MlListResult getMailingLists(String domainId) throws SessionExpired, RequestTimeout, InvalidRequest, InvalidParameters, InvalidJSON, RequestTooLarge, ResourceAlreadyExists, ResourceDontExists, Forbidden, GeneralException {
    MlListResult listResult = new MlListResult();

    HashMap<String, Object> query = new HashMap<String, Object>();

    query.put("fields", new String[] { "id", "domainId", "name", "description", "languageId", "welcomeString", "footerString", "subscription", "posting", "replyTo", "otherAddress", "subjectPrefix", "hideSenderAddress", "allowEmptySubject", "archive" } );

    HashMap<String, String> orderByItem = new HashMap<String, String>();
    orderByItem.put("columnName", "name");
    orderByItem.put("direction", "Asc");
    ArrayList<HashMap<String,String>> orderBy = new ArrayList<HashMap<String,String>>();
    orderBy.add(orderByItem);
    query.put("orderBy", orderBy);

    HashMap<String, Object> params = new HashMap<String, Object>();
    params.put("query", query);
    params.put("domainId", domainId);

    try {
      JSONObject result = (JSONObject)executeJSONRPCRequest("MailingLists.get", null, params);

      ArrayList<Ml> mailingLists = new ArrayList<Ml>();
      JSONArray arrayAsJson = (JSONArray)result.get("list");
      for (Object mlAsJson: arrayAsJson) {
        if (mlAsJson instanceof JSONObject) {
          Ml mailinglist = mapper.readValue(((JSONObject)mlAsJson).toJSONString(), Ml.class);
          mailingLists.add(mailinglist);
        }
      }
      listResult.setList(mailingLists);

      long totalItems = (Long)result.get("totalItems");
      listResult.setTotalItems(totalItems);
    }
    catch (JsonParseException e) {
      e.printStackTrace();
    }
    catch (JsonMappingException e) {
      e.printStackTrace();
    }
    catch (IOException e) {
      e.printStackTrace();
    }

    return listResult;
  }

  public MlUserListResult getMlUserList(String mlId) throws SessionExpired, RequestTimeout, InvalidRequest, InvalidParameters, InvalidJSON, RequestTooLarge, ResourceAlreadyExists, ResourceDontExists, Forbidden, GeneralException {
    MlUserListResult listResult = new MlUserListResult();

    HashMap<String, Object> query = new HashMap<String, Object>();
    query.put("fields", new String[] { "userId", "hasId", "emailAddress", "fullName", "kind" } );

    HashMap<String, Object> params = new HashMap<String, Object>();
    params.put("query", query);
    params.put("mlId", mlId);

    try {
      JSONObject result = (JSONObject)executeJSONRPCRequest("MailingLists.getMlUserList", null, params);

      ArrayList<UserOrEmail> mailingListUsers = new ArrayList<UserOrEmail>();
      JSONArray arrayAsJson = (JSONArray)result.get("list");
      for (Object mlAsJson: arrayAsJson) {
        if (mlAsJson instanceof JSONObject) {
          UserOrEmail mlUser = mapper.readValue(((JSONObject)mlAsJson).toJSONString(), UserOrEmail.class);
          mailingListUsers.add(mlUser);
        }
      }
      listResult.setList(mailingListUsers);

      long totalItems = (Long)result.get("totalItems");
      listResult.setTotalItems(totalItems);
    }
    catch (JsonParseException e) {
      e.printStackTrace();
    }
    catch (JsonMappingException e) {
      e.printStackTrace();
    }
    catch (IOException e) {
      e.printStackTrace();
    }

    return listResult;
  }

  // TODO
  public void getSuffixes(ArrayList<String> suffixes) {

  }

  TrusteeTargetListResult getTrusteeTargetList(String domainId) throws SessionExpired, RequestTimeout, InvalidRequest, InvalidParameters, InvalidJSON, RequestTooLarge, ResourceAlreadyExists, ResourceDontExists, Forbidden, GeneralException {
    TrusteeTargetListResult listResult = new TrusteeTargetListResult(); 

    HashMap<String, Object> query = new HashMap<String, Object>();

    query.put("fields", new String[] { "id", "name", "fullName", "description", "type", "isEnabled", "homeServer", "itemSource" } );

    HashMap<String, String> orderByItem = new HashMap<String, String>();
    orderByItem.put("columnName", "name");
    orderByItem.put("direction", "Asc");
    ArrayList<HashMap<String,String>> orderBy = new ArrayList<HashMap<String,String>>();
    orderBy.add(orderByItem);
    query.put("orderBy", orderBy);

    HashMap<String, Object> params = new HashMap<String, Object>();
    params.put("query", query);
    params.put("domainId", domainId);

    try {
      JSONObject result = (JSONObject)executeJSONRPCRequest("MailingLists.getTrusteeTargetList", null, params);

      JSONArray arrayAsJSON = (JSONArray)result.get("list");
      ArrayList<TrusteeTarget> trustees = new ArrayList<TrusteeTarget>();

      for (Object aliasAsJson: arrayAsJSON) {
        if (aliasAsJson instanceof JSONObject) {
          TrusteeTarget trustee = mapper.readValue(((JSONObject)aliasAsJson).toJSONString(), TrusteeTarget.class);
          trustees.add(trustee);
        }
      }
      listResult.setList(trustees);

      long totalItems = (Long)result.get("totalItems");
      listResult.setTotalItems(totalItems);
    }
    catch (JsonParseException e) {
      e.printStackTrace();
    }
    catch (JsonMappingException e) {
      e.printStackTrace();
    }
    catch (IOException e) {
      e.printStackTrace();
    }

    return listResult;

  }

  /* end MailingLists */

  /* begin Archives */

  public ArchiveOptions getArchive() throws JSONRPC2Error, SessionExpired, RequestTimeout, InvalidRequest, InvalidParameters, InvalidJSON, RequestTooLarge, ResourceAlreadyExists, ResourceDontExists, Forbidden, GeneralException, JsonParseException, JsonMappingException, IOException {
    JSONObject result = (JSONObject)executeJSONRPCRequest("Archive.get", "options");
    ArchiveOptions archive = mapper.readValue(((JSONObject)result).toJSONString(), ArchiveOptions.class);
    return archive;
  }

  /*
   * TODO
   */
  public void setArchive(ArchiveOptions options) {

  }

  /* end Archives */

  /* begin Backup */

  public BackupOptions getBackupOptions() throws JSONRPC2Error, SessionExpired, RequestTimeout, InvalidRequest, InvalidParameters, InvalidJSON, RequestTooLarge, ResourceAlreadyExists, ResourceDontExists, Forbidden, GeneralException, JsonParseException, JsonMappingException, IOException {
    JSONObject result = (JSONObject)executeJSONRPCRequest("Backup.get", "options");
    BackupOptions options = mapper.readValue(((JSONObject)result).toJSONString(), BackupOptions.class);
    return options;
  }

  public BackupStatus getBackupStatus() throws JSONRPC2Error, SessionExpired, RequestTimeout, InvalidRequest, InvalidParameters, InvalidJSON, RequestTooLarge, ResourceAlreadyExists, ResourceDontExists, Forbidden, GeneralException, JsonParseException, JsonMappingException, IOException {
    JSONObject result = (JSONObject)executeJSONRPCRequest("Backup.getStatus", "status");
    BackupStatus status = mapper.readValue(((JSONObject)result).toJSONString(), BackupStatus.class);
    return status;
  }

  // TODO
  public ArrayList<BackupSchedule> getScheduleList(SearchQuery query) {
    return new ArrayList<BackupSchedule>();
  }

  // TODO
  public void setBackupOptions(BackupOptions options) {

  }

  // TODO
  public void setScheduleList(ArrayList<BackupSchedule> options) {

  }

  // TODO
  public void startBackup(BackupType backupType) {

  }

  /* end Backup */

  /* begin ConnectCertificate */

  public ArrayList<Certificate> getCertificates(SearchQuery query) throws SessionExpired, RequestTimeout, InvalidRequest, InvalidParameters, InvalidJSON, RequestTooLarge, ResourceAlreadyExists, ResourceDontExists, Forbidden, GeneralException {
    ArrayList<Certificate> certificates = new ArrayList<Certificate>();

    HashMap<String, Object> params = new HashMap<String, Object>();
    params.put("query", query);

    try {
      JSONObject result = (JSONObject)executeJSONRPCRequest("ConnectCertificate.get", null, params);

      JSONArray arrayAsJSON = (JSONArray)result.get("certificates");

      for (Object certificatesAsJson: arrayAsJSON) {
        if (certificatesAsJson instanceof JSONObject) {
          Certificate certificate = mapper.readValue(((JSONObject)certificatesAsJson).toJSONString(), Certificate.class);
          certificates.add(certificate);
        }
      }
    }
    catch (JsonParseException e) {
      e.printStackTrace();
    }
    catch (JsonMappingException e) {
      e.printStackTrace();
    }
    catch (IOException e) {
      e.printStackTrace();
    }

    return certificates;
  }

  // TODO
  public String generateRequest(ArrayList<NamedValue> subject) {
    return null;
  }

  // TODO
  public String importPrivateKey(String fileId) {
    return null;
  }

  // TODO
  public void setActiveCertificate(String id) {

  }

  // TODO
  public ArrayList<Error> remove(ArrayList<String> ids) {
    return new ArrayList<Error>(); 
  }

  public String generateCertificate(ArrayList<NamedValue> subject, int yearsValid) throws SessionExpired, RequestTimeout, InvalidRequest, InvalidParameters, InvalidJSON, RequestTooLarge, ResourceAlreadyExists, ResourceDontExists, Forbidden, GeneralException {
    HashMap<String, Object> params = new HashMap<String, Object>();
    params.put("subject", subject);
    params.put("valid", yearsValid);

    JSONObject result = (JSONObject)executeJSONRPCRequest("ConnectCertificate.generate", null, params);
    return (String)result.get("id");
  }

  public Download exportCertificate(String id) throws SessionExpired, RequestTimeout, InvalidRequest, InvalidParameters, InvalidJSON, RequestTooLarge, ResourceAlreadyExists, ResourceDontExists, Forbidden, GeneralException, JsonParseException, JsonMappingException, IOException {
    HashMap<String, Object> params = new HashMap<String, Object>();
    params.put("id", id);

    JSONObject fileDownload = (JSONObject)executeJSONRPCRequest("ConnectCertificate.exportCertificate", "fileDownload", params);
    Download download = mapper.readValue(fileDownload.toJSONString(), Download.class);
    return download;
  }

  public Download exportPrivateKey(String id) throws SessionExpired, RequestTimeout, InvalidRequest, InvalidParameters, InvalidJSON, RequestTooLarge, ResourceAlreadyExists, ResourceDontExists, Forbidden, GeneralException, JsonParseException, JsonMappingException, IOException {
    HashMap<String, Object> params = new HashMap<String, Object>();
    params.put("id", id);

    JSONObject fileDownload = (JSONObject)executeJSONRPCRequest("ConnectCertificate.exportPrivateKey", "fileDownload", params);
    Download download = mapper.readValue(fileDownload.toJSONString(), Download.class);
    return download;
  }

  public String getCertificateAsString(String id) throws SessionExpired, RequestTimeout, InvalidRequest, InvalidParameters, InvalidJSON, RequestTooLarge, ResourceAlreadyExists, ResourceDontExists, Forbidden, GeneralException, JsonParseException, JsonMappingException, IOException {
    HashMap<String, Object> params = new HashMap<String, Object>();
    params.put("id", id);

    String source = (String)executeJSONRPCRequest("ConnectCertificate.toSource", "source", params);
    return source;
  }

  /* end ConnectCertificate */

  /* begin Content */

  // TODO
  public ArrayList<Error> addBlackLists(ArrayList<BlackList> items) {
    return new ArrayList<Error>();
  }

  public AntiSpamSetting getAntiSpamSetting() throws SessionExpired, RequestTimeout, InvalidRequest, InvalidParameters, InvalidJSON, RequestTooLarge, ResourceAlreadyExists, ResourceDontExists, Forbidden, GeneralException, JsonParseException, JsonMappingException, IOException {
    JSONObject settingAsJson = (JSONObject)executeJSONRPCRequest("Content.getAntiSpamSetting", "setting", null);
    AntiSpamSetting settings = mapper.readValue(settingAsJson.toJSONString(), AntiSpamSetting.class);
    return settings;
  }

  public AntivirusSetting getAntivirusSetting() throws SessionExpired, RequestTimeout, InvalidRequest, InvalidParameters, InvalidJSON, RequestTooLarge, ResourceAlreadyExists, ResourceDontExists, Forbidden, GeneralException, JsonParseException, JsonMappingException, IOException {
    JSONObject settingAsJson = (JSONObject)executeJSONRPCRequest("Content.getAntivirusSetting", "setting", null);
    AntivirusSetting settings = mapper.readValue(settingAsJson.toJSONString(), AntivirusSetting.class);
    return settings;
  }

  public ArrayList<AttachmentItem> getAttachmentRules() throws SessionExpired, RequestTimeout, InvalidRequest, InvalidParameters, InvalidJSON, RequestTooLarge, ResourceAlreadyExists, ResourceDontExists, Forbidden, GeneralException {
    ArrayList<AttachmentItem> rules = new ArrayList<AttachmentItem>();

    try {
      JSONArray arrayAsJSON = (JSONArray)executeJSONRPCRequest("Content.getAttachmentRules", "filterRules", null);

      for (Object ruleAsJson: arrayAsJSON) {
        if (ruleAsJson instanceof JSONObject) {
          AttachmentItem rule = mapper.readValue(((JSONObject)ruleAsJson).toJSONString(), AttachmentItem.class);
          rules.add(rule);
        }
      }
    }
    catch (JsonParseException e) {
      e.printStackTrace();
    }
    catch (JsonMappingException e) {
      e.printStackTrace();
    }
    catch (IOException e) {
      e.printStackTrace();
    }

    return rules;
  }

  public AttachmentSetting getAttachmentSetting() throws SessionExpired, RequestTimeout, InvalidRequest, InvalidParameters, InvalidJSON, RequestTooLarge, ResourceAlreadyExists, ResourceDontExists, Forbidden, GeneralException, JsonParseException, JsonMappingException, IOException {
    JSONObject settingAsJson = (JSONObject)executeJSONRPCRequest("Content.getAttachmentSetting", "setting", null);
    AttachmentSetting settings = mapper.readValue(settingAsJson.toJSONString(), AttachmentSetting.class);
    return settings;
  }

  public HashMap<String, ArrayList<String>> getAvailableAttachments() throws SessionExpired, RequestTimeout, InvalidRequest, InvalidParameters, InvalidJSON, RequestTooLarge, ResourceAlreadyExists, ResourceDontExists, Forbidden, GeneralException {
    HashMap<String, ArrayList<String>> objects = new HashMap<String, ArrayList<String>>();
    ArrayList<String> fileNames = new ArrayList<String>();
    ArrayList<String> mimeTypes = new ArrayList<String>();

    JSONObject result = (JSONObject)executeJSONRPCRequest("Content.getAvailableAttachments", null, null);

    JSONArray fileNamesAsJson = (JSONArray)result.get("fileNames");
    for (Object fileName: fileNamesAsJson) {
      fileNames.add((String)fileName);
    }
    
    JSONArray mimeTypesAsJson = (JSONArray)result.get("mimeTypes");
    for (Object mimeType: mimeTypesAsJson) {
      mimeTypes.add((String)mimeType);
    }

    objects.put("fileNames", fileNames);
    objects.put("mimeTypes", mimeTypes);

    return objects;

  }

  public ArrayList<BlackList> getBlackListList() throws SessionExpired, RequestTimeout, InvalidRequest, InvalidParameters, InvalidJSON, RequestTooLarge, ResourceAlreadyExists, ResourceDontExists, Forbidden, GeneralException {
    ArrayList<BlackList> list = new ArrayList<BlackList>();

    try {
      JSONArray arrayAsJSON = (JSONArray)executeJSONRPCRequest("Content.getBlackListList", "list", null);

      for (Object blackListAsJson: arrayAsJSON) {
        if (blackListAsJson instanceof JSONObject) {
          BlackList blackList = mapper.readValue(((JSONObject)blackListAsJson).toJSONString(), BlackList.class);
          list.add(blackList);
        }
      }
    }
    catch (JsonParseException e) {
      e.printStackTrace();
    }
    catch (JsonMappingException e) {
      e.printStackTrace();
    }
    catch (IOException e) {
      e.printStackTrace();
    }

    return list;
  }

  //void getCustomRuleList(out CustomRuleList list, out long totalItems, in kerio::web::SearchQuery query);

  // TODO
  public ArrayList<Error> removeBlackLists(ArrayList<String> ids) {
    return new ArrayList<Error>();
  }

  // TODO
  public void removeUnusedCustomRules(long number, HourOrDay unit) {
    
  }
  
  // TODO
  public void setAntiSpamSetting(AntiSpamSetting setting) {
   
  }
  
  // TODO
  public ArrayList<Error> setAntivirusSetting(AntivirusSetting setting) {
    return new ArrayList<Error>();
  }
  
  // TODO
  public void setAttachmentRules(ArrayList<AttachmentItem> filterRules) {
    
  }
  
// TODO
  public void setAttachmentSetting(AttachmentSetting setting) {
    
  }
  
  // TODO
  public ArrayList<Error> setBlackLists(ArrayList<String> ids, BlackList pattern) {
    return new ArrayList<Error>();
  }
  
  // TODO
  public void setCustomRuleList(ArrayList<CustomRule> list) {
    
  }
  
  public void testGreylistConnection() throws SessionExpired, RequestTimeout, InvalidRequest, InvalidParameters, InvalidJSON, RequestTooLarge, ResourceAlreadyExists, ResourceDontExists, Forbidden, GeneralException {
    executeJSONRPCRequest("Content.testGreylistConnection", null, null);
  }
  
  public IntegratedAvirUpdateStatus updateAntivirusStatus() throws SessionExpired, RequestTimeout, InvalidRequest, InvalidParameters, InvalidJSON, RequestTooLarge, ResourceAlreadyExists, ResourceDontExists, Forbidden, GeneralException, JsonParseException, JsonMappingException, IOException {
    JSONObject statusAsJson = (JSONObject)executeJSONRPCRequest("Content.updateAntivirusStatus", "status", null);
    IntegratedAvirUpdateStatus status = mapper.readValue(statusAsJson.toJSONString(), IntegratedAvirUpdateStatus.class);
    return status;
  }
  
  public void updateIntegratedAntivirus() throws SessionExpired, RequestTimeout, InvalidRequest, InvalidParameters, InvalidJSON, RequestTooLarge, ResourceAlreadyExists, ResourceDontExists, Forbidden, GeneralException {
    executeJSONRPCRequest("Content.updateIntegratedAntivirus", null, null);
  }

  /* end Content */
  
  /* begin Delivery */
  
  // TODO
  public ArrayList<Error> addEtrnDownloadList(ArrayList<EtrnDownload> downloads) {
    return new ArrayList<Error>();
  }
  
  // TODO
  public ArrayList<Error> addPop3AccountList(ArrayList<Pop3Account> accounts) {
    return new ArrayList<Error>();
  }
  
  // TODO
  public ArrayList<Error> addPop3SortingList(ArrayList<Pop3Sorting> sortings) {
    return new ArrayList<Error>();
  }
  
  // TODO
  public ArrayList<Error> addScheduledActionList(ArrayList<ScheduledAction> actions) {
    return new ArrayList<Error>();
  }
  
  public void downloadEtrn() throws SessionExpired, RequestTimeout, InvalidRequest, InvalidParameters, InvalidJSON, RequestTooLarge, ResourceAlreadyExists, ResourceDontExists, Forbidden, GeneralException {
    executeJSONRPCRequest("Delivery.downloadEtrn", null, null);
  }
  
  // void getEtrnDownloadList(out EtrnDownloadList list, out long totalItems, in kerio::web::SearchQuery query);
  public long getEtrnTimeout() throws SessionExpired, RequestTimeout, InvalidRequest, InvalidParameters, InvalidJSON, RequestTooLarge, ResourceAlreadyExists, ResourceDontExists, Forbidden, GeneralException {
    Long seconds = (Long)executeJSONRPCRequest("Delivery.getEtrnTimeout", "seconds", null);
    return seconds;
  }
  
  public InternetSettings getInternetSettings() throws SessionExpired, RequestTimeout, InvalidRequest, InvalidParameters, InvalidJSON, RequestTooLarge, ResourceAlreadyExists, ResourceDontExists, Forbidden, GeneralException, JsonParseException, JsonMappingException, IOException {
    JSONObject statusAsJson = (JSONObject)executeJSONRPCRequest("Delivery.getInternetSettings", "settings", null);
    InternetSettings settings = mapper.readValue(statusAsJson.toJSONString(), InternetSettings.class); 
    return settings;
  }
  
  //void getPop3AccountList(out Pop3AccountList list, out long totalItems, in kerio::web::SearchQuery query);
  //void getPop3SortingList(out Pop3SortingList list, out long totalItems, in kerio::web::SearchQuery query);
  public ArrayList<String> getRasNames() throws SessionExpired, RequestTimeout, InvalidRequest, InvalidParameters, InvalidJSON, RequestTooLarge, ResourceAlreadyExists, ResourceDontExists, Forbidden, GeneralException {
    ArrayList<String> list = new ArrayList<String>();

    JSONArray arrayAsJSON = (JSONArray)executeJSONRPCRequest("Delivery.getRasNames", "names", null);

    for (Object name: arrayAsJSON) {
      list.add((String)name);
    }

    return list;
  }
  
  //void getScheduledActionList(out ScheduledActionList list, out long totalItems, in kerio::web::SearchQuery query);
  // TODO
  public ArrayList<Error> removeEtrnDownloadList(ArrayList<String> ids) {
    return new ArrayList<Error>();
  }
  
  // TODO
  public ArrayList<Error> removePop3AccountList(ArrayList<String> ids) {
    return new ArrayList<Error>();
  }
  
  // TODO
  public ArrayList<Error> removePop3SortingList(ArrayList<String> ids) {
    return new ArrayList<Error>();
  }
  
  // TODO
  public ArrayList<Error> removeScheduledActionList(ArrayList<String> ids) {
    return new ArrayList<Error>();
  }
  
  public void runPop3Downloads() throws SessionExpired, RequestTimeout, InvalidRequest, InvalidParameters, InvalidJSON, RequestTooLarge, ResourceAlreadyExists, ResourceDontExists, Forbidden, GeneralException {
    executeJSONRPCRequest("Delivery.runPop3Downloads", null, null);
  }
  
  // TODO
  public void setEtrnDownload(String downloadId, EtrnDownload download) {
    
  }
  
  // TODO
  public void setEtrnTimeout(long seconds) {
    
  }
  
  // TODO
  public void setInternetSettings(InternetSettings settings) {
    
  }
  
  // TODO
  void setPop3Account(String accountId, Pop3Account account) {
    
  }
  
  // TODO
  void setPop3Sorting(String sortingId, Pop3Sorting sorting) {
    
  }
  
  // TODO
  void setScheduledAction(String actionId, ScheduledAction action) {
    
  }
  
  /* end Delivery */

  public class SessionExpired extends Exception {
    public SessionExpired(String message) {
      super(message);
    }
  }

  public class GeneralException extends Exception {
    public GeneralException(String message) {
      super(message);
    }

    public GeneralException(Throwable e) {
      super(e);
    }
  }

  public class RequestTimeout extends Exception {
    public RequestTimeout(String message) {
      super(message);
    }
  }

  public class InvalidRequest extends Exception {
    public InvalidRequest(String message) {
      super(message);
    }
  }

  public class InvalidParameters extends Exception {
    public InvalidParameters(String message) {
      super(message);
    }
  }

  public class InvalidJSON extends Exception {
    public InvalidJSON(String message) {
      super(message);
    }
  }

  public class RequestTooLarge extends Exception {
    public RequestTooLarge(String message) {
      super(message);
    }
  }

  public class ResourceAlreadyExists extends Exception {
    public ResourceAlreadyExists(String message) {
      super(message);
    }
  }  

  public class ResourceDontExists extends Exception {
    public ResourceDontExists(String message) {
      super(message);
    }
  }

  public class Forbidden extends Exception {
    public Forbidden(String message) {
      super(message);
    }
  }

}
