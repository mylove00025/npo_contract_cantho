package com.osp.npo.app.context;

/**
 * <P>Prevent Context</P>
 * 
 * @author  HungPT 
 * <BR>
 */
public class PreventContext {

    public static final String SESSION_KEY = "PreventContext";
    
    private String type;

    private String propertyInfo;

    private String landCertificate;

    private String landMapNumber;

    private String landNumber;
    
    private String landAddress;

    private String carLicenseNumber;

    private String carRegistNumber;

    private String carFrameNumber;

    private String carMachineNumber;
    
    private String typeKeySearch;
    
    private String keySearch;
    
    private String originKind;
    
    private String releaseFlg;
    
    private Boolean isHidePanelSearch = Boolean.FALSE;
    
    private Boolean isAdvanceSearch = Boolean.FALSE;
    
    private Boolean displayPreventList = Boolean.TRUE;

    private String officeCode;
    
    /**
     * Get the type
     *
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * Set the type
     *
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Get the propertyInfo
     *
     * @return the propertyInfo
     */
    public String getPropertyInfo() {
        return propertyInfo;
    }

    /**
     * Set the propertyInfo
     *
     * @param propertyInfo the propertyInfo to set
     */
    public void setPropertyInfo(String propertyInfo) {
        this.propertyInfo = propertyInfo;
    }

    /**
     * Get the landCertificate
     *
     * @return the landCertificate
     */
    public String getLandCertificate() {
        return landCertificate;
    }

    /**
     * Set the landCertificate
     *
     * @param landCertificate the landCertificate to set
     */
    public void setLandCertificate(String landCertificate) {
        this.landCertificate = landCertificate;
    }

    /**
     * Get the landMapNumber
     *
     * @return the landMapNumber
     */
    public String getLandMapNumber() {
        return landMapNumber;
    }

    /**
     * Set the landMapNumber
     *
     * @param landMapNumber the landMapNumber to set
     */
    public void setLandMapNumber(String landMapNumber) {
        this.landMapNumber = landMapNumber;
    }

    /**
     * Get the landNumber
     *
     * @return the landNumber
     */
    public String getLandNumber() {
        return landNumber;
    }

    /**
     * Set the landNumber
     *
     * @param landNumber the landNumber to set
     */
    public void setLandNumber(String landNumber) {
        this.landNumber = landNumber;
    }

    /**
     * Get the landAddress
     *
     * @return the landAddress
     */
    public String getLandAddress() {
        return landAddress;
    }

    /**
     * Set the landAddress
     *
     * @param landAddress the landAddress to set
     */
    public void setLandAddress(String landAddress) {
        this.landAddress = landAddress;
    }

    /**
     * Get the carLicenseNumber
     *
     * @return the carLicenseNumber
     */
    public String getCarLicenseNumber() {
        return carLicenseNumber;
    }

    /**
     * Set the carLicenseNumber
     *
     * @param carLicenseNumber the carLicenseNumber to set
     */
    public void setCarLicenseNumber(String carLicenseNumber) {
        this.carLicenseNumber = carLicenseNumber;
    }

    /**
     * Get the carRegistNumber
     *
     * @return the carRegistNumber
     */
    public String getCarRegistNumber() {
        return carRegistNumber;
    }

    /**
     * Set the carRegistNumber
     *
     * @param carRegistNumber the carRegistNumber to set
     */
    public void setCarRegistNumber(String carRegistNumber) {
        this.carRegistNumber = carRegistNumber;
    }

    /**
     * Get the carFrameNumber
     *
     * @return the carFrameNumber
     */
    public String getCarFrameNumber() {
        return carFrameNumber;
    }

    /**
     * Set the carFrameNumber
     *
     * @param carFrameNumber the carFrameNumber to set
     */
    public void setCarFrameNumber(String carFrameNumber) {
        this.carFrameNumber = carFrameNumber;
    }

