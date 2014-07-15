package com.osp.npo.core.user;


import com.osp.npo.core.AbstractList;
import com.osp.npo.core.user.AuthorityInfo;


/**
 * Generate by script
 * Generate date: 10/14/2010 11:03:35 AM
 * @version $Revision: 17060 $
 */
public class AuthorityList extends AbstractList {


    /**
     * <P>Generate Instance.</P>
     *
     */
    public AuthorityList() {
        super();
    }


    /**
     * <P>Get object Info from List</P>
     *
     * @param index Index
     * @return object Info
     */
    public AuthorityInfo get(int index) {
        return ((AuthorityInfo) this.list.get(index));
    }


    /**
     * <P>Add object Info to List.</P>
     *
     * @param info object Info
     * @return List of ojbect after add object Info
     */
    public boolean add(AuthorityInfo info) {
        return this.list.add(info);
    }
}
