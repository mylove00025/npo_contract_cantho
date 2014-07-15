package com.osp.npo.core.contract;

import com.osp.npo.common.global.Constants;
import com.osp.npo.common.util.EditString;
import com.osp.npo.common.util.SystemMessageProperties;
import com.osp.npo.core.AbstractInfo;
import java.sql.Timestamp;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * Generate by script
 * Generate date: 10/28/2010 12:04:18 PM
 */
public class ContractInfo extends AbstractInfo {

	private String page;
	
    /** id t? tang */
    private Long id;

    /** id h?p d?ng m?u */
    private Long contractTemplateId;

    /** S? h?p d?ng */
    private String contractNumber;

    private Long contractKindId;

    private String contractKindName;

    /** GiÃ¡ tr? h?p d?ng */
    private String contractValue;

    /** CÃ´ng ch?ng viÃªn */
    private Long notaryId;

    private String notaryAccount;

    /** ChuyÃªn viÃªn so?n th?o */
    private Long drafterId;

    private String drafterAccount;

    /** NgÃ y th? lÃ½ */
    private Timestamp receivedDate;

    /** NgÃ y cÃ´ng ch?ng */
    private Timestamp notaryDate;

    /** PhÃ­ ThÃ¹ lao theo thÃ´ng tu 91 */
    private String costTt91;

    /** PhÃ­ ThÃ¹ lao so?n th?o */
    private String costDraft;

    /** PhÃ­ d?ch v? cÃ´ng ch?ng ngoÃ i */
    private String costNotaryOutsite;

    /** PhÃ­ d?ch v? xÃ¡c minh khÃ¡c */
    private String costOtherDetermine;

    /** T?ng phÃ­ cÃ´ng ch?ng */
    private String costTotal;

    /** Ã�?a di?m cÃ´ng ch?ng */
    private String notaryPlace;

    private Boolean notaryPlaceFlag;

    /** NgÃ¢n hÃ ng trung gian */
    private Long bankId;

    /** Chi?t kh?u l?i cho NgÃ¢n hÃ ng */
    private String bankServiceFee;

    /** CÃ¡n b? tÃ­n d?ng NgÃ¢n hÃ ng */
    private String crediterName;

    /** TÃªn file dÃ­nh kÃ¨m */
    private String fileName;

    /** Ã�u?ng d?n ch?a file */
    private String filePath;

    /** tÃ¬nh tr?ng l?i
 */
    private Boolean errorStatus;

    private String errorUserFamilyName;

    private String errorUserFirstName;

    /** id CÃ¡n b? gÃ¢y l?i. */
    private Long errorUserId;

    /** MÃ´ t? l?i */
    private String errorDescription;

    private Boolean additionStatus;

    private String additionDescription;

    /** Trang thai huy hop dong */
    private Boolean cancelStatus;

    /** Mo ta chi tiet huy hop dong */
    private String cancelDescription;

    private Long cancelRelationContractId;

    /** Noi luu tr? b?n g?c h?p d?ng */
    private String originalStorePlace;

    /** Ghi chÃº */
    private String note;

    /** id ngu?i t?o */
    private Long entryUserId;

    /** TÃªn ngu?i t?o */
    private String entryUserName;

    /** NgÃ y t?o */
    private Timestamp entryDateTime;

    /** id ngu?i c?p nh?t cu?i */
    private Long updateUserId;

    /** TÃªn ngu?i c?p nh?t cu?i */
    private String updateUserName;

    /** NgÃ y c?p nh?t cu?i */
    private Timestamp updateDateTime;

    /** ChuyÃªn viÃªn soáº¡n tháº£o - Há»� Ä‘Ãªm */
    private String drafterFamilyName;

    /** ChuyÃªn viÃªn soáº¡n tháº£o - TÃªn */
    private String drafterFirstName;

    /** Ten Hop dong mau */
    private String contractTemplateName;
    
    private String contractTemplateCode;
    
    private int relateObjectNumber;

    /** TÃªn BÃªn A */
    private String relationObjectA;

    private String relationObjectB;

    private String relationObjectC;

    /** TÃªn NgÃ¢n hÃ ng trung gian */
    private String bankName;

    /** CÃ´ng chá»©ng viÃªn - Há»� Ä‘á»‡m*/
    private String notaryFamilyName;

    /** CÃ´ng chá»©ng viÃªn - TÃªn*/
    private String notaryFirstName;

    private Integer contractCount;

    private Integer errorContractCount;

    private String contractSummary;

    private String userRequireContract;

    private String numberCopyOfContract;

    private String numberOfPage;

    private Long numberOfContractByDrafter;
    
    private String propertyInfo;
    
    private String propertyType;
    
    private String luceneContractInfoDisp;
    
    private String luceneContractSummaryDisp;
    
    private String luceneContractInfo;
    
    private String luceneContractSummary;
    
    private String contractPeriod;
    
    private Boolean mortageCancelFlag;
    
    private String mortageCancelDate;
    
    private String mortageCancelNote;
    
