package com.tdcare.www;

public class WS_DataInterchangeServiceSoapProxy implements com.tdcare.www.WS_DataInterchangeServiceSoap {
  private String _endpoint = null;
  private com.tdcare.www.WS_DataInterchangeServiceSoap wS_DataInterchangeServiceSoap = null;
  
  public WS_DataInterchangeServiceSoapProxy() {
    _initWS_DataInterchangeServiceSoapProxy();
  }
  
  public WS_DataInterchangeServiceSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initWS_DataInterchangeServiceSoapProxy();
  }
  
  private void _initWS_DataInterchangeServiceSoapProxy() {
    try {
      wS_DataInterchangeServiceSoap = (new com.tdcare.www.WS_DataInterchangeServiceLocator()).getWS_DataInterchangeServiceSoap();
      if (wS_DataInterchangeServiceSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)wS_DataInterchangeServiceSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)wS_DataInterchangeServiceSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (wS_DataInterchangeServiceSoap != null)
      ((javax.xml.rpc.Stub)wS_DataInterchangeServiceSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.tdcare.www.WS_DataInterchangeServiceSoap getWS_DataInterchangeServiceSoap() {
    if (wS_DataInterchangeServiceSoap == null)
      _initWS_DataInterchangeServiceSoapProxy();
    return wS_DataInterchangeServiceSoap;
  }
  
  public java.lang.String dataInterchange(java.lang.String iCMDType, java.lang.String iData) throws java.rmi.RemoteException{
    if (wS_DataInterchangeServiceSoap == null)
      _initWS_DataInterchangeServiceSoapProxy();
    return wS_DataInterchangeServiceSoap.dataInterchange(iCMDType, iData);
  }
  
  
}