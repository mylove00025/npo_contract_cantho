package com.osp.npo.app.action;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.osp.npo.app.form.ContractKindForm;
import com.osp.npo.app.message.MessageUtil;
import com.osp.npo.app.viewhelper.ContractKindViewHelper;
import com.osp.npo.common.global.Constants;
import com.osp.npo.core.OrderField;
import com.osp.npo.core.contract.ContractKindInfo;
import com.osp.npo.core.contract.ContractNumberInfo;
import com.osp.npo.service.ContractKindService;
import com.osp.npo.service.ContractNumberService;

/**
 * <P>Contract Kind Regist Action</P>
 *
 * @author HungPT
 * @version $Revision: 25477 $
 */
public class ContractKindRegistAction extends BaseMDAction {

    private static final String SUCCESS = "success";
    private static final String NO_LOGIN = "nologin"; 
    private static final String TOP_LIST = "01";
    private static final String MIDDLE_LIST = "02";
    private static final String BOTTOM_LIST = "03";
    private static final String ORDER_FIELD= "order_number";
    private static final Long FIRST = (long) 1;
    
    /**
     * <P>Action for first view</P>
     * 
     * @author HungPT
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */    
    @SuppressWarnings("unchecked")
	public ActionForward view(ActionMapping mapping, ActionForm form, 
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        createTitle(Constants.SCREEN_ADM005);
        
        HttpSession session = request.getSession();
        if (session.getAttribute(ContractKindViewHelper.SESSION_KEY) != null) {
            session.removeAttribute(ContractKindViewHelper.SESSION_KEY);
        }
        
        ContractKindViewHelper viewHelper =  new ContractKindViewHelper();
        
        ContractKindService service = new ContractKindService(getConnection());
        service.addOrderFieldName(new OrderField(ORDER_FIELD));
        viewHelper.setPosition(BOTTOM_LIST);
        viewHelper.setContractKindList(service.queryAllContractKind(false).getList());
        
        session.setAttribute(ContractKindViewHelper.SESSION_KEY, viewHelper);
        
        return mapping.findForward(SUCCESS);
    }
    
    /**
     * <P>Action for regist</P>
     * 
     * @author HungPT
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */    
    @SuppressWarnings("unchecked")
    public ActionForward regist(ActionMapping mapping, ActionForm form, 
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        ContractKindViewHelper viewHelper = (ContractKindViewHelper)request.getSession().getAttribute(ContractKindViewHelper.SESSION_KEY);
        if (viewHelper == null) {
            return mapping.findForward(NO_LOGIN);
        }
        
        ContractKindForm contractKindForm = (ContractKindForm)form;
        
        MessageUtil messageUtil = new MessageUtil();
        
        viewHelper.reset(contractKindForm);
        
        ContractKindService service = new ContractKindService(getConnection());
        
        ContractKindInfo contractKindInfo = new ContractKindInfo();
        
        contractKindInfo.setName(contractKindForm.getName());
        contractKindInfo.setParentKindId(null);
        createEntryUserInfo(contractKindInfo);
        
        ActionErrors errors = new ActionErrors();        
//        
//        if (contractKindForm.getParentKindId() != 0L) {
//        	ContractKindService service = new ContractKindService(getConnection());
//        	
//        	service.setIdFilter(contractKindForm.getParentKindId());
//        	 ContractKindList contractKindList = service.queryAllContractKind(false);
//            if (contractKindList == null || contractKindList.size() == 0) {
//                errors.add(messageUtil.createActionMessages("", request, "err_not_exist", "item_contract_kind_root"));
//                this.addErrors(request, errors);
//                return mapping.findForward(FAILURE_PATH);
//            }
//            contractKindInfo.setParentKindId(contractKindForm.getParentKindId());
//        } 
        
        if(viewHelper.getContractKindList().size()==0){
        	contractKindInfo.setOrderNumber(1L);
        }
        else{
        	service.addOrderFieldName(new OrderField(ORDER_FIELD));
    		List<ContractKindInfo> list = service.queryAllContractKind(false).getList();
    		Long minOrder = 0L;
        	if(TOP_LIST.equals(contractKindForm.getPosition())){
        		minOrder  = 0L;        		
        		for(ContractKindInfo info : list){
        			info.setOrderNumber(info.getOrderNumber()+1);
        			service.modifyContract(info);
        		}
        	}
        	
        	if(MIDDLE_LIST.equals(contractKindForm.getPosition())){
        		minOrder = contractKindForm.getOrderContractKindId();
        		for(ContractKindInfo info : list){
        			if(info.getOrderNumber() > minOrder){        				
	        			info.setOrderNumber(info.getOrderNumber()+1);
	        			service.modifyContract(info);
        			}
        		}        		
        	}
        	
        	if(BOTTOM_LIST.equals(contractKindForm.getPosition())){        		
        		for(ContractKindInfo info : list){
        			if(info.getOrderNumber() > minOrder){
        				minOrder = info.getOrderNumber();
        			}
        		}        		
        	}
        	
        	contractKindInfo.setOrderNumber(minOrder + 1);
        }
        	
        
        //entry contractKindInfo to database
        service.entryContract(contractKindInfo);
        
        //entry contractNumberInfo to database
        ContractNumberService contractNumberService = new ContractNumberService(getConnection());
        ContractNumberInfo contractNumberInfo = new ContractNumberInfo();
        contractNumberInfo.setContractNumber(FIRST);
        contractNumberInfo.setKindId(contractKindInfo.getId());
        contractNumberService.entryContractNumber(contractNumberInfo);
        
        getConnection().commit();
        
        viewHelper.clear();
       
        errors.add(messageUtil.createActionMessages("", request, "msg_regist_success", "item_contract_kind"));
        this.addMessages(request, errors);
        
        //load update data
        service.addOrderFieldName(new OrderField(ORDER_FIELD));
        viewHelper.setPosition(BOTTOM_LIST);
        viewHelper.setContractKindList(service.queryAllContractKind(false).getList());
        
        return mapping.findForward(SUCCESS);
    }
}
