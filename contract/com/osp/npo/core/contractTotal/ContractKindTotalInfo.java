package com.osp.npo.core.contractTotal;


import com.osp.npo.core.AbstractInfo;


/**
 * Generate by script
 * Generate date: 12/05/2010 1:52:14 PM
 * @version $Revision: 18438 $
 */
public class ContractKindTotalInfo extends AbstractInfo {


    /** kind ID */
    private Long kindId;
    
    /** Kind name */
    private String kindName;

    /** Template name */
    private String templateName;;
    
    /** Number of contract by template */
    private Long numberOfContract;

    /** Number of internal contract by template */
    private Long numberOfInternalContract;

    /** Number of external contract by template */
    private Long numberOfExternalContract;
    
    /** Number of template by kind */
    private Long numberOfTemplateByKind;

    /**
     * <P>Generate Instance.</P>
     *
     */
    public ContractKindTotalInfo() {
        super();
    }


    /**
     * Get the kindId
     *
     * @return the kindId
     */
    public Long getKindId() {
        return kindId;
    }


    /**
     * Set the kindId
     *
     * @param kindId the kindId to set
     */
    public void setKindId(Long kindId) {
        this.kindId = kindId;
    }


    /**
     * Get the kindName
     *
     * @return the kindName
     */
    public String getKindName() {
        return kindName;
    }


    /**
     * Set the kindName
     *
     * @param kindName the kindName to set
     */
    public void setKindName(String kindName) {
        this.kindName = kindName;
    }


    /**
     * Get the templateName
     *
     * @return the templateName
     */
    public String getTemplateName() {
        return templateName;
    }


    /**
     * Set the templateName
     *
     * @param templateName the templateName to set
     */
    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }


    /**
     * Get the numberOfContract
     *
     * @return the numberOfContract
     */
    public Long getNumberOfContract() {
        if (numberOfContract == null) {
            return 0L;
        }
        return numberOfContract;
    }


    /**
     * Set the numberOfContract
     *
     * @param numberOfContract the numberOfContract to set
     */
    public void setNumberOfContract(Long numberOfContract) {
        this.numberOfContract = numberOfContract;
    }


    /**
     * Get the numberOfInternalContract
     *
     * @return the numberOfInternalContract
     */
    public Long getNumberOfInternalContract() {
        if (numberOfInternalContract == null) {
            return 0L;
        }
        return numberOfInternalContract;
    }


    /**
     * Set the numberOfInternalContract
     *
     * @param numberOfInternalContract the numberOfInternalContract to set
     */
    public void setNumberOfInternalContract(Long numberOfInternalContract) {
        this.numberOfInternalContract = numberOfInternalContract;
    }


    /**
     * Get the numberOfExternalContract
     *
     * @return the numberOfExternalContract
     */
    public Long getNumberOfExternalContract() {
        if (numberOfExternalContract == null) {
            return 0L;
        }
        return numberOfExternalContract;
    }


    /**
     * Set the numberOfExternalContract
     *
     * @param numberOfExternalContract the numberOfExternalContract to set
     */
    public void setNumberOfExternalContract(Long numberOfExternalContract) {
        this.numberOfExternalContract = numberOfExternalContract;
    }


    /**
     * Get the numberOfTemplateByKind
     *
     * @return the numberOfTemplateByKind
     */
    public Long getNumberOfTemplateByKind() {
        if (numberOfTemplateByKind == null) {
            return 0L;
        }
        return numberOfTemplateByKind;
    }


    /**
     * Set the numberOfTemplateByKind
     *
     * @param numberOfTemplateByKind the numberOfTemplateByKind to set
     */
    public void setNumberOfTemplateByKind(Long numberOfTemplateByKind) {
        this.numberOfTemplateByKind = numberOfTemplateByKind;
    }

    
}
