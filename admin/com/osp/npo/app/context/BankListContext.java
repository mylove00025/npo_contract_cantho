/**
 * 
 */
package com.osp.npo.app.context;

/**
 * @author PhuongNT
 *
 */
public class BankListContext {
    /** session key */
    public static final String SESSION_KEY = "bankListContext";   
    
    private String bankName;

	/**
	 * @return the bankName
	 */
	public String getBankName() {
		return bankName;
	}

	/**
	 * @param bankName the bankName to set
	 */
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public void reset() {
		// TODO Auto-generated method stub
		this.bankName = null;
	}
    
}
