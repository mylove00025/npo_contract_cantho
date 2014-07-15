package com.osp.npo.core.temporaryContract;


import com.osp.npo.common.global.Constants;
import com.osp.npo.common.util.EditString;
import com.osp.npo.common.util.SystemMessageProperties;
import com.osp.npo.core.AbstractInfo;
import java.sql.Timestamp;


/**
 * Generate by script
 * Generate date: 05/06/2011 2:29:16 PM
 * @version $Revision: 26198 $ 
 */
public class TemporaryContractInfo extends AbstractInfo {

	

    /** Temparary contract ID */
    private Long tcid;

    /** Type: */
    private Byte type;

    /** Contract template ID */
    private Long contractTemplateId;
    
    /**  contract kind id */
    private Long contractKindId;

    /** contract kind name */
    private String contractKindName;
    
    /** Contract template name */
    private String contractTemplateName;

    /** Contract number */
    private String contractNumber;

    /** Contract value */
    private String contractValue;

    /** Relation object A */
    private String relationObjectA;

    /** Relation object B */
    private String relationObjectB;

    /** Relation object C */
    private String relationObjectC;

    /** Notary id */
    private Long notaryId;
    
    /** notary family name*/
    private String notaryFamilyName;

    /** notary first name*/
    private String notaryFirstName;

    /** Drafter ID */
    private Long drafterId;
    
    /** drafter family name */
    private String drafterFamilyName;

    /** drafter first name*/
    private String drafterFirstName;

    /** Received date */
    private Timestamp receivedDate;

    /** Notary date */
    private Timestamp notaryDate;

    /** Request person */
    private String userRequireContract;

    /** Property type */
    private String propertyType;

    /** Property information */
    private String propertyInfo;

    /** Number copy of contract */
    private String numberCopyOfContract;

    /** Number of page */
    private String numberOfPage;

    /** Fee 91 */
    private String costTt91;

    /** Draft fee */
    private String costDraft;

    /** Outside notary fee */
    private String costNotaryOutsite;

    /** Other fee */
    private String costOtherDetermine;

    /** Total fee */
    private String costTotal;

    /** Notary place flag */
    private Boolean notaryPlaceFlag;

    /** Notary place */
    private String notaryPlace;

    /** Bank id */
    private Long bankId;
    
    /** Bank name */
    private String bankName;

    /** Bank fee */
    private String bankServiceFee;

    /** Crediter name */
    private String crediterName;

    /** File name */
    private String fileName;

    /** File path */
    private String filePath;

    /** Original store place */
    private String originalStorePlace;

    /** Note */
    private String note;

    /** Summary of contract */
    private String summary;

    /** Creator ID */
    private Long entryUserId;

    /** Creator name */
    private String entryUserName;

    /** Create date time */
    private Timestamp entryDateTime;

    /** Last update user ID */
    private Long updateUserId;

    /** Last update user name */
    private String updateUserName;

    /** Last update user date time */
    private Timestamp updateDateTime;
    
    /** land address */
    private String landAddress;
    
    /** land area */
    private String landArea;
    
    /** land certificate */
    private String landCertificate;
    
    /** land issue place */
    private String landIssuePlace;
    
    /** land map number */
    private String landMapNumber;

    /** land number */
    private String landNumber;
    
    /** land public area */
    private String landPublicArea;
    
    /** land private area */
    private String landPrivateArea;

    /** land user purpose */
    private String landUsePurpose;

    /** land use period */
    private String landUsePeriod;

    /** land use origin */
    private String landUseOrigin;
    
    /** land issue date */
    private Timestamp landIssueDate;
    
    /** land associate property */
    private String landAssociateProperty;
    
    /** car license number */
    private String carLicenseNumber;

    /** car regist number */
    private String carRegistNumber;

    /** car issue place */
    private String carIssuePlace;

    /** car issue date*/
    private Timestamp carIssueDate;

    /** car frame number */
    private String carFrameNumber;

    /** car machine number */
    private String carMachineNumber;
    
    /** owner info */
    private String ownerInfo;

    /** other info */
    private String otherInfo;