    private String relateObjectATitle;
    
    private String relateObjectBTitle;
    
    private String relateObjectCTitle;
    
    private String district;
    
    private String street;

    
    
    public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	/**
     * <P>Generate Instance.</P>
     *
     */
    public ContractInfo() {
        super();
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
     * Set the contractKindName
     *
     * @param contractKindName the contractKindName to set
     */
    public void setContractKindName(String contractKindName) {
        this.contractKindName = contractKindName;
    }


    /**
     * <P>Get id t? tang </P>
     *
     * @return id t? tang
     */
    public Long getId() {
        return this.id;
    }

    /**
     * <P>Set id t? tang. </P>
     *
     * @param id id t? tang
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * <P>Get id h?p d?ng m?u </P>
     *
     * @return id h?p d?ng m?u
     */
    public Long getContractTemplateId() {
        return this.contractTemplateId;
    }

    /**
     * <P>Set id h?p d?ng m?u. </P>
     *
     * @param contractTemplateId id h?p d?ng m?u
     */
    public void setContractTemplateId(Long contractTemplateId) {
        this.contractTemplateId = contractTemplateId;
    }

    /**
     * <P>Get S? h?p d?ng </P>
     *
     * @return S? h?p d?ng
     */
    public String getContractNumber() {
        return this.contractNumber;
    }

    /**
     * <P>Set S? h?p d?ng. </P>
     *
     * @param contractNumber S? h?p d?ng
     */
    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    /**
     * <P>Get GiÃ¡ tr? h?p d?ng </P>
     *
     * @return GiÃ¡ tr? h?p d?ng
     */
    public String getContractValueCurrency() {
        try {
            return NumberFormat.getNumberInstance(Locale.GERMANY).format(Long.parseLong(contractValue));
        } catch (Exception e) {
            return contractValue;
        }
    }

    /**
     * <P>Get GiÃ¡ tr? h?p d?ng </P>
     *
     * @return GiÃ¡ tr? h?p d?ng
     */
    public String getContractValue() {
        return this.contractValue;
    }

    /**
     * <P>Set GiÃ¡ tr? h?p d?ng. </P>
     *
     * @param contractValue GiÃ¡ tr? h?p d?ng
     */
    public void setContractValue(String contractValue) {
        this.contractValue = contractValue;
    }

    /**
     * <P>Get CÃ´ng ch?ng viÃªn </P>
     *
     * @return CÃ´ng ch?ng viÃªn
     */
    public Long getNotaryId() {
        return this.notaryId;
    }

    /**
     * <P>Set CÃ´ng ch?ng viÃªn. </P>
     *
     * @param notaryId CÃ´ng ch?ng viÃªn
     */
    public void setNotaryId(Long notaryId) {
        this.notaryId = notaryId;
    }

    /**
     * <P>Get ChuyÃªn viÃªn so?n th?o </P>
     *
     * @return ChuyÃªn viÃªn so?n th?o
     */
    public Long getDrafterId() {
        return this.drafterId;
    }

    /**
     * <P>Set ChuyÃªn viÃªn so?n th?o. </P>
     *
     * @param drafterId ChuyÃªn viÃªn so?n th?o
     */
    public void setDrafterId(Long drafterId) {
        this.drafterId = drafterId;
    }

    /**
     * <P>Get NgÃ y th? lÃ½ </P>
     *
     * @return NgÃ y th? lÃ½
     */
    public Timestamp getReceivedDate() {
        return this.receivedDate;
    }

    /**
     * <P>Set NgÃ y th? lÃ½. </P>
     *
     * @param receivedDate NgÃ y th? lÃ½
     */
    public void setReceivedDate(Timestamp receivedDate) {
        this.receivedDate = receivedDate;
    }

    /**
     * <P>Get NgÃ y cÃ´ng ch?ng </P>
     *
     * @return NgÃ y cÃ´ng ch?ng
     */
    public Timestamp getNotaryDate() {
        return this.notaryDate;
    }

    /**
     * <P>Set NgÃ y cÃ´ng ch?ng. </P>
     *
     * @param notaryDate NgÃ y cÃ´ng ch?ng
     */
    public void setNotaryDate(Timestamp notaryDate) {
        this.notaryDate = notaryDate;
    }

    /**
     * <P>Get PhÃ­ ThÃ¹ lao theo thÃ´ng tu 91 </P>
     *
     * @return PhÃ­ ThÃ¹ lao theo thÃ´ng tu 91
     */
    public String getCostTt91() {
        return this.costTt91;
    }

    /**
     * <P>Set PhÃ­ ThÃ¹ lao theo thÃ´ng tu 91. </P>
     *
     * @param costTt91 PhÃ­ ThÃ¹ lao theo thÃ´ng tu 91
     */
    public void setCostTt91(String costTt91) {
        this.costTt91 = costTt91;
    }

    /**
     * <P>Get PhÃ­ ThÃ¹ lao so?n th?o </P>
     *
     * @return PhÃ­ ThÃ¹ lao so?n th?o
     */
    public String getCostDraft() {
        return this.costDraft;
    }

    /**
     * <P>Set PhÃ­ ThÃ¹ lao so?n th?o. </P>
     *
     * @param costDraft PhÃ­ ThÃ¹ lao so?n th?o
     */
    public void setCostDraft(String costDraft) {
        this.costDraft = costDraft;
    }

    /**
     * <P>Get PhÃ­ d?ch v? cÃ´ng ch?ng ngoÃ i </P>
     *
     * @return PhÃ­ d?ch v? cÃ´ng ch?ng ngoÃ i
     */
    public String getCostNotaryOutsite() {
        return this.costNotaryOutsite;
    }

    /**
     * <P>Set PhÃ­ d?ch v? cÃ´ng ch?ng ngoÃ i. </P>
     *
     * @param costNotaryOutsite PhÃ­ d?ch v? cÃ´ng ch?ng ngoÃ i
     */
    public void setCostNotaryOutsite(String costNotaryOutsite) {
        this.costNotaryOutsite = costNotaryOutsite;
    }

    /**
     * <P>Get PhÃ­ d?ch v? xÃ¡c minh khÃ¡c </P>
     *
     * @return PhÃ­ d?ch v? xÃ¡c minh khÃ¡c
     */
    public String getCostOtherDetermine() {
        return this.costOtherDetermine;
    }

    /**
     * <P>Set PhÃ­ d?ch v? xÃ¡c minh khÃ¡c. </P>
     *
     * @param costOtherDetermine PhÃ­ d?ch v? xÃ¡c minh khÃ¡c
     */
    public void setCostOtherDetermine(String costOtherDetermine) {
        this.costOtherDetermine = costOtherDetermine;
    }

    /**
     * <P>Get T?ng phÃ­ cÃ´ng ch?ng </P>
     *
     * @return T?ng phÃ­ cÃ´ng ch?ng
     */
    public String getCostTotal() {
        return this.costTotal;
    }

    /**
     * <P>Set T?ng phÃ­ cÃ´ng ch?ng. </P>
     *
     * @param costTotal T?ng phÃ­ cÃ´ng ch?ng
     */
    public void setCostTotal(String costTotal) {
        this.costTotal = costTotal;
    }

    /**
     * <P>Get Ã�?a di?m cÃ´ng ch?ng </P>
     *
     * @return Ã�?a di?m cÃ´ng ch?ng
     */
    public String getNotaryPlace() {
        return this.notaryPlace;
    }

    /**
     * <P>Set Ã�?a di?m cÃ´ng ch?ng. </P>
     *
     * @param notaryPlace Ã�?a di?m cÃ´ng ch?ng
     */
    public void setNotaryPlace(String notaryPlace) {
        this.notaryPlace = notaryPlace;
    }

    /**
     * @return the notaryPlaceFlag
     */
    public Boolean getNotaryPlaceFlag() {
        return notaryPlaceFlag;
    }


    /**
     * @param notaryPlaceFlag the notaryPlaceFlag to set
     */
    public void setNotaryPlaceFlag(Boolean notaryPlaceFlag) {
        this.notaryPlaceFlag = notaryPlaceFlag;
    }


    /**
     * <P>Get NgÃ¢n hÃ ng trung gian </P>
     *
     * @return NgÃ¢n hÃ ng trung gian
     */
    public Long getBankId() {
        return this.bankId;
    }

    /**
     * <P>Set NgÃ¢n hÃ ng trung gian. </P>
     *
     * @param bankId NgÃ¢n hÃ ng trung gian
     */
    public void setBankId(Long bankId) {
        this.bankId = bankId;
    }

    /**
     * <P>Get Chi?t kh?u l?i cho NgÃ¢n hÃ ng </P>
     *
     * @return Chi?t kh?u l?i cho NgÃ¢n hÃ ng
     */
    public String getBankServiceFee() {
        return this.bankServiceFee;
    }

    public String getBankServiceFeeCurrency() {
        try {
            return NumberFormat.getNumberInstance(Locale.GERMANY).format(Long.parseLong(bankServiceFee));
        } catch (Exception e) {
            return bankServiceFee;
        }
    }

    /**
     * <P>Set Chi?t kh?u l?i cho NgÃ¢n hÃ ng. </P>
     *
     * @param bankServiceFee Chi?t kh?u l?i cho NgÃ¢n hÃ ng
     */
    public void setBankServiceFee(String bankServiceFee) {
        this.bankServiceFee = bankServiceFee;
    }

    /**
     * <P>Get CÃ¡n b? tÃ­n d?ng NgÃ¢n hÃ ng </P>
     *
     * @return CÃ¡n b? tÃ­n d?ng NgÃ¢n hÃ ng
     */
    public String getCrediterName() {
        return this.crediterName;
    }

    /**
     * <P>Set CÃ¡n b? tÃ­n d?ng NgÃ¢n hÃ ng. </P>
     *
     * @param crediterName CÃ¡n b? tÃ­n d?ng NgÃ¢n hÃ ng
     */
    public void setCrediterName(String crediterName) {
        this.crediterName = crediterName;
    }

    /**
     * <P>Get TÃªn file dÃ­nh kÃ¨m </P>
     *
     * @return TÃªn file dÃ­nh kÃ¨m
     */
    public String getFileName() {
        return this.fileName;
    }

    /**
     * <P>Set TÃªn file dÃ­nh kÃ¨m. </P>
     *
     * @param fileName TÃªn file dÃ­nh kÃ¨m
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * <P>Get Ã�u?ng d?n ch?a file </P>
     *
     * @return Ã�u?ng d?n ch?a file
     */
    public String getFilePath() {
        return this.filePath;
    }

    /**
     * <P>Set Ã�u?ng d?n ch?a file. </P>
     *
     * @param filePath Ã�u?ng d?n ch?a file
     */
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    /**
     * <P>Get tÃ¬nh tr?ng l?i
 </P>
     *
     * @return tÃ¬nh tr?ng l?i

     */
    public Boolean getErrorStatus() {
        return this.errorStatus;
    }

    /**
     * <P>Set tÃ¬nh tr?ng l?i
. </P>
     *
     * @param errorStatus tÃ¬nh tr?ng l?i

     */
    public void setErrorStatus(Boolean errorStatus) {
        this.errorStatus = errorStatus;
    }

    /**
     * <P>Get id CÃ¡n b? gÃ¢y l?i. </P>
     *
     * @return id CÃ¡n b? gÃ¢y l?i.
     */
    public Long getErrorUserId() {
        return this.errorUserId;
    }

    /**
     * <P>Set id CÃ¡n b? gÃ¢y l?i.. </P>
     *
     * @param errorUserId id CÃ¡n b? gÃ¢y l?i.
     */
    public void setErrorUserId(Long errorUserId) {
        this.errorUserId = errorUserId;
    }

    /**
     * <P>Get MÃ´ t? l?i </P>
     *
     * @return MÃ´ t? l?i
     */
    public String getErrorDescription() {
        return this.errorDescription;
    }

    /**
     * <P>Set MÃ´ t? l?i. </P>
     *
     * @param errorDescription MÃ´ t? l?i
     */
    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }

