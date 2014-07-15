package com.osp.npo.core.contractTotal;


import com.osp.npo.core.AbstractList;
import com.osp.npo.core.contractTotal.ContractBankTotalInfo;


/**
 * Generate by script
 * Generate date: 12/05/2010 1:52:14 PM
 * @version $Revision: 18438 $
 */
public class ContractBankTotalList extends AbstractList {


    /**
     * <P>Generate Instance.</P>
     *
     */
    public ContractBankTotalList() {
        super();
    }


    /**
     * <P>Get object Info from List</P>
     *
     * @param index Index
     * @return object Info
     */
    public ContractBankTotalInfo get(int index) {
        return ((ContractBankTotalInfo) this.list.get(index));
    }


    /**
     * <P>Add object Info to List.</P>
     *
     * @param info object Info
     * @return List of ojbect after add object Info
     */
    public boolean add(ContractBankTotalInfo info) {
        return this.list.add(info);
    }
}