    /**
     * <P>Generate Instance.</P>
     *
     */
    public TemporaryContractInfo() {
        super();
    }


    /**
     * <P>Get Temparary contract ID </P>
     *
     * @return Temparary contract ID
     */
    public Long getTcid() {
        return this.tcid;
    }

    /**
     * <P>Set Temparary contract ID. </P>
     *
     * @param tcid Temparary contract ID
     */
    public void setTcid(Long tcid) {
        this.tcid = tcid;
    }

    /**
     * <P>Get Type:
 </P>
     *
     * @return Type:

     */
    public Byte getType() {
        return this.type;
    }

    /**
     * <P>Set Type:
. </P>
     *
     * @param type Type:

     */
    public void setType(Byte type) {
        this.type = type;
    }

    /**
     * <P>Get Contract template ID </P>
     *
     * @return Contract template ID
     */
    public Long getContractTemplateId() {
        return this.contractTemplateId;
    }

    /**
     * <P>Set Contract template ID. </P>
     *
     * @param contractTemplateId Contract template ID
     */
    public void setContractTemplateId(Long contractTemplateId) {
        this.contractTemplateId = contractTemplateId;
    }

    /**
	 * @param contractKindId the contractKindId to set
	 */
	public void setContractKindId(Long contractKindId) {
		this.contractKindId = contractKindId;
	}


	/**
	 * @param contractKindName the contractKindName to set
	 */
	public void setContractKindName(String contractKindName) {
		this.contractKindName = contractKindName;
	}


	/**
	 * @return the contractKindName
	 */
	public String getContractKindName() {
		return contractKindName;
	}


	/**
	 * @return the contractKindId
	 */
	public Long getContractKindId() {
		return contractKindId;
	}


	/**
	 * Get contractTemplateName
	 * @return the contractTemplateName
	 */
	public String getContractTemplateName() {
		return contractTemplateName;
	}


	/**
	 * Set contractTemplateName
	 * @param contractTemplateName the contractTemplateName to set
	 */
	public void setContractTemplateName(String contractTemplateName) {
		this.contractTemplateName = contractTemplateName;
	}


	/**
     * <P>Get Contract number </P>
     *
     * @return Contract number
     */
    public String getContractNumber() {
        return this.contractNumber;
    }

    /**
     * <P>Set Contract number. </P>
     *
     * @param contractNumber Contract number
     */
    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    /**
     * <P>Get Contract value </P>
     *
     * @return Contract value
     */
    public String getContractValue() {
        return this.contractValue;
    }

    /**
     * <P>Set Contract value. </P>
     *
     * @param contractValue Contract value
     */
    public void setContractValue(String contractValue) {
        this.contractValue = contractValue;
    }

    /**
     * <P>Get Relation object A </P>
     *
     * @return Relation object A
     */
    public String getRelationObjectA() {
        return this.relationObjectA;
    }

    /**
     * <P>Set Relation object A. </P>
     *
     * @param relationObjectA Relation object A
     */
    public void setRelationObjectA(String relationObjectA) {
        this.relationObjectA = relationObjectA;
    }

    /**
     * <P>Get Relation object B </P>
     *
     * @return Relation object B
     */
    public String getRelationObjectB() {
        return this.relationObjectB;
    }

    /**
     * <P>Set Relation object B. </P>
     *
     * @param relationObjectB Relation object B
     */
    public void setRelationObjectB(String relationObjectB) {
        this.relationObjectB = relationObjectB;
    }

    /**
     * <P>Get Relation object C </P>
     *
     * @return Relation object C
     */
    public String getRelationObjectC() {
        return this.relationObjectC;
    }

    /**
     * <P>Set Relation object C. </P>
     *
     * @param relationObjectC Relation object C
     */
    public void setRelationObjectC(String relationObjectC) {
        this.relationObjectC = relationObjectC;
    }

    /**
     * <P>Get Notary id </P>
     *
     * @return Notary id
     */
    public Long getNotaryId() {
        return this.notaryId;
    }

    /**
     * <P>Set Notary id. </P>
     *
     * @param notaryId Notary id
     */
    public void setNotaryId(Long notaryId) {
        this.notaryId = notaryId;
    }

