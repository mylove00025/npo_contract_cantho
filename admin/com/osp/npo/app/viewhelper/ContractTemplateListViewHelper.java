package com.osp.npo.app.viewhelper;

import java.util.List;

import com.osp.npo.app.form.ContractTemplateListForm;
import com.osp.npo.core.contract.ContractKindTreeNode;
import com.osp.npo.core.contract.ContractTemplateInfo;


/**
 * Contract View Helper
 * 
 * @author KienLT
 * @version $Revision: 25400 $
 */
public class ContractTemplateListViewHelper extends AbstractPageListViewHelper {
    
    public static final String SESSION_KEY = "contractTemplateListViewHelper";
    
    private String contractTemplateNameFilter;
    private Long contractKindId;
    private String useStatus;    
    private List<ContractTemplateInfo> contractTemplateList;
    private List<ContractKindTreeNode> contractKindTreeNodeList;
    private String[] chkID;
    private String chkAllID;
    
    /**
     * Get the contractTemplateList
     *
     * @return the contractTemplateList
     */
    public List<ContractTemplateInfo> getContractTemplateList() {
        return contractTemplateList;
    }

    /**
     * Set the contractTemplateList
     *
     * @param contractTemplateList the contractTemplateList to set
     */
    public void setContractTemplateList(List<ContractTemplateInfo> contractTemplateList) {
        this.contractTemplateList = contractTemplateList;
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
     * Get the contractTemplateNameFilter
     *
     * @return the contractTemplateNameFilter
     */
    public String getContractTemplateNameFilter() {
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
     * Get the chkAllID
     *
     * @return the chkAllID
     */
    public String getChkAllID() {
        return chkAllID;
    }
    /**
     * Set the chkAllID
     *
     * @param chkAllID the chkAllID to set
     */
    public void setChkAllID(String chkAllID) {
        this.chkAllID = chkAllID;
    }
    
    /**
     * Get the chkID
     *
     * @return the chkID
     */
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

    public void reset(ContractTemplateListForm f) {
        this.contractTemplateNameFilter = f.getContractTemplateNameFilter();
        this.contractKindId = f.getContractKindId();
        this.useStatus = f.getUseStatus();
    }

	/**
	 * @param contractKindTreeNodeList the contractKindTreeNodeList to set
	 */
	public void setContractKindTreeNodeList(List<ContractKindTreeNode> contractKindTreeNodeList) {
		this.contractKindTreeNodeList = contractKindTreeNodeList;
	}

	/**
	 * @return the contractKindTreeNodeList
	 */
	public List<ContractKindTreeNode> getContractKindTreeNodeList() {
		return contractKindTreeNodeList;
	}
}