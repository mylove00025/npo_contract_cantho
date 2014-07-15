package com.osp.npo.app.form;

import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.osp.npo.app.message.MessageUtil;
import com.osp.npo.app.viewhelper.ContractErrorListViewHelper;
import com.osp.npo.common.util.EditString;
import com.osp.npo.common.util.RelateDateTime;
import com.osp.npo.core.contract.ContractInfo;
import com.osp.npo.core.user.UserInfo;

/**
 * <P>Contract List Form</P>
 * 
 * @author SonHD
 * @version $Revision: 19673 $
 */
@SuppressWarnings("serial")
public class ContractErrorListForm extends ActionForm {
    
    public static final String NOTARY_IN_ALL = "00";
    public static final String NOTARY_IN_DAY = "01";
    public static final String NOTARY_IN_WEEK = "02";
    public static final String NOTARY_IN_MONTH = "03";
    public static final String NOTARY_IN_YEAR = "04";
    public static final String NOTARY_IN_RANGE = "05";
    
    private Long id;
    private String fromDate;
    private String toDate;
    private String searchDate;
    private String notaryUser;
    private String drafter;
    private List<ContractInfo> contractErrorList;
    private List<UserInfo> contractNotaryList;
    private List<UserInfo> contractDrafterList;
    private Long contractNotaryId;
    private Long contractDrafterId;
    private String direction;
    
    private Boolean isHidePanelSearch;
    
    @Override
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();
        MessageUtil messageUtil = new MessageUtil();

        ContractErrorListViewHelper view = (ContractErrorListViewHelper)
            request.getSession().getAttribute(ContractErrorListViewHelper.SESSION_KEY);
        if (view == null) {
            return errors;  
        }

        if (NOTARY_IN_RANGE.equals(searchDate)) {
         // Start date is null or not correct format
            Timestamp fromDate = RelateDateTime.toTimestamp(false, getFromDate());
            if ((!EditString.isNull(getFromDate())) && (fromDate == null)) {
                errors.add(messageUtil.createActionMessages("fromDate", request, "err_not_regular", "item_notary_date_from"));
            }

            Timestamp toDate = RelateDateTime.toTimestamp(false, getToDate());
            if ((!EditString.isNull(getToDate())) && (toDate == null)) {
                errors.add(messageUtil.createActionMessages("toDate", request, "err_not_regular", "item_notary_date_to"));
            }

            if (fromDate != null && toDate != null && toDate.getTime() < fromDate.getTime()) {
                errors.add(messageUtil.createActionMessages("searchFromToDate", request, "err_start_date_greater_than_end_date", "item_notary_date"));
            }
        } 

        view.reset(this);

        return errors;
    }
    
    /**
     * Get the id
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }
    /**
     * Set the id
     *
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }
    /**
     * Get the fromDate
     *
     * @return the fromDate
     */
    public String getFromDate() {
        if(!EditString.isNull(fromDate)){
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
     * Get the toDate
     *
     * @return the toDate
     */
    public String getToDate() {
        if(!EditString.isNull(toDate)){
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
     * Get the searchDate
     *
     * @return the searchDate
     */
    public String getSearchDate() {
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
     * Get the notaryUser
     *
     * @return the notaryUser
     */
    public String getNotaryUser() {
        return notaryUser;
    }
    /**
     * Set the notaryUser
     *
     * @param notaryUser the notaryUser to set
     */
    public void setNotaryUser(String notaryUser) {
        this.notaryUser = notaryUser;
    }
    /**
     * Get the drafter
     *
     * @return the drafter
     */
    public String getDrafter() {
        return drafter;
    }
    /**
     * Set the drafter
     *
     * @param drafter the drafter to set
     */
    public void setDrafter(String drafter) {
        this.drafter = drafter;
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
     * Get the contractErrorList
     *
     * @return the contractErrorList
     */
    public List<ContractInfo> getContractErrorList() {
        return contractErrorList;
    }
    /**
     * Set the contractErrorList
     *
     * @param contractErrorList the contractErrorList to set
     */
    public void setContractErrorList(List<ContractInfo> contractErrorList) {
        this.contractErrorList = contractErrorList;
    }
    /**
     * Get the contractNotaryList
     *
     * @return the contractNotaryList
     */
    public List<UserInfo> getContractNotaryList() {
        return contractNotaryList;
    }
    /**
     * Set the contractNotaryList
     *
     * @param contractNotaryList the contractNotaryList to set
     */
    public void setContractNotaryList(List<UserInfo> contractNotaryList) {
        this.contractNotaryList = contractNotaryList;
    }
    /**
     * Get the contractDrafterList
     *
     * @return the contractDrafterList
     */
    public List<UserInfo> getContractDrafterList() {
        return contractDrafterList;
    }
    /**
     * Set the contractDrafterList
     *
     * @param contractDrafterList the contractDrafterList to set
     */
    public void setContractDrafterList(List<UserInfo> contractDrafterList) {
        this.contractDrafterList = contractDrafterList;
    }
    /**
     * Get the contractNotaryId
     *
     * @return the contractNotaryId
     */
    public Long getContractNotaryId() {
        return contractNotaryId;
    }
    /**
     * Set the contractNotaryId
     *
     * @param contractNotaryId the contractNotaryId to set
     */
    public void setContractNotaryId(Long contractNotaryId) {
        this.contractNotaryId = contractNotaryId;
    }
    /**
     * Get the contractDrafterId
     *
     * @return the contractDrafterId
     */
    public Long getContractDrafterId() {
        return contractDrafterId;
    }
    /**
     * Set the contractDrafterId
     *
     * @param contractDrafterId the contractDrafterId to set
     */
    public void setContractDrafterId(Long contractDrafterId) {
        this.contractDrafterId = contractDrafterId;
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
    
}
