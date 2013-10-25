package kerio.connect.admin.settings;

import java.util.ArrayList;

import kerio.connect.admin.common.ByteValueWithUnits;
import kerio.connect.admin.common.Distance;

public class ServerStatistics {

  long     start;
  Distance       uptime;     ///< server uptime
  OccupiedStorage      storage;
  MessageThroughput received;         ///< messages received by server
  MessageThroughput storedInQueue;    ///< messages stored in queue
  MessageThroughput transmitted;      ///< messages transmitted by server
  MessageThroughput deliveredToLocals;   ///< messages delivered to local domains
  MessageThroughput mx;               ///< messages sent to remote MX servers
  MessageThroughput relay;            ///< messages sent to relay server
  FailureAndBounce  failures;
  Notifications     deliveryStatus;
  AntivirusStats    antivirus;
  SpamStats         spam;
  OtherStats        other;
  SmtpServerStats      smtpServer;
  SmtpClientStats      smtpClient;
  Pop3ServerStats      pop3Server;
  Pop3ClientStats      pop3Client;
  ImapServerStats      imapServer;
  LdapServerStats      ldapServer;
  WebServerStats    webServer;
  XmppServerStats      xmppServer;
  DnsResolverStats  dnsResolver;
  AntibombingStats  antibombing;
  GreylistingStats  greylisting;
  
  public ServerStatistics() {
    
  }

  public long getStart() {
    return start;
  }

  public void setStart(long start) {
    this.start = start;
  }

  public Distance getUptime() {
    return uptime;
  }

  public void setUptime(Distance uptime) {
    this.uptime = uptime;
  }

  public OccupiedStorage getStorage() {
    return storage;
  }

  public void setStorage(OccupiedStorage storage) {
    this.storage = storage;
  }

  public MessageThroughput getReceived() {
    return received;
  }

  public void setReceived(MessageThroughput received) {
    this.received = received;
  }

  public MessageThroughput getStoredInQueue() {
    return storedInQueue;
  }

  public void setStoredInQueue(MessageThroughput storedInQueue) {
    this.storedInQueue = storedInQueue;
  }

  public MessageThroughput getTransmitted() {
    return transmitted;
  }

  public void setTransmitted(MessageThroughput transmitted) {
    this.transmitted = transmitted;
  }

  public MessageThroughput getDeliveredToLocals() {
    return deliveredToLocals;
  }

  public void setDeliveredToLocals(MessageThroughput deliveredToLocals) {
    this.deliveredToLocals = deliveredToLocals;
  }

  public MessageThroughput getMx() {
    return mx;
  }

  public void setMx(MessageThroughput mx) {
    this.mx = mx;
  }

  public MessageThroughput getRelay() {
    return relay;
  }

  public void setRelay(MessageThroughput relay) {
    this.relay = relay;
  }

  public FailureAndBounce getFailures() {
    return failures;
  }

  public void setFailures(FailureAndBounce failures) {
    this.failures = failures;
  }

  public Notifications getDeliveryStatus() {
    return deliveryStatus;
  }

  public void setDeliveryStatus(Notifications deliveryStatus) {
    this.deliveryStatus = deliveryStatus;
  }

  public AntivirusStats getAntivirus() {
    return antivirus;
  }

  public void setAntivirus(AntivirusStats antivirus) {
    this.antivirus = antivirus;
  }

  public SpamStats getSpam() {
    return spam;
  }

  public void setSpam(SpamStats spam) {
    this.spam = spam;
  }

  public OtherStats getOther() {
    return other;
  }

  public void setOther(OtherStats other) {
    this.other = other;
  }

  public SmtpServerStats getSmtpServer() {
    return smtpServer;
  }

  public void setSmtpServer(SmtpServerStats smtpServer) {
    this.smtpServer = smtpServer;
  }

  public SmtpClientStats getSmtpClient() {
    return smtpClient;
  }

  public void setSmtpClient(SmtpClientStats smtpClient) {
    this.smtpClient = smtpClient;
  }

  public Pop3ServerStats getPop3Server() {
    return pop3Server;
  }

  public void setPop3Server(Pop3ServerStats pop3Server) {
    this.pop3Server = pop3Server;
  }

