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

    /** T�n file */
    private String name;

    /** T�n file d�nh k�m */
    private String docFileName;

    /** �u?ng d?n file d�nh k�m */
    private String filePath;

    /** Lo?i t�i li?u:
 */
    private Long type;

    /** ID c?a folder m? */
    private Long previousId;

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
     * <P>Get T�n file </P>
     *
     * @return T�n file
     */
    public String getName() {
        return this.name;
    }

    /**
     * <P>Set T�n file. </P>
     *
     * @param name T�n file
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * <P>Get T�n file d�nh k�m </P>
     *
     * @return T�n file d�nh k�m
     */
    public String getDocFileName() {
        return this.docFileName;
    }

    /**
     * <P>Set T�n file d�nh k�m. </P>
     *
     * @param docFileName T�n file d�nh k�m
     */
    public void setDocFileName(String docFileName) {
        this.docFileName = docFileName;
    }

    /**
     * <P>Get �u?ng d?n file d�nh k�m </P>
     *
     * @return �u?ng d?n file d�nh k�m
     */
    public String getFilePath() {
        return this.filePath;
    }

    /**
     * <P>Set �u?ng d?n file d�nh k�m. </P>
     *
     * @param filePath �u?ng d?n file d�nh k�m
     */
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    /**
     * <P>Get Lo?i t�i li?u:
 </P>
     *
     * @return Lo?i t�i li?u:

     */
    public Long getType() {
        return this.type;
    }

    /**
     * <P>Set Lo?i t�i li?u:
. </P>
     *
     * @param type Lo?i t�i li?u:

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
