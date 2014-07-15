package com.osp.npo.app.context;

/**
 * <P>Context for User List</P>
 *
 * @author KienLT
 * @author GiangVT
 * @version $Revision: 17899 $
 */
public class UserListContext {
    /** session key */
    public static final String SESSION_KEY = "userListContext";

    private String familyName;
    private String firstName;
    private String account;
    private Boolean activeFlg;
    private String role;
    private Boolean hiddenFlg = Boolean.FALSE;

    /**
     * Reset data
     */
    public void reset() {
        this.account = null;
        this.activeFlg = null;
        this.familyName = null;
        this.firstName = null;
        this.hiddenFlg = Boolean.FALSE;
        this.role = null;
    }

    /**
     * Get the hiddenFlg
     *
     * @return the hiddenFlg
     */
    public Boolean getHiddenFlg() {
        return hiddenFlg;
    }
    /**
     * Set the hiddenFlg
     *
     * @param hiddenFlg the hiddenFlg to set
     */
    public void setHiddenFlg(Boolean hiddenFlg) {
        this.hiddenFlg = hiddenFlg;
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
    public Boolean getActiveFlg() {
        return activeFlg;
    }
    /**
     * Set the activeFlg
     *
     * @param activeFlg the activeFlg to set
     */
    public void setActiveFlg(Boolean activeFlg) {
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
}