    /**
     * <P>Get Noi luu tr? b?n g?c h?p d?ng </P>
     *
     * @return Noi luu tr? b?n g?c h?p d?ng
     */
    public String getOriginalStorePlace() {
        return this.originalStorePlace;
    }

    /**
     * <P>Set Noi luu tr? b?n g?c h?p d?ng. </P>
     *
     * @param originalStorePlace Noi luu tr? b?n g?c h?p d?ng
     */
    public void setOriginalStorePlace(String originalStorePlace) {
        this.originalStorePlace = originalStorePlace;
    }

    /**
     * <P>Get Ghi chÃº </P>
     *
     * @return Ghi chÃº
     */
    public String getNote() {
        return this.note;
    }

    /**
     * <P>Set Ghi chÃº. </P>
     *
     * @param note Ghi chÃº
     */
    public void setNote(String note) {
        this.note = note;
    }

    /**
     * <P>Get id ngu?i t?o </P>
     *
     * @return id ngu?i t?o
     */
    public Long getEntryUserId() {
        return this.entryUserId;
    }

    /**
     * <P>Set id ngu?i t?o. </P>
     *
     * @param entryUserId id ngu?i t?o
     */
    public void setEntryUserId(Long entryUserId) {
        this.entryUserId = entryUserId;
    }

