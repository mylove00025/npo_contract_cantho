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
import com.osp.npo.app.viewhelper.AccessHistoryViewHelper;
import com.osp.npo.common.util.EditString;
import com.osp.npo.common.util.RelateDateTime;

/**
 * @author Truongnd
 * @version $Revision: 19228 $
 */
public class AccessHistoryForm extends ActionForm {

    /**
	 * 
	 */
	private static final long serialVersionUID = 5780030864652328159L;
	
	private Long userIdFilter;
    private Byte accessTypeFilter;
    private String executeDateTimeFilter;    
    private String accessDateFromFilter;    
    private String accessDateToFilter;
    private String direction;
    private Boolean isHidePanelSearch = Boolean.FALSE;

    /**
     * Get the executeDateTimeFilter
     *
     * @return the executeDateTimeFilter
     */
    public String getExecuteDateTimeFilter() {
        return executeDateTimeFilter;
    }


    /**
     * Set the executeDateTimeFilter
     *
     * @param executeDateTimeFilter the executeDateTimeFilter to set
     */
    public void setExecuteDateTimeFilter(String executeDateTimeFilter) {
        this.executeDateTimeFilter = executeDateTimeFilter;
    }


    /**
     * Get the accessDateFromFilter
     *
     * @return the accessDateFromFilter
     */
    public String getAccessDateFromFilter() {
        return accessDateFromFilter;
    }


    /**
     * Set the accessDateFromFilter
     *
     * @param accessDateFromFilter the accessDateFromFilter to set
     */
    public void setAccessDateFromFilter(String accessDateFromFilter) {
        this.accessDateFromFilter = accessDateFromFilter;
    }


    /**
     * Get the accessDateToFilter
     *
     * @return the accessDateToFilter
     */
    public String getAccessDateToFilter() {
        return accessDateToFilter;
    }


    /**
     * Set the accessDateToFilter
     *
     * @param accessDateToFilter the accessDateToFilter to set
     */
    public void setAccessDateToFilter(String accessDateToFilter) {
        this.accessDateToFilter = accessDateToFilter;
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
        
        AccessHistoryViewHelper contractListByKindViewHelper = (AccessHistoryViewHelper)request.getSession().getAttribute(AccessHistoryViewHelper.SESSION_KEY);
        if (contractListByKindViewHelper == null) {
            return errors;
        }
        
        Timestamp fromDate = RelateDateTime.toTimestamp(false, getAccessDateFromFilter());
        
        // Start date is null or not correct format
        if (!EditString.isNull(getAccessDateFromFilter()) && fromDate == null) {
            errors.add(messageUtil.createActionMessages("notaryDate-1", request, "err_not_regular", "item_from_date"));            
        }
        
        Timestamp toDate = RelateDateTime.toTimestamp(false, getAccessDateToFilter());
        if (!EditString.isNull(getAccessDateToFilter()) && toDate == null) {
            errors.add(messageUtil.createActionMessages("notaryDate-2", request, "err_not_regular", "item_to_date"));            
        }
        
        if (fromDate != null && toDate != null && toDate.getTime() < fromDate.getTime()) {
            errors.add(messageUtil.createActionMessages("notaryDate", request, "err_start_date_greater_than_end_date", "item_notary_date"));
        }
        
        contractListByKindViewHelper.reset(this);
        
        return errors;
    }


	/**
	 * @param userIdFilter the userIdFilter to set
	 */
	public void setUserIdFilter(Long userIdFilter) {
		this.userIdFilter = userIdFilter;
	}


	/**
	 * @return the userIdFilter
	 */
	public Long getUserIdFilter() {
		return userIdFilter;
	}


	/**
	 * @param accessTypeFilter the accessTypeFilter to set
	 */
	public void setAccessTypeFilter(Byte accessTypeFilter) {
		if(accessTypeFilter == 2){
			accessTypeFilter = null;
		}
		this.accessTypeFilter = accessTypeFilter;
	}


	/**
	 * @return the accessTypeFilter
	 */
	public Byte getAccessTypeFilter() {
		return accessTypeFilter;
	}
}
