package com.osp.npo.core.prevent;


import com.osp.npo.common.util.EditString;
import com.osp.npo.core.AbstractInfo;
import java.sql.Timestamp;


/**
 * Generate by script
 * Generate date: 1/22/2011 8:59:06 AM
 * @version $Revision: 27190 $
 */
public class PropertyPreventInfo extends AbstractInfo {

    /** id t�i s?n b? ch?n */
    private Long id;

    /** Loai t�i s?n ch?n:  */
    private String type;

    /** Thong tin tai san */
    private String propertyInfo;

    /** Thong tin chu so huu */
    private String ownerInfo;

    /** Th�ng tin kh�c */
    private String otherInfo;

    /** Nh� d?t - S? gi?y ch?ng nh?n */
    private String landCertificate;

    /** Nh� d?t - Noi c?p GCN */
    private String landIssuePlace;

    /** Nh� d?t - Ng�y c?p GCN */
    private Timestamp landIssueDate;

    /** Nh� d?t -S? t? b?n d? */
    private String landMapNumber;

    /** Nh� d?t -S? th?a d?t */
    private String landNumber;

    /** Nh� d?t -�?a ch? th?a d?t */
    private String landAddress;

    /** Nh� d?t - Di?n t�ch */
    private String landArea;

    /** Nh� d?t - Di?n t�ch s? d?ng chung */
    private String landPublicArea;

    /** Nh� d?t - Di?n t�ch s? d?ng ri�ng */
    private String landPrivateArea;

    /** Nh� d?t - M?c d�ch s? d?ng */
    private String landUsePurpose;

    /** Nh� d?t - M?c d�ch s? d?ng */
    private String landUsePeriod;

    /** Nh� d?t - M?c d�ch s? d?ng */
    private String landUseOrigin;

    /** Nh� d?t - �?a b�n T?nh/Th�nh */
    private String landDistrict;
    
    /** Nh� d?t - �?a b�n phường xã */
    private String landStreet;
    
    /** Nh� d?t - �?a b�n Qu?n/Huy?n  */
    private Long landProvince;

    /** Tai san gan lien voi dat */
    private String landAssociateProperty;

    /** � t�, Motor - Bi?n ki?m so�t */
    private String carLicenseNumber;

    /** � t�, Motor - S? dang k� */
    private String carRegistNumber;

    /** � t�, Motor - Noi c?p GCN */
    private String carIssuePlace;

    /** � t�, Motor  - Ng�y c?p GCN */
    private Timestamp carIssueDate;

    /** � t�, Motor - S? khung  */
    private String carFrameNumber;

    /** � t�, Motor - S? m�y */
    private String carMachineNumber;
    
    


    /**
     * <P>Generate Instance.</P>
     *
     */
    public PropertyPreventInfo() {
        super();
    }


    /**
     * <P>Get id t�i s?n b? ch?n </P>
     *
     * @return id t�i s?n b? ch?n
     */
    public Long getId() {
        return this.id;
    }

    /**
     * <P>Set id t�i s?n b? ch?n. </P>
     *
     * @param id id t�i s?n b? ch?n
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * <P>Get Loai t�i s?n ch?n:
 </P>
     *
     * @return Loai t�i s?n ch?n:

     */
    public String getType() {
        return this.type;
    }

    /**
     * <P>Set Loai t�i s?n ch?n:
. </P>
     *
     * @param type Loai t�i s?n ch?n:

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
     * <P>Get Th�ng tin kh�c </P>
     *
     * @return Th�ng tin kh�c
     */
    public String getOtherInfo() {
        return this.otherInfo;
    }

    /**
     * <P>Set Th�ng tin kh�c. </P>
     *
     * @param otherInfo Th�ng tin kh�c
     */
    public void setOtherInfo(String otherInfo) {
        this.otherInfo = otherInfo;
    }

    /**
     * <P>Get Nh� d?t - S? gi?y ch?ng nh?n </P>
     *
     * @return Nh� d?t - S? gi?y ch?ng nh?n
     */
    public String getLandCertificate() {
        return this.landCertificate;
    }

    /**
     * <P>Set Nh� d?t - S? gi?y ch?ng nh?n. </P>
     *
     * @param landCertificate Nh� d?t - S? gi?y ch?ng nh?n
     */
    public void setLandCertificate(String landCertificate) {
        this.landCertificate = landCertificate;
    }

    /**
     * <P>Get Nh� d?t - Noi c?p GCN </P>
     *
     * @return Nh� d?t - Noi c?p GCN
     */
    public String getLandIssuePlace() {
        return this.landIssuePlace;
    }

    /**
     * <P>Set Nh� d?t - Noi c?p GCN. </P>
     *
     * @param landIssuePlace Nh� d?t - Noi c?p GCN
     */
    public void setLandIssuePlace(String landIssuePlace) {
        this.landIssuePlace = landIssuePlace;
    }

