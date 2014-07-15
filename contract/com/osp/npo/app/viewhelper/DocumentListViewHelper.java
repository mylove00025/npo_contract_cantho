package com.osp.npo.app.viewhelper;

import java.util.List;

import com.osp.npo.app.form.DocumentListForm;
import com.osp.npo.core.document.DocumentInfo;

public class DocumentListViewHelper extends AbstractPageListViewHelper{

    public static final String SESSION_KEY = "documentListViewHelper";

	private String documentNameFilter;
	
	private String nameHistoryFilter;
	
	private String direction;

	private int firstIndex;
	
	private Boolean makeNewFolder = Boolean.FALSE;
	
	private String folderPath;
	
	private String folderPathDisp1;
	
	private String folderPathDisp2;
	
	private Long previousId;
	
	private Boolean isSearch = Boolean.FALSE;
	

	private List<DocumentInfo> documentList = null;
	
	

	 /**
     * @return the lstContractKindTreeNode
     */
    public List<DocumentInfo> getDocumentList() {
        return documentList;
    }

    /**
     * @param lstContractKindTreeNode the lstContractKindTreeNode to set
     */
    public void setDocumentList(List<DocumentInfo> documentList) {
        this.documentList = documentList;
    }


	/**
	 * @return the contractKindName
	 */
	public String getDocumentNameFilter() {
		return documentNameFilter;
	}

	/**
	 * @param contractKindName the contractKindName to set
	 */
	public void setDocumentNameFilter(String documentNameFilter) {
		this.documentNameFilter = documentNameFilter;
	}

	/**
	 * @return the direction
	 */
	public String getDirection() {
		return direction;
	}

	/**
	 * @param direction the direction to set
	 */
	public void setDirection(String direction) {
		this.direction = direction;
	}

	/**
	 * @return the firstIndex
	 */
	public int getFirstIndex() {
		return firstIndex;
	}

	/**
	 * @param firstIndex the firstIndex to set
	 */
	public void setFirstIndex(int firstIndex) {
		this.firstIndex = firstIndex;
	}
	
	 /**
     * reset from form
     * 
     * @param f
     */
    public void reset(DocumentListForm f) {
        documentNameFilter=f.getDocumentNameFilter().trim();	   
        nameHistoryFilter = f.getDocumentNameFilter().trim();
    }

	/**
	 * @param makeNewFolder the makeNewFolder to set
	 */
	public void setMakeNewFolder(Boolean makeNewFolder) {
		this.makeNewFolder = makeNewFolder;
	}

	/**
	 * @return the makeNewFolder
	 */
	public Boolean getMakeNewFolder() {
		return makeNewFolder;
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
	 * @param folderPathDisp1 the folderPathDisp1 to set
	 */
	public void setFolderPathDisp1(String folderPathDisp1) {
		this.folderPathDisp1 = folderPathDisp1;
	}

	/**
	 * @return the folderPathDisp1
	 */
	public String getFolderPathDisp1() {
		return folderPathDisp1;
	}

	/**
	 * @param folderPathDisp2 the folderPathDisp2 to set
	 */
	public void setFolderPathDisp2(String folderPathDisp2) {
		this.folderPathDisp2 = folderPathDisp2;
	}

	/**
	 * @return the folderPathDisp2
	 */
	public String getFolderPathDisp2() {
		return folderPathDisp2;
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
	 * @param previousId the previousId to set
	 */
	public void setPreviousId(Long previousId) {
		this.previousId = previousId;
	}

	/**
	 * @return the previousId
	 */
	public Long getPreviousId() {
		return previousId;
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