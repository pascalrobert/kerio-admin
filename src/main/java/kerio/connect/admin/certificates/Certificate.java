package kerio.connect.admin.certificates;

import java.util.ArrayList;

import kerio.connect.admin.common.Date;
import kerio.connect.admin.common.NamedValue;
import kerio.connect.admin.common.Time;
import kerio.connect.admin.common.enums.StoreStatus;

public class Certificate {

  String            id;
  StoreStatus     status;
  String         name;
  ArrayList<NamedValue> issuer;
  ArrayList<NamedValue> subject;
  String         fingerprint;       ///< 128-bit MD5, i.e. 16 hexa values separated by colons
  String         fingerprintSha1;  ///< 160-bit SHA1, i.e. 20 hexa values separated by colons
  ValidPeriod    validPeriod;
  boolean        valid;            ///< exists and valid content
  CertificateType type;

  public Certificate() {

  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public StoreStatus getStatus() {
    return status;
  }

  public void setStatus(StoreStatus status) {
    this.status = status;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ArrayList<NamedValue> getIssuer() {
    return issuer;
  }

  public void setIssuer(ArrayList<NamedValue> issuer) {
    this.issuer = issuer;
  }

  public ArrayList<NamedValue> getSubject() {
    return subject;
  }

  public void setSubject(ArrayList<NamedValue> subject) {
    this.subject = subject;
  }

  public String getFingerprint() {
    return fingerprint;
  }

  public void setFingerprint(String fingerprint) {
    this.fingerprint = fingerprint;
  }

  public String getFingerprintSha1() {
    return fingerprintSha1;
  }

  public void setFingerprintSha1(String fingerprintSha1) {
    this.fingerprintSha1 = fingerprintSha1;
  }

  public ValidPeriod getValidPeriod() {
    return validPeriod;
  }

  public void setValidPeriod(ValidPeriod validPeriod) {
    this.validPeriod = validPeriod;
  }

  public boolean isValid() {
    return valid;
  }

  public void setValid(boolean valid) {
    this.valid = valid;
  }

  public CertificateType getType() {
    return type;
  }

  public void setType(CertificateType type) {
    this.type = type;
  }
  
  public enum ValidType {
    Valid,
    NotValidYet,
    ExpireSoon,
    Expired
  }

  public enum CertificateType {
    ActiveCertificate,
    InactiveCertificate,
    CertificateRequest,
    Authority,
    LocalAuthority
  }

  public static class ValidPeriod {
    Date validFromDate;
    Time validFromTime;
    Date validToDate;      
    Time validToTime;
    ValidType validType;

    public ValidPeriod() {

    }

    public Date getValidFromDate() {
      return validFromDate;
    }

    public void setValidFromDate(Date validFromDate) {
      this.validFromDate = validFromDate;
    }

    public Time getValidFromTime() {
      return validFromTime;
    }

    public void setValidFromTime(Time validFromTime) {
      this.validFromTime = validFromTime;
    }

    public Date getValidToDate() {
      return validToDate;
    }

    public void setValidToDate(Date validToDate) {
      this.validToDate = validToDate;
    }

    public Time getValidToTime() {
      return validToTime;
    }

    public void setValidToTime(Time validToTime) {
      this.validToTime = validToTime;
    }

    public ValidType getValidType() {
      return validType;
    }

    public void setValidType(ValidType validType) {
      this.validType = validType;
    }
  }

}
