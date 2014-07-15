package com.osp.npo.core.contract;


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
 */
public class ContractKindManager extends AbstractManager {

    private Long idFilter;

    private Long parentKindIdFilter;

    private Boolean onlyRootFilter;
    
	private String nameFilter;

    /**
     * @param idFilter the idFilter to set
     */
    public void setIdFilter(Long idFilter) {
        this.idFilter = idFilter;
    }
    /**
     * 
     */
    public void setNameFilter(String nameFilter, FilterKind kind) {
        this.nameFilter = this.buildFilterString(nameFilter, kind.getValue());
    }
    
    /**
     * @param parentKindIdFilter the parentKindIdFilter to set
     */
    public void setParentKindIdFilter(Long parentKindIdFilter) {
        this.parentKindIdFilter = parentKindIdFilter;
    }

    /**
     * @param onlyRootFilter the onlyRootFilter to set
     */
    public void setOnlyRootFilter(Boolean onlyRootFilter) {
        this.onlyRootFilter = onlyRootFilter;
    }


    /**
     * <P>Generate instance</P>
     *
     * @param  connection  Connection
     */
    public ContractKindManager(Connection connection) {
        super(connection);
    }


    /**
     * <P>Add new infomation</P>
     *
     * @param  info  Infomation that need add
     * @return  PreparedStatement#executeUpdate Return's Value
     * @throws SQLException
     */
    public int insert(ContractKindInfo info) throws SQLException {

        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" INSERT INTO ");
        sqlBuffer.append("npo_contract_kind");
        sqlBuffer.append(" ( ");
        sqlBuffer.append("name,");
        sqlBuffer.append("parent_kind_id,");
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
            psSetLong(ps, i++, info.getParentKindId());
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
        sqlBuffer.append(" npo_contract_kind ");
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
    public int update(ContractKindInfo info) throws SQLException, IOException {

        ArrayList<String> sqlList = new ArrayList<String>();
        ArrayList<Object> prmList = new ArrayList<Object>();

        //Evaluate Null value, create parameter list for SQL Statement.
        makeUpdateList(info, sqlList, prmList);

        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" UPDATE ");
        sqlBuffer.append("npo_contract_kind");
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
    public ContractKindList select(boolean forUpdate, int offset, int limit) throws SQLException, IOException {

        ArrayList<Object> prmList = new ArrayList<Object>();
        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" SELECT ");
        sqlBuffer.append(" * ");
        sqlBuffer.append(" FROM ");
        sqlBuffer.append( " npo_contract_kind nck " );
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
        ContractKindList list = null;
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

            ContractKindInfo info = null;
            list = new ContractKindList();
            while(rs.next()) {
                info = new ContractKindInfo();
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
     * @return info that geted
     * @throws SQLException
     * @throws IOException
     */
    public ContractKindInfo selectById(Long id, boolean forUpdate) throws SQLException, IOException {

        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" SELECT * ");
        
        sqlBuffer.append(" FROM ");
        sqlBuffer.append(" npo_contract_kind nck ");

        sqlBuffer.append(" WHERE id=? ");

        if (forUpdate) {
            sqlBuffer.append(" FOR UPDATE ");
        }
        this.setSql(sqlBuffer.toString());

        PreparedStatement ps = null;
        ResultSet rs = null;
        ContractKindInfo info = null;
        try {
            Connection c = this.getConnection();
            ps = c.prepareStatement(this.getSql());

            psSetLong(ps, 1, id);

            rs = ps.executeQuery();

            while(rs.next()) {
                info = new ContractKindInfo();
                rsSetInfo(rs, info);
            }
        } finally {
            close(ps, rs);
        }

        return info;
    }
    
    /**
     * <P>Get all infomation</P>
     *
     * @param  forUpdate  Use FOR UPDATE (Yes or No)
     * @return info that geted
     * @throws SQLException
     * @throws IOException
     */
    public ContractKindInfo selectByIdTT08(Long id, boolean forUpdate) throws SQLException, IOException {

        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" SELECT * ");
        
        sqlBuffer.append(" FROM ");
        sqlBuffer.append(" npo_contract_kind_tt08 nck ");

        sqlBuffer.append(" WHERE id=? ");

        if (forUpdate) {
            sqlBuffer.append(" FOR UPDATE ");
        }
        this.setSql(sqlBuffer.toString());

        PreparedStatement ps = null;
        ResultSet rs = null;
        ContractKindInfo info = null;
        try {
            Connection c = this.getConnection();
            ps = c.prepareStatement(this.getSql());

            psSetLong(ps, 1, id);

            rs = ps.executeQuery();

            while(rs.next()) {
                info = new ContractKindInfo();
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
        sqlBuffer.append("npo_contract_kind nck ");

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
     * <P>Set ResultSet to Info instance </P>
     *
     * @param  rs    ResultSet
     * @param  info  Info instance
     * @throws SQLException
     */
    private void rsSetInfo(ResultSet rs,ContractKindInfo info) throws SQLException {

        info.setId(rsGetLong(rs, "id"));
        info.setName(rsGetString(rs, "name"));
        info.setParentKindId(rsGetLong(rs, "parent_kind_id"));
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
    private void makeUpdateList(ContractKindInfo info, ArrayList<String> sqlList,ArrayList<Object> prmList){

        addUpdateList(info.getName(), ",name=?", sqlList, prmList);
        addUpdateList(info.getParentKindId(), ",parent_kind_id=?", true, sqlList, prmList);
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
            filterBuffer.append(" nck.id = ? ");
            prmList.add(this.idFilter);
        }
        if (this.parentKindIdFilter != null) {
            appendAnd(filterBuffer);
            filterBuffer.append(" nck.parent_kind_id = ? ");
            prmList.add(this.parentKindIdFilter);
        }
        if (this.onlyRootFilter == Boolean.TRUE) {
            appendAnd(filterBuffer);
            filterBuffer.append(" nck.parent_kind_id is Null ");
            prmList.add(this.parentKindIdFilter);
        }
        
        if(this.nameFilter !=null && this.nameFilter.length()>0){
        	appendAnd(filterBuffer);
        	filterBuffer.append(" nck.name LIKE ? ");
        	prmList.add(this.nameFilter);
        }       
        return filterBuffer.toString();
    }
}
