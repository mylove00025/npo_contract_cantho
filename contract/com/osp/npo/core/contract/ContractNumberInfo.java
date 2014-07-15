package com.osp.npo.core.contract;

import com.osp.npo.core.AbstractInfo;

public class ContractNumberInfo extends AbstractInfo{
	
	 /** kind id */
    private Long kindId;

    /** số hợp đồng */
    private Long contractNumber;

	/**
	 * @param kind_id the kind_id to set
	 */
	public void setKindId(Long kindId) {
		this.kindId = kindId;
	}

	/**
	 * @return the kind_id
	 */
	public Long getKindId() {
		return kindId;
	}

	/**
	 * @param contractNumber the contractNumber to set
	 */
	public void setContractNumber(Long contractNumber) {
		this.contractNumber = contractNumber;
	}

	/**
	 * @return the contractNumber
	 */
	public Long getContractNumber() {
		return contractNumber;
	}

}
