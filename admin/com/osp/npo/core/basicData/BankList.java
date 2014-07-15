package com.osp.npo.core.basicData;


import com.osp.npo.core.AbstractList;
import com.osp.npo.core.basicData.BankInfo;


/**
 * Generate by script
 * Generate date: 10/28/2010 12:04:18 PM
 * @version $Revision: 17059 $
 */
public class BankList extends AbstractList {


    /**
     * <P>Generate Instance.</P>
     *
     */
    public BankList() {
        super();
    }


    /**
     * <P>Get object Info from List</P>
     *
     * @param index Index
     * @return object Info
     */
    public BankInfo get(int index) {
        return ((BankInfo) this.list.get(index));
    }


    /**
     * <P>Add object Info to List.</P>
     *
     * @param info object Info
     * @return List of ojbect after add object Info
     */
    public boolean add(BankInfo info) {
        return this.list.add(info);
    }
}
