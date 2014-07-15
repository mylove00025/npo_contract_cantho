package com.osp.npo.app.viewhelper;

import java.util.List;

import com.osp.npo.app.form.ContractByUserListForm;
import com.osp.npo.core.contract.ContractInfo;
import com.osp.npo.core.user.UserInfo;


/**
 * Contract View Helper
 * 
 * @author KienLT
 * @version $Revision: 19954 $
 *
 */
public class ContractByUserListViewHelper extends AbstractPageListViewHelper {
    
    public static final String SESSION_KEY = "contractByUserListViewHelper";
    
    private String searchDate;
    private String fromDate;
    private String toDate;
    private Boolean checkAllValue;
    
    private List<UserInfo> userList;
    private String[] selectedUserList;
    private Long selectedUserID;
    private List<ContractInfo> contractList;

        
    /**
     * Get the checkAllValue
     *
     * @return the checkAllValue
     */
    public Boolean getCheckAllValue() {
        return checkAllValue;
    }

    /**
     * Set the checkAllValue
     *
     * @param checkAllValue the checkAllValue to set
     */
    public void setCheckAllValue(Boolean checkAllValue) {
        this.checkAllValue = checkAllValue;
    }

    /**
     * Get the fromDate
     *
     * @return the fromDate
     */
    public String getFromDate() {
        return fromDate;
    }

    /**
     * Set the fromDate
     *
     * @param fromDate the fromDate to set
     */
    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    /**
     * Get the toDate
     *
     * @return the toDate
     */
    public String getToDate() {
        return toDate;
    }

    /**
     * Set the toDate
     *
     * @param toDate the toDate to set
     */
    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    /**
     * Get the userList
     *
     * @return the userList
     */
    public List<UserInfo> getUserList() {
        return userList;
    }

    /**
     * Set the userList
     *
     * @param userList the userList to set
     */
    public void setUserList(List<UserInfo> userList) {
        this.userList = userList;
    }

    /**
     * Get the selectedUserList
     *
     * @return the selectedUserList
     */
    public String[] getSelectedUserList() {
        return selectedUserList;
    }

    /**
     * Set the selectedUserList
     *
     * @param selectedUserList the selectedUserList to set
     */
    public void setSelectedUserList(String[] selectedUserList) {
        this.selectedUserList = selectedUserList;
    }

    /**
     * Get the searchDate
     *
     * @return the searchDate
     */
    public String getSearchDate() {
        return searchDate;
    }

    /**
     * Set the searchDate
     *
     * @param searchDate the searchDate to set
     */
    public void setSearchDate(String searchDate) {
        this.searchDate = searchDate;
    }

    /**
     * Get the contractList
     *
     * @return the contractList
     */
    public List<ContractInfo> getContractList() {
        return contractList;
    }

    /**
     * Set the contractList
     *
     * @param contractList the contractList to set
     */
    public void setContractList(List<ContractInfo> contractList) {
        this.contractList = contractList;
    }   
    
    /**
     * Get the selectedUserID
     *
     * @return the selectedUserID
     */
    public Long getSelectedUserID() {
        return selectedUserID;
    }

    /**
     * Set the selectedUserID
     *
     * @param selectedUserID the selectedUserID to set
     */
    public void setSelectedUserID(Long selectedUserID) {
        this.selectedUserID = selectedUserID;
    }

    public void reset(ContractByUserListForm f) {
        searchDate = f.getSearchDate();
        fromDate = f.getFromDate();
        toDate = f.getToDate();
        selectedUserList = f.getSelectedUserList();
        checkAllValue = f.getCheckAllValue();
        selectedUserID = f.getSelectedUserID();
    }
}
