package com.osp.npo.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.osp.npo.core.OrderField;
import com.osp.npo.core.contract.ContractByBankManager;
import com.osp.npo.core.contract.ContractList;

/**
 * Generate by script
 * Generate date: 10/13/2010 3:47:47 PM
 */
public class ContractByBankService extends AbstractService {

    /** Contract Manager Object */
    private ContractByBankManager contractByBankManager;

    /**
     * <P>
     * Service constructor
     * </P>
     */
    public ContractByBankService(Connection connection) {
        super(connection);
        this.contractByBankManager = new ContractByBankManager(connection);      
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
        return this.contractByBankManager.select(forUpdate, offset, maxLine);
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
        return this.contractByBankManager.select(forUpdate, -1, -1);
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
        return this.contractByBankManager.countTotalByFilter();
    }
    
    /**
     * Add order field for table npo_contract
     *
     * @param orderField
     */
    public void addOrderFieldContract(OrderField orderField) {
        this.contractByBankManager.addOrderField(orderField);
    }
    
    /**
     * Set notary DateFrom Filter
     *
     * @param notaryDateFromFilter
     */
    public void setNotaryDateFromFilter(Timestamp notaryDateFromFilter) {

        this.contractByBankManager.setNotaryDateFromFilter(notaryDateFromFilter);
    }

    /**
     * Set notary DateTo Filter
     *
     * @param notaryDateToFilter
     */
    public void setNotaryDateToFilter(Timestamp notaryDateToFilter) {

        this.contractByBankManager.setNotaryDateToFilter(notaryDateToFilter);
    }
    
    /**
     * Set bank Id Filter
     *
     * @param bankIdFilter
     */
    public void setBankIdFilter(Long bankIdFilter) {

        this.contractByBankManager.setBankIdFilter(bankIdFilter);
    }
    
    /**
     * Set the bankIdNullFilter
     *
     * @param bankIdNullFilter the bankIdNullFilter to set
     */
    public void setBankIdNullFilter(Boolean bankIdNullFilter) {
        this.contractByBankManager.setBankIdNullFilter(bankIdNullFilter);
    }
}
