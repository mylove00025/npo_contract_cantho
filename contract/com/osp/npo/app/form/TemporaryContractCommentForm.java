package com.osp.npo.app.form;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

//import com.lgevn.dms.common.util.EditString;
import com.osp.npo.app.message.MessageUtil;
import com.osp.npo.app.viewhelper.ContractListViewHelper;
import com.osp.npo.app.viewhelper.TemporaryContractViewHelper;

/**
 * <P>Temporary Contract Form</P>
 * 
 * @author SonHD 
 * @version $Revision: 23796 $
 */
public class TemporaryContractCommentForm extends ValidatorForm {

    /**
	 * 
	 */
	private static final long serialVersionUID = 729955552752445028L;

	private String comment;

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		ActionErrors errors = super.validate(mapping, request);
        MessageUtil messageUtil = new MessageUtil();
        
        TemporaryContractViewHelper temporaryContractViewHelper = (TemporaryContractViewHelper)request.getSession().getAttribute(TemporaryContractViewHelper.SESSION_KEY);
        if (temporaryContractViewHelper == null) {
            return errors;
        }
        if (getComment() == null || getComment().equals("") ) {
    		errors.add(messageUtil.createActionMessages("comment", request, "err_not_input_data", "item_contract_comment"));
    	}
        
        return errors;
	}
    
}
