package com.osp.npo.app.viewhelper;

import java.util.List;

import com.osp.npo.core.contract.ContractInfo;

public class ContractAppendixListViewHelper extends AbstractPageListViewHelper {

	public static final String SESSION_KEY = "contractAppendixListViewHelper";
	
	private List<ContractInfo> contractList;

	/**
	 * @param contractList the contractList to set
	 */
	public void setContractList(List<ContractInfo> contractList) {
		this.contractList = contractList;
	}

	/**
	 * @return the contractList
	 */
	public List<ContractInfo> getContractList() {
		return contractList;
	}
}
