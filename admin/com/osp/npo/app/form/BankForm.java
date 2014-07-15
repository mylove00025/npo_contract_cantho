package com.osp.npo.app.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

import com.osp.npo.app.viewhelper.BankViewHelper;

/**
 * <P>Bank Form</P>
 * 
 * @author HungPT 
 * @version $Revision$
 */
public class BankForm extends ValidatorForm {

    private static final long serialVersionUID = -7133763570955822203L;
    
    private String bankName;
    
    private String position;
    
    private Long orderBankId;
    
    /**
     * Get the bankName
     *
     * @return the bankName
     */
    public String getBankName() {
        if (bankName != null) {
            return bankName.trim();
        }
        return bankName;
    }

    /**
     * Set the bankName
     *
     * @param bankName the bankName to set
     */
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    /**
     * Get the position
     *
     * @return the position
     */
    public String getPosition() {
        return position;
    }

    /**
     * Set the position
     *
     * @param position the position to set
     */
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * Get the orderBankId
     *
     * @return the orderBankId
     */
    public Long getOrderBankId() {
        return orderBankId;
    }

    /**
     * Set the orderBankId
     *
     * @param orderBankId the orderBankId to set
     */
    public void setOrderBankId(Long orderBankId) {
        this.orderBankId = orderBankId;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.apache.struts.action.ActionForm#validate(org.apache.struts.action.ActionMapping,
     *      javax.servlet.http.HttpServletRequest)
     */
    @Override
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {  
        
        BankViewHelper bankViewHelper = (BankViewHelper)request.getSession().getAttribute(BankViewHelper.SESSION_KEY);
        if (bankViewHelper == null) {
            return new ActionErrors();
        }
        ActionErrors errors = super.validate(mapping, request);
        if (errors.size() > 0) {
            bankViewHelper.reset(this);
        }
        
        return errors;
    }
}
