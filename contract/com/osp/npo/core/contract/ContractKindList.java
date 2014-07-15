package com.osp.npo.core.contract;


import java.util.List;

import com.osp.npo.core.AbstractList;
import com.osp.npo.core.contract.ContractKindInfo;
import com.osp.npo.core.user.UserInfo;


/**
 * Generate by script
 * Generate date: 10/28/2010 12:04:18 PM
 */
public class ContractKindList extends AbstractList {
	
	


    /**
     * <P>Generate Instance.</P>
     *
     */
    public ContractKindList() {
        super();
    }


    /**
     * <P>Get object Info from List</P>
     *
     * @param index Index
     * @return object Info
     */
    public ContractKindInfo get(int index) {
        return ((ContractKindInfo) this.list.get(index));
    }


    /**
     * <P>Add object Info to List.</P>
     *
     * @param info object Info
     * @return List of ojbect after add object Info
     */
    public boolean add(ContractKindInfo info) {
        return this.list.add(info);
    }


	
}
