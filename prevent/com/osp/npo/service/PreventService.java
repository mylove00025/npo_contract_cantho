package com.osp.npo.service;


import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.store.LockObtainFailedException;


import com.osp.npo.common.global.Constants.FilterKind;
import com.osp.npo.common.util.RelateDateTime;
import com.osp.npo.core.OrderField;
import com.osp.npo.core.luceneIndex.LuceneIndexInfo;
import com.osp.npo.core.prevent.DataPreventHistoryInfo;
import com.osp.npo.core.prevent.DataPreventHistoryList;
import com.osp.npo.core.prevent.DataPreventHistoryManager;
import com.osp.npo.core.prevent.DataPreventManager;
import com.osp.npo.core.prevent.DataPreventInfo;
import com.osp.npo.core.prevent.DataPreventList;
import com.osp.npo.core.prevent.PropertyPreventManager;
import com.osp.npo.core.prevent.PropertyPreventInfo;
import com.osp.npo.core.prevent.PropertyPreventList;
import com.osp.npo.core.prevent.TransactionPropertyInfo;
import com.osp.npo.core.prevent.TransactionPropertyList;
import com.osp.npo.core.prevent.TransactionPropertyManager;


/**
 * Generate by script
 * Generate date: 12/05/2010 1:52:14 PM
 */
public class PreventService extends AbstractService {


    /** DataPrevent Manager Object */
    private DataPreventManager dataPreventManager;


    /** PropertyPrevent Manager Object */
    private PropertyPreventManager propertyPreventManager;


    /** History manager object */
    private DataPreventHistoryManager datapreventPreventHistoryManager;
    
    /** Transaction property object*/
    private TransactionPropertyManager transactionPropertyManager;

    /** <P> Service constructor </P>*/
    public PreventService(Connection connection) {
        super(connection);
        this.dataPreventManager = new DataPreventManager (connection);
        this.propertyPreventManager = new PropertyPreventManager (connection);
        this.datapreventPreventHistoryManager = new DataPreventHistoryManager(connection);
        this.transactionPropertyManager = new TransactionPropertyManager(connection);
    }


    /**
     * <P> entry DataPreventInfo object to database </P>
     *
     * @param info
     * @return number of record insert.
     * @throws SQLException
     * @throws IOException 
     * @throws LockObtainFailedException 
     * @throws CorruptIndexException 
     */
    public int entryDataPrevent(DataPreventInfo info) throws SQLException, CorruptIndexException, LockObtainFailedException, IOException{
    	
    	int rs = this.dataPreventManager.insert(info);
    	
		LuceneIndexService luceneIndexService = new LuceneIndexService(getConnection());
        
    	LuceneIndexInfo liInfo = new LuceneIndexInfo();
    	liInfo.setType(LuceneIndexInfo.TYPE_PREVENT_DATA);
    	liInfo.setDataId(info.getId());
    	liInfo.setAction(LuceneIndexInfo.ACTION_CREATE);
    	liInfo.setEntryDateTime(RelateDateTime.getTimeNow());
    	
    	luceneIndexService.entryLuceneIndex(liInfo);
        
        return rs;
    }


    /**
     * <P> modify DataPreventInfo object to database </P>
     *
     * @param info
     * @return number of record update.
     * @throws SQLException
     * @throws IOException
     */
    public int modifyDataPrevent(DataPreventInfo info) throws SQLException, IOException{
        int rs = this.dataPreventManager.update(info);
        
		LuceneIndexService luceneIndexService = new LuceneIndexService(getConnection());
        
    	LuceneIndexInfo liInfo = new LuceneIndexInfo();
    	liInfo.setType(LuceneIndexInfo.TYPE_PREVENT_DATA);
    	liInfo.setDataId(info.getId());
    	
    	if (info.getDeleteFlg()) {
    		liInfo.setAction(LuceneIndexInfo.ACTION_REMOVE);
    	} else {
    		liInfo.setAction(LuceneIndexInfo.ACTION_MODIFY);
    	}
    	liInfo.setEntryDateTime(RelateDateTime.getTimeNow());
    	
    	luceneIndexService.entryLuceneIndex(liInfo);
        
        return rs;
    }


