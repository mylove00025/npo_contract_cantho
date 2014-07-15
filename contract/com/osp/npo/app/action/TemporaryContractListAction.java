package com.osp.npo.app.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.osp.npo.app.context.TemporaryContractContext;
import com.osp.npo.app.form.TemporaryContractListForm;
import com.osp.npo.app.message.MessageUtil;
import com.osp.npo.app.viewhelper.TemporaryContractListViewHelper;
import com.osp.npo.common.global.Constants;
import com.osp.npo.common.global.Constants.FilterKind;
import com.osp.npo.common.util.EditString;
import com.osp.npo.common.util.RelateDateTime;
import com.osp.npo.core.OrderField;
import com.osp.npo.core.OrderField.OrderType;
import com.osp.npo.core.temporaryContract.TemporaryContractList;
import com.osp.npo.service.TemporaryContractService;

/**
 * <P>Temporary Contract List Action</P>
 *
 * @author SonHD
 * @author HaiNT
 * @version $Revision: 25516 $
 */
@SuppressWarnings("unchecked")
public class TemporaryContractListAction extends BaseMDAction {
    
    private static final String SUCCESS = "success";
    private static final Integer FIRST_PAGE = 1;
    private static final String ORDER_FIELD_ENTRY_DATE = "entry_date_time";
    private static final Byte TYPE_UNSIGNED = 0;
    private static final String ORDER_FIELD_CONTRACT_TEMPLATE = "name";
    private static final String NOTARY_DATE_IN_DAY = "01";
    private static final String NOTARY_DATE_IN_WEEK = "02";
    private static final String NOTARY_DATE_IN_MONTH = "03";
    private static final String NOTARY_DATE_IN_YEAR = "04";
    private static final String NOTARY_DATE_IN_RANGE = "05";
    private String keyHightLight = "";
    private List<String> subKeyList;
    /**
     * <P>Action for first view</P>
     * 
     * @author SonHD 
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward view(ActionMapping mapping, ActionForm form, 
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        createTitle(Constants.SCREEN_CNTR026);
        
        HttpSession session = request.getSession();
        
        //delete session
        if (session.getAttribute(TemporaryContractListViewHelper.SESSION_KEY) != null) {
            session.removeAttribute(TemporaryContractListViewHelper.SESSION_KEY);
        }
        
        if (session.getAttribute(TemporaryContractContext.SESSION_KEY) != null) {
            session.removeAttribute(TemporaryContractContext.SESSION_KEY);
        }
        
        TemporaryContractContext temporaryContractContext = new TemporaryContractContext();
        temporaryContractContext.clear();        
        TemporaryContractListViewHelper temporaryContractListViewHelper = new TemporaryContractListViewHelper();
        TemporaryContractService temporaryContractService = new TemporaryContractService(getConnection());
        temporaryContractService.addOrderFieldContractTemplate(new OrderField(ORDER_FIELD_CONTRACT_TEMPLATE));
        temporaryContractListViewHelper.setContractTemplateList(temporaryContractService.queryAllContractTemplate(false).getList());
        //Set default value for first view
        //default search
        saveDataContractList(temporaryContractListViewHelper, temporaryContractContext, null);
        temporaryContractListViewHelper.setContractKindTree(temporaryContractService.getContractKindTree(false, null));
        session.setAttribute(TemporaryContractContext.SESSION_KEY, temporaryContractContext);
        session.setAttribute(TemporaryContractListViewHelper.SESSION_KEY, temporaryContractListViewHelper);
        
        return mapping.findForward(SUCCESS);
    }

    /**
     * <P>Action when click search button</P>
     * 
     * @author SonHD 
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward search(ActionMapping mapping, ActionForm form, 
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        TemporaryContractListForm contractListForm = (TemporaryContractListForm)form;        
        
        HttpSession session = request.getSession();        
        TemporaryContractListViewHelper contractListViewHelper = (TemporaryContractListViewHelper)session.getAttribute(TemporaryContractListViewHelper.SESSION_KEY);        
        TemporaryContractContext temporaryContractContext = (TemporaryContractContext)session.getAttribute(TemporaryContractContext.SESSION_KEY);
        
        if (contractListViewHelper != null && temporaryContractContext != null) {          
            contractListViewHelper.reset(contractListForm);
            temporaryContractContext.clear();
            this.keyHightLight = "";
            this.subKeyList = null;
            setContext(temporaryContractContext, contractListForm);
            contractListViewHelper.setPage(FIRST_PAGE);
            saveDataContractList(contractListViewHelper, temporaryContractContext, null);
            contractListViewHelper.setKeyHighLight(this.keyHightLight);
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
     * @author SonHD 
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward paging(ActionMapping mapping, ActionForm form, 
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        TemporaryContractListForm contractListForm = (TemporaryContractListForm)form;        
        
		HttpSession session = request.getSession();
		TemporaryContractListViewHelper contractListViewHelper = (TemporaryContractListViewHelper) session
				.getAttribute(TemporaryContractListViewHelper.SESSION_KEY);
		TemporaryContractContext temporaryContractContext = (TemporaryContractContext)session.getAttribute(TemporaryContractContext.SESSION_KEY);
        
        if (contractListViewHelper != null && temporaryContractContext != null) {            
            saveDataContractList(contractListViewHelper, temporaryContractContext, contractListForm.getDirection());
            contractListViewHelper.setIsAdvanceSearch(contractListForm.getIsAdvanceSearch());
            contractListViewHelper.setIsHidePanelSearch(contractListForm.getIsHidePanelSearch());
        }
        
        return mapping.findForward(SUCCESS);
    }
    
    /**
     * <P>Action back</P>
     * 
     * @author SonHD 
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
		TemporaryContractListViewHelper contractListViewHelper = (TemporaryContractListViewHelper) session
				.getAttribute(TemporaryContractListViewHelper.SESSION_KEY);
		TemporaryContractContext temporaryContractContext = (TemporaryContractContext)session.getAttribute(TemporaryContractContext.SESSION_KEY);
        
        if (contractListViewHelper != null && temporaryContractContext != null) {
            setViewHelper(contractListViewHelper, temporaryContractContext);
            saveDataContractList(contractListViewHelper, temporaryContractContext, null);
        }
        else {
            view(mapping, form, request, response);
        }
        
        return mapping.findForward(SUCCESS);
    }
    
    /**
     * <P>Save Contract Data to View Helper</P>
     * 
     * @author SonHD 
     * @param preventListViewHelper
     * @param context
     * @param direction
     */
	private void saveDataContractList(
			TemporaryContractListViewHelper temporaryContractListViewHelper,
			TemporaryContractContext context, String direction)
			throws SQLException, IOException {

		TemporaryContractService contractService = new TemporaryContractService(
				getConnection());

		// set search filter
		setSearchFilter(context, contractService);
		
		contractService.setTemporaryContractTypeFilter(TYPE_UNSIGNED);

		temporaryContractListViewHelper.setContractList(null);

		Integer totalCount = contractService.countTotalTemporaryContract();
		temporaryContractListViewHelper.setTotalCount(totalCount);

		if (totalCount != 0) {
			Integer totalPage = pageCalculation(totalCount, getLineMax());
			temporaryContractListViewHelper.setTotalPage(totalPage);
			temporaryContractListViewHelper.setPage(pageTransition(direction,
					temporaryContractListViewHelper.getPage(), totalPage));
//			if (temporaryContractListViewHelper.getIsAdvanceSearch() 
//                    || (!temporaryContractListViewHelper.getIsAdvanceSearch() && EditString.isNull(temporaryContractListViewHelper.getKeySearch()))) {
//                contractService.addContractOrderField(new OrderField(ORDER_FIELD_NOTARY_YEAR, OrderType.DESC));
//                contractService.addContractOrderField(new OrderField(ORDER_FIELD_CONTRACT_NUMNER, OrderType.DESC));
//            }
			contractService.addTemporaryContractOrderField(new OrderField(
					ORDER_FIELD_ENTRY_DATE, OrderType.DESC));
			TemporaryContractList contractList = contractService
					.queryTemporaryContract(false,
							temporaryContractListViewHelper.getPage(),
							getLineMax());
			temporaryContractListViewHelper.setContractList(contractList
					.getList());
		}
	}
    
