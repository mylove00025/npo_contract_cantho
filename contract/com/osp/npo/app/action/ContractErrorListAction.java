/**
 * 
 */
package com.osp.npo.app.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.osp.npo.common.global.Constants;
import com.osp.npo.app.context.CommonContext;
import com.osp.npo.app.context.ContractByUserListContext;
import com.osp.npo.app.context.ContractErrorListContext;
import com.osp.npo.app.export.ContractErrorReport;
import com.osp.npo.app.form.ContractErrorListForm;
import com.osp.npo.app.message.MessageUtil;
import com.osp.npo.app.viewhelper.ContractErrorListViewHelper;
import com.osp.npo.common.util.RelateDateTime;
import com.osp.npo.core.OrderField;
import com.osp.npo.core.OrderField.OrderType;
import com.osp.npo.core.contract.ContractList;
import com.osp.npo.service.ContractErrorService;
import com.osp.npo.service.UserService;

/**
 * @author SonHD
 * @version $Revision: 29615 $
 */
@SuppressWarnings("unchecked")
public class ContractErrorListAction extends BaseMDAction {    
    private static final String NOTARY_IN_DAY = "01";
    private static final String NOTARY_IN_WEEK = "02";
    private static final String NOTARY_IN_MONTH = "03";
    private static final String NOTARY_IN_YEAR = "04";
    private static final String NOTARY_IN_RANGE = "05";
    private static final String SUCCESS = "success";
    private static final Integer FIRST_PAGE = 1;
    private static final String FILE_NAME = "DSHopDongLoi.xls";
    private static final String ORDER_FIELD_CONTRACT_NUMNER = "CAST(nc.contract_number AS UNSIGNED)";
    private static final String ORDER_FIELD_NOTARY_YEAR = "YEAR(nc.notary_date)";
    
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
        
        createTitle(Constants.SCREEN_CNTR016);
        
        HttpSession session = request.getSession();
        
        //delete session
        if (session.getAttribute(ContractErrorListViewHelper.SESSION_KEY) != null) {
            session.removeAttribute(ContractErrorListViewHelper.SESSION_KEY);
        }
        
        if (session.getAttribute(ContractByUserListContext.SESSION_KEY) != null) {
            session.removeAttribute(ContractByUserListContext.SESSION_KEY);
        }
        
        ContractErrorListContext context = new ContractErrorListContext();        
        ContractErrorListForm f = (ContractErrorListForm) form;
        ContractErrorListViewHelper view = new ContractErrorListViewHelper();
        UserService userService = new UserService(getConnection());
        
        userService.setActiveFlgFilter(true);
        userService.setHiddenFlgFilter(false);        
        userService.setRoleFilter(new String[]{"02"});
        userService.addOrderFieldUser(new OrderField("first_name", OrderType.ASC));
        view.setContractNotaryList(userService.queryAllUser(false).getList());
        
        userService.setRoleFilter(new String[]{"03"});
        view.setContractDrafterList(userService.queryAllUser(false).getList());
        view.setSearchDate(NOTARY_IN_MONTH);
        f.setSearchDate(NOTARY_IN_MONTH);
        setContext(context, f);
        //default search
        saveDataContractErrorList(view, context, null);
        
