package com.osp.npo.core.contract;


import com.osp.npo.common.global.Constants;
import com.osp.npo.common.util.EditString;
import com.osp.npo.common.util.SystemMessageProperties;
import com.osp.npo.core.AbstractInfo;
import java.sql.Timestamp;


/**
 * Generate by script
 * Generate date: 11/29/2010 10:15:29 AM
 */
public class PropertyInfo extends AbstractInfo {


    /** id tï¿½i s?n b? ch?n */
    private Long id;

    /** Loai tï¿½i s?n ch?n:
 */
    private String type;

    /** Thong tin tai san */
    private String propertyInfo;

    /** Thong tin chu so huu */
    private String ownerInfo;

    /** Thï¿½ng tin khï¿½c */
    private String otherInfo;

    /** Nhï¿½ d?t - S? gi?y ch?ng nh?n */
    private String landCertificate;

    /** Nhï¿½ d?t - Noi c?p GCN */
    private String landIssuePlace;

    /** Nhï¿½ d?t - Ngï¿½y c?p GCN */
    private Timestamp landIssueDate;

    /** Nhï¿½ d?t -S? t? b?n d? */
    private String landMapNumber;

    /** Nhï¿½ d?t -S? th?a d?t */
    private String landNumber;

    /** Nhï¿½ d?t -ï¿½?a ch? th?a d?t */
    private String landAddress;

    /** Nhï¿½ d?t - Di?n tï¿½ch */
    private String landArea;

    /** Nhï¿½ d?t - Di?n tï¿½ch s? d?ng chung */
    private String landPublicArea;

    /** Nhï¿½ d?t - Di?n tï¿½ch s? d?ng riï¿½ng */
    private String landPrivateArea;

    /** Nhï¿½ d?t - M?c dï¿½ch s? d?ng */
    private String landUsePurpose;

    /** Nhï¿½ d?t - M?c dï¿½ch s? d?ng */
    private String landUsePeriod;

    /** Nhï¿½ d?t - M?c dï¿½ch s? d?ng */
    private String landUseOrigin;

    /** Nhï¿½ d?t - ï¿½?a bï¿½n T?nh/Thï¿½nh */
    private String landDistrict;
    

    /** Nhï¿½ d?t - ï¿½?a bï¿½n Phường/Xã */
    private String landStreet;

    /** Nhï¿½ d?t - ï¿½?a bï¿½n Qu?n/Huy?n  */
    private Long landProvince;
    
    private String landAssociateProperty;

    /** ï¿½ tï¿½, Motor - Bi?n ki?m soï¿½t */
    private String carLicenseNumber;

    /** ï¿½ tï¿½, Motor - S? dang kï¿½ */
    private String carRegistNumber;

    /** ï¿½ tï¿½, Motor - Noi c?p GCN */
    private String carIssuePlace;

    /** ï¿½ tï¿½, Motor  - Ngï¿½y c?p GCN */
    private Timestamp carIssueDate;

    /** ï¿½ tï¿½, Motor - S? khung  */
    private String carFrameNumber;

    /** ï¿½ tï¿½, Motor - S? mï¿½y */
    private String carMachineNumber;
    
    private Long contractId;
    
    private Timestamp notaryDate;
    
    private String contractTemplate;
    
    private String contractSummary;
    
    /**
     * <P>Generate Instance.</P>
     *
     */
    public PropertyInfo() {
        super();
    }


    /**
     * <P>Get id tï¿½i s?n b? ch?n </P>
     *
     * @return id tï¿½i s?n b? ch?n
     */
    public Long getId() {
        return this.id;
    }

    /**
     * <P>Set id tï¿½i s?n b? ch?n. </P>
     *
     * @param id id tï¿½i s?n b? ch?n
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * <P>Get Loai tï¿½i s?n ch?n:
 </P>
     *
     * @return Loai tï¿½i s?n ch?n:

     */
    public String getType() {
        return this.type;
    }

    /**
     * <P>Set Loai tï¿½i s?n ch?n:
. </P>
     *
     * @param type Loai tï¿½i s?n ch?n:

     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * <P>Get Thong tin tai san </P>
     *
     * @return Thong tin tai san
     */
    public String getPropertyInfo() {
        return this.propertyInfo;
    }

