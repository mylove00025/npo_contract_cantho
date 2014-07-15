/**
 * DataPreventWsInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.osp.npo.core.preventws;

import com.osp.npo.common.global.Constants;
import com.osp.npo.common.util.EditString;
import com.osp.npo.common.util.SystemMessageProperties;

public class DataPreventWsInfo  extends com.osp.npo.core.AbstractWsInfo  implements java.io.Serializable {
    private java.lang.String carFrameNumber;

    private java.util.Calendar carIssueDate;

    private java.lang.String carIssuePlace;

    private java.lang.String carLicenseNumber;

    private java.lang.String carMachineNumber;

    private java.lang.String carRegistNumber;

    private java.lang.Boolean deleteFlg;

    private java.lang.Long id;

    private java.lang.String landAddress;

    private java.lang.String landArea;

    private java.lang.String landAssociateProperty;

    private java.lang.String landCertificate;

    private java.lang.Long landDistrict;

    private java.util.Calendar landIssueDate;

    private java.lang.String landIssuePlace;

    private java.lang.String landMapNumber;

    private java.lang.String landNumber;

    private java.lang.String landPrivateArea;

    private java.lang.Long landProvince;

    private java.lang.String landPublicArea;

    private java.lang.String landUseOrigin;

    private java.lang.String landUsePeriod;

    private java.lang.String landUsePurpose;

    private java.lang.String originKind;

    private java.lang.String otherInfo;

    private java.lang.String ownerInfo;

    private java.util.Calendar preventDocDate;

    private java.lang.String preventDocNumber;

    private java.util.Calendar preventDocReceiveDate;

    private java.lang.String preventDocSummary;

    private java.lang.String preventFileName;

    private java.lang.String preventFilePath;

    private java.lang.String preventInBookNumber;

    private java.util.Calendar preventInputDate;

    private java.lang.String preventNote;

    private java.lang.String preventPersonInfo;

    private java.lang.String preventRegistAgency;

    private java.lang.Long propertyId;

    private java.lang.String propertyInfo;

    private java.util.Calendar releaseDocDate;

    private java.lang.String releaseDocNumber;

    private java.util.Calendar releaseDocReceiveDate;

    private java.lang.String releaseDocSummary;

    private java.lang.String releaseFileName;

    private java.lang.String releaseFilePath;

    private java.lang.Boolean releaseFlg;

    private java.lang.String releaseInBookNumber;

    private java.util.Calendar releaseInputDate;

    private java.lang.String releaseNote;

    private java.lang.String releasePersonInfo;

    private java.lang.String releaseRegistAgency;

    private java.lang.String synchronizeId;

    private java.lang.String type;

    public DataPreventWsInfo() {
    }

    public DataPreventWsInfo(
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
           java.lang.Boolean deleteFlg,
           java.lang.Long id,
           java.lang.String landAddress,
           java.lang.String landArea,
           java.lang.String landAssociateProperty,
           java.lang.String landCertificate,
           java.lang.Long landDistrict,
           java.util.Calendar landIssueDate,
           java.lang.String landIssuePlace,
           java.lang.String landMapNumber,
           java.lang.String landNumber,
           java.lang.String landPrivateArea,
           java.lang.Long landProvince,
           java.lang.String landPublicArea,
           java.lang.String landUseOrigin,
           java.lang.String landUsePeriod,
           java.lang.String landUsePurpose,
           java.lang.String originKind,
           java.lang.String otherInfo,
           java.lang.String ownerInfo,
           java.util.Calendar preventDocDate,
           java.lang.String preventDocNumber,
           java.util.Calendar preventDocReceiveDate,
           java.lang.String preventDocSummary,
           java.lang.String preventFileName,
           java.lang.String preventFilePath,
           java.lang.String preventInBookNumber,
           java.util.Calendar preventInputDate,
           java.lang.String preventNote,
           java.lang.String preventPersonInfo,
           java.lang.String preventRegistAgency,
           java.lang.Long propertyId,
           java.lang.String propertyInfo,
           java.util.Calendar releaseDocDate,
           java.lang.String releaseDocNumber,
           java.util.Calendar releaseDocReceiveDate,
           java.lang.String releaseDocSummary,
           java.lang.String releaseFileName,
           java.lang.String releaseFilePath,
           java.lang.Boolean releaseFlg,
           java.lang.String releaseInBookNumber,
           java.util.Calendar releaseInputDate,
           java.lang.String releaseNote,
           java.lang.String releasePersonInfo,
           java.lang.String releaseRegistAgency,
           java.lang.String synchronizeId,
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
        this.deleteFlg = deleteFlg;
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
        this.landUseOrigin = landUseOrigin;
        this.landUsePeriod = landUsePeriod;
        this.landUsePurpose = landUsePurpose;
        this.originKind = originKind;
        this.otherInfo = otherInfo;
        this.ownerInfo = ownerInfo;
        this.preventDocDate = preventDocDate;
        this.preventDocNumber = preventDocNumber;
        this.preventDocReceiveDate = preventDocReceiveDate;
        this.preventDocSummary = preventDocSummary;
        this.preventFileName = preventFileName;
        this.preventFilePath = preventFilePath;
        this.preventInBookNumber = preventInBookNumber;
        this.preventInputDate = preventInputDate;
        this.preventNote = preventNote;
        this.preventPersonInfo = preventPersonInfo;
        this.preventRegistAgency = preventRegistAgency;
        this.propertyId = propertyId;
        this.propertyInfo = propertyInfo;
        this.releaseDocDate = releaseDocDate;
        this.releaseDocNumber = releaseDocNumber;
        this.releaseDocReceiveDate = releaseDocReceiveDate;
        this.releaseDocSummary = releaseDocSummary;
        this.releaseFileName = releaseFileName;
        this.releaseFilePath = releaseFilePath;
        this.releaseFlg = releaseFlg;
        this.releaseInBookNumber = releaseInBookNumber;
        this.releaseInputDate = releaseInputDate;
        this.releaseNote = releaseNote;
        this.releasePersonInfo = releasePersonInfo;
        this.releaseRegistAgency = releaseRegistAgency;
        this.synchronizeId = synchronizeId;
        this.type = type;
    }


    /**
     * Gets the carFrameNumber value for this DataPreventWsInfo.
     * 
     * @return carFrameNumber
     */
    public java.lang.String getCarFrameNumber() {
        return carFrameNumber;
    }


    /**
     * Sets the carFrameNumber value for this DataPreventWsInfo.
     * 
     * @param carFrameNumber
     */
    public void setCarFrameNumber(java.lang.String carFrameNumber) {
        this.carFrameNumber = carFrameNumber;
    }


    /**
     * Gets the carIssueDate value for this DataPreventWsInfo.
     * 
     * @return carIssueDate
     */
    public java.util.Calendar getCarIssueDate() {
        return carIssueDate;
    }


    /**
     * Sets the carIssueDate value for this DataPreventWsInfo.
     * 
     * @param carIssueDate
     */
    public void setCarIssueDate(java.util.Calendar carIssueDate) {
        this.carIssueDate = carIssueDate;
    }


    /**
     * Gets the carIssuePlace value for this DataPreventWsInfo.
     * 
     * @return carIssuePlace
     */
    public java.lang.String getCarIssuePlace() {
        return carIssuePlace;
    }


    /**
     * Sets the carIssuePlace value for this DataPreventWsInfo.
     * 
     * @param carIssuePlace
     */
    public void setCarIssuePlace(java.lang.String carIssuePlace) {
        this.carIssuePlace = carIssuePlace;
    }


    /**
     * Gets the carLicenseNumber value for this DataPreventWsInfo.
     * 
     * @return carLicenseNumber
     */
    public java.lang.String getCarLicenseNumber() {
        return carLicenseNumber;
    }


    /**
     * Sets the carLicenseNumber value for this DataPreventWsInfo.
     * 
     * @param carLicenseNumber
     */
    public void setCarLicenseNumber(java.lang.String carLicenseNumber) {
        this.carLicenseNumber = carLicenseNumber;
    }


    /**
     * Gets the carMachineNumber value for this DataPreventWsInfo.
     * 
     * @return carMachineNumber
     */
    public java.lang.String getCarMachineNumber() {
        return carMachineNumber;
    }


    /**
     * Sets the carMachineNumber value for this DataPreventWsInfo.
     * 
     * @param carMachineNumber
     */
    public void setCarMachineNumber(java.lang.String carMachineNumber) {
        this.carMachineNumber = carMachineNumber;
    }


    /**
     * Gets the carRegistNumber value for this DataPreventWsInfo.
     * 
     * @return carRegistNumber
     */
    public java.lang.String getCarRegistNumber() {
        return carRegistNumber;
    }


    /**
     * Sets the carRegistNumber value for this DataPreventWsInfo.
     * 
     * @param carRegistNumber
     */
    public void setCarRegistNumber(java.lang.String carRegistNumber) {
        this.carRegistNumber = carRegistNumber;
    }


    /**
     * Gets the deleteFlg value for this DataPreventWsInfo.
     * 
     * @return deleteFlg
     */
    public java.lang.Boolean getDeleteFlg() {
        return deleteFlg;
    }


    /**
     * Sets the deleteFlg value for this DataPreventWsInfo.
     * 
     * @param deleteFlg
     */
    public void setDeleteFlg(java.lang.Boolean deleteFlg) {
        this.deleteFlg = deleteFlg;
    }


    /**
     * Gets the id value for this DataPreventWsInfo.
     * 
     * @return id
     */
    public java.lang.Long getId() {
        return id;
    }


    /**
     * Sets the id value for this DataPreventWsInfo.
     * 
     * @param id
     */
    public void setId(java.lang.Long id) {
        this.id = id;
    }


    /**
     * Gets the landAddress value for this DataPreventWsInfo.
     * 
     * @return landAddress
     */
    public java.lang.String getLandAddress() {
        return landAddress;
    }


    /**
     * Sets the landAddress value for this DataPreventWsInfo.
     * 
     * @param landAddress
     */
    public void setLandAddress(java.lang.String landAddress) {
        this.landAddress = landAddress;
    }


    /**
     * Gets the landArea value for this DataPreventWsInfo.
     * 
     * @return landArea
     */
    public java.lang.String getLandArea() {
        return landArea;
    }


    /**
     * Sets the landArea value for this DataPreventWsInfo.
     * 
     * @param landArea
     */
    public void setLandArea(java.lang.String landArea) {
        this.landArea = landArea;
    }


    /**
     * Gets the landAssociateProperty value for this DataPreventWsInfo.
     * 
     * @return landAssociateProperty
     */
    public java.lang.String getLandAssociateProperty() {
        return landAssociateProperty;
    }


    /**
     * Sets the landAssociateProperty value for this DataPreventWsInfo.
     * 
     * @param landAssociateProperty
     */
    public void setLandAssociateProperty(java.lang.String landAssociateProperty) {
        this.landAssociateProperty = landAssociateProperty;
    }


    /**
     * Gets the landCertificate value for this DataPreventWsInfo.
     * 
     * @return landCertificate
     */
    public java.lang.String getLandCertificate() {
        return landCertificate;
    }


    /**
     * Sets the landCertificate value for this DataPreventWsInfo.
     * 
     * @param landCertificate
     */
    public void setLandCertificate(java.lang.String landCertificate) {
        this.landCertificate = landCertificate;
    }


    /**
     * Gets the landDistrict value for this DataPreventWsInfo.
     * 
     * @return landDistrict
     */
    public java.lang.Long getLandDistrict() {
        return landDistrict;
    }


    /**
     * Sets the landDistrict value for this DataPreventWsInfo.
     * 
     * @param landDistrict
     */
    public void setLandDistrict(java.lang.Long landDistrict) {
        this.landDistrict = landDistrict;
    }


    /**
     * Gets the landIssueDate value for this DataPreventWsInfo.
     * 
     * @return landIssueDate
     */
    public java.util.Calendar getLandIssueDate() {
        return landIssueDate;
    }


    /**
     * Sets the landIssueDate value for this DataPreventWsInfo.
     * 
     * @param landIssueDate
     */
    public void setLandIssueDate(java.util.Calendar landIssueDate) {
        this.landIssueDate = landIssueDate;
    }


    /**
     * Gets the landIssuePlace value for this DataPreventWsInfo.
     * 
     * @return landIssuePlace
     */
    public java.lang.String getLandIssuePlace() {
        return landIssuePlace;
    }


    /**
     * Sets the landIssuePlace value for this DataPreventWsInfo.
     * 
     * @param landIssuePlace
     */
    public void setLandIssuePlace(java.lang.String landIssuePlace) {
        this.landIssuePlace = landIssuePlace;
    }


    /**
     * Gets the landMapNumber value for this DataPreventWsInfo.
     * 
     * @return landMapNumber
     */
    public java.lang.String getLandMapNumber() {
        return landMapNumber;
    }


    /**
     * Sets the landMapNumber value for this DataPreventWsInfo.
     * 
     * @param landMapNumber
     */
    public void setLandMapNumber(java.lang.String landMapNumber) {
        this.landMapNumber = landMapNumber;
    }


    /**
     * Gets the landNumber value for this DataPreventWsInfo.
     * 
     * @return landNumber
     */
    public java.lang.String getLandNumber() {
        return landNumber;
    }


    /**
     * Sets the landNumber value for this DataPreventWsInfo.
     * 
     * @param landNumber
     */
    public void setLandNumber(java.lang.String landNumber) {
        this.landNumber = landNumber;
    }


    /**
     * Gets the landPrivateArea value for this DataPreventWsInfo.
     * 
     * @return landPrivateArea
     */
    public java.lang.String getLandPrivateArea() {
        return landPrivateArea;
    }


    /**
     * Sets the landPrivateArea value for this DataPreventWsInfo.
     * 
     * @param landPrivateArea
     */
    public void setLandPrivateArea(java.lang.String landPrivateArea) {
        this.landPrivateArea = landPrivateArea;
    }


    /**
     * Gets the landProvince value for this DataPreventWsInfo.
     * 
     * @return landProvince
     */
    public java.lang.Long getLandProvince() {
        return landProvince;
    }


    /**
     * Sets the landProvince value for this DataPreventWsInfo.
     * 
     * @param landProvince
     */
    public void setLandProvince(java.lang.Long landProvince) {
        this.landProvince = landProvince;
    }


    /**
     * Gets the landPublicArea value for this DataPreventWsInfo.
     * 
     * @return landPublicArea
     */
    public java.lang.String getLandPublicArea() {
        return landPublicArea;
    }


    /**
     * Sets the landPublicArea value for this DataPreventWsInfo.
     * 
     * @param landPublicArea
     */
    public void setLandPublicArea(java.lang.String landPublicArea) {
        this.landPublicArea = landPublicArea;
    }


    /**
     * Gets the landUseOrigin value for this DataPreventWsInfo.
     * 
     * @return landUseOrigin
     */
    public java.lang.String getLandUseOrigin() {
        return landUseOrigin;
    }


    /**
     * Sets the landUseOrigin value for this DataPreventWsInfo.
     * 
     * @param landUseOrigin
     */
    public void setLandUseOrigin(java.lang.String landUseOrigin) {
        this.landUseOrigin = landUseOrigin;
    }


    /**
     * Gets the landUsePeriod value for this DataPreventWsInfo.
     * 
     * @return landUsePeriod
     */
    public java.lang.String getLandUsePeriod() {
        return landUsePeriod;
    }


    /**
     * Sets the landUsePeriod value for this DataPreventWsInfo.
     * 
     * @param landUsePeriod
     */
    public void setLandUsePeriod(java.lang.String landUsePeriod) {
        this.landUsePeriod = landUsePeriod;
    }


    /**
     * Gets the landUsePurpose value for this DataPreventWsInfo.
     * 
     * @return landUsePurpose
     */
    public java.lang.String getLandUsePurpose() {
        return landUsePurpose;
    }


    /**
     * Sets the landUsePurpose value for this DataPreventWsInfo.
     * 
     * @param landUsePurpose
     */
    public void setLandUsePurpose(java.lang.String landUsePurpose) {
        this.landUsePurpose = landUsePurpose;
    }


    /**
     * Gets the originKind value for this DataPreventWsInfo.
     * 
     * @return originKind
     */
    public java.lang.String getOriginKind() {
        return originKind;
    }


    /**
     * Sets the originKind value for this DataPreventWsInfo.
     * 
     * @param originKind
     */
    public void setOriginKind(java.lang.String originKind) {
        this.originKind = originKind;
    }


    /**
     * Gets the otherInfo value for this DataPreventWsInfo.
     * 
     * @return otherInfo
     */
    public java.lang.String getOtherInfo() {
        return otherInfo;
    }


    /**
     * Sets the otherInfo value for this DataPreventWsInfo.
     * 
     * @param otherInfo
     */
    public void setOtherInfo(java.lang.String otherInfo) {
        this.otherInfo = otherInfo;
    }


    /**
     * Gets the ownerInfo value for this DataPreventWsInfo.
     * 
     * @return ownerInfo
     */
    public java.lang.String getOwnerInfo() {
        return ownerInfo;
    }


    /**
     * Sets the ownerInfo value for this DataPreventWsInfo.
     * 
     * @param ownerInfo
     */
    public void setOwnerInfo(java.lang.String ownerInfo) {
        this.ownerInfo = ownerInfo;
    }


    /**
     * Gets the preventDocDate value for this DataPreventWsInfo.
     * 
     * @return preventDocDate
     */
    public java.util.Calendar getPreventDocDate() {
        return preventDocDate;
    }


    /**
     * Sets the preventDocDate value for this DataPreventWsInfo.
     * 
     * @param preventDocDate
     */
    public void setPreventDocDate(java.util.Calendar preventDocDate) {
        this.preventDocDate = preventDocDate;
    }


    /**
     * Gets the preventDocNumber value for this DataPreventWsInfo.
     * 
     * @return preventDocNumber
     */
    public java.lang.String getPreventDocNumber() {
        return preventDocNumber;
    }


    /**
     * Sets the preventDocNumber value for this DataPreventWsInfo.
     * 
     * @param preventDocNumber
     */
    public void setPreventDocNumber(java.lang.String preventDocNumber) {
        this.preventDocNumber = preventDocNumber;
    }


    /**
     * Gets the preventDocReceiveDate value for this DataPreventWsInfo.
     * 
     * @return preventDocReceiveDate
     */
    public java.util.Calendar getPreventDocReceiveDate() {
        return preventDocReceiveDate;
    }


    /**
     * Sets the preventDocReceiveDate value for this DataPreventWsInfo.
     * 
     * @param preventDocReceiveDate
     */
    public void setPreventDocReceiveDate(java.util.Calendar preventDocReceiveDate) {
        this.preventDocReceiveDate = preventDocReceiveDate;
    }


    /**
     * Gets the preventDocSummary value for this DataPreventWsInfo.
     * 
     * @return preventDocSummary
     */
    public java.lang.String getPreventDocSummary() {
        return preventDocSummary;
    }


    /**
     * Sets the preventDocSummary value for this DataPreventWsInfo.
     * 
     * @param preventDocSummary
     */
    public void setPreventDocSummary(java.lang.String preventDocSummary) {
        this.preventDocSummary = preventDocSummary;
    }


    /**
     * Gets the preventFileName value for this DataPreventWsInfo.
     * 
     * @return preventFileName
     */
    public java.lang.String getPreventFileName() {
        return preventFileName;
    }


    /**
     * Sets the preventFileName value for this DataPreventWsInfo.
     * 
     * @param preventFileName
     */
    public void setPreventFileName(java.lang.String preventFileName) {
        this.preventFileName = preventFileName;
    }


    /**
     * Gets the preventFilePath value for this DataPreventWsInfo.
     * 
     * @return preventFilePath
     */
    public java.lang.String getPreventFilePath() {
        return preventFilePath;
    }


    /**
     * Sets the preventFilePath value for this DataPreventWsInfo.
     * 
     * @param preventFilePath
     */
    public void setPreventFilePath(java.lang.String preventFilePath) {
        this.preventFilePath = preventFilePath;
    }


    /**
     * Gets the preventInBookNumber value for this DataPreventWsInfo.
     * 
     * @return preventInBookNumber
     */
    public java.lang.String getPreventInBookNumber() {
        return preventInBookNumber;
    }


    /**
     * Sets the preventInBookNumber value for this DataPreventWsInfo.
     * 
     * @param preventInBookNumber
     */
    public void setPreventInBookNumber(java.lang.String preventInBookNumber) {
        this.preventInBookNumber = preventInBookNumber;
    }


    /**
     * Gets the preventInputDate value for this DataPreventWsInfo.
     * 
     * @return preventInputDate
     */
    public java.util.Calendar getPreventInputDate() {
        return preventInputDate;
    }


    /**
     * Sets the preventInputDate value for this DataPreventWsInfo.
     * 
     * @param preventInputDate
     */
    public void setPreventInputDate(java.util.Calendar preventInputDate) {
        this.preventInputDate = preventInputDate;
    }


    /**
     * Gets the preventNote value for this DataPreventWsInfo.
     * 
     * @return preventNote
     */
    public java.lang.String getPreventNote() {
        return preventNote;
    }


    /**
     * Sets the preventNote value for this DataPreventWsInfo.
     * 
     * @param preventNote
     */
    public void setPreventNote(java.lang.String preventNote) {
        this.preventNote = preventNote;
    }


    /**
     * Gets the preventPersonInfo value for this DataPreventWsInfo.
     * 
     * @return preventPersonInfo
     */
    public java.lang.String getPreventPersonInfo() {
        return preventPersonInfo;
    }


    /**
     * Sets the preventPersonInfo value for this DataPreventWsInfo.
     * 
     * @param preventPersonInfo
     */
    public void setPreventPersonInfo(java.lang.String preventPersonInfo) {
        this.preventPersonInfo = preventPersonInfo;
    }


    /**
     * Gets the preventRegistAgency value for this DataPreventWsInfo.
     * 
     * @return preventRegistAgency
     */
    public java.lang.String getPreventRegistAgency() {
        return preventRegistAgency;
    }


    /**
     * Sets the preventRegistAgency value for this DataPreventWsInfo.
     * 
     * @param preventRegistAgency
     */
    public void setPreventRegistAgency(java.lang.String preventRegistAgency) {
        this.preventRegistAgency = preventRegistAgency;
    }


    /**
     * Gets the propertyId value for this DataPreventWsInfo.
     * 
     * @return propertyId
     */
    public java.lang.Long getPropertyId() {
        return propertyId;
    }


    /**
     * Sets the propertyId value for this DataPreventWsInfo.
     * 
     * @param propertyId
     */
    public void setPropertyId(java.lang.Long propertyId) {
        this.propertyId = propertyId;
    }


    /**
     * Gets the propertyInfo value for this DataPreventWsInfo.
     * 
     * @return propertyInfo
     */
    public java.lang.String getPropertyInfo() {
        return propertyInfo;
    }

    /**
     * Get the propertyInfoDisp
     *
     * @return the propertyInfoDisp
     */
    public String getPropertyInfoDisp() {
        return EditString.replaceChangeLine(propertyInfo);
    }

    /**
     * Sets the propertyInfo value for this DataPreventWsInfo.
     * 
     * @param propertyInfo
     */
    public void setPropertyInfo(java.lang.String propertyInfo) {
        this.propertyInfo = propertyInfo;
    }


    /**
     * Gets the releaseDocDate value for this DataPreventWsInfo.
     * 
     * @return releaseDocDate
     */
    public java.util.Calendar getReleaseDocDate() {
        return releaseDocDate;
    }


    /**
     * Sets the releaseDocDate value for this DataPreventWsInfo.
     * 
     * @param releaseDocDate
     */
    public void setReleaseDocDate(java.util.Calendar releaseDocDate) {
        this.releaseDocDate = releaseDocDate;
    }


    /**
     * Gets the releaseDocNumber value for this DataPreventWsInfo.
     * 
     * @return releaseDocNumber
     */
    public java.lang.String getReleaseDocNumber() {
        return releaseDocNumber;
    }


    /**
     * Sets the releaseDocNumber value for this DataPreventWsInfo.
     * 
     * @param releaseDocNumber
     */
    public void setReleaseDocNumber(java.lang.String releaseDocNumber) {
        this.releaseDocNumber = releaseDocNumber;
    }


    /**
     * Gets the releaseDocReceiveDate value for this DataPreventWsInfo.
     * 
     * @return releaseDocReceiveDate
     */
    public java.util.Calendar getReleaseDocReceiveDate() {
        return releaseDocReceiveDate;
    }


    /**
     * Sets the releaseDocReceiveDate value for this DataPreventWsInfo.
     * 
     * @param releaseDocReceiveDate
     */
    public void setReleaseDocReceiveDate(java.util.Calendar releaseDocReceiveDate) {
        this.releaseDocReceiveDate = releaseDocReceiveDate;
    }


    /**
     * Gets the releaseDocSummary value for this DataPreventWsInfo.
     * 
     * @return releaseDocSummary
     */
    public java.lang.String getReleaseDocSummary() {
        return releaseDocSummary;
    }


    /**
     * Sets the releaseDocSummary value for this DataPreventWsInfo.
     * 
     * @param releaseDocSummary
     */
    public void setReleaseDocSummary(java.lang.String releaseDocSummary) {
        this.releaseDocSummary = releaseDocSummary;
    }


    /**
     * Gets the releaseFileName value for this DataPreventWsInfo.
     * 
     * @return releaseFileName
     */
    public java.lang.String getReleaseFileName() {
        return releaseFileName;
    }


    /**
     * Sets the releaseFileName value for this DataPreventWsInfo.
     * 
     * @param releaseFileName
     */
    public void setReleaseFileName(java.lang.String releaseFileName) {
        this.releaseFileName = releaseFileName;
    }


    /**
     * Gets the releaseFilePath value for this DataPreventWsInfo.
     * 
     * @return releaseFilePath
     */
    public java.lang.String getReleaseFilePath() {
        return releaseFilePath;
    }


    /**
     * Sets the releaseFilePath value for this DataPreventWsInfo.
     * 
     * @param releaseFilePath
     */
    public void setReleaseFilePath(java.lang.String releaseFilePath) {
        this.releaseFilePath = releaseFilePath;
    }


    /**
     * Gets the releaseFlg value for this DataPreventWsInfo.
     * 
     * @return releaseFlg
     */
    public java.lang.Boolean getReleaseFlg() {
        return releaseFlg;
    }


    /**
     * Sets the releaseFlg value for this DataPreventWsInfo.
     * 
     * @param releaseFlg
     */
    public void setReleaseFlg(java.lang.Boolean releaseFlg) {
        this.releaseFlg = releaseFlg;
    }


    /**
     * Gets the releaseInBookNumber value for this DataPreventWsInfo.
     * 
     * @return releaseInBookNumber
     */
    public java.lang.String getReleaseInBookNumber() {
        return releaseInBookNumber;
    }


    /**
     * Sets the releaseInBookNumber value for this DataPreventWsInfo.
     * 
     * @param releaseInBookNumber
     */
    public void setReleaseInBookNumber(java.lang.String releaseInBookNumber) {
        this.releaseInBookNumber = releaseInBookNumber;
    }


    /**
     * Gets the releaseInputDate value for this DataPreventWsInfo.
     * 
     * @return releaseInputDate
     */
    public java.util.Calendar getReleaseInputDate() {
        return releaseInputDate;
    }


    /**
     * Sets the releaseInputDate value for this DataPreventWsInfo.
     * 
     * @param releaseInputDate
     */
    public void setReleaseInputDate(java.util.Calendar releaseInputDate) {
        this.releaseInputDate = releaseInputDate;
    }


    /**
     * Gets the releaseNote value for this DataPreventWsInfo.
     * 
     * @return releaseNote
     */
    public java.lang.String getReleaseNote() {
        return releaseNote;
    }


    /**
     * Sets the releaseNote value for this DataPreventWsInfo.
     * 
     * @param releaseNote
     */
    public void setReleaseNote(java.lang.String releaseNote) {
        this.releaseNote = releaseNote;
    }


    /**
     * Gets the releasePersonInfo value for this DataPreventWsInfo.
     * 
     * @return releasePersonInfo
     */
    public java.lang.String getReleasePersonInfo() {
        return releasePersonInfo;
    }


    /**
     * Sets the releasePersonInfo value for this DataPreventWsInfo.
     * 
     * @param releasePersonInfo
     */
    public void setReleasePersonInfo(java.lang.String releasePersonInfo) {
        this.releasePersonInfo = releasePersonInfo;
    }


    /**
     * Gets the releaseRegistAgency value for this DataPreventWsInfo.
     * 
     * @return releaseRegistAgency
     */
    public java.lang.String getReleaseRegistAgency() {
        return releaseRegistAgency;
    }


    /**
     * Sets the releaseRegistAgency value for this DataPreventWsInfo.
     * 
     * @param releaseRegistAgency
     */
    public void setReleaseRegistAgency(java.lang.String releaseRegistAgency) {
        this.releaseRegistAgency = releaseRegistAgency;
    }


    /**
     * Gets the synchronizeId value for this DataPreventWsInfo.
     * 
     * @return synchronizeId
     */
    public java.lang.String getSynchronizeId() {
        return synchronizeId;
    }


    /**
     * Sets the synchronizeId value for this DataPreventWsInfo.
     * 
     * @param synchronizeId
     */
    public void setSynchronizeId(java.lang.String synchronizeId) {
        this.synchronizeId = synchronizeId;
    }


    /**
     * Gets the type value for this DataPreventWsInfo.
     * 
     * @return type
     */
    public java.lang.String getType() {
        return type;
    }


    /**
     * Sets the type value for this DataPreventWsInfo.
     * 
     * @param type
     */
    public void setType(java.lang.String type) {
        this.type = type;
    }
    
    /**
     * <P>Get the info </P>
     *
     * @return info
     */
    public String getInfo() {
        String info = "";
        info += propertyInfo;
        if (!EditString.isNull(ownerInfo)) {
            info += Constants.ENTER + SystemMessageProperties.getSystemProperty("item_owner")
                + Constants.COLON + Constants.SPACE + ownerInfo;
        }
        if (!EditString.isNull(otherInfo)) {
            info += Constants.ENTER + SystemMessageProperties.getSystemProperty("item_other_info")
                + Constants.COLON + Constants.SPACE + otherInfo;
        }
        return EditString.replaceChangeLine(info);
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DataPreventWsInfo)) return false;
        DataPreventWsInfo other = (DataPreventWsInfo) obj;
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
            ((this.deleteFlg==null && other.getDeleteFlg()==null) || 
             (this.deleteFlg!=null &&
              this.deleteFlg.equals(other.getDeleteFlg()))) &&
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
            ((this.landUseOrigin==null && other.getLandUseOrigin()==null) || 
             (this.landUseOrigin!=null &&
              this.landUseOrigin.equals(other.getLandUseOrigin()))) &&
            ((this.landUsePeriod==null && other.getLandUsePeriod()==null) || 
             (this.landUsePeriod!=null &&
              this.landUsePeriod.equals(other.getLandUsePeriod()))) &&
            ((this.landUsePurpose==null && other.getLandUsePurpose()==null) || 
             (this.landUsePurpose!=null &&
              this.landUsePurpose.equals(other.getLandUsePurpose()))) &&
            ((this.originKind==null && other.getOriginKind()==null) || 
             (this.originKind!=null &&
              this.originKind.equals(other.getOriginKind()))) &&
            ((this.otherInfo==null && other.getOtherInfo()==null) || 
             (this.otherInfo!=null &&
              this.otherInfo.equals(other.getOtherInfo()))) &&
            ((this.ownerInfo==null && other.getOwnerInfo()==null) || 
             (this.ownerInfo!=null &&
              this.ownerInfo.equals(other.getOwnerInfo()))) &&
            ((this.preventDocDate==null && other.getPreventDocDate()==null) || 
             (this.preventDocDate!=null &&
              this.preventDocDate.equals(other.getPreventDocDate()))) &&
            ((this.preventDocNumber==null && other.getPreventDocNumber()==null) || 
             (this.preventDocNumber!=null &&
              this.preventDocNumber.equals(other.getPreventDocNumber()))) &&
            ((this.preventDocReceiveDate==null && other.getPreventDocReceiveDate()==null) || 
             (this.preventDocReceiveDate!=null &&
              this.preventDocReceiveDate.equals(other.getPreventDocReceiveDate()))) &&
            ((this.preventDocSummary==null && other.getPreventDocSummary()==null) || 
             (this.preventDocSummary!=null &&
              this.preventDocSummary.equals(other.getPreventDocSummary()))) &&
            ((this.preventFileName==null && other.getPreventFileName()==null) || 
             (this.preventFileName!=null &&
              this.preventFileName.equals(other.getPreventFileName()))) &&
            ((this.preventFilePath==null && other.getPreventFilePath()==null) || 
             (this.preventFilePath!=null &&
              this.preventFilePath.equals(other.getPreventFilePath()))) &&
            ((this.preventInBookNumber==null && other.getPreventInBookNumber()==null) || 
             (this.preventInBookNumber!=null &&
              this.preventInBookNumber.equals(other.getPreventInBookNumber()))) &&
            ((this.preventInputDate==null && other.getPreventInputDate()==null) || 
             (this.preventInputDate!=null &&
              this.preventInputDate.equals(other.getPreventInputDate()))) &&
            ((this.preventNote==null && other.getPreventNote()==null) || 
             (this.preventNote!=null &&
              this.preventNote.equals(other.getPreventNote()))) &&
            ((this.preventPersonInfo==null && other.getPreventPersonInfo()==null) || 
             (this.preventPersonInfo!=null &&
              this.preventPersonInfo.equals(other.getPreventPersonInfo()))) &&
            ((this.preventRegistAgency==null && other.getPreventRegistAgency()==null) || 
             (this.preventRegistAgency!=null &&
              this.preventRegistAgency.equals(other.getPreventRegistAgency()))) &&
            ((this.propertyId==null && other.getPropertyId()==null) || 
             (this.propertyId!=null &&
              this.propertyId.equals(other.getPropertyId()))) &&
            ((this.propertyInfo==null && other.getPropertyInfo()==null) || 
             (this.propertyInfo!=null &&
              this.propertyInfo.equals(other.getPropertyInfo()))) &&
            ((this.releaseDocDate==null && other.getReleaseDocDate()==null) || 
             (this.releaseDocDate!=null &&
              this.releaseDocDate.equals(other.getReleaseDocDate()))) &&
            ((this.releaseDocNumber==null && other.getReleaseDocNumber()==null) || 
             (this.releaseDocNumber!=null &&
              this.releaseDocNumber.equals(other.getReleaseDocNumber()))) &&
            ((this.releaseDocReceiveDate==null && other.getReleaseDocReceiveDate()==null) || 
             (this.releaseDocReceiveDate!=null &&
              this.releaseDocReceiveDate.equals(other.getReleaseDocReceiveDate()))) &&
            ((this.releaseDocSummary==null && other.getReleaseDocSummary()==null) || 
             (this.releaseDocSummary!=null &&
              this.releaseDocSummary.equals(other.getReleaseDocSummary()))) &&
            ((this.releaseFileName==null && other.getReleaseFileName()==null) || 
             (this.releaseFileName!=null &&
              this.releaseFileName.equals(other.getReleaseFileName()))) &&
            ((this.releaseFilePath==null && other.getReleaseFilePath()==null) || 
             (this.releaseFilePath!=null &&
              this.releaseFilePath.equals(other.getReleaseFilePath()))) &&
            ((this.releaseFlg==null && other.getReleaseFlg()==null) || 
             (this.releaseFlg!=null &&
              this.releaseFlg.equals(other.getReleaseFlg()))) &&
            ((this.releaseInBookNumber==null && other.getReleaseInBookNumber()==null) || 
             (this.releaseInBookNumber!=null &&
              this.releaseInBookNumber.equals(other.getReleaseInBookNumber()))) &&
            ((this.releaseInputDate==null && other.getReleaseInputDate()==null) || 
             (this.releaseInputDate!=null &&
              this.releaseInputDate.equals(other.getReleaseInputDate()))) &&
            ((this.releaseNote==null && other.getReleaseNote()==null) || 
             (this.releaseNote!=null &&
              this.releaseNote.equals(other.getReleaseNote()))) &&
            ((this.releasePersonInfo==null && other.getReleasePersonInfo()==null) || 
             (this.releasePersonInfo!=null &&
              this.releasePersonInfo.equals(other.getReleasePersonInfo()))) &&
            ((this.releaseRegistAgency==null && other.getReleaseRegistAgency()==null) || 
             (this.releaseRegistAgency!=null &&
              this.releaseRegistAgency.equals(other.getReleaseRegistAgency()))) &&
            ((this.synchronizeId==null && other.getSynchronizeId()==null) || 
             (this.synchronizeId!=null &&
              this.synchronizeId.equals(other.getSynchronizeId()))) &&
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
        if (getDeleteFlg() != null) {
            _hashCode += getDeleteFlg().hashCode();
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
        if (getLandUseOrigin() != null) {
            _hashCode += getLandUseOrigin().hashCode();
        }
        if (getLandUsePeriod() != null) {
            _hashCode += getLandUsePeriod().hashCode();
        }
        if (getLandUsePurpose() != null) {
            _hashCode += getLandUsePurpose().hashCode();
        }
        if (getOriginKind() != null) {
            _hashCode += getOriginKind().hashCode();
        }
        if (getOtherInfo() != null) {
            _hashCode += getOtherInfo().hashCode();
        }
        if (getOwnerInfo() != null) {
            _hashCode += getOwnerInfo().hashCode();
        }
        if (getPreventDocDate() != null) {
            _hashCode += getPreventDocDate().hashCode();
        }
        if (getPreventDocNumber() != null) {
            _hashCode += getPreventDocNumber().hashCode();
        }
        if (getPreventDocReceiveDate() != null) {
            _hashCode += getPreventDocReceiveDate().hashCode();
        }
        if (getPreventDocSummary() != null) {
            _hashCode += getPreventDocSummary().hashCode();
        }
        if (getPreventFileName() != null) {
            _hashCode += getPreventFileName().hashCode();
        }
        if (getPreventFilePath() != null) {
            _hashCode += getPreventFilePath().hashCode();
        }
        if (getPreventInBookNumber() != null) {
            _hashCode += getPreventInBookNumber().hashCode();
        }
        if (getPreventInputDate() != null) {
            _hashCode += getPreventInputDate().hashCode();
        }
        if (getPreventNote() != null) {
            _hashCode += getPreventNote().hashCode();
        }
        if (getPreventPersonInfo() != null) {
            _hashCode += getPreventPersonInfo().hashCode();
        }
        if (getPreventRegistAgency() != null) {
            _hashCode += getPreventRegistAgency().hashCode();
        }
        if (getPropertyId() != null) {
            _hashCode += getPropertyId().hashCode();
        }
        if (getPropertyInfo() != null) {
            _hashCode += getPropertyInfo().hashCode();
        }
        if (getReleaseDocDate() != null) {
            _hashCode += getReleaseDocDate().hashCode();
        }
        if (getReleaseDocNumber() != null) {
            _hashCode += getReleaseDocNumber().hashCode();
        }
        if (getReleaseDocReceiveDate() != null) {
            _hashCode += getReleaseDocReceiveDate().hashCode();
        }
        if (getReleaseDocSummary() != null) {
            _hashCode += getReleaseDocSummary().hashCode();
        }
        if (getReleaseFileName() != null) {
            _hashCode += getReleaseFileName().hashCode();
        }
        if (getReleaseFilePath() != null) {
            _hashCode += getReleaseFilePath().hashCode();
        }
        if (getReleaseFlg() != null) {
            _hashCode += getReleaseFlg().hashCode();
        }
        if (getReleaseInBookNumber() != null) {
            _hashCode += getReleaseInBookNumber().hashCode();
        }
        if (getReleaseInputDate() != null) {
            _hashCode += getReleaseInputDate().hashCode();
        }
        if (getReleaseNote() != null) {
            _hashCode += getReleaseNote().hashCode();
        }
        if (getReleasePersonInfo() != null) {
            _hashCode += getReleasePersonInfo().hashCode();
        }
        if (getReleaseRegistAgency() != null) {
            _hashCode += getReleaseRegistAgency().hashCode();
        }
        if (getSynchronizeId() != null) {
            _hashCode += getSynchronizeId().hashCode();
        }
        if (getType() != null) {
            _hashCode += getType().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DataPreventWsInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://npo.osp.com/", "dataPreventWsInfo"));
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
        elemField.setFieldName("deleteFlg");
        elemField.setXmlName(new javax.xml.namespace.QName("", "deleteFlg"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
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
        elemField.setFieldName("originKind");
        elemField.setXmlName(new javax.xml.namespace.QName("", "originKind"));
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
        elemField.setFieldName("preventDocDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "preventDocDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("preventDocNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "preventDocNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("preventDocReceiveDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "preventDocReceiveDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("preventDocSummary");
        elemField.setXmlName(new javax.xml.namespace.QName("", "preventDocSummary"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("preventFileName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "preventFileName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("preventFilePath");
        elemField.setXmlName(new javax.xml.namespace.QName("", "preventFilePath"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("preventInBookNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "preventInBookNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("preventInputDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "preventInputDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("preventNote");
        elemField.setXmlName(new javax.xml.namespace.QName("", "preventNote"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("preventPersonInfo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "preventPersonInfo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("preventRegistAgency");
        elemField.setXmlName(new javax.xml.namespace.QName("", "preventRegistAgency"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("propertyId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "propertyId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
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
        elemField.setFieldName("releaseDocDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "releaseDocDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("releaseDocNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "releaseDocNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("releaseDocReceiveDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "releaseDocReceiveDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("releaseDocSummary");
        elemField.setXmlName(new javax.xml.namespace.QName("", "releaseDocSummary"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("releaseFileName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "releaseFileName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("releaseFilePath");
        elemField.setXmlName(new javax.xml.namespace.QName("", "releaseFilePath"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("releaseFlg");
        elemField.setXmlName(new javax.xml.namespace.QName("", "releaseFlg"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("releaseInBookNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "releaseInBookNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("releaseInputDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "releaseInputDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("releaseNote");
        elemField.setXmlName(new javax.xml.namespace.QName("", "releaseNote"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("releasePersonInfo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "releasePersonInfo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("releaseRegistAgency");
        elemField.setXmlName(new javax.xml.namespace.QName("", "releaseRegistAgency"));
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
