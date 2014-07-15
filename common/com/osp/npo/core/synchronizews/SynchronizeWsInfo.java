/**
 * SynchronizeWsInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.osp.npo.core.synchronizews;

public class SynchronizeWsInfo  extends com.osp.npo.core.AbstractWsInfo  implements java.io.Serializable {
    private java.lang.Byte action;

    private java.lang.String authenticationId;

    private java.lang.String dataId;

    private java.lang.Long historyId;

    private java.lang.Byte status;

    private java.lang.Byte type;

    public SynchronizeWsInfo() {
    }

    public SynchronizeWsInfo(
           java.util.Calendar entryDateTime,
           java.lang.Long entryUserId,
           java.lang.String entryUserName,
           java.util.Calendar updateDateTime,
           java.lang.Long updateUserId,
           java.lang.String updateUserName,
           java.lang.Byte action,
           java.lang.String authenticationId,
           java.lang.String dataId,
           java.lang.Long historyId,
           java.lang.Byte status,
           java.lang.Byte type) {
        super(
            entryDateTime,
            entryUserId,
            entryUserName,
            updateDateTime,
            updateUserId,
            updateUserName);
        this.action = action;
        this.authenticationId = authenticationId;
        this.dataId = dataId;
        this.historyId = historyId;
        this.status = status;
        this.type = type;
    }


    /**
     * Gets the action value for this SynchronizeWsInfo.
     * 
     * @return action
     */
    public java.lang.Byte getAction() {
        return action;
    }


    /**
     * Sets the action value for this SynchronizeWsInfo.
     * 
     * @param action
     */
    public void setAction(java.lang.Byte action) {
        this.action = action;
    }


    /**
     * Gets the authenticationId value for this SynchronizeWsInfo.
     * 
     * @return authenticationId
     */
    public java.lang.String getAuthenticationId() {
        return authenticationId;
    }


    /**
     * Sets the authenticationId value for this SynchronizeWsInfo.
     * 
     * @param authenticationId
     */
    public void setAuthenticationId(java.lang.String authenticationId) {
        this.authenticationId = authenticationId;
    }


    /**
     * Gets the dataId value for this SynchronizeWsInfo.
     * 
     * @return dataId
     */
    public java.lang.String getDataId() {
        return dataId;
    }


    /**
     * Sets the dataId value for this SynchronizeWsInfo.
     * 
     * @param dataId
     */
    public void setDataId(java.lang.String dataId) {
        this.dataId = dataId;
    }


    /**
     * Gets the historyId value for this SynchronizeWsInfo.
     * 
     * @return historyId
     */
    public java.lang.Long getHistoryId() {
        return historyId;
    }


    /**
     * Sets the historyId value for this SynchronizeWsInfo.
     * 
     * @param historyId
     */
    public void setHistoryId(java.lang.Long historyId) {
        this.historyId = historyId;
    }


    /**
     * Gets the status value for this SynchronizeWsInfo.
     * 
     * @return status
     */
    public java.lang.Byte getStatus() {
        return status;
    }


    /**
     * Sets the status value for this SynchronizeWsInfo.
     * 
     * @param status
     */
    public void setStatus(java.lang.Byte status) {
        this.status = status;
    }


    /**
     * Gets the type value for this SynchronizeWsInfo.
     * 
     * @return type
     */
    public java.lang.Byte getType() {
        return type;
    }


    /**
     * Sets the type value for this SynchronizeWsInfo.
     * 
     * @param type
     */
    public void setType(java.lang.Byte type) {
        this.type = type;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SynchronizeWsInfo)) return false;
        SynchronizeWsInfo other = (SynchronizeWsInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.action==null && other.getAction()==null) || 
             (this.action!=null &&
              this.action.equals(other.getAction()))) &&
            ((this.authenticationId==null && other.getAuthenticationId()==null) || 
             (this.authenticationId!=null &&
              this.authenticationId.equals(other.getAuthenticationId()))) &&
            ((this.dataId==null && other.getDataId()==null) || 
             (this.dataId!=null &&
              this.dataId.equals(other.getDataId()))) &&
            ((this.historyId==null && other.getHistoryId()==null) || 
             (this.historyId!=null &&
              this.historyId.equals(other.getHistoryId()))) &&
            ((this.status==null && other.getStatus()==null) || 
             (this.status!=null &&
              this.status.equals(other.getStatus()))) &&
            ((this.type==null && other.getType()==null) || 
             (this.type!=null &&
              this.type.equals(other.getType())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        if (getAction() != null) {
            _hashCode += getAction().hashCode();
        }
        if (getAuthenticationId() != null) {
            _hashCode += getAuthenticationId().hashCode();
        }
        if (getDataId() != null) {
            _hashCode += getDataId().hashCode();
        }
        if (getHistoryId() != null) {
            _hashCode += getHistoryId().hashCode();
        }
        if (getStatus() != null) {
            _hashCode += getStatus().hashCode();
        }
        if (getType() != null) {
            _hashCode += getType().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SynchronizeWsInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ws.npo.osp.com/", "synchronizeWsInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("action");
        elemField.setXmlName(new javax.xml.namespace.QName("", "action"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "byte"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("authenticationId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "authenticationId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dataId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("historyId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "historyId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("status");
        elemField.setXmlName(new javax.xml.namespace.QName("", "status"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "byte"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("type");
        elemField.setXmlName(new javax.xml.namespace.QName("", "type"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "byte"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