    /**
     * <P> remove DataPrevent by id</P>
     *
     * @param id
     * @return number of record update.
     * @throws SQLException
     * @throws IOException 
     * @throws LockObtainFailedException 
     * @throws CorruptIndexException 
     */
    public int removeDataPrevent(Long id) throws SQLException, CorruptIndexException, LockObtainFailedException, IOException{
        int rs = this.dataPreventManager.delete(id);
        
		LuceneIndexService luceneIndexService = new LuceneIndexService(getConnection());
        
    	LuceneIndexInfo liInfo = new LuceneIndexInfo();
    	liInfo.setType(LuceneIndexInfo.TYPE_PREVENT_DATA);
    	liInfo.setDataId(id);
    	liInfo.setAction(LuceneIndexInfo.ACTION_REMOVE);
    	liInfo.setEntryDateTime(RelateDateTime.getTimeNow());
    	
    	luceneIndexService.entryLuceneIndex(liInfo);
        
        return rs;
    }


    /**
     * <P> query DataPrevent list from database </P>
     *
     * @param forUpdate
     * @param  page current page
     * @param  maxLine maximum line of a page
     * @return number of record query
     * @throws SQLException
     * @throws IOException
    */
    public DataPreventList queryDataPrevent(boolean forUpdate, int page, int maxLine)
            throws SQLException, IOException{
        /* Calculate start position of page */
        int offset = (page - 1) * maxLine;
        return this.dataPreventManager.select(forUpdate, offset, maxLine);
    }


    /**
     * <P> query all of DataPrevent list from database </P>
     *
     * @param forUpdate
     * @return number of record query
     * @throws SQLException
     * @throws IOException
    */
    public DataPreventList queryAllDataPrevent(boolean forUpdate)
            throws SQLException, IOException{
        /* if limit < 0 or offset < 0 then select all */
        return this.dataPreventManager.select(forUpdate, -1, -1);
    }

    
    /**
     * <P> query all of DataPrevent list from database </P>
     *
     * @param forUpdate
     * @return number of record query
     * @throws SQLException
     * @throws IOException
    */
    public DataPreventInfo queryDataPreventById(Long id, boolean forUpdate)
            throws SQLException, IOException{
    	DataPreventManager dpManager = new DataPreventManager(getConnection());
    	dpManager.setIdFilter(id);
    	
    	DataPreventList rsList = dpManager.select(forUpdate, -1, -1);
    	
    	if (rsList.size() > 0) {
    		return rsList.get(0);
    	} else {
    		return null;
    	}
    }
    

    /**
     * <P> count total DataPrevent </P>
     *
     * @param forUpdate
     * @return number of count record
     * @throws SQLException
     * @throws IOException
    */
    public int countTotalDataPrevent()
            throws SQLException, IOException{
        return this.dataPreventManager.countTotal();
    }


    /**
     * <P> entry PropertyPreventInfo object to database </P>
     *
     * @param info
     * @return number of record insert.
     * @throws SQLException
     */
    public int entryPropertyPrevent(PropertyPreventInfo info) throws SQLException{
        return this.propertyPreventManager.insert(info);
    }


    /**
     * <P> modify PropertyPreventInfo object to database </P>
     *
     * @param info
     * @return number of record update.
     * @throws SQLException
     * @throws IOException
     */
    public int modifyPropertyPrevent(PropertyPreventInfo info) throws SQLException, IOException{
        return this.propertyPreventManager.update(info);
    }


    /**
     * <P> remove PropertyPrevent by id</P>
     *
     * @param id
     * @return number of record update.
     * @throws SQLException
     */
    public int removePropertyPrevent(Long id) throws SQLException{
        return this.propertyPreventManager.delete(id);
    }


    /**
     * <P> query PropertyPrevent list from database </P>
     *
     * @param forUpdate
     * @param  page current page
     * @param  maxLine maximum line of a page
     * @return number of record query
     * @throws SQLException
     * @throws IOException
    */
    public PropertyPreventList queryPropertyPrevent(boolean forUpdate, int page, int maxLine)
            throws SQLException, IOException{
        /* Calculate start position of page */
        int offset = (page - 1) * maxLine;
        return this.propertyPreventManager.select(forUpdate, offset, maxLine);
    }


