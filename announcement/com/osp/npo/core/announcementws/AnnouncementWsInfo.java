/**
 * AnnouncementWsInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.osp.npo.core.announcementws;

public class AnnouncementWsInfo  extends com.osp.npo.core.AbstractWsInfo  implements java.io.Serializable {
    private java.lang.Long aid;

    private java.lang.String attachFileName;

    private java.lang.String attachFilePath;

    private java.lang.Byte confirmRequest;

    private java.lang.String content;

    private java.lang.Byte importanceType;

    private java.lang.Byte kind;

    private java.lang.Long popupDisplayDay;

    private java.lang.Boolean popupDisplayFlg;

    private java.util.Calendar sendDateTime;

    private java.lang.String senderInfo;

    private java.lang.String synchronizeId;

    private java.lang.String title;

    public AnnouncementWsInfo() {
    }

    public AnnouncementWsInfo(
           java.util.Calendar entryDateTime,
           java.lang.Long entryUserId,
           java.lang.String entryUserName,
           java.util.Calendar updateDateTime,
           java.lang.Long updateUserId,
           java.lang.String updateUserName,
           java.lang.Long aid,
           java.lang.String attachFileName,
           java.lang.String attachFilePath,
           java.lang.Byte confirmRequest,
           java.lang.String content,
           java.lang.Byte importanceType,
           java.lang.Byte kind,
           java.lang.Long popupDisplayDay,
           java.lang.Boolean popupDisplayFlg,
           java.util.Calendar sendDateTime,
           java.lang.String senderInfo,
           java.lang.String synchronizeId,
           java.lang.String title) {
        super(
            entryDateTime,
            entryUserId,
            entryUserName,
            updateDateTime,
            updateUserId,
            updateUserName);
        this.aid = aid;
        this.attachFileName = attachFileName;
        this.attachFilePath = attachFilePath;
        this.confirmRequest = confirmRequest;
        this.content = content;
        this.importanceType = importanceType;
        this.kind = kind;
        this.popupDisplayDay = popupDisplayDay;
        this.popupDisplayFlg = popupDisplayFlg;
        this.sendDateTime = sendDateTime;
        this.senderInfo = senderInfo;
        this.synchronizeId = synchronizeId;
        this.title = title;
    }


    /**
     * Gets the aid value for this AnnouncementWsInfo.
     * 
     * @return aid
     */
    public java.lang.Long getAid() {
        return aid;
    }


    /**
     * Sets the aid value for this AnnouncementWsInfo.
     * 
     * @param aid
     */
    public void setAid(java.lang.Long aid) {
        this.aid = aid;
    }


    /**
     * Gets the attachFileName value for this AnnouncementWsInfo.
     * 
     * @return attachFileName
     */
    public java.lang.String getAttachFileName() {
        return attachFileName;
    }


    /**
     * Sets the attachFileName value for this AnnouncementWsInfo.
     * 
     * @param attachFileName
     */
    public void setAttachFileName(java.lang.String attachFileName) {
        this.attachFileName = attachFileName;
    }


    /**
     * Gets the attachFilePath value for this AnnouncementWsInfo.
     * 
     * @return attachFilePath
     */
    public java.lang.String getAttachFilePath() {
        return attachFilePath;
    }


    /**
     * Sets the attachFilePath value for this AnnouncementWsInfo.
     * 
     * @param attachFilePath
     */
    public void setAttachFilePath(java.lang.String attachFilePath) {
        this.attachFilePath = attachFilePath;
    }


    /**
     * Gets the confirmRequest value for this AnnouncementWsInfo.
     * 
     * @return confirmRequest
     */
    public java.lang.Byte getConfirmRequest() {
        return confirmRequest;
    }


    /**
     * Sets the confirmRequest value for this AnnouncementWsInfo.
     * 
     * @param confirmRequest
     */
    public void setConfirmRequest(java.lang.Byte confirmRequest) {
        this.confirmRequest = confirmRequest;
    }


    /**
     * Gets the content value for this AnnouncementWsInfo.
     * 
     * @return content
     */
    public java.lang.String getContent() {
        return content;
    }


    /**
     * Sets the content value for this AnnouncementWsInfo.
     * 
     * @param content
     */
    public void setContent(java.lang.String content) {
        this.content = content;
    }


    /**
     * Gets the importanceType value for this AnnouncementWsInfo.
     * 
     * @return importanceType
     */
    public java.lang.Byte getImportanceType() {
        return importanceType;
    }


    /**
     * Sets the importanceType value for this AnnouncementWsInfo.
     * 
     * @param importanceType
     */
    public void setImportanceType(java.lang.Byte importanceType) {
        this.importanceType = importanceType;
    }


    /**
     * Gets the kind value for this AnnouncementWsInfo.
     * 
     * @return kind
     */
    public java.lang.Byte getKind() {
        return kind;
    }


    /**
     * Sets the kind value for this AnnouncementWsInfo.
     * 
     * @param kind
     */
    public void setKind(java.lang.Byte kind) {
        this.kind = kind;
    }


    /**
     * Gets the popupDisplayDay value for this AnnouncementWsInfo.
     * 
     * @return popupDisplayDay
     */
    public java.lang.Long getPopupDisplayDay() {
        return popupDisplayDay;
    }


    /**
     * Sets the popupDisplayDay value for this AnnouncementWsInfo.
     * 
     * @param popupDisplayDay
     */
    public void setPopupDisplayDay(java.lang.Long popupDisplayDay) {
        this.popupDisplayDay = popupDisplayDay;
    }


    /**
     * Gets the popupDisplayFlg value for this AnnouncementWsInfo.
     * 
     * @return popupDisplayFlg
     */
    public java.lang.Boolean getPopupDisplayFlg() {
        return popupDisplayFlg;
    }


    /**
     * Sets the popupDisplayFlg value for this AnnouncementWsInfo.
     * 
     * @param popupDisplayFlg
     */
    public void setPopupDisplayFlg(java.lang.Boolean popupDisplayFlg) {
        this.popupDisplayFlg = popupDisplayFlg;
    }


    /**
     * Gets the sendDateTime value for this AnnouncementWsInfo.
     * 
     * @return sendDateTime
     */
    public java.util.Calendar getSendDateTime() {
        return sendDateTime;
    }


    /**
     * Sets the sendDateTime value for this AnnouncementWsInfo.
     * 
     * @param sendDateTime
     */
    public void setSendDateTime(java.util.Calendar sendDateTime) {
        this.sendDateTime = sendDateTime;
    }


    /**
     * Gets the senderInfo value for this AnnouncementWsInfo.
     * 
     * @return senderInfo
     */
    public java.lang.String getSenderInfo() {
        return senderInfo;
    }


    /**
     * Sets the senderInfo value for this AnnouncementWsInfo.
     * 
     * @param senderInfo
     */
    public void setSenderInfo(java.lang.String senderInfo) {
        this.senderInfo = senderInfo;
    }


    /**
     * Gets the synchronizeId value for this AnnouncementWsInfo.
     * 
     * @return synchronizeId
     */
    public java.lang.String getSynchronizeId() {
        return synchronizeId;
    }


    /**
     * Sets the synchronizeId value for this AnnouncementWsInfo.
     * 
     * @param synchronizeId
     */
    public void setSynchronizeId(java.lang.String synchronizeId) {
        this.synchronizeId = synchronizeId;
    }


    /**
     * Gets the title value for this AnnouncementWsInfo.
     * 
     * @return title
     */
    public java.lang.String getTitle() {
        return title;
    }


    /**
     * Sets the title value for this AnnouncementWsInfo.
     * 
     * @param title
     */
    public void setTitle(java.lang.String title) {
        this.title = title;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AnnouncementWsInfo)) return false;
        AnnouncementWsInfo other = (AnnouncementWsInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.aid==null && other.getAid()==null) || 
             (this.aid!=null &&
              this.aid.equals(other.getAid()))) &&
            ((this.attachFileName==null && other.getAttachFileName()==null) || 
             (this.attachFileName!=null &&
              this.attachFileName.equals(other.getAttachFileName()))) &&
            ((this.attachFilePath==null && other.getAttachFilePath()==null) || 
             (this.attachFilePath!=null &&
              this.attachFilePath.equals(other.getAttachFilePath()))) &&
            ((this.confirmRequest==null && other.getConfirmRequest()==null) || 
             (this.confirmRequest!=null &&
              this.confirmRequest.equals(other.getConfirmRequest()))) &&
            ((this.content==null && other.getContent()==null) || 
             (this.content!=null &&
              this.content.equals(other.getContent()))) &&
            ((this.importanceType==null && other.getImportanceType()==null) || 
             (this.importanceType!=null &&
              this.importanceType.equals(other.getImportanceType()))) &&
            ((this.kind==null && other.getKind()==null) || 
             (this.kind!=null &&
              this.kind.equals(other.getKind()))) &&
            ((this.popupDisplayDay==null && other.getPopupDisplayDay()==null) || 
             (this.popupDisplayDay!=null &&
              this.popupDisplayDay.equals(other.getPopupDisplayDay()))) &&
            ((this.popupDisplayFlg==null && other.getPopupDisplayFlg()==null) || 
             (this.popupDisplayFlg!=null &&
              this.popupDisplayFlg.equals(other.getPopupDisplayFlg()))) &&
            ((this.sendDateTime==null && other.getSendDateTime()==null) || 
             (this.sendDateTime!=null &&
              this.sendDateTime.equals(other.getSendDateTime()))) &&
            ((this.senderInfo==null && other.getSenderInfo()==null) || 
             (this.senderInfo!=null &&
              this.senderInfo.equals(other.getSenderInfo()))) &&
            ((this.synchronizeId==null && other.getSynchronizeId()==null) || 
             (this.synchronizeId!=null &&
              this.synchronizeId.equals(other.getSynchronizeId()))) &&
            ((this.title==null && other.getTitle()==null) || 
             (this.title!=null &&
              this.title.equals(other.getTitle())));
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
        if (getAid() != null) {
            _hashCode += getAid().hashCode();
        }
        if (getAttachFileName() != null) {
            _hashCode += getAttachFileName().hashCode();
        }
        if (getAttachFilePath() != null) {
            _hashCode += getAttachFilePath().hashCode();
        }
        if (getConfirmRequest() != null) {
            _hashCode += getConfirmRequest().hashCode();
        }
        if (getContent() != null) {
            _hashCode += getContent().hashCode();
        }
        if (getImportanceType() != null) {
            _hashCode += getImportanceType().hashCode();
        }
        if (getKind() != null) {
            _hashCode += getKind().hashCode();
        }
        if (getPopupDisplayDay() != null) {
            _hashCode += getPopupDisplayDay().hashCode();
        }
        if (getPopupDisplayFlg() != null) {
            _hashCode += getPopupDisplayFlg().hashCode();
        }
        if (getSendDateTime() != null) {
            _hashCode += getSendDateTime().hashCode();
        }
        if (getSenderInfo() != null) {
            _hashCode += getSenderInfo().hashCode();
        }
        if (getSynchronizeId() != null) {
            _hashCode += getSynchronizeId().hashCode();
        }
        if (getTitle() != null) {
            _hashCode += getTitle().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AnnouncementWsInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://npo.osp.com/", "announcementWsInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("aid");
        elemField.setXmlName(new javax.xml.namespace.QName("", "aid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("attachFileName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "attachFileName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("attachFilePath");
        elemField.setXmlName(new javax.xml.namespace.QName("", "attachFilePath"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("confirmRequest");
        elemField.setXmlName(new javax.xml.namespace.QName("", "confirmRequest"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "byte"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("content");
        elemField.setXmlName(new javax.xml.namespace.QName("", "content"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("importanceType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "importanceType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "byte"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("kind");
        elemField.setXmlName(new javax.xml.namespace.QName("", "kind"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "byte"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("popupDisplayDay");
        elemField.setXmlName(new javax.xml.namespace.QName("", "popupDisplayDay"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("popupDisplayFlg");
        elemField.setXmlName(new javax.xml.namespace.QName("", "popupDisplayFlg"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sendDateTime");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sendDateTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("senderInfo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "senderInfo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("synchronizeId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "synchronizeId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("title");
        elemField.setXmlName(new javax.xml.namespace.QName("", "title"));
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
