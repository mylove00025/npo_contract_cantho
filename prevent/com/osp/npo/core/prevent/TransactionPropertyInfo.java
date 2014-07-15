package com.osp.npo.core.prevent;


import com.osp.npo.common.global.Constants;
import com.osp.npo.common.util.EditString;
import com.osp.npo.common.util.SystemMessageProperties;
import com.osp.npo.core.AbstractInfo;
import com.sun.org.apache.bcel.internal.generic.LAND;

import java.sql.Timestamp;


/**
 * Generate by script
 * Generate date: 02/17/2011 10:15:26 AM
 */
public class TransactionPropertyInfo extends AbstractInfo {


    /** Transaction property */
    private Long tpid;

    /** Synchronize ID */
    private String synchronizeId;

    /** Property type:
 */
    private String type;

    /** Property information */
    private String propertyInfo;

    /** Transaction content */
    private String transactionContent;

    /** Notary date */
    private Timestamp notaryDate;

    /** Notary office name */
    private String notaryOfficeName;

    /** Contract ID */
    private Long contractId;
    
    /** Contract number */
    private String contractNumber;
    
    private String contractName;

    /** Contract value */
    private String contractValue;

    /** Relation object */
    private String relationObject;

    /** Ho ten Cong chung vien */
    private String notaryPerson;

    /** Notary place */
    private String notaryPlace;

    /** Notary fee */
    private String notaryFee;

    /** Note */
    private String note;

    /** Trang thai huy cua hop dong */
    private Boolean cancelStatus;

    /** Mo ta chi tiet huy */
    private String cancelDescription;

    /** Entry user id */
    private Long entryUserId;

    /** Entry user name */
    private String entryUserName;

    /** Entry date time */
    private Timestamp entryDateTime;

    /** Update user id */
    private Long updateUserId;

    /** Update user name */
    private String updateUserName;

    /** Update user date time */
    private Timestamp updateDateTime;
    
    /** Lucene hiÃ¡Â»Æ’n thÃ¡Â»â€¹ nÃ¡Â»â„¢i dung */
    private String luceneTransactionContentDisp;
    
    /** Lucene nÃ¡Â»â„¢i dung */
    private String luceneTransactionContent;
    
    /** Lucene Relation*/
    private String luceneRelationObjectDisp;
    
    /** Lucene Relation*/
    private String luceneRelationObject;
    
    /** Quáº­n*/
    private String district;
    
    /** PhÆ°á»�ng xÃ£ */
    private String street;
    
    /** Thá»�i háº¡n há»£p Ä‘á»“ng */
    private String contractPeriod;
    
    /** TÃ¬nh tráº¡ng giáº£i cháº¥p */
    private Boolean mortageCancelFlag;
    
    /** NgÃ y giáº£i cháº¥p */
    private String mortageCancelDate;
    
    /** Ghi chÃº giáº£i cháº¥p */
    private String mortageCancelNote;
    
    /** Nhom hop dong */
    private String contractKind;
    
    
    /**
     * <P>Generate Instance.</P>
     *
     */
    public TransactionPropertyInfo() {
        super();
    }


    /**
     * <P>Get Transaction property </P>
     *
     * @return Transaction property
     */
    public Long getTpid() {
        return this.tpid;
    }

    /**
     * <P>Set Transaction property. </P>
     *
     * @param tpid Transaction property
     */
    public void setTpid(Long tpid) {
        this.tpid = tpid;
    }

    /**
     * <P>Get Synchronize ID </P>
     *
     * @return Synchronize ID
     */
    public String getSynchronizeId() {
        return this.synchronizeId;
    }

    /**
     * <P>Set Synchronize ID. </P>
     *
     * @param synchronizeId Synchronize ID
     */
    public void setSynchronizeId(String synchronizeId) {
        this.synchronizeId = synchronizeId;
    }

    /**
     * <P>Get Property type:
 </P>
     *
     * @return Property type:

     */
    public String getType() {
        return this.type;
    }

    /**
     * <P>Set Property type:
. </P>
     *
     * @param type Property type:

     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * <P>Get Property information </P>
     *
     * @return Property information
     */
    public String getPropertyInfo() {
        return this.propertyInfo;
    }

    /**
     * <P>Set Property information. </P>
     *
     * @param propertyInfo Property information
     */
    public void setPropertyInfo(String propertyInfo) {
        this.propertyInfo = propertyInfo;
    }

    /**
     * <P>Get Transaction content </P>
     *
     * @return Transaction content
     */
    public String getTransactionContent() {
        return this.transactionContent;
    }

    /**
     * <P>Set Transaction content. </P>
     *
     * @param transactionContent Transaction content
     */
    public void setTransactionContent(String transactionContent) {
        this.transactionContent = transactionContent;
    }

