package kerio.connect.admin.policies;

import java.util.ArrayList;

import kerio.connect.admin.common.OptionalEntity;

public class SecurityPolicyOptions {

  SecurityPolicyMode mode;
  OptionalEntity authenticationExceptionGroup; ///< Is used if mode == SPAuthenticationRequired
  OptionalEntity encryptionExceptionGroup;    ///< Is used if mode == SPEncryptionRequired
  ArrayList<String> authenticationMethods; ///< List of authenticatin methods and its status. In any set operation, all methods should be present in list. Methods which are not specified are reset to 'enabled'.
  boolean allowNtlmForKerberosUsers;     ///< Allow NTLM authentication for users with Kerberos authentication (for Active Directory users)
  boolean enableLockout;     ///< Enable/disable account lockout feature
  long failedLoginsToLock;   ///< Count of failed logins to lock user account
  long minutesToUnlock;      ///< Minutes to unlock locked account
  AntiHammeringOptions antiHammering; ///< Anti-Hammering settings

  public SecurityPolicyOptions() {
    
  }
  
  public SecurityPolicyMode getMode() {
    return mode;
  }

  public void setMode(SecurityPolicyMode mode) {
    this.mode = mode;
  }

  public OptionalEntity getAuthenticationExceptionGroup() {
    return authenticationExceptionGroup;
  }

  public void setAuthenticationExceptionGroup(OptionalEntity authenticationExceptionGroup) {
    this.authenticationExceptionGroup = authenticationExceptionGroup;
  }

  public OptionalEntity getEncryptionExceptionGroup() {
    return encryptionExceptionGroup;
  }

  public void setEncryptionExceptionGroup(OptionalEntity encryptionExceptionGroup) {
    this.encryptionExceptionGroup = encryptionExceptionGroup;
  }

  public ArrayList<String> getAuthenticationMethods() {
    return authenticationMethods;
  }

  public void setAuthenticationMethods(ArrayList<String> authenticationMethods) {
    this.authenticationMethods = authenticationMethods;
  }

  public boolean isAllowNtlmForKerberosUsers() {
    return allowNtlmForKerberosUsers;
  }

  public void setAllowNtlmForKerberosUsers(boolean allowNtlmForKerberosUsers) {
    this.allowNtlmForKerberosUsers = allowNtlmForKerberosUsers;
  }

  public boolean isEnableLockout() {
    return enableLockout;
  }

  public void setEnableLockout(boolean enableLockout) {
    this.enableLockout = enableLockout;
  }

  public long getFailedLoginsToLock() {
    return failedLoginsToLock;
  }

  public void setFailedLoginsToLock(long failedLoginsToLock) {
    this.failedLoginsToLock = failedLoginsToLock;
  }

  public long getMinutesToUnlock() {
    return minutesToUnlock;
  }

  public void setMinutesToUnlock(long minutesToUnlock) {
    this.minutesToUnlock = minutesToUnlock;
  }

  public AntiHammeringOptions getAntiHammering() {
    return antiHammering;
  }

  public void setAntiHammering(AntiHammeringOptions antiHammering) {
    this.antiHammering = antiHammering;
  }

  enum SecurityPolicyMode {
    SPNoRestrictions,       ///< No restriction
    SPAuthenticationRequired,  ///< Require secure authentication
    SPEncryptionRequired    ///< Require encrypted connection
  }
    
  public static class AntiHammeringOptions {
    boolean isEnabled;         ///< Enable/disable Anti-Hammering
    long failedLoginsToBlock;  ///< Count of failed logins within minute to start blocking
    long minutesToBlock;    ///< Minutes to keep blocking IP
    OptionalEntity exceptionIpGroup;       ///< switchable custom white list IP group
    
    public AntiHammeringOptions() {
      
    }

    public boolean isIsEnabled() {
      return isEnabled;
    }

    public void setIsEnabled(boolean isEnabled) {
      this.isEnabled = isEnabled;
    }

    public long getFailedLoginsToBlock() {
      return failedLoginsToBlock;
    }

    public void setFailedLoginsToBlock(long failedLoginsToBlock) {
      this.failedLoginsToBlock = failedLoginsToBlock;
    }

    public long getMinutesToBlock() {
      return minutesToBlock;
    }

    public void setMinutesToBlock(long minutesToBlock) {
      this.minutesToBlock = minutesToBlock;
    }

    public OptionalEntity getExceptionIpGroup() {
      return exceptionIpGroup;
    }

    public void setExceptionIpGroup(OptionalEntity exceptionIpGroup) {
      this.exceptionIpGroup = exceptionIpGroup;
    }
  }
  

}
