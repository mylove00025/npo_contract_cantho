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
public class ContractUserTotalManager extends AbstractManager {

	/** Role filter */
    private String[] roleFilter;
    
    /** active Flag Filter */
    private Boolean activeFlgFilter;
    
    /** hidden Flag Filter */
    private Boolean hiddenFlgFilter; 
    
    /** Notary date from filter */
    private Timestamp notaryDateFromFilter;

    /** Notary date to filter */
    private Timestamp notaryDateToFilter;

    /**
     * <P>Generate instance</P>
     * 
     * @param  connection  Connection
     */
    public ContractUserTotalManager(Connection connection) {
        super(connection);
    }

    /**
     * Set role Filter
     * 
     * @param roleFilter   
     */
    public void setRoleFilter(String[] roleFilter) {
    
        this.roleFilter = roleFilter;
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
     * Set hidden Flag Filter
     * 
     * @param hiddenFlgFilter     
     */
    public void setHiddenFlgFilter(Boolean hiddenFlgFilter) {
    
        this.hiddenFlgFilter = hiddenFlgFilter;
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
    public ContractUserTotalList selectTotalByNotary() throws SQLException, IOException {

        ArrayList<Object> prmList = new ArrayList<Object>();
        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" SELECT ");
        sqlBuffer.append(" nu.id AS usid ");
        sqlBuffer.append(", nu.family_name ");
        sqlBuffer.append(", nu.first_name ");
        sqlBuffer.append(", number_of_contract ");
        sqlBuffer.append(", number_of_error_contract ");
        sqlBuffer.append(" FROM ");
        sqlBuffer.append(" npo_user nu ");
        
        sqlBuffer.append(" LEFT JOIN ");
        sqlBuffer.append(" ( ");
        sqlBuffer.append(" SELECT notary_id, COUNT(*) AS number_of_contract ");
        sqlBuffer.append(" FROM npo_contract ");
        sqlBuffer.append(" WHERE true ");
        
        if (notaryDateFromFilter != null) {
        	sqlBuffer.append(" AND notary_date >= ? ");
        }
        
        if (notaryDateToFilter != null) {
        	sqlBuffer.append(" AND notary_date <= ? ");
        }
        
        sqlBuffer.append(" GROUP BY notary_id ");
        sqlBuffer.append(" ) A ");
        sqlBuffer.append(" ON nu.id = A.notary_id ");
        
        sqlBuffer.append(" LEFT JOIN ");
        sqlBuffer.append(" ( ");
        sqlBuffer.append(" SELECT notary_id, COUNT(*) AS number_of_error_contract ");
        sqlBuffer.append(" FROM npo_contract ");
        sqlBuffer.append(" WHERE error_status = 1 AND notary_id = error_user_id ");
        
        if (notaryDateFromFilter != null) {
        	sqlBuffer.append(" AND notary_date >= ? ");
        }
        
        if (notaryDateToFilter != null) {
        	sqlBuffer.append(" AND notary_date <= ? ");
        }
        
        sqlBuffer.append(" GROUP BY notary_id ");
        sqlBuffer.append(" ) B ");
        sqlBuffer.append(" ON nu.id = B.notary_id ");
        
        sqlBuffer.append(getBaseSQL(prmList));
        
        //Append order field
        appendOrderField(sqlBuffer);
        
        this.setSql(sqlBuffer.toString());

        PreparedStatement ps = null;
        ResultSet rs = null;
        ContractUserTotalList list = null;
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
            
            for (int j = 0; j < prmList.size(); j++) {
                psSetObject(ps, i++, prmList.get(j));
            }
            
            rs = ps.executeQuery();

            ContractUserTotalInfo info = null;
            list = new ContractUserTotalList();
            while(rs.next()) {
                info = new ContractUserTotalInfo();
                rsSetInfo(rs, info);
                list.add(info);
            }
        } finally {
            close(ps, rs);
        }

        return list;
    }
    
    /**
     * <P>Total by drafter</P>
     * 
     * @return  List of info that geted
     * @throws SQLException
     * @throws IOException
     */
    public ContractUserTotalList selectTotalByDrafter() throws SQLException, IOException {

        ArrayList<Object> prmList = new ArrayList<Object>();
        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" SELECT ");
        sqlBuffer.append(" nu.id AS usid ");
        sqlBuffer.append(", nu.family_name ");
        sqlBuffer.append(", nu.first_name ");
        sqlBuffer.append(", number_of_contract ");
        sqlBuffer.append(", number_of_error_contract ");
        sqlBuffer.append(" FROM ");
        sqlBuffer.append(" npo_user nu ");
        
        sqlBuffer.append(" LEFT JOIN ");
        sqlBuffer.append(" ( ");
        sqlBuffer.append(" SELECT drafter_id, COUNT(*) AS number_of_contract ");
        sqlBuffer.append(" FROM npo_contract ");
        sqlBuffer.append(" WHERE true ");
        
        if (notaryDateFromFilter != null) {
        	sqlBuffer.append(" AND notary_date >= ? ");
        }
        
