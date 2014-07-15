package com.osp.npo.core.basicData;


import com.osp.npo.core.AbstractList;
import com.osp.npo.core.basicData.ProvinceInfo;


/**
 * Generate by script
 * Generate date: 10/14/2010 11:03:35 AM
 * @version $Revision: 17059 $
 */
public class ProvinceList extends AbstractList {


    /**
     * <P>Generate Instance.</P>
     *
     */
    public ProvinceList() {
        super();
    }


    /**
     * <P>Get object Info from List</P>
     *
     * @param index Index
     * @return object Info
     */
    public ProvinceInfo get(int index) {
        return ((ProvinceInfo) this.list.get(index));
    }


    /**
     * <P>Add object Info to List.</P>
     *
     * @param info object Info
     * @return List of ojbect after add object Info
     */
    public boolean add(ProvinceInfo info) {
        return this.list.add(info);
    }
}