    /**
     * <P> query all of PropertyPrevent list from database </P>
     *
     * @param forUpdate
     * @return number of record query
     * @throws SQLException
     * @throws IOException
    */
    public PropertyPreventList queryAllPropertyPrevent(boolean forUpdate)
            throws SQLException, IOException{
        /* if limit < 0 or offset < 0 then select all */
        return this.propertyPreventManager.select(forUpdate, -1, -1);
    }


    /**
     * <P> count total PropertyPrevent </P>
     *
     * @param forUpdate
     * @return number of count record
     * @throws SQLException
     * @throws IOException
    */
    public int countTotalPropertyPrevent()
            throws SQLException, IOException{
        return this.propertyPreventManager.countTotal();
    }

    /**
     * <P> count total DataPrevent by filter </P>
     *
     * @param forUpdate
     * @return number of count record
     * @throws SQLException
     * @throws IOException
    */
    public int countTotalDataPreventByFilter()
            throws SQLException, IOException {
        return this.dataPreventManager.countTotalByFilter();
    }

    /**
     * <P> entry DataPreventHistoryInfo object to database </P>
     *
     * @param info
     * @return number of record insert.
     * @throws SQLException
     */
    public int entryDataPreventHistory(DataPreventHistoryInfo info) throws SQLException{
        return this.datapreventPreventHistoryManager.insert(info);
    }


    /**
     * <P> modify DataPreventHistoryInfo object to database </P>
     *
     * @param info
     * @return number of record update.
     * @throws SQLException
     * @throws IOException
     */
    public int modifyDataPreventHistory(DataPreventHistoryInfo info) throws SQLException, IOException{
        return this.datapreventPreventHistoryManager.update(info);
    }


    /**
     * <P> remove DataPreventHistory by id</P>
     *
     * @param id
     * @return number of record update.
     * @throws SQLException
     */
    public int removeDataPreventHistory(Long id) throws SQLException{
        return this.datapreventPreventHistoryManager.delete(id);
    }

    /**
     * <P> query all of DatPreventHistory list from database </P>
     *
     * @param forUpdate
     * @return number of record query
     * @throws SQLException
     * @throws IOException
    */
    public DataPreventHistoryList queryAllDataPreventHistory(boolean forUpdate)
            throws SQLException, IOException{
        /* if limit < 0 or offset < 0 then select all */
        return this.datapreventPreventHistoryManager.select(forUpdate, -1, -1);
    }

    /**
     * Set filter by Id
     * @param id for id filter
     */

    public void setIdFilter(long id) {
        this.dataPreventManager.setIdFilter(id);
        this.datapreventPreventHistoryManager.setPreventIdFilter(id);
    }

    /**
     * Add order field for table npo_data_prevent
     * @param orderField
     */
    public void addOrderFieldDataPrevent(OrderField orderField) {
        this.dataPreventManager.addOrderField(orderField);
    }

    /**
     * Add order field for table npo_data_prevent
     * @param orderField
     */
    public void addOrderFieldDataPreventHistory(OrderField orderField) {
        this.datapreventPreventHistoryManager.addOrderField(orderField);
    }

    /**
     * Set the typeFilter
     *
     * @param typeFilter the typeFilter to set
     */
    public void setTypeFilter(String typeFilter) {
        this.dataPreventManager.setTypeFilter(typeFilter);
    }


    /**
     * Set the propertyInfoFilter
     *
     * @param propertyInfoFilter the propertyInfoFilter to set
     * @param kind Filter kind (FULL, LEFT, MIDDLE)
     */
    public void setPropertyInfoFilter(String propertyInfoFilter, FilterKind kind) {
        this.dataPreventManager.setPropertyInfoFilter(propertyInfoFilter, kind);
    }


    /**
     * Set the landCertificateFilter
     *
     * @param landCertificateFilter the landCertificateFilter to set
     * @param kind Filter kind (FULL, LEFT, MIDDLE)
     */
    public void setLandCertificateFilter(String landCertificateFilter, FilterKind kind) {
        this.dataPreventManager.setLandCertificateFilter(landCertificateFilter, kind);
    }


    /**
     * Set the landMapNumberFilter
     *
     * @param landMapNumberFilter the landMapNumberFilter to set
     * @param kind Filter kind (FULL, LEFT, MIDDLE)
     */
    public void setLandMapNumberFilter(String landMapNumberFilter, FilterKind kind) {
        this.dataPreventManager.setLandMapNumberFilter(landMapNumberFilter, kind);
    }


