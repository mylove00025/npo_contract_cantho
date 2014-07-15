package com.osp.npo.app.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

import com.osp.npo.app.context.UserListContext;
import com.osp.npo.app.viewhelper.UserListViewHelper;

/**
 * Form for User List
 *
 * @author KienLT
 * @author GiangVT
 * @version $Revision: 17899 $
 */
public class UserListForm extends ValidatorForm {
    private static final long serialVersionUID = 5907268701218039950L;
    private String role;
    private String familyName;
    private String firstName;
    private String account;
    private String activeFlg;
    private String direction;
    private String pagerState;
    private int id;



    /**
     * Get the pagerState
     *
     * @return the pagerState
     */
    public String getPagerState() {
        return pagerState;
    }

    /**
     * Set the pagerState
     *
     * @param pagerState the pagerState to set
     */
    public void setPagerState(String pagerState) {
        this.pagerState = pagerState;
    }

    /**
     * Get the id
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Set the id
     *
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get the direction
     *
     * @return the direction
     */
    public String getDirection() {
        return direction;
    }

    /**
     * Set the direction
     *
     * @param direction the direction to set
     */
    public void setDirection(String direction) {
        this.direction = direction;
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
     * Get the firstName
     *
     * @return the firstName
     */
    public String getFirstName() {
        if (firstName != null) {
            return firstName.trim();
        }
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
        if (account != null ) {
            return account.trim();
        }
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
     * Get the familyName
     *
     * @return the familyName
     */
    public String getFamilyName() {
        if (familyName != null) {
            return familyName.trim();
        }
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

    /*
     * (non-Javadoc)
     *
     * @see org.apache.struts.action.ActionForm#validate(org.apache.struts.action.ActionMapping,
     *      javax.servlet.http.HttpServletRequest)
     */
    @Override
    public ActionErrors validate(ActionMapping mapping,
            HttpServletRequest request) {

        UserListViewHelper view = (UserListViewHelper)
            request.getSession().getAttribute(UserListViewHelper.SESSION_KEY);
        UserListContext context = (UserListContext)request.getSession().getAttribute(UserListContext.SESSION_KEY);
        if (view == null || context == null) {
            return new ActionErrors();
        }

        ActionErrors errors = super.validate(mapping, request);

        if (errors.size() > 0) {
            view.reset(this);
        }

        return errors;
    }
}