        if (notaryDateToFilter != null) {
        	sqlBuffer.append(" AND notary_date <= ? ");
        }
        
        sqlBuffer.append(" GROUP BY drafter_id ");
        sqlBuffer.append(" ) A ");
        sqlBuffer.append(" ON nu.id = A.drafter_id ");
        
        sqlBuffer.append(" LEFT JOIN ");
        sqlBuffer.append(" ( ");
        sqlBuffer.append(" SELECT drafter_id, COUNT(*) AS number_of_error_contract ");
        sqlBuffer.append(" FROM npo_contract ");
        sqlBuffer.append(" WHERE error_status = 1 AND drafter_id = error_user_id ");
        
        if (notaryDateFromFilter != null) {
        	sqlBuffer.append(" AND notary_date >= ? ");
        }
        
        if (notaryDateToFilter != null) {
        	sqlBuffer.append(" AND notary_date <= ? ");
        }
        
        sqlBuffer.append(" GROUP BY drafter_id ");
        sqlBuffer.append(" ) B ");
        sqlBuffer.append(" ON nu.id = B.drafter_id ");
        
        sqlBuffer.append(getBaseSQL(prmList));
        
        //Append order field
        appendOrderField(sqlBuffer);
        
        this.setSql(sqlBuffer.toString());

        PreparedStatement ps = null;
        ResultSet rs = null;
        ContractUserTotalList list = null;
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
            
            for (int j = 0; j < prmList.size(); j++) {
                psSetObject(ps, i++, prmList.get(j));
            }
            
            rs = ps.executeQuery();

            ContractUserTotalInfo info = null;
            list = new ContractUserTotalList();
            while(rs.next()) {
                info = new ContractUserTotalInfo();
                rsSetInfo(rs, info);
                list.add(info);
            }
        } finally {
            close(ps, rs);
        }

        return list;
    }

    /**
     * <P>Get count record result. </P>
     * 
     * @return  Count of record that geted
     * @throws SQLException
     */
    public int countContract() throws SQLException {

        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" SELECT ");
        sqlBuffer.append(" COUNT(*) ");
        sqlBuffer.append(" FROM ");
        sqlBuffer.append(" npo_contract ");
        sqlBuffer.append(" WHERE true ");
        
        if (notaryDateFromFilter != null) {
        	sqlBuffer.append(" AND notary_date >= ? ");
        }
        
        if (notaryDateToFilter != null) {
        	sqlBuffer.append(" AND notary_date <= ? ");
        }

        this.setSql(sqlBuffer.toString());

        PreparedStatement ps = null;
        ResultSet rs = null;
        int result;
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
            
            rs = ps.executeQuery();
            rs.next();
            result = rs.getInt(1);

        } finally {
            close(ps, rs);
        }

        return result;
    }
    
    /**
     * <P>Get count record result. </P>
     * 
     * @return  Count of record that geted
     * @throws SQLException
     */
    public int countErrorContract() throws SQLException {

        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" SELECT ");
        sqlBuffer.append(" COUNT(*) ");
        sqlBuffer.append(" FROM ");
        sqlBuffer.append(" npo_contract ");
        sqlBuffer.append(" WHERE error_status = 1 ");
        
        if (notaryDateFromFilter != null) {
        	sqlBuffer.append(" AND notary_date >= ? ");
        }
        
        if (notaryDateToFilter != null) {
        	sqlBuffer.append(" AND notary_date <= ? ");
        }

        this.setSql(sqlBuffer.toString());

        PreparedStatement ps = null;
        ResultSet rs = null;
        int result;
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
            
            rs = ps.executeQuery();
            rs.next();
            result = rs.getInt(1);

        } finally {
            close(ps, rs);
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
    private void rsSetInfo(ResultSet rs,ContractUserTotalInfo info) throws SQLException {

        info.setUsid(rsGetLong(rs, "usid"));
        info.setFamilyName(rsGetString(rs, "family_name"));
        info.setFirstName(rsGetString(rs, "first_name"));
        info.setNumberOfContract(rsGetLong(rs, "number_of_contract"));
        info.setNumberOfErrorContract(rsGetLong(rs, "number_of_error_contract"));
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
        
        /* Set role filter */
        if (this.roleFilter != null) {
            appendAnd(filterBuffer);
            filterBuffer.append(buildIn("nu.role", roleFilter.length));
            for (int i = 0; i < roleFilter.length; i++) {
                prmList.add(roleFilter[i]);
            }
        }
        
        /* Set active Flag Filter */        
        if (this.activeFlgFilter != null) {
            appendAnd(filterBuffer);
            filterBuffer.append("nu.active_flg = ?");
            prmList.add(this.activeFlgFilter);
        }
        
        /* Set hidden Flag Filter */
        if (this.hiddenFlgFilter != null) {
            appendAnd(filterBuffer);
            filterBuffer.append("nu.hidden_flg = ?");
            prmList.add(this.hiddenFlgFilter);
        }
        
        return filterBuffer.toString();
    }
}
