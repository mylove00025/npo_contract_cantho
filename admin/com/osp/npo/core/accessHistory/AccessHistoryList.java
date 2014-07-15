package com.osp.npo.core.accessHistory;


import com.osp.npo.core.AbstractList;
import com.osp.npo.core.accessHistory.AccessHistoryInfo;


/**
 * Generate by script
 * Generate date: 06/24/2011 8:55:45 AM
 * @version $Revision$ 
 */
public class AccessHistoryList extends AbstractList {


    /**
     * <P>Generate Instance.</P>
     *
     */
    public AccessHistoryList() {
        super();
    }


    /**
     * <P>Get object Info from List</P>
     *
     * @param index Index
     * @return object Info
     */
    public AccessHistoryInfo get(int index) {
        return ((AccessHistoryInfo) this.list.get(index));
    }


    /**
     * <P>Add object Info to List.</P>
     *
     * @param info object Info
     * @return List of ojbect after add object Info
     */
    public boolean add(AccessHistoryInfo info) {
        return this.list.add(info);
    }
}
