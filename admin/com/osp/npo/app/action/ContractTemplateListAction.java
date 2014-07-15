package com.osp.npo.app.action;


import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.osp.npo.app.context.ContractTemplateEditContext;
import com.osp.npo.app.context.ContractTemplateListContext;
import com.osp.npo.app.form.ContractTemplateListForm;
import com.osp.npo.app.message.MessageUtil;
import com.osp.npo.app.viewhelper.ContractTemplateListViewHelper;
import com.osp.npo.common.global.Constants;
import com.osp.npo.core.OrderField;
import com.osp.npo.core.contract.ContractKindTreeNode;
import com.osp.npo.core.contract.ContractTemplateInfo;
import com.osp.npo.core.contract.ContractTemplateList;
import com.osp.npo.service.ContractKindService;
import com.osp.npo.service.ContractService;

/**
 * <P>Contract Template List Action</P>
 *
 * @author KienLT
 * @version $Revision: 25298 $
 */
@SuppressWarnings("unchecked")
public class ContractTemplateListAction extends BaseMDAction {
    private static final String SUCCESS = "success";
    private static final String FAILURE = "failure";
    private static final Integer FIRST_PAGE = 1;
    public static final String CONTRACT_TEMPLATE_ID = "template_id";
    private static final String CONTRACT_KIND_NAME_ORDERFIELD = "contract_kind_name";
    private static final String CONTRACT_TEMPLATE_NAME_ORDERFIELD = "name";
    public static final String NO_LOGIN = "nologin";
    
    /**
     * <P>Action for first view</P>
     * 
     * @author KienLT
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */    
    public ActionForward view(ActionMapping mapping, ActionForm form, 
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        createTitle(Constants.SCREEN_ADM010);        
        HttpSession session = request.getSession();
        
        //delete session
        if (session.getAttribute(ContractTemplateListViewHelper.SESSION_KEY) != null) {
            session.removeAttribute(ContractTemplateListViewHelper.SESSION_KEY);
        }
        
        if (session.getAttribute(ContractTemplateListContext.SESSION_KEY) != null) {
            session.removeAttribute(ContractTemplateListContext.SESSION_KEY);
        }
        
        ContractTemplateListContext context = new ContractTemplateListContext();
        ContractTemplateListForm f = (ContractTemplateListForm) form;
        ContractTemplateListViewHelper view = new ContractTemplateListViewHelper();
                  
        view.setContractKindId((long)0);
        view.setUseStatus("00");
        
        //set default search
        f.setContractKindId((long)0);
        f.setUseStatus("00");
        f.setContractTemplateNameFilter("");
        setContext(context, f);
        saveDataContractTemplateList(view, context, null);
        
        request.getSession().setAttribute(ContractTemplateListViewHelper.SESSION_KEY, view);
        request.getSession().setAttribute(ContractTemplateListContext.SESSION_KEY, context);
           
        return mapping.findForward(SUCCESS);
    }
    
