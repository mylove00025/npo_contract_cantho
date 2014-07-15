package com.osp.npo.core.prevent;


import com.osp.npo.core.AbstractList;
import com.osp.npo.core.prevent.PropertyPreventInfo;


/**
 * Generate by script
 * Generate date: 1/22/2011 8:59:06 AM
 * @version $Revision: 19880 $ 
 */
public class PropertyPreventList extends AbstractList {


    /**
     * <P>Generate Instance.</P>
     *
     */
    public PropertyPreventList() {
        super();
    }


    /**
     * <P>Get object Info from List</P>
     *
     * @param index Index
     * @return object Info
     */
    public PropertyPreventInfo get(int index) {
        return ((PropertyPreventInfo) this.list.get(index));
    }


    /**
     * <P>Add object Info to List.</P>
     *
     * @param info object Info
     * @return List of ojbect after add object Info
     */
    public boolean add(PropertyPreventInfo info) {
        return this.list.add(info);
    }
}