    /**
	 * @param notaryFamilyName the notaryFamilyName to set
	 */
	public void setNotaryFamilyName(String notaryFamilyName) {
		this.notaryFamilyName = notaryFamilyName;
	}


	/**
	 * @param notaryFirstName the notaryFirstName to set
	 */
	public void setNotaryFirstName(String notaryFirstName) {
		this.notaryFirstName = notaryFirstName;
	}


	/**
	 * @return the notaryFirstName
	 */
	public String getNotaryFirstName() {
		return notaryFirstName;
	}


	/**
	 * @return the notaryFamilyName
	 */
	public String getNotaryFamilyName() {
		return notaryFamilyName;
	}


	/**
     * <P>Get Drafter ID </P>
     *
     * @return Drafter ID
     */
    public Long getDrafterId() {
        return this.drafterId;
    }

    /**
     * <P>Set Drafter ID. </P>
     *
     * @param drafterId Drafter ID
     */
    public void setDrafterId(Long drafterId) {
        this.drafterId = drafterId;
    }

    /**
	 * @param drafterFamilyName the drafterFamilyName to set
	 */
	public void setDrafterFamilyName(String drafterFamilyName) {
		this.drafterFamilyName = drafterFamilyName;
	}


	/**
	 * @param drafterFirstName the drafterFirstName to set
	 */
	public void setDrafterFirstName(String drafterFirstName) {
		this.drafterFirstName = drafterFirstName;
	}


	/**
	 * @return the drafterFirstName
	 */
	public String getDrafterFirstName() {
		return drafterFirstName;
	}


	/**
	 * @return the drafterFamilyName
	 */
	public String getDrafterFamilyName() {
		return drafterFamilyName;
	}


	/**
     * <P>Get Received date </P>
     *
     * @return Received date
     */
    public Timestamp getReceivedDate() {
        return this.receivedDate;
    }

