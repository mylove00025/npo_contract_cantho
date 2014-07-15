package com.osp.npo.core.synchronize;


import com.osp.npo.core.AbstractList;
import com.osp.npo.core.synchronize.SynchronizeInfo;


/**
 * Generate by script
 * Generate date: 02/17/2011 10:15:26 AM
 */
public class SynchronizeList extends AbstractList {


    /**
     * <P>Generate Instance.</P>
     *
     */
    public SynchronizeList() {
        super();
    }


    /**
     * <P>Get object Info from List</P>
     *
     * @param index Index
     * @return object Info
     */
    public SynchronizeInfo get(int index) {
        return ((SynchronizeInfo) this.list.get(index));
    }


    /**
     * <P>Add object Info to List.</P>
     *
     * @param info object Info
     * @return List of ojbect after add object Info
     */
    public boolean add(SynchronizeInfo info) {
        return this.list.add(info);
    }
}
