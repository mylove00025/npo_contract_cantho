package com.osp.npo.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.store.LockObtainFailedException;

import com.osp.npo.common.global.Constants;
import com.osp.npo.common.global.Constants.FilterKind;
import com.osp.npo.common.util.EditString;
import com.osp.npo.common.util.RelateDateTime;
import com.osp.npo.common.util.SystemMessageProperties;
import com.osp.npo.core.OrderField;
import com.osp.npo.core.appendix.ContractAppendixManager;
import com.osp.npo.core.contract.ContractInfo;
import com.osp.npo.core.contract.ContractKindInfo;
import com.osp.npo.core.contract.ContractKindList;
import com.osp.npo.core.contract.ContractKindListForNotary;
import com.osp.npo.core.contract.ContractKindManager;
import com.osp.npo.core.contract.ContractList;
import com.osp.npo.core.contract.ContractManager;
import com.osp.npo.core.contract.ContractPropertyInfo;
import com.osp.npo.core.contract.ContractPropertyList;
import com.osp.npo.core.contract.ContractPropertyManager;
import com.osp.npo.core.contract.ContractStatisticalInfo;
import com.osp.npo.core.contract.ContractStatisticalList;
import com.osp.npo.core.contract.ContractStatisticalManager;
import com.osp.npo.core.contract.ContractTemplateInfo;
import com.osp.npo.core.contract.ContractTemplateList;
import com.osp.npo.core.contract.ContractTemplateManager;
import com.osp.npo.core.contract.PropertyInfo;
import com.osp.npo.core.contract.PropertyList;
import com.osp.npo.core.contract.PropertyManager;
import com.osp.npo.core.contract.RelationObjectInfo;
import com.osp.npo.core.contract.RelationObjectList;
import com.osp.npo.core.contract.RelationObjectManager;
import com.osp.npo.core.luceneIndex.LuceneIndexInfo;
import com.osp.npo.core.user.UserInfo;
import com.osp.npo.core.user.UserList;
import com.osp.npo.core.user.UserManager;

/**
 * Generate by script
 * Generate date: 10/13/2010 3:47:47 PM
 */
public class ContractService extends AbstractService {

    /** Contract Manager Object */
    private ContractManager contractManager;

    /** RelationObject Manager Object */
    private RelationObjectManager relationObjectManager;

    /** ContractKind Manager Object */
    private ContractKindManager contractKindManager;

    /** ContractTemplate Manager Object */
    private ContractTemplateManager contractTemplateManager;

    /** User Manager Object */
    private UserManager userManager;

    /** ContractStatistical Manager Object */
    private ContractStatisticalManager contractStatisticalManager;

    /** Property Manager Object */
    private PropertyManager propertyManager;

    /** ContractProperty Manager Object */
    private ContractPropertyManager contractPropertyManager;
    
    private ContractAppendixManager contractAppendixManager;

    /**
     * <P>
     * Service constructor
     * </P>
     */
    public ContractService(Connection connection) {
        super(connection);
        this.contractManager = new ContractManager(connection);
        this.relationObjectManager = new RelationObjectManager(connection);
        this.contractKindManager = new ContractKindManager(connection);
        this.contractTemplateManager = new ContractTemplateManager(connection);
        this.userManager = new UserManager(connection);
        this.contractStatisticalManager = new ContractStatisticalManager(connection);
        this.propertyManager = new PropertyManager(connection);
        this.contractPropertyManager = new ContractPropertyManager(connection);
        this.contractAppendixManager = new ContractAppendixManager(connection);
    }

    /**
     * <P>
     * entry ContractInfo object to database
     * </P>
     *
     * @param info
     * @return number of record insert.
     * @throws SQLException
     * @throws IOException 
     * @throws LockObtainFailedException 
     * @throws CorruptIndexException 
     */
    public int entryContract(ContractInfo info) throws SQLException, CorruptIndexException, LockObtainFailedException, IOException {
    	int rs = this.contractManager.insert(info);
    	
    	ContractTemplateInfo ctInfo = this.contractTemplateManager.selectById(info.getContractTemplateId(), false);
    	info.setContractTemplateName(ctInfo.getName());
    	
    	UserInfo notaryUser = this.queryUserInfoById(info.getNotaryId(), false);
    	info.setNotaryFamilyName(notaryUser.getFamilyName());
    	info.setNotaryFirstName(notaryUser.getFirstName());
    	
    	LuceneIndexService luceneIndexService = new LuceneIndexService(getConnection());
    	
    	LuceneIndexInfo liInfo = new LuceneIndexInfo();
    	liInfo.setType(LuceneIndexInfo.TYPE_CONTRACT);
    	liInfo.setDataId(info.getId());
    	liInfo.setAction(LuceneIndexInfo.ACTION_CREATE);
    	liInfo.setEntryDateTime(RelateDateTime.getTimeNow());
    	
    	luceneIndexService.entryLuceneIndex(liInfo);
        
        return rs;
    }
    

    /**
     * <P>
     * modify ContractInfo object to database
     * </P>
     *
     * @param info
     * @return number of record update.
     * @throws SQLException
     * @throws IOException
     */
    public int modifyContract(ContractInfo info) throws SQLException, IOException {
    	
    	int rs = this.contractManager.update(info);
    	
    	ContractTemplateInfo ctInfo = this.contractTemplateManager.selectById(info.getContractTemplateId(), false);
    	info.setContractTemplateName(ctInfo.getName());
    	
    	UserInfo notaryUser = this.queryUserInfoById(info.getNotaryId(), false);
    	info.setNotaryFamilyName(notaryUser.getFamilyName());
    	info.setNotaryFirstName(notaryUser.getFirstName());
    	
    	LuceneIndexService luceneIndexService = new LuceneIndexService(getConnection());
    	
    	LuceneIndexInfo liInfo = new LuceneIndexInfo();
    	liInfo.setType(LuceneIndexInfo.TYPE_CONTRACT);
    	liInfo.setDataId(info.getId());
    	liInfo.setAction(LuceneIndexInfo.ACTION_MODIFY);
    	liInfo.setEntryDateTime(RelateDateTime.getTimeNow());
    	
    	luceneIndexService.entryLuceneIndex(liInfo);
        
        return rs;
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
    public int removeContract(Long id) throws SQLException, CorruptIndexException, LockObtainFailedException, IOException {
    	contractPropertyManager.delete(id);
    	contractAppendixManager.deleteByAppendixCid(id);
    	
    	int rs = this.contractManager.delete(id);
    	
    	LuceneIndexService luceneIndexService = new LuceneIndexService(getConnection());
    	
    	LuceneIndexInfo liInfo = new LuceneIndexInfo();
    	liInfo.setType(LuceneIndexInfo.TYPE_CONTRACT);
    	liInfo.setDataId(id);
    	liInfo.setAction(LuceneIndexInfo.ACTION_REMOVE);
    	liInfo.setEntryDateTime(RelateDateTime.getTimeNow());
    	
    	luceneIndexService.entryLuceneIndex(liInfo);
        
        return rs;
    }

    /**
     * <P>
     * query Contract list from database
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
    public ContractList queryContract(boolean forUpdate, int page, int maxLine) throws SQLException, IOException {
        /* Calculate start position of page */
        int offset = (page - 1) * maxLine;
        return this.contractManager.select(forUpdate, offset, maxLine);
    }

