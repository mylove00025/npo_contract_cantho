package com.osp.npo.core.customer;


import com.osp.npo.core.AbstractList;
import com.osp.npo.core.customer.CustomerInfo;


/**
 * Generate by script
 * Generate date: 04/22/2011 2:22:57 PM
 * @version $Revision$ 
 */
public class CustomerList extends AbstractList {


    /**
     * <P>Generate Instance.</P>
     *
     */
    public CustomerList() {
        super();
    }


    /**
     * <P>Get object Info from List</P>
     *
     * @param index Index
     * @return object Info
     */
    public CustomerInfo get(int index) {
        return ((CustomerInfo) this.list.get(index));
    }


    /**
     * <P>Add object Info to List.</P>
     *
     * @param info object Info
     * @return List of ojbect after add object Info
     */
    public boolean add(CustomerInfo info) {
        return this.list.add(info);
    }
}