    /**
     * <P>Set data from contract context to contract view helper</P>
     * 
     * @author SonHD 
     * @param viewHelper
     * @param context
     */
    private void setViewHelper(TemporaryContractListViewHelper viewHelper, TemporaryContractContext context) {
    	viewHelper.setContractNumberFilter(context.getContractNumberFilter());
        viewHelper.setContractSearchFilter(context.getContractSearchFilter());
        viewHelper.setBankIdFilter(context.getBankIdFilter());
        viewHelper.setContractTemplateIdFilter(context.getContractTemplateIdFilter());
        viewHelper.setDrafterIdFilter(context.getDrafterIdFilter());
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
     * @author SonHD 
     * @param context
     * @param form
     */
    private void setContext(TemporaryContractContext context, TemporaryContractListForm form) {
        context.setContractNumberFilter(form.getContractNumberFilter());
    	context.setContractSearchFilter(form.getContractSearchFilter());
      //context.setAdditionStatusFilter(form.getAdditionStatusFilter());
        context.setBankIdFilter(form.getBankIdFilter());
        //context.setCancellationStatusFilter(form.getCancellationStatusFilter());
        context.setContractKindIdFilter(form.getContractKindIdFilter());
        context.setContractTemplateIdFilter(form.getContractTemplateIdFilter());
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
        
        context.setIsAdvanceSearch(form.getIsAdvanceSearch());
        context.setIsHidePanelSearch(form.getIsHidePanelSearch());
    }
    
    /**
     * <P>Set search filter</P>
     * 
     * @author SonHD 
     * @param context
     * @param service
     */
    private void setSearchFilter(TemporaryContractContext context, TemporaryContractService service) {
    	
    	 if (!EditString.isNull(context.getContractNumberFilter())) {
             service.setContractNumberFilter(context.getContractNumberFilter(), FilterKind.MIDDLE);
         }
    	
    	if (context.getBankIdFilter() != null && context.getBankIdFilter() != 0L) {
            service.setBankIdFilter(context.getBankIdFilter());
        }
        
        if (context.getContractKindIdFilter() != null && context.getContractKindIdFilter() != 0L) {
            service.setContractKindIdFilter(context.getContractKindIdFilter());
        }
        
        if (context.getContractTemplateIdFilter() != null && context.getContractTemplateIdFilter() != 0L) {
            service.setContractTemplateIdFilter(context.getContractTemplateIdFilter());
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
            service.setPropertyInfoFilter(context.getPropertyInfoFilter(), FilterKind.MIDDLE);
        }
        
        if (!EditString.isNull(context.getRelationObjectFilter())) {
            service.setRelationObjectFilter(context.getRelationObjectFilter(), FilterKind.MIDDLE);
        }
        
        if (!EditString.isNull(context.getContractSummaryFilter())) {
            service.setContractSummaryFilter(context.getContractSummaryFilter(), FilterKind.MIDDLE);
        }
        
        if (!EditString.isNull(context.getKeySearch())) {
            service.setSubKeys(subKeyList);
            if (subKeyList.size() > 0) {
                service.setKeySearchFilter(context.getKeySearch());
            } else {
                service.setKeySearchFilter(null);
            }
        }
    }
    
    private List<String> parseKeySearch(String key) {
        List<String> subkeys = new ArrayList<String>();
        key = key.trim();
        while (key.charAt(0) == '+' || key.charAt(0) == '-') {
            key = key.substring(1, key.length() - 1);
        }
        
        while (key.charAt(key.length() - 1) == '+' || key.charAt(key.length() - 1) == '-') {
            key = key.substring(0, key.length() - 2);
        }
       
        key = key.replaceAll(Constants.PLUS, "\\+ ");
        
        Pattern pattern = Pattern.compile("\\s+");
        Matcher matcher = pattern.matcher(key);
        key = matcher.replaceAll(" ");
        
        //key = key.replaceAll("\"" + Constants.SPACE + "\"", "\"" + Constants.SPACE + Constants.SPACE + "\"");
        key = key.replaceAll("\"\"", "\"" + Constants.SPACE + "\"");
        
        String[] temp = key.split(Constants.MASK);
        for (int i = 0; i < temp.length; i++) {            
            if (i % 2 == 1) {
                if (!EditString.isNull(temp[i].trim())) {
                    if (subkeys.size() > 0 && !Constants.SPACE.equals(subkeys.get(subkeys.size() - 1))
                            && !Constants.PLUS.equals(subkeys.get(subkeys.size() - 1))) {
                        subkeys.add(Constants.SPACE);
                    }
                    subkeys.add(Constants.MASK + temp[i] + Constants.MASK);
                }
            } else if (i % 2 == 0) {
                parseSubKey(temp[i], Constants.PLUS, subkeys);
            }
        }
        
        while (subkeys.size() > 0 && Constants.PLUS.equals(subkeys.get(subkeys.size() - 1))) {
            subkeys.remove(subkeys.size() - 1);
        }
        while (subkeys.size() > 0 && Constants.MINUS.equals(subkeys.get(subkeys.size() - 1))) {
            subkeys.remove(subkeys.size() - 1);
        }
        while (subkeys.size() > 0 && EditString.isNull(subkeys.get(subkeys.size() - 1).trim())) {
            subkeys.remove(subkeys.size() - 1);
        }
        if (subkeys.size() > 0 && !Constants.PLUS.equals(subkeys.get(0))) {
            subkeys.add(0, Constants.PLUS);
        }
        
        return subkeys;
    }
    
    private void parseSubKey(String subKey, String regex, List<String> subkeys) {
        String[] temp1 = subKey.split(Constants.PLUS);
        
        if (!EditString.isNull(subKey) && EditString.isNull(subKey.trim())
                && !Constants.SPACE.equals(subkeys.get(subkeys.size() - 1))
                && !Constants.PLUS.equals(subkeys.get(subkeys.size() - 1))) {
            subkeys.add(Constants.SPACE);
        }
        
        for (int i = 0; i < temp1.length; i++) {
            if (!EditString.isNull(temp1[i].trim())) {
                
                if (i > 0 && subkeys.size() > 0 && !Constants.SPACE.equals(subkeys.get(subkeys.size() - 1))
                        && !Constants.PLUS.equals(subkeys.get(subkeys.size() - 1))) {
                    subkeys.add(Constants.PLUS);
                }
                               
                String[] temp2 = temp1[i].trim().split(Constants.SPACE);
                
                if (subkeys.size() > 0 && !Constants.SPACE.equals(subkeys.get(subkeys.size() - 1))
                        && !Constants.PLUS.equals(subkeys.get(subkeys.size() - 1))) {
                    subkeys.add(Constants.SPACE);
                }
                
                for (int k = 0; k < temp2.length; k++) {
                    if (k != temp2.length - 1) {
                        subkeys.add(temp2[k]);
                        subkeys.add(Constants.SPACE);
                    } else {
                        subkeys.add(temp2[k]);
                    }
                }                
            }
            if (i > 0 && i == temp1.length - 1 && EditString.isNull(temp1[i].trim())
                    && subkeys.size() > 0 && !Constants.SPACE.equals(subkeys.get(subkeys.size() - 1))
                    && !Constants.PLUS.equals(subkeys.get(subkeys.size() - 1))) {
                subkeys.add(Constants.PLUS);
            }
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
