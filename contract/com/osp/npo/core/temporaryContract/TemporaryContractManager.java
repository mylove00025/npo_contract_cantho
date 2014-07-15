package com.osp.npo.core.temporaryContract;


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
 * Generate date: 04/26/2011 10:04:43 AM
 * @version $Revision: 29724 $ 
 */
public class TemporaryContractManager extends AbstractManager {

	private Byte typeFilter;
	
	private String contractNumberFilter;
	
	private Long contractIdFilter;

    private Long contractKindIdFilter;

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

    private String[] draftUserIdListFilter;

    private String[] notaryUserIdListFilter;

    private String contractSummaryFilter;

    private String keySearchFilter;

    private List<String> subKeys;

    private String[] banksIdFilter;

    private Boolean isBankIdNullFilter;

    private String propertyInfoFilter;

    private Boolean orderKeySearch = Boolean.TRUE;

    private Boolean drafterIdFlagFilter;

    /**
     * <P>Generate instance</P>
     * 
     * @param  connection  Connection
     */
    public TemporaryContractManager(Connection connection) {
        super(connection);
    }


	/**
	 * Set typeFilter
	 * @param typeFilter the typeFilter to set
	 */
	public void setTypeFilter(Byte typeFilter) {
		this.typeFilter = typeFilter;
	}


	/**
     * <P>Add new infomation</P>
     * 
     * @param  info  Infomation that need add
     * @return  PreparedStatement#executeUpdate Return's Value
     * @throws SQLException
     */
    public int insert(TemporaryContractInfo info) throws SQLException {

        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" INSERT INTO ");
        sqlBuffer.append("npo_temporary_contract");
        sqlBuffer.append(" ( ");
        sqlBuffer.append("type,");
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
        sqlBuffer.append("property_type,");
        sqlBuffer.append("property_info,");
        sqlBuffer.append("owner_info,");
        sqlBuffer.append("other_info,");
        sqlBuffer.append("land_certificate,");
        sqlBuffer.append("land_issue_place,");
        sqlBuffer.append("land_issue_date,");
        sqlBuffer.append("land_map_number,");
        sqlBuffer.append("land_number,");
        sqlBuffer.append("land_address,");
        sqlBuffer.append("land_area,");
        sqlBuffer.append("land_public_area,");
        sqlBuffer.append("land_private_area,");
        sqlBuffer.append("land_use_purpose,");
        sqlBuffer.append("land_use_period,");
        sqlBuffer.append("land_use_origin,");
        sqlBuffer.append("land_associate_property,");
        sqlBuffer.append("car_license_number,");
        sqlBuffer.append("car_regist_number,");
        sqlBuffer.append("car_issue_place,");
        sqlBuffer.append("car_issue_date,");
        sqlBuffer.append("car_frame_number,");
        sqlBuffer.append("car_machine_number,");
        sqlBuffer.append("number_copy_of_contract,");
        sqlBuffer.append("number_of_page,");
        sqlBuffer.append("cost_tt91,");
        sqlBuffer.append("cost_draft,");
        sqlBuffer.append("cost_notary_outsite,");
        sqlBuffer.append("cost_other_determine,");
        sqlBuffer.append("cost_total,");
        sqlBuffer.append("notary_place_flag,");
        sqlBuffer.append("notary_place,");
        sqlBuffer.append("bank_id,");
        sqlBuffer.append("bank_service_fee,");
        sqlBuffer.append("crediter_name,");
        sqlBuffer.append("file_name,");
        sqlBuffer.append("file_path,");
        sqlBuffer.append("original_store_place,");
        sqlBuffer.append("note,");
        sqlBuffer.append("summary,");
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
            psSetByte(ps, i++, info.getType());
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
            psSetString(ps, i++, info.getPropertyType());
            psSetString(ps, i++, info.getPropertyInfo());
            psSetString(ps, i++, info.getOwnerInfo());
            psSetString(ps, i++, info.getOtherInfo());
            psSetString(ps, i++, info.getLandCertificate());
            psSetString(ps, i++, info.getLandIssuePlace());
            psSetTimestamp(ps, i++, info.getLandIssueDate());
            psSetString(ps, i++, info.getLandMapNumber());
            psSetString(ps, i++, info.getLandNumber());
            psSetString(ps, i++, info.getLandAddress());
            psSetString(ps, i++, info.getLandArea());
            psSetString(ps, i++, info.getLandPublicArea());
            psSetString(ps, i++, info.getLandPrivateArea());
            psSetString(ps, i++, info.getLandUsePurpose());
            psSetString(ps, i++, info.getLandUsePeriod());
            psSetString(ps, i++, info.getLandUseOrigin());
            psSetString(ps, i++, info.getLandAssociateProperty());
            psSetString(ps, i++, info.getCarLicenseNumber());
            psSetString(ps, i++, info.getCarRegistNumber());
            psSetString(ps, i++, info.getCarIssuePlace());
            psSetTimestamp(ps, i++, info.getCarIssueDate());
            psSetString(ps, i++, info.getCarFrameNumber());
            psSetString(ps, i++, info.getCarMachineNumber());
            psSetString(ps, i++, info.getNumberCopyOfContract());
            psSetString(ps, i++, info.getNumberOfPage());
            psSetString(ps, i++, info.getCostTt91());
            psSetString(ps, i++, info.getCostDraft());
            psSetString(ps, i++, info.getCostNotaryOutsite());
            psSetString(ps, i++, info.getCostOtherDetermine());
            psSetString(ps, i++, info.getCostTotal());
            psSetBoolean(ps, i++, info.getNotaryPlaceFlag());
            psSetString(ps, i++, info.getNotaryPlace());
            psSetLong(ps, i++, info.getBankId());
            psSetString(ps, i++, info.getBankServiceFee());
            psSetString(ps, i++, info.getCrediterName());
            psSetString(ps, i++, info.getFileName());
            psSetString(ps, i++, info.getFilePath());
            psSetString(ps, i++, info.getOriginalStorePlace());
            psSetString(ps, i++, info.getNote());
            psSetString(ps, i++, info.getSummary());
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
            info.setTcid(new Long(generatedId));
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
        sqlBuffer.append(" npo_temporary_contract ");
        sqlBuffer.append(" WHERE ");
        sqlBuffer.append(" tcid = ? ");

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
    public int update(TemporaryContractInfo info) throws SQLException, IOException {

        ArrayList<String> sqlList = new ArrayList<String>();
        ArrayList<Object> prmList = new ArrayList<Object>();

        //Evaluate Null value, create parameter list for SQL Statement.
        makeUpdateList(info, sqlList, prmList);

        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" UPDATE ");
        sqlBuffer.append("npo_temporary_contract");
        sqlBuffer.append(" SET ");
        sqlBuffer.append("tcid=?");

        //Result of SQL Statement
        for (int i = 0; i < sqlList.size(); i++) {
            sqlBuffer.append(sqlList.get(i));
        }

        sqlBuffer.append(" WHERE ");
        sqlBuffer.append("tcid=?");
        this.setSql(sqlBuffer.toString());

        PreparedStatement ps = null;
        int result;

        try {
            Connection c = this.getConnection();
            ps = c.prepareStatement(this.getSql());

            int i = 1;

            psSetLong(ps, i++, info.getTcid());
            
            for (int j = 0; j < prmList.size(); j++) {
                psSetObject(ps, i++, prmList.get(j));
            }
            psSetLong(ps, i++, info.getTcid());

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
    public TemporaryContractList select(boolean forUpdate, int offset, int limit) throws SQLException, IOException {

        ArrayList<Object> prmList = new ArrayList<Object>();
        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" SELECT ");
        sqlBuffer.append(" ntc.*, ");
        sqlBuffer.append(" nct.name ");
        sqlBuffer.append(" FROM ");
        sqlBuffer.append(" npo_temporary_contract ntc ");
        sqlBuffer.append(" INNER JOIN npo_contract_template nct ON ntc.contract_template_id = nct.id ");
       
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
        TemporaryContractList list = null;
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

            TemporaryContractInfo info = null;
            list = new TemporaryContractList();
            while(rs.next()) {
                info = new TemporaryContractInfo();
                rsSetInfo(rs, info);
                
                info.setContractTemplateName(rsGetString(rs, "name"));
                
                list.add(info);
            }
        } finally {
            close(ps, rs);
        }

