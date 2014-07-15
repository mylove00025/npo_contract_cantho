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