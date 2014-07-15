package com.osp.npo.core.announcement;


import com.osp.npo.core.AbstractList;
import com.osp.npo.core.announcement.AnnouncementInfo;


/**
 * Generate by script
 * Generate date: 01/27/2011 2:53:52 PM
 * @version $Revision: 20134 $ 
 */
public class AnnouncementList extends AbstractList {


    /**
     * <P>Generate Instance.</P>
     *
     */
    public AnnouncementList() {
        super();
    }


    /**
     * <P>Get object Info from List</P>
     *
     * @param index Index
     * @return object Info
     */
    public AnnouncementInfo get(int index) {
        return ((AnnouncementInfo) this.list.get(index));
    }


    /**
     * <P>Add object Info to List.</P>
     *
     * @param info object Info
     * @return List of ojbect after add object Info
     */
    public boolean add(AnnouncementInfo info) {
        return this.list.add(info);
    }
}
