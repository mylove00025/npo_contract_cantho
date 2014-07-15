/**
 * AbstractWsInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.osp.npo.core;

public abstract class AbstractWsInfo  implements java.io.Serializable {
    private java.util.Calendar entryDateTime;

    private java.lang.Long entryUserId;

    private java.lang.String entryUserName;

    private java.util.Calendar updateDateTime;

    private java.lang.Long updateUserId;

    private java.lang.String updateUserName;

    public AbstractWsInfo() {
    }

    public AbstractWsInfo(
           java.util.Calendar entryDateTime,
           java.lang.Long entryUserId,
           java.lang.String entryUserName,
           java.util.Calendar updateDateTime,
           java.lang.Long updateUserId,
           java.lang.String updateUserName) {
           this.entryDateTime = entryDateTime;
           this.entryUserId = entryUserId;
           this.entryUserName = entryUserName;
           this.updateDateTime = updateDateTime;
           this.updateUserId = updateUserId;
           this.updateUserName = updateUserName;
    }


    /**
     * Gets the entryDateTime value for this AbstractWsInfo.
     * 
     * @return entryDateTime
     */
    public java.util.Calendar getEntryDateTime() {
        return entryDateTime;
    }


    /**
     * Sets the entryDateTime value for this AbstractWsInfo.
     * 
     * @param entryDateTime
     */
    public void setEntryDateTime(java.util.Calendar entryDateTime) {
        this.entryDateTime = entryDateTime;
    }


    /**
     * Gets the entryUserId value for this AbstractWsInfo.
     * 
     * @return entryUserId
     */
    public java.lang.Long getEntryUserId() {
        return entryUserId;
    }


    /**
     * Sets the entryUserId value for this AbstractWsInfo.
     * 
     * @param entryUserId
     */
    public void setEntryUserId(java.lang.Long entryUserId) {
        this.entryUserId = entryUserId;
    }


    /**
     * Gets the entryUserName value for this AbstractWsInfo.
     * 
     * @return entryUserName
     */
    public java.lang.String getEntryUserName() {
        return entryUserName;
    }


    /**
     * Sets the entryUserName value for this AbstractWsInfo.
     * 
     * @param entryUserName
     */
    public void setEntryUserName(java.lang.String entryUserName) {
        this.entryUserName = entryUserName;
    }


    /**
     * Gets the updateDateTime value for this AbstractWsInfo.
     * 
     * @return updateDateTime
     */
    public java.util.Calendar getUpdateDateTime() {
        return updateDateTime;
    }


    /**
     * Sets the updateDateTime value for this AbstractWsInfo.
     * 
     * @param updateDateTime
     */
    public void setUpdateDateTime(java.util.Calendar updateDateTime) {
        this.updateDateTime = updateDateTime;
    }


    /**
     * Gets the updateUserId value for this AbstractWsInfo.
     * 
     * @return updateUserId
     */
    public java.lang.Long getUpdateUserId() {
        return updateUserId;
    }


    /**
     * Sets the updateUserId value for this AbstractWsInfo.
     * 
     * @param updateUserId
     */
    public void setUpdateUserId(java.lang.Long updateUserId) {
        this.updateUserId = updateUserId;
    }


    /**
     * Gets the updateUserName value for this AbstractWsInfo.
     * 
     * @return updateUserName
     */
    public java.lang.String getUpdateUserName() {
        return updateUserName;
    }


    /**
     * Sets the updateUserName value for this AbstractWsInfo.
     * 
     * @param updateUserName
     */
    public void setUpdateUserName(java.lang.String updateUserName) {
        this.updateUserName = updateUserName;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AbstractWsInfo)) return false;
        AbstractWsInfo other = (AbstractWsInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.entryDateTime==null && other.getEntryDateTime()==null) || 
             (this.entryDateTime!=null &&
              this.entryDateTime.equals(other.getEntryDateTime()))) &&
            ((this.entryUserId==null && other.getEntryUserId()==null) || 
             (this.entryUserId!=null &&
              this.entryUserId.equals(other.getEntryUserId()))) &&
            ((this.entryUserName==null && other.getEntryUserName()==null) || 
             (this.entryUserName!=null &&
              this.entryUserName.equals(other.getEntryUserName()))) &&
            ((this.updateDateTime==null && other.getUpdateDateTime()==null) || 
             (this.updateDateTime!=null &&
              this.updateDateTime.equals(other.getUpdateDateTime()))) &&
            ((this.updateUserId==null && other.getUpdateUserId()==null) || 
             (this.updateUserId!=null &&
              this.updateUserId.equals(other.getUpdateUserId()))) &&
            ((this.updateUserName==null && other.getUpdateUserName()==null) || 
             (this.updateUserName!=null &&
              this.updateUserName.equals(other.getUpdateUserName())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getEntryDateTime() != null) {
            _hashCode += getEntryDateTime().hashCode();
        }
        if (getEntryUserId() != null) {
            _hashCode += getEntryUserId().hashCode();
        }
        if (getEntryUserName() != null) {
            _hashCode += getEntryUserName().hashCode();
        }
        if (getUpdateDateTime() != null) {
            _hashCode += getUpdateDateTime().hashCode();
        }
        if (getUpdateUserId() != null) {
            _hashCode += getUpdateUserId().hashCode();
        }
        if (getUpdateUserName() != null) {
            _hashCode += getUpdateUserName().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AbstractWsInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://npo.osp.com/", "abstractWsInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("entryDateTime");
        elemField.setXmlName(new javax.xml.namespace.QName("", "entryDateTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("entryUserId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "entryUserId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("entryUserName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "entryUserName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("updateDateTime");
        elemField.setXmlName(new javax.xml.namespace.QName("", "updateDateTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("updateUserId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "updateUserId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("updateUserName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "updateUserName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
