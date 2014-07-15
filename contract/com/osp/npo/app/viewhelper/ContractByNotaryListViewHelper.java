package com.osp.npo.app.viewhelper;

import java.util.List;

import com.osp.npo.app.form.ContractByNotaryListForm;
import com.osp.npo.core.contract.ContractInfo;
import com.osp.npo.core.user.UserInfo;

/**
 *
 * View Helper for Contract By Notary List function
 *
 * @author GiangVT
 * @version $Revision: 20069 $
 */
public class ContractByNotaryListViewHelper extends AbstractPageListViewHelper {

    public static final String SESSION_KEY = "contractByNotaryListViewHelper";

    private List<ContractInfo> contractList;
    private List<UserInfo> notaryList;
    private String[] selectedNotaryList;
    private Boolean checkAllValue;
    private Long notaryIdFilter;
    private String searchDate;
    private String fromDate;
    private String toDate;

    /**
     *
     * reset view helper to last form
     *
     * @author GiangVT
     * @param f for form
     */
    public void reset(ContractByNotaryListForm f) {
        searchDate = f.getSearchDate();
        fromDate = f.getFromDate();
        toDate = f.getToDate();
        checkAllValue = f.getCheckAllValue();
        selectedNotaryList = f.getSelectedNotaryList();
        notaryIdFilter = f.getNotaryIdFilter();
    }

    /**
     * @return the contractList
     */
    public List<ContractInfo> getContractList() {
        return contractList;
    }

    /**
     * @param contractList the contractList to set
     */
    public void setContractList(List<ContractInfo> contractList) {
        this.contractList = contractList;
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
     * @return the selectedNotaryList
     */
    public String[] getSelectedNotaryList() {
        return selectedNotaryList;
    }

    /**
     * @param selectedNotaryList the selectedNotaryList to set
     */
    public void setSelectedNotaryList(String[] selectedNotaryList) {
        this.selectedNotaryList = selectedNotaryList;
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
     * @return the checkAllValue
     */
    public Boolean getCheckAllValue() {
        return checkAllValue;
    }

    /**
     * @param checkAllValue the checkAllValue to set
     */
    public void setCheckAllValue(Boolean checkAllValue) {
        this.checkAllValue = checkAllValue;
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
