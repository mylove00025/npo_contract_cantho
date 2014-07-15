package com.osp.npo.core.contract;


import com.osp.npo.core.AbstractList;
import com.osp.npo.core.contract.ContractStatisticalInfo;


/**
 * Generate by script
 * Generate date: 10/28/2010 12:04:18 PM
 * @version $Revision: 18029 $
 */
public class ContractStatisticalList extends AbstractList {


    /**
     * <P>Generate Instance.</P>
     *
     */
    public ContractStatisticalList() {
        super();
    }


    /**
     * <P>Get object Info from List</P>
     *
     * @param index Index
     * @return object Info
     */
    public ContractStatisticalInfo get(int index) {
        return ((ContractStatisticalInfo) this.list.get(index));
    }


    /**
     * <P>Add object Info to List.</P>
     *
     * @param info object Info
     * @return List of ojbect after add object Info
     */
    public boolean add(ContractStatisticalInfo info) {
        return this.list.add(info);
    }
}
