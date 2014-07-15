/**
 * NpoWSService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.osp.npo.ws;

public interface NpoWSService extends javax.xml.rpc.Service {
    public java.lang.String getNpoWSPortAddress();

    public com.osp.npo.ws.NpoWS getNpoWSPort() throws javax.xml.rpc.ServiceException;

    public com.osp.npo.ws.NpoWS getNpoWSPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
