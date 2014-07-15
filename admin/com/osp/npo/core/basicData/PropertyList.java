package com.osp.npo.core.basicData;


import com.osp.npo.core.AbstractList;


/**
 * Property Info Class
 * 
 * @author HaiNT
 * @version $Revision: 17049 $
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
