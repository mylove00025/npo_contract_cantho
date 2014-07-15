package com.osp.npo.core.document;


import com.osp.npo.core.AbstractInfo;
import java.sql.Timestamp;


/**
 * Generate by script
 * Generate date: 7/13/2011 4:00:13 PM
 * @version $Revision$ 
 */
public class DocumentInfo extends AbstractInfo {


    /** id file,folder */
    private Long id;

    /** Tên file */
    private String name;

    /** Tên file dính kèm */
    private String docFileName;

    /** Ðu?ng d?n file dính kèm */
    private String filePath;

    /** Lo?i tài li?u:
 */
    private Long type;

    /** ID c?a folder m? */
    private Long previousId;

    /** id ngu?i t?o */
    private Long entryUserId;

    /** Tên ngu?i t?o */
    private String entryUserName;

    /** Ngày t?o */
    private Timestamp entryDateTime;

    /** id ngu?i c?p nh?t cu?i */
    private Long updateUserId;

    /** Tên ngu?i c?p nh?t cu?i */
    private String updateUserName;

    /** Ngày c?p nh?t cu?i */
    private Timestamp updateDateTime;
    
    /** folder path */
    private String folderPath;
    
    /** folder path */
    private String folderPathDisp;


    /**
     * <P>Generate Instance.</P>
     *
     */
    public DocumentInfo() {
        super();
    }


    /**
     * <P>Get id file,folder </P>
     *
     * @return id file,folder
     */
    public Long getId() {
        return this.id;
    }

    /**
     * <P>Set id file,folder. </P>
     *
     * @param id id file,folder
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * <P>Get Tên file </P>
     *
     * @return Tên file
     */
    public String getName() {
        return this.name;
    }

    /**
     * <P>Set Tên file. </P>
     *
     * @param name Tên file
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * <P>Get Tên file dính kèm </P>
     *
     * @return Tên file dính kèm
     */
    public String getDocFileName() {
        return this.docFileName;
    }

    /**
     * <P>Set Tên file dính kèm. </P>
     *
     * @param docFileName Tên file dính kèm
     */
    public void setDocFileName(String docFileName) {
        this.docFileName = docFileName;
    }

    /**
     * <P>Get Ðu?ng d?n file dính kèm </P>
     *
     * @return Ðu?ng d?n file dính kèm
     */
    public String getFilePath() {
        return this.filePath;
    }

    /**
     * <P>Set Ðu?ng d?n file dính kèm. </P>
     *
     * @param filePath Ðu?ng d?n file dính kèm
     */
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    /**
     * <P>Get Lo?i tài li?u:
 </P>
     *
     * @return Lo?i tài li?u:

     */
    public Long getType() {
        return this.type;
    }

    /**
     * <P>Set Lo?i tài li?u:
. </P>
     *
     * @param type Lo?i tài li?u:

     */
    public void setType(Long type) {
        this.type = type;
    }

    /**
     * <P>Get ID c?a folder m? </P>
     *
     * @return ID c?a folder m?
     */
    public Long getPreviousId() {
        return this.previousId;
    }

    /**
     * <P>Set ID c?a folder m?. </P>
     *
     * @param previousId ID c?a folder m?
     */
    public void setPreviousId(Long previousId) {
        this.previousId = previousId;
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
     * <P>Get Tên ngu?i t?o </P>
     *
     * @return Tên ngu?i t?o
     */
    public String getEntryUserName() {
        return this.entryUserName;
    }

    /**
     * <P>Set Tên ngu?i t?o. </P>
     *
     * @param entryUserName Tên ngu?i t?o
     */
    public void setEntryUserName(String entryUserName) {
        this.entryUserName = entryUserName;
    }

    /**
     * <P>Get Ngày t?o </P>
     *
     * @return Ngày t?o
     */
    public Timestamp getEntryDateTime() {
        return this.entryDateTime;
    }

    /**
     * <P>Set Ngày t?o. </P>
     *
     * @param entryDateTime Ngày t?o
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
     * <P>Get Tên ngu?i c?p nh?t cu?i </P>
     *
     * @return Tên ngu?i c?p nh?t cu?i
     */
    public String getUpdateUserName() {
        return this.updateUserName;
    }

    /**
     * <P>Set Tên ngu?i c?p nh?t cu?i. </P>
     *
     * @param updateUserName Tên ngu?i c?p nh?t cu?i
     */
    public void setUpdateUserName(String updateUserName) {
        this.updateUserName = updateUserName;
    }

    /**
     * <P>Get Ngày c?p nh?t cu?i </P>
     *
     * @return Ngày c?p nh?t cu?i
     */
    public Timestamp getUpdateDateTime() {
        return this.updateDateTime;
    }

    /**
     * <P>Set Ngày c?p nh?t cu?i. </P>
     *
     * @param updateDateTime Ngày c?p nh?t cu?i
     */
    public void setUpdateDateTime(Timestamp updateDateTime) {
        this.updateDateTime = updateDateTime;
    }


	/**
	 * @param folderPath the folderPath to set
	 */
	public void setFolderPath(String folderPath) {
		this.folderPath = folderPath;
	}


	/**
	 * @return the folderPath
	 */
	public String getFolderPath() {
		return folderPath;
	}


	/**
	 * @param folderPathDisp the folderPathDisp to set
	 */
	public void setFolderPathDisp(String folderPathDisp) {
		this.folderPathDisp = folderPathDisp;
	}


	/**
	 * @return the folderPathDisp
	 */
	public String getFolderPathDisp() {
		return folderPathDisp;
	}
    
    
}
