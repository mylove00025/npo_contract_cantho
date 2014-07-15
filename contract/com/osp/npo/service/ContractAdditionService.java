package com.osp.npo.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.osp.npo.core.OrderField;
import com.osp.npo.core.contract.ContractAdditionManager;
import com.osp.npo.core.contract.ContractList;

/**
 * Generate by script
 * Generate date: 10/13/2010 3:47:47 PM
 */
public class ContractAdditionService extends AbstractService {

    /** Contract Manager Object */
    private ContractAdditionManager contractAdditionManager;

    /**
     * <P>
     * Service constructor
     * </P>
     */
    public ContractAdditionService(Connection connection) {
        super(connection);
        this.contractAdditionManager = new ContractAdditionManager(connection);      
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
        return this.contractAdditionManager.select(forUpdate, offset, maxLine);
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
        return this.contractAdditionManager.select(forUpdate, -1, -1);
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
        return this.contractAdditionManager.countTotalByFilter();
    }
    
    /**
     * Add order field for table npo_contract
     *
     * @param orderField
     */
    public void addOrderFieldContract(OrderField orderField) {
        this.contractAdditionManager.addOrderField(orderField);
    }
    
    /**
     * Set notary DateFrom Filter
     *
     * @param notaryDateFromFilter
     */
    public void setNotaryDateFromFilter(Timestamp notaryDateFromFilter) {

        this.contractAdditionManager.setNotaryDateFromFilter(notaryDateFromFilter);
    }

    /**
     * Set notary DateTo Filter
     *
     * @param notaryDateToFilter
     */
    public void setNotaryDateToFilter(Timestamp notaryDateToFilter) {

        this.contractAdditionManager.setNotaryDateToFilter(notaryDateToFilter);
    }
    
    /**
     * Set the drafterIdFilter
     *
     * @param drafterIdFilter the drafterIdFilter to set
     */
    public void setDrafterIdFilter(Long drafterIdFilter) {
        this.contractAdditionManager.setDrafterIdFilter(drafterIdFilter);
    }
    
    /**
     * Set the drafterIdFlagFilter
     *
     * @param drafterIdFlagFilter the drafterIdFlagFilter to set
     */
    public void setDrafterIdFlagFilter(Boolean drafterIdFlagFilter) {
        this.contractAdditionManager.setDrafterIdFlagFilter(drafterIdFlagFilter);
    }
    
    /**
     * Set the additionStatusFilter
     *
     * @param additionStatusFilter the additionStatusFilter to set
     */
    public void setAdditionStatusFilter(Boolean additionStatusFilter) {
        this.contractAdditionManager.setAdditionStatusFilter(additionStatusFilter);
    }
}
