/**
 * 
 */
package com.osp.npo.app.viewhelper;

import java.util.List;

import com.osp.npo.app.form.ContractAdditionForm;
import com.osp.npo.core.contract.ContractInfo;

/**
 * @author SonHD
 * @version $Revision: 19595 $
 */
public class ContractAdditionViewHelper extends AbstractPageListViewHelper {
    public static final String SESSION_KEY = "contractAdditionViewHelper";
    
    private String notaryDateFilter;    
    private String notaryDateFromFilter;    
    private String notaryDateToFilter;
    private List<ContractInfo> contractList;
    
    /**
     * Get the notaryDateFilter
     *
     * @return the notaryDateFilter
     */
    public String getNotaryDateFilter() {
        return notaryDateFilter;
    }
    /**
     * Set the notaryDateFilter
     *
     * @param notaryDateFilter the notaryDateFilter to set
     */
    public void setNotaryDateFilter(String notaryDateFilter) {
        this.notaryDateFilter = notaryDateFilter;
    }
    /**
     * Get the notaryDateFromFilter
     *
     * @return the notaryDateFromFilter
     */
    public String getNotaryDateFromFilter() {
        return notaryDateFromFilter;
    }
    /**
     * Set the notaryDateFromFilter
     *
     * @param notaryDateFromFilter the notaryDateFromFilter to set
     */
    public void setNotaryDateFromFilter(String notaryDateFromFilter) {
        this.notaryDateFromFilter = notaryDateFromFilter;
    }
    /**
     * Get the notaryDateToFilter
     *
     * @return the notaryDateToFilter
     */
    public String getNotaryDateToFilter() {
        return notaryDateToFilter;
    }
    /**
     * Set the notaryDateToFilter
     *
     * @param notaryDateToFilter the notaryDateToFilter to set
     */
    public void setNotaryDateToFilter(String notaryDateToFilter) {
        this.notaryDateToFilter = notaryDateToFilter;
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
    
    public void reset(ContractAdditionForm contractAdditionForm) {
        this.notaryDateFilter = contractAdditionForm.getNotaryDateFilter();
        this.notaryDateFromFilter = contractAdditionForm.getNotaryDateFromFilter();
        this.notaryDateToFilter = contractAdditionForm.getNotaryDateToFilter();
    }
}