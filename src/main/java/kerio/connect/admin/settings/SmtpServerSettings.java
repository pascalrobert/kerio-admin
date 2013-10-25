package kerio.connect.admin.settings;

import kerio.connect.admin.common.SizeLimit;
import kerio.connect.admin.common.TimeLimit;
import kerio.connect.admin.users.User.ItemCountLimit;

public class SmtpServerSettings {

  Relay             relayControl;        ///< relay control options
  IpLimit              ipBasedLimit;        ///< limits based on IP address
  boolean              blockUnknownDns;     ///< block is sender's mail domain was not found in DNS
  boolean              verifyClientRDnsEntry;  ///< block if client's IP address has no reverse DNS entry (PTR)
  boolean              requireLocalDomainSenderAuth; ///< require SMTP authentication if the sender's address is from a local domain
  ItemCountLimit       maximumRecipients;      ///< maximum number of recipients in 1 message
  ItemCountLimit       maximumSmtpFailures; ///< maximum number of failed commands in 1 SMTP session
  SizeLimit   messageSize;         ///< limit for incomming SMTP message size
  long              readerHops;          ///< maximum number of accepted received headers (hops)
  SmtpDelivery         smtpOptions;         ///< SMTP delivery options
  boolean              useSSL;              ///< use SSL if supported by remote SMTP server
  long              maximumThreads;         ///< maximum number of delivery threads
  TimeLimit            retryInterval;       ///< delivery retry interval
  TimeLimit            bounceInterval;         ///< bounce the message to the sender if not delivered in defined time
  TimeLimit            warningInterval;     ///< warn sender if a message is not delivered within define time
  String               reportLanguage;         ///< 2 char abbreviation; we don't support reports added by user
    
  public SmtpServerSettings() {
    
  }

  public Relay getRelayControl() {
    return relayControl;
  }

  public void setRelayControl(Relay relayControl) {
    this.relayControl = relayControl;
  }

  public IpLimit getIpBasedLimit() {
    return ipBasedLimit;
  }

  public void setIpBasedLimit(IpLimit ipBasedLimit) {
    this.ipBasedLimit = ipBasedLimit;
  }

  public boolean isBlockUnknownDns() {
    return blockUnknownDns;
  }

  public void setBlockUnknownDns(boolean blockUnknownDns) {
    this.blockUnknownDns = blockUnknownDns;
  }

  public boolean isVerifyClientRDnsEntry() {
    return verifyClientRDnsEntry;
  }

  public void setVerifyClientRDnsEntry(boolean verifyClientRDnsEntry) {
    this.verifyClientRDnsEntry = verifyClientRDnsEntry;
  }

  public boolean isRequireLocalDomainSenderAuth() {
    return requireLocalDomainSenderAuth;
  }

  public void setRequireLocalDomainSenderAuth(boolean requireLocalDomainSenderAuth) {
    this.requireLocalDomainSenderAuth = requireLocalDomainSenderAuth;
  }

  public ItemCountLimit getMaximumRecipients() {
    return maximumRecipients;
  }

  public void setMaximumRecipients(ItemCountLimit maximumRecipients) {
    this.maximumRecipients = maximumRecipients;
  }

  public ItemCountLimit getMaximumSmtpFailures() {
    return maximumSmtpFailures;
  }

  public void setMaximumSmtpFailures(ItemCountLimit maximumSmtpFailures) {
    this.maximumSmtpFailures = maximumSmtpFailures;
  }

  public SizeLimit getMessageSize() {
    return messageSize;
  }

  public void setMessageSize(SizeLimit messageSize) {
    this.messageSize = messageSize;
  }

  public long getReaderHops() {
    return readerHops;
  }

  public void setReaderHops(long readerHops) {
    this.readerHops = readerHops;
  }

  public SmtpDelivery getSmtpOptions() {
    return smtpOptions;
  }

  public void setSmtpOptions(SmtpDelivery smtpOptions) {
    this.smtpOptions = smtpOptions;
  }

  public boolean isUseSSL() {
    return useSSL;
  }

  public void setUseSSL(boolean useSSL) {
    this.useSSL = useSSL;
  }

  public long getMaximumThreads() {
    return maximumThreads;
  }

  public void setMaximumThreads(long maximumThreads) {
    this.maximumThreads = maximumThreads;
  }

  public TimeLimit getRetryInterval() {
    return retryInterval;
  }

  public void setRetryInterval(TimeLimit retryInterval) {
    this.retryInterval = retryInterval;
  }

  public TimeLimit getBounceInterval() {
    return bounceInterval;
  }

  public void setBounceInterval(TimeLimit bounceInterval) {
    this.bounceInterval = bounceInterval;
  }

  public TimeLimit getWarningInterval() {
    return warningInterval;
  }

  public void setWarningInterval(TimeLimit warningInterval) {
    this.warningInterval = warningInterval;
  }

  public String getReportLanguage() {
    return reportLanguage;
  }

  public void setReportLanguage(String reportLanguage) {
    this.reportLanguage = reportLanguage;
  }
  
  public enum SmtpAuthentication {
    Pop3Based,     ///< POP3 authentication before SMTP
    Auth        ///< AUTH SMTP command
  }