  public Pop3ClientStats getPop3Client() {
    return pop3Client;
  }

  public void setPop3Client(Pop3ClientStats pop3Client) {
    this.pop3Client = pop3Client;
  }

  public ImapServerStats getImapServer() {
    return imapServer;
  }

  public void setImapServer(ImapServerStats imapServer) {
    this.imapServer = imapServer;
  }

  public LdapServerStats getLdapServer() {
    return ldapServer;
  }

  public void setLdapServer(LdapServerStats ldapServer) {
    this.ldapServer = ldapServer;
  }

  public WebServerStats getWebServer() {
    return webServer;
  }

  public void setWebServer(WebServerStats webServer) {
    this.webServer = webServer;
  }

  public XmppServerStats getXmppServer() {
    return xmppServer;
  }

  public void setXmppServer(XmppServerStats xmppServer) {
    this.xmppServer = xmppServer;
  }

  public DnsResolverStats getDnsResolver() {
    return dnsResolver;
  }

  public void setDnsResolver(DnsResolverStats dnsResolver) {
    this.dnsResolver = dnsResolver;
  }

  public AntibombingStats getAntibombing() {
    return antibombing;
  }

  public void setAntibombing(AntibombingStats antibombing) {
    this.antibombing = antibombing;
  }

  public GreylistingStats getGreylisting() {
    return greylisting;
  }

  public void setGreylisting(GreylistingStats greylisting) {
    this.greylisting = greylisting;
  }

  public class MessageThroughput {

    String               count;      ///< how many messages
    ByteValueWithUnits   volume;     ///< how much space is occupied by messages
    String               recipients; ///< how many recipients in messages
    
    public MessageThroughput() {
      
    }

    public String getCount() {
      return count;
    }

    public void setCount(String count) {
      this.count = count;
    }

    public ByteValueWithUnits getVolume() {
      return volume;
    }

    public void setVolume(ByteValueWithUnits volume) {
      this.volume = volume;
    }

    public String getRecipients() {
      return recipients;
    }

    public void setRecipients(String recipients) {
      this.recipients = recipients;
    }

  }

  public class OccupiedStorage {

    ByteValueWithUnits   total;      ///< total space on disc
    ByteValueWithUnits   occupied;   ///< occupied space on disc
    String               percentage; ///< how many per cent is occupied
    
    public OccupiedStorage() {
      
    }

    public ByteValueWithUnits getTotal() {
      return total;
    }

    public void setTotal(ByteValueWithUnits total) {
      this.total = total;
    }

    public ByteValueWithUnits getOccupied() {
      return occupied;
    }

    public void setOccupied(ByteValueWithUnits occupied) {
      this.occupied = occupied;
    }

    public String getPercentage() {
      return percentage;
    }

    public void setPercentage(String percentage) {
      this.percentage = percentage;
    }

  }

  public class FailureAndBounce {
    String   transientFailures;   ///< transient delivery failures
    String   permanentFailures;   ///< permanent delivery failures
    
    public FailureAndBounce() {
      
    }

    public String getTransientFailures() {
      return transientFailures;
    }

    public void setTransientFailures(String transientFailures) {
      this.transientFailures = transientFailures;
    }

    public String getPermanentFailures() {
      return permanentFailures;
    }

    public void setPermanentFailures(String permanentFailures) {
      this.permanentFailures = permanentFailures;
    }
  }

  public class Notifications {
    String   success; ///< how many sent success notifications
    String   delay;      ///< how many sent delay notifications
    String   failure; ///< how many sent failure notifications
    
    public Notifications() {
      
    }

    public String getSuccess() {
      return success;
    }

    public void setSuccess(String success) {
      this.success = success;
    }

    public String getDelay() {
      return delay;
    }

    public void setDelay(String delay) {
      this.delay = delay;
    }

    public String getFailure() {
      return failure;
    }

    public void setFailure(String failure) {
      this.failure = failure;
    }
  }

  public class AntivirusStats {
    String   checkedAttachments;  ///< how many checked attachments
    String   foundViruses;     ///< how many found viruses
    String   prohibitedTypes;  ///< how many found prohibited filenames/MIME types
    
    public AntivirusStats() {
      
    }

    public String getCheckedAttachments() {
      return checkedAttachments;
    }

    public void setCheckedAttachments(String checkedAttachments) {
      this.checkedAttachments = checkedAttachments;
    }

    public String getFoundViruses() {
      return foundViruses;
    }

    public void setFoundViruses(String foundViruses) {
      this.foundViruses = foundViruses;
    }

    public String getProhibitedTypes() {
      return prohibitedTypes;
    }

    public void setProhibitedTypes(String prohibitedTypes) {
      this.prohibitedTypes = prohibitedTypes;
    }
  }

  public class SpamStats {
    String   checked;       ///< how many checked messages
    String   tagged;           ///< how many tagged messages
    String   rejected;         ///< how many rejected messages
    String   markedAsSpam;     ///< how many messages were marked as spam by users
    String   markedAsNotSpam;  ///< how many messages were marked as NOT spam by users
    
    public SpamStats() {
      
    }

    public String getChecked() {
      return checked;
    }

    public void setChecked(String checked) {
      this.checked = checked;
    }

    public String getTagged() {
      return tagged;
    }

    public void setTagged(String tagged) {
      this.tagged = tagged;
    }

    public String getRejected() {
      return rejected;
    }

    public void setRejected(String rejected) {
      this.rejected = rejected;
    }

    public String getMarkedAsSpam() {
      return markedAsSpam;
    }

    public void setMarkedAsSpam(String markedAsSpam) {
      this.markedAsSpam = markedAsSpam;
    }

    public String getMarkedAsNotSpam() {
      return markedAsNotSpam;
    }

    public void setMarkedAsNotSpam(String markedAsNotSpam) {
      this.markedAsNotSpam = markedAsNotSpam;
    }
  }

  public class OtherStats {
    ByteValueWithUnits   largest; ///< the largest messages received by server
    String                     loops;      ///< how many detected message loops
    
    public OtherStats() {
      
    }

    public ByteValueWithUnits getLargest() {
      return largest;
    }

    public void setLargest(ByteValueWithUnits largest) {
      this.largest = largest;
    }

    public String getLoops() {
      return loops;
    }

    public void setLoops(String loops) {
      this.loops = loops;
    }
  }

  public class SmtpServerStats {
    String   totalIncomingConnections;
    String   lostConnections;
    String   rejectedByBlacklist;
    String   authenticationAttempts;
    String   authenticationFailures;
    String   rejectedRelays;
    String   acceptedMessages;
    
    public SmtpServerStats() {
      
    }

    public String getTotalIncomingConnections() {
      return totalIncomingConnections;
    }

    public void setTotalIncomingConnections(String totalIncomingConnections) {
      this.totalIncomingConnections = totalIncomingConnections;
    }

    public String getLostConnections() {
      return lostConnections;
    }

    public void setLostConnections(String lostConnections) {
      this.lostConnections = lostConnections;
    }

    public String getRejectedByBlacklist() {
      return rejectedByBlacklist;
    }

    public void setRejectedByBlacklist(String rejectedByBlacklist) {
      this.rejectedByBlacklist = rejectedByBlacklist;
    }

    public String getAuthenticationAttempts() {
      return authenticationAttempts;
    }

    public void setAuthenticationAttempts(String authenticationAttempts) {
      this.authenticationAttempts = authenticationAttempts;
    }

    public String getAuthenticationFailures() {
      return authenticationFailures;
    }

    public void setAuthenticationFailures(String authenticationFailures) {
      this.authenticationFailures = authenticationFailures;
    }

    public String getRejectedRelays() {
      return rejectedRelays;
    }

    public void setRejectedRelays(String rejectedRelays) {
      this.rejectedRelays = rejectedRelays;
    }

    public String getAcceptedMessages() {
      return acceptedMessages;
    }

    public void setAcceptedMessages(String acceptedMessages) {
      this.acceptedMessages = acceptedMessages;
    }
  }

  public class SmtpClientStats {
    String   connectionAttempts;
    String   dnsFailures;
    String   connectionFailures;
    String   connectionLosses;
    
    public SmtpClientStats() {
      
    }

    public String getConnectionAttempts() {
      return connectionAttempts;
    }

    public void setConnectionAttempts(String connectionAttempts) {
      this.connectionAttempts = connectionAttempts;
    }

