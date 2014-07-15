package com.osp.npo.app.form;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.osp.npo.app.message.MessageUtil;
import com.osp.npo.app.viewhelper.ContractListViewHelper;
import com.osp.npo.app.viewhelper.TemporaryContractListViewHelper;
import com.osp.npo.common.util.EditString;
import com.osp.npo.common.util.RelateDateTime;

/**
 * <P>Temporary Contract List Form</P>
 * 
 * @author SonHD 
 * @version $Revision: 25547 $
 */
public class TemporaryContractListForm extends ActionForm {

    private static final long serialVersionUID = -3179098143240509228L;

    private String contractSearchFilter;
    
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
    
//    private String contractStatusFilter;
    
//    private Boolean errorStatusFilter;
//    
//    private Boolean additionStatusFilter;
//    
//    private Boolean cancellationStatusFilter;

    private String contractSummaryFilter;
    
    private String propertyInfoFilter;
    
    private String keySearch;
    
    private String direction;
    
    private Boolean isHidePanelSearch = Boolean.FALSE;
    
    private Boolean isAdvanceSearch = Boolean.TRUE;
    
    /**
     * Get the contractSearchFilter
     *
     * @return the contractSearchFilter
     */
    public String getContractSearchFilter() {
        if (contractSearchFilter != null) {
            return contractSearchFilter.trim();
        }
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
		if(relationObject != null)
			return relationObject.trim();
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
		if(relationObjectFilter != null)
			return relationObjectFilter.trim();
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
		if(contractSummaryFilter != null)
			return contractSummaryFilter.trim();
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
		if(propertyInfoFilter != null)
			return propertyInfoFilter.trim();
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
public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        
        ActionErrors errors = new ActionErrors();
        MessageUtil messageUtil = new MessageUtil();
        
        TemporaryContractListViewHelper temporaryContractListViewHelper = (TemporaryContractListViewHelper)request.getSession().getAttribute(TemporaryContractListViewHelper.SESSION_KEY);
        if (temporaryContractListViewHelper == null) {
            return errors;
        }
        
//        if (this.isAdvanceSearch) {
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
            errors.add(messageUtil.createActionMessages("notaryDate", request, "err_start_date_greater_than_end_date", "item_entry_date"));
        }
//        }        
        
        temporaryContractListViewHelper.reset(this);
        
        return errors;
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
	if(contractNumberFilter != null)
		return contractNumberFilter.trim();
	return contractNumberFilter;
}
    
    
}
