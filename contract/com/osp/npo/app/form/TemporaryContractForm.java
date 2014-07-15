package com.osp.npo.app.form;
import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;
import org.apache.struts.validator.ValidatorForm;

import com.osp.npo.app.message.MessageUtil;
import com.osp.npo.app.viewhelper.TemporaryContractViewHelper;
import com.osp.npo.common.util.EditString;
import com.osp.npo.common.util.RelateDateTime;

/**
 * <P>Temporary Contract Form</P>
 * 
 * @author SonHD 
 * @version $Revision: 26096 $
 */
public class TemporaryContractForm extends ValidatorForm {

    private static final long serialVersionUID = -8053525789046420933L;
    
    private static final long CONTRACT_TEMPALTE_NONE_SELECTED = 0;

    private Long contractId;
    
    private Long contractKindId;
    
    private String contractKindName;
    
    private String contractNumber;
    
    private Long contractTemplateId;
    
    private String contractTemplateName;
    
    private String relationObjectA;
    
    private String relationObjectB;
    
    private String relationObjectC;  
    
    private String contractComment;
    
    private String contractValue;
    
    private Long notaryId;
    
    private Long drafterId;
    
    private String receivedDate;
    
    private String notaryDate;
    
    private String notaryPlace;
    
    private Boolean notaryPlaceFlag;
    
    private String contractSummary;
    
    private String costTt91;
    
    private String costDraft;
    
    private String costNotaryOutsite;
    
    private String costOtherDetermine;
    
    private String costTotal;
    
    private Long bankId;
    
    private String crediterName;
    
    private String bankServiceFee;
    
    private String fileName;
    
    private String originalStorePlace;
    
    private FormFile formFile;
    
    private Boolean errorStatus;
    
    private String errorDescription;
    
    private String errorAgent;
    
    private String errorUserFamilyName;
    
    private String errorUserFirstName;
    
    private String bankName;
    
    private String notaryFamilyName;
    
    private String notaryFirstName;
    
    private String drafterFamilyName;
    
    private String drafterFirstName;
    
    private String contractNote;
    
    private String userRequireContract;
    
    private String numberCopyOfContract;
    
    private String numberOfPage;
    
    //comment
    private Long ccid;

    
    //Property
    private String propertyType;
    
    private String propertyCodeLand;
    
    private String propertyCodeVehicle;
    
    private String propertyCodeOther;
    
    private Long provinceLand;
    
    private String provinceName;
    
    private String districtName;
    
    private Long provinceVehicle; 
    
    private Long district;
    
    private String mapNumber;
    
    private String landNumber;
    
    private String landAddress;
    
    private String landArea;
    
    private String landCertificate;

    private String landIssuePlace;
    
    private String landIssueDate;
    
    private String landMapNumber;
    
    private String landPublicArea;

    private String landPrivateArea;

    private String landUsePurpose;

    private String landUsePeriod;

    private String landUseOrigin;
    
    private String landAssociateProperty;
    
    private String carLicenseNumber;

    private String carRegistNumber;

    private String carIssuePlace;

    private String carIssueDate;

    private String carFrameNumber;

    private String carMachineNumber;

    private String frameNumber;
    
    private String machineNumber;
    
    private String ownerName;
    
    private String ownerIdCard;
    
    private String ownerAddress;
    
    private String propertyOtherInfo;
    
    private String ownerInfo;

    private String otherInfo;
    
    private String givenDateVehicle;
    
    private String givenDateLand;
    
    //Many Property
    private String titlePopup;
    
    private String propertyTypePopup;
    
    private String propertyCodeLandPopup;
    
    private String propertyCodeVehiclePopup;
    
    private String propertyCodeOtherPopup;
    
    private Long provinceLandPopup;
    
    private String provinceLandNamePopup;
    
    private Long provinceVehiclePopup; 
    
    private String provinceVehicleNamePopup;
    
    private Long districtPopup;
    
    private String mapNumberPopup;
    
    private String landNumberPopup;
    
    private String landAddressPopup;
    
    private String frameNumberPopup;
    
    private String machineNumberPopup;
    
    private String ownerNamePopup;
    
    private String ownerIdCardPopup;
    
    private String ownerAddressPopup;
    
    private String propertyOtherInfoPopup;
    
    private String givenDateVehiclePopup;
    
    private String givenDateLandPopup;
    
    private String numberProperty = "1";
    
    private Boolean isAddnew = Boolean.TRUE;
    
    private Integer propertySelectedIndex;
    
    private Boolean fileExisted = Boolean.FALSE;

	private String propertyInfo;

	private Boolean isHidePanelSearch = Boolean.FALSE;

	private Boolean isHidePanelInfo;

	private Boolean isHidePropertyPanelInfo;
	
    private Boolean isDetailPropertyEntry = Boolean.FALSE;


	
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
     * Get the contractKindId
     *
     * @return the contractKindId
     */
    public Long getContractKindId() {
        return contractKindId;
    }

    /**
     * Set the contractKindId
     *
     * @param contractKindId the contractKindId to set
     */
    public void setContractKindId(Long contractKindId) {
        this.contractKindId = contractKindId;
    }

    /**
     * Get the contractNumber
     *
     * @return the contractNumber
     */
    public String getContractNumber() {
        if (contractNumber != null) {
            return contractNumber.trim();
        }
        return contractNumber;
    }

    /**
     * Set the contractNumber
     *
     * @param contractNumber the contractNumber to set
     */
    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    /**
     * Get the contractTemplateId
     *
     * @return the contractTemplateId
     */
    public Long getContractTemplateId() {
        return contractTemplateId;
    }

    /**
     * Set the contractTemplateId
     *
     * @param contractTemplateId the contractTemplateId to set
     */
    public void setContractTemplateId(Long contractTemplateId) {
        this.contractTemplateId = contractTemplateId;
    }

    /**
     * Get the contractTemplateName
     *
     * @return the contractTemplateName
     */
    public String getContractTemplateName() {
        if (contractTemplateName != null) {
            return contractTemplateName.trim();
        }
        return contractTemplateName;
    }

    /**
     * Set the contractTemplateName
     *
     * @param contractTemplateName the contractTemplateName to set
     */
    public void setContractTemplateName(String contractTemplateName) {
        this.contractTemplateName = contractTemplateName;
    }

    /**
     * Get the contractValue
     *
     * @return the contractValue
     */
    public String getContractValue() {
        if (contractValue != null) {
            if (contractValue.trim() == "") {
                return "0";
            } else {                
                return contractValue.trim();
            }
        }
        return contractValue;
    }

