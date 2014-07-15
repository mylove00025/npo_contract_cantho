/**
 * TransactionPropertyWsInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.osp.npo.core.preventws;

import com.osp.npo.core.AbstractWsInfo;

public class TransactionPropertyWsInfo  extends AbstractWsInfo  implements java.io.Serializable {
    private java.lang.String cancelDescription;

    private java.lang.Boolean cancelStatus;

    private java.lang.Long contractId;

    private java.lang.String contractKind;

    private java.lang.String contractName;

    private java.lang.String contractNumber;

    private java.lang.String contractPeriod;

    private java.lang.String contractValue;

    private java.lang.String landDistrict;

    private java.lang.String landStreet;

    private java.lang.String mortageCancelDate;

    private java.lang.Boolean mortageCancelFlag;

    private java.lang.String mortageCancelNote;

    private java.util.Calendar notaryDate;

    private java.lang.String notaryFee;

    private java.lang.String notaryOfficeName;

    private java.lang.String notaryPerson;

    private java.lang.String notaryPlace;

    private java.lang.String note;

    private java.lang.String propertyInfo;

    private java.lang.String relationObject;

    private java.lang.String synchronizeId;

    private java.lang.Long tpid;

    private java.lang.String transactionContent;

    private java.lang.String type;

    public TransactionPropertyWsInfo() {
    }

    public TransactionPropertyWsInfo(
           java.util.Calendar entryDateTime,
           java.lang.Long entryUserId,
           java.lang.String entryUserName,
           java.util.Calendar updateDateTime,
           java.lang.Long updateUserId,
           java.lang.String updateUserName,
           java.lang.String cancelDescription,
           java.lang.Boolean cancelStatus,
           java.lang.Long contractId,
           java.lang.String contractKind,
           java.lang.String contractName,
           java.lang.String contractNumber,
           java.lang.String contractPeriod,
           java.lang.String contractValue,
           java.lang.String landDistrict,
           java.lang.String landStreet,
           java.lang.String mortageCancelDate,
           java.lang.Boolean mortageCancelFlag,
           java.lang.String mortageCancelNote,
           java.util.Calendar notaryDate,
           java.lang.String notaryFee,
           java.lang.String notaryOfficeName,
           java.lang.String notaryPerson,
           java.lang.String notaryPlace,
           java.lang.String note,
           java.lang.String propertyInfo,
           java.lang.String relationObject,
           java.lang.String synchronizeId,
           java.lang.Long tpid,
           java.lang.String transactionContent,
           java.lang.String type) {
        super(
            entryDateTime,
            entryUserId,
            entryUserName,
            updateDateTime,
            updateUserId,
            updateUserName);
        this.cancelDescription = cancelDescription;
        this.cancelStatus = cancelStatus;
        this.contractId = contractId;
        this.contractKind = contractKind;
        this.contractName = contractName;
        this.contractNumber = contractNumber;
        this.contractPeriod = contractPeriod;
        this.contractValue = contractValue;
        this.landDistrict = landDistrict;
        this.landStreet = landStreet;
        this.mortageCancelDate = mortageCancelDate;
        this.mortageCancelFlag = mortageCancelFlag;
        this.mortageCancelNote = mortageCancelNote;
        this.notaryDate = notaryDate;
        this.notaryFee = notaryFee;
        this.notaryOfficeName = notaryOfficeName;
        this.notaryPerson = notaryPerson;
        this.notaryPlace = notaryPlace;
        this.note = note;
        this.propertyInfo = propertyInfo;
        this.relationObject = relationObject;
        this.synchronizeId = synchronizeId;
        this.tpid = tpid;
        this.transactionContent = transactionContent;
        this.type = type;
    }


    /**
     * Gets the cancelDescription value for this TransactionPropertyWsInfo.
     * 
     * @return cancelDescription
     */
    public java.lang.String getCancelDescription() {
        return cancelDescription;
    }


    /**
     * Sets the cancelDescription value for this TransactionPropertyWsInfo.
     * 
     * @param cancelDescription
     */
    public void setCancelDescription(java.lang.String cancelDescription) {
        this.cancelDescription = cancelDescription;
    }


    /**
     * Gets the cancelStatus value for this TransactionPropertyWsInfo.
     * 
     * @return cancelStatus
     */
    public java.lang.Boolean getCancelStatus() {
        return cancelStatus;
    }


    /**
     * Sets the cancelStatus value for this TransactionPropertyWsInfo.
     * 
     * @param cancelStatus
     */
    public void setCancelStatus(java.lang.Boolean cancelStatus) {
        this.cancelStatus = cancelStatus;
    }


    /**
     * Gets the contractId value for this TransactionPropertyWsInfo.
     * 
     * @return contractId
     */
    public java.lang.Long getContractId() {
        return contractId;
    }


    /**
     * Sets the contractId value for this TransactionPropertyWsInfo.
     * 
     * @param contractId
     */
    public void setContractId(java.lang.Long contractId) {
        this.contractId = contractId;
    }


    /**
     * Gets the contractKind value for this TransactionPropertyWsInfo.
     * 
     * @return contractKind
     */
    public java.lang.String getContractKind() {
        return contractKind;
    }


    /**
     * Sets the contractKind value for this TransactionPropertyWsInfo.
     * 
     * @param contractKind
     */
    public void setContractKind(java.lang.String contractKind) {
        this.contractKind = contractKind;
    }


    /**
     * Gets the contractName value for this TransactionPropertyWsInfo.
     * 
     * @return contractName
     */
    public java.lang.String getContractName() {
        return contractName;
    }


    /**
     * Sets the contractName value for this TransactionPropertyWsInfo.
     * 
     * @param contractName
     */
    public void setContractName(java.lang.String contractName) {
        this.contractName = contractName;
    }


    /**
     * Gets the contractNumber value for this TransactionPropertyWsInfo.
     * 
     * @return contractNumber
     */
    public java.lang.String getContractNumber() {
        return contractNumber;
    }


    /**
     * Sets the contractNumber value for this TransactionPropertyWsInfo.
     * 
     * @param contractNumber
     */
    public void setContractNumber(java.lang.String contractNumber) {
        this.contractNumber = contractNumber;
    }


    /**
     * Gets the contractPeriod value for this TransactionPropertyWsInfo.
     * 
     * @return contractPeriod
     */
    public java.lang.String getContractPeriod() {
        return contractPeriod;
    }


    /**
     * Sets the contractPeriod value for this TransactionPropertyWsInfo.
     * 
     * @param contractPeriod
     */
    public void setContractPeriod(java.lang.String contractPeriod) {
        this.contractPeriod = contractPeriod;
    }


    /**
     * Gets the contractValue value for this TransactionPropertyWsInfo.
     * 
     * @return contractValue
     */
    public java.lang.String getContractValue() {
        return contractValue;
    }


    /**
     * Sets the contractValue value for this TransactionPropertyWsInfo.
     * 
     * @param contractValue
     */
    public void setContractValue(java.lang.String contractValue) {
        this.contractValue = contractValue;
    }


    /**
     * Gets the landDistrict value for this TransactionPropertyWsInfo.
     * 
     * @return landDistrict
     */
    public java.lang.String getLandDistrict() {
        return landDistrict;
    }


    /**
     * Sets the landDistrict value for this TransactionPropertyWsInfo.
     * 
     * @param landDistrict
     */
    public void setLandDistrict(java.lang.String landDistrict) {
        this.landDistrict = landDistrict;
    }


    /**
     * Gets the landStreet value for this TransactionPropertyWsInfo.
     * 
     * @return landStreet
     */
    public java.lang.String getLandStreet() {
        return landStreet;
    }


    /**
     * Sets the landStreet value for this TransactionPropertyWsInfo.
     * 
     * @param landStreet
     */
    public void setLandStreet(java.lang.String landStreet) {
        this.landStreet = landStreet;
    }


    /**
     * Gets the mortageCancelDate value for this TransactionPropertyWsInfo.
     * 
     * @return mortageCancelDate
     */
    public java.lang.String getMortageCancelDate() {
        return mortageCancelDate;
    }


    /**
     * Sets the mortageCancelDate value for this TransactionPropertyWsInfo.
     * 
     * @param mortageCancelDate
     */
    public void setMortageCancelDate(java.lang.String mortageCancelDate) {
        this.mortageCancelDate = mortageCancelDate;
    }


    /**
     * Gets the mortageCancelFlag value for this TransactionPropertyWsInfo.
     * 
     * @return mortageCancelFlag
     */
    public java.lang.Boolean getMortageCancelFlag() {
        return mortageCancelFlag;
    }


    /**
     * Sets the mortageCancelFlag value for this TransactionPropertyWsInfo.
     * 
     * @param mortageCancelFlag
     */
    public void setMortageCancelFlag(java.lang.Boolean mortageCancelFlag) {
        this.mortageCancelFlag = mortageCancelFlag;
    }


    /**
     * Gets the mortageCancelNote value for this TransactionPropertyWsInfo.
     * 
     * @return mortageCancelNote
     */
    public java.lang.String getMortageCancelNote() {
        return mortageCancelNote;
    }


    /**
     * Sets the mortageCancelNote value for this TransactionPropertyWsInfo.
     * 
     * @param mortageCancelNote
     */
    public void setMortageCancelNote(java.lang.String mortageCancelNote) {
        this.mortageCancelNote = mortageCancelNote;
    }


    /**
     * Gets the notaryDate value for this TransactionPropertyWsInfo.
     * 
     * @return notaryDate
     */
    public java.util.Calendar getNotaryDate() {
        return notaryDate;
    }


    /**
     * Sets the notaryDate value for this TransactionPropertyWsInfo.
     * 
     * @param notaryDate
     */
    public void setNotaryDate(java.util.Calendar notaryDate) {
        this.notaryDate = notaryDate;
    }


    /**
     * Gets the notaryFee value for this TransactionPropertyWsInfo.
     * 
     * @return notaryFee
     */
    public java.lang.String getNotaryFee() {
        return notaryFee;
    }


    /**
     * Sets the notaryFee value for this TransactionPropertyWsInfo.
     * 
     * @param notaryFee
     */
    public void setNotaryFee(java.lang.String notaryFee) {
        this.notaryFee = notaryFee;
    }


    /**
     * Gets the notaryOfficeName value for this TransactionPropertyWsInfo.
     * 
     * @return notaryOfficeName
     */
    public java.lang.String getNotaryOfficeName() {
        return notaryOfficeName;
    }


    /**
     * Sets the notaryOfficeName value for this TransactionPropertyWsInfo.
     * 
     * @param notaryOfficeName
     */
    public void setNotaryOfficeName(java.lang.String notaryOfficeName) {
        this.notaryOfficeName = notaryOfficeName;
    }


    /**
     * Gets the notaryPerson value for this TransactionPropertyWsInfo.
     * 
     * @return notaryPerson
     */
    public java.lang.String getNotaryPerson() {
        return notaryPerson;
    }


    /**
     * Sets the notaryPerson value for this TransactionPropertyWsInfo.
     * 
     * @param notaryPerson
     */
    public void setNotaryPerson(java.lang.String notaryPerson) {
        this.notaryPerson = notaryPerson;
    }


    /**
     * Gets the notaryPlace value for this TransactionPropertyWsInfo.
     * 
     * @return notaryPlace
     */
    public java.lang.String getNotaryPlace() {
        return notaryPlace;
    }


    /**
     * Sets the notaryPlace value for this TransactionPropertyWsInfo.
     * 
     * @param notaryPlace
     */
    public void setNotaryPlace(java.lang.String notaryPlace) {
        this.notaryPlace = notaryPlace;
    }


    /**
     * Gets the note value for this TransactionPropertyWsInfo.
     * 
     * @return note
     */
    public java.lang.String getNote() {
        return note;
    }


    /**
     * Sets the note value for this TransactionPropertyWsInfo.
     * 
     * @param note
     */
    public void setNote(java.lang.String note) {
        this.note = note;
    }


    /**
     * Gets the propertyInfo value for this TransactionPropertyWsInfo.
     * 
     * @return propertyInfo
     */
    public java.lang.String getPropertyInfo() {
        return propertyInfo;
    }


    /**
     * Sets the propertyInfo value for this TransactionPropertyWsInfo.
     * 
     * @param propertyInfo
     */
    public void setPropertyInfo(java.lang.String propertyInfo) {
        this.propertyInfo = propertyInfo;
    }


    /**
     * Gets the relationObject value for this TransactionPropertyWsInfo.
     * 
     * @return relationObject
     */
    public java.lang.String getRelationObject() {
        return relationObject;
    }


    /**
     * Sets the relationObject value for this TransactionPropertyWsInfo.
     * 
     * @param relationObject
     */
    public void setRelationObject(java.lang.String relationObject) {
        this.relationObject = relationObject;
    }


    /**
     * Gets the synchronizeId value for this TransactionPropertyWsInfo.
     * 
     * @return synchronizeId
     */
    public java.lang.String getSynchronizeId() {
        return synchronizeId;
    }


    /**
     * Sets the synchronizeId value for this TransactionPropertyWsInfo.
     * 
     * @param synchronizeId
     */
    public void setSynchronizeId(java.lang.String synchronizeId) {
        this.synchronizeId = synchronizeId;
    }


    /**
     * Gets the tpid value for this TransactionPropertyWsInfo.
     * 
     * @return tpid
     */
    public java.lang.Long getTpid() {
        return tpid;
    }


    /**
     * Sets the tpid value for this TransactionPropertyWsInfo.
     * 
     * @param tpid
     */
    public void setTpid(java.lang.Long tpid) {
        this.tpid = tpid;
    }


    /**
     * Gets the transactionContent value for this TransactionPropertyWsInfo.
     * 
     * @return transactionContent
     */
    public java.lang.String getTransactionContent() {
        return transactionContent;
    }


    /**
     * Sets the transactionContent value for this TransactionPropertyWsInfo.
     * 
     * @param transactionContent
     */
    public void setTransactionContent(java.lang.String transactionContent) {
        this.transactionContent = transactionContent;
    }


    /**
     * Gets the type value for this TransactionPropertyWsInfo.
     * 
     * @return type
     */
    public java.lang.String getType() {
        return type;
    }


    /**
     * Sets the type value for this TransactionPropertyWsInfo.
     * 
     * @param type
     */
    public void setType(java.lang.String type) {
        this.type = type;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof TransactionPropertyWsInfo)) return false;
        TransactionPropertyWsInfo other = (TransactionPropertyWsInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.cancelDescription==null && other.getCancelDescription()==null) || 
             (this.cancelDescription!=null &&
              this.cancelDescription.equals(other.getCancelDescription()))) &&
            ((this.cancelStatus==null && other.getCancelStatus()==null) || 
             (this.cancelStatus!=null &&
              this.cancelStatus.equals(other.getCancelStatus()))) &&
            ((this.contractId==null && other.getContractId()==null) || 
             (this.contractId!=null &&
              this.contractId.equals(other.getContractId()))) &&
            ((this.contractKind==null && other.getContractKind()==null) || 
             (this.contractKind!=null &&
              this.contractKind.equals(other.getContractKind()))) &&
            ((this.contractName==null && other.getContractName()==null) || 
             (this.contractName!=null &&
              this.contractName.equals(other.getContractName()))) &&
            ((this.contractNumber==null && other.getContractNumber()==null) || 
             (this.contractNumber!=null &&
              this.contractNumber.equals(other.getContractNumber()))) &&
            ((this.contractPeriod==null && other.getContractPeriod()==null) || 
             (this.contractPeriod!=null &&
              this.contractPeriod.equals(other.getContractPeriod()))) &&
            ((this.contractValue==null && other.getContractValue()==null) || 
             (this.contractValue!=null &&
              this.contractValue.equals(other.getContractValue()))) &&
            ((this.landDistrict==null && other.getLandDistrict()==null) || 
             (this.landDistrict!=null &&
              this.landDistrict.equals(other.getLandDistrict()))) &&
            ((this.landStreet==null && other.getLandStreet()==null) || 
             (this.landStreet!=null &&
              this.landStreet.equals(other.getLandStreet()))) &&
            ((this.mortageCancelDate==null && other.getMortageCancelDate()==null) || 
             (this.mortageCancelDate!=null &&
              this.mortageCancelDate.equals(other.getMortageCancelDate()))) &&
            ((this.mortageCancelFlag==null && other.getMortageCancelFlag()==null) || 
             (this.mortageCancelFlag!=null &&
              this.mortageCancelFlag.equals(other.getMortageCancelFlag()))) &&
            ((this.mortageCancelNote==null && other.getMortageCancelNote()==null) || 
             (this.mortageCancelNote!=null &&
              this.mortageCancelNote.equals(other.getMortageCancelNote()))) &&
            ((this.notaryDate==null && other.getNotaryDate()==null) || 
             (this.notaryDate!=null &&
              this.notaryDate.equals(other.getNotaryDate()))) &&
            ((this.notaryFee==null && other.getNotaryFee()==null) || 
             (this.notaryFee!=null &&
              this.notaryFee.equals(other.getNotaryFee()))) &&
            ((this.notaryOfficeName==null && other.getNotaryOfficeName()==null) || 
             (this.notaryOfficeName!=null &&
              this.notaryOfficeName.equals(other.getNotaryOfficeName()))) &&
            ((this.notaryPerson==null && other.getNotaryPerson()==null) || 
             (this.notaryPerson!=null &&
              this.notaryPerson.equals(other.getNotaryPerson()))) &&
            ((this.notaryPlace==null && other.getNotaryPlace()==null) || 
             (this.notaryPlace!=null &&
              this.notaryPlace.equals(other.getNotaryPlace()))) &&
            ((this.note==null && other.getNote()==null) || 
             (this.note!=null &&
              this.note.equals(other.getNote()))) &&
            ((this.propertyInfo==null && other.getPropertyInfo()==null) || 
             (this.propertyInfo!=null &&
              this.propertyInfo.equals(other.getPropertyInfo()))) &&
            ((this.relationObject==null && other.getRelationObject()==null) || 
             (this.relationObject!=null &&
              this.relationObject.equals(other.getRelationObject()))) &&
            ((this.synchronizeId==null && other.getSynchronizeId()==null) || 
             (this.synchronizeId!=null &&
              this.synchronizeId.equals(other.getSynchronizeId()))) &&
            ((this.tpid==null && other.getTpid()==null) || 
             (this.tpid!=null &&
              this.tpid.equals(other.getTpid()))) &&
            ((this.transactionContent==null && other.getTransactionContent()==null) || 
             (this.transactionContent!=null &&
              this.transactionContent.equals(other.getTransactionContent()))) &&
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
        if (getCancelDescription() != null) {
            _hashCode += getCancelDescription().hashCode();
        }
        if (getCancelStatus() != null) {
            _hashCode += getCancelStatus().hashCode();
        }
        if (getContractId() != null) {
            _hashCode += getContractId().hashCode();
        }
        if (getContractKind() != null) {
            _hashCode += getContractKind().hashCode();
        }
        if (getContractName() != null) {
            _hashCode += getContractName().hashCode();
        }
        if (getContractNumber() != null) {
            _hashCode += getContractNumber().hashCode();
        }
        if (getContractPeriod() != null) {
            _hashCode += getContractPeriod().hashCode();
        }
        if (getContractValue() != null) {
            _hashCode += getContractValue().hashCode();
        }
        if (getLandDistrict() != null) {
            _hashCode += getLandDistrict().hashCode();
        }
        if (getLandStreet() != null) {
            _hashCode += getLandStreet().hashCode();
        }
        if (getMortageCancelDate() != null) {
            _hashCode += getMortageCancelDate().hashCode();
        }
        if (getMortageCancelFlag() != null) {
            _hashCode += getMortageCancelFlag().hashCode();
        }
        if (getMortageCancelNote() != null) {
            _hashCode += getMortageCancelNote().hashCode();
        }
        if (getNotaryDate() != null) {
            _hashCode += getNotaryDate().hashCode();
        }
        if (getNotaryFee() != null) {
            _hashCode += getNotaryFee().hashCode();
        }
        if (getNotaryOfficeName() != null) {
            _hashCode += getNotaryOfficeName().hashCode();
        }
        if (getNotaryPerson() != null) {
            _hashCode += getNotaryPerson().hashCode();
        }
        if (getNotaryPlace() != null) {
            _hashCode += getNotaryPlace().hashCode();
        }
        if (getNote() != null) {
            _hashCode += getNote().hashCode();
        }
        if (getPropertyInfo() != null) {
            _hashCode += getPropertyInfo().hashCode();
        }
        if (getRelationObject() != null) {
            _hashCode += getRelationObject().hashCode();
        }
        if (getSynchronizeId() != null) {
            _hashCode += getSynchronizeId().hashCode();
        }
        if (getTpid() != null) {
            _hashCode += getTpid().hashCode();
        }
        if (getTransactionContent() != null) {
            _hashCode += getTransactionContent().hashCode();
        }
        if (getType() != null) {
            _hashCode += getType().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(TransactionPropertyWsInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ws.npo.osp.com/", "transactionPropertyWsInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cancelDescription");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cancelDescription"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cancelStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cancelStatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contractId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "contractId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contractKind");
        elemField.setXmlName(new javax.xml.namespace.QName("", "contractKind"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contractName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "contractName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contractNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "contractNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contractPeriod");
        elemField.setXmlName(new javax.xml.namespace.QName("", "contractPeriod"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contractValue");
        elemField.setXmlName(new javax.xml.namespace.QName("", "contractValue"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("landDistrict");
        elemField.setXmlName(new javax.xml.namespace.QName("", "landDistrict"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("landStreet");
        elemField.setXmlName(new javax.xml.namespace.QName("", "landStreet"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mortageCancelDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mortageCancelDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mortageCancelFlag");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mortageCancelFlag"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mortageCancelNote");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mortageCancelNote"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("notaryDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "notaryDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("notaryFee");
        elemField.setXmlName(new javax.xml.namespace.QName("", "notaryFee"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("notaryOfficeName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "notaryOfficeName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("notaryPerson");
        elemField.setXmlName(new javax.xml.namespace.QName("", "notaryPerson"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("notaryPlace");
        elemField.setXmlName(new javax.xml.namespace.QName("", "notaryPlace"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("note");
        elemField.setXmlName(new javax.xml.namespace.QName("", "note"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("propertyInfo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "propertyInfo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("relationObject");
        elemField.setXmlName(new javax.xml.namespace.QName("", "relationObject"));
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
        elemField.setFieldName("tpid");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tpid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("transactionContent");
        elemField.setXmlName(new javax.xml.namespace.QName("", "transactionContent"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("type");
        elemField.setXmlName(new javax.xml.namespace.QName("", "type"));
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
