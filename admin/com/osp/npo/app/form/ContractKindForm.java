package com.osp.npo.app.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

import com.osp.npo.app.viewhelper.ContractKindViewHelper;

/**
 * <P>Contract kind form</P>
 * 
 * @author HungPT 
 * @version $Revision: 19075 $
 */
public class ContractKindForm extends ValidatorForm {
   
    private static final long serialVersionUID = -9189058669754850327L;

    private String name;
    
    private Long parentKindId;
    
    private String position;
    
    private Long orderContractKindId;
    
    /**
     * Get the name
     *
     * @return the name
     */
    public String getName() {
    	if (name != null) {
            return name.trim();
        }
        return name;
    }

    /**
     * Set the name
     *
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the parentKindId
     *
     * @return the parentKindId
     */
    public Long getParentKindId() {
        return parentKindId;
    }

    /**
     * Set the parentKindId
     *
     * @param parentKindId the parentKindId to set
     */
    public void setParentKindId(Long parentKindId) {
        this.parentKindId = parentKindId;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.apache.struts.action.ActionForm#validate(org.apache.struts.action.ActionMapping,
     *      javax.servlet.http.HttpServletRequest)
     */
    @Override
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {    
        
        ContractKindViewHelper contractKindViewHelper = (ContractKindViewHelper)request.getSession().getAttribute(ContractKindViewHelper.SESSION_KEY);
        if (contractKindViewHelper == null) {
            return new ActionErrors();
        }
        ActionErrors errors = super.validate(mapping, request);
        if (errors.size() > 0) {
            contractKindViewHelper.reset(this);
        }
        
        return errors;
    }

	/**
	 * @return the position
	 */
	public String getPosition() {
		return position;
	}

	/**
	 * @param position the position to set
	 */
	public void setPosition(String position) {
		this.position = position;
	}

	/**
	 * @return the orderContractKindId
	 */
	public Long getOrderContractKindId() {
		return orderContractKindId;
	}

	/**
	 * @param orderContractKindId the orderContractKindId to set
	 */
	public void setOrderContractKindId(Long orderContractKindId) {
		this.orderContractKindId = orderContractKindId;
	}
    
}