    /**
     * Set the contractValue
     *
     * @param contractValue the contractValue to set
     */
    public void setContractValue(String contractValue) {
        this.contractValue = contractValue;
    }
    
    /**
     * Get the isHidePanelInfo
     *
     * @return the isHidePanelInfo
     */
    public Boolean getIsHidePanelInfo() {
        return isHidePanelInfo;
    }

    /**
     * Set the isHidePanelInfo
     *
     * @param isHidePanelInfo the isHidePanelInfo to set
     */
    public void setIsHidePanelInfo(Boolean isHidePanelInfo) {
        this.isHidePanelInfo = isHidePanelInfo;
    }

    /**
     * Get the isHidePropertyPanelInfo
     *
     * @return the isHidePropertyPanelInfo
     */
    public Boolean getIsHidePropertyPanelInfo() {
        return isHidePropertyPanelInfo;
    }

    /**
     * Set the isHidePropertyPanelInfo
     *
     * @param isHidePropertyPanelInfo the isHidePropertyPanelInfo to set
     */
    public void setIsHidePropertyPanelInfo(Boolean isHidePropertyPanelInfo) {
        this.isHidePropertyPanelInfo = isHidePropertyPanelInfo;
    }
    /**
     * Get the notaryId
     *
     * @return the notaryId
     */
    public Long getNotaryId() {
        return notaryId;
    }

    /**
     * Set the notaryId
     *
     * @param notaryId the notaryId to set
     */
    public void setNotaryId(Long notaryId) {
        this.notaryId = notaryId;
    }

    /**
     * Get the drafterId
     *
     * @return the drafterId
     */
    public Long getDrafterId() {
        return drafterId;
    }

    /**
     * Set the drafterId
     *
     * @param drafterId the drafterId to set
     */
    public void setDrafterId(Long drafterId) {
        this.drafterId = drafterId;
    }

    /**
     * Get the receivedDate
     *
     * @return the receivedDate
     */
    public String getReceivedDate() {
        if (receivedDate != null) {
            return receivedDate.trim();
        }
        return receivedDate;
    }

    /**
     * Get the bankName
     *
     * @return the bankName
     */
    public String getBankName() {
        if (bankName != null) {
            return bankName.trim();
        }
        return bankName;
    }

    /**
     * Set the bankName
     *
     * @param bankName the bankName to set
     */
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    /**
     * Set the receivedDate
     *
     * @param receivedDate the receivedDate to set
     */
    public void setReceivedDate(String receivedDate) {
        this.receivedDate = receivedDate;
    }

    /**
     * Get the notaryDate
     *
     * @return the notaryDate
     */
    public String getNotaryDate() {
        if (notaryDate != null) {
            return notaryDate.trim();
        }
        return notaryDate;
    }

    /**
     * Set the notaryDate
     *
     * @param notaryDate the notaryDate to set
     */
    public void setNotaryDate(String notaryDate) {
        this.notaryDate = notaryDate;
    }

    /**
     * Get the notaryPlace
     *
     * @return the notaryPlace
     */
    public String getNotaryPlace() {
        if (notaryPlace != null) {
            return notaryPlace.trim();
        }
        return notaryPlace;
    }

    /**
     * Set the notaryPlace
     *
     * @param notaryPlace the notaryPlace to set
     */
    public void setNotaryPlace(String notaryPlace) {
        this.notaryPlace = notaryPlace;
    }

    /**
     * Get the costTt91
     *
     * @return the costTt91
     */
    public String getCostTt91() {
        if (costTt91 != null) {
            if (costTt91.trim() == "") {
                return "0";
            } else {
                return costTt91.trim();
            }
        }
        return costTt91;
    }

    /**
     * Set the costTt91
     *
     * @param costTt91 the costTt91 to set
     */
    public void setCostTt91(String costTt91) {
        this.costTt91 = costTt91;
    }

    /**
     * Get the costDraft
     *
     * @return the costDraft
     */
    public String getCostDraft() {
        if (costDraft != null) {
            if (costDraft.trim() == "") {
                return "0";
            } else {
                return costDraft.trim();
            }
        }
        return costDraft;
    }

    /**
     * Set the costDraft
     *
     * @param costDraft the costDraft to set
     */
    public void setCostDraft(String costDraft) {
        this.costDraft = costDraft;
    }

    /**
     * Get the costNotaryOutsite
     *
     * @return the costNotaryOutsite
     */
    public String getCostNotaryOutsite() {
        if (costNotaryOutsite != null) {
            if (costNotaryOutsite.trim() == "") {
                return "0";
            } else {
                return costNotaryOutsite.trim();
            }
        }
        return costNotaryOutsite;
    }

    /**
     * Set the costNotaryOutsite
     *
     * @param costNotaryOutsite the costNotaryOutsite to set
     */
    public void setCostNotaryOutsite(String costNotaryOutsite) {
        this.costNotaryOutsite = costNotaryOutsite;
    }

    /**
     * Get the costOtherDetermine
     *
     * @return the costOtherDetermine
     */
    public String getCostOtherDetermine() {
        if (costOtherDetermine != null) {
            if (costOtherDetermine.trim() == "") {
                return "0";
            } else {
                return costOtherDetermine.trim();
            }
        }
        return costOtherDetermine;
    }

    /**
     * Set the costOtherDetermine
     *
     * @param costOtherDetermine the costOtherDetermine to set
     */
    public void setCostOtherDetermine(String costOtherDetermine) {
        this.costOtherDetermine = costOtherDetermine;
    }

    /**
     * Get the costTotal
     *
     * @return the costTotal
     */
    public String getCostTotal() {
        if (costTotal != null) {
            if (costTotal.trim() == "") {
                return "0";
            } else {
                return costTotal.trim();
            }
        }
        return costTotal;
    }

    /**
     * Set the costTotal
     *
     * @param costTotal the costTotal to set
     */
    public void setCostTotal(String costTotal) {
        this.costTotal = costTotal;
    }

    /**
     * Get the bankId
     *
     * @return the bankId
     */
    public Long getBankId() {
        return bankId;
    }

    /**
     * Set the bankId
     *
     * @param bankId the bankId to set
     */
    public void setBankId(Long bankId) {
        this.bankId = bankId;
    }

    /**
     * Get the crediterName
     *
     * @return the crediterName
     */
    public String getCrediterName() {
        if (crediterName != null) {
            return crediterName.trim();
        }
        return crediterName;
    }

    /**
     * Set the crediterName
     *
     * @param crediterName the crediterName to set
     */
    public void setCrediterName(String crediterName) {
        this.crediterName = crediterName;
    }

