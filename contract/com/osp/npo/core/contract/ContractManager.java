package com.osp.npo.core.contract;


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
import com.osp.npo.common.util.SystemMessageProperties;
import com.osp.npo.core.AbstractManager;
import com.osp.npo.core.user.UserInfo;
import com.osp.npo.core.user.UserList;


/**
 * Generate by script
 * Generate date: 10/28/2010 12:04:18 PM
 */
public class ContractManager extends AbstractManager {

public static final String SESSION_KEY = "contractContext";

    private Long contractIdFilter;

    private Long contractKindIdFilter;
    
    private Long[] contractKindIdArrayFilter;

    private String contractNumberFilter;

    private Long contractTemplateIdFilter;

    private String relationObjectFilter;

    private String relationObjectAFilter;

    private String relationObjectBFilter;

    private String relationObjectCFilter;

    private Timestamp notaryDateFilter;

    private Timestamp notaryDateFromFilter;

    private Timestamp notaryDateToFilter;

    private Long bankIdFilter;

    private Boolean notaryPlaceFilter;

    private Long notaryIdFilter;

    private Long drafterIdFilter;

    private Boolean errorStatusFilter;

    private String[] draftUserIdListFilter;

    private String[] notaryUserIdListFilter;

    private String contractSummaryFilter;

    private Boolean additionStatusFilter;

    private Boolean cancellationStatusFilter;

    private String keySearchFilter;

    private List<String> subKeys;

    private String[] banksIdFilter;

    private Boolean isBankIdNullFilter;

    private String propertyInfoFilter;

    private Boolean orderKeySearch = Boolean.TRUE;

    private Boolean drafterIdFlagFilter;
    
    private Boolean templateActiveFlgFilter;


    /**
     * <P>Generate instance</P>
     *
     * @param  connection  Connection
     */
    public ContractManager(Connection connection) {
        super(connection);
    }

    /**
     * <P>Add new infomation</P>
     *
     * @param  info  Infomation that need add
     * @return  PreparedStatement#executeUpdate Return's Value
     * @throws SQLException
     */
    public int insert(ContractInfo info) throws SQLException {

        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" INSERT INTO ");
        sqlBuffer.append("npo_contract");
        sqlBuffer.append(" ( ");
        sqlBuffer.append("contract_template_id,");
        sqlBuffer.append("contract_number,");
        sqlBuffer.append("contract_value,");
        sqlBuffer.append("relation_object_A,");
        sqlBuffer.append("relation_object_B,");
        sqlBuffer.append("relation_object_C,");
        sqlBuffer.append("notary_id,");
        sqlBuffer.append("drafter_id,");
        sqlBuffer.append("received_date,");
        sqlBuffer.append("notary_date,");
        sqlBuffer.append("user_require_contract,");
        sqlBuffer.append("number_copy_of_contract,");
        sqlBuffer.append("number_of_page,");
        sqlBuffer.append("cost_tt91,");
        sqlBuffer.append("cost_draft,");
        sqlBuffer.append("cost_notary_outsite,");
        sqlBuffer.append("cost_other_determine,");
        sqlBuffer.append("cost_total,");
        sqlBuffer.append("notary_place,");
        sqlBuffer.append("notary_place_flag,");
        sqlBuffer.append("bank_id,");
        sqlBuffer.append("bank_service_fee,");
        sqlBuffer.append("crediter_name,");
        sqlBuffer.append("file_name,");
        sqlBuffer.append("file_path,");
        sqlBuffer.append("error_status,");
        sqlBuffer.append("error_user_id,");
        sqlBuffer.append("error_description,");
        sqlBuffer.append("addition_status,");
        sqlBuffer.append("addition_description,");
        sqlBuffer.append("cancel_status,");
        sqlBuffer.append("cancel_description,");
        sqlBuffer.append("cancel_relation_contract_id,");
        sqlBuffer.append("original_store_place,");
        sqlBuffer.append("note,");
        sqlBuffer.append("summary,");
        sqlBuffer.append("entry_user_id,");
        sqlBuffer.append("entry_user_name,");
        sqlBuffer.append("entry_date_time,");
        sqlBuffer.append("update_user_id,");
        sqlBuffer.append("update_user_name,");
        sqlBuffer.append("update_date_time,");
        sqlBuffer.append("contract_period,");
        sqlBuffer.append("mortage_cancel_flag,");
        sqlBuffer.append("mortage_cancel_date,");
        sqlBuffer.append("mortage_cancel_note");
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
            psSetLong(ps, i++, info.getContractTemplateId());
            psSetString(ps, i++, info.getContractNumber());
            psSetString(ps, i++, info.getContractValue());
            psSetString(ps, i++, info.getRelationObjectA());
            psSetString(ps, i++, info.getRelationObjectB());
            psSetString(ps, i++, info.getRelationObjectC());
            psSetLong(ps, i++, info.getNotaryId());
            psSetLong(ps, i++, info.getDrafterId());
            psSetTimestamp(ps, i++, info.getReceivedDate());
            psSetTimestamp(ps, i++, info.getNotaryDate());
            psSetString(ps, i++, info.getUserRequireContract());
            psSetString(ps, i++, info.getNumberCopyOfContract());
            psSetString(ps, i++, info.getNumberOfPage());
            psSetString(ps, i++, info.getCostTt91());
            psSetString(ps, i++, info.getCostDraft());
            psSetString(ps, i++, info.getCostNotaryOutsite());
            psSetString(ps, i++, info.getCostOtherDetermine());
            psSetString(ps, i++, info.getCostTotal());
            psSetString(ps, i++, info.getNotaryPlace());
            psSetBoolean(ps, i++, info.getNotaryPlaceFlag());
            psSetLong(ps, i++, info.getBankId());
            psSetString(ps, i++, info.getBankServiceFee());
            psSetString(ps, i++, info.getCrediterName());
            psSetString(ps, i++, info.getFileName());
            psSetString(ps, i++, info.getFilePath());
            psSetBoolean(ps, i++, info.getErrorStatus());
            psSetLong(ps, i++, info.getErrorUserId());
            psSetString(ps, i++, info.getErrorDescription());
            psSetBoolean(ps, i++, info.getAdditionStatus());
            psSetString(ps, i++, info.getAdditionDescription());
            psSetBoolean(ps, i++, info.getCancelStatus());
            psSetString(ps, i++, info.getCancelDescription());
            psSetLong(ps, i++, info.getCancelRelationContractId());
            psSetString(ps, i++, info.getOriginalStorePlace());
            psSetString(ps, i++, info.getNote());
            psSetString(ps, i++, info.getContractSummary());
            psSetLong(ps, i++, info.getEntryUserId());
            psSetString(ps, i++, info.getEntryUserName());
            psSetTimestamp(ps, i++, info.getEntryDateTime());
            psSetLong(ps, i++, info.getUpdateUserId());
            psSetString(ps, i++, info.getUpdateUserName());
            psSetTimestamp(ps, i++, info.getUpdateDateTime());
            psSetString(ps, i++, info.getContractPeriod());
            psSetBoolean(ps, i++, info.getMortageCancelFlag());
            psSetString(ps, i++, info.getMortageCancelDate());
            psSetString(ps, i++, info.getMortageCancelNote());

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
        sqlBuffer.append(" npo_contract ");
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
    public int update(ContractInfo info) throws SQLException, IOException {

        ArrayList<String> sqlList = new ArrayList<String>();
        ArrayList<Object> prmList = new ArrayList<Object>();

        //Evaluate Null value, create parameter list for SQL Statement.
        makeUpdateList(info, sqlList, prmList);

        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" UPDATE ");
        sqlBuffer.append("npo_contract");
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
    public ContractList select(boolean forUpdate, int offset, int limit) throws SQLException, IOException {

        ArrayList<Object> prmList = new ArrayList<Object>();
        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" SELECT ");
        sqlBuffer.append(" nc.id, ");
        sqlBuffer.append(" nc.contract_number, ");
        sqlBuffer.append(" nct.name as contract_name, ");
        sqlBuffer.append(" nct.relate_object_A_display as relateObjectATitle, ");
        sqlBuffer.append(" nct.relate_object_B_display as relateObjectBTitle, ");
        sqlBuffer.append(" nct.relate_object_C_display as relateObjectCTitle, ");
        sqlBuffer.append(" nc.relation_object_A, ");
        sqlBuffer.append(" nc.relation_object_B, ");
        sqlBuffer.append(" nc.relation_object_C, ");
        sqlBuffer.append(" nc.contract_value, ");
        sqlBuffer.append(" nc.notary_date, ");
        sqlBuffer.append(" nc.received_date, ");
        sqlBuffer.append(" nb.name as bank_name, ");
        sqlBuffer.append(" nb.id as bank_id, ");
        sqlBuffer.append(" nc.notary_place, ");
        sqlBuffer.append(" nc.note, ");
        sqlBuffer.append(" nc.notary_place_flag as notary_place_flag, ");
        sqlBuffer.append(" nu1.family_name as notary_family_name, ");
        sqlBuffer.append(" nu1.first_name as notary_first_name, ");
        sqlBuffer.append(" nu1.id as notary_id, ");
        sqlBuffer.append(" nu1.account as notary_account, ");
        sqlBuffer.append(" nc.bank_service_fee,");
        sqlBuffer.append(" nu2.family_name as drafter_family_name, ");
        sqlBuffer.append(" nu2.first_name as drafter_first_name, ");
        sqlBuffer.append(" nu2.id as drafter_id, ");
        sqlBuffer.append(" nu2.account as drafter_account, ");
        sqlBuffer.append(" nc.error_status, ");
        sqlBuffer.append(" nc.error_description, ");
        sqlBuffer.append(" nc.addition_status, ");
        sqlBuffer.append(" nc.addition_description, ");
        sqlBuffer.append(" nc.cancel_status, ");
        sqlBuffer.append(" nc.summary as contract_sumary, ");
        sqlBuffer.append(" nc.contract_period, ");
        sqlBuffer.append(" nc.mortage_cancel_flag, ");
        sqlBuffer.append(" nc.mortage_cancel_date, ");
        sqlBuffer.append(" nc.mortage_cancel_note, ");
        sqlBuffer.append(" nc.crediter_name, ");
        sqlBuffer.append(" nc.entry_user_id ");
        

        sqlBuffer.append(" FROM ");
        sqlBuffer.append(" npo_contract nc ");

        sqlBuffer.append(" INNER JOIN ");
        sqlBuffer.append(" npo_contract_template nct ");
        sqlBuffer.append(" ON ");
        sqlBuffer.append(" nc.contract_template_id = nct.id ");
        
        sqlBuffer.append(" INNER JOIN ");
        sqlBuffer.append(" npo_user nu1 ");
        sqlBuffer.append(" ON ");
        sqlBuffer.append(" nc.notary_id = nu1.id ");

        sqlBuffer.append(" LEFT JOIN ");
        sqlBuffer.append(" npo_user nu2 ");
        sqlBuffer.append(" ON ");
        sqlBuffer.append(" nc.drafter_id = nu2.id ");

        sqlBuffer.append(" LEFT JOIN ");
        sqlBuffer.append(" npo_bank nb ");
        sqlBuffer.append(" ON ");
        sqlBuffer.append(" nc.bank_id = nb.id ");

        sqlBuffer.append(" INNER JOIN ");
        sqlBuffer.append(" npo_contract_kind nck ");
        sqlBuffer.append(" ON ");
        sqlBuffer.append(" nct.kind_id = nck.id ");

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
        ContractList list = null;
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

            ContractInfo info = null;
            list = new ContractList();
            while(rs.next()) {
                info = new ContractInfo();
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
    public ContractList selectForContractCertify(boolean forUpdate, int offset, int limit) throws SQLException, IOException {

        ArrayList<Object> prmList = new ArrayList<Object>();
        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" SELECT ");
        sqlBuffer.append(" nc.id, ");
        sqlBuffer.append(" nc.contract_number, ");
        sqlBuffer.append(" nct.name as contract_name, ");
        sqlBuffer.append(" nct.relate_object_A_display as relateObjectATitle, ");
        sqlBuffer.append(" nct.relate_object_B_display as relateObjectBTitle, ");
        sqlBuffer.append(" nct.relate_object_C_display as relateObjectCTitle, ");
        sqlBuffer.append(" nc.relation_object_A, ");
        sqlBuffer.append(" nc.relation_object_B, ");
        sqlBuffer.append(" nc.relation_object_C, ");
        sqlBuffer.append(" nc.contract_value, ");
        sqlBuffer.append(" nc.notary_date, ");
        sqlBuffer.append(" nc.received_date, ");
        sqlBuffer.append(" nb.name as bank_name, ");
        sqlBuffer.append(" nb.id as bank_id, ");
        sqlBuffer.append(" nc.notary_place, ");
        sqlBuffer.append(" nc.note, ");
        sqlBuffer.append(" nc.notary_place_flag as notary_place_flag, ");
        sqlBuffer.append(" nu1.family_name as notary_family_name, ");
        sqlBuffer.append(" nu1.first_name as notary_first_name, ");
        sqlBuffer.append(" nu1.id as notary_id, ");
        sqlBuffer.append(" nu1.account as notary_account, ");
        sqlBuffer.append(" nc.bank_service_fee,");
        sqlBuffer.append(" nu2.family_name as drafter_family_name, ");
        sqlBuffer.append(" nu2.first_name as drafter_first_name, ");
        sqlBuffer.append(" nu2.id as drafter_id, ");
        sqlBuffer.append(" nu2.account as drafter_account, ");
        sqlBuffer.append(" nc.error_status, ");
        sqlBuffer.append(" nc.error_description, ");
        sqlBuffer.append(" nc.addition_status, ");
        sqlBuffer.append(" nc.addition_description, ");
        sqlBuffer.append(" nc.cancel_status, ");
        sqlBuffer.append(" nc.summary as contract_sumary, ");
        sqlBuffer.append(" nc.contract_period, ");
        sqlBuffer.append(" nc.mortage_cancel_flag, ");
        sqlBuffer.append(" nc.mortage_cancel_date, ");
        sqlBuffer.append(" nc.mortage_cancel_note, ");
        sqlBuffer.append(" ntp.property_info, ");
        sqlBuffer.append(" ntp.type, ");
        sqlBuffer.append(" ntp.land_district, ");
        sqlBuffer.append(" ntp.land_street ");

        sqlBuffer.append(" FROM ");
        sqlBuffer.append(" npo_contract nc ");

        sqlBuffer.append(" INNER JOIN ");
        sqlBuffer.append(" npo_contract_template nct ");
        sqlBuffer.append(" ON ");
        sqlBuffer.append(" nc.contract_template_id = nct.id ");
        
        sqlBuffer.append(" INNER JOIN ");
        sqlBuffer.append(" npo_user nu1 ");
        sqlBuffer.append(" ON ");
        sqlBuffer.append(" nc.notary_id = nu1.id ");

        sqlBuffer.append(" LEFT JOIN ");
        sqlBuffer.append(" npo_user nu2 ");
        sqlBuffer.append(" ON ");
        sqlBuffer.append(" nc.drafter_id = nu2.id ");

        sqlBuffer.append(" LEFT JOIN ");
        sqlBuffer.append(" npo_bank nb ");
        sqlBuffer.append(" ON ");
        sqlBuffer.append(" nc.bank_id = nb.id ");

        sqlBuffer.append(" INNER JOIN ");
        sqlBuffer.append(" npo_contract_kind nck ");
        sqlBuffer.append(" ON ");
        sqlBuffer.append(" nct.kind_id = nck.id ");

        sqlBuffer.append(" INNER JOIN ");
        sqlBuffer.append(" npo_transaction_property ntp ");
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
        ContractList list = null;
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

            ContractInfo info = null;
            list = new ContractList();
            while(rs.next()) {
                info = new ContractInfo();
                rsSetInfoForContractCertify(rs, info);
                list.add(info);
            }
        } finally {
            close(ps, rs);
        }

