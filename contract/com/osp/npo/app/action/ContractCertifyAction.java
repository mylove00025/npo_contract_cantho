/**
 * 
 */
package com.osp.npo.app.action;

import java.util.Calendar;
import java.util.Date;

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
import com.osp.npo.app.export.ContractCertifyReport;
import com.osp.npo.app.form.ContractCertifyForm;
import com.osp.npo.app.message.MessageUtil;
import com.osp.npo.app.viewhelper.ContractCertifyViewHelper;
import com.osp.npo.common.global.Constants;
import com.osp.npo.common.util.EditString;
import com.osp.npo.common.util.RelateDateTime;
import com.osp.npo.core.OrderField;
import com.osp.npo.core.contract.ContractKindList;
import com.osp.npo.core.contract.ContractList;
import com.osp.npo.service.ContractCertifyService;
import com.osp.npo.service.ContractService;

/**
 * @author SonHD
 * @version $Revision: 29615 $
 */
@SuppressWarnings("unchecked")
public class ContractCertifyAction extends BaseMDAction {
    private static final String SUCCESS = "success";
    private static final String FAILURE = "failure";
    private static final String NOTARY_IN_DAY = "01";
    private static final String NOTARY_IN_MONTH = "03";
    private static final String NOTARY_IN_YEAR = "04";
    private static final String NOTARY_IN_RANGE = "05";
    private static final String FILE_NAME = "SoHDCC.xls";
    private static final String ORDER_FIELD_NOTARY_YEAR = "YEAR(nc.notary_date)";
    private static final String ORDER_FIELD_CONTRACT_NUMNER = "CAST(nc.contract_number AS UNSIGNED)";
    private static final String ORDER_FIELD_NOTARY_DATE = "nc.notary_date";

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
        
        createTitle(Constants.SCREEN_CNTR021);
        
        ContractCertifyForm contractCertifyForm = (ContractCertifyForm)form;
        contractCertifyForm.setNotaryDateFromFilter("");
        contractCertifyForm.setNotaryDateToFilter("");
        HttpSession session = request.getSession();
        
        //delete session
        if (session.getAttribute(ContractCertifyViewHelper.SESSION_KEY) != null) {
            session.removeAttribute(ContractCertifyViewHelper.SESSION_KEY);
        }
        
        ContractCertifyViewHelper viewHelper = new ContractCertifyViewHelper();
        viewHelper.setNotaryDateFilter(NOTARY_IN_MONTH);
        
        //set contract kind list
        ContractKindList contractKindList = new ContractService(getConnection()).queryAllContractKind(false);
        viewHelper.setContractKindList(contractKindList.getList());
    
        
        //Set default filter
        Calendar cal = Calendar.getInstance();
//        String fromDate = RelateDateTime.getDateByFirstDayOfMonth(cal.getTime());
//        String toDate = RelateDateTime.getDateByLastDayOfMonth(cal.getTime());
        String toDay = RelateDateTime.toDayMonthYear(cal.getTime());
        viewHelper.setNotaryDayFilter(toDay);
        viewHelper.setNotaryMonMonthFilter(Integer.toString(cal.get(Calendar.MONTH)+1));
        viewHelper.setNotaryMonYearFilter(Integer.toString(cal.get(Calendar.YEAR)));
        viewHelper.setNotaryYearFilter(Integer.toString(cal.get(Calendar.YEAR)));
//        viewHelper.reset(contractCertifyForm);
        session.setAttribute(ContractCertifyViewHelper.SESSION_KEY, viewHelper);
                
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
        
        ContractCertifyReport contractCertifyReport = new ContractCertifyReport();
        ContractCertifyForm contractForm = (ContractCertifyForm) form;
        ContractCertifyViewHelper contractCertifyViewHelper = (ContractCertifyViewHelper)session
            .getAttribute(ContractCertifyViewHelper.SESSION_KEY);
        ContractCertifyService contractService = new ContractCertifyService(getConnection());
        setViewHelper(contractCertifyViewHelper, contractForm);
        contractCertifyViewHelper.reset(contractForm);
        setSearchFilter(contractCertifyViewHelper, contractService);
        
        //HungPT 25/05/2014: change code for Can Tho
        CommonContext commonContext = (CommonContext) session.getAttribute(CommonContext.SESSION_KEY);
        contractService.setEntryUserIdFilter(commonContext.getUserInfo().getId());
        //End HungPT 25/05/2014
        
        MessageUtil messageUtil = new MessageUtil();
        if(!setSearchFilter(contractCertifyViewHelper, contractService)){
        	ActionErrors errors = new ActionErrors();
            //errors.add(messageUtil.createActionMessages("", request, "err_not_regular", "item_page"));
        	errors.add(messageUtil.createActionMessages("err_no_contract_kind"));
            this.addErrors(request, errors);
        	return mapping.findForward(FAILURE);
        }
        if (contractForm.getSortType()) {
        contractService.addOrderFieldContract(new OrderField(ORDER_FIELD_NOTARY_YEAR));
        contractService.addOrderFieldContract(new OrderField(ORDER_FIELD_CONTRACT_NUMNER));
        } else {
        	contractService.addOrderFieldContract(new OrderField(ORDER_FIELD_NOTARY_DATE));
        }
        contractCertifyViewHelper.setContractList(null);
        
