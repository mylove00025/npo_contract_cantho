package com.osp.npo.app.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
import com.osp.npo.service.BasicDataService;

/**
 * <P>Bank Regist Action</P>
 *
 * @author HungPT
 * @version $Revision: 19134 $
 */
@SuppressWarnings("unchecked")
public class BankRegistAction extends BaseMDAction {
    
    private static final String SUCCESS = "success";
    private static final String NO_LOGIN = "nologin";
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
        
        createTitle(Constants.SCREEN_ADM008);
        
        HttpSession session = request.getSession();
        if (session.getAttribute(BankViewHelper.SESSION_KEY) != null) {
            session.removeAttribute(BankViewHelper.SESSION_KEY);
        }
        
        BankViewHelper viewHelper =  new BankViewHelper();
        
        BasicDataService service = new BasicDataService(getConnection());
        service.addOrderFieldBank(new OrderField(ORDER_FIELD_BANK));
        viewHelper.setPosition("03");
        viewHelper.setBankList(service.queryAllBank(false).getList());
       
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
    public ActionForward regist(ActionMapping mapping, ActionForm form, 
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        BankViewHelper viewHelper = (BankViewHelper)request.getSession().getAttribute(BankViewHelper.SESSION_KEY);
        if (viewHelper == null) {
            return mapping.findForward(NO_LOGIN);
        }
        
        BankForm bankForm = (BankForm)form;
        
        MessageUtil messageUtil = new MessageUtil();
        
        viewHelper.reset(bankForm);
        
        BasicDataService service = new BasicDataService(getConnection());
        
        BankInfo bankInfo = new BankInfo();
        bankInfo.setName(bankForm.getBankName());
        createEntryUserInfo(bankInfo);
        
        if (viewHelper.getBankList().size() == 0) {
            bankInfo.setOrderNumber(1L);            
        } else {
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
        }
        
        service.entryBank(bankInfo);
        getConnection().commit();        
        
        service.setUpperOrderNumberFilter(null);
        service.addOrderFieldBank(new OrderField(ORDER_FIELD_BANK));
        viewHelper.setBankList(service.queryAllBank(false).getList());
        
        viewHelper.clear();
        
        ActionMessages messages = new ActionMessages();
        messages.add(messageUtil.createActionMessages("", request, "msg_regist_success", "item_bank_name"));
        this.addMessages(request, messages);
               
        
        return mapping.findForward(SUCCESS);
    }
}
