package com.osp.npo.app.viewhelper;

import java.util.List;

import com.osp.npo.core.user.RoleInfo;
import com.osp.npo.app.form.UserListForm;


/**
 * User List ViewHelper
 *
 * @author KienLT
 * @author GiangVT
 * @version $Revision: 17899 $
 */
public class UserListViewHelper extends AbstractPageListViewHelper {

    private String role;
    private String activeFlg;

    private List<RoleInfo> roleList;

    public static final String SESSION_KEY = "userListViewHelper";

    private String firstName;

    private String familyName;

    private String account;

    /**
     * reset from form
     *
     * @param f for user list form
     */
    public void reset(UserListForm f) {
        familyName=f.getFamilyName();
        firstName=f.getFirstName();
        account=f.getAccount();
        role=f.getRole();
        activeFlg=f.getActiveFlg();
    }

    /**
     * Get the account
     *
     * @return the account
     */
    public String getAccount() {
        return account;
    }

    /**
     * Set the account
     *
     * @param account the account to set
     */
    public void setAccount(String account) {
        this.account = account;
    }

    /**
     * Get the activeFlg
     *
     * @return the activeFlg
     */
    public String getActiveFlg() {
        return activeFlg;
    }

    /**
     * Set the activeFlg
     *
     * @param activeFlg the activeFlg to set
     */
    public void setActiveFlg(String activeFlg) {
        this.activeFlg = activeFlg;
    }

    /**
     * Get the role
     *
     * @return the role
     */
    public String getRole() {
        return role;
    }

    /**
     * Set the role
     *
     * @param role the role to set
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * Get the roleList
     *
     * @return the roleList
     */
    public List<RoleInfo> getRoleList() {
        return roleList;
    }

    /**
     * Set the roleList
     *
     * @param roleList the roleList to set
     */
    public void setRoleList(List<RoleInfo> roleList) {
        this.roleList = roleList;
    }

    /**
     * Get the firstName
     *
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set the firstName
     *
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Get the familyName
     *
     * @return the familyName
     */
    public String getFamilyName() {
        return familyName;
    }

    /**
     * Set the familyName
     *
     * @param familyName the familyName to set
     */
    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }
}
