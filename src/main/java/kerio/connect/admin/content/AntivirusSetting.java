package kerio.connect.admin.content;

import java.util.ArrayList;

import kerio.connect.admin.common.DistanceOrNull;
import kerio.connect.admin.common.OptionalString;

public class AntivirusSetting {

  boolean              useIntegrated;    ///< integrated antivirus is used?
  boolean              useExternal;      ///< an external antivirus is used? note: both internal and extenal can be used together
  AntivirusStatus         status;           ///< status of antivirus to be used for informative massage
  ArrayList<AntivirusPlugin>    plugins;       ///< list of available antivirus plugins
  String               selectedId;       ///< identifier of currently selected antivirus plugin
  IntegratedEngine     engine;           ///< integrated engine settings
  FoundVirusBehavior      virusReaction;    ///< found virus reaction setting
  ReactionOnNotScanned notScannedReaction;  ///< found corruption or encryption reaction type
  
  public AntivirusSetting() {
    
  }

  public boolean isUseIntegrated() {
    return useIntegrated;
  }

  public void setUseIntegrated(boolean useIntegrated) {
    this.useIntegrated = useIntegrated;
  }

  public boolean isUseExternal() {
    return useExternal;
  }

  public void setUseExternal(boolean useExternal) {
    this.useExternal = useExternal;
  }

  public AntivirusStatus getStatus() {
    return status;
  }

  public void setStatus(AntivirusStatus status) {
    this.status = status;
  }

  public ArrayList<AntivirusPlugin> getPlugins() {
    return plugins;
  }

  public void setPlugins(ArrayList<AntivirusPlugin> plugins) {
    this.plugins = plugins;
  }

  public String getSelectedId() {
    return selectedId;
  }

  public void setSelectedId(String selectedId) {
    this.selectedId = selectedId;
  }

  public IntegratedEngine getEngine() {
    return engine;
  }

  public void setEngine(IntegratedEngine engine) {
    this.engine = engine;
  }

  public FoundVirusBehavior getVirusReaction() {
    return virusReaction;
  }

  public void setVirusReaction(FoundVirusBehavior virusReaction) {
    this.virusReaction = virusReaction;
  }

  public ReactionOnNotScanned getNotScannedReaction() {
    return notScannedReaction;
  }

  public void setNotScannedReaction(ReactionOnNotScanned notScannedReaction) {
    this.notScannedReaction = notScannedReaction;
  }

  public static class AntivirusOption {
    String   name;
    String   content;
    String   defaultValue;                 ///< read only value
    
    public AntivirusOption() {
      
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public String getContent() {
      return content;
    }

    public void setContent(String content) {
      this.content = content;
    }

    public String getDefaultValue() {
      return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
      this.defaultValue = defaultValue;
    }
  }
  
  public static class AntivirusPlugin {
    String            id;                  ///< example: avir_avg
    String            description;         ///< example: AVG Email Server Edition
    boolean           areOptionsAvailable;
    ArrayList<AntivirusOption>  options;
    
    public AntivirusPlugin() {
      
    }

    public String getId() {
      return id;
    }

    public void setId(String id) {
      this.id = id;
    }

    public String getDescription() {
      return description;
    }

    public void setDescription(String description) {
      this.description = description;
    }

    public boolean isAreOptionsAvailable() {
      return areOptionsAvailable;
    }

    public void setAreOptionsAvailable(boolean areOptionsAvailable) {
      this.areOptionsAvailable = areOptionsAvailable;
    }

    public ArrayList<AntivirusOption> getOptions() {
      return options;
    }

    public void setOptions(ArrayList<AntivirusOption> options) {
      this.options = options;
    }
  }
  
  public static class FoundVirusBehavior {
    ReactionOnVirus          reaction;
    OptionalString forwardOriginal;     ///< should be original message forwarded?
    OptionalString forwardFiltered;     ///< should be filtered message forwarded?

    public FoundVirusBehavior() {

    }

    public ReactionOnVirus getReaction() {
      return reaction;
    }

    public void setReaction(ReactionOnVirus reaction) {
      this.reaction = reaction;
    }

    public OptionalString getForwardOriginal() {
      return forwardOriginal;
    }

    public void setForwardOriginal(OptionalString forwardOriginal) {
      this.forwardOriginal = forwardOriginal;
    }

    public OptionalString getForwardFiltered() {
      return forwardFiltered;
    }

    public void setForwardFiltered(OptionalString forwardFiltered) {
      this.forwardFiltered = forwardFiltered;
    }
  }

  public static class IntegratedEngine {
    boolean     checkForUpdates;  ///< should we periodically ask for a new version?
    long     updatePeriod;     ///< update checking period in hours
    DistanceOrNull databaseAge;      ///< how old is virus database
    DistanceOrNull lastUpdateCheck;  ///< how long is since last database update check
    String      databaseVersion;  ///< virus database version
    String      engineVersion;    ///< scanning engine version
    boolean     isPluginAvailable;   ///< says if plugins dll is on hardrive
    
    public IntegratedEngine() {
      
    }

    public boolean isCheckForUpdates() {
      return checkForUpdates;
    }

    public void setCheckForUpdates(boolean checkForUpdates) {
      this.checkForUpdates = checkForUpdates;
    }

    public long getUpdatePeriod() {
      return updatePeriod;
    }

    public void setUpdatePeriod(long updatePeriod) {
      this.updatePeriod = updatePeriod;
    }

    public DistanceOrNull getDatabaseAge() {
      return databaseAge;
    }

    public void setDatabaseAge(DistanceOrNull databaseAge) {
      this.databaseAge = databaseAge;
    }

    public DistanceOrNull getLastUpdateCheck() {
      return lastUpdateCheck;
    }

    public void setLastUpdateCheck(DistanceOrNull lastUpdateCheck) {
      this.lastUpdateCheck = lastUpdateCheck;
    }

    public String getDatabaseVersion() {
      return databaseVersion;
    }

    public void setDatabaseVersion(String databaseVersion) {
      this.databaseVersion = databaseVersion;
    }

    public String getEngineVersion() {
      return engineVersion;
    }

    public void setEngineVersion(String engineVersion) {
      this.engineVersion = engineVersion;
    }

    public boolean isIsPluginAvailable() {
      return isPluginAvailable;
    }

    public void setIsPluginAvailable(boolean isPluginAvailable) {
      this.isPluginAvailable = isPluginAvailable;
    }
  }

  public enum AntivirusStatus {
    AntivirusOk,      ///< no message is needed
    NoAntivirus,      ///< neither internal nor external antivirus is active
    InternalFailure,  ///< problem with internal intivirus
    ExternalFailure,  ///< problem with external intivirus
    DoubleFailer      ///< both internal and external antivirus has failed
  }

  public enum ReactionOnNotScanned {
    DeliverWithWarning,  ///< deliver original message with prepended warning
    SameAsVirus       ///< the same reaction as for ReactionOnVirus
  }

  public enum ReactionOnVirus {
    DiscardMessage,      ///< completely dicard the message
    RemoveVirus       ///< deliver the message but remove malicious code
  }
}
