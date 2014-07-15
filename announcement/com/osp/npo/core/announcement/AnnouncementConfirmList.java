package com.osp.npo.core.announcement;


import com.osp.npo.core.AbstractList;
import com.osp.npo.core.announcement.AnnouncementConfirmInfo;


/**
 * Generate by script
 * Generate date: 01/27/2011 2:53:52 PM
 * @version $Revision: 20134 $ 
 */
public class AnnouncementConfirmList extends AbstractList {


    /**
     * <P>Generate Instance.</P>
     *
     */
    public AnnouncementConfirmList() {
        super();
    }


    /**
     * <P>Get object Info from List</P>
     *
     * @param index Index
     * @return object Info
     */
    public AnnouncementConfirmInfo get(int index) {
        return ((AnnouncementConfirmInfo) this.list.get(index));
    }


    /**
     * <P>Add object Info to List.</P>
     *
     * @param info object Info
     * @return List of ojbect after add object Info
     */
    public boolean add(AnnouncementConfirmInfo info) {
        return this.list.add(info);
    }
}
