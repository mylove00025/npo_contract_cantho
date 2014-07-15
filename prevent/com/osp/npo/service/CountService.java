package com.osp.npo.service;


import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;


import com.osp.npo.core.count.CountManager;
import com.osp.npo.core.count.CountInfo;
import com.osp.npo.core.count.CountList;


/**
 * Generate by script
 * Generate date: 1/3/2012 2:04:43 PM
 * @version $Revision$ 
 */
public class CountService extends AbstractService {


    /** Count Manager Object */
    private CountManager countManager;




    /** <P> Service constructor </P>*/
    public CountService(Connection connection) {
        super(connection);
        this.countManager = new CountManager (connection);
    }


    /**
     * <P> entry CountInfo object to database </P>
     *
     * @param info
     * @return number of record insert.
     * @throws SQLException
     */
    public int entryCount(CountInfo info) throws SQLException{
        return this.countManager.insert(info);
    }


    /**
     * <P> modify CountInfo object to database </P>
     *
     * @param info
     * @return number of record update.
     * @throws SQLException
     * @throws IOException
     */
    public int modifyCount(CountInfo info) throws SQLException, IOException{
        return this.countManager.update(info);
    }


    /**
     * <P> remove Count by id</P>
     *
     * @param id
     * @return number of record update.
     * @throws SQLException
     */
    public int removeCount(Long id) throws SQLException{
        return this.countManager.delete(id);
    }


    /**
     * <P> query Count list from database </P>
     *
     * @param forUpdate
     * @param  page current page
     * @param  maxLine maximum line of a page
     * @return number of record query
     * @throws SQLException
     * @throws IOException
    */
    public CountList queryCount(boolean forUpdate, int page, int maxLine)
            throws SQLException, IOException{
        /* Calculate start position of page */
        int offset = (page - 1) * maxLine;
        return this.countManager.select(forUpdate, offset, maxLine);
    }


    /**
     * <P> query all of Count list from database </P>
     *
     * @param forUpdate
     * @return number of record query
     * @throws SQLException
     * @throws IOException
    */
    public CountList queryAllCount(boolean forUpdate)
            throws SQLException, IOException{
        /* if limit < 0 or offset < 0 then select all */
        return this.countManager.select(forUpdate, -1, -1);
    }

    /**
     * <P>Get count by ID</P>
     * 
     * @param  id
     * @return  List of info that geted
     * @throws SQLException
     */
    public CountInfo queryCountById(Long id) throws SQLException {
    	return this.countManager.selectById(id);
    }

    /**
     * <P> count total Count </P>
     *
     * @param forUpdate
     * @return number of count record
     * @throws SQLException
     * @throws IOException
    */
    public int countTotalCount()
            throws SQLException, IOException{
        return this.countManager.countTotal();
    }
}
