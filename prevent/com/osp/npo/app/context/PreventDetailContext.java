/**
 *
 */
package com.osp.npo.app.context;

import java.util.List;

import com.osp.npo.core.basicData.PropertyInfo;

/**
 * Prevent Detail Context
 *
 * @author GiangVT
 * @version $Revision: 27190 $
 */
public class PreventDetailContext {

    public static final String SESSION_KEY = "preventDetailContext";

    private Long preventId;
    private Boolean fromRegist;

    /** Phân lo?i d? li?u ngan ch?n: */
    private String originKind;

    /** Ðon v? dang ký CV ngan ch?n */
    private String preventRegistAgency;

    /** Thông tin ngu?i (don v?) g?i yêu c?u ngan ch?n */
    private String preventPersonInfo;

    /** S? vào s? công van yêu c?u */
    private String preventInBookNumber;

    /** S? công van yêu c?u ngan ch?n */
    private String preventDocNumber;

    /** Ngày công van yêu c?u ngan ch?n */
    private String preventDocDate;

    /** Ngày nh?n công van yêu c?u ngan ch?n */
    private String preventDocReceiveDate;

    /** Ngày nh?p công van yêu c?u ngan ch?n */
    private String preventInputDate;

    /** Trích y?u n?i dung công van yêu c?u ngan ch?n */
    private String preventDocSummary;

    /** Tên file dính kèm CV ngan ch?n */
    private String preventFileName;

    /** Luu du?ng d?n ch?a file dính kèm CV ngan ch?n */
    private String preventFilePath;

    /** Ghi chú ngan ch?n */
    private String preventNote;

 // for property prevent info
    /** Thong tin tai san */
    private String propertyInfo;

    /** Thong tin chu so huu */
    private String ownerInfo;

    /** Thông tin khác */
    private String otherInfo;

    /** Nhà d?t - S? gi?y ch?ng nh?n */
    private String landCertificate;

    /** Nhà d?t - Noi c?p GCN */
    private String landIssuePlace;

    /** Nhà d?t - Ngày c?p GCN */
    private String landIssueDate;

    /** Nhà d?t -S? t? b?n d? */
    private String landMapNumber;

    /** Nhà d?t -S? th?a d?t */
    private String landNumber;

    /** Nhà d?t -Ð?a ch? th?a d?t */
    private String landAddress;

    /** Nhà d?t - Di?n tích */
    private String landArea;

    /** Nhà d?t - Di?n tích s? d?ng chung */
    private String landPublicArea;

    /** Nhà d?t - Di?n tích s? d?ng riêng */
    private String landPrivateArea;

    /** Nhà d?t - M?c dích s? d?ng */
    private String landUsePurpose;

    /** Nhà d?t - M?c dích s? d?ng */
    private String landUsePeriod;

    /** Nhà d?t - M?c dích s? d?ng */
    private String landUseOrigin;

    /** Nhà d?t - Ð?a bàn T?nh/Thành */
    private String landDistrict;
    
    /** Nhà d?t - Ð?a bàn Phường xã */
    private String landStreet;

    /** Nhà d?t - Ð?a bàn Qu?n/Huy?n  */
    private Long landProvince;

    /** Tai san gan lien voi dat */
    private String landAssociateProperty;

    /** Ô tô, Motor - Bi?n ki?m soát */
    private String carLicenseNumber;

    /** Ô tô, Motor - S? dang ký */
    private String carRegistNumber;

    /** Ô tô, Motor - Noi c?p GCN */
    private String carIssuePlace;

    /** Ô tô, Motor  - Ngày c?p GCN */
    private String carIssueDate;

    /** Ô tô, Motor - S? khung  */
    private String carFrameNumber;

    /** Ô tô, Motor - S? máy */
    private String carMachineNumber;

    private List<PropertyInfo> lstProperty;

    /** TÃƒÂ i sÃ¡ÂºÂ£n bÃƒÂ¡o chÃ¡ÂºÂ·n */
    private String propertyType;

    /** remove file */
    private Boolean filePreventExisted;