    /**
     * Set the landNumberFilter
     *
     * @param landNumberFilter the landNumberFilter to set
     * @param kind Filter kind (FULL, LEFT, MIDDLE)
     */
    public void setLandNumberFilter(String landNumberFilter, FilterKind kind) {
        this.dataPreventManager.setLandNumberFilter(landNumberFilter, kind);
    }


    /**
     * Set the landAddressFilter
     *
     * @param landAddressFilter the landAddressFilter to set
     * @param kind Filter kind (FULL, LEFT, MIDDLE)
     */
    public void setLandAddressFilter(String landAddressFilter, FilterKind kind) {
        this.dataPreventManager.setLandAddressFilter(landAddressFilter, kind);
    }


    /**
     * Set the carLicenseNumberFilter
     *
     * @param carLicenseNumberFilter the carLicenseNumberFilter to set
     * @param kind Filter kind (FULL, LEFT, MIDDLE)
     */
    public void setCarLicenseNumberFilter(String carLicenseNumberFilter, FilterKind kind) {
        this.dataPreventManager.setCarLicenseNumberFilter(carLicenseNumberFilter, kind);
    }


    /**
     * Set the carRegistNumberFilter
     *
     * @param carRegistNumberFilter the carRegistNumberFilter to set
     * @param kind Filter kind (FULL, LEFT, MIDDLE)
     */
    public void setCarRegistNumberFilter(String carRegistNumberFilter, FilterKind kind) {
        this.dataPreventManager.setCarRegistNumberFilter(carRegistNumberFilter, kind);
    }


    /**
     * Set the carFrameNumberFilter
     *
     * @param carFrameNumberFilter the carFrameNumberFilter to set
     * @param kind Filter kind (FULL, LEFT, MIDDLE)
     */
    public void setCarFrameNumberFilter(String carFrameNumberFilter, FilterKind kind) {
        this.dataPreventManager.setCarFrameNumberFilter(carFrameNumberFilter, kind);
    }


    /**
     * Set the carMachineNumberFilter
     *
     * @param carMachineNumberFilter the carMachineNumberFilter to set
     * @param kind Filter kind (FULL, LEFT, MIDDLE)
     */
    public void setCarMachineNumberFilter(String carMachineNumberFilter, FilterKind kind) {
        this.dataPreventManager.setCarMachineNumberFilter(carMachineNumberFilter, kind);
    }


    /**
     * Set the typeKeySearchFilter
     *
     * @param typeKeySearchFilter the typeKeySearchFilter to set
     */
    public void setTypeKeySearchFilter(String typeKeySearchFilter) {
        this.dataPreventManager.setTypeKeySearchFilter(typeKeySearchFilter);
    }


    /**
     * Set the keySearchFilter
     *
     * @param keySearchFilter the keySearchFilter to set
     */
    public void setKeySearchFilter(String keySearchFilter) {
        this.dataPreventManager.setKeySearchFilter(keySearchFilter);
    }


    /**
     * Set the originKindFilter
     *
     * @param originKindFilter the originKindFilter to set
     */
    public void setOriginKindFilter(String originKindFilter) {
        this.dataPreventManager.setOriginKindFilter(originKindFilter);
    }

    /**
     * Set the subKeys
     *
     * @param subKeys the subKeys to set
     */
    public void setSubKeys(List<String> subKeys) {
        this.dataPreventManager.setSubKeys(subKeys);
    }
    
    /**
     * Set the releaseFlgFilter
     *
     * @param releaseFlgFilter the releaseFlgFilter to set
     */
    public void setReleaseFlgFilter(Boolean releaseFlgFilter) {
        this.dataPreventManager.setReleaseFlgFilter(releaseFlgFilter);
    }
    
    /**
     * Set the deleteFlgFilter
     *
     * @param deleteFlgFilter the deleteFlgFilter to set
     */
    public void setDeleteFlgFilter(Boolean deleteFlgFilter) {
        this.dataPreventManager.setDeleteFlgFilter(deleteFlgFilter);
    }
    
