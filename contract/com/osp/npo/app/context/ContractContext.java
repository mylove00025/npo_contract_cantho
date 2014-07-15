package com.osp.npo.app.context;

/**
 * <P>Contract context</P>
 * 
 * @author HungPT 
 * @version $Revision: 29615 $
 */
public class ContractContext {
    
    public static final String SESSION_KEY = "contractContext";
    
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
    
    private Boolean isHidePanelSearch = Boolean.FALSE;
    
    private Boolean isAdvanceSearch = Boolean.FALSE;

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
     * Set the contractTemplateIdFilter
     *
     * @param contractTemplateIdFilter the contractTemplateIdFilter to set
     */
    public void setContractTemplateIdFilter(Long contractTemplateIdFilter) {
        this.contractTemplateIdFilter = contractTemplateIdFilter;
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

    public void clear() {
        this.additionStatusFilter = null;
        this.bankIdFilter = null;
        this.cancellationStatusFilter = null;
        this.contractNumberFilter = null;
        this.contractKindIdFilter = null;
        this.contractTemplateIdFilter = null;
        this.contractTemplateNameFilter = null;
        this.drafterIdFilter = null;
        this.errorStatusFilter = null;
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
        this.contractStatusFilter = null;
    }
}
