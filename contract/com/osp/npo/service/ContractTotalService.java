package com.osp.npo.service;


import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;


import com.osp.npo.core.OrderField;
import com.osp.npo.core.contractTotal.ContractKindTotalList;
import com.osp.npo.core.contractTotal.ContractKindTotalManager;
import com.osp.npo.core.contractTotal.ContractUserTotalManager;
import com.osp.npo.core.contractTotal.ContractUserTotalList;
import com.osp.npo.core.contractTotal.ContractBankTotalManager;
import com.osp.npo.core.contractTotal.ContractBankTotalList;


/**
 * Generate by script
 * Generate date: 12/05/2010 1:52:14 PM
 * @version $Revision: 19081 $
 */
public class ContractTotalService extends AbstractService {


    /** ContractUserTotal Manager Object */
    private ContractUserTotalManager contractUserTotalManager;


    /** ContractBankTotal Manager Object */
    private ContractBankTotalManager contractBankTotalManager;
    
    /** ContractKindTotal Manager Object */
    private ContractKindTotalManager contractKindTotalManager;


    /** <P> Service constructor </P>*/
    public ContractTotalService(Connection connection) {
        super(connection);
        this.contractUserTotalManager = new ContractUserTotalManager (connection);
        this.contractBankTotalManager = new ContractBankTotalManager (connection);
        this.contractKindTotalManager = new ContractKindTotalManager(connection);
    }


    /**
     * <P> query ContractUserTotal by notary </P>
     *
     * @return number of record query
     * @throws SQLException
     * @throws IOException
    */
    public ContractUserTotalList queryContractUserTotalByNotary()
            throws SQLException, IOException{
        return this.contractUserTotalManager.selectTotalByNotary();
    }
    
    /**
     * <P> query ContractUserTotal by drafter </P>
     *
     * @return number of record query
     * @throws SQLException
     * @throws IOException
    */
    public ContractUserTotalList queryContractUserTotalByDrafter()
            throws SQLException, IOException{
        return this.contractUserTotalManager.selectTotalByDrafter();
    }

    
    /**
     * <P> count total Contract</P>
     *
     * @param forUpdate
     * @return number of count record
     * @throws SQLException
     * @throws IOException
    */
    public int countContract() throws SQLException, IOException{
        return this.contractUserTotalManager.countContract();
    }
    
    
    /**
     * <P> Count total error Contract</P>
     *
     * @param forUpdate
     * @return number of count record
     * @throws SQLException
     * @throws IOException
    */
    public int countErrorContract() throws SQLException, IOException{
        return this.contractUserTotalManager.countErrorContract();
    }
    

    /**
     * <P> query ContractBankTotal list from database </P>
     *
     * @return number of record query
     * @throws SQLException
     * @throws IOException
    */
    public ContractBankTotalList queryContractBankTotal()
            throws SQLException, IOException{
        return this.contractBankTotalManager.selectTotal();
    }
    
    /**
     * <P> query ContractKindTotal by drafter </P>
     *
     * @return number of record query
     * @throws SQLException
     * @throws IOException
    */
    public ContractKindTotalList queryContractKindTotal()
            throws SQLException, IOException{
        return this.contractKindTotalManager.selectTotal();
    }


    /**
     * Set notary Date Filter
     *
     * @param notaryDateFilter
     */
    public void setNotaryDateToFilter(Timestamp notaryDateToFilter) {
        this.contractBankTotalManager.setNotaryDateToFilter(notaryDateToFilter);
        this.contractUserTotalManager.setNotaryDateToFilter(notaryDateToFilter);
    }

    /**
     * Set notary DateFrom Filter
     *
     * @param notaryDateFromFilter
     */
    public void setNotaryDateFromFilter(Timestamp notaryDateFromFilter) {
        this.contractBankTotalManager.setNotaryDateFromFilter(notaryDateFromFilter);
        this.contractUserTotalManager.setNotaryDateFromFilter(notaryDateFromFilter);
    }
    
    /**
     * Set role Filter
     * 
     * @param roleFilter   
     */
    public void setRoleFilter(String[] roleFilter) {
    
        this.contractUserTotalManager.setRoleFilter(roleFilter);
    }
    
    /**
     * Set active Flag Filter
     * 
     * @param activeFlgFilter     
     */
    public void setActiveFlgFilter(Boolean activeFlgFilter) {
    
        this.contractUserTotalManager.setActiveFlgFilter(activeFlgFilter);
    }
    
    /**
     * Set hidden Flag Filter
     * 
     * @param hiddenFlgFilter     
     */
    public void setHiddenFlgFilter(Boolean hiddenFlgFilter) {
    
        this.contractUserTotalManager.setHiddenFlgFilter(hiddenFlgFilter);
    }
    
    /**
     * Add order field for table npo_user
     * @param orderField
     */
    public void addOrderFieldContractUserTotal(OrderField orderField) {
        this.contractUserTotalManager.addOrderField(orderField);
    }
    
    /**
     * Add order field for table npo_user
     * @param orderField
     */
    public void addOrderFieldContractBankTotal(OrderField orderField) {
        this.contractBankTotalManager.addOrderField(orderField);
    }
    
    /**
     * Set active Flag Template Filter
     * 
     * @param activeFlgFilter     
     */
    public void setActiveFlgTemplateFilter(Boolean activeFlgFilter) {
    
        this.contractKindTotalManager.setActiveFlgFilter(activeFlgFilter);
    }
    
    /**
     * Set notary DateFrom Filter
     *
     * @param notaryDateFromFilter
     */
    public void setNotaryDateContractFromFilter(Timestamp notaryDateFromFilter) {

        this.contractKindTotalManager.setNotaryDateFromFilter(notaryDateFromFilter);
    }

    /**
     * Set notary DateTo Filter
     *
     * @param notaryDateToFilter
     */
    public void setNotaryDateContractToFilter(Timestamp notaryDateToFilter) {

        this.contractKindTotalManager.setNotaryDateToFilter(notaryDateToFilter);
    }
    
    /**
     * Add order field for table npo_user
     * @param orderField
     */
    public void addOrderFieldContractKindTotal(OrderField orderField) {
        this.contractKindTotalManager.addOrderField(orderField);
    }
}
