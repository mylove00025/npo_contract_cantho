package com.osp.npo.app.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.osp.npo.app.context.CommonContext;
import com.osp.npo.app.context.ContractContext;
import com.osp.npo.app.export.ContractSynthetizeReport;
import com.osp.npo.app.form.ContractListForm;
import com.osp.npo.app.message.MessageUtil;
import com.osp.npo.app.viewhelper.ContractListViewHelper;
import com.osp.npo.common.global.Constants;
import com.osp.npo.common.global.Constants.FilterKind;
import com.osp.npo.common.util.EditString;
import com.osp.npo.common.util.RelateDateTime;
import com.osp.npo.core.OrderField;
import com.osp.npo.core.OrderField.OrderType;
import com.osp.npo.core.contract.ContractTemplateInfo;
import com.osp.npo.core.prevent.TransactionPropertyList;
import com.osp.npo.service.ContractKindService;
import com.osp.npo.service.ContractService;
import com.osp.npo.service.LuceneContractService;
import com.osp.npo.service.PreventService;
import com.osp.npo.service.UserService;

/**
 * <P>Contract List Action</P>
 *
 * @author HungPT
 * @version $Revision: 30014 $
 */
@SuppressWarnings("unchecked")
public class ContractListAction extends BaseMDAction {
    
    private static final String SUCCESS = "success";
    private static final String FAILURE = "failure";

    private static final Integer FIRST_PAGE = 1;
    private static final String NOTARY_ROLE = "02";
    private static final String DRAFTER_ROLE = "03";
    private static final String NOTARY_DATE_IN_DAY = "01";
    private static final String NOTARY_DATE_IN_WEEK = "02";
    private static final String NOTARY_DATE_IN_MONTH = "03";
    private static final String NOTARY_DATE_IN_YEAR = "04";
    private static final String NOTARY_DATE_IN_RANGE = "05";
    private static final String FILE_NAME = "BaocaoHDCC.xls";
    private static final String ORDER_FIELD_CONTRACT_TEMPLATE = "name";
    private static final String ORDER_FIELD_USER = "first_name";
    private static final String ORDER_FIELD_CONTRACT_NUMNER = "CAST(ntp.contract_number AS UNSIGNED)";
    private static final String ORDER_FIELD_NOTARY_YEAR = "YEAR(ntp.notary_date)";
//    private static final String ORDER_FIELD_BANK = "order_number";
    public static final String OPTION_ALL = "0";
    
    private String keyHightLight = "";
    private List<String> subKeyList;
    
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
        
        createTitle(Constants.SCREEN_CNTR001);
        
        HttpSession session = request.getSession();
        
        //delete session
        if (session.getAttribute(ContractListViewHelper.SESSION_KEY) != null) {
            session.removeAttribute(ContractListViewHelper.SESSION_KEY);
        }
        
        if (session.getAttribute(ContractContext.SESSION_KEY) != null) {
            session.removeAttribute(ContractContext.SESSION_KEY);
        }
        
        ContractContext contractContext = new ContractContext();
        session.setAttribute(ContractContext.SESSION_KEY, contractContext);
        
//        BasicDataService basicDataService = new BasicDataService(getConnection());
        UserService userService = new UserService(getConnection());
        ContractService contractService = new ContractService(getConnection());
        ContractKindService contractKindService = new ContractKindService(getConnection());
        
        ContractListViewHelper contractListViewHelper = new ContractListViewHelper();
        
        //Set default value for first view
//        basicDataService.addOrderFieldBank(new OrderField(ORDER_FIELD_BANK)); 
//        contractListViewHelper.setBankList(basicDataService.queryAllBank(false).getList());
        
        //userService.setActiveFlgFilter(Boolean.TRUE);
        userService.setHiddenFlgFilter(Boolean.FALSE);
        userService.addOrderFieldUser(new OrderField(ORDER_FIELD_USER));
        userService.setRoleFilter(new String[] { DRAFTER_ROLE });
        contractListViewHelper.setDrafterList(userService.queryAllUser(false).getList());
        userService.setRoleFilter(new String[] {NOTARY_ROLE });
        contractListViewHelper.setNotaryList(userService.queryAllUser(false).getList());
        
        contractService.addOrderFieldContractTemplate(new OrderField(ORDER_FIELD_CONTRACT_TEMPLATE));
        contractListViewHelper.setContractTemplateList(contractService.queryAllContractTemplate(false).getList());
        
