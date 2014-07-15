/**
 * NpoWS.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.osp.npo.ws;

public interface NpoWS extends java.rmi.Remote {
    public com.osp.npo.ws.WebserviceInfo synchronizeDB(com.osp.npo.ws.WebserviceInfo arg0) throws java.rmi.RemoteException;
    public java.lang.String synchronize(com.osp.npo.ws.WebserviceInfo arg0) throws java.rmi.RemoteException;
    public java.lang.Boolean synchronizeFirstTime(com.osp.npo.ws.WebserviceInfo arg0) throws java.rmi.RemoteException;
    public java.lang.Boolean checkData(com.osp.npo.ws.WebserviceInfo arg0) throws java.rmi.RemoteException;
}