    /**
     * <P>Get TÃªn ngu?i t?o </P>
     *
     * @return TÃªn ngu?i t?o
     */
    public String getEntryUserName() {
        return this.entryUserName;
    }

    /**
     * <P>Set TÃªn ngu?i t?o. </P>
     *
     * @param entryUserName TÃªn ngu?i t?o
     */
    public void setEntryUserName(String entryUserName) {
        this.entryUserName = entryUserName;
    }

    /**
     * <P>Get NgÃ y t?o </P>
     *
     * @return NgÃ y t?o
     */
    public Timestamp getEntryDateTime() {
        return this.entryDateTime;
    }

    /**
     * <P>Set NgÃ y t?o. </P>
     *
     * @param entryDateTime NgÃ y t?o
     */
    public void setEntryDateTime(Timestamp entryDateTime) {
        this.entryDateTime = entryDateTime;
    }

    /**
     * <P>Get id ngu?i c?p nh?t cu?i </P>
     *
     * @return id ngu?i c?p nh?t cu?i
     */
    public Long getUpdateUserId() {
        return this.updateUserId;
    }

    /**
     * <P>Set id ngu?i c?p nh?t cu?i. </P>
     *
     * @param updateUserId id ngu?i c?p nh?t cu?i
     */
    public void setUpdateUserId(Long updateUserId) {
        this.updateUserId = updateUserId;
    }

