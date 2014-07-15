package com.osp.npo.core.prevent;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


import com.mysql.jdbc.Statement;
import com.osp.npo.common.global.Constants;
import com.osp.npo.common.global.Constants.FilterKind;
import com.osp.npo.core.AbstractManager;


/**
 * Generate by script
 * Generate date: 02/17/2011 10:15:26 AM
 */
public class TransactionPropertyManager extends AbstractManager {


    private String typeFilter;
    private String keySearchFilter;
    private List<String> subKeys; 
    private Long contractIdFilter;
    private String contractNumberFilter;
    private String[] contractNameFilter;
    private String relationObjectFilter;
    private Timestamp notaryDateFromFilter;
    private Timestamp notaryDateToFilter;
    private String propertyInfoFilter;
    private String officeCode;
    private Long entryUserIdFilter;
    
    /**
     * <P>Generate instance</P>
     * 
     * @param  connection  Connection
     */
    public TransactionPropertyManager(Connection connection) {
        super(connection);
    }


    /**
     * <P>Add new infomation</P>
     * 
     * @param  info  Infomation that need add
     * @return  PreparedStatement#executeUpdate Return's Value
     * @throws SQLException
     */
    public int insert(TransactionPropertyInfo info) throws SQLException {

        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" INSERT INTO ");
        sqlBuffer.append("npo_transaction_property");
        sqlBuffer.append(" ( ");
        sqlBuffer.append("synchronize_id,");
        sqlBuffer.append("type,");
        sqlBuffer.append("property_info,");
        sqlBuffer.append("transaction_content,");
        sqlBuffer.append("notary_date,");
        sqlBuffer.append("notary_office_name,");
        sqlBuffer.append("contract_id,");
        sqlBuffer.append("contract_number,");
        sqlBuffer.append("contract_name,");
        sqlBuffer.append("contract_value,");
        sqlBuffer.append("relation_object,");
        sqlBuffer.append("notary_person,");
        sqlBuffer.append("notary_place,");
        sqlBuffer.append("notary_fee,");
        sqlBuffer.append("note,");
        sqlBuffer.append("cancel_status,");
        sqlBuffer.append("cancel_description,");
        sqlBuffer.append("entry_user_id,");
        sqlBuffer.append("entry_user_name,");
        sqlBuffer.append("entry_date_time,");
        sqlBuffer.append("update_user_id,");
        sqlBuffer.append("update_user_name,");
        sqlBuffer.append("update_date_time,");
        sqlBuffer.append("land_district,");
        sqlBuffer.append("land_street,");
        sqlBuffer.append("contract_period,");
        sqlBuffer.append("mortage_cancel_flag,");
        sqlBuffer.append("mortage_cancel_date,");
        sqlBuffer.append("mortage_cancel_note,");
        sqlBuffer.append("contract_kind");

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
            psSetString(ps, i++, info.getSynchronizeId());
            psSetString(ps, i++, info.getType());
            psSetString(ps, i++, info.getPropertyInfo());
            psSetString(ps, i++, info.getTransactionContent());
            psSetTimestamp(ps, i++, info.getNotaryDate());
            psSetString(ps, i++, info.getNotaryOfficeName());
            psSetLong(ps, i++, info.getContractId());
            psSetString(ps, i++, info.getContractNumber());
            psSetString(ps, i++, info.getContractName());
            psSetString(ps, i++, info.getContractValue());
            psSetString(ps, i++, info.getRelationObject());
            psSetString(ps, i++, info.getNotaryPerson());
            psSetString(ps, i++, info.getNotaryPlace());
            psSetString(ps, i++, info.getNotaryFee());
            psSetString(ps, i++, info.getNote());
            psSetBoolean(ps, i++, info.getCancelStatus());
            psSetString(ps, i++, info.getCancelDescription());
            psSetLong(ps, i++, info.getEntryUserId());
            psSetString(ps, i++, info.getEntryUserName());
            psSetTimestamp(ps, i++, info.getEntryDateTime());
            psSetLong(ps, i++, info.getUpdateUserId());
            psSetString(ps, i++, info.getUpdateUserName());
            psSetTimestamp(ps, i++, info.getUpdateDateTime());
            psSetString(ps, i++, info.getDistrict());
            psSetString(ps, i++, info.getStreet());
            psSetString(ps, i++, info.getContractPeriod());
            psSetBoolean(ps, i++, info.getMortageCancelFlag());
            psSetString(ps, i++, info.getMortageCancelDate());
            psSetString(ps, i++, info.getMortageCancelNote());
            psSetString(ps, i++, info.getContractKind());

            
            

