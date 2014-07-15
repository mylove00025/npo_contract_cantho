package com.osp.npo.app.context;

import java.util.List;

import com.osp.npo.core.user.UserInfo;

/**
 *
 * Contract By NotaryList Context
 *
 * @author GiangVT
 * @version $Revision: 20069 $
 */
public class ContractByNotaryListContext {

    public static final String SESSION_KEY = "contractByNotaryListContext";

    private String searchDate;
    private String fromDate;
    private String toDate;
    private Long notaryIdFilter;
    private String[] selectedNotaryIdList;
    private List<UserInfo> notaryList;

    private int page;

    /**
     * Clear context
     *
     */
    public void clear() {
        this.searchDate = null;
        this.fromDate = null;
        this.fromDate = null;
        this.selectedNotaryIdList = null;
    }

    /**
     * @return the searchDate
     */
    public String getSearchDate() {
        return searchDate;
    }

    /**
     * @param searchDate the searchDate to set
     */
    public void setSearchDate(String searchDate) {
        this.searchDate = searchDate;
    }

    /**
     * @return the fromDate
     */
    public String getFromDate() {
        return fromDate;
    }

    /**
     * @param fromDate the fromDate to set
     */
    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    /**
     * @return the toDate
     */
    public String getToDate() {
        return toDate;
    }

    /**
     * @param toDate the toDate to set
     */
    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    /**
     * @return the page
     */
    public int getPage() {
        return page;
    }

    /**
     * @param page the page to set
     */
    public void setPage(int page) {
        this.page = page;
    }

    /**
     * @return the selectedNotaryIdList
     */
    public String[] getSelectedNotaryIdList() {
        return selectedNotaryIdList;
    }

    /**
     * @param selectedNotaryIdList the selectedNotaryIdList to set
     */
    public void setSelectedNotaryIdList(String[] selectedNotaryIdList) {
        this.selectedNotaryIdList = selectedNotaryIdList;
    }

    /**
     * @return the notaryList
     */
    public List<UserInfo> getNotaryList() {
        return notaryList;
    }

    /**
     * @param notaryList the notaryList to set
     */
    public void setNotaryList(List<UserInfo> notaryList) {
        this.notaryList = notaryList;
    }

    /**
     * Get the notaryIdFilter
     *
     * @return the notaryIdFilter
     */
    public Long getNotaryIdFilter() {
        return notaryIdFilter;
    }

    /**
     * Set the notaryIdFilter
     *
     * @param notaryIdFilter the notaryIdFilter to set
     */
    public void setNotaryIdFilter(Long notaryIdFilter) {
        this.notaryIdFilter = notaryIdFilter;
    }
}
