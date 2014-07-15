package com.osp.npo.app.form;

import java.sql.Timestamp;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.osp.npo.app.context.ContractByNotaryListContext;
import com.osp.npo.app.message.MessageUtil;
import com.osp.npo.app.viewhelper.ContractByNotaryListViewHelper;
import com.osp.npo.common.util.EditString;
import com.osp.npo.common.util.RelateDateTime;
import com.osp.npo.core.contract.ContractInfo;
import com.osp.npo.core.user.UserInfo;

/**
 *
 * Contract By Notary List Form
 *
 * @author GiangVT
 * @version $Revision: 22068 $
 */
public class ContractByNotaryListForm extends ActionForm {

    private static final long serialVersionUID = -5669404898256526300L;
    public static final String NOTARY_IN_WEEK = "00";
    public static final String NOTARY_IN_DAY = "01";
    public static final String NOTARY_IN_MONTH = "02";
    public static final String NOTARY_IN_YEAR = "03";
    public static final String NOTARY_IN_RANGE = "04";

    private List<ContractInfo> contractList;
    private List<UserInfo> notaryList;
    private String[] selectedNotaryList;
    private Boolean checkAllValue;
    private Boolean isHidePanelSearch;
    private Long notaryIdFilter;
    private String searchDate;
    private String fromDate;
    private String toDate;
    private String direction;
    private String pagerState;

    /**
     *
     * @see org.apache.struts.action.ActionForm#validate(org.apache.struts.action.ActionMapping, javax.servlet.http.HttpServletRequest)
     */
    @Override
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();
        MessageUtil messageUtil = new MessageUtil();

        ContractByNotaryListViewHelper view = (ContractByNotaryListViewHelper)
            request.getSession().getAttribute(ContractByNotaryListViewHelper.SESSION_KEY);
        ContractByNotaryListContext context = (ContractByNotaryListContext)request.getSession().getAttribute(ContractByNotaryListContext.SESSION_KEY);
        if (view == null || context == null) {
            return errors;
        }

        if (NOTARY_IN_RANGE.equals(searchDate)) {
            // Start date is null or not correct format
            Timestamp fromDate = RelateDateTime.toTimestamp(false, getFromDate());
            if ((!EditString.isNull(getFromDate())) && (fromDate == null)) {
                errors.add(messageUtil.createActionMessages("fromDate", request, "err_not_regular", "item_from_date"));
            }

            Timestamp toDate = RelateDateTime.toTimestamp(false, getToDate());
            if ((!EditString.isNull(getToDate())) && (toDate == null)) {
                errors.add(messageUtil.createActionMessages("toDate", request, "err_not_regular", "item_to_date"));
            }

            if (fromDate != null && toDate != null && toDate.getTime() < fromDate.getTime()) {
                errors.add(messageUtil.createActionMessages("searchFromToDate", request, "err_start_date_greater_than_end_date", "item_require_send_date"));
            }
        }

        if (!errors.isEmpty()) {
            view.reset(this);
        }

        return errors;
    }

    /**
     * @return the contractList
     */
    public List<ContractInfo> getContractList() {
        return contractList;
    }
    /**
     * @param contractList the contractList to set
     */
    public void setContractList(List<ContractInfo> contractList) {
        this.contractList = contractList;
    }
    /**
     * @return the notaryList
     */
    public List<UserInfo> getNotaryList() {
        return notaryList;
    }

    /**
     * @param notaryList the notaryList to set
     */
    public void setNotaryList(List<UserInfo> notaryList) {
        this.notaryList = notaryList;
    }

    /**
     * @return the selectedNotaryList
     */
    public String[] getSelectedNotaryList() {
        if (selectedNotaryList == null) {
            return new String[]{"0"};
        }
        return selectedNotaryList;
    }

    /**
     * @param selectedNotaryList the selectedNotaryList to set
     */
    public void setSelectedNotaryList(String[] selectedNotaryList) {
        this.selectedNotaryList = selectedNotaryList;
    }

    /**
     * @return the searchDate
     */
    public String getSearchDate() {
        return searchDate;
    }
    /**
     * @param searchDate the searchDate to set
     */
    public void setSearchDate(String searchDate) {
        this.searchDate = searchDate;
    }
    /**
     * @return the fromDate
     */
    public String getFromDate() {
        if (fromDate != null) {
            return fromDate.trim();
        }
        return null;
    }
    /**
     * @param fromDate the fromDate to set
     */
    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }
    /**
     * @return the toDate
     */
    public String getToDate() {
        if (toDate != null) {
            return toDate.trim();
        }
        return null;
    }
    /**
     * @param toDate the toDate to set
     */
    public void setToDate(String toDate) {
        this.toDate = toDate;
    }
    /**
     * @return the direction
     */
    public String getDirection() {
        return direction;
    }
    /**
     * @param direction the direction to set
     */
    public void setDirection(String direction) {
        this.direction = direction;
    }
    /**
     * @return the pagerState
     */
    public String getPagerState() {
        return pagerState;
    }
    /**
     * @param pagerState the pagerState to set
     */
    public void setPagerState(String pagerState) {
        this.pagerState = pagerState;
    }

    /**
     * @return the checkAllValue
     */
    public Boolean getCheckAllValue() {
        return checkAllValue;
    }

    /**
     * @param checkAllValue the checkAllValue to set
     */
    public void setCheckAllValue(Boolean checkAllValue) {
        this.checkAllValue = checkAllValue;
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
}
