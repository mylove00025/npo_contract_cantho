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
public class ContractTemplateManager extends AbstractManager {

    private Long id;
    private String nameFilter;
    private Long contractKindFilter;
    private Boolean activeFlgFilter;
    private Long kindIdFilter;
    

    /**
     * <P>Generate instance</P>
     * 
     * @param  connection  Connection
     */
    public ContractTemplateManager(Connection connection) {
        super(connection);
    }


    /**
     * <P>Add new infomation</P>
     * 
     * @param  info  Infomation that need add
     * @return  PreparedStatement#executeUpdate Return's Value
     * @throws SQLException
     */
    public int insert(ContractTemplateInfo info) throws SQLException {

        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" INSERT INTO ");
        sqlBuffer.append("npo_contract_template");
        sqlBuffer.append(" ( ");
        sqlBuffer.append("name,");
        sqlBuffer.append("kind_id,");
        sqlBuffer.append("code,");
        sqlBuffer.append("relate_object_number,");
        sqlBuffer.append("description,");
        sqlBuffer.append("file_name,");
        sqlBuffer.append("file_path,");
        sqlBuffer.append("active_flg,");
        sqlBuffer.append("entry_user_id,");
        sqlBuffer.append("entry_user_name,");
        sqlBuffer.append("entry_date_time,");
        sqlBuffer.append("update_user_id,");
        sqlBuffer.append("update_user_name,");
        sqlBuffer.append("update_date_time,");
        sqlBuffer.append("relate_object_A_display,");
        sqlBuffer.append("relate_object_B_display,");
        sqlBuffer.append("relate_object_C_display,");
        sqlBuffer.append("mortage_cancel_func,");
        sqlBuffer.append("period_flag,");
        sqlBuffer.append("kind_id_tt08 ");
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
            psSetLong(ps, i++, info.getKindId());
            psSetString(ps, i++, info.getCode());
            psSetInt(ps, i++, info.getRelateObjectNumber());
            psSetString(ps, i++, info.getDescription());
            psSetString(ps, i++, info.getFileName());
            psSetString(ps, i++, info.getFilePath());
            psSetBoolean(ps, i++, info.getActiveFlg());
            psSetLong(ps, i++, info.getEntryUserId());
            psSetString(ps, i++, info.getEntryUserName());
            psSetTimestamp(ps, i++, info.getEntryDateTime());
            psSetLong(ps, i++, info.getUpdateUserId());
            psSetString(ps, i++, info.getUpdateUserName());
            psSetTimestamp(ps, i++, info.getUpdateDateTime());
            psSetString(ps, i++, info.getRelateObjectATitle());
            psSetString(ps, i++, info.getRelateObjectBTitle());
            psSetString(ps, i++, info.getRelateObjectCTitle());
            psSetBoolean(ps, i++, info.getMortageCancelFunc());
            psSetBoolean(ps, i++, info.getPeriodFlag());
            psSetLong(ps, i++, info.getKindIdTT08());

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
        sqlBuffer.append(" npo_contract_template ");
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
    public int update(ContractTemplateInfo info) throws SQLException, IOException {

        ArrayList<String> sqlList = new ArrayList<String>();
        ArrayList<Object> prmList = new ArrayList<Object>();

        //Evaluate Null value, create parameter list for SQL Statement.
        makeUpdateList(info, sqlList, prmList);

        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" UPDATE ");
        sqlBuffer.append("npo_contract_template");
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
    public ContractTemplateList select(boolean forUpdate, int offset, int limit) throws SQLException, IOException {

        ArrayList<Object> prmList = new ArrayList<Object>();
        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" SELECT ");
        sqlBuffer.append(" temp.id, ");
        sqlBuffer.append(" temp.name, ");
        sqlBuffer.append(" temp.kind_id, ");
        sqlBuffer.append(" temp.code, ");
        sqlBuffer.append(" temp.relate_object_number, ");
        sqlBuffer.append(" temp.description, ");
        sqlBuffer.append(" temp.file_name, ");
        sqlBuffer.append(" temp.file_path, ");
        sqlBuffer.append(" temp.active_flg, ");
        sqlBuffer.append(" temp.entry_user_id, ");
        sqlBuffer.append(" temp.entry_user_name, ");
        sqlBuffer.append(" temp.entry_date_time, ");
        sqlBuffer.append(" temp.update_user_id, ");
        sqlBuffer.append(" temp.update_user_name, ");
        sqlBuffer.append(" temp.update_date_time, ");
        sqlBuffer.append(" temp.relate_object_A_display, ");
        sqlBuffer.append(" temp.relate_object_B_display, ");
        sqlBuffer.append(" temp.relate_object_C_display, ");
        sqlBuffer.append(" temp.mortage_cancel_func, ");
        sqlBuffer.append(" temp.period_flag, ");
        sqlBuffer.append(" temp.kind_id_tt08, ");
        sqlBuffer.append(" temp.sync_option, ");
        sqlBuffer.append(" kind.name contract_kind_name ");
        sqlBuffer.append(" FROM ");
        sqlBuffer.append( "npo_contract_template temp" );
        sqlBuffer.append(" INNER JOIN ");
        sqlBuffer.append(" npo_contract_kind kind ");
        sqlBuffer.append(" ON ");
        sqlBuffer.append(" temp.kind_id = kind.id ");
        
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
        ContractTemplateList list = null;
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

