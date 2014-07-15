package com.osp.npo.core.contract;


import java.sql.Timestamp;

import com.osp.npo.common.util.EditString;
import com.osp.npo.core.AbstractInfo;


/**
 * Generate by script
 * Generate date: 10/28/2010 12:04:18 PM
 */
public class ContractTemplateInfo extends AbstractInfo {

	public static final Byte SYNC_OPTION_NOT_CONTENT = 1;
	public static final Byte SYNC_OPTION_NOT_RELATEOBJ = 2;

    /** id t? tang */
    private Long id;

    /** T�n h?p d?ng */
    private String name;

    /** Lo?i h?p d?ng */
    private Long kindId;
    
    /** Lo?i h?p d?ng tt 08*/
    private Long kindIdTT08;

    /** M� t? h?p d?ng */
    private String description;

    /** T�n file d�nh k�m */
    private String fileName;

    /** �u?ng d?n ch?a file d�nh k�m */
    private String filePath;

    /** Tr?ng th�i s? d?ng c?a h?p d?ng m?u:
 */
    private Boolean activeFlg;

    /** id ngu?i t?o */
    private Long entryUserId;

    /** T�n ngu?i t?o */
    private String entryUserName;

    /** Ng�y t?o */
    private Timestamp entryDateTime;

    /** id ngu?i c?p nh?t cu?i */
    private Long updateUserId;

    /** T�n ngu?i c?p nh?t cu?i */
    private String updateUserName;

    /** Ng�y c?p nh?t cu?i */
    private Timestamp updateDateTime;

    /** Loai hop dong */
    private String contractKindName;
    
    private String code;
    
    private Integer relateObjectNumber;
    
    private String relateObjectATitle;
    
    private String relateObjectBTitle;
    
    private String relateObjectCTitle;
    
    private Boolean mortageCancelFunc;
    
    private Boolean periodFlag;

    /** Synchronize Option */
    private Byte syncOption;
  
