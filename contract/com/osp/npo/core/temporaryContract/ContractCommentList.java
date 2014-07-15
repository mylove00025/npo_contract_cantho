package com.osp.npo.core.temporaryContract;


import com.osp.npo.core.AbstractList;
import com.osp.npo.core.temporaryContract.ContractCommentInfo;


/**
 * Generate by script
 * Generate date: 04/26/2011 10:04:43 AM
 * @version $Revision$ 
 */
public class ContractCommentList extends AbstractList {


    /**
     * <P>Generate Instance.</P>
     *
     */
    public ContractCommentList() {
        super();
    }


    /**
     * <P>Get object Info from List</P>
     *
     * @param index Index
     * @return object Info
     */
    public ContractCommentInfo get(int index) {
        return ((ContractCommentInfo) this.list.get(index));
    }


    /**
     * <P>Add object Info to List.</P>
     *
     * @param info object Info
     * @return List of ojbect after add object Info
     */
    public boolean add(ContractCommentInfo info) {
        return this.list.add(info);
    }
}
