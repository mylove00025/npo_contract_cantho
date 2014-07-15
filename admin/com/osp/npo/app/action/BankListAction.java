/**
 * 
 */
package com.osp.npo.app.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.osp.npo.app.context.BankListContext;
import com.osp.npo.app.form.BankListForm;
import com.osp.npo.app.message.MessageUtil;
import com.osp.npo.app.viewhelper.BankListViewHelper;
import com.osp.npo.common.global.Constants;
import com.osp.npo.common.global.Constants.FilterKind;
import com.osp.npo.core.OrderField;
import com.osp.npo.core.basicData.BankInfo;
import com.osp.npo.core.basicData.BankList;
import com.osp.npo.service.BasicDataService;


/**
 * @author PhuongNT
 * @version $Revision: 25057 $
 */
public class BankListAction extends BaseMDAction {

	private static final String SUCCESS = "success";
    private static final Integer FIRST_PAGE = 1;
    private static final String ORDER_FIELD = "order_number";
    private static final String ORDER_NAME = "name";
    
    public ActionForward view(ActionMapping mapping, ActionForm form, 
            HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
    	createTitle(Constants.SCREEN_ADM007);
    	
        BankListViewHelper bankListViewHelper = new BankListViewHelper();
	    BankListContext bankListContext = new BankListContext();
	    bankListContext.reset();   	   
	   
        
        setBankList(bankListViewHelper, bankListContext, null);
	    
	    request.getSession().setAttribute(BankListContext.SESSION_KEY, bankListContext);
	    request.getSession().setAttribute(BankListViewHelper.SESSION_KEY, bankListViewHelper);
	    
        return mapping.findForward(SUCCESS);
    }
    
    public ActionForward orderByName(ActionMapping mapping, ActionForm form, 
            HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
    	createTitle(Constants.SCREEN_ADM007);
    	
    	BasicDataService bankService = new BasicDataService(getConnection());
    	bankService.addOrderFieldBank(new OrderField(ORDER_NAME));
    	BankList bankList = bankService.queryAllBank(false);
    	
    	for(int i = 0;i < bankList.size();i++){
    		BankInfo bankInfo = bankList.get(i);
    		bankInfo.setOrderNumber((long)(i+1));
    		bankService.modifyBank(bankInfo);
    	}
    	getConnection().commit();
        BankListViewHelper bankListViewHelper = new BankListViewHelper();
	    BankListContext bankListContext = new BankListContext();
	    bankListContext.reset();   	   
	   
        
        setBankList(bankListViewHelper, bankListContext, null);
	    
	    request.getSession().setAttribute(BankListContext.SESSION_KEY, bankListContext);
	    request.getSession().setAttribute(BankListViewHelper.SESSION_KEY, bankListViewHelper);
	    
        return mapping.findForward(SUCCESS);
    }
    
    /**
     * Search action
     * 
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward search(ActionMapping mapping, ActionForm form, 
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        BankListContext bankListContext = getListContext(request);
        
        BankListForm bankListForm = (BankListForm)form;        
        
        bankListContext.reset();
        setContext(bankListContext, bankListForm);
        
        BankListViewHelper bankListViewHelper = (BankListViewHelper) request.getSession().getAttribute(BankListViewHelper.SESSION_KEY);
        bankListViewHelper.reset(bankListForm);
        bankListViewHelper.setPage(FIRST_PAGE);
        setBankList(bankListViewHelper, bankListContext, null);
        
        if (bankListViewHelper.getTotalCount() == 0) {            
            MessageUtil mu = new MessageUtil();
            saveMessages(request, mu.createActionMessages("", request, "msg_data_not_exist", "item_bank"));
        }
        	
        return mapping.findForward(SUCCESS);
    }
    
    /**
     * Paging action
     *
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward page(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {

        BankListContext context = getListContext(request);
        BankListForm f = (BankListForm)form;

        BankListViewHelper bankListViewHelper = (BankListViewHelper) request.getSession().getAttribute(BankListViewHelper.SESSION_KEY);
        bankListViewHelper.reset(f);

        setBankList(bankListViewHelper, context, f.getDirection());

        return mapping.findForward(SUCCESS);
    }

    /**
     * Set bank list to viewhelper
     * 
     * @param bankListViewHelper
     * @param bankListContext
     * @param object
     */	
	private void setBankList(BankListViewHelper bankListViewHelper,
			BankListContext bankListContext, String direction) 
		throws SQLException, IOException{
		BasicDataService bankService = new BasicDataService(getConnection());
		
		setSearchFilter(bankListContext, bankService);
		
		bankListViewHelper.setList(null);
		
		int totalCount = bankService.countTotalBank();
		bankListViewHelper.setTotalCount(totalCount);
		
		if(totalCount>0){			
	    		int totalPage = pageCalculation(totalCount, getLineMax());
	    		bankListViewHelper.setTotalPage(totalPage);
	    		bankListViewHelper.setPage(pageTransition(direction,bankListViewHelper.getPage(),totalPage));
	    		int firstIndex = (bankListViewHelper.getPage()-1)*getLineMax();
	    		bankListViewHelper.setFirstIndex(firstIndex);
	    		bankService.addOrderFieldBank(new OrderField(ORDER_FIELD));
	    		BankList bankList = bankService.queryBank(false, bankListViewHelper.getPage(),getLineMax());
	    		
	    		bankListViewHelper.setList(bankList.getList());
		}
		
	}


	private void setSearchFilter(BankListContext bankListContext,
			BasicDataService bankService) {
		if(bankListContext.getBankName() != null && bankListContext.getBankName().length()>0){
			bankService.setBankNameFilter(bankListContext.getBankName(), FilterKind.MIDDLE);
		}
		
	}

	/**
	 * Set data from Form to Context
	 * 
	 * @param bankListContext
	 * @param bankListForm
	 */
	private void setContext(BankListContext bankListContext,
			BankListForm bankListForm) {
		bankListContext.setBankName(bankListForm.getBankName());
	}

	/**
	 * 
	 * 
	 * @param request
	 * @return
	 */
	private BankListContext getListContext(HttpServletRequest request) {
		HttpSession session = request.getSession();
		BankListContext context = (BankListContext) session.getAttribute(BankListContext.SESSION_KEY);
		
		 if (context == null) {
	            context = new BankListContext();
	            session.setAttribute(BankListContext.SESSION_KEY,context);
		 }
		 
		return context;
	}
	
	/**
	 * Back event
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward back(ActionMapping mapping, ActionForm form,
	            HttpServletRequest request, HttpServletResponse response) throws Exception {
		BankListContext bankListContext = getListContext(request);	
		
		BankListViewHelper bankListViewHelper = (BankListViewHelper)request.getSession().getAttribute(BankListViewHelper.SESSION_KEY);
		
		setBankList(bankListViewHelper, bankListContext, null);
		
		return mapping.findForward(SUCCESS);
	 }
}
