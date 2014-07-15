/**
 * 
 */
package com.osp.npo.app.context;

import java.util.List;

import com.osp.npo.core.announcement.AnnouncementInfo;

/**
 * @author SonHD
 * @version $Revision: 20626 $
 */
public class AnnouncementContext {
    public static final String SESSION_KEY = "announcementContext";
    private String announcementTitleFilter;
    private List<AnnouncementInfo> announcementList;
    private String[] chkID;
    /**
     * Get the announcementTitleFilter
     *
     * @return the announcementTitleFilter
     */
    public String getAnnouncementTitleFilter() {
        return announcementTitleFilter;
    }
    /**
     * Set the announcementTitleFilter
     *
     * @param announcementTitleFilter the announcementTitleFilter to set
     */
    public void setAnnouncementTitleFilter(String announcementTitleFilter) {
        this.announcementTitleFilter = announcementTitleFilter;
    }
    /**
     * Get the announcementList
     *
     * @return the announcementList
     */
    public List<AnnouncementInfo> getAnnouncementList() {
        return announcementList;
    }
    /**
     * Set the announcementList
     *
     * @param announcementList the announcementList to set
     */
    public void setAnnouncementList(List<AnnouncementInfo> announcementList) {
        this.announcementList = announcementList;
    }
    /**
     * Get the chkID
     *
     * @return the chkID
     */
    public String[] getChkID() {
        return chkID;
    }
    /**
     * Set the chkID
     *
     * @param chkID the chkID to set
     */
    public void setChkID(String[] chkID) {
        this.chkID = chkID;
    }
    
    public void clear() {
        this.announcementTitleFilter = null;
        this.chkID = null;
    }
}
