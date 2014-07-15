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
import com.osp.npo.app.context.ContractByUserListContext;
import com.osp.npo.app.context.ContractContext;
import com.osp.npo.app.export.ContractByUserReport;
import com.osp.npo.app.form.ContractByUserListForm;
import com.osp.npo.app.message.MessageUtil;
import com.osp.npo.app.viewhelper.ContractByUserListViewHelper;
import com.osp.npo.app.viewhelper.ContractListViewHelper;
import com.osp.npo.common.global.Constants;
import com.osp.npo.common.util.RelateDateTime;
import com.osp.npo.core.OrderField;
import com.osp.npo.core.OrderField.OrderType;
import com.osp.npo.service.ContractByDrafterService;
import com.osp.npo.service.UserService;
import com.osp.npo.core.contract.ContractList;

/**
 * <P>Contract Action</P>
 *
 * @author KienLT
 * @version $Revision: 29615 $
 */
@SuppressWarnings("unchecked")
public class ContractByUserListAction extends BaseMDAction {
    public static final String NOTARY_IN_WEEK = "00";
    public static final String NOTARY_IN_DAY = "01";
    public static final String NOTARY_IN_MONTH = "02";
    public static final String NOTARY_IN_YEAR = "03";
    public static final String NOTARY_IN_RANGE = "04";
    private static final String DRAFTER_ROLE = "03";
    private static final String SUCCESS = "success";
    private static final Integer FIRST_PAGE = 1;
    private static final String FILE_NAME = "DSHopDongTheoChuyenVienSoanThao.xls";
    private static final String ORDER_FIELD_DRAFTER_FIRST_NAME = "drafter_first_name";
    private static final String ORDER_FIELD_DRAFTER_FAMILY_NAME = "drafter_family_name";
    private static final String ORDER_FIELD_NOTARY_YEAR = "YEAR(nc.notary_date)";
    private static final String ORDER_FIELD_CONTRACT_NUMNER = "CAST(nc.contract_number AS UNSIGNED) ";
    private static final String ORDER_FIELD_USER = "first_name";

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

        createTitle(Constants.SCREEN_CNTR007);

        HttpSession session = request.getSession();

        //delete session
        if (session.getAttribute(ContractByUserListViewHelper.SESSION_KEY) != null) {
            session.removeAttribute(ContractByUserListViewHelper.SESSION_KEY);
        }

        if (session.getAttribute(ContractByUserListContext.SESSION_KEY) != null) {
            session.removeAttribute(ContractByUserListContext.SESSION_KEY);
        }

        ContractByUserListContext context = new ContractByUserListContext();
        ContractByUserListForm f = (ContractByUserListForm) form;
        ContractByUserListViewHelper view = new ContractByUserListViewHelper();
        UserService userService = new UserService(getConnection());

        // Set default value for first view
        userService.setHiddenFlgFilter(Boolean.FALSE);
        userService.addOrderFieldUser(new OrderField(ORDER_FIELD_USER));
        userService.setRoleFilter(new String[] { DRAFTER_ROLE });
        view.setUserList(userService.queryAllUser(false).getList());

        view.setSearchDate(NOTARY_IN_MONTH);
        view.setCheckAllValue(Boolean.TRUE);
        //default search
        f.setSearchDate(NOTARY_IN_MONTH);
        f.setUserList(view.getUserList());
        setContext(context, f);
        view.setPage(FIRST_PAGE);
        saveDataContractByUserList(view, context, null);
        if (view.getTotalCount() == 0) {
            view.setTotalPage(0);
            view.setContractList(null);
            MessageUtil mu = new MessageUtil();
            saveMessages(request, mu.createActionMessages("", request, "msg_data_not_exist", "item_contract"));
        }
        request.getSession().setAttribute(ContractByUserListViewHelper.SESSION_KEY, view);
        request.getSession().setAttribute(ContractByUserListContext.SESSION_KEY, context);

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