    /**
     * <P>Set Thong tin tai san. </P>
     *
     * @param propertyInfo Thong tin tai san
     */
    public void setPropertyInfo(String propertyInfo) {
        this.propertyInfo = propertyInfo;
    }

    /**
     * <P>Get Thong tin chu so huu </P>
     *
     * @return Thong tin chu so huu
     */
    public String getOwnerInfo() {
        return this.ownerInfo;
    }

    /**
     * <P>Set Thong tin chu so huu. </P>
     *
     * @param ownerInfo Thong tin chu so huu
     */
    public void setOwnerInfo(String ownerInfo) {
        this.ownerInfo = ownerInfo;
    }

    /**
     * <P>Get Thï¿½ng tin khï¿½c </P>
     *
     * @return Thï¿½ng tin khï¿½c
     */
    public String getOtherInfo() {
        return this.otherInfo;
    }

    /**
     * <P>Set Thï¿½ng tin khï¿½c. </P>
     *
     * @param otherInfo Thï¿½ng tin khï¿½c
     */
    public void setOtherInfo(String otherInfo) {
        this.otherInfo = otherInfo;
    }

    /**
     * <P>Get Nhï¿½ d?t - S? gi?y ch?ng nh?n </P>
     *
     * @return Nhï¿½ d?t - S? gi?y ch?ng nh?n
     */
    public String getLandCertificate() {
        return this.landCertificate;
    }

    /**
     * <P>Set Nhï¿½ d?t - S? gi?y ch?ng nh?n. </P>
     *
     * @param landCertificate Nhï¿½ d?t - S? gi?y ch?ng nh?n
     */
    public void setLandCertificate(String landCertificate) {
        this.landCertificate = landCertificate;
    }

    /**
     * <P>Get Nhï¿½ d?t - Noi c?p GCN </P>
     *
     * @return Nhï¿½ d?t - Noi c?p GCN
     */
    public String getLandIssuePlace() {
        return this.landIssuePlace;
    }

    /**
     * <P>Set Nhï¿½ d?t - Noi c?p GCN. </P>
     *
     * @param landIssuePlace Nhï¿½ d?t - Noi c?p GCN
     */
    public void setLandIssuePlace(String landIssuePlace) {
        this.landIssuePlace = landIssuePlace;
    }

    /**
     * <P>Get Nhï¿½ d?t - Ngï¿½y c?p GCN </P>
     *
     * @return Nhï¿½ d?t - Ngï¿½y c?p GCN
     */
    public Timestamp getLandIssueDate() {
        return this.landIssueDate;
    }

    /**
     * <P>Set Nhï¿½ d?t - Ngï¿½y c?p GCN. </P>
     *
     * @param landIssueDate Nhï¿½ d?t - Ngï¿½y c?p GCN
     */
    public void setLandIssueDate(Timestamp landIssueDate) {
        this.landIssueDate = landIssueDate;
    }

    /**
     * <P>Get Nhï¿½ d?t -S? t? b?n d? </P>
     *
     * @return Nhï¿½ d?t -S? t? b?n d?
     */
    public String getLandMapNumber() {
        return this.landMapNumber;
    }

    /**
     * <P>Set Nhï¿½ d?t -S? t? b?n d?. </P>
     *
     * @param landMapNumber Nhï¿½ d?t -S? t? b?n d?
     */
    public void setLandMapNumber(String landMapNumber) {
        this.landMapNumber = landMapNumber;
    }

    /**
     * <P>Get Nhï¿½ d?t -S? th?a d?t </P>
     *
     * @return Nhï¿½ d?t -S? th?a d?t
     */
    public String getLandNumber() {
        return this.landNumber;
    }

    /**
     * <P>Set Nhï¿½ d?t -S? th?a d?t. </P>
     *
     * @param landNumber Nhï¿½ d?t -S? th?a d?t
     */
    public void setLandNumber(String landNumber) {
        this.landNumber = landNumber;
    }