        int totalCount = contractService.countTotalContract();
        contractCertifyViewHelper.setTotalCount(totalCount);
        if (totalCount != 0) {
            ContractList contractList = contractService.queryAllContract(false);
            contractCertifyViewHelper.setContractList(contractList.getList());
            
            HSSFWorkbook workbook = contractCertifyReport.createWorkbook(contractCertifyViewHelper.getContractList());
            
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
    private void setViewHelper(ContractCertifyViewHelper viewHelper, ContractCertifyForm form) {
        viewHelper.setNotaryDateFilter(form.getNotaryDateFilter());
        if(NOTARY_IN_DAY.equals(form.getNotaryDateFilter())) {
            viewHelper.setNotaryDayFilter(form.getNotaryDayFilter());
        }
        if(NOTARY_IN_MONTH.equals(form.getNotaryDateFilter())) {
            viewHelper.setNotaryMonMonthFilter(form.getNotaryMonMonthFilter());
            viewHelper.setNotaryMonYearFilter(form.getNotaryMonYearFilter());
        }
        if(NOTARY_IN_YEAR.equals(form.getNotaryDateFilter())) {
            viewHelper.setNotaryYearFilter(form.getNotaryYearFilter());
        }
        if (NOTARY_IN_RANGE.equals(form.getNotaryDateFilter())) {
            viewHelper.setNotaryDateFromFilter(form.getNotaryDateFromFilter());
            viewHelper.setNotaryDateToFilter(form.getNotaryDateToFilter());
        }
    }
    /**
     * <P>Set search filter</P>
     * 
     * @author SonHD 
     * @param context
     * @param service
     */
    private Boolean setSearchFilter(ContractCertifyViewHelper view, ContractCertifyService service) {
    	Boolean flg = true;
    	if (NOTARY_IN_DAY.equals(view.getNotaryDateFilter())) {
            if (EditString.isNull(view.getNotaryDayFilter())) {
                Date date = Calendar.getInstance().getTime();
                service.setNotaryDateFromFilter(RelateDateTime.toTimestamp(Boolean.TRUE, RelateDateTime.toDayMonthYear(date)));          
                service.setNotaryDateToFilter(RelateDateTime.toTimestamp(Boolean.FALSE, RelateDateTime.toDayMonthYear(date)));
            } else {
                service.setNotaryDateFromFilter(RelateDateTime.toTimestamp(Boolean.TRUE, view.getNotaryDayFilter()));          
                service.setNotaryDateToFilter(RelateDateTime.toTimestamp(Boolean.FALSE, view.getNotaryDayFilter()));
            }
        }
        if (NOTARY_IN_MONTH.equals(view.getNotaryDateFilter())) {
            Calendar cal = Calendar.getInstance();
            String month = Integer.toString(cal.get(Calendar.MONTH)+1);
            String year = Integer.toString(cal.get(Calendar.YEAR));
            if (!EditString.isNull(view.getNotaryMonMonthFilter())) {
                month = view.getNotaryMonMonthFilter();
            }
            if (!EditString.isNull(view.getNotaryMonYearFilter())) {
                year = view.getNotaryMonYearFilter();
            }
            String date = "01/" + month + "/" + year;
            
            String fromDate = RelateDateTime.getDateByFirstDayOfMonth(RelateDateTime.toDateTime(date));
            String toDate = RelateDateTime.getDateByLastDayOfMonth(RelateDateTime.toDateTime(date));
            
            service.setNotaryDateFromFilter(RelateDateTime.toTimestamp(Boolean.TRUE, fromDate));            
            service.setNotaryDateToFilter(RelateDateTime.toTimestamp(Boolean.FALSE, toDate));
        }
        
        if (NOTARY_IN_YEAR.equals(view.getNotaryDateFilter())) {
            Calendar cal = Calendar.getInstance();
            String year = Integer.toString(cal.get(Calendar.YEAR));
            if (!EditString.isNull(view.getNotaryYearFilter())) {
                year = view.getNotaryYearFilter();
            }
            String date = "01/" + Integer.toString(cal.get(Calendar.MONTH)+1) + "/" + year;
            
            String fromDate = RelateDateTime.getDateByFirstDayOfYear(RelateDateTime.toDateTime(date));
            String toDate = RelateDateTime.getDateByLastDayOfYear(RelateDateTime.toDateTime(date));
            service.setNotaryDateFromFilter(RelateDateTime.toTimestamp(Boolean.TRUE, fromDate));            
            service.setNotaryDateToFilter(RelateDateTime.toTimestamp(Boolean.FALSE, toDate));
        }
        
        if (NOTARY_IN_RANGE.equals(view.getNotaryDateFilter())) {
            service.setNotaryDateFromFilter(RelateDateTime.toTimestamp(Boolean.TRUE, view.getNotaryDateFromFilter())); 
            service.setNotaryDateToFilter(RelateDateTime.toTimestamp(Boolean.FALSE, view.getNotaryDateToFilter()));
        }
        
        if (view.getChkID() != null && view.getChkID().length > 0) {
        	service.setContractKindIdArrayFilter(view.getChkID());
        }
        else{
        	flg = false;
        	
        }
       return flg; 
    }
}
