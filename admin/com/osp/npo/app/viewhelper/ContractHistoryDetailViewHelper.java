package com.osp.npo.app.viewhelper;

import java.util.List;

import com.osp.npo.app.form.ContractHistoryListForm;
import com.osp.npo.app.form.ContractKindListForm;
import com.osp.npo.core.contract.ContractKindTreeNode;
import com.osp.npo.core.contractHistory.ContractHistoryInfo;

public class ContractHistoryDetailViewHelper extends AbstractPageListViewHelper{

    public static final String SESSION_KEY = "contractHistoryDetailViewHelper";

    private List<ContractHistoryInfo> contractHistoryList;
    private Long isOpen;
    
    /**
	 * @return the contractHistoryList
	 */
	public List<ContractHistoryInfo> getContractHistoryList() {
		return contractHistoryList;
	}

	/**
	 * @param contractHistoryList the contractHistoryList to set
	 */
	public void setContractHistoryList(List<ContractHistoryInfo> contractHistoryList) {
		this.contractHistoryList = contractHistoryList;
	}

	/**
	 * @return the isOpen
	 */
	public Long getIsOpen() {
		return isOpen;
	}

	/**
	 * @param isOpen the isOpen to set
	 */
	public void setIsOpen(Long isOpen) {
		this.isOpen = isOpen;
	}
	

}