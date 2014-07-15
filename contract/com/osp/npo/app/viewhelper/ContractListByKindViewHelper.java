/**
 * 
 */
package com.osp.npo.app.viewhelper;

import java.util.List;

import com.osp.npo.app.form.ContractListByKindForm;
import com.osp.npo.core.contract.ContractInfo;
import com.osp.npo.core.contract.ContractKindTreeNode;

/**
 * @author SonHD
 * @version $Revision: 25061 $
 */
public class ContractListByKindViewHelper extends AbstractPageListViewHelper {
    public static final String SESSION_KEY = "contractListByKindViewHelper";
    private Long contractKindIdFilter;
    private String contractKindNameFilter;
    private String notaryDateFilter;    
    private String notaryDateFromFilter;    
    private String notaryDateToFilter;
    private List<ContractInfo> contractList;
    private List<ContractKindTreeNode> contractKindTree;
    /**
     * Get the contractKindIdFilter
     *
     * @return the contractKindIdFilter
     */
    public Long getContractKindIdFilter() {
        return contractKindIdFilter;
    }
    /**
     * Set the contractKindIdFilter
     *
     * @param contractKindIdFilter the contractKindIdFilter to set
     */
    public void setContractKindIdFilter(Long contractKindIdFilter) {
        this.contractKindIdFilter = contractKindIdFilter;
    }
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
    
    /**
     * Get the contractKindTree
     *
     * @return the contractKindTree
     */
    public List<ContractKindTreeNode> getContractKindTree() {
        return contractKindTree;
    }
    /**
     * Set the contractKindTree
     *
     * @param contractKindTree the contractKindTree to set
     */
    public void setContractKindTree(List<ContractKindTreeNode> contractKindTree) {
        this.contractKindTree = contractKindTree;
    }
    
    /**
     * Get the contractKindNameFilter
     *
     * @return the contractKindNameFilter
     */
    public String getContractKindNameFilter() {
        return contractKindNameFilter;
    }
    /**
     * Set the contractKindNameFilter
     *
     * @param contractKindNameFilter the contractKindNameFilter to set
     */
    public void setContractKindNameFilter(String contractKindNameFilter) {
        this.contractKindNameFilter = contractKindNameFilter;
    }
    public void reset(ContractListByKindForm contractListByKindForm) {
        this.notaryDateFilter = contractListByKindForm.getNotaryDateFilter();
        this.notaryDateFromFilter = contractListByKindForm.getNotaryDateFromFilter();
        this.notaryDateToFilter = contractListByKindForm.getNotaryDateToFilter();
        this.contractKindIdFilter= contractListByKindForm.getContractKindIdFilter();
    }
}
