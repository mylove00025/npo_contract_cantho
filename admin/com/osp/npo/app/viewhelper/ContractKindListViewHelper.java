package com.osp.npo.app.viewhelper;

import java.util.List;

import com.osp.npo.app.form.ContractKindListForm;
import com.osp.npo.core.contract.ContractKindTreeNode;

public class ContractKindListViewHelper extends AbstractPageListViewHelper{

    public static final String SESSION_KEY = "contractKindListViewHelper";

    private List<ContractKindTreeNode> lstContractKindTreeNode;
    
	private String contractKindName;
	
	private String direction;

	private int firstIndex;

    /**
     * @return the lstContractKindTreeNode
     */
    public List<ContractKindTreeNode> getLstContractKindTreeNode() {
        return lstContractKindTreeNode;
    }

    /**
     * @param lstContractKindTreeNode the lstContractKindTreeNode to set
     */
    public void setLstContractKindTreeNode(List<ContractKindTreeNode> lstContractKindTreeNode) {
        this.lstContractKindTreeNode = lstContractKindTreeNode;
    }

	/**
	 * @return the contractKindName
	 */
	public String getContractKindName() {
		return contractKindName;
	}

	/**
	 * @param contractKindName the contractKindName to set
	 */
	public void setContractKindName(String contractKindName) {
		this.contractKindName = contractKindName;
	}

	/**
	 * @return the direction
	 */
	public String getDirection() {
		return direction;
	}

	/**
	 * @param direction the direction to set
	 */
	public void setDirection(String direction) {
		this.direction = direction;
	}

	/**
	 * @return the firstIndex
	 */
	public int getFirstIndex() {
		return firstIndex;
	}

	/**
	 * @param firstIndex the firstIndex to set
	 */
	public void setFirstIndex(int firstIndex) {
		this.firstIndex = firstIndex;
	}
	
	 /**
     * reset from form
     * 
     * @param f
     */
    public void reset(ContractKindListForm f) {
        contractKindName=f.getContractKindName();	        
    }

}