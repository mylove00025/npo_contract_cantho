package com.osp.npo.app.context;

/**
 * <P>Temporary Contract context</P>
 * 
 * @author SonHD 
 * @version $Revision: 25477 $
 */
public class TemporaryContractContext {
    
    public static final String SESSION_KEY = "temporaryContractContext";
    
    private String contractNumberFilter;
    
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
    
    private String contractSummaryFilter;
    
    private String propertyInfoFilter;
    
    private String keySearch;
    
    private Boolean isHidePanelSearch = Boolean.FALSE;
    
    private Boolean isAdvanceSearch = Boolean.FALSE;

    private String contractSearchFilter;

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
	


	/**
	 * @return the contractSearchFilter
	 */
	public String getContractSearchFilter() {
		return contractSearchFilter;
	}



	/**
	 * @param contractSearchFilter the contractSearchFilter to set
	 */
	public void setContractSearchFilter(String contractSearchFilter) {
		this.contractSearchFilter = contractSearchFilter;
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

	public void clear() {
		this.contractNumberFilter = null;
		this.contractSearchFilter = null;
        this.bankIdFilter = null;
        this.contractKindIdFilter = null;
        this.contractTemplateIdFilter = null;
        this.drafterIdFilter = null;
        this.notaryDateFilter = null;
        this.notaryDateFromFilter = null;
        this.notaryDateToFilter = null;
        this.notaryIdFilter = null;
        this.notaryPlaceFilter = null;
        this.relationObject = null;
        this.relationObjectFilter = null;         
        this.contractSummaryFilter = null;
        this.propertyInfoFilter = null;
        this.keySearch = null;
    }




}
