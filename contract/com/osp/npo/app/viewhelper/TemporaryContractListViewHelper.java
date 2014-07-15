package com.osp.npo.app.viewhelper;

import java.util.List;

import com.osp.npo.app.form.TemporaryContractListForm;
import com.osp.npo.core.basicData.BankInfo;
import com.osp.npo.core.contract.ContractInfo;
import com.osp.npo.core.contract.ContractKindTreeNode;
import com.osp.npo.core.contract.ContractTemplateInfo;
import com.osp.npo.core.temporaryContract.TemporaryContractInfo;
import com.osp.npo.core.user.UserInfo;

/**
 * <P>Temporary Contract List View Helper</P>
 * 
 * @author SonHD 
 * @version $Revision: 25519 $
 */
public class TemporaryContractListViewHelper extends AbstractPageListViewHelper {
    
    public static final String SESSION_KEY = "temporaryContractListViewHelper";
    
    private String contractNumberFilter;
    
    private String contractSearchFilter;
    
    private Long contractKindIdFilter;
    
    private Long contractTemplateIdFilter;
    
    private String relationObject;
    
    private String relationObjectFilter;
    
    private String notaryDateFilter;
    
    private String notaryDateFromFilter;
    
    private String notaryDateToFilter;
    
    private Long bankIdFilter;
    
    private String notaryPlaceFilter;
    
    private Long notaryIdFilter;
    
    private Long drafterIdFilter;
    
//    private String contractStatusFilter;
//    
//    private Boolean errorStatusFilter;
//    
//    private Boolean additionStatusFilter;
//    
//    private Boolean cancellationStatusFilter;
    
    private String contractSummaryFilter;
    
    private String propertyInfoFilter;
    
    private String keySearch;
    
    private String keyHighLight;
    
//    private List<ContractInfo> contractList;
    
    private List<ContractTemplateInfo> contractTemplateList;
    
    private List<ContractKindTreeNode> contractKindTree;
    
    private List<UserInfo> notaryList;
    
    private List<UserInfo> drafterList;
    
    private List<BankInfo> bankList;
    
    private Boolean isHidePanelSearch = Boolean.FALSE;
    
    private Boolean isAdvanceSearch = Boolean.TRUE;
    
    private List<TemporaryContractInfo> contractList;
    
    /**
     * Get the contractSearchFilter
     *
     * @return the contractSearchFilter
     */
    public String getContractSearchFilter() {
        return contractSearchFilter;
    }


    /**
     * Set the contractSearchFilter
     *
     * @param contractSearchFilter the contractSearchFilter to set
     */
    public void setContractSearchFilter(String contractSearchFilter) {
        this.contractSearchFilter = contractSearchFilter;
    }

    /**
     * Get the contractList
     *
     * @return the contractList
     */
    public List<TemporaryContractInfo> getContractList() {
        return contractList;
    }


    /**
     * Set the contractList
     *
     * @param contractList the contractList to set
     */
    public void setContractList(List<TemporaryContractInfo> contractList) {
        this.contractList = contractList;
    }
    

    /**
	 * @return the contractKindIdFilter
	 */
	public Long getContractKindIdFilter() {
		return contractKindIdFilter;
	}


	/**
	 * @param contractKindIdFilter the contractKindIdFilter to set
	 */
	public void setContractKindIdFilter(Long contractKindIdFilter) {
		this.contractKindIdFilter = contractKindIdFilter;
	}


	/**
	 * @return the contractTemplateIdFilter
	 */
	public Long getContractTemplateIdFilter() {
		return contractTemplateIdFilter;
	}


	/**
	 * @param contractTemplateIdFilter the contractTemplateIdFilter to set
	 */
	public void setContractTemplateIdFilter(Long contractTemplateIdFilter) {
		this.contractTemplateIdFilter = contractTemplateIdFilter;
	}


	/**
	 * @return the relationObject
	 */
	public String getRelationObject() {
		return relationObject;
	}


	/**
	 * @param relationObject the relationObject to set
	 */
	public void setRelationObject(String relationObject) {
		this.relationObject = relationObject;
	}


	/**
	 * @return the relationObjectFilter
	 */
	public String getRelationObjectFilter() {
		return relationObjectFilter;
	}


	/**
	 * @param relationObjectFilter the relationObjectFilter to set
	 */
	public void setRelationObjectFilter(String relationObjectFilter) {
		this.relationObjectFilter = relationObjectFilter;
	}


	/**
	 * @return the notaryDateFilter
	 */
	public String getNotaryDateFilter() {
		return notaryDateFilter;
	}


	/**
	 * @param notaryDateFilter the notaryDateFilter to set
	 */
	public void setNotaryDateFilter(String notaryDateFilter) {
		this.notaryDateFilter = notaryDateFilter;
	}


	/**
	 * @return the notaryDateFromFilter
	 */
	public String getNotaryDateFromFilter() {
		return notaryDateFromFilter;
	}


	/**
	 * @param notaryDateFromFilter the notaryDateFromFilter to set
	 */
	public void setNotaryDateFromFilter(String notaryDateFromFilter) {
		this.notaryDateFromFilter = notaryDateFromFilter;
	}


	/**
	 * @return the notaryDateToFilter
	 */
	public String getNotaryDateToFilter() {
		return notaryDateToFilter;
	}


