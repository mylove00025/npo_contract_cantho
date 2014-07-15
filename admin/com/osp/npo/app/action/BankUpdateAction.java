package com.osp.npo.app.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;

import com.osp.npo.app.form.BankForm;
import com.osp.npo.app.message.MessageUtil;
import com.osp.npo.app.viewhelper.BankViewHelper;
import com.osp.npo.common.global.Constants;
import com.osp.npo.core.OrderField;
import com.osp.npo.core.basicData.BankInfo;
import com.osp.npo.core.contract.ContractInfo;
import com.osp.npo.service.BasicDataService;
import com.osp.npo.service.ContractService;

/**
 * <P>Bank Update Action</P>
 *
 * @author HungPT
 * @version $Revision: 19134 $
 */
@SuppressWarnings("unchecked")
public class BankUpdateAction extends BaseMDAction {
    
    private static final String SUCCESS = "success";
    private static final String NO_LOGIN = "nologin";
    private static final String FAILURE_PATH = "failure";
    private static final String BANK_ID = "id";
    private static final String TOP_LIST = "01";
    private static final String MIDDLE_LIST = "02";
    private static final String BOTTOM_LIST = "03";
    private static final String ORDER_FIELD_BANK = "order_number";
    
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
        
        createTitle(Constants.SCREEN_ADM009);
        
        HttpSession session = request.getSession();
        if (session.getAttribute(BankViewHelper.SESSION_KEY) != null) {
            session.removeAttribute(BankViewHelper.SESSION_KEY);
        }
        
        MessageUtil messageUtil = new MessageUtil();
        BankViewHelper viewHelper =  new BankViewHelper();
        
        Long id = Long.parseLong(request.getParameter(BANK_ID));
        
        BasicDataService service = new BasicDataService(getConnection());
        
        service.setBankIdFilter(id);
        BankInfo bankInfo = service.getBank(false);
        if (bankInfo == null) {
            ActionErrors errors = new ActionErrors();
            errors.add(messageUtil.createActionMessages("", request, "err_not_exist", "item_bank_name"));
            this.addErrors(request, errors);
            return mapping.findForward(FAILURE_PATH);
        }
        
        viewHelper.setId(bankInfo.getId());
        viewHelper.setBankName(bankInfo.getName());        
        service.setBankIdFilter(null);
        service.setLowerOrderNumberFilter(null);
        service.addOrderFieldBank(new OrderField(ORDER_FIELD_BANK));
        ArrayList<BankInfo> bankListAll = new ArrayList<BankInfo>();
        bankListAll = service.queryAllBank(false).getList();        
        if(bankListAll.size()>0)
        {
        	Long currentOrderNumber = bankInfo.getOrderNumber();        	
	        if ( currentOrderNumber.equals(bankListAll.get(0).getOrderNumber())) {
	            viewHelper.setPosition(TOP_LIST);
	            
	        } else if (currentOrderNumber.equals(bankListAll.get(bankListAll.size()-1).getOrderNumber())) {
	            viewHelper.setPosition(BOTTOM_LIST);
	        } else {
	            viewHelper.setPosition(MIDDLE_LIST);
	            for(int i=0;i<bankListAll.size();i++)
	            {
	            	Long number = bankListAll.get(i).getOrderNumber();
	            	if(currentOrderNumber.equals(number))
	            	{
	            		viewHelper.setOrderBankId(bankListAll.get(i-1).getOrderNumber());
	            		break;
	            	}
	            }	
	        }
        }
        
        viewHelper.setBankList(bankListAll);
        
        ContractService contractService = new ContractService(getConnection());
        contractService.setBankIdFilter(id);
        if (contractService.countTotalContractByFilter() > 0) {
            viewHelper.setHasRelation(Boolean.TRUE);
        } else {
            viewHelper.setHasRelation(Boolean.FALSE);
        }
        
        session.setAttribute(BankViewHelper.SESSION_KEY, viewHelper);
        
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
    public ActionForward update(ActionMapping mapping, ActionForm form, 
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        BankViewHelper viewHelper = (BankViewHelper)request.getSession().getAttribute(BankViewHelper.SESSION_KEY);
        if (viewHelper == null) {
            return mapping.findForward(NO_LOGIN);
        }
        
        BankForm bankForm = (BankForm)form;
        
        MessageUtil messageUtil = new MessageUtil();
        
        viewHelper.reset(bankForm);
        
        BasicDataService service = new BasicDataService(getConnection());
        
        service.setBankIdFilter(viewHelper.getId());
        BankInfo bankInfo = service.getBank(false);
        if (bankInfo == null) {
            ActionErrors errors = new ActionErrors();
            errors.add(messageUtil.createActionMessages("", request, "err_not_exist", "item_bank_name"));
            this.addErrors(request, errors);
            return mapping.findForward(FAILURE_PATH);
        }
        
        bankInfo.setName(bankForm.getBankName());
        createEntryUserInfo(bankInfo);
           
        service.setBankIdFilter(null);
        if (TOP_LIST.equals(bankForm.getPosition())) {
            Long minOrder = service.getMinOrderNumber();
            List<BankInfo> list = service.queryAllBank(false).getList();
            for (BankInfo info : list) {
                info.setOrderNumber(info.getOrderNumber() + 1);
                service.modifyBank(info);
            }
            bankInfo.setOrderNumber(minOrder);                
        }
        
        if (MIDDLE_LIST.equals(bankForm.getPosition())) {
            service.setUpperOrderNumberFilter(bankForm.getOrderBankId());
            List<BankInfo> list = service.queryAllBank(false).getList();
            for (BankInfo info : list) {
                info.setOrderNumber(info.getOrderNumber() + 1);
                service.modifyBank(info);
            }
            bankInfo.setOrderNumber(bankForm.getOrderBankId() + 1);                
        }
        
        if (BOTTOM_LIST.equals(bankForm.getPosition())) {
            bankInfo.setOrderNumber(service.getMaxOrderNumber() + 1);
        }
        
        service.modifyBank(bankInfo);
        getConnection().commit();
        
        service.setUpperOrderNumberFilter(null);
        service.addOrderFieldBank(new OrderField(ORDER_FIELD_BANK));
        viewHelper.setBankList(service.queryAllBank(false).getList());
        
        ActionMessages messages = new ActionMessages();
        messages.add(messageUtil.createActionMessages("", request, "msg_update_success", "item_bank_name"));
        this.addMessages(request, messages);
        
        return mapping.findForward(SUCCESS);
    }
    
    /**
     * <P>Action remove</P>
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
        
        BankViewHelper viewHelper = (BankViewHelper)request.getSession().getAttribute(BankViewHelper.SESSION_KEY);
        if (viewHelper == null) {
            return mapping.findForward(NO_LOGIN);
        }
        
        MessageUtil messageUtil = new MessageUtil();
        
        BasicDataService basicDataService = new BasicDataService(getConnection());
        ContractService contracService = new ContractService(getConnection());
        
        basicDataService.setBankIdFilter(viewHelper.getId());
        BankInfo bankInfo = basicDataService.getBank(false);
        if (bankInfo == null) {
            ActionErrors errors = new ActionErrors();
            errors.add(messageUtil.createActionMessages("", request, "err_not_exist", "item_bank_name"));
            this.addErrors(request, errors);
            return mapping.findForward(FAILURE_PATH);
        }
        
        contracService.setBankIdFilter(viewHelper.getId());
        List<ContractInfo> contractList = contracService.queryAllContract(false).getList();
        for (ContractInfo info : contractList) {
            info.setBankId(null);
            contracService.modifyContract(info);
        }
        
        basicDataService.removeBank(viewHelper.getId());
        
        getConnection().commit();
        ActionMessages messages = new ActionMessages();
        messages.add(new MessageUtil().createActionMessages("", request, "msg_delete_success", "item_bank_name"));
        this.addMessages(request, messages);
        
        return mapping.findForward(SUCCESS);
    }
}
