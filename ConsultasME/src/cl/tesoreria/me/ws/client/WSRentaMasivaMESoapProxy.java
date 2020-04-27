package cl.tesoreria.me.ws.client;

public class WSRentaMasivaMESoapProxy implements cl.tesoreria.me.ws.client.WSRentaMasivaMESoap {
  private String _endpoint = null;
  private cl.tesoreria.me.ws.client.WSRentaMasivaMESoap wSRentaMasivaMESoap = null;
  
  public WSRentaMasivaMESoapProxy() {
    _initWSRentaMasivaMESoapProxy();
  }
  
  public WSRentaMasivaMESoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initWSRentaMasivaMESoapProxy();
  }
  
  private void _initWSRentaMasivaMESoapProxy() {
    try {
      wSRentaMasivaMESoap = (new cl.tesoreria.me.ws.client.WSRentaMasivaMELocator()).getWSRentaMasivaMESoap();
      if (wSRentaMasivaMESoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)wSRentaMasivaMESoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)wSRentaMasivaMESoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (wSRentaMasivaMESoap != null)
      ((javax.xml.rpc.Stub)wSRentaMasivaMESoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public cl.tesoreria.me.ws.client.WSRentaMasivaMESoap getWSRentaMasivaMESoap() {
    if (wSRentaMasivaMESoap == null)
      _initWSRentaMasivaMESoapProxy();
    return wSRentaMasivaMESoap;
  }
  
  public java.lang.String receiverXML(java.lang.String inputXML) throws java.rmi.RemoteException{
    if (wSRentaMasivaMESoap == null)
      _initWSRentaMasivaMESoapProxy();
    return wSRentaMasivaMESoap.receiverXML(inputXML);
  }
  
  
}