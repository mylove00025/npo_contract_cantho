package com.osp.npo.core.contract;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.osp.npo.core.AbstractManager;

public class ContractNumberManager extends AbstractManager{
	
	 /**
     * <P>Generate instance</P>
     *
     * @param  connection  Connection
     */
	public ContractNumberManager(Connection connection) {
		super(connection);
	}
	
	
	 /**
     * <P>Add new infomation</P>
     *
     * @param  info  Infomation that need add
     * @return  PreparedStatement#executeUpdate Return's Value
     * @throws SQLException
     */
    public int insert(ContractNumberInfo info) throws SQLException {

        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" INSERT INTO ");
        sqlBuffer.append("npo_contract_number");
        sqlBuffer.append(" ( ");
        sqlBuffer.append("kind_id,");
        sqlBuffer.append("contract_number");
        sqlBuffer.append(" ) ");
        sqlBuffer.append(" VALUES ");
        sqlBuffer.append(" ( ");
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
            psSetLong(ps, i++, info.getKindId());
            psSetLong(ps, i++, info.getContractNumber());
        

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
    public ContractNumberInfo selectContractNumberbyKindId(Long id) throws SQLException {

        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" SELECT ");
        sqlBuffer.append(" cn.kind_id, ");
        sqlBuffer.append(" cn.contract_number ");
        sqlBuffer.append(" FROM ");
        sqlBuffer.append( "npo_contract_number cn" );
        
        sqlBuffer.append(" WHERE cn.kind_id=? ");
        
        this.setSql(sqlBuffer.toString());

        PreparedStatement ps = null;
        ResultSet rs = null;
        ContractNumberInfo info = null;
        try {
            Connection c = this.getConnection();
            ps = c.prepareStatement(this.getSql());

	        psSetLong(ps, 1, id);
            
            rs = ps.executeQuery();

            while(rs.next()) {
                info = new ContractNumberInfo();
                rsSetInfo(rs, info);
            }
        } finally {
            close(ps, rs);
        }

        return info;
    }
    
    /**
     * <P>Update infomation</P>
     *
     * @param  info  Infomation that need update
     * @return  PreparedStatement#executeUpdate return's value
     * @throws SQLException
     * @throws IOException
     */
    public int update(ContractNumberInfo info) throws SQLException, IOException {

        ArrayList<String> sqlList = new ArrayList<String>();
        ArrayList<Object> prmList = new ArrayList<Object>();

        //Evaluate Null value, create parameter list for SQL Statement.
        makeUpdateList(info, sqlList, prmList);

        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" UPDATE ");
        sqlBuffer.append("npo_contract_number");
        sqlBuffer.append(" SET ");
        sqlBuffer.append("kind_id=?");

        //Result of SQL Statement
        for (int i = 0; i < sqlList.size(); i++) {
            sqlBuffer.append(sqlList.get(i));
        }

        sqlBuffer.append(" WHERE ");
        sqlBuffer.append("kind_id=?");
        this.setSql(sqlBuffer.toString());

        PreparedStatement ps = null;
        int result;

        try {
            Connection c = this.getConnection();
            ps = c.prepareStatement(this.getSql());

            int i = 1;

            psSetLong(ps, i++, info.getKindId());

            for (int j = 0; j < prmList.size(); j++) {
                psSetObject(ps, i++, prmList.get(j));
            }
            psSetLong(ps, i++, info.getKindId());

            result = ps.executeUpdate();
        } finally {
            close(ps);
        }

        return result;
    }
    
    /**
     * <P>Update infomation</P>
     *
     * @param  info  Infomation that need update
     * @return  PreparedStatement#executeUpdate return's value
     * @throws SQLException
     * @throws IOException
     */
    public int reset() throws SQLException, IOException {

        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" UPDATE ");
        sqlBuffer.append("npo_contract_number");
        sqlBuffer.append(" SET ");
        sqlBuffer.append("contract_number=1");

        this.setSql(sqlBuffer.toString());

        PreparedStatement ps = null;
        int result;

        try {
            Connection c = this.getConnection();
            ps = c.prepareStatement(this.getSql());

            result = ps.executeUpdate();
        } finally {
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
    private void rsSetInfo(ResultSet rs,ContractNumberInfo info) throws SQLException {

        info.setKindId(rsGetLong(rs, "kind_id"));
        info.setContractNumber(rsGetLong(rs, "contract_number"));
    }

    
    /**
     * <P>Create parameter</P>
     *
     * @param  info  Update Info
     * @param sqlList  SQL List
     * @param prmList  Parameter List
     */
    private void makeUpdateList(ContractNumberInfo info, ArrayList<String> sqlList,ArrayList<Object> prmList){

        addUpdateList(info.getContractNumber(), ",contract_number=?", sqlList, prmList);
       
    }



}
