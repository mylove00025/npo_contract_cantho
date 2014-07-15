package com.osp.npo.core.contract;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import com.mysql.jdbc.Statement;
import com.osp.npo.core.AbstractManager;


/**
 * Generate by script
 * Generate date: 10/28/2010 12:04:18 PM
 */
public class RelationObjectManager extends AbstractManager {


    private Long idFilter;
    
    /**
     * Set Id Filter
     *
     * @param idFilter
     */
    public void setIdFilter(Long idFilter) {

        this.idFilter = idFilter;
    }
    
    /**
     * <P>Generate instance</P>
     * 
     * @param  connection  Connection
     */
    public RelationObjectManager(Connection connection) {
        super(connection);
    }


    /**
     * <P>Add new infomation</P>
     * 
     * @param  info  Infomation that need add
     * @return  PreparedStatement#executeUpdate Return's Value
     * @throws SQLException
     */
    public int insert(RelationObjectInfo info) throws SQLException {

        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" INSERT INTO ");
        sqlBuffer.append("npo_relation_object");
        sqlBuffer.append(" ( ");
        sqlBuffer.append("type,");
        sqlBuffer.append("name,");
        sqlBuffer.append("code,");
        sqlBuffer.append("address,");
        sqlBuffer.append("telephone,");
        sqlBuffer.append("fax,");
        sqlBuffer.append("birthyear,");
        sqlBuffer.append("typical_personal_name,");
        sqlBuffer.append("typical_personal_identity_card,");
        sqlBuffer.append("typical_personal_birthyear,");
        sqlBuffer.append("typical_personal_telephone,");
        sqlBuffer.append("typical_personal_mobile,");
        sqlBuffer.append("typical_personal_fax,");
        sqlBuffer.append("typical_personal_email,");
        sqlBuffer.append("typical_personal_address,");
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
        sqlBuffer.append("?,");
        sqlBuffer.append("?,");
        sqlBuffer.append("?,");
        sqlBuffer.append("?,");
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
            psSetString(ps, i++, info.getType());
            psSetString(ps, i++, info.getName());
            psSetString(ps, i++, info.getCode());
            psSetString(ps, i++, info.getAddress());
            psSetString(ps, i++, info.getTelephone());
            psSetString(ps, i++, info.getFax());
            psSetString(ps, i++, info.getBirthyear());
            psSetString(ps, i++, info.getTypicalPersonalName());
            psSetString(ps, i++, info.getTypicalPersonalIdentityCard());
            psSetString(ps, i++, info.getTypicalPersonalBirthyear());
            psSetString(ps, i++, info.getTypicalPersonalTelephone());
            psSetString(ps, i++, info.getTypicalPersonalMobile());
            psSetString(ps, i++, info.getTypicalPersonalFax());
            psSetString(ps, i++, info.getTypicalPersonalEmail());
            psSetString(ps, i++, info.getTypicalPersonalAddress());
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
        sqlBuffer.append(" npo_relation_object ");
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
    public int update(RelationObjectInfo info) throws SQLException, IOException {

        ArrayList<String> sqlList = new ArrayList<String>();
        ArrayList<Object> prmList = new ArrayList<Object>();

        //Evaluate Null value, create parameter list for SQL Statement.
        makeUpdateList(info, sqlList, prmList);

        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" UPDATE ");
        sqlBuffer.append("npo_relation_object");
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
    public RelationObjectList select(boolean forUpdate, int offset, int limit) throws SQLException, IOException {

        ArrayList<Object> prmList = new ArrayList<Object>();
        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" SELECT ");
        sqlBuffer.append(" * ");
        sqlBuffer.append(" FROM ");
        sqlBuffer.append( "npo_relation_object nro" );
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
        RelationObjectList list = null;
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

            RelationObjectInfo info = null;
            list = new RelationObjectList();
            while(rs.next()) {
                info = new RelationObjectInfo();
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
        sqlBuffer.append("npo_relation_object");

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
    private void rsSetInfo(ResultSet rs,RelationObjectInfo info) throws SQLException {

        info.setId(rsGetLong(rs, "id"));
        info.setType(rsGetString(rs, "type"));
        info.setName(rsGetString(rs, "name"));
        info.setCode(rsGetString(rs, "code"));
        info.setAddress(rsGetString(rs, "address"));
        info.setTelephone(rsGetString(rs, "telephone"));
        info.setFax(rsGetString(rs, "fax"));
        info.setBirthyear(rsGetString(rs, "birthyear"));
        info.setTypicalPersonalName(rsGetString(rs, "typical_personal_name"));
        info.setTypicalPersonalIdentityCard(rsGetString(rs, "typical_personal_identity_card"));
        info.setTypicalPersonalBirthyear(rsGetString(rs, "typical_personal_birthyear"));
        info.setTypicalPersonalTelephone(rsGetString(rs, "typical_personal_telephone"));
        info.setTypicalPersonalMobile(rsGetString(rs, "typical_personal_mobile"));
        info.setTypicalPersonalFax(rsGetString(rs, "typical_personal_fax"));
        info.setTypicalPersonalEmail(rsGetString(rs, "typical_personal_email"));
        info.setTypicalPersonalAddress(rsGetString(rs, "typical_personal_address"));
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
    private void makeUpdateList(RelationObjectInfo info, ArrayList<String> sqlList,ArrayList<Object> prmList){

        addUpdateList(info.getType(), ",type=?", sqlList, prmList);
        addUpdateList(info.getName(), ",name=?", sqlList, prmList);
        addUpdateList(info.getCode(), ",code=?", sqlList, prmList);
        addUpdateList(info.getAddress(), ",address=?", sqlList, prmList);
        addUpdateList(info.getTelephone(), ",telephone=?", sqlList, prmList);
        addUpdateList(info.getFax(), ",fax=?", sqlList, prmList);
        addUpdateList(info.getBirthyear(), ",birthyear=?", sqlList, prmList);
        addUpdateList(info.getTypicalPersonalName(), ",typical_personal_name=?", sqlList, prmList);
        addUpdateList(info.getTypicalPersonalIdentityCard(), ",typical_personal_identity_card=?", sqlList, prmList);
        addUpdateList(info.getTypicalPersonalBirthyear(), ",typical_personal_birthyear=?", sqlList, prmList);
        addUpdateList(info.getTypicalPersonalTelephone(), ",typical_personal_telephone=?", sqlList, prmList);
        addUpdateList(info.getTypicalPersonalMobile(), ",typical_personal_mobile=?", sqlList, prmList);
        addUpdateList(info.getTypicalPersonalFax(), ",typical_personal_fax=?", sqlList, prmList);
        addUpdateList(info.getTypicalPersonalEmail(), ",typical_personal_email=?", sqlList, prmList);
        addUpdateList(info.getTypicalPersonalAddress(), ",typical_personal_address=?", sqlList, prmList);
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
        if (this.idFilter !=  null) {
            appendAnd(filterBuffer);
            filterBuffer.append(" nro.id = ? ");
            prmList.add(this.idFilter);
        }
        return filterBuffer.toString();
    }
}
