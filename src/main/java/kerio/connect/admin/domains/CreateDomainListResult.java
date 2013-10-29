package kerio.connect.admin.domains;

import java.util.ArrayList;

import kerio.connect.admin.common.CreateResult;
import kerio.connect.admin.common.Error;

public class CreateDomainListResult {

  private ArrayList<CreateResult> createResultList;
  private ArrayList<Error> errorList;
  
  public CreateDomainListResult() {
    
  }

  public ArrayList<CreateResult> getCreateResultList() {
    return createResultList;
  }

  public void setCreateResultList(ArrayList<CreateResult> createResultList) {
    this.createResultList = createResultList;
  }

  public ArrayList<Error> getErrorList() {
    return errorList;
  }

  public void setErrorList(ArrayList<Error> errorList) {
    this.errorList = errorList;
  }
  
}