    /**
     * <P>
     * query all of Contract list from database
     * </P>
     *
     * @param forUpdate
     * @return number of record query
     * @throws SQLException
     * @throws IOException
     */
    public ContractList queryAllContract(boolean forUpdate) throws SQLException, IOException {
        /* if limit < 0 or offset < 0 then select all */
        return this.contractManager.select(forUpdate, -1, -1);
    }
    
    /**
     * <P>
     * query all of Contract list from database
     * </P>
     *
     * @param forUpdate
     * @return number of record query
     * @throws SQLException
     * @throws IOException
     */
    public ContractList queryAllContractCertify(boolean forUpdate) throws SQLException, IOException {
        /* if limit < 0 or offset < 0 then select all */
        return this.contractManager.selectForContractCertify(forUpdate, -1, -1);
    }

    /**
     * <P>
     * Contract info by id from database
     * </P>
     *
     * @param forUpdate
     * @return number of record query
     * @throws SQLException
     * @throws IOException
     */
    public ContractInfo queryContractById(boolean forUpdate) throws SQLException, IOException {
        return this.contractManager.selectById(forUpdate);
    }
    
    /**
     * <P>
     * Contract info by id from database
     * </P>
     *
     * @param forUpdate
     * @return number of record query
     * @throws SQLException
     * @throws IOException
     */
    public ContractInfo queryContractByCancellationId(Long cancellationId, boolean forUpdate) throws SQLException, IOException {
        return this.contractManager.selectByCancellationId(cancellationId, forUpdate);
    }
    
