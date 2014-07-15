package com.osp.npo.service;


import java.sql.Connection;
import java.sql.SQLException;


import com.osp.npo.core.diagnostic.DiagnosticManager;


/**
 * Generate by script
 * Generate date: 1/2/2012 9:54:59 PM
 * @version $Revision$ 
 */
public class DiagnosticService extends AbstractService {


    /** Diagnostic Manager Object */
    private DiagnosticManager diagnosticManager;




    /** <P> Service constructor </P>*/
    public DiagnosticService(Connection connection) {
        super(connection);
        this.diagnosticManager = new DiagnosticManager (connection);
    }

    /**
     * <P>Dem so ban ghi con chua dong bo</P>
     * 
     * @return  Count of record that geted
     * @throws SQLException
     */
    public long countSyncRemained() throws SQLException {
    	return this.diagnosticManager.countSyncRemained();
    }
    
    /**
     * <P>Dem so ban ghi con dong bo bi loi</P>
     * 
     * @return  Count of record that geted
     * @throws SQLException
     */
    public long countSyncError() throws SQLException {
    	return this.diagnosticManager.countSyncError();
    }
    
    /**
     * <P>Dem so ban ghi DLNC cua van phong</P>
     * 
     * @return  Count of record that geted
     * @throws SQLException
     */
    public long countDataPreventByOffice(String officeCode) throws SQLException {
    	return this.diagnosticManager.countDataPreventByOffice(officeCode);
    }
    
    /**
     * <P>Dem tong so ban ghi DLNC</P>
     * 
     * @return  Count of record that geted
     * @throws SQLException
     */
    public long countTotalDataPrevent() throws SQLException {
    	return this.diagnosticManager.countTotalDataPrevent();
    }
    
    /**
     * <P>Dem so ban ghi HD, GD cua van phong</P>
     * 
     * @return  Count of record that geted
     * @throws SQLException
     */
    public long countTransactionByOffice(String officeCode) throws SQLException {
    	return this.diagnosticManager.countTransactionByOffice(officeCode);
    }
    
    /**
     * <P>Dem tong so ban ghi HD, GD </P>
     * 
     * @return  Count of record that geted
     * @throws SQLException
     */
    public long countTotalTransaction() throws SQLException {
    	return this.diagnosticManager.countTotalTransaction();
    }
    
    /**
     * <P>Dem tong so ban ghi hop dong noi bo </P>
     * 
     * @return  Count of record that geted
     * @throws SQLException
     */
    public long countContract() throws SQLException {
    	return this.diagnosticManager.countContract();
    }
    
    /**
     * <P>Dem tong so ban ghi HD, GD trung contract id </P>
     * 
     * @return  Count of record that geted
     * @throws SQLException
     */
    public long countDuplicateContractId() throws SQLException {
    	return this.diagnosticManager.countDuplicateContractId();
    }
    
    /**
     * <P>Dem tong so ban ghi HD, GD trung synchronize id </P>
     * 
     * @return  Count of record that geted
     * @throws SQLException
     */
    public long countDuplicateSyncId() throws SQLException {
    	return this.diagnosticManager.countDuplicateSyncId();
    }
}