        //default search
        contractContext.clear();
        //contractContext.setNotaryDateFilter(NOTARY_DATE_IN_ALL);
        saveDataContractList(contractListViewHelper, contractContext, null, session);
        
        contractListViewHelper.setContractKindTree(contractKindService.getContractKindTree(false, null));        
        
        session.setAttribute(ContractListViewHelper.SESSION_KEY, contractListViewHelper);
        
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
        
        ContractListForm contractListForm = (ContractListForm)form;        
        
        HttpSession session = request.getSession();
        CommonContext commonContext = (CommonContext)session.getAttribute(CommonContext.SESSION_KEY);
        ContractListViewHelper contractListViewHelper = (ContractListViewHelper)session.getAttribute(ContractListViewHelper.SESSION_KEY);        
        ContractContext contractContext = (ContractContext)session.getAttribute(ContractContext.SESSION_KEY);
        
        if (contractListViewHelper != null && contractContext != null) {            
            contractListViewHelper.reset(contractListForm);            
            contractContext.clear();
            this.keyHightLight = "";
            this.subKeyList = null;
            if (contractListForm.getIsAdvanceSearch()) {
            	
            	contractListViewHelper.setLuceneSearch(false);
            	
                setContext(contractContext, contractListForm);
                contractListViewHelper.setPage(FIRST_PAGE);
                saveDataContractList(contractListViewHelper, contractContext, null, session);
                contractListViewHelper.setKeyHighLight(this.keyHightLight);
            } else {     
            	String keySearch ="";
                if (!EditString.isNull(contractListForm.getKeySearch())) {
                    contractContext.setKeySearch(contractListForm.getKeySearch());
                    keySearch = EditString.convertUnicodeToASCII(contractListForm.getKeySearch());
//                   String escapeChars ="[\\\\+\\-\\!\\(\\)\\:\\^\\]\\{\\}\\~\\*\\?]";
//                   keySearch = keySearch.replaceAll(escapeChars, "\\\\$0");
                }
//                while (keySearch!=null && !"".equals(keySearch) && !Character.isLetterOrDigit(keySearch.charAt(keySearch.length()-1))&& keySearch.charAt(0)!= '"') {
//					if (keySearch.length() >=2) {
//						keySearch = keySearch.substring(0, keySearch.length() - 1);
//						} else keySearch = "";
//				}
                keySearch = EditString.parseKeyForSearch(keySearch).trim();
                subKeyList = EditString.parseKeySearch(keySearch);
                if ("".equals(keySearch)||subKeyList.size()==0) {
                	//default search
                    contractContext.clear();
                    saveDataContractList(contractListViewHelper, contractContext, null, session);
                    
                    contractListViewHelper.setLuceneSearch(false);
                    
                } else {
                
                  
 //                   subKeyList = parseKeySearch(contractListForm.getKeySearch());
                    
                    getSubKeyForHightLight(subKeyList);
                    contractListViewHelper.setPage(FIRST_PAGE);
                    LuceneContractService luceneContractService = new LuceneContractService();
                    luceneContractService.searchContract(contractListViewHelper, commonContext.getUserInfo().getId(), subKeyList, getLineMax(), FIRST_PAGE);
                    contractListViewHelper.setTotalPage(pageCalculation(contractListViewHelper.getTotalCount(), getLineMax()));
                    contractListViewHelper.setIsHidePanelSearch(true);
                    contractListViewHelper.setIsAdvanceSearch(false);
                    contractListViewHelper.setSubkeyList(subKeyList);
                
	                contractContext.setIsAdvanceSearch(contractListForm.getIsAdvanceSearch());
	                contractContext.setIsHidePanelSearch(contractListForm.getIsHidePanelSearch());
                }
            }   

             
        }
        if (contractListViewHelper.getTotalCount() == 0) {
            MessageUtil mu = new MessageUtil();
            saveMessages(request, mu.createActionMessages("", request, "msg_data_not_exist", "item_contract"));
        }
        return mapping.findForward(SUCCESS);
    }
    
    /**
     * <P>Action when paging</P>
     * 
     * @author HungPT 
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward paging(ActionMapping mapping, ActionForm form, 
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        ContractListForm contractListForm = (ContractListForm)form;   
        MessageUtil messageUtil = new MessageUtil();
        HttpSession session = request.getSession();    
        CommonContext commonContext = (CommonContext)session.getAttribute(CommonContext.SESSION_KEY);
        ContractListViewHelper contractListViewHelper = (ContractListViewHelper)session.getAttribute(ContractListViewHelper.SESSION_KEY);  
        Integer pageNumber = null;
        String page = request.getParameter("page");
        if (EditString.isNumber(page)) pageNumber = Integer.parseInt(page);
        if (page !=null && !page.trim().equals(String.valueOf(contractListViewHelper.getPage()))) {
	        if (pageNumber!=null && pageNumber>0 && pageNumber<=contractListViewHelper.getTotalPage()) {
	        	contractListViewHelper.setPage(pageNumber-1);
	        	contractListForm.setDirection("next");
	        } else {
	        	ActionErrors errors = new ActionErrors();
	            errors.add(messageUtil.createActionMessages("", request, "err_not_regular", "item_page"));
	            this.addErrors(request, errors);
	        	return mapping.findForward(FAILURE);
	        }
        }
        ContractContext contractContext = (ContractContext)session.getAttribute(ContractContext.SESSION_KEY);
        if (!contractListViewHelper.getLuceneSearch()){
        if (contractListViewHelper != null && contractContext != null) {            
            saveDataContractList(contractListViewHelper, contractContext, contractListForm.getDirection(), session);
            contractListViewHelper.setIsAdvanceSearch(contractListForm.getIsAdvanceSearch());
            contractListViewHelper.setIsHidePanelSearch(contractListForm.getIsHidePanelSearch());
        	} 
        } else {
      
        Integer totalPage = contractListViewHelper.getTotalPage();
    	contractListViewHelper.setPage(pageTransition(contractListForm.getDirection(), contractListViewHelper.getPage(), totalPage));
    	LuceneContractService luceneContractService = new LuceneContractService();
    	luceneContractService.searchContract(contractListViewHelper, commonContext.getUserInfo().getId(), contractListViewHelper.getSubkeyList(), getLineMax(), contractListViewHelper.getPage());
        }
//    	searchLucene(contractListViewHelper, contractListViewHelper.getPage());
        return mapping.findForward(SUCCESS);
    }
    
    /**
     * <P>Action back</P>
     * 
     * @author HungPT 
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
        CommonContext commonContext = (CommonContext)session.getAttribute(CommonContext.SESSION_KEY);
        ContractListViewHelper contractListViewHelper = (ContractListViewHelper)session.getAttribute(ContractListViewHelper.SESSION_KEY);
        ContractContext contractContext = (ContractContext)session.getAttribute(ContractContext.SESSION_KEY);
        
        if (contractListViewHelper != null && contractContext != null) {
        	if (!contractListViewHelper.getLuceneSearch()){
            setViewHelper(contractListViewHelper, contractContext);
            saveDataContractList(contractListViewHelper, contractContext, null, session);
        	} else {
        		LuceneContractService luceneContractService = new LuceneContractService();
                luceneContractService.searchContract(contractListViewHelper, commonContext.getUserInfo().getId(), contractListViewHelper.getSubkeyList(), getLineMax(), contractListViewHelper.getPage());
                contractListViewHelper.setTotalPage(pageCalculation(contractListViewHelper.getTotalCount(), getLineMax()));
        	}
        } else {
            view(mapping, form, request, response);
        }
        
        return mapping.findForward(SUCCESS);
        
    }
    
    /**
     * This is the Struts action method called on
     * http://.../actionPath?method=myAction2,
     * where "method" is the value specified in <action> element : 
     * ( <action parameter="method" .../> )
     */
    public ActionForward exportExcel(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        HttpSession session = request.getSession();
        CommonContext commonContext = (CommonContext)session.getAttribute(CommonContext.SESSION_KEY);
        ContractListViewHelper contractListViewHelper = (ContractListViewHelper)session.getAttribute(ContractListViewHelper.SESSION_KEY);
        ContractContext contractContext = (ContractContext)session.getAttribute(ContractContext.SESSION_KEY);
        
        ContractSynthetizeReport contractExcelCreator = new ContractSynthetizeReport();
        PreventService preventService = new PreventService(getConnection());
//        setViewHelper(contractListViewHelper, contractContext);
//        
//        ContractService contractService = new ContractService(getConnection());
        
        //set search filter        
//        setSearchFilter(contractContext, contractService);
        
//        Integer totalCount = contractService.countTotalContractByFilter();
//        contractListViewHelper.setTotalCount(totalCount);
        Integer totalCount;
        HSSFWorkbook workbook = null;
        if (contractListViewHelper.getLuceneSearch()) {
        	totalCount = preventService.countTotalTransactionProperty();
	        LuceneContractService luceneContractService = new LuceneContractService();
	        luceneContractService.searchContract(contractListViewHelper, commonContext.getUserInfo().getId(), subKeyList,totalCount , FIRST_PAGE);
	        contractListViewHelper.setTotalPage(pageCalculation(contractListViewHelper.getTotalCount(), getLineMax()));
	        totalCount = contractListViewHelper.getTotalCount();
	        contractExcelCreator.setLuceneSearch(Boolean.TRUE);
	        if (totalCount != 0) {
	        	workbook = contractExcelCreator.createWorkbook(contractListViewHelper.getTransactionPropertyList(), contractListViewHelper, 
	                contractContext, commonContext);
	        }
        } else {
        	contractExcelCreator.setLuceneSearch(Boolean.FALSE);
            setViewHelper(contractListViewHelper, contractContext);
          
            
          
          //set search filter        
            setSearchFilter(contractContext, contractListViewHelper, preventService);
            
            preventService.setOfficeCodeFilter(commonContext.getSystemOfficeAuthorityID() + "_");
            
            //HungPT 25/05/2014: change code for Can Tho
            preventService.setEntryUserIdFilter(commonContext.getUserInfo().getId());
            //End HungPT 25/05/2014
          
            totalCount = preventService.countTotalTransactionProperty();
            contractListViewHelper.setTotalCount(totalCount);
            //contractService.setOrderKeySearch(Boolean.FALSE);
            preventService.addOrderFieldTransactionProperty(new OrderField(ORDER_FIELD_NOTARY_YEAR, OrderType.ASC));
            preventService.addOrderFieldTransactionProperty(new OrderField(ORDER_FIELD_CONTRACT_NUMNER, OrderType.ASC));
	        TransactionPropertyList transactionPropertyList = preventService.queryAllTransactionProperty(false);
	        if (totalCount != 0) {
	        	workbook = contractExcelCreator.createWorkbook(transactionPropertyList.getList(), contractListViewHelper, 
		                contractContext, commonContext);
		        }
        	}   

	          
        if (totalCount!=0) {
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-Disposition", "attachment; filename=" + FILE_NAME);
            ServletOutputStream out = response.getOutputStream();
            workbook.write(out);
            out.flush();
            out.close();
            return null;
        } else {
            MessageUtil mu = new MessageUtil();
            saveMessages(request, mu.createActionMessages("", request, "msg_data_not_exist", "item_contract"));
            return mapping.findForward(SUCCESS);
        }
    }
    
    /**
     * <P>Save Contract Data to View Helper</P>
     * 
     * @author HungPT 
     * @param preventListViewHelper
     * @param context
     * @param direction
     */
    private void saveDataContractList(ContractListViewHelper contractListViewHelper, ContractContext context, String direction, HttpSession session)
        throws SQLException, IOException {
        
        PreventService preventService = new PreventService(getConnection());
        
        //set search filter        
        setSearchFilter(context, contractListViewHelper, preventService);
        
        CommonContext commonCntx = (CommonContext) session.getAttribute(CommonContext.SESSION_KEY);
        preventService.setOfficeCodeFilter(commonCntx.getSystemOfficeAuthorityID() + "_");
        
        //HungPT 25/05/2014: change code for Can Tho
        preventService.setEntryUserIdFilter(commonCntx.getUserInfo().getId());
        //End HungPT 25/05/2014
        
        contractListViewHelper.setTransactionPropertyList(null);
              
        Integer totalCount = preventService.countTotalTransactionProperty();
        contractListViewHelper.setTotalCount(totalCount);
        
        if (totalCount != 0) {                    
            Integer totalPage = pageCalculation(totalCount, getLineMax());
            contractListViewHelper.setTotalPage(totalPage);
            contractListViewHelper.setPage(pageTransition(direction, contractListViewHelper.getPage(), totalPage));
            if (contractListViewHelper.getIsAdvanceSearch() 
                    || (!contractListViewHelper.getIsAdvanceSearch() && EditString.isNull(contractListViewHelper.getKeySearch()))) {
                preventService.addOrderFieldTransactionProperty(new OrderField(ORDER_FIELD_NOTARY_YEAR, OrderType.DESC));
                preventService.addOrderFieldTransactionProperty(new OrderField(ORDER_FIELD_CONTRACT_NUMNER, OrderType.DESC));
            }
            
            TransactionPropertyList transactionPropertyList = preventService.queryTransactionPropertyForContractList(false, 
            		contractListViewHelper.getPage(), getLineMax());
            contractListViewHelper.setTransactionPropertyList(transactionPropertyList.getList());
        }
    }
    
    /**
     * <P>Set data from contract context to contract view helper</P>
     * 
     * @author HungPT 
     * @param viewHelper
     * @param context
     */
    private void setViewHelper(ContractListViewHelper viewHelper, ContractContext context) {
        viewHelper.setAdditionStatusFilter(context.getAdditionStatusFilter());
        viewHelper.setBankIdFilter(context.getBankIdFilter());
        viewHelper.setCancellationStatusFilter(context.getCancellationStatusFilter());
        viewHelper.setContractNumberFilter(context.getContractNumberFilter());
        viewHelper.setContractTemplateIdFilter(context.getContractTemplateIdFilter());
        viewHelper.setContractTemplateNameFilter(context.getContractTemplateNameFilter());
        viewHelper.setDrafterIdFilter(context.getDrafterIdFilter());
        viewHelper.setErrorStatusFilter(context.getErrorStatusFilter());
        viewHelper.setNotaryDateFilter(context.getNotaryDateFilter());
        viewHelper.setNotaryDateFromFilter(context.getNotaryDateFromFilter());
        viewHelper.setNotaryDateToFilter(context.getNotaryDateToFilter());
        viewHelper.setNotaryIdFilter(context.getNotaryIdFilter());
        viewHelper.setNotaryPlaceFilter(context.getNotaryPlaceFilter());
        viewHelper.setPropertyInfoFilter(context.getPropertyInfoFilter());
        viewHelper.setRelationObject(context.getRelationObject());
        viewHelper.setRelationObjectFilter(context.getRelationObjectFilter());
        viewHelper.setContractKindIdFilter(context.getContractKindIdFilter());
        viewHelper.setIsAdvanceSearch(context.getIsAdvanceSearch());
        viewHelper.setIsHidePanelSearch(context.getIsHidePanelSearch());
    }
    
    /**
     * <P>Set data for contract context</P>
     * 
     * @author HungPT 
     * @param context
     * @param form
     */
    private void setContext(ContractContext context, ContractListForm form) {
        //context.setAdditionStatusFilter(form.getAdditionStatusFilter());
        context.setBankIdFilter(form.getBankIdFilter());
        //context.setCancellationStatusFilter(form.getCancellationStatusFilter());
        context.setContractNumberFilter(form.getContractNumberFilter());
        context.setContractKindIdFilter(form.getContractKindIdFilter());
        context.setContractTemplateIdFilter(form.getContractTemplateIdFilter());
        context.setContractTemplateNameFilter(form.getContractTemplateNameFilter());
        context.setDrafterIdFilter(form.getDrafterIdFilter());
        //context.setErrorStatusFilter(form.getErrorStatusFilter());
        context.setNotaryDateFilter(form.getNotaryDateFilter());
        if (NOTARY_DATE_IN_RANGE.equals(form.getNotaryDateFilter())) {
            context.setNotaryDateFromFilter(form.getNotaryDateFromFilter());
            context.setNotaryDateToFilter(form.getNotaryDateToFilter());
        }
        context.setNotaryIdFilter(form.getNotaryIdFilter());
        context.setNotaryPlaceFilter(form.getNotaryPlaceFilter());
        context.setPropertyInfoFilter(form.getPropertyInfoFilter());
        context.setRelationObjectFilter(form.getRelationObjectFilter());
        context.setRelationObject(form.getRelationObject());
        context.setContractSummaryFilter(form.getContractSummaryFilter());
        context.setContractStatusFilter(form.getContractStatusFilter());
        
        context.setIsAdvanceSearch(form.getIsAdvanceSearch());
        context.setIsHidePanelSearch(form.getIsHidePanelSearch());
    }
    
    /**
     * <P>Set search filter</P>
     * 
     * @author HungPT 
     * @param context
     * @param service
     */
    private void setSearchFilter(ContractContext context, ContractListViewHelper viewHelper, PreventService service) {
                
        if (!EditString.isNull(context.getContractNumberFilter())) {
            service.setContractNumberFilter(context.getContractNumberFilter(), FilterKind.MIDDLE);
        }      
        
        if (!EditString.isNull(context.getContractTemplateNameFilter()) && !OPTION_ALL.equals(context.getContractTemplateNameFilter())) {
        	String[] contractTemplateNameFilter = new String[] {context.getContractTemplateNameFilter()};
        	service.setContractNameFilter(contractTemplateNameFilter);
        } else {
	        if (context.getContractKindIdFilter() != null && context.getContractKindIdFilter() != 0) {
	        	List<String> lstTemplateName = new ArrayList<String>();
	        	for (ContractTemplateInfo temp : viewHelper.getContractTemplateList()) {
	        		if (temp.getKindId().equals(context.getContractKindIdFilter())) {
	        			lstTemplateName.add(temp.getName());
	        		}
	        	}
	        	service.setContractNameFilter(lstTemplateName.toArray(new String[lstTemplateName.size()]));
	        }
        }
        
        if (NOTARY_DATE_IN_DAY.equals(context.getNotaryDateFilter())) {
            Date date = Calendar.getInstance().getTime();
            service.setNotaryDateFromFilter(RelateDateTime.toTimestamp(Boolean.TRUE, RelateDateTime.toDayMonthYear(date)));          
            service.setNotaryDateToFilter(RelateDateTime.toTimestamp(Boolean.FALSE, RelateDateTime.toDayMonthYear(date)));
        }
        
        if (NOTARY_DATE_IN_WEEK.equals(context.getNotaryDateFilter())) {
            Date date = Calendar.getInstance().getTime();
            String fromDate = RelateDateTime.getDateByFirstDayOfWeek(date);
            String toDate = RelateDateTime.getDateByLastDayOfWeek(date);
            service.setNotaryDateFromFilter(RelateDateTime.toTimestamp(Boolean.TRUE, fromDate));            
            service.setNotaryDateToFilter(RelateDateTime.toTimestamp(Boolean.FALSE, toDate));
            context.setNotaryDateFromFilter(fromDate);
            context.setNotaryDateToFilter(toDate);
        }
        
        if (NOTARY_DATE_IN_MONTH.equals(context.getNotaryDateFilter())) {
            Date date = Calendar.getInstance().getTime();
            String fromDate = RelateDateTime.getDateByFirstDayOfMonth(date);
            String toDate = RelateDateTime.getDateByLastDayOfMonth(date);
            service.setNotaryDateFromFilter(RelateDateTime.toTimestamp(Boolean.TRUE, fromDate));            
            service.setNotaryDateToFilter(RelateDateTime.toTimestamp(Boolean.FALSE, toDate));
            context.setNotaryDateFromFilter(fromDate);
            context.setNotaryDateToFilter(toDate);
        }
        
        if (NOTARY_DATE_IN_YEAR.equals(context.getNotaryDateFilter())) {
            Date date = Calendar.getInstance().getTime();
            String fromDate = RelateDateTime.getDateByFirstDayOfYear(date);
            String toDate = RelateDateTime.getDateByLastDayOfYear(date);
            service.setNotaryDateFromFilter(RelateDateTime.toTimestamp(Boolean.TRUE, fromDate));            
            service.setNotaryDateToFilter(RelateDateTime.toTimestamp(Boolean.FALSE, toDate));
            context.setNotaryDateFromFilter(fromDate);
            context.setNotaryDateToFilter(toDate);
        }
        
        if (NOTARY_DATE_IN_RANGE.equals(context.getNotaryDateFilter())) {
            service.setNotaryDateFromFilter(RelateDateTime.toTimestamp(Boolean.TRUE, context.getNotaryDateFromFilter())); 
            service.setNotaryDateToFilter(RelateDateTime.toTimestamp(Boolean.FALSE, context.getNotaryDateToFilter()));
        }
        
        if (!EditString.isNull(context.getPropertyInfoFilter())) {
            service.setTransactionPropertyInfoFilter(context.getPropertyInfoFilter(), FilterKind.MIDDLE);
        }
        
        if (!EditString.isNull(context.getRelationObjectFilter())) {
            service.setRelationObjectFilter(context.getRelationObjectFilter(), FilterKind.MIDDLE);
        }
    }
    
        
    private void getSubKeyForHightLight(List<String> subkeys) {
        String subkey = "";
        for (int i = 1; i < subkeys.size(); i += 2) {
            subkey = subkeys.get(i);
            subkey = subkey.trim();
            if (subkey.charAt(0) == '"') {
                subkey = subkey.substring(1, subkey.length() - 1);
            }
            if (subkey.charAt(subkey.length() - 1) == '"') {
                subkey = subkey.substring(0, subkey.length() - 2);
            }
            if (i != subkeys.size() - 1) {
                this.keyHightLight += subkey + "|";
            } else {
                this.keyHightLight += subkey;
            }            
        }
    }
}
    
    
