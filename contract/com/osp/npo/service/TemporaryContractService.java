package com.osp.npo.service;


import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


import com.osp.npo.common.global.Constants.FilterKind;
import com.osp.npo.core.OrderField;
import com.osp.npo.core.OrderField.OrderType;
import com.osp.npo.core.contract.ContractKindInfo;
import com.osp.npo.core.contract.ContractKindManager;
import com.osp.npo.core.contract.ContractKindTreeNode;
import com.osp.npo.core.contract.ContractTemplateInfo;
import com.osp.npo.core.contract.ContractTemplateList;
import com.osp.npo.core.contract.ContractTemplateManager;
import com.osp.npo.core.contract.ContractKindTreeNode.DivStyle;
import com.osp.npo.core.temporaryContract.TemporaryContractManager;
import com.osp.npo.core.temporaryContract.TemporaryContractInfo;
import com.osp.npo.core.temporaryContract.TemporaryContractList;
import com.osp.npo.core.temporaryContract.ContractCommentManager;
import com.osp.npo.core.temporaryContract.ContractCommentInfo;
import com.osp.npo.core.temporaryContract.ContractCommentList;


/**
 * Generate by script
 * Generate date: 05/05/2011 8:59:25 AM
 * @version $Revision: 25477 $ 
 */
public class TemporaryContractService extends AbstractService {


    /** TemporaryContract Manager Object */
    private TemporaryContractManager temporaryContractManager;


    /** ContractComment Manager Object */
    private ContractCommentManager contractCommentManager;
    
    
    /** ContractTemplateManager Manager Object */
    private ContractTemplateManager contractTemplateManager;




    /** <P> Service constructor </P>*/
    public TemporaryContractService(Connection connection) {
        super(connection);
        this.temporaryContractManager = new TemporaryContractManager (connection);
        this.contractCommentManager = new ContractCommentManager (connection);
        this.contractTemplateManager = new ContractTemplateManager(connection);
    }


    /**
     * <P> entry TemporaryContractInfo object to database </P>
     *
     * @param info
     * @return number of record insert.
     * @throws SQLException
     */
    public int entryTemporaryContract(TemporaryContractInfo info) throws SQLException{
        return this.temporaryContractManager.insert(info);
    }


    /**
     * <P> modify TemporaryContractInfo object to database </P>
     *
     * @param info
     * @return number of record update.
     * @throws SQLException
     * @throws IOException
     */
    public int modifyTemporaryContract(TemporaryContractInfo info) throws SQLException, IOException{
        return this.temporaryContractManager.update(info);
    }


    /**
     * <P> remove TemporaryContract by id</P>
     *
     * @param id
     * @return number of record update.
     * @throws SQLException
     */
    public int removeTemporaryContract(Long id) throws SQLException{
        return this.temporaryContractManager.delete(id);
    }

    public void addOrderFieldContractTemplate(OrderField orderField) {
        this.contractTemplateManager.addOrderField(orderField);
    }
    public void addContractOrderField(OrderField orderField) {
        this.temporaryContractManager.addOrderField(orderField);
    }
    /**
     * <P> query TemporaryContract list from database </P>
     *
     * @param forUpdate
     * @param  page current page
     * @param  maxLine maximum line of a page
     * @return number of record query
     * @throws SQLException
     * @throws IOException
    */
    public TemporaryContractList queryTemporaryContract(boolean forUpdate, int page, int maxLine)
            throws SQLException, IOException{
        /* Calculate start position of page */
        int offset = (page - 1) * maxLine;
        return this.temporaryContractManager.select(forUpdate, offset, maxLine);
    }
    public ContractTemplateList queryAllContractTemplate(boolean forUpdate) throws SQLException, IOException {
        /* if limit < 0 or offset < 0 then select all */
        return this.contractTemplateManager.select(forUpdate, -1, -1);
    }
    
    /**
     * <P>Get record by ID</P>
     * 
     * @param tcid Temporary contract ID
     * @param  forUpdate  Use FOR UPDATE (Yes or No)
     * @return  List of info that geted
     * @throws SQLException
     */
    public TemporaryContractInfo queryTemporaryContractByTcid(Long tcid, boolean forUpdate) throws SQLException {
    	return this.temporaryContractManager.selectByTcid(tcid, forUpdate);
    }


    /**
     * <P> query all of TemporaryContract list from database </P>
     *
     * @param forUpdate
     * @return number of record query
     * @throws SQLException
     * @throws IOException
    */
    public TemporaryContractList queryAllTemporaryContract(boolean forUpdate)
            throws SQLException, IOException{
        /* if limit < 0 or offset < 0 then select all */
        return this.temporaryContractManager.select(forUpdate, -1, -1);
    }


