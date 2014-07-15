package com.osp.npo.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.osp.npo.core.OrderField;
import com.osp.npo.core.contract.ContractByNotaryManager;
import com.osp.npo.core.contract.ContractKindListForNotary;
import com.osp.npo.core.contract.ContractList;

/**
 * Generate by script
 * Generate date: 10/13/2010 3:47:47 PM
 */
public class ContractByNotaryService extends AbstractService {

    /** Contract Manager Object */
    private ContractByNotaryManager contractByNotaryManager;

    /**
     * <P>
     * Service constructor
     * </P>
     */
    public ContractByNotaryService(Connection connection) {
        super(connection);
        this.contractByNotaryManager = new ContractByNotaryManager(connection);      
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
        return this.contractByNotaryManager.select(forUpdate, offset, maxLine);
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
        return this.contractByNotaryManager.select(forUpdate, -1, -1);
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
        return this.contractByNotaryManager.selectUserReport(contractKindListForNotary, forUpdate);
    }
    
    /**
     * Query total cost TT91
     * @return
     * @throws SQLException
     * @throws IOException
     */
    public Long queryTotalCostTT91() throws SQLException, IOException {
    	return this.contractByNotaryManager.selectTotalCostTT91();
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
        return this.contractByNotaryManager.selectNotaryPlace(contractKindListForNotary, forUpdate);
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
        return this.contractByNotaryManager.countTotalByFilter();
    }
    
    /**
     * Add order field for table npo_contract
     *
     * @param orderField
     */
    public void addOrderFieldContract(OrderField orderField) {
        this.contractByNotaryManager.addOrderField(orderField);
    }
    
    /**
     * Set notary DateFrom Filter
     *
     * @param notaryDateFromFilter
     */
    public void setNotaryDateFromFilter(Timestamp notaryDateFromFilter) {

        this.contractByNotaryManager.setNotaryDateFromFilter(notaryDateFromFilter);
    }

    /**
     * Set notary DateTo Filter
     *
     * @param notaryDateToFilter
     */
    public void setNotaryDateToFilter(Timestamp notaryDateToFilter) {

        this.contractByNotaryManager.setNotaryDateToFilter(notaryDateToFilter);
    }
    
    /**
     * Set the notaryIdFilter
     *
     * @param notaryIdFilter the notaryIdFilter to set
     */
    public void setNotaryIdFilter(Long notaryIdFilter) {
        this.contractByNotaryManager.setNotaryIdFilter(notaryIdFilter);
    }
    
    /**
     * Set the notaryPlaceFilter
     *
     * @param notaryPlaceFilter the notaryPlaceFilter to set
     */
    public void setNotaryPlaceFilter(Boolean notaryPlaceFilter) {
        this.contractByNotaryManager.setNotaryPlaceFilter(notaryPlaceFilter);
    }
}
