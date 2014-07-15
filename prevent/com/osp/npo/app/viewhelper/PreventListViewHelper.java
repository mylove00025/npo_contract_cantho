package com.osp.npo.app.viewhelper;

import java.util.List;

import com.osp.npo.app.form.PreventListForm;
import com.osp.npo.core.basicData.DistrictInfo;
import com.osp.npo.core.basicData.PropertyInfo;
import com.osp.npo.core.prevent.DataPreventInfo;
import com.osp.npo.core.prevent.TransactionPropertyInfo;

/**
 * <P>Prevent List View Helper</P>
 * 
 * @author HungPT 
 * @version $Revision: 29790 $
 */
public class PreventListViewHelper extends AbstractPageListViewHelper {
    
    public static final String SESSION_KEY = "preventListViewHelper";
    
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
    
    private List<PropertyInfo> propertyList;
    private List<DataPreventInfo> dataPreventList;
    private List<TransactionPropertyInfo> transactionPropertyList;
	
	private Boolean isHidePanelSearch = Boolean.FALSE;
    private Boolean isAdvanceSearch = Boolean.FALSE;
    private Boolean displayPreventList = Boolean.TRUE;
    
    private String keyHighLight;
    
    private int pageProperty = 1;

    private int totalPageProperty = 1;

    private int totalCountProperty = 0;
    
    private boolean luceneSearch = Boolean.FALSE;
    
    private String district;
    
    private List<DistrictInfo> districtList;
    
    private String street;
    
    private String ownerInfo;
    
    private boolean sortType = true;
    
    private List<String> subkeyList;
    
    private List<String> searchList;

    private java.util.Date searchTime;
    
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
     * Get the propertyList
     *
     * @return the propertyList
     */
    public List<PropertyInfo> getPropertyList() {
        return propertyList;
    }

    /**
     * Set the propertyList
     *
     * @param propertyList the propertyList to set
     */
    public void setPropertyList(List<PropertyInfo> propertyList) {
        this.propertyList = propertyList;
    }

    /**
     * Get the dataPreventList
     *
     * @return the dataPreventList
     */
    public List<DataPreventInfo> getDataPreventList() {
        return dataPreventList;
    }

    /**
     * Set the dataPreventList
     *
     * @param dataPreventList the dataPreventList to set
     */
    public void setDataPreventList(List<DataPreventInfo> dataPreventList) {
        this.dataPreventList = dataPreventList;
    }

    /**
     * Get the transactionPropertyList
     *
     * @return the transactionPropertyList
     */
    public List<TransactionPropertyInfo> getTransactionPropertyList() {
        return transactionPropertyList;
    }