        ContractByUserListForm f = (ContractByUserListForm)form;
        HttpSession session = request.getSession();
        ContractByUserListViewHelper view = (ContractByUserListViewHelper)
            session.getAttribute(ContractByUserListViewHelper.SESSION_KEY);
        ContractByUserListContext context = (ContractByUserListContext)
            session.getAttribute(ContractByUserListContext.SESSION_KEY);

        if (view != null && context != null) {
            saveDataContractByUserList(view, context, f.getDirection());
        }

        return mapping.findForward(SUCCESS);
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

        ContractByUserListForm f = (ContractByUserListForm)form;

        HttpSession session = request.getSession();
        ContractByUserListViewHelper view = (ContractByUserListViewHelper)
            session.getAttribute(ContractByUserListViewHelper.SESSION_KEY);
        ContractByUserListContext context = (ContractByUserListContext)
            session.getAttribute(ContractByUserListContext.SESSION_KEY);

        if (view != null && context != null) {
            view.reset(f);
            context.clear();
            setContext(context, f);
            view.setPage(FIRST_PAGE);
            if (context.getSelectedUserIDList().length > 0) {
                saveDataContractByUserList(view, context, null);
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

        return mapping.findForward(SUCCESS);
    }

    /**
     * <P>Set data for contract context</P>
     *
     * @author KienLT
     * @param context
     * @param form
     */
    private void setContext(ContractByUserListContext context, ContractByUserListForm form) {
        context.setSearchDate(form.getSearchDate());
        context.setFromDate(form.getFromDate());
        context.setToDate(form.getToDate());
        context.setSelectedUserIDList(form.getSelectedUserList());
        context.setCheckAllValue(form.getCheckAllValue());
        context.setSelectedUserID(form.getSelectedUserID());
    }

    /**
     * <P>Save Contract Data to View Helper</P>
     *
     * @author KienLT
     * @param preventListViewHelper
     * @param context
     * @param direction
     */
    private void saveDataContractByUserList(ContractByUserListViewHelper view, ContractByUserListContext context, String direction)
        throws SQLException, IOException {

        ContractByDrafterService contractService = new ContractByDrafterService(getConnection());

        //set search filter
        setSearchFilter(context, contractService);

        view.setContractList(null);

        int totalCount = contractService.countTotalContract();
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
            ContractList contractList = contractService.queryContract(false, view.getPage(), getLineMax());
            view.setContractList(contractList.getList());
        }
    }

    /**
     * <P>Set search filter</P>
     *
     * @author KienLT
     * @param context
     * @param service
     */
    private void setSearchFilter(ContractByUserListContext context, ContractByDrafterService service) {
        if (NOTARY_IN_DAY.equals(context.getSearchDate())) {
            Date date = Calendar.getInstance().getTime();
            service.setNotaryDateFromFilter(RelateDateTime.toTimestamp(Boolean.TRUE, RelateDateTime.toDayMonthYear(date)));
            service.setNotaryDateToFilter(RelateDateTime.toTimestamp(Boolean.FALSE, RelateDateTime.toDayMonthYear(date)));
        }

        if (NOTARY_IN_MONTH.equals(context.getSearchDate())) {
            Date date = Calendar.getInstance().getTime();
            service.setNotaryDateFromFilter(RelateDateTime.toTimestamp(Boolean.TRUE, RelateDateTime.getDateByFirstDayOfMonth(date)));
            service.setNotaryDateToFilter(RelateDateTime.toTimestamp(Boolean.FALSE, RelateDateTime.getDateByLastDayOfMonth(date)));
        }

        if (NOTARY_IN_YEAR.equals(context.getSearchDate())) {
            Date date = Calendar.getInstance().getTime();
            service.setNotaryDateFromFilter(RelateDateTime.toTimestamp(Boolean.TRUE, RelateDateTime.getDateByFirstDayOfYear(date)));
            service.setNotaryDateToFilter(RelateDateTime.toTimestamp(Boolean.FALSE, RelateDateTime.getDateByLastDayOfYear(date)));
        }

        if (NOTARY_IN_RANGE.equals(context.getSearchDate())) {
            service.setNotaryDateFromFilter(RelateDateTime.toTimestamp(true, context.getFromDate()));
            service.setNotaryDateToFilter(RelateDateTime.toTimestamp(false, context.getToDate()));
        }
        if (NOTARY_IN_WEEK.equals(context.getSearchDate())) {
            Date date = Calendar.getInstance().getTime();
            service.setNotaryDateFromFilter(RelateDateTime.toTimestamp(Boolean.TRUE, RelateDateTime.getDateByFirstDayOfWeek(date)));
            service.setNotaryDateToFilter(RelateDateTime.toTimestamp(Boolean.FALSE, RelateDateTime.getDateByLastDayOfWeek(date)));
        }
//        if (context.getSelectedUserIDList() != null && context.getSelectedUserIDList().length > 0) {
//            service.setDraftUserIdListFilter(context.getSelectedUserIDList());
//        }
        service.setDrafterIdFlagFilter(Boolean.TRUE);
        if (context.getSelectedUserID() != null && context.getSelectedUserID() != 0L) {
            service.setDrafterIdFilter(context.getSelectedUserID());
        }
    }

