package com.osp.npo.core.contract;


import com.osp.npo.core.AbstractList;
import com.osp.npo.core.contract.ContractInfo;


/**
 * Generate by script
 * Generate date: 10/28/2010 12:04:18 PM
 */
public class ContractList extends AbstractList {


    /**
     * <P>Generate Instance.</P>
     *
     */
    public ContractList() {
        super();
    }


    /**
     * <P>Get object Info from List</P>
     *
     * @param index Index
     * @return object Info
     */
    public ContractInfo get(int index) {
        return ((ContractInfo) this.list.get(index));
    }


    /**
     * <P>Add object Info to List.</P>
     *
     * @param info object Info
     * @return List of ojbect after add object Info
     */
    public boolean add(ContractInfo info) {
        return this.list.add(info);
    }
}