    /**
     * Get the bankServiceFee
     *
     * @return the bankServiceFee
     */
    public String getBankServiceFee() {
        if (bankServiceFee != null) {
            return bankServiceFee.trim();
        }
        return bankServiceFee;
    }

    /**
     * Set the bankServiceFee
     *
     * @param bankServiceFee the bankServiceFee to set
     */
    public void setBankServiceFee(String bankServiceFee) {
        this.bankServiceFee = bankServiceFee;
    }

    /**
     * Get the fileName
     *
     * @return the fileName
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * Set the fileName
     *
     * @param fileName the fileName to set
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Get the originalStorePlace
     *
     * @return the originalStorePlace
     */
    public String getOriginalStorePlace() {
        if (originalStorePlace != null) {
            return originalStorePlace.trim();
        }
        return originalStorePlace;
    }

    /**
     * Set the originalStorePlace
     *
     * @param originalStorePlace the originalStorePlace to set
     */
    public void setOriginalStorePlace(String originalStorePlace) {
        this.originalStorePlace = originalStorePlace;
    }
    
    /**
     * Get the formFile
     *
     * @return the formFile
     */
    public FormFile getFormFile() {
        return formFile;
    }

    /**
     * Set the formFile
     *
     * @param formFile the formFile to set
     */
    public void setFormFile(FormFile formFile) {
        this.formFile = formFile;
    }

    /**
     * Get the errorStatus
     *
     * @return the errorStatus
     */
    public Boolean getErrorStatus() {
        return errorStatus;
    }

    /**
     * Set the errorStatus
     *
     * @param errorStatus the errorStatus to set
     */
    public void setErrorStatus(Boolean errorStatus) {
        this.errorStatus = errorStatus;
    }

    /**
     * Get the errorDescription
     *
     * @return the errorDescription
     */
    public String getErrorDescription() {
        if (errorDescription != null) {
            return errorDescription.trim();
        }
        return errorDescription;
    }

