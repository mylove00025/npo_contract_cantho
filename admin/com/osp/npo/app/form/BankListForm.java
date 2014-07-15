package com.osp.npo.app.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

import com.osp.npo.app.viewhelper.BankListViewHelper;


/**
 * Form for Bank List
 * 
 * @author PhuongNT
 * @version $Revision: 16882 $
 */
public class BankListForm extends ValidatorForm {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4741069493550773905L;
	
	private String bankName;
	
	private String direction;
	
	/**
	 * @return the bankName
	 */
	public String getBankName() {
		if(bankName !=null){
			return bankName.trim();
		}
		return bankName;
	}

	/**
	 * @param bankName the bankName to set
	 */
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	
    /*
     * (non-Javadoc)
     * 
     * @see org.apache.struts.action.ActionForm#validate(org.apache.struts.action.ActionMapping,
     *      javax.servlet.http.HttpServletRequest)
     */
    @Override
    public ActionErrors validate(ActionMapping mapping,
            HttpServletRequest request) {
        
        BankListViewHelper view = (BankListViewHelper) 
            request.getSession().getAttribute(BankListViewHelper.SESSION_KEY);
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

}
