package com.osp.npo.app.action;

import java.io.IOException;
import java.sql.SQLException;
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
import com.osp.npo.app.context.ContractByBankListContext;
import com.osp.npo.app.export.ContractByBankReport;
import com.osp.npo.app.form.ContractByBankListForm;
import com.osp.npo.app.message.MessageUtil;
import com.osp.npo.app.viewhelper.ContractByBankListViewHelper;
import com.osp.npo.common.global.Constants;
import com.osp.npo.common.util.RelateDateTime;
import com.osp.npo.core.OrderField;
import com.osp.npo.core.OrderField.OrderType;
import com.osp.npo.core.basicData.BankInfo;
import com.osp.npo.core.basicData.BankList;
import com.osp.npo.core.contract.ContractList;
import com.osp.npo.service.BasicDataService;
import com.osp.npo.service.ContractByBankService;

/**
 *
 * Contract By Bank List Action
 *
 * @author GiangVT
 * @version $Revision: 29615 $
 */
public class ContractByBankListAction extends BaseMDAction {

    public static final String CONTRACT_IN_WEEK = "00";
    public static final String CONTRACT_IN_DAY = "01";
    public static final String CONTRACT_IN_MONTH = "02";
    public static final String CONTRACT_IN_YEAR = "03";
    public static final String CONTRACT_IN_RANGE = "04";
    public static final String NOTARY_IN_ALL = "05";
    public static final String SUCCESS_PATH = "success";
    public static final String FAILURE_PATH = "failure";
    public static final Integer FIRST_PAGE = 1;
    public static final String FILE_NAME = "BaocaoHDCCtheoNganhang.xls";
    public static final String SPACE = " ";
    private static final String ORDER_FIELD_BANK_ORDER_NUMBER = "nb.order_number";
    private static final String ORDER_FIELD_CONTRACT_NUMNER = "CAST(nc.contract_number AS UNSIGNED)";
    private static final String ORDER_FIELD_NOTARY_YEAR = "YEAR(nc.notary_date)";

