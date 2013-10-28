package kerio.connect.admin.certificates;

import java.util.ArrayList;

public class CreateCertificateResult {

  private ArrayList<Certificate> createResultList;
  private ArrayList<Error> errorList;
  
  public CreateCertificateResult() {
    
  }

  public ArrayList<Certificate> getCreateResultList() {
    return createResultList;
  }

  public void setCreateResultList(ArrayList<Certificate> createResultList) {
    this.createResultList = createResultList;
  }

  public ArrayList<Error> getErrorList() {
    return errorList;
  }

  public void setErrorList(ArrayList<Error> errorList) {
    this.errorList = errorList;
  }
  
}
