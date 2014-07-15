package com.osp.npo.app.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.osp.npo.app.message.MessageUtil;
import com.osp.npo.app.context.UserEditContext;
import com.osp.npo.app.context.UserListContext;
import com.osp.npo.app.form.UserListForm;
import com.osp.npo.app.viewhelper.UserListViewHelper;
import com.osp.npo.common.global.Constants;
import com.osp.npo.common.global.Constants.FilterKind;
import com.osp.npo.common.util.SystemMessageProperties;
import com.osp.npo.core.OrderField;
import com.osp.npo.core.user.RoleList;
import com.osp.npo.core.user.UserList;
import com.osp.npo.service.UserService;
import com.osp.npo.core.user.RoleInfo;

/**
 * User List Action
 *
 * @author KienLT
 * @author GiangVT
 * @version $Revision: 17783 $
 */
@SuppressWarnings("unchecked")
public class UserListAction extends BaseMDAction {

    private static final String ACTIVEFLG_TYPE_ALL = "00";
    private static final String ACTIVEFLG_TYPE_INACTIVE = "02";
    private static final String ROLE_TYPE_ALL = "00";
    private static final String SUCCESS = "success";
    private static final String FAILURE = "failure";
    private static final String ITEM_ALL = "item_all";
    private static final Integer FIRST_PAGE = 1;
    private static final String ORDER_FIELD = "account";


    /**
     * View action
     *
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return success page
     * @throws Exception
     */
    public ActionForward view(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {

        createTitle(Constants.SCREEN_ADM001);

        UserListViewHelper userListViewHelper = new UserListViewHelper();
        UserListContext userListContext = new UserListContext();
        userListContext.reset();

        // load list role
        UserService userService = new UserService(getConnection());
        RoleList roleList = userService.queryAllRole(false);
        RoleInfo allRI = new RoleInfo();
        allRI.setCode(ROLE_TYPE_ALL);
        allRI.setName(SystemMessageProperties.getSystemProperty(ITEM_ALL));
        roleList.add(allRI, 0);
        userListViewHelper.setRoleList(roleList.getList());

        setUserList(userListViewHelper, userListContext, null);

        request.getSession().setAttribute(UserListContext.SESSION_KEY, userListContext);
        request.getSession().setAttribute(UserListViewHelper.SESSION_KEY, userListViewHelper);

        return mapping.findForward(SUCCESS);
    }


    /**
     * Search action
     *
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward search(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {

        UserListContext userListContext = getListContext(request);

        UserListForm userListForm = (UserListForm)form;

        userListContext.reset();
        setContext(userListContext, userListForm);

        UserListViewHelper userListViewHelper = (UserListViewHelper) request.getSession().getAttribute(UserListViewHelper.SESSION_KEY);
        userListViewHelper.reset(userListForm);
        userListViewHelper.setPage(FIRST_PAGE);
        setUserList(userListViewHelper, userListContext, null);

        if (userListViewHelper.getTotalCount() == 0) {
            MessageUtil mu = new MessageUtil();
            saveMessages(request, mu.createActionMessages("", request, "msg_data_not_exist", "item_user"));
        }

        return mapping.findForward(SUCCESS);
    }

    /**
     * Paging action
     *
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward page(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {

        UserListContext context = getListContext(request);
        UserListForm f = (UserListForm)form;

        UserListViewHelper userListViewHelper = (UserListViewHelper) request.getSession().getAttribute(UserListViewHelper.SESSION_KEY);
        userListViewHelper.reset(f);

        setUserList(userListViewHelper, context, f.getDirection());

        return mapping.findForward(SUCCESS);
    }

    /**
     * Back action
     *
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward back(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {

        UserListContext context = getListContext(request);
        UserListViewHelper userListViewHelper = (UserListViewHelper) request.getSession().getAttribute(UserListViewHelper.SESSION_KEY);

        setUserList(userListViewHelper, context, null);

        return mapping.findForward(SUCCESS);
    }

    /**
     * Select user action
     *
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward select(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        UserListForm f = (UserListForm)form;

        UserEditContext context = new UserEditContext();
        int id = f.getId();
        context.setId(id);

        UserService userService = new UserService(getConnection());
        userService.setUsidFilter((long)id);
        UserList userList = userService.queryAllUser(false);
        if (userList.size() == 0) {
            ActionErrors errors = new ActionErrors();
            errors.add(new MessageUtil().createActionMessages("", request, "err_not_exist", "item_user"));
            saveErrors(request, errors);
            return mapping.findForward(FAILURE);
        }

        request.getSession().setAttribute(UserEditContext.SESSION_KEY, context);

        return mapping.findForward(SUCCESS);
    }

    /**
     * Set user list to viewhelper
     *
     * @param viewHelper
     * @param context
     * @param direction
     * @throws SQLException
     * @throws IOException
     */
    private void setUserList(UserListViewHelper viewHelper, UserListContext context, String direction)
            throws SQLException, IOException {
        UserService userService = new UserService(getConnection());

        // Set filter condition
        setSearchFilter(context, userService);

        viewHelper.setList(null);

        int totalCount = userService.countTotalUserByFilter();
        viewHelper.setTotalCount(totalCount);

        if (totalCount > 0) {
            int totalPage = pageCalculation(totalCount, getLineMax());
            viewHelper.setTotalPage(totalPage);
            viewHelper.setPage(pageTransition(direction, viewHelper.getPage(), totalPage));
            userService.addOrderFieldUser(new OrderField(ORDER_FIELD));
            UserList userList = userService.queryUser(false, viewHelper.getPage(), getLineMax());
            viewHelper.setList(userList.getList());
        }
    }


    /**
     * Set filter to service
     *
     * @param context
     * @param userService
     */
    private void setSearchFilter(UserListContext context, UserService userService) {
        if (context.getFamilyName() != null) {
            userService.setFamilyNameFilter(context.getFamilyName(), FilterKind.MIDDLE);
        }
        if (context.getFirstName() != null) {
            userService.setFirstNameFilter(context.getFirstName(), FilterKind.MIDDLE);
        }
        if (context.getAccount() != null) {
            userService.setAccountIdFilter(context.getAccount(), FilterKind.MIDDLE);
        }
        if (context.getRole() != null) {
            userService.setRoleFilter(new String[]{context.getRole()});
        }
        if (context.getActiveFlg() != null) {
            userService.setActiveFlgFilter(context.getActiveFlg());
        }
        if (context.getHiddenFlg() != null) {
            userService.setHiddenFlgFilter(context.getHiddenFlg());
        }
    }

    /**
     * Set data from Form to Context
     *
     * @param context
     * @param form
     */
    private void setContext(UserListContext context, UserListForm form) {
        // loc ho dem
        context.setFamilyName(form.getFamilyName());
        // loc ten
        context.setFirstName(form.getFirstName());
        // loc tai khoan dang nhap
        context.setAccount(form.getAccount());
        // loc chuc vu
        String role = form.getRole();
        if (!ROLE_TYPE_ALL.equals(role)) {
            context.setRole(role);
        } else {
            context.setRole(null);
        }

        // loc trang thai hoat dong
        String activeFlg = form.getActiveFlg();
        if (!ACTIVEFLG_TYPE_ALL.equals(activeFlg)) {
            Boolean isActive = true;
            if (ACTIVEFLG_TYPE_INACTIVE.equals(activeFlg)) {
                isActive = false;
            }
            context.setActiveFlg(isActive);
        } else {
            context.setActiveFlg(null);
        }
    }

    /**
     *
     * @param request
     * @return
     */
    private UserListContext getListContext(HttpServletRequest request) {

        HttpSession session = request.getSession();
        UserListContext context = (UserListContext) session
                .getAttribute(UserListContext.SESSION_KEY);

        if (context == null) {
            context = new UserListContext();

            session.setAttribute(UserListContext.SESSION_KEY, context);
        }

        return context;
    }

}
