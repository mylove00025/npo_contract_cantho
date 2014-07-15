package com.osp.npo.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.osp.npo.core.OrderField;
import com.osp.npo.core.contract.ContractErrorManager;
import com.osp.npo.core.contract.ContractList;

/**
 * Generate by script
 * Generate date: 10/13/2010 3:47:47 PM
 */
public class ContractErrorService extends AbstractService {

    /** Contract Manager Object */
    private ContractErrorManager contractErrorManager;

    /**
     * <P>
     * Service constructor
     * </P>
     */
    public ContractErrorService(Connection connection) {
        super(connection);
        this.contractErrorManager = new ContractErrorManager(connection);      
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
        return this.contractErrorManager.select(forUpdate, offset, maxLine);
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
        return this.contractErrorManager.select(forUpdate, -1, -1);
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
        return this.contractErrorManager.countTotalByFilter();
    }
    
    /**
     * Add order field for table npo_contract
     *
     * @param orderField
     */
    public void addOrderFieldContract(OrderField orderField) {
        this.contractErrorManager.addOrderField(orderField);
    }
    
    /**
     * Set notary DateFrom Filter
     *
     * @param notaryDateFromFilter
     */
    public void setNotaryDateFromFilter(Timestamp notaryDateFromFilter) {

        this.contractErrorManager.setNotaryDateFromFilter(notaryDateFromFilter);
    }

    /**
     * Set notary DateTo Filter
     *
     * @param notaryDateToFilter
     */
    public void setNotaryDateToFilter(Timestamp notaryDateToFilter) {

        this.contractErrorManager.setNotaryDateToFilter(notaryDateToFilter);
    }
    
    /**
     * Set the notaryIdFilter
     *
     * @param notaryIdFilter the notaryIdFilter to set
     */
    public void setNotaryIdFilter(Long notaryIdFilter) {
        this.contractErrorManager.setNotaryIdFilter(notaryIdFilter);
    }

    /**
     * Set the drafterIdFilter
     *
     * @param drafterIdFilter the drafterIdFilter to set
     */
    public void setDrafterIdFilter(Long drafterIdFilter) {
        this.contractErrorManager.setDrafterIdFilter(drafterIdFilter);
    }
    
    /**
     * Set the errorStatusFilter
     *
     * @param errorStatusFilter the errorStatusFilter to set
     */
    public void setErrorStatusFilter(Boolean errorStatusFilter) {
        this.contractErrorManager.setErrorStatusFilter(errorStatusFilter);
    }
}
