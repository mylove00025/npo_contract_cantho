/**
 * DiagnosticWsInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.osp.npo.ws;

public class DiagnosticWsInfo  implements java.io.Serializable {
    private java.lang.String commandCode;

    private java.lang.Long numberResult;

    private java.lang.String stringResult;

    public DiagnosticWsInfo() {
    }

    public DiagnosticWsInfo(
           java.lang.String commandCode,
           java.lang.Long numberResult,
           java.lang.String stringResult) {
           this.commandCode = commandCode;
           this.numberResult = numberResult;
           this.stringResult = stringResult;
    }


    /**
     * Gets the commandCode value for this DiagnosticWsInfo.
     * 
     * @return commandCode
     */
    public java.lang.String getCommandCode() {
        return commandCode;
    }


    /**
     * Sets the commandCode value for this DiagnosticWsInfo.
     * 
     * @param commandCode
     */
    public void setCommandCode(java.lang.String commandCode) {
        this.commandCode = commandCode;
    }


    /**
     * Gets the numberResult value for this DiagnosticWsInfo.
     * 
     * @return numberResult
     */
    public java.lang.Long getNumberResult() {
        return numberResult;
    }


    /**
     * Sets the numberResult value for this DiagnosticWsInfo.
     * 
     * @param numberResult
     */
    public void setNumberResult(java.lang.Long numberResult) {
        this.numberResult = numberResult;
    }


    /**
     * Gets the stringResult value for this DiagnosticWsInfo.
     * 
     * @return stringResult
     */
    public java.lang.String getStringResult() {
        return stringResult;
    }


    /**
     * Sets the stringResult value for this DiagnosticWsInfo.
     * 
     * @param stringResult
     */
    public void setStringResult(java.lang.String stringResult) {
        this.stringResult = stringResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DiagnosticWsInfo)) return false;
        DiagnosticWsInfo other = (DiagnosticWsInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.commandCode==null && other.getCommandCode()==null) || 
             (this.commandCode!=null &&
              this.commandCode.equals(other.getCommandCode()))) &&
            ((this.numberResult==null && other.getNumberResult()==null) || 
             (this.numberResult!=null &&
              this.numberResult.equals(other.getNumberResult()))) &&
            ((this.stringResult==null && other.getStringResult()==null) || 
             (this.stringResult!=null &&
              this.stringResult.equals(other.getStringResult())));
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
        if (getCommandCode() != null) {
            _hashCode += getCommandCode().hashCode();
        }
        if (getNumberResult() != null) {
            _hashCode += getNumberResult().hashCode();
        }
        if (getStringResult() != null) {
            _hashCode += getStringResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DiagnosticWsInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ws.npo.osp.com/", "diagnosticWsInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("commandCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "commandCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numberResult");
        elemField.setXmlName(new javax.xml.namespace.QName("", "numberResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stringResult");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stringResult"));
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
