package com.osp.npo.app.context;

import java.util.List;

import com.osp.npo.core.user.UserInfo;

/**
 * 
 * @author KienLT
 *
 */
public class ContractByUserListContext extends BaseSelectionDeleteContext {
    /** session key */
    public static final String SESSION_KEY = "contractByUserListContext";   
    
    private String searchDate;
    private String fromDate;
    private String toDate;
    private String[] selectedUserIDList;
    private Boolean checkAllValue;
    private List<UserInfo> drafterList;
    private Long selectedUserID;
    
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
     * Get the selectedUserIDList
     *
     * @return the selectedUserIDList
     */
    public String[] getSelectedUserIDList() {
        return selectedUserIDList;
    }
    /**
     * Set the selectedUserIDList
     *
     * @param selectedUserIDList the selectedUserIDList to set
     */
    public void setSelectedUserIDList(String[] selectedUserIDList) {
        this.selectedUserIDList = selectedUserIDList;
    }   
 
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
     * Get the drafterList
     *
     * @return the drafterList
     */
    public List<UserInfo> getDrafterList() {
        return drafterList;
    }
    /**
     * Set the drafterList
     *
     * @param drafterList the drafterList to set
     */
    public void setDrafterList(List<UserInfo> drafterList) {
        this.drafterList = drafterList;
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
    /**
     * 
     */
    public void clear() {
        
    }
}
