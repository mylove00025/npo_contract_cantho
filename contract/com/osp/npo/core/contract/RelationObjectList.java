package com.osp.npo.core.contract;


import com.osp.npo.core.AbstractList;
import com.osp.npo.core.contract.RelationObjectInfo;


/**
 * Generate by script
 * Generate date: 10/28/2010 12:04:18 PM
 */
public class RelationObjectList extends AbstractList {


    /**
     * <P>Generate Instance.</P>
     *
     */
    public RelationObjectList() {
        super();
    }


    /**
     * <P>Get object Info from List</P>
     *
     * @param index Index
     * @return object Info
     */
    public RelationObjectInfo get(int index) {
        return ((RelationObjectInfo) this.list.get(index));
    }


    /**
     * <P>Add object Info to List.</P>
     *
     * @param info object Info
     * @return List of ojbect after add object Info
     */
    public boolean add(RelationObjectInfo info) {
        return this.list.add(info);
    }
}
