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
 * Generate date: 10/28/2010 12:04:18 PM
 */
public class ContractStatisticalManager extends AbstractManager {


    Long notaryId;
    /**
     * <P>Generate instance</P>
     *
     * @param  connection  Connection
     */
    public ContractStatisticalManager(Connection connection) {
        super(connection);
    }


    /**
     * <P>Add new infomation</P>
     *
     * @param  info  Infomation that need add
     * @return  PreparedStatement#executeUpdate Return's Value
     * @throws SQLException
     */
    public int insert(ContractStatisticalInfo info) throws SQLException {

        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" INSERT INTO ");
        sqlBuffer.append("npo_contract_statistical");
        sqlBuffer.append(" ( ");
        sqlBuffer.append("notary_id,");
        sqlBuffer.append("count_in_day,");
        sqlBuffer.append("count_in_week,");
        sqlBuffer.append("count_in_month,");
        sqlBuffer.append("count_in_year,");
        sqlBuffer.append("count_total");
        sqlBuffer.append(" ) ");
        sqlBuffer.append(" VALUES ");
        sqlBuffer.append(" ( ");
        sqlBuffer.append("?,");
        sqlBuffer.append("?,");
        sqlBuffer.append("?,");
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

            psSetLong(ps, 1, info.getNotaryId());
            psSetLong(ps, 2, info.getCountInDay());
            psSetLong(ps, 3, info.getCountInWeek());
            psSetLong(ps, 4, info.getCountInMonth());
            psSetLong(ps, 5, info.getCountInYear());
            psSetLong(ps, 6, info.getCountTotal());

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
    public int delete(Long id) throws SQLException {

        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" DELETE FROM ");
        sqlBuffer.append(" npo_contract_statistical ");
        sqlBuffer.append(" WHERE ");
        sqlBuffer.append(" id = ? ");

        this.setSql(sqlBuffer.toString());

        PreparedStatement ps = null;
        int result;

        try{
            Connection c = this.getConnection();
            ps = c.prepareStatement(this.getSql());

            psSetLong(ps, 1, id);

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
    public int update(ContractStatisticalInfo info) throws SQLException, IOException {

        ArrayList<String> sqlList = new ArrayList<String>();
        ArrayList<Object> prmList = new ArrayList<Object>();

        //Evaluate Null value, create parameter list for SQL Statement.
        makeUpdateList(info, sqlList, prmList);

        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" UPDATE ");
        sqlBuffer.append("npo_contract_statistical");
        sqlBuffer.append(" SET ");
        sqlBuffer.append("notary_id=?");

        //Result of SQL Statement
        for (int i = 0; i < sqlList.size(); i++) {
            sqlBuffer.append(sqlList.get(i));
        }

        sqlBuffer.append(" WHERE ");
        sqlBuffer.append("notary_id=?");
        this.setSql(sqlBuffer.toString());

        PreparedStatement ps = null;
        int result;

        try {
            Connection c = this.getConnection();
            ps = c.prepareStatement(this.getSql());

            int i = 1;

            psSetLong(ps, i++, info.getNotaryId());

            for (int j = 0; j < prmList.size(); j++) {
                psSetObject(ps, i++, prmList.get(j));
            }
            psSetLong(ps, i++, info.getNotaryId());

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
    public ContractStatisticalList select(boolean forUpdate, int offset, int limit) throws SQLException, IOException {

        ArrayList<Object> prmList = new ArrayList<Object>();
        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" SELECT ");

        sqlBuffer.append(" ncs.notary_id, ");
        sqlBuffer.append(" ncs.count_in_day, ");
        sqlBuffer.append(" ncs.count_in_week, ");
        sqlBuffer.append(" ncs.count_in_month, ");
        sqlBuffer.append(" ncs.count_in_year, ");
        sqlBuffer.append(" ncs.count_total, ");
        sqlBuffer.append(" nu.first_name, ");
        sqlBuffer.append(" nu.family_name");

        sqlBuffer.append(" FROM ");
        sqlBuffer.append( "npo_contract_statistical ncs " );
        sqlBuffer.append(" INNER JOIN ");
        sqlBuffer.append(" npo_user nu ");
        sqlBuffer.append(" ON ");
        sqlBuffer.append(" ncs.notary_id = nu.id ");
        sqlBuffer.append(getBaseSQL(prmList));
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
        ContractStatisticalList list = null;
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

            ContractStatisticalInfo info = null;
            list = new ContractStatisticalList();
            while(rs.next()) {
                info = new ContractStatisticalInfo();
                rsSetInfo(rs, info);
                list.add(info);
            }
        } finally {
            close(ps, rs);
        }

        return list;
    }