        request.getSession().setAttribute(ContractErrorListViewHelper.SESSION_KEY, view);
        request.getSession().setAttribute(ContractErrorListContext.SESSION_KEY, context);
           
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
     private void saveDataContractErrorList(ContractErrorListViewHelper contractErrorListViewHelper, 
            ContractErrorListContext context, String direction)
        throws SQLException, IOException {
        
        ContractErrorService contractService = new ContractErrorService(getConnection());
        
        //set search filter        
        setSearchFilter(context, contractService);
        
        contractErrorListViewHelper.setContractErrorList(null);
              
        int totalCount = contractService.countTotalContract();
        contractErrorListViewHelper.setTotalCount(totalCount);
        
        if (totalCount != 0) {                    
            int totalPage = pageCalculation(totalCount, getLineMax());
            contractErrorListViewHelper.setTotalPage(totalPage);
            if (direction != null) {
                contractErrorListViewHelper.setPage(pageTransition(direction, contractErrorListViewHelper.getPage(), totalPage));
            }
            contractService.addOrderFieldContract(new OrderField(ORDER_FIELD_NOTARY_YEAR, OrderType.DESC));
            contractService.addOrderFieldContract(new OrderField(ORDER_FIELD_CONTRACT_NUMNER, OrderType.DESC));
            ContractList contractList = contractService.queryContract(false, contractErrorListViewHelper.getPage(), getLineMax());
            contractErrorListViewHelper.setContractErrorList(contractList.getList());
        }
    }
    /**
     * <P>Set search filter</P>
     * 
     * @author SonHD 
     * @param context
     * @param service
     */
    private void setSearchFilter(ContractErrorListContext context, ContractErrorService service) {
        service.setDrafterIdFilter(context.getDrafterIdFilter());
        service.setNotaryIdFilter(context.getNotaryIdFilter());
        service.setErrorStatusFilter(true);
        if (NOTARY_IN_DAY.equals(context.getSearchDateFilter())) {
            Date date = Calendar.getInstance().getTime();
            service.setNotaryDateFromFilter(RelateDateTime.toTimestamp(Boolean.TRUE, RelateDateTime.toDayMonthYear(date)));          
            service.setNotaryDateToFilter(RelateDateTime.toTimestamp(Boolean.FALSE, RelateDateTime.toDayMonthYear(date)));
        }
        
        if (NOTARY_IN_WEEK.equals(context.getSearchDateFilter())) {
            Date date = Calendar.getInstance().getTime();
            String fromDate = RelateDateTime.getDateByFirstDayOfWeek(date);
            String toDate = RelateDateTime.getDateByLastDayOfWeek(date);
            service.setNotaryDateFromFilter(RelateDateTime.toTimestamp(Boolean.TRUE, fromDate));            
            service.setNotaryDateToFilter(RelateDateTime.toTimestamp(Boolean.FALSE, toDate));
            context.setFromDateFilter(fromDate);
            context.setToDateFilter(toDate);
        }
        
        if (NOTARY_IN_MONTH.equals(context.getSearchDateFilter())) {
            Date date = Calendar.getInstance().getTime();
            String fromDate = RelateDateTime.getDateByFirstDayOfMonth(date);
            String toDate = RelateDateTime.getDateByLastDayOfMonth(date);
            service.setNotaryDateFromFilter(RelateDateTime.toTimestamp(Boolean.TRUE, fromDate));            
            service.setNotaryDateToFilter(RelateDateTime.toTimestamp(Boolean.FALSE, toDate));
            context.setFromDateFilter(fromDate);
            context.setToDateFilter(toDate);
        }
        
        if (NOTARY_IN_YEAR.equals(context.getSearchDateFilter())) {
            Date date = Calendar.getInstance().getTime();
            String fromDate = RelateDateTime.getDateByFirstDayOfYear(date);
            String toDate = RelateDateTime.getDateByLastDayOfYear(date);
            service.setNotaryDateFromFilter(RelateDateTime.toTimestamp(Boolean.TRUE, fromDate));            
            service.setNotaryDateToFilter(RelateDateTime.toTimestamp(Boolean.FALSE, toDate));
            context.setFromDateFilter(fromDate);
            context.setToDateFilter(toDate);
        }
        
        if (NOTARY_IN_RANGE.equals(context.getSearchDateFilter())) {
            service.setNotaryDateFromFilter(RelateDateTime.toTimestamp(Boolean.TRUE, context.getFromDateFilter())); 
            service.setNotaryDateToFilter(RelateDateTime.toTimestamp(Boolean.FALSE, context.getToDateFilter()));
        }
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
        
        ContractErrorListForm contractListForm = (ContractErrorListForm)form;        
        
        HttpSession session = request.getSession();
        ContractErrorListViewHelper contractListViewHelper = 
            (ContractErrorListViewHelper)session.getAttribute(ContractErrorListViewHelper.SESSION_KEY);
        ContractErrorListContext contractContext = (ContractErrorListContext)session.getAttribute(ContractErrorListContext.SESSION_KEY);
        
        if (contractListViewHelper != null && contractContext != null) {            
            saveDataContractErrorList(contractListViewHelper, contractContext, contractListForm.getDirection());
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
        ContractErrorListViewHelper contractListViewHelper = 
            (ContractErrorListViewHelper)session.getAttribute(ContractErrorListViewHelper.SESSION_KEY);
        ContractErrorListContext contractContext = (ContractErrorListContext)session.getAttribute(ContractErrorListContext.SESSION_KEY);
        if (contractListViewHelper != null && contractContext != null) {
            setViewHelper(contractListViewHelper, contractContext);
            saveDataContractErrorList(contractListViewHelper, contractContext, null);
        }
        return mapping.findForward(SUCCESS);
    }
    /**
     * <P>Set data from contract context to contract view helper</P>
     * 
     * @author SonHD 
     * @param viewHelper
     * @param context
     */
    private void setViewHelper(ContractErrorListViewHelper viewHelper, ContractErrorListContext context) {
        viewHelper.setContractDrafterId(context.getDrafterIdFilter());
        viewHelper.setContractNotaryId(context.getNotaryIdFilter());
        viewHelper.setFromDate(context.getFromDateFilter());
        viewHelper.setToDate(context.getToDateFilter());
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
        
        ContractErrorListForm contractListForm = (ContractErrorListForm)form;        
        
        HttpSession session = request.getSession();        
        ContractErrorListViewHelper contractListViewHelper = 
            (ContractErrorListViewHelper)session.getAttribute(ContractErrorListViewHelper.SESSION_KEY);
        ContractErrorListContext contractContext = (ContractErrorListContext)session.getAttribute(ContractErrorListContext.SESSION_KEY);
        
        if (contractListViewHelper != null && contractContext != null) {
            contractListViewHelper.reset(contractListForm);
            contractContext.clear();
            setContext(contractContext, contractListForm);
            contractListViewHelper.setPage(FIRST_PAGE);
            saveDataContractErrorList(contractListViewHelper, contractContext, null);
        }
        if (contractListViewHelper.getTotalCount() == 0) {
            MessageUtil mu = new MessageUtil();
            saveMessages(request, mu.createActionMessages("", request, "msg_data_not_exist", "item_contract"));
        }
        
        return mapping.findForward(SUCCESS);
    }
    
    /**
     * <P>Set data for contract context</P>
     * 
     * @author SonHD
     * @param context
     * @param form
     */
    private void setContext(ContractErrorListContext context, ContractErrorListForm form) {
        if ((form.getContractDrafterId() != null) && (form.getContractDrafterId() != 0)) {
            context.setDrafterIdFilter(form.getContractDrafterId());
        }
        if ((form.getContractNotaryId() != null) && (form.getContractNotaryId() != 0)) {
            context.setNotaryIdFilter(form.getContractNotaryId());
        }
        context.setSearchDateFilter(form.getSearchDate());
        if (NOTARY_IN_RANGE.equals(form.getSearchDate())) {
            context.setFromDateFilter(form.getFromDate());
            context.setToDateFilter(form.getToDate());
        } else if (!"00".equals(form.getSearchDate())) {
            context.setSearchDateFilter(form.getSearchDate());
        }        
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
        ContractErrorListViewHelper contractListViewHelper = 
            (ContractErrorListViewHelper)session.getAttribute(ContractErrorListViewHelper.SESSION_KEY);
        ContractErrorListContext contractContext = (ContractErrorListContext)session.getAttribute(ContractErrorListContext.SESSION_KEY);
            ContractErrorReport contractExcelCreator = new ContractErrorReport();
            setViewHelper(contractListViewHelper, contractContext);            
            ContractErrorService contractService = new ContractErrorService(getConnection());
            
            //set search filter        
            setSearchFilter(contractContext, contractService);
            contractService.addOrderFieldContract(new OrderField(ORDER_FIELD_NOTARY_YEAR));
            contractService.addOrderFieldContract(new OrderField(ORDER_FIELD_CONTRACT_NUMNER));
            contractListViewHelper.setContractErrorList(null);
                  
            int totalCount = contractService.countTotalContract();
            contractListViewHelper.setTotalCount(totalCount);
            
            if (totalCount != 0) {
                ContractList contractList = contractService.queryAllContract(false);
                contractListViewHelper.setContractErrorList(contractList.getList());
                HSSFWorkbook workbook = contractExcelCreator.createWorkbook(contractListViewHelper.getContractErrorList(), 
                        contractContext, commonContext);

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
}