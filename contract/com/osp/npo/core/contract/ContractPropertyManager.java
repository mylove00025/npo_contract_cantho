package com.osp.npo.core.contract;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import com.osp.npo.core.AbstractManager;


/**
 * Generate by script
 * Generate date: 11/29/2010 10:15:29 AM
 */
public class ContractPropertyManager extends AbstractManager {


    private Long contractIdFilter;
    private Long propertyIdFilter;

    /**
     * Set the contractIdFilter
     *
     * @param contractIdFilter the contractIdFilter to set
     */
    public void setContractIdFilter(Long contractIdFilter) {
        this.contractIdFilter = contractIdFilter;
    }

    /**
     * Set the propertyIdFilter
     *
     * @param propertyIdFilter the propertyIdFilter to set
     */
    public void setPropertyIdFilter(Long propertyIdFilter) {
        this.propertyIdFilter = propertyIdFilter;
    }

    /**
     * <P>Generate instance</P>
     *
     * @param  connection  Connection
     */
    public ContractPropertyManager(Connection connection) {
        super(connection);
    }


    /**
     * <P>Add new infomation</P>
     *
     * @param  info  Infomation that need add
     * @return  PreparedStatement#executeUpdate Return's Value
     * @throws SQLException
     */
    public int insert(ContractPropertyInfo info) throws SQLException {

        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" INSERT INTO ");
        sqlBuffer.append("npo_contract_property");
        sqlBuffer.append(" ( ");
        sqlBuffer.append("contract_id,");
        sqlBuffer.append("property_id");
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

            psSetLong(ps, 1, info.getContractId());
            psSetLong(ps, 2, info.getPropertyId());

