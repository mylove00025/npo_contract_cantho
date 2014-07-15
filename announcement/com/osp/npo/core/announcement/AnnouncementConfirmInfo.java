package com.osp.npo.core.announcement;


import com.osp.npo.core.AbstractInfo;
import java.sql.Timestamp;


/**
 * Generate by script
 * Generate date: 01/27/2011 2:53:52 PM
 * @version $Revision: 20134 $ 
 */
public class AnnouncementConfirmInfo extends AbstractInfo {


    /** Announcement ID */
    private Long aid;

    /** Confirm type */
    private Byte confirmType;

    /** Confirm date time */
    private Timestamp confirmDateTime;

    /** Confirm person information */
    private String confirmPerson;


    /**
     * <P>Generate Instance.</P>
     *
     */
    public AnnouncementConfirmInfo() {
        super();
    }


    /**
     * <P>Get Announcement ID </P>
     *
     * @return Announcement ID
     */
    public Long getAid() {
        return this.aid;
    }

    /**
     * <P>Set Announcement ID. </P>
     *
     * @param aid Announcement ID
     */
    public void setAid(Long aid) {
        this.aid = aid;
    }

    /**
     * <P>Get Confirm type </P>
     *
     * @return Confirm type

     */
    public Byte getConfirmType() {
        return this.confirmType;
    }

    /**
     * <P>Set Confirm type. </P>
     *
     * @param confirmType Confirm type

     */
    public void setConfirmType(Byte confirmType) {
        this.confirmType = confirmType;
    }

    /**
     * <P>Get Confirm date time </P>
     *
     * @return Confirm date time
     */
    public Timestamp getConfirmDateTime() {
        return this.confirmDateTime;
    }

    /**
     * <P>Set Confirm date time. </P>
     *
     * @param confirmDateTime Confirm date time
     */
    public void setConfirmDateTime(Timestamp confirmDateTime) {
        this.confirmDateTime = confirmDateTime;
    }

    /**
     * <P>Get Confirm person information </P>
     *
     * @return Confirm person information
     */
    public String getConfirmPerson() {
        return this.confirmPerson;
    }

    /**
     * <P>Set Confirm person information. </P>
     *
     * @param confirmPerson Confirm person information
     */
    public void setConfirmPerson(String confirmPerson) {
        this.confirmPerson = confirmPerson;
    }
}
