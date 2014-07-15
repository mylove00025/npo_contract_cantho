package com.osp.npo.service;


import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.osp.npo.core.OrderField;
import com.osp.npo.core.synchronizews.SynchronizeWsInfo;
import com.osp.npo.core.synchronizews.SynchronizeWsList;
import com.osp.npo.core.synchronizews.SynchronizeWsManager;


/**
 * Generate by script
 * Generate date: 02/17/2011 10:08:27 AM
 */
public class SynchronizeWsService extends AbstractService {


    /** Synchronize Manager Object */
    private SynchronizeWsManager synchronizeManager;




    /** <P> Service constructor </P>*/
    public SynchronizeWsService(Connection connection) {
        super(connection);
        this.synchronizeManager = new SynchronizeWsManager (connection);
    }


    /**
     * <P> entry SynchronizeInfo object to database </P>
     *
     * @param info
     * @return number of record insert.
     * @throws SQLException
     */
    public int entrySynchronize(SynchronizeWsInfo info) throws SQLException{
        return this.synchronizeManager.insert(info);
    }


    /**
     * <P> modify SynchronizeInfo object to database </P>
     *
     * @param info
     * @return number of record update.
     * @throws SQLException
     * @throws IOException
     */
    public int modifySynchronize(SynchronizeWsInfo info) throws SQLException, IOException{
        return this.synchronizeManager.update(info);
    }
    
    
    /**
     * <P> Change error status </P>
     *
     * @return number of record update.
     * @throws SQLException
     * @throws IOException
     */
    public int changeErrorStatus() throws SQLException, IOException{
        return this.synchronizeManager.updateErrorStatus();
    }


    /**
     * <P> remove Synchronize by id</P>
     *
     * @param id
     * @return number of record update.
     * @throws SQLException
     */
    public int removeSynchronize(String dataId) throws SQLException{
        return this.synchronizeManager.delete(dataId);
    }
    
    /**
     * <P> remove Synchronize by data id</P>
     *
     * @param id
     * @return number of record update.
     * @throws SQLException
     */
    public int removeSynchByDataId(String dataId) throws SQLException{
        return this.synchronizeManager.deleteByDataId(dataId);
    }
    
    
    /**
     * <P> remove Synchronize by id</P>
     *
     * @param id
     * @return number of record update.
     * @throws SQLException
     */
    public int removeSynchronize(String[] dataId) throws SQLException{
        return this.synchronizeManager.delete(dataId);
    }


    /**
     * <P> query Synchronize list from database </P>
     *
     * @param forUpdate
     * @param  page current page
     * @param  maxLine maximum line of a page
     * @return number of record query
     * @throws SQLException
     * @throws IOException
    */
    public SynchronizeWsList querySynchronize(boolean forUpdate, int page, int maxLine)
            throws SQLException, IOException{
        /* Calculate start position of page */
        int offset = (page - 1) * maxLine;
        return this.synchronizeManager.select(forUpdate, offset, maxLine);
    }


    /**
     * <P> query all of Synchronize list from database </P>
     *
     * @param forUpdate
     * @return number of record query
     * @throws SQLException
     * @throws IOException
    */
    public SynchronizeWsList queryAllSynchronize(boolean forUpdate)
            throws SQLException, IOException{
        /* if limit < 0 or offset < 0 then select all */
        return this.synchronizeManager.select(forUpdate, -1, -1);
    }


    /**
     * <P> count total Synchronize </P>
     *
     * @param forUpdate
     * @return number of count record
     * @throws SQLException
     * @throws IOException
    */
    public int countTotalSynchronize()
            throws SQLException, IOException{
        return this.synchronizeManager.countTotal();
    }
    
    /**
     * Set the dataId
     *
     * @param dataId the dataId to set
     */
    public void setDataId(String dataId) {
        this.synchronizeManager.setDataId(dataId);
    }
    
    /**
     * Set the authenticationIdFilter
     *
     * @param authenticationIdFilter the authenticationIdFilter to set
     */
    public void setAuthenticationIdFilter(String authenticationIdFilter) {
        this.synchronizeManager.setAuthenticationIdFilter(authenticationIdFilter);
    }
    
    /**
     * Set the statusFilter
     *
     * @param statusFilter the statusFilter to set
     */
    public void setStatusFilter(Byte statusFilter) {
        this.synchronizeManager.setStatusFilter(statusFilter);
    }
    
    /**
     * Add order field
     *
     * @param orderField
     */
    public void addOrderField(OrderField orderField) {
        this.synchronizeManager.addOrderField(orderField);
    }
}
