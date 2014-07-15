/**
 * WebserviceInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.osp.npo.ws;

public class WebserviceInfo  implements java.io.Serializable {
    private java.lang.String account;

    private java.lang.String authenticationCode;

    private java.lang.String authenticationId;

    private com.osp.npo.ws.ContentInfo[] contentInfoList;

    private java.lang.String[] dataIdList;

    private com.osp.npo.ws.DiagnosticWsInfo[] diagnosticInfoList;

    private java.lang.String password;

    private byte[] tpAddNewFile;

    private byte[] tpFirstSynFile;

    private byte[] tpUpdateFile;

    public WebserviceInfo() {
    }

    public WebserviceInfo(
           java.lang.String account,
           java.lang.String authenticationCode,
           java.lang.String authenticationId,
           com.osp.npo.ws.ContentInfo[] contentInfoList,
           java.lang.String[] dataIdList,
           com.osp.npo.ws.DiagnosticWsInfo[] diagnosticInfoList,
           java.lang.String password,
           byte[] tpAddNewFile,
           byte[] tpFirstSynFile,
           byte[] tpUpdateFile) {
           this.account = account;
           this.authenticationCode = authenticationCode;
           this.authenticationId = authenticationId;
           this.contentInfoList = contentInfoList;
           this.dataIdList = dataIdList;
           this.diagnosticInfoList = diagnosticInfoList;
           this.password = password;
           this.tpAddNewFile = tpAddNewFile;
           this.tpFirstSynFile = tpFirstSynFile;
           this.tpUpdateFile = tpUpdateFile;
    }


    /**
     * Gets the account value for this WebserviceInfo.
     * 
     * @return account
     */
    public java.lang.String getAccount() {
        return account;
    }


    /**
     * Sets the account value for this WebserviceInfo.
     * 
     * @param account
     */
    public void setAccount(java.lang.String account) {
        this.account = account;
    }


    /**
     * Gets the authenticationCode value for this WebserviceInfo.
     * 
     * @return authenticationCode
     */
    public java.lang.String getAuthenticationCode() {
        return authenticationCode;
    }


    /**
     * Sets the authenticationCode value for this WebserviceInfo.
     * 
     * @param authenticationCode
     */
    public void setAuthenticationCode(java.lang.String authenticationCode) {
        this.authenticationCode = authenticationCode;
    }


    /**
     * Gets the authenticationId value for this WebserviceInfo.
     * 
     * @return authenticationId
     */
    public java.lang.String getAuthenticationId() {
        return authenticationId;
    }


    /**
     * Sets the authenticationId value for this WebserviceInfo.
     * 
     * @param authenticationId
     */
    public void setAuthenticationId(java.lang.String authenticationId) {
        this.authenticationId = authenticationId;
    }


    /**
     * Gets the contentInfoList value for this WebserviceInfo.
     * 
     * @return contentInfoList
     */
    public com.osp.npo.ws.ContentInfo[] getContentInfoList() {
        return contentInfoList;
    }


    /**
     * Sets the contentInfoList value for this WebserviceInfo.
     * 
     * @param contentInfoList
     */
    public void setContentInfoList(com.osp.npo.ws.ContentInfo[] contentInfoList) {
        this.contentInfoList = contentInfoList;
    }

    public com.osp.npo.ws.ContentInfo getContentInfoList(int i) {
        return this.contentInfoList[i];
    }

    public void setContentInfoList(int i, com.osp.npo.ws.ContentInfo _value) {
        this.contentInfoList[i] = _value;
    }


    /**
     * Gets the dataIdList value for this WebserviceInfo.
     * 
     * @return dataIdList
     */
    public java.lang.String[] getDataIdList() {
        return dataIdList;
    }


    /**
     * Sets the dataIdList value for this WebserviceInfo.
     * 
     * @param dataIdList
     */
    public void setDataIdList(java.lang.String[] dataIdList) {
        this.dataIdList = dataIdList;
    }

    public java.lang.String getDataIdList(int i) {
        return this.dataIdList[i];
    }

    public void setDataIdList(int i, java.lang.String _value) {
        this.dataIdList[i] = _value;
    }


    /**
     * Gets the diagnosticInfoList value for this WebserviceInfo.
     * 
     * @return diagnosticInfoList
     */
    public com.osp.npo.ws.DiagnosticWsInfo[] getDiagnosticInfoList() {
        return diagnosticInfoList;
    }


    /**
     * Sets the diagnosticInfoList value for this WebserviceInfo.
     * 
     * @param diagnosticInfoList
     */
    public void setDiagnosticInfoList(com.osp.npo.ws.DiagnosticWsInfo[] diagnosticInfoList) {
        this.diagnosticInfoList = diagnosticInfoList;
    }

    public com.osp.npo.ws.DiagnosticWsInfo getDiagnosticInfoList(int i) {
        return this.diagnosticInfoList[i];
    }

    public void setDiagnosticInfoList(int i, com.osp.npo.ws.DiagnosticWsInfo _value) {
        this.diagnosticInfoList[i] = _value;
    }


    /**
     * Gets the password value for this WebserviceInfo.
     * 
     * @return password
     */
    public java.lang.String getPassword() {
        return password;
    }


    /**
     * Sets the password value for this WebserviceInfo.
     * 
     * @param password
     */
    public void setPassword(java.lang.String password) {
        this.password = password;
    }


    /**
     * Gets the tpAddNewFile value for this WebserviceInfo.
     * 
     * @return tpAddNewFile
     */
    public byte[] getTpAddNewFile() {
        return tpAddNewFile;
    }


    /**
     * Sets the tpAddNewFile value for this WebserviceInfo.
     * 
     * @param tpAddNewFile
     */
    public void setTpAddNewFile(byte[] tpAddNewFile) {
        this.tpAddNewFile = tpAddNewFile;
    }


    /**
     * Gets the tpFirstSynFile value for this WebserviceInfo.
     * 
     * @return tpFirstSynFile
     */
    public byte[] getTpFirstSynFile() {
        return tpFirstSynFile;
    }


    /**
     * Sets the tpFirstSynFile value for this WebserviceInfo.
     * 
     * @param tpFirstSynFile
     */
    public void setTpFirstSynFile(byte[] tpFirstSynFile) {
        this.tpFirstSynFile = tpFirstSynFile;
    }


    /**
     * Gets the tpUpdateFile value for this WebserviceInfo.
     * 
     * @return tpUpdateFile
     */
    public byte[] getTpUpdateFile() {
        return tpUpdateFile;
    }


    /**
     * Sets the tpUpdateFile value for this WebserviceInfo.
     * 
     * @param tpUpdateFile
     */
    public void setTpUpdateFile(byte[] tpUpdateFile) {
        this.tpUpdateFile = tpUpdateFile;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof WebserviceInfo)) return false;
        WebserviceInfo other = (WebserviceInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.account==null && other.getAccount()==null) || 
             (this.account!=null &&
              this.account.equals(other.getAccount()))) &&
            ((this.authenticationCode==null && other.getAuthenticationCode()==null) || 
             (this.authenticationCode!=null &&
              this.authenticationCode.equals(other.getAuthenticationCode()))) &&
            ((this.authenticationId==null && other.getAuthenticationId()==null) || 
             (this.authenticationId!=null &&
              this.authenticationId.equals(other.getAuthenticationId()))) &&
            ((this.contentInfoList==null && other.getContentInfoList()==null) || 
             (this.contentInfoList!=null &&
              java.util.Arrays.equals(this.contentInfoList, other.getContentInfoList()))) &&
            ((this.dataIdList==null && other.getDataIdList()==null) || 
             (this.dataIdList!=null &&
              java.util.Arrays.equals(this.dataIdList, other.getDataIdList()))) &&
            ((this.diagnosticInfoList==null && other.getDiagnosticInfoList()==null) || 
             (this.diagnosticInfoList!=null &&
              java.util.Arrays.equals(this.diagnosticInfoList, other.getDiagnosticInfoList()))) &&
            ((this.password==null && other.getPassword()==null) || 
             (this.password!=null &&
              this.password.equals(other.getPassword()))) &&
            ((this.tpAddNewFile==null && other.getTpAddNewFile()==null) || 
             (this.tpAddNewFile!=null &&
              java.util.Arrays.equals(this.tpAddNewFile, other.getTpAddNewFile()))) &&
            ((this.tpFirstSynFile==null && other.getTpFirstSynFile()==null) || 
             (this.tpFirstSynFile!=null &&
              java.util.Arrays.equals(this.tpFirstSynFile, other.getTpFirstSynFile()))) &&
            ((this.tpUpdateFile==null && other.getTpUpdateFile()==null) || 
             (this.tpUpdateFile!=null &&
              java.util.Arrays.equals(this.tpUpdateFile, other.getTpUpdateFile())));
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
        if (getAccount() != null) {
            _hashCode += getAccount().hashCode();
        }
        if (getAuthenticationCode() != null) {
            _hashCode += getAuthenticationCode().hashCode();
        }
        if (getAuthenticationId() != null) {
            _hashCode += getAuthenticationId().hashCode();
        }
        if (getContentInfoList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getContentInfoList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getContentInfoList(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDataIdList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDataIdList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDataIdList(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDiagnosticInfoList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDiagnosticInfoList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDiagnosticInfoList(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getPassword() != null) {
            _hashCode += getPassword().hashCode();
        }
        if (getTpAddNewFile() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getTpAddNewFile());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getTpAddNewFile(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getTpFirstSynFile() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getTpFirstSynFile());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getTpFirstSynFile(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getTpUpdateFile() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getTpUpdateFile());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getTpUpdateFile(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(WebserviceInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ws.npo.osp.com/", "webserviceInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("account");
        elemField.setXmlName(new javax.xml.namespace.QName("", "account"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("authenticationCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "authenticationCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
        elemField.setFieldName("contentInfoList");
        elemField.setXmlName(new javax.xml.namespace.QName("", "contentInfoList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ws.npo.osp.com/", "contentInfo"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataIdList");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dataIdList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("diagnosticInfoList");
        elemField.setXmlName(new javax.xml.namespace.QName("", "diagnosticInfoList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ws.npo.osp.com/", "diagnosticWsInfo"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("password");
        elemField.setXmlName(new javax.xml.namespace.QName("", "password"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tpAddNewFile");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tpAddNewFile"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "base64Binary"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tpFirstSynFile");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tpFirstSynFile"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "base64Binary"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tpUpdateFile");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tpUpdateFile"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "base64Binary"));
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