    /**
     * <P>Get Nhï¿½ d?t -ï¿½?a ch? th?a d?t </P>
     *
     * @return Nhï¿½ d?t -ï¿½?a ch? th?a d?t
     */
    public String getLandAddress() {
        return this.landAddress;
    }

    /**
     * <P>Set Nhï¿½ d?t -ï¿½?a ch? th?a d?t. </P>
     *
     * @param landAddress Nhï¿½ d?t -ï¿½?a ch? th?a d?t
     */
    public void setLandAddress(String landAddress) {
        this.landAddress = landAddress;
    }

    /**
     * <P>Get Nhï¿½ d?t - Di?n tï¿½ch </P>
     *
     * @return Nhï¿½ d?t - Di?n tï¿½ch
     */
    public String getLandArea() {
        return this.landArea;
    }

    /**
     * <P>Set Nhï¿½ d?t - Di?n tï¿½ch. </P>
     *
     * @param landArea Nhï¿½ d?t - Di?n tï¿½ch
     */
    public void setLandArea(String landArea) {
        this.landArea = landArea;
    }

    /**
     * <P>Get Nhï¿½ d?t - Di?n tï¿½ch s? d?ng chung </P>
     *
     * @return Nhï¿½ d?t - Di?n tï¿½ch s? d?ng chung
     */
    public String getLandPublicArea() {
        return this.landPublicArea;
    }

    /**
     * <P>Set Nhï¿½ d?t - Di?n tï¿½ch s? d?ng chung. </P>
     *
     * @param landPublicArea Nhï¿½ d?t - Di?n tï¿½ch s? d?ng chung
     */
    public void setLandPublicArea(String landPublicArea) {
        this.landPublicArea = landPublicArea;
    }

    /**
     * <P>Get Nhï¿½ d?t - Di?n tï¿½ch s? d?ng riï¿½ng </P>
     *
     * @return Nhï¿½ d?t - Di?n tï¿½ch s? d?ng riï¿½ng
     */
    public String getLandPrivateArea() {
        return this.landPrivateArea;
    }

    /**
     * <P>Set Nhï¿½ d?t - Di?n tï¿½ch s? d?ng riï¿½ng. </P>
     *
     * @param landPrivateArea Nhï¿½ d?t - Di?n tï¿½ch s? d?ng riï¿½ng
     */
    public void setLandPrivateArea(String landPrivateArea) {
        this.landPrivateArea = landPrivateArea;
    }

    /**
     * <P>Get Nhï¿½ d?t - M?c dï¿½ch s? d?ng </P>
     *
     * @return Nhï¿½ d?t - M?c dï¿½ch s? d?ng
     */
    public String getLandUsePurpose() {
        return this.landUsePurpose;
    }

    /**
     * <P>Set Nhï¿½ d?t - M?c dï¿½ch s? d?ng. </P>
     *
     * @param landUsePurpose Nhï¿½ d?t - M?c dï¿½ch s? d?ng
     */
    public void setLandUsePurpose(String landUsePurpose) {
        this.landUsePurpose = landUsePurpose;
    }

    /**
     * <P>Get Nhï¿½ d?t - M?c dï¿½ch s? d?ng </P>
     *
     * @return Nhï¿½ d?t - M?c dï¿½ch s? d?ng
     */
    public String getLandUsePeriod() {
        return this.landUsePeriod;
    }

    /**
     * <P>Set Nhï¿½ d?t - M?c dï¿½ch s? d?ng. </P>
     *
     * @param landUsePeriod Nhï¿½ d?t - M?c dï¿½ch s? d?ng
     */
    public void setLandUsePeriod(String landUsePeriod) {
        this.landUsePeriod = landUsePeriod;
    }

    /**
     * <P>Get Nhï¿½ d?t - M?c dï¿½ch s? d?ng </P>
     *
     * @return Nhï¿½ d?t - M?c dï¿½ch s? d?ng
     */
    public String getLandUseOrigin() {
        return this.landUseOrigin;
    }

    /**
     * <P>Set Nhï¿½ d?t - M?c dï¿½ch s? d?ng. </P>
     *
     * @param landUseOrigin Nhï¿½ d?t - M?c dï¿½ch s? d?ng
     */
    public void setLandUseOrigin(String landUseOrigin) {
        this.landUseOrigin = landUseOrigin;
    }

