package com.osp.npo.app.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.osp.npo.app.context.CommonContext;
import com.osp.npo.app.message.MessageUtil;
import com.osp.npo.common.util.Crypter;
import com.osp.npo.common.util.EditString;
import com.osp.npo.common.util.SystemProperties;
import com.osp.npo.core.user.UserInfo;

/**
 * Login Form
 *
 * @author HungPT
 */
public class UserProfileForm extends ActionForm {

    private static final long serialVersionUID = 5384607727500580814L;
    private static final String MALE = "0";
    private static final String FEMALE = "1";
    private static final String NO_LOGIN = "nologin";

    private String familyName;
    private String firstName;
    private String account;
    private String birthday;
    private String sex;
    private String address;
    private String email;
    private String telephone;
    private String mobile;
    private String role;
    private String password;
    private String newPassword;
    private String retypePassword;
    private Boolean isChangePassword;


    @Override
    public ActionErrors validate(ActionMapping mapping,
            HttpServletRequest request) {

        ActionErrors errors = new ActionErrors();

        CommonContext context = (CommonContext)request.getSession().getAttribute(CommonContext.SESSION_KEY);
        if (context == null) {
            return errors;
        }

        if(getFamilyName().length() == 0) {
            errors.add(new MessageUtil().createActionMessages("", request, "err_not_input_data", SystemProperties.getProperty("item_family_name")));
        } else if(getFamilyName().length() > 40) {
            errors.add(new MessageUtil().createActionMessages("", request, "err_max_length", SystemProperties.getProperty("item_family_name"), "40"));
        }

        if(getFirstName().length() == 0) {
            errors.add(new MessageUtil().createActionMessages("", request, "err_not_input_data", SystemProperties.getProperty("item_fisrt_name")));
        } else if(getFirstName().length() > 10) {
            errors.add(new MessageUtil().createActionMessages("", request, "err_max_length", SystemProperties.getProperty("item_fisrt_name"), "10"));
        }

        // validate password if user change
        if(getIsChangePassword()) {
            CommonContext commonContext = (CommonContext) request.getSession().getAttribute(CommonContext.SESSION_KEY);
            UserInfo userInfo = commonContext.getUserInfo();
            Crypter.crypt(this.getPassword());
            if(Crypter.matches(userInfo.getPassword(), this.getPassword())) {
                if(!EditString.isNull(this.getNewPassword())) {
                    if(!this.getNewPassword().equals(this.getRetypePassword())) {
                        errors.add(new MessageUtil().createActionMessages("", "err_password_not_match"));
                    }
                } else {
                    errors.add(new MessageUtil().createActionMessages("", request, "err_not_input_data", SystemProperties.getProperty("item_new_password")));
                }
            } else {
                errors.add(new MessageUtil().createActionMessages("", "COM004_old_password_wrong"));
            }
        }

        if(getBirthday().length() > 10) {
            errors.add(new MessageUtil().createActionMessages("", request, "err_max_length", SystemProperties.getProperty("item_birthday"), "10"));
        }

        if(!(MALE.equals(getSex()) || FEMALE.equals(getSex()))) {
            errors.add(new MessageUtil().createActionMessages("", request, "err_not_input_data", SystemProperties.getProperty("item_sex")));
        }

        if(getAddress().length() > 200) {
            errors.add(new MessageUtil().createActionMessages("", request, "err_max_length", SystemProperties.getProperty("item_address"), "200"));
        }

        if(getEmail().length() > 50) {
            errors.add(new MessageUtil().createActionMessages("", request, "err_max_length", SystemProperties.getProperty("item_email"), "50"));
        }

        if(getTelephone().length() > 16) {
            errors.add(new MessageUtil().createActionMessages("", request, "err_max_length", SystemProperties.getProperty("item_telephone"), "16"));
        }

        if(getMobile().length() > 16) {
            errors.add(new MessageUtil().createActionMessages("", request, "err_max_length", SystemProperties.getProperty("item_mobile"), "16"));
        }

        return errors;
    }

    public String getFamilyName() {
        return familyName;
    }
    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getAccount() {
        return account;
    }
    public void setAccount(String account) {
        this.account = account;
    }
    public String getBirthday() {
        return birthday;
    }
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getTelephone() {
        return telephone;
    }
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    public String getMobile() {
        return mobile;
    }
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getNewPassword() {
        return newPassword;
    }
    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
    public String getRetypePassword() {
        return retypePassword;
    }
    public void setRetypePassword(String retypePassword) {
        this.retypePassword = retypePassword;
    }

    public Boolean getIsChangePassword() {
        return isChangePassword;
    }

    public void setIsChangePassword(Boolean isChangePassword) {
        this.isChangePassword = isChangePassword;
    }
}