/**
 * 
 */
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
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.osp.npo.app.context.CommonContext;
import com.osp.npo.app.context.ContractAdditionContext;
import com.osp.npo.app.export.ContractAdditionReport;
import com.osp.npo.app.form.ContractAdditionForm;
import com.osp.npo.app.message.MessageUtil;
import com.osp.npo.app.viewhelper.ContractAdditionViewHelper;
import com.osp.npo.common.global.Constants;
import com.osp.npo.common.util.RelateDateTime;
import com.osp.npo.core.OrderField;
import com.osp.npo.core.OrderField.OrderType;
import com.osp.npo.core.contract.ContractInfo;
import com.osp.npo.core.contract.ContractList;
import com.osp.npo.service.ContractAdditionService;

/**
 * @author SonHD
 * @version $Revision: 29615 $
 */
public class ContractAdditionAction extends BaseMDAction {
    private static final String SUCCESS = "success";
    private static final String NOTARY_IN_DAY = "01";
    private static final String NOTARY_IN_WEEK = "02";
    private static final String NOTARY_IN_MONTH = "03";
    private static final String NOTARY_IN_YEAR = "04";
    private static final String NOTARY_IN_RANGE = "05";
    private static final String FILE_NAME = "HDcanbosungHS.xls";
    private static final String ORDER_FIELD_DRAFTER_ID = "nc.drafter_id";
    private static final String ORDER_FIELD_DRAFTER_FIRST_NAME = "drafter_first_name";
    private static final String ORDER_FIELD_DRAFTER_FAMILY_NAME = "drafter_family_name";
    private static final Integer FIRST_PAGE = 1;
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
        
        createTitle(Constants.SCREEN_CNTR028);
        
        ContractAdditionForm contractAdditionForm = (ContractAdditionForm)form;
        contractAdditionForm.setNotaryDateFromFilter("");
        contractAdditionForm.setNotaryDateToFilter("");
        
        HttpSession session = request.getSession();
        
