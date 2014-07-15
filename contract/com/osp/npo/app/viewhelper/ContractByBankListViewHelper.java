package com.osp.npo.app.viewhelper;

import java.util.List;
import com.osp.npo.app.form.ContractByBankListForm;
import com.osp.npo.core.basicData.BankInfo;
import com.osp.npo.core.contract.ContractInfo;

/**
 *
 * View Helper for Contract By Notary List function
 *
 * @author GiangVT
 * @version $Revision: 20069 $
 */
public class ContractByBankListViewHelper extends AbstractPageListViewHelper {

    public static final String SESSION_KEY = "contractByBankListViewHelper";

    private List<ContractInfo> contractList;
    private List<BankInfo> bankList;
    private String[] selectedBankList;
    private Boolean checkAllValue;
    private Long bankIdFilter;
    private String searchDate;
    private String fromDate;
    private String toDate;

    public void reset(ContractByBankListForm f) {
        searchDate = f.getSearchDate();
        fromDate = f.getFromDate();
        toDate = f.getToDate();
        selectedBankList = f.getSelectedBankList();
        checkAllValue = f.getCheckAllValue();
        bankIdFilter = f.getBankIdFilter();
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
     * @return the selectedBankList
     */
    public String[] getSelectedBankList() {
        return selectedBankList;
    }

    /**
     * @param selectedBankList the selectedBankList to set
     */
    public void setSelectedBankList(String[] selectedBankList) {
        this.selectedBankList = selectedBankList;
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
