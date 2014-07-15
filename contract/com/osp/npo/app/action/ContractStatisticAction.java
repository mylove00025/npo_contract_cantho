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

import com.osp.npo.app.context.CommonContext;
import com.osp.npo.app.export.ContractStatisticReport;
import com.osp.npo.app.form.ContractStatisticForm;
import com.osp.npo.app.viewhelper.ContractStatisticViewHelper;
import com.osp.npo.common.global.Constants;
import com.osp.npo.common.util.RelateDateTime;
import com.osp.npo.core.OrderField;
import com.osp.npo.service.ContractTotalService;

/**
 * <P>Contract Statistic Action</P>
 *
 * @author HungPT
 * @version $Revision: 27182 $
 */
@SuppressWarnings("unchecked")
public class ContractStatisticAction extends BaseMDAction {
    
    private static final String SUCCESS = "success";
    private static final String NOTARY_IN_DAY = "01";
    private static final String NOTARY_IN_WEEK = "02";
    private static final String NOTARY_IN_MONTH = "03";
    private static final String NOTARY_IN_YEAR = "04";
    private static final String NOTARY_IN_RANGE = "05";
    private static final String ORDER_FIELD_FIRST_NAME = "first_name";
    private static final String ORDER_FIELD_ORDER_NUMBER = "order_number";
    private static final String ROLE_NOTARY = "02";
    private static final String ROLE_DRAFTER = "03";
    private static final String FILE_NAME = "Thongke.xls";
    private static final String NOTARY_PLACE = "1";
    
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
        
        createTitle(Constants.SCREEN_CNTR011);
        
        ContractStatisticForm contractStatisticForm = (ContractStatisticForm)form;
        contractStatisticForm.setNotaryDateFromFilter("");
        contractStatisticForm.setNotaryDateToFilter("");
        
        HttpSession session = request.getSession();
        
        //delete session
        if (session.getAttribute(ContractStatisticViewHelper.SESSION_KEY) != null) {
            session.removeAttribute(ContractStatisticViewHelper.SESSION_KEY);
        }
        
        ContractStatisticViewHelper viewHelper = new ContractStatisticViewHelper();
        viewHelper.setNotaryDateFilter(NOTARY_IN_DAY);        
        
        //Set default filter
        Date date = Calendar.getInstance().getTime();
        String fromDate = RelateDateTime.toDayMonthYear(date);
        String toDate = RelateDateTime.toDayMonthYear(date);
        viewHelper.setNotaryDateFromFilter(fromDate);
        viewHelper.setNotaryDateToFilter(toDate);
       
        session.setAttribute(ContractStatisticViewHelper.SESSION_KEY, viewHelper);
        
        //Set total list into viewhelper
        setTotalList(session);
        
