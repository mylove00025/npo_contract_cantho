package com.osp.npo.app.form;

import java.sql.Timestamp;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import com.osp.npo.app.context.ContractByBankListContext;
import com.osp.npo.app.message.MessageUtil;
import com.osp.npo.app.viewhelper.ContractByBankListViewHelper;
import com.osp.npo.common.util.EditString;
import com.osp.npo.common.util.RelateDateTime;
import com.osp.npo.core.basicData.BankInfo;
import com.osp.npo.core.contract.ContractInfo;

/**
 *
 * Contract By Bank List Form
 *
 * @author GiangVT
 * @version $Revision: 20069 $
 */
public class ContractByBankListForm extends ActionForm {

    private static final long serialVersionUID = 3856131996765993032L;

    public static final String CONTRACT_IN_WEEK = "00";
    public static final String CONTRACT_IN_DAY = "01";
    public static final String CONTRACT_IN_MONTH = "02";
    public static final String CONTRACT_IN_YEAR = "03";
    public static final String CONTRACT_IN_RANGE = "04";

    private List<ContractInfo> contractList;
    private List<BankInfo> bankList;
    private String[] selectedBankList;
    private Boolean checkAllValue;
    private Boolean isHidePanelSearch;
    private Long bankIdFilter;
    private String searchDate;
    private String fromDate;
    private String toDate;
    private String direction;
    private String pagerState;

    @Override
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();
        MessageUtil messageUtil = new MessageUtil();

        ContractByBankListViewHelper view = (ContractByBankListViewHelper)
            request.getSession().getAttribute(ContractByBankListViewHelper.SESSION_KEY);
        ContractByBankListContext context = (ContractByBankListContext)request.getSession().getAttribute(ContractByBankListContext.SESSION_KEY);
        if (view == null || context == null) {
            return errors;
        }

        if (CONTRACT_IN_RANGE.equals(searchDate)) {
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

        view.reset(this);

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
     * @return the bankList
     */
    public List<BankInfo> getBankList() {
        return bankList;
    }

    /**
     * @param bankList the bankList to set
     */
    public void setBankList(List<BankInfo> bankList) {
        this.bankList = bankList;
    }

    /**
     * @return the selectedBankList
     */
    public String[] getSelectedBankList() {
        if (selectedBankList == null) {
            return new String[]{"0"};
        }
        return selectedBankList;
    }
    /**
     * @param selectedBankList the selectedBankList to set
     */
    public void setSelectedBankList(String[] selectedBankList) {
        this.selectedBankList = selectedBankList;
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
}
