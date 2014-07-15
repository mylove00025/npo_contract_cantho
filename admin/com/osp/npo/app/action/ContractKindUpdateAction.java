package com.osp.npo.app.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;

import com.osp.npo.app.form.ContractKindForm;
import com.osp.npo.app.message.MessageUtil;
import com.osp.npo.app.viewhelper.ContractKindViewHelper;
import com.osp.npo.common.global.Constants;
import com.osp.npo.core.OrderField;
import com.osp.npo.core.contract.ContractKindInfo;
import com.osp.npo.core.contract.ContractKindList;
import com.osp.npo.service.ContractKindService;
import com.osp.npo.service.ContractService;

/**
 * <P>Contract Kind Update Action</P>
 *
 * @author HungPT
 * @version $Revision: 19134 $
 */
@SuppressWarnings("unchecked")
public class ContractKindUpdateAction extends BaseMDAction {

    private static final String SUCCESS = "success";
    private static final String FAILURE_PATH = "failure";
    private static final String NO_LOGIN = "nologin";
    private static final String CONTRACT_KIND_ID = "id";
    private static final String NPO_CONTRACT_TEMPLATE = "npo_contract_template";
    private static final String KIND_ID = "kind_id";    
    private static final String TOP_LIST = "01";
    private static final String MIDDLE_LIST = "02";
    private static final String BOTTOM_LIST = "03";
    private static final String ORDER_FIELD= "order_number";
    
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
    public ActionForward view(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {

        createTitle(Constants.SCREEN_ADM005);
        MessageUtil messageUtil = new MessageUtil();

        HttpSession session = request.getSession();
        if (session.getAttribute(ContractKindViewHelper.SESSION_KEY) != null) {
            session.removeAttribute(ContractKindViewHelper.SESSION_KEY);
        }

        ContractKindViewHelper viewHelper =  new ContractKindViewHelper();

        Long id = Long.parseLong(request.getParameter(CONTRACT_KIND_ID));

        ContractKindService service = new ContractKindService(getConnection());
        
        service.addOrderFieldName(new OrderField(ORDER_FIELD));
        
        List<ContractKindInfo> list = service.queryAllContractKind(false).getList();
        
        viewHelper.setContractKindList(list);        
        
        service.setIdFilter(id);
        ContractKindList contractKindList = service.queryAllContractKind(false);
        
        if (contractKindList == null || contractKindList.size() == 0) {
            ActionErrors errors = new ActionErrors();
            errors.add(messageUtil.createActionMessages("", request, "err_not_exist", "item_contract_kind"));
            this.addErrors(request, errors);
            session.setAttribute(ContractKindViewHelper.SESSION_KEY, viewHelper);
            return mapping.findForward(FAILURE_PATH);
        }
        ContractKindInfo contractKindInfo = contractKindList.get(0);
        
        if(list.size()>0){
        	if(list.get(0).getId().equals(contractKindInfo.getId())){
        		viewHelper.setPosition(TOP_LIST);
        		viewHelper.setOrderContractKindId(contractKindInfo.getId());
        	} else if(list.get(list.size()-1).getId().equals(contractKindInfo.getId())){
        		viewHelper.setPosition(BOTTOM_LIST);
        		viewHelper.setOrderContractKindId(contractKindInfo.getId());
        	} else {
    			Long beforeKindId = 0L;
    			for(ContractKindInfo info : list){        		
            		if(info.getId().equals(contractKindInfo.getId())) {
            			break;
            		}
            		beforeKindId = info.getId();
            	}
    			viewHelper.setPosition(MIDDLE_LIST);
            	viewHelper.setOrderContractKindId(beforeKindId);
    		}
        	
        }
        
        viewHelper.setId(contractKindInfo.getId());
        viewHelper.setName(contractKindInfo.getName());
        viewHelper.setParentKindId(contractKindInfo.getParentKindId());

        session.setAttribute(ContractKindViewHelper.SESSION_KEY, viewHelper);

        return mapping.findForward(SUCCESS);
    }

    /**
     * <P>Action for update</P>
     *
     * @author HungPT
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward update(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {

        ContractKindViewHelper viewHelper = (ContractKindViewHelper)request.getSession().getAttribute(ContractKindViewHelper.SESSION_KEY);
        if (viewHelper == null) {
            return mapping.findForward(NO_LOGIN);
        }

        ContractKindForm contractKindForm = (ContractKindForm)form;
        MessageUtil messageUtil = new MessageUtil();
        viewHelper.reset(contractKindForm);

        ContractKindService service = new ContractKindService(getConnection());
        service.addOrderFieldName(new OrderField(ORDER_FIELD));
        
        //service.setIdFilter(viewHelper.getId());
        List<ContractKindInfo> list = service.queryAllContractKind(false).getList();
        
        boolean isExist = false;
        int currentIndex = 0;
        for (int i = 0; i < list.size(); i++) {
        	ContractKindInfo info = list.get(i);
        	if (info.getId().equals(viewHelper.getId())) {
        		isExist = true;
        		currentIndex = i;
        	}
        }
        
        ActionErrors errors = new ActionErrors();
        if (!isExist) {
            errors.add(messageUtil.createActionMessages("", request, "err_not_exist", "item_contract_kind"));
            this.addErrors(request, errors);
            return mapping.findForward(FAILURE_PATH);
        }

        ContractKindInfo contractKindInfo = list.get(currentIndex);

        contractKindInfo.setName(contractKindForm.getName());
        contractKindInfo.setParentKindId(null);
        
        //Reorder
        list.remove(currentIndex);
        if (TOP_LIST.equals(contractKindForm.getPosition())) {
        	list.add(0, contractKindInfo);
        } else if (MIDDLE_LIST.equals(contractKindForm.getPosition())) {
        	for (int i = 0; i < list.size(); i++) {
            	ContractKindInfo info = list.get(i);
            	if (info.getId().equals(contractKindForm.getOrderContractKindId())) {
            		if (i == list.size() - 1) {
            			list.add(contractKindInfo);
            		} else {
            			list.add(i + 1, contractKindInfo);
            		}
            	}
            }
        } else {
        	list.add(contractKindInfo);
        }
        
        //Update contract kind
        for (int i = 0; i < list.size(); i++) {
        	ContractKindInfo info = list.get(i);
        	info.setOrderNumber(new Long(i + 1));
        	
        	if (contractKindInfo.equals(info)) {
        		createUpdateUserInfo(info);
        	}
        	
        	//update contractKindInfo to database
            service.modifyContract(info);
        }
        
        /*
        if (contractKindForm.getParentKindId() != 0L) {
        	service.setIdFilter(contractKindForm.getParentKindId());
            contractKindList = service.queryAllContractKind(false);
            if (contractKindList == null || contractKindList.size() == 0) {
                errors.add(messageUtil.createActionMessages("", request, "err_not_exist", "item_contract_kind_root"));
                this.addErrors(request, errors);
                return mapping.findForward(FAILURE_PATH);
            }     
            
            for (int i=0; i< contractKindList.size();i++){
            	if(contractKindList.get(i).getId().equals(contractKindInfo.getId()) 
            			|| (contractKindList.get(i).getParentKindId() != null && contractKindList.get(i).getParentKindId().equals(contractKindInfo.getId()))){
            		errors.add(messageUtil.createActionMessages("", request, "ADM006_contract_kind_update_root_error", "item_contract_kind_root", "item_contract_kind"));
                    this.addErrors(request, errors);
                    return mapping.findForward(FAILURE_PATH);
            	}
            }
            
            contractKindInfo.setParentKindId(contractKindForm.getParentKindId()); 
        }
        else {
        	contractKindInfo.setParentKindId(null); 
		}        
        */
        
        getConnection().commit();

        errors.add(messageUtil.createActionMessages("", request, "msg_update_success", "item_contract_kind"));
        this.addMessages(request, errors);

        return mapping.findForward(SUCCESS);
    }

