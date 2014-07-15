/**
 * 
 */
package com.osp.npo.app.action;

import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.osp.npo.app.form.TemporaryContractCommentForm;
import com.osp.npo.app.message.MessageUtil;
import com.osp.npo.app.viewhelper.TemporaryContractCommentEditViewHelper;
import com.osp.npo.app.viewhelper.TemporaryContractViewHelper;
import com.osp.npo.common.global.Constants;
import com.osp.npo.core.temporaryContract.ContractCommentInfo;
import com.osp.npo.service.TemporaryContractService;

/**
 * <P>Temporary Contract Comment Edit Action</P>
 * @author TruongND
 * @version $Revision: 20670 $
 */
public class TemporaryContractCommentAction extends BaseMDAction {
    private static final String SUCCESS = "success";
    private static final String FAILURE_PATH = "failure";
    private static final String NO_LOGIN = "nologin";
    
    private static final String CONTRACT_COMMENT_ID = "ccid";
    

    /**
     * Hien thi khi vao trang
     * 
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws SQLException
     * @throws Exception
     */
    public ActionForward view(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, SQLException, Exception {
        
    	createTitle(Constants.SCREEN_CNTR032);
        
    	HttpSession session = request.getSession();
        TemporaryContractCommentEditViewHelper viewHelper = null;        
        TemporaryContractService temporaryContractService = new TemporaryContractService(getConnection());
        
        
        try {
        	Long ccid = Long.parseLong(request.getParameter(CONTRACT_COMMENT_ID));
        	viewHelper = new TemporaryContractCommentEditViewHelper();
        	
        	viewHelper.setCcid(ccid);
        	
        	ContractCommentInfo ccInfo = temporaryContractService.queryContractCommentByCcid(ccid, false);
        	viewHelper.setComment(ccInfo.getComment());
        	
        	session.setAttribute(TemporaryContractCommentEditViewHelper.SESSION_KEY, viewHelper);
        } catch (NumberFormatException numEx) {
        	return mapping.findForward(FAILURE_PATH);
        }
        
        return mapping.findForward(SUCCESS);
    }
    
    
    
    /**
     * Chinh sua comment
     * 
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward editComment(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {

    	HttpSession session = request.getSession();
    	
    	TemporaryContractCommentEditViewHelper viewHelper = (TemporaryContractCommentEditViewHelper) session
    		.getAttribute(TemporaryContractCommentEditViewHelper.SESSION_KEY);
    	
    	if (viewHelper != null) {
    		TemporaryContractService temporaryContractService = new TemporaryContractService(getConnection());

    		ContractCommentInfo ccInfo = temporaryContractService.queryContractCommentByCcid(viewHelper.getCcid(), false);
    		
    		if (ccInfo == null) {
    			//Dua ra thong bao khong ton tai, quay ve trang detail
    			ActionErrors errors = new ActionErrors();
    			
    			MessageUtil messageUtil = new MessageUtil();
                errors.add(messageUtil.createActionMessages("", request, "err_not_exist", "item_contract_comment"));
                this.addErrors(request, errors);
                
                return mapping.findForward(FAILURE_PATH);
    		} else {
    			TemporaryContractCommentForm cceForm = (TemporaryContractCommentForm) form;
    			ccInfo.setComment(cceForm.getComment());
    			
    			createUpdateUserInfo(ccInfo);
    			
    			temporaryContractService.modifyContractComment(ccInfo);
    			
    			viewHelper.setComment(ccInfo.getComment());
        		
        		getConnection().commit();
    		}
    	} else {
    		return mapping.findForward(NO_LOGIN);
    	}
    	
    	return mapping.findForward(SUCCESS);
      
    }
    
    /**
     * Xoa comment
     * 
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws SQLException
     * @throws Exception
     */
    public ActionForward delete(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, SQLException, Exception {
        
        TemporaryContractService temporaryContractService = new TemporaryContractService(getConnection());
        
        try {
        	Long ccid = Long.parseLong(request.getParameter(CONTRACT_COMMENT_ID));
        	temporaryContractService.removeContractComment(ccid);
        	
        	getConnection().commit();
        } catch (NumberFormatException numEx) {
        	return mapping.findForward(FAILURE_PATH);
        }
        
        return mapping.findForward(SUCCESS);
    }
    
    /**
     * Dang ky comment
     * 
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward registComment(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {

    	HttpSession session = request.getSession();
    	
    	TemporaryContractViewHelper viewHelper = (TemporaryContractViewHelper) session
    		.getAttribute(TemporaryContractViewHelper.SESSION_KEY);
    	
    	if (viewHelper != null) {
    		TemporaryContractService temporaryContractService = new TemporaryContractService(getConnection());

    		ContractCommentInfo ccInfo = new ContractCommentInfo();
    		
			TemporaryContractCommentForm cceForm = (TemporaryContractCommentForm) form;
			ccInfo.setComment(cceForm.getComment());
			ccInfo.setTcid(viewHelper.getContractId());
			
			createEntryUserInfo(ccInfo);
			
			temporaryContractService.entryContractComment(ccInfo);
			
    		getConnection().commit();
    	}
    	
    	return mapping.findForward(SUCCESS);
      
    }

}
