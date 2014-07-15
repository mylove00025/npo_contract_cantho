package com.osp.npo.core.contract;

import java.util.List;

import com.osp.npo.core.AbstractList;
import com.osp.npo.core.user.UserInfo;

public class ContractKindListForNotary extends AbstractList {
	
	private int totalKind;
	
	private int totalUser;
	
	private List<UserInfo> userList;
	
	private List<ContractKindInfo> contractKindList;
	
	 /**
     * <P>Generate Instance.</P>
     *
     */
    public ContractKindListForNotary() {
        super();
    }


    /**
     * <P>Get object Info from List</P>
     *
     * @param index Index
     * @return object Info
     */
    public ContractKindForNotaryInfo get(int index) {
        return ((ContractKindForNotaryInfo) this.list.get(index));
    }


    /**
     * <P>Add object Info to List.</P>
     *
     * @param info object Info
     * @return List of ojbect after add object Info
     */
    public boolean add(ContractKindForNotaryInfo info) {
        return this.list.add(info);
    }


	/**
	 * @param totalKind the totalKind to set
	 */
	public void setTotalKind(int totalKind) {
		this.totalKind = totalKind;
	}


	/**
	 * @return the totalKind
	 */
	public int getTotalKind() {
		return totalKind;
	}


	/**
	 * @param totalUser the totalUser to set
	 */
	public void setTotalUser(int totalUser) {
		this.totalUser = totalUser;
	}


	/**
	 * @return the totalUser
	 */
	public int getTotalUser() {
		return totalUser;
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


	/**
	 * @param contractKindList the contractKindList to set
	 */
	public void setContractKindList(List<ContractKindInfo> contractKindList) {
		this.contractKindList = contractKindList;
	}


	/**
	 * @return the contractKindList
	 */
	public List<ContractKindInfo> getContractKindList() {
		return contractKindList;
	}

}
