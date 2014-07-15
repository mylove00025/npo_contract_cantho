package com.osp.npo.app.viewhelper;

import java.util.List;

import com.osp.npo.app.form.BankForm;
import com.osp.npo.core.basicData.BankInfo;

/**
 * <P>Bank View Helper</P>
 * 
 * @author HungPT 
 * @version $Revision$
 */
public class BankViewHelper {
    
    public static final String SESSION_KEY = "bankViewHelper";
    
    private Long id;
    
    private String bankName;
    
    private String position;
    
    //Id of bank which has order number behind order number of current bank
    private Long orderBankId;
    
    private List<BankInfo> bankList;
    
    private Boolean hasRelation;
    
    
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
     * Get the bankName
     *
     * @return the bankName
     */
    public String getBankName() {
        return bankName;
    }

    /**
     * Set the bankName
     *
     * @param bankName the bankName to set
     */
    public void setBankName(String bankName) {
        this.bankName = bankName.trim();
    }

    /**
     * Get the position
     *
     * @return the position
     */
    public String getPosition() {
        return position;
    }

    /**
     * Set the position
     *
     * @param position the position to set
     */
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * Get the orderBankId
     *
     * @return the orderBankId
     */
    public Long getOrderBankId() {
        return orderBankId;
    }

    /**
     * Set the orderBankId
     *
     * @param orderBankId the orderBankId to set
     */
    public void setOrderBankId(Long orderBankId) {
        this.orderBankId = orderBankId;
    }

    /**
     * Get the bankList
     *
     * @return the bankList
     */
    public List<BankInfo> getBankList() {
        return bankList;
    }

    /**
     * Set the bankList
     *
     * @param bankList the bankList to set
     */
    public void setBankList(List<BankInfo> bankList) {
        this.bankList = bankList;
    }

    /**
     * Get the hasRelation
     *
     * @return the hasRelation
     */
    public Boolean getHasRelation() {
        return hasRelation;
    }

    /**
     * Set the hasRelation
     *
     * @param hasRelation the hasRelation to set
     */
    public void setHasRelation(Boolean hasRelation) {
        this.hasRelation = hasRelation;
    }

    public void reset(BankForm form) {        
        this.bankName = form.getBankName();
        this.position = form.getPosition();
        this.orderBankId = form.getOrderBankId();
    }
    
    public void clear() {
    	this.bankName = null;
        this.position = "01";
        this.orderBankId = 0L;
    }
}
