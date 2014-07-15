package com.osp.npo.app.form;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;
import org.apache.struts.validator.ValidatorForm;

import com.osp.npo.app.context.CommonContext;
import com.osp.npo.app.message.MessageUtil;
import com.osp.npo.app.viewhelper.ContractHistoryDetailViewHelper;
import com.osp.npo.app.viewhelper.ContractViewHelper;
import com.osp.npo.common.util.EditString;
import com.osp.npo.common.util.RelateDateTime;

/**
 * <P>Contract Form</P>
 *
 * @author HungPT
 * @version $Revision: 23644 $
 */
public class ContractHistoryDetailForm extends ValidatorForm {

    private static final long serialVersionUID = 4674190302636844933L;
    private Boolean isHidePanelInfo = Boolean.FALSE;
    private Long isOpen;
    
    /**
	 * @return the isHidePanelInfo
	 */
	public Boolean getIsHidePanelInfo() {
		return isHidePanelInfo;
	}


	/**
	 * @param isHidePanelInfo the isHidePanelInfo to set
	 */
	public void setIsHidePanelInfo(Boolean isHidePanelInfo) {
		this.isHidePanelInfo = isHidePanelInfo;
	}
	

	/**
	 * @return the isOpen
	 */
	public Long getIsOpen() {
		return isOpen;
	}


	/**
	 * @param isOpen the isOpen to set
	 */
	public void setIsOpen(Long isOpen) {
		this.isOpen = isOpen;
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

    	ContractHistoryDetailViewHelper contractViewHelper = (ContractHistoryDetailViewHelper)request.getSession().getAttribute(ContractHistoryDetailViewHelper.SESSION_KEY);
        if (contractViewHelper == null) {
            return new ActionErrors();
        }
        
        CommonContext commonContext = (CommonContext)request.getSession().getAttribute(CommonContext.SESSION_KEY);
        if (commonContext == null) {
            return new ActionErrors();
        }

        ActionErrors errors = super.validate(mapping, request);
        MessageUtil messageUtil = new MessageUtil();

        if (errors.size() > 0) {
        }

        return errors;
    }


}
