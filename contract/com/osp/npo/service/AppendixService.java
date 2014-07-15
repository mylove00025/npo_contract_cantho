package com.osp.npo.service;


import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;


import com.osp.npo.core.appendix.ContractAppendixManager;
import com.osp.npo.core.appendix.ContractAppendixInfo;
import com.osp.npo.core.appendix.ContractAppendixList;


/**
 * Generate by script
 * Generate date: 04/22/2011 3:02:07 PM
 * @version $Revision$ 
 */
public class AppendixService extends AbstractService {


    /** ContractAppendix Manager Object */
    private ContractAppendixManager contractAppendixManager;




    /** <P> Service constructor </P>*/
    public AppendixService(Connection connection) {
        super(connection);
        this.contractAppendixManager = new ContractAppendixManager (connection);
    }


    /**
     * <P> entry ContractAppendixInfo object to database </P>
     *
     * @param info
     * @return number of record insert.
     * @throws SQLException
     */
    public int entryContractAppendix(ContractAppendixInfo info) throws SQLException{
        return this.contractAppendixManager.insert(info);
    }

    /**
     * <P> remove ContractAppendix by id</P>
     *
     * @param id
     * @return number of record update.
     * @throws SQLException
     */
    public int removeByAppendixCid(Long id) throws SQLException{
        return this.contractAppendixManager.deleteByAppendixCid(id);
    }


    /**
     * <P> query ContractAppendix list from database </P>
     *
     * @param forUpdate
     * @param  page current page
     * @param  maxLine maximum line of a page
     * @return number of record query
     * @throws SQLException
     * @throws IOException
    */
    public ContractAppendixList queryContractAppendix(boolean forUpdate, int page, int maxLine)
            throws SQLException, IOException{
        /* Calculate start position of page */
        int offset = (page - 1) * maxLine;
        return this.contractAppendixManager.select(forUpdate, offset, maxLine);
    }

    /**
     * <P> query ContractAppendix list by MainId from database </P>
     
     * @throws SQLException
     * @throws IOException
    */
    public ContractAppendixList queryContractAppendix(Long mainId)
            throws SQLException, IOException{  
        return this.contractAppendixManager.selectbyMainId(mainId);
    }

    /**
     * <P> query all of ContractAppendix list from database </P>
     *
     * @param forUpdate
     * @return number of record query
     * @throws SQLException
     * @throws IOException
    */
    public ContractAppendixList queryAllContractAppendix(boolean forUpdate)
            throws SQLException, IOException{
        /* if limit < 0 or offset < 0 then select all */
        return this.contractAppendixManager.select(forUpdate, -1, -1);
    }


    /**
     * <P> count total ContractAppendix </P>
     *
     * @param forUpdate
     * @return number of count record
     * @throws SQLException
     * @throws IOException
    */
    public int countTotalContractAppendix()
            throws SQLException, IOException{
        return this.contractAppendixManager.countTotal();
    }
}
