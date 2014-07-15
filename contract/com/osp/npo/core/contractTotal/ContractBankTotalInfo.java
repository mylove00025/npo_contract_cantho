package com.osp.npo.core.contractTotal;


import com.osp.npo.core.AbstractInfo;


/**
 * Generate by script
 * Generate date: 12/05/2010 1:52:14 PM
 * @version $Revision: 18438 $ 
 */
public class ContractBankTotalInfo extends AbstractInfo {


    /** Bank ID */
    private Long bankId;

    /** Bank name */
    private String bankName;

    /** Number of contract */
    private Long numberOfContract;


    /**
     * <P>Generate Instance.</P>
     *
     */
    public ContractBankTotalInfo() {
        super();
    }


    /**
     * <P>Get Bank ID </P>
     *
     * @return Bank ID
     */
    public Long getBankId() {
        return this.bankId;
    }

    /**
     * <P>Set Bank ID. </P>
     *
     * @param bankId Bank ID
     */
    public void setBankId(Long bankId) {
        this.bankId = bankId;
    }

    /**
     * <P>Get Bank name </P>
     *
     * @return Bank name
     */
    public String getBankName() {
        return this.bankName;
    }

    /**
     * <P>Set Bank name. </P>
     *
     * @param bankName Bank name
     */
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    /**
     * <P>Get Number of contract </P>
     *
     * @return Number of contract
     */
    public Long getNumberOfContract() {
    	if (numberOfContract == null) {
    		return 0L;
    	}
        return this.numberOfContract;
    }

    /**
     * <P>Set Number of contract. </P>
     *
     * @param numberOfContract Number of contract
     */
    public void setNumberOfContract(Long numberOfContract) {
        this.numberOfContract = numberOfContract;
    }
}
