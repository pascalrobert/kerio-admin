package kerio.connect.admin;

import java.net.HttpURLConnection;

import com.thetransactioncompany.jsonrpc2.client.ConnectionConfigurator;

public class MyConfigurator implements ConnectionConfigurator {

  protected String _token;
  
  public void configure(HttpURLConnection connection) {
  
    // add custom HTTP header
    connection.addRequestProperty("X-Token", _token);
  }
  
  public void setToken(String token) {
    this._token = token;
  }
  
  public String getToken() {
    return _token;
  }
}