package com.osp.npo.core.contractTotal;


import com.osp.npo.core.AbstractInfo;


/**
 * Generate by script
 * Generate date: 12/05/2010 1:52:14 PM
 * @version $Revision: 18438 $
 */
public class ContractUserTotalInfo extends AbstractInfo {


    /** User ID */
    private Long usid;

    /** Family name */
    private String familyName;

    /** First name */
    private String firstName;

    /** Number of contract */
    private Long numberOfContract;

    /** Number of  error contract */
    private Long numberOfErrorContract;


    /**
     * <P>Generate Instance.</P>
     *
     */
    public ContractUserTotalInfo() {
        super();
    }


    /**
     * <P>Get User ID </P>
     *
     * @return User ID
     */
    public Long getUsid() {
        return this.usid;
    }

    /**
     * <P>Set usid. </P>
     *
     * @param usid User ID
     */
    public void setUsid(Long usid) {
        this.usid = usid;
    }

    /**
     * <P>Get Family name </P>
     *
     * @return Family name
     */
    public String getFamilyName() {
        return this.familyName;
    }

    /**
     * <P>Set Family name. </P>
     *
     * @param familyName Family name
     */
    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    /**
     * <P>Get First name </P>
     *
     * @return First name
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * <P>Set First name. </P>
     *
     * @param firstName First name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
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

    /**
     * <P>Get Number of  error contract </P>
     *
     * @return Number of  error contract
     */
    public Long getNumberOfErrorContract() {
    	if (numberOfErrorContract == null) {
    		return 0L;
    	}
        return this.numberOfErrorContract;
    }

    /**
     * <P>Set Number of  error contract. </P>
     *
     * @param numberOfErrorContract Number of  error contract
     */
    public void setNumberOfErrorContract(Long numberOfErrorContract) {
        this.numberOfErrorContract = numberOfErrorContract;
    }
}
