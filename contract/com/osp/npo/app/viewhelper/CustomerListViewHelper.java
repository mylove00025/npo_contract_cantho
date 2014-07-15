package com.osp.npo.app.viewhelper;

import java.util.List;

import com.osp.npo.core.customer.CustomerInfo;



public class CustomerListViewHelper extends AbstractPageListViewHelper {
	 public static final String SESSION_KEY = "customerListViewHelper";
	 
	 private String customerInfo;
	 private String frequency;
	 private String keyHighLight;
	 private List<CustomerInfo> customerList;

	/**
	 * @param customerInfo the customerInfo to set
	 */
	public void setCustomerInfo(String customerInfo) {
		this.customerInfo = customerInfo;
	}

	/**
	 * @return the customerInfo
	 */
	public String getCustomerInfo() {
		return customerInfo;
	}

	/**
	 * @param frequency the frequency to set
	 */
	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	/**
	 * @return the frequency
	 */
	public String getFrequency() {
		return frequency;
	}

	/**
	 * @param keyHighLight the keyHighLight to set
	 */
	public void setKeyHighLight(String keyHighLight) {
		this.keyHighLight = keyHighLight;
	}

	/**
	 * @return the keyHighLight
	 */
	public String getKeyHighLight() {
		return keyHighLight;
	}

	/**
	 * @param customerList the customerList to set
	 */
	public void setCustomerList(List<CustomerInfo> customerList) {
		this.customerList = customerList;
	}

	/**
	 * @return the customerList
	 */
	public List<CustomerInfo> getCustomerList() {
		return customerList;
	}
	 
}
