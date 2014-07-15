package com.osp.npo.app.context;

/**
 * 
 * @author KienLT
 * @version $Revision: 23786 $
 */
public class ContractTemplateListContext extends BaseSelectionDeleteContext {
    /** session key */
    public static final String SESSION_KEY = "contractTemplateListContext";   
    
    private String contractName;
    private Long contractKindId;
    private String useStatus;
    private String[] chkID;
    /**
     * Get the contractName
     *
     * @return the contractName
     */
    public String getContractName() {
        return contractName;
    }



    /**
     * Set the contractName
     *
     * @param contractName the contractName to set
     */
    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    
    /**
     * Reset data
     */
    public void reset() {
        this.contractName = null;
       
      
    }


    /**
     * Get the contractKindId
     *
     * @return the contractKindId
     */
    public Long getContractKindId() {
        return contractKindId;
    }



    /**
     * Set the contractKindId
     *
     * @param contractKindId the contractKindId to set
     */
    public void setContractKindId(Long contractKindId) {
        this.contractKindId = contractKindId;
    }



    /**
     * Get the useStatus
     *
     * @return the useStatus
     */
    public String getUseStatus() {
        return useStatus;
    }



    /**
     * Set the useStatus
     *
     * @param useStatus the useStatus to set
     */
    public void setUseStatus(String useStatus) {
        this.useStatus = useStatus;
    }

    
    /**
     * Get the chkID
     *
     * @return the chkID
     */
    public String[] getChkID() {
        return chkID;
    }
    /**
     * Set the chkID
     *
     * @param chkID the chkID to set
     */
    public void setChkID(String[] chkID) {
        this.chkID = chkID;
    }
    
    public void clear() {
        this.contractName = null;
        this.chkID = null;
    }
    

}
