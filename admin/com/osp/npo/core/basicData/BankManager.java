package com.osp.npo.core.basicData;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import com.mysql.jdbc.Statement;
import com.osp.npo.common.global.Constants.FilterKind;
import com.osp.npo.core.AbstractManager;


/**
 * Generate by script
 * Generate date: 10/28/2010 12:04:18 PM
 * @version $Revision: 29724 $
 */
public class BankManager extends AbstractManager {


    private Long idFilter;
    private Long upperOrderNumberFilter;
    private Long lowerOrderNumberFilter;    
    private String bankNameFilter;
   
    /**
     * Set the bank's Name
     * 
     * @param bankNameFilter
     * @param kind
     */
	public void setBankNameFilter(String bankNameFilter, FilterKind kind) {
		this.bankNameFilter = this.buildFilterString(bankNameFilter, kind.getValue());
	}

	/**
     * Set the idFilter
     *
     * @param idFilter the idFilter to set
     */
    public void setIdFilter(Long idFilter) {
        this.idFilter = idFilter;
    }

    /**
     * Get the upperOrderNumberFilter
     *
     * @return the upperOrderNumberFilter
     */
    public Long getUpperOrderNumberFilter() {
        return upperOrderNumberFilter;
    }

    /**
     * Set the upperOrderNumberFilter
     *
     * @param upperOrderNumberFilter the upperOrderNumberFilter to set
     */
    public void setUpperOrderNumberFilter(Long upperOrderNumberFilter) {
        this.upperOrderNumberFilter = upperOrderNumberFilter;
    }





    /**
     * Get the lowerOrderNumberFilter
     *
     * @return the lowerOrderNumberFilter
     */
    public Long getLowerOrderNumberFilter() {
        return lowerOrderNumberFilter;
    }





    /**
     * Set the lowerOrderNumberFilter
     *
     * @param lowerOrderNumberFilter the lowerOrderNumberFilter to set
     */
    public void setLowerOrderNumberFilter(Long lowerOrderNumberFilter) {
        this.lowerOrderNumberFilter = lowerOrderNumberFilter;
    }





    /**
     * <P>Generate instance</P>
     * 
     * @param  connection  Connection
     */
    public BankManager(Connection connection) {
        super(connection);
    }


    /**
     * <P>Add new infomation</P>
     * 
     * @param  info  Infomation that need add
     * @return  PreparedStatement#executeUpdate Return's Value
     * @throws SQLException
     */
    public int insert(BankInfo info) throws SQLException {

        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" INSERT INTO ");
        sqlBuffer.append("npo_bank");
        sqlBuffer.append(" ( ");
        sqlBuffer.append("name,");
        sqlBuffer.append("order_number,");
        sqlBuffer.append("entry_user_id,");
        sqlBuffer.append("entry_user_name,");
        sqlBuffer.append("entry_date_time,");
        sqlBuffer.append("update_user_id,");
        sqlBuffer.append("update_user_name,");
        sqlBuffer.append("update_date_time");
        sqlBuffer.append(" ) ");
        sqlBuffer.append(" VALUES ");
        sqlBuffer.append(" ( ");
        sqlBuffer.append("?,");
        sqlBuffer.append("?,");
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
            ps = c.prepareStatement(getSql(), Statement.RETURN_GENERATED_KEYS);
            
            int i = 1;
            psSetString(ps, i++, info.getName());
            psSetLong(ps, i++, info.getOrderNumber());
            psSetLong(ps, i++, info.getEntryUserId());
            psSetString(ps, i++, info.getEntryUserName());
            psSetTimestamp(ps, i++, info.getEntryDateTime());
            psSetLong(ps, i++, info.getUpdateUserId());
            psSetString(ps, i++, info.getUpdateUserName());
            psSetTimestamp(ps, i++, info.getUpdateDateTime());

            result = ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            Integer generatedId = new Integer(rs.getInt(1));
            info.setId(new Long(generatedId));
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
        sqlBuffer.append(" npo_bank ");
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
    public int update(BankInfo info) throws SQLException, IOException {

        ArrayList<String> sqlList = new ArrayList<String>();
        ArrayList<Object> prmList = new ArrayList<Object>();

        //Evaluate Null value, create parameter list for SQL Statement.
        makeUpdateList(info, sqlList, prmList);

        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" UPDATE ");
        sqlBuffer.append("npo_bank");
        sqlBuffer.append(" SET ");
        sqlBuffer.append("id=?");

        //Result of SQL Statement
        for (int i = 0; i < sqlList.size(); i++) {
            sqlBuffer.append(sqlList.get(i));
        }

        sqlBuffer.append(" WHERE ");
        sqlBuffer.append("id=?");
        this.setSql(sqlBuffer.toString());

        PreparedStatement ps = null;
        int result;

        try {
            Connection c = this.getConnection();
            ps = c.prepareStatement(this.getSql());

            int i = 1;

            psSetLong(ps, i++, info.getId());
            
            for (int j = 0; j < prmList.size(); j++) {
                psSetObject(ps, i++, prmList.get(j));
            }
            psSetLong(ps, i++, info.getId());

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
    public BankList select(boolean forUpdate, int offset, int limit) throws SQLException, IOException {

        ArrayList<Object> prmList = new ArrayList<Object>();
        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" SELECT ");
        sqlBuffer.append(" * ");
        sqlBuffer.append(" FROM ");
        sqlBuffer.append( "npo_bank nb" );
        
        sqlBuffer.append(getBaseSQL(prmList));
        
        //Append order field
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
        BankList list = null;
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

            BankInfo info = null;
            list = new BankList();
            while(rs.next()) {
                info = new BankInfo();
                rsSetInfo(rs, info);
                list.add(info);
            }
        } finally {
            close(ps, rs);
        }