    /**
     * <P> count total TemporaryContract </P>
     *
     * @param forUpdate
     * @return number of count record
     * @throws SQLException
     * @throws IOException
    */
    public int countTotalTemporaryContract()
            throws SQLException, IOException{
        return this.temporaryContractManager.countTotal();
    }


    /**
     * <P> entry ContractCommentInfo object to database </P>
     *
     * @param info
     * @return number of record insert.
     * @throws SQLException
     */
    public int entryContractComment(ContractCommentInfo info) throws SQLException{
        return this.contractCommentManager.insert(info);
    }


    /**
     * <P> modify ContractCommentInfo object to database </P>
     *
     * @param info
     * @return number of record update.
     * @throws SQLException
     * @throws IOException
     */
    public int modifyContractComment(ContractCommentInfo info) throws SQLException, IOException{
        return this.contractCommentManager.update(info);
    }


    /**
     * <P> remove ContractComment by id</P>
     *
     * @param id
     * @return number of record update.
     * @throws SQLException
     */
    public int removeContractComment(Long id) throws SQLException{
        return this.contractCommentManager.delete(id);
    }


    /**
     * <P> query ContractComment list from database </P>
     *
     * @param forUpdate
     * @param  page current page
     * @param  maxLine maximum line of a page
     * @return number of record query
     * @throws SQLException
     * @throws IOException
    */
    public ContractCommentList queryContractComment(boolean forUpdate, int page, int maxLine)
            throws SQLException, IOException{
        /* Calculate start position of page */
        int offset = (page - 1) * maxLine;
        return this.contractCommentManager.select(forUpdate, offset, maxLine);
    }

    /**
     * <P>Get record by ID</P>
     * 
     * @param  ccid Contract comment ID
     * @param  forUpdate  Use FOR UPDATE (Yes or No)
     * @return  info that geted
     * @throws SQLException
     */
    public ContractCommentInfo queryContractCommentByCcid(Long ccid, boolean forUpdate) throws SQLException {
    	return this.contractCommentManager.selectByCcid(ccid, forUpdate);
    }
    
    /**
     * <P>Get list by tcid</P>
     * 
     * @param  tcid Temporary contract ID
     * @param  forUpdate  Use FOR UPDATE (Yes or No)
     * @return  List of info that geted
     * @throws SQLException
     * @throws IOException
     */
    public ContractCommentList queryContractCommentByTcid(Long tcid, boolean forUpdate, int offset, int limit) throws SQLException, IOException {
    	return this.contractCommentManager.selectByTcid(tcid, forUpdate, offset, limit);
    }

    /**
     * <P> query all of ContractComment list from database </P>
     *
     * @param forUpdate
     * @return number of record query
     * @throws SQLException
     * @throws IOException
    */
    public ContractCommentList queryAllContractComment(boolean forUpdate)
            throws SQLException, IOException{
        /* if limit < 0 or offset < 0 then select all */
        return this.contractCommentManager.select(forUpdate, -1, -1);
    }
    public List<ContractKindTreeNode> getContractKindTree(boolean forUpdate, Long parentId)
	    throws SQLException, IOException {
		ContractKindManager ckm = new ContractKindManager(getConnection());
		ckm.addOrderField(new OrderField("order_number", OrderType.ASC));
		
		List<ContractKindInfo> result = ckm.select(forUpdate, -1, -1).getList();
		
		List<ContractKindTreeNode> lstResult = new ArrayList<ContractKindTreeNode>();
		for (ContractKindInfo info : result) {
		    ContractKindTreeNode node = new ContractKindTreeNode();
		    node.setChildren(null);
		    node.setId(info.getId());
		    node.setDivStyle(DivStyle.NODE.getValue());
		    node.setLevel(0);
		    node.setName(info.getName());
		    node.setParentId(null);
		    lstResult.add(node);
		}
		
		return lstResult;
	}

    /**
     * <P> count total ContractComment </P>
     *
     * @param forUpdate
     * @return number of count record
     * @throws SQLException
     * @throws IOException
    */
    public int countTotalContractComment()
            throws SQLException, IOException{
        return this.contractCommentManager.countTotal();
    }
    
    /**
     * <P>Get ContractTemplateInfo by id</P>
     * 
     * @param  forUpdate  Use FOR UPDATE (Yes or No)
     * @return  List of info that geted
     * @throws SQLException
     */
    public ContractTemplateInfo queryContractTemplateById(Long id, boolean forUpdate) throws SQLException {
    	return this.contractTemplateManager.selectById(id, forUpdate);
    }
    
    
    /**
     * Add order field for temporary contract manager
     * 
     * @param orderField
     */
    public void addTemporaryContractOrderField(OrderField orderField) {
    	this.temporaryContractManager.addOrderField(orderField);
    }
    
    /**
	 * Set typeFilter
	 * @param typeFilter the typeFilter to set
	 */
	public void setTemporaryContractTypeFilter(Byte typeFilter) {
		this.temporaryContractManager.setTypeFilter(typeFilter);
	}
	
