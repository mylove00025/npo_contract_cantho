package com.osp.npo.app.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;
import org.apache.struts.validator.ValidatorForm;

import com.osp.npo.app.viewhelper.DocumentListViewHelper;

public class DocumentListForm extends ValidatorForm{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -57070114464792757L;


	private String direction;
	
	private String documentName;
	
	private Long previousId ;
	
	private String documentNameFilter;
	
	private String nameHistoryFilter;
	
	private FormFile formFile;
	
	private Long documentId;
	
	private Boolean isSearch = Boolean.FALSE;
	
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
	
	 public ActionErrors validate(ActionMapping mapping,
	            HttpServletRequest request) {
	        
		 DocumentListViewHelper view = (DocumentListViewHelper) 
	            request.getSession().getAttribute(DocumentListViewHelper.SESSION_KEY);
	        if (view == null) {
	            return new ActionErrors();
	        }
	    
	        ActionErrors errors = super.validate(mapping, request);
	        
	        if (errors.size() > 0) {
	            view.reset(this);
	        }
	        
	        return errors;
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
	 * @param formFile the formFile to set
	 */
	public void setFormFile(FormFile formFile) {
		this.formFile = formFile;
	}

	/**
	 * @return the formFile
	 */
	public FormFile getFormFile() {
		return formFile;
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
	 * @param documentId the documentId to set
	 */
	public void setDocumentId(Long documentId) {
		this.documentId = documentId;
	}

	/**
	 * @return the documentId
	 */
	public Long getDocumentId() {
		return documentId;
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
	 * reset form
	 */
	public void reset() {
		this.previousId = null;
		this.documentNameFilter = null;
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