	/**
	 * @param notaryDateToFilter the notaryDateToFilter to set
	 */
	public void setNotaryDateToFilter(String notaryDateToFilter) {
		this.notaryDateToFilter = notaryDateToFilter;
	}


	/**
	 * @return the bankIdFilter
	 */
	public Long getBankIdFilter() {
		return bankIdFilter;
	}


	/**
	 * @param bankIdFilter the bankIdFilter to set
	 */
	public void setBankIdFilter(Long bankIdFilter) {
		this.bankIdFilter = bankIdFilter;
	}


	/**
	 * @return the notaryPlaceFilter
	 */
	public String getNotaryPlaceFilter() {
		return notaryPlaceFilter;
	}


	/**
	 * @param notaryPlaceFilter the notaryPlaceFilter to set
	 */
	public void setNotaryPlaceFilter(String notaryPlaceFilter) {
		this.notaryPlaceFilter = notaryPlaceFilter;
	}


	/**
	 * @return the notaryIdFilter
	 */
	public Long getNotaryIdFilter() {
		return notaryIdFilter;
	}


	/**
	 * @param notaryIdFilter the notaryIdFilter to set
	 */
	public void setNotaryIdFilter(Long notaryIdFilter) {
		this.notaryIdFilter = notaryIdFilter;
	}


	/**
	 * @return the drafterIdFilter
	 */
	public Long getDrafterIdFilter() {
		return drafterIdFilter;
	}


	/**
	 * @param drafterIdFilter the drafterIdFilter to set
	 */
	public void setDrafterIdFilter(Long drafterIdFilter) {
		this.drafterIdFilter = drafterIdFilter;
	}


	/**
	 * @return the contractSummaryFilter
	 */
	public String getContractSummaryFilter() {
		return contractSummaryFilter;
	}


	/**
	 * @param contractSummaryFilter the contractSummaryFilter to set
	 */
	public void setContractSummaryFilter(String contractSummaryFilter) {
		this.contractSummaryFilter = contractSummaryFilter;
	}


	/**
	 * @return the propertyInfoFilter
	 */
	public String getPropertyInfoFilter() {
		return propertyInfoFilter;
	}


	/**
	 * @param propertyInfoFilter the propertyInfoFilter to set
	 */
	public void setPropertyInfoFilter(String propertyInfoFilter) {
		this.propertyInfoFilter = propertyInfoFilter;
	}


	/**
	 * @return the keySearch
	 */
	public String getKeySearch() {
		return keySearch;
	}


	/**
	 * @param keySearch the keySearch to set
	 */
	public void setKeySearch(String keySearch) {
		this.keySearch = keySearch;
	}


	/**
	 * @return the keyHighLight
	 */
	public String getKeyHighLight() {
		return keyHighLight;
	}


	/**
	 * @param keyHighLight the keyHighLight to set
	 */
	public void setKeyHighLight(String keyHighLight) {
		this.keyHighLight = keyHighLight;
	}


	/**
	 * @return the contractTemplateList
	 */
	public List<ContractTemplateInfo> getContractTemplateList() {
		return contractTemplateList;
	}


	/**
	 * @param contractTemplateList the contractTemplateList to set
	 */
	public void setContractTemplateList(
			List<ContractTemplateInfo> contractTemplateList) {
		this.contractTemplateList = contractTemplateList;
	}


	/**
	 * @return the contractKindTree
	 */
	public List<ContractKindTreeNode> getContractKindTree() {
		return contractKindTree;
	}


	/**
	 * @param contractKindTree the contractKindTree to set
	 */
	public void setContractKindTree(List<ContractKindTreeNode> contractKindTree) {
		this.contractKindTree = contractKindTree;
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
	 * @return the drafterList
	 */
	public List<UserInfo> getDrafterList() {
		return drafterList;
	}


	/**
	 * @param drafterList the drafterList to set
	 */
	public void setDrafterList(List<UserInfo> drafterList) {
		this.drafterList = drafterList;
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
	 * @return the isHidePanelSearch
	 */
	public Boolean getIsHidePanelSearch() {
		return isHidePanelSearch;
	}


	/**
	 * @param isHidePanelSearch the isHidePanelSearch to set
	 */
	public void setIsHidePanelSearch(Boolean isHidePanelSearch) {
		this.isHidePanelSearch = isHidePanelSearch;
	}


	/**
	 * @return the isAdvanceSearch
	 */
	public Boolean getIsAdvanceSearch() {
		return isAdvanceSearch;
	}


	/**
	 * @param isAdvanceSearch the isAdvanceSearch to set
	 */
	public void setIsAdvanceSearch(Boolean isAdvanceSearch) {
		this.isAdvanceSearch = isAdvanceSearch;
	}


	public void reset(TemporaryContractListForm form) {
		this.contractNumberFilter = form.getContractNumberFilter();
        this.contractSearchFilter = form.getContractSearchFilter();
        this.bankIdFilter = form.getBankIdFilter();
        this.contractTemplateIdFilter = form.getContractTemplateIdFilter();
        this.drafterIdFilter = form.getDrafterIdFilter();
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
    }


	/**
	 * @param contractNumberFilter the contractNumberFilter to set
	 */
	public void setContractNumberFilter(String contractNumberFilter) {
		this.contractNumberFilter = contractNumberFilter;
	}


	/**
	 * @return the contractNumberFilter
	 */
	public String getContractNumberFilter() {
		return contractNumberFilter;
	}
}