    /**
     * <P>Set Received date. </P>
     *
     * @param receivedDate Received date
     */
    public void setReceivedDate(Timestamp receivedDate) {
        this.receivedDate = receivedDate;
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
     * <P>Get Request person </P>
     *
     * @return Request person
     */
    public String getUserRequireContract() {
        return this.userRequireContract;
    }

    /**
     * <P>Set Request person. </P>
     *
     * @param userRequireContract Request person
     */
    public void setUserRequireContract(String userRequireContract) {
        this.userRequireContract = userRequireContract;
    }

    /**
     * <P>Get Property type
 </P>
     *
     * @return Property type

     */
    public String getPropertyType() {
        return this.propertyType;
    }

    /**
     * <P>Set Property type
. </P>
     *
     * @param propertyType Property type

     */
    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
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
     * <P>Get Number copy of contract </P>
     *
     * @return Number copy of contract
     */
    public String getNumberCopyOfContract() {
        return this.numberCopyOfContract;
    }

    /**
     * <P>Set Number copy of contract. </P>
     *
     * @param numberCopyOfContract Number copy of contract
     */
    public void setNumberCopyOfContract(String numberCopyOfContract) {
        this.numberCopyOfContract = numberCopyOfContract;
    }

    /**
     * <P>Get Number of page </P>
     *
     * @return Number of page
     */
    public String getNumberOfPage() {
        return this.numberOfPage;
    }

    /**
     * <P>Set Number of page. </P>
     *
     * @param numberOfPage Number of page
     */
    public void setNumberOfPage(String numberOfPage) {
        this.numberOfPage = numberOfPage;
    }

    /**
     * <P>Get Fee 91 </P>
     *
     * @return Fee 91
     */
    public String getCostTt91() {
        return this.costTt91;
    }

    /**
     * <P>Set Fee 91. </P>
     *
     * @param costTt91 Fee 91
     */
    public void setCostTt91(String costTt91) {
        this.costTt91 = costTt91;
    }

    /**
     * <P>Get Draft fee </P>
     *
     * @return Draft fee
     */
    public String getCostDraft() {
        return this.costDraft;
    }

    /**
     * <P>Set Draft fee. </P>
     *
     * @param costDraft Draft fee
     */
    public void setCostDraft(String costDraft) {
        this.costDraft = costDraft;
    }

    /**
     * <P>Get Outside notary fee </P>
     *
     * @return Outside notary fee
     */
    public String getCostNotaryOutsite() {
        return this.costNotaryOutsite;
    }

    /**
     * <P>Set Outside notary fee. </P>
     *
     * @param costNotaryOutsite Outside notary fee
     */
    public void setCostNotaryOutsite(String costNotaryOutsite) {
        this.costNotaryOutsite = costNotaryOutsite;
    }

    /**
     * <P>Get Other fee </P>
     *
     * @return Other fee
     */
    public String getCostOtherDetermine() {
        return this.costOtherDetermine;
    }

    /**
     * <P>Set Other fee. </P>
     *
     * @param costOtherDetermine Other fee
     */
    public void setCostOtherDetermine(String costOtherDetermine) {
        this.costOtherDetermine = costOtherDetermine;
    }

    /**
     * <P>Get Total fee </P>
     *
     * @return Total fee
     */
    public String getCostTotal() {
        return this.costTotal;
    }

    /**
     * <P>Set Total fee. </P>
     *
     * @param costTotal Total fee
     */
    public void setCostTotal(String costTotal) {
        this.costTotal = costTotal;
    }

    /**
     * <P>Get Notary place flag
 </P>
     *
     * @return Notary place flag

     */
    public Boolean getNotaryPlaceFlag() {
        return this.notaryPlaceFlag;
    }

    /**
     * <P>Set Notary place flag
. </P>
     *
     * @param notaryPlaceFlag Notary place flag

     */
    public void setNotaryPlaceFlag(Boolean notaryPlaceFlag) {
        this.notaryPlaceFlag = notaryPlaceFlag;
    }

    /**
     * <P>Get Notary place </P>
     *
     * @return Notary place
     */
    public String getNotaryPlace() {
        return this.notaryPlace;
    }

    /**
     * <P>Set Notary place. </P>
     *
     * @param notaryPlace Notary place
     */
    public void setNotaryPlace(String notaryPlace) {
        this.notaryPlace = notaryPlace;
    }

    /**
     * <P>Get Bank name </P>
     *
     * @return Bank name
     */
    public Long getBankId() {
        return this.bankId;
    }

    /**
     * <P>Set Bank name. </P>
     *
     * @param bankId Bank name
     */
    public void setBankId(Long bankId) {
        this.bankId = bankId;
    }

    /**
     * <P>Get Bank fee </P>
     *
     * @return Bank fee
     */
    public String getBankServiceFee() {
        return this.bankServiceFee;
    }

    /**
     * <P>Set Bank fee. </P>
     *
     * @param bankServiceFee Bank fee
     */
    public void setBankServiceFee(String bankServiceFee) {
        this.bankServiceFee = bankServiceFee;
    }

    /**
     * <P>Get Crediter name </P>
     *
     * @return Crediter name
     */
    public String getCrediterName() {
        return this.crediterName;
    }

    /**
     * <P>Set Crediter name. </P>
     *
     * @param crediterName Crediter name
     */
    public void setCrediterName(String crediterName) {
        this.crediterName = crediterName;
    }

    /**
     * <P>Get File name </P>
     *
     * @return File name
     */
    public String getFileName() {
        return this.fileName;
    }

    /**
     * <P>Set File name. </P>
     *
     * @param fileName File name
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * <P>Get File path </P>
     *
     * @return File path
     */
    public String getFilePath() {
        return this.filePath;
    }

    /**
     * <P>Set File path. </P>
     *
     * @param filePath File path
     */
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    /**
     * <P>Get Original store place </P>
     *
     * @return Original store place
     */
    public String getOriginalStorePlace() {
        return this.originalStorePlace;
    }

    /**
     * <P>Set Original store place. </P>
     *
     * @param originalStorePlace Original store place
     */
    public void setOriginalStorePlace(String originalStorePlace) {
        this.originalStorePlace = originalStorePlace;
    }

    /**
     * <P>Get Note </P>
     *
     * @return Note
     */
    public String getNote() {
        return this.note;
    }

    /**
     * <P>Set Note. </P>
     *
     * @param note Note
     */
    public void setNote(String note) {
        this.note = note;
    }
    
    /**
     * <P>Get Note </P>
     *
     * @return Note
     */
    public String getNoteDisp() {
        return EditString.replaceChangeLine(this.note);
    }

    /**
     * <P>Get Summary of contract </P>
     *
     * @return Summary of contract
     */
    public String getSummary() {
        return this.summary;
    }

    /**
     * <P>Set Summary of contract. </P>
     *
     * @param summary Summary of contract
     */
    public void setSummary(String summary) {
        this.summary = summary;
    }
    
    /**
     * <P>Get Summary </P>
     *
     * @return Summary
     */
    public String getSummaryDisp() {
        return EditString.replaceChangeLine(this.summary);
    }

    /**
     * <P>Get Creator ID </P>
     *
     * @return Creator ID
     */
    public Long getEntryUserId() {
        return this.entryUserId;
    }

    /**
     * <P>Set Creator ID. </P>
     *
     * @param entryUserId Creator ID
     */
    public void setEntryUserId(Long entryUserId) {
        this.entryUserId = entryUserId;
    }

    /**
     * <P>Get Creator name </P>
     *
     * @return Creator name
     */
    public String getEntryUserName() {
        return this.entryUserName;
    }

    /**
     * <P>Set Creator name. </P>
     *
     * @param entryUserName Creator name
     */
    public void setEntryUserName(String entryUserName) {
        this.entryUserName = entryUserName;
    }

    /**
     * <P>Get Create date time </P>
     *
     * @return Create date time
     */
    public Timestamp getEntryDateTime() {
        return this.entryDateTime;
    }

    /**
     * <P>Set Create date time. </P>
     *
     * @param entryDateTime Create date time
     */
    public void setEntryDateTime(Timestamp entryDateTime) {
        this.entryDateTime = entryDateTime;
    }

    /**
     * <P>Get Last update user ID </P>
     *
     * @return Last update user ID
     */
    public Long getUpdateUserId() {
        return this.updateUserId;
    }

    /**
     * <P>Set Last update user ID. </P>
     *
     * @param updateUserId Last update user ID
     */
    public void setUpdateUserId(Long updateUserId) {
        this.updateUserId = updateUserId;
    }

    /**
     * <P>Get Last update user name </P>
     *
     * @return Last update user name
     */
    public String getUpdateUserName() {
        return this.updateUserName;
    }

    /**
     * <P>Set Last update user name. </P>
     *
     * @param updateUserName Last update user name
     */
    public void setUpdateUserName(String updateUserName) {
        this.updateUserName = updateUserName;
    }

    /**
     * <P>Get Last update user date time </P>
     *
     * @return Last update user date time
     */
    public Timestamp getUpdateDateTime() {
        return this.updateDateTime;
    }

    /**
     * <P>Set Last update user date time. </P>
     *
     * @param updateDateTime Last update user date time
     */
    public void setUpdateDateTime(Timestamp updateDateTime) {
        this.updateDateTime = updateDateTime;
    }
    
    /**
     * Get the contract Information
     *
     * @return the contractInformation
     */
    public String getContractInformation() {
        String info = "";
//        info += contractTemplateName;
        if (!EditString.isNull(relationObjectA)) {
            info += SystemMessageProperties.getSystemProperty("item_relation_objectA")
                + Constants.COLON + Constants.SPACE + relationObjectA;
        }
        if (!EditString.isNull(relationObjectB)) {
            info += Constants.ENTER + SystemMessageProperties.getSystemProperty("item_relation_objectB")
                + Constants.COLON + Constants.SPACE + relationObjectB;
        }
        if (!EditString.isNull(relationObjectC)) {
            info += Constants.ENTER + SystemMessageProperties.getSystemProperty("item_relation_objectC")
                + Constants.COLON + Constants.SPACE + relationObjectC;
        }
        return EditString.replaceChangeLine(info);
    }

    public String getContractInformationDisp() {
        return EditString.getDisp(getContractInformation(), Constants.LENGTH_OUTPUT_LIMIT);
    }
    
    /**
     * Get the contractSummaryDisp
     *
     * @return the contractSummaryDisp
     */
    public String getContractSummaryDisp() {
        String info = "";
        String type = "";
        if (!EditString.isNull(propertyInfo)) {
            if ("01".equals(propertyType)) {
                type = SystemMessageProperties.getSystemProperty("item_land");
            } else if ("02".equals(propertyType)) {
                type = SystemMessageProperties.getSystemProperty("item_vehicle");
            } else if ("99".equals(propertyType)) {
                type = SystemMessageProperties.getSystemProperty("item_other");
            }
            info += Constants.ENTER + SystemMessageProperties.getSystemProperty("item_property_contract")
                + Constants.COLON + Constants.SPACE + type + Constants.ENTER + propertyInfo;
        }
        if (!EditString.isNull(summary))
            info += Constants.ENTER + SystemMessageProperties.getSystemProperty("item_contract_sumary") 
            		+ Constants.COLON + Constants.ENTER + summary;
        return EditString.replaceChangeLine(info);
    }

    /**
     * Get the shorten contractSummary
     *
     * @return the contractSummary
     */
    public String getShorttenContractSummaryDisp() {
        return EditString.getDisp(getContractSummaryDisp(), Constants.LENGTH_OUTPUT_LIMIT);
    }


	/**
	 * @param bankName the bankName to set
	 */
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}


