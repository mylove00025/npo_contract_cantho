package com.osp.npo.core.contractTotal;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;


import com.osp.npo.core.AbstractManager;


/**
 * Generate by script
 * Generate date: 12/05/2010 1:52:14 PM
 * @version $Revision: 18438 $
 */
public class ContractBankTotalManager extends AbstractManager {

	/** Notary date from filter */
    private Timestamp notaryDateFromFilter;

    /** Notary date to filter */
    private Timestamp notaryDateToFilter;

    /**
     * <P>Generate instance</P>
     * 
     * @param  connection  Connection
     */
    public ContractBankTotalManager(Connection connection) {
        super(connection);
    }
    

    /**
     * Set notary DateFrom Filter
     *
     * @param notaryDateFromFilter
     */
    public void setNotaryDateFromFilter(Timestamp notaryDateFromFilter) {

        this.notaryDateFromFilter = notaryDateFromFilter;
    }

    /**
     * Set notary DateTo Filter
     *
     * @param notaryDateToFilter
     */
    public void setNotaryDateToFilter(Timestamp notaryDateToFilter) {

        this.notaryDateToFilter = notaryDateToFilter;
    }

    /**
     * <P>Get all infomation</P>
     * 
     * @return  List of info that geted
     * @throws SQLException
     * @throws IOException
     */
    public ContractBankTotalList selectTotal() throws SQLException, IOException {

        ArrayList<Object> prmList = new ArrayList<Object>();
        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" SELECT ");
        sqlBuffer.append(" nb.id AS bank_id ");
        sqlBuffer.append(", nb.name AS bank_name ");
        sqlBuffer.append(", number_of_contract ");
        sqlBuffer.append(" FROM ");
        sqlBuffer.append(" npo_bank nb ");
        
        sqlBuffer.append(" LEFT JOIN ");
        sqlBuffer.append(" ( ");
        sqlBuffer.append(" SELECT bank_id, COUNT(*) AS number_of_contract ");
        sqlBuffer.append(" FROM npo_contract ");
        sqlBuffer.append(" WHERE true ");
        
        if (notaryDateFromFilter != null) {
        	sqlBuffer.append(" AND notary_date >= ? ");
        }
        
        if (notaryDateToFilter != null) {
        	sqlBuffer.append(" AND notary_date <= ? ");
        }
        
        sqlBuffer.append(" GROUP BY bank_id ");
        sqlBuffer.append(" ) A ");
        sqlBuffer.append(" ON nb.id = A.bank_id ");
        
        sqlBuffer.append(getBaseSQL(prmList));
        
        //Append order field
        appendOrderField(sqlBuffer);
        
        this.setSql(sqlBuffer.toString());

        PreparedStatement ps = null;
        ResultSet rs = null;
        ContractBankTotalList list = null;
        try {
            Connection c = this.getConnection();
            ps = c.prepareStatement(this.getSql());

            int i = 1;
          
            //Set notary date filter
            if (notaryDateFromFilter != null) {
            	psSetTimestamp(ps, i++, notaryDateFromFilter);
            }
            
            if (notaryDateToFilter != null) {
            	psSetTimestamp(ps, i++, notaryDateToFilter);
            }
            
            for (int j = 0; j < prmList.size(); j++) {
                psSetObject(ps, i ++, prmList.get(j));
            }
            
            rs = ps.executeQuery();

            ContractBankTotalInfo info = null;
            list = new ContractBankTotalList();
            while(rs.next()) {
                info = new ContractBankTotalInfo();
                rsSetInfo(rs, info);
                list.add(info);
            }
        } finally {
            close(ps, rs);
        }

        return list;
    }
    

    /**
     * <P>Set ResultSet to Info instance </P>
     * 
     * @param  rs    ResultSet
     * @param  info  Info instance
     * @throws SQLException
     */
    private void rsSetInfo(ResultSet rs,ContractBankTotalInfo info) throws SQLException {

        info.setBankId(rsGetLong(rs, "bank_id"));
        info.setBankName(rsGetString(rs, "bank_name"));
        info.setNumberOfContract(rsGetLong(rs, "number_of_contract"));
    }


    /**
     * <P>Base SQL</P>
     * 
     * @param  prmList  ArrayList
     * @throws SQLException
     */
    private StringBuffer getBaseSQL(ArrayList<Object> prmList) throws SQLException {
        StringBuffer sqlBuffer = new StringBuffer();
        String whereString = getWhereFilter(prmList);
        if(whereString.length() > 0) {
            sqlBuffer.append(" WHERE true ");
            sqlBuffer.append(whereString);
        }
        return sqlBuffer;
    }


    /**
     * <P>>Get where sql statement part.</P>
     * 
     * @param  prmList  ArrayList
     * @return where sql statement
     * @throws SQLException
     */
    private String getWhereFilter(ArrayList<Object> prmList) {
        StringBuffer filterBuffer = new StringBuffer();
        //if (this.cidFilter != null) {
        //    appendAnd(filterBuffer);
        //    filterBuffer.append("vog.cid = ?");
        //    prmList.add(this.cidFilter);
        //}
        return filterBuffer.toString();
    }
}
