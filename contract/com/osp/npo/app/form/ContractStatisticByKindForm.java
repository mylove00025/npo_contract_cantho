package com.osp.npo.app.form;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.osp.npo.app.message.MessageUtil;
import com.osp.npo.app.viewhelper.ContractStatisticByKindViewHelper;
import com.osp.npo.common.util.EditString;
import com.osp.npo.common.util.RelateDateTime;

/**
 * <P>Contract Statistic Form</P>
 * 
 * @author HungPT 
 * @version $Revision: 18266 $
 */
public class ContractStatisticByKindForm extends ActionForm {

    private static final long serialVersionUID = -3112530903369263571L;

    private String notaryDateFilter;
    
    private String notaryDateFromFilter;
    
    private String notaryDateToFilter;

    /**
     * Get the notaryDateFilter
     *
     * @return the notaryDateFilter
     */
    public String getNotaryDateFilter() {
    	if (notaryDateFilter != null) {
    		return notaryDateFilter.trim();
    	}
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
        
        ContractStatisticByKindViewHelper contractStatisticByKindViewHelper = (ContractStatisticByKindViewHelper) request.getSession().getAttribute(
                ContractStatisticByKindViewHelper.SESSION_KEY);
        if (contractStatisticByKindViewHelper == null) {
            return errors;
        }
        
        if (EditString.isNull(getNotaryDateFilter())) {
            errors.add(messageUtil.createActionMessages("notaryDateFilter", request, "err_not_input_data", "item_notary_date")); 
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
        
        contractStatisticByKindViewHelper.reset(this);
        
        return errors;
    }
}