	/**
	 * @return the bankName
	 */
	public String getBankName() {
		return bankName;
	}


	/**
	 * @param landAddress the landAddress to set
	 */
	public void setLandAddress(String landAddress) {
		this.landAddress = landAddress;
	}


	/**
	 * @return the landAddress
	 */
	public String getLandAddress() {
		return landAddress;
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
		return landIssuePlace;
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
		return landMapNumber;
	}


	/**
	 * @param landNumber the landNumber to set
	 */
	public void setLandNumber(String landNumber) {
		this.landNumber = landNumber;
	}


	/**
	 * @return the landNumber
	 */
	public String getLandNumber() {
		return landNumber;
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
		return landUseOrigin;
	}


	/**
	 * @param timestamp the landIssueDate to set
	 */
	public void setLandIssueDate(Timestamp timestamp) {
		this.landIssueDate = timestamp;
	}


	/**
	 * @return the landIssueDate
	 */
	public Timestamp getLandIssueDate() {
		return landIssueDate;
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
		return landAssociateProperty;
	}


	/**
	 * @param carLicenseNumber the carLicenseNumber to set
	 */
	public void setCarLicenseNumber(String carLicenseNumber) {
		this.carLicenseNumber = carLicenseNumber;
	}


	/**
	 * @return the carLicenseNumber
	 */
	public String getCarLicenseNumber() {
		return carLicenseNumber;
	}


