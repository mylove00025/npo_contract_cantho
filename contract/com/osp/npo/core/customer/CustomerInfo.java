package com.osp.npo.core.customer;


import com.osp.npo.common.util.EditString;
import com.osp.npo.core.AbstractInfo;


/**
 * Generate by script
 * Generate date: 04/22/2011 2:22:57 PM
 * @version $Revision$ 
 */
public class CustomerInfo extends AbstractInfo {


    /** Customer ID */
    private Long cid;

    /** Customer information */
    private String customerInfo;

    /** Frequency of contract */
    private Long frequency;


    /**
     * <P>Generate Instance.</P>
     *
     */
    public CustomerInfo() {
        super();
    }


    /**
     * <P>Get Customer ID </P>
     *
     * @return Customer ID
     */
    public Long getCid() {
        return this.cid;
    }

    /**
     * <P>Set Customer ID. </P>
     *
     * @param cid Customer ID
     */
    public void setCid(Long cid) {
        this.cid = cid;
    }

    /**
     * <P>Get Customer information </P>
     *
     * @return Customer information
     */
    public String getCustomerInfo() {
        return this.customerInfo;
    }

    /**
     * <P>Set Customer information. </P>
     *
     * @param customerInfo Customer information
     */
    public void setCustomerInfo(String customerInfo) {
        this.customerInfo = customerInfo;
    }

    /**
     * <P>Get Customer information </P>
     *
     * @return Customer information
     */
    public String getCustomerInfoDisp() {
    	 return EditString.replaceChangeLine(customerInfo);
    }
    
    /**
     * <P>Get Frequency of contract </P>
     *
     * @return Frequency of contract
     */
    public Long getFrequency() {
        return this.frequency;
    }

    /**
     * <P>Set Frequency of contract. </P>
     *
     * @param frequency Frequency of contract
     */
    public void setFrequency(Long frequency) {
        this.frequency = frequency;
    }
}
