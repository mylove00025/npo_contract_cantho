package com.osp.npo.service;


import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;


import com.osp.npo.core.OrderField;
import com.osp.npo.core.accessHistory.AccessHistoryManager;
import com.osp.npo.core.accessHistory.AccessHistoryInfo;
import com.osp.npo.core.accessHistory.AccessHistoryList;


/**
 * Generate by script
 * Generate date: 06/24/2011 8:55:46 AM
 * @version $Revision$ 
 */
public class AccessHistoryService extends AbstractService {


    /** AccessHistory Manager Object */
    private AccessHistoryManager accessHistoryManager;




    /** <P> Service constructor </P>*/
    public AccessHistoryService(Connection connection) {
        super(connection);
        this.accessHistoryManager = new AccessHistoryManager (connection);
    }


    /**
     * <P> entry AccessHistoryInfo object to database </P>
     *
     * @param info
     * @return number of record insert.
     * @throws SQLException
     */
    
    
    
    public int entryAccessHistory(AccessHistoryInfo info) throws SQLException{
        return this.accessHistoryManager.insert(info);
    }


    /**
     * <P> modify AccessHistoryInfo object to database </P>
     *
     * @param info
     * @return number of record update.
     * @throws SQLException
     * @throws IOException
     */
    public int modifyAccessHistory(AccessHistoryInfo info) throws SQLException, IOException{
        return this.accessHistoryManager.update(info);
    }


    /**
     * <P> remove AccessHistory by id</P>
     *
     * @param id
     * @return number of record update.
     * @throws SQLException
     */
    public int removeAccessHistory(Long id) throws SQLException{
        return this.accessHistoryManager.delete(id);
    }


    /**
     * <P> query AccessHistory list from database </P>
     *
     * @param forUpdate
     * @param  page current page
     * @param  maxLine maximum line of a page
     * @return number of record query
     * @throws SQLException
     * @throws IOException
    */
    public AccessHistoryList queryAccessHistory(boolean forUpdate, int page, int maxLine)
            throws SQLException, IOException{
        /* Calculate start position of page */
        int offset = (page - 1) * maxLine;
        return this.accessHistoryManager.select(forUpdate, offset, maxLine);
    }


    /**
     * <P> query all of AccessHistory list from database </P>
     *
     * @param forUpdate
     * @return number of record query
     * @throws SQLException
     * @throws IOException
    */
    public AccessHistoryList queryAllAccessHistory(boolean forUpdate)
            throws SQLException, IOException{
        /* if limit < 0 or offset < 0 then select all */
        return this.accessHistoryManager.select(forUpdate, -1, -1);
    }


    /**
     * <P> count total AccessHistory </P>
     *
     * @param forUpdate
     * @return number of count record
     * @throws SQLException
     * @throws IOException
    */
    public int countTotalAccessHistory()
            throws SQLException, IOException{
        return this.accessHistoryManager.countTotal();
    }
    
    /**
     * <P>
     * count total contract by filter
     * </P>
     *
     * @param forUpdate
     * @return number of count record
     * @throws SQLException
     * @throws IOException
     */
    public int countTotalAccessHistoryByFilter() throws SQLException, IOException {
        return this.accessHistoryManager.countTotalByFilter();
    }
    
    /**
     * Set notary DateFrom Filter
     *
     * @param notaryDateFromFilter
     */
    public void setAccessDateFromFilter(Timestamp accessDateFromFilter) {

        this.accessHistoryManager.setAccessDateFromFilter(accessDateFromFilter);
    }

    /**
     * Set notary DateTo Filter
     *
     * @param notaryDateToFilter
     */
    public void setAccessDateToFilter(Timestamp accessDateToFilter) {

        this.accessHistoryManager.setAccessDateToFilter(accessDateToFilter);
    }

    /**
     * Set notary DateTo Filter
     *
     * @param notaryDateToFilter
     */
    public void setUserIdFilter(long userIdFilter) {

        this.accessHistoryManager.setUserIdFilter(userIdFilter);
    }
    /**
     * Set notary DateTo Filter
     *
     * @param notaryDateToFilter
     */
    public void setAccessTypeFilter(byte accessType) {

        this.accessHistoryManager.setAccessTypeFilter(accessType);
    }
    
    public void addAccessOrderField(OrderField orderField) {
        this.accessHistoryManager.addOrderField(orderField);
    }


}
