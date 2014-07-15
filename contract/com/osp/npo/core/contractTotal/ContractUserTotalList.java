package com.osp.npo.core.contractTotal;


import com.osp.npo.core.AbstractList;
import com.osp.npo.core.contractTotal.ContractUserTotalInfo;


/**
 * Generate by script
 * Generate date: 12/05/2010 1:52:14 PM
 * @version $Revision: 18438 $
 */
public class ContractUserTotalList extends AbstractList {


    /**
     * <P>Generate Instance.</P>
     *
     */
    public ContractUserTotalList() {
        super();
    }


    /**
     * <P>Get object Info from List</P>
     *
     * @param index Index
     * @return object Info
     */
    public ContractUserTotalInfo get(int index) {
        return ((ContractUserTotalInfo) this.list.get(index));
    }


    /**
     * <P>Add object Info to List.</P>
     *
     * @param info object Info
     * @return List of ojbect after add object Info
     */
    public boolean add(ContractUserTotalInfo info) {
        return this.list.add(info);
    }
}