    public String getDnsFailures() {
      return dnsFailures;
    }

    public void setDnsFailures(String dnsFailures) {
      this.dnsFailures = dnsFailures;
    }

    public String getConnectionFailures() {
      return connectionFailures;
    }

    public void setConnectionFailures(String connectionFailures) {
      this.connectionFailures = connectionFailures;
    }

    public String getConnectionLosses() {
      return connectionLosses;
    }

    public void setConnectionLosses(String connectionLosses) {
      this.connectionLosses = connectionLosses;
    }
  }

  public class Pop3ServerStats {
    String   totalIncomingConnections;
    String   authenticationFailures;
    String   sentMessages;
    
    public Pop3ServerStats() {
      
    }

    public String getTotalIncomingConnections() {
      return totalIncomingConnections;
    }

    public void setTotalIncomingConnections(String totalIncomingConnections) {
      this.totalIncomingConnections = totalIncomingConnections;
    }

    public String getAuthenticationFailures() {
      return authenticationFailures;
    }

    public void setAuthenticationFailures(String authenticationFailures) {
      this.authenticationFailures = authenticationFailures;
    }

    public String getSentMessages() {
      return sentMessages;
    }

    public void setSentMessages(String sentMessages) {
      this.sentMessages = sentMessages;
    }
  }

  public class Pop3ClientStats {
    String   connectionAttempts;
    String   connectionFailures;
    String   authenticationFailures;
    String   totalDownloads;
    
    public Pop3ClientStats() {
      
    }

    public String getConnectionAttempts() {
      return connectionAttempts;
    }

    public void setConnectionAttempts(String connectionAttempts) {
      this.connectionAttempts = connectionAttempts;
    }

    public String getConnectionFailures() {
      return connectionFailures;
    }

    public void setConnectionFailures(String connectionFailures) {
      this.connectionFailures = connectionFailures;
    }

    public String getAuthenticationFailures() {
      return authenticationFailures;
    }

    public void setAuthenticationFailures(String authenticationFailures) {
      this.authenticationFailures = authenticationFailures;
    }

    public String getTotalDownloads() {
      return totalDownloads;
    }

    public void setTotalDownloads(String totalDownloads) {
      this.totalDownloads = totalDownloads;
    }
  }

  public class ImapServerStats {
    String   totalIncomingConnections;
    String   authenticationFailures;
    
    public ImapServerStats() {
      
    }

    public String getTotalIncomingConnections() {
      return totalIncomingConnections;
    }

    public void setTotalIncomingConnections(String totalIncomingConnections) {
      this.totalIncomingConnections = totalIncomingConnections;
    }

    public String getAuthenticationFailures() {
      return authenticationFailures;
    }

    public void setAuthenticationFailures(String authenticationFailures) {
      this.authenticationFailures = authenticationFailures;
    }
  }

  public class LdapServerStats {
    String   totalIncomingConnections;
    String   authenticationFailures;
    String   totalSearchRequests;
    
    public LdapServerStats() {
      
    }

    public String getTotalIncomingConnections() {
      return totalIncomingConnections;
    }

    public void setTotalIncomingConnections(String totalIncomingConnections) {
      this.totalIncomingConnections = totalIncomingConnections;
    }

    public String getAuthenticationFailures() {
      return authenticationFailures;
    }

    public void setAuthenticationFailures(String authenticationFailures) {
      this.authenticationFailures = authenticationFailures;
    }

    public String getTotalSearchRequests() {
      return totalSearchRequests;
    }

    public void setTotalSearchRequests(String totalSearchRequests) {
      this.totalSearchRequests = totalSearchRequests;
    }
  }

  public class WebServerStats {
    String   totalIncomingConnections;
    
    public WebServerStats() {
      
    }

    public String getTotalIncomingConnections() {
      return totalIncomingConnections;
    }

    public void setTotalIncomingConnections(String totalIncomingConnections) {
      this.totalIncomingConnections = totalIncomingConnections;
    }
  }

  public class XmppServerStats {
    String   totalIncomingConnections;
    String   authenticationFailures;
    String   droppedPackets;
    String   sentPackets;
    String   sentMessages;
    
    public XmppServerStats() {
      
    }

    public String getTotalIncomingConnections() {
      return totalIncomingConnections;
    }

