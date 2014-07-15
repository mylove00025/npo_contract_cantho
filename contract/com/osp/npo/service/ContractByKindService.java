package com.osp.npo.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.osp.npo.core.OrderField;
import com.osp.npo.core.contract.ContractByKindManager;
import com.osp.npo.core.contract.ContractList;

/**
 * Generate by script
 * Generate date: 10/13/2010 3:47:47 PM
 */
public class ContractByKindService extends AbstractService {

    /** Contract Manager Object */
    private ContractByKindManager contractByKindManager;

    /**
     * <P>
     * Service constructor
     * </P>
     */
    public ContractByKindService(Connection connection) {
        super(connection);
        this.contractByKindManager = new ContractByKindManager(connection);      
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
        return this.contractByKindManager.select(forUpdate, offset, maxLine);
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
        return this.contractByKindManager.select(forUpdate, -1, -1);
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
        return this.contractByKindManager.countTotalByFilter();
    }
    
    /**
     * Add order field for table npo_contract
     *
     * @param orderField
     */
    public void addOrderFieldContract(OrderField orderField) {
        this.contractByKindManager.addOrderField(orderField);
    }
    
    /**
     * Set notary DateFrom Filter
     *
     * @param notaryDateFromFilter
     */
    public void setNotaryDateFromFilter(Timestamp notaryDateFromFilter) {

        this.contractByKindManager.setNotaryDateFromFilter(notaryDateFromFilter);
    }

    /**
     * Set notary DateTo Filter
     *
     * @param notaryDateToFilter
     */
    public void setNotaryDateToFilter(Timestamp notaryDateToFilter) {

        this.contractByKindManager.setNotaryDateToFilter(notaryDateToFilter);
    }
    
    /**
     * Set the contractKindIdFilter
     *
     * @param contractKindIdFilter the contractKindIdFilter to set
     */
    public void setContractKindIdFilter(Long contractKindIdFilter) {
        this.contractByKindManager.setContractKindIdFilter(contractKindIdFilter);
    }
    
    /**
     * Set the contractTemplateActiveFlgFilter
     *
     * @param contractTemplateActiveFlgFilter the contractTemplateActiveFlgFilter to set
     */
    public void setContractTemplateActiveFlgFilter(Boolean contractTemplateActiveFlgFilter) {
        this.contractByKindManager.setContractTemplateActiveFlgFilter(contractTemplateActiveFlgFilter);
    }
}