    /**
     * <P> entry TransactionPropertyInfo object to database </P>
     *
     * @param info
     * @return number of record insert.
     * @throws SQLException
     * @throws IOException 
     * @throws LockObtainFailedException 
     * @throws CorruptIndexException 
     */
	public int entryTransactionProperty(TransactionPropertyInfo info)
			throws SQLException, CorruptIndexException,
			LockObtainFailedException, IOException {
		int rs = this.transactionPropertyManager.insert(info);
        
		LuceneIndexService luceneIndexService = new LuceneIndexService(getConnection());
        
    	LuceneIndexInfo liInfo = new LuceneIndexInfo();
    	liInfo.setType(LuceneIndexInfo.TYPE_TRANSACTION);
    	liInfo.setDataId(info.getTpid());
    	liInfo.setAction(LuceneIndexInfo.ACTION_CREATE);
    	liInfo.setEntryDateTime(RelateDateTime.getTimeNow());
    	
    	luceneIndexService.entryLuceneIndex(liInfo);
        
        return rs;
    }


    /**
     * <P> modify TransactionPropertyInfo object to database </P>
     *
     * @param info
     * @return number of record update.
     * @throws SQLException
     * @throws IOException
     */
    public int modifyTransactionProperty(TransactionPropertyInfo info) throws SQLException, IOException{
    	int rs = this.transactionPropertyManager.update(info);
    	
		LuceneIndexService luceneIndexService = new LuceneIndexService(getConnection());
        
    	LuceneIndexInfo liInfo = new LuceneIndexInfo();
    	liInfo.setType(LuceneIndexInfo.TYPE_TRANSACTION);
    	liInfo.setDataId(info.getTpid());
    	liInfo.setAction(LuceneIndexInfo.ACTION_MODIFY);
    	liInfo.setEntryDateTime(RelateDateTime.getTimeNow());
    	
    	luceneIndexService.entryLuceneIndex(liInfo);

		return rs;
    }


    /**
     * <P> remove TransactionProperty by id</P>
     *
     * @param id
     * @return number of record update.
     * @throws SQLException
     * @throws IOException 
     * @throws LockObtainFailedException 
     * @throws CorruptIndexException 
     */
    public int removeTransactionProperty(Long tpid) throws SQLException, CorruptIndexException, LockObtainFailedException, IOException{
        int rs = this.transactionPropertyManager.delete(tpid);
        
		LuceneIndexService luceneIndexService = new LuceneIndexService(getConnection());
        
    	LuceneIndexInfo liInfo = new LuceneIndexInfo();
    	liInfo.setType(LuceneIndexInfo.TYPE_TRANSACTION);
    	liInfo.setDataId(tpid);
    	liInfo.setAction(LuceneIndexInfo.ACTION_REMOVE);
    	liInfo.setEntryDateTime(RelateDateTime.getTimeNow());
    	
    	luceneIndexService.entryLuceneIndex(liInfo);

		return rs;
    }


    /**
     * <P> query TransactionProperty list from database </P>
     *
     * @param forUpdate
     * @param  page current page
     * @param  maxLine maximum line of a page
     * @return number of record query
     * @throws SQLException
     * @throws IOException
    */
    public TransactionPropertyList queryTransactionProperty(boolean forUpdate, int page, int maxLine)
            throws SQLException, IOException{
        /* Calculate start position of page */
        int offset = (page - 1) * maxLine;
        return this.transactionPropertyManager.select(forUpdate, offset, maxLine);
    }
    
    /**
     * <P> query TransactionProperty list from database </P>
     *
     * @param forUpdate
     * @param  page current page
     * @param  maxLine maximum line of a page
     * @return number of record query
     * @throws SQLException
     * @throws IOException
    */
    public TransactionPropertyList queryTransactionPropertyForContractList(boolean forUpdate, int page, int maxLine)
            throws SQLException, IOException{
        /* Calculate start position of page */
        int offset = (page - 1) * maxLine;
        return this.transactionPropertyManager.selectForContractList(forUpdate, offset, maxLine);
    }


    /**
     * <P> query all of TransactionProperty list from database </P>
     *
     * @param forUpdate
     * @return number of record query
     * @throws SQLException
     * @throws IOException
    */
    public TransactionPropertyList queryAllTransactionProperty(boolean forUpdate)
            throws SQLException, IOException{
        /* if limit < 0 or offset < 0 then select all */
        return this.transactionPropertyManager.selectByContract(forUpdate, -1, -1);
    }
    