    /**
     * <P>Get Notary date </P>
     *
     * @return Notary date
     */
    public Timestamp getNotaryDate() {
        return this.notaryDate;
    }

    /**
     * <P>Set Notary date. </P>
     *
     * @param notaryDate Notary date
     */
    public void setNotaryDate(Timestamp notaryDate) {
        this.notaryDate = notaryDate;
    }

    /**
     * <P>Get Notary office name </P>
     *
     * @return Notary office name
     */
    public String getNotaryOfficeName() {
        return this.notaryOfficeName;
    }

    /**
     * <P>Set Notary office name. </P>
     *
     * @param notaryOfficeName Notary office name
     */
    public void setNotaryOfficeName(String notaryOfficeName) {
        this.notaryOfficeName = notaryOfficeName;
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
     * Get the contractNumber
     *
     * @return the contractNumber
     */
    public String getContractNumber() {
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
     * Get the contractName
     *
     * @return the contractName
     */
    public String getContractName() {
        return contractName;
    }


    /**
     * Set the contractName
     *
     * @param contractName the contractName to set
     */
    public void setContractName(String contractName) {
        this.contractName = contractName;
    }


    /**
     * Get the contractValue
     *
     * @return the contractValue
     */
    public String getContractValue() {
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
     * Get the relationObject
     *
     * @return the relationObject
     */
    public String getRelationObject() {
        return relationObject;
    }
    
    /**
     * Get the relationObject
     *
     * @return the relationObject
     */
    public String getRelationObjectDisp() {
        return EditString.replaceChangeLine(relationObject);
    }
    
    /**
     * Get the relationObject
     *
     * @return the relationObject
     */
    public String getRelationObjectSummaryDisp() {
        return EditString.getDisp(getRelationObjectDisp(), Constants.LENGTH_OUTPUT_LIMIT);
    }

    /**
     * Set the relationObject
     *
     * @param relationObject the relationObject to set
     */
    public void setRelationObject(String relationObject) {
        this.relationObject = relationObject;
    }


    /**
     * Get the notaryPerson
     *
     * @return the notaryPerson
     */
    public String getNotaryPerson() {
        return notaryPerson;
    }


    /**
     * Set the notaryPerson
     *
     * @param notaryPerson the notaryPerson to set
     */
    public void setNotaryPerson(String notaryPerson) {
        this.notaryPerson = notaryPerson;
    }


    /**
     * Get the notaryPlace
     *
     * @return the notaryPlace
     */
    public String getNotaryPlace() {
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
     * Get the notaryFee
     *
     * @return the notaryFee
     */
    public String getNotaryFee() {
        return notaryFee;
    }


    /**
     * Set the notaryFee
     *
     * @param notaryFee the notaryFee to set
     */
    public void setNotaryFee(String notaryFee) {
        this.notaryFee = notaryFee;
    }


    /**
     * Get the note
     *
     * @return the note
     */
    public String getNote() {
        return note;
    }


    /**
     * Set the note
     *
     * @param note the note to set
     */
    public void setNote(String note) {
        this.note = note;
    }


    /**
     * Get the cancelStatus
     *
     * @return the cancelStatus
     */
    public Boolean getCancelStatus() {
        return cancelStatus;
    }


    /**
     * Set the cancelStatus
     *
     * @param cancelStatus the cancelStatus to set
     */
    public void setCancelStatus(Boolean cancelStatus) {
        this.cancelStatus = cancelStatus;
    }


    /**
     * Get the cancelDescription
     *
     * @return the cancelDescription
     */
    public String getCancelDescription() {
        return cancelDescription;
    }


    /**
     * Set the cancelDescription
     *
     * @param cancelDescription the cancelDescription to set
     */
    public void setCancelDescription(String cancelDescription) {
        this.cancelDescription = cancelDescription;
    }


    /**
     * <P>Get Entry user id </P>
     *
     * @return Entry user id
     */
    public Long getEntryUserId() {
        return this.entryUserId;
    }

    /**
     * <P>Set Entry user id. </P>
     *
     * @param entryUserId Entry user id
     */
    public void setEntryUserId(Long entryUserId) {
        this.entryUserId = entryUserId;
    }

    /**
     * <P>Get Entry user name </P>
     *
     * @return Entry user name
     */
    public String getEntryUserName() {
        return this.entryUserName;
    }

    /**
     * <P>Set Entry user name. </P>
     *
     * @param entryUserName Entry user name
     */
    public void setEntryUserName(String entryUserName) {
        this.entryUserName = entryUserName;
    }

    /**
     * <P>Get Entry date time </P>
     *
     * @return Entry date time
     */
    public Timestamp getEntryDateTime() {
        return this.entryDateTime;
    }

    /**
     * <P>Set Entry date time. </P>
     *
     * @param entryDateTime Entry date time
     */
    public void setEntryDateTime(Timestamp entryDateTime) {
        this.entryDateTime = entryDateTime;
    }

    /**
     * <P>Get Update user id </P>
     *
     * @return Update user id
     */
    public Long getUpdateUserId() {
        return this.updateUserId;
    }

    /**
     * <P>Set Update user id. </P>
     *
     * @param updateUserId Update user id
     */
    public void setUpdateUserId(Long updateUserId) {
        this.updateUserId = updateUserId;
    }

    /**
     * <P>Get Update user name </P>
     *
     * @return Update user name
     */
    public String getUpdateUserName() {
        return this.updateUserName;
    }

    /**
     * <P>Set Update user name. </P>
     *
     * @param updateUserName Update user name
     */
    public void setUpdateUserName(String updateUserName) {
        this.updateUserName = updateUserName;
    }

    /**
     * <P>Get Update user date time </P>
     *
     * @return Update user date time
     */
    public Timestamp getUpdateDateTime() {
        return this.updateDateTime;
    }

    /**
     * <P>Set Update user date time. </P>
     *
     * @param updateDateTime Update user date time
     */
    public void setUpdateDateTime(Timestamp updateDateTime) {
        this.updateDateTime = updateDateTime;
    }
    
    
    /**
     * <P>Get the Property Info Disp </P>
     *
     * @return info
     */
    public String getPropertyInfoDisp() {       
        return EditString.replaceChangeLine(getPropertyInfo());
    }
    
    /**
     * <P>Get the Property Info Summary Disp </P>
     *
     * @return infoDisp
     */
    public String getPropertyInfoSummaryDisp() {
        return EditString.getDisp(getPropertyInfoDisp(), Constants.LENGTH_OUTPUT_LIMIT);
    }
    
    /**
     * Get the contract Information
     *
     * @return the contractInformation
     */
    public String getTransactionContentLucene() {
        String info = "";
//        String typeName = "";
        if (!EditString.isNull(propertyInfo)) {
        	 String landArea = getLandArea();
        	 if (!"01".equals(type)) landArea = "";
//            if ("01".equals(type)) {
//                typeName = SystemMessageProperties.getSystemProperty("item_land");
//            } else if ("02".equals(type)) {
//                typeName = SystemMessageProperties.getSystemProperty("item_vehicle");
//            } else if ("99".equals(type)) {
//                typeName = SystemMessageProperties.getSystemProperty("item_other");
//            }
        	 info += SystemMessageProperties.getSystemProperty("item_property2") 
             + Constants.COLON + Constants.SPACE + Constants.ENTER + landArea +/*typeName +*/  propertyInfo + Constants.ENTER ;
        }
        if (!EditString.isNull(transactionContent)) 
        info += SystemMessageProperties.getSystemProperty("item_contract_summary") 
        		+ Constants.COLON + Constants.ENTER + transactionContent;
        info = EditString.replaceChangeLine(info);
        info = EditString.filterIgnoreB(info);
        return info;
    }
    
    /**
     * Get the contract Information
     *
     * @return the contractInformation
     */
    public String getTransactionContentDisp() {
        String info = "";
//        String typeName = "";
        if (!EditString.isNull(propertyInfo)) {
        	String landArea = getLandArea();
        	if (!"01".equals(type)) landArea = "";
//            if ("01".equals(type)) {
//                typeName = SystemMessageProperties.getSystemProperty("item_land");
//            } else if ("02".equals(type)) {
//                typeName = SystemMessageProperties.getSystemProperty("item_vehicle");
//            } else if ("99".equals(type)) {
//                typeName = SystemMessageProperties.getSystemProperty("item_other");
//            }
            info += SystemMessageProperties.getSystemProperty("item_property2") 
                + Constants.COLON + Constants.SPACE + Constants.ENTER + landArea +/*typeName +*/ propertyInfo + Constants.ENTER ;
        }
        if (!EditString.isNull(transactionContent))   
        info += SystemMessageProperties.getSystemProperty("item_contract_summary") 
        		+ Constants.COLON + Constants.ENTER + transactionContent;
        info = EditString.replaceChangeLine(info);
        info = EditString.filterIgnoreB(info);
        return info;
    }
    
    public String getTransactionContentSummaryDisp() {
        return EditString.getDisp(getTransactionContentDisp(), Constants.LENGTH_OUTPUT_LIMIT);
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
	 * @param luceneTransactionContentDisp the luceneTransactionContentDisp to set
	 */
	public void setLuceneTransactionContentDisp(
			String luceneTransactionContentDisp) {
		this.luceneTransactionContentDisp = luceneTransactionContentDisp;
	}


	/**
	 * @return the luceneTransactionContentDisp
	 */
	public String getLuceneTransactionContentDisp() {
	    if (luceneTransactionContentDisp == null) {
	        return "";
	    }
		return luceneTransactionContentDisp;
	}


	/**
	 * @param luceneTransactionContent the luceneTransactionContent to set
	 */
	public void setLuceneTransactionContent(String luceneTransactionContent) {
		this.luceneTransactionContent = luceneTransactionContent;
	}


	/**
	 * @return the luceneTransactionContent
	 */
	public String getLuceneTransactionContent() {
	    if (luceneTransactionContent == null) {
            return "";
        }
		return luceneTransactionContent;
	}


	/**
	 * @param luceneRelationObjectDisp the luceneRelationObjectDisp to set
	 */
	public void setLuceneRelationObjectDisp(String luceneRelationObjectDisp) {
		this.luceneRelationObjectDisp = luceneRelationObjectDisp;
	}


	/**
	 * @return the luceneRelationObjectDisp
	 */
	public String getLuceneRelationObjectDisp() {
	    if (luceneRelationObjectDisp == null) {
            return "";
        }
		return luceneRelationObjectDisp;
	}


	/**
	 * @param luceneRelationObject the luceneRelationObject to set
	 */
	public void setLuceneRelationObject(String luceneRelationObject) {
		this.luceneRelationObject = luceneRelationObject;
	}


	/**
	 * @return the luceneRelationObject
	 */
	public String getLuceneRelationObject() {
	    if (luceneRelationObject == null) {
            return "";
        }
		return luceneRelationObject;
	}


	public void setContractPeriod(String contractPeriod) {
		this.contractPeriod = contractPeriod;
	}


	public String getContractPeriod() {
		return EditString.replaceChangeLine(contractPeriod);
	}


	public void setMortageCancelFlag(Boolean mortageCancelFlag) {
		this.mortageCancelFlag = mortageCancelFlag;
	}


	public Boolean getMortageCancelFlag() {
		return mortageCancelFlag;
	}


	public void setMortageCancelDate(String mortageCancelDate) {
		this.mortageCancelDate = mortageCancelDate;
	}

	public String getMortageCancelDate() {
		return mortageCancelDate;
	}

	public String getMortageCancelDateDisp() {
		String date = SystemMessageProperties.getSystemProperty("item_mortage_date") + Constants.SPACE + mortageCancelDate;
		return date;
	}


	public void setMortageCancelNote(String mortageCancelNote) {
		this.mortageCancelNote = mortageCancelNote;
	}


	public String getMortageCancelNote() {
		return mortageCancelNote;
	}
	
	public String getMortageCancelNoteDisp() {
		return EditString.replaceChangeLine(mortageCancelNote);
	}


	public void setContractKind(String contractKind) {
		this.contractKind = contractKind;
	}


	public String getContractKind() {
		return contractKind;
	}
	
	public String getLandArea(){
		String landArea = "";
		if ((getDistrict()!=null && !"".equals(getDistrict().trim()))||(getStreet()!=null && !"".equals(getStreet().trim()))) {
			landArea += SystemMessageProperties.getSystemProperty("item_area") + Constants.COLON + Constants.SPACE;
			landArea += street + Constants.SPACE; 
			if (getDistrict()!=null && getStreet()!=null && !"".equals(getDistrict().trim()) && !"".equals(getStreet().trim())) {
				landArea += "-" + Constants.SPACE;
			}
			landArea += district;
		}
		if (!"".equals(landArea)) landArea += Constants.ENTER;
		return landArea;
	}

	/**
     * Get the contractSummaryReport
     *
     * @return the contractSummaryReport
     */
    public String getContractSummaryReport() {
        String info = "";
//        String type = "";
        if (!EditString.isNull(propertyInfo)) {
             String landArea = getLandArea();
             if (!"01".equals(type)) landArea = "";
//            if ("01".equals(propertyType)) {
//                type = SystemMessageProperties.getSystemProperty("item_land");
//            } else if ("02".equals(propertyType)) {
//                type = SystemMessageProperties.getSystemProperty("item_vehicle");
//            } else if ("99".equals(propertyType)) {
//                type = SystemMessageProperties.getSystemProperty("item_other");
//            }
            info += SystemMessageProperties.getSystemProperty("item_property")
                + Constants.COLON + Constants.SPACE + /*type +*/ Constants.ENTER + landArea + propertyInfo + Constants.ENTER;
        }
        if (!EditString.isNull(transactionContent))
        info += SystemMessageProperties.getSystemProperty("item_contract_summary2") 
                + Constants.COLON + Constants.ENTER + transactionContent;
        return info;
    }
	
}
