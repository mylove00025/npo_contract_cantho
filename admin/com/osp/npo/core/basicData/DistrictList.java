package com.osp.npo.core.basicData;


import com.osp.npo.core.AbstractList;
import com.osp.npo.core.basicData.DistrictInfo;


/**
 * Generate by script
 * Generate date: 10/14/2010 11:03:35 AM
 * @version $Revision: 17059 $
 */
public class DistrictList extends AbstractList {


    /**
     * <P>Generate Instance.</P>
     *
     */
    public DistrictList() {
        super();
    }


    /**
     * <P>Get object Info from List</P>
     *
     * @param index Index
     * @return object Info
     */
    public DistrictInfo get(int index) {
        return ((DistrictInfo) this.list.get(index));
    }


    /**
     * <P>Add object Info to List.</P>
     *
     * @param info object Info
     * @return List of ojbect after add object Info
     */
    public boolean add(DistrictInfo info) {
        return this.list.add(info);
    }
}
