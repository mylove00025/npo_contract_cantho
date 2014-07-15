/**
 * PropertyPreventWsInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.osp.npo.core.preventws;

import com.osp.npo.common.global.Constants;
import com.osp.npo.common.util.EditString;
import com.osp.npo.common.util.SystemMessageProperties;
import com.osp.npo.core.AbstractWsInfo;

public class PropertyPreventWsInfo  extends AbstractWsInfo  implements java.io.Serializable {
    private java.lang.String carFrameNumber;

    private java.util.Calendar carIssueDate;

    private java.lang.String carIssuePlace;

    private java.lang.String carLicenseNumber;

    private java.lang.String carMachineNumber;

    private java.lang.String carRegistNumber;

    private java.lang.Long id;

    private java.lang.String landAddress;

    private java.lang.String landArea;

    private java.lang.String landAssociateProperty;

    private java.lang.String landCertificate;

    private java.lang.String landDistrict;

    private java.util.Calendar landIssueDate;

    private java.lang.String landIssuePlace;

    private java.lang.String landMapNumber;

    private java.lang.String landNumber;

    private java.lang.String landPrivateArea;

    private java.lang.Long landProvince;

    private java.lang.String landPublicArea;

    private java.lang.String landStreet;

    private java.lang.String landUseOrigin;

    private java.lang.String landUsePeriod;

    private java.lang.String landUsePurpose;

    private java.lang.String otherInfo;

    private java.lang.String ownerInfo;

    private java.lang.String propertyInfo;

    private java.lang.String type;

    public PropertyPreventWsInfo() {
    }

    public PropertyPreventWsInfo(
           java.util.Calendar entryDateTime,
           java.lang.Long entryUserId,
           java.lang.String entryUserName,
           java.util.Calendar updateDateTime,
           java.lang.Long updateUserId,
           java.lang.String updateUserName,
           java.lang.String carFrameNumber,
           java.util.Calendar carIssueDate,
           java.lang.String carIssuePlace,
           java.lang.String carLicenseNumber,
           java.lang.String carMachineNumber,
           java.lang.String carRegistNumber,
           java.lang.Long id,
           java.lang.String landAddress,
           java.lang.String landArea,
           java.lang.String landAssociateProperty,
           java.lang.String landCertificate,
           java.lang.String landDistrict,
           java.util.Calendar landIssueDate,
           java.lang.String landIssuePlace,
           java.lang.String landMapNumber,
           java.lang.String landNumber,
           java.lang.String landPrivateArea,
           java.lang.Long landProvince,
           java.lang.String landPublicArea,
           java.lang.String landStreet,
           java.lang.String landUseOrigin,
           java.lang.String landUsePeriod,
           java.lang.String landUsePurpose,
           java.lang.String otherInfo,
           java.lang.String ownerInfo,
           java.lang.String propertyInfo,
           java.lang.String type) {
        super(
            entryDateTime,
            entryUserId,
            entryUserName,
            updateDateTime,
            updateUserId,
            updateUserName);
        this.carFrameNumber = carFrameNumber;
        this.carIssueDate = carIssueDate;
        this.carIssuePlace = carIssuePlace;
        this.carLicenseNumber = carLicenseNumber;
        this.carMachineNumber = carMachineNumber;
        this.carRegistNumber = carRegistNumber;
        this.id = id;
        this.landAddress = landAddress;
        this.landArea = landArea;
        this.landAssociateProperty = landAssociateProperty;
        this.landCertificate = landCertificate;
        this.landDistrict = landDistrict;
        this.landIssueDate = landIssueDate;
        this.landIssuePlace = landIssuePlace;
        this.landMapNumber = landMapNumber;
        this.landNumber = landNumber;
        this.landPrivateArea = landPrivateArea;
        this.landProvince = landProvince;
        this.landPublicArea = landPublicArea;
        this.landStreet = landStreet;
        this.landUseOrigin = landUseOrigin;
        this.landUsePeriod = landUsePeriod;
        this.landUsePurpose = landUsePurpose;
        this.otherInfo = otherInfo;
        this.ownerInfo = ownerInfo;
        this.propertyInfo = propertyInfo;
        this.type = type;
    }


    /**
     * Gets the carFrameNumber value for this PropertyPreventWsInfo.
     * 
     * @return carFrameNumber
     */
    public java.lang.String getCarFrameNumber() {
        return carFrameNumber;
    }


    /**
     * Sets the carFrameNumber value for this PropertyPreventWsInfo.
     * 
     * @param carFrameNumber
     */
    public void setCarFrameNumber(java.lang.String carFrameNumber) {
        this.carFrameNumber = carFrameNumber;
    }


    /**
     * Gets the carIssueDate value for this PropertyPreventWsInfo.
     * 
     * @return carIssueDate
     */
    public java.util.Calendar getCarIssueDate() {
        return carIssueDate;
    }


    /**
     * Sets the carIssueDate value for this PropertyPreventWsInfo.
     * 
     * @param carIssueDate
     */
    public void setCarIssueDate(java.util.Calendar carIssueDate) {
        this.carIssueDate = carIssueDate;
    }


    /**
     * Gets the carIssuePlace value for this PropertyPreventWsInfo.
     * 
     * @return carIssuePlace
     */
    public java.lang.String getCarIssuePlace() {
        return carIssuePlace;
    }


    /**
     * Sets the carIssuePlace value for this PropertyPreventWsInfo.
     * 
     * @param carIssuePlace
     */
    public void setCarIssuePlace(java.lang.String carIssuePlace) {
        this.carIssuePlace = carIssuePlace;
    }


    /**
     * Gets the carLicenseNumber value for this PropertyPreventWsInfo.
     * 
     * @return carLicenseNumber
     */
    public java.lang.String getCarLicenseNumber() {
        return carLicenseNumber;
    }


    /**
     * Sets the carLicenseNumber value for this PropertyPreventWsInfo.
     * 
     * @param carLicenseNumber
     */
    public void setCarLicenseNumber(java.lang.String carLicenseNumber) {
        this.carLicenseNumber = carLicenseNumber;
    }


    /**
     * Gets the carMachineNumber value for this PropertyPreventWsInfo.
     * 
     * @return carMachineNumber
     */
    public java.lang.String getCarMachineNumber() {
        return carMachineNumber;
    }


    /**
     * Sets the carMachineNumber value for this PropertyPreventWsInfo.
     * 
     * @param carMachineNumber
     */
    public void setCarMachineNumber(java.lang.String carMachineNumber) {
        this.carMachineNumber = carMachineNumber;
    }


    /**
     * Gets the carRegistNumber value for this PropertyPreventWsInfo.
     * 
     * @return carRegistNumber
     */
    public java.lang.String getCarRegistNumber() {
        return carRegistNumber;
    }


    /**
     * Sets the carRegistNumber value for this PropertyPreventWsInfo.
     * 
     * @param carRegistNumber
     */
    public void setCarRegistNumber(java.lang.String carRegistNumber) {
        this.carRegistNumber = carRegistNumber;
    }


    /**
     * Gets the id value for this PropertyPreventWsInfo.
     * 
     * @return id
     */
    public java.lang.Long getId() {
        return id;
    }


    /**
     * Sets the id value for this PropertyPreventWsInfo.
     * 
     * @param id
     */
    public void setId(java.lang.Long id) {
        this.id = id;
    }


    /**
     * Gets the landAddress value for this PropertyPreventWsInfo.
     * 
     * @return landAddress
     */
    public java.lang.String getLandAddress() {
        return landAddress;
    }


    /**
     * Sets the landAddress value for this PropertyPreventWsInfo.
     * 
     * @param landAddress
     */
    public void setLandAddress(java.lang.String landAddress) {
        this.landAddress = landAddress;
    }


    /**
     * Gets the landArea value for this PropertyPreventWsInfo.
     * 
     * @return landArea
     */
    public java.lang.String getLandArea() {
        return landArea;
    }


    /**
     * Sets the landArea value for this PropertyPreventWsInfo.
     * 
     * @param landArea
     */
    public void setLandArea(java.lang.String landArea) {
        this.landArea = landArea;
    }


    /**
     * Gets the landAssociateProperty value for this PropertyPreventWsInfo.
     * 
     * @return landAssociateProperty
     */
    public java.lang.String getLandAssociateProperty() {
        return landAssociateProperty;
    }


    /**
     * Sets the landAssociateProperty value for this PropertyPreventWsInfo.
     * 
     * @param landAssociateProperty
     */
    public void setLandAssociateProperty(java.lang.String landAssociateProperty) {
        this.landAssociateProperty = landAssociateProperty;
    }


    /**
     * Gets the landCertificate value for this PropertyPreventWsInfo.
     * 
     * @return landCertificate
     */
    public java.lang.String getLandCertificate() {
        return landCertificate;
    }


    /**
     * Sets the landCertificate value for this PropertyPreventWsInfo.
     * 
     * @param landCertificate
     */
    public void setLandCertificate(java.lang.String landCertificate) {
        this.landCertificate = landCertificate;
    }


    /**
     * Gets the landDistrict value for this PropertyPreventWsInfo.
     * 
     * @return landDistrict
     */
    public java.lang.String getLandDistrict() {
        return landDistrict;
    }


    /**
     * Sets the landDistrict value for this PropertyPreventWsInfo.
     * 
     * @param landDistrict
     */
    public void setLandDistrict(java.lang.String landDistrict) {
        this.landDistrict = landDistrict;
    }


    /**
     * Gets the landIssueDate value for this PropertyPreventWsInfo.
     * 
     * @return landIssueDate
     */
    public java.util.Calendar getLandIssueDate() {
        return landIssueDate;
    }


    /**
     * Sets the landIssueDate value for this PropertyPreventWsInfo.
     * 
     * @param landIssueDate
     */
    public void setLandIssueDate(java.util.Calendar landIssueDate) {
        this.landIssueDate = landIssueDate;
    }


    /**
     * Gets the landIssuePlace value for this PropertyPreventWsInfo.
     * 
     * @return landIssuePlace
     */
    public java.lang.String getLandIssuePlace() {
        return landIssuePlace;
    }


    /**
     * Sets the landIssuePlace value for this PropertyPreventWsInfo.
     * 
     * @param landIssuePlace
     */
    public void setLandIssuePlace(java.lang.String landIssuePlace) {
        this.landIssuePlace = landIssuePlace;
    }


    /**
     * Gets the landMapNumber value for this PropertyPreventWsInfo.
     * 
     * @return landMapNumber
     */
    public java.lang.String getLandMapNumber() {
        return landMapNumber;
    }


    /**
     * Sets the landMapNumber value for this PropertyPreventWsInfo.
     * 
     * @param landMapNumber
     */
    public void setLandMapNumber(java.lang.String landMapNumber) {
        this.landMapNumber = landMapNumber;
    }


    /**
     * Gets the landNumber value for this PropertyPreventWsInfo.
     * 
     * @return landNumber
     */
    public java.lang.String getLandNumber() {
        return landNumber;
    }


    /**
     * Sets the landNumber value for this PropertyPreventWsInfo.
     * 
     * @param landNumber
     */
    public void setLandNumber(java.lang.String landNumber) {
        this.landNumber = landNumber;
    }


    /**
     * Gets the landPrivateArea value for this PropertyPreventWsInfo.
     * 
     * @return landPrivateArea
     */
    public java.lang.String getLandPrivateArea() {
        return landPrivateArea;
    }


    /**
     * Sets the landPrivateArea value for this PropertyPreventWsInfo.
     * 
     * @param landPrivateArea
     */
    public void setLandPrivateArea(java.lang.String landPrivateArea) {
        this.landPrivateArea = landPrivateArea;
    }


    /**
     * Gets the landProvince value for this PropertyPreventWsInfo.
     * 
     * @return landProvince
     */
    public java.lang.Long getLandProvince() {
        return landProvince;
    }


    /**
     * Sets the landProvince value for this PropertyPreventWsInfo.
     * 
     * @param landProvince
     */
    public void setLandProvince(java.lang.Long landProvince) {
        this.landProvince = landProvince;
    }


    /**
     * Gets the landPublicArea value for this PropertyPreventWsInfo.
     * 
     * @return landPublicArea
     */
    public java.lang.String getLandPublicArea() {
        return landPublicArea;
    }


    /**
     * Sets the landPublicArea value for this PropertyPreventWsInfo.
     * 
     * @param landPublicArea
     */
    public void setLandPublicArea(java.lang.String landPublicArea) {
        this.landPublicArea = landPublicArea;
    }


    /**
     * Gets the landStreet value for this PropertyPreventWsInfo.
     * 
     * @return landStreet
     */
    public java.lang.String getLandStreet() {
        return landStreet;
    }


    /**
     * Sets the landStreet value for this PropertyPreventWsInfo.
     * 
     * @param landStreet
     */
    public void setLandStreet(java.lang.String landStreet) {
        this.landStreet = landStreet;
    }


    /**
     * Gets the landUseOrigin value for this PropertyPreventWsInfo.
     * 
     * @return landUseOrigin
     */
    public java.lang.String getLandUseOrigin() {
        return landUseOrigin;
    }


    /**
     * Sets the landUseOrigin value for this PropertyPreventWsInfo.
     * 
     * @param landUseOrigin
     */
    public void setLandUseOrigin(java.lang.String landUseOrigin) {
        this.landUseOrigin = landUseOrigin;
    }


    /**
     * Gets the landUsePeriod value for this PropertyPreventWsInfo.
     * 
     * @return landUsePeriod
     */
    public java.lang.String getLandUsePeriod() {
        return landUsePeriod;
    }


    /**
     * Sets the landUsePeriod value for this PropertyPreventWsInfo.
     * 
     * @param landUsePeriod
     */
    public void setLandUsePeriod(java.lang.String landUsePeriod) {
        this.landUsePeriod = landUsePeriod;
    }


    /**
     * Gets the landUsePurpose value for this PropertyPreventWsInfo.
     * 
     * @return landUsePurpose
     */
    public java.lang.String getLandUsePurpose() {
        return landUsePurpose;
    }


    /**
     * Sets the landUsePurpose value for this PropertyPreventWsInfo.
     * 
     * @param landUsePurpose
     */
    public void setLandUsePurpose(java.lang.String landUsePurpose) {
        this.landUsePurpose = landUsePurpose;
    }


    /**
     * Gets the otherInfo value for this PropertyPreventWsInfo.
     * 
     * @return otherInfo
     */
    public java.lang.String getOtherInfo() {
        return otherInfo;
    }


    /**
     * Sets the otherInfo value for this PropertyPreventWsInfo.
     * 
     * @param otherInfo
     */
    public void setOtherInfo(java.lang.String otherInfo) {
        this.otherInfo = otherInfo;
    }


    /**
     * Gets the ownerInfo value for this PropertyPreventWsInfo.
     * 
     * @return ownerInfo
     */
    public java.lang.String getOwnerInfo() {
        return ownerInfo;
    }


    /**
     * Sets the ownerInfo value for this PropertyPreventWsInfo.
     * 
     * @param ownerInfo
     */
    public void setOwnerInfo(java.lang.String ownerInfo) {
        this.ownerInfo = ownerInfo;
    }


    /**
     * Gets the propertyInfo value for this PropertyPreventWsInfo.
     * 
     * @return propertyInfo
     */
    public java.lang.String getPropertyInfo() {
        return propertyInfo;
    }


    /**
     * Sets the propertyInfo value for this PropertyPreventWsInfo.
     * 
     * @param propertyInfo
     */
    public void setPropertyInfo(java.lang.String propertyInfo) {
        this.propertyInfo = propertyInfo;
    }


    /**
     * Gets the type value for this PropertyPreventWsInfo.
     * 
     * @return type
     */
    public java.lang.String getType() {
        return type;
    }


    /**
     * Sets the type value for this PropertyPreventWsInfo.
     * 
     * @param type
     */
    public void setType(java.lang.String type) {
        this.type = type;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PropertyPreventWsInfo)) return false;
        PropertyPreventWsInfo other = (PropertyPreventWsInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.carFrameNumber==null && other.getCarFrameNumber()==null) || 
             (this.carFrameNumber!=null &&
              this.carFrameNumber.equals(other.getCarFrameNumber()))) &&
            ((this.carIssueDate==null && other.getCarIssueDate()==null) || 
             (this.carIssueDate!=null &&
              this.carIssueDate.equals(other.getCarIssueDate()))) &&
            ((this.carIssuePlace==null && other.getCarIssuePlace()==null) || 
             (this.carIssuePlace!=null &&
              this.carIssuePlace.equals(other.getCarIssuePlace()))) &&
            ((this.carLicenseNumber==null && other.getCarLicenseNumber()==null) || 
             (this.carLicenseNumber!=null &&
              this.carLicenseNumber.equals(other.getCarLicenseNumber()))) &&
            ((this.carMachineNumber==null && other.getCarMachineNumber()==null) || 
             (this.carMachineNumber!=null &&
              this.carMachineNumber.equals(other.getCarMachineNumber()))) &&
            ((this.carRegistNumber==null && other.getCarRegistNumber()==null) || 
             (this.carRegistNumber!=null &&
              this.carRegistNumber.equals(other.getCarRegistNumber()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.landAddress==null && other.getLandAddress()==null) || 
             (this.landAddress!=null &&
              this.landAddress.equals(other.getLandAddress()))) &&
            ((this.landArea==null && other.getLandArea()==null) || 
             (this.landArea!=null &&
              this.landArea.equals(other.getLandArea()))) &&
            ((this.landAssociateProperty==null && other.getLandAssociateProperty()==null) || 
             (this.landAssociateProperty!=null &&
              this.landAssociateProperty.equals(other.getLandAssociateProperty()))) &&
            ((this.landCertificate==null && other.getLandCertificate()==null) || 
             (this.landCertificate!=null &&
              this.landCertificate.equals(other.getLandCertificate()))) &&
            ((this.landDistrict==null && other.getLandDistrict()==null) || 
             (this.landDistrict!=null &&
              this.landDistrict.equals(other.getLandDistrict()))) &&
            ((this.landIssueDate==null && other.getLandIssueDate()==null) || 
             (this.landIssueDate!=null &&
              this.landIssueDate.equals(other.getLandIssueDate()))) &&
            ((this.landIssuePlace==null && other.getLandIssuePlace()==null) || 
             (this.landIssuePlace!=null &&
              this.landIssuePlace.equals(other.getLandIssuePlace()))) &&
            ((this.landMapNumber==null && other.getLandMapNumber()==null) || 
             (this.landMapNumber!=null &&
              this.landMapNumber.equals(other.getLandMapNumber()))) &&
            ((this.landNumber==null && other.getLandNumber()==null) || 
             (this.landNumber!=null &&
              this.landNumber.equals(other.getLandNumber()))) &&
            ((this.landPrivateArea==null && other.getLandPrivateArea()==null) || 
             (this.landPrivateArea!=null &&
              this.landPrivateArea.equals(other.getLandPrivateArea()))) &&
            ((this.landProvince==null && other.getLandProvince()==null) || 
             (this.landProvince!=null &&
              this.landProvince.equals(other.getLandProvince()))) &&
            ((this.landPublicArea==null && other.getLandPublicArea()==null) || 
             (this.landPublicArea!=null &&
              this.landPublicArea.equals(other.getLandPublicArea()))) &&
            ((this.landStreet==null && other.getLandStreet()==null) || 
             (this.landStreet!=null &&
              this.landStreet.equals(other.getLandStreet()))) &&
            ((this.landUseOrigin==null && other.getLandUseOrigin()==null) || 
             (this.landUseOrigin!=null &&
              this.landUseOrigin.equals(other.getLandUseOrigin()))) &&
            ((this.landUsePeriod==null && other.getLandUsePeriod()==null) || 
             (this.landUsePeriod!=null &&
              this.landUsePeriod.equals(other.getLandUsePeriod()))) &&
            ((this.landUsePurpose==null && other.getLandUsePurpose()==null) || 
             (this.landUsePurpose!=null &&
              this.landUsePurpose.equals(other.getLandUsePurpose()))) &&
            ((this.otherInfo==null && other.getOtherInfo()==null) || 
             (this.otherInfo!=null &&
              this.otherInfo.equals(other.getOtherInfo()))) &&
            ((this.ownerInfo==null && other.getOwnerInfo()==null) || 
             (this.ownerInfo!=null &&
              this.ownerInfo.equals(other.getOwnerInfo()))) &&
            ((this.propertyInfo==null && other.getPropertyInfo()==null) || 
             (this.propertyInfo!=null &&
              this.propertyInfo.equals(other.getPropertyInfo()))) &&
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
        if (getCarFrameNumber() != null) {
            _hashCode += getCarFrameNumber().hashCode();
        }
        if (getCarIssueDate() != null) {
            _hashCode += getCarIssueDate().hashCode();
        }
        if (getCarIssuePlace() != null) {
            _hashCode += getCarIssuePlace().hashCode();
        }
        if (getCarLicenseNumber() != null) {
            _hashCode += getCarLicenseNumber().hashCode();
        }
        if (getCarMachineNumber() != null) {
            _hashCode += getCarMachineNumber().hashCode();
        }
        if (getCarRegistNumber() != null) {
            _hashCode += getCarRegistNumber().hashCode();
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getLandAddress() != null) {
            _hashCode += getLandAddress().hashCode();
        }
        if (getLandArea() != null) {
            _hashCode += getLandArea().hashCode();
        }
        if (getLandAssociateProperty() != null) {
            _hashCode += getLandAssociateProperty().hashCode();
        }
        if (getLandCertificate() != null) {
            _hashCode += getLandCertificate().hashCode();
        }
        if (getLandDistrict() != null) {
            _hashCode += getLandDistrict().hashCode();
        }
        if (getLandIssueDate() != null) {
            _hashCode += getLandIssueDate().hashCode();
        }
        if (getLandIssuePlace() != null) {
            _hashCode += getLandIssuePlace().hashCode();
        }
        if (getLandMapNumber() != null) {
            _hashCode += getLandMapNumber().hashCode();
        }
        if (getLandNumber() != null) {
            _hashCode += getLandNumber().hashCode();
        }
        if (getLandPrivateArea() != null) {
            _hashCode += getLandPrivateArea().hashCode();
        }
        if (getLandProvince() != null) {
            _hashCode += getLandProvince().hashCode();
        }
        if (getLandPublicArea() != null) {
            _hashCode += getLandPublicArea().hashCode();
        }
        if (getLandStreet() != null) {
            _hashCode += getLandStreet().hashCode();
        }
        if (getLandUseOrigin() != null) {
            _hashCode += getLandUseOrigin().hashCode();
        }
        if (getLandUsePeriod() != null) {
            _hashCode += getLandUsePeriod().hashCode();
        }
        if (getLandUsePurpose() != null) {
            _hashCode += getLandUsePurpose().hashCode();
        }
        if (getOtherInfo() != null) {
            _hashCode += getOtherInfo().hashCode();
        }
        if (getOwnerInfo() != null) {
            _hashCode += getOwnerInfo().hashCode();
        }
        if (getPropertyInfo() != null) {
            _hashCode += getPropertyInfo().hashCode();
        }
        if (getType() != null) {
            _hashCode += getType().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PropertyPreventWsInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ws.npo.osp.com/", "propertyPreventWsInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("carFrameNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "carFrameNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("carIssueDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "carIssueDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("carIssuePlace");
        elemField.setXmlName(new javax.xml.namespace.QName("", "carIssuePlace"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("carLicenseNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "carLicenseNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("carMachineNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "carMachineNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("carRegistNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "carRegistNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("landAddress");
        elemField.setXmlName(new javax.xml.namespace.QName("", "landAddress"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("landArea");
        elemField.setXmlName(new javax.xml.namespace.QName("", "landArea"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("landAssociateProperty");
        elemField.setXmlName(new javax.xml.namespace.QName("", "landAssociateProperty"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("landCertificate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "landCertificate"));
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
        elemField.setFieldName("landIssueDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "landIssueDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("landIssuePlace");
        elemField.setXmlName(new javax.xml.namespace.QName("", "landIssuePlace"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("landMapNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "landMapNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("landNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "landNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("landPrivateArea");
        elemField.setXmlName(new javax.xml.namespace.QName("", "landPrivateArea"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("landProvince");
        elemField.setXmlName(new javax.xml.namespace.QName("", "landProvince"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("landPublicArea");
        elemField.setXmlName(new javax.xml.namespace.QName("", "landPublicArea"));
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
        elemField.setFieldName("landUseOrigin");
        elemField.setXmlName(new javax.xml.namespace.QName("", "landUseOrigin"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("landUsePeriod");
        elemField.setXmlName(new javax.xml.namespace.QName("", "landUsePeriod"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("landUsePurpose");
        elemField.setXmlName(new javax.xml.namespace.QName("", "landUsePurpose"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("otherInfo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "otherInfo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ownerInfo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ownerInfo"));
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
