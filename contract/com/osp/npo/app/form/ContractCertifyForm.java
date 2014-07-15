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
import com.osp.npo.app.viewhelper.ContractCertifyViewHelper;
import com.osp.npo.common.util.EditString;
import com.osp.npo.common.util.RelateDateTime;

/**
 * @author SonHD
 * @version $Revision: 28677 $
 */
public class ContractCertifyForm extends ActionForm {

    private static final long serialVersionUID = 8600816180962493710L;
    private static final String NOTARY_IN_DAY = "01";
    private static final String NOTARY_IN_MONTH = "03";
    private static final String NOTARY_IN_YEAR = "04";
    private static final String NOTARY_IN_RANGE = "05";
    
    private String notaryDateFilter;    
    private String notaryDateFromFilter;    
    private String notaryDateToFilter;
    private String notaryDayFilter;
    private String notaryMonMonthFilter;
    private String notaryMonYearFilter;
    private String notaryYearFilter;
    private Long[] chkID;
    private Boolean sortType;
    
   
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
     * Get the notaryDayFilter
     *
     * @return the notaryDayFilter
     */
    public String getNotaryDayFilter() {
        return notaryDayFilter;
    }
    /**
     * Set the notaryDayFilter
     *
     * @param notaryDayFilter the notaryDayFilter to set
     */
    public void setNotaryDayFilter(String notaryDayFilter) {
        this.notaryDayFilter = notaryDayFilter;
    }
    /**
     * Get the notaryMonMonthFilter
     *
     * @return the notaryMonMonthFilter
     */
    public String getNotaryMonMonthFilter() {
        return notaryMonMonthFilter;
    }
    /**
     * Set the notaryMonMonthFilter
     *
     * @param notaryMonMonthFilter the notaryMonMonthFilter to set
     */
    public void setNotaryMonMonthFilter(String notaryMonMonthFilter) {
        this.notaryMonMonthFilter = notaryMonMonthFilter;
    }
    /**
     * Get the notaryMonYearFilter
     *
     * @return the notaryMonYearFilter
     */
    public String getNotaryMonYearFilter() {
        return notaryMonYearFilter;
    }
    /**
     * Set the notaryMonYearFilter
     *
     * @param notaryMonYearFilter the notaryMonYearFilter to set
     */
    public void setNotaryMonYearFilter(String notaryMonYearFilter) {
        this.notaryMonYearFilter = notaryMonYearFilter;
    }
    /**
     * Get the notaryYearFilter
     *
     * @return the notaryYearFilter
     */
    public String getNotaryYearFilter() {
        return notaryYearFilter;
    }
    /**
     * Set the notaryYearFilter
     *
     * @param notaryYearFilter the notaryYearFilter to set
     */
    public void setNotaryYearFilter(String notaryYearFilter) {
        this.notaryYearFilter = notaryYearFilter;
    }
    
    
	public Long[] getChkID() {
		return chkID;
	}
	public void setChkID(Long[] chkID) {
		this.chkID = chkID;
	}
	/**
	 * @param sortType the sortType to set
	 */
	public void setSortType(Boolean sortType) {
		this.sortType = sortType;
	}
	/**
	 * @return the sortType
	 */
	public Boolean getSortType() {
		return sortType;
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
        
        ContractCertifyViewHelper contractCertifyViewHelper = (ContractCertifyViewHelper) request.getSession().getAttribute(ContractCertifyViewHelper.SESSION_KEY);
       
        if (contractCertifyViewHelper == null) {
            return errors;
        }
        
        if (EditString.isNull(getNotaryDateFilter())) {
            errors.add(messageUtil.createActionMessages("notaryDateFilter", request, "err_not_input_data", "item_notary_date")); 
        }
        if (NOTARY_IN_DAY.equals(getNotaryDateFilter())) {
            Timestamp toDay = RelateDateTime.toTimestamp(false, getNotaryDayFilter());
            if (!EditString.isNull(getNotaryDayFilter()) && toDay == null) {
                errors.add(messageUtil.createActionMessages("notaryDay", request, "err_not_regular", "item_notary_date"));
                
            }
        }
        if (NOTARY_IN_MONTH.equals(getNotaryDateFilter())) {
            try {
                int month = Integer.parseInt(getNotaryMonMonthFilter());
                if ((month < 1) || (month > 12)) {
                    errors.add(messageUtil.createActionMessages("notaryMonth", request, "err_not_regular", "item_notary_month"));
                }
            } catch (Exception ex) {
                errors.add(messageUtil.createActionMessages("notaryMonth", request, "err_not_regular", "item_notary_month"));
            }
            try {
                int year = Integer.parseInt(getNotaryMonYearFilter());
                if ((year < 1970) || (year > 2037)) {
                    errors.add(messageUtil.createActionMessages("notaryMonth", request, "err_not_regular", "item_notary_year"));
                }
            } catch (Exception ex) {
                errors.add(messageUtil.createActionMessages("notaryMonth", request, "err_not_regular", "item_notary_year"));
            }
        }
        if (NOTARY_IN_YEAR.equals(getNotaryDateFilter())) {
            try {
                int year = Integer.parseInt(getNotaryYearFilter());
                if ((year < 1970) || (year > 2037)) {
                    errors.add(messageUtil.createActionMessages("notaryYear", request, "err_not_regular", "item_notary_year"));
                }
            } catch (Exception ex) {
                errors.add(messageUtil.createActionMessages("notaryYear", request, "err_not_regular", "item_notary_year"));
            }
            
        }
        if (NOTARY_IN_RANGE.equals(getNotaryDateFilter())) {
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
        contractCertifyViewHelper.reset(this);
        
        return errors;
    }
}
