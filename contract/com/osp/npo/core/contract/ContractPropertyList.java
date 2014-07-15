package com.osp.npo.core.contract;


import com.osp.npo.core.AbstractList;
import com.osp.npo.core.contract.ContractPropertyInfo;


/**
 * Generate by script
 * Generate date: 11/29/2010 10:15:29 AM
 */
public class ContractPropertyList extends AbstractList {


    /**
     * <P>Generate Instance.</P>
     *
     */
    public ContractPropertyList() {
        super();
    }


    /**
     * <P>Get object Info from List</P>
     *
     * @param index Index
     * @return object Info
     */
    public ContractPropertyInfo get(int index) {
        return ((ContractPropertyInfo) this.list.get(index));
    }


    /**
     * <P>Add object Info to List.</P>
     *
     * @param info object Info
     * @return List of ojbect after add object Info
     */
    public boolean add(ContractPropertyInfo info) {
        return this.list.add(info);
    }
}