        return list;
    }
    
    /**
     * <P>Get record by ID</P>
     * 
     * @param tcid Temporary contract ID
     * @param  forUpdate  Use FOR UPDATE (Yes or No)
     * @return  List of info that geted
     * @throws SQLException
     */
    public TemporaryContractInfo selectByTcid(Long tcid, boolean forUpdate) throws SQLException {

        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" SELECT ");
        sqlBuffer.append(" ntc.tcid,");
        sqlBuffer.append(" ntc.type,");
        sqlBuffer.append(" ntc.contract_template_id,");
        sqlBuffer.append(" nct.name as contract_template_name,");
        sqlBuffer.append(" nct.code as contract_template_code,");
        sqlBuffer.append(" ntc.contract_number,");
        sqlBuffer.append(" ntc.relation_object_A,");
        sqlBuffer.append(" ntc.relation_object_B,");
        sqlBuffer.append(" ntc.relation_object_C,");
        sqlBuffer.append(" ntc.contract_value,");
        sqlBuffer.append(" ntc.notary_id,");
        sqlBuffer.append(" ntc.drafter_id,");
        sqlBuffer.append(" ntc.notary_date,");
        sqlBuffer.append(" ntc.user_require_contract, ");
        sqlBuffer.append(" ntc.number_copy_of_contract, ");
        sqlBuffer.append(" ntc.number_of_page, ");
        sqlBuffer.append(" ntc.received_date,");
        sqlBuffer.append(" ntc.notary_place,");
        sqlBuffer.append(" ntc.notary_place_flag,");
        sqlBuffer.append(" ntc.summary,");
        sqlBuffer.append(" ntc.cost_tt91,");
        sqlBuffer.append(" ntc.cost_draft,");
        sqlBuffer.append(" ntc.cost_notary_outsite,");
        sqlBuffer.append(" ntc.cost_other_determine,");
        sqlBuffer.append(" ntc.cost_total,");
        sqlBuffer.append(" ntc.bank_id,");
        sqlBuffer.append(" ntc.note,");
        sqlBuffer.append(" nb.name as bank_name,");
        sqlBuffer.append(" ntc.bank_service_fee,");
        sqlBuffer.append(" ntc.crediter_name,");
        sqlBuffer.append(" ntc.file_name,");
        sqlBuffer.append(" ntc.file_path,");
        sqlBuffer.append(" ntc.original_store_place,");
        sqlBuffer.append(" ntc.property_type, ");
        sqlBuffer.append(" ntc.property_info, ");
        sqlBuffer.append(" ntc.owner_info, ");
        sqlBuffer.append(" ntc.other_info, ");
        sqlBuffer.append(" ntc.land_certificate, ");
        sqlBuffer.append(" ntc.land_issue_place, ");
        sqlBuffer.append(" ntc.land_issue_date, ");
        sqlBuffer.append(" ntc.land_map_number, ");
        sqlBuffer.append(" ntc.land_number, ");
        sqlBuffer.append(" ntc.land_address, ");
        sqlBuffer.append(" ntc.land_area, ");
        sqlBuffer.append(" ntc.land_public_area, ");        
        sqlBuffer.append(" ntc.land_private_area, ");
        sqlBuffer.append(" ntc.land_use_purpose, ");
        sqlBuffer.append(" ntc.land_use_period, ");
        sqlBuffer.append(" ntc.land_use_origin, ");
        sqlBuffer.append(" ntc.land_associate_property, ");
        sqlBuffer.append(" ntc.car_license_number, ");
        sqlBuffer.append(" ntc.car_regist_number, ");        
        sqlBuffer.append(" ntc.car_issue_place, ");
        sqlBuffer.append(" ntc.car_issue_date, ");
        sqlBuffer.append(" ntc.car_frame_number, ");
        sqlBuffer.append(" ntc.car_machine_number, ");
        sqlBuffer.append(" ntc.entry_user_id,");
        sqlBuffer.append(" ntc.entry_user_name,");
        sqlBuffer.append(" ntc.entry_date_time,");
        sqlBuffer.append(" ntc.update_user_id,");
        sqlBuffer.append(" ntc.update_user_name,");
        sqlBuffer.append(" ntc.update_date_time,");
        sqlBuffer.append(" nu1.family_name as notary_family_name,");
        sqlBuffer.append(" nu1.first_name as notary_first_name,");
        sqlBuffer.append(" nu2.family_name as drafter_family_name,");
        sqlBuffer.append(" nu2.first_name as drafter_first_name,");
        sqlBuffer.append(" nck.id as contract_kind_id,");
        sqlBuffer.append(" nck.name as contract_kind_name");
        sqlBuffer.append(" FROM ");
        sqlBuffer.append(" npo_temporary_contract ntc");
        sqlBuffer.append(" INNER JOIN npo_contract_template nct ON ntc.contract_template_id = nct.id ");
        sqlBuffer.append(" LEFT JOIN ");
        sqlBuffer.append(" npo_user nu1 ");
        sqlBuffer.append(" ON ");
        sqlBuffer.append(" ntc.notary_id = nu1.id ");
        sqlBuffer.append(" LEFT JOIN ");
        sqlBuffer.append(" npo_user nu2 ");
        sqlBuffer.append(" ON ");
        sqlBuffer.append(" ntc.drafter_id = nu2.id ");
        sqlBuffer.append(" LEFT JOIN ");
        sqlBuffer.append(" npo_bank nb ");
        sqlBuffer.append(" ON ");
        sqlBuffer.append(" ntc.bank_id = nb.id ");
        sqlBuffer.append(" LEFT JOIN ");
        sqlBuffer.append(" npo_contract_kind nck ");
        sqlBuffer.append(" ON ");
        sqlBuffer.append(" nct.kind_id = nck.id ");
        sqlBuffer.append(" WHERE ");
        sqlBuffer.append(" tcid=? ");

        if(forUpdate) {
            sqlBuffer.append(" FOR UPDATE ");
        }
        
        this.setSql(sqlBuffer.toString());

        PreparedStatement ps = null;
        ResultSet rs = null;
        
        TemporaryContractInfo info = null;
        
        try {
            Connection c = this.getConnection();
            ps = c.prepareStatement(this.getSql());

            psSetLong(ps, 1, tcid);
            
            rs = ps.executeQuery();
            
            while(rs.next()) {
                info = new TemporaryContractInfo();
                rsSetInfo(rs, info);
                info.setContractTemplateName(rsGetString(rs, "contract_template_name"));
                info.setContractKindId(rsGetLong(rs, "contract_kind_id"));
                info.setContractKindName(rsGetString(rs, "contract_kind_name"));
                info.setNotaryFamilyName(rsGetString(rs, "notary_family_name"));
                info.setNotaryFirstName(rsGetString(rs, "notary_first_name"));
                info.setDrafterFamilyName(rsGetString(rs, "drafter_family_name"));
                info.setDrafterFirstName(rsGetString(rs, "drafter_first_name"));
                info.setBankName(rsGetString(rs, "bank_name"));

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
     * @throws IOException 
     */
    public int countTotal() throws SQLException, IOException {

    	ArrayList<Object> prmList = new ArrayList<Object>();
    	
        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" SELECT ");
        sqlBuffer.append(" COUNT(*) ");
        sqlBuffer.append(" FROM ");
        sqlBuffer.append("npo_temporary_contract ntc");
        sqlBuffer.append(" INNER JOIN npo_contract_template nct ON ntc.contract_template_id = nct.id ");
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
    private void rsSetInfo(ResultSet rs,TemporaryContractInfo info) throws SQLException {

        info.setTcid(rsGetLong(rs, "tcid"));
        info.setType(rsGetByte(rs, "type"));
        info.setContractTemplateId(rsGetLong(rs, "contract_template_id"));
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
        info.setPropertyType(rsGetString(rs, "property_type"));
        info.setPropertyInfo(rsGetString(rs, "property_info"));
        info.setOwnerInfo(rsGetString(rs, "owner_info"));
        info.setOtherInfo(rsGetString(rs, "other_info"));
        info.setLandCertificate(rsGetString(rs, "land_certificate"));
        info.setLandIssuePlace(rsGetString(rs, "land_issue_place"));
        info.setLandIssueDate(rsGetTimestamp(rs, "land_issue_date"));
        info.setLandMapNumber(rsGetString(rs, "land_map_number"));
        info.setLandNumber(rsGetString(rs, "land_number"));
        info.setLandAddress(rsGetString(rs, "land_address"));
        info.setLandArea(rsGetString(rs, "land_area"));
        info.setLandPublicArea(rsGetString(rs, "land_public_area"));
        info.setLandPrivateArea(rsGetString(rs, "land_private_area"));
        info.setLandUsePurpose(rsGetString(rs, "land_use_purpose"));
        info.setLandUsePeriod(rsGetString(rs, "land_use_period"));
        info.setLandUseOrigin(rsGetString(rs, "land_use_origin"));
        info.setLandAssociateProperty(rsGetString(rs, "land_associate_property"));
        info.setCarLicenseNumber(rsGetString(rs, "car_license_number"));
        info.setCarRegistNumber(rsGetString(rs, "car_regist_number"));
        info.setCarIssuePlace(rsGetString(rs, "car_issue_place"));
        info.setCarIssueDate(rsGetTimestamp(rs, "car_issue_date"));
        info.setCarFrameNumber(rsGetString(rs, "car_frame_number"));
        info.setCarMachineNumber(rsGetString(rs, "car_machine_number"));
        info.setNumberCopyOfContract(rsGetString(rs, "number_copy_of_contract"));
        info.setNumberOfPage(rsGetString(rs, "number_of_page"));
        info.setCostTt91(rsGetString(rs, "cost_tt91"));
        info.setCostDraft(rsGetString(rs, "cost_draft"));
        info.setCostNotaryOutsite(rsGetString(rs, "cost_notary_outsite"));
        info.setCostOtherDetermine(rsGetString(rs, "cost_other_determine"));
        info.setCostTotal(rsGetString(rs, "cost_total"));
        info.setNotaryPlaceFlag(rsGetBoolean(rs, "notary_place_flag"));
        info.setNotaryPlace(rsGetString(rs, "notary_place"));
        info.setBankId(rsGetLong(rs, "bank_id"));
        info.setBankServiceFee(rsGetString(rs, "bank_service_fee"));
        info.setCrediterName(rsGetString(rs, "crediter_name"));
        info.setFileName(rsGetString(rs, "file_name"));
        info.setFilePath(rsGetString(rs, "file_path"));
        info.setOriginalStorePlace(rsGetString(rs, "original_store_place"));
        info.setNote(rsGetString(rs, "note"));
        info.setSummary(rsGetString(rs, "summary"));
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
    private void makeUpdateList(TemporaryContractInfo info, ArrayList<String> sqlList,ArrayList<Object> prmList){

        addUpdateList(info.getType(), ",type=?", sqlList, prmList);
        addUpdateList(info.getContractTemplateId(), ",contract_template_id=?", sqlList, prmList);
        addUpdateList(info.getContractNumber(), ",contract_number=?", sqlList, prmList);
        addUpdateList(info.getContractValue(), ",contract_value=?",true, sqlList, prmList);
        addUpdateList(info.getRelationObjectA(), ",relation_object_A=?", sqlList, prmList);
        addUpdateList(info.getRelationObjectB(), ",relation_object_B=?", sqlList, prmList);
        addUpdateList(info.getRelationObjectC(), ",relation_object_C=?", sqlList, prmList);
        addUpdateList(info.getNotaryId(), ",notary_id=?", sqlList, prmList);
        addUpdateList(info.getDrafterId(), ",drafter_id=?", sqlList, prmList);
        addUpdateList(info.getReceivedDate(), ",received_date=?",true, sqlList, prmList);
        addUpdateList(info.getNotaryDate(), ",notary_date=?",true, sqlList, prmList);
        addUpdateList(info.getUserRequireContract(), ",user_require_contract=?", sqlList, prmList);
        addUpdateList(info.getPropertyType(), ",property_type=?", sqlList, prmList);
        addUpdateList(info.getPropertyInfo(), ",property_info=?", sqlList, prmList);
        addUpdateList(info.getOwnerInfo(), ",owner_info=?", sqlList, prmList);
        addUpdateList(info.getOtherInfo(), ",other_info=?", sqlList, prmList);
        addUpdateList(info.getLandCertificate(), ",land_certificate=?", sqlList, prmList);
        addUpdateList(info.getLandIssuePlace(), ",land_issue_place=?", sqlList, prmList);
        addUpdateList(info.getLandIssueDate(), ",land_issue_date=?", true, sqlList, prmList);
        addUpdateList(info.getLandMapNumber(), ",land_map_number=?", sqlList, prmList);
        addUpdateList(info.getLandNumber(), ",land_number=?", sqlList, prmList);
        addUpdateList(info.getLandAddress(), ",land_address=?", sqlList, prmList);
        addUpdateList(info.getLandArea(), ",land_area=?", sqlList, prmList);
        addUpdateList(info.getLandPublicArea(), ",land_public_area=?", sqlList, prmList);
        addUpdateList(info.getLandPrivateArea(), ",land_private_area=?", sqlList, prmList);
        addUpdateList(info.getLandUsePurpose(), ",land_use_purpose=?", sqlList, prmList);
        addUpdateList(info.getLandUsePeriod(), ",land_use_period=?", sqlList, prmList);
        addUpdateList(info.getLandUseOrigin(), ",land_use_origin=?", sqlList, prmList);
        addUpdateList(info.getLandAssociateProperty(), ",land_associate_property=?", sqlList, prmList);
        addUpdateList(info.getCarLicenseNumber(), ",car_license_number=?", sqlList, prmList);
        addUpdateList(info.getCarRegistNumber(), ",car_regist_number=?", sqlList, prmList);
        addUpdateList(info.getCarIssuePlace(), ",car_issue_place=?", sqlList, prmList);
        addUpdateList(info.getCarIssueDate(), ",car_issue_date=?", true, sqlList, prmList);
        addUpdateList(info.getCarFrameNumber(), ",car_frame_number=?", sqlList, prmList);
        addUpdateList(info.getCarMachineNumber(), ",car_machine_number=?", sqlList, prmList);
        addUpdateList(info.getNumberCopyOfContract(), ",number_copy_of_contract=?", sqlList, prmList);
        addUpdateList(info.getNumberOfPage(), ",number_of_page=?", sqlList, prmList);
        addUpdateList(info.getCostTt91(), ",cost_tt91=?",true, sqlList, prmList);
        addUpdateList(info.getCostDraft(), ",cost_draft=?",true, sqlList, prmList);
        addUpdateList(info.getCostNotaryOutsite(), ",cost_notary_outsite=?",true, sqlList, prmList);
        addUpdateList(info.getCostOtherDetermine(), ",cost_other_determine=?",true, sqlList, prmList);
        addUpdateList(info.getCostTotal(), ",cost_total=?",true, sqlList, prmList);
        addUpdateList(info.getNotaryPlaceFlag(), ",notary_place_flag=?", sqlList, prmList);
        addUpdateList(info.getNotaryPlace(), ",notary_place=?", sqlList, prmList);
        addUpdateList(info.getBankId(), ",bank_id=?",true, sqlList, prmList);
        addUpdateList(info.getBankServiceFee(), ",bank_service_fee=?",true, sqlList, prmList);
        addUpdateList(info.getCrediterName(), ",crediter_name=?",true, sqlList, prmList);
        addUpdateList(info.getFileName(), ",file_name=?", sqlList, prmList);
        addUpdateList(info.getFilePath(), ",file_path=?", sqlList, prmList);
        addUpdateList(info.getOriginalStorePlace(), ",original_store_place=?", sqlList, prmList);
        addUpdateList(info.getNote(), ",note=?",true, sqlList, prmList);
        addUpdateList(info.getSummary(), ",summary=?",true, sqlList, prmList);
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
        
        if (this.contractNumberFilter != null) {
            appendAnd(filterBuffer);
            filterBuffer.append("ntc.contract_number LIKE ?");
            prmList.add(this.contractNumberFilter);
        }
        
        if (this.typeFilter != null) {
            appendAnd(filterBuffer);
            filterBuffer.append("ntc.type = ?");
            prmList.add(this.typeFilter);
        }
        if (this.contractIdFilter !=  null) {
            appendAnd(filterBuffer);
            filterBuffer.append(" ntc.id = ? ");
            prmList.add(this.contractIdFilter);
        }

        if (this.contractKindIdFilter !=  null) {
            appendAnd(filterBuffer);
            filterBuffer.append(" nct.kind_id = ? ");
            prmList.add(this.contractKindIdFilter);
        }

        if (this.bankIdFilter !=  null) {
            appendAnd(filterBuffer);
            filterBuffer.append(" ntc.bank_id = ? ");
            prmList.add(this.bankIdFilter);
        }

        if (this.isBankIdNullFilter !=  null) {
            if (this.isBankIdNullFilter == Boolean.TRUE) {
                appendAnd(filterBuffer);
                filterBuffer.append(" ntc.bank_id IS NULL ");
            } else {
                appendAnd(filterBuffer);
                filterBuffer.append(" ntc.bank_id IS NOT NULL ");
            }
        }

        if (this.contractTemplateIdFilter !=  null) {
            appendAnd(filterBuffer);
            filterBuffer.append(" ntc.contract_template_id = ? ");
            prmList.add(this.contractTemplateIdFilter);
        }

        if (this.drafterIdFilter !=  null) {
            appendAnd(filterBuffer);
            filterBuffer.append(" ntc.drafter_id = ? ");
            prmList.add(this.drafterIdFilter);
        }

        if (this.drafterIdFlagFilter !=  null) {
            if (this.drafterIdFlagFilter == Boolean.FALSE) {
                appendAnd(filterBuffer);
                filterBuffer.append(" ntc.drafter_id = ? ");
                prmList.add(this.drafterIdFilter);
            } else {
                appendAnd(filterBuffer);
                filterBuffer.append(" ntc.drafter_id IS NOT NULL ");
            }
        }
        
        if (this.notaryIdFilter !=  null) {
            appendAnd(filterBuffer);
            filterBuffer.append(" ntc.notary_id= ? ");
            prmList.add(this.notaryIdFilter);
        }

        if (this.notaryDateFilter !=  null) {
            appendAnd(filterBuffer);
            filterBuffer.append(" ntc.entry_date_time = ? ");
            prmList.add(this.notaryDateFilter);
        }

        if (this.notaryDateFromFilter !=  null) {
            appendAnd(filterBuffer);
            filterBuffer.append(" ntc.entry_date_time >= ? ");
            prmList.add(this.notaryDateFromFilter);
        }

        if (this.notaryDateToFilter !=  null) {
            appendAnd(filterBuffer);
            filterBuffer.append(" ntc.entry_date_time <= ? ");
            prmList.add(this.notaryDateToFilter);
        }

        if (this.notaryPlaceFilter !=  null) {
            appendAnd(filterBuffer);
            filterBuffer.append(" ntc.notary_place_flag = ? ");
            prmList.add(this.notaryPlaceFilter);
        }

        if (this.relationObjectAFilter !=  null) {
            appendAnd(filterBuffer);
            filterBuffer.append(" ntc.relation_object_A LIKE ? ");
            prmList.add(this.relationObjectAFilter);
        }

        if (this.relationObjectBFilter !=  null) {
            appendAnd(filterBuffer);
            filterBuffer.append(" ntc.relation_object_B LIKE ? ");
            prmList.add(this.relationObjectBFilter);
        }

        if (this.relationObjectCFilter !=  null) {
            appendAnd(filterBuffer);
            filterBuffer.append(" ntc.relation_object_C LIKE ? ");
            prmList.add(this.relationObjectCFilter);
        }

        if (this.draftUserIdListFilter != null && this.draftUserIdListFilter.length > 0) {
            appendAnd(filterBuffer);
            filterBuffer.append(" ntc.drafter_id IN (");
            for (int i = 0; i< this.draftUserIdListFilter.length; i++) {
                filterBuffer.append(" " + this.draftUserIdListFilter[i] + ",");
            }
            filterBuffer.append(" -1) ");
        }

        if (this.notaryUserIdListFilter != null && this.notaryUserIdListFilter.length > 0) {
            appendAnd(filterBuffer);
            filterBuffer.append(" ntc.notary_id IN (");
            for (int i = 0; i< this.notaryUserIdListFilter.length; i++) {
                filterBuffer.append(" " + this.notaryUserIdListFilter[i] + ",");
            }
            filterBuffer.append(" -1) ");
        }

        if (this.banksIdFilter != null && this.banksIdFilter.length > 0) {
            appendAnd(filterBuffer);
            filterBuffer.append(" ntc.bank_id IN (");
            for (int i = 0; i< this.banksIdFilter.length; i++) {
                filterBuffer.append(" " + this.banksIdFilter[i] + ",");
            }
            filterBuffer.append(" -1) ");
        }

        if (this.relationObjectFilter !=  null) {
            appendAnd(filterBuffer);
            filterBuffer.append(" ( ");

            filterBuffer.append(" ntc.relation_object_A LIKE ? ");
            prmList.add(this.relationObjectFilter);

            appendOr(filterBuffer);
            filterBuffer.append(" ntc.relation_object_B LIKE ? ");
            prmList.add(this.relationObjectFilter);

            appendOr(filterBuffer);
            filterBuffer.append(" ntc.relation_object_C LIKE ? ");
            prmList.add(this.relationObjectFilter);

            filterBuffer.append(" ) ");
        }

        if (this.contractSummaryFilter !=  null) {
            appendAnd(filterBuffer);
            filterBuffer.append(" nct.summary LIKE ? ");
            prmList.add(this.contractSummaryFilter);
        }

        if (this.propertyInfoFilter !=  null) {
            appendAnd(filterBuffer);
            filterBuffer.append(" ntc.property_info LIKE ? ");
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
                    filterBuffer.append(" MATCH(ntc.contract_number, ntc.relation_object_A, ntc.relation_object_B, " +
                            "ntc.relation_object_C, ntc.user_require_contract, ntc.notary_place, ntc.crediter_name, " +
                            "ntc.original_store_place, ntc.note, ntc.summary, " +
                            "nct.name, ntc.property_info) " );
                    filterBuffer.append(" AGAINST(? IN BOOLEAN MODE) ");
                    prmList.add(subkey);

                    if (subkey.charAt(0) == '"') {
                        subkey = subkey.substring(1, subkey.length() - 1);
                    }

                    if (subkey.charAt(subkey.length() - 1) == '"') {
                        subkey = subkey.substring(0, subkey.length() - 2);
                    }

                    appendOr(filterBuffer);
                    filterBuffer.append(" ntc.contract_number LIKE ? ");
                    prmList.add(buildFilterString(subkey, FilterKind.MIDDLE.getValue()));

                    appendOr(filterBuffer);
                    filterBuffer.append(" ntc.relation_object_A LIKE ? ");
                    prmList.add(buildFilterString(subkey, FilterKind.MIDDLE.getValue()));

                    appendOr(filterBuffer);
                    filterBuffer.append(" ntc.relation_object_B LIKE ? ");
                    prmList.add(buildFilterString(subkey, FilterKind.MIDDLE.getValue()));

                    appendOr(filterBuffer);
                    filterBuffer.append(" ntc.relation_object_C LIKE ? ");
                    prmList.add(buildFilterString(subkey, FilterKind.MIDDLE.getValue()));

                    appendOr(filterBuffer);
                    filterBuffer.append(" ntc.user_require_contract LIKE ? ");
                    prmList.add(buildFilterString(subkey, FilterKind.MIDDLE.getValue()));

                    appendOr(filterBuffer);
                    filterBuffer.append(" ntc.notary_place LIKE ? ");
                    prmList.add(buildFilterString(subkey, FilterKind.MIDDLE.getValue()));

                    appendOr(filterBuffer);
                    filterBuffer.append(" ntc.crediter_name LIKE ? ");
                    prmList.add(buildFilterString(subkey, FilterKind.MIDDLE.getValue()));

                    appendOr(filterBuffer);
                    filterBuffer.append(" ntc.original_store_place LIKE ? ");
                    prmList.add(buildFilterString(subkey, FilterKind.MIDDLE.getValue()));

                    appendOr(filterBuffer);
                    filterBuffer.append(" ntc.note LIKE ? ");
                    prmList.add(buildFilterString(subkey, FilterKind.MIDDLE.getValue()));

                    appendOr(filterBuffer);
                    filterBuffer.append(" ntc.summary LIKE ? ");
                    prmList.add(buildFilterString(subkey, FilterKind.MIDDLE.getValue()));

                    appendOr(filterBuffer);
                    filterBuffer.append(" nct.name LIKE ? ");
                    prmList.add(buildFilterString(subkey, FilterKind.MIDDLE.getValue()));

                    appendOr(filterBuffer);
                    filterBuffer.append(" ntc.property_info LIKE ? ");
                    prmList.add(buildFilterString(subkey, FilterKind.MIDDLE.getValue()));

                    filterBuffer.append(" ) ");
                }
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


	/**
	 * @param contractNumberFilter the contractNumberFilter to set
	 */
	public void setContractNumberFilter(String contractNumberFilter, FilterKind kind) {
		this.contractNumberFilter = this.buildFilterString(contractNumberFilter, kind.getValue());
	}



}
