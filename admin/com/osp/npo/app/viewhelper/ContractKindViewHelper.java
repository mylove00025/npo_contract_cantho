package com.osp.npo.app.viewhelper;

import java.util.List;

import com.osp.npo.app.form.ContractKindForm;
import com.osp.npo.core.basicData.BankInfo;
import com.osp.npo.core.contract.ContractKindInfo;
import com.osp.npo.core.contract.ContractKindTreeNode;

/**
 * <P>Contract kind view helper</P>
 * 
 * @author HungPT 
 * @version $Revision: 19076 $
 */
public class ContractKindViewHelper {

    public static final String SESSION_KEY = "contractKindViewHelper";
    
    private Long id;
    
    private String name;
    
    private Long parentKindId;
    
    private List<ContractKindTreeNode> contractKindTreeNodeList;
    
    private Boolean hasChildren;
    
    private String position;
    
    private Long orderContractKindId;
    
    private List<ContractKindInfo> contractKindList;

    /**
	 * @return the contractKindList
	 */
	public List<ContractKindInfo> getContractKindList() {
		return contractKindList;
	}

	/**
	 * @param contractKindList the contractKindList to set
	 */
	public void setContractKindList(List<ContractKindInfo> contractKindList) {
		this.contractKindList = contractKindList;
	}

	/**
	 * @return the orderContractKindId
	 */
	public Long getOrderContractKindId() {
		return orderContractKindId;
	}

	/**
	 * @param orderContractKindId the orderContractKindId to set
	 */
	public void setOrderContractKindId(Long orderContractKindId) {
		this.orderContractKindId = orderContractKindId;
	}

	/**
	 * @return the position
	 */
	public String getPosition() {
		return position;
	}

	/**
	 * @param position the position to set
	 */
	public void setPosition(String position) {
		this.position = position;
	}

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
     * Get the name
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name
     *
     * @param name the name to set
     */
    public void setName(String name) {
    	if(name != null)
    		this.name = name.trim();
    }

    /**
     * Get the parentKindId
     *
     * @return the parentKindId
     */
    public Long getParentKindId() {
        return parentKindId;
    }

    /**
     * Set the parentKindId
     *
     * @param parentKindId the parentKindId to set
     */
    public void setParentKindId(Long parentKindId) {
        this.parentKindId = parentKindId;
    }
    
    /**
     * Get the contractKindTreeNodeList
     *
     * @return the contractKindTreeNodeList
     */
    public List<ContractKindTreeNode> getContractKindTreeNodeList() {
        return contractKindTreeNodeList;
    }

    /**
     * Set the contractKindTreeNodeList
     *
     * @param contractKindTreeNodeList the contractKindTreeNodeList to set
     */
    public void setContractKindTreeNodeList(List<ContractKindTreeNode> contractKindTreeNodeList) {
        this.contractKindTreeNodeList = contractKindTreeNodeList;
    }

    /**
     * Get the hasChildren
     *
     * @return the hasChildren
     */
    public Boolean getHasChildren() {
        return hasChildren;
    }

    /**
     * Set the hasChildren
     *
     * @param hasChildren the hasChildren to set
     */
    public void setHasChildren(Boolean hasChildren) {
        this.hasChildren = hasChildren;
    }

    public void reset(ContractKindForm form) {
        this.name = form.getName();
        this.parentKindId = form.getParentKindId();
        this.position = form.getPosition();
        this.orderContractKindId = form.getOrderContractKindId();
    }
    
    public  void clear() {
    	this.name = null;
    	this.parentKindId =null;
    	this.position ="01";
    	this.orderContractKindId =0L;
	}    
}
