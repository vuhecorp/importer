/**
 * WS_DataInterchangeServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.tdcare.www;

public class WS_DataInterchangeServiceLocator extends org.apache.axis.client.Service implements com.tdcare.www.WS_DataInterchangeService {

    public WS_DataInterchangeServiceLocator() {
    }


    public WS_DataInterchangeServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public WS_DataInterchangeServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for WS_DataInterchangeServiceSoap
    private java.lang.String WS_DataInterchangeServiceSoap_address = "https://telehealth.foracare.com/WebService/WS_DataInterchangeService.asmx";

    public java.lang.String getWS_DataInterchangeServiceSoapAddress() {
        return WS_DataInterchangeServiceSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String WS_DataInterchangeServiceSoapWSDDServiceName = "WS_DataInterchangeServiceSoap";

    public java.lang.String getWS_DataInterchangeServiceSoapWSDDServiceName() {
        return WS_DataInterchangeServiceSoapWSDDServiceName;
    }

    public void setWS_DataInterchangeServiceSoapWSDDServiceName(java.lang.String name) {
        WS_DataInterchangeServiceSoapWSDDServiceName = name;
    }

    public com.tdcare.www.WS_DataInterchangeServiceSoap getWS_DataInterchangeServiceSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(WS_DataInterchangeServiceSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getWS_DataInterchangeServiceSoap(endpoint);
    }

    public com.tdcare.www.WS_DataInterchangeServiceSoap getWS_DataInterchangeServiceSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.tdcare.www.WS_DataInterchangeServiceSoapStub _stub = new com.tdcare.www.WS_DataInterchangeServiceSoapStub(portAddress, this);
            _stub.setPortName(getWS_DataInterchangeServiceSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setWS_DataInterchangeServiceSoapEndpointAddress(java.lang.String address) {
        WS_DataInterchangeServiceSoap_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.tdcare.www.WS_DataInterchangeServiceSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                com.tdcare.www.WS_DataInterchangeServiceSoapStub _stub = new com.tdcare.www.WS_DataInterchangeServiceSoapStub(new java.net.URL(WS_DataInterchangeServiceSoap_address), this);
                _stub.setPortName(getWS_DataInterchangeServiceSoapWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("WS_DataInterchangeServiceSoap".equals(inputPortName)) {
            return getWS_DataInterchangeServiceSoap();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://www.tdcare.com/", "WS_DataInterchangeService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://www.tdcare.com/", "WS_DataInterchangeServiceSoap"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("WS_DataInterchangeServiceSoap".equals(portName)) {
            setWS_DataInterchangeServiceSoapEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
