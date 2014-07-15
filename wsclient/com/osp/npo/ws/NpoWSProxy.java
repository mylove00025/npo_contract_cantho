package com.osp.npo.ws;

public class NpoWSProxy implements com.osp.npo.ws.NpoWS {
  private String _endpoint = null;
  private com.osp.npo.ws.NpoWS npoWS = null;
  
  public NpoWSProxy() {
    _initNpoWSProxy();
  }
  
  public NpoWSProxy(String endpoint) {
    _endpoint = endpoint;
    _initNpoWSProxy();
  }
  
  private void _initNpoWSProxy() {
    try {
      npoWS = (new com.osp.npo.ws.NpoWSServiceLocator()).getNpoWSPort();
      if (npoWS != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)npoWS)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)npoWS)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (npoWS != null)
      ((javax.xml.rpc.Stub)npoWS)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.osp.npo.ws.NpoWS getNpoWS() {
    if (npoWS == null)
      _initNpoWSProxy();
    return npoWS;
  }
  
  public com.osp.npo.ws.WebserviceInfo synchronizeDB(com.osp.npo.ws.WebserviceInfo arg0) throws java.rmi.RemoteException{
    if (npoWS == null)
      _initNpoWSProxy();
    return npoWS.synchronizeDB(arg0);
  }
  
  public java.lang.String synchronize(com.osp.npo.ws.WebserviceInfo arg0) throws java.rmi.RemoteException{
    if (npoWS == null)
      _initNpoWSProxy();
    return npoWS.synchronize(arg0);
  }
  
  public java.lang.Boolean synchronizeFirstTime(com.osp.npo.ws.WebserviceInfo arg0) throws java.rmi.RemoteException{
    if (npoWS == null)
      _initNpoWSProxy();
    return npoWS.synchronizeFirstTime(arg0);
  }
  
  public java.lang.Boolean checkData(com.osp.npo.ws.WebserviceInfo arg0) throws java.rmi.RemoteException{
    if (npoWS == null)
      _initNpoWSProxy();
    return npoWS.checkData(arg0);
  }
  
  
}