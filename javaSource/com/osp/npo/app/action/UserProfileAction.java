package com.osp.npo.app.action;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;

import com.osp.npo.app.context.CommonContext;
import com.osp.npo.app.form.UserProfileForm;
import com.osp.npo.app.message.MessageUtil;
import com.osp.npo.common.util.Crypter;
import com.osp.npo.common.util.SystemProperties;
import com.osp.npo.core.user.UserInfo;
import com.osp.npo.service.UserService;

/**
 *
 * Change information of login user
 *
 * @author Giangvt
 * @version Revision:
 */
public class UserProfileAction extends BaseMDAction  {

    public static final String SUCCESS_PATH = "success";
    public static final String FAILURE_PATH = "failure";
    private static final String MALE = "0";
    private static final String FEMALE = "1";
    public static final String NO_LOGIN = "nologin";

    /**
     *
     * First view of page COM004.jsp
     *
     * @author Giangvt
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return ActionForward
     * @throws ServletException
     * @throws SQLException
     * @throws Exception
     */
    public ActionForward view(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, SQLException, Exception {

        CommonContext context = (CommonContext)request.getSession().getAttribute(CommonContext.SESSION_KEY);
        if (context == null) {
            mapping.findForward(NO_LOGIN);
        }

        createTitle("COM004");
        // get information
        UserProfileForm userProfileForm = (UserProfileForm)form;
        CommonContext commonContext = (CommonContext) request.getSession().getAttribute(CommonContext.SESSION_KEY);
        UserInfo userInfo = commonContext.getUserInfo();

        // commit data to user interface
        userProfileForm.setFamilyName(userInfo.getFamilyName());
        userProfileForm.setFirstName(userInfo.getFirstName());
        userProfileForm.setAccount(userInfo.getAccount());
        userProfileForm.setBirthday(userInfo.getBirthday());
        if(userInfo.getSex()) {
            userProfileForm.setSex("0");
        } else {
            userProfileForm.setSex("1");
        }
        userProfileForm.setAddress(userInfo.getAddress());
        userProfileForm.setEmail(userInfo.getEmail());
        userProfileForm.setTelephone(userInfo.getTelephone());
        userProfileForm.setMobile(userInfo.getMobile());
        userProfileForm.setRole(userInfo.getRole());
        return mapping.findForward(SUCCESS_PATH);
    }

    /**
     *
     * Update user profile information
     *
     * @author Giangvt
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return ActionForward
     * @throws ServletException
     * @throws SQLException
     * @throws Exception
     */
    public ActionForward update(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, SQLException, Exception {
        UserProfileForm userProfileForm = (UserProfileForm)form;

        // save data
        CommonContext commonContext = (CommonContext) request.getSession().getAttribute(CommonContext.SESSION_KEY);
        UserInfo userInfo = commonContext.getUserInfo();
        userInfo.setAddress(userProfileForm.getAddress());
        userInfo.setBirthday(userProfileForm.getBirthday());
        userInfo.setEmail(userProfileForm.getEmail());
        userInfo.setFamilyName(userProfileForm.getFamilyName());
        userInfo.setFirstName(userProfileForm.getFirstName());
        userInfo.setMobile(userProfileForm.getMobile());

        // check user change password
        if(userProfileForm.getIsChangePassword()) {
            // validate logic again
            if(userProfileForm.getNewPassword().equals(userProfileForm.getRetypePassword())) {
                userInfo.setPassword(Crypter.crypt(userProfileForm.getNewPassword()));
            }
        }

        // check user's sex
        if(MALE.equals(userProfileForm.getSex())) {
            userInfo.setSex(Boolean.TRUE);
        } else {
            userInfo.setSex(Boolean.FALSE);
        }
        userInfo.setTelephone(userProfileForm.getTelephone());
        userInfo.setUpdateDateTime(new Timestamp(Calendar.getInstance().getTime().getTime()));
        userInfo.setUpdateUserId(userInfo.getId());
        userInfo.setUpdateUserName(userInfo.getAccount());

        // update user info to session
        commonContext.setUserInfo(userInfo);

        // update data base
        UserService userService = new UserService(getConnection());
        userService.modifyUser(userInfo);
        getConnection().commit();
        ActionMessages messages = new ActionMessages();
        messages.add(new MessageUtil().createActionMessages("", request, "msg_update_success", SystemProperties.getProperty("item_user")));
        this.addMessages(request, messages);
        return mapping.findForward(SUCCESS_PATH);
    }
}
