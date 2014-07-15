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
import com.osp.npo.app.export.ContractStatisticByKindReport;
import com.osp.npo.app.form.ContractStatisticByKindForm;
import com.osp.npo.app.viewhelper.ContractStatisticByKindViewHelper;
import com.osp.npo.common.global.Constants;
import com.osp.npo.common.util.RelateDateTime;
import com.osp.npo.core.OrderField;
import com.osp.npo.core.contractTotal.ContractKindTotalInfo;
import com.osp.npo.service.ContractTotalService;

/**
 * <P>Contract Statistic By Kind Action</P>
 *
 * @author HungPT
 * @version $Revision: 18596 $
 */
@SuppressWarnings("unchecked")
public class ContractStatisticByKindAction extends BaseMDAction {
    
    private static final String SUCCESS = "success";
    private static final String NOTARY_IN_DAY = "01";
    private static final String NOTARY_IN_WEAK = "02";
    private static final String NOTARY_IN_MONTH = "03";
    private static final String NOTARY_IN_YEAR = "04";
    private static final String NOTARY_IN_RANGE = "05";
    private static final String ORDER_FIELD_ORDER_NUMBER = "order_number";
    private static final String ORDER_FIELD_TEMPLATE_NAME = "templateName";
    private static final String FILE_NAME = "BaocaotheonhomHD.xls";
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
        
        createTitle(Constants.SCREEN_CNTR019);
        
        ContractStatisticByKindForm contractStatisticByKindForm = (ContractStatisticByKindForm)form;
        contractStatisticByKindForm.setNotaryDateFromFilter("");
        contractStatisticByKindForm.setNotaryDateToFilter("");
        
        HttpSession session = request.getSession();
        
        //delete session
        if (session.getAttribute(ContractStatisticByKindViewHelper.SESSION_KEY) != null) {
            session.removeAttribute(ContractStatisticByKindViewHelper.SESSION_KEY);
        }
        
        ContractStatisticByKindViewHelper viewHelper = new ContractStatisticByKindViewHelper();
        viewHelper.setNotaryDateFilter(NOTARY_IN_MONTH);        
        
        //Set default filter
        Date date = Calendar.getInstance().getTime();
        String fromDate = RelateDateTime.getDateByFirstDayOfMonth(date);
        String toDate = RelateDateTime.getDateByLastDayOfMonth(date);
        viewHelper.setNotaryDateFromFilter(fromDate);
        viewHelper.setNotaryDateToFilter(toDate);
       
        session.setAttribute(ContractStatisticByKindViewHelper.SESSION_KEY, viewHelper);
        
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
        
        createTitle(Constants.SCREEN_CNTR019);
        
        ContractStatisticByKindForm contractStatisticByKindForm = (ContractStatisticByKindForm)form;
        
        HttpSession session = request.getSession();
        
        ContractStatisticByKindViewHelper viewHelper = (ContractStatisticByKindViewHelper)session
            .getAttribute(ContractStatisticByKindViewHelper.SESSION_KEY);
        
        viewHelper.reset(contractStatisticByKindForm);
        
        String fromDate = null;
        String toDate = null;
        if (NOTARY_IN_DAY.equals(contractStatisticByKindForm.getNotaryDateFilter())) {
            Date date = Calendar.getInstance().getTime();
            viewHelper.setNotaryDateFromFilter(RelateDateTime.toDayMonthYear(date));
            viewHelper.setNotaryDateToFilter(RelateDateTime.toDayMonthYear(date));
        }
        
        if (NOTARY_IN_WEAK.equals(contractStatisticByKindForm.getNotaryDateFilter())) {
            Date date = Calendar.getInstance().getTime();
            fromDate = RelateDateTime.getDateByFirstDayOfWeek(date);
            toDate = RelateDateTime.getDateByLastDayOfWeek(date);
            viewHelper.setNotaryDateFromFilter(fromDate);            
            viewHelper.setNotaryDateToFilter(toDate);            
        }
        
        if (NOTARY_IN_MONTH.equals(contractStatisticByKindForm.getNotaryDateFilter())) {
            Date date = Calendar.getInstance().getTime();
            fromDate = RelateDateTime.getDateByFirstDayOfMonth(date);
            toDate = RelateDateTime.getDateByLastDayOfMonth(date);
            viewHelper.setNotaryDateFromFilter(fromDate);            
            viewHelper.setNotaryDateToFilter(toDate);    
        }
        
        if (NOTARY_IN_YEAR.equals(contractStatisticByKindForm.getNotaryDateFilter())) {
            Date date = Calendar.getInstance().getTime();
            fromDate = RelateDateTime.getDateByFirstDayOfYear(date);
            toDate = RelateDateTime.getDateByLastDayOfYear(date);
            viewHelper.setNotaryDateFromFilter(fromDate);            
            viewHelper.setNotaryDateToFilter(toDate);
        }
        
        if (NOTARY_IN_RANGE.equals(contractStatisticByKindForm.getNotaryDateFilter())) {
        	viewHelper.setNotaryDateFromFilter(contractStatisticByKindForm.getNotaryDateFromFilter()); 
        	viewHelper.setNotaryDateToFilter(contractStatisticByKindForm.getNotaryDateToFilter());
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
        
        setTotalList(session);
        
        CommonContext commonContext = (CommonContext)session.getAttribute(CommonContext.SESSION_KEY);
        ContractStatisticByKindViewHelper contractStatisticByKindViewHelper = (ContractStatisticByKindViewHelper)session
            .getAttribute(ContractStatisticByKindViewHelper.SESSION_KEY);
        
        ContractStatisticByKindReport contractStatisticByKindReport = new ContractStatisticByKindReport();
        
        HSSFWorkbook workbook;
        if (NOTARY_PLACE.equals(commonContext.getContractNotaryPlace())) {
            workbook = contractStatisticByKindReport.createWorkbook(contractStatisticByKindViewHelper, commonContext);
        } else {
            workbook = contractStatisticByKindReport.createWorkbook2(contractStatisticByKindViewHelper, commonContext);
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
    	ContractStatisticByKindViewHelper viewHelper = (ContractStatisticByKindViewHelper)session
    	    .getAttribute(ContractStatisticByKindViewHelper.SESSION_KEY);
    	
    	viewHelper.setNotaryDateDisp(viewHelper.getNotaryDateFilter());
    	viewHelper.setNotaryDateFromDisp(viewHelper.getNotaryDateFromFilter());
        viewHelper.setNotaryDateToDisp(viewHelper.getNotaryDateToFilter());
        
    	ContractTotalService contractTotalService = new ContractTotalService(getConnection());
    	//contractTotalService.setActiveFlgTemplateFilter(Boolean.TRUE);
    	contractTotalService.setNotaryDateContractFromFilter(RelateDateTime.toTimestamp(Boolean.TRUE, viewHelper.getNotaryDateFromFilter()));
        contractTotalService.setNotaryDateContractToFilter(RelateDateTime.toTimestamp(Boolean.FALSE, viewHelper.getNotaryDateToFilter()));
    	
    	contractTotalService.addOrderFieldContractKindTotal(new OrderField(ORDER_FIELD_ORDER_NUMBER));
    	contractTotalService.addOrderFieldContractKindTotal(new OrderField(ORDER_FIELD_TEMPLATE_NAME));
    	
    	//loc bo nhung hop dong ngung su dung
    	contractTotalService.setActiveFlgTemplateFilter(true);
    	
        List<ContractKindTotalInfo> contractKindTotalList = contractTotalService.queryContractKindTotal().getList();
        
        Long kindId = 0L;
        Long numberOfContractByKind = 0L;
        Long numberOfInternalContractByKind = 0L;
        Long numberOfExternalContractByKind = 0L;
        Long numberOfInternalContract = 0L;
        Long numberOfExternalContract = 0L;
        Long numberOfContract = 0L;
        Integer index = 0;
        ContractKindTotalInfo contractKindTotalInfo;
        
        List<ContractKindTotalInfo> tempList = new ArrayList<ContractKindTotalInfo>();
        
        if (contractKindTotalList.size() > 0) {
            kindId = contractKindTotalList.get(0).getKindId();            
        }
        
        
        Long numberOfContractTemplateByKind = 1L;
        for (int i = 0; i < contractKindTotalList.size(); i++) {
            contractKindTotalInfo = contractKindTotalList.get(i);
            if (contractKindTotalList.size() == 1) {
                contractKindTotalInfo.setNumberOfTemplateByKind(numberOfContractTemplateByKind);
            }
            tempList.add(contractKindTotalInfo);
            
            numberOfContract += contractKindTotalInfo.getNumberOfContract();
            numberOfInternalContract += contractKindTotalInfo.getNumberOfInternalContract();
            numberOfExternalContract += contractKindTotalInfo.getNumberOfExternalContract();
            
            if (kindId.equals(contractKindTotalInfo.getKindId())) {
                numberOfContractByKind += contractKindTotalInfo.getNumberOfContract();
                numberOfInternalContractByKind += contractKindTotalInfo.getNumberOfInternalContract();                
                numberOfExternalContractByKind += contractKindTotalInfo.getNumberOfExternalContract();                
                numberOfContractTemplateByKind++;
            } else {
                
                if (i == 1) {
                    tempList.get(0).setNumberOfTemplateByKind(1L);
                }
                
                if (numberOfContractTemplateByKind > 2) {
                    ContractKindTotalInfo info = new ContractKindTotalInfo();
                    info.setKindId(kindId);
                    info.setKindName(contractKindTotalList.get(i - 1).getKindName());
                    info.setTemplateName("");
                    info.setNumberOfContract(numberOfContractByKind);
                    info.setNumberOfInternalContract(numberOfInternalContractByKind);
                    info.setNumberOfExternalContract(numberOfExternalContractByKind);
                    info.setNumberOfTemplateByKind(numberOfContractTemplateByKind);
                    
                    tempList.add(index, info);
                    
                    tempList.get(index + 1).setNumberOfTemplateByKind(0L);
                    
                }
                
                numberOfContractByKind = contractKindTotalInfo.getNumberOfContract();
                numberOfInternalContractByKind = contractKindTotalInfo.getNumberOfInternalContract();                
                numberOfExternalContractByKind = contractKindTotalInfo.getNumberOfExternalContract(); 
                numberOfContractTemplateByKind = 2L;
                
                contractKindTotalInfo.setNumberOfTemplateByKind(1L);
                
                index = tempList.size() - 1;
                
                kindId = contractKindTotalInfo.getKindId();
            }
            
            if ((i == contractKindTotalList.size() - 1) && numberOfContractTemplateByKind > 2) {
                
                    ContractKindTotalInfo info = new ContractKindTotalInfo();
                    info.setKindId(kindId);
                    info.setKindName(contractKindTotalList.get(i - 1).getKindName());
                    info.setTemplateName("");
                    info.setNumberOfContract(numberOfContractByKind);
                    info.setNumberOfInternalContract(numberOfInternalContractByKind);
                    info.setNumberOfExternalContract(numberOfExternalContractByKind);
                    info.setNumberOfTemplateByKind(numberOfContractTemplateByKind);
                    
                    tempList.add(index, info);
                    
                    tempList.get(index + 1).setNumberOfTemplateByKind(0L);
            }
        }
        
        viewHelper.setListContractByKind(tempList);
        viewHelper.setNumberOfContract(numberOfContract);
        viewHelper.setNumberOfInternalContract(numberOfInternalContract);
        viewHelper.setNumberOfExternalContract(numberOfExternalContract);
        
    }
}