    /**
     * Set the transactionPropertyList
     *
     * @param transactionPropertyList the transactionPropertyList to set
     */
    public void setTransactionPropertyList(List<TransactionPropertyInfo> transactionPropertyList) {
        this.transactionPropertyList = transactionPropertyList;
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
     * Get the keyHighLight
     *
     * @return the keyHighLight
     */
    public String getKeyHighLight() {
        return keyHighLight;
    }

    /**
     * Set the keyHighLight
     *
     * @param keyHighLight the keyHighLight to set
     */
    public void setKeyHighLight(String keyHighLight) {
        this.keyHighLight = keyHighLight;
    }

    /**
     * Get the pageProperty
     *
     * @return the pageProperty
     */
    public int getPageProperty() {
        return pageProperty;
    }

    /**
     * Set the pageProperty
     *
     * @param pageProperty the pageProperty to set
     */
    public void setPageProperty(int pageProperty) {
        this.pageProperty = pageProperty;
    }

    /**
     * Get the totalPageProperty
     *
     * @return the totalPageProperty
     */
    public int getTotalPageProperty() {
        return totalPageProperty;
    }

    /**
     * Set the totalPageProperty
     *
     * @param totalPageProperty the totalPageProperty to set
     */
    public void setTotalPageProperty(int totalPageProperty) {
        this.totalPageProperty = totalPageProperty;
    }

    /**
     * Get the totalCountProperty
     *
     * @return the totalCountProperty
     */
    public int getTotalCountProperty() {
        return totalCountProperty;
    }

    /**
     * Set the totalCountProperty
     *
     * @param totalCountProperty the totalCountProperty to set
     */
    public void setTotalCountProperty(int totalCountProperty) {
        this.totalCountProperty = totalCountProperty;
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
     * <P>Save data from Form to View Helper </P>
     * 
     * @author HungPT
     * @param form
     */
    public void reset(PreventListForm form) {
        
        this.setCarFrameNumber(form.getCarFrameNumber());
        this.setCarLicenseNumber(form.getCarLicenseNumber());
        this.setCarMachineNumber(form.getCarMachineNumber());
        this.setCarRegistNumber(form.getCarRegistNumber());
        this.setLandAddress(form.getLandAddress());
        this.setLandCertificate(form.getLandCertificate());
        this.setLandMapNumber(form.getLandMapNumber());
        this.setLandNumber(form.getLandNumber());
        this.setPropertyInfo(form.getPropertyInfo());
        this.setType(form.getType());
        this.setOriginKind(form.getOriginKind());
		this.setTypeKeySearch(form.getTypeKeySearch());
        this.setKeySearch(form.getKeySearch());
        this.setIsAdvanceSearch(form.getIsAdvanceSearch());
        this.setIsHidePanelSearch(form.getIsHidePanelSearch());
        this.setDisplayPreventList(form.getDisplayPreventList());
        this.setReleaseFlg(form.getReleaseFlg());
        this.setOwnerInfo(form.getOwnerInfo());
        this.setStreet(form.getStreet());
        this.setDistrict(form.getDistrict());
        this.setSortType(form.getSortType());
        this.setOfficeCode(form.getOfficeCode());
    }

	/**
	 * @param luceneSearch the luceneSearch to set
	 */
	public void setLuceneSearch(boolean luceneSearch) {
		this.luceneSearch = luceneSearch;
	}

	/**
	 * @return the luceneSearch
	 */
	public boolean isLuceneSearch() {
		return luceneSearch;
	}

	/**
	 * @param district the district to set
	 */
	public void setDistrict(String district) {
		this.district = district;
	}

	/**
	 * @return the district
	 */
	public String getDistrict() {
		return district;
	}

	/**
	 * @param districtList the districtList to set
	 */
	public void setDistrictList(List<DistrictInfo> districtList) {
		this.districtList = districtList;
	}

	/**
	 * @return the districtList
	 */
	public List<DistrictInfo> getDistrictList() {
		return districtList;
	}

	/**
	 * @param street the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * @param ownerInfo the ownerInfo to set
	 */
	public void setOwnerInfo(String ownerInfo) {
		this.ownerInfo = ownerInfo;
	}

	/**
	 * @return the ownerInfo
	 */
	public String getOwnerInfo() {
		return ownerInfo;
	}

	public void setSortType(boolean sortType) {
		this.sortType = sortType;
	}

	public boolean getSortType() {
		return sortType;
	}

	/**
	 * @param subkeyList the subkeyList to set
	 */
	public void setSubkeyList(List<String> subkeyList) {
		this.subkeyList = subkeyList;
	}

	/**
	 * @return the subkeyList
	 */
	public List<String> getSubkeyList() {
		return subkeyList;
	}

	public List<String> getSearchList() {
		return searchList;
	}

	public void setSearchList(List<String> searchList) {
		this.searchList = searchList;
	}
	/**
	 * @param date the searchTime to set
	 */
	public void setSearchTime(java.util.Date date) {
		this.searchTime = date;
	}

	/**
	 * @return the searchTime
	 */
	public java.util.Date getSearchTime() {
		return searchTime;
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
}
