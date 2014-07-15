package com.osp.npo.app.viewhelper;

import java.sql.Timestamp;

public class DocumentViewHelper extends AbstractPageListViewHelper{

    public static final String SESSION_KEY = "documentViewHelper";

    private Long id;

    private String documentName;

    private String docFileName;

    private String filePath;

    private Long type;

    private Long previousId;

    private Long entryUserId;

    private String entryUserName;

    private Timestamp entryDateTime;

    private Long updateUserId;

    private String updateUserName;

    private Timestamp updateDateTime;
    
    private String documentNameFilter;
    
    private String nameHistoryFilter;
    
    private Boolean isSearch = Boolean.FALSE;
		


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
	 * @param documentName the documentName to set
	 */
	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}

	/**
	 * @return the documentName
	 */
	public String getDocumentName() {
		return documentName;
	}

	/**
	 * @param documentNameFilter the documentNameFilter to set
	 */
	public void setDocumentNameFilter(String documentNameFilter) {
		this.documentNameFilter = documentNameFilter;
	}

	/**
	 * @return the documentNameFilter
	 */
	public String getDocumentNameFilter() {
		return documentNameFilter;
	}

	/**
	 * @param isSearch the isSearch to set
	 */
	public void setIsSearch(Boolean isSearch) {
		this.isSearch = isSearch;
	}

	/**
	 * @return the isSearch
	 */
	public Boolean getIsSearch() {
		return isSearch;
	}

	/**
	 * @param nameHistoryFilter the nameHistoryFilter to set
	 */
	public void setNameHistoryFilter(String nameHistoryFilter) {
		this.nameHistoryFilter = nameHistoryFilter;
	}

	/**
	 * @return the nameHistoryFilter
	 */
	public String getNameHistoryFilter() {
		return nameHistoryFilter;
	}

}