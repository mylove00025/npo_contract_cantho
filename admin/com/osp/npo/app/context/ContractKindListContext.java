/**
 * 
 */
package com.osp.npo.app.context;

/**
 * @author PhuongNT
 *
 */
public class ContractKindListContext {
    /** session key */
    public static final String SESSION_KEY = "contractKindListContext";   
    
    private String contractKindName;

	/**
	 * @return the bankName
	 */
	public String getContractKindName() {
		return contractKindName;
	}

	/**
	 * @param bankName the bankName to set
	 */
	public void setContractKindName(String contractKindName) {
		this.contractKindName = contractKindName;
	}

	public void reset() {
		// TODO Auto-generated method stub
		this.contractKindName = null;
	}
    
}
