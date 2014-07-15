package com.osp.npo.core.count;


import com.osp.npo.core.AbstractList;
import com.osp.npo.core.count.CountInfo;


/**
 * Generate by script
 * Generate date: 1/3/2012 2:04:42 PM
 * @version $Revision$ 
 */
public class CountList extends AbstractList {


    /**
     * <P>Generate Instance.</P>
     *
     */
    public CountList() {
        super();
    }


    /**
     * <P>Get object Info from List</P>
     *
     * @param index Index
     * @return object Info
     */
    public CountInfo get(int index) {
        return ((CountInfo) this.list.get(index));
    }


    /**
     * <P>Add object Info to List.</P>
     *
     * @param info object Info
     * @return List of ojbect after add object Info
     */
    public boolean add(CountInfo info) {
        return this.list.add(info);
    }
}
