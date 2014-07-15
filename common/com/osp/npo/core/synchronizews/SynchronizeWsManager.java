package com.osp.npo.core.synchronizews;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;


import com.osp.npo.core.AbstractManager;

/**
 * Generate by script
 * Generate date: 02/17/2011 11:55:52 AM
 * @version $Revision$ 
 */
public class SynchronizeWsManager extends AbstractManager {

    private String dataId;
    private String authenticationIdFilter;
    private Byte statusFilter;

    /**
     * <P>Generate instance</P>
     * 
     * @param  connection  Connection
     */
    public SynchronizeWsManager(Connection connection) {
        super(connection);
    }


    /**
     * <P>Add new infomation</P>
     * 
     * @param  info  Infomation that need add
     * @return  PreparedStatement#executeUpdate Return's Value
     * @throws SQLException
     */
    public int insert(SynchronizeWsInfo info) throws SQLException {

        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" INSERT INTO ");
        sqlBuffer.append("npo_synchronize");
        sqlBuffer.append(" ( ");
        sqlBuffer.append("type,");
        sqlBuffer.append("data_id,");
        sqlBuffer.append("authentication_id,");
        sqlBuffer.append("action,");
        sqlBuffer.append("status,");
        sqlBuffer.append("entry_date_time");
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

            int i = 1;
            psSetByte(ps, i++, info.getType());
            psSetString(ps, i++, info.getDataId());
            psSetString(ps, i++, info.getAuthenticationId());
            psSetByte(ps, i++, info.getAction());
            psSetByte(ps, i++, info.getStatus());
            if (info.getEntryDateTime() != null) {
                psSetTimestamp(ps, i++, new Timestamp(info.getEntryDateTime().getTimeInMillis()));
            } else {
                psSetTimestamp(ps, i++, null);
            }

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
    public int delete(String dataId) throws SQLException {

        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" DELETE FROM ");
        sqlBuffer.append(" npo_synchronize ");
        sqlBuffer.append(" WHERE ");
        sqlBuffer.append(" data_id LIKE ? ");

        this.setSql(sqlBuffer.toString());

        PreparedStatement ps = null;
        int result;

        try{
            Connection c = this.getConnection();
            ps = c.prepareStatement(this.getSql());

            psSetString(ps, 1, dataId);

            result = ps.executeUpdate();

        } finally{
            close(ps);
        }

