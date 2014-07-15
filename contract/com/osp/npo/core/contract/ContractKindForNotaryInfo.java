package com.osp.npo.core.contract;

import java.util.List;

import com.osp.npo.core.AbstractInfo;
import com.osp.npo.core.user.UserInfo;


public class ContractKindForNotaryInfo extends AbstractInfo {
	
	private String name;

	private Long id;
	
	private List<UserInfo> userList;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param userList the userList to set
	 */
	public void setUserList(List<UserInfo> userList) {
		this.userList = userList;
	}

	/**
	 * @return the userList
	 */
	public List<UserInfo> getUserList() {
		return userList;
	}
	
	

}
