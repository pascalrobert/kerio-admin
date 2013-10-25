package kerio.connect.admin.common.enums;

public enum RestrictionKind {

  Regex,                  ///< regular expression
  ByteLength,             ///< maximal length in Bytes
  ForbiddenNameList,         ///< list of denied exact names due to filesystem or KMS store
  ForbiddenPrefixList,    ///< list of denied preffixes due to filesystem or KMS store
  ForbiddenSuffixList,    ///< list of denied suffixes due to filesystem or KMS store
  ForbiddenCharacterList     ///< list of denied characters

}
