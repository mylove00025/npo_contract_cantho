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
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.osp.npo.app.context.CommonContext;
import com.osp.npo.app.context.ContractContext;
import com.osp.npo.app.export.ContractListByKindReport;
import com.osp.npo.app.form.ContractListByKindForm;
import com.osp.npo.app.message.MessageUtil;
import com.osp.npo.app.viewhelper.ContractListByKindViewHelper;
import com.osp.npo.app.viewhelper.ContractStatisticByKindViewHelper;
import com.osp.npo.common.global.Constants;
import com.osp.npo.common.util.EditString;
import com.osp.npo.common.util.RelateDateTime;
import com.osp.npo.core.OrderField;
import com.osp.npo.core.OrderField.OrderType;
import com.osp.npo.core.contract.ContractKindInfo;
import com.osp.npo.core.contract.ContractList;
import com.osp.npo.service.ContractByKindService;
import com.osp.npo.service.ContractKindService;

/**
 * @author SonHD
 * @version $Revision: 29615 $
 *
 */

public class ContractListByKindAction extends BaseMDAction {
    private static final String SUCCESS = "success";
    private static final Integer FIRST_PAGE = 1;
    private static final String NOTARY_DATE_IN_DAY = "01";
    private static final String NOTARY_DATE_IN_WEEK = "02";
    private static final String NOTARY_DATE_IN_MONTH = "03";
    private static final String NOTARY_DATE_IN_YEAR = "04";
    private static final String NOTARY_DATE_IN_RANGE = "05";
    private static final String FILE_NAME = "BaocaoHDCC.xls";
    private static final String ORDER_FIELD_CONTRACT_NUMNER = "CAST(nc.contract_number AS UNSIGNED)";
    private static final String ORDER_FIELD_NOTARY_YEAR = "YEAR(nc.notary_date)";
    private static final String KIND_ID = "kindid";

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

        createTitle(Constants.SCREEN_CNTR024);

        HttpSession session = request.getSession();

        //delete session
        if (session.getAttribute(ContractListByKindViewHelper.SESSION_KEY) != null) {
            session.removeAttribute(ContractListByKindViewHelper.SESSION_KEY);
        }

        if (session.getAttribute(ContractContext.SESSION_KEY) != null) {
            session.removeAttribute(ContractContext.SESSION_KEY);
        }

        ContractContext contractContext = new ContractContext();
        session.setAttribute(ContractContext.SESSION_KEY, contractContext);
        ContractKindService contractKindService = new ContractKindService(getConnection());
        ContractListByKindViewHelper contractListByKindViewHelper = new ContractListByKindViewHelper();
        ContractListByKindForm contractListByKindForm = (ContractListByKindForm)form;

        //default search
        Long kindId = (long) 0;
        if(request.getParameter(KIND_ID) != null) {
            kindId = Long.parseLong(request.getParameter(KIND_ID));
            contractListByKindViewHelper.setContractKindIdFilter(kindId);
            contractContext.setContractKindIdFilter(kindId);
        }

        ContractStatisticByKindViewHelper contractStatisticByKindViewHelper = (ContractStatisticByKindViewHelper)session
            .getAttribute(ContractStatisticByKindViewHelper.SESSION_KEY);
        if (contractStatisticByKindViewHelper != null) {
            contractContext.setNotaryDateFilter(contractStatisticByKindViewHelper.getNotaryDateFilter());
            contractContext.setNotaryDateFromFilter(contractStatisticByKindViewHelper.getNotaryDateFromFilter());
            contractContext.setNotaryDateToFilter(contractStatisticByKindViewHelper.getNotaryDateToFilter());
        }

        setViewHelper(contractListByKindViewHelper, contractContext);
        saveDataContractList(contractListByKindViewHelper, contractContext, null);
        contractListByKindViewHelper.setContractKindTree(contractKindService.getContractKindTree(false, null));

        ContractKindInfo contractKindInfo = contractKindService.queryContractKindInfoById(kindId, false);
        if(contractKindInfo != null) {
            contractListByKindViewHelper.setContractKindNameFilter(contractKindInfo.getName());
        }
        if ((contractListByKindViewHelper.getContractList() == null) || (contractListByKindViewHelper.getContractList().size()<=0)) {
            MessageUtil mu = new MessageUtil();
            saveMessages(request, mu.createActionMessages("", request, "msg_data_not_exist", "item_contract"));
        }
        //contractListByKindViewHelper.reset(contractListByKindForm);
        contractListByKindForm.setContractKindIdFilter(kindId);

        session.setAttribute(ContractListByKindViewHelper.SESSION_KEY, contractListByKindViewHelper);

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
    @SuppressWarnings("unchecked")
    private void saveDataContractList(ContractListByKindViewHelper contractListByKindViewHelper, ContractContext context, String direction)
        throws SQLException, IOException {

        ContractByKindService contractService = new ContractByKindService(getConnection());

        //set search filter
        setSearchFilter(context, contractService);
        contractService.setContractTemplateActiveFlgFilter(true);

        contractListByKindViewHelper.setContractList(null);

        Integer totalCount = contractService.countTotalContract();
        contractListByKindViewHelper.setTotalCount(totalCount);

        if (totalCount != 0) {
            Integer totalPage = pageCalculation(totalCount, getLineMax());
            contractListByKindViewHelper.setTotalPage(totalPage);
            contractListByKindViewHelper.setPage(pageTransition(direction, contractListByKindViewHelper.getPage(), totalPage));
            contractService.addOrderFieldContract(new OrderField(ORDER_FIELD_NOTARY_YEAR, OrderType.DESC));
            contractService.addOrderFieldContract(new OrderField(ORDER_FIELD_CONTRACT_NUMNER, OrderType.DESC));
            ContractList contractList = contractService.queryContract(false, contractListByKindViewHelper.getPage(), getLineMax());
            contractListByKindViewHelper.setContractList(contractList.getList());
        }
    }
    /**
     * <P>Set search filter</P>
     *
     * @author SonHD
     * @param context
     * @param service
     */
    private void setSearchFilter(ContractContext context, ContractByKindService service) {

        if (context.getContractKindIdFilter() != null && context.getContractKindIdFilter() != 0L) {
            service.setContractKindIdFilter(context.getContractKindIdFilter());
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

        ContractListByKindForm contractListByKindForm = (ContractListByKindForm)form;

        HttpSession session = request.getSession();
        ContractListByKindViewHelper contractListByKindViewHelper = (ContractListByKindViewHelper)session.getAttribute(ContractListByKindViewHelper.SESSION_KEY);
        ContractContext contractContext = (ContractContext)session.getAttribute(ContractContext.SESSION_KEY);

        if (contractListByKindViewHelper != null && contractContext != null) {
            contractListByKindViewHelper.reset(contractListByKindForm);
            contractContext.clear();
            setContext(contractContext, contractListByKindForm);
            contractListByKindViewHelper.setPage(FIRST_PAGE);
            saveDataContractList(contractListByKindViewHelper, contractContext, null);
        }
        if (contractListByKindViewHelper.getTotalCount() == 0) {
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

        ContractListByKindForm contractListByKindForm = (ContractListByKindForm)form;

        HttpSession session = request.getSession();
        ContractListByKindViewHelper contractListByKindViewHelper = (ContractListByKindViewHelper)session.getAttribute(ContractListByKindViewHelper.SESSION_KEY);
        ContractContext contractContext = (ContractContext)session.getAttribute(ContractContext.SESSION_KEY);

        if (contractListByKindViewHelper != null && contractContext != null) {
            saveDataContractList(contractListByKindViewHelper, contractContext, contractListByKindForm.getDirection());
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
        ContractListByKindViewHelper contractListByKindViewHelper = (ContractListByKindViewHelper)session.getAttribute(ContractListByKindViewHelper.SESSION_KEY);
        ContractContext contractContext = (ContractContext)session.getAttribute(ContractContext.SESSION_KEY);

        if (contractListByKindViewHelper != null && contractContext != null) {
            setViewHelper(contractListByKindViewHelper, contractContext);
            saveDataContractList(contractListByKindViewHelper, contractContext, null);
        }

        return mapping.findForward(SUCCESS);
    }
    /**
     * This is the Struts action method called on
     * http://.../actionPath?method=myAction2,
     * where "method" is the value specified in <action> element :
     * ( <action parameter="method" .../> )
     */
    @SuppressWarnings("unchecked")
    public ActionForward exportExcel(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        HttpSession session = request.getSession();
        CommonContext commonContext = (CommonContext)session.getAttribute(CommonContext.SESSION_KEY);
        ContractListByKindViewHelper contractListByKindViewHelper = (ContractListByKindViewHelper)session.getAttribute(ContractListByKindViewHelper.SESSION_KEY);
        ContractContext contractContext = (ContractContext)session.getAttribute(ContractContext.SESSION_KEY);
        //ContractListByKindForm contractListByKindForm = (ContractListByKindForm)form;
        //contractListByKindViewHelper.reset(contractListByKindForm);
        if (EditString.isNull(contractContext.getNotaryDateFilter())) {
            ActionErrors errors = new ActionErrors();
            errors.add(new MessageUtil().createActionMessages("", request, "err_not_input_data", "item_notary_date"));
            saveErrors(request, errors);
            return mapping.findForward(SUCCESS);
        } else {
            ContractListByKindReport contractExcelCreator = new ContractListByKindReport();
            setViewHelper(contractListByKindViewHelper, contractContext);

            ContractByKindService contractService = new ContractByKindService(getConnection());

            //set search filter
            setSearchFilter(contractContext, contractService);

            Integer totalCount = contractService.countTotalContract();
            contractListByKindViewHelper.setTotalCount(totalCount);

            if (totalCount != 0) {
                contractService.addOrderFieldContract(new OrderField(ORDER_FIELD_NOTARY_YEAR));
                contractService.addOrderFieldContract(new OrderField(ORDER_FIELD_CONTRACT_NUMNER));
                ContractList contractList = contractService.queryAllContract(false);
                HSSFWorkbook workbook = contractExcelCreator.createWorkbook(contractList.getList(), contractListByKindViewHelper,
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
    /**
     * <P>Set data from contract context to contract view helper</P>
     *
     * @author SonHD
     * @param viewHelper
     * @param context
     */
    private void setViewHelper(ContractListByKindViewHelper viewHelper, ContractContext context) {
        viewHelper.setNotaryDateFilter(context.getNotaryDateFilter());
        viewHelper.setNotaryDateFromFilter(context.getNotaryDateFromFilter());
        viewHelper.setNotaryDateToFilter(context.getNotaryDateToFilter());
        viewHelper.setContractKindIdFilter(context.getContractKindIdFilter());
    }
    /**
     * <P>Set data for contract context</P>
     *
     * @author SonHD
     * @param context
     * @param form
     */
    private void setContext(ContractContext context, ContractListByKindForm form) {
        context.setContractKindIdFilter(form.getContractKindIdFilter());
        context.setNotaryDateFilter(form.getNotaryDateFilter());
        if (NOTARY_DATE_IN_RANGE.equals(form.getNotaryDateFilter())) {
            context.setNotaryDateFromFilter(form.getNotaryDateFromFilter());
            context.setNotaryDateToFilter(form.getNotaryDateToFilter());
        }
    }
}