	public void setContractNumberFilter(String contractNumberFilter, FilterKind kind) {

        this.temporaryContractManager.setContractNumberFilter(contractNumberFilter, kind);
    }

	
	public void setContractIdFilter(Long contractIdFilter) {

        this.temporaryContractManager.setContractIdFilter(contractIdFilter);
    }

    /**
     * Set the contractKindIdFilter
     *
     * @param contractKindIdFilter the contractKindIdFilter to set
     */
    public void setContractKindIdFilter(Long contractKindIdFilter) {
        this.temporaryContractManager.setContractKindIdFilter(contractKindIdFilter);
    }




    /**
     * Set contract Template Id Filter
     *
     * @param contractTemplateIdFilter
     */
    public void setContractTemplateIdFilter(Long contractTemplateIdFilter) {

        this.temporaryContractManager.setContractTemplateIdFilter(contractTemplateIdFilter);
    }

    /**
     * Set the relationObjectFilter
     *
     * @param relationObjectFilter the relationObjectFilter to set
     */
    public void setRelationObjectFilter(String relationObjectFilter, FilterKind kind) {
        this.temporaryContractManager.setRelationObjectFilter(relationObjectFilter, kind);
    }

    /**
     * Set the relationObjectAFilter
     *
     * @param relationObjectAFilter the relationObjectAFilter to set
     */
    public void setRelationObjectAFilter(String relationObjectAFilter, FilterKind kind) {
        this.temporaryContractManager.setRelationObjectAFilter(relationObjectAFilter, kind);
    }

    /**
     * Set the relationObjectBFilter
     *
     * @param relationObjectBFilter the relationObjectBFilter to set
     */
    public void setRelationObjectBFilter(String relationObjectBFilter, FilterKind kind) {
        this.temporaryContractManager.setRelationObjectBFilter(relationObjectBFilter, kind);
    }

    /**
     * Set the relationObjectCFilter
     *
     * @param relationObjectCFilter the relationObjectCFilter to set
     */
    public void setRelationObjectCFilter(String relationObjectCFilter, FilterKind kind) {
        this.temporaryContractManager.setRelationObjectCFilter(relationObjectCFilter, kind);
    }

    /**
     * Set notary Date Filter
     *
     * @param notaryDateFilter
     */
    public void setNotaryDateFilter(Timestamp notaryDateFilter) {

        this.temporaryContractManager.setNotaryDateFilter(notaryDateFilter);
    }

    /**
     * Set notary DateFrom Filter
     *
     * @param notaryDateFromFilter
     */
    public void setNotaryDateFromFilter(Timestamp notaryDateFromFilter) {

        this.temporaryContractManager.setNotaryDateFromFilter(notaryDateFromFilter);
    }

    /**
     * Set notary DateTo Filter
     *
     * @param notaryDateToFilter
     */
    public void setNotaryDateToFilter(Timestamp notaryDateToFilter) {

        this.temporaryContractManager.setNotaryDateToFilter(notaryDateToFilter);
    }

    /**
     * Set bank Id Filter
     *
     * @param bankIdFilter
     */
    public void setBankIdFilter(Long bankIdFilter) {

        this.temporaryContractManager.setBankIdFilter(bankIdFilter);
    }



    public void setContractSummaryFilter(String contractSummaryFilter, FilterKind kind) {

        this.temporaryContractManager.setContractSummaryFilter(contractSummaryFilter, kind);
    }


    /**
     * Set the subKeys
     *
     * @param subKeys the subKeys to set
     */
    public void setSubKeys(List<String> subKeys) {
        this.temporaryContractManager.setSubKeys(subKeys);
    }

    /**
     * Set the keySearchFilter
     *
     * @param keySearchFilter the keySearchFilter to set
     */
    public void setKeySearchFilter(String keySearchFilter) {
        this.temporaryContractManager.setKeySearchFilter(keySearchFilter);
    }

    /**
     * Set the propertyInfoFilter
     *
     * @param propertyInfoFilter the propertyInfoFilter to set
     */
    public void setPropertyInfoFilter(String propertyInfoFilter, FilterKind kind) {
        this.temporaryContractManager.setPropertyInfoFilter(propertyInfoFilter, kind);
    }

    /**
     * Set the orderKeySearch
     *
     * @param orderKeySearch the orderKeySearch to set
     */
    public void setOrderKeySearch(Boolean orderKeySearch) {
        this.temporaryContractManager.setOrderKeySearch(orderKeySearch);
    }

    /**
     * Set the drafterIdFlagFilter
     *
     * @param drafterIdFlagFilter the drafterIdFlagFilter to set
     */
    public void setDrafterIdFlagFilter(Boolean drafterIdFlagFilter) {
        this.temporaryContractManager.setDrafterIdFlagFilter(drafterIdFlagFilter);
    }
}