    /**
     * <P>Action for remove</P>
     *
     * @author HungPT
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward remove(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {

        ContractKindViewHelper viewHelper = (ContractKindViewHelper)request.getSession().getAttribute(ContractKindViewHelper.SESSION_KEY);
        if (viewHelper == null) {
            return mapping.findForward(NO_LOGIN);
        }

        MessageUtil messageUtil = new MessageUtil();

        ContractKindService contractKindService = new ContractKindService(getConnection());
        ContractService contractService = new ContractService(getConnection());

        //Check existance of data
        if (contractService.isExistContractTemplateInDB(NPO_CONTRACT_TEMPLATE,
                                                            new Object[][] {{KIND_ID, viewHelper.getId()}})) {
            ActionErrors errors = new ActionErrors();
            errors.add(messageUtil.createActionMessages("", "ADM006_contract_kind_template_data_reference"));
            this.addErrors(request, errors);
            return mapping.findForward(FAILURE_PATH);
        }

//        if (viewHelper.getHasChildren()) {
//        	contractKindService.setIdFilter(null);
//            contractKindService.setParentKindIdFilter(viewHelper.getId());
//            List<ContractKindInfo> list = contractKindService.queryAllContractKind(false).getList();
//            for (ContractKindInfo info : list) {
//                if (contractService.isExistContractTemplateInDB(NPO_CONTRACT_TEMPLATE,
//                                                                    new Object[][] {{KIND_ID, info.getId()}})) {
//                    ActionErrors errors = new ActionErrors();
//                    errors.add(messageUtil.createActionMessages("", "ADM006_contract_kind_template_data_reference"));
//                    this.addErrors(request, errors);
//                    return mapping.findForward(FAILURE_PATH);
//                }
//                contractKindService.removeContractKind(info.getId());
//            }
//        }

        contractKindService.removeContractKind(viewHelper.getId());

        getConnection().commit();
        ActionMessages messages = new ActionMessages();
        messages.add(new MessageUtil().createActionMessages("", request, "msg_delete_success", "item_contract_kind"));
        this.addMessages(request, messages);

        return mapping.findForward(SUCCESS);
    }
}
