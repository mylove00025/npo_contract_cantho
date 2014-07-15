package com.osp.npo.app.action;


import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.osp.npo.app.context.ContractKindListContext;
import com.osp.npo.app.form.ContractKindListForm;
import com.osp.npo.app.message.MessageUtil;
import com.osp.npo.app.viewhelper.ContractKindListViewHelper;
import com.osp.npo.common.global.Constants;
import com.osp.npo.common.global.Constants.FilterKind;
import com.osp.npo.core.OrderField;
import com.osp.npo.core.contract.ContractKindList;
import com.osp.npo.service.ContractKindService;

/**
 * List of contract kind page
 *
 * @author GiangVT
 * @version $Revision: 25298 $
 */
public class ContractKindListAction extends BaseMDAction {
    public static final String SUCCESS_PATH = "success";
    private static final Integer FIRST_PAGE = 1;
    private static final String ORDER_FIELD = "order_number";
    /**
     *
     * view action
     *
     * @author GiangVT
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws SQLException
     * @throws IOException
     */
    public ActionForward view(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws SQLException,
            IOException {
        createTitle(Constants.SCREEN_ADM004);
        
        ContractKindListViewHelper view = new ContractKindListViewHelper();
        ContractKindListContext context = new ContractKindListContext();
        context.reset();
        
        setContractKindList(view, context,null);
        
        
        request.getSession().setAttribute(ContractKindListContext.SESSION_KEY,context);
        request.getSession().setAttribute(ContractKindListViewHelper.SESSION_KEY,view);
       
      
        return mapping.findForward(SUCCESS_PATH);
    }
    
    private void setContractKindList(ContractKindListViewHelper contractKindViewHelper,
			ContractKindListContext contractKindContext, String direction) 
		throws SQLException, IOException{
    	
    	ContractKindService service = new ContractKindService(getConnection());
    	setSearchFilter(contractKindContext, service);
    	
    	contractKindViewHelper.setList(null);
    	
    	int totalCount = service.countTotalContractKind();
    	contractKindViewHelper.setTotalCount(totalCount);
    	
    	if(totalCount>0){
    		int totalPage = pageCalculation(totalCount, getLineMax());
    		contractKindViewHelper.setTotalPage(totalPage);
    		contractKindViewHelper.setPage(pageTransition(direction,contractKindViewHelper.getPage(), totalPage));
    		int firstIndex = (contractKindViewHelper.getPage()-1)*getLineMax();
    		contractKindViewHelper.setFirstIndex(firstIndex);
    		service.addOrderFieldName(new OrderField(ORDER_FIELD));
    		ContractKindList contractKindList =  service.queryContractKind(false,contractKindViewHelper.getPage(), getLineMax());
    		contractKindViewHelper.setList(contractKindList.getList());
    	}
    }
    
    public ActionForward page(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ContractKindListContext context = getContractListContext(request);
    	ContractKindListForm f = (ContractKindListForm)form;
    	
    	ContractKindListViewHelper viewHelper = (ContractKindListViewHelper) request.getSession().getAttribute(ContractKindListViewHelper.SESSION_KEY); 
    	setContractKindList(viewHelper, context, f.getDirection());
    	
    	return mapping.findForward(SUCCESS_PATH);
    }
    
    public ContractKindListContext getContractListContext(HttpServletRequest request){
    	HttpSession session = request.getSession();
    	ContractKindListContext context = (ContractKindListContext) session.getAttribute(ContractKindListContext.SESSION_KEY);
		
		 if (context == null) {
	            context = new ContractKindListContext();
	            session.setAttribute(ContractKindListContext.SESSION_KEY,context);
		 }
		 
		return context;
    	
    }
    
	private void setSearchFilter(ContractKindListContext contractKindContext,
			ContractKindService contractKindService) {
		if(contractKindContext.getContractKindName() != null && contractKindContext.getContractKindName().length()>0){
			contractKindService.setNameFilter(contractKindContext.getContractKindName(),FilterKind.MIDDLE);
		}
		
	}
	
	public ActionForward back(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
		
    createTitle(Constants.SCREEN_ADM004);
	ContractKindListContext context = getContractListContext(request);	
	
	ContractKindListViewHelper viewHelper = (ContractKindListViewHelper)request.getSession().getAttribute(ContractKindListViewHelper.SESSION_KEY);
	
	setContractKindList(viewHelper, context, null);
	
	return mapping.findForward(SUCCESS_PATH);
	}
	
	public ActionForward search(ActionMapping mapping, ActionForm form, 
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        ContractKindListContext context = getContractListContext(request);
        
        ContractKindListForm kindListForm = (ContractKindListForm)form;        
        
        context.reset();
        setContext(context, kindListForm);
        
        ContractKindListViewHelper viewHelper = (ContractKindListViewHelper) request.getSession().getAttribute(ContractKindListViewHelper.SESSION_KEY);
        viewHelper.reset(kindListForm);
        viewHelper.setPage(FIRST_PAGE);
        setContractKindList(viewHelper, context, null);
        
        if (viewHelper.getTotalCount() == 0) {            
            MessageUtil mu = new MessageUtil();
            saveMessages(request, mu.createActionMessages("", request, "msg_data_not_exist", "item_group_contract_kind"));
        }
        	
        return mapping.findForward(SUCCESS_PATH);
    }
	
	private void setContext(ContractKindListContext context,
			ContractKindListForm kindListForm) {
		context.setContractKindName(kindListForm.getContractKindName());
	}
    	
}
