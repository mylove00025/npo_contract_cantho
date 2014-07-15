package com.osp.npo.core.user;


import com.osp.npo.core.AbstractList;
import com.osp.npo.core.user.UserInfo;


/**
 * Generate by script
 * Generate date: 10/14/2010 11:03:35 AM
 * @version $Revision: 17060 $
 */
public class UserList extends AbstractList {


    /**
     * <P>Generate Instance.</P>
     *
     */
    public UserList() {
        super();
    }


    /**
     * <P>Get object Info from List</P>
     *
     * @param index Index
     * @return object Info
     */
    public UserInfo get(int index) {
        return ((UserInfo) this.list.get(index));
    }


    /**
     * <P>Add object Info to List.</P>
     *
     * @param info object Info
     * @return List of ojbect after add object Info
     */
    public boolean add(UserInfo info) {
        return this.list.add(info);
    }
}
