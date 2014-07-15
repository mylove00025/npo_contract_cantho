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
public class ContractKindTotalManager extends AbstractManager {

    /** active Flag Filter */
    private Boolean activeFlgFilter;
    
    /** Notary date from filter */
    private Timestamp notaryDateFromFilter;

    /** Notary date to filter */
    private Timestamp notaryDateToFilter;

    /**
     * <P>Generate instance</P>
     * 
     * @param  connection  Connection
     */
    public ContractKindTotalManager(Connection connection) {
        super(connection);
    }

    /**
     * Set active Flag Filter
     * 
     * @param activeFlgFilter     
     */
    public void setActiveFlgFilter(Boolean activeFlgFilter) {
    
        this.activeFlgFilter = activeFlgFilter;
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
     * <P>Total by notary</P>
     * 
     * @return  List of info that geted
     * @throws SQLException
     * @throws IOException
     */
    public ContractKindTotalList selectTotal() throws SQLException, IOException {

        ArrayList<Object> prmList = new ArrayList<Object>();
        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" SELECT ");
        sqlBuffer.append(" nck.id as kindId ");
        sqlBuffer.append(", nck.name as kindName ");
        sqlBuffer.append(", nct.name as templateName ");
        sqlBuffer.append(", number_of_contract ");
        sqlBuffer.append(", number_of_internal_contract ");
        sqlBuffer.append(", number_of_external_contract ");
        sqlBuffer.append(" FROM ");
        sqlBuffer.append(" npo_contract_template nct ");
        
        sqlBuffer.append(" INNER JOIN ");
        sqlBuffer.append(" npo_contract_kind nck ");
        sqlBuffer.append(" ON nct.kind_id = nck.id ");
        
        sqlBuffer.append(" LEFT JOIN ");
        sqlBuffer.append(" ( ");
        sqlBuffer.append(" SELECT contract_template_id, COUNT(*) AS number_of_contract ");
        sqlBuffer.append(" FROM npo_contract ");
        sqlBuffer.append(" WHERE true ");
        
        if (notaryDateFromFilter != null) {
        	sqlBuffer.append(" AND notary_date >= ? ");
        }
        
        if (notaryDateToFilter != null) {
        	sqlBuffer.append(" AND notary_date <= ? ");
        }
        
        sqlBuffer.append(" GROUP BY contract_template_id ");
        sqlBuffer.append(" ) A ");
        sqlBuffer.append(" ON nct.id = A.contract_template_id ");
        
        sqlBuffer.append(" LEFT JOIN ");
        sqlBuffer.append(" ( ");
        sqlBuffer.append(" SELECT contract_template_id, COUNT(*) AS number_of_internal_contract ");
        sqlBuffer.append(" FROM npo_contract ");
        sqlBuffer.append(" WHERE notary_place_flag = 1 ");
        
        if (notaryDateFromFilter != null) {
        	sqlBuffer.append(" AND notary_date >= ? ");
        }
        
        if (notaryDateToFilter != null) {
        	sqlBuffer.append(" AND notary_date <= ? ");
        }
        
        sqlBuffer.append(" GROUP BY contract_template_id ");
        sqlBuffer.append(" ) B ");
        sqlBuffer.append(" ON nct.id = B.contract_template_id ");
        
        sqlBuffer.append(" LEFT JOIN ");
        sqlBuffer.append(" ( ");
        sqlBuffer.append(" SELECT contract_template_id, COUNT(*) AS number_of_external_contract ");
        sqlBuffer.append(" FROM npo_contract ");
        sqlBuffer.append(" WHERE notary_place_flag = 0 ");
        
        if (notaryDateFromFilter != null) {
            sqlBuffer.append(" AND notary_date >= ? ");
        }
        
        if (notaryDateToFilter != null) {
            sqlBuffer.append(" AND notary_date <= ? ");
        }
        
        sqlBuffer.append(" GROUP BY contract_template_id ");
        sqlBuffer.append(" ) C ");
        sqlBuffer.append(" ON nct.id = C.contract_template_id ");
        
        sqlBuffer.append(getBaseSQL(prmList));
        
        //Append order field
        appendOrderField(sqlBuffer);
        
        this.setSql(sqlBuffer.toString());

        PreparedStatement ps = null;
        ResultSet rs = null;
        ContractKindTotalList list = null;
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
            
            if (notaryDateFromFilter != null) {
            	psSetTimestamp(ps, i++, notaryDateFromFilter);
            }
            
            if (notaryDateToFilter != null) {
            	psSetTimestamp(ps, i++, notaryDateToFilter);
            }
            
            if (notaryDateFromFilter != null) {
                psSetTimestamp(ps, i++, notaryDateFromFilter);
            }
            
            if (notaryDateToFilter != null) {
                psSetTimestamp(ps, i++, notaryDateToFilter);
            }
            
            for (int j = 0; j < prmList.size(); j++) {
                psSetObject(ps, i++, prmList.get(j));
            }
            
            rs = ps.executeQuery();

            ContractKindTotalInfo info = null;
            list = new ContractKindTotalList();
            while(rs.next()) {
                info = new ContractKindTotalInfo();
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
     * @param  rs ResultSet
     * @param  info Info instance
     * @throws SQLException
     */
    private void rsSetInfo(ResultSet rs,ContractKindTotalInfo info) throws SQLException {

        info.setKindId(rsGetLong(rs, "kindId"));
        info.setKindName(rsGetString(rs, "kindName"));
        info.setTemplateName(rsGetString(rs, "templateName"));
        info.setNumberOfContract(rsGetLong(rs, "number_of_contract"));
        info.setNumberOfInternalContract(rsGetLong(rs, "number_of_internal_contract"));
        info.setNumberOfExternalContract(rsGetLong(rs, "number_of_external_contract"));
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
        
        /* Set active Flag Filter */        
        if (this.activeFlgFilter != null) {
            appendAnd(filterBuffer);
            filterBuffer.append("nct.active_flg = ?");
            prmList.add(this.activeFlgFilter);
        }
        
        return filterBuffer.toString();
    }
}
