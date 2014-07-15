package com.osp.npo.core.contract;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.osp.npo.core.AbstractManager;

public class LostNumberManager extends AbstractManager{

	public LostNumberManager(Connection connection) {
		super(connection);
	}
	
	/**
     * <P>Add new infomation</P>
     *
     * @param  info  Infomation that need add
     * @return  PreparedStatement#executeUpdate Return's Value
     * @throws SQLException
     */
    public int insert(LostNumberInfo info) throws SQLException {

        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" INSERT INTO ");
        sqlBuffer.append("npo_lost_number");
        sqlBuffer.append(" ( ");
        sqlBuffer.append("year,");
        sqlBuffer.append("kind_id,");
        sqlBuffer.append("contract_number");
        sqlBuffer.append(" ) ");
        sqlBuffer.append(" VALUES ");
        sqlBuffer.append(" ( ");
        sqlBuffer.append("?,");
        sqlBuffer.append("?,");
        sqlBuffer.append("?");
        sqlBuffer.append(" ) ");
        setSql(sqlBuffer.toString());

        PreparedStatement ps = null;
        int result = -1;
        try {
            Connection c = this.getConnection();
            ps = c.prepareStatement(getSql());
            
            int i = 1;
            psSetInt(ps, i++, info.getYear());
            psSetLong(ps, i++, info.getKindId());
            psSetLong(ps, i++, info.getLostContractNumber());
        
            result = ps.executeUpdate();
 
        } finally {
            close(ps);
        }

        return result;
    }
    
    /**
     * <P>Get record by id</P>
     * 
     * @return  List of info that geted
     * @throws SQLException
     */
    public LostNumberInfo selectLostNumber(LostNumberInfo lostNumberInfo) throws SQLException {

        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" SELECT ");
        sqlBuffer.append(" ln.year, ");
        sqlBuffer.append(" ln.kind_id, ");
        sqlBuffer.append(" ln.contract_number ");
        sqlBuffer.append(" FROM ");
        sqlBuffer.append( "npo_lost_number ln" );
        
        sqlBuffer.append(" WHERE ln.kind_id=? ");
        sqlBuffer.append(" AND ");
        sqlBuffer.append(" ln.contract_number=? ");
        sqlBuffer.append(" AND ");
        sqlBuffer.append(" ln.year=? ");
        
        this.setSql(sqlBuffer.toString());

        PreparedStatement ps = null;
        ResultSet rs = null;
        LostNumberInfo info = null;
        try {
            Connection c = this.getConnection();
            ps = c.prepareStatement(this.getSql());

            int i=1;
	        psSetLong(ps, i++, lostNumberInfo.getKindId());
	        psSetLong(ps, i++, lostNumberInfo.getLostContractNumber());
	        psSetInt(ps, i++, lostNumberInfo.getYear());
            
            rs = ps.executeQuery();

            while(rs.next()) {
                info = new LostNumberInfo();
                rsSetInfo(rs, info);
            }
        } finally {
            close(ps, rs);
        }

        return info;
    }
    

    /**
     * <P>Delete a record</P>
     *
     * @param  id
     * @return  PreparedStatement#executeUpdate Return's Value
     * @throws SQLException
     */
    public int delete(LostNumberInfo lostNumberInfo) throws SQLException {

        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" DELETE FROM ");
        sqlBuffer.append(" npo_lost_number ");
        sqlBuffer.append(" WHERE ");
        sqlBuffer.append(" kind_id = ? ");
        sqlBuffer.append(" AND ");
        sqlBuffer.append(" contract_number = ? ");
        sqlBuffer.append(" AND ");
        sqlBuffer.append(" year=? ");


        this.setSql(sqlBuffer.toString());

        PreparedStatement ps = null;
        int result;

        try{
            Connection c = this.getConnection();
            ps = c.prepareStatement(this.getSql());

            int i=1;
            psSetLong(ps, i++, lostNumberInfo.getKindId());
            psSetLong(ps, i++, lostNumberInfo.getLostContractNumber());
            psSetInt(ps, i++, lostNumberInfo.getYear());
            
            result = ps.executeUpdate();

        } finally{
            close(ps);
        }

        return result;
    }

    
    /**
     * <P>Set ResultSet to Info instance </P>
     *
     * @param  rs    ResultSet
     * @param  info  Info instance
     * @throws SQLException
     */
    private void rsSetInfo(ResultSet rs,LostNumberInfo info) throws SQLException {

    	info.setYear(rsGetInt(rs, "year"));
        info.setKindId(rsGetLong(rs, "kind_id"));
        info.setLostContractNumber(rsGetLong(rs, "contract_number"));
    }

    

}