    /**
     * <P>
     * query User Report list from database
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
    public ContractKindListForNotary queryUserReport(ContractKindListForNotary contractKindListForNotary, boolean forUpdate) throws SQLException, IOException {
        /* Calculate start position of page */
        return this.contractManager.selectUserReport(contractKindListForNotary, forUpdate);
    }
    
    /**
     * <P>
     * query User Report list from database
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
    public ContractKindListForNotary queryNotaryPlace(ContractKindListForNotary contractKindListForNotary, boolean forUpdate) throws SQLException, IOException {
        /* Calculate start position of page */
        return this.contractManager.selectNotaryPlace(contractKindListForNotary, forUpdate);
    }

    /**
     * <P>
     * count total Contract
     * </P>
     *
     * @param forUpdate
     * @return number of count record
     * @throws SQLException
     * @throws IOException
     */
    public int countTotalContract() throws SQLException, IOException {
        return this.contractManager.countTotal();
    }

    /**
     * Determine record is existed in database based on attributes
     *
     * @param contractNumber
     * @return TRUE if its was existed
     */
    public Boolean isExistContractNumber(String contractNumber) throws SQLException {
    	return this.contractManager.isExistContractNumber(contractNumber);
    }
    
    /**
     * <P>
     * entry RelationObjectInfo object to database
     * </P>
     *
     * @param info
     * @return number of record insert.
     * @throws SQLException
     */
    public int entryRelationObject(RelationObjectInfo info) throws SQLException {
        return this.relationObjectManager.insert(info);
    }

    /**
     * <P>
     * modify RelationObjectInfo object to database
     * </P>
     *
     * @param info
     * @return number of record update.
     * @throws SQLException
     * @throws IOException
     */
    public int modifyRelationObject(RelationObjectInfo info) throws SQLException, IOException {
        return this.relationObjectManager.update(info);
    }

    /**
     * <P>
     * remove RelationObject by id
     * </P>
     *
     * @param id
     * @return number of record update.
     * @throws SQLException
     */
    public int removeRelationObject(Long id) throws SQLException {
        return this.relationObjectManager.delete(id);
    }

    /**
     * <P>
     * query RelationObject list from database
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
    public RelationObjectList queryRelationObject(boolean forUpdate, int page, int maxLine) throws SQLException, IOException {
        /* Calculate start position of page */
        int offset = (page - 1) * maxLine;
        return this.relationObjectManager.select(forUpdate, offset, maxLine);
    }

    public List<String> selectSuggestRelationObjectA(String query, int page, int maxLine) throws SQLException, IOException {
        /* Calculate start position of page */
        int offset = (page - 1) * maxLine;
        return this.contractManager.selectSuggestRelationObjectA(query, offset, maxLine);
    }

    public List<String> selectSuggestRelationObjectB(String query, int page, int maxLine) throws SQLException, IOException {
        /* Calculate start position of page */
        int offset = (page - 1) * maxLine;
        return this.contractManager.selectSuggestRelationObjectB(query, offset, maxLine);
    }

    public List<String> selectSuggestRelationObjectC(String query, int page, int maxLine) throws SQLException, IOException {
        /* Calculate start position of page */
        int offset = (page - 1) * maxLine;
        return this.contractManager.selectSuggestRelationObjectC(query, offset, maxLine);
    }

    /**
     * <P>
     * query all of RelationObject list from database
     * </P>
     *
     * @param forUpdate
     * @return number of record query
     * @throws SQLException
     * @throws IOException
     */
    public RelationObjectList queryAllRelationObject(boolean forUpdate) throws SQLException, IOException {
        /* if limit < 0 or offset < 0 then select all */
        return this.relationObjectManager.select(forUpdate, -1, -1);
    }

    /**
     * <P>
     * count total RelationObject
     * </P>
     *
     * @param forUpdate
     * @return number of count record
     * @throws SQLException
     * @throws IOException
     */
    public int countTotalRelationObject() throws SQLException, IOException {
        return this.relationObjectManager.countTotal();
    }

    /**
     * <P>
     * entry ContractKindInfo object to database
     * </P>
     *
     * @param info
     * @return number of record insert.
     * @throws SQLException
     */
    public int entryContractKind(ContractKindInfo info) throws SQLException {
        return this.contractKindManager.insert(info);
    }

    /**
     * <P>
     * modify ContractKindInfo object to database
     * </P>
     *
     * @param info
     * @return number of record update.
     * @throws SQLException
     * @throws IOException
     */
    public int modifyContractKind(ContractKindInfo info) throws SQLException, IOException {
        return this.contractKindManager.update(info);
    }

    /**
     * <P>
     * remove ContractKind by id
     * </P>
     *
     * @param id
     * @return number of record update.
     * @throws SQLException
     */
    public int removeContractKind(Long id) throws SQLException {
        return this.contractKindManager.delete(id);
    }

    /**
     * <P>
     * query ContractKind list from database
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
    public ContractKindList queryContractKind(boolean forUpdate, int page, int maxLine) throws SQLException, IOException {
        /* Calculate start position of page */
        int offset = (page - 1) * maxLine;
        return this.contractKindManager.select(forUpdate, offset, maxLine);
    }

    /**
     * <P>
     * query all of ContractKind list from database
     * </P>
     *
     * @param forUpdate
     * @return number of record query
     * @throws SQLException
     * @throws IOException
     */
    public ContractKindList queryAllContractKind(boolean forUpdate) throws SQLException, IOException {
        /* if limit < 0 or offset < 0 then select all */
        return this.contractKindManager.select(forUpdate, -1, -1);
    }

    /**
     * <P>
     * count total ContractKind
     * </P>
     *
     * @param forUpdate
     * @return number of count record
     * @throws SQLException
     * @throws IOException
     */
    public int countTotalContractKind() throws SQLException, IOException {
        return this.contractKindManager.countTotal();
    }

    /**
     * <P>
     * entry ContractTemplateInfo object to database
     * </P>
     *
     * @param info
     * @return number of record insert.
     * @throws SQLException
     */
    public int entryContractTemplate(ContractTemplateInfo info) throws SQLException {
        return this.contractTemplateManager.insert(info);
    }

    /**
     * <P>
     * modify ContractTemplateInfo object to database
     * </P>
     *
     * @param info
     * @return number of record update.
     * @throws SQLException
     * @throws IOException
     */
    public int modifyContractTemplate(ContractTemplateInfo info) throws SQLException, IOException {
        return this.contractTemplateManager.update(info);
    }

    /**
     * <P>
     * remove ContractTemplate by id
     * </P>
     *
     * @param id
     * @return number of record update.
     * @throws SQLException
     */
    public int removeContractTemplate(Long id) throws SQLException {
        return this.contractTemplateManager.delete(id);
    }

    /**
     * <P>
     * query ContractTemplate list from database
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
    public ContractTemplateList queryContractTemplate(boolean forUpdate, int page, int maxLine) throws SQLException, IOException {
        /* Calculate start position of page */
        int offset = (page - 1) * maxLine;
        return this.contractTemplateManager.select(forUpdate, offset, maxLine);
    }

    /**
     * <P>
     * query all of ContractTemplate list from database
     * </P>
     *
     * @param forUpdate
     * @return number of record query
     * @throws SQLException
     * @throws IOException
     */
    public ContractTemplateList queryAllContractTemplate(boolean forUpdate) throws SQLException, IOException {
        /* if limit < 0 or offset < 0 then select all */
        return this.contractTemplateManager.select(forUpdate, -1, -1);
    }

    /**
     * <P>
     * count total ContractTemplate
     * </P>
     *
     * @param forUpdate
     * @return number of count record
     * @throws SQLException
     * @throws IOException
     */
    public int countTotalContractTemplate() throws SQLException, IOException {
        return this.contractTemplateManager.countTotal();
    }

    /**
     *
     * query all contract statistical
     *
     * @author Giangvt
     * @param forUpdate
     * @return
     * @throws SQLException
     * @throws IOException
     */
    public ContractStatisticalList queryAllContractStatistical(boolean forUpdate) throws SQLException, IOException {
        return this.contractStatisticalManager.selectTotalContract();
    }

    /**
    *
    * query all contract statistical for drafter
    *
    * @author Giangvt
    * @param forUpdate
    * @return
    * @throws SQLException
    * @throws IOException
    */
   public ContractStatisticalList queryAllContractStatisticalForDrafter(boolean forUpdate) throws SQLException, IOException {
       return this.contractStatisticalManager.selectTotalContractForDrafter();
   }

    /**
     *
     * get total record of ContractStatistical
     *
     * @author Giangvt
     * @return
     * @throws SQLException
     * @throws IOException
     */
    public int countTotalContractStatistical() throws SQLException, IOException {
        return this.contractStatisticalManager.countTotal();
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
    public int countTotalContractByFilter() throws SQLException, IOException {
        return this.contractManager.countTotalByFilter();
    }

    /**
     *
     * Update data of table npo_contract_statistical
     *
     * @author Giangvt
     * @throws SQLException
     */
    public void updateContractStatistical() throws SQLException, IOException {
        // get all user with role = 02
        String[] roleFilter = { "02" };
        userManager.setRoleFilter(roleFilter);
        UserList userList = userManager.select(false, -1, -1);

        for (int i = 0; i < userList.size(); i++) {
            UserInfo ui = userList.get(i);
            // statistic data of this user
            ContractStatisticalInfo statisticInfo = new ContractStatisticalInfo();
            statisticInfo.setNotaryId(ui.getId());
            this.contractManager.setNotaryIdFilter(ui.getId());
            this.contractManager.setNotaryDateFromFilter(null);
            this.contractManager.setNotaryDateToFilter(null);

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date now = Calendar.getInstance().getTime();
            String today = sdf.format(now);

            // statistic total
            long countTotal = (long) contractManager.countTotalByFilter();

            // statistic by day
            contractManager.setNotaryDateFromFilter(RelateDateTime.toTimestamp(true, today));
            contractManager.setNotaryDateToFilter(RelateDateTime.toTimestamp(false, today));
            long countInDay = (long) contractManager.countTotalByFilter();

            // statistic by week
            contractManager.setNotaryDateFromFilter(RelateDateTime.toTimestamp(true, RelateDateTime.getDateByFirstDayOfWeek(now)));
            contractManager.setNotaryDateToFilter(RelateDateTime.toTimestamp(false, RelateDateTime.getDateByLastDayOfWeek(now)));
            long countInWeek = (long) contractManager.countTotalByFilter();

            // statistic by month
            contractManager.setNotaryDateFromFilter(RelateDateTime.toTimestamp(true, RelateDateTime.getDateByFirstDayOfMonth(now)));
            contractManager.setNotaryDateToFilter(RelateDateTime.toTimestamp(false, RelateDateTime.getDateByLastDayOfMonth(now)));
            long countInMonth = (long) contractManager.countTotalByFilter();

            // statistic by year
            contractManager.setNotaryDateFromFilter(RelateDateTime.toTimestamp(true, RelateDateTime.getDateByFirstDayOfYear(now)));
            contractManager.setNotaryDateToFilter(RelateDateTime.toTimestamp(false, RelateDateTime.getDateByLastDayOfYear(now)));
            long countInYear = (long) contractManager.countTotalByFilter();

            ContractStatisticalManager contractStatisticalManager = new ContractStatisticalManager(getConnection());
            contractStatisticalManager.setNotaryId(ui.getId());

            statisticInfo.setCountInDay(countInDay);
            statisticInfo.setCountInWeek(countInWeek);
            statisticInfo.setCountInMonth(countInMonth);
            statisticInfo.setCountInYear(countInYear);
            statisticInfo.setCountTotal(countTotal);
            // insert or update data
            ContractStatisticalList list = contractStatisticalManager.select(false, -1, -1);
            if (list.size() > 0) {
                contractStatisticalManager.update(statisticInfo);
            } else {
                contractStatisticalManager.insert(statisticInfo);
            }
        }
    }

    /**
     * <P>
     * entry PropertyInfo object to database
     * </P>
     *
     * @param info
     * @return number of record insert.
     * @throws SQLException
     */
    public int entryProperty(PropertyInfo info) throws SQLException {
        return this.propertyManager.insert(info);
    }

    /**
     * <P>
     * modify PropertyInfo object to database
     * </P>
     *
     * @param info
     * @return number of record update.
     * @throws SQLException
     * @throws IOException
     */
    public int modifyProperty(PropertyInfo info) throws SQLException, IOException {
        return this.propertyManager.update(info);
    }

    /**
     * <P>
     * remove Property by id
     * </P>
     *
     * @param id
     * @return number of record update.
     * @throws SQLException
     */
    public int removeProperty(Long id) throws SQLException {
        return this.propertyManager.delete(id);
    }

    /**
     * <P>
     * query Property list from database
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
    public PropertyList queryProperty(boolean forUpdate, int page, int maxLine) throws SQLException, IOException {
        /* Calculate start position of page */
        int offset = (page - 1) * maxLine;
        return this.propertyManager.select(forUpdate, offset, maxLine);
    }

    /**
     * <P>
     * query all of Property list from database
     * </P>
     *
     * @param forUpdate
     * @return number of record query
     * @throws SQLException
     * @throws IOException
     */
    public PropertyList queryAllProperty(boolean forUpdate) throws SQLException, IOException {
        /* if limit < 0 or offset < 0 then select all */
        return this.propertyManager.select(forUpdate, -1, -1);
    }

    /**
     * <P>
     * query all of Property list by ContractId from database
     * </P>
     *
     * @param forUpdate
     * @return number of record query
     * @throws SQLException
     * @throws IOException
     */
    public PropertyList queryAllPropertyByContract(boolean forUpdate) throws SQLException, IOException {
        /* if limit < 0 or offset < 0 then select all */
        return this.propertyManager.selectByContract(forUpdate);
    }

    /**
     * <P>
     * count total Property
     * </P>
     *
     * @param forUpdate
     * @return number of count record
     * @throws SQLException
     * @throws IOException
     */
    public int countTotalProperty() throws SQLException, IOException {
        return this.propertyManager.countTotal();
    }

    /**
     * <P>
     * entry ContractPropertyInfo object to database
     * </P>
     *
     * @param info
     * @return number of record insert.
     * @throws SQLException
     */
    public int entryContractProperty(ContractPropertyInfo info) throws SQLException {
        return this.contractPropertyManager.insert(info);
    }

    /**
     * <P>
     * modify ContractPropertyInfo object to database
     * </P>
     *
     * @param info
     * @return number of record update.
     * @throws SQLException
     * @throws IOException
     */
    public int modifyContractProperty(ContractPropertyInfo info) throws SQLException, IOException {
        return this.contractPropertyManager.update(info);
    }

    /**
     * <P>
     * remove ContractProperty by id
     * </P>
     *
     * @param id
     * @return number of record update.
     * @throws SQLException
     */
    public int removeContractProperty(Long contractId) throws SQLException {
        return this.contractPropertyManager.delete(contractId);
    }

    /**
     * <P>
     * query ContractProperty list from database
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
    public ContractPropertyList queryContractProperty(boolean forUpdate, int page, int maxLine) throws SQLException, IOException {
        /* Calculate start position of page */
        int offset = (page - 1) * maxLine;
        return this.contractPropertyManager.select(forUpdate, offset, maxLine);
    }

    /**
     * <P>
     * query all of ContractProperty list from database
     * </P>
     *
     * @param forUpdate
     * @return number of record query
     * @throws SQLException
     * @throws IOException
     */
    public ContractPropertyList queryAllContractProperty(boolean forUpdate) throws SQLException, IOException {
        /* if limit < 0 or offset < 0 then select all */
        return this.contractPropertyManager.select(forUpdate, -1, -1);
    }

    /**
     * <P>
     * count total ContractProperty
     * </P>
     *
     * @param forUpdate
     * @return number of count record
     * @throws SQLException
     * @throws IOException
     */
    public int countTotalContractProperty() throws SQLException, IOException {
        return this.contractPropertyManager.countTotal();
    }

    /**
     * Set contract Id Filter
     *
     * @param contractIdFilter
     */
    public void setContractIdFilter(Long contractIdFilter) {

        this.contractManager.setContractIdFilter(contractIdFilter);
    }

    /**
     * Set contract Number Filter
     *
     * @param contractNumberFilter
     * @param kind
     *            Filter kind (FULL, LEFT, MIDDLE)
     */
    public void setContractNumberFilter(String contractNumberFilter, FilterKind kind) {

        this.contractManager.setContractNumberFilter(contractNumberFilter, kind);
    }

    /**
     * Set contract Template Id Filter
     *
     * @param contractTemplateIdFilter
     */
    public void setContractTemplateIdFilter(Long contractTemplateIdFilter) {

        this.contractManager.setContractTemplateIdFilter(contractTemplateIdFilter);
    }

    /**
     * Set contract Template Id Filter
     *
     * @param contractTemplateIdFilter
     */
    public void setContractTemplateId(Long contractTemplateIdFilter) {
        this.contractTemplateManager.setId(contractTemplateIdFilter);
    }

    /**
     * Set relation ObjectA Filter
     *
     * @param relationObjectAFilter
     * @param kind
     *            Filter kind (FULL, LEFT, MIDDLE)
     */
    public void setRelationObjectAFilter(String relationObjectAFilter, FilterKind kind) {

        this.contractManager.setRelationObjectAFilter(relationObjectAFilter, kind);
    }

    /**
     * Set relation ObjectB Filter
     *
     * @param relationObjectBFilter
     * @param kind
     *            Filter kind (FULL, LEFT, MIDDLE)
     */
    public void setRelationObjectBFilter(String relationObjectBFilter, FilterKind kind) {

        this.contractManager.setRelationObjectBFilter(relationObjectBFilter, kind);
    }

    /**
     * Set relation ObjectC Filter
     *
     * @param relationObjectCFilter
     * @param kind
     *            Filter kind (FULL, LEFT, MIDDLE)
     */
    public void setRelationObjectCFilter(String relationObjectCFilter, FilterKind kind) {

        this.contractManager.setRelationObjectCFilter(relationObjectCFilter, kind);
    }

    /**
     * Set notary Date Filter
     *
     * @param notaryDateFilter
     */
    public void setNotaryDateFilter(Timestamp notaryDateFilter) {

        this.contractManager.setNotaryDateFilter(notaryDateFilter);
    }

    /**
     * Set notary DateFrom Filter
     *
     * @param notaryDateFromFilter
     */
    public void setNotaryDateFromFilter(Timestamp notaryDateFromFilter) {

        this.contractManager.setNotaryDateFromFilter(notaryDateFromFilter);
    }

    /**
     * Set notary DateTo Filter
     *
     * @param notaryDateToFilter
     */
    public void setNotaryDateToFilter(Timestamp notaryDateToFilter) {

        this.contractManager.setNotaryDateToFilter(notaryDateToFilter);
    }

    /**
     * Set bank Id Filter
     *
     * @param bankIdFilter
     */
    public void setBankIdFilter(Long bankIdFilter) {

        this.contractManager.setBankIdFilter(bankIdFilter);
    }

    /**
     * Set bank Id Filter
     *
     * @param bankIdFilter
     */
    public void setBankIdNullFilter(Boolean isBankIdNullFilter) {

        this.contractManager.setIsBankIdNullFilter(isBankIdNullFilter);
    }

    /**
     * Set notary Place Filter
     *
     * @param notaryPlaceFilter
     */
    public void setNotaryPlaceFilter(Boolean notaryPlaceFilter) {

        this.contractManager.setNotaryPlaceFilter(notaryPlaceFilter);
    }

    /**
     * Set notary Id Filter
     *
     * @param notaryIdFilter
     */
    public void setNotaryIdFilter(Long notaryIdFilter) {

        this.contractManager.setNotaryIdFilter(notaryIdFilter);
    }

    /**
     * Set drafter Id Filter
     *
     * @param drafterIdFilter
     */
    public void setDrafterIdFilter(Long drafterIdFilter) {

        this.contractManager.setDrafterIdFilter(drafterIdFilter);
    }
    
    /**
     * Set drafter Id Flag Filter
     *
     * @param drafterIdFilter
     */
    public void setDrafterIdFlagFilter(Boolean drafterIdFlagFilter) {

        this.contractManager.setDrafterIdFlagFilter(drafterIdFlagFilter);
    }

    /**
     * Set notary Id filter
     *
     * @param selectedUserIds
     */
    public void setNotaryUserIdListFilter(String[] selectedUserIds) {
        this.contractManager.setNotaryUserIdListFilter(selectedUserIds);
    }

    /**
     * Set list bank Id filter
     *
     * @param selectedBankIds
     */
    public void setBanksIdFilter(String[] selectedBankIds) {
        this.contractManager.setBanksIdFilter(selectedBankIds);
    }

    /**
     * Set error Status Filter
     *
     * @param errorStatusFilter
     */
    public void setErrorStatusFilter(Boolean errorStatusFilter) {

        this.contractManager.setErrorStatusFilter(errorStatusFilter);
    }

    /**
     * Set Notary User Id List Filter
     *
     * @param selectedUserIds
     */
    public void setDraftUserIdListFilter(String[] selectedUserIds) {
        this.contractManager.setDraftUserIdListFilter(selectedUserIds);
    }

    /**
     * Set Contract Template Name Filter
     *
     * @param name
     */
    public void setContractTemplateNameFilter(String name) {
        this.contractTemplateManager.setNameFilter(name);
    }

    /**
     * Set Contract Template KindId Filter
     *
     * @param kindId
     */
    public void setContractTemplateKindIdFilter(Long kindId) {
        this.contractTemplateManager.setContractKindFilter(kindId);
    }

    /**
     * Set Contract Template ActiveFlg Filter
     *
     * @param activeFlg
     */
    public void setContractTemplateActiveFlgFilter(Boolean activeFlg) {
        this.contractTemplateManager.setActiveFlgFilter(activeFlg);
        this.contractManager.setContractTemplateActiveFlgFilter(activeFlg);
    }

    /**
     * Filter Contract Property By Property Id
     *
     * @param propertyIdFilter
     */
    public void setContractPropertyByPropertyIdFilter(Long propertyIdFilter) {
        this.contractPropertyManager.setPropertyIdFilter(propertyIdFilter);
    }

    /**
     * Add order field for table npo_contract_template
     *
     * @param orderField
     */
    public void addOrderFieldContractTemplate(OrderField orderField) {
        this.contractTemplateManager.addOrderField(orderField);
    }

    /**
     * Determine record is existed in database based on attributes
     *
     * @param entity
     * @param nameKeyAndValueKey
     * @return TRUE if its was existed
     */
    public Boolean isExistContractInDB(String entity, Object[][] nameKeyAndValueKey) throws SQLException, IOException {
        return contractManager.isExistInDB(entity, nameKeyAndValueKey);
    }

    /**
     * Determine record is existed in database based on attributes
     *
     * @param entity
     * @param nameKeyAndValueKey
     * @return TRUE if its was existed
     */
    public Boolean isExistContractTemplateInDB(String entity, Object[][] nameKeyAndValueKey) throws SQLException, IOException {
        return contractTemplateManager.isExistInDB(entity, nameKeyAndValueKey);
    }

    public void addContractOrderField(OrderField orderField) {
        this.contractManager.addOrderField(orderField);
    }

    public void addContractPropertyOrderField(OrderField orderField) {
        this.contractPropertyManager.addOrderField(orderField);
    }

    public void addPropertyOrderField(OrderField orderField) {
        this.propertyManager.addOrderField(orderField);
    }

    /**
     * Set Relation Object Id Filter
     *
     * @param relationObjectIdFilter
     */
    public void setRelationObjectIdFilter(Long relationObjectIdFilter) {

        this.relationObjectManager.setIdFilter(relationObjectIdFilter);
    }

    /**
     * Set the propertyIdFilter
     *
     * @param propertyIdFilter the propertyIdFilter to set
     */
    public void setPropertyIdFilter(Long propertyIdFilter) {
        this.propertyManager.setIdFilter(propertyIdFilter);
    }

    /**
     * Set the contractIdFilter
     *
     * @param contractIdFilter the contractIdFilter to set
     */
    public void setContractPropertyIdFilter(Long contractIdFilter) {
        this.contractPropertyManager.setContractIdFilter(contractIdFilter);
    }

    /**
     * <P>
     * count total Property by filter
     * </P>
     *
     * @param forUpdate
     * @return number of count record
     * @throws SQLException
     * @throws IOException
     */