        return result;
    }
    
    /**
     * <P>Delete records by data id</P>
     * 
     * @param  id
     * @return  PreparedStatement#executeUpdate Return's Value
     * @throws SQLException
     */
    public int deleteByDataId(String dataId) throws SQLException {

        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" DELETE FROM ");
        sqlBuffer.append(" npo_synchronize ");
        sqlBuffer.append(" WHERE ");
        sqlBuffer.append(" data_id LIKE ? ");

        this.setSql(sqlBuffer.toString());

        PreparedStatement ps = null;
        int result;

        try{
            Connection c = this.getConnection();
            ps = c.prepareStatement(this.getSql());

            psSetString(ps, 1, dataId);

            result = ps.executeUpdate();

        } finally{
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
    public int delete(String[] dataId) throws SQLException {

        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" DELETE FROM ");
        sqlBuffer.append(" npo_synchronize ");
        sqlBuffer.append(" WHERE ");
        sqlBuffer.append(buildIn("data_id", dataId.length));
        
        this.setSql(sqlBuffer.toString());

        PreparedStatement ps = null;
        int result;

        try{
            Connection c = this.getConnection();
            ps = c.prepareStatement(this.getSql());

            int i = 1;
            for (String id : dataId) {
            	psSetString(ps, i++, id);
            }

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
    public int update(SynchronizeWsInfo info) throws SQLException, IOException {

        ArrayList<String> sqlList = new ArrayList<String>();
        ArrayList<Object> prmList = new ArrayList<Object>();

        //Evaluate Null value, create parameter list for SQL Statement.
        makeUpdateList(info, sqlList, prmList);

        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" UPDATE ");
        sqlBuffer.append("npo_synchronize");
        sqlBuffer.append(" SET ");


        //Result of SQL Statement
        for (int i = 0; i < sqlList.size(); i++) {
            sqlBuffer.append(sqlList.get(i));
        }

        sqlBuffer.append(" WHERE ");
        sqlBuffer.append(" type=? ");
        sqlBuffer.append(" AND data_id=? ");
        sqlBuffer.append(" AND authentication_id=? ");
        sqlBuffer.append(" AND action=? ");

        this.setSql(sqlBuffer.toString());

        PreparedStatement ps = null;
        int result;

        try {
            Connection c = this.getConnection();
            ps = c.prepareStatement(this.getSql());

            int i = 1;

            for (int j = 0; j < prmList.size(); j++) {
                psSetObject(ps, i++, prmList.get(j));
            }

            psSetByte(ps, i++, info.getType());
            psSetString(ps, i++, info.getDataId());
            psSetString(ps, i++, info.getAuthenticationId());
            psSetByte(ps, i++, info.getAction());
            
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
    public int updateErrorStatus() throws SQLException, IOException {

        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" UPDATE ");
        sqlBuffer.append(" npo_synchronize ");
        sqlBuffer.append(" SET ");
        sqlBuffer.append(" status=1 ");
        sqlBuffer.append(" WHERE ");
        sqlBuffer.append(" status=0 ");

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
     * <P>Get all infomation</P>
     * 
     * @param  forUpdate  Use FOR UPDATE (Yes or No)
     * @return  List of info that geted
     * @throws SQLException
     * @throws IOException
     */
    public SynchronizeWsList select(boolean forUpdate, int offset, int limit) throws SQLException, IOException {

        ArrayList<Object> prmList = new ArrayList<Object>();
        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" SELECT ");
        sqlBuffer.append(" * ");
        sqlBuffer.append(" FROM ");
        sqlBuffer.append(" npo_synchronize ns ");
        sqlBuffer.append(getBaseSQL(prmList));
        appendOrderField(sqlBuffer);
        if ((offset >= 0) && (limit >= 0)){
            sqlBuffer.append(" LIMIT ? ");
            sqlBuffer.append(" OFFSET ? ");
        }
        if(forUpdate) {
            sqlBuffer.append(" FOR UPDATE ");
        }
        this.setSql(sqlBuffer.toString());

        PreparedStatement ps = null;
        ResultSet rs = null;
        SynchronizeWsList list = null;
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

            SynchronizeWsInfo info = null;
            list = new SynchronizeWsList();
            while(rs.next()) {
                info = new SynchronizeWsInfo();
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
        sqlBuffer.append("npo_synchronize");

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
    private void rsSetInfo(ResultSet rs,SynchronizeWsInfo info) throws SQLException {

        info.setType(rsGetByte(rs, "type"));
        info.setDataId(rsGetString(rs, "data_id"));
        info.setAuthenticationId(rsGetString(rs, "authentication_id"));
        info.setAction(rsGetByte(rs, "action"));
        info.setStatus(rsGetByte(rs, "status"));        
        if (rsGetTimestamp(rs, "entry_date_time") != null) {
            Calendar cal = Calendar.getInstance();
            cal.setTimeInMillis(rsGetTimestamp(rs, "entry_date_time").getTime());
            info.setEntryDateTime(cal);
        } else {
            info.setEntryDateTime(null);
        }
    }


    /**
     * <P>Create parameter</P>
     * 
     * @param  info  Update Info
     * @param sqlList  SQL List
     * @param prmList  Parameter List
     */
    private void makeUpdateList(SynchronizeWsInfo info, ArrayList<String> sqlList,ArrayList<Object> prmList){

        addUpdateList(info.getType(), "type=?", sqlList, prmList);
        addUpdateList(info.getDataId(), ",data_id=?", sqlList, prmList);
        addUpdateList(info.getAuthenticationId(), ",authentication_id=?", sqlList, prmList);
        addUpdateList(info.getAction(), ",action=?", sqlList, prmList);
        addUpdateList(info.getStatus(), ",status=?", sqlList, prmList);
        if (info.getEntryDateTime() != null) {
            addUpdateList(new Timestamp(info.getEntryDateTime().getTimeInMillis()), ",entry_date_time=?", true, sqlList, prmList);
        } else {
            addUpdateList(null, ",entry_date_time=?", true, sqlList, prmList);
        }
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
        
        if (this.dataId != null){
            appendAnd(filterBuffer);
            filterBuffer.append("ns.data_id LIKE ?");
            prmList.add(this.dataId);
        }
        
        if (this.authenticationIdFilter != null){
            appendAnd(filterBuffer);
            filterBuffer.append("ns.authentication_id LIKE ?");
            prmList.add(this.authenticationIdFilter);
        }
        
        if (this.statusFilter != null){
            appendAnd(filterBuffer);
            filterBuffer.append("ns.status = ?");
            prmList.add(this.statusFilter);
        }
        
        return filterBuffer.toString();
    }

    
    /**
     * Set the dataId
     *
     * @param dataId the dataId to set
     */
    public void setDataId(String dataId) {
        this.dataId = dataId;
    }


    /**
     * Set the authenticationIdFilter
     *
     * @param authenticationIdFilter the authenticationIdFilter to set
     */
    public void setAuthenticationIdFilter(String authenticationIdFilter) {
        this.authenticationIdFilter = authenticationIdFilter;
    }


    /**
     * Set the statusFilter
     *
     * @param statusFilter the statusFilter to set
     */
    public void setStatusFilter(Byte statusFilter) {
        this.statusFilter = statusFilter;
    }
    
}
