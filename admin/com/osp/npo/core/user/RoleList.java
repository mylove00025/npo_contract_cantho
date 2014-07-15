package com.osp.npo.core.user;


import com.osp.npo.core.AbstractList;
import com.osp.npo.core.user.RoleInfo;


/**
 * Generate by script
 * Generate date: 10/14/2010 11:03:35 AM
 * @version $Revision: 17060 $
 */
public class RoleList extends AbstractList {


    /**
     * <P>Generate Instance.</P>
     *
     */
    public RoleList() {
        super();
    }


    /**
     * <P>Get object Info from List</P>
     *
     * @param index Index
     * @return object Info
     */
    public RoleInfo get(int index) {
        return ((RoleInfo) this.list.get(index));
    }


    /**
     * <P>Add object Info to List.</P>
     *
     * @param info object Info
     * @return List of ojbect after add object Info
     */
    public boolean add(RoleInfo info) {
        return this.list.add(info);
    }    
    
    public void add(RoleInfo info,int index) {
        this.list.add(index, info);
    }
}