    /**
     * @return the preventId
     */
    public Long getPreventId() {
        return preventId;
    }
    /**
     * @param preventId the preventId to set
     */
    public void setPreventId(Long preventId) {
        this.preventId = preventId;
    }
    /**
     * @return the fromRegist
     */
    public Boolean getFromRegist() {
        return fromRegist;
    }
    /**
     * @param fromRegist the fromRegist to set
     */
    public void setFromRegist(Boolean fromRegist) {
        this.fromRegist = fromRegist;
    }
    /**
     * @return the originKind
     */
    public String getOriginKind() {
        return originKind;
    }
    /**
     * @param originKind the originKind to set
     */
    public void setOriginKind(String originKind) {
        this.originKind = originKind;
    }
    /**
     * @return the preventRegistAgency
     */
    public String getPreventRegistAgency() {
        return preventRegistAgency;
    }
    /**
     * @param preventRegistAgency the preventRegistAgency to set
     */
    public void setPreventRegistAgency(String preventRegistAgency) {
        this.preventRegistAgency = preventRegistAgency;
    }
    /**
     * @return the preventPersonInfo
     */
    public String getPreventPersonInfo() {
        return preventPersonInfo;
    }
    /**
     * @param preventPersonInfo the preventPersonInfo to set
     */
    public void setPreventPersonInfo(String preventPersonInfo) {
        this.preventPersonInfo = preventPersonInfo;
    }
    /**
     * @return the preventInBookNumber
     */
    public String getPreventInBookNumber() {
        return preventInBookNumber;
    }
    /**
     * @param preventInBookNumber the preventInBookNumber to set
     */
    public void setPreventInBookNumber(String preventInBookNumber) {
        this.preventInBookNumber = preventInBookNumber;
    }
    /**
     * @return the preventDocNumber
     */
    public String getPreventDocNumber() {
        return preventDocNumber;
    }
    /**
     * @param preventDocNumber the preventDocNumber to set
     */
    public void setPreventDocNumber(String preventDocNumber) {
        this.preventDocNumber = preventDocNumber;
    }
    /**
     * @return the preventDocDate
     */
    public String getPreventDocDate() {
        return preventDocDate;
    }
    /**
     * @param preventDocDate the preventDocDate to set
     */
    public void setPreventDocDate(String preventDocDate) {
        this.preventDocDate = preventDocDate;
    }
    /**
     * @return the preventDocReceiveDate
     */
    public String getPreventDocReceiveDate() {
        return preventDocReceiveDate;
    }
    /**
     * @param preventDocReceiveDate the preventDocReceiveDate to set
     */
    public void setPreventDocReceiveDate(String preventDocReceiveDate) {
        this.preventDocReceiveDate = preventDocReceiveDate;
    }
    /**
     * @return the preventInputDate
     */
    public String getPreventInputDate() {
        return preventInputDate;
    }
    /**
     * @param preventInputDate the preventInputDate to set
     */
    public void setPreventInputDate(String preventInputDate) {
        this.preventInputDate = preventInputDate;
    }
    /**
     * @return the preventDocSummary
     */
    public String getPreventDocSummary() {
        return preventDocSummary;
    }
    /**
     * @param preventDocSummary the preventDocSummary to set
     */
    public void setPreventDocSummary(String preventDocSummary) {
        this.preventDocSummary = preventDocSummary;
    }
    /**
     * @return the preventFileName
     */
    public String getPreventFileName() {
        return preventFileName;
    }
    /**
     * @param preventFileName the preventFileName to set
     */
    public void setPreventFileName(String preventFileName) {
        this.preventFileName = preventFileName;
    }
    /**
     * @return the preventFilePath
     */
    public String getPreventFilePath() {
        return preventFilePath;
    }
    /**
     * @param preventFilePath the preventFilePath to set
     */
    public void setPreventFilePath(String preventFilePath) {
        this.preventFilePath = preventFilePath;
    }
    /**
     * @return the preventNote
     */
    public String getPreventNote() {
        return preventNote;
    }
    /**
     * @param preventNote the preventNote to set
     */
    public void setPreventNote(String preventNote) {
        this.preventNote = preventNote;
    }
    /**
     * @return the propertyInfo
     */
    public String getPropertyInfo() {
        return propertyInfo;
    }
    /**
     * @param propertyInfo the propertyInfo to set
     */
    public void setPropertyInfo(String propertyInfo) {
        this.propertyInfo = propertyInfo;
    }
    /**
     * @return the ownerInfo
     */
    public String getOwnerInfo() {
        return ownerInfo;
    }
    /**
     * @param ownerInfo the ownerInfo to set
     */
    public void setOwnerInfo(String ownerInfo) {
        this.ownerInfo = ownerInfo;
    }
    /**
     * @return the otherInfo
     */
    public String getOtherInfo() {
        return otherInfo;
    }
    /**
     * @param otherInfo the otherInfo to set
     */
    public void setOtherInfo(String otherInfo) {
        this.otherInfo = otherInfo;
    }
    /**
     * @return the landCertificate
     */
    public String getLandCertificate() {
        return landCertificate;
    }
    /**
     * @param landCertificate the landCertificate to set
     */
    public void setLandCertificate(String landCertificate) {
        this.landCertificate = landCertificate;
    }
    /**
     * @return the landIssuePlace
     */
    public String getLandIssuePlace() {
        return landIssuePlace;
    }
    /**
     * @param landIssuePlace the landIssuePlace to set
     */
    public void setLandIssuePlace(String landIssuePlace) {
        this.landIssuePlace = landIssuePlace;
    }
    /**
     * @return the landIssueDate
     */
    public String getLandIssueDate() {
        return landIssueDate;
    }
    /**
     * @param landIssueDate the landIssueDate to set
     */
    public void setLandIssueDate(String landIssueDate) {
        this.landIssueDate = landIssueDate;
    }
    /**
     * @return the landMapNumber
     */
    public String getLandMapNumber() {
        return landMapNumber;
    }
    /**
     * @param landMapNumber the landMapNumber to set
     */
    public void setLandMapNumber(String landMapNumber) {
        this.landMapNumber = landMapNumber;
    }
    /**
     * @return the landNumber
     */
    public String getLandNumber() {
        return landNumber;
    }
    /**
     * @param landNumber the landNumber to set
     */
    public void setLandNumber(String landNumber) {
        this.landNumber = landNumber;
    }
    /**
     * @return the landAddress
     */
    public String getLandAddress() {
        return landAddress;
    }
    /**
     * @param landAddress the landAddress to set
     */
    public void setLandAddress(String landAddress) {
        this.landAddress = landAddress;
    }
    /**
     * @return the landArea
     */
    public String getLandArea() {
        return landArea;
    }
    /**
     * @param landArea the landArea to set
     */
    public void setLandArea(String landArea) {
        this.landArea = landArea;
    }
    /**
     * @return the landPublicArea
     */
    public String getLandPublicArea() {
        return landPublicArea;
    }
    /**
     * @param landPublicArea the landPublicArea to set
     */
    public void setLandPublicArea(String landPublicArea) {
        this.landPublicArea = landPublicArea;
    }
    /**
     * @return the landPrivateArea
     */
    public String getLandPrivateArea() {
        return landPrivateArea;
    }
    /**
     * @param landPrivateArea the landPrivateArea to set
     */
    public void setLandPrivateArea(String landPrivateArea) {
        this.landPrivateArea = landPrivateArea;
    }
    /**
     * @return the landUsePurpose
     */
    public String getLandUsePurpose() {
        return landUsePurpose;
    }
    /**
     * @param landUsePurpose the landUsePurpose to set
     */
    public void setLandUsePurpose(String landUsePurpose) {
        this.landUsePurpose = landUsePurpose;
    }
    /**
     * @return the landUsePeriod
     */
    public String getLandUsePeriod() {
        return landUsePeriod;
    }
    /**
     * @param landUsePeriod the landUsePeriod to set
     */
    public void setLandUsePeriod(String landUsePeriod) {
        this.landUsePeriod = landUsePeriod;
    }
    /**
     * @return the landUseOrigin
     */
    public String getLandUseOrigin() {
        return landUseOrigin;
    }
    /**
     * @param landUseOrigin the landUseOrigin to set
     */
    public void setLandUseOrigin(String landUseOrigin) {
        this.landUseOrigin = landUseOrigin;
    }
    /**
     * @return the landDistrict
     */
    public String getLandDistrict() {
        return landDistrict;
    }
    /**
     * @param landDistrict the landDistrict to set
     */
    public void setLandDistrict(String landDistrict) {
        this.landDistrict = landDistrict;
    }
    /**
     * @return the landProvince
     */
    public Long getLandProvince() {
        return landProvince;
    }
    /**
     * @param landProvince the landProvince to set
     */
    public void setLandProvince(Long landProvince) {
        this.landProvince = landProvince;
    }
    /**
     * @return the landAssociateProperty
     */
    public String getLandAssociateProperty() {
        return landAssociateProperty;
    }
    /**
     * @param landAssociateProperty the landAssociateProperty to set
     */
    public void setLandAssociateProperty(String landAssociateProperty) {
        this.landAssociateProperty = landAssociateProperty;
    }
    /**
     * @return the carLicenseNumber
     */
    public String getCarLicenseNumber() {
        return carLicenseNumber;
    }
    /**
     * @param carLicenseNumber the carLicenseNumber to set
     */
    public void setCarLicenseNumber(String carLicenseNumber) {
        this.carLicenseNumber = carLicenseNumber;
    }
    /**
     * @return the carRegistNumber
     */
    public String getCarRegistNumber() {
        return carRegistNumber;
    }
    /**
     * @param carRegistNumber the carRegistNumber to set
     */
    public void setCarRegistNumber(String carRegistNumber) {
        this.carRegistNumber = carRegistNumber;
    }
    /**
     * @return the carIssuePlace
     */
    public String getCarIssuePlace() {
        return carIssuePlace;
    }
    /**
     * @param carIssuePlace the carIssuePlace to set
     */
    public void setCarIssuePlace(String carIssuePlace) {
        this.carIssuePlace = carIssuePlace;
    }
    /**
     * @return the carIssueDate
     */
    public String getCarIssueDate() {
        return carIssueDate;
    }
    /**
     * @param carIssueDate the carIssueDate to set
     */
    public void setCarIssueDate(String carIssueDate) {
        this.carIssueDate = carIssueDate;
    }
    /**
     * @return the carFrameNumber
     */
    public String getCarFrameNumber() {
        return carFrameNumber;
    }
    /**
     * @param carFrameNumber the carFrameNumber to set
     */
    public void setCarFrameNumber(String carFrameNumber) {
        this.carFrameNumber = carFrameNumber;
    }
    /**
     * @return the carMachineNumber
     */
    public String getCarMachineNumber() {
        return carMachineNumber;
    }
    /**
     * @param carMachineNumber the carMachineNumber to set
     */
    public void setCarMachineNumber(String carMachineNumber) {
        this.carMachineNumber = carMachineNumber;
    }
    /**
     * @return the lstProperty
     */
    public List<PropertyInfo> getLstProperty() {
        return lstProperty;
    }
    /**
     * @param lstProperty the lstProperty to set
     */
    public void setLstProperty(List<PropertyInfo> lstProperty) {
        this.lstProperty = lstProperty;
    }
    /**
     * @return the propertyType
     */
    public String getPropertyType() {
        return propertyType;
    }
    /**
     * @param propertyType the propertyType to set
     */
    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }
    /**
     * @return the filePreventExisted
     */
    public Boolean getFilePreventExisted() {
        return filePreventExisted;
    }
    /**
     * @param filePreventExisted the filePreventExisted to set
     */
    public void setFilePreventExisted(Boolean filePreventExisted) {
        this.filePreventExisted = filePreventExisted;
    }
	/**
	 * @param landStreet the landStreet to set
	 */
	public void setLandStreet(String landStreet) {
		this.landStreet = landStreet;
	}
	/**
	 * @return the landStreet
	 */
	public String getLandStreet() {
		return landStreet;
	}
}