    /**
     * Action for Export Excel file
     *
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
        ContractByUserListViewHelper view = (ContractByUserListViewHelper)
            session.getAttribute(ContractByUserListViewHelper.SESSION_KEY);
        ContractByUserListContext context = (ContractByUserListContext)
            session.getAttribute(ContractByUserListContext.SESSION_KEY);
        CommonContext commonContext = (CommonContext)
            session.getAttribute(CommonContext.SESSION_KEY);
        ContractByDrafterService contractService = new ContractByDrafterService(getConnection());

        //set search filter
        setSearchFilter(context, contractService);
        int totalCount = contractService.countTotalContract();
        view.setTotalCount(totalCount);

        view.setContractList(null);
        if (totalCount != 0) {
            int totalPage = pageCalculation(totalCount, getLineMax());
            view.setTotalPage(totalPage);
            view.setPage(pageTransition(null, view.getPage(), totalPage));
            contractService.addOrderFieldContract(new OrderField(ORDER_FIELD_DRAFTER_FIRST_NAME));
            contractService.addOrderFieldContract(new OrderField(ORDER_FIELD_DRAFTER_FAMILY_NAME));
            contractService.addOrderFieldContract(new OrderField(ORDER_FIELD_NOTARY_YEAR));
            contractService.addOrderFieldContract(new OrderField(ORDER_FIELD_CONTRACT_NUMNER));
            ContractList lstContractInfo = contractService.queryContract(false, view.getPage(), getLineMax());
            view.setContractList(lstContractInfo.getList());
            
            ContractList contractList = contractService.queryAllContract(false);

            ContractByUserReport contractByUserExcelCreator = new ContractByUserReport();
            HSSFWorkbook workbook = contractByUserExcelCreator.createWorkbook(contractList.getList(), context, commonContext);

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
        ContractByUserListViewHelper contractListViewHelper = (ContractByUserListViewHelper)session.getAttribute(ContractListViewHelper.SESSION_KEY);
        ContractByUserListContext contractContext = (ContractByUserListContext)session.getAttribute(ContractContext.SESSION_KEY);

        if (contractListViewHelper != null && contractContext != null) {
            setViewHelper(contractListViewHelper, contractContext);
            saveDataContractByUserList(contractListViewHelper, contractContext, null);
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
    private void setViewHelper(ContractByUserListViewHelper viewHelper, ContractByUserListContext context) {
        viewHelper.setCheckAllValue(context.getCheckAllValue());
        viewHelper.setSearchDate(context.getSearchDate());
        if (NOTARY_IN_RANGE.equals(context.getSearchDate())) {
            viewHelper.setFromDate(context.getFromDate());
            viewHelper.setToDate(context.getToDate());
        }
        viewHelper.setSelectedUserList(context.getSelectedUserIDList());
    }
}
