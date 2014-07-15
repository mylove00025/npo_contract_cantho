package com.osp.npo.service;


import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;


import com.osp.npo.common.global.Constants.FilterKind;
import com.osp.npo.core.OrderField;
import com.osp.npo.core.announcement.AnnouncementManager;
import com.osp.npo.core.announcement.AnnouncementInfo;
import com.osp.npo.core.announcement.AnnouncementList;
import com.osp.npo.core.announcement.AnnouncementConfirmManager;
import com.osp.npo.core.announcement.AnnouncementConfirmInfo;
import com.osp.npo.core.announcement.AnnouncementConfirmList;


/**
 * Generate by script
 * Generate date: 01/27/2011 2:53:53 PM
 * @version $Revision: 21537 $ 
 */
public class AnnouncementService extends AbstractService {


    /** Announcement Manager Object */
    private AnnouncementManager announcementManager;


    /** AnnouncementConfirm Manager Object */
    private AnnouncementConfirmManager announcementConfirmManager;




    /** <P> Service constructor </P>*/
    public AnnouncementService(Connection connection) {
        super(connection);
        this.announcementManager = new AnnouncementManager (connection);
        this.announcementConfirmManager = new AnnouncementConfirmManager (connection);
    }


    /**
     * <P> entry AnnouncementInfo object to database </P>
     *
     * @param info
     * @return number of record insert.
     * @throws SQLException
     */
    public int entryAnnouncement(AnnouncementInfo info) throws SQLException{
        return this.announcementManager.insert(info);
    }


    /**
     * <P> modify AnnouncementInfo object to database </P>
     *
     * @param info
     * @return number of record update.
     * @throws SQLException
     * @throws IOException
     */
    public int modifyAnnouncement(AnnouncementInfo info) throws SQLException, IOException{
        return this.announcementManager.update(info);
    }


    /**
     * <P> remove Announcement by id</P>
     *
     * @param id
     * @return number of record update.
     * @throws SQLException
     */
    public int removeAnnouncement(Long id) throws SQLException{
        return this.announcementManager.delete(id);
    }


    /**
     * <P> query Announcement list from database </P>
     *
     * @param forUpdate
     * @param  page current page
     * @param  maxLine maximum line of a page
     * @return number of record query
     * @throws SQLException
     * @throws IOException
    */
    public AnnouncementList queryAnnouncement(boolean forUpdate, int page, int maxLine)
            throws SQLException, IOException{
        /* Calculate start position of page */
        int offset = (page - 1) * maxLine;
        return this.announcementManager.select(forUpdate, offset, maxLine);
    }


    /**
     * <P> query all of Announcement list from database </P>
     *
     * @param forUpdate
     * @return number of record query
     * @throws SQLException
     * @throws IOException
    */
    public AnnouncementList queryAllAnnouncement(boolean forUpdate)
            throws SQLException, IOException{
        /* if limit < 0 or offset < 0 then select all */
        return this.announcementManager.select(forUpdate, -1, -1);
    }


    /**
     * <P> Query all of latest Announcement list from database </P>
     *
     * @param forUpdate
     * @return number of record query
     * @throws SQLException
     * @throws IOException
    */
    public AnnouncementList queryLatestAnnouncement(int count)
            throws SQLException, IOException{
        /* if limit < 0 or offset < 0 then select all */
        return this.announcementManager.selectLatestAnnouncement(count);
    }
    
    /**
     * <P> Query all of late Announcement list from database </P>
     *
     * @param forUpdate
     * @return number of record query
     * @throws SQLException
     * @throws IOException
    */
    public AnnouncementList queryLateAnnouncement(int count)
            throws SQLException, IOException{
        /* if limit < 0 or offset < 0 then select all */
        return this.announcementManager.selectLateAnnouncement(count);
    }
    
    /**
     * <P> Query Announcement by ID </P>
     *
     * @param forUpdate
     * @param aid
     * @return number of record query
     * @throws SQLException
     * @throws IOException
    */
    public AnnouncementInfo queryAnnouncementById(boolean forUpdate, Long aid)
            throws SQLException, IOException{
        /* if limit < 0 or offset < 0 then select all */
        return this.announcementManager.selectById(forUpdate, aid);
    }
    
    /**
     * <P> Query popup announcement for homepage </P>
     *
     * @return number of record query
     * @throws SQLException
     * @throws IOException
    */
    public AnnouncementInfo queryPopupAnnouncement()
            throws SQLException, IOException{
        return this.announcementManager.selectPopupAnnouncement();
    }


    /**
     * <P> count total Announcement </P>
     *
     * @param forUpdate
     * @return number of count record
     * @throws SQLException
     * @throws IOException
    */
    public int countTotalAnnouncement()
            throws SQLException, IOException{
        return this.announcementManager.countTotal();
    }


    /**
     * <P> entry AnnouncementConfirmInfo object to database </P>
     *
     * @param info
     * @return number of record insert.
     * @throws SQLException
     */
    public int entryAnnouncementConfirm(AnnouncementConfirmInfo info) throws SQLException{
        return this.announcementConfirmManager.insert(info);
    }


    /**
     * <P> remove AnnouncementConfirm by id</P>
     *
     * @param id
     * @return number of record update.
     * @throws SQLException
     */
    public int removeAnnouncementConfirm(Long id) throws SQLException{
        return this.announcementConfirmManager.delete(id);
    }


    /**
     * <P> query AnnouncementConfirm list from database </P>
     *
     * @param forUpdate
     * @param  page current page
     * @param  maxLine maximum line of a page
     * @return number of record query
     * @throws SQLException
     * @throws IOException
    */
    public AnnouncementConfirmList queryAnnouncementConfirm(boolean forUpdate, int page, int maxLine)
            throws SQLException, IOException{
        /* Calculate start position of page */
        int offset = (page - 1) * maxLine;
        return this.announcementConfirmManager.select(forUpdate, offset, maxLine);
    }


    /**
     * <P> query all of AnnouncementConfirm list from database </P>
     *
     * @param forUpdate
     * @return number of record query
     * @throws SQLException
     * @throws IOException
    */
    public AnnouncementConfirmList queryAllAnnouncementConfirm(boolean forUpdate)
            throws SQLException, IOException{
        /* if limit < 0 or offset < 0 then select all */
        return this.announcementConfirmManager.select(forUpdate, -1, -1);
    }
    

    /**
     * <P> count total AnnouncementConfirm </P>
     *
     * @param forUpdate
     * @return number of count record
     * @throws SQLException
     * @throws IOException
    */
    public int countTotalAnnouncementConfirm()
            throws SQLException, IOException{
        return this.announcementConfirmManager.countTotal();
    }
    
    /**
     * Add order field for table announcement
     * @param orderField
     */
    public void addOrderFieldAnnouncement(OrderField orderField) {
        this.announcementManager.addOrderField(orderField);
    }
    
    public void setTitleFilter(String titleFilter, FilterKind kind) {
        this.announcementManager.setTitleFilter(titleFilter, kind);
    }
    
    public void setIdFilter(Long idFilter) {
        this.announcementManager.setIdFilter(idFilter);
    }
    
    /**
     * Set current open announcement id
     * @param idCurentFilter
     */
    public void setIdCurentFilter(Long idCurentFilter) {
        this.announcementManager.setIdCurentFilter(idCurentFilter);
    }
    
    /**
     * Set kind filter
     * @param kind
     */
    public void setKindFilter(Byte kind) {
        this.announcementManager.setKindFilter(kind);
    }
}
