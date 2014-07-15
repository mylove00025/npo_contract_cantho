package com.osp.npo.app.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

import com.osp.npo.app.viewhelper.ContractHistoryListViewHelper;
import com.osp.npo.app.viewhelper.ContractKindListViewHelper;

public class ContractHistoryListForm extends ValidatorForm{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -57070114464792757L;

	private String contractNumber;
	
	private String contractContent;
	
	private String direction;
	
	private int id;
	
	/**
	 * @return the contractNumber
	 */
	public String getContractNumber() {
		if(contractNumber != null)
			return contractNumber.trim();
		return contractNumber;
	}



	/**
	 * @param contractNumber the contractNumber to set
	 */
	public void setContractNumber(String contractNumber) {
		this.contractNumber = contractNumber;
	}



	/**
	 * @return the contractContent
	 */
	public String getContractContent() {
		if(contractContent != null)
			return contractContent.trim();
		return contractContent;
	}



	/**
	 * @param contractContent the contractContent to set
	 */
	public void setContractContent(String contractContent) {
		this.contractContent = contractContent;
	}



	/**
	 * @return the derection
	 */
	public String getDirection() {
		return direction;
	}



	/**
	 * @param derection the derection to set
	 */
	public void setDirection(String direction) {
		this.direction = direction;
	}

	

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}



	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}



	public ActionErrors validate(ActionMapping mapping,
	            HttpServletRequest request) {
	        
		ContractHistoryListViewHelper view = (ContractHistoryListViewHelper) 
	            request.getSession().getAttribute(ContractHistoryListViewHelper.SESSION_KEY);
	        if (view == null) {
	            return new ActionErrors();
	        }
	    
	        ActionErrors errors = super.validate(mapping, request);
	        
	        if (errors.size() > 0) {
	            view.reset(this);
	        }
	        
	        return errors;
	    }

}
