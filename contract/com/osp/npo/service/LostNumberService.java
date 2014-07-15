package com.osp.npo.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.store.LockObtainFailedException;

import com.osp.npo.core.contract.LostNumberInfo;
import com.osp.npo.core.contract.LostNumberManager;

public class LostNumberService extends AbstractService{
	
	 /** Lost Number Manager Object */
    private LostNumberManager lostNumberManager;
    
    /**
     * <P>
     * Service constructor
     * </P>
     */
    public LostNumberService(Connection connection) {
        super(connection);
        this.lostNumberManager = new LostNumberManager(connection);
    }
	
    /**
     * <P> entry ContractNumberInfo object to database </P>
     *
     * @param info
     * @return number of record insert.
     * @throws SQLException
     */
    public int entryLostNumber(LostNumberInfo info) throws SQLException{
        return this.lostNumberManager.insert(info);
    }
    
    /**
     * <P>
     * query LostNumber from database
     * </P>
     *
     * @param forUpdate
     * @param page
     *            current page
     * @param maxLine
     *            maximum line of a page
     * @return number of record query
     * @throws SQLException
     * @throws IOException
     */
    public LostNumberInfo queryLostNumber(LostNumberInfo lostNumberInfo) throws SQLException, IOException {
 
        return this.lostNumberManager.selectLostNumber(lostNumberInfo);
    }
    
    /**
     * <P>
     * remove Contract by id
     * </P>
     *
     * @param id
     * @return number of record update.
     * @throws SQLException
     * @throws IOException 
     * @throws LockObtainFailedException 
     * @throws CorruptIndexException 
     */
    public int removeLostNumber(LostNumberInfo lostNumberInfo) throws SQLException, CorruptIndexException, LockObtainFailedException, IOException {
    	int rs = this.lostNumberManager.delete(lostNumberInfo);
        return rs;
    }

	

}
