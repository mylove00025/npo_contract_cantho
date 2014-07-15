package com.osp.npo.service;


import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.osp.npo.core.announcement.AnnouncementInfo;
import com.osp.npo.core.contract.ContractKindInfo;
import com.osp.npo.core.contract.ContractKindManager;
import com.osp.npo.core.contract.ContractManager;
import com.osp.npo.core.contract.ContractNumberInfo;
import com.osp.npo.core.contract.ContractNumberManager;
import com.osp.npo.core.contract.ContractPropertyManager;
import com.osp.npo.core.contract.ContractStatisticalManager;
import com.osp.npo.core.contract.ContractTemplateManager;
import com.osp.npo.core.contract.PropertyManager;
import com.osp.npo.core.user.UserManager;

public class ContractNumberService extends AbstractService{
	
	 /** Contract Number Manager Object */
    private ContractNumberManager contractNumberManager;
    
    /**
     * <P>
     * Service constructor
     * </P>
     */
    public ContractNumberService(Connection connection) {
        super(connection);
        this.contractNumberManager = new ContractNumberManager(connection);
    }
    
    /**
     * <P> entry ContractNumberInfo object to database </P>
     *
     * @param info
     * @return number of record insert.
     * @throws SQLException
     */
    public int entryContractNumber(ContractNumberInfo info) throws SQLException{
        return this.contractNumberManager.insert(info);
    }

    
    
    /**
     * <P> modify ContractNumberInfo object to database </P>
     *
     * @param info
     * @return number of record update.
     * @throws SQLException
     * @throws IOException
     */
    public int modifyContractNumber(ContractNumberInfo info) throws SQLException, IOException{
        return this.contractNumberManager.update(info);
    }
    /**
     * <P>
     * query ContractNumber from database
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
    public ContractNumberInfo queryContractNumberByContractKindId(Long contractKindId) throws SQLException, IOException {
 
        return this.contractNumberManager.selectContractNumberbyKindId(contractKindId);
    }
    
    /**
     * <P> reset object in database </P>
     *
     * @param info
     * @return number of record update.
     * @throws SQLException
     * @throws IOException
     */
    public int resetNumber() throws SQLException, IOException{
        return this.contractNumberManager.reset();
    }

}
