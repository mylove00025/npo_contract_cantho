package com.osp.npo.core.temporaryContract;


import com.osp.npo.core.AbstractList;
import com.osp.npo.core.temporaryContract.TemporaryContractInfo;


/**
 * Generate by script
 * Generate date: 04/26/2011 10:04:43 AM
 * @version $Revision: 23378 $ 
 */
public class TemporaryContractList extends AbstractList {


    /**
     * <P>Generate Instance.</P>
     *
     */
    public TemporaryContractList() {
        super();
    }


    /**
     * <P>Get object Info from List</P>
     *
     * @param index Index
     * @return object Info
     */
    public TemporaryContractInfo get(int index) {
        return ((TemporaryContractInfo) this.list.get(index));
    }


    /**
     * <P>Add object Info to List.</P>
     *
     * @param info object Info
     * @return List of ojbect after add object Info
     */
    public boolean add(TemporaryContractInfo info) {
        return this.list.add(info);
    }
}
