package com.osp.npo.core.contractHistory;


import com.osp.npo.core.AbstractList;
import com.osp.npo.core.contractHistory.ContractHistoryInfo;


/**
 * Generate by script
 * Generate date: 04/26/2011 10:08:28 AM
 * @version $Revision$ 
 */
public class ContractHistoryList extends AbstractList {


    /**
     * <P>Generate Instance.</P>
     *
     */
    public ContractHistoryList() {
        super();
    }


    /**
     * <P>Get object Info from List</P>
     *
     * @param index Index
     * @return object Info
     */
    public ContractHistoryInfo get(int index) {
        return ((ContractHistoryInfo) this.list.get(index));
    }


    /**
     * <P>Add object Info to List.</P>
     *
     * @param info object Info
     * @return List of ojbect after add object Info
     */
    public boolean add(ContractHistoryInfo info) {
        return this.list.add(info);
    }
}