    /**
     * <P>Get TÃªn ngu?i c?p nh?t cu?i </P>
     *
     * @return TÃªn ngu?i c?p nh?t cu?i
     */
    public String getUpdateUserName() {
        return this.updateUserName;
    }

    /**
     * <P>Set TÃªn ngu?i c?p nh?t cu?i. </P>
     *
     * @param updateUserName TÃªn ngu?i c?p nh?t cu?i
     */
    public void setUpdateUserName(String updateUserName) {
        this.updateUserName = updateUserName;
    }

    /**
     * <P>Get NgÃ y c?p nh?t cu?i </P>
     *
     * @return NgÃ y c?p nh?t cu?i
     */
    public Timestamp getUpdateDateTime() {
        return this.updateDateTime;
    }

    /**
     * <P>Set NgÃ y c?p nh?t cu?i. </P>
     *
     * @param updateDateTime NgÃ y c?p nh?t cu?i
     */
    public void setUpdateDateTime(Timestamp updateDateTime) {
        this.updateDateTime = updateDateTime;
    }


    /**
     * Get the drafterFamiliName
     *
     * @return the drafterFamiliName
     */
    public String getDrafterFamilyName() {
        return drafterFamilyName;
    }


    /**
     * Set the drafterFamiliName
     *
     * @param drafterFamiliName the drafterFamiliName to set
     */
    public void setDrafterFamilyName(String drafterFamiliName) {
        this.drafterFamilyName = drafterFamiliName;
    }