            ContractTemplateInfo info = null;
            list = new ContractTemplateList();
            while(rs.next()) {
                info = new ContractTemplateInfo();
                rsSetInfo(rs, info);
                list.add(info);
            }
        } finally {
            close(ps, rs);
        }

        return list;
    }

    
    /**
     * <P>Get record by id</P>
     * 
     * @param  forUpdate  Use FOR UPDATE (Yes or No)
     * @return  List of info that geted
     * @throws SQLException
     */
    public ContractTemplateInfo selectById(Long id, boolean forUpdate) throws SQLException {

        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" SELECT ");
        sqlBuffer.append(" temp.id, ");
        sqlBuffer.append(" temp.name, ");
        sqlBuffer.append(" temp.kind_id, ");
        sqlBuffer.append(" temp.code, ");
        sqlBuffer.append(" temp.relate_object_number, ");
        sqlBuffer.append(" temp.description, ");
        sqlBuffer.append(" temp.file_name, ");
        sqlBuffer.append(" temp.file_path, ");
        sqlBuffer.append(" temp.active_flg, ");
        sqlBuffer.append(" temp.entry_user_id, ");
        sqlBuffer.append(" temp.entry_user_name, ");
        sqlBuffer.append(" temp.entry_date_time, ");
        sqlBuffer.append(" temp.update_user_id, ");
        sqlBuffer.append(" temp.update_user_name, ");
        sqlBuffer.append(" temp.update_date_time, ");
        sqlBuffer.append(" temp.relate_object_A_display, ");
        sqlBuffer.append(" temp.relate_object_B_display, ");
        sqlBuffer.append(" temp.relate_object_C_display, ");
        sqlBuffer.append(" temp.mortage_cancel_func, ");
        sqlBuffer.append(" temp.period_flag, ");
        sqlBuffer.append(" temp.kind_id_tt08, ");
        sqlBuffer.append(" temp.sync_option, ");
        sqlBuffer.append(" kind.name contract_kind_name ");
        sqlBuffer.append(" FROM ");
        sqlBuffer.append( "npo_contract_template temp" );
        sqlBuffer.append(" INNER JOIN ");
        sqlBuffer.append(" npo_contract_kind kind ");
        sqlBuffer.append(" ON ");
        sqlBuffer.append(" temp.kind_id = kind.id ");
        
        sqlBuffer.append(" WHERE temp.id=? ");
        
        if(forUpdate) {
            sqlBuffer.append(" FOR UPDATE ");
        }
        this.setSql(sqlBuffer.toString());

        PreparedStatement ps = null;
        ResultSet rs = null;
        ContractTemplateInfo info = null;
        try {
            Connection c = this.getConnection();
            ps = c.prepareStatement(this.getSql());

	        psSetLong(ps, 1, id);
            
            rs = ps.executeQuery();

            while(rs.next()) {
                info = new ContractTemplateInfo();
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
    public int countTotal() throws SQLException {

        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" SELECT ");
        sqlBuffer.append(" COUNT(*) ");
        sqlBuffer.append(" FROM ");
        sqlBuffer.append("npo_contract_template");

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
    private void rsSetInfo(ResultSet rs, ContractTemplateInfo info) throws SQLException {

        info.setId(rsGetLong(rs, "id"));
        info.setName(rsGetString(rs, "name"));
        info.setKindId(rsGetLong(rs, "kind_id"));
        info.setCode(rsGetString(rs, "code"));
        info.setRelateObjectNumber(rsGetInt(rs, "relate_object_number"));
        info.setDescription(rsGetString(rs, "description"));
        info.setFileName(rsGetString(rs, "file_name"));
        info.setFilePath(rsGetString(rs, "file_path"));
        info.setActiveFlg(rsGetBoolean(rs, "active_flg"));
        info.setEntryUserId(rsGetLong(rs, "entry_user_id"));
        info.setEntryUserName(rsGetString(rs, "entry_user_name"));
        info.setEntryDateTime(rsGetTimestamp(rs, "entry_date_time"));
        info.setUpdateUserId(rsGetLong(rs, "update_user_id"));
        info.setUpdateUserName(rsGetString(rs, "update_user_name"));
        info.setUpdateDateTime(rsGetTimestamp(rs, "update_date_time"));
        info.setContractKindName(rsGetString(rs, "contract_kind_name"));  
        info.setRelateObjectATitle(rsGetString(rs, "relate_object_A_display"));
        info.setRelateObjectBTitle(rsGetString(rs, "relate_object_B_display"));
        info.setRelateObjectCTitle(rsGetString(rs, "relate_object_C_display"));
        info.setMortageCancelFunc(rsGetBoolean(rs, "mortage_cancel_func"));
        info.setPeriodFlag(rsGetBoolean(rs, "period_flag"));
        info.setKindIdTT08(rsGetLong(rs, "kind_id_tt08"));
        info.setSyncOption(rsGetByte(rs, "sync_option"));
    }


    /**
     * <P>Create parameter</P>
     * 
     * @param  info  Update Info
     * @param sqlList  SQL List
     * @param prmList  Parameter List
     */
    private void makeUpdateList(ContractTemplateInfo info, ArrayList<String> sqlList,ArrayList<Object> prmList){

        addUpdateList(info.getName(), ",name=?", sqlList, prmList);
        addUpdateList(info.getKindId(), ",kind_id=?", sqlList, prmList);
        addUpdateList(info.getCode(), ",code=?", sqlList, prmList);
        addUpdateList(info.getRelateObjectNumber(), ",relate_object_number=?", sqlList, prmList);
        addUpdateList(info.getDescription(), ",description=?", sqlList, prmList);
        addUpdateList(info.getFileName(), ",file_name=?", sqlList, prmList);
        addUpdateList(info.getFilePath(), ",file_path=?", sqlList, prmList);
        addUpdateList(info.getActiveFlg(), ",active_flg=?", sqlList, prmList);
        addUpdateList(info.getEntryUserId(), ",entry_user_id=?", sqlList, prmList);
        addUpdateList(info.getEntryUserName(), ",entry_user_name=?", sqlList, prmList);
        addUpdateList(info.getEntryDateTime(), ",entry_date_time=?", sqlList, prmList);
        addUpdateList(info.getUpdateUserId(), ",update_user_id=?", sqlList, prmList);
        addUpdateList(info.getUpdateUserName(), ",update_user_name=?", sqlList, prmList);
        addUpdateList(info.getUpdateDateTime(), ",update_date_time=?", sqlList, prmList);
        addUpdateList(info.getRelateObjectATitle(), ",relate_object_A_display=?", sqlList, prmList);
        addUpdateList(info.getRelateObjectBTitle(), ",relate_object_B_display=?", sqlList, prmList);
        addUpdateList(info.getRelateObjectCTitle(), ",relate_object_C_display=?", sqlList, prmList);
        addUpdateList(info.getMortageCancelFunc(), ",mortage_cancel_func=?", sqlList, prmList);
        addUpdateList(info.getPeriodFlag(), ",period_flag=?", sqlList, prmList);
        addUpdateList(info.getKindIdTT08(), ",kind_id_tt08=?", sqlList, prmList);
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
        
        if (this.nameFilter != null) {
            appendAnd(filterBuffer);
            filterBuffer.append(" temp.name LIKE ? ");
            prmList.add(this.nameFilter);
        }
        
        if (this.contractKindFilter != null) {
            appendAnd(filterBuffer);
            filterBuffer.append(" temp.kind_id = ? ");
            prmList.add(this.contractKindFilter);
        }
        
        if (this.activeFlgFilter != null) {
            appendAnd(filterBuffer);
            filterBuffer.append(" temp.active_flg = ? ");
            prmList.add(this.activeFlgFilter);
        }
        
        if (this.id != null) {
            appendAnd(filterBuffer);
            filterBuffer.append(" temp.id = ? ");
            prmList.add(this.id);
        }
        
        if (this.kindIdFilter != null) {
            appendAnd(filterBuffer);
            filterBuffer.append(" temp.kind_id = ? ");
            prmList.add(this.kindIdFilter);
        }
        
        return filterBuffer.toString();
    }


    /**
     * Get the nameFilter
     *
     * @return the nameFilter
     */
    public String getNameFilter() {
        return nameFilter;
    }


    /**
     * Set the nameFilter
     *
     * @param nameFilter the nameFilter to set
     */
    public void setNameFilter(String nameFilter) {
        this.nameFilter = "%" + nameFilter + "%";
    }


    /**
     * Get the contractKindFilter
     *
     * @return the contractKindFilter
     */
    public Long getContractKindFilter() {
        return contractKindFilter;
    }


    /**
     * Set the contractKindFilter
     *
     * @param contractKindFilter the contractKindFilter to set
     */
    public void setContractKindFilter(Long contractKindFilter) {
        this.contractKindFilter = contractKindFilter;
    }


    /**
     * Get the activeFlgFilter
     *
     * @return the activeFlgFilter
     */
    public Boolean getActiveFlgFilter() {
        return activeFlgFilter;
    }


    /**
     * Set the activeFlgFilter
     *
     * @param activeFlgFilter the activeFlgFilter to set
     */
    public void setActiveFlgFilter(Boolean activeFlgFilter) {
        this.activeFlgFilter = activeFlgFilter;
    }


    /**
     * Get the id
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }


    /**
     * Set the id
     *
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }   
    
    /**
     * Set the kindIdFilter
     *
     * @param kindIdFilter the kindIdFilter to set
     */
    public void setKindIdFilter(Long kindIdFilter) {
        this.kindIdFilter = kindIdFilter;
    }
    
}
