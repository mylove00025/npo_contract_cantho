package com.osp.npo.app.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.osp.npo.app.viewhelper.PreventListViewHelper;

/**
 * <P>Prevent List Form</P>
 * 
 * @author HungPT 
 * @version $Revision: 29790 $
 */
public class PreventListForm extends ActionForm {
    
    private static final long serialVersionUID = -3993074335381284464L;
    
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
    
    private String direction;
    
    private Boolean isHidePanelSearch = Boolean.FALSE;
    
    private Boolean isAdvanceSearch = Boolean.TRUE;
    
    private Boolean displayPreventList = Boolean.TRUE;
    
    private String district;
    
    private String street;
    
    private String ownerInfo;
    
    private boolean sortType = true;
    
    private String officeCode;
    
    /**
     * Get the type
     *
     * @return the type
     */
    public String getType() {
    	if (type != null) {
            return type.trim();
        }
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
        if (propertyInfo != null) {
            return propertyInfo.trim();
        }
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
        if (landCertificate != null) {
            return landCertificate.trim();
        }
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
        if (landMapNumber != null) {
            return landMapNumber.trim();
        }
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
        if (landNumber != null) {
            return landNumber.trim();
        }
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
        if (landAddress != null) {
            return landAddress.trim();
        }
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
        if (carLicenseNumber != null) {
            return carLicenseNumber.trim();
        }
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
        if (carRegistNumber != null) {
            return carRegistNumber.trim();
        }
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
        if (carFrameNumber != null) {
            return carFrameNumber.trim();
        }
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
        if (carMachineNumber != null) {
            return carMachineNumber.trim();
        }
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
    	if (typeKeySearch != null) {
            return typeKeySearch.trim();
        }
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
        if (keySearch != null) {
            return keySearch.trim();
        }
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
     * Get the direction
     *
     * @return the direction
     */
    public String getDirection() {
    	if (direction != null) {
            return direction.trim();
        }
        return direction;
    }



    /**
     * Set the direction
     *
     * @param direction the direction to set
     */
    public void setDirection(String direction) {
        this.direction = direction;
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
     * Get the originKind
     *
     * @return the originKind
     */
    public String getOriginKind() {
    	if (originKind != null) {
            return originKind.trim();
        }
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
    	if (releaseFlg != null) {
            return releaseFlg.trim();
        }
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
	 * @param district the district to set
	 */
	public void setDistrict(String district) {
		this.district = district;
	}



	/**
	 * @return the district
	 */
	public String getDistrict() {
		if (district != null) {
            return district.trim();
        }
		return district;
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
		if (street != null) {
            return street.trim();
        }
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
		if (ownerInfo != null) {
            return ownerInfo.trim();
        }
		return ownerInfo;
	}



	/*
     * (non-Javadoc)
     * 
     * @see org.apache.struts.action.ActionForm#validate(org.apache.struts.action.ActionMapping,
     *      javax.servlet.http.HttpServletRequest)
     */
    @Override
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        
        ActionErrors errors = new ActionErrors();
        
        PreventListViewHelper preventListViewHelper = (PreventListViewHelper)request.getSession().getAttribute(PreventListViewHelper.SESSION_KEY);
        if (preventListViewHelper == null) {
            return errors;
        }
        
        preventListViewHelper.reset(this);
        
        return errors;
    }



	public void setSortType(boolean sortType) {
		this.sortType = sortType;
	}



	public boolean getSortType() {
		return sortType;
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
