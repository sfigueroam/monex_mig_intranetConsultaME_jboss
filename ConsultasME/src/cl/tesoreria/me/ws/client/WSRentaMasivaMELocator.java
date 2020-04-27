/**
 * WSRentaMasivaMELocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cl.tesoreria.me.ws.client;

import org.apache.log4j.Logger;

public class WSRentaMasivaMELocator extends org.apache.axis.client.Service implements cl.tesoreria.me.ws.client.WSRentaMasivaME {

	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger("cl.tesoreria.finpub.intranetConsultasME.WSRentaMasivaMELocator");
	
	public WSRentaMasivaMELocator() {
    }


    public WSRentaMasivaMELocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public WSRentaMasivaMELocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for WSRentaMasivaMESoap
    private java.lang.String WSRentaMasivaMESoap_address = "http://http://tgr2452:8001/RentaMasivaWS";

    public java.lang.String getWSRentaMasivaMESoapAddress() {
        return WSRentaMasivaMESoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String WSRentaMasivaMESoapWSDDServiceName = "WSRentaMasivaMESoap";

    public java.lang.String getWSRentaMasivaMESoapWSDDServiceName() {
        return WSRentaMasivaMESoapWSDDServiceName;
    }

    public void setWSRentaMasivaMESoapWSDDServiceName(java.lang.String name) {
        WSRentaMasivaMESoapWSDDServiceName = name;
    }

    public cl.tesoreria.me.ws.client.WSRentaMasivaMESoap getWSRentaMasivaMESoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(WSRentaMasivaMESoap_address);
        }
        catch (java.net.MalformedURLException e) {
        	e.printStackTrace();
        	logger.error("Error en el metodo WSRentaMasivaMELocator.getWSRentaMasivaMESoap(): " + e);
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getWSRentaMasivaMESoap(endpoint);
    }

    public cl.tesoreria.me.ws.client.WSRentaMasivaMESoap getWSRentaMasivaMESoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {        	
            cl.tesoreria.me.ws.client.WSRentaMasivaMESoapStub _stub = new cl.tesoreria.me.ws.client.WSRentaMasivaMESoapStub(portAddress, this);            
            _stub.setPortName(getWSRentaMasivaMESoapWSDDServiceName());            
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
        	e.printStackTrace();
        	logger.error("Error en el metodo WSRentaMasivaMELocator.getWSRentaMasivaMESoap(): " + e);
            return null;
        }
    }

    public void setWSRentaMasivaMESoapEndpointAddress(java.lang.String address) {
        WSRentaMasivaMESoap_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (cl.tesoreria.me.ws.client.WSRentaMasivaMESoap.class.isAssignableFrom(serviceEndpointInterface)) {
                cl.tesoreria.me.ws.client.WSRentaMasivaMESoapStub _stub = new cl.tesoreria.me.ws.client.WSRentaMasivaMESoapStub(new java.net.URL(WSRentaMasivaMESoap_address), this);
                _stub.setPortName(getWSRentaMasivaMESoapWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
        	t.printStackTrace();
        	logger.error("Error en el metodo WSRentaMasivaMELocator.getPort(): " + t);
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
        if ("WSRentaMasivaMESoap".equals(inputPortName)) {
            return getWSRentaMasivaMESoap();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://www.openuri.org/", "WSRentaMasivaME");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://www.openuri.org/", "WSRentaMasivaMESoap"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("WSRentaMasivaMESoap".equals(portName)) {
            setWSRentaMasivaMESoapEndpointAddress(address);
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