            result = ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            Integer generatedId = new Integer(rs.getInt(1));
            info.setTpid(new Long(generatedId));
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
    public int delete(Long tpid) throws SQLException {

        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" DELETE FROM ");
        sqlBuffer.append(" npo_transaction_property ");
        sqlBuffer.append(" WHERE ");
        sqlBuffer.append(" tpid = ? ");

        this.setSql(sqlBuffer.toString());

        PreparedStatement ps = null;
        int result;

        try{
            Connection c = this.getConnection();
            ps = c.prepareStatement(this.getSql());

            psSetLong(ps, 1, tpid);

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
    public int update(TransactionPropertyInfo info) throws SQLException, IOException {

        ArrayList<String> sqlList = new ArrayList<String>();
        ArrayList<Object> prmList = new ArrayList<Object>();

        //Evaluate Null value, create parameter list for SQL Statement.
        makeUpdateList(info, sqlList, prmList);

        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" UPDATE ");
        sqlBuffer.append("npo_transaction_property");
        sqlBuffer.append(" SET ");
        sqlBuffer.append("tpid=?");

        //Result of SQL Statement
        for (int i = 0; i < sqlList.size(); i++) {
            sqlBuffer.append(sqlList.get(i));
        }

        sqlBuffer.append(" WHERE ");
        sqlBuffer.append("tpid=?");
        this.setSql(sqlBuffer.toString());

        PreparedStatement ps = null;
        int result;

        try {
            Connection c = this.getConnection();
            ps = c.prepareStatement(this.getSql());

            int i = 1;

            psSetLong(ps, i++, info.getTpid());
            
            for (int j = 0; j < prmList.size(); j++) {
                psSetObject(ps, i++, prmList.get(j));
            }
            psSetLong(ps, i++, info.getTpid());

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
    public TransactionPropertyList select(boolean forUpdate, int offset, int limit) throws SQLException, IOException {

        ArrayList<Object> prmList = new ArrayList<Object>();
        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" SELECT ");
        sqlBuffer.append(" * ");
        sqlBuffer.append(" FROM ");
        sqlBuffer.append(" npo_transaction_property ntp");
        
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
        TransactionPropertyList list = null;
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

            TransactionPropertyInfo info = null;
            list = new TransactionPropertyList();
            while(rs.next()) {
                info = new TransactionPropertyInfo();
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
    public TransactionPropertyList selectForContractList(boolean forUpdate, int offset, int limit) throws SQLException, IOException {

        ArrayList<Object> prmList = new ArrayList<Object>();
        StringBuffer sqlBuffer = new StringBuffer();
        
        sqlBuffer.append(" SELECT ");
        sqlBuffer.append(" ntp.contract_id, ");
        sqlBuffer.append(" ntp.contract_number, ");
        sqlBuffer.append(" ntp.notary_date, ");
        sqlBuffer.append(" ntp.notary_person, ");
        sqlBuffer.append(" ntp.contract_name, ");
        sqlBuffer.append(" ntp.type, ");
        sqlBuffer.append(" ntp.property_info, ");
        sqlBuffer.append(" ntp.transaction_content, ");
        sqlBuffer.append(" ntp.land_street, ");
        sqlBuffer.append(" ntp.land_district, ");
        sqlBuffer.append(" ntp.relation_object, ");
        sqlBuffer.append(" ntp.contract_period, ");
        sqlBuffer.append(" ntp.cancel_description, ");
        sqlBuffer.append(" ntp.mortage_cancel_flag, ");
        sqlBuffer.append(" ntp.mortage_cancel_date, ");
        sqlBuffer.append(" ntp.mortage_cancel_note "); 
        

        sqlBuffer.append(" FROM ");
        sqlBuffer.append(" npo_transaction_property ntp ");
        
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
        TransactionPropertyList list = null;
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

            TransactionPropertyInfo info = null;
            list = new TransactionPropertyList();
            while(rs.next()) {
                info = new TransactionPropertyInfo();
                rsSetInfoForContractList(rs, info);
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
    public TransactionPropertyInfo selectByTpid(Long tpid, boolean forUpdate) throws SQLException {

        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" SELECT ");
        sqlBuffer.append(" * ");
        sqlBuffer.append(" FROM ");
        sqlBuffer.append(" npo_transaction_property ntp ");
        sqlBuffer.append(" WHERE tpid = ? ");
        
        if(forUpdate) {
            sqlBuffer.append(" FOR UPDATE ");
        }
        this.setSql(sqlBuffer.toString());

        PreparedStatement ps = null;
        ResultSet rs = null;
        TransactionPropertyInfo info = null;
        try {
            Connection c = this.getConnection();
            ps = c.prepareStatement(this.getSql());

            psSetLong(ps, 1, tpid);
            
            rs = ps.executeQuery();
            
            while(rs.next()) {
                info = new TransactionPropertyInfo();
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
     * @return  List of info that geted
     * @throws SQLException
     * @throws IOException
     */
    public TransactionPropertyList selectByContract(boolean forUpdate, int offset, int limit) throws SQLException, IOException {

        ArrayList<Object> prmList = new ArrayList<Object>();
        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" SELECT ");
        sqlBuffer.append(" * ");
        sqlBuffer.append(" FROM ");
        sqlBuffer.append(" npo_transaction_property ntp");
        
        sqlBuffer.append(" INNER JOIN ");
        sqlBuffer.append(" npo_contract nc ");
        sqlBuffer.append(" ON ");
        sqlBuffer.append(" ntp.contract_id = nc.id ");
        
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
        TransactionPropertyList list = null;
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

            TransactionPropertyInfo info = null;
            list = new TransactionPropertyList();
            while(rs.next()) {
                info = new TransactionPropertyInfo();
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
    public int countTotal() throws SQLException, IOException {

        ArrayList<Object> prmList = new ArrayList<Object>();
        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" SELECT ");
        sqlBuffer.append(" COUNT(*) ");
        sqlBuffer.append(" FROM ");
        sqlBuffer.append(" npo_transaction_property ntp");
        
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
    private void rsSetInfo(ResultSet rs,TransactionPropertyInfo info) throws SQLException {

        info.setTpid(rsGetLong(rs, "tpid"));
        info.setSynchronizeId(rsGetString(rs, "synchronize_id"));
        info.setType(rsGetString(rs, "type"));
        info.setPropertyInfo(rsGetString(rs, "property_info"));
        info.setTransactionContent(rsGetString(rs, "transaction_content"));
        info.setNotaryDate(rsGetTimestamp(rs, "notary_date"));
        info.setNotaryOfficeName(rsGetString(rs, "notary_office_name"));
        info.setContractId(rsGetLong(rs, "contract_id"));
        info.setContractName(rsGetString(rs, "contract_name"));
        info.setContractNumber(rsGetString(rs, "contract_number"));
        info.setContractValue(rsGetString(rs, "contract_value"));
        info.setRelationObject(rsGetString(rs, "relation_object"));
        info.setNotaryPerson(rsGetString(rs, "notary_person"));
        info.setNotaryPlace(rsGetString(rs, "notary_place"));
        info.setNotaryFee(rsGetString(rs, "notary_fee"));
        info.setNote(rsGetString(rs, "note"));
        info.setCancelStatus(rsGetBoolean(rs, "cancel_status"));
        info.setCancelDescription(rsGetString(rs, "cancel_description"));
        info.setEntryUserId(rsGetLong(rs, "entry_user_id"));
        info.setEntryUserName(rsGetString(rs, "entry_user_name"));
        info.setEntryDateTime(rsGetTimestamp(rs, "entry_date_time"));
        info.setUpdateUserId(rsGetLong(rs, "update_user_id"));
        info.setUpdateUserName(rsGetString(rs, "update_user_name"));
        info.setUpdateDateTime(rsGetTimestamp(rs, "update_date_time"));
        info.setDistrict(rsGetString(rs, "land_district"));
        info.setStreet(rsGetString(rs, "land_street"));
        info.setMortageCancelFlag(rsGetBoolean(rs, "mortage_cancel_flag"));
        info.setMortageCancelDate(rsGetString(rs, "mortage_cancel_date"));
        info.setMortageCancelNote(rsGetString(rs, "mortage_cancel_note"));
        info.setContractPeriod(rsGetString(rs, "contract_period"));
        info.setContractKind(rsGetString(rs, "contract_kind"));
    }
    
    /**
     * <P>Set ResultSet to Info instance </P>
     *
     * @param  rs    ResultSet
     * @param  info  Info instance
     * @throws SQLException
     */
    private void rsSetInfoForContractList(ResultSet rs,TransactionPropertyInfo info) throws SQLException {

        info.setContractId(rsGetLong(rs, "contract_id"));
        info.setContractNumber(rsGetString(rs, "contract_number"));
        info.setNotaryDate(rsGetTimestamp(rs, "notary_date"));
        info.setNotaryPerson(rsGetString(rs, "notary_person"));  
        info.setContractName(rsGetString(rs, "contract_name"));
        info.setContractPeriod(rsGetString(rs, "contract_period"));
        info.setTransactionContent(rsGetString(rs, "transaction_content"));
        info.setType(rsGetString(rs, "type"));
        info.setPropertyInfo(rsGetString(rs, "property_info"));
        info.setDistrict(rsGetString(rs, "land_district"));
        info.setStreet(rsGetString(rs, "land_street"));
        info.setRelationObject(rsGetString(rs, "relation_object"));
        info.setCancelDescription(rsGetString(rs, "cancel_description"));
        info.setMortageCancelFlag(rsGetBoolean(rs, "mortage_cancel_flag"));
        info.setMortageCancelDate(rsGetString(rs, "mortage_cancel_date"));
        info.setMortageCancelNote(rsGetString(rs, "mortage_cancel_note"));
        
    }


    /**
     * <P>Create parameter</P>
     * 
     * @param  info  Update Info
     * @param sqlList  SQL List
     * @param prmList  Parameter List
     */
    private void makeUpdateList(TransactionPropertyInfo info, ArrayList<String> sqlList,ArrayList<Object> prmList){

        addUpdateList(info.getSynchronizeId(), ",synchronize_id=?", sqlList, prmList);
        addUpdateList(info.getType(), ",type=?", sqlList, prmList);
        addUpdateList(info.getPropertyInfo(), ",property_info=?", sqlList, prmList);
        addUpdateList(info.getTransactionContent(), ",transaction_content=?", sqlList, prmList);
        addUpdateList(info.getNotaryDate(), ",notary_date=?", sqlList, prmList);
        addUpdateList(info.getNotaryOfficeName(), ",notary_office_name=?", sqlList, prmList);
        addUpdateList(info.getContractId(), ",contract_id=?", sqlList, prmList);
        addUpdateList(info.getContractName(), ",contract_name=?", sqlList, prmList);
        addUpdateList(info.getContractNumber(), ",contract_number=?", sqlList, prmList);
        addUpdateList(info.getContractValue(), ",contract_value=?", sqlList, prmList);
        addUpdateList(info.getRelationObject(), ",relation_object=?", sqlList, prmList);
        addUpdateList(info.getNotaryPerson(), ",notary_person=?", sqlList, prmList);
        addUpdateList(info.getNotaryPlace(), ",notary_place=?", sqlList, prmList);
        addUpdateList(info.getNotaryFee(), ",notary_fee=?", sqlList, prmList);
        addUpdateList(info.getNote(), ",note=?", sqlList, prmList);
        addUpdateList(info.getCancelStatus(), ",cancel_status=?", sqlList, prmList);
        addUpdateList(info.getCancelDescription(), ",cancel_description=?", sqlList, prmList);
        addUpdateList(info.getEntryUserId(), ",entry_user_id=?", sqlList, prmList);
        addUpdateList(info.getEntryUserName(), ",entry_user_name=?", sqlList, prmList);
        addUpdateList(info.getEntryDateTime(), ",entry_date_time=?", sqlList, prmList);
        addUpdateList(info.getUpdateUserId(), ",update_user_id=?", sqlList, prmList);
        addUpdateList(info.getUpdateUserName(), ",update_user_name=?", sqlList, prmList);
        addUpdateList(info.getUpdateDateTime(), ",update_date_time=?", sqlList, prmList);
        addUpdateList(info.getDistrict(), ",land_district = ?", sqlList, prmList);
        addUpdateList(info.getStreet(), ",land_street=?", sqlList, prmList);
        addUpdateList(info.getMortageCancelFlag(), ",mortage_cancel_flag = ?", sqlList, prmList);
        addUpdateList(info.getMortageCancelDate(), ",mortage_cancel_date=?", sqlList, prmList);
        addUpdateList(info.getMortageCancelNote(), ",mortage_cancel_note=?", sqlList, prmList);
        addUpdateList(info.getContractPeriod(), ",contract_period=?", sqlList, prmList);
        addUpdateList(info.getContractKind(), ",contract_kind=?", sqlList, prmList);
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
        if (this.typeFilter != null) {
            appendAnd(filterBuffer);
            filterBuffer.append(" ntp.type = ? ");
            prmList.add(this.typeFilter);
        }
        
        if (this.contractIdFilter != null) {
            appendAnd(filterBuffer);
            filterBuffer.append(" ntp.contract_id = ? ");
            prmList.add(this.contractIdFilter);
        }
        
        if (this.contractNumberFilter != null) {
            appendAnd(filterBuffer);
            filterBuffer.append(" ntp.contract_number LIKE ? ");
            prmList.add(this.contractNumberFilter);
        }
        
        if (this.contractNameFilter !=  null && this.contractNameFilter.length > 0) {
            appendAnd(filterBuffer);
            filterBuffer.append(buildIn("ntp.contract_name", this.contractNameFilter.length));
            for (int i = 0; i < this.contractNameFilter.length; i++) {
                prmList.add(this.contractNameFilter[i]);
            }
        }
        
        if (this.relationObjectFilter != null) {
            appendAnd(filterBuffer);
            filterBuffer.append(" ntp.relation_object LIKE ? ");
            prmList.add(this.relationObjectFilter);
        }
        
        if (this.notaryDateFromFilter !=  null) {
            appendAnd(filterBuffer);
            filterBuffer.append(" ntp.notary_date >= ? ");
            prmList.add(this.notaryDateFromFilter);
        }

        if (this.notaryDateToFilter !=  null) {
            appendAnd(filterBuffer);
            filterBuffer.append(" ntp.notary_date <= ? ");
            prmList.add(this.notaryDateToFilter);
        }
        
        if (this.propertyInfoFilter !=  null) {
            appendAnd(filterBuffer);
            filterBuffer.append(" ntp.property_info LIKE ? ");
            prmList.add(this.propertyInfoFilter);
        }
        
        if (this.keySearchFilter !=  null) {
            for (int i = 0; i < subKeys.size(); i++) {
                String subkey = subKeys.get(i);
                
                if (Constants.PLUS.equals(subkey)) {
                    appendAnd(filterBuffer);
                    filterBuffer.append(" ( ");
                    if (i == 0) {
                        filterBuffer.append(" ( ");
                    }
                } else if (Constants.SPACE.equals(subkey)) {                        
                    appendOr(filterBuffer);
                    filterBuffer.append(" ( ");
                } else {
                    filterBuffer.append(" MATCH(ntp.property_info, ntp.transaction_content, ntp.contract_number, ntp.contract_name, " +
                    		" ntp.relation_object, ntp.notary_person, ntp.notary_place, ntp.note, ntp.cancel_description) ");
                    filterBuffer.append(" AGAINST(? IN BOOLEAN MODE) ");
                    prmList.add(subkey);
                    
                    if (subkey.charAt(0) == '"') {
                        subkey = subkey.substring(1, subkey.length() - 1);
                    }
                    
                    if (subkey.charAt(subkey.length() - 1) == '"') {
                        subkey = subkey.substring(0, subkey.length() - 2);
                    }
                    
                    appendOr(filterBuffer);
                    filterBuffer.append(" ntp.property_info LIKE ? ");
                    prmList.add(buildFilterString(subkey, FilterKind.MIDDLE.getValue()));
                    
                    appendOr(filterBuffer);
                    filterBuffer.append(" ntp.transaction_content LIKE ? ");
                    prmList.add(buildFilterString(subkey, FilterKind.MIDDLE.getValue()));
                    
                    appendOr(filterBuffer);
                    filterBuffer.append(" ntp.contract_number LIKE ? ");
                    prmList.add(buildFilterString(subkey, FilterKind.MIDDLE.getValue()));
                    
                    appendOr(filterBuffer);
                    filterBuffer.append(" ntp.contract_name LIKE ? ");
                    prmList.add(buildFilterString(subkey, FilterKind.MIDDLE.getValue()));
                    
                    appendOr(filterBuffer);
                    filterBuffer.append(" ntp.relation_object LIKE ? ");
                    prmList.add(buildFilterString(subkey, FilterKind.MIDDLE.getValue()));
                    
                    appendOr(filterBuffer);
                    filterBuffer.append(" ntp.notary_person LIKE ? ");
                    prmList.add(buildFilterString(subkey, FilterKind.MIDDLE.getValue()));
                    
                    appendOr(filterBuffer);
                    filterBuffer.append(" ntp.notary_place LIKE ? ");
                    prmList.add(buildFilterString(subkey, FilterKind.MIDDLE.getValue()));
                    
                    appendOr(filterBuffer);
                    filterBuffer.append(" ntp.note LIKE ? ");
                    prmList.add(buildFilterString(subkey, FilterKind.MIDDLE.getValue()));
                    
                    appendOr(filterBuffer);
                    filterBuffer.append(" ntp.cancel_description LIKE ? ");
                    prmList.add(buildFilterString(subkey, FilterKind.MIDDLE.getValue()));
                    
                    filterBuffer.append(" ) ");
                }
            }
            filterBuffer.append(" ) ");
        }
        
        if (this.officeCode != null && !"".equals(this.officeCode)) {
        	appendAnd(filterBuffer);
            filterBuffer.append(" ntp.synchronize_id LIKE ? ");
            prmList.add(this.officeCode);
        }
        
        if (this.entryUserIdFilter != null) {
            appendAnd(filterBuffer);
            filterBuffer.append(" ntp.entry_user_id = ? ");
            prmList.add(this.entryUserIdFilter);
        }
        
        return filterBuffer.toString();
    }


    /**
     * Get the typeFilter
     *
     * @return the typeFilter
     */
    public String getTypeFilter() {
        return typeFilter;
    }


    /**
     * Set the typeFilter
     *
     * @param typeFilter the typeFilter to set
     */
    public void setTypeFilter(String typeFilter) {
        this.typeFilter = typeFilter;
    }


    /**
     * Set the keySearchFilter
     *
     * @param keySearchFilter the keySearchFilter to set
     */
    public void setKeySearchFilter(String keySearchFilter) {
        this.keySearchFilter = keySearchFilter;
    }

    /**
     * Set the subKeys
     *
     * @param subKeys the subKeys to set
     */
    public void setSubKeys(List<String> subKeys) {
        this.subKeys = subKeys;
    }

    /**
     * Set the contractIdFilter
     *
     * @param contractIdFilter the contractIdFilter to set
     */
    public void setContractIdFilter(Long contractIdFilter) {
        this.contractIdFilter = contractIdFilter;
    }


    /**
     * Set the contractNumberFilter
     *
     * @param contractNumberFilter the contractNumberFilter to set
     */
    public void setContractNumberFilter(String contractNumberFilter, FilterKind kind) {
        this.contractNumberFilter = this.buildFilterString(contractNumberFilter, kind.getValue());
    }


    /**
     * Set the contractNameFilter
     *
     * @param contractNameFilter the contractNameFilter to set
     */
    public void setContractNameFilter(String[] contractNameFilter) {
        this.contractNameFilter = contractNameFilter;
    }


    /**
     * Set the relationObjectFilter
     *
     * @param relationObjectFilter the relationObjectFilter to set
     */
    public void setRelationObjectFilter(String relationObjectFilter, FilterKind kind) {
        this.relationObjectFilter = this.buildFilterString(relationObjectFilter, kind.getValue());
    }


    /**
     * Set the notaryDateFromFilter
     *
     * @param notaryDateFromFilter the notaryDateFromFilter to set
     */
    public void setNotaryDateFromFilter(Timestamp notaryDateFromFilter) {
        this.notaryDateFromFilter = notaryDateFromFilter;
    }


    /**
     * Set the notaryDateToFilter
     *
     * @param notaryDateToFilter the notaryDateToFilter to set
     */
    public void setNotaryDateToFilter(Timestamp notaryDateToFilter) {
        this.notaryDateToFilter = notaryDateToFilter;
    }
    

    /**
     * Set the propertyInfoFilter
     *
     * @param propertyInfoFilter the propertyInfoFilter to set
     */
    public void setPropertyInfoFilter(String propertyInfoFilter, FilterKind kind) {
        this.propertyInfoFilter = this.buildFilterString(propertyInfoFilter, kind.getValue());
    }
   
    /**
	 * Set officeCode
	 * @param officeCode the officeCode to set
	 */
	public void setOfficeCode(String officeCode) {
		this.officeCode = this.buildFilterString(officeCode, FilterKind.LEFT.getValue());
	}


	public void setEntryUserIdFilter(Long entryUserIdFilter) {
		this.entryUserIdFilter = entryUserIdFilter;
	}
}