    /**
     * <P> query TransactionProperty by Tpid </P>
     *
     * @param forUpdate
     * @return number of record query
     * @throws SQLException
     * @throws IOException
    */
    public TransactionPropertyInfo queryTransactionPropertyByTpid(Long tpid, boolean forUpdate)
            throws SQLException, IOException{
        return this.transactionPropertyManager.selectByTpid(tpid, forUpdate);
    }


    /**
     * <P> count total TransactionProperty </P>
     *
     * @param forUpdate
     * @return number of count record
     * @throws SQLException
     * @throws IOException
    */
    public int countTotalTransactionProperty()
            throws SQLException, IOException{
        return this.transactionPropertyManager.countTotal();
    }
    
    /**
     * Add order field for table npo_transaction_property
     * @param orderField
     */
    public void addOrderFieldTransactionProperty(OrderField orderField) {
        this.transactionPropertyManager.addOrderField(orderField);
    }
    
    /**
     * Set the keySearchFilter
     *
     * @param keySearchFilter the keySearchFilter to set
     */
    public void setKeySearchTransactionFilter(String keySearchFilter) {
        this.transactionPropertyManager.setKeySearchFilter(keySearchFilter);
    }
    
    /**
     * Set the typeFilter
     *
     * @param typeFilter the typeFilter to set
     */
    public void setTypeTransactionFilter(String typeFilter) {
        this.transactionPropertyManager.setTypeFilter(typeFilter);
    }
    
    /**
     * Set the subKeys of transaction
     *
     * @param subKeys the subKeys to set
     */
    public void setSubKeysTransaction(List<String> subKeys) {
        this.transactionPropertyManager.setSubKeys(subKeys);
    }
    
    /**
     * Set the contractIdFilter
     *
     * @param contractIdFilter the contractIdFilter to set
     */
    public void setContractIdFilter(Long contractIdFilter) {
        this.transactionPropertyManager.setContractIdFilter(contractIdFilter);
    }
    
    ///////////////////

    /**
     * Set the contractNumberFilter
     *
     * @param contractNumberFilter the contractNumberFilter to set
     */
    public void setContractNumberFilter(String contractNumberFilter, FilterKind kind) {
        this.transactionPropertyManager.setContractNumberFilter(contractNumberFilter, kind);
    }


    /**
     * Set the contractNameFilter
     *
     * @param contractNameFilter the contractNameFilter to set
     */
    public void setContractNameFilter(String[] contractNameFilter) {
        this.transactionPropertyManager.setContractNameFilter(contractNameFilter);
    }


    /**
     * Set the relationObjectFilter
     *
     * @param relationObjectFilter the relationObjectFilter to set
     */
    public void setRelationObjectFilter(String relationObjectFilter, FilterKind kind) {
        this.transactionPropertyManager.setRelationObjectFilter(relationObjectFilter, kind);
    }


    /**
     * Set the notaryDateFromFilter
     *
     * @param notaryDateFromFilter the notaryDateFromFilter to set
     */
    public void setNotaryDateFromFilter(Timestamp notaryDateFromFilter) {
        this.transactionPropertyManager.setNotaryDateFromFilter(notaryDateFromFilter);
    }


    /**
     * Set the notaryDateToFilter
     *
     * @param notaryDateToFilter the notaryDateToFilter to set
     */
    public void setNotaryDateToFilter(Timestamp notaryDateToFilter) {
        this.transactionPropertyManager.setNotaryDateToFilter(notaryDateToFilter);
    }
    

    /**
     * Set the propertyInfoFilter
     *
     * @param propertyInfoFilter the propertyInfoFilter to set
     */
    public void setTransactionPropertyInfoFilter(String propertyInfoFilter, FilterKind kind) {
        this.transactionPropertyManager.setPropertyInfoFilter(propertyInfoFilter, kind);
    }
    
    /**
     * Set office code
     * @param officeCode
     */
    public void setOfficeCodeFilter(String officeCode) {
    	this.dataPreventManager.setOfficeCode(officeCode);
    	this.transactionPropertyManager.setOfficeCode(officeCode);
    }
    
    /**
     * Set entry user id
     * @param entryUserId
     */
    public void setEntryUserIdFilter(Long entryUserId) {
    	this.transactionPropertyManager.setEntryUserIdFilter(entryUserId);
    }
}