    public void setTotalIncomingConnections(String totalIncomingConnections) {
      this.totalIncomingConnections = totalIncomingConnections;
    }

    public String getAuthenticationFailures() {
      return authenticationFailures;
    }

    public void setAuthenticationFailures(String authenticationFailures) {
      this.authenticationFailures = authenticationFailures;
    }

    public String getDroppedPackets() {
      return droppedPackets;
    }

    public void setDroppedPackets(String droppedPackets) {
      this.droppedPackets = droppedPackets;
    }

    public String getSentPackets() {
      return sentPackets;
    }

    public void setSentPackets(String sentPackets) {
      this.sentPackets = sentPackets;
    }

    public String getSentMessages() {
      return sentMessages;
    }

    public void setSentMessages(String sentMessages) {
      this.sentMessages = sentMessages;
    }
  }

  public class DnsResolverStats {
    String   hostnameQueries;
    String   cachedHostnameQueries;
    String   mxQueries;
    String   cachedMxQueries;
    
    public DnsResolverStats() {
      
    }

    public String getHostnameQueries() {
      return hostnameQueries;
    }

    public void setHostnameQueries(String hostnameQueries) {
      this.hostnameQueries = hostnameQueries;
    }

    public String getCachedHostnameQueries() {
      return cachedHostnameQueries;
    }

    public void setCachedHostnameQueries(String cachedHostnameQueries) {
      this.cachedHostnameQueries = cachedHostnameQueries;
    }

    public String getMxQueries() {
      return mxQueries;
    }

    public void setMxQueries(String mxQueries) {
      this.mxQueries = mxQueries;
    }

    public String getCachedMxQueries() {
      return cachedMxQueries;
    }

    public void setCachedMxQueries(String cachedMxQueries) {
      this.cachedMxQueries = cachedMxQueries;
    }
  }

  public class AntibombingStats {
    String   rejectedConnections;
    String   rejectedMessages;
    String   rejectedHarvestAttacks;
    
    public AntibombingStats() {
      
    }

    public String getRejectedConnections() {
      return rejectedConnections;
    }

    public void setRejectedConnections(String rejectedConnections) {
      this.rejectedConnections = rejectedConnections;
    }

    public String getRejectedMessages() {
      return rejectedMessages;
    }

    public void setRejectedMessages(String rejectedMessages) {
      this.rejectedMessages = rejectedMessages;
    }

    public String getRejectedHarvestAttacks() {
      return rejectedHarvestAttacks;
    }

    public void setRejectedHarvestAttacks(String rejectedHarvestAttacks) {
      this.rejectedHarvestAttacks = rejectedHarvestAttacks;
    }
  }

  public class  GreylistingStats {
    String messagesAccepted;
    String messagesDelayed;
    String messagesSkipped;
    
    public GreylistingStats() {
      
    }

    public String getMessagesAccepted() {
      return messagesAccepted;
    }

    public void setMessagesAccepted(String messagesAccepted) {
      this.messagesAccepted = messagesAccepted;
    }

    public String getMessagesDelayed() {
      return messagesDelayed;
    }

    public void setMessagesDelayed(String messagesDelayed) {
      this.messagesDelayed = messagesDelayed;
    }

    public String getMessagesSkipped() {
      return messagesSkipped;
    }

    public void setMessagesSkipped(String messagesSkipped) {
      this.messagesSkipped = messagesSkipped;
    }
  }

  public class Scale {
    long id;
    long scaleTime;      ///< The time scale
    long sampleTime;  ///< The sample scale
  }

  public class Chart {
    String classname; ///< A class name of chart
    String name;      ///< A chart name
    String xtype;     ///< An x scale type
    String ytype;     ///< An y scale type
    long scaleCount;  ///< A count of scales
    ArrayList<Scale> scale;  ///< List of scales
  }

  public class ChartData {
    String         xName;         ///< Name of X axis
    ArrayList<Long>  xValues;       ///< Values of X axis
    long countValues;          ///< A count of values in X axis
    long countRows;               ///< A count of rows
    ArrayList<String>  rowNames;  ///< Array of names of rows
    ArrayList<ArrayList<Long>> rowValues; ///< Array of values of rows
  }

}