    /**
     * <P>Get Nh� d?t - Ng�y c?p GCN </P>
     *
     * @return Nh� d?t - Ng�y c?p GCN
     */
    public Timestamp getLandIssueDate() {
        return this.landIssueDate;
    }

    /**
     * <P>Set Nh� d?t - Ng�y c?p GCN. </P>
     *
     * @param landIssueDate Nh� d?t - Ng�y c?p GCN
     */
    public void setLandIssueDate(Timestamp landIssueDate) {
        this.landIssueDate = landIssueDate;
    }

    /**
     * <P>Get Nh� d?t -S? t? b?n d? </P>
     *
     * @return Nh� d?t -S? t? b?n d?
     */
    public String getLandMapNumber() {
        return this.landMapNumber;
    }

    /**
     * <P>Set Nh� d?t -S? t? b?n d?. </P>
     *
     * @param landMapNumber Nh� d?t -S? t? b?n d?
     */
    public void setLandMapNumber(String landMapNumber) {
        this.landMapNumber = landMapNumber;
    }

    /**
     * <P>Get Nh� d?t -S? th?a d?t </P>
     *
     * @return Nh� d?t -S? th?a d?t
     */
    public String getLandNumber() {
        return this.landNumber;
    }

    /**
     * <P>Set Nh� d?t -S? th?a d?t. </P>
     *
     * @param landNumber Nh� d?t -S? th?a d?t
     */
    public void setLandNumber(String landNumber) {
        this.landNumber = landNumber;
    }

    /**
     * <P>Get Nh� d?t -�?a ch? th?a d?t </P>
     *
     * @return Nh� d?t -�?a ch? th?a d?t
     */
    public String getLandAddress() {
        return this.landAddress;
    }

    /**
     * <P>Set Nh� d?t -�?a ch? th?a d?t. </P>
     *
     * @param landAddress Nh� d?t -�?a ch? th?a d?t
     */
    public void setLandAddress(String landAddress) {
        this.landAddress = landAddress;
    }

    /**
     * <P>Get Nh� d?t - Di?n t�ch </P>
     *
     * @return Nh� d?t - Di?n t�ch
     */
    public String getLandArea() {
        return this.landArea;
    }

    /**
     * <P>Set Nh� d?t - Di?n t�ch. </P>
     *
     * @param landArea Nh� d?t - Di?n t�ch
     */
    public void setLandArea(String landArea) {
        this.landArea = landArea;
    }

    /**
     * <P>Get Nh� d?t - Di?n t�ch s? d?ng chung </P>
     *
     * @return Nh� d?t - Di?n t�ch s? d?ng chung
     */
    public String getLandPublicArea() {
        return this.landPublicArea;
    }

    /**
     * <P>Set Nh� d?t - Di?n t�ch s? d?ng chung. </P>
     *
     * @param landPublicArea Nh� d?t - Di?n t�ch s? d?ng chung
     */
    public void setLandPublicArea(String landPublicArea) {
        this.landPublicArea = landPublicArea;
    }

    /**
     * <P>Get Nh� d?t - Di?n t�ch s? d?ng ri�ng </P>
     *
     * @return Nh� d?t - Di?n t�ch s? d?ng ri�ng
     */
    public String getLandPrivateArea() {
        return this.landPrivateArea;
    }

    /**
     * <P>Set Nh� d?t - Di?n t�ch s? d?ng ri�ng. </P>
     *
     * @param landPrivateArea Nh� d?t - Di?n t�ch s? d?ng ri�ng
     */
    public void setLandPrivateArea(String landPrivateArea) {
        this.landPrivateArea = landPrivateArea;
    }

    /**
     * <P>Get Nh� d?t - M?c d�ch s? d?ng </P>
     *
     * @return Nh� d?t - M?c d�ch s? d?ng
     */
    public String getLandUsePurpose() {
        return this.landUsePurpose;
    }

    /**
     * <P>Set Nh� d?t - M?c d�ch s? d?ng. </P>
     *
     * @param landUsePurpose Nh� d?t - M?c d�ch s? d?ng
     */
    public void setLandUsePurpose(String landUsePurpose) {
        this.landUsePurpose = landUsePurpose;
    }

    /**
     * <P>Get Nh� d?t - M?c d�ch s? d?ng </P>
     *
     * @return Nh� d?t - M?c d�ch s? d?ng
     */
    public String getLandUsePeriod() {
        return this.landUsePeriod;
    }

    /**
     * <P>Set Nh� d?t - M?c d�ch s? d?ng. </P>
     *
     * @param landUsePeriod Nh� d?t - M?c d�ch s? d?ng
     */
    public void setLandUsePeriod(String landUsePeriod) {
        this.landUsePeriod = landUsePeriod;
    }

    /**
     * <P>Get Nh� d?t - M?c d�ch s? d?ng </P>
     *
     * @return Nh� d?t - M?c d�ch s? d?ng
     */
    public String getLandUseOrigin() {
        return this.landUseOrigin;
    }

