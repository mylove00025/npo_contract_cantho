package com.osp.npo.core.appendix;


import com.osp.npo.core.AbstractList;
import com.osp.npo.core.appendix.ContractAppendixInfo;


/**
 * Generate by script
 * Generate date: 04/22/2011 3:02:07 PM
 * @version $Revision$ 
 */
public class ContractAppendixList extends AbstractList {


    /**
     * <P>Generate Instance.</P>
     *
     */
    public ContractAppendixList() {
        super();
    }


    /**
     * <P>Get object Info from List</P>
     *
     * @param index Index
     * @return object Info
     */
    public ContractAppendixInfo get(int index) {
        return ((ContractAppendixInfo) this.list.get(index));
    }


    /**
     * <P>Add object Info to List.</P>
     *
     * @param info object Info
     * @return List of ojbect after add object Info
     */
    public boolean add(ContractAppendixInfo info) {
        return this.list.add(info);
    }
}
