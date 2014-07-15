package com.osp.npo.app.context;

import java.util.List;

import com.osp.npo.core.basicData.BankInfo;

/**
 *
 * Contract By Bank List Context
 *
 * @author GiangVT
 * @version $Revision: 20069 $
 */
public class ContractByBankListContext {

    public static final String SESSION_KEY = "contractByBankListContext";

    private String searchDate;
    private String fromDate;
    private String toDate;
    private Long bankIdFilter;
    private String[] selectedBankIdList;
    private List<BankInfo> bankList;

    private int page;

    /**
     * Clear context
     *
     */
    public void clear() {
        this.searchDate = null;
        this.fromDate = null;
        this.fromDate = null;
        this.selectedBankIdList = null;
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
     * @return the selectedBankIdList
     */
    public String[] getSelectedBankIdList() {
        return selectedBankIdList;
    }

    /**
     * @param selectedBankIdList the selectedBankIdList to set
     */
    public void setSelectedBankIdList(String[] selectedBankIdList) {
        this.selectedBankIdList = selectedBankIdList;
    }

    /**
     * @return the bankList
     */
    public List<BankInfo> getBankList() {
        return bankList;
    }

    /**
     * @param bankList the bankList to set
     */
    public void setBankList(List<BankInfo> bankList) {
        this.bankList = bankList;
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
     * Get the bankIdFilter
     *
     * @return the bankIdFilter
     */
    public Long getBankIdFilter() {
        return bankIdFilter;
    }

    /**
     * Set the bankIdFilter
     *
     * @param bankIdFilter the bankIdFilter to set
     */
    public void setBankIdFilter(Long bankIdFilter) {
        this.bankIdFilter = bankIdFilter;
    }
}
