package kerio.connect.admin;

public class LoginResponse {

  private String _token;

  public LoginResponse() {    
  }
  
  public String getToken() {
    return _token;
  }

  public void setToken(String token) {
    _token = token;
  }

}

// {"jsonrpc":"2.0","id":8652548341168163840,"result":{"token":"061feb1710f670f18352cb0a5eed8b9e396f3bf3313a97bc4b8929233bb4a095"}}