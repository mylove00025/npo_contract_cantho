package com.osp.npo.app.viewhelper;

import java.util.List;

import com.osp.npo.app.form.ContractListForm;
import com.osp.npo.core.basicData.BankInfo;
import com.osp.npo.core.contract.ContractInfo;
import com.osp.npo.core.contract.ContractKindTreeNode;
import com.osp.npo.core.contract.ContractTemplateInfo;
import com.osp.npo.core.prevent.TransactionPropertyInfo;
import com.osp.npo.core.user.UserInfo;

/**
 * <P>Contract List View Helper</P>
 * 
 * @author HungPT 
 * @version $Revision$
 */
public class ContractListViewHelper extends AbstractPageListViewHelper {
    
    public static final String SESSION_KEY = "contractListViewHelper";
    
    private String contractNumberFilter;
    
    private Long contractKindIdFilter;
    
    private Long contractTemplateIdFilter;
    
    private String contractTemplateNameFilter;
    
    private String relationObject;
    
    private String relationObjectFilter;
    
    private String notaryDateFilter;
    
    private String notaryDateFromFilter;
    
    private String notaryDateToFilter;
    
    private Long bankIdFilter;
    
    private String notaryPlaceFilter;
    
    private Long notaryIdFilter;
    
    private Long drafterIdFilter;
    
    private String contractStatusFilter;
    
    private Boolean errorStatusFilter;
    
    private Boolean additionStatusFilter;
    
    private Boolean cancellationStatusFilter;
    
    private String contractSummaryFilter;
    
    private String propertyInfoFilter;
    
    private String keySearch;
    
    private String keyHighLight;
    
    private List<ContractInfo> contractList;
    
    private List<TransactionPropertyInfo> transactionPropertyList;
    
    private List<ContractTemplateInfo> contractTemplateList;
    
    private List<ContractKindTreeNode> contractKindTree;
    
    private List<UserInfo> notaryList;
    
    private List<UserInfo> drafterList;
    
    private List<BankInfo> bankList;
    
    private Boolean isHidePanelSearch = Boolean.FALSE;
    
    private Boolean isAdvanceSearch = Boolean.FALSE;
    
    private Boolean luceneSearch = Boolean.FALSE;
    
    private List<String> subkeyList;

    

    /**
     * Get the contractNumberFilter
     *
     * @return the contractNumberFilter
     */
    public String getContractNumberFilter() {
        return contractNumberFilter;
    }
    
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
     * Set the contractNumberFilter
     *
     * @param contractNumberFilter the contractNumberFilter to set
     */
    public void setContractNumberFilter(String contractNumberFilter) {
        this.contractNumberFilter = contractNumberFilter;
    }

    /**
     * Get the contractTemplateIdFilter
     *
     * @return the contractTemplateIdFilter
     */
    public Long getContractTemplateIdFilter() {
        return contractTemplateIdFilter;
    }
    
    /**
     * Get the relationObject
     *
     * @return the relationObject
     */
    public String getRelationObject() {
        return relationObject;
    }

    /**
     * Set the relationObject
     *
     * @param relationObject the relationObject to set
     */
    public void setRelationObject(String relationObject) {
        this.relationObject = relationObject;
    }

    /**
     * Get the relationObjectFilter
     *
     * @return the relationObjectFilter
     */
    public String getRelationObjectFilter() {
        return relationObjectFilter;
    }

    /**
     * Set the relationObjectFilter
     *
     * @param relationObjectFilter the relationObjectFilter to set
     */
    public void setRelationObjectFilter(String relationObjectFilter) {
        this.relationObjectFilter = relationObjectFilter;
    }

    /**
     * Set the contractTemplateIdFilter
     *
     * @param contractTemplateIdFilter the contractTemplateIdFilter to set
     */
    public void setContractTemplateIdFilter(Long contractTemplateIdFilter) {
        this.contractTemplateIdFilter = contractTemplateIdFilter;
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

    /**
     * Get the notaryPlaceFilter
     *
     * @return the notaryPlaceFilter
     */
    public String getNotaryPlaceFilter() {
        return notaryPlaceFilter;
    }

    /**
     * Set the notaryPlaceFilter
     *
     * @param notaryPlaceFilter the notaryPlaceFilter to set
     */
    public void setNotaryPlaceFilter(String notaryPlaceFilter) {
        this.notaryPlaceFilter = notaryPlaceFilter;
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

    /**
     * Get the drafterIdFilter
     *
     * @return the drafterIdFilter
     */
    public Long getDrafterIdFilter() {
        return drafterIdFilter;
    }

    /**
     * Set the drafterIdFilter
     *
     * @param drafterIdFilter the drafterIdFilter to set
     */
    public void setDrafterIdFilter(Long drafterIdFilter) {
        this.drafterIdFilter = drafterIdFilter;
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
     * Get the contractTemplateList
     *
     * @return the contractTemplateList
     */
    public List<ContractTemplateInfo> getContractTemplateList() {
        return contractTemplateList;
    }

    /**
     * Set the contractTemplateList
     *
     * @param contractTemplateList the contractTemplateList to set
     */
    public void setContractTemplateList(List<ContractTemplateInfo> contractTemplateList) {
        this.contractTemplateList = contractTemplateList;
    }

    /**
     * Get the notaryList
     *
     * @return the notaryList
     */
    public List<UserInfo> getNotaryList() {
        return notaryList;
    }

    /**
     * Set the notaryList
     *
     * @param notaryList the notaryList to set
     */
    public void setNotaryList(List<UserInfo> notaryList) {
        this.notaryList = notaryList;
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
     * Get the bankList
     *
     * @return the bankList
     */
    public List<BankInfo> getBankList() {
        return bankList;
    }

    /**
     * Set the bankList
     *
     * @param bankList the bankList to set
     */
    public void setBankList(List<BankInfo> bankList) {
        this.bankList = bankList;
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
     * Get the contractSummaryFilter
     *
     * @return the contractSummaryFilter
     */
    public String getContractSummaryFilter() {
        return contractSummaryFilter;
    }

    /**
     * Set the contractSummaryFilter
     *
     * @param contractSummaryFilter the contractSummaryFilter to set
     */
    public void setContractSummaryFilter(String contractSummaryFilter) {
        this.contractSummaryFilter = contractSummaryFilter;
    }

    /**
     * Get the errorStatusFilter
     *
     * @return the errorStatusFilter
     */
    public Boolean getErrorStatusFilter() {
        return errorStatusFilter;
    }

    /**
     * Set the errorStatusFilter
     *
     * @param errorStatusFilter the errorStatusFilter to set
     */
    public void setErrorStatusFilter(Boolean errorStatusFilter) {
        this.errorStatusFilter = errorStatusFilter;
    }

    /**
     * Get the additionStatusFilter
     *
     * @return the additionStatusFilter
     */
    public Boolean getAdditionStatusFilter() {
        return additionStatusFilter;
    }

    /**
     * Set the additionStatusFilter
     *
     * @param additionStatusFilter the additionStatusFilter to set
     */
    public void setAdditionStatusFilter(Boolean additionStatusFilter) {
        this.additionStatusFilter = additionStatusFilter;
    }

    /**
     * Get the cancellationStatusFilter
     *
     * @return the cancellationStatusFilter
     */
    public Boolean getCancellationStatusFilter() {
        return cancellationStatusFilter;
    }

    /**
     * Set the cancellationStatusFilter
     *
     * @param cancellationStatusFilter the cancellationStatusFilter to set
     */
    public void setCancellationStatusFilter(Boolean cancellationStatusFilter) {
        this.cancellationStatusFilter = cancellationStatusFilter;
    }
    
    /**
     * Get the propertyInfoFilter
     *
     * @return the propertyInfoFilter
     */
    public String getPropertyInfoFilter() {
        return propertyInfoFilter;
    }

    /**
     * Set the propertyInfoFilter
     *
     * @param propertyInfoFilter the propertyInfoFilter to set
     */
    public void setPropertyInfoFilter(String propertyInfoFilter) {
        this.propertyInfoFilter = propertyInfoFilter;
    }
    
    /**
     * Get the keySearch
     *
     * @return the keySearch
     */
    public String getKeySearch() {
        return keySearch;
    }

    /**
     * Set the keySearch
     *
     * @param keySearch the keySearch to set
     */
    public void setKeySearch(String keySearch) {
        this.keySearch = keySearch;
    }
    
    /**
     * Get the isAdvanceSearch
     *
     * @return the isAdvanceSearch
     */
    public Boolean getIsAdvanceSearch() {
        return isAdvanceSearch;
    }

    /**
     * Set the isAdvanceSearch
     *
     * @param isAdvanceSearch the isAdvanceSearch to set
     */
    public void setIsAdvanceSearch(Boolean isAdvanceSearch) {
        this.isAdvanceSearch = isAdvanceSearch;
    }
    
    /**
     * Get the isHidePanelSearch
     *
     * @return the isHidePanelSearch
     */
    public Boolean getIsHidePanelSearch() {
        return isHidePanelSearch;
    }

    /**
     * Set the isHidePanelSearch
     *
     * @param isHidePanelSearch the isHidePanelSearch to set
     */
    public void setIsHidePanelSearch(Boolean isHidePanelSearch) {
        this.isHidePanelSearch = isHidePanelSearch;
    }
    
    /**
     * Get the keyHighLight
     *
     * @return the keyHighLight
     */
    public String getKeyHighLight() {
        return keyHighLight;
    }

    /**
     * Set the keyHighLight
     *
     * @param keyHighLight the keyHighLight to set
     */
    public void setKeyHighLight(String keyHighLight) {
        this.keyHighLight = keyHighLight;
    }
    
    /**
     * Get the contractStatusFilter
     *
     * @return the contractStatusFilter
     */
    public String getContractStatusFilter() {
        return contractStatusFilter;
    }

    /**
     * Set the contractStatusFilter
     *
     * @param contractStatusFilter the contractStatusFilter to set
     */
    public void setContractStatusFilter(String contractStatusFilter) {
        this.contractStatusFilter = contractStatusFilter;
    }

	/**
	 * @param luceneSearch the luceneSearch to set
	 */
	public void setLuceneSearch(Boolean luceneSearch) {
		this.luceneSearch = luceneSearch;
	}

	/**
	 * @return the luceneSearch
	 */
	public Boolean getLuceneSearch() {
		return luceneSearch;
	}

	/**
	 * @param subkeyList the subkeyList to set
	 */
	public void setSubkeyList(List<String> subkeyList) {
		this.subkeyList = subkeyList;
	}

	/**
	 * @return the subkeyList
	 */
	public List<String> getSubkeyList() {
		return subkeyList;
	}

    /**
     * Get the transactionPropertyList
     *
     * @return the transactionPropertyList
     */
    public List<TransactionPropertyInfo> getTransactionPropertyList() {
        return transactionPropertyList;
    }

    /**
     * Set the transactionPropertyList
     *
     * @param transactionPropertyList the transactionPropertyList to set
     */
    public void setTransactionPropertyList(List<TransactionPropertyInfo> transactionPropertyList) {
        this.transactionPropertyList = transactionPropertyList;
    }    
    
	
    /**
     * Get the contractTemplateNameFilter
     *
     * @return the contractTemplateNameFilter
     */
    public String getContractTemplateNameFilter() {
        return contractTemplateNameFilter;
    }

    /**
     * Set the contractTemplateNameFilter
     *
     * @param contractTemplateNameFilter the contractTemplateNameFilter to set
     */
    public void setContractTemplateNameFilter(String contractTemplateNameFilter) {
        this.contractTemplateNameFilter = contractTemplateNameFilter;
    }

    public void reset(ContractListForm form) {
        this.bankIdFilter = form.getBankIdFilter();
        this.contractNumberFilter = form.getContractNumberFilter();
        this.contractTemplateIdFilter = form.getContractTemplateIdFilter();
        this.contractTemplateNameFilter = form.getContractTemplateNameFilter();
        this.drafterIdFilter = form.getDrafterIdFilter();
        this.errorStatusFilter = form.getErrorStatusFilter();
        this.additionStatusFilter = form.getAdditionStatusFilter();
        this.cancellationStatusFilter = form.getCancellationStatusFilter();
        this.notaryDateFilter = form.getNotaryDateFilter();
        this.notaryDateFromFilter = form.getNotaryDateFromFilter();
        this.notaryDateToFilter = form.getNotaryDateToFilter();
        this.notaryIdFilter = form.getNotaryIdFilter();
        this.notaryPlaceFilter = form.getNotaryPlaceFilter();
        this.relationObject = form.getRelationObject();
        this.relationObjectFilter = form.getRelationObjectFilter();
        this.contractKindIdFilter= form.getContractKindIdFilter();
        this.contractSummaryFilter = form.getContractSummaryFilter();
        this.propertyInfoFilter = form.getPropertyInfoFilter();
        this.keySearch = form.getKeySearch();
        this.isAdvanceSearch = form.getIsAdvanceSearch();
        this.isHidePanelSearch = form.getIsHidePanelSearch();
        this.contractStatusFilter = form.getContractStatusFilter();
    }
	
}
