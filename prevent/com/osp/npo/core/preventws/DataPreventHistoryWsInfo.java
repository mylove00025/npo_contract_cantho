/**
 * DataPreventHistoryWsInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.osp.npo.core.preventws;

import com.osp.npo.core.AbstractWsInfo;

public class DataPreventHistoryWsInfo  extends AbstractWsInfo  implements java.io.Serializable {
    private java.lang.String clientInfo;

    private java.lang.String executeContent;

    private java.util.Calendar executeDateTime;

    private java.lang.String executePerson;

    private java.lang.Long hid;

    private java.lang.Long preventId;

    public DataPreventHistoryWsInfo() {
    }

    public DataPreventHistoryWsInfo(
           java.util.Calendar entryDateTime,
           java.lang.Long entryUserId,
           java.lang.String entryUserName,
           java.util.Calendar updateDateTime,
           java.lang.Long updateUserId,
           java.lang.String updateUserName,
           java.lang.String clientInfo,
           java.lang.String executeContent,
           java.util.Calendar executeDateTime,
           java.lang.String executePerson,
           java.lang.Long hid,
           java.lang.Long preventId) {
        super(
            entryDateTime,
            entryUserId,
            entryUserName,
            updateDateTime,
            updateUserId,
            updateUserName);
        this.clientInfo = clientInfo;
        this.executeContent = executeContent;
        this.executeDateTime = executeDateTime;
        this.executePerson = executePerson;
        this.hid = hid;
        this.preventId = preventId;
    }


    /**
     * Gets the clientInfo value for this DataPreventHistoryWsInfo.
     * 
     * @return clientInfo
     */
    public java.lang.String getClientInfo() {
        return clientInfo;
    }


    /**
     * Sets the clientInfo value for this DataPreventHistoryWsInfo.
     * 
     * @param clientInfo
     */
    public void setClientInfo(java.lang.String clientInfo) {
        this.clientInfo = clientInfo;
    }


    /**
     * Gets the executeContent value for this DataPreventHistoryWsInfo.
     * 
     * @return executeContent
     */
    public java.lang.String getExecuteContent() {
        return executeContent;
    }


    /**
     * Sets the executeContent value for this DataPreventHistoryWsInfo.
     * 
     * @param executeContent
     */
    public void setExecuteContent(java.lang.String executeContent) {
        this.executeContent = executeContent;
    }


    /**
     * Gets the executeDateTime value for this DataPreventHistoryWsInfo.
     * 
     * @return executeDateTime
     */
    public java.util.Calendar getExecuteDateTime() {
        return executeDateTime;
    }


    /**
     * Sets the executeDateTime value for this DataPreventHistoryWsInfo.
     * 
     * @param executeDateTime
     */
    public void setExecuteDateTime(java.util.Calendar executeDateTime) {
        this.executeDateTime = executeDateTime;
    }


    /**
     * Gets the executePerson value for this DataPreventHistoryWsInfo.
     * 
     * @return executePerson
     */
    public java.lang.String getExecutePerson() {
        return executePerson;
    }


    /**
     * Sets the executePerson value for this DataPreventHistoryWsInfo.
     * 
     * @param executePerson
     */
    public void setExecutePerson(java.lang.String executePerson) {
        this.executePerson = executePerson;
    }


    /**
     * Gets the hid value for this DataPreventHistoryWsInfo.
     * 
     * @return hid
     */
    public java.lang.Long getHid() {
        return hid;
    }


    /**
     * Sets the hid value for this DataPreventHistoryWsInfo.
     * 
     * @param hid
     */
    public void setHid(java.lang.Long hid) {
        this.hid = hid;
    }


    /**
     * Gets the preventId value for this DataPreventHistoryWsInfo.
     * 
     * @return preventId
     */
    public java.lang.Long getPreventId() {
        return preventId;
    }


    /**
     * Sets the preventId value for this DataPreventHistoryWsInfo.
     * 
     * @param preventId
     */
    public void setPreventId(java.lang.Long preventId) {
        this.preventId = preventId;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DataPreventHistoryWsInfo)) return false;
        DataPreventHistoryWsInfo other = (DataPreventHistoryWsInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.clientInfo==null && other.getClientInfo()==null) || 
             (this.clientInfo!=null &&
              this.clientInfo.equals(other.getClientInfo()))) &&
            ((this.executeContent==null && other.getExecuteContent()==null) || 
             (this.executeContent!=null &&
              this.executeContent.equals(other.getExecuteContent()))) &&
            ((this.executeDateTime==null && other.getExecuteDateTime()==null) || 
             (this.executeDateTime!=null &&
              this.executeDateTime.equals(other.getExecuteDateTime()))) &&
            ((this.executePerson==null && other.getExecutePerson()==null) || 
             (this.executePerson!=null &&
              this.executePerson.equals(other.getExecutePerson()))) &&
            ((this.hid==null && other.getHid()==null) || 
             (this.hid!=null &&
              this.hid.equals(other.getHid()))) &&
            ((this.preventId==null && other.getPreventId()==null) || 
             (this.preventId!=null &&
              this.preventId.equals(other.getPreventId())));
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
        if (getClientInfo() != null) {
            _hashCode += getClientInfo().hashCode();
        }
        if (getExecuteContent() != null) {
            _hashCode += getExecuteContent().hashCode();
        }
        if (getExecuteDateTime() != null) {
            _hashCode += getExecuteDateTime().hashCode();
        }
        if (getExecutePerson() != null) {
            _hashCode += getExecutePerson().hashCode();
        }
        if (getHid() != null) {
            _hashCode += getHid().hashCode();
        }
        if (getPreventId() != null) {
            _hashCode += getPreventId().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DataPreventHistoryWsInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ws.npo.osp.com/", "dataPreventHistoryWsInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("clientInfo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "clientInfo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("executeContent");
        elemField.setXmlName(new javax.xml.namespace.QName("", "executeContent"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("executeDateTime");
        elemField.setXmlName(new javax.xml.namespace.QName("", "executeDateTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("executePerson");
        elemField.setXmlName(new javax.xml.namespace.QName("", "executePerson"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("hid");
        elemField.setXmlName(new javax.xml.namespace.QName("", "hid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("preventId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "preventId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
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