    /**
     * Get the drafterFirstName
     *
     * @return the drafterFirstName
     */
    public String getDrafterFirstName() {
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
     * Get the contractTemplateName
     *
     * @return the contractTemplateName
     */
    public String getContractTemplateName() {
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
     * Get the contractTemplateCode
     *
     * @return the contractTemplateCode
     */
    public String getContractTemplateCode() {
        return contractTemplateCode;
    }

    /**
     * Set the contractTemplateCode
     *
     * @param contractTemplateCode the contractTemplateCode to set
     */
    public void setContractTemplateCode(String contractTemplateCode) {
        this.contractTemplateCode = contractTemplateCode;
    }

    /**
     * Get the relateObjectNumber
     *
     * @return the relateObjectNumber
     */
    public int getRelateObjectNumber() {
        return relateObjectNumber;
    }

    /**
     * Set the relateObjectNumber
     *
     * @param relateObjectNumber the relateObjectNumber to set
     */
    public void setRelateObjectNumber(int relateObjectNumber) {
        this.relateObjectNumber = relateObjectNumber;
    }

    /**
     * Get the bankName
     *
     * @return the bankName
     */
    public String getBankName() {
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
     * Get the notaryFamilyName
     *
     * @return the notaryFamilyName
     */
    public String getNotaryFamilyName() {
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
     * Get the contractCount
     *
     * @return the contractCount
     */
    public Integer getContractCount() {
        return contractCount;
    }


    /**
     * Set the contractCount
     *
     * @param contractCount the contractCount to set
     */
    public void setContractCount(Integer contractCount) {
        this.contractCount = contractCount;
    }


    /**
     * Get the errorContractCount
     *
     * @return the errorContractCount
     */
    public Integer getErrorContractCount() {
        return errorContractCount;
    }


    /**
     * Set the errorContractCount
     *
     * @param errorContractCount the errorContractCount to set
     */
    public void setErrorContractCount(Integer errorContractCount) {
        this.errorContractCount = errorContractCount;
    }


    /**
     * Get the errorUserFamilyName
     *
     * @return the errorUserFamilyName
     */
    public String getErrorUserFamilyName() {
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
     * Get the contractSummary
     *
     * @return the contractSummary
     */
    public String getContractSummary() {
        return contractSummary;
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
        	 if (!"01".equals(propertyType)) landArea = "";
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
        if (!EditString.isNull(contractSummary))
        info += SystemMessageProperties.getSystemProperty("item_contract_summary2") 
				+ Constants.COLON + Constants.ENTER + contractSummary;
        return info;
    }

    /**
     * Get the contractSummaryDisp
     *
     * @return the contractSummaryDisp
     */
    public String getContractSummaryLucene() {
        String info = "";
//        String type = "";
        if (!EditString.isNull(propertyInfo)) {
        	 String landArea = getLandArea();
        	 if (!"01".equals(propertyType)) landArea = "";
//            if ("01".equals(propertyType)) {
//                type = SystemMessageProperties.getSystemProperty("item_land");
//            } else if ("02".equals(propertyType)) {
//                type = SystemMessageProperties.getSystemProperty("item_vehicle");
//            } else if ("99".equals(propertyType)) {
//                type = SystemMessageProperties.getSystemProperty("item_other");
//            }
            info += SystemMessageProperties.getSystemProperty("item_property2")
                + Constants.COLON + Constants.SPACE + /*type +*/ Constants.ENTER + landArea +  propertyInfo+ Constants.ENTER;
        }
        if (!EditString.isNull(contractSummary))
        info += SystemMessageProperties.getSystemProperty("item_contract_summary") 
				+ Constants.COLON + Constants.ENTER + contractSummary;
        info = EditString.replaceChangeLine(info);
        info = EditString.filterIgnoreB(info);
        return info;
    }
    
    /**
     * Get the contractSummaryDisp
     *
     * @return the contractSummaryDisp
     */
    public String getContractSummaryDisp() {
        String info = "";
//        String type = "";
        if (!EditString.isNull(propertyInfo)) {
        	 String landArea = getLandArea();
        	 if (!"01".equals(propertyType)) landArea = "";
//            if ("01".equals(propertyType)) {
//                type = SystemMessageProperties.getSystemProperty("item_land");
//            } else if ("02".equals(propertyType)) {
//                type = SystemMessageProperties.getSystemProperty("item_vehicle");
//            } else if ("99".equals(propertyType)) {
//                type = SystemMessageProperties.getSystemProperty("item_other");
//            }
        	info += SystemMessageProperties.getSystemProperty("item_property2")
            + Constants.COLON + Constants.SPACE + /*type +*/ Constants.ENTER + landArea +  propertyInfo+ Constants.ENTER;
        }
        if (!EditString.isNull(contractSummary))
        info += SystemMessageProperties.getSystemProperty("item_contract_summary") 
        		+ Constants.COLON + Constants.ENTER + contractSummary;
        info = EditString.replaceChangeLine(info);
        info = EditString.filterIgnoreB(info);
        return info;
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
     * Set the contractSummary
     *
     * @param contractSummary the contractSummary to set
     */
    public void setContractSummary(String contractSummary) {
        this.contractSummary = contractSummary;
    }


    /**
     * Get the notaryAccount
     *
     * @return the notaryAccount
     */
    public String getNotaryAccount() {
        return notaryAccount;
    }


    /**
     * Set the notaryAccount
     *
     * @param notaryAccount the notaryAccount to set
     */
    public void setNotaryAccount(String notaryAccount) {
        this.notaryAccount = notaryAccount;
    }


    /**
     * Get the drafterAccount
     *
     * @return the drafterAccount
     */
    public String getDrafterAccount() {
        return drafterAccount;
    }


    /**
     * Set the drafterAccount
     *
     * @param drafterAccount the drafterAccount to set
     */
    public void setDrafterAccount(String drafterAccount) {
        this.drafterAccount = drafterAccount;
    }

    /**
     * Get the userRequireContract
     *
     * @return the userRequireContract
     */
    public String getUserRequireContract() {
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

    /**
     * Get the additionStatus
     *
     * @return the additionStatus
     */
    public Boolean getAdditionStatus() {
        return additionStatus;
    }

    /**
     * Set the additionStatus
     *
     * @param additionStatus the additionStatus to set
     */
    public void setAdditionStatus(Boolean additionStatus) {
        this.additionStatus = additionStatus;
    }

    /**
     * Get the additionDescription
     *
     * @return the additionDescription
     */
    public String getAdditionDescription() {
        return additionDescription;
    }

    /**
     * Set the additionDescription
     *
     * @param additionDescription the additionDescription to set
     */
    public void setAdditionDescription(String additionDescription) {
        this.additionDescription = additionDescription;
    }

    /**
     * Get the numberOfContractByDrafter
     *
     * @return the numberOfContractByDrafter
     */
    public Long getNumberOfContractByDrafter() {
        if (numberOfContractByDrafter == null) {
            return 0L;
        }
        return numberOfContractByDrafter;
    }

    /**
     * Set the numberOfContractByDrafter
     *
     * @param numberOfContractByDrafter the numberOfContractByDrafter to set
     */
    public void setNumberOfContractByDrafter(Long numberOfContractByDrafter) {
        this.numberOfContractByDrafter = numberOfContractByDrafter;
    }

    /**
     * <P>Get Trang thai huy hop dong </P>
     *
     * @return Trang thai huy hop dong
     */
    public Boolean getCancelStatus() {
        return this.cancelStatus;
    }

    /**
     * <P>Set Trang thai huy hop dong. </P>
     *
     * @param cancelStatus Trang thai huy hop dong
     */
    public void setCancelStatus(Boolean cancelStatus) {
        this.cancelStatus = cancelStatus;
    }

    /**
     * <P>Get Mo ta chi tiet huy hop dong </P>
     *
     * @return Mo ta chi tiet huy hop dong
     */
    public String getCancelDescription() {
        return this.cancelDescription;
    }

    /**
     * <P>Set Mo ta chi tiet huy hop dong. </P>
     *
     * @param cancelDescription Mo ta chi tiet huy hop dong
     */
    public void setCancelDescription(String cancelDescription) {
        this.cancelDescription = cancelDescription;
    }

    /**
     * <P>Get  </P>
     *
     * @return
     */
    public Long getCancelRelationContractId() {
        return this.cancelRelationContractId;
    }

    /**
     * <P>Set . </P>
     *
     * @param cancelRelationContractId
     */
    public void setCancelRelationContractId(Long cancelRelationContractId) {
        this.cancelRelationContractId = cancelRelationContractId;
    }

    /**
     * Get the relationObjectA
     *
     * @return the relationObjectA
     */
    public String getRelationObjectA() {
        return relationObjectA;
    }

    /**
     * Set the relationObjectA
     *
     * @param relationObjectA the relationObjectA to set
     */
    public void setRelationObjectA(String relationObjectA) {
        this.relationObjectA = relationObjectA;
    }

    /**
     * Get the relationObjectB
     *
     * @return the relationObjectB
     */
    public String getRelationObjectB() {
        return relationObjectB;
    }

    /**
     * Set the relationObjectB
     *
     * @param relationObjectB the relationObjectB to set
     */
    public void setRelationObjectB(String relationObjectB) {
        this.relationObjectB = relationObjectB;
    }

    /**
     * Get the relationObjectC
     *
     * @return the relationObjectC
     */
    public String getRelationObjectC() {
        return relationObjectC;
    }

    /**
     * Set the relationObjectC
     *
     * @param relationObjectC the relationObjectC to set
     */
    public void setRelationObjectC(String relationObjectC) {
        this.relationObjectC = relationObjectC;
    }

    /**
     * Get the relationObjectA to display
     *
     * @return the relationObjectA
     */
    public String getRelationObjectADisp() {
        return EditString.replaceChangeLine(relationObjectA);
    }

    /**
     * Get the relationObjectB to display
     *
     * @return the relationObjectB
     */
    public String getRelationObjectBDisp() {
        return EditString.replaceChangeLine(relationObjectB);
    }

    /**
     * Get the relationObjectC to display
     *
     * @return the relationObjectC
     */
    public String getRelationObjectCDisp() {
        return EditString.replaceChangeLine(relationObjectC);
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
        	 if (relateObjectATitle==null || relateObjectATitle.equals(SystemMessageProperties.getSystemProperty("item_relation_object"))) {
             	relateObjectATitle = SystemMessageProperties.getSystemProperty("item_relation_objectA");
             }
            info += /*SystemMessageProperties.getSystemProperty("item_relation_objectA")*/ relateObjectATitle
                + Constants.COLON + Constants.SPACE + relationObjectA;
        }
        if (!EditString.isNull(relationObjectB)) {
        	 if (relateObjectBTitle==null || relateObjectBTitle.equals(SystemMessageProperties.getSystemProperty("item_relation_object"))) {
             	relateObjectBTitle = SystemMessageProperties.getSystemProperty("item_relation_objectB");
             }
            info += Constants.ENTER + /*SystemMessageProperties.getSystemProperty("item_relation_objectB")*/ relateObjectBTitle
                + Constants.COLON + Constants.SPACE + relationObjectB;
        }
        if (!EditString.isNull(relationObjectC)) {
        	 if (relateObjectCTitle==null || relateObjectCTitle.equals(SystemMessageProperties.getSystemProperty("item_relation_object"))) {
             	relateObjectCTitle = SystemMessageProperties.getSystemProperty("item_relation_objectC");
             }
            info += Constants.ENTER + /*SystemMessageProperties.getSystemProperty("item_relation_objectC")*/ relateObjectCTitle
                + Constants.COLON + Constants.SPACE + relationObjectC;
        }
        return EditString.replaceChangeLine(info);
    }
    
    /**
     * Get the contract Information
     *
     * @return the contractInformation
     */
    public String getRelationInfoLucene() {
        String info = "";
        if (!EditString.isNull(relationObjectA)) {
        	 if (relateObjectATitle==null || relateObjectATitle.equals(SystemMessageProperties.getSystemProperty("item_relation_object"))) {
             	relateObjectATitle = SystemMessageProperties.getSystemProperty("item_relation_objectA");
             }
            info += /*SystemMessageProperties.getSystemProperty("item_relation_objectA")*/ relateObjectATitle
                + Constants.COLON + Constants.SPACE + relationObjectA;
        }
        if (!EditString.isNull(relationObjectB)) {
        	 if (relateObjectBTitle==null || relateObjectBTitle.equals(SystemMessageProperties.getSystemProperty("item_relation_object"))) {
             	relateObjectBTitle = SystemMessageProperties.getSystemProperty("item_relation_objectB");
             }
            info += Constants.ENTER + /*SystemMessageProperties.getSystemProperty("item_relation_objectB")*/ relateObjectBTitle
                + Constants.COLON + Constants.SPACE + relationObjectB;
        }
        if (!EditString.isNull(relationObjectC)) {
        	 if (relateObjectCTitle==null || relateObjectCTitle.equals(SystemMessageProperties.getSystemProperty("item_relation_object"))) {
             	relateObjectCTitle = SystemMessageProperties.getSystemProperty("item_relation_objectC");
             }
            info += Constants.ENTER + /*SystemMessageProperties.getSystemProperty("item_relation_objectC")*/ relateObjectCTitle
                + Constants.COLON + Constants.SPACE + relationObjectC;
        }
        return EditString.replaceChangeLine(info);
    }

    public String getContractInformationDisp() {
        return EditString.getDisp(getContractInformation(), Constants.LENGTH_OUTPUT_LIMIT);
    }

    public String getErrorDescriptionDisp() {
        return EditString.getDisp(getErrorDescription(), Constants.LENGTH_OUTPUT_LIMIT);
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

	/**
	 * @param luceneContractInfoDisp the luceneContractInfoDisp to set
	 */
	public void setLuceneContractInfoDisp(String luceneContractInfoDisp) {
		this.luceneContractInfoDisp = luceneContractInfoDisp;
	}

	/**
	 * @return the luceneContractInfoDisp
	 */
	public String getLuceneContractInfoDisp() {
		return luceneContractInfoDisp;
	}

	/**
	 * @param luceneContractSummaryDisp the luceneContractSummaryDisp to set
	 */
	public void setLuceneContractSummaryDisp(String luceneContractSummaryDisp) {
		this.luceneContractSummaryDisp = luceneContractSummaryDisp;
	}

	/**
	 * @return the luceneContractSummaryDisp
	 */
	public String getLuceneContractSummaryDisp() {
		return luceneContractSummaryDisp;
	}

	/**
	 * @param luceneContractInfo the luceneContractInfo to set
	 */
	public void setLuceneContractInfo(String luceneContractInfo) {
		this.luceneContractInfo = luceneContractInfo;
	}

	/**
	 * @return the luceneContractInfo
	 */
	public String getLuceneContractInfo() {
		return luceneContractInfo;
	}

	/**
	 * @param luceneContractSummary the luceneContractSummary to set
	 */
	public void setLuceneContractSummary(String luceneContractSummary) {
		this.luceneContractSummary = luceneContractSummary;
	}

	/**
	 * @return the luceneContractSummary
	 */
	public String getLuceneContractSummary() {
		return luceneContractSummary;
	}

	/**
	 * @param contractPeriod the contractPeriod to set
	 */
	public void setContractPeriod(String contractPeriod) {
		this.contractPeriod = contractPeriod;
	}

	/**
	 * @return the contractPeriod
	 */
	public String getContractPeriod() {
		return EditString.replaceChangeLine(contractPeriod);
	}

	/**
	 * @param mortageCancelDate the mortageCancelDate to set
	 */
	public void setMortageCancelDate(String mortageCancelDate) {
		this.mortageCancelDate = mortageCancelDate;
	}

	/**
	 * @return the mortageCancelDate
	 */
	public String getMortageCancelDate() {
		return mortageCancelDate;
	}
	
	public String getMortageCancelDateDisp() {
		String date = SystemMessageProperties.getSystemProperty("item_mortage_date") + Constants.SPACE + mortageCancelDate;
		return date;
	}

	/**
	 * @param mortageCancelNote the mortageCancelNote to set
	 */
	public void setMortageCancelNote(String mortageCancelNote) {
		this.mortageCancelNote = mortageCancelNote;
	}

	/**
	 * @return the mortageCancelNote
	 */
	public String getMortageCancelNote() {
		return mortageCancelNote;
	}
	
	/**
	 * @return the mortageCancelNote
	 */
	public String getMortageCancelNoteDisp() {
		return EditString.replaceChangeLine(mortageCancelNote);
	}

	/**
	 * @param mortageCancelFlag the mortageCancelFlag to set
	 */
	public void setMortageCancelFlag(Boolean mortageCancelFlag) {
		this.mortageCancelFlag = mortageCancelFlag;
	}

	/**
	 * @return the mortageCancelFlag
	 */
	public Boolean getMortageCancelFlag() {
		return mortageCancelFlag;
	}

	/**
	 * @param relateObjectATitle the relateObjectATitle to set
	 */
	public void setRelateObjectATitle(String relateObjectATitle) {
		this.relateObjectATitle = relateObjectATitle;
	}

	/**
	 * @return the relateObjectATitle
	 */
	public String getRelateObjectATitle() {
		return relateObjectATitle;
	}

	/**
	 * @param relateObjectBTitle the relateObjectBTitle to set
	 */
	public void setRelateObjectBTitle(String relateObjectBTitle) {
		this.relateObjectBTitle = relateObjectBTitle;
	}

	/**
	 * @return the relateObjectBTitle
	 */
	public String getRelateObjectBTitle() {
		return relateObjectBTitle;
	}

	/**
	 * @param relateObjectCTitle the relateObjectCTitle to set
	 */
	public void setRelateObjectCTitle(String relateObjectCTitle) {
		this.relateObjectCTitle = relateObjectCTitle;
	}

	/**
	 * @return the relateObjectCTitle
	 */
	public String getRelateObjectCTitle() {
		return relateObjectCTitle;
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

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	/**
	 * @param page the page to set
	 */
	public void setPage(String page) {
		this.page = page;
	}

	/**
	 * @return the page
	 */
	public String getPage() {
		return page;
	}
    
}
