/**
 * 
 */
package com.osp.npo.app.context;

/**
 * @author TruongND
 *
 */
public class DocumentListContext {
    /** session key */
    public static final String SESSION_KEY = "documentListContext";   
    
    private String documentNameFilter;
    private Long previousId;

	/**
	 * @return the bankName
	 */
	public String getDocumentNameFilter() {
		return documentNameFilter;
	}

	/**
	 * @param bankName the bankName to set
	 */
	public void setDocumentNameFilter(String documentNameFilter) {
		this.documentNameFilter = documentNameFilter;
	}

	public void reset() {
		// TODO Auto-generated method stub
		this.documentNameFilter = null;
		this.previousId = null;
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
    
}