    /**
     *
     * Action for first view
     *
     * @author GiangVT
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return view page
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public ActionForward view(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {

        createTitle(Constants.SCREEN_CNTR009);

        request.getSession().removeAttribute(ContractByBankListViewHelper.SESSION_KEY);
        request.getSession().removeAttribute(ContractByBankListContext.SESSION_KEY);
        ContractByBankListViewHelper view = new ContractByBankListViewHelper();
        ContractByBankListContext context = new ContractByBankListContext();
        ContractByBankListForm contractForm = (ContractByBankListForm)form;
        BasicDataService basicDataService = new BasicDataService(getConnection());
        basicDataService.addOrderFieldBank(new OrderField("order_number",OrderType.ASC));
        BankList lstBank = basicDataService.queryAllBank(false);
        List<BankInfo> lstBankInfo = lstBank.getList();
        String[] bankIdArray = new String[lstBank.size()];

        for (int i = 0; i < lstBank.size(); i++) {
            bankIdArray[i] = lstBank.get(i).getId().toString();
        }

        view.setBankList(lstBankInfo);
        contractForm.setBankList(lstBankInfo);

        view.setSelectedBankList(bankIdArray);
        contractForm.setSelectedBankList(bankIdArray);

        context.setSelectedBankIdList(bankIdArray);

        view.setSearchDate(CONTRACT_IN_MONTH);
        view.setCheckAllValue(Boolean.TRUE);
        contractForm.setSearchDate(CONTRACT_IN_MONTH);
        context.setSearchDate(CONTRACT_IN_MONTH);

        view.setPage(FIRST_PAGE);

        if (bankIdArray.length > 0) {
            saveDataList(view, context, null);
            if (view.getTotalCount() == 0) {
                MessageUtil mu = new MessageUtil();
                saveMessages(request, mu.createActionMessages("", request, "msg_data_not_exist", "item_contract"));
            }
        } else {
            view.setTotalPage(0);
            view.setContractList(null);
            MessageUtil mu = new MessageUtil();
            saveMessages(request, mu.createActionMessages("", request, "msg_data_not_exist", "item_contract"));
        }

        request.getSession().setAttribute(ContractByBankListContext.SESSION_KEY, context);
        request.getSession().setAttribute(ContractByBankListViewHelper.SESSION_KEY, view);

        return mapping.findForward(SUCCESS_PATH);
    }

    /**
     *
     * search action
     *
     * @author GiangVT
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return view page
     * @throws Exception
     */
    public ActionForward search(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {

        ContractByBankListForm contractForm = (ContractByBankListForm)form;
        ContractByBankListContext context = (ContractByBankListContext)request.getSession().getAttribute(ContractByBankListContext.SESSION_KEY);
        ContractByBankListViewHelper view = (ContractByBankListViewHelper)request.getSession().
                                                        getAttribute(ContractByBankListViewHelper.SESSION_KEY);

        if (view != null && context != null) {
            view.reset(contractForm);
            context.clear();
            setContext(context, contractForm);
            view.setPage(FIRST_PAGE);
            if (context.getSelectedBankIdList().length > 0) {
                saveDataList(view, context, null);
            } else {
                view.setTotalPage(0);
                view.setContractList(null);
                MessageUtil mu = new MessageUtil();
                saveMessages(request, mu.createActionMessages("", request, "msg_data_not_exist", "item_contract"));
            }
        }

        if (view.getTotalCount() == 0) {
            MessageUtil mu = new MessageUtil();
            saveMessages(request, mu.createActionMessages("", request, "msg_data_not_exist", "item_contract"));
        }
        return mapping.findForward(SUCCESS_PATH);
    }

    /**
     *
     * paging redirection
     *
     * @author GiangVT
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return view page
     * @throws Exception
     */
    public ActionForward paging(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        ContractByBankListForm contractForm = (ContractByBankListForm)form;
        ContractByBankListViewHelper view = (ContractByBankListViewHelper)session.getAttribute(ContractByBankListViewHelper.SESSION_KEY);
        ContractByBankListContext context = (ContractByBankListContext)session.getAttribute(ContractByBankListContext.SESSION_KEY);

        if (context != null && view != null) {
            saveDataList(view, context, contractForm.getDirection());
        }
        return mapping.findForward(SUCCESS_PATH);
    }

    /**
     *
     * report action
     *
     * @author GiangVT
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return view
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public ActionForward report(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        ContractByBankListContext context = (ContractByBankListContext)session.getAttribute(ContractByBankListContext.SESSION_KEY);
        CommonContext commonContext = (CommonContext)session.getAttribute(CommonContext.SESSION_KEY);
        ContractByBankService contractService = new ContractByBankService(getConnection());
        ContractByBankListViewHelper view = (ContractByBankListViewHelper)session.getAttribute(ContractByBankListViewHelper.SESSION_KEY);
        setSearchFilter(context, contractService);
        contractService.addOrderFieldContract(new OrderField(ORDER_FIELD_BANK_ORDER_NUMBER, OrderType.ASC));
        contractService.addOrderFieldContract(new OrderField(ORDER_FIELD_NOTARY_YEAR, OrderType.ASC));
        contractService.addOrderFieldContract(new OrderField(ORDER_FIELD_CONTRACT_NUMNER, OrderType.ASC));

        view.setSearchDate(context.getSearchDate());
        view.setFromDate(context.getFromDate());
        view.setToDate(context.getToDate());
        view.setSelectedBankList(context.getSelectedBankIdList());

        int totalCount = contractService.countTotalContract();
        view.setTotalCount(totalCount);

        view.setContractList(null);
        if (totalCount != 0) {
            int totalPage = pageCalculation(totalCount, getLineMax());
            view.setTotalPage(totalPage);
            view.setPage(pageTransition(null, view.getPage(), totalPage));
            ContractList lstContractInfo = contractService.queryContract(false, view.getPage(), getLineMax());
            view.setContractList(lstContractInfo.getList());
        } else {
            MessageUtil mu = new MessageUtil();
            saveMessages(request, mu.createActionMessages("", request, "msg_data_not_exist", "item_contract"));
            return mapping.findForward(SUCCESS_PATH);
        }

        ContractList contractList = contractService.queryAllContract(false);

        ContractByBankReport contractByBankExcelCreator = new ContractByBankReport();
        HSSFWorkbook workbook = contractByBankExcelCreator.createWorkbook(contractList.getList(), context, commonContext);

        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=" + FILE_NAME);
        ServletOutputStream out = response.getOutputStream();
        workbook.write(out);
        out.flush();
        out.close();
        return null;
    }

    /**
     *
     * back action
     *
     * @author GiangVT
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return CNTR005 page from current page
     * @throws Exception
     */
    public ActionForward back(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        createTitle(Constants.SCREEN_CNTR005);
        HttpSession session = request.getSession();
        ContractByBankListContext context = (ContractByBankListContext)session.getAttribute(ContractByBankListContext.SESSION_KEY);
        ContractByBankListViewHelper view = (ContractByBankListViewHelper)session.getAttribute(ContractByBankListViewHelper.SESSION_KEY);

        view.setSearchDate(context.getSearchDate());
        view.setFromDate(context.getFromDate());
        view.setToDate(context.getToDate());
        view.setSelectedBankList(context.getSelectedBankIdList());
        // page number has in view session

        saveDataList(view, context, null);
        return mapping.findForward(SUCCESS_PATH);
    }


    /**
     *
     * save data to view
     *
     * @author GiangVT
     * @param view
     * @param context
     * @param direction
     * @throws SQLException
     * @throws IOException
     */
    @SuppressWarnings("unchecked")
    private void saveDataList(ContractByBankListViewHelper view, ContractByBankListContext context, String direction)
        throws SQLException, IOException {

        ContractByBankService service = new ContractByBankService(getConnection());
        setSearchFilter(context, service);
        service.addOrderFieldContract(new OrderField(ORDER_FIELD_BANK_ORDER_NUMBER, OrderType.ASC));
        service.addOrderFieldContract(new OrderField(ORDER_FIELD_NOTARY_YEAR, OrderType.DESC));
        service.addOrderFieldContract(new OrderField(ORDER_FIELD_CONTRACT_NUMNER, OrderType.DESC));

        int totalCount = service.countTotalContract();
        view.setTotalCount(totalCount);
        view.setSelectedBankList(context.getSelectedBankIdList());

        view.setContractList(null);
        if (totalCount != 0) {
            int totalPage = pageCalculation(totalCount, getLineMax());
            view.setTotalPage(totalPage);
            view.setPage(pageTransition(direction, view.getPage(), totalPage));
            ContractList lstContractInfo = service.queryContract(false, view.getPage(), getLineMax());
            view.setContractList(lstContractInfo.getList());
        }
    }

    /**
     *
     * Set filter condition from context to service
     *
     * @author GiangVT
     * @param context
     * @param service
     */
    public void setSearchFilter(ContractByBankListContext context, ContractByBankService service) {
        Date date = Calendar.getInstance().getTime();
        if (CONTRACT_IN_DAY.equals(context.getSearchDate())) {
            service.setNotaryDateFromFilter(RelateDateTime.toTimestamp(Boolean.TRUE, RelateDateTime.toDayMonthYear(date)));
            service.setNotaryDateToFilter(RelateDateTime.toTimestamp(Boolean.FALSE, RelateDateTime.toDayMonthYear(date)));
        } else if (CONTRACT_IN_MONTH.equals(context.getSearchDate())) {
            service.setNotaryDateFromFilter(RelateDateTime.toTimestamp(Boolean.TRUE, RelateDateTime.getDateByFirstDayOfMonth(date)));
            service.setNotaryDateToFilter(RelateDateTime.toTimestamp(Boolean.FALSE, RelateDateTime.getDateByLastDayOfMonth(date)));
        } else if (CONTRACT_IN_YEAR.equals(context.getSearchDate())) {
            service.setNotaryDateFromFilter(RelateDateTime.toTimestamp(Boolean.TRUE, RelateDateTime.getDateByFirstDayOfYear(date)));
            service.setNotaryDateToFilter(RelateDateTime.toTimestamp(Boolean.FALSE, RelateDateTime.getDateByLastDayOfYear(date)));
        } else if (CONTRACT_IN_RANGE.equals(context.getSearchDate())) {
            service.setNotaryDateFromFilter(RelateDateTime.toTimestamp(true, context.getFromDate()));
            service.setNotaryDateToFilter(RelateDateTime.toTimestamp(false, context.getToDate()));
        } else if (CONTRACT_IN_WEEK.equals(context.getSearchDate())) {
            service.setNotaryDateFromFilter(RelateDateTime.toTimestamp(Boolean.TRUE, RelateDateTime.getDateByFirstDayOfWeek(date)));
            service.setNotaryDateToFilter(RelateDateTime.toTimestamp(Boolean.FALSE, RelateDateTime.getDateByLastDayOfWeek(date)));
        }
        if (context.getBankIdFilter() != null && context.getBankIdFilter() > 0) {
            service.setBankIdFilter(context.getBankIdFilter());
        } else {
            service.setBankIdNullFilter(Boolean.FALSE);
        }
    }

    /**
     *
     * Set context
     *
     * @author GiangVT
     * @param context
     * @param form
     */
    private void setContext(ContractByBankListContext context, ContractByBankListForm form) {
        context.setSearchDate(form.getSearchDate());
        context.setFromDate(form.getFromDate());
        context.setToDate(form.getToDate());
        context.setBankList(form.getBankList());
        context.setSelectedBankIdList(form.getSelectedBankList());
        context.setBankIdFilter(form.getBankIdFilter());
    }
}
