/**
 * ContentInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.osp.npo.ws;

import com.osp.npo.core.announcementws.AnnouncementWsInfo;
import com.osp.npo.core.preventws.DataPreventHistoryWsInfo;
import com.osp.npo.core.preventws.DataPreventWsInfo;
import com.osp.npo.core.preventws.PropertyPreventWsInfo;
import com.osp.npo.core.preventws.TransactionPropertyWsInfo;
import com.osp.npo.core.synchronizews.SynchronizeWsInfo;

public class ContentInfo  implements java.io.Serializable {
    private AnnouncementWsInfo announcementWsInfo;

    private DataPreventHistoryWsInfo dataPreventHistoryWsInfo;

    private DataPreventWsInfo dataPreventWsInfo;

    private byte[] fileAttachment;

    private PropertyPreventWsInfo propertyPreventWsInfo;

    private byte[] releaseFile;

    private SynchronizeWsInfo synchronizeWsInfo;

    private TransactionPropertyWsInfo transactionPropertyWsInfo;

    public ContentInfo() {
    }

    public ContentInfo(
           AnnouncementWsInfo announcementWsInfo,
           DataPreventHistoryWsInfo dataPreventHistoryWsInfo,
           DataPreventWsInfo dataPreventWsInfo,
           byte[] fileAttachment,
           PropertyPreventWsInfo propertyPreventWsInfo,
           byte[] releaseFile,
           SynchronizeWsInfo synchronizeWsInfo,
           TransactionPropertyWsInfo transactionPropertyWsInfo) {
           this.announcementWsInfo = announcementWsInfo;
           this.dataPreventHistoryWsInfo = dataPreventHistoryWsInfo;
           this.dataPreventWsInfo = dataPreventWsInfo;
           this.fileAttachment = fileAttachment;
           this.propertyPreventWsInfo = propertyPreventWsInfo;
           this.releaseFile = releaseFile;
           this.synchronizeWsInfo = synchronizeWsInfo;
           this.transactionPropertyWsInfo = transactionPropertyWsInfo;
    }


    /**
     * Gets the announcementWsInfo value for this ContentInfo.
     * 
     * @return announcementWsInfo
     */
    public AnnouncementWsInfo getAnnouncementWsInfo() {
        return announcementWsInfo;
    }


    /**
     * Sets the announcementWsInfo value for this ContentInfo.
     * 
     * @param announcementWsInfo
     */
    public void setAnnouncementWsInfo(AnnouncementWsInfo announcementWsInfo) {
        this.announcementWsInfo = announcementWsInfo;
    }


    /**
     * Gets the dataPreventHistoryWsInfo value for this ContentInfo.
     * 
     * @return dataPreventHistoryWsInfo
     */
    public DataPreventHistoryWsInfo getDataPreventHistoryWsInfo() {
        return dataPreventHistoryWsInfo;
    }


    /**
     * Sets the dataPreventHistoryWsInfo value for this ContentInfo.
     * 
     * @param dataPreventHistoryWsInfo
     */
    public void setDataPreventHistoryWsInfo(DataPreventHistoryWsInfo dataPreventHistoryWsInfo) {
        this.dataPreventHistoryWsInfo = dataPreventHistoryWsInfo;
    }


    /**
     * Gets the dataPreventWsInfo value for this ContentInfo.
     * 
     * @return dataPreventWsInfo
     */
    public DataPreventWsInfo getDataPreventWsInfo() {
        return dataPreventWsInfo;
    }


    /**
     * Sets the dataPreventWsInfo value for this ContentInfo.
     * 
     * @param dataPreventWsInfo
     */
    public void setDataPreventWsInfo(DataPreventWsInfo dataPreventWsInfo) {
        this.dataPreventWsInfo = dataPreventWsInfo;
    }


    /**
     * Gets the fileAttachment value for this ContentInfo.
     * 
     * @return fileAttachment
     */
    public byte[] getFileAttachment() {
        return fileAttachment;
    }


    /**
     * Sets the fileAttachment value for this ContentInfo.
     * 
     * @param fileAttachment
     */
    public void setFileAttachment(byte[] fileAttachment) {
        this.fileAttachment = fileAttachment;
    }


    /**
     * Gets the propertyPreventWsInfo value for this ContentInfo.
     * 
     * @return propertyPreventWsInfo
     */
    public PropertyPreventWsInfo getPropertyPreventWsInfo() {
        return propertyPreventWsInfo;
    }


    /**
     * Sets the propertyPreventWsInfo value for this ContentInfo.
     * 
     * @param propertyPreventWsInfo
     */
    public void setPropertyPreventWsInfo(PropertyPreventWsInfo propertyPreventWsInfo) {
        this.propertyPreventWsInfo = propertyPreventWsInfo;
    }


    /**
     * Gets the releaseFile value for this ContentInfo.
     * 
     * @return releaseFile
     */
    public byte[] getReleaseFile() {
        return releaseFile;
    }


    /**
     * Sets the releaseFile value for this ContentInfo.
     * 
     * @param releaseFile
     */
    public void setReleaseFile(byte[] releaseFile) {
        this.releaseFile = releaseFile;
    }


    /**
     * Gets the synchronizeWsInfo value for this ContentInfo.
     * 
     * @return synchronizeWsInfo
     */
    public SynchronizeWsInfo getSynchronizeWsInfo() {
        return synchronizeWsInfo;
    }


    /**
     * Sets the synchronizeWsInfo value for this ContentInfo.
     * 
     * @param synchronizeWsInfo
     */
    public void setSynchronizeWsInfo(SynchronizeWsInfo synchronizeWsInfo) {
        this.synchronizeWsInfo = synchronizeWsInfo;
    }


    /**
     * Gets the transactionPropertyWsInfo value for this ContentInfo.
     * 
     * @return transactionPropertyWsInfo
     */
    public TransactionPropertyWsInfo getTransactionPropertyWsInfo() {
        return transactionPropertyWsInfo;
    }


    /**
     * Sets the transactionPropertyWsInfo value for this ContentInfo.
     * 
     * @param transactionPropertyWsInfo
     */
    public void setTransactionPropertyWsInfo(TransactionPropertyWsInfo transactionPropertyWsInfo) {
        this.transactionPropertyWsInfo = transactionPropertyWsInfo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ContentInfo)) return false;
        ContentInfo other = (ContentInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.announcementWsInfo==null && other.getAnnouncementWsInfo()==null) || 
             (this.announcementWsInfo!=null &&
              this.announcementWsInfo.equals(other.getAnnouncementWsInfo()))) &&
            ((this.dataPreventHistoryWsInfo==null && other.getDataPreventHistoryWsInfo()==null) || 
             (this.dataPreventHistoryWsInfo!=null &&
              this.dataPreventHistoryWsInfo.equals(other.getDataPreventHistoryWsInfo()))) &&
            ((this.dataPreventWsInfo==null && other.getDataPreventWsInfo()==null) || 
             (this.dataPreventWsInfo!=null &&
              this.dataPreventWsInfo.equals(other.getDataPreventWsInfo()))) &&
            ((this.fileAttachment==null && other.getFileAttachment()==null) || 
             (this.fileAttachment!=null &&
              java.util.Arrays.equals(this.fileAttachment, other.getFileAttachment()))) &&
            ((this.propertyPreventWsInfo==null && other.getPropertyPreventWsInfo()==null) || 
             (this.propertyPreventWsInfo!=null &&
              this.propertyPreventWsInfo.equals(other.getPropertyPreventWsInfo()))) &&
            ((this.releaseFile==null && other.getReleaseFile()==null) || 
             (this.releaseFile!=null &&
              java.util.Arrays.equals(this.releaseFile, other.getReleaseFile()))) &&
            ((this.synchronizeWsInfo==null && other.getSynchronizeWsInfo()==null) || 
             (this.synchronizeWsInfo!=null &&
              this.synchronizeWsInfo.equals(other.getSynchronizeWsInfo()))) &&
            ((this.transactionPropertyWsInfo==null && other.getTransactionPropertyWsInfo()==null) || 
             (this.transactionPropertyWsInfo!=null &&
              this.transactionPropertyWsInfo.equals(other.getTransactionPropertyWsInfo())));
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
        if (getAnnouncementWsInfo() != null) {
            _hashCode += getAnnouncementWsInfo().hashCode();
        }
        if (getDataPreventHistoryWsInfo() != null) {
            _hashCode += getDataPreventHistoryWsInfo().hashCode();
        }
        if (getDataPreventWsInfo() != null) {
            _hashCode += getDataPreventWsInfo().hashCode();
        }
        if (getFileAttachment() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getFileAttachment());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getFileAttachment(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getPropertyPreventWsInfo() != null) {
            _hashCode += getPropertyPreventWsInfo().hashCode();
        }
        if (getReleaseFile() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getReleaseFile());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getReleaseFile(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getSynchronizeWsInfo() != null) {
            _hashCode += getSynchronizeWsInfo().hashCode();
        }
        if (getTransactionPropertyWsInfo() != null) {
            _hashCode += getTransactionPropertyWsInfo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ContentInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ws.npo.osp.com/", "contentInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("announcementWsInfo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "announcementWsInfo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ws.npo.osp.com/", "announcementWsInfo"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataPreventHistoryWsInfo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dataPreventHistoryWsInfo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ws.npo.osp.com/", "dataPreventHistoryWsInfo"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataPreventWsInfo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dataPreventWsInfo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ws.npo.osp.com/", "dataPreventWsInfo"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fileAttachment");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fileAttachment"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "base64Binary"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("propertyPreventWsInfo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "propertyPreventWsInfo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ws.npo.osp.com/", "propertyPreventWsInfo"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("releaseFile");
        elemField.setXmlName(new javax.xml.namespace.QName("", "releaseFile"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "base64Binary"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("synchronizeWsInfo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "synchronizeWsInfo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ws.npo.osp.com/", "synchronizeWsInfo"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("transactionPropertyWsInfo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "transactionPropertyWsInfo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ws.npo.osp.com/", "transactionPropertyWsInfo"));
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
