package com.osp.npo.core.preventws;


import com.osp.npo.core.AbstractList;

/**
 * Generate by script
 * Generate date: 1/22/2011 8:59:06 AM
 * @version $Revision: 19880 $ 
 */
public class DataPreventWsList extends AbstractList {


    /**
     * <P>Generate Instance.</P>
     *
     */
    public DataPreventWsList() {
        super();
    }


    /**
     * <P>Get object Info from List</P>
     *
     * @param index Index
     * @return object Info
     */
    public DataPreventWsInfo get(int index) {
        return ((DataPreventWsInfo) this.list.get(index));
    }


    /**
     * <P>Add object Info to List.</P>
     *
     * @param info object Info
     * @return List of ojbect after add object Info
     */
    public boolean add(DataPreventWsInfo info) {
        return this.list.add(info);
    }
}
