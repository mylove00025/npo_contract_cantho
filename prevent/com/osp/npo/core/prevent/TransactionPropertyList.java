package com.osp.npo.core.prevent;


import com.osp.npo.core.AbstractList;
import com.osp.npo.core.prevent.TransactionPropertyInfo;


/**
 * Generate by script
 * Generate date: 02/17/2011 10:15:26 AM
 */
public class TransactionPropertyList extends AbstractList {


    /**
     * <P>Generate Instance.</P>
     *
     */
    public TransactionPropertyList() {
        super();
    }


    /**
     * <P>Get object Info from List</P>
     *
     * @param index Index
     * @return object Info
     */
    public TransactionPropertyInfo get(int index) {
        return ((TransactionPropertyInfo) this.list.get(index));
    }


    /**
     * <P>Add object Info to List.</P>
     *
     * @param info object Info
     * @return List of ojbect after add object Info
     */
    public boolean add(TransactionPropertyInfo info) {
        return this.list.add(info);
    }
}