    /**
     * Set the errorDescription
     *
     * @param errorDescription the errorDescription to set
     */
    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }

    /**
     * Get the errorAgent
     *
     * @return the errorAgent
     */
    public String getErrorAgent() {
        return errorAgent;
    }

    /**
     * Set the errorAgent
     *
     * @param errorAgent the errorAgent to set
     */
    public void setErrorAgent(String errorAgent) {
        this.errorAgent = errorAgent;
    }
    
    /**
     * Get the propertyType
     *
     * @return the propertyType
     */
    public String getPropertyType() {
        return propertyType;
    }

    /**
     * Set the propertyType
     *
     * @param propertyType the propertyType to set
     */
    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

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
     * Get the propertyId
     *
     * @return the propertyId
     */
    public Long getCcid() {
        return ccid;
    }

    /**
     * Set the propertyId
     *
     * @param propertyId the propertyId to set
     */
    public void setCcid(Long ccid) {
        this.ccid = ccid;
    }
    /**
     * Get the propertyCodeLand
     *
     * @return the propertyCodeLand
     */
    public String getPropertyCodeLand() {
        if (propertyCodeLand != null) {
            return propertyCodeLand.trim();
        }
        return propertyCodeLand;
    }

    /**
     * Set the propertyCodeLand
     *
     * @param propertyCodeLand the propertyCodeLand to set
     */
    public void setPropertyCodeLand(String propertyCodeLand) {
        this.propertyCodeLand = propertyCodeLand;
    }

    /**
     * Get the propertyCodeVehicle
     *
     * @return the propertyCodeVehicle
     */
    public String getPropertyCodeVehicle() {
        if (propertyCodeVehicle != null) {
            return propertyCodeVehicle.trim();
        }
        return propertyCodeVehicle;
    }

    /**
     * Set the propertyCodeVehicle
     *
     * @param propertyCodeVehicle the propertyCodeVehicle to set
     */
    public void setPropertyCodeVehicle(String propertyCodeVehicle) {
        this.propertyCodeVehicle = propertyCodeVehicle;
    }

    /**
     * Get the propertyCodeOther
     *
     * @return the propertyCodeOther
     */
    public String getPropertyCodeOther() {
        if (propertyCodeOther != null) {
            return propertyCodeOther.trim();
        }
        return propertyCodeOther;
    }

    /**
     * Set the propertyCodeOther
     *
     * @param propertyCodeOther the propertyCodeOther to set
     */
    public void setPropertyCodeOther(String propertyCodeOther) {
        this.propertyCodeOther = propertyCodeOther;
    }

    /**
     * Get the provinceLand
     *
     * @return the provinceLand
     */
    public Long getProvinceLand() {
        return provinceLand;
    }

    /**
     * Set the provinceLand
     *
     * @param provinceLand the provinceLand to set
     */
    public void setProvinceLand(Long provinceLand) {
        this.provinceLand = provinceLand;
    }

    /**
     * Get the provinceVehicle
     *
     * @return the provinceVehicle
     */
    public Long getProvinceVehicle() {
        return provinceVehicle;
    }

    /**
     * Set the provinceVehicle
     *
     * @param provinceVehicle the provinceVehicle to set
     */
    public void setProvinceVehicle(Long provinceVehicle) {
        this.provinceVehicle = provinceVehicle;
    }

    /**
     * Get the district
     *
     * @return the district
     */
    public Long getDistrict() {
        return district;
    }

    /**
     * Set the district
     *
     * @param district the district to set
     */
    public void setDistrict(Long district) {
        this.district = district;
    }

    /**
     * Get the mapNumber
     *
     * @return the mapNumber
     */
    public String getMapNumber() {
        if (mapNumber != null) {
            return mapNumber.trim();
        }
        return mapNumber;
    }

    /**
     * Set the mapNumber
     *
     * @param mapNumber the mapNumber to set
     */
    public void setMapNumber(String mapNumber) {
        this.mapNumber = mapNumber;
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
	 * @param landArea the landArea to set
	 */
	public void setLandArea(String landArea) {
		this.landArea = landArea;
	}

	/**
	 * @return the landArea
	 */
	public String getLandArea() {
		if (landArea != null) {
			return landArea.trim();
		}
		return landArea;
	}

	/**
	 * @param landCertificate the landCertificate to set
	 */
	public void setLandCertificate(String landCertificate) {
		this.landCertificate = landCertificate;
	}

	/**
	 * @return the landCertificate
	 */
	public String getLandCertificate() {
		if (landCertificate != null) {
			return landCertificate.trim();
		}
		return landCertificate;
	}

	/**
	 * @param landIssuePlace the landIssuePlace to set
	 */
	public void setLandIssuePlace(String landIssuePlace) {
		this.landIssuePlace = landIssuePlace;
	}

	/**
	 * @return the landIssuePlace
	 */
	public String getLandIssuePlace() {
		if (landIssuePlace != null) {
			return landIssuePlace.trim();
		}
		return landIssuePlace;
	}

	/**
	 * @param landIssueDate the landIssueDate to set
	 */
	public void setLandIssueDate(String landIssueDate) {
		this.landIssueDate = landIssueDate;
	}

	/**
	 * @return the landIssueDate
	 */
	public String getLandIssueDate() {
		if (landIssueDate != null) {
			return landIssueDate.trim();
		}
		return landIssueDate;
	}

	/**
	 * @param landPublicArea the landPublicArea to set
	 */
	public void setLandPublicArea(String landPublicArea) {
		this.landPublicArea = landPublicArea;
	}

	/**
	 * @return the landPublicArea
	 */
	public String getLandPublicArea() {
		if (landPublicArea != null) {
			return landPublicArea.trim();
		}
		return landPublicArea;
	}

	/**
	 * @param landPrivateArea the landPrivateArea to set
	 */
	public void setLandPrivateArea(String landPrivateArea) {
		this.landPrivateArea = landPrivateArea;
	}

	/**
	 * @return the landPrivateArea
	 */
	public String getLandPrivateArea() {
		if (landPrivateArea != null) {
			return landPrivateArea.trim();
		}
		return landPrivateArea;
	}

	/**
	 * @param landUsePurpose the landUsePurpose to set
	 */
	public void setLandUsePurpose(String landUsePurpose) {
		this.landUsePurpose = landUsePurpose;
	}

	/**
	 * @return the landUsePurpose
	 */
	public String getLandUsePurpose() {
		if (landUsePurpose != null) {
			return landUsePurpose.trim();
		}
		return landUsePurpose;
	}

	/**
	 * @param landUsePeriod the landUsePeriod to set
	 */
	public void setLandUsePeriod(String landUsePeriod) {
		this.landUsePeriod = landUsePeriod;
	}

	/**
	 * @return the landUsePeriod
	 */
	public String getLandUsePeriod() {
		if (landUsePeriod != null) {
			return landUsePeriod.trim();
		}
		return landUsePeriod;
	}

	/**
	 * @param landUseOrigin the landUseOrigin to set
	 */
	public void setLandUseOrigin(String landUseOrigin) {
		this.landUseOrigin = landUseOrigin;
	}

	/**
	 * @return the landUseOrigin
	 */
	public String getLandUseOrigin() {
		if (landUseOrigin != null) {
			return landUseOrigin.trim();
		}
		return landUseOrigin;
	}

	/**
	 * @param landMapNumber the landMapNumber to set
	 */
	public void setLandMapNumber(String landMapNumber) {
		this.landMapNumber = landMapNumber;
	}

	/**
	 * @return the landMapNumber
	 */
	public String getLandMapNumber() {
		if (landMapNumber != null) {
			return landMapNumber.trim();
		}
		return landMapNumber;
	}

	/**
	 * @param landAssociateProperty the landAssociateProperty to set
	 */
	public void setLandAssociateProperty(String landAssociateProperty) {
		this.landAssociateProperty = landAssociateProperty;
	}

	/**
	 * @return the landAssociateProperty
	 */
	public String getLandAssociateProperty() {
		if (landAssociateProperty != null) {
			return landAssociateProperty.trim();
		}
		return landAssociateProperty;
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
     * Get the frameNumber
     *
     * @return the frameNumber
     */
    public String getFrameNumber() {
        if (frameNumber != null) {
            return frameNumber.trim();
        }
        return frameNumber;
    }

    /**
	 * @param carLicenseNumber the carLicenseNumber to set
	 */
	public void setCarLicenseNumber(String carLicenseNumber) {
		this.carLicenseNumber = carLicenseNumber;
	}

	/**
	 * @param carRegistNumber the carRegistNumber to set
	 */
	public void setCarRegistNumber(String carRegistNumber) {
		this.carRegistNumber = carRegistNumber;
	}

	/**
	 * @param carIssuePlace the carIssuePlace to set
	 */
	public void setCarIssuePlace(String carIssuePlace) {
		this.carIssuePlace = carIssuePlace;
	}

	/**
	 * @param carIssueDate the carIssueDate to set
	 */
	public void setCarIssueDate(String carIssueDate) {
		this.carIssueDate = carIssueDate;
	}

	/**
	 * @param carFrameNumber the carFrameNumber to set
	 */
	public void setCarFrameNumber(String carFrameNumber) {
		this.carFrameNumber = carFrameNumber;
	}

	/**
	 * @param carMachineNumber the carMachineNumber to set
	 */
	public void setCarMachineNumber(String carMachineNumber) {
		this.carMachineNumber = carMachineNumber;
	}

	/**
	 * @return the carMachineNumber
	 */
	public String getCarMachineNumber() {
		if (carMachineNumber != null) {
			return carMachineNumber.trim();
		}
		return carMachineNumber;
	}

	/**
	 * @return the carFrameNumber
	 */
	public String getCarFrameNumber() {
		if (carFrameNumber != null) {
			return carFrameNumber.trim();
		}
		return carFrameNumber;
	}

	/**
	 * @return the carIssueDate
	 */
	public String getCarIssueDate() {
		if (carIssueDate != null) {
			return carIssueDate.trim();
		}
		return carIssueDate;
	}

	/**
	 * @return the carIssuePlace
	 */
	public String getCarIssuePlace() {
		if (carIssuePlace != null) {
			return carIssuePlace.trim();
		}
		return carIssuePlace;
	}

	/**
	 * @return the carRegistNumber
	 */
	public String getCarRegistNumber() {
		if (carRegistNumber != null) {
			return carRegistNumber.trim();
		}
		return carRegistNumber;
	}

	/**
	 * @return the carLicenseNumber
	 */
	public String getCarLicenseNumber() {
		if (carLicenseNumber != null) {
			return carLicenseNumber.trim();
		}
		return carLicenseNumber;
	}

	/**
     * Set the frameNumber
     *
     * @param frameNumber the frameNumber to set
     */
    public void setFrameNumber(String frameNumber) {
        this.frameNumber = frameNumber;
    }

    /**
     * Get the machineNumber
     *
     * @return the machineNumber
     */
    public String getMachineNumber() {
        if (machineNumber != null) {
            return machineNumber.trim();
        }
        return machineNumber;
    }

    /**
     * Set the machineNumber
     *
     * @param machineNumber the machineNumber to set
     */
    public void setMachineNumber(String machineNumber) {
        this.machineNumber = machineNumber;
    }

    /**
     * Get the ownerName
     *
     * @return the ownerName
     */
    public String getOwnerName() {
        if (ownerName != null) {
            return ownerName.trim();
        }
        return ownerName;
    }

    /**
     * Set the ownerName
     *
     * @param ownerName the ownerName to set
     */
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    /**
     * Get the ownerIdCard
     *
     * @return the ownerIdCard
     */
    public String getOwnerIdCard() {
        if (ownerIdCard != null) {
            return ownerIdCard.trim();
        }
        return ownerIdCard;
    }

    /**
     * Set the ownerIdCard
     *
     * @param ownerIdCard the ownerIdCard to set
     */
    public void setOwnerIdCard(String ownerIdCard) {
        this.ownerIdCard = ownerIdCard;
    }

    /**
     * Get the ownerAddress
     *
     * @return the ownerAddress
     */
    public String getOwnerAddress() {
        if (ownerAddress != null) {
            return ownerAddress.trim();
        }
        return ownerAddress;
    }

    /**
     * Set the ownerAddress
     *
     * @param ownerAddress the ownerAddress to set
     */
    public void setOwnerAddress(String ownerAddress) {
        this.ownerAddress = ownerAddress;
    }

    /**
     * Get the propertyOtherInfo
     *
     * @return the propertyOtherInfo
     */
    public String getPropertyOtherInfo() {
        if (propertyOtherInfo != null) {
            return propertyOtherInfo.trim();
        }
        return propertyOtherInfo;
    }

    /**
     * Set the propertyOtherInfo
     *
     * @param propertyOtherInfo the propertyOtherInfo to set
     */
    public void setPropertyOtherInfo(String propertyOtherInfo) {
        this.propertyOtherInfo = propertyOtherInfo;
    }

    /**
	 * @param ownerInfo the ownerInfo to set
	 */
	public void setOwnerInfo(String ownerInfo) {
		this.ownerInfo = ownerInfo;
	}

	/**
	 * @param otherInfo the otherInfo to set
	 */
	public void setOtherInfo(String otherInfo) {
		this.otherInfo = otherInfo;
	}

	/**
	 * @return the otherInfo
	 */
	public String getOtherInfo() {
		if (otherInfo != null) {
			return otherInfo.trim();
		}
		return otherInfo;
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

	/**
     * Get the givenDateVehicle
     *
     * @return the givenDateVehicle
     */
    public String getGivenDateVehicle() {
        if (givenDateVehicle != null) {
            return givenDateVehicle.trim();
        }
        return givenDateVehicle;
    }

    /**
     * Set the givenDateVehicle
     *
     * @param givenDateVehicle the givenDateVehicle to set
     */
    public void setGivenDateVehicle(String givenDateVehicle) {
        this.givenDateVehicle = givenDateVehicle;
    }

    /**
     * Get the givenDateLand
     *
     * @return the givenDateLand
     */
    public String getGivenDateLand() {
        if (givenDateLand != null) {
            return givenDateLand.trim();
        }
        return givenDateLand;
    }

    /**
     * Set the givenDateLand
     *
     * @param givenDateLand the givenDateLand to set
     */
    public void setGivenDateLand(String givenDateLand) {
        this.givenDateLand = givenDateLand;
    }
    
    /**
     * Get the notaryFamilyName
     *
     * @return the notaryFamilyName
     */
    public String getNotaryFamilyName() {
        if (notaryFamilyName != null) {
            return notaryFamilyName.trim();
        }
        return notaryFamilyName;
    }

    /**
     * Set the notaryFamilyName
     *
     * @param notaryFamilyName the notaryFamilyName to set
     */
    public void setNotaryFamilyName(String notaryFamilyName) {
        this.notaryFamilyName = notaryFamilyName;
    }

    /**
     * Get the notaryFirstName
     *
     * @return the notaryFirstName
     */
    public String getNotaryFirstName() {
        if (notaryFirstName != null) {
            return notaryFirstName.trim();
        }
        return notaryFirstName;
    }

    /**
     * Set the notaryFirstName
     *
     * @param notaryFirstName the notaryFirstName to set
     */
    public void setNotaryFirstName(String notaryFirstName) {
        this.notaryFirstName = notaryFirstName;
    }

    /**
     * Get the drafterFamilyName
     *
     * @return the drafterFamilyName
     */
    public String getDrafterFamilyName() {
        if (drafterFamilyName != null) {
            return drafterFamilyName.trim();
        }
        return drafterFamilyName;
    }

    /**
     * Set the drafterFamilyName
     *
     * @param drafterFamilyName the drafterFamilyName to set
     */
    public void setDrafterFamilyName(String drafterFamilyName) {
        this.drafterFamilyName = drafterFamilyName;
    }

    /**
     * Get the drafterFirstName
     *
     * @return the drafterFirstName
     */
    public String getDrafterFirstName() {
        if (drafterFirstName != null) {
            return drafterFirstName.trim();
        }
        return drafterFirstName;
    }

    /**
     * Set the drafterFirstName
     *
     * @param drafterFirstName the drafterFirstName to set
     */
    public void setDrafterFirstName(String drafterFirstName) {
        this.drafterFirstName = drafterFirstName;
    }

    /**
     * Get the errorUserFamilyName
     *
     * @return the errorUserFamilyName
     */
    public String getErrorUserFamilyName() {
        if (errorUserFamilyName != null) {
            return errorUserFamilyName.trim();
        }
        return errorUserFamilyName;
    }

    /**
     * Set the errorUserFamilyName
     *
     * @param errorUserFamilyName the errorUserFamilyName to set
     */
    public void setErrorUserFamilyName(String errorUserFamilyName) {
        this.errorUserFamilyName = errorUserFamilyName;
    }

    /**
     * Get the errorUserFirstName
     *
     * @return the errorUserFirstName
     */
    public String getErrorUserFirstName() {
        if (errorUserFirstName != null) {
            return errorUserFirstName.trim();
        }
        return errorUserFirstName;
    }

    /**
     * Set the errorUserFirstName
     *
     * @param errorUserFirstName the errorUserFirstName to set
     */
    public void setErrorUserFirstName(String errorUserFirstName) {
        this.errorUserFirstName = errorUserFirstName;
    }

    /**
     * Get the contractNote
     *
     * @return the contractNote
     */
    public String getContractNote() {
        if (contractNote != null) {
            return contractNote.trim();
        }
        return contractNote;
    }

    /**
     * Set the contractNote
     *
     * @param contractNote the contractNote to set
     */
    public void setContractNote(String contractNote) {
        this.contractNote = contractNote;
    }

    /**
     * Get the titlePopup
     *
     * @return the titlePopup
     */
    public String getTitlePopup() {
        if (titlePopup != null) {
            return titlePopup.trim();
        }
        return titlePopup;
    }

    /**
     * Set the titlePopup
     *
     * @param titlePopup the titlePopup to set
     */
    public void setTitlePopup(String titlePopup) {
        this.titlePopup = titlePopup;
    }

    /**
     * Get the propertyTypePopup
     *
     * @return the propertyTypePopup
     */
    public String getPropertyTypePopup() {
        return propertyTypePopup;
    }

    /**
     * Set the propertyTypePopup
     *
     * @param propertyTypePopup the propertyTypePopup to set
     */
    public void setPropertyTypePopup(String propertyTypePopup) {
        this.propertyTypePopup = propertyTypePopup;
    }

    /**
     * Get the propertyCodeLandPopup
     *
     * @return the propertyCodeLandPopup
     */
    public String getPropertyCodeLandPopup() {
        if (propertyCodeLandPopup != null) {
            return propertyCodeLandPopup.trim();
        }
        return propertyCodeLandPopup;
    }

    /**
     * Set the propertyCodeLandPopup
     *
     * @param propertyCodeLandPopup the propertyCodeLandPopup to set
     */
    public void setPropertyCodeLandPopup(String propertyCodeLandPopup) {
        this.propertyCodeLandPopup = propertyCodeLandPopup;
    }

    /**
     * Get the propertyCodeVehiclePopup
     *
     * @return the propertyCodeVehiclePopup
     */
    public String getPropertyCodeVehiclePopup() {
        if (propertyCodeVehiclePopup != null) {
            return propertyCodeVehiclePopup.trim();
        }
        return propertyCodeVehiclePopup;
    }

    /**
     * Set the propertyCodeVehiclePopup
     *
     * @param propertyCodeVehiclePopup the propertyCodeVehiclePopup to set
     */
    public void setPropertyCodeVehiclePopup(String propertyCodeVehiclePopup) {
        this.propertyCodeVehiclePopup = propertyCodeVehiclePopup;
    }

    /**
     * Get the contractKindName
     *
     * @return the contractKindName
     */
    public String getContractKindName() {
        return contractKindName;
    }

    /**
     * Set the contractKindName
     *
     * @param contractKindName the contractKindName to set
     */
    public void setContractKindName(String contractKindName) {
        this.contractKindName = contractKindName;
    }

    /**
     * Get the provinceLandNamePopup
     *
     * @return the provinceLandNamePopup
     */
    public String getProvinceLandNamePopup() {
        return provinceLandNamePopup;
    }

    /**
     * Set the provinceLandNamePopup
     *
     * @param provinceLandNamePopup the provinceLandNamePopup to set
     */
    public void setProvinceLandNamePopup(String provinceLandNamePopup) {
        this.provinceLandNamePopup = provinceLandNamePopup;
    }

    /**
     * Get the provinceVehicleNamePopup
     *
     * @return the provinceVehicleNamePopup
     */
    public String getProvinceVehicleNamePopup() {
        return provinceVehicleNamePopup;
    }

    /**
     * Set the provinceVehicleNamePopup
     *
     * @param provinceVehicleNamePopup the provinceVehicleNamePopup to set
     */
    public void setProvinceVehicleNamePopup(String provinceVehicleNamePopup) {
        this.provinceVehicleNamePopup = provinceVehicleNamePopup;
    }

    /**
     * Get the propertyCodeOtherPopup
     *
     * @return the propertyCodeOtherPopup
     */
    public String getPropertyCodeOtherPopup() {
        if (propertyCodeOtherPopup != null) {
            return propertyCodeOtherPopup.trim();
        }
        return propertyCodeOtherPopup;
    }

    /**
     * Set the propertyCodeOtherPopup
     *
     * @param propertyCodeOtherPopup the propertyCodeOtherPopup to set
     */
    public void setPropertyCodeOtherPopup(String propertyCodeOtherPopup) {
        this.propertyCodeOtherPopup = propertyCodeOtherPopup;
    }

    /**
     * Get the provinceLandPopup
     *
     * @return the provinceLandPopup
     */
    public Long getProvinceLandPopup() {
        return provinceLandPopup;
    }

    /**
     * Set the provinceLandPopup
     *
     * @param provinceLandPopup the provinceLandPopup to set
     */
    public void setProvinceLandPopup(Long provinceLandPopup) {
        this.provinceLandPopup = provinceLandPopup;
    }

    /**
     * Get the provinceVehiclePopup
     *
     * @return the provinceVehiclePopup
     */
    public Long getProvinceVehiclePopup() {
        return provinceVehiclePopup;
    }

    /**
     * Set the provinceVehiclePopup
     *
     * @param provinceVehiclePopup the provinceVehiclePopup to set
     */
    public void setProvinceVehiclePopup(Long provinceVehiclePopup) {
        this.provinceVehiclePopup = provinceVehiclePopup;
    }

    /**
     * Get the districtPopup
     *
     * @return the districtPopup
     */
    public Long getDistrictPopup() {
        return districtPopup;
    }

    /**
     * Set the districtPopup
     *
     * @param districtPopup the districtPopup to set
     */
    public void setDistrictPopup(Long districtPopup) {
        this.districtPopup = districtPopup;
    }

    /**
     * Get the mapNumberPopup
     *
     * @return the mapNumberPopup
     */
    public String getMapNumberPopup() {
        if (mapNumberPopup != null) {
            return mapNumberPopup.trim();
        }
        return mapNumberPopup;
    }

    /**
     * Set the mapNumberPopup
     *
     * @param mapNumberPopup the mapNumberPopup to set
     */
    public void setMapNumberPopup(String mapNumberPopup) {
        this.mapNumberPopup = mapNumberPopup;
    }

    /**
     * Get the landNumberPopup
     *
     * @return the landNumberPopup
     */
    public String getLandNumberPopup() {
        if (landNumberPopup != null) {
            return landNumberPopup.trim();
        }
        return landNumberPopup;
    }

    /**
     * Set the landNumberPopup
     *
     * @param landNumberPopup the landNumberPopup to set
     */
    public void setLandNumberPopup(String landNumberPopup) {
        this.landNumberPopup = landNumberPopup;
    }

    /**
     * Get the landAddressPopup
     *
     * @return the landAddressPopup
     */
    public String getLandAddressPopup() {
        if (landAddressPopup != null) {
            return landAddressPopup.trim();
        }
        return landAddressPopup;
    }

    /**
     * Set the landAddressPopup
     *
     * @param landAddressPopup the landAddressPopup to set
     */
    public void setLandAddressPopup(String landAddressPopup) {
        this.landAddressPopup = landAddressPopup;
    }

    /**
     * Get the frameNumberPopup
     *
     * @return the frameNumberPopup
     */
    public String getFrameNumberPopup() {
        if (frameNumberPopup != null) {
            return frameNumberPopup.trim();
        }
        return frameNumberPopup;
    }

    /**
     * Set the frameNumberPopup
     *
     * @param frameNumberPopup the frameNumberPopup to set
     */
    public void setFrameNumberPopup(String frameNumberPopup) {
        this.frameNumberPopup = frameNumberPopup;
    }

    /**
     * Get the machineNumberPopup
     *
     * @return the machineNumberPopup
     */
    public String getMachineNumberPopup() {
        if (machineNumberPopup != null) {
            return machineNumberPopup.trim();
        }
        return machineNumberPopup;
    }

    /**
     * Set the machineNumberPopup
     *
     * @param machineNumberPopup the machineNumberPopup to set
     */
    public void setMachineNumberPopup(String machineNumberPopup) {
        this.machineNumberPopup = machineNumberPopup;
    }

    /**
     * Get the ownerNamePopup
     *
     * @return the ownerNamePopup
     */
    public String getOwnerNamePopup() {
        if (ownerNamePopup != null) {
            return ownerNamePopup.trim();
        }
        return ownerNamePopup;
    }

    /**
     * Set the ownerNamePopup
     *
     * @param ownerNamePopup the ownerNamePopup to set
     */
    public void setOwnerNamePopup(String ownerNamePopup) {
        this.ownerNamePopup = ownerNamePopup;
    }

    /**
     * Get the ownerIdCardPopup
     *
     * @return the ownerIdCardPopup
     */
    public String getOwnerIdCardPopup() {
        if (ownerIdCardPopup != null) {
            return ownerIdCardPopup.trim();
        }
        return ownerIdCardPopup;
    }

    /**
     * Set the ownerIdCardPopup
     *
     * @param ownerIdCardPopup the ownerIdCardPopup to set
     */
    public void setOwnerIdCardPopup(String ownerIdCardPopup) {
        this.ownerIdCardPopup = ownerIdCardPopup;
    }
    
    

    /**
     * Get the ownerAddressPopup
     *
     * @return the ownerAddressPopup
     */
    public String getOwnerAddressPopup() {
        if (ownerAddressPopup != null) {
            return ownerAddressPopup.trim();
        }
        return ownerAddressPopup;
    }

    /**
     * Set the ownerAddressPopup
     *
     * @param ownerAddressPopup the ownerAddressPopup to set
     */
    public void setOwnerAddressPopup(String ownerAddressPopup) {
        this.ownerAddressPopup = ownerAddressPopup;
    }

    /**
     * Get the propertyOtherInfoPopup
     *
     * @return the propertyOtherInfoPopup
     */
    public String getPropertyOtherInfoPopup() {
        if (propertyOtherInfoPopup != null) {
            return propertyOtherInfoPopup.trim();
        }
        return propertyOtherInfoPopup;
    }

    /**
     * Set the propertyOtherInfoPopup
     *
     * @param propertyOtherInfoPopup the propertyOtherInfoPopup to set
     */
    public void setPropertyOtherInfoPopup(String propertyOtherInfoPopup) {
        this.propertyOtherInfoPopup = propertyOtherInfoPopup;
    }

    /**
     * Get the givenDateVehiclePopup
     *
     * @return the givenDateVehiclePopup
     */
    public String getGivenDateVehiclePopup() {
        if (givenDateVehiclePopup != null) {
            return givenDateVehiclePopup.trim();
        }
        return givenDateVehiclePopup;
    }

    /**
     * Set the givenDateVehiclePopup
     *
     * @param givenDateVehiclePopup the givenDateVehiclePopup to set
     */
    public void setGivenDateVehiclePopup(String givenDateVehiclePopup) {
        this.givenDateVehiclePopup = givenDateVehiclePopup;
    }

    /**
     * Get the givenDateLandPopup
     *
     * @return the givenDateLandPopup
     */
    public String getGivenDateLandPopup() {
        if (givenDateLandPopup != null) {
            return givenDateLandPopup.trim();
        }
        return givenDateLandPopup;
    }

    /**
     * Set the givenDateLandPopup
     *
     * @param givenDateLandPopup the givenDateLandPopup to set
     */
    public void setGivenDateLandPopup(String givenDateLandPopup) {
        this.givenDateLandPopup = givenDateLandPopup;
    }

    /**
     * Get the numberProperty
     *
     * @return the numberProperty
     */
    public String getNumberProperty() {
        return numberProperty;
    }

    /**
     * Set the numberProperty
     *
     * @param numberProperty the numberProperty to set
     */
    public void setNumberProperty(String numberProperty) {
        this.numberProperty = numberProperty;
    }

    /**
     * Get the isAddnew
     *
     * @return the isAddnew
     */
    public Boolean getIsAddnew() {
        return isAddnew;
    }

    /**
     * Set the isAddnew
     *
     * @param isAddnew the isAddnew to set
     */
    public void setIsAddnew(Boolean isAddnew) {
        this.isAddnew = isAddnew;
    }

    /**
     * Get the provinceName
     *
     * @return the provinceName
     */
    public String getProvinceName() {
        return provinceName;
    }

    /**
     * Set the provinceName
     *
     * @param provinceName the provinceName to set
     */
    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    /**
     * Get the districtName
     *
     * @return the districtName
     */
    public String getDistrictName() {
        return districtName;
    }

    /**
     * Set the districtName
     *
     * @param districtName the districtName to set
     */
    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    /**
     * Get the propertySelectedIndex
     *
     * @return the propertySelectedIndex
     */
    public Integer getPropertySelectedIndex() {
        return propertySelectedIndex;
    }

    /**
     * Set the propertySelectedIndex
     *
     * @param propertySelectedIndex the propertySelectedIndex to set
     */
    public void setPropertySelectedIndex(Integer propertySelectedIndex) {
        this.propertySelectedIndex = propertySelectedIndex;
    }

    /**
     * Get the relationObjectAName
     *
     * @return the relationObjectAName
     */
    public String getRelationObjectA() {
        return relationObjectA;
    }

    /**
     * Set the relationObjectAName
     *
     * @param relationObjectAName the relationObjectAName to set
     */
    public void setRelationObjectA(String relationObjectAName) {
        this.relationObjectA = relationObjectAName;
    }

    /**
     * Get the relationObjectBName
     *
     * @return the relationObjectBName
     */
    public String getRelationObjectB() {
        return relationObjectB;
    }

    /**
     * Set the relationObjectBName
     *
     * @param relationObjectBName the relationObjectBName to set
     */
    public void setRelationObjectB(String relationObjectBName) {
        this.relationObjectB = relationObjectBName;
    }

    /**
     * Get the relationObjectCName
     *
     * @return the relationObjectCName
     */
    public String getRelationObjectC() {
        return relationObjectC;
    }

    /**
     * Set the relationObjectCName
     *
     * @param relationObjectCName the relationObjectCName to set
     */
    public void setRelationObjectC(String relationObjectCName) {
        this.relationObjectC = relationObjectCName;
    }

    
    /**
     * Get the relationObjectCName
     *
     * @return the relationObjectCName
     */
    public String getContractComment() {
        return contractComment;
    }

    /**
     * Set the relationObjectCName
     *
     * @param relationObjectCName the relationObjectCName to set
     */
    public void setContractComment(String contractComment) {
        this.contractComment = contractComment;
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
     * Get the fileExisted
     *
     * @return the fileExisted
     */
    public Boolean getFileExisted() {
        return fileExisted;
    }

    /**
     * Set the fileExisted
     *
     * @param fileExisted the fileExisted to set
     */
    public void setFileExisted(Boolean fileExisted) {
        this.fileExisted = fileExisted;
    }

    /**
     * Get the notaryPlaceFlag
     *
     * @return the notaryPlaceFlag
     */
    public Boolean getNotaryPlaceFlag() {
        return notaryPlaceFlag;
    }

    /**
     * Set the notaryPlaceFlag
     *
     * @param notaryPlaceFlag the notaryPlaceFlag to set
     */
    public void setNotaryPlaceFlag(Boolean notaryPlaceFlag) {
        this.notaryPlaceFlag = notaryPlaceFlag;
    }

    /**
     * Get the userRequireContract
     *
     * @return the userRequireContract
     */
    public String getUserRequireContract() {
        if (userRequireContract != null) {
            return userRequireContract.trim();
        }
        return userRequireContract;
    }

    /**
     * Set the userRequireContract
     *
     * @param userRequireContract the userRequireContract to set
     */
    public void setUserRequireContract(String userRequireContract) {
        this.userRequireContract = userRequireContract;
    }

    /**
     * Get the numberCopyOfContract
     *
     * @return the numberCopyOfContract
     */
    public String getNumberCopyOfContract() {
        if (numberCopyOfContract != null) {
            return numberCopyOfContract.trim();
        }
        return numberCopyOfContract;
    }

    /**
     * Set the numberCopyOfContract
     *
     * @param numberCopyOfContract the numberCopyOfContract to set
     */
    public void setNumberCopyOfContract(String numberCopyOfContract) {
        this.numberCopyOfContract = numberCopyOfContract;
    }

    /**
     * Get the numberOfPage
     *
     * @return the numberOfPage
     */
    public String getNumberOfPage() {
        if (numberOfPage != null) {
            return numberOfPage.trim();
        }
        return numberOfPage;
    }

    /**
     * Set the numberOfPage
     *
     * @param numberOfPage the numberOfPage to set
     */
    public void setNumberOfPage(String numberOfPage) {
        this.numberOfPage = numberOfPage;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.apache.struts.action.ActionForm#validate(org.apache.struts.action.ActionMapping,
     *      javax.servlet.http.HttpServletRequest)
     */
    @Override
    public ActionErrors validate(ActionMapping mapping,
            HttpServletRequest request) {        
    
		TemporaryContractViewHelper contractViewHelper = (TemporaryContractViewHelper) request
				.getSession().getAttribute(
						TemporaryContractViewHelper.SESSION_KEY);
		if (contractViewHelper == null) {
			return new ActionErrors();
		}
        
        ActionErrors errors = super.validate(mapping, request);
        
        MessageUtil messageUtil = new MessageUtil();

        if (getContractTemplateId() == null || getContractTemplateId() == CONTRACT_TEMPALTE_NONE_SELECTED) {
            errors.add(messageUtil.createActionMessages("contractTemplateId", request, "err_not_input_data", "item_contract_template_name"));
        }
        
        if (!EditString.isNull(getPropertyInfo()) && getPropertyInfo().length()>5000) {
            errors.add(messageUtil.createActionMessages("propertyInfo", request, "err_max_length", "item_property", "5000"));
        }
        
        Timestamp notaryDate = RelateDateTime.toTimestamp(false, getNotaryDate());

        // Notary date is null or not correct format
        if (!EditString.isNull(getNotaryDate()) && notaryDate == null) {
            errors.add(messageUtil.createActionMessages("notaryDate", request, "err_not_regular", "item_notary_date"));
        }

        Timestamp receivedDate = RelateDateTime.toTimestamp(false, getReceivedDate());
        if (!EditString.isNull(getReceivedDate()) && receivedDate == null) {
            errors.add(messageUtil.createActionMessages("receivedDate", request, "err_not_regular", "item_received_date"));
        }

        if (getFormFile() != null && getFormFile().getFileName().length() > 100) {
            errors.add(messageUtil.createActionMessages("formFile", request, "err_max_length", "item_file_name", "100"));
        }
        
        Timestamp landIssueDate = RelateDateTime.toTimestamp(false, getLandIssueDate());

        // Notary date is null or not correct format
        if (!EditString.isNull(getLandIssueDate()) && landIssueDate == null) {
            errors.add(messageUtil.createActionMessages("landIssueDate", request, "err_not_regular", "item_given_date"));
        }

        Timestamp carIssueDate = RelateDateTime.toTimestamp(false, getCarIssueDate());
        if (!EditString.isNull(getCarIssueDate()) && carIssueDate == null) {
            errors.add(messageUtil.createActionMessages("carIssueDate", request, "err_not_regular", "item_given_date"));
        }

        
        if (errors.size() > 0) {
			contractViewHelper.reset(this);
        }       
        
        return errors;
    }

	/**
	 * @param isDetailPropertyEntry the isDetailPropertyEntry to set
	 */
	public void setIsDetailPropertyEntry(Boolean isDetailPropertyEntry) {
		this.isDetailPropertyEntry = isDetailPropertyEntry;
	}

	/**
	 * @return the isDetailPropertyEntry
	 */
	public Boolean getIsDetailPropertyEntry() {
		return isDetailPropertyEntry;
	}
    
}