    /**
     * <P>Set Nh� d?t - M?c d�ch s? d?ng. </P>
     *
     * @param landUseOrigin Nh� d?t - M?c d�ch s? d?ng
     */
    public void setLandUseOrigin(String landUseOrigin) {
        this.landUseOrigin = landUseOrigin;
    }

    /**
     * <P>Get Nh� d?t - �?a b�n T?nh/Th�nh </P>
     *
     * @return Nh� d?t - �?a b�n T?nh/Th�nh
     */
    public String getLandDistrict() {
        return this.landDistrict;
    }

    /**
     * <P>Set Nh� d?t - �?a b�n T?nh/Th�nh. </P>
     *
     * @param landDistrict Nh� d?t - �?a b�n T?nh/Th�nh
     */
    public void setLandDistrict(String landDistrict) {
        this.landDistrict = landDistrict;
    }

    /**
     * <P>Get Nh� d?t - �?a b�n Qu?n/Huy?n  </P>
     *
     * @return Nh� d?t - �?a b�n Qu?n/Huy?n
     */
    public Long getLandProvince() {
        return this.landProvince;
    }

    /**
     * <P>Set Nh� d?t - �?a b�n Qu?n/Huy?n . </P>
     *
     * @param landProvince Nh� d?t - �?a b�n Qu?n/Huy?n
     */
    public void setLandProvince(Long landProvince) {
        this.landProvince = landProvince;
    }

    /**
     * <P>Get tai san gan lien voi dat. </P>
     *
     * @return the landAssociateProperty
     */
    public String getLandAssociateProperty() {
        return landAssociateProperty;
    }


    /**
     * <P>Set tai san gan lien voi dat. </P>
     *
     * @param landAssociateProperty the landAssociateProperty to set
     */
    public void setLandAssociateProperty(String landAssociateProperty) {
        this.landAssociateProperty = landAssociateProperty;
    }


    /**
     * <P>Get � t�, Motor - Bi?n ki?m so�t </P>
     *
     * @return � t�, Motor - Bi?n ki?m so�t
     */
    public String getCarLicenseNumber() {
        return this.carLicenseNumber;
    }

    /**
     * <P>Set � t�, Motor - Bi?n ki?m so�t. </P>
     *
     * @param carLicenseNumber � t�, Motor - Bi?n ki?m so�t
     */
    public void setCarLicenseNumber(String carLicenseNumber) {
        this.carLicenseNumber = carLicenseNumber;
    }

    /**
     * <P>Get � t�, Motor - S? dang k� </P>
     *
     * @return � t�, Motor - S? dang k�
     */
    public String getCarRegistNumber() {
        return this.carRegistNumber;
    }

    /**
     * <P>Set � t�, Motor - S? dang k�. </P>
     *
     * @param carRegistNumber � t�, Motor - S? dang k�
     */
    public void setCarRegistNumber(String carRegistNumber) {
        this.carRegistNumber = carRegistNumber;
    }

    /**
     * <P>Get � t�, Motor - Noi c?p GCN </P>
     *
     * @return � t�, Motor - Noi c?p GCN
     */
    public String getCarIssuePlace() {
        return this.carIssuePlace;
    }

    /**
     * <P>Set � t�, Motor - Noi c?p GCN. </P>
     *
     * @param carIssuePlace � t�, Motor - Noi c?p GCN
     */
    public void setCarIssuePlace(String carIssuePlace) {
        this.carIssuePlace = carIssuePlace;
    }

    /**
     * <P>Get � t�, Motor  - Ng�y c?p GCN </P>
     *
     * @return � t�, Motor  - Ng�y c?p GCN
     */
    public Timestamp getCarIssueDate() {
        return this.carIssueDate;
    }

    /**
     * <P>Set � t�, Motor  - Ng�y c?p GCN. </P>
     *
     * @param carIssueDate � t�, Motor  - Ng�y c?p GCN
     */
    public void setCarIssueDate(Timestamp carIssueDate) {
        this.carIssueDate = carIssueDate;
    }

    /**
     * <P>Get � t�, Motor - S? khung  </P>
     *
     * @return � t�, Motor - S? khung
     */
    public String getCarFrameNumber() {
        return this.carFrameNumber;
    }

    /**
     * <P>Set � t�, Motor - S? khung . </P>
     *
     * @param carFrameNumber � t�, Motor - S? khung
     */
    public void setCarFrameNumber(String carFrameNumber) {
        this.carFrameNumber = carFrameNumber;
    }

    /**
     * <P>Get � t�, Motor - S? m�y </P>
     *
     * @return � t�, Motor - S? m�y
     */
    public String getCarMachineNumber() {
        return this.carMachineNumber;
    }

    /**
     * <P>Set � t�, Motor - S? m�y. </P>
     *
     * @param carMachineNumber � t�, Motor - S? m�y
     */
    public void setCarMachineNumber(String carMachineNumber) {
        this.carMachineNumber = carMachineNumber;
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
