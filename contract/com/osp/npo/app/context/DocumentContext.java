/**
 * 
 */
package com.osp.npo.app.context;

/**
 * @author PhuongNT
 *
 */
public class DocumentContext {
    /** session key */
    public static final String SESSION_KEY = "documentContext";   
    
    private String documentName;
    private Long documentId;

	/**
	 * @return the bankName
	 */
	public String getDocumentName() {
		return documentName;
	}

	/**
	 * @param bankName the bankName to set
	 */
	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}

	public void reset() {
		// TODO Auto-generated method stub
		this.documentName = null;
		this.documentId = 0L;
	}

	/**
	 * @param previousId the previousId to set
	 */
	public void setDocumentId(Long documentId) {
		this.documentId = documentId;
	}

	/**
	 * @return the previousId
	 */
	public Long getDocumentId() {
		return documentId;
	}
    
}
