package com.osp.npo.app.form;

import org.apache.struts.action.ActionForm;

/**
 * <P>Contract List Form</P>
 * 
 * @author KienLT
 * @version $Revision$
 */
@SuppressWarnings("serial")
public class ContractTemplateListForm extends ActionForm {
    
    private String contractTemplateNameFilter;
    private String useStatus;    
    private Long contractKindId;
    private String direction;
    private Long id;
    private boolean contractTemplateStatus;
    private String[] chkID;
       
    private Boolean isHidePanelSearch;
    
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
     * Get the contractTemplateNameFilter
     *
     * @return the contractTemplateNameFilter
     */
    public String getContractTemplateNameFilter() {
        if (contractTemplateNameFilter != null) {
            return contractTemplateNameFilter.trim();
        }
        return contractTemplateNameFilter;
    }



    /**
     * Set the contractTemplateNameFilter
     *
     * @param contractTemplateNameFilter the contractTemplateNameFilter to set
     */
    public void setContractTemplateNameFilter(String contractTemplateNameFilter) {
        this.contractTemplateNameFilter = contractTemplateNameFilter;
    }



    /**
     * Get the useStatus
     *
     * @return the useStatus
     */
    public String getUseStatus() {
        if (useStatus != null) {
            return useStatus.trim();
        }
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
    
    /**
     * Get the contractTemplateStatus
     *
     * @return the contractTemplateStatus
     */
    public Boolean getContractTemplateStatus() {
        return contractTemplateStatus;
    }

    /**
     * Set the contractTemplateStatus
     *
     * @param contractTemplateStatus the contractTemplateStatus to set
     */
    public void setContractTemplateStatus(Boolean contractTemplateStatus) {
        this.contractTemplateStatus = contractTemplateStatus;
    }
    
}
