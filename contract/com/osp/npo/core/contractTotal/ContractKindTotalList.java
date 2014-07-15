package com.osp.npo.core.contractTotal;


import com.osp.npo.core.AbstractList;

/**
 * Generate by script
 * Generate date: 12/05/2010 1:52:14 PM
 * @version $Revision: 18438 $
 */
public class ContractKindTotalList extends AbstractList {


    /**
     * <P>Generate Instance.</P>
     *
     */
    public ContractKindTotalList() {
        super();
    }


    /**
     * <P>Get object Info from List</P>
     *
     * @param index Index
     * @return object Info
     */
    public ContractKindTotalInfo get(int index) {
        return ((ContractKindTotalInfo) this.list.get(index));
    }


    /**
     * <P>Add object Info to List.</P>
     *
     * @param info object Info
     * @return List of ojbect after add object Info
     */
    public boolean add(ContractKindTotalInfo info) {
        return this.list.add(info);
    }
}