//    public int countTotalPropertyByFilter() throws SQLException, IOException {
//        return this.propertyManager.countTotalByFilter();
//    }
//
//    public int countTotalAllPropertyByFilter() throws SQLException, IOException {
//        return this.propertyManager.countTotalAllByFilter();
//    }

    /**
     * Set the kindIdFilter
     *
     * @param kindIdFilter the kindIdFilter to set
     */
    public void setKindIdFilter(Long kindIdFilter) {
        this.contractTemplateManager.setKindIdFilter(kindIdFilter);
    }

    /**
     * Set the contractKindIdFilter
     *
     * @param contractKindIdFilter the contractKindIdFilter to set
     */
    public void setContractKindIdFilter(Long contractKindIdFilter) {
        this.contractManager.setContractKindIdFilter(contractKindIdFilter);
    }
    
    /**
     * Set contract Id Filter
     *
     * @param contractIdFilter
     */
    public void setContractKindIdArrayFilter(Long[] contractIdFilter) {

        this.contractManager.setContractKindIdArrayFilter(contractIdFilter);
    }

    /**
     * Set relation Object Filter
     *
     * @param relationObjectFilter
     * @param kind Filter kind (FULL, LEFT, MIDDLE)
     */
    public void setRelationObjectFilter(String relationObjectFilter, FilterKind kind) {

        this.contractManager.setRelationObjectFilter(relationObjectFilter, kind);
    }

    /**
     * Set the contractIdFilter for get Property
     *
     * @param contractIdFilter the contractIdFilter to set
     */
    public void setContractIdPropertyFilter(Long contractIdFilter) {
        this.propertyManager.setContractIdFilter(contractIdFilter);
    }

    /**
     * Set contract Summary Filter
     *
     * @param contractSummaryFilter
     * @param kind  Filter kind (FULL, LEFT, MIDDLE)
     */
    public void setContractSummaryFilter(String contractSummaryFilter, FilterKind kind) {

        this.contractManager.setContractSummaryFilter(contractSummaryFilter, kind);
    }

    /**
     * Set the additionStatusFilter
     *
     * @param additionStatusFilter the additionStatusFilter to set
     */
    public void setAdditionStatusFilter(Boolean additionStatusFilter) {
        this.contractManager.setAdditionStatusFilter(additionStatusFilter);
    }

    /**
     * Set the cancellationStatusFilter
     *
     * @param cancellationStatusFilter the cancellationStatusFilter to set
     */
    public void setCancellationStatusFilter(Boolean cancellationStatusFilter) {
        this.contractManager.setCancellationStatusFilter(cancellationStatusFilter);
    }

    /**
     *
     * Set filter to get contract kind table
     *
     * @author GiangVT
     * @param contractKindIdFilter
     */
    public void setNpoContractKindIdFilter(Long contractKindIdFilter) {
        this.contractKindManager.setIdFilter(contractKindIdFilter);
    }

    /**
     *
     * Set filter to get contract template table
     *
     * @author GiangVT
     * @param contractTemplateIdFilter
     */
    public void setNpoContractTemplateIdFilter(Long contractTemplateIdFilter) {
        this.contractTemplateManager.setId(contractTemplateIdFilter);
    }

    /**
     * Set the keySearchFilter
     *
     * @param keySearchFilter the keySearchFilter to set
     */
    public void setKeySearchContractFilter(String keySearchFilter) {
        this.contractManager.setKeySearchFilter(keySearchFilter);
    }

    /**
     * Set the subKeys
     *
     * @param subKeys the subKeys to set
     */
    public void setSubKeys(List<String> subKeys) {
        this.contractManager.setSubKeys(subKeys);
    }

    /**
     * Set the typeFilter
     *
     * @param typeFilter the typeFilter to set
     */
    public void setTypeFilter(String typeFilter) {
        this.propertyManager.setTypeFilter(typeFilter);
    }


    /**
     * Set the propertyInfoFilter
     *
     * @param propertyInfoFilter the propertyInfoFilter to set
     * @param kind Filter kind (FULL, LEFT, MIDDLE)
     */
    public void setPropertyInfoFilter(String propertyInfoFilter, FilterKind kind) {
        this.propertyManager.setPropertyInfoFilter(propertyInfoFilter, kind);
    }


    /**
     * Set the landCertificateFilter
     *
     * @param landCertificateFilter the landCertificateFilter to set
     * @param kind Filter kind (FULL, LEFT, MIDDLE)
     */
    public void setLandCertificateFilter(String landCertificateFilter, FilterKind kind) {
        this.propertyManager.setLandCertificateFilter(landCertificateFilter, kind);
    }


    /**
     * Set the landMapNumberFilter
     *
     * @param landMapNumberFilter the landMapNumberFilter to set
     * @param kind Filter kind (FULL, LEFT, MIDDLE)
     */
    public void setLandMapNumberFilter(String landMapNumberFilter, FilterKind kind) {
        this.propertyManager.setLandMapNumberFilter(landMapNumberFilter, kind);
    }


    /**
     * Set the landNumberFilter
     *
     * @param landNumberFilter the landNumberFilter to set
     * @param kind Filter kind (FULL, LEFT, MIDDLE)
     */
    public void setLandNumberFilter(String landNumberFilter, FilterKind kind) {
        this.propertyManager.setLandNumberFilter(landNumberFilter, kind);
    }


    /**
     * Set the landAddressFilter
     *
     * @param landAddressFilter the landAddressFilter to set
     * @param kind Filter kind (FULL, LEFT, MIDDLE)
     */
    public void setLandAddressFilter(String landAddressFilter, FilterKind kind) {
        this.propertyManager.setLandAddressFilter(landAddressFilter, kind);
    }


    /**
     * Set the carLicenseNumberFilter
     *
     * @param carLicenseNumberFilter the carLicenseNumberFilter to set
     * @param kind Filter kind (FULL, LEFT, MIDDLE)
     */
    public void setCarLicenseNumberFilter(String carLicenseNumberFilter, FilterKind kind) {
        this.propertyManager.setCarLicenseNumberFilter(carLicenseNumberFilter, kind);
    }


    /**
     * Set the carRegistNumberFilter
     *
     * @param carRegistNumberFilter the carRegistNumberFilter to set
     * @param kind Filter kind (FULL, LEFT, MIDDLE)
     */
    public void setCarRegistNumberFilter(String carRegistNumberFilter, FilterKind kind) {
        this.propertyManager.setCarRegistNumberFilter(carRegistNumberFilter, kind);
    }


    /**
     * Set the carFrameNumberFilter
     *
     * @param carFrameNumberFilter the carFrameNumberFilter to set
     * @param kind Filter kind (FULL, LEFT, MIDDLE)
     */
    public void setCarFrameNumberFilter(String carFrameNumberFilter, FilterKind kind) {
        this.propertyManager.setCarFrameNumberFilter(carFrameNumberFilter, kind);
    }


    /**
     * Set the carMachineNumberFilter
     *
     * @param carMachineNumberFilter the carMachineNumberFilter to set
     * @param kind Filter kind (FULL, LEFT, MIDDLE)
     */
    public void setCarMachineNumberFilter(String carMachineNumberFilter, FilterKind kind) {
        this.propertyManager.setCarMachineNumberFilter(carMachineNumberFilter, kind);
    }


    /**
     * Set the typeKeySearchFilter
     *
     * @param typeKeySearchFilter the typeKeySearchFilter to set
     */
    public void setTypeKeySearchFilter(String typeKeySearchFilter) {
        this.propertyManager.setTypeKeySearchFilter(typeKeySearchFilter);
    }


    /**
     * Set the keySearchFilter
     *
     * @param keySearchFilter the keySearchFilter to set
     */
    public void setKeySearchFilter(String keySearchFilter) {
        this.propertyManager.setKeySearchFilter(keySearchFilter);
    }

    /**
     * Set the subKeys
     *
     * @param subKeys the subKeys to set
     */
    public void setSubKeysProperty(List<String> subKeys) {
        this.propertyManager.setSubKeys(subKeys);
    }

    /**
     * Set the propertyInfoFilter
     *
     * @param propertyInfoFilter the propertyInfoFilter to set
     */
    public void setPropertyInfoForContractFilter(String propertyInfoFilter, FilterKind kind) {
        this.contractManager.setPropertyInfoFilter(propertyInfoFilter, kind);
    }

    /**
     * Set the orderKeySearch
     *
     * @param orderKeySearch the orderKeySearch to set
     */
    public void setOrderKeySearch(Boolean orderKeySearch) {
        this.contractManager.setOrderKeySearch(orderKeySearch);
    }
    /**
     * get the appendix list
     * 
     * @param orderKeySearch
     * @throws IOException 
     * @throws SQLException 
     */
    public ContractList queryAppendixContract(Boolean forUpdate) throws SQLException, IOException {
        return this.contractManager.selectAppendixContract(forUpdate);
    }
    
    /**
     * Set the orderKeySearch
     *
     * @param orderKeySearch the orderKeySearch to set
     */
    public String entryHistory(ContractInfo contractInfo) {
    	
        String contractContent="";
        if(!EditString.isNull(contractInfo.getContractKindName()))
        	contractContent += Constants.BULLET + Constants.SPACE + SystemMessageProperties.getSystemProperty("item_contract_kind") + Constants.SPACE + Constants.COLON + Constants.SPACE + contractInfo.getContractKindName() + Constants.ENTER;
        if(!EditString.isNull(contractInfo.getContractTemplateName()))
        	contractContent += Constants.BULLET + Constants.SPACE + SystemMessageProperties.getSystemProperty("item_contract_template") + Constants.SPACE + Constants.COLON + Constants.SPACE + contractInfo.getContractTemplateName() + Constants.ENTER;
        if(!EditString.isNull(contractInfo.getContractNumber()))
        	contractContent += Constants.BULLET + Constants.SPACE + SystemMessageProperties.getSystemProperty("item_number_contract") + Constants.SPACE + Constants.COLON + Constants.SPACE + contractInfo.getContractNumber() + Constants.ENTER;
        if(contractInfo.getReceivedDate() != null)
        	contractContent += Constants.BULLET + Constants.SPACE + SystemMessageProperties.getSystemProperty("item_received_date") + Constants.SPACE + Constants.COLON + Constants.SPACE + RelateDateTime.toDayMonthYear(contractInfo.getReceivedDate()) + Constants.ENTER;
        if(contractInfo.getNotaryDate() != null)
        	contractContent += Constants.BULLET + Constants.SPACE + SystemMessageProperties.getSystemProperty("item_notary_date") + Constants.SPACE + Constants.COLON + Constants.SPACE + RelateDateTime.toDayMonthYear(contractInfo.getNotaryDate()) + Constants.ENTER;
        if(!EditString.isNull(contractInfo.getRelationObjectA()))
        	contractContent += Constants.BULLET + Constants.SPACE + SystemMessageProperties.getSystemProperty("item_relation_objectA") + Constants.SPACE + Constants.COLON + Constants.SPACE + contractInfo.getRelationObjectA() + Constants.ENTER;
        if(!EditString.isNull(contractInfo.getRelationObjectB()))
        	contractContent += Constants.BULLET + Constants.SPACE + SystemMessageProperties.getSystemProperty("item_relation_objectB") + Constants.SPACE + Constants.COLON + Constants.SPACE + contractInfo.getRelationObjectB() + Constants.ENTER;
        if(!EditString.isNull(contractInfo.getRelationObjectC()))
        	contractContent += Constants.BULLET + Constants.SPACE + SystemMessageProperties.getSystemProperty("item_relation_objectC") + Constants.SPACE + Constants.COLON + Constants.SPACE + contractInfo.getRelationObjectC() + Constants.ENTER;
        if(!EditString.isNull(contractInfo.getContractSummary()))
        	contractContent += Constants.BULLET + Constants.SPACE + SystemMessageProperties.getSystemProperty("item_contract_sumary") + Constants.SPACE + Constants.COLON + Constants.SPACE + contractInfo.getContractSummary() + Constants.ENTER;
        if(!EditString.isNull(contractInfo.getContractValue()))
        	contractContent += Constants.BULLET + Constants.SPACE + SystemMessageProperties.getSystemProperty("item_contract_value") + Constants.SPACE + Constants.COLON + Constants.SPACE + contractInfo.getContractValue() + Constants.ENTER;
        if(!EditString.isNull(contractInfo.getNotaryPlace()))
        	contractContent += Constants.BULLET + Constants.SPACE + SystemMessageProperties.getSystemProperty("item_notary_place") + Constants.SPACE + Constants.COLON + Constants.SPACE + contractInfo.getNotaryPlace() + Constants.ENTER;
        if (!EditString.isNull(contractInfo.getPropertyInfo())) {
	        if (contractInfo.getPropertyType()=="01"){
	        contractContent += Constants.BULLET + Constants.SPACE + SystemMessageProperties.getSystemProperty("item_property_type") + Constants.SPACE + Constants.COLON + Constants.SPACE + SystemMessageProperties.getSystemProperty("item_land") + Constants.ENTER;
	        } else if (contractInfo.getPropertyType()=="02"){
	            contractContent += Constants.BULLET + Constants.SPACE + SystemMessageProperties.getSystemProperty("item_property_type") + Constants.SPACE + Constants.COLON + Constants.SPACE + SystemMessageProperties.getSystemProperty("item_vehicle") + Constants.ENTER;
	        } else contractContent += Constants.BULLET + Constants.SPACE + SystemMessageProperties.getSystemProperty("item_property_type") + Constants.SPACE + Constants.COLON + Constants.SPACE + SystemMessageProperties.getSystemProperty("item_other") + Constants.ENTER;
	
	        	
	        contractContent += Constants.BULLET + Constants.SPACE + SystemMessageProperties.getSystemProperty("item_property_contract") + Constants.SPACE + Constants.COLON + Constants.SPACE + contractInfo.getPropertyInfo() + Constants.ENTER;
        }
        
        if (!EditString.isNull(contractInfo.getContractPeriod())) {
        	contractContent += Constants.BULLET + Constants.SPACE + SystemMessageProperties.getSystemProperty("item_contract_period") + Constants.SPACE + Constants.COLON + Constants.SPACE + contractInfo.getContractPeriod() + Constants.ENTER;
        }
        
        if (contractInfo.getMortageCancelFlag() != null && contractInfo.getMortageCancelFlag()) {
			contractContent += Constants.BULLET + Constants.SPACE + SystemMessageProperties.getSystemProperty("item_mortage_cancel")
			        + Constants.SPACE + Constants.COLON + Constants.SPACE + contractInfo.getMortageCancelDateDisp()  + " "
			        + contractInfo.getMortageCancelNote() + Constants.ENTER;
        }
          
        if (contractInfo.getAdditionStatus() != null && contractInfo.getAdditionStatus()) {
        	contractContent += Constants.BULLET + Constants.SPACE + SystemMessageProperties.getSystemProperty("item_addition_contrat") + Constants.SPACE + Constants.COLON + Constants.SPACE + contractInfo.getAdditionDescription() + Constants.ENTER;
        }
        if (contractInfo.getCancelStatus() != null && contractInfo.getCancelStatus()) {
        	contractContent += Constants.BULLET + Constants.SPACE + SystemMessageProperties.getSystemProperty("item_cancel_contract") + Constants.SPACE + Constants.COLON + Constants.SPACE + contractInfo.getCancelDescription() + Constants.ENTER;
        }
        if (contractInfo.getErrorStatus() != null && contractInfo.getErrorStatus()) {
        	contractContent += Constants.BULLET + Constants.SPACE + SystemMessageProperties.getSystemProperty("item_error_description") + Constants.SPACE + Constants.COLON + Constants.SPACE + contractInfo.getErrorDescription() + Constants.ENTER;	
        }
        if (contractInfo.getBankId()!=null)
        {
	        contractContent += Constants.BULLET + Constants.SPACE + SystemMessageProperties.getSystemProperty("item_bank") + Constants.SPACE + Constants.COLON + Constants.SPACE + contractInfo.getBankName() + Constants.ENTER;
	        contractContent += Constants.BULLET + Constants.SPACE + SystemMessageProperties.getSystemProperty("item_crediter_name") + Constants.SPACE + Constants.COLON + Constants.SPACE + contractInfo.getCrediterName() + Constants.ENTER;
	        contractContent += Constants.BULLET + Constants.SPACE + SystemMessageProperties.getSystemProperty("item_bank_service_fee") + Constants.SPACE + Constants.COLON + Constants.SPACE + contractInfo.getBankServiceFee() + Constants.ENTER;
        }
        if(!EditString.isNull(contractInfo.getCostTt91()))
        	contractContent += Constants.BULLET + Constants.SPACE + SystemMessageProperties.getSystemProperty("item_cost_tt91") + Constants.SPACE + Constants.COLON + Constants.SPACE + contractInfo.getCostTt91() + Constants.ENTER;
        if(!EditString.isNull(contractInfo.getCostDraft()))
        	contractContent += Constants.BULLET + Constants.SPACE + SystemMessageProperties.getSystemProperty("item_cost_draft") + Constants.SPACE + Constants.COLON + Constants.SPACE + contractInfo.getCostDraft() + Constants.ENTER;
        if(!EditString.isNull(contractInfo.getCostNotaryOutsite()))
        	contractContent += Constants.BULLET + Constants.SPACE + SystemMessageProperties.getSystemProperty("item_cost_notary_outsite") + Constants.SPACE + Constants.COLON + Constants.SPACE + contractInfo.getCostNotaryOutsite() + Constants.ENTER;
        if(!EditString.isNull(contractInfo.getCostOtherDetermine()))
        	contractContent += Constants.BULLET + Constants.SPACE + SystemMessageProperties.getSystemProperty("item_cost_other_determine") + Constants.SPACE + Constants.COLON + Constants.SPACE + contractInfo.getCostOtherDetermine() + Constants.ENTER;
        if(!EditString.isNull(contractInfo.getNumberOfPage()))
        	contractContent += Constants.BULLET + Constants.SPACE + SystemMessageProperties.getSystemProperty("item_contract_number_of_page") + Constants.SPACE + Constants.COLON + Constants.SPACE + contractInfo.getNumberOfPage() + Constants.ENTER;
        if(!EditString.isNull(contractInfo.getNumberCopyOfContract()))
        	contractContent += Constants.BULLET + Constants.SPACE + SystemMessageProperties.getSystemProperty("item_contract_number_of_copy") + Constants.SPACE + Constants.COLON + Constants.SPACE + contractInfo.getNumberCopyOfContract() + Constants.ENTER;
        if(!EditString.isNull(contractInfo.getOriginalStorePlace()))
        	contractContent += Constants.BULLET + Constants.SPACE + SystemMessageProperties.getSystemProperty("item_original_store_place") + Constants.SPACE + Constants.COLON + Constants.SPACE + contractInfo.getOriginalStorePlace() + Constants.ENTER;
        if(!EditString.isNull(contractInfo.getNote()))
        	contractContent += Constants.BULLET + Constants.SPACE + SystemMessageProperties.getSystemProperty("item_note") + Constants.SPACE + Constants.COLON + Constants.SPACE + contractInfo.getNote();
        
        return contractContent;
    }
    
    /**
     * Query contract template by id
     * 
     * @param id
     * @param forUpdate
     * @return
     * @throws SQLException
     */
    public ContractTemplateInfo queryContractTemplateInfoById(Long id, boolean forUpdate) throws SQLException {
    	return this.contractTemplateManager.selectById(id, forUpdate);
    }
    
    /**
     * Query contract kind tt08 by id
     * 
     * @param id
     * @param forUpdate
     * @return
     * @throws SQLException
     * @throws IOException 
     */
    public ContractKindInfo queryContractKindTT08ById(Long id, boolean forUpdate) throws SQLException, IOException {
    	return this.contractKindManager.selectByIdTT08(id, forUpdate);
    }
    
    /**
     * Query contract template by id
     * 
     * @param id
     * @param forUpdate
     * @return
     * @throws SQLException
     * @throws IOException 
     */
    public UserInfo queryUserInfoById(Long usid, boolean forUpdate) throws SQLException, IOException {
    	UserManager manager = new UserManager(getConnection());
    	manager.setUsidFilter(usid);
    	
    	UserList list = manager.select(forUpdate, -1, -1);
    	if (list.size() > 0) {
    		return list.get(0);
    	} else {
    		return null;
    	}
    }
}
