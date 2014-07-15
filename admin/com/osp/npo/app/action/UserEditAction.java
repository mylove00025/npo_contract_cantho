package com.osp.npo.app.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;

import com.osp.npo.app.context.CommonContext;
import com.osp.npo.app.context.UserEditContext;
import com.osp.npo.app.form.UserEditForm;
import com.osp.npo.app.message.MessageUtil;
import com.osp.npo.app.viewhelper.UserEditViewHelper;
import com.osp.npo.common.global.Constants;
import com.osp.npo.common.util.Crypter;
import com.osp.npo.core.user.RoleList;
import com.osp.npo.core.user.UserAuthorityInfo;
import com.osp.npo.core.user.UserAuthorityList;
import com.osp.npo.core.user.UserInfo;
import com.osp.npo.core.user.UserList;
import com.osp.npo.service.ContractService;
import com.osp.npo.service.UserService;

/**
 * <P>Action for User Edit</P>
 *
 * @author KienLT
 * @author GiangVT
 * @version $Revision: 25477 $
 */
@SuppressWarnings("unchecked")
public class UserEditAction extends BaseMDAction {
    private static final String SUCCESS = "success";
    private static final String FAILURE = "failure";
    private static final String NPO_CONTRACT = "npo_contract";
    private static final String NPO_CONTRACT_NOTARY_ID = "notary_id";
    private static final String NPO_CONTRACT_DRAFTER_ID = "drafter_id";

