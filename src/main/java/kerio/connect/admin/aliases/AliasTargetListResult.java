package kerio.connect.admin.aliases;

import java.util.ArrayList;

import kerio.connect.admin.aliases.Aliases.Alias;
import kerio.connect.admin.common.Error;

public class AliasTargetListResult {

  private ArrayList<Alias> createResultList;
  private ArrayList<Error> errorList;
  
  public AliasTargetListResult() {
    
  }

  public ArrayList<Alias> getCreateResultList() {
    return createResultList;
  }

  public void setCreateResultList(ArrayList<Alias> createResultList) {
    this.createResultList = createResultList;
  }

  public ArrayList<Error> getErrorList() {
    return errorList;
  }

  public void setErrorList(ArrayList<Error> errorList) {
    this.errorList = errorList;
  }
  
}