    /**
     * <P>Generate Instance.</P>
     *
     */
    public ContractTemplateInfo() {
        super();
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
     * <P>Get T�n h?p d?ng </P>
     *
     * @return T�n h?p d?ng
     */
    public String getName() {
        return this.name;
    }

    /**
     * <P>Set T�n h?p d?ng. </P>
     *
     * @param name T�n h?p d?ng
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * <P>Get Lo?i h?p d?ng </P>
     *
     * @return Lo?i h?p d?ng
     */
    public Long getKindId() {
        return this.kindId;
    }

    /**
     * <P>Set Lo?i h?p d?ng. </P>
     *
     * @param kindId Lo?i h?p d?ng
     */
    public void setKindId(Long kindId) {
        this.kindId = kindId;
    }

    /**
     * <P>Get M� t? h?p d?ng </P>
     *
     * @return M� t? h?p d?ng
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * <P>Set M� t? h?p d?ng. </P>
     *
     * @param description M� t? h?p d?ng
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * <P>Get T�n file d�nh k�m </P>
     *
     * @return T�n file d�nh k�m
     */
    public String getFileName() {
        return this.fileName;
    }

    /**
     * <P>Set T�n file d�nh k�m. </P>
     *
     * @param fileName T�n file d�nh k�m
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * <P>Get �u?ng d?n ch?a file d�nh k�m </P>
     *
     * @return �u?ng d?n ch?a file d�nh k�m
     */
    public String getFilePath() {
        return this.filePath;
    }

    /**
     * <P>Set �u?ng d?n ch?a file d�nh k�m. </P>
     *
     * @param filePath �u?ng d?n ch?a file d�nh k�m
     */
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    /**
     * <P>Get Tr?ng th�i s? d?ng c?a h?p d?ng m?u:
 </P>
     *
     * @return Tr?ng th�i s? d?ng c?a h?p d?ng m?u:

     */
    public Boolean getActiveFlg() {
        return this.activeFlg;
    }

    /**
     * <P>Set Tr?ng th�i s? d?ng c?a h?p d?ng m?u:
. </P>
     *
     * @param activeFlg Tr?ng th�i s? d?ng c?a h?p d?ng m?u:

     */
    public void setActiveFlg(Boolean activeFlg) {
        this.activeFlg = activeFlg;
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
     * <P>Get T�n ngu?i t?o </P>
     *
     * @return T�n ngu?i t?o
     */
    public String getEntryUserName() {
        return this.entryUserName;
    }

    /**
     * <P>Set T�n ngu?i t?o. </P>
     *
     * @param entryUserName T�n ngu?i t?o
     */
    public void setEntryUserName(String entryUserName) {
        this.entryUserName = entryUserName;
    }

    /**
     * <P>Get Ng�y t?o </P>
     *
     * @return Ng�y t?o
     */
    public Timestamp getEntryDateTime() {
        return this.entryDateTime;
    }

    /**
     * <P>Set Ng�y t?o. </P>
     *
     * @param entryDateTime Ng�y t?o
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
     * <P>Get T�n ngu?i c?p nh?t cu?i </P>
     *
     * @return T�n ngu?i c?p nh?t cu?i
     */
    public String getUpdateUserName() {
        return this.updateUserName;
    }

    /**
     * <P>Set T�n ngu?i c?p nh?t cu?i. </P>
     *
     * @param updateUserName T�n ngu?i c?p nh?t cu?i
     */
    public void setUpdateUserName(String updateUserName) {
        this.updateUserName = updateUserName;
    }

    /**
     * <P>Get Ng�y c?p nh?t cu?i </P>
     *
     * @return Ng�y c?p nh?t cu?i
     */
    public Timestamp getUpdateDateTime() {
        return this.updateDateTime;
    }

    /**
     * <P>Set Ng�y c?p nh?t cu?i. </P>
     *
     * @param updateDateTime Ng�y c?p nh?t cu?i
     */
    public void setUpdateDateTime(Timestamp updateDateTime) {
        this.updateDateTime = updateDateTime;
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
     * Get the contractTemplateCode
     *
     * @return the contractTemplateCode
     */
    public String getCode() {
        return code;
    }


    /**
     * Set the contractTemplateCode
     *
     * @param contractTemplateCode the contractTemplateCode to set
     */
    public void setCode(String code) {
        this.code = code;
    }


    /**
     * Get the relateObjectNumber
     *
     * @return the relateObjectNumber
     */
    public Integer getRelateObjectNumber() {
        return relateObjectNumber;
    }


    /**
     * Set the relateObjectNumber
     *
     * @param relateObjectNumber the relateObjectNumber to set
     */
    public void setRelateObjectNumber(Integer relateObjectNumber) {
        this.relateObjectNumber = relateObjectNumber;
    }




	/**
	 * @return the descriptionDisp
	 */
	public String getDescriptionDisp2() {
		
         return EditString.replaceChangeLine2(description);
    
	}   
	
	/**
	 * @return the descriptionDisp
	 */
	public String getDescriptionDisp() {
		
         return EditString.replaceChangeLine(description);
    
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
	
	/**
	 * @param mortageCancelFunc the mortageCancelFunc to set
	 */
	public void setMortageCancelFunc(Boolean mortageCancelFunc) {
		this.mortageCancelFunc = mortageCancelFunc;
	}

	/**
	 * @return the mortageCancelFunc
	 */
	public Boolean getMortageCancelFunc() {
		return mortageCancelFunc;
	}

	/**
	 * @param periodFlag the periodFlag to set
	 */
	public void setPeriodFlag(Boolean periodFlag) {
		this.periodFlag = periodFlag;
	}

	/**
	 * @return the periodFlag
	 */
	public Boolean getPeriodFlag() {
		return periodFlag;
	}


	/**
	 * @param kindIdTT08 the kindIdTT08 to set
	 */
	public void setKindIdTT08(Long kindIdTT08) {
		this.kindIdTT08 = kindIdTT08;
	}


	/**
	 * @return the kindIdTT08
	 */
	public Long getKindIdTT08() {
		return kindIdTT08;
	}


	/**
	 * Get syncOption
	 * @return the syncOption
	 */
	public Byte getSyncOption() {
		return syncOption;
	}


	/**
	 * Set syncOption
	 * @param syncOption the syncOption to set
	 */
	public void setSyncOption(Byte syncOption) {
		this.syncOption = syncOption;
	}

}
