package com.osp.npo.core.contract;


import com.osp.npo.core.AbstractList;
import com.osp.npo.core.contract.PropertyInfo;


/**
 * Generate by script
 * Generate date: 11/29/2010 10:15:29 AM
 */
public class PropertyList extends AbstractList {


    /**
     * <P>Generate Instance.</P>
     *
     */
    public PropertyList() {
        super();
    }


    /**
     * <P>Get object Info from List</P>
     *
     * @param index Index
     * @return object Info
     */
    public PropertyInfo get(int index) {
        return ((PropertyInfo) this.list.get(index));
    }


    /**
     * <P>Add object Info to List.</P>
     *
     * @param info object Info
     * @return List of ojbect after add object Info
     */
    public boolean add(PropertyInfo info) {
        return this.list.add(info);
    }
}
