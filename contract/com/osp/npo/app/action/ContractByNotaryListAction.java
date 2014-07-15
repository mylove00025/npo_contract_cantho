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
import com.osp.npo.app.context.ContractByNotaryListContext;
import com.osp.npo.app.export.ContractByNotaryReport;
import com.osp.npo.app.form.ContractByNotaryListForm;
import com.osp.npo.app.message.MessageUtil;
import com.osp.npo.app.viewhelper.ContractByNotaryListViewHelper;
import com.osp.npo.common.global.Constants;
import com.osp.npo.common.util.RelateDateTime;
import com.osp.npo.core.OrderField;
import com.osp.npo.core.OrderField.OrderType;
import com.osp.npo.core.contract.ContractKindListForNotary;
import com.osp.npo.core.contract.ContractList;
import com.osp.npo.core.user.UserInfo;
import com.osp.npo.core.user.UserList;
import com.osp.npo.service.ContractByNotaryService;
import com.osp.npo.service.ContractKindService;
import com.osp.npo.service.UserService;

/**
 *
 * Contract By Notary List
 *
 * @author GiangVT
 * @version $Revision: 29900 $
 */
public class ContractByNotaryListAction extends BaseMDAction {

    public static final String NOTARY_IN_WEEK = "00";
    public static final String NOTARY_IN_DAY = "01";
    public static final String NOTARY_IN_MONTH = "02";
    public static final String NOTARY_IN_YEAR = "03";
    public static final String NOTARY_IN_RANGE = "04";
    public static final String NOTARY_IN_ALL = "05";
    public static final String NOTARY_ROLE = "02";
    public static final String SUCCESS_PATH = "success";
    public static final String FAILURE_PATH = "failure";
    public static final Integer FIRST_PAGE = 1;
    public static final String FILE_NAME = "BaocaoHDCCtheoCCV.xls";
    private static final String ORDER_FIELD_NOTARY_FIRST_NAME = "notary_first_name";
    private static final String ORDER_FIELD_NOTARY_FAMILY_NAME = "notary_family_name";
    private static final String ORDER_FIELD_CONTRACT_NUMNER = "CAST(nc.contract_number AS UNSIGNED)";
    private static final String ORDER_FIELD_NOTARY_YEAR = "YEAR(nc.notary_date)";
    private static final String SUCCESS = "success";


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

        createTitle(Constants.SCREEN_CNTR005);

        request.getSession().removeAttribute(ContractByNotaryListViewHelper.SESSION_KEY);
        request.getSession().removeAttribute(ContractByNotaryListContext.SESSION_KEY);
        ContractByNotaryListViewHelper view = new ContractByNotaryListViewHelper();
        ContractByNotaryListContext context = new ContractByNotaryListContext();
        ContractByNotaryListForm contractForm = (ContractByNotaryListForm)form;
        UserService userService = new UserService(getConnection());

        userService.setRoleFilter(new String[] { NOTARY_ROLE });
        userService.setActiveFlgFilter(Boolean.TRUE);
        userService.setHiddenFlgFilter(Boolean.FALSE);
        userService.addOrderFieldUser(new OrderField("first_name", OrderType.ASC));
        UserList lstUser = userService.queryAllUser(false);

        List<UserInfo> lstUserInfo = lstUser.getList();
        String[] lstSelectedUserInfoId = new String[lstUser.size()];

        for (int i = 0; i < lstUser.size(); i++) {
            lstSelectedUserInfoId[i] = (lstUser.get(i).getId().toString());
        }

        view.setNotaryList(lstUserInfo);
        contractForm.setNotaryList(lstUserInfo);

        view.setSelectedNotaryList(lstSelectedUserInfoId);
        contractForm.setSelectedNotaryList(lstSelectedUserInfoId);
        context.setSelectedNotaryIdList(lstSelectedUserInfoId);

        view.setSearchDate(NOTARY_IN_MONTH);
        view.setCheckAllValue(Boolean.TRUE);
        contractForm.setSearchDate(NOTARY_IN_MONTH);

        setContext(context, contractForm);

        view.setPage(FIRST_PAGE);

        if (lstSelectedUserInfoId.length > 0) {
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

        request.getSession().setAttribute(ContractByNotaryListContext.SESSION_KEY, context);
        request.getSession().setAttribute(ContractByNotaryListViewHelper.SESSION_KEY, view);

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

        ContractByNotaryListForm contractForm = (ContractByNotaryListForm)form;

        ContractByNotaryListViewHelper view = (ContractByNotaryListViewHelper)request.getSession().getAttribute(ContractByNotaryListViewHelper.SESSION_KEY);
        ContractByNotaryListContext context = (ContractByNotaryListContext)request.getSession().getAttribute(ContractByNotaryListContext.SESSION_KEY);
        if (view != null && context != null) {
            view.reset(contractForm);
            context.clear();
            setContext(context, contractForm);
            view.setPage(FIRST_PAGE);
            if (context.getSelectedNotaryIdList().length > 0) {
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
        ContractByNotaryListForm contractForm = (ContractByNotaryListForm)form;
        ContractByNotaryListViewHelper view = (ContractByNotaryListViewHelper)session.getAttribute(ContractByNotaryListViewHelper.SESSION_KEY);
        ContractByNotaryListContext context = (ContractByNotaryListContext)session.getAttribute(ContractByNotaryListContext.SESSION_KEY);

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
        ContractByNotaryListContext context = (ContractByNotaryListContext)session.getAttribute(ContractByNotaryListContext.SESSION_KEY);
        CommonContext commonContext = (CommonContext)session.getAttribute(CommonContext.SESSION_KEY);
        ContractByNotaryListViewHelper view = (ContractByNotaryListViewHelper)session.getAttribute(ContractByNotaryListViewHelper.SESSION_KEY);
        ContractByNotaryService contractService = new ContractByNotaryService(getConnection());

        view.setSearchDate(context.getSearchDate());
        view.setFromDate(context.getFromDate());
        view.setToDate(context.getToDate());
        view.setSelectedNotaryList(context.getSelectedNotaryIdList());

        // set search filter
        setSearchFilter(context, contractService);
        contractService.addOrderFieldContract(new OrderField(ORDER_FIELD_NOTARY_FIRST_NAME, OrderType.ASC));
        contractService.addOrderFieldContract(new OrderField(ORDER_FIELD_NOTARY_FAMILY_NAME, OrderType.ASC));
        contractService.addOrderFieldContract(new OrderField(ORDER_FIELD_NOTARY_YEAR, OrderType.ASC));
        contractService.addOrderFieldContract(new OrderField(ORDER_FIELD_CONTRACT_NUMNER, OrderType.ASC));

        int totalCount = contractService.countTotalContract();
        view.setTotalCount(totalCount);

        if (totalCount != 0) {
            int totalPage = pageCalculation(totalCount, getLineMax());
            view.setTotalPage(totalPage);
            view.setPage(pageTransition(null, view.getPage(), totalPage));
            ContractList lstContractInfo = contractService.queryContract(false, view.getPage(), getLineMax());
            view.setContractList(lstContractInfo.getList());
            
            ContractList contractList = contractService.queryAllContract(false);

            ContractByNotaryReport contractByNotaryExcelCreator = new ContractByNotaryReport();
            HSSFWorkbook workbook = contractByNotaryExcelCreator.createWorkbook(contractList.getList(), context, commonContext);

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
            view.setContractList(null);
            return mapping.findForward(SUCCESS_PATH);
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
    @SuppressWarnings("unchecked")
	public ActionForward exportUserExcel(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        HttpSession session = request.getSession();
        ContractByNotaryListContext context = (ContractByNotaryListContext)
            session.getAttribute(ContractByNotaryListContext.SESSION_KEY);
        CommonContext commonContext = (CommonContext)
            session.getAttribute(CommonContext.SESSION_KEY);
        ContractByNotaryService contractService = new ContractByNotaryService(getConnection());
        

        //set search filter
        setSearchFilter(context, contractService);
        int totalCount = contractService.countTotalContract();
       
        if (totalCount == 0) {
            MessageUtil mu = new MessageUtil();
            saveMessages(request, mu.createActionMessages("", request, "msg_data_not_exist", "item_contract"));
            return mapping.findForward(SUCCESS);
        }
        
        ContractKindService contractKindService = new ContractKindService(getConnection());
        int totalKind = contractKindService.countTotalContractKind();
        UserService userService = new UserService(getConnection());
        String[] role = new String[1];
        role[0]="02";
        userService.setRoleFilter(role);
        int totalUser = userService.countTotalUserByFilter();
        ContractKindListForNotary contractKindList = new ContractKindListForNotary();
        contractKindList.setTotalKind(totalKind);
        contractKindList.setTotalUser(totalUser);
        contractKindList.setUserList(userService.queryAllUser(false).getList());
        contractKindList.setContractKindList(contractKindService.queryAllContractKind(false).getList());

        contractKindList = contractService.queryUserReport(contractKindList, false);
        
        Long totalCost91 = contractService.queryTotalCostTT91();
        
        contractService.setNotaryPlaceFilter(false);
        contractKindList = contractService.queryNotaryPlace(contractKindList, false);
        
        ContractByNotaryReport contractByNotaryExcelCreator = new ContractByNotaryReport();
        HSSFWorkbook workbook = contractByNotaryExcelCreator.createWorkbook2(contractKindList, context, commonContext, totalCost91);

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
        ContractByNotaryListContext context = (ContractByNotaryListContext)session.getAttribute(ContractByNotaryListContext.SESSION_KEY);
        ContractByNotaryListViewHelper view = (ContractByNotaryListViewHelper)session.getAttribute(ContractByNotaryListViewHelper.SESSION_KEY);

        view.setSearchDate(context.getSearchDate());
        view.setFromDate(context.getFromDate());
        view.setToDate(context.getToDate());
        view.setSelectedNotaryList(context.getSelectedNotaryIdList());
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
    private void saveDataList(ContractByNotaryListViewHelper view, ContractByNotaryListContext context, String direction)
        throws SQLException, IOException {

        ContractByNotaryService service = new ContractByNotaryService(getConnection());
        setSearchFilter(context, service);

        service.addOrderFieldContract(new OrderField(ORDER_FIELD_NOTARY_FIRST_NAME, OrderType.ASC));
        service.addOrderFieldContract(new OrderField(ORDER_FIELD_NOTARY_FAMILY_NAME, OrderType.ASC));
        service.addOrderFieldContract(new OrderField(ORDER_FIELD_NOTARY_YEAR, OrderType.DESC));
        service.addOrderFieldContract(new OrderField(ORDER_FIELD_CONTRACT_NUMNER, OrderType.DESC));

        int totalCount = service.countTotalContract();
        view.setTotalCount(totalCount);
        view.setSelectedNotaryList(context.getSelectedNotaryIdList());

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
    public void setSearchFilter(ContractByNotaryListContext context, ContractByNotaryService service) {

        Date date = Calendar.getInstance().getTime();
        if (NOTARY_IN_DAY.equals(context.getSearchDate())) {
            service.setNotaryDateFromFilter(RelateDateTime.toTimestamp(Boolean.TRUE, RelateDateTime.toDayMonthYear(date)));
            service.setNotaryDateToFilter(RelateDateTime.toTimestamp(Boolean.FALSE, RelateDateTime.toDayMonthYear(date)));
        } else if (NOTARY_IN_MONTH.equals(context.getSearchDate())) {
            service.setNotaryDateFromFilter(RelateDateTime.toTimestamp(Boolean.TRUE, RelateDateTime.getDateByFirstDayOfMonth(date)));
            service.setNotaryDateToFilter(RelateDateTime.toTimestamp(Boolean.FALSE, RelateDateTime.getDateByLastDayOfMonth(date)));
        } else if (NOTARY_IN_YEAR.equals(context.getSearchDate())) {
            service.setNotaryDateFromFilter(RelateDateTime.toTimestamp(Boolean.TRUE, RelateDateTime.getDateByFirstDayOfYear(date)));
            service.setNotaryDateToFilter(RelateDateTime.toTimestamp(Boolean.FALSE, RelateDateTime.getDateByLastDayOfYear(date)));
        } else if (NOTARY_IN_RANGE.equals(context.getSearchDate())) {
            service.setNotaryDateFromFilter(RelateDateTime.toTimestamp(Boolean.TRUE, context.getFromDate()));
            service.setNotaryDateToFilter(RelateDateTime.toTimestamp(Boolean.FALSE, context.getToDate()));
        } else if (NOTARY_IN_WEEK.equals(context.getSearchDate())) {
            service.setNotaryDateFromFilter(RelateDateTime.toTimestamp(Boolean.TRUE, RelateDateTime.getDateByFirstDayOfWeek(date)));
            service.setNotaryDateToFilter(RelateDateTime.toTimestamp(Boolean.FALSE, RelateDateTime.getDateByLastDayOfWeek(date)));
        }
        if(context.getNotaryIdFilter() != null && context.getNotaryIdFilter() > 0) {
            service.setNotaryIdFilter(context.getNotaryIdFilter());
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
    private void setContext(ContractByNotaryListContext context, ContractByNotaryListForm form) {
        context.setSearchDate(form.getSearchDate());
        context.setFromDate(form.getFromDate());
        context.setToDate(form.getToDate());
        context.setNotaryList(form.getNotaryList());
        context.setSelectedNotaryIdList(form.getSelectedNotaryList());
        context.setNotaryIdFilter(form.getNotaryIdFilter());
    }
}