    /**
     * <P>Action when paging</P>
     * 
     * @author KienLT
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward paging(ActionMapping mapping, ActionForm form, 
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        ContractTemplateListForm f = (ContractTemplateListForm)form;  
        HttpSession session = request.getSession(); 
        ContractTemplateListViewHelper view = (ContractTemplateListViewHelper)
            session.getAttribute(ContractTemplateListViewHelper.SESSION_KEY);        
        ContractTemplateListContext context = (ContractTemplateListContext)
            session.getAttribute(ContractTemplateListContext.SESSION_KEY);
        
        setContext(context, f, view);
        if (context.getChkID() != null && context.getChkID().length > 0) {
            String[] checkedId = new String[context.getChkID().length];
            for (int i = 0; i < context.getChkID().length; i++) {
                checkedId[i] = context.getChkID()[i];
            }    view.setChkID(checkedId);
        } else {
        	view.setChkID(null);
        }
        
        if (view != null && context != null) {            
            saveDataContractTemplateList(view, context, f.getDirection());
        }
       
        return mapping.findForward(SUCCESS);
    }
    
    /**
     * <P>Action when click search button</P>
     * 
     * @author HungPT 
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward search(ActionMapping mapping, ActionForm form, 
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        ContractTemplateListForm f = (ContractTemplateListForm)form;        
        
        HttpSession session = request.getSession();        
        ContractTemplateListViewHelper view = (ContractTemplateListViewHelper)
            session.getAttribute(ContractTemplateListViewHelper.SESSION_KEY);        
        ContractTemplateListContext context = (ContractTemplateListContext)
            session.getAttribute(ContractTemplateListContext.SESSION_KEY);
        
        if (view != null && context != null) {
            view.reset(f);
            context.clear();
            setContext(context, f);
            view.setPage(FIRST_PAGE);
            saveDataContractTemplateList(view, context, null);
        }
        
        if (view.getTotalCount() == 0) {
            MessageUtil mu = new MessageUtil();
            saveMessages(request, mu.createActionMessages("", request, "msg_data_not_exist", "item_contract"));
        }
        
        return mapping.findForward(SUCCESS);
    }
    
    /**
     * Select Action
     * 
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward select(ActionMapping mapping, ActionForm form, 
            HttpServletRequest request, HttpServletResponse response) throws Exception {
                
        ContractTemplateListForm f = (ContractTemplateListForm)form;
        ContractTemplateEditContext context = new ContractTemplateEditContext();
        
        long id = f.getId();
        context.setId(id);
        ContractService service = new ContractService(getConnection());
        service.setContractTemplateId(id);
        ContractTemplateList list = service.queryAllContractTemplate(false);
        if (list.size() == 0) {
            ActionErrors errors = new ActionErrors();
            errors.add(new MessageUtil().createActionMessages("", request, "err_not_exist", "item_contract_template"));
            saveErrors(request, errors);
            return mapping.findForward(FAILURE);
        }
        
        request.getSession().setAttribute(ContractTemplateEditContext.SESSION_KEY, context);       
        return mapping.findForward(SUCCESS);
    }
    
    /**
     * Download Action
     * 
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward download(ActionMapping mapping, ActionForm form, 
            HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, Exception {
        
        ContractTemplateListForm f = (ContractTemplateListForm)form;
        
        Long id = f.getId();
        
        ContractService service = new ContractService(getConnection());   
        service.setContractTemplateId(id);
        ContractTemplateList contractTemplateList = service.queryContractTemplate(false, 0, 1);        
        
        if (contractTemplateList != null && contractTemplateList.size() > 0) {
            ContractTemplateInfo info = contractTemplateList.get(0);
            if (info != null && info.getFilePath() != null) {
                File file = new File(info.getFilePath());
    
                if (file != null && file.exists() && file.canRead() && file.isFile() && file.length() < Integer.MAX_VALUE) {
                    response.setContentType("application/octet-stream");
                    response.setHeader("Content-Disposition",
                            "attachment; filename=\"" + info.getFileName() + "\"");
                    response.setHeader("Pragma", "public");
                    response.setHeader("Cache-Control", "max-age=0");
                    ServletOutputStream out = response.getOutputStream();
                    FileInputStream fstream = new FileInputStream(file);
                    DataInputStream in = new DataInputStream(fstream);
                    long length = file.length();
                    byte[] b = new byte[(int)length];
                    in.read(b);
                    out.write(b);
                    out.flush();
                    out.close();
                    in.close();
                } else {
                    ActionErrors errors = new ActionErrors();
                    MessageUtil messageUtil = new MessageUtil();
                    errors.add(messageUtil.createActionMessages("", "err_file_not_found"));
                    this.addErrors(request, errors);
                }                 
            } else {
                ActionErrors errors = new ActionErrors();
                MessageUtil messageUtil = new MessageUtil();
                errors.add(messageUtil.createActionMessages("", "err_file_not_found"));
                this.addErrors(request, errors);
            }            
        } else {
            ActionErrors errors = new ActionErrors();
            MessageUtil messageUtil = new MessageUtil();
            errors.add(messageUtil.createActionMessages("", request, "err_not_exist", "item_contract_template"));
            this.addErrors(request, errors);
        }
        
        return mapping.findForward(SUCCESS);
    }
    
    /**
     * Back action
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
        
        HttpSession session = request.getSession();
        ContractTemplateListContext context = (ContractTemplateListContext)
        session.getAttribute(ContractTemplateListContext.SESSION_KEY);
        ContractTemplateListViewHelper view = (ContractTemplateListViewHelper)
        session.getAttribute(ContractTemplateListViewHelper.SESSION_KEY);   
        
        saveDataContractTemplateList(view, context, null);
        
        return mapping.findForward(SUCCESS);
    }
    
	public ActionForward changeStatusList(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws ServletException,
			SQLException, Exception {

		ContractTemplateListViewHelper helper = (ContractTemplateListViewHelper) request
				.getSession().getAttribute(
						ContractTemplateListViewHelper.SESSION_KEY);
		ContractTemplateListContext context = (ContractTemplateListContext) request
				.getSession().getAttribute(
						ContractTemplateListContext.SESSION_KEY);
		if (helper == null) {
			return mapping.findForward(NO_LOGIN);
		}

		ContractService service = new ContractService(getConnection());
		ContractTemplateListForm contractTemplateListForm = (ContractTemplateListForm) form;

		if (context != null) {
			setContext(context, contractTemplateListForm, helper);
			setViewHelper(helper, context);
		} else {
			helper.reset(contractTemplateListForm);
		}
		
		if (helper.getChkID() == null || helper.getChkID().length <= 0) { 	
 
			return mapping.findForward(SUCCESS);
		} else {
			for (String strNotaryId : helper.getChkID()) {

				Long contractId = null;
				try {
					contractId = Long.parseLong(strNotaryId);
				} catch (Exception e) {
					contractId = null;
				}

				service.setContractTemplateId(contractId);
				ContractTemplateList contractTemplateList = service
						.queryAllContractTemplate(false);
				if (contractTemplateList.size() == 0) {
					return mapping.findForward(FAILURE);
				}
				ContractTemplateInfo contractTemplateInfo = contractTemplateList
						.get(0);

				// Save info
				contractTemplateInfo.setActiveFlg(contractTemplateListForm
						.getContractTemplateStatus());
				createUpdateUserInfo(contractTemplateInfo);
				service.modifyContractTemplate(contractTemplateInfo);

			}

			getConnection().commit();
			helper.setChkID(null);
			context.setChkID(null);

			// update data
			HttpSession session = request.getSession();
			ContractTemplateListContext contextc = (ContractTemplateListContext) session
					.getAttribute(ContractTemplateListContext.SESSION_KEY);
			ContractTemplateListViewHelper view = (ContractTemplateListViewHelper) session
					.getAttribute(ContractTemplateListViewHelper.SESSION_KEY);

			saveDataContractTemplateList(view, contextc, null);

			return mapping.findForward(SUCCESS);
		}
	}
    
    /**
     * <P>Set data for contract context</P>
     * 
     * @author KienLT
     * @param context
     * @param form
     */
    private void setContext(ContractTemplateListContext context, ContractTemplateListForm form) {
        context.setContractKindId(form.getContractKindId());
        context.setContractName(form.getContractTemplateNameFilter());
        context.setUseStatus(form.getUseStatus());
    }
    
