package com.osp.npo.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.osp.npo.core.OrderField;
import com.osp.npo.core.contract.ContractCertifyManager;
import com.osp.npo.core.contract.ContractList;

/**
 * Generate by script
 * Generate date: 10/13/2010 3:47:47 PM
 */
public class ContractCertifyService extends AbstractService {

    /** Contract Manager Object */
    private ContractCertifyManager contractCertifyManager;

    /**
     * <P>
     * Service constructor
     * </P>
     */
    public ContractCertifyService(Connection connection) {
        super(connection);
        this.contractCertifyManager = new ContractCertifyManager(connection);      
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
        return this.contractCertifyManager.select(forUpdate, offset, maxLine);
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
        return this.contractCertifyManager.select(forUpdate, -1, -1);
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
        return this.contractCertifyManager.countTotalByFilter();
    }
    
    /**
     * Add order field for table npo_contract
     *
     * @param orderField
     */
    public void addOrderFieldContract(OrderField orderField) {
        this.contractCertifyManager.addOrderField(orderField);
    }
    
    /**
     * Set notary DateFrom Filter
     *
     * @param notaryDateFromFilter
     */
    public void setNotaryDateFromFilter(Timestamp notaryDateFromFilter) {

        this.contractCertifyManager.setNotaryDateFromFilter(notaryDateFromFilter);
    }

    /**
     * Set notary DateTo Filter
     *
     * @param notaryDateToFilter
     */
    public void setNotaryDateToFilter(Timestamp notaryDateToFilter) {

        this.contractCertifyManager.setNotaryDateToFilter(notaryDateToFilter);
    }
    
    /**
     * Set the contractKindIdArrayFilter
     *
     * @param contractKindIdArrayFilter the contractKindIdArrayFilter to set
     */
    public void setContractKindIdArrayFilter(Long[] contractKindIdArrayFilter) {
        this.contractCertifyManager.setContractKindIdArrayFilter(contractKindIdArrayFilter);
    }
    
    /**
     * Set the entryUserIdFilter
     *
     * @param entryUserIdFilter the entryUserIdFilter to set
     */
    public void setEntryUserIdFilter(Long entryUserIdFilter) {
        this.contractCertifyManager.setEntryUserIdFilter(entryUserIdFilter);
    }
}
