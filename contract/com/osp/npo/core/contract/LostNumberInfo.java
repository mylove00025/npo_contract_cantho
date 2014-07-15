package com.osp.npo.core.contract;

public class LostNumberInfo {
	
	/** kind id */
    private Long kindId;

    /** số hợp đồng */
    private Long lostContractNumber;
    
    /** Year */
    private int year;

	/**
	 * @param kindId the kindId to set
	 */
	public void setKindId(Long kindId) {
		this.kindId = kindId;
	}

	/**
	 * @return the kindId
	 */
	public Long getKindId() {
		return kindId;
	}

	/**
	 * @param lostContractNumber the lostContractNumber to set
	 */
	public void setLostContractNumber(Long lostContractNumber) {
		this.lostContractNumber = lostContractNumber;
	}

	/**
	 * @return the lostContractNumber
	 */
	public Long getLostContractNumber() {
		return lostContractNumber;
	}

	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}

}
