package com.osp.npo.core.diagnostic;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.osp.npo.core.AbstractManager;


/**
 * Generate by script
 * Generate date: 1/2/2012 9:54:58 PM
 * @version $Revision$ 
 */
public class DiagnosticManager extends AbstractManager {


    /**
     * <P>Generate instance</P>
     * 
     * @param  connection  Connection
     */
    public DiagnosticManager(Connection connection) {
        super(connection);
    }


    /**
     * <P>Dem so ban ghi con chua dong bo</P>
     * 
     * @return  Count of record that geted
     * @throws SQLException
     */
    public long countSyncRemained() throws SQLException {

        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" SELECT ");
        sqlBuffer.append(" COUNT(*) ");
        sqlBuffer.append(" FROM ");
        sqlBuffer.append(" npo_synchronize ");

        this.setSql(sqlBuffer.toString());

        PreparedStatement ps = null;
        ResultSet rs = null;
        long result;
        try {
            Connection c = this.getConnection();
            ps = c.prepareStatement(this.getSql());

            rs = ps.executeQuery();
            rs.next();
            result = rs.getLong(1);

        } finally {
            close(ps, rs);
        }

        return result;
    }

    /**
     * <P>Dem so ban ghi con dong bo bi loi</P>
     * 
     * @return  Count of record that geted
     * @throws SQLException
     */
    public long countSyncError() throws SQLException {

        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" SELECT ");
        sqlBuffer.append(" COUNT(*) ");
        sqlBuffer.append(" FROM ");
        sqlBuffer.append(" npo_synchronize ");
        sqlBuffer.append(" WHERE status=1 ");

        this.setSql(sqlBuffer.toString());

        PreparedStatement ps = null;
        ResultSet rs = null;
        long result;
        try {
            Connection c = this.getConnection();
            ps = c.prepareStatement(this.getSql());

            rs = ps.executeQuery();
            rs.next();
            result = rs.getLong(1);

        } finally {
            close(ps, rs);
        }

        return result;
    }
    
    /**
     * <P>Dem so ban ghi DLNC cua van phong</P>
     * 
     * @return  Count of record that geted
     * @throws SQLException
     */
    public long countDataPreventByOffice(String officeCode) throws SQLException {

        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" SELECT ");
        sqlBuffer.append(" COUNT(*) ");
        sqlBuffer.append(" FROM ");
        sqlBuffer.append(" npo_data_prevent ");
        sqlBuffer.append(" WHERE delete_flg=0 ");
        sqlBuffer.append(" AND synchronize_id LIKE ? ");

        this.setSql(sqlBuffer.toString());

        PreparedStatement ps = null;
        ResultSet rs = null;
        long result;
        try {
            Connection c = this.getConnection();
            ps = c.prepareStatement(this.getSql());

            psSetString(ps, 1, officeCode + "_%");
            
            rs = ps.executeQuery();
            rs.next();
            result = rs.getLong(1);

        } finally {
            close(ps, rs);
        }

        return result;
    }
    
    
    /**
     * <P>Dem tong so ban ghi DLNC</P>
     * 
     * @return  Count of record that geted
     * @throws SQLException
     */
    public long countTotalDataPrevent() throws SQLException {

        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" SELECT ");
        sqlBuffer.append(" COUNT(*) ");
        sqlBuffer.append(" FROM ");
        sqlBuffer.append(" npo_data_prevent ");
        sqlBuffer.append(" WHERE delete_flg=0 ");

        this.setSql(sqlBuffer.toString());

        PreparedStatement ps = null;
        ResultSet rs = null;
        long result;
        try {
            Connection c = this.getConnection();
            ps = c.prepareStatement(this.getSql());

            rs = ps.executeQuery();
            rs.next();
            result = rs.getLong(1);

        } finally {
            close(ps, rs);
        }

        return result;
    }
    
    /**
     * <P>Dem so ban ghi HD, GD cua van phong</P>
     * 
     * @return  Count of record that geted
     * @throws SQLException
     */
    public long countTransactionByOffice(String officeCode) throws SQLException {

        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" SELECT ");
        sqlBuffer.append(" COUNT(*) ");
        sqlBuffer.append(" FROM ");
        sqlBuffer.append(" npo_transaction_property ");
        sqlBuffer.append(" WHERE contract_id IS NOT NULL ");
        sqlBuffer.append(" AND synchronize_id LIKE ? ");

        this.setSql(sqlBuffer.toString());

        PreparedStatement ps = null;
        ResultSet rs = null;
        long result;
        try {
            Connection c = this.getConnection();
            ps = c.prepareStatement(this.getSql());

            psSetString(ps, 1, officeCode + "_%");
            
            rs = ps.executeQuery();
            rs.next();
            result = rs.getLong(1);

        } finally {
            close(ps, rs);
        }

        return result;
    }
    
    
    /**
     * <P>Dem tong so ban ghi HD, GD </P>
     * 
     * @return  Count of record that geted
     * @throws SQLException
     */
    public long countTotalTransaction() throws SQLException {

        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" SELECT ");
        sqlBuffer.append(" COUNT(*) ");
        sqlBuffer.append(" FROM ");
        sqlBuffer.append(" npo_transaction_property ");

        this.setSql(sqlBuffer.toString());

        PreparedStatement ps = null;
        ResultSet rs = null;
        long result;
        try {
            Connection c = this.getConnection();
            ps = c.prepareStatement(this.getSql());

            rs = ps.executeQuery();
            rs.next();
            result = rs.getLong(1);

        } finally {
            close(ps, rs);
        }

        return result;
    }
    
    /**
     * <P>Dem tong so ban ghi hop dong noi bo </P>
     * 
     * @return  Count of record that geted
     * @throws SQLException
     */
    public long countContract() throws SQLException {

        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" SELECT ");
        sqlBuffer.append(" COUNT(*) ");
        sqlBuffer.append(" FROM ");
        sqlBuffer.append(" npo_contract ");

        this.setSql(sqlBuffer.toString());

        PreparedStatement ps = null;
        ResultSet rs = null;
        long result;
        try {
            Connection c = this.getConnection();
            ps = c.prepareStatement(this.getSql());

            rs = ps.executeQuery();
            rs.next();
            result = rs.getLong(1);

        } finally {
            close(ps, rs);
        }

        return result;
    }
    
    /**
     * <P>Dem tong so ban ghi HD, GD trung contract id </P>
     * 
     * @return  Count of record that geted
     * @throws SQLException
     */
    public long countDuplicateContractId() throws SQLException {

        String sql = " SELECT SUM(A) FROM (SELECT COUNT(*) AS A FROM npo_transaction_property " +
        		"WHERE contract_id IS NOT NULL GROUP BY contract_id HAVING A > 1) tbl1 ";

        this.setSql(sql);

        PreparedStatement ps = null;
        ResultSet rs = null;
        long result = 0;
        try {
            Connection c = this.getConnection();
            ps = c.prepareStatement(this.getSql());

            rs = ps.executeQuery();
            if (rs.next()) {
            	result = rs.getLong(1);
            }
        } finally {
            close(ps, rs);
        }

        return result;
    }
    
    /**
     * <P>Dem tong so ban ghi HD, GD trung synchronize id </P>
     * 
     * @return  Count of record that geted
     * @throws SQLException
     */
    public long countDuplicateSyncId() throws SQLException {

        String sql = " SELECT SUM(A) FROM (SELECT COUNT(*) AS A FROM npo_transaction_property " +
        		" GROUP BY synchronize_id HAVING A > 1) tbl1 ";

        this.setSql(sql);

        PreparedStatement ps = null;
        ResultSet rs = null;
        long result = 0;
        try {
            Connection c = this.getConnection();
            ps = c.prepareStatement(this.getSql());

            rs = ps.executeQuery();
            if (rs.next()) {
            	result = rs.getLong(1);
            }

        } finally {
            close(ps, rs);
        }

        return result;
    }
}
