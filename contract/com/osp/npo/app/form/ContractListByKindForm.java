/**
 * 
 */
package com.osp.npo.app.form;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.osp.npo.app.message.MessageUtil;
import com.osp.npo.app.viewhelper.ContractListByKindViewHelper;
import com.osp.npo.common.util.EditString;
import com.osp.npo.common.util.RelateDateTime;

/**
 * @author SonHD
 * @version $Revision: 19228 $
 */
public class ContractListByKindForm extends ActionForm {

    private static final long serialVersionUID = 7162504881896739719L;
    
    private Long contractKindIdFilter;
    private String notaryDateFilter;    
    private String notaryDateFromFilter;    
    private String notaryDateToFilter;
    private String direction;
    private Boolean isHidePanelSearch = Boolean.FALSE;
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
        
        ContractListByKindViewHelper contractListByKindViewHelper = (ContractListByKindViewHelper)request.getSession().getAttribute(ContractListByKindViewHelper.SESSION_KEY);
        if (contractListByKindViewHelper == null) {
            return errors;
        }
        
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
        
        contractListByKindViewHelper.reset(this);
        
        return errors;
    }
}
