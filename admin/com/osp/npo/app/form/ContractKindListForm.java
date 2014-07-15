package com.osp.npo.app.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

import com.osp.npo.app.viewhelper.ContractKindListViewHelper;

public class ContractKindListForm extends ValidatorForm{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -57070114464792757L;

	private String contractKindName;
	

	private String direction;
	
 	/**
	 * @return the contractKindName
	 */
	public String getContractKindName() {
		if(contractKindName != null)
			return contractKindName.trim();
		return contractKindName;
	}

	/**
	 * @param contractKindName the contractKindName to set
	 */
	public void setContractKindName(String contractKindName) {
		this.contractKindName = contractKindName;
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
	
	 public ActionErrors validate(ActionMapping mapping,
	            HttpServletRequest request) {
	        
		 ContractKindListViewHelper view = (ContractKindListViewHelper) 
	            request.getSession().getAttribute(ContractKindListViewHelper.SESSION_KEY);
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