  public static class Relay {
    boolean        isRestricted;           ///< is relay restricted? false == open relay enabled
    String         ipAddressGroupName;        ///< output only: name of IP group from which open relay is enabled
    String   ipAddressGroupId;       ///< ID of IP group from which open relay is enabled
    boolean        authenticateOutgoing;      ///< client must authenticate before sending a message
    ItemCountLimit forwardPop3authentication; ///< client can be authenticated by POP3 before SMTP relay for certain number of minutes
    boolean        hideLocalIpInRcv;        ///< hide local IP address in receive headers
    
    public Relay() {
      
    }

    public boolean isIsRestricted() {
      return isRestricted;
    }

    public void setIsRestricted(boolean isRestricted) {
      this.isRestricted = isRestricted;
    }

    public String getIpAddressGroupName() {
      return ipAddressGroupName;
    }

    public void setIpAddressGroupName(String ipAddressGroupName) {
      this.ipAddressGroupName = ipAddressGroupName;
    }

    public String getIpAddressGroupId() {
      return ipAddressGroupId;
    }

    public void setIpAddressGroupId(String ipAddressGroupId) {
      this.ipAddressGroupId = ipAddressGroupId;
    }

    public boolean isAuthenticateOutgoing() {
      return authenticateOutgoing;
    }

    public void setAuthenticateOutgoing(boolean authenticateOutgoing) {
      this.authenticateOutgoing = authenticateOutgoing;
    }

    public ItemCountLimit getForwardPop3authentication() {
      return forwardPop3authentication;
    }

    public void setForwardPop3authentication(ItemCountLimit forwardPop3authentication) {
      this.forwardPop3authentication = forwardPop3authentication;
    }

    public boolean isHideLocalIpInRcv() {
      return hideLocalIpInRcv;
    }

    public void setHideLocalIpInRcv(boolean hideLocalIpInRcv) {
      this.hideLocalIpInRcv = hideLocalIpInRcv;
    }

  }
  public static class RelayAuthentication {
    boolean           isRequired;       ///< is authentication required?
    String            userName;         ///< user name for relay server authentication
    String            password;         ///< password for relay server authentication
    SmtpAuthentication   authType;         ///< type of authentication
    
    public RelayAuthentication() {
      
    }

    public boolean isIsRequired() {
      return isRequired;
    }

    public void setIsRequired(boolean isRequired) {
      this.isRequired = isRequired;
    }

    public String getUserName() {
      return userName;
    }

    public void setUserName(String userName) {
      this.userName = userName;
    }

    public String getPassword() {
      return password;
    }

    public void setPassword(String password) {
      this.password = password;
    }

    public SmtpAuthentication getAuthType() {
      return authType;
    }

    public void setAuthType(SmtpAuthentication authType) {
      this.authType = authType;
    }
  }

  public static class SmtpDelivery {
    boolean           isUsedRelay;      ///< true = SMTP server is used / false = direct use of MX record
    String            hostName;         ///< relay server hostname
    long           port;          ///< relay server port
    RelayAuthentication  authentication;      ///< relay server authentication parameters
    
    public SmtpDelivery() {
      
    }

    public boolean isIsUsedRelay() {
      return isUsedRelay;
    }

    public void setIsUsedRelay(boolean isUsedRelay) {
      this.isUsedRelay = isUsedRelay;
    }

    public String getHostName() {
      return hostName;
    }

    public void setHostName(String hostName) {
      this.hostName = hostName;
    }

    public long getPort() {
      return port;
    }

    public void setPort(long port) {
      this.port = port;
    }

    public RelayAuthentication getAuthentication() {
      return authentication;
    }

    public void setAuthentication(RelayAuthentication authentication) {
      this.authentication = authentication;
    }
  }

  public static class IpLimit {
    ItemCountLimit maximumFromIp;       ///< maximum number of messages per hour from 1 IP address
    ItemCountLimit maximumConnections;     ///< maximum number of concurrent SMTP connections from 1 IP address
    ItemCountLimit maximumUnknowns;     ///< maximum number of unknown recipients
    String         ipAddressGroupName;     ///< output only: name of IP group on which limits are NOT applied
    String   ipAddressGroupId;    ///< ID of IP group on which limits are NOT applied
    
    public IpLimit() {
      
    }

    public ItemCountLimit getMaximumFromIp() {
      return maximumFromIp;
    }

    public void setMaximumFromIp(ItemCountLimit maximumFromIp) {
      this.maximumFromIp = maximumFromIp;
    }

    public ItemCountLimit getMaximumConnections() {
      return maximumConnections;
    }

    public void setMaximumConnections(ItemCountLimit maximumConnections) {
      this.maximumConnections = maximumConnections;
    }

    public ItemCountLimit getMaximumUnknowns() {
      return maximumUnknowns;
    }

    public void setMaximumUnknowns(ItemCountLimit maximumUnknowns) {
      this.maximumUnknowns = maximumUnknowns;
    }

    public String getIpAddressGroupName() {
      return ipAddressGroupName;
    }

    public void setIpAddressGroupName(String ipAddressGroupName) {
      this.ipAddressGroupName = ipAddressGroupName;
    }

    public String getIpAddressGroupId() {
      return ipAddressGroupId;
    }

    public void setIpAddressGroupId(String ipAddressGroupId) {
      this.ipAddressGroupId = ipAddressGroupId;
    }
  }
}