            result = ps.executeUpdate();
        } finally {
            close(ps);
        }

        return result;
    }


    /**
     * <P>Delete a record</P>
     *
     * @param  id
     * @return  PreparedStatement#executeUpdate Return's Value
     * @throws SQLException
     */
    public int delete(Long contractId) throws SQLException {

        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" DELETE FROM ");
        sqlBuffer.append(" npo_contract_property ");
        sqlBuffer.append(" WHERE ");
        sqlBuffer.append(" contract_id = ? ");

        this.setSql(sqlBuffer.toString());

        PreparedStatement ps = null;
        int result;

        try{
            Connection c = this.getConnection();
            ps = c.prepareStatement(this.getSql());

            psSetLong(ps, 1, contractId);

            result = ps.executeUpdate();

        } finally{
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
    public int update(ContractPropertyInfo info) throws SQLException, IOException {

        ArrayList<String> sqlList = new ArrayList<String>();
        ArrayList<Object> prmList = new ArrayList<Object>();

        //Evaluate Null value, create parameter list for SQL Statement.
        makeUpdateList(info, sqlList, prmList);

        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" UPDATE ");
        sqlBuffer.append("npo_contract_property");
        sqlBuffer.append(" SET ");
        sqlBuffer.append("contract_id=?");
        sqlBuffer.append(", property_id=?");

        //Result of SQL Statement
        for (int i = 0; i < sqlList.size(); i++) {
            sqlBuffer.append(sqlList.get(i));
        }

        sqlBuffer.append(" WHERE ");
        sqlBuffer.append("contract_id=?");
        sqlBuffer.append(" AND  property_id=?");
        this.setSql(sqlBuffer.toString());

        PreparedStatement ps = null;
        int result;

        try {
            Connection c = this.getConnection();
            ps = c.prepareStatement(this.getSql());

            int i = 1;

            psSetLong(ps, i++, info.getContractId());
            psSetLong(ps, i++, info.getPropertyId());

            for (int j = 0; j < prmList.size(); j++) {
                psSetObject(ps, i++, prmList.get(j));
            }

            psSetLong(ps, i++, info.getContractId());
            psSetLong(ps, i++, info.getPropertyId());

            result = ps.executeUpdate();
        } finally {
            close(ps);
        }

        return result;
    }


    /**
     * <P>Get all infomation</P>
     *
     * @param  forUpdate  Use FOR UPDATE (Yes or No)
     * @return  List of info that geted
     * @throws SQLException
     * @throws IOException
     */
    public ContractPropertyList select(boolean forUpdate, int offset, int limit) throws SQLException, IOException {

        ArrayList<Object> prmList = new ArrayList<Object>();
        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" SELECT ");
        sqlBuffer.append(" cp.contract_id as contract_id, ");
        sqlBuffer.append(" cp.property_id as property_id, ");
        sqlBuffer.append(" nct.name as template_name, ");
        sqlBuffer.append(" nc.notary_date as notary_date, ");
        sqlBuffer.append(" nc.contract_number as contract_number");

        sqlBuffer.append(" FROM ");
        sqlBuffer.append(" npo_contract_property cp" );

        sqlBuffer.append(" INNER JOIN ");
        sqlBuffer.append(" npo_contract nc ");
        sqlBuffer.append(" ON ");
        sqlBuffer.append(" cp.contract_id = nc.id ");

        sqlBuffer.append(" INNER JOIN ");
        sqlBuffer.append(" npo_contract_template nct ");
        sqlBuffer.append(" ON ");
        sqlBuffer.append(" nc.contract_template_id = nct.id ");

        sqlBuffer.append(" INNER JOIN ");
        sqlBuffer.append(" npo_property np ");
        sqlBuffer.append(" ON ");
        sqlBuffer.append(" cp.property_id = np.id ");

        sqlBuffer.append(getBaseSQL(prmList));
        appendOrderField(sqlBuffer);

        if ((offset >= 0) && (limit >= 0)){
            sqlBuffer.append("LIMIT ? ");
            sqlBuffer.append("OFFSET ? ");
        }
        if(forUpdate) {
            sqlBuffer.append(" FOR UPDATE ");
        }
        this.setSql(sqlBuffer.toString());

        PreparedStatement ps = null;
        ResultSet rs = null;
        ContractPropertyList list = null;
        try {
            Connection c = this.getConnection();
            ps = c.prepareStatement(this.getSql());

            int i = 1;
            for (int j = 0; j < prmList.size(); j++) {
                psSetObject(ps, i ++, prmList.get(j));
            }
            if ((offset >= 0) && (limit >= 0)){
                psSetObject(ps, i ++, limit);
                psSetObject(ps, i ++, offset);
            }
            rs = ps.executeQuery();

            ContractPropertyInfo info = null;
            list = new ContractPropertyList();
            while(rs.next()) {
                info = new ContractPropertyInfo();
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
    public int countTotal() throws SQLException {

        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" SELECT ");
        sqlBuffer.append(" COUNT(*) ");
        sqlBuffer.append(" FROM ");
        sqlBuffer.append("npo_contract_property");

        this.setSql(sqlBuffer.toString());

        PreparedStatement ps = null;
        ResultSet rs = null;
        int result;
        try {
            Connection c = this.getConnection();
            ps = c.prepareStatement(this.getSql());

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
    private void rsSetInfo(ResultSet rs,ContractPropertyInfo info) throws SQLException {
        info.setContractId(rsGetLong(rs, "contract_id"));
        info.setPropertyId(rsGetLong(rs, "property_id"));
        info.setContractNumber(rsGetString(rs, "contract_number"));
        info.setNotaryDate(rsGetTimestamp(rs, "notary_date"));
        info.setTemplateName(rsGetString(rs, "template_name"));
    }


    /**
     * <P>Create parameter</P>
     *
     * @param  info  Update Info
     * @param sqlList  SQL List
     * @param prmList  Parameter List
     */
    private void makeUpdateList(ContractPropertyInfo info, ArrayList<String> sqlList,ArrayList<Object> prmList){

        addUpdateList(info.getPropertyId(), ",property_id=?", sqlList, prmList);
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
        if (this.contractIdFilter != null) {
            appendAnd(filterBuffer);
            filterBuffer.append(" cp.contract_id = ? ");
            prmList.add(this.contractIdFilter);
        }

        if (this.propertyIdFilter != null) {
            appendAnd(filterBuffer);
            filterBuffer.append(" cp.property_id = ? ");
            prmList.add(this.propertyIdFilter);
        }
        return filterBuffer.toString();
    }
}