    /**
     * <P>Get Nhï¿½ d?t - ï¿½?a bï¿½n T?nh/Thï¿½nh </P>
     *
     * @return Nhï¿½ d?t - ï¿½?a bï¿½n T?nh/Thï¿½nh
     */
    public String getLandDistrict() {
        return this.landDistrict;
    }

    /**
     * <P>Set Nhï¿½ d?t - ï¿½?a bï¿½n T?nh/Thï¿½nh. </P>
     *
     * @param landDistrict Nhï¿½ d?t - ï¿½?a bï¿½n T?nh/Thï¿½nh
     */
    public void setLandDistrict(String landDistrict) {
        this.landDistrict = landDistrict;
    }

    /**
     * <P>Get Nhï¿½ d?t - ï¿½?a bï¿½n Qu?n/Huy?n  </P>
     *
     * @return Nhï¿½ d?t - ï¿½?a bï¿½n Qu?n/Huy?n 
     */
    public Long getLandProvince() {
        return this.landProvince;
    }

    /**
     * <P>Set Nhï¿½ d?t - ï¿½?a bï¿½n Qu?n/Huy?n . </P>
     *
     * @param landProvince Nhï¿½ d?t - ï¿½?a bï¿½n Qu?n/Huy?n 
     */
    public void setLandProvince(Long landProvince) {
        this.landProvince = landProvince;
    }

    /**
     * <P>Get ï¿½ tï¿½, Motor - Bi?n ki?m soï¿½t </P>
     *
     * @return ï¿½ tï¿½, Motor - Bi?n ki?m soï¿½t
     */
    public String getCarLicenseNumber() {
        return this.carLicenseNumber;
    }

    /**
     * <P>Set ï¿½ tï¿½, Motor - Bi?n ki?m soï¿½t. </P>
     *
     * @param carLicenseNumber ï¿½ tï¿½, Motor - Bi?n ki?m soï¿½t
     */
    public void setCarLicenseNumber(String carLicenseNumber) {
        this.carLicenseNumber = carLicenseNumber;
    }

    /**
     * <P>Get ï¿½ tï¿½, Motor - S? dang kï¿½ </P>
     *
     * @return ï¿½ tï¿½, Motor - S? dang kï¿½
     */
    public String getCarRegistNumber() {
        return this.carRegistNumber;
    }

    /**
     * <P>Set ï¿½ tï¿½, Motor - S? dang kï¿½. </P>
     *
     * @param carRegistNumber ï¿½ tï¿½, Motor - S? dang kï¿½
     */
    public void setCarRegistNumber(String carRegistNumber) {
        this.carRegistNumber = carRegistNumber;
    }

    /**
     * <P>Get ï¿½ tï¿½, Motor - Noi c?p GCN </P>
     *
     * @return ï¿½ tï¿½, Motor - Noi c?p GCN
     */
    public String getCarIssuePlace() {
        return this.carIssuePlace;
    }

    /**
     * <P>Set ï¿½ tï¿½, Motor - Noi c?p GCN. </P>
     *
     * @param carIssuePlace ï¿½ tï¿½, Motor - Noi c?p GCN
     */
    public void setCarIssuePlace(String carIssuePlace) {
        this.carIssuePlace = carIssuePlace;
    }

    /**
     * <P>Get ï¿½ tï¿½, Motor  - Ngï¿½y c?p GCN </P>
     *
     * @return ï¿½ tï¿½, Motor  - Ngï¿½y c?p GCN
     */
    public Timestamp getCarIssueDate() {
        return this.carIssueDate;
    }

    /**
     * <P>Set ï¿½ tï¿½, Motor  - Ngï¿½y c?p GCN. </P>
     *
     * @param carIssueDate ï¿½ tï¿½, Motor  - Ngï¿½y c?p GCN
     */
    public void setCarIssueDate(Timestamp carIssueDate) {
        this.carIssueDate = carIssueDate;
    }

    /**
     * <P>Get ï¿½ tï¿½, Motor - S? khung  </P>
     *
     * @return ï¿½ tï¿½, Motor - S? khung 
     */
    public String getCarFrameNumber() {
        return this.carFrameNumber;
    }