    /**
     * <P>Save Contract Data to View Helper</P>
     * 
     * @author KienLT
     * @param preventListViewHelper
     * @param context
     * @param direction
     */    
    private void saveDataContractTemplateList(ContractTemplateListViewHelper view, ContractTemplateListContext context, String direction)
        throws SQLException, IOException {
        
        ContractService contractService = new ContractService(getConnection());
        
        //set search filter        
        setSearchFilter(context, contractService);
        
        view.setContractTemplateList(null);
        
        ContractKindService service = new ContractKindService(getConnection());
        List<ContractKindTreeNode> contractKindTreeNodeList = service.getContractKindTree(false, null);
        view.setContractKindTreeNodeList(contractKindTreeNodeList);
        
        ContractTemplateList contractTemplateList = contractService.queryAllContractTemplate(false);
              
        int totalCount = contractTemplateList.size();
        view.setTotalCount(totalCount);
        
        if (totalCount != 0) {                    
            int totalPage = pageCalculation(totalCount, getLineMax());
            view.setTotalPage(totalPage);
            view.setPage(pageTransition(direction, view.getPage(), totalPage));
            contractTemplateList = contractService.queryContractTemplate(false, view.getPage(), getLineMax());
            view.setContractTemplateList(contractTemplateList.getList());
        }
    }
    
    /**
     * <P>Set search filter</P>
     * 
     * @author KienLT 
     * @param context
     * @param service
     */
    private void setSearchFilter(ContractTemplateListContext context, ContractService service) {
        if (context.getContractName() != null && context.getContractName() != "") {
            service.setContractTemplateNameFilter(context.getContractName());
        }        
        if (context.getContractKindId() != null && context.getContractKindId() != 0) {
            service.setContractTemplateKindIdFilter(context.getContractKindId());
        }
        
        String useStatus = context.getUseStatus();
        if ("01".equals(useStatus)) {
            service.setContractTemplateActiveFlgFilter(true);
        } else if ("02".equals(useStatus)) {
            service.setContractTemplateActiveFlgFilter(false);
        }
        service.addOrderFieldContractTemplate(new OrderField(CONTRACT_KIND_NAME_ORDERFIELD));
        service.addOrderFieldContractTemplate(new OrderField(CONTRACT_TEMPLATE_NAME_ORDERFIELD));
    }
    
    
    private void setContext(ContractTemplateListContext context, ContractTemplateListForm form, ContractTemplateListViewHelper viewHelper) throws SQLException, IOException {
        

        List<String> contractTemplateList = new ArrayList<String>();
        if (context.getChkID() != null && context.getChkID().length >= 0) {
            for (String item : context.getChkID()) {
            	contractTemplateList.add(item);
            }
        }
        
        if(viewHelper.getContractTemplateList() != null 
        		&& viewHelper.getContractTemplateList().size() > 0 ) {
        	for (ContractTemplateInfo info : viewHelper.getContractTemplateList()) {
				if (contractTemplateList.contains(info.getId().toString())) {
					contractTemplateList.remove(info.getId().toString());
				}
			}
        }
        
        if (form.getChkID() != null && form.getChkID().length >= 0) {
    	   
            for (int i = 0; i < form.getChkID().length; i++) {
                if(!contractTemplateList.contains(form.getChkID()[i].toString())) {
                	contractTemplateList.add(form.getChkID()[i].toString());
                }
            }
        }
        
        context.setChkID(contractTemplateList.toArray(new String[contractTemplateList.size()]));
    }
    
    private void setViewHelper(ContractTemplateListViewHelper viewHelper, ContractTemplateListContext context) {
        viewHelper.setContractTemplateNameFilter(context.getContractName());
        viewHelper.setChkID(context.getChkID());
    }
}
