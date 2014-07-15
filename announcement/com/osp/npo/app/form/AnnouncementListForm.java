/**
 * 
 */
package com.osp.npo.app.form;

import org.apache.struts.action.ActionForm;

/**
 * @author SonHD
 * @version $Revision: 20626 $
 */
public class AnnouncementListForm extends ActionForm {

    private static final long serialVersionUID = 4549166071634268494L;
    private String announcementTitleFilter;
    private String direction;
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
     * Get the direction
     *
     * @return the direction
     */
    public String getDirection() {
        return direction;
    }
    /**
     * Set the direction
     *
     * @param direction the direction to set
     */
    public void setDirection(String direction) {
        this.direction = direction;
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
}