        return mapping.findForward(SUCCESS);
    }
    
    
    /**
     * <P>Action for statistics</P>
     * 
     * @author HungPT 
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */    
    public ActionForward statistics(ActionMapping mapping, ActionForm form, 
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        createTitle(Constants.SCREEN_CNTR011);
        
        ContractStatisticForm contractStatisticForm = (ContractStatisticForm)form;
        
        HttpSession session = request.getSession();
        
        ContractStatisticViewHelper viewHelper = (ContractStatisticViewHelper)session.getAttribute(ContractStatisticViewHelper.SESSION_KEY);
        
        viewHelper.reset(contractStatisticForm);
        
        String fromDate = null;
        String toDate = null;
        if (NOTARY_IN_DAY.equals(contractStatisticForm.getNotaryDateFilter())) {
            Date date = Calendar.getInstance().getTime();
            viewHelper.setNotaryDateFromFilter(RelateDateTime.toDayMonthYear(date));
            viewHelper.setNotaryDateToFilter(RelateDateTime.toDayMonthYear(date));
        }
        
        if (NOTARY_IN_WEEK.equals(contractStatisticForm.getNotaryDateFilter())) {
            Date date = Calendar.getInstance().getTime();
            fromDate = RelateDateTime.getDateByFirstDayOfWeek(date);
            toDate = RelateDateTime.getDateByLastDayOfWeek(date);
            viewHelper.setNotaryDateFromFilter(fromDate);            
            viewHelper.setNotaryDateToFilter(toDate);            
        }
        
        if (NOTARY_IN_MONTH.equals(contractStatisticForm.getNotaryDateFilter())) {
            Date date = Calendar.getInstance().getTime();
            fromDate = RelateDateTime.getDateByFirstDayOfMonth(date);
            toDate = RelateDateTime.getDateByLastDayOfMonth(date);
            viewHelper.setNotaryDateFromFilter(fromDate);            
            viewHelper.setNotaryDateToFilter(toDate);    
        }
        
        if (NOTARY_IN_YEAR.equals(contractStatisticForm.getNotaryDateFilter())) {
            Date date = Calendar.getInstance().getTime();
            fromDate = RelateDateTime.getDateByFirstDayOfYear(date);
            toDate = RelateDateTime.getDateByLastDayOfYear(date);
            viewHelper.setNotaryDateFromFilter(fromDate);            
            viewHelper.setNotaryDateToFilter(toDate);
        }
        
        if (NOTARY_IN_RANGE.equals(contractStatisticForm.getNotaryDateFilter())) {
        	viewHelper.setNotaryDateFromFilter(contractStatisticForm.getNotaryDateFromFilter()); 
        	viewHelper.setNotaryDateToFilter(contractStatisticForm.getNotaryDateToFilter());
        }
        
        //Set total list into viewhelper
        setTotalList(session);
        
        return mapping.findForward(SUCCESS);
    }
    
    /**
     * <P>Action for statistics</P>
     * 
     * @author HungPT 
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward exportExcel(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        HttpSession session = request.getSession();
        
        //Set total list into viewhelper
        setTotalList(session);
        
        CommonContext commonContext = (CommonContext)session.getAttribute(CommonContext.SESSION_KEY);
        ContractStatisticViewHelper contractStatisticViewHelper = (ContractStatisticViewHelper)session
            .getAttribute(ContractStatisticViewHelper.SESSION_KEY);
        
        ContractStatisticReport contractStatisticReport = new ContractStatisticReport();
        
        HSSFWorkbook workbook;
        if (NOTARY_PLACE.equals(commonContext.getContractNotaryPlace())) {
            workbook = contractStatisticReport.createWorkbook(contractStatisticViewHelper, commonContext);
        } else {
            workbook = contractStatisticReport.createWorkbook2(contractStatisticViewHelper, commonContext);
        }

        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=" + FILE_NAME);
        ServletOutputStream out = response.getOutputStream();
        workbook.write(out);
        out.flush();
        out.close();
        return null;            
    } 
   
    
    /**
     * Set total list into viewhelper
     * @param session
     * @throws SQLException
     * @throws IOException
     */
    private void setTotalList(HttpSession session) throws SQLException, IOException {
    	ContractStatisticViewHelper viewHelper = (ContractStatisticViewHelper)session.getAttribute(ContractStatisticViewHelper.SESSION_KEY);
    	
    	viewHelper.setNotaryDateDisp(viewHelper.getNotaryDateFilter());
    	viewHelper.setNotaryDateFromDisp(viewHelper.getNotaryDateFromFilter());
        viewHelper.setNotaryDateToDisp(viewHelper.getNotaryDateToFilter()); 
        
    	ContractTotalService contractTotalService = new ContractTotalService(getConnection());
    	contractTotalService.setNotaryDateFromFilter(RelateDateTime.toTimestamp(Boolean.TRUE, viewHelper.getNotaryDateFromFilter()));            
        contractTotalService.setNotaryDateToFilter(RelateDateTime.toTimestamp(Boolean.FALSE, viewHelper.getNotaryDateToFilter()));
    	
    	contractTotalService.addOrderFieldContractUserTotal(new OrderField(ORDER_FIELD_FIRST_NAME));
        
        //Total by notary
    	contractTotalService.setActiveFlgFilter(Boolean.TRUE);
        contractTotalService.setHiddenFlgFilter(Boolean.FALSE);
        contractTotalService.setRoleFilter(new String[]{ROLE_NOTARY});
        viewHelper.setListContractByNotary(contractTotalService.queryContractUserTotalByNotary().getList());
        
        //Total by Drafter
        contractTotalService.setRoleFilter(new String[]{ROLE_DRAFTER});
        viewHelper.setListContractByDrafter(contractTotalService.queryContractUserTotalByDrafter().getList());
        
        //Total by bank
        contractTotalService.addOrderFieldContractBankTotal(new OrderField(ORDER_FIELD_ORDER_NUMBER));
        viewHelper.setListContractByBank(contractTotalService.queryContractBankTotal().getList());
        
        viewHelper.setTotalContract(contractTotalService.countContract());
        viewHelper.setTotalErrorContract(contractTotalService.countErrorContract());
    }
}