    /**
     * <P>Set ï¿½ tï¿½, Motor - S? khung . </P>
     *
     * @param carFrameNumber ï¿½ tï¿½, Motor - S? khung 
     */
    public void setCarFrameNumber(String carFrameNumber) {
        this.carFrameNumber = carFrameNumber;
    }

    /**
     * <P>Get ï¿½ tï¿½, Motor - S? mï¿½y </P>
     *
     * @return ï¿½ tï¿½, Motor - S? mï¿½y
     */
    public String getCarMachineNumber() {
        return this.carMachineNumber;
    }

    /**
     * <P>Set ï¿½ tï¿½, Motor - S? mï¿½y. </P>
     *
     * @param carMachineNumber ï¿½ tï¿½, Motor - S? mï¿½y
     */
    public void setCarMachineNumber(String carMachineNumber) {
        this.carMachineNumber = carMachineNumber;
    }


    /**
     * Get the contractId
     *
     * @return the contractId
     */
    public Long getContractId() {
        return contractId;
    }


    /**
     * Set the contractId
     *
     * @param contractId the contractId to set
     */
    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }


    /**
     * Get the notaryDate
     *
     * @return the notaryDate
     */
    public Timestamp getNotaryDate() {
        return notaryDate;
    }


    /**
     * Set the notaryDate
     *
     * @param notaryDate the notaryDate to set
     */
    public void setNotaryDate(Timestamp notaryDate) {
        this.notaryDate = notaryDate;
    }


    /**
     * Get the contractTemplate
     *
     * @return the contractTemplate
     */
    public String getContractTemplate() {
        return contractTemplate;
    }


    /**
     * Set the contractTemplate
     *
     * @param contractTemplate the contractTemplate to set
     */
    public void setContractTemplate(String contractTemplate) {
        this.contractTemplate = contractTemplate;
    }


    /**
     * Get the contractSummary
     *
     * @return the contractSummary
     */
    public String getContractSummary() {
        return contractSummary;
    }


    /**
     * Set the contractSummary
     *
     * @param contractSummary the contractSummary to set
     */
    public void setContractSummary(String contractSummary) {
        this.contractSummary = contractSummary;
    }


    /**
     * Get the landAssociateProperty
     *
     * @return the landAssociateProperty
     */
    public String getLandAssociateProperty() {
        return landAssociateProperty;
    }


    /**
     * Set the landAssociateProperty
     *
     * @param landAssociateProperty the landAssociateProperty to set
     */
    public void setLandAssociateProperty(String landAssociateProperty) {
        this.landAssociateProperty = landAssociateProperty;
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
     * <P>Get the ownerInfoDisp </P>
     *
     * @return ownerInfoDisp
     */
    public String getOwnerInfoDisp() {
        return EditString.replaceChangeLine(ownerInfo);
    }
    
    /**
     * Get the contractSummaryDisp
     *
     * @return the contractSummaryDisp
     */
    public String getContractSummaryDisp() {
        return EditString.replaceChangeLine(contractSummary);
    }


    /**
     * Get the contractTemplateDisp
     *
     * @return the contractTemplateDisp
     */
    public String getContractTemplateDisp() {
        return EditString.replaceChangeLine(contractTemplate);
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
    
    /**
     * <P>Get the infoDisp </P>
     *
     * @return infoDisp
     */
    public String getInfoDisp() {
        return EditString.getDisp(getInfo(), Constants.LENGTH_OUTPUT_LIMIT);
    }
    
    /**
     * Get the contract Information
     *
     * @return the contractInformation
     */
    public String getContractInfo() {
        String info = "";
        info += contractTemplate;
        if (!EditString.isNull(contractSummary)) {
            info += Constants.ENTER + SystemMessageProperties.getSystemProperty("item_content")
                + Constants.COLON + Constants.SPACE + contractSummary;
        }
        return EditString.replaceChangeLine(info);
    }
    
    public String getContractInfoDisp() {
        return EditString.getDisp(getContractInfo(), Constants.LENGTH_OUTPUT_LIMIT);
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