        return list;
    }
    
    /**
     * <P>Get all infomation</P>
     * 
     * @param  forUpdate  Use FOR UPDATE (Yes or No)
     * @return  List of info that geted
     * @throws SQLException
     * @throws IOException
     */
    public BankInfo getBank(boolean forUpdate) throws SQLException, IOException {

        ArrayList<Object> prmList = new ArrayList<Object>();
        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" SELECT ");
        sqlBuffer.append(" * ");
        sqlBuffer.append(" FROM ");
        sqlBuffer.append( "npo_bank nb" );
        
        sqlBuffer.append(getBaseSQL(prmList));
        
        //Append order field
        appendOrderField(sqlBuffer);
        
        if(forUpdate) {
            sqlBuffer.append(" FOR UPDATE ");
        }
        this.setSql(sqlBuffer.toString());

        PreparedStatement ps = null;
        ResultSet rs = null;
        BankInfo info = null;
        try {
            Connection c = this.getConnection();
            ps = c.prepareStatement(this.getSql());

            int i = 1;
            for (int j = 0; j < prmList.size(); j++) {
                psSetObject(ps, i ++, prmList.get(j));
            }
            
            rs = ps.executeQuery();
            
            if (rs.first()) {
                info = new BankInfo();
                rsSetInfo(rs, info);
            }
            
        } finally {
            close(ps, rs);
        }

        return info;
    }


    /**
     * <P>Get count record result. </P>
     * 
     * @return  Count of record that geted
     * @throws SQLException
     */
    public int countTotal() throws SQLException, IOException {

    	ArrayList<Object> prmList = new ArrayList<Object>();
        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" SELECT ");
        sqlBuffer.append(" COUNT(*) ");
        sqlBuffer.append(" FROM ");
        sqlBuffer.append("npo_bank nb");

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
                psSetObject(ps, i ++, prmList.get(j));
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
     * <P>Get max order number. </P>
     * 
     * @return  Count of record that geted
     * @throws SQLException
     */
    public long getMaxOrderNumber() throws SQLException {

        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" SELECT ");
        sqlBuffer.append(" MAX(order_number) ");
        sqlBuffer.append(" FROM ");
        sqlBuffer.append("npo_bank");

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
     * <P>Get min order number.</P>
     * 
     * @return  Count of record that geted
     * @throws SQLException
     */
    public long getMinOrderNumber() throws SQLException {

        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" SELECT ");
        sqlBuffer.append(" MIN(order_number) ");
        sqlBuffer.append(" FROM ");
        sqlBuffer.append("npo_bank");

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
     * <P>Set ResultSet to Info instance </P>
     * 
     * @param  rs    ResultSet
     * @param  info  Info instance
     * @throws SQLException
     */
    private void rsSetInfo(ResultSet rs,BankInfo info) throws SQLException {

        info.setId(rsGetLong(rs, "id"));
        info.setName(rsGetString(rs, "name"));
        info.setOrderNumber(rsGetLong(rs, "order_number"));
        info.setEntryUserId(rsGetLong(rs, "entry_user_id"));
        info.setEntryUserName(rsGetString(rs, "entry_user_name"));
        info.setEntryDateTime(rsGetTimestamp(rs, "entry_date_time"));
        info.setUpdateUserId(rsGetLong(rs, "update_user_id"));
        info.setUpdateUserName(rsGetString(rs, "update_user_name"));
        info.setUpdateDateTime(rsGetTimestamp(rs, "update_date_time"));
    }


    /**
     * <P>Create parameter</P>
     * 
     * @param  info  Update Info
     * @param sqlList  SQL List
     * @param prmList  Parameter List
     */
    private void makeUpdateList(BankInfo info, ArrayList<String> sqlList,ArrayList<Object> prmList){

        addUpdateList(info.getName(), ",name=?", sqlList, prmList);
        addUpdateList(info.getOrderNumber(), ",order_number=?", sqlList, prmList);
        addUpdateList(info.getEntryUserId(), ",entry_user_id=?", sqlList, prmList);
        addUpdateList(info.getEntryUserName(), ",entry_user_name=?", sqlList, prmList);
        addUpdateList(info.getEntryDateTime(), ",entry_date_time=?", sqlList, prmList);
        addUpdateList(info.getUpdateUserId(), ",update_user_id=?", sqlList, prmList);
        addUpdateList(info.getUpdateUserName(), ",update_user_name=?", sqlList, prmList);
        addUpdateList(info.getUpdateDateTime(), ",update_date_time=?", sqlList, prmList);
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
        
        if (this.idFilter != null) {
            appendAnd(filterBuffer);
            filterBuffer.append("nb.id = ?");
            prmList.add(this.idFilter);
        }
        
        if (this.upperOrderNumberFilter != null) {
            appendAnd(filterBuffer);
            filterBuffer.append("nb.order_number > ?");
            prmList.add(this.upperOrderNumberFilter);
        }
        
        if (this.lowerOrderNumberFilter != null) {
            appendAnd(filterBuffer);
            filterBuffer.append("nb.order_number < ?");
            prmList.add(this.lowerOrderNumberFilter);
        }
        
        if(this.bankNameFilter !=null && this.bankNameFilter.length()>0){
        	appendAnd(filterBuffer);
        	filterBuffer.append("nb.name LIKE ?");
        	prmList.add(this.bankNameFilter);
        }
        	
        
        return filterBuffer.toString();
    }
}
