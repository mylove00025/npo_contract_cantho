package com.osp.npo.core.contract;


import com.osp.npo.core.AbstractList;
import com.osp.npo.core.contract.ContractTemplateInfo;


/**
 * Generate by script
 * Generate date: 10/28/2010 12:04:18 PM
 */
public class ContractTemplateList extends AbstractList {


    /**
     * <P>Generate Instance.</P>
     *
     */
    public ContractTemplateList() {
        super();
    }


    /**
     * <P>Get object Info from List</P>
     *
     * @param index Index
     * @return object Info
     */
    public ContractTemplateInfo get(int index) {
        return ((ContractTemplateInfo) this.list.get(index));
    }


    /**
     * <P>Add object Info to List.</P>
     *
     * @param info object Info
     * @return List of ojbect after add object Info
     */
    public boolean add(ContractTemplateInfo info) {
        return this.list.add(info);
    }
}
