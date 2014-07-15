package com.osp.npo.core.accessHistory;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;


import com.mysql.jdbc.Statement;
import com.osp.npo.core.AbstractManager;


/**
 * Generate by script
 * Generate date: 06/24/2011 8:55:45 AM
 * @version $Revision$ 
 */
public class AccessHistoryManager extends AbstractManager {


    private Timestamp accessDateFromFilter;
	private Timestamp accessDateToFilter;
	private Long userIdFilter;
	private Byte accessType;

	/**
     * <P>Generate instance</P>
     * 
     * @param  connection  Connection
     */
    public AccessHistoryManager(Connection connection) {
        super(connection);
    }


    /**
     * <P>Add new infomation</P>
     * 
     * @param  info  Infomation that need add
     * @return  PreparedStatement#executeUpdate Return's Value
     * @throws SQLException
     */
    public int insert(AccessHistoryInfo info) throws SQLException {

        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" INSERT INTO ");
        sqlBuffer.append("npo_access_history");
        sqlBuffer.append(" ( ");
        sqlBuffer.append("usid,");
        sqlBuffer.append("execute_person,");
        sqlBuffer.append("client_info,");
        sqlBuffer.append("execute_date_time,");
        sqlBuffer.append("access_type");
        sqlBuffer.append(" ) ");
        sqlBuffer.append(" VALUES ");
        sqlBuffer.append(" ( ");
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
            ps = c.prepareStatement(getSql(), Statement.RETURN_GENERATED_KEYS);

            int i = 1;
            psSetLong(ps, i++, info.getUsid());
            psSetString(ps, i++, info.getExecutePerson());
            psSetString(ps, i++, info.getClientInfo());
            psSetTimestamp(ps, i++, info.getExecuteDateTime());
            psSetByte(ps, i++, info.getAccessType());

            result = ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            Integer generatedId = new Integer(rs.getInt(1));
            info.setHid(new Long(generatedId));
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
        sqlBuffer.append(" npo_access_history ");
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
    public int update(AccessHistoryInfo info) throws SQLException, IOException {

        ArrayList<String> sqlList = new ArrayList<String>();
        ArrayList<Object> prmList = new ArrayList<Object>();

        //Evaluate Null value, create parameter list for SQL Statement.
        makeUpdateList(info, sqlList, prmList);

        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" UPDATE ");
        sqlBuffer.append("npo_access_history");
        sqlBuffer.append(" SET ");
        sqlBuffer.append("hid=?");

        //Result of SQL Statement
        for (int i = 0; i < sqlList.size(); i++) {
            sqlBuffer.append(sqlList.get(i));
        }

        sqlBuffer.append(" WHERE ");
        sqlBuffer.append("hid=?");
        this.setSql(sqlBuffer.toString());

        PreparedStatement ps = null;
        int result;

        try {
            Connection c = this.getConnection();
            ps = c.prepareStatement(this.getSql());

            int i = 1;

            psSetLong(ps, i++, info.getHid());
            
            for (int j = 0; j < prmList.size(); j++) {
                psSetObject(ps, i++, prmList.get(j));
            }
            psSetLong(ps, i++, info.getHid());

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
    public AccessHistoryList select(boolean forUpdate, int offset, int limit) throws SQLException, IOException {

        ArrayList<Object> prmList = new ArrayList<Object>();
        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" SELECT ");
        sqlBuffer.append(" * ");
        sqlBuffer.append(" FROM ");
        sqlBuffer.append( "npo_access_history nah" );
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
        AccessHistoryList list = null;
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

            AccessHistoryInfo info = null;
            list = new AccessHistoryList();
            while(rs.next()) {
                info = new AccessHistoryInfo();
                rsSetInfo(rs, info);
                //set type
                info.setType();
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
        sqlBuffer.append("npo_access_history");

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
     * Get count record result by filter
     *
     * @return Count of record
     * @throws SQLException
     */
    public int countTotalByFilter()
        throws SQLException, IOException {
      
        ArrayList<Object> prmList = new ArrayList<Object>();
        
        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" SELECT ");
        sqlBuffer.append(" COUNT(*) ");
        sqlBuffer.append(" FROM ");
        sqlBuffer.append("npo_access_history nah");
        sqlBuffer.append(getBaseSQL(prmList));

        this.setSql(sqlBuffer.toString());

        PreparedStatement ps = null;
        ResultSet rs = null;
        int result;
        try {
            Connection c = this.getConnection();
            ps = c.prepareStatement(this.getSql());
            
            int i = 1;
            for (int j = 0; j < prmList.size(); j++) {
                psSetObject(ps, i++, prmList.get(j));
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
    private void rsSetInfo(ResultSet rs,AccessHistoryInfo info) throws SQLException {

        info.setHid(rsGetLong(rs, "hid"));
        info.setUsid(rsGetLong(rs, "usid"));
        info.setExecutePerson(rsGetString(rs, "execute_person"));
        info.setClientInfo(rsGetString(rs, "client_info"));
        info.setExecuteDateTime(rsGetTimestamp(rs, "execute_date_time"));
        info.setAccessType(rsGetByte(rs, "access_type"));
    }


    /**
     * <P>Create parameter</P>
     * 
     * @param  info  Update Info
     * @param sqlList  SQL List
     * @param prmList  Parameter List
     */
    private void makeUpdateList(AccessHistoryInfo info, ArrayList<String> sqlList,ArrayList<Object> prmList){

        addUpdateList(info.getUsid(), ",usid=?", sqlList, prmList);
        addUpdateList(info.getExecutePerson(), ",execute_person=?", sqlList, prmList);
        addUpdateList(info.getClientInfo(), ",client_info=?", sqlList, prmList);
        addUpdateList(info.getExecuteDateTime(), ",execute_date_time=?", sqlList, prmList);
        addUpdateList(info.getAccessType(), ",access_type=?", sqlList, prmList);
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
        
        if (this.userIdFilter !=  null) {
            appendAnd(filterBuffer);
            filterBuffer.append(" nah.usid = ? ");
            prmList.add(this.userIdFilter);
        }

        if (this.accessType !=  null) {
            appendAnd(filterBuffer);
            filterBuffer.append(" nah.access_type = ? ");
            prmList.add(this.accessType);
        }

        if (this.accessDateFromFilter !=  null) {
            appendAnd(filterBuffer);
            filterBuffer.append(" nah.execute_date_time >= ? ");
            prmList.add(this.accessDateFromFilter);
        }

        if (this.accessDateToFilter !=  null) {
            appendAnd(filterBuffer);
            filterBuffer.append(" nah.execute_date_time <= ? ");
            prmList.add(this.accessDateToFilter);
        }
       
        return filterBuffer.toString();
    }

    /**
     * Set notary DateFrom Filter
     *
     * @param notaryDateFromFilter
     */
    public void setAccessDateFromFilter(Timestamp accessDateFromFilter) {

        this.accessDateFromFilter = accessDateFromFilter;
    }

    /**
     * Set notary DateTo Filter
     *
     * @param notaryDateToFilter
     */
    public void setAccessDateToFilter(Timestamp accessDateToFilter) {

        this.accessDateToFilter = accessDateToFilter;
    }


	public void setUserIdFilter(long userIdFilter2) {
		
		this.userIdFilter = userIdFilter2;
		
	}
	
   public void setAccessTypeFilter(Byte accessType) {
		
		this.accessType = accessType;
		
	}
	
}