    /**
     * Get the carMachineNumber
     *
     * @return the carMachineNumber
     */
    public String getCarMachineNumber() {
        return carMachineNumber;
    }

    /**
     * Set the carMachineNumber
     *
     * @param carMachineNumber the carMachineNumber to set
     */
    public void setCarMachineNumber(String carMachineNumber) {
        this.carMachineNumber = carMachineNumber;
    }

    /**
     * Get the typeKeySearch
     *
     * @return the typeKeySearch
     */
    public String getTypeKeySearch() {
        return typeKeySearch;
    }

    /**
     * Set the typeKeySearch
     *
     * @param typeKeySearch the typeKeySearch to set
     */
    public void setTypeKeySearch(String typeKeySearch) {
        this.typeKeySearch = typeKeySearch;
    }

    /**
     * Get the keySearch
     *
     * @return the keySearch
     */
    public String getKeySearch() {
        return keySearch;
    }

    /**
     * Set the keySearch
     *
     * @param keySearch the keySearch to set
     */
    public void setKeySearch(String keySearch) {
        this.keySearch = keySearch;
    }

    /**
     * Get the originKind
     *
     * @return the originKind
     */
    public String getOriginKind() {
        return originKind;
    }

    /**
     * Set the originKind
     *
     * @param originKind the originKind to set
     */
    public void setOriginKind(String originKind) {
        this.originKind = originKind;
    }

    /**
     * Get the isHidePanelSearch
     *
     * @return the isHidePanelSearch
     */
    public Boolean getIsHidePanelSearch() {
        return isHidePanelSearch;
    }

    /**
     * Set the isHidePanelSearch
     *
     * @param isHidePanelSearch the isHidePanelSearch to set
     */
    public void setIsHidePanelSearch(Boolean isHidePanelSearch) {
        this.isHidePanelSearch = isHidePanelSearch;
    }

    /**
     * Get the isAdvanceSearch
     *
     * @return the isAdvanceSearch
     */
    public Boolean getIsAdvanceSearch() {
        return isAdvanceSearch;
    }

    /**
     * Set the isAdvanceSearch
     *
     * @param isAdvanceSearch the isAdvanceSearch to set
     */
    public void setIsAdvanceSearch(Boolean isAdvanceSearch) {
        this.isAdvanceSearch = isAdvanceSearch;
    }

    /**
     * Get the displayPreventList
     *
     * @return the displayPreventList
     */
    public Boolean getDisplayPreventList() {
        return displayPreventList;
    }

    /**
     * Set the displayPreventList
     *
     * @param displayPreventList the displayPreventList to set
     */
    public void setDisplayPreventList(Boolean displayPreventList) {
        this.displayPreventList = displayPreventList;
    }
    
    /**
     * Get the releaseFlg
     *
     * @return the releaseFlg
     */
    public String getReleaseFlg() {
        return releaseFlg;
    }

    /**
     * Set the releaseFlg
     *
     * @param releaseFlg the releaseFlg to set
     */
    public void setReleaseFlg(String releaseFlg) {
        this.releaseFlg = releaseFlg;
    }

    /**
	 * Get officeCode
	 * @return the officeCode
	 */
	public String getOfficeCode() {
		return officeCode;
	}

	/**
	 * Set officeCode
	 * @param officeCode the officeCode to set
	 */
	public void setOfficeCode(String officeCode) {
		this.officeCode = officeCode;
	}

	/**
     * Clear context
     *     
     */
    public void clear() {
        this.type = null;
        this.propertyInfo = null;
        this.landCertificate = null;
        this.landMapNumber = null;
        this.landNumber = null;        
        this.landAddress = null;
        this.carLicenseNumber = null;
        this.carRegistNumber = null;
        this.carFrameNumber = null;
        this.carMachineNumber = null;        
        this.typeKeySearch = null;        
        this.keySearch = null;        
        this.originKind = null;
        this.releaseFlg = null;
        this.officeCode = null;
    }
}
