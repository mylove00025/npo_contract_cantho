/**
 * 
 */
package com.osp.npo.app.viewhelper;

import java.util.List;

import com.osp.npo.app.form.ContractErrorListForm;
import com.osp.npo.core.contract.ContractInfo;
import com.osp.npo.core.user.UserInfo;

/**
 * @author SonHD
 * @version $Revision: 19455 $
 */
public class ContractErrorListViewHelper extends AbstractPageListViewHelper {
    
    public static final String SESSION_KEY = "contractErrorListViewHelper";
    
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
    
    public void reset(ContractErrorListForm form) {
       this.contractDrafterId = form.getContractDrafterId();
       this.contractNotaryId = form.getContractNotaryId();
       this.searchDate = form.getSearchDate();
       this.fromDate = form.getFromDate();
       this.toDate = form.getToDate();
    }
}