    /**
     * <P>Action for first view</P>
     *
     * @author KienLT
     * @author GiangVT
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward view(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {

        createTitle(Constants.SCREEN_ADM003);

        request.getSession().removeAttribute(UserEditViewHelper.SESSION_KEY);
        UserEditViewHelper userEditViewHelper = new UserEditViewHelper();

        UserService userService = new UserService(getConnection());

        UserEditContext context = (UserEditContext)
            request.getSession().getAttribute(UserEditContext.SESSION_KEY);
        int id = context.getId();

        //load danh sach chuc vu
        RoleList roleList = userService.queryAllRole(false);
        userEditViewHelper.setRoleList(roleList.getList());

        //khoi tao trang thai hoat dong
        UserEditForm f = (UserEditForm)form;
        f.setActiveFlg(true);

        //Lay thong tin nguoi dung
        userService.setUsidFilter((long)id);
        UserList userList = userService.queryAllUser(false);
        if (userList.size() == 0) {
            ActionErrors errors = new ActionErrors();
            errors.add(new MessageUtil().createActionMessages("", request, "err_not_exist", "item_user"));
            saveErrors(request, errors);
            return mapping.findForward(FAILURE);
        }

        UserInfo userInfo = (UserInfo) userList.get(0);

        userEditViewHelper.setId(id);
        userEditViewHelper.setFamilyName(userInfo.getFamilyName());
        userEditViewHelper.setFirstName(userInfo.getFirstName());
        userEditViewHelper.setAccount(userInfo.getAccount());
        userEditViewHelper.setBirthday(userInfo.getBirthday());
        userEditViewHelper.setSex(userInfo.getSex());
        userEditViewHelper.setAddress(userInfo.getAddress());
        userEditViewHelper.setEmail(userInfo.getEmail());
        userEditViewHelper.setTelephone(userInfo.getTelephone());
        userEditViewHelper.setMobile(userInfo.getMobile());
        userEditViewHelper.setRole(userInfo.getRole());
        userEditViewHelper.setActiveFlg(userInfo.getActiveFlg());

        CommonContext commonContext = (CommonContext)
            request.getSession().getAttribute(CommonContext.SESSION_KEY);

        UserInfo currentUser = commonContext.getUserInfo();
        if (currentUser.getId().equals(userInfo.getId())) {
            userEditViewHelper.setCanDel(false);
        } else {
            userEditViewHelper.setCanDel(true);
        }

        // Kiem tra quyen quan tri
        Boolean adminAuthority = Boolean.FALSE;
        Boolean preventAuthority = Boolean.FALSE;
        Boolean bankAuthority = Boolean.FALSE;
        Boolean contractAuthority = Boolean.FALSE;
        Boolean announcementAuthority = Boolean.FALSE;
        Boolean deleteContractAuthority = Boolean.FALSE;
        Boolean deletePreventAuthority = Boolean.FALSE;
        Boolean viewReportAuthority = Boolean.FALSE;
        Boolean tempContractAuthority = Boolean.FALSE;
        Boolean deleteTempContractAuthority = Boolean.FALSE;
        UserAuthorityList userAuthorityList = userService.queryUserAuthorityByUsid(false, (long)id);
        for ( int i = 0; i < userAuthorityList.size(); i++) {
            if (Constants.AUTHORITY_ADMIN.equals(userAuthorityList.get(i).getAuthorityCode())) {
                adminAuthority = Boolean.TRUE;
            }
            if (Constants.AUTHORITY_PREVENT_DATA.equals(userAuthorityList.get(i).getAuthorityCode())) {
                preventAuthority = Boolean.TRUE;
            }
            if (Constants.AUTHORITY_BANK_REPORT.equals(userAuthorityList.get(i).getAuthorityCode())) {
                bankAuthority = Boolean.TRUE;
            }
            if (Constants.AUTHORITY_CONTRACT.equals(userAuthorityList.get(i).getAuthorityCode())) {
                contractAuthority = Boolean.TRUE;
            }
            if (Constants.AUTHORITY_ANNOUNCEMENT.equals(userAuthorityList.get(i).getAuthorityCode())) {
                announcementAuthority = Boolean.TRUE;
            }
            if (Constants.AUTHORITY_VIEW_REPORT.equals(userAuthorityList.get(i).getAuthorityCode())) {
            	viewReportAuthority = Boolean.TRUE;
            }
            if (Constants.AUTHORITY_CNTR_DEL.equals(userAuthorityList.get(i).getAuthorityCode())) {
            	deleteContractAuthority = Boolean.TRUE;
            }
            if (Constants.AUTHORITY_PRV_DEL.equals(userAuthorityList.get(i).getAuthorityCode())) {
            	deletePreventAuthority = Boolean.TRUE;
            }
            if (Constants.AUTHORITY_TEMP_CONTRACT.equals(userAuthorityList.get(i).getAuthorityCode())) {
            	tempContractAuthority = Boolean.TRUE;
            }
            if (Constants.AUTHORITY_TEMP_CNTR_DEL.equals(userAuthorityList.get(i).getAuthorityCode())) {
            	deleteTempContractAuthority = Boolean.TRUE;
            }
        }

        userEditViewHelper.setAdminAuthority(adminAuthority);
        userEditViewHelper.setPreventAuthority(preventAuthority);
        userEditViewHelper.setBankAuthority(bankAuthority);
        userEditViewHelper.setContractAuthority(contractAuthority);
        userEditViewHelper.setAnnouncementAuthority(announcementAuthority);
        userEditViewHelper.setDeleteContractAuthority(deleteContractAuthority);
        userEditViewHelper.setDeletePreventAuthority(deletePreventAuthority);
        userEditViewHelper.setViewReportAuthority(viewReportAuthority);
        userEditViewHelper.setTempContractAuthority(tempContractAuthority);
        userEditViewHelper.setDeleteTempContractAuthority(deleteTempContractAuthority);

        // kiem tra co the thay doi chuc vu user
        userEditViewHelper.setHasContract(Boolean.FALSE);
        ContractService contractService = new ContractService(getConnection());
        if (contractService.isExistContractInDB(NPO_CONTRACT, new Object[][] {{NPO_CONTRACT_NOTARY_ID, id}}) ||
                contractService.isExistContractInDB(NPO_CONTRACT, new Object[][] {{NPO_CONTRACT_DRAFTER_ID, id}})) {
            userEditViewHelper.setHasContract(Boolean.TRUE);
        }

        request.getSession().setAttribute(UserEditViewHelper.SESSION_KEY, userEditViewHelper);
        return mapping.findForward(SUCCESS);
    }

    /**
     * <P>Action save user</P>
     *
     * @author KienLT
     * @author GiangVT
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward save(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {

        UserEditViewHelper view = (UserEditViewHelper)
            request.getSession().getAttribute(UserEditViewHelper.SESSION_KEY);

        UserService userService = new UserService(getConnection());
        UserEditForm userEditForm = (UserEditForm)form;
        int id = view.getId();

        userService.setUsidFilter((long)id);
        UserList userList = userService.queryAllUser(false);
        if (userList.size() == 0) {
            ActionErrors errors = new ActionErrors();
            errors.add(new MessageUtil().createActionMessages("", request, "err_not_exist", "item_user"));
            saveErrors(request, errors);
            return mapping.findForward(FAILURE);
        }

        UserInfo userInfo = (UserInfo) userList.get(0);

        userInfo.setFamilyName(userEditForm.getFamilyName());
        userInfo.setFirstName(userEditForm.getFirstName());
        if (userEditForm.getPassword() != null && !userEditForm.getPassword().equals("")) {
            userInfo.setPassword(Crypter.crypt(userEditForm.getPassword()));
        }
        userInfo.setBirthday(userEditForm.getBirthday());
        userInfo.setSex(userEditForm.getSex());
        userInfo.setAddress(userEditForm.getAddress());
        userInfo.setEmail(userEditForm.getEmail());
        userInfo.setTelephone(userEditForm.getTelephone());
        userInfo.setMobile(userEditForm.getMobile());
        userInfo.setActiveFlg(userEditForm.getActiveFlg());

        ContractService contractService = new ContractService(getConnection());
        if (userEditForm.getRole() != null && !userEditForm.getRole().equals(view.getRole())) {
            if (!(contractService.isExistContractInDB(NPO_CONTRACT, new Object[][] {{NPO_CONTRACT_NOTARY_ID, id}}) ||
                    contractService.isExistContractInDB(NPO_CONTRACT, new Object[][] {{NPO_CONTRACT_DRAFTER_ID, id}}))) {
                userInfo.setRole(userEditForm.getRole());
            } else {
                ActionErrors errors = new ActionErrors();
                errors.add(new MessageUtil().createActionMessages("", "ADM003_user_contract_data_reference_modify_role"));
                saveErrors(request, errors);
                return mapping.findForward(FAILURE);
            }
        }

        //Update user information
        createUpdateUserInfo(userInfo);

        userService.modifyUser(userInfo);

        view.reset(userEditForm);

        //Remove authority
        userService.removeUserAuthority(userInfo.getId());

        if (view.getCanDel()) {
            //Add authority
            if (userEditForm.getAdminAuthority() != null && userEditForm.getAdminAuthority()) {
                UserAuthorityInfo userAuthorityInfo = new UserAuthorityInfo();
                userAuthorityInfo.setUserId(userInfo.getId());
                userAuthorityInfo.setAuthorityCode(Constants.AUTHORITY_ADMIN);
                userService.entryUserAuthority(userAuthorityInfo);
            }
        } else {
            //Cap nhat cho chinh minh
            UserAuthorityInfo userAuthorityInfo = new UserAuthorityInfo();
            userAuthorityInfo.setUserId(userInfo.getId());
            userAuthorityInfo.setAuthorityCode(Constants.AUTHORITY_ADMIN);
            userService.entryUserAuthority(userAuthorityInfo);
        }

        //Add authority
        if (userEditForm.getPreventAuthority() != null && userEditForm.getPreventAuthority()) {
            UserAuthorityInfo userAuthorityInfo = new UserAuthorityInfo();
            userAuthorityInfo.setUserId(userInfo.getId());
            userAuthorityInfo.setAuthorityCode(Constants.AUTHORITY_PREVENT_DATA);
            userService.entryUserAuthority(userAuthorityInfo);
        }

        if (userEditForm.getContractAuthority() != null && userEditForm.getContractAuthority()) {
            UserAuthorityInfo userAuthorityInfo = new UserAuthorityInfo();
            userAuthorityInfo.setUserId(userInfo.getId());
            userAuthorityInfo.setAuthorityCode(Constants.AUTHORITY_CONTRACT);
            userService.entryUserAuthority(userAuthorityInfo);
        }

        if (userEditForm.getBankAuthority() != null && userEditForm.getBankAuthority()) {
            UserAuthorityInfo userAuthorityInfo = new UserAuthorityInfo();
            userAuthorityInfo.setUserId(userInfo.getId());
            userAuthorityInfo.setAuthorityCode(Constants.AUTHORITY_BANK_REPORT);
            userService.entryUserAuthority(userAuthorityInfo);
        }

        if (userEditForm.getAnnouncementAuthority() != null && userEditForm.getAnnouncementAuthority()) {
            UserAuthorityInfo userAuthorityInfo = new UserAuthorityInfo();
            userAuthorityInfo.setUserId(userInfo.getId());
            userAuthorityInfo.setAuthorityCode(Constants.AUTHORITY_ANNOUNCEMENT);

            userService.entryUserAuthority(userAuthorityInfo);
        }
        
        if (userEditForm.getDeleteContractAuthority() != null && userEditForm.getDeleteContractAuthority()) {
            UserAuthorityInfo userAuthorityInfo = new UserAuthorityInfo();
            userAuthorityInfo.setUserId(userInfo.getId());
            userAuthorityInfo.setAuthorityCode(Constants.AUTHORITY_CNTR_DEL);

            userService.entryUserAuthority(userAuthorityInfo);
        }
        
        if (userEditForm.getViewReportAuthority() != null && userEditForm.getViewReportAuthority()) {
            UserAuthorityInfo userAuthorityInfo = new UserAuthorityInfo();
            userAuthorityInfo.setUserId(userInfo.getId());
            userAuthorityInfo.setAuthorityCode(Constants.AUTHORITY_VIEW_REPORT);

            userService.entryUserAuthority(userAuthorityInfo);
        }
        
        if (userEditForm.getDeletePreventAuthority() != null && userEditForm.getDeletePreventAuthority()) {
            UserAuthorityInfo userAuthorityInfo = new UserAuthorityInfo();
            userAuthorityInfo.setUserId(userInfo.getId());
            userAuthorityInfo.setAuthorityCode(Constants.AUTHORITY_PRV_DEL);

            userService.entryUserAuthority(userAuthorityInfo);
        }
        
        // Cap nhat quyen tao moi hop dong cho ky
        if (userEditForm.getTempContractAuthority() != null && userEditForm.getTempContractAuthority()) {
            UserAuthorityInfo userAuthorityInfo = new UserAuthorityInfo();
            userAuthorityInfo.setUserId(userInfo.getId());
            userAuthorityInfo.setAuthorityCode(Constants.AUTHORITY_TEMP_CONTRACT);

            userService.entryUserAuthority(userAuthorityInfo);
        }
        
        
        //Cap nhat quyen xoa hop dong cho ky
        if (userEditForm.getDeleteTempContractAuthority() != null && userEditForm.getDeleteTempContractAuthority()) {
            UserAuthorityInfo userAuthorityInfo = new UserAuthorityInfo();
            userAuthorityInfo.setUserId(userInfo.getId());
            userAuthorityInfo.setAuthorityCode(Constants.AUTHORITY_TEMP_CNTR_DEL);

            userService.entryUserAuthority(userAuthorityInfo);
        }

        getConnection().commit();

        //Hien thi thong bao Sua thanh cong
        ActionMessages messages = new ActionMessages();
        messages.add(new MessageUtil().createActionMessages("", request, "msg_update_success", "item_user"));
        this.addMessages(request, messages);

        return mapping.findForward(SUCCESS);
    }

    /**
     * <P>Action del user</P>
     *
     * @author KienLT
     * @author GiangVT
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward del(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {

        UserEditViewHelper view = (UserEditViewHelper)
            request.getSession().getAttribute(UserEditViewHelper.SESSION_KEY);

        UserService userService = new UserService(getConnection());
        int id = view.getId();

        ContractService contractService = new ContractService(getConnection());
        if (contractService.isExistContractInDB(NPO_CONTRACT, new Object[][] {{NPO_CONTRACT_NOTARY_ID, id}}) ||
                contractService.isExistContractInDB(NPO_CONTRACT, new Object[][] {{NPO_CONTRACT_DRAFTER_ID, id}})) {

            ActionErrors errors = new ActionErrors();
            errors.add((new MessageUtil()).createActionMessages("", "ADM003_user_contract_data_reference"));
            this.addErrors(request, errors);
            return mapping.findForward(FAILURE);
        }

        userService.removeUser((long)id);
        getConnection().commit();

        // Hien thi thong bao Xoa thanh cong
        ActionMessages messages = new ActionMessages();
        messages.add(new MessageUtil().createActionMessages("", request, "msg_delete_success", "item_user"));
        this.addMessages(request, messages);

        return mapping.findForward(SUCCESS);
    }

}
