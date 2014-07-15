/**
 * 
 */
package com.osp.npo.app.viewhelper;

import java.util.List;

import com.osp.npo.app.form.AnnouncementListForm;
import com.osp.npo.core.announcement.AnnouncementInfo;

/**
 * @author SonHD
 * @version $Revision: 20686 $
 */
public class AnnouncementListViewHelper extends AbstractPageListViewHelper {
    
    public static final String SESSION_KEY = "announcementListViewHelper";
    private String announcementTitleFilter;
    private List<AnnouncementInfo> announcementList;
    private String[] chkID;
    private String chkAllID;
    
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
    
    /**
     * Get the chkAllID
     *
     * @return the chkAllID
     */
    public String getChkAllID() {
        return chkAllID;
    }
    /**
     * Set the chkAllID
     *
     * @param chkAllID the chkAllID to set
     */
    public void setChkAllID(String chkAllID) {
        this.chkAllID = chkAllID;
    }
    public void reset(AnnouncementListForm form) {
        this.announcementTitleFilter = form.getAnnouncementTitleFilter();        
        this.chkID = form.getChkID();
    }
}