        return list;
    }

    
    public ContractList selectAppendixContract(boolean forUpdate) throws SQLException, IOException {

        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" SELECT ");
        sqlBuffer.append(" nc.id, ");
        sqlBuffer.append(" nc.contract_number, ");
        sqlBuffer.append(" nc.contract_template_id, ");
        sqlBuffer.append(" nct.name as contract_template_name, ");
        sqlBuffer.append(" nc.summary ");
        
        sqlBuffer.append(" FROM ");
        sqlBuffer.append(" npo_contract nc ");
        sqlBuffer.append(" INNER JOIN ");
        sqlBuffer.append(" npo_contract_template nct ");
        sqlBuffer.append(" ON ");
        sqlBuffer.append(" nc.contract_template_id = nct.id ");

        sqlBuffer.append(" WHERE nc.id  ");
        sqlBuffer.append(" IN ");
        sqlBuffer.append(" (SELECT npo_contract_appendix.appendix_cid ");
        sqlBuffer.append(" FROM npo_contract_appendix ");

        sqlBuffer.append(" WHERE ");
        sqlBuffer.append(" npo_contract_appendix.main_cid = ?");
        sqlBuffer.append(" ) ");
       
        if(forUpdate) {
            sqlBuffer.append(" FOR UPDATE ");
        }
        this.setSql(sqlBuffer.toString());


        PreparedStatement ps = null;
        ResultSet rs = null;
        ContractList list = null;
        try {
            Connection c = this.getConnection();
            ps = c.prepareStatement(this.getSql());
            psSetLong(ps, 1,contractIdFilter);
            
            rs = ps.executeQuery();
            ContractInfo info = null;
            list = new ContractList();
            while(rs.next()) {
                info = new ContractInfo();
                info.setId(rsGetLong(rs, "id"));
                info.setContractNumber(rsGetString(rs, "contract_number"));
                info.setContractSummary(rsGetString(rs, "summary"));
                info.setContractTemplateName(rsGetString(rs, "contract_template_name"));
                info.setContractTemplateId(rsGetLong(rs, "contract_template_id"));
                list.add(info);
            }
        } finally {
            close(ps, rs);
        }

        return list;
    }
    
    public List<String> selectSuggestRelationObjectA(String query, int offset, int limit) throws SQLException, IOException {

        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" SELECT ");
        sqlBuffer.append(" nc.relation_object_A");

        sqlBuffer.append(" FROM ");
        sqlBuffer.append(" npo_contract nc ");

        // sqlBuffer.append(getBaseSQL(prmList));
        sqlBuffer.append(" WHERE nc.relation_object_A LIKE '%" + query + "%'");
        // appendOrderField(sqlBuffer);

        if ((offset >= 0) && (limit >= 0)){
            sqlBuffer.append(" LIMIT " + limit);
            sqlBuffer.append(" OFFSET " + offset);
        }

        this.setSql(sqlBuffer.toString());

        PreparedStatement ps = null;
        ResultSet rs = null;
        List<String> list = null;
        try {
            Connection c = this.getConnection();
            ps = c.prepareStatement(this.getSql());

            rs = ps.executeQuery();

            list = new ArrayList<String>();
            while(rs.next()) {
                list.add(rsGetString(rs, "relation_object_A"));
            }
        } finally {
            close(ps, rs);
        }

        return list;
    }

    public List<String> selectSuggestRelationObjectB(String query, int offset, int limit) throws SQLException, IOException {

        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" SELECT ");
        sqlBuffer.append(" nc.relation_object_B");

        sqlBuffer.append(" FROM ");
        sqlBuffer.append(" npo_contract nc ");

        // sqlBuffer.append(getBaseSQL(prmList));
        sqlBuffer.append(" WHERE nc.relation_object_B LIKE '%" + query + "%'");
        // appendOrderField(sqlBuffer);

        if ((offset >= 0) && (limit >= 0)){
            sqlBuffer.append(" LIMIT " + limit);
            sqlBuffer.append(" OFFSET " + offset);
        }

        this.setSql(sqlBuffer.toString());

        PreparedStatement ps = null;
        ResultSet rs = null;
        List<String> list = null;
        try {
            Connection c = this.getConnection();
            ps = c.prepareStatement(this.getSql());

            rs = ps.executeQuery();

            list = new ArrayList<String>();
            while(rs.next()) {
                list.add(rsGetString(rs, "relation_object_B"));
            }
        } finally {
            close(ps, rs);
        }

        return list;
    }

    public List<String> selectSuggestRelationObjectC(String query, int offset, int limit) throws SQLException, IOException {

        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" SELECT ");
        sqlBuffer.append(" nc.relation_object_C");

        sqlBuffer.append(" FROM ");
        sqlBuffer.append(" npo_contract nc ");

        // sqlBuffer.append(getBaseSQL(prmList));
        sqlBuffer.append(" WHERE nc.relation_object_C LIKE '%" + query + "%'");
        // appendOrderField(sqlBuffer);

        if ((offset >= 0) && (limit >= 0)){
            sqlBuffer.append(" LIMIT " + limit);
            sqlBuffer.append(" OFFSET " + offset);
        }

        this.setSql(sqlBuffer.toString());

        PreparedStatement ps = null;
        ResultSet rs = null;
        List<String> list = null;
        try {
            Connection c = this.getConnection();
            ps = c.prepareStatement(this.getSql());

            rs = ps.executeQuery();

            list = new ArrayList<String>();
            while(rs.next()) {
                list.add(rsGetString(rs, "relation_object_C"));
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
    @SuppressWarnings("unchecked")
	public ContractKindListForNotary selectUserReport(ContractKindListForNotary contractKindListForNotary, boolean forUpdate) throws SQLException, IOException {

        ArrayList<Object> prmList = new ArrayList<Object>();
        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" SELECT ");
        sqlBuffer.append(" nck.name, ");
        sqlBuffer.append(" nck.id, ");
        sqlBuffer.append(" nc.notary_id, ");
        sqlBuffer.append(" nu1.first_name as notary_first_name, ");
        sqlBuffer.append(" COUNT(*) as count ");
       
        sqlBuffer.append(" FROM ");
        sqlBuffer.append(" npo_contract nc ");

        sqlBuffer.append(" INNER JOIN ");
        sqlBuffer.append(" npo_contract_template nct ");
        sqlBuffer.append(" ON ");
        sqlBuffer.append(" nc.contract_template_id = nct.id ");
        
        sqlBuffer.append(" INNER JOIN ");
        sqlBuffer.append(" npo_user nu1 ");
        sqlBuffer.append(" ON ");
        sqlBuffer.append(" nc.notary_id = nu1.id ");

        sqlBuffer.append(" INNER JOIN ");
        sqlBuffer.append(" npo_contract_kind nck ");
        sqlBuffer.append(" ON ");
        sqlBuffer.append(" nct.kind_id = nck.id ");

        sqlBuffer.append(getBaseSQL(prmList));
        sqlBuffer.append(" GROUP BY nck.id, nc.notary_id ");
        sqlBuffer.append(" ORDER BY nck.id, nc.notary_id ");
        


  
        if(forUpdate) {
            sqlBuffer.append(" FOR UPDATE ");
        }
        this.setSql(sqlBuffer.toString());


        PreparedStatement ps = null;
        ResultSet rs = null;
        ContractKindListForNotary list = contractKindListForNotary;
        try {
            Connection c = this.getConnection();
            ps = c.prepareStatement(this.getSql());

            int i = 1;
            for (int j = 0; j < prmList.size(); j++) {
                psSetObject(ps, i ++, prmList.get(j));
            }
           
            rs = ps.executeQuery();

            ContractKindForNotaryInfo info = null;
            Boolean checkExist;
            while(rs.next()) {
            	checkExist = false;
            	for (int j = 0; j < list.size(); j++) 
	            	if (list.get(j).getId().equals(rsGetLong(rs, "id"))){
	            		UserInfo userInfo = new UserInfo();
	            		userInfo.setFirstName(rsGetString(rs, "notary_first_name").toUpperCase());
	            		userInfo.setId(rsGetLong(rs,"notary_id"));
	            		userInfo.setCount(rsGetLong(rs, "count"));
	            		list.get(j).getUserList().add(userInfo);
						checkExist = true;
						break;
					}
            	if (!checkExist){
	                info = new ContractKindForNotaryInfo();
	                info.setUserList((new UserList()).getList());
	                info.setId(rsGetLong(rs, "id"));
	                info.setName(rsGetString(rs, "name"));
	                UserInfo userInfo = new UserInfo();
	                userInfo.setId(rsGetLong(rs,"notary_id"));
	        		userInfo.setCount(rsGetLong(rs, "count"));
	        		info.getUserList().add(userInfo);
	                list.add(info);
            	}
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
 
	public ContractKindListForNotary selectNotaryPlace(ContractKindListForNotary contractKindListForNotary, boolean forUpdate) throws SQLException, IOException {

        ArrayList<Object> prmList = new ArrayList<Object>();
        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" SELECT ");
        sqlBuffer.append(" nc.notary_id, ");
        sqlBuffer.append(" COUNT(*) as count ");
       
        sqlBuffer.append(" FROM ");
        sqlBuffer.append(" npo_contract nc ");

        sqlBuffer.append(getBaseSQL(prmList));
        sqlBuffer.append(" GROUP BY nc.notary_id ");
        sqlBuffer.append(" ORDER BY nc.notary_id ");
        
  
        if(forUpdate) {
            sqlBuffer.append(" FOR UPDATE ");
        }
        this.setSql(sqlBuffer.toString());


        PreparedStatement ps = null;
        ResultSet rs = null;
        ContractKindListForNotary list = contractKindListForNotary;
        try {
            Connection c = this.getConnection();
            ps = c.prepareStatement(this.getSql());

            int i = 1;
            for (int j = 0; j < prmList.size(); j++) {
                psSetObject(ps, i ++, prmList.get(j));
            }
           
            rs = ps.executeQuery();

            while(rs.next()) {
            	for (int j = 0; j < contractKindListForNotary.getTotalUser(); j++) {
					if (contractKindListForNotary.getUserList().get(j).getId().equals(rsGetLong(rs,"notary_id" ))){
						contractKindListForNotary.getUserList().get(j).setCount(rsGetLong(rs, "count"));
					}
				}
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
    public ContractInfo selectById(boolean forUpdate) throws SQLException, IOException {

        ArrayList<Object> prmList = new ArrayList<Object>();
        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" SELECT ");
        sqlBuffer.append(" nc.id,");
        sqlBuffer.append(" nc.contract_template_id,");
        sqlBuffer.append(" nct.name as contract_template_name,");
        sqlBuffer.append(" nct.code as contract_template_code,");
        sqlBuffer.append(" nct.relate_object_A_display as relateObjectATitle,");
        sqlBuffer.append(" nct.relate_object_B_display as relateObjectBTitle,");
        sqlBuffer.append(" nct.relate_object_C_display as relateObjectCTitle,");
        sqlBuffer.append(" nct.relate_object_number,");
        sqlBuffer.append(" nc.contract_number,");
        sqlBuffer.append(" nc.relation_object_A,");
        sqlBuffer.append(" nc.relation_object_B,");
        sqlBuffer.append(" nc.relation_object_C,");
        sqlBuffer.append(" nc.contract_value,");
        sqlBuffer.append(" nc.notary_id,");
        sqlBuffer.append(" nc.drafter_id,");
        sqlBuffer.append(" nc.notary_date,");
        sqlBuffer.append(" nc.user_require_contract, ");
        sqlBuffer.append(" nc.number_copy_of_contract, ");
        sqlBuffer.append(" nc.number_of_page, ");
        sqlBuffer.append(" nc.received_date,");
        sqlBuffer.append(" nc.notary_place,");
        sqlBuffer.append(" nc.notary_place_flag,");
        sqlBuffer.append(" nc.summary,");
        sqlBuffer.append(" nc.cost_tt91,");
        sqlBuffer.append(" nc.cost_draft,");
        sqlBuffer.append(" nc.cost_notary_outsite,");
        sqlBuffer.append(" nc.cost_other_determine,");
        sqlBuffer.append(" nc.cost_total,");
        sqlBuffer.append(" nc.bank_id,");
        sqlBuffer.append(" nc.note as contract_note,");
        sqlBuffer.append(" nb.name as bank_name,");
        sqlBuffer.append(" nc.bank_service_fee,");
        sqlBuffer.append(" nc.crediter_name,");
        sqlBuffer.append(" nc.file_name,");
        sqlBuffer.append(" nc.file_path,");
        sqlBuffer.append(" nc.error_status,");
        sqlBuffer.append(" nc.error_user_id,");
        sqlBuffer.append(" nc.error_description,");
        sqlBuffer.append(" nc.addition_status,");
        sqlBuffer.append(" nc.addition_description,");
        sqlBuffer.append(" nc.cancel_status,");
        sqlBuffer.append(" nc.cancel_description,");
        sqlBuffer.append(" nc.cancel_relation_contract_id,");
        sqlBuffer.append(" nc.original_store_place,");
        sqlBuffer.append(" nc.entry_user_id,");
        sqlBuffer.append(" nc.entry_user_name,");
        sqlBuffer.append(" nc.entry_date_time,");
        sqlBuffer.append(" nc.update_user_name,");
        sqlBuffer.append(" nc.update_date_time,");
        sqlBuffer.append(" nc.contract_period,");
        sqlBuffer.append(" nc.mortage_cancel_flag,");
        sqlBuffer.append(" nc.mortage_cancel_date,");
        sqlBuffer.append(" nc.mortage_cancel_note,");
        sqlBuffer.append(" nu1.family_name as notary_family_name,");
        sqlBuffer.append(" nu1.first_name as notary_first_name,");
        sqlBuffer.append(" nu2.family_name as drafter_family_name,");
        sqlBuffer.append(" nu2.first_name as drafter_first_name,");
        sqlBuffer.append(" nu3.family_name as error_user_family_name,");
        sqlBuffer.append(" nu3.first_name as error_user_first_name,");
        sqlBuffer.append(" nck.id as contract_kind_id,");
        sqlBuffer.append(" nck.name as contract_kind_name");

        sqlBuffer.append(" FROM ");
        sqlBuffer.append(" npo_contract nc ");

        sqlBuffer.append(" INNER JOIN ");
        sqlBuffer.append(" npo_contract_template nct ");
        sqlBuffer.append(" ON ");
        sqlBuffer.append(" nc.contract_template_id = nct.id ");

        sqlBuffer.append(" INNER JOIN ");
        sqlBuffer.append(" npo_user nu1 ");
        sqlBuffer.append(" ON ");
        sqlBuffer.append(" nc.notary_id = nu1.id ");

        sqlBuffer.append(" LEFT JOIN ");
        sqlBuffer.append(" npo_user nu2 ");
        sqlBuffer.append(" ON ");
        sqlBuffer.append(" nc.drafter_id = nu2.id ");

        sqlBuffer.append(" LEFT JOIN ");
        sqlBuffer.append(" npo_user nu3 ");
        sqlBuffer.append(" ON ");
        sqlBuffer.append(" nc.error_user_id = nu3.id ");

        sqlBuffer.append(" LEFT JOIN ");
        sqlBuffer.append(" npo_bank nb ");
        sqlBuffer.append(" ON ");
        sqlBuffer.append(" nc.bank_id = nb.id ");

        sqlBuffer.append(" LEFT JOIN ");
        sqlBuffer.append(" npo_contract_kind nck ");
        sqlBuffer.append(" ON ");
        sqlBuffer.append(" nct.kind_id = nck.id ");

        sqlBuffer.append(getBaseSQL(prmList));

        if (forUpdate) {
            sqlBuffer.append(" FOR UPDATE ");
        }
        this.setSql(sqlBuffer.toString());

        PreparedStatement ps = null;
        ResultSet rs = null;
        ContractInfo info = null;
        try {
            Connection c = this.getConnection();
            ps = c.prepareStatement(this.getSql());

            int i = 1;
            for (int j = 0; j < prmList.size(); j++) {
                psSetObject(ps, i++, prmList.get(j));
            }

            rs = ps.executeQuery();

            while(rs.next()) {
                info = new ContractInfo();
                rsSetInfoById(rs, info);
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
    public ContractInfo selectByCancellationId(Long cancellationId, boolean forUpdate) throws SQLException, IOException {

        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" SELECT ");
        sqlBuffer.append(" nc.id,");
        sqlBuffer.append(" nc.contract_template_id,");
        sqlBuffer.append(" nct.name as contract_template_name,");
        sqlBuffer.append(" nct.code as contract_template_code,");
        sqlBuffer.append(" nct.relate_object_A_display as relateObjectATitle,");
        sqlBuffer.append(" nct.relate_object_B_display as relateObjectBTitle,");
        sqlBuffer.append(" nct.relate_object_C_display as relateObjectCTitle,");
        sqlBuffer.append(" nct.relate_object_number,");
        sqlBuffer.append(" nc.contract_number,");
        sqlBuffer.append(" nc.relation_object_A,");
        sqlBuffer.append(" nc.relation_object_B,");
        sqlBuffer.append(" nc.relation_object_C,");
        sqlBuffer.append(" nc.contract_value,");
        sqlBuffer.append(" nc.notary_id,");
        sqlBuffer.append(" nc.drafter_id,");
        sqlBuffer.append(" nc.notary_date,");
        sqlBuffer.append(" nc.user_require_contract, ");
        sqlBuffer.append(" nc.number_copy_of_contract, ");
        sqlBuffer.append(" nc.number_of_page, ");
        sqlBuffer.append(" nc.received_date,");
        sqlBuffer.append(" nc.notary_place,");
        sqlBuffer.append(" nc.notary_place_flag,");
        sqlBuffer.append(" nc.summary,");
        sqlBuffer.append(" nc.cost_tt91,");
        sqlBuffer.append(" nc.cost_draft,");
        sqlBuffer.append(" nc.cost_notary_outsite,");
        sqlBuffer.append(" nc.cost_other_determine,");
        sqlBuffer.append(" nc.cost_total,");
        sqlBuffer.append(" nc.bank_id,");
        sqlBuffer.append(" nc.note as contract_note,");
        sqlBuffer.append(" nb.name as bank_name,");
        sqlBuffer.append(" nc.bank_service_fee,");
        sqlBuffer.append(" nc.crediter_name,");
        sqlBuffer.append(" nc.file_name,");
        sqlBuffer.append(" nc.file_path,");
        sqlBuffer.append(" nc.error_status,");
        sqlBuffer.append(" nc.error_user_id,");
        sqlBuffer.append(" nc.error_description,");
        sqlBuffer.append(" nc.addition_status,");
        sqlBuffer.append(" nc.addition_description,");
        sqlBuffer.append(" nc.cancel_status,");
        sqlBuffer.append(" nc.cancel_description,");
        sqlBuffer.append(" nc.cancel_relation_contract_id,");
        sqlBuffer.append(" nc.original_store_place,");
        sqlBuffer.append(" nc.entry_user_name,");
        sqlBuffer.append(" nc.entry_date_time,");
        sqlBuffer.append(" nc.update_user_name,");
        sqlBuffer.append(" nc.update_date_time,");
        sqlBuffer.append(" nc.contract_period,");
        sqlBuffer.append(" nc.mortage_cancel_flag,");
        sqlBuffer.append(" nc.mortage_cancel_date,");
        sqlBuffer.append(" nc.mortage_cancel_note,");
        sqlBuffer.append(" nu1.family_name as notary_family_name,");
        sqlBuffer.append(" nu1.first_name as notary_first_name,");
        sqlBuffer.append(" nu2.family_name as drafter_family_name,");
        sqlBuffer.append(" nu2.first_name as drafter_first_name,");
        sqlBuffer.append(" nu3.family_name as error_user_family_name,");
        sqlBuffer.append(" nu3.first_name as error_user_first_name,");
        sqlBuffer.append(" nck.id as contract_kind_id,");
        sqlBuffer.append(" nck.name as contract_kind_name");

        sqlBuffer.append(" FROM ");
        sqlBuffer.append(" npo_contract nc ");

        sqlBuffer.append(" INNER JOIN ");
        sqlBuffer.append(" npo_contract_template nct ");
        sqlBuffer.append(" ON ");
        sqlBuffer.append(" nc.contract_template_id = nct.id ");

        sqlBuffer.append(" INNER JOIN ");
        sqlBuffer.append(" npo_user nu1 ");
        sqlBuffer.append(" ON ");
        sqlBuffer.append(" nc.notary_id = nu1.id ");

        sqlBuffer.append(" LEFT JOIN ");
        sqlBuffer.append(" npo_user nu2 ");
        sqlBuffer.append(" ON ");
        sqlBuffer.append(" nc.drafter_id = nu2.id ");

        sqlBuffer.append(" LEFT JOIN ");
        sqlBuffer.append(" npo_user nu3 ");
        sqlBuffer.append(" ON ");
        sqlBuffer.append(" nc.error_user_id = nu3.id ");

        sqlBuffer.append(" LEFT JOIN ");
        sqlBuffer.append(" npo_bank nb ");
        sqlBuffer.append(" ON ");
        sqlBuffer.append(" nc.bank_id = nb.id ");

        sqlBuffer.append(" LEFT JOIN ");
        sqlBuffer.append(" npo_contract_kind nck ");
        sqlBuffer.append(" ON ");
        sqlBuffer.append(" nct.kind_id = nck.id ");

        sqlBuffer.append(" WHERE ");
        sqlBuffer.append(" cancel_relation_contract_id = ? ");

        if (forUpdate) {
            sqlBuffer.append(" FOR UPDATE ");
        }
        this.setSql(sqlBuffer.toString());

        PreparedStatement ps = null;
        ResultSet rs = null;
        ContractInfo info = null;
        try {
            Connection c = this.getConnection();
            ps = c.prepareStatement(this.getSql());

	        psSetLong(ps, 1, cancellationId);

            rs = ps.executeQuery();

            while(rs.next()) {
                info = new ContractInfo();
                rsSetInfoById(rs, info);
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
        sqlBuffer.append("npo_contract");

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
        sqlBuffer.append(" npo_contract nc ");

        sqlBuffer.append(" INNER JOIN ");
        sqlBuffer.append(" npo_contract_template nct ");
        sqlBuffer.append(" ON ");
        sqlBuffer.append(" nc.contract_template_id = nct.id ");

        sqlBuffer.append(" INNER JOIN ");
        sqlBuffer.append(" npo_user nu1 ");
        sqlBuffer.append(" ON ");
        sqlBuffer.append(" nc.notary_id = nu1.id ");

        sqlBuffer.append(" LEFT JOIN ");
        sqlBuffer.append(" npo_user nu2 ");
        sqlBuffer.append(" ON ");
        sqlBuffer.append(" nc.drafter_id = nu2.id ");

        sqlBuffer.append(" LEFT JOIN ");
        sqlBuffer.append(" npo_user nu3 ");
        sqlBuffer.append(" ON ");
        sqlBuffer.append(" nc.error_user_id = nu3.id ");

        sqlBuffer.append(" LEFT JOIN ");
        sqlBuffer.append(" npo_bank nb ");
        sqlBuffer.append(" ON ");
        sqlBuffer.append(" nc.bank_id = nb.id ");

        sqlBuffer.append(" INNER JOIN ");
        sqlBuffer.append(" npo_contract_kind nck ");
        sqlBuffer.append(" ON ");
        sqlBuffer.append(" nct.kind_id = nck.id ");

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
     * Determine record is existed in database based on attributes
     *
     * @param contractNumber
     * @return TRUE if its was existed
     */
    public Boolean isExistContractNumber(String contractNumber) throws SQLException {
        StringBuilder sqlBuilder = new StringBuilder();

        sqlBuilder.append(" SELECT ");
        sqlBuilder.append(" COUNT(*) ");
        sqlBuilder.append(" FROM ");
        sqlBuilder.append(" npo_contract nc ");
//        sqlBuilder.append(" INNER JOIN  ");
//        sqlBuilder.append(" npo_transaction_property ntp ");
//        sqlBuilder.append(" ON ");
//        sqlBuilder.append(" ntp.contract_id = nc.id ");
        sqlBuilder.append(" WHERE ");
        sqlBuilder.append(" nc.contract_number = ? ");
        
        this.setSql(sqlBuilder.toString());

        PreparedStatement ps = null;
        ResultSet rs = null;
        int result;
        try {
            Connection c = this.getConnection();
            ps = c.prepareStatement(this.getSql());
            psSetString(ps, 1, contractNumber);
            
            rs = ps.executeQuery();
            rs.next();
            result = rs.getInt(1);

        } finally {
            close(ps, rs);
        }  
        if (result <= 0) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }
    

    /**
     * <P>Create parameter</P>
     *
     * @param  info  Update Info
     * @param sqlList  SQL List
     * @param prmList  Parameter List
     */
    private void makeUpdateList(ContractInfo info, ArrayList<String> sqlList,ArrayList<Object> prmList){

        addUpdateList(info.getContractTemplateId(), ",contract_template_id=?", sqlList, prmList);
        addUpdateList(info.getContractNumber(), ",contract_number=?", sqlList, prmList);
        addUpdateList(info.getContractValue(), ",contract_value=?", true, sqlList, prmList);
        addUpdateList(info.getRelationObjectA(), ",relation_object_A=?", sqlList, prmList);
        addUpdateList(info.getRelationObjectB(), ",relation_object_B=?", sqlList, prmList);
        addUpdateList(info.getRelationObjectC(), ",relation_object_C=?", sqlList, prmList);
        addUpdateList(info.getNotaryId(), ",notary_id=?", sqlList, prmList);
        addUpdateList(info.getDrafterId(), ",drafter_id=?", true, sqlList, prmList);
        addUpdateList(info.getReceivedDate(), ",received_date=?", true, sqlList, prmList);
        addUpdateList(info.getNotaryDate(), ",notary_date=?", sqlList, prmList);
        addUpdateList(info.getUserRequireContract(), ",user_require_contract=?", sqlList, prmList);
        addUpdateList(info.getNumberCopyOfContract(), ",number_copy_of_contract=?", sqlList, prmList);
        addUpdateList(info.getNumberOfPage(), ",number_of_page=?", sqlList, prmList);
        addUpdateList(info.getCostTt91(), ",cost_tt91=?", true, sqlList, prmList);
        addUpdateList(info.getCostDraft(), ",cost_draft=?", true, sqlList, prmList);
        addUpdateList(info.getCostNotaryOutsite(), ",cost_notary_outsite=?", true, sqlList, prmList);
        addUpdateList(info.getCostOtherDetermine(), ",cost_other_determine=?", true, sqlList, prmList);
        addUpdateList(info.getCostTotal(), ",cost_total=?", true, sqlList, prmList);
        addUpdateList(info.getNotaryPlace(), ",notary_place=?", sqlList, prmList);
        addUpdateList(info.getNotaryPlaceFlag(), ",notary_place_flag=?", sqlList, prmList);
        addUpdateList(info.getContractSummary(), ",summary=?", sqlList, prmList);
        addUpdateList(info.getBankId(), ",bank_id=?", true, sqlList, prmList);
        addUpdateList(info.getBankServiceFee(), ",bank_service_fee=?", true, sqlList, prmList);
        addUpdateList(info.getCrediterName(), ",crediter_name=?", sqlList, prmList);
        addUpdateList(info.getFileName(), ",file_name=?", sqlList, prmList);
        addUpdateList(info.getFilePath(), ",file_path=?", sqlList, prmList);
        addUpdateList(info.getErrorStatus(), ",error_status=?", sqlList, prmList);
        addUpdateList(info.getErrorUserId(), ",error_user_id=?", true, sqlList, prmList);
        addUpdateList(info.getErrorDescription(), ",error_description=?", sqlList, prmList);
        addUpdateList(info.getAdditionStatus(), ",addition_status=?", sqlList, prmList);
        addUpdateList(info.getAdditionDescription(), ",addition_description=?", sqlList, prmList);
        addUpdateList(info.getCancelStatus(), ",cancel_status=?", sqlList, prmList);
        addUpdateList(info.getCancelDescription(), ",cancel_description=?", sqlList, prmList);
        addUpdateList(info.getCancelRelationContractId(), ",cancel_relation_contract_id=?", true, sqlList, prmList);
        addUpdateList(info.getOriginalStorePlace(), ",original_store_place=?", sqlList, prmList);
        addUpdateList(info.getNote(), ",note=?", sqlList, prmList);
        addUpdateList(info.getEntryUserId(), ",entry_user_id=?", sqlList, prmList);
        addUpdateList(info.getEntryUserName(), ",entry_user_name=?", sqlList, prmList);
        addUpdateList(info.getEntryDateTime(), ",entry_date_time=?", sqlList, prmList);
        addUpdateList(info.getUpdateUserId(), ",update_user_id=?", sqlList, prmList);
        addUpdateList(info.getUpdateUserName(), ",update_user_name=?", sqlList, prmList);
        addUpdateList(info.getUpdateDateTime(), ",update_date_time=?", sqlList, prmList);
        addUpdateList(info.getContractPeriod(), ",contract_period=?", sqlList, prmList);
        addUpdateList(info.getMortageCancelFlag(), ",mortage_cancel_flag=?", sqlList, prmList);
        addUpdateList(info.getMortageCancelDate(), ",mortage_cancel_date=?", sqlList, prmList);
        addUpdateList(info.getMortageCancelNote(), ",mortage_cancel_note=?", sqlList, prmList);
    }


    /**
     * <P>Set ResultSet to Info instance </P>
     *
     * @param  rs    ResultSet
     * @param  info  Info instance
     * @throws SQLException
     */
    private void rsSetInfo(ResultSet rs,ContractInfo info) throws SQLException {

        info.setId(rsGetLong(rs, "id"));
        //info.setContractTemplateId(rsGetLong(rs, "contract_template_id"));
        info.setContractNumber(rsGetString(rs, "contract_number"));
        info.setContractValue(rsGetString(rs, "contract_value"));
        info.setRelationObjectA(rsGetString(rs, "relation_object_A"));
        info.setRelationObjectB(rsGetString(rs, "relation_object_B"));
        info.setRelationObjectC(rsGetString(rs, "relation_object_C"));
        info.setNotaryId(rsGetLong(rs, "notary_id"));
        info.setDrafterId(rsGetLong(rs, "drafter_id"));
        info.setReceivedDate(rsGetTimestamp(rs, "received_date"));
        info.setNotaryDate(rsGetTimestamp(rs, "notary_date"));
        //info.setCostTt91(rsGetString(rs, "cost_tt91"));
        //info.setCostDraft(rsGetString(rs, "cost_draft"));
        //info.setCostNotaryOutsite(rsGetString(rs, "cost_notary_outsite"));
        //info.setCostOtherDetermine(rsGetString(rs, "cost_other_determine"));
        //info.setCostTotal(rsGetString(rs, "cost_total"));
        info.setNotaryPlace(rsGetString(rs, "notary_place"));
        info.setBankId(rsGetLong(rs, "bank_id"));
        info.setBankServiceFee(rsGetString(rs, "bank_service_fee"));
        info.setCrediterName(rsGetString(rs, "crediter_name"));
        //info.setFileName(rsGetString(rs, "file_name"));
        //info.setFilePath(rsGetString(rs, "file_path"));
        info.setErrorStatus(rsGetBoolean(rs, "error_status"));
        //info.setErrorUserId(rsGetLong(rs, "error_user_id"));
        info.setErrorDescription(rsGetString(rs, "error_description"));
        info.setAdditionStatus(rsGetBoolean(rs, "addition_status"));
        info.setAdditionDescription(rsGetString(rs, "addition_description"));
        info.setCancelStatus(rsGetBoolean(rs, "cancel_status"));
        //info.setOriginalStorePlace(rsGetString(rs, "original_store_place"));
        info.setNote(rsGetString(rs, "note"));
        info.setEntryUserId(rsGetLong(rs, "entry_user_id"));
        //info.setEntryUserName(rsGetString(rs, "entry_user_name"));
        //info.setEntryDateTime(rsGetTimestamp(rs, "entry_date_time"));
        //info.setUpdateUserId(rsGetLong(rs, "update_user_id"));
        //info.setUpdateUserName(rsGetString(rs, "update_user_name"));
        //info.setUpdateDateTime(rsGetTimestamp(rs, "update_date_time"));

        info.setContractTemplateName(rsGetString(rs, "contract_name"));
        if (rsGetString(rs, "relateObjectATitle")!= null && !rsGetString(rs, "relateObjectATitle").equals(SystemMessageProperties.getSystemProperty("item_relation_object")))
    		info.setRelateObjectATitle(rsGetString(rs, "relateObjectATitle"));
        else info.setRelateObjectATitle(SystemMessageProperties.getSystemProperty("item_relation_objectA"));
        if (rsGetString(rs, "relateObjectBTitle")!= null && !rsGetString(rs, "relateObjectBTitle").equals(SystemMessageProperties.getSystemProperty("item_relation_object")))
		info.setRelateObjectBTitle(rsGetString(rs, "relateObjectBTitle"));
        else info.setRelateObjectBTitle(SystemMessageProperties.getSystemProperty("item_relation_objectB"));
        if (rsGetString(rs, "relateObjectCTitle")!= null && !rsGetString(rs, "relateObjectCTitle").equals(SystemMessageProperties.getSystemProperty("item_relation_object")))
		info.setRelateObjectCTitle(rsGetString(rs, "relateObjectCTitle"));
        else info.setRelateObjectCTitle(SystemMessageProperties.getSystemProperty("item_relation_objectC"));
        info.setBankName(rsGetString(rs, "bank_name"));
        info.setNotaryFamilyName(rsGetString(rs, "notary_family_name"));
        info.setNotaryFirstName(rsGetString(rs, "notary_first_name"));
        info.setDrafterFamilyName(rsGetString(rs, "drafter_family_name"));
        info.setDrafterFirstName(rsGetString(rs, "drafter_first_name"));
        info.setNotaryAccount(rsGetString(rs, "notary_account"));
        info.setDrafterAccount(rsGetString(rs, "drafter_account"));
        info.setContractSummary(rsGetString(rs, "contract_sumary"));
        info.setNotaryPlaceFlag(rsGetBoolean(rs, "notary_place_flag"));
        //info.setPropertyInfo(rsGetString(rs, "property_info"));
        //info.setPropertyType(rsGetString(rs, "type"));
        info.setContractPeriod(rsGetString(rs, "contract_period"));
        info.setMortageCancelFlag(rsGetBoolean(rs, "mortage_cancel_flag"));
        info.setMortageCancelDate(rsGetString(rs, "mortage_cancel_date"));
        info.setMortageCancelNote(rsGetString(rs, "mortage_cancel_note"));
        //info.setDistrict(rsGetString(rs, "land_district"));
        //info.setStreet(rsGetString(rs, "land_street"));
    }
    
    /**
     * <P>Set ResultSet to Info instance </P>
     *
     * @param  rs    ResultSet
     * @param  info  Info instance
     * @throws SQLException
     */
    private void rsSetInfoForContractCertify(ResultSet rs,ContractInfo info) throws SQLException {

        info.setId(rsGetLong(rs, "id"));
        info.setContractNumber(rsGetString(rs, "contract_number"));
        info.setContractValue(rsGetString(rs, "contract_value"));
        info.setRelationObjectA(rsGetString(rs, "relation_object_A"));
        info.setRelationObjectB(rsGetString(rs, "relation_object_B"));
        info.setRelationObjectC(rsGetString(rs, "relation_object_C"));
        info.setNotaryId(rsGetLong(rs, "notary_id"));
        info.setDrafterId(rsGetLong(rs, "drafter_id"));
        info.setReceivedDate(rsGetTimestamp(rs, "received_date"));
        info.setNotaryDate(rsGetTimestamp(rs, "notary_date"));       
        info.setNotaryPlace(rsGetString(rs, "notary_place"));
        info.setBankId(rsGetLong(rs, "bank_id"));
        info.setBankServiceFee(rsGetString(rs, "bank_service_fee"));
        info.setErrorStatus(rsGetBoolean(rs, "error_status"));
        info.setErrorDescription(rsGetString(rs, "error_description"));
        info.setAdditionStatus(rsGetBoolean(rs, "addition_status"));
        info.setAdditionDescription(rsGetString(rs, "addition_description"));
        info.setCancelStatus(rsGetBoolean(rs, "cancel_status"));
        info.setNote(rsGetString(rs, "note"));
        info.setContractTemplateName(rsGetString(rs, "contract_name"));
        if (rsGetString(rs, "relateObjectATitle")!= null && !rsGetString(rs, "relateObjectATitle").equals(SystemMessageProperties.getSystemProperty("item_relation_object")))
            info.setRelateObjectATitle(rsGetString(rs, "relateObjectATitle"));
        else info.setRelateObjectATitle(SystemMessageProperties.getSystemProperty("item_relation_objectA"));
        if (rsGetString(rs, "relateObjectBTitle")!= null && !rsGetString(rs, "relateObjectBTitle").equals(SystemMessageProperties.getSystemProperty("item_relation_object")))
        info.setRelateObjectBTitle(rsGetString(rs, "relateObjectBTitle"));
        else info.setRelateObjectBTitle(SystemMessageProperties.getSystemProperty("item_relation_objectB"));
        if (rsGetString(rs, "relateObjectCTitle")!= null && !rsGetString(rs, "relateObjectCTitle").equals(SystemMessageProperties.getSystemProperty("item_relation_object")))
        info.setRelateObjectCTitle(rsGetString(rs, "relateObjectCTitle"));
        else info.setRelateObjectCTitle(SystemMessageProperties.getSystemProperty("item_relation_objectC"));
        info.setBankName(rsGetString(rs, "bank_name"));
        info.setNotaryFamilyName(rsGetString(rs, "notary_family_name"));
        info.setNotaryFirstName(rsGetString(rs, "notary_first_name"));
        info.setDrafterFamilyName(rsGetString(rs, "drafter_family_name"));
        info.setDrafterFirstName(rsGetString(rs, "drafter_first_name"));
        info.setNotaryAccount(rsGetString(rs, "notary_account"));
        info.setDrafterAccount(rsGetString(rs, "drafter_account"));
        info.setContractSummary(rsGetString(rs, "contract_sumary"));
        info.setNotaryPlaceFlag(rsGetBoolean(rs, "notary_place_flag"));
        info.setPropertyInfo(rsGetString(rs, "property_info"));
        info.setPropertyType(rsGetString(rs, "type"));
        info.setContractPeriod(rsGetString(rs, "contract_period"));
        info.setMortageCancelFlag(rsGetBoolean(rs, "mortage_cancel_flag"));
        info.setMortageCancelDate(rsGetString(rs, "mortage_cancel_date"));
        info.setMortageCancelNote(rsGetString(rs, "mortage_cancel_note"));
        info.setDistrict(rsGetString(rs, "land_district"));
        info.setStreet(rsGetString(rs, "land_street"));
    }

    /**
     * <P>Set ResultSet to Info instance </P>
     *
     * @param  rs    ResultSet
     * @param  info  Info instance
     * @throws SQLException
     */
    private void rsSetInfoById(ResultSet rs,ContractInfo info) throws SQLException {

        info.setId(rsGetLong(rs, "id"));
        info.setContractTemplateId(rsGetLong(rs, "contract_template_id"));
        info.setContractTemplateName(rsGetString(rs, "contract_template_name"));
        info.setContractTemplateCode(rsGetString(rs, "contract_template_code"));
        if (rsGetString(rs, "relateObjectATitle")!= null && !rsGetString(rs, "relateObjectATitle").equals(SystemMessageProperties.getSystemProperty("item_relation_object")))
        		info.setRelateObjectATitle(rsGetString(rs, "relateObjectATitle"));
        else info.setRelateObjectATitle(SystemMessageProperties.getSystemProperty("item_relation_objectA"));
        if (rsGetString(rs, "relateObjectBTitle")!= null && !rsGetString(rs, "relateObjectBTitle").equals(SystemMessageProperties.getSystemProperty("item_relation_object")))
    		info.setRelateObjectBTitle(rsGetString(rs, "relateObjectBTitle"));
        else info.setRelateObjectBTitle(SystemMessageProperties.getSystemProperty("item_relation_objectB"));
        if (rsGetString(rs, "relateObjectCTitle")!= null && !rsGetString(rs, "relateObjectCTitle").equals(SystemMessageProperties.getSystemProperty("item_relation_object")))
    		info.setRelateObjectCTitle(rsGetString(rs, "relateObjectCTitle"));
        else info.setRelateObjectCTitle(SystemMessageProperties.getSystemProperty("item_relation_objectC"));
        info.setRelateObjectNumber(rsGetInt(rs, "relate_object_number"));
        info.setContractNumber(rsGetString(rs, "contract_number"));
        info.setContractValue(rsGetString(rs, "contract_value"));
        info.setRelationObjectA(rsGetString(rs, "relation_object_A"));
        info.setRelationObjectB(rsGetString(rs, "relation_object_B"));
        info.setRelationObjectC(rsGetString(rs, "relation_object_C"));
        info.setNotaryId(rsGetLong(rs, "notary_id"));
        info.setDrafterId(rsGetLong(rs, "drafter_id"));
        info.setReceivedDate(rsGetTimestamp(rs, "received_date"));
        info.setNotaryDate(rsGetTimestamp(rs, "notary_date"));
        info.setUserRequireContract(rsGetString(rs, "user_require_contract"));
        info.setNumberCopyOfContract(rsGetString(rs, "number_copy_of_contract"));
        info.setNumberOfPage(rsGetString(rs, "number_of_page"));
        info.setEntryUserId(rsGetLong(rs, "entry_user_id"));
        info.setEntryUserName(rsGetString(rs, "entry_user_name"));
        info.setEntryDateTime(rsGetTimestamp(rs, "entry_date_time"));
        info.setUpdateUserName(rsGetString(rs, "update_user_name"));
        info.setUpdateDateTime(rsGetTimestamp(rs, "update_date_time"));
        info.setNote(rsGetString(rs, "contract_note"));
        info.setCostTt91(rsGetString(rs, "cost_tt91"));
        info.setCostDraft(rsGetString(rs, "cost_draft"));
        info.setCostNotaryOutsite(rsGetString(rs, "cost_notary_outsite"));
        info.setCostOtherDetermine(rsGetString(rs, "cost_other_determine"));
        info.setCostTotal(rsGetString(rs, "cost_total"));
        info.setNotaryPlace(rsGetString(rs, "notary_place"));
        info.setNotaryPlaceFlag(rsGetBoolean(rs, "notary_place_flag"));
        info.setBankId(rsGetLong(rs, "bank_id"));
        info.setBankName(rsGetString(rs, "bank_name"));
        info.setBankServiceFee(rsGetString(rs, "bank_service_fee"));
        info.setCrediterName(rsGetString(rs, "crediter_name"));
        info.setFileName(rsGetString(rs, "file_name"));
        info.setFilePath(rsGetString(rs, "file_path"));
        info.setErrorStatus(rsGetBoolean(rs, "error_status"));
        info.setErrorUserId(rsGetLong(rs, "error_user_id"));
        info.setErrorDescription(rsGetString(rs, "error_description"));
        info.setAdditionStatus(rsGetBoolean(rs, "addition_status"));
        info.setAdditionDescription(rsGetString(rs, "addition_description"));
        info.setCancelStatus(rsGetBoolean(rs, "cancel_status"));
        info.setCancelDescription(rsGetString(rs, "cancel_description"));
        info.setCancelRelationContractId(rsGetLong(rs, "cancel_relation_contract_id"));
        info.setOriginalStorePlace(rsGetString(rs, "original_store_place"));
        info.setNotaryFamilyName(rsGetString(rs, "notary_family_name"));
        info.setNotaryFirstName(rsGetString(rs, "notary_first_name"));
        info.setDrafterFamilyName(rsGetString(rs, "drafter_family_name"));
        info.setDrafterFirstName(rsGetString(rs, "drafter_first_name"));
        info.setErrorUserFamilyName(rsGetString(rs, "error_user_family_name"));
        info.setErrorUserFirstName(rsGetString(rs, "error_user_first_name"));
        info.setContractKindId(rsGetLong(rs, "contract_kind_id"));
        info.setContractKindName(rsGetString(rs, "contract_kind_name"));
        info.setContractSummary(rsGetString(rs, "summary"));
        info.setContractPeriod(rsGetString(rs, "contract_period"));
        info.setMortageCancelFlag(rsGetBoolean(rs, "mortage_cancel_flag"));
        info.setMortageCancelDate(rsGetString(rs, "mortage_cancel_date"));
        info.setMortageCancelNote(rsGetString(rs, "mortage_cancel_note"));
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

        if (this.contractIdFilter !=  null) {
            appendAnd(filterBuffer);
            filterBuffer.append(" nc.id = ? ");
            prmList.add(this.contractIdFilter);
        }

        if (this.contractKindIdFilter !=  null) {
            appendAnd(filterBuffer);
            filterBuffer.append(" nct.kind_id = ? ");
            prmList.add(this.contractKindIdFilter);
        }
        
        if (this.contractKindIdArrayFilter !=  null && this.contractKindIdArrayFilter.length > 0) {
            appendAnd(filterBuffer);
            filterBuffer.append(buildIn("nct.kind_id", this.contractKindIdArrayFilter.length));
            for (int i = 0; i < this.contractKindIdArrayFilter.length; i++) {
                prmList.add(this.contractKindIdArrayFilter[i]);
            }
        }

        if (this.bankIdFilter !=  null) {
            appendAnd(filterBuffer);
            filterBuffer.append(" nc.bank_id = ? ");
            prmList.add(this.bankIdFilter);
        }

        if (this.isBankIdNullFilter !=  null) {
            if (this.isBankIdNullFilter == Boolean.TRUE) {
                appendAnd(filterBuffer);
                filterBuffer.append(" nc.bank_id IS NULL ");
            } else {
                appendAnd(filterBuffer);
                filterBuffer.append(" nc.bank_id IS NOT NULL ");
            }
        }

        if (this.contractNumberFilter !=  null) {
            appendAnd(filterBuffer);
            filterBuffer.append(" nc.contract_number LIKE ? ");
            prmList.add(this.contractNumberFilter);
        }

        if (this.contractTemplateIdFilter !=  null) {
            appendAnd(filterBuffer);
            filterBuffer.append(" nc.contract_template_id = ? ");
            prmList.add(this.contractTemplateIdFilter);
        }
        //loc bo nhung ten hop dong da ngung su dung
        if (this.templateActiveFlgFilter != null) {
            appendAnd(filterBuffer);
            filterBuffer.append(" nct.active_flg = ? ");
            prmList.add(this.templateActiveFlgFilter);
        }

        if (this.drafterIdFilter !=  null) {
            appendAnd(filterBuffer);
            filterBuffer.append(" nc.drafter_id = ? ");
            prmList.add(this.drafterIdFilter);
        }

        if (this.drafterIdFlagFilter !=  null) {
            if (this.drafterIdFlagFilter == Boolean.FALSE) {
                appendAnd(filterBuffer);
                filterBuffer.append(" nc.drafter_id = ? ");
                prmList.add(this.drafterIdFilter);
            } else {
                appendAnd(filterBuffer);
                filterBuffer.append(" nc.drafter_id IS NOT NULL ");
            }
        }
        
        if (this.notaryIdFilter !=  null) {
            appendAnd(filterBuffer);
            filterBuffer.append(" nc.notary_id= ? ");
            prmList.add(this.notaryIdFilter);
        }

        if (this.notaryDateFilter !=  null) {
            appendAnd(filterBuffer);
            filterBuffer.append(" nc.notary_date = ? ");
            prmList.add(this.notaryDateFilter);
        }

        if (this.notaryDateFromFilter !=  null) {
            appendAnd(filterBuffer);
            filterBuffer.append(" nc.notary_date >= ? ");
            prmList.add(this.notaryDateFromFilter);
        }

        if (this.notaryDateToFilter !=  null) {
            appendAnd(filterBuffer);
            filterBuffer.append(" nc.notary_date <= ? ");
            prmList.add(this.notaryDateToFilter);
        }

        if (this.notaryPlaceFilter !=  null) {
            appendAnd(filterBuffer);
            filterBuffer.append(" nc.notary_place_flag = ? ");
            prmList.add(this.notaryPlaceFilter);
        }

        if (this.relationObjectAFilter !=  null) {
            appendAnd(filterBuffer);
            filterBuffer.append(" nc.relation_object_A LIKE ? ");
            prmList.add(this.relationObjectAFilter);
        }

        if (this.relationObjectBFilter !=  null) {
            appendAnd(filterBuffer);
            filterBuffer.append(" nc.relation_object_B LIKE ? ");
            prmList.add(this.relationObjectBFilter);
        }

        if (this.relationObjectCFilter !=  null) {
            appendAnd(filterBuffer);
            filterBuffer.append(" nc.relation_object_C LIKE ? ");
            prmList.add(this.relationObjectCFilter);
        }

        if (this.errorStatusFilter !=  null) {
            appendAnd(filterBuffer);
            filterBuffer.append(" nc.error_status = ? ");
            prmList.add(this.errorStatusFilter);
        }

        if (this.additionStatusFilter !=  null) {
            appendAnd(filterBuffer);
            filterBuffer.append(" nc.addition_status = ? ");
            prmList.add(this.additionStatusFilter);
        }

        if (this.cancellationStatusFilter !=  null) {
            appendAnd(filterBuffer);
            filterBuffer.append(" nc.cancel_status = ? ");
            prmList.add(this.cancellationStatusFilter);
        }

        if (this.draftUserIdListFilter != null && this.draftUserIdListFilter.length > 0) {
            appendAnd(filterBuffer);
            filterBuffer.append(" nc.drafter_id IN (");
            for (int i = 0; i< this.draftUserIdListFilter.length; i++) {
                filterBuffer.append(" " + this.draftUserIdListFilter[i] + ",");
            }
            filterBuffer.append(" -1) ");
        }

        if (this.notaryUserIdListFilter != null && this.notaryUserIdListFilter.length > 0) {
            appendAnd(filterBuffer);
            filterBuffer.append(" nc.notary_id IN (");
            for (int i = 0; i< this.notaryUserIdListFilter.length; i++) {
                filterBuffer.append(" " + this.notaryUserIdListFilter[i] + ",");
            }
            filterBuffer.append(" -1) ");
        }

        if (this.banksIdFilter != null && this.banksIdFilter.length > 0) {
            appendAnd(filterBuffer);
            filterBuffer.append(" nc.bank_id IN (");
            for (int i = 0; i< this.banksIdFilter.length; i++) {
                filterBuffer.append(" " + this.banksIdFilter[i] + ",");
            }
            filterBuffer.append(" -1) ");
        }

        if (this.relationObjectFilter !=  null) {
            appendAnd(filterBuffer);
            filterBuffer.append(" ( ");

            filterBuffer.append(" nc.relation_object_A LIKE ? ");
            prmList.add(this.relationObjectFilter);

            appendOr(filterBuffer);
            filterBuffer.append(" nc.relation_object_B LIKE ? ");
            prmList.add(this.relationObjectFilter);

            appendOr(filterBuffer);
            filterBuffer.append(" nc.relation_object_C LIKE ? ");
            prmList.add(this.relationObjectFilter);

            filterBuffer.append(" ) ");
        }

        if (this.contractSummaryFilter !=  null) {
            appendAnd(filterBuffer);
            filterBuffer.append(" nc.summary LIKE ? ");
            prmList.add(this.contractSummaryFilter);
        }

        if (this.propertyInfoFilter !=  null) {
            appendAnd(filterBuffer);
            filterBuffer.append(" ntp.property_info LIKE ? ");
            prmList.add(this.propertyInfoFilter);
        }
        
        if (this.keySearchFilter != null) {
            for (String subkey : subKeys) {

                if (Constants.PLUS.equals(subkey)) {
                    appendAnd(filterBuffer);
                    filterBuffer.append(" ( ");
                } else if (Constants.SPACE.equals(subkey)) {
                    appendOr(filterBuffer);
                    filterBuffer.append(" ( ");
                } else {
                    filterBuffer.append(" MATCH(nc.contract_number, nc.relation_object_A, nc.relation_object_B, " +
                            "nc.relation_object_C, nc.user_require_contract, nc.notary_place, nc.crediter_name, nc.error_description, " +
                            "nc.addition_description, nc.cancel_description, nc.original_store_place, nc.note, nc.summary, " +
                            "nct.name, nu1.family_name, nu1.first_name, nu2.family_name, nu2.first_name, nb.name, nck.name, ntp.property_info) " );
                    filterBuffer.append(" AGAINST(? IN BOOLEAN MODE) ");
                    prmList.add(subkey);

                    if (subkey.charAt(0) == '"') {
                        subkey = subkey.substring(1, subkey.length() - 1);
                    }

                    if (subkey.charAt(subkey.length() - 1) == '"') {
                        subkey = subkey.substring(0, subkey.length() - 2);
                    }

                    appendOr(filterBuffer);
                    filterBuffer.append(" nc.contract_number LIKE ? ");
                    prmList.add(buildFilterString(subkey, FilterKind.MIDDLE.getValue()));

                    appendOr(filterBuffer);
                    filterBuffer.append(" nc.relation_object_A LIKE ? ");
                    prmList.add(buildFilterString(subkey, FilterKind.MIDDLE.getValue()));

                    appendOr(filterBuffer);
                    filterBuffer.append(" nc.relation_object_B LIKE ? ");
                    prmList.add(buildFilterString(subkey, FilterKind.MIDDLE.getValue()));

                    appendOr(filterBuffer);
                    filterBuffer.append(" nc.relation_object_C LIKE ? ");
                    prmList.add(buildFilterString(subkey, FilterKind.MIDDLE.getValue()));

                    appendOr(filterBuffer);
                    filterBuffer.append(" nc.user_require_contract LIKE ? ");
                    prmList.add(buildFilterString(subkey, FilterKind.MIDDLE.getValue()));

                    appendOr(filterBuffer);
                    filterBuffer.append(" nc.notary_place LIKE ? ");
                    prmList.add(buildFilterString(subkey, FilterKind.MIDDLE.getValue()));

                    appendOr(filterBuffer);
                    filterBuffer.append(" nc.crediter_name LIKE ? ");
                    prmList.add(buildFilterString(subkey, FilterKind.MIDDLE.getValue()));

                    appendOr(filterBuffer);
                    filterBuffer.append(" nc.error_description LIKE ? ");
                    prmList.add(buildFilterString(subkey, FilterKind.MIDDLE.getValue()));

                    appendOr(filterBuffer);
                    filterBuffer.append(" nc.addition_description LIKE ? ");
                    prmList.add(buildFilterString(subkey, FilterKind.MIDDLE.getValue()));

                    appendOr(filterBuffer);
                    filterBuffer.append(" nc.cancel_description LIKE ? ");
                    prmList.add(buildFilterString(subkey, FilterKind.MIDDLE.getValue()));

                    appendOr(filterBuffer);
                    filterBuffer.append(" nc.original_store_place LIKE ? ");
                    prmList.add(buildFilterString(subkey, FilterKind.MIDDLE.getValue()));

                    appendOr(filterBuffer);
                    filterBuffer.append(" nc.note LIKE ? ");
                    prmList.add(buildFilterString(subkey, FilterKind.MIDDLE.getValue()));

                    appendOr(filterBuffer);
                    filterBuffer.append(" nc.summary LIKE ? ");
                    prmList.add(buildFilterString(subkey, FilterKind.MIDDLE.getValue()));

                    appendOr(filterBuffer);
                    filterBuffer.append(" nct.name LIKE ? ");
                    prmList.add(buildFilterString(subkey, FilterKind.MIDDLE.getValue()));

                    appendOr(filterBuffer);
                    filterBuffer.append(" nu1.family_name LIKE ? ");
                    prmList.add(buildFilterString(subkey, FilterKind.MIDDLE.getValue()));

                    appendOr(filterBuffer);
                    filterBuffer.append(" nu1.first_name LIKE ? ");
                    prmList.add(buildFilterString(subkey, FilterKind.MIDDLE.getValue()));

                    appendOr(filterBuffer);
                    filterBuffer.append(" nu2.family_name LIKE ? ");
                    prmList.add(buildFilterString(subkey, FilterKind.MIDDLE.getValue()));

                    appendOr(filterBuffer);
                    filterBuffer.append(" nu2.first_name LIKE ? ");
                    prmList.add(buildFilterString(subkey, FilterKind.MIDDLE.getValue()));

                    appendOr(filterBuffer);
                    filterBuffer.append(" nb.name LIKE ? ");
                    prmList.add(buildFilterString(subkey, FilterKind.MIDDLE.getValue()));

                    appendOr(filterBuffer);
                    filterBuffer.append(" nck.name LIKE ? ");
                    prmList.add(buildFilterString(subkey, FilterKind.MIDDLE.getValue()));

                    appendOr(filterBuffer);
                    filterBuffer.append(" ntp.property_info LIKE ? ");
                    prmList.add(buildFilterString(subkey, FilterKind.MIDDLE.getValue()));

                    filterBuffer.append(" ) ");
                }
            }

            if (orderKeySearch) {
                filterBuffer.append(" ORDER BY ");
                for (int i = 1; i < subKeys.size(); i++) {
                    String subkey = subKeys.get(i);
                    if (!Constants.PLUS.equals(subkey) && !Constants.SPACE.equals(subkey)) {
                        filterBuffer.append(" ( ");

                        filterBuffer.append(" MATCH(nc.contract_number, nc.relation_object_A, nc.relation_object_B, " +
                                "nc.relation_object_C, nc.user_require_contract, nc.notary_place, nc.crediter_name, nc.error_description, " +
                                "nc.addition_description, nc.cancel_description, nc.original_store_place, nc.note, nc.summary, " +
                                "nct.name, nu1.family_name, nu1.first_name, nu2.family_name, nu2.first_name, nb.name, nck.name, ntp.property_info) " );
                        filterBuffer.append(" AGAINST(? IN BOOLEAN MODE) ");
                        prmList.add(subkey);

                        appendAnd(filterBuffer);
                        filterBuffer.append(" nb.name IS NOT NULL ");

                        if (subkey.charAt(0) == '"') {
                            subkey = subkey.substring(1, subkey.length() - 1);
                        }

                        if (subkey.charAt(subkey.length() - 1) == '"') {
                            subkey = subkey.substring(0, subkey.length() - 2);
                        }

                        appendOr(filterBuffer);
                        filterBuffer.append(" nc.contract_number LIKE ? ");
                        prmList.add(buildFilterString(subkey, FilterKind.MIDDLE.getValue()));

                        appendOr(filterBuffer);
                        filterBuffer.append(" nc.relation_object_A LIKE ? ");
                        prmList.add(buildFilterString(subkey, FilterKind.MIDDLE.getValue()));

                        appendOr(filterBuffer);
                        filterBuffer.append(" nc.relation_object_B LIKE ? ");
                        prmList.add(buildFilterString(subkey, FilterKind.MIDDLE.getValue()));

                        appendOr(filterBuffer);
                        filterBuffer.append(" nc.relation_object_C LIKE ? ");
                        prmList.add(buildFilterString(subkey, FilterKind.MIDDLE.getValue()));

                        appendOr(filterBuffer);
                        filterBuffer.append(" nc.user_require_contract LIKE ? ");
                        prmList.add(buildFilterString(subkey, FilterKind.MIDDLE.getValue()));

                        appendOr(filterBuffer);
                        filterBuffer.append(" nc.notary_place LIKE ? ");
                        prmList.add(buildFilterString(subkey, FilterKind.MIDDLE.getValue()));

                        appendOr(filterBuffer);
                        filterBuffer.append(" nc.crediter_name LIKE ? ");
                        prmList.add(buildFilterString(subkey, FilterKind.MIDDLE.getValue()));

                        appendOr(filterBuffer);
                        filterBuffer.append(" nc.error_description LIKE ? ");
                        prmList.add(buildFilterString(subkey, FilterKind.MIDDLE.getValue()));

                        appendOr(filterBuffer);
                        filterBuffer.append(" nc.addition_description LIKE ? ");
                        prmList.add(buildFilterString(subkey, FilterKind.MIDDLE.getValue()));

                        appendOr(filterBuffer);
                        filterBuffer.append(" nc.cancel_description LIKE ? ");
                        prmList.add(buildFilterString(subkey, FilterKind.MIDDLE.getValue()));

                        appendOr(filterBuffer);
                        filterBuffer.append(" nc.original_store_place LIKE ? ");
                        prmList.add(buildFilterString(subkey, FilterKind.MIDDLE.getValue()));

                        appendOr(filterBuffer);
                        filterBuffer.append(" nc.note LIKE ? ");
                        prmList.add(buildFilterString(subkey, FilterKind.MIDDLE.getValue()));

                        appendOr(filterBuffer);
                        filterBuffer.append(" nc.summary LIKE ? ");
                        prmList.add(buildFilterString(subkey, FilterKind.MIDDLE.getValue()));

                        appendOr(filterBuffer);
                        filterBuffer.append(" nct.name LIKE ? ");
                        prmList.add(buildFilterString(subkey, FilterKind.MIDDLE.getValue()));

                        appendOr(filterBuffer);
                        filterBuffer.append(" nu1.family_name LIKE ? ");
                        prmList.add(buildFilterString(subkey, FilterKind.MIDDLE.getValue()));

                        appendOr(filterBuffer);
                        filterBuffer.append(" nu1.first_name LIKE ? ");
                        prmList.add(buildFilterString(subkey, FilterKind.MIDDLE.getValue()));

                        appendOr(filterBuffer);
                        filterBuffer.append(" nu2.family_name LIKE ? ");
                        prmList.add(buildFilterString(subkey, FilterKind.MIDDLE.getValue()));

                        appendOr(filterBuffer);
                        filterBuffer.append(" nu2.first_name LIKE ? ");
                        prmList.add(buildFilterString(subkey, FilterKind.MIDDLE.getValue()));

                        appendOr(filterBuffer);
                        filterBuffer.append(" nb.name LIKE ? ");
                        prmList.add(buildFilterString(subkey, FilterKind.MIDDLE.getValue()));

                        appendOr(filterBuffer);
                        filterBuffer.append(" nck.name LIKE ? ");
                        prmList.add(buildFilterString(subkey, FilterKind.MIDDLE.getValue()));

                        appendOr(filterBuffer);
                        filterBuffer.append(" ntp.property_info LIKE ? ");
                        prmList.add(buildFilterString(subkey, FilterKind.MIDDLE.getValue()));

                        if (i == subKeys.size() - 1) {
                            filterBuffer.append(" ) ");
                        } else {
                            filterBuffer.append(" ) + ");
                        }
                    }
                }
                filterBuffer.append(" DESC, nc.contract_number DESC, year(nc.notary_date) DESC ");
            }
        }

        return filterBuffer.toString();
    }

    /**
     * Set contract Id Filter
     *
     * @param contractIdFilter
     */
    public void setContractIdFilter(Long contractIdFilter) {

        this.contractIdFilter = contractIdFilter;
    }

    /**
     * Set the contractKindIdFilter
     *
     * @param contractKindIdFilter the contractKindIdFilter to set
     */
    public void setContractKindIdFilter(Long contractKindIdFilter) {
        this.contractKindIdFilter = contractKindIdFilter;
    }
    
    /**
	 * Set contractKindIdArrayFilter
	 * @param contractKindIdArrayFilter the contractKindIdArrayFilter to set
	 */
	public void setContractKindIdArrayFilter(Long[] contractKindIdArrayFilter) {
		this.contractKindIdArrayFilter = contractKindIdArrayFilter;
	}

	/**
     * Set the contractKindIdFilter
     *
     * @param contractKindIdFilter the contractKindIdFilter to set
     */
    public void setContractTemplateActiveFlgFilter(Boolean activeFlg){
    	this.templateActiveFlgFilter = activeFlg;
    }

    /**
     * Set contract Number Filter
     *
     * @param contractNumberFilter
     * @param kind  Filter kind (FULL, LEFT, MIDDLE)
     */
    public void setContractNumberFilter(String contractNumberFilter, FilterKind kind) {

        this.contractNumberFilter = this.buildFilterString(contractNumberFilter, kind.getValue());
    }

    /**
     * Set contract Template Id Filter
     *
     * @param contractTemplateIdFilter
     */
    public void setContractTemplateIdFilter(Long contractTemplateIdFilter) {

        this.contractTemplateIdFilter = contractTemplateIdFilter;
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
     * Set the relationObjectAFilter
     *
     * @param relationObjectAFilter the relationObjectAFilter to set
     */
    public void setRelationObjectAFilter(String relationObjectAFilter, FilterKind kind) {
        this.relationObjectAFilter = this.buildFilterString(relationObjectAFilter, kind.getValue());
    }

    /**
     * Set the relationObjectBFilter
     *
     * @param relationObjectBFilter the relationObjectBFilter to set
     */
    public void setRelationObjectBFilter(String relationObjectBFilter, FilterKind kind) {
        this.relationObjectBFilter = this.buildFilterString(relationObjectBFilter, kind.getValue());
    }

    /**
     * Set the relationObjectCFilter
     *
     * @param relationObjectCFilter the relationObjectCFilter to set
     */
    public void setRelationObjectCFilter(String relationObjectCFilter, FilterKind kind) {
        this.relationObjectCFilter = this.buildFilterString(relationObjectCFilter, kind.getValue());
    }

    /**
     * Set notary Date Filter
     *
     * @param notaryDateFilter
     */
    public void setNotaryDateFilter(Timestamp notaryDateFilter) {

        this.notaryDateFilter = notaryDateFilter;
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
     * Set bank Id Filter
     *
     * @param bankIdFilter
     */
    public void setBankIdFilter(Long bankIdFilter) {

        this.bankIdFilter = bankIdFilter;
    }


    /**
     * Set the isBankIdNullFilter
     *
     * @param isBankIdNullFilter the isBankIdNullFilter to set
     */
    public void setIsBankIdNullFilter(Boolean isBankIdNullFilter) {
        this.isBankIdNullFilter = isBankIdNullFilter;
    }


    /**
     * Set notary Place Filter
     *
     * @param notaryPlaceFilter
     */
    public void setNotaryPlaceFilter(Boolean notaryPlaceFilter) {

        this.notaryPlaceFilter = notaryPlaceFilter;
    }

    /**
     * Set notary Id Filter
     *
     * @param notaryIdFilter
     */
    public void setNotaryIdFilter(Long notaryIdFilter) {

        this.notaryIdFilter = notaryIdFilter;
    }

    /**
     * Set drafter Id Filter
     *
     * @param drafterIdFilter
     */
    public void setDrafterIdFilter(Long drafterIdFilter) {

        this.drafterIdFilter = drafterIdFilter;
    }

    /**
     * Set error Status Filter
     *
     * @param errorStatusFilter
     */
    public void setErrorStatusFilter(Boolean errorStatusFilter) {

        this.errorStatusFilter = errorStatusFilter;
    }

    /**
     *
     * Set list notary user id
     *
     * @param selectedUserIds
     */
    public void setNotaryUserIdListFilter(String[] selectedUserIds) {
        this.notaryUserIdListFilter = selectedUserIds;
    }

    /**
     * Set bank ids Filter
     *
     * @param bankIdFilter
     */
    public void setBanksIdFilter(String[] banksIdFilter) {
        this.banksIdFilter = banksIdFilter;
    }

    /**
     * Set contract Summary Filter
     *
     * @param contractSummaryFilter
     * @param kind  Filter kind (FULL, LEFT, MIDDLE)
     */
    public void setContractSummaryFilter(String contractSummaryFilter, FilterKind kind) {

        this.contractSummaryFilter = this.buildFilterString(contractSummaryFilter, kind.getValue());
    }

    /**
     * Get the additionStatusFilter
     *
     * @return the additionStatusFilter
     */
    public Boolean getAdditionStatusFilter() {
        return additionStatusFilter;
    }

    /**
     * Set the additionStatusFilter
     *
     * @param additionStatusFilter the additionStatusFilter to set
     */
    public void setAdditionStatusFilter(Boolean additionStatusFilter) {
        this.additionStatusFilter = additionStatusFilter;
    }

    /**
     * Get the draftUserIdListFilter
     *
     * @return the draftUserIdListFilter
     */
    public String[] getDraftUserIdListFilter() {
        return draftUserIdListFilter;
    }

    /**
     * Set the draftUserIdListFilter
     *
     * @param draftUserIdListFilter the draftUserIdListFilter to set
     */
    public void setDraftUserIdListFilter(String[] draftUserIdListFilter) {
        this.draftUserIdListFilter = draftUserIdListFilter;
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
     * Set the cancellationStatusFilter
     *
     * @param cancellationStatusFilter the cancellationStatusFilter to set
     */
    public void setCancellationStatusFilter(Boolean cancellationStatusFilter) {
        this.cancellationStatusFilter = cancellationStatusFilter;
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
     * Set the propertyInfoFilter
     *
     * @param propertyInfoFilter the propertyInfoFilter to set
     */
    public void setPropertyInfoFilter(String propertyInfoFilter, FilterKind kind) {
        this.propertyInfoFilter = this.buildFilterString(propertyInfoFilter, kind.getValue());
    }

    /**
     * Set the orderKeySearch
     *
     * @param orderKeySearch the orderKeySearch to set
     */
    public void setOrderKeySearch(Boolean orderKeySearch) {
        this.orderKeySearch = orderKeySearch;
    }

    /**
     * Set the drafterIdFlagFilter
     *
     * @param drafterIdFlagFilter the drafterIdFlagFilter to set
     */
    public void setDrafterIdFlagFilter(Boolean drafterIdFlagFilter) {
        this.drafterIdFlagFilter = drafterIdFlagFilter;
    }
}
