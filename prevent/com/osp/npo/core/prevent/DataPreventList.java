package com.osp.npo.core.prevent;


import com.osp.npo.core.AbstractList;
import com.osp.npo.core.prevent.DataPreventInfo;


/**
 * Generate by script
 * Generate date: 1/22/2011 8:59:06 AM
 * @version $Revision: 19880 $ 
 */
public class DataPreventList extends AbstractList {


    /**
     * <P>Generate Instance.</P>
     *
     */
    public DataPreventList() {
        super();
    }


    /**
     * <P>Get object Info from List</P>
     *
     * @param index Index
     * @return object Info
     */
    public DataPreventInfo get(int index) {
        return ((DataPreventInfo) this.list.get(index));
    }


    /**
     * <P>Add object Info to List.</P>
     *
     * @param info object Info
     * @return List of ojbect after add object Info
     */
    public boolean add(DataPreventInfo info) {
        return this.list.add(info);
    }
}
