package com.osp.npo.app.form;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.osp.npo.app.message.MessageUtil;
import com.osp.npo.app.viewhelper.ContractListViewHelper;
import com.osp.npo.common.util.EditString;
import com.osp.npo.common.util.RelateDateTime;

/**
 * <P>Contract List Form</P>
 * 
 * @author HungPT 
 * @version $Revision: 29615 $
 */
public class ContractListForm extends ActionForm {
   
    private static final long serialVersionUID = -5898624927964782224L;

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
    
    private String direction;
    
    private Boolean isHidePanelSearch = Boolean.FALSE;
    
    private Boolean isAdvanceSearch = Boolean.FALSE;

    /**
     * Get the contractNumberFilter
     *
     * @return the contractNumberFilter
     */
    public String getContractNumberFilter() {
        if (contractNumberFilter != null) {
            return contractNumberFilter.trim();
        }
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
     * Get the relationObjectNameFilter
     *
     * @return the relationObjectNameFilter
     */
    public String getRelationObjectFilter() {
        if (relationObjectFilter != null) {
            return relationObjectFilter.trim();
        }
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
        if (notaryDateFromFilter != null) {
            return notaryDateFromFilter.trim();
        }
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
        if (notaryDateToFilter != null) {
            return notaryDateToFilter.trim();
        }
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
        if (notaryPlaceFilter != null) {
            return notaryPlaceFilter.trim();
        }
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
     * Get the direction
     *
     * @return the direction
     */
    public String getDirection() {
        return direction;
    }

    /**
     * Set the direction
     *
     * @param direction the direction to set
     */
    public void setDirection(String direction) {
        this.direction = direction;
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
     * Get the contractSummaryFilter
     *
     * @return the contractSummaryFilter
     */
    public String getContractSummaryFilter() {
        if (contractSummaryFilter != null) {
            return contractSummaryFilter.trim();
        }
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
        if (propertyInfoFilter != null) {
            return propertyInfoFilter.trim();
        }
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

    /*
     * (non-Javadoc)
     * 
     * @see org.apache.struts.action.ActionForm#validate(org.apache.struts.action.ActionMapping,
     *      javax.servlet.http.HttpServletRequest)
     */
    @Override
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        
        ActionErrors errors = new ActionErrors();
        MessageUtil messageUtil = new MessageUtil();
        
        ContractListViewHelper contractListViewHelper = (ContractListViewHelper)request.getSession().getAttribute(ContractListViewHelper.SESSION_KEY);
        if (contractListViewHelper == null) {
            return errors;
        }
        
        if (this.isAdvanceSearch) {
            Timestamp fromDate = RelateDateTime.toTimestamp(false, getNotaryDateFromFilter());
            
            // Start date is null or not correct format
            if (!EditString.isNull(getNotaryDateFromFilter()) && fromDate == null) {
                errors.add(messageUtil.createActionMessages("notaryDate-1", request, "err_not_regular", "item_from_date"));            
            }
            
            Timestamp toDate = RelateDateTime.toTimestamp(false, getNotaryDateToFilter());
            if (!EditString.isNull(getNotaryDateToFilter()) && toDate == null) {
                errors.add(messageUtil.createActionMessages("notaryDate-2", request, "err_not_regular", "item_to_date"));            
            }
            
            if (fromDate != null && toDate != null && toDate.getTime() < fromDate.getTime()) {
                errors.add(messageUtil.createActionMessages("notaryDate", request, "err_start_date_greater_than_end_date", "item_notary_date"));
            }
        }        
        
        contractListViewHelper.reset(this);
        
        return errors;
    }

}