    /**
     * <P>Total contract</P>
     *
     * @param  forUpdate  Use FOR UPDATE (Yes or No)
     * @return  List of info that geted
     * @throws SQLException
     * @throws IOException
     */
    public ContractStatisticalList selectTotalContract() throws SQLException, IOException {

        String sql = " CALL totalContract(); ";
        this.setSql(sql);

        PreparedStatement ps = null;
        ResultSet rs = null;
        ContractStatisticalList list = null;
        try {
            Connection c = this.getConnection();
            ps = c.prepareStatement(this.getSql());

            rs = ps.executeQuery();

            ContractStatisticalInfo info = null;
            list = new ContractStatisticalList();
            while(rs.next()) {
                info = new ContractStatisticalInfo();
                rsSetInfo(rs, info);
                list.add(info);
            }
        } finally {
            close(ps, rs);
        }

        return list;
    }

    /**
     * <P>Total contract</P>
     *
     * @param  forUpdate  Use FOR UPDATE (Yes or No)
     * @return  List of info that geted
     * @throws SQLException
     * @throws IOException
     */
    public ContractStatisticalList selectTotalContractForDrafter() throws SQLException, IOException {

        String sql = " CALL totalContractForDrafter(); ";
        this.setSql(sql);

        PreparedStatement ps = null;
        ResultSet rs = null;
        ContractStatisticalList list = null;
        try {
            Connection c = this.getConnection();
            ps = c.prepareStatement(this.getSql());

            rs = ps.executeQuery();

            ContractStatisticalInfo info = null;
            list = new ContractStatisticalList();
            while(rs.next()) {
                info = new ContractStatisticalInfo();
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
        sqlBuffer.append(" npo_contract_statistical ncs");

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
    private void rsSetInfo(ResultSet rs,ContractStatisticalInfo info) throws SQLException {

        info.setNotaryId(rsGetLong(rs, "notary_id"));
        info.setCountInDay(rsGetLong(rs, "count_in_day"));
        info.setCountInWeek(rsGetLong(rs, "count_in_week"));
        info.setCountInMonth(rsGetLong(rs, "count_in_month"));
        info.setCountInYear(rsGetLong(rs, "count_in_year"));
        info.setCountTotal(rsGetLong(rs, "count_total"));
        info.setFamilyName(rsGetString(rs, "family_name"));
        info.setFirstName(rsGetString(rs, "first_name"));
    }


    /**
     * <P>Create parameter</P>
     *
     * @param  info  Update Info
     * @param sqlList  SQL List
     * @param prmList  Parameter List
     */
    private void makeUpdateList(ContractStatisticalInfo info, ArrayList<String> sqlList,ArrayList<Object> prmList){

        addUpdateList(info.getCountInDay(), ",count_in_day=?", sqlList, prmList);
        addUpdateList(info.getCountInWeek(), ",count_in_week=?", sqlList, prmList);
        addUpdateList(info.getCountInMonth(), ",count_in_month=?", sqlList, prmList);
        addUpdateList(info.getCountInYear(), ",count_in_year=?", sqlList, prmList);
        addUpdateList(info.getCountTotal(), ",count_total=?", sqlList, prmList);
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
        if (this.notaryId != null) {
            appendAnd(filterBuffer);
            filterBuffer.append(" ncs.notary_id = ? ");
            prmList.add(this.notaryId);
        }
        return filterBuffer.toString();
    }

    public void setNotaryId(Long id) {
        this.notaryId = id;
    }
}