	/**
	 * @param carRegistNumber the carRegistNumber to set
	 */
	public void setCarRegistNumber(String carRegistNumber) {
		this.carRegistNumber = carRegistNumber;
	}


	/**
	 * @return the carRegistNumber
	 */
	public String getCarRegistNumber() {
		return carRegistNumber;
	}


	/**
	 * @param carIssuePlace the carIssuePlace to set
	 */
	public void setCarIssuePlace(String carIssuePlace) {
		this.carIssuePlace = carIssuePlace;
	}


	/**
	 * @return the carIssuePlace
	 */
	public String getCarIssuePlace() {
		return carIssuePlace;
	}


	/**
	 * @param timestamp the carIssueDate to set
	 */
	public void setCarIssueDate(Timestamp timestamp) {
		this.carIssueDate = timestamp;
	}


	/**
	 * @return the carIssueDate
	 */
	public Timestamp getCarIssueDate() {
		return carIssueDate;
	}


	/**
	 * @param carFrameNumber the carFrameNumber to set
	 */
	public void setCarFrameNumber(String carFrameNumber) {
		this.carFrameNumber = carFrameNumber;
	}


	/**
	 * @return the carFrameNumber
	 */
	public String getCarFrameNumber() {
		return carFrameNumber;
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
		return carMachineNumber;
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
		return otherInfo;
	}
}