        //delete session
        if (session.getAttribute(ContractAdditionViewHelper.SESSION_KEY) != null) {
            session.removeAttribute(ContractAdditionViewHelper.SESSION_KEY);
        }
        ContractAdditionContext context = new ContractAdditionContext();
        ContractAdditionForm f = (ContractAdditionForm) form;
        ContractAdditionViewHelper view = new ContractAdditionViewHelper();        
        //Set default filter
        view.setNotaryDateFilter(NOTARY_IN_MONTH);
        f.setNotaryDateFilter(NOTARY_IN_MONTH);
        view.setPage(FIRST_PAGE);
        setContext(context, f);
        saveDataContract(view, context, null);
        if (view.getTotalCount() == 0) {
            view.setTotalPage(0);
            view.setContractList(null);                
            MessageUtil mu = new MessageUtil();
            saveMessages(request, mu.createActionMessages("", request, "msg_data_not_exist", "item_contract"));
        }
        session.setAttribute(ContractAdditionViewHelper.SESSION_KEY, view);
        request.getSession().setAttribute(ContractAdditionContext.SESSION_KEY, context);
        return mapping.findForward(SUCCESS);
    }
    
    public ActionForward paging(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {

        ContractAdditionForm f = (ContractAdditionForm)form;
        HttpSession session = request.getSession();
        ContractAdditionViewHelper view = (ContractAdditionViewHelper)
            session.getAttribute(ContractAdditionViewHelper.SESSION_KEY);
        ContractAdditionContext context = (ContractAdditionContext)
            session.getAttribute(ContractAdditionContext.SESSION_KEY);

        if (view != null && context != null) {
            saveDataContract(view, context, f.getDirection());
        }

        return mapping.findForward(SUCCESS);
    }
    
    /**
     * <P>Action for export Excel</P>
     * 
     * @author SonHD 
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward exportExcel(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        HttpSession session = request.getSession();
        ContractAdditionContext context = (ContractAdditionContext)
        session.getAttribute(ContractAdditionContext.SESSION_KEY);
        ContractAdditionForm contractAdditionForm = (ContractAdditionForm) form;
        
        ContractAdditionViewHelper viewHelper = (ContractAdditionViewHelper)session
                                                    .getAttribute(ContractAdditionViewHelper.SESSION_KEY);
        ContractAdditionService contractService = new ContractAdditionService(getConnection());
        setViewHelper(viewHelper, contractAdditionForm);
                
        setSearchFilter(context, contractService);
        viewHelper.setNotaryDateFromFilter(context.getFromDate());
        viewHelper.setNotaryDateToFilter(context.getToDate());
        
        contractService.addOrderFieldContract(new OrderField(ORDER_FIELD_DRAFTER_ID));
        contractService.addOrderFieldContract(new OrderField(ORDER_FIELD_CONTRACT_NUMNER));
        ContractList contractList = contractService.queryAllContract(false);
   
        List<ContractInfo> tempList = new ArrayList<ContractInfo>();
        List<Long> drafterIdList = new ArrayList<Long>();
        for (int i = 0; i < contractList.size(); i++) {
            if(drafterIdList.contains((contractList.get(i).getDrafterId()))) {
                contractList.get(i).setNumberOfContractByDrafter((long) 0);
                tempList.add(contractList.get(i));
            } else {
                contractService.setDrafterIdFilter(contractList.get(i).getDrafterId());
                contractService.setDrafterIdFlagFilter(Boolean.FALSE);
                contractList.get(i).setNumberOfContractByDrafter((long)contractService.countTotalContract());
                tempList.add(contractList.get(i));
                drafterIdList.add(contractList.get(i).getDrafterId());
            }
        }
        viewHelper.setContractList(tempList);
        
        CommonContext commonContext = (CommonContext)session.getAttribute(CommonContext.SESSION_KEY);
        ContractAdditionViewHelper contractAdditionViewHelper = (ContractAdditionViewHelper)session.getAttribute(ContractAdditionViewHelper.SESSION_KEY);
        if(contractAdditionViewHelper.getContractList().size() > 0)
        {
            ContractAdditionReport contractAdditionReport = new ContractAdditionReport();
            HSSFWorkbook workbook = contractAdditionReport.createWorkbook(contractAdditionViewHelper, commonContext);
            
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
     * <P>Set data from contract form to contract view helper</P>
     * 
     * @author SonHD 
     * @param viewHelper
     * @param context
     */
    private void setViewHelper(ContractAdditionViewHelper viewHelper, ContractAdditionForm form) {
        viewHelper.setNotaryDateFilter(form.getNotaryDateFilter());
        if (NOTARY_IN_RANGE.equals(form.getNotaryDateFilter())) {
            viewHelper.setNotaryDateFromFilter(form.getNotaryDateFromFilter());
            viewHelper.setNotaryDateToFilter(form.getNotaryDateToFilter());
        } else if (!"00".equals(form.getNotaryDateFilter())) {
            viewHelper.setNotaryDateFilter(form.getNotaryDateFilter());
        }
    }
    
    /**
     * <P>Set search filter</P>
     * 
     * @author SonHD 
     * @param context
     * @param service
     */
    private void setSearchFilter(ContractAdditionContext context, ContractAdditionService service) {
        service.setAdditionStatusFilter(true);
        if (NOTARY_IN_DAY.equals(context.getSearchDate())) {
            Date date = Calendar.getInstance().getTime();
            service.setNotaryDateFromFilter(RelateDateTime.toTimestamp(Boolean.TRUE, RelateDateTime.toDayMonthYear(date)));          
            service.setNotaryDateToFilter(RelateDateTime.toTimestamp(Boolean.FALSE, RelateDateTime.toDayMonthYear(date)));
        }
        
        if (NOTARY_IN_WEEK.equals(context.getSearchDate())) {
            Date date = Calendar.getInstance().getTime();
            String fromDate = RelateDateTime.getDateByFirstDayOfWeek(date);
            String toDate = RelateDateTime.getDateByLastDayOfWeek(date);
            service.setNotaryDateFromFilter(RelateDateTime.toTimestamp(Boolean.TRUE, fromDate));            
            service.setNotaryDateToFilter(RelateDateTime.toTimestamp(Boolean.FALSE, toDate));
            context.setFromDate(fromDate);
            context.setToDate(toDate);
        }
        
        if (NOTARY_IN_MONTH.equals(context.getSearchDate())) {
            Date date = Calendar.getInstance().getTime();
            String fromDate = RelateDateTime.getDateByFirstDayOfMonth(date);
            String toDate = RelateDateTime.getDateByLastDayOfMonth(date);
            service.setNotaryDateFromFilter(RelateDateTime.toTimestamp(Boolean.TRUE, fromDate));            
            service.setNotaryDateToFilter(RelateDateTime.toTimestamp(Boolean.FALSE, toDate));
            context.setFromDate(fromDate);
            context.setToDate(toDate);
        }
        
        if (NOTARY_IN_YEAR.equals(context.getSearchDate())) {
            Date date = Calendar.getInstance().getTime();
            String fromDate = RelateDateTime.getDateByFirstDayOfYear(date);
            String toDate = RelateDateTime.getDateByLastDayOfYear(date);
            service.setNotaryDateFromFilter(RelateDateTime.toTimestamp(Boolean.TRUE, fromDate));            
            service.setNotaryDateToFilter(RelateDateTime.toTimestamp(Boolean.FALSE, toDate));
            context.setFromDate(fromDate);
            context.setToDate(toDate);
        }
        
        if (NOTARY_IN_RANGE.equals(context.getSearchDate())) {
            service.setNotaryDateFromFilter(RelateDateTime.toTimestamp(Boolean.TRUE, context.getFromDate())); 
            service.setNotaryDateToFilter(RelateDateTime.toTimestamp(Boolean.FALSE, context.getToDate()));
        }
    }
    
    /**
     * <P>Action when click search button</P>
     *
     * @author KienLT
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward search(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {

        ContractAdditionForm f = (ContractAdditionForm)form;

        HttpSession session = request.getSession();
        ContractAdditionViewHelper view = (ContractAdditionViewHelper)
            session.getAttribute(ContractAdditionViewHelper.SESSION_KEY);
        ContractAdditionContext context = (ContractAdditionContext)
            session.getAttribute(ContractAdditionContext.SESSION_KEY);
        
        if (view != null && context != null) {
            view.reset(f);
            context.clear();
            setContext(context, f);
            view.setPage(FIRST_PAGE);
            view.setTotalPage(0);
            view.setContractList(null);
            saveDataContract(view, context, null);
        }
        if (view.getTotalCount() == 0) {
            MessageUtil mu = new MessageUtil();
            saveMessages(request, mu.createActionMessages("", request, "msg_data_not_exist", "item_contract"));
        }

        return mapping.findForward(SUCCESS);
    }
    
    /**
     * <P>Set data for contract context</P>
     *
     * @author KienLT
     * @param context
     * @param form
     */
    private void setContext(ContractAdditionContext context, ContractAdditionForm form) {
        context.setSearchDate(form.getNotaryDateFilter());
        context.setFromDate(form.getNotaryDateFromFilter());
        context.setToDate(form.getNotaryDateToFilter());
    }
    
    /**
     * <P>Save Contract Data to View Helper</P>
     *
     * @author KienLT
     * @param preventListViewHelper
     * @param context
     * @param direction
     */
    @SuppressWarnings("unchecked")
    private void saveDataContract(ContractAdditionViewHelper view, ContractAdditionContext context, String direction)
        throws SQLException, IOException {
        
        ContractAdditionService contractService = new ContractAdditionService(getConnection());

        //set search filter
        setSearchFilter(context, contractService);

        view.setContractList(null);
        ContractList contractList = contractService.queryAllContract(false);

        int totalCount = contractList.size();
        view.setTotalCount(totalCount);

        if (totalCount != 0) {
            int totalPage = pageCalculation(totalCount, getLineMax());
            view.setTotalPage(totalPage);
            if (direction != null) {
                view.setPage(pageTransition(direction, view.getPage(), totalPage));
            }

            contractService.addOrderFieldContract(new OrderField(ORDER_FIELD_DRAFTER_FIRST_NAME));
            contractService.addOrderFieldContract(new OrderField(ORDER_FIELD_DRAFTER_FAMILY_NAME));
            contractService.addOrderFieldContract(new OrderField(ORDER_FIELD_NOTARY_YEAR, OrderType.DESC));
            contractService.addOrderFieldContract(new OrderField(ORDER_FIELD_CONTRACT_NUMNER, OrderType.DESC));
            contractList = contractService.queryContract(false, view.getPage(), getLineMax());
            view.setContractList(contractList.getList());
        }
    }
}
