package com.osp.npo.app.form;

import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import com.osp.npo.app.message.MessageUtil;
import com.osp.npo.app.viewhelper.ContractByUserListViewHelper;
import com.osp.npo.common.util.EditString;
import com.osp.npo.common.util.RelateDateTime;
import com.osp.npo.core.contract.ContractInfo;
import com.osp.npo.core.user.UserInfo;

/**
 * <P>Contract List Form</P>
 * 
 * @author KienLT
 * @version $Revision: 19954 $
 */

@SuppressWarnings("serial")
public class ContractByUserListForm extends ActionForm {
    
    private static final String NOTARY_IN_RANGE = "04";

    private List<ContractInfo> contractList;
    private List<UserInfo> userList;
    private String[] selectedUserList;
    private Long selectedUserID;
    private Boolean checkAllValue;
    private String searchDate;
    private String fromDate;
    private String toDate;      
    private String direction;
    private String pagerState;
    
    private Boolean isHidePanelSearch;
    
    /**
     * Get the direction
     *
     * @return the direction
     */
    public String getDirection() {
        if ( direction != null) {
            return direction.trim();
        }
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
     * Get the pagerState
     *
     * @return the pagerState
     */
    public String getPagerState() {
        if (pagerState != null) {
            return pagerState.trim();
        }
        return pagerState;
    }

    /**
     * Set the pagerState
     *
     * @param pagerState the pagerState to set
     */
    public void setPagerState(String pagerState) {
        this.pagerState = pagerState;
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
     * Get the userList
     *
     * @return the userList
     */
    public List<UserInfo> getUserList() {
        return userList;
    }

    /**
     * Set the userList
     *
     * @param userList the userList to set
     */
    public void setUserList(List<UserInfo> userList) {
        this.userList = userList;
    }

    /**
     * Get the selectedUserList
     *
     * @return the selectedUserList
     */
    public String[] getSelectedUserList() {
        if (selectedUserList == null) {
            return new String[]{"0"};
        }
        return selectedUserList;
    }

    /**
     * Set the selectedUserList
     *
     * @param selectedUserList the selectedUserList to set
     */
    public void setSelectedUserList(String[] selectedUserList) {        
        this.selectedUserList = selectedUserList;
    }
   
    /**
     * Get the toDate
     *
     * @return the toDate
     */
    public String getToDate() {
        if (toDate != null) {
            return toDate.trim();
        }
        return toDate;
    }

    /**
     * Set the toDate
     *
     * @param toDate the toDate to set
     */
    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    /**
     * Get the fromDate
     *
     * @return the fromDate
     */
    public String getFromDate() {
        if (fromDate != null) {
            return fromDate.trim();
        }
        return fromDate;
    }

    /**
     * Set the fromDate
     *
     * @param fromDate the fromDate to set
     */
    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    /**
     * Get the searchDate
     *
     * @return the searchDate
     */
    public String getSearchDate() {
        if (searchDate != null) {
            return searchDate.trim();
        }
        return searchDate;
    }

    /**
     * Set the searchDate
     *
     * @param searchDate the searchDate to set
     */
    public void setSearchDate(String searchDate) {
        this.searchDate = searchDate;
    }    
    
    /**
     * Get the checkAllValue
     *
     * @return the checkAllValue
     */
    public Boolean getCheckAllValue() {
        return checkAllValue;
    }

    /**
     * Set the checkAllValue
     *
     * @param checkAllValue the checkAllValue to set
     */
    public void setCheckAllValue(Boolean checkAllValue) {
        this.checkAllValue = checkAllValue;
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
     * Get the selectedUserID
     *
     * @return the selectedUserID
     */
    public Long getSelectedUserID() {
        return selectedUserID;
    }

    /**
     * Set the selectedUserID
     *
     * @param selectedUserID the selectedUserID to set
     */
    public void setSelectedUserID(Long selectedUserID) {
        this.selectedUserID = selectedUserID;
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
        
        ContractByUserListViewHelper view = (ContractByUserListViewHelper)
            request.getSession().getAttribute(ContractByUserListViewHelper.SESSION_KEY);
        if (view == null) {
            return errors;
        }
        
        if (NOTARY_IN_RANGE.equals(searchDate)) {
            Timestamp fromDate = RelateDateTime.toTimestamp(false, getFromDate());
            
            // Start date is null or not correct format
            if (!EditString.isNull(getFromDate()) && fromDate == null) {
                errors.add(messageUtil.createActionMessages("fromDate", request, "err_not_regular", "item_notary_date_from"));            
            }
            
            Timestamp toDate = RelateDateTime.toTimestamp(false, getToDate());
            if (!EditString.isNull(getToDate()) && toDate == null) {
                errors.add(messageUtil.createActionMessages("toDate", request, "err_not_regular", "item_notary_date_to"));            
            }
            
            if (fromDate != null && toDate != null && toDate.getTime() < fromDate.getTime()) {
                errors.add(messageUtil.createActionMessages("searchFromToDate", request, "err_start_date_greater_than_end_date", "item_notary_date"));
            }
        }
        
        view.reset(this);
        
        return errors;
    }
}
