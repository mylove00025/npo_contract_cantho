package com.osp.npo.core.prevent;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.mysql.jdbc.Statement;
import com.osp.npo.common.global.Constants;
import com.osp.npo.common.global.Constants.FilterKind;
import com.osp.npo.core.AbstractManager;


/**
 * Generate by script
 * Generate date: 1/22/2011 8:59:06 AM
 * @version $Revision: 29790 $
 */
public class DataPreventManager extends AbstractManager {

    /**
     * filter property
     */
    private Long idFilter;

    private String typeFilter;

    private String propertyInfoFilter;

    private String landCertificateFilter;

    private String landMapNumberFilter;

    private String landNumberFilter;

    private String landAddressFilter;

    private String carLicenseNumberFilter;

    private String carRegistNumberFilter;

    private String carFrameNumberFilter;

    private String carMachineNumberFilter;

    private String typeKeySearchFilter;

    private String keySearchFilter;

    private String originKindFilter;

    private Boolean releaseFlgFilter;

    private Boolean deleteFlgFilter;

    private List<String> subKeys;
    
    private String officeCode;

    /**
     * set filter
     */

    /**
     * Set Id filter
     *
     * @param id for id filter
     */
    public void setIdFilter(Long id) {
        this.idFilter = id;
    }


    /**
     * <P>Generate instance</P>
     *
     * @param  connection  Connection
     */
    public DataPreventManager(Connection connection) {
        super(connection);
    }


    /**
     * <P>Add new infomation</P>
     *
     * @param  info  Infomation that need add
     * @return  PreparedStatement#executeUpdate Return's Value
     * @throws SQLException
     */
    public int insert(DataPreventInfo info) throws SQLException {

        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" INSERT INTO ");
        sqlBuffer.append("npo_data_prevent");
        sqlBuffer.append(" ( ");
        sqlBuffer.append("synchronize_id,");
        sqlBuffer.append("property_id,");
        sqlBuffer.append("origin_kind,");
        sqlBuffer.append("delete_flg,");
        sqlBuffer.append("prevent_regist_agency,");
        sqlBuffer.append("prevent_in_book_number,");
        sqlBuffer.append("prevent_person_info,");
        sqlBuffer.append("prevent_doc_number,");
        sqlBuffer.append("prevent_doc_date,");
        sqlBuffer.append("prevent_doc_receive_date,");
        sqlBuffer.append("prevent_input_date,");
        sqlBuffer.append("prevent_doc_summary,");
        sqlBuffer.append("prevent_file_name,");
        sqlBuffer.append("prevent_file_path,");
        sqlBuffer.append("prevent_note,");
        sqlBuffer.append("release_flg,");
        sqlBuffer.append("release_regist_agency,");
        sqlBuffer.append("release_in_book_number,");
        sqlBuffer.append("release_person_info,");
        sqlBuffer.append("release_doc_number,");
        sqlBuffer.append("release_doc_date,");
        sqlBuffer.append("release_doc_receive_date,");
        sqlBuffer.append("release_input_date,");
        sqlBuffer.append("release_doc_summary,");
        sqlBuffer.append("release_file_name,");
        sqlBuffer.append("release_file_path,");
        sqlBuffer.append("release_note,");
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
            psSetLong(ps, i++, info.getPropertyId());
            psSetString(ps, i++, info.getOriginKind());
            psSetBoolean(ps, i++, info.getDeleteFlg());
            psSetString(ps, i++, info.getPreventRegistAgency());
            psSetString(ps, i++, info.getPreventInBookNumber());
            psSetString(ps, i++, info.getPreventPersonInfo());
            psSetString(ps, i++, info.getPreventDocNumber());
            psSetTimestamp(ps, i++, info.getPreventDocDate());
            psSetTimestamp(ps, i++, info.getPreventDocReceiveDate());
            psSetTimestamp(ps, i++, info.getPreventInputDate());
            psSetString(ps, i++, info.getPreventDocSummary());
            psSetString(ps, i++, info.getPreventFileName());
            psSetString(ps, i++, info.getPreventFilePath());
            psSetString(ps, i++, info.getPreventNote());
            psSetBoolean(ps, i++, info.getReleaseFlg());
            psSetString(ps, i++, info.getReleaseRegistAgency());
            psSetString(ps, i++, info.getReleaseInBookNumber());
            psSetString(ps, i++, info.getReleasePersonInfo());
            psSetString(ps, i++, info.getReleaseDocNumber());
            psSetTimestamp(ps, i++, info.getReleaseDocDate());
            psSetTimestamp(ps, i++, info.getReleaseDocReceiveDate());
            psSetTimestamp(ps, i++, info.getReleaseInputDate());
            psSetString(ps, i++, info.getReleaseDocSummary());
            psSetString(ps, i++, info.getReleaseFileName());
            psSetString(ps, i++, info.getReleaseFilePath());
            psSetString(ps, i++, info.getReleaseNote());
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
        sqlBuffer.append(" npo_data_prevent ");
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
    public int update(DataPreventInfo info) throws SQLException, IOException {

        ArrayList<String> sqlList = new ArrayList<String>();
        ArrayList<Object> prmList = new ArrayList<Object>();

        //Evaluate Null value, create parameter list for SQL Statement.
        makeUpdateList(info, sqlList, prmList);

        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" UPDATE ");
        sqlBuffer.append("npo_data_prevent");
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
    public DataPreventList select(boolean forUpdate, int offset, int limit) throws SQLException, IOException {

        ArrayList<Object> prmList = new ArrayList<Object>();
        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" SELECT ");
        // data prevent info
        sqlBuffer.append(" ndp.id as id , ");
        sqlBuffer.append(" ndp.synchronize_id as synchronize_id, ");
        sqlBuffer.append(" ndp.property_id as property_id , ");
        sqlBuffer.append(" ndp.origin_kind as origin_kind , ");
        sqlBuffer.append(" ndp.delete_flg as delete_flg , ");
        sqlBuffer.append(" ndp.prevent_regist_agency as prevent_regist_agency , ");
        sqlBuffer.append(" ndp.prevent_in_book_number as prevent_in_book_number , ");
        sqlBuffer.append(" ndp.prevent_person_info as prevent_person_info , ");
        sqlBuffer.append(" ndp.prevent_doc_number as prevent_doc_number , ");
        sqlBuffer.append(" ndp.prevent_doc_date as prevent_doc_date , ");
        sqlBuffer.append(" ndp.prevent_doc_receive_date as prevent_doc_receive_date , ");
        sqlBuffer.append(" ndp.prevent_input_date as prevent_input_date , ");
        sqlBuffer.append(" ndp.prevent_doc_summary as prevent_doc_summary , ");
        sqlBuffer.append(" ndp.prevent_file_name as prevent_file_name , ");
        sqlBuffer.append(" ndp.prevent_file_path as prevent_file_path , ");
        sqlBuffer.append(" ndp.prevent_note as prevent_note , ");
        sqlBuffer.append(" ndp.release_flg as release_flg , ");
        sqlBuffer.append(" ndp.release_regist_agency as release_regist_agency , ");
        sqlBuffer.append(" ndp.release_in_book_number as release_in_book_number , ");
        sqlBuffer.append(" ndp.release_person_info as release_person_info , ");
        sqlBuffer.append(" ndp.release_doc_number as release_doc_number , ");
        sqlBuffer.append(" ndp.release_doc_date as release_doc_date , ");
        sqlBuffer.append(" ndp.release_doc_receive_date as release_doc_receive_date , ");
        sqlBuffer.append(" ndp.release_input_date as release_input_date , ");
        sqlBuffer.append(" ndp.release_doc_summary as release_doc_summary , ");
        sqlBuffer.append(" ndp.release_file_name as release_file_name , ");
        sqlBuffer.append(" ndp.release_file_path as release_file_path , ");
        sqlBuffer.append(" ndp.release_note as release_note , ");
        // property prevent info
        sqlBuffer.append(" npp.type as type , ");
        sqlBuffer.append(" npp.property_info as property_info , ");
        sqlBuffer.append(" npp.owner_info as owner_info , ");
        sqlBuffer.append(" npp.other_info as other_info , ");
        sqlBuffer.append(" npp.land_certificate as land_certificate , ");
        sqlBuffer.append(" npp.land_issue_place as land_issue_place , ");
        sqlBuffer.append(" npp.land_issue_date as land_issue_date , ");
        sqlBuffer.append(" npp.land_map_number as land_map_number , ");
        sqlBuffer.append(" npp.land_number as land_number , ");
        sqlBuffer.append(" npp.land_address as land_address , ");
        sqlBuffer.append(" npp.land_area as land_area , ");
        sqlBuffer.append(" npp.land_public_area as land_public_area , ");
        sqlBuffer.append(" npp.land_private_area as land_private_area , ");
        sqlBuffer.append(" npp.land_use_purpose as land_use_purpose , ");
        sqlBuffer.append(" npp.land_use_period as land_use_period , ");
        sqlBuffer.append(" npp.land_use_origin as land_use_origin , ");
        sqlBuffer.append(" npp.land_associate_property as land_associate_property , ");
        sqlBuffer.append(" npp.land_district as land_district , ");
        sqlBuffer.append(" npp.land_province as land_province , ");
        sqlBuffer.append(" npp.car_license_number as car_license_number , ");
        sqlBuffer.append(" npp.car_regist_number as car_regist_number , ");
        sqlBuffer.append(" npp.car_issue_place as car_issue_place , ");
        sqlBuffer.append(" npp.car_issue_date as car_issue_date , ");
        sqlBuffer.append(" npp.car_frame_number as car_frame_number , ");
        sqlBuffer.append(" npp.car_machine_number as car_machine_number,");
        sqlBuffer.append(" npp.land_street as land_street");
       

        sqlBuffer.append(" FROM ");
        sqlBuffer.append(" npo_data_prevent ndp ");
        sqlBuffer.append(" INNER JOIN ");
        sqlBuffer.append(" npo_property_prevent npp ");
        sqlBuffer.append(" ON ");
        sqlBuffer.append(" ndp.property_id = npp.id ");
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
        DataPreventList list = null;
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

            DataPreventInfo info = null;
            list = new DataPreventList();
            while(rs.next()) {
                info = new DataPreventInfo();
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
        sqlBuffer.append("npo_data_prevent");

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
    private void rsSetInfo(ResultSet rs,DataPreventInfo info) throws SQLException {
        info.setId(rsGetLong(rs, "id"));
        info.setSynchronizeId(rsGetString(rs, "synchronize_id"));
        info.setPropertyId(rsGetLong(rs, "property_id"));
        info.setOriginKind(rsGetString(rs, "origin_kind"));
        info.setDeleteFlg(rsGetBoolean(rs, "delete_flg"));
        info.setPreventRegistAgency(rsGetString(rs, "prevent_regist_agency"));
        info.setPreventInBookNumber(rsGetString(rs, "prevent_in_book_number"));
        info.setPreventPersonInfo(rsGetString(rs, "prevent_person_info"));
        info.setPreventDocNumber(rsGetString(rs, "prevent_doc_number"));
        info.setPreventDocDate(rsGetTimestamp(rs, "prevent_doc_date"));
        info.setPreventDocReceiveDate(rsGetTimestamp(rs, "prevent_doc_receive_date"));
        info.setPreventInputDate(rsGetTimestamp(rs, "prevent_input_date"));
        info.setPreventDocSummary(rsGetString(rs, "prevent_doc_summary"));
        info.setPreventFileName(rsGetString(rs, "prevent_file_name"));
        info.setPreventFilePath(rsGetString(rs, "prevent_file_path"));
        info.setPreventNote(rsGetString(rs, "prevent_note"));
        info.setReleaseFlg(rsGetBoolean(rs, "release_flg"));
        info.setReleaseRegistAgency(rsGetString(rs, "release_regist_agency"));
        info.setReleaseInBookNumber(rsGetString(rs, "release_in_book_number"));
        info.setReleasePersonInfo(rsGetString(rs, "release_person_info"));
        info.setReleaseDocNumber(rsGetString(rs, "release_doc_number"));
        info.setReleaseDocDate(rsGetTimestamp(rs, "release_doc_date"));
        info.setReleaseDocReceiveDate(rsGetTimestamp(rs, "release_doc_receive_date"));
        info.setReleaseInputDate(rsGetTimestamp(rs, "release_input_date"));
        info.setReleaseDocSummary(rsGetString(rs, "release_doc_summary"));
        info.setReleaseFileName(rsGetString(rs, "release_file_name"));
        info.setReleaseFilePath(rsGetString(rs, "release_file_path"));
        info.setReleaseNote(rsGetString(rs, "release_note"));
//        info.setEntryUserId(rsGetLong(rs, "entry_user_id"));
//        info.setEntryUserName(rsGetString(rs, "entry_user_name"));
//        info.setEntryDateTime(rsGetTimestamp(rs, "entry_date_time"));
//        info.setUpdateUserId(rsGetLong(rs, "update_user_id"));
//        info.setUpdateUserName(rsGetString(rs, "update_user_name"));
//        info.setUpdateDateTime(rsGetTimestamp(rs, "update_date_time"));

        info.setType(rsGetString(rs, "type"));
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
        info.setLandDistrict(rsGetString(rs, "land_district"));
        info.setLandStreet(rsGetString(rs, "land_street"));
//        info.setLandProvince(rsGetString(rs, "land_province"));
        info.setCarLicenseNumber(rsGetString(rs, "car_license_number"));
        info.setCarRegistNumber(rsGetString(rs, "car_regist_number"));
        info.setCarIssuePlace(rsGetString(rs, "car_issue_place"));
        info.setCarIssueDate(rsGetTimestamp(rs, "car_issue_date"));
        info.setCarFrameNumber(rsGetString(rs, "car_frame_number"));
        info.setCarMachineNumber(rsGetString(rs, "car_machine_number"));
        
    }


    /**
     * <P>Create parameter</P>
     *
     * @param  info  Update Info
     * @param sqlList  SQL List
     * @param prmList  Parameter List
     */
    private void makeUpdateList(DataPreventInfo info, ArrayList<String> sqlList,ArrayList<Object> prmList){

        addUpdateList(info.getSynchronizeId(), ",synchronize_id=?", sqlList, prmList);
        addUpdateList(info.getPropertyId(), ",property_id=?", sqlList, prmList);
        addUpdateList(info.getOriginKind(), ",origin_kind=?", sqlList, prmList);
        addUpdateList(info.getDeleteFlg(), ",delete_flg=?", sqlList, prmList);
        addUpdateList(info.getPreventRegistAgency(), ",prevent_regist_agency=?", Boolean.TRUE, sqlList, prmList);
        addUpdateList(info.getPreventInBookNumber(), ",prevent_in_book_number=?", Boolean.TRUE, sqlList, prmList);
        addUpdateList(info.getPreventPersonInfo(), ",prevent_person_info=?", Boolean.TRUE, sqlList, prmList);
        addUpdateList(info.getPreventDocNumber(), ",prevent_doc_number=?", Boolean.TRUE, sqlList, prmList);
        addUpdateList(info.getPreventDocDate(), ",prevent_doc_date=?", Boolean.TRUE, sqlList, prmList);
        addUpdateList(info.getPreventDocReceiveDate(), ",prevent_doc_receive_date=?", Boolean.TRUE, sqlList, prmList);
        addUpdateList(info.getPreventInputDate(), ",prevent_input_date=?", Boolean.TRUE, sqlList, prmList);
        addUpdateList(info.getPreventDocSummary(), ",prevent_doc_summary=?", Boolean.TRUE, sqlList, prmList);
        addUpdateList(info.getPreventFileName(), ",prevent_file_name=?", Boolean.TRUE, sqlList, prmList);
        addUpdateList(info.getPreventFilePath(), ",prevent_file_path=?", Boolean.TRUE, sqlList, prmList);
        addUpdateList(info.getPreventNote(), ",prevent_note=?", Boolean.TRUE, sqlList, prmList);
        addUpdateList(info.getReleaseFlg(), ",release_flg=?", sqlList, prmList);
        addUpdateList(info.getReleaseRegistAgency(), ",release_regist_agency=?", Boolean.TRUE, sqlList, prmList);
        addUpdateList(info.getReleaseInBookNumber(), ",release_in_book_number=?", Boolean.TRUE, sqlList, prmList);
        addUpdateList(info.getReleasePersonInfo(), ",release_person_info=?", Boolean.TRUE, sqlList, prmList);
        addUpdateList(info.getReleaseDocNumber(), ",release_doc_number=?", Boolean.TRUE, sqlList, prmList);
        addUpdateList(info.getReleaseDocDate(), ",release_doc_date=?", Boolean.TRUE, sqlList, prmList);
        addUpdateList(info.getReleaseDocReceiveDate(), ",release_doc_receive_date=?", Boolean.TRUE, sqlList, prmList);
        addUpdateList(info.getReleaseInputDate(), ",release_input_date=?", Boolean.TRUE, sqlList, prmList);
        addUpdateList(info.getReleaseDocSummary(), ",release_doc_summary=?", Boolean.TRUE, sqlList, prmList);
        addUpdateList(info.getReleaseFileName(), ",release_file_name=?", Boolean.TRUE, sqlList, prmList);
        addUpdateList(info.getReleaseFilePath(), ",release_file_path=?", Boolean.TRUE, sqlList, prmList);
        addUpdateList(info.getReleaseNote(), ",release_note=?", Boolean.TRUE, sqlList, prmList);
        addUpdateList(info.getEntryUserId(), ",entry_user_id=?", sqlList, prmList);
        addUpdateList(info.getEntryUserName(), ",entry_user_name=?", sqlList, prmList);
        addUpdateList(info.getEntryDateTime(), ",entry_date_time=?", sqlList, prmList);
        addUpdateList(info.getUpdateUserId(), ",update_user_id=?", sqlList, prmList);
        addUpdateList(info.getUpdateUserName(), ",update_user_name=?", sqlList, prmList);
        addUpdateList(info.getUpdateDateTime(), ",update_date_time=?", sqlList, prmList);
    }

    /**
     * Get count record result by filter
     *
     * @return Count of record
     * @throws SQLException
     */
    public int countTotalByFilter() throws SQLException, IOException {

        ArrayList<Object> prmList = new ArrayList<Object>();
        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" SELECT ");
        sqlBuffer.append(" COUNT(*) ");

        sqlBuffer.append(" FROM ");
        sqlBuffer.append(" npo_data_prevent ndp ");
        sqlBuffer.append(" INNER JOIN ");

        sqlBuffer.append(" npo_property_prevent npp ");
        sqlBuffer.append(" ON ");
        sqlBuffer.append(" ndp.property_id = npp.id ");

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
        /* set id filter */
        if (this.idFilter !=  null) {
            appendAnd(filterBuffer);
            filterBuffer.append(" ndp.id = ? ");
            prmList.add(this.idFilter);
        }

        if (this.typeFilter !=  null) {
            appendAnd(filterBuffer);
            filterBuffer.append(" npp.type LIKE ? ");
            prmList.add(this.typeFilter);
        }

        if (this.propertyInfoFilter !=  null) {
            appendAnd(filterBuffer);
            filterBuffer.append(" npp.property_info LIKE ? ");
            prmList.add(this.propertyInfoFilter);
        }

        if (this.landCertificateFilter !=  null) {
            appendAnd(filterBuffer);
            filterBuffer.append(" npp.land_certificate LIKE ? ");
            prmList.add(this.landCertificateFilter);
        }

        if (this.landMapNumberFilter !=  null) {
            appendAnd(filterBuffer);
            filterBuffer.append(" npp.land_map_number LIKE ? ");
            prmList.add(this.landMapNumberFilter);
        }

        if (this.landNumberFilter !=  null) {
            appendAnd(filterBuffer);
            filterBuffer.append(" npp.land_number LIKE ? ");
            prmList.add(this.landNumberFilter);
        }

        if (this.landAddressFilter !=  null) {
            appendAnd(filterBuffer);
            filterBuffer.append(" npp.land_address LIKE ? ");
            prmList.add(this.landAddressFilter);
        }

        if (this.carLicenseNumberFilter !=  null) {
            appendAnd(filterBuffer);
            filterBuffer.append(" npp.car_license_number LIKE ? ");
            prmList.add(this.carLicenseNumberFilter);
        }

        if (this.carRegistNumberFilter !=  null) {
            appendAnd(filterBuffer);
            filterBuffer.append(" npp.car_regist_number LIKE ? ");
            prmList.add(this.carRegistNumberFilter);
        }

        if (this.carFrameNumberFilter !=  null) {
            appendAnd(filterBuffer);
            filterBuffer.append(" npp.car_frame_number LIKE ? ");
            prmList.add(this.carFrameNumberFilter);
        }

        if (this.carMachineNumberFilter !=  null) {
            appendAnd(filterBuffer);
            filterBuffer.append(" npp.car_machine_number LIKE ? ");
            prmList.add(this.carMachineNumberFilter);
        }

        if (this.originKindFilter !=  null) {
            appendAnd(filterBuffer);
            filterBuffer.append(" ndp.origin_kind LIKE ? ");
            prmList.add(this.originKindFilter);
        }

        if (this.releaseFlgFilter !=  null) {
            appendAnd(filterBuffer);
            filterBuffer.append(" ndp.release_flg = ? ");
            prmList.add(this.releaseFlgFilter);
        }

        if (this.deleteFlgFilter !=  null) {
            appendAnd(filterBuffer);
            filterBuffer.append(" ndp.delete_flg = ? ");
            prmList.add(this.deleteFlgFilter);
        }

        if (this.typeKeySearchFilter !=  null) {
            appendAnd(filterBuffer);
            filterBuffer.append(" npp.type LIKE ? ");
            prmList.add(this.typeKeySearchFilter);
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
                    filterBuffer.append(" MATCH(npp.property_info, npp.owner_info, npp.other_info, " +
                            "ndp.prevent_in_book_number, ndp.prevent_person_info, ndp.prevent_doc_number, ndp.prevent_doc_summary, " +
                            "ndp.prevent_note, ndp.release_in_book_number, ndp.release_person_info, " +
                            "ndp.release_doc_number, ndp.release_doc_summary, ndp.release_note) ");
                    filterBuffer.append(" AGAINST(? IN BOOLEAN MODE) ");
                    prmList.add(subkey);

                    if (subkey.charAt(0) == '"') {
                        subkey = subkey.substring(1, subkey.length() - 1);
                    }

                    if (subkey.charAt(subkey.length() - 1) == '"') {
                        subkey = subkey.substring(0, subkey.length() - 2);
                    }

                    appendOr(filterBuffer);
                    filterBuffer.append(" npp.property_info LIKE ? ");
                    prmList.add(buildFilterString(subkey, FilterKind.MIDDLE.getValue()));

                    appendOr(filterBuffer);
                    filterBuffer.append(" npp.owner_info LIKE ? ");
                    prmList.add(buildFilterString(subkey, FilterKind.MIDDLE.getValue()));

                    appendOr(filterBuffer);
                    filterBuffer.append(" npp.other_info LIKE ? ");
                    prmList.add(buildFilterString(subkey, FilterKind.MIDDLE.getValue()));

                    appendOr(filterBuffer);
                    filterBuffer.append(" ndp.prevent_in_book_number LIKE ? ");
                    prmList.add(buildFilterString(subkey, FilterKind.MIDDLE.getValue()));

                    appendOr(filterBuffer);
                    filterBuffer.append(" ndp.prevent_person_info LIKE ? ");
                    prmList.add(buildFilterString(subkey, FilterKind.MIDDLE.getValue()));
                    
                    appendOr(filterBuffer);
                    filterBuffer.append(" ndp.prevent_doc_number LIKE ? ");
                    prmList.add(buildFilterString(subkey, FilterKind.MIDDLE.getValue()));

                    appendOr(filterBuffer);
                    filterBuffer.append(" ndp.prevent_doc_summary LIKE ? ");
                    prmList.add(buildFilterString(subkey, FilterKind.MIDDLE.getValue()));

                    appendOr(filterBuffer);
                    filterBuffer.append(" ndp.prevent_note LIKE ? ");
                    prmList.add(buildFilterString(subkey, FilterKind.MIDDLE.getValue()));

                    appendOr(filterBuffer);
                    filterBuffer.append(" ndp.release_in_book_number LIKE ? ");
                    prmList.add(buildFilterString(subkey, FilterKind.MIDDLE.getValue()));

                    appendOr(filterBuffer);
                    filterBuffer.append(" ndp.release_person_info LIKE ? ");
                    prmList.add(buildFilterString(subkey, FilterKind.MIDDLE.getValue()));

                    appendOr(filterBuffer);
                    filterBuffer.append(" ndp.release_doc_number LIKE ? ");
                    prmList.add(buildFilterString(subkey, FilterKind.MIDDLE.getValue()));

                    appendOr(filterBuffer);
                    filterBuffer.append(" ndp.release_doc_summary LIKE ? ");
                    prmList.add(buildFilterString(subkey, FilterKind.MIDDLE.getValue()));

                    appendOr(filterBuffer);
                    filterBuffer.append(" ndp.release_note LIKE ? ");
                    prmList.add(buildFilterString(subkey, FilterKind.MIDDLE.getValue()));

                    filterBuffer.append(" ) ");
                }
            }
            filterBuffer.append(" ) ");

            filterBuffer.append(" ORDER BY ");
            for (int j = 1; j < subKeys.size(); j++) {
                String subkey = subKeys.get(j);
                if (!Constants.PLUS.equals(subkey) && !Constants.SPACE.equals(subkey)) {

                    filterBuffer.append(" ( ");
                    filterBuffer.append(" MATCH(npp.property_info, npp.owner_info, npp.other_info, " +
                            "ndp.prevent_in_book_number, ndp.prevent_person_info, ndp.prevent_doc_number, ndp.prevent_doc_summary, " +
                            "ndp.prevent_note, ndp.release_in_book_number, ndp.release_person_info, " +
                            "ndp.release_doc_number, ndp.release_doc_summary, ndp.release_note) ");
                    filterBuffer.append(" AGAINST(? IN BOOLEAN MODE) ");
                    prmList.add(subkey);

                    if (subkey.charAt(0) == '"') {
                        subkey = subkey.substring(1, subkey.length() - 1);
                    }

                    if (subkey.charAt(subkey.length() - 1) == '"') {
                        subkey = subkey.substring(0, subkey.length() - 2);
                    }

                    appendOr(filterBuffer);
                    filterBuffer.append(" npp.property_info LIKE ? ");
                    prmList.add(buildFilterString(subkey, FilterKind.MIDDLE.getValue()));

                    appendOr(filterBuffer);
                    filterBuffer.append(" npp.owner_info LIKE ? ");
                    prmList.add(buildFilterString(subkey, FilterKind.MIDDLE.getValue()));

                    appendOr(filterBuffer);
                    filterBuffer.append(" npp.other_info LIKE ? ");
                    prmList.add(buildFilterString(subkey, FilterKind.MIDDLE.getValue()));

                    appendOr(filterBuffer);
                    filterBuffer.append(" ndp.prevent_in_book_number LIKE ? ");
                    prmList.add(buildFilterString(subkey, FilterKind.MIDDLE.getValue()));

                    appendOr(filterBuffer);
                    filterBuffer.append(" ndp.prevent_person_info LIKE ? ");
                    prmList.add(buildFilterString(subkey, FilterKind.MIDDLE.getValue()));
                    
                    appendOr(filterBuffer);
                    filterBuffer.append(" ndp.prevent_doc_number LIKE ? ");
                    prmList.add(buildFilterString(subkey, FilterKind.MIDDLE.getValue()));

                    appendOr(filterBuffer);
                    filterBuffer.append(" ndp.prevent_doc_summary LIKE ? ");
                    prmList.add(buildFilterString(subkey, FilterKind.MIDDLE.getValue()));

                    appendOr(filterBuffer);
                    filterBuffer.append(" ndp.prevent_note LIKE ? ");
                    prmList.add(buildFilterString(subkey, FilterKind.MIDDLE.getValue()));

                    appendOr(filterBuffer);
                    filterBuffer.append(" ndp.release_in_book_number LIKE ? ");
                    prmList.add(buildFilterString(subkey, FilterKind.MIDDLE.getValue()));

                    appendOr(filterBuffer);
                    filterBuffer.append(" ndp.release_person_info LIKE ? ");
                    prmList.add(buildFilterString(subkey, FilterKind.MIDDLE.getValue()));

                    appendOr(filterBuffer);
                    filterBuffer.append(" ndp.release_doc_number LIKE ? ");
                    prmList.add(buildFilterString(subkey, FilterKind.MIDDLE.getValue()));

                    appendOr(filterBuffer);
                    filterBuffer.append(" ndp.release_doc_summary LIKE ? ");
                    prmList.add(buildFilterString(subkey, FilterKind.MIDDLE.getValue()));

                    appendOr(filterBuffer);
                    filterBuffer.append(" ndp.release_note LIKE ? ");
                    prmList.add(buildFilterString(subkey, FilterKind.MIDDLE.getValue()));

                    if (j == subKeys.size() - 1) {
                        filterBuffer.append(" ) ");
                    } else {
                        filterBuffer.append(" ) + ");
                    }
                }
            }
            filterBuffer.append(" DESC, prevent_doc_receive_date DESC ");
        }

        if (this.officeCode != null && !"".equals(this.officeCode)) {
        	appendAnd(filterBuffer);
            filterBuffer.append(" ndp.synchronize_id LIKE ? ");
            prmList.add(this.officeCode);
        }
        
        return filterBuffer.toString();
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
     * Set the propertyInfoFilter
     *
     * @param propertyInfoFilter the propertyInfoFilter to set
     * @param kind Filter kind (FULL, LEFT, MIDDLE)
     */
    public void setPropertyInfoFilter(String propertyInfoFilter, FilterKind kind) {
        this.propertyInfoFilter = this.buildFilterString(propertyInfoFilter, kind.getValue());
    }


    /**
     * Set the landCertificateFilter
     *
     * @param landCertificateFilter the landCertificateFilter to set
     * @param kind Filter kind (FULL, LEFT, MIDDLE)
     */
    public void setLandCertificateFilter(String landCertificateFilter, FilterKind kind) {
        this.landCertificateFilter = this.buildFilterString(landCertificateFilter, kind.getValue());
    }


    /**
     * Set the landMapNumberFilter
     *
     * @param landMapNumberFilter the landMapNumberFilter to set
     * @param kind Filter kind (FULL, LEFT, MIDDLE)
     */
    public void setLandMapNumberFilter(String landMapNumberFilter, FilterKind kind) {
        this.landMapNumberFilter = this.buildFilterString(landMapNumberFilter, kind.getValue());
    }


    /**
     * Set the landNumberFilter
     *
     * @param landNumberFilter the landNumberFilter to set
     * @param kind Filter kind (FULL, LEFT, MIDDLE)
     */
    public void setLandNumberFilter(String landNumberFilter, FilterKind kind) {
        this.landNumberFilter = this.buildFilterString(landNumberFilter, kind.getValue());
    }


    /**
     * Set the landAddressFilter
     *
     * @param landAddressFilter the landAddressFilter to set
     * @param kind Filter kind (FULL, LEFT, MIDDLE)
     */
    public void setLandAddressFilter(String landAddressFilter, FilterKind kind) {
        this.landAddressFilter = this.buildFilterString(landAddressFilter, kind.getValue());
    }


    /**
     * Set the carLicenseNumberFilter
     *
     * @param carLicenseNumberFilter the carLicenseNumberFilter to set
     * @param kind Filter kind (FULL, LEFT, MIDDLE)
     */
    public void setCarLicenseNumberFilter(String carLicenseNumberFilter, FilterKind kind) {
        this.carLicenseNumberFilter = this.buildFilterString(carLicenseNumberFilter, kind.getValue());
    }


    /**
     * Set the carRegistNumberFilter
     *
     * @param carRegistNumberFilter the carRegistNumberFilter to set
     * @param kind Filter kind (FULL, LEFT, MIDDLE)
     */
    public void setCarRegistNumberFilter(String carRegistNumberFilter, FilterKind kind) {
        this.carRegistNumberFilter = this.buildFilterString(carRegistNumberFilter, kind.getValue());
    }


    /**
     * Set the carFrameNumberFilter
     *
     * @param carFrameNumberFilter the carFrameNumberFilter to set
     * @param kind Filter kind (FULL, LEFT, MIDDLE)
     */
    public void setCarFrameNumberFilter(String carFrameNumberFilter, FilterKind kind) {
        this.carFrameNumberFilter = this.buildFilterString(carFrameNumberFilter, kind.getValue());
    }


    /**
     * Set the carMachineNumberFilter
     *
     * @param carMachineNumberFilter the carMachineNumberFilter to set
     * @param kind Filter kind (FULL, LEFT, MIDDLE)
     */
    public void setCarMachineNumberFilter(String carMachineNumberFilter, FilterKind kind) {
        this.carMachineNumberFilter = this.buildFilterString(carMachineNumberFilter, kind.getValue());
    }

    /**
     * Set the releaseFlgFilter
     *
     * @param releaseFlgFilter the releaseFlgFilter to set
     */
    public void setReleaseFlgFilter(Boolean releaseFlgFilter) {
        this.releaseFlgFilter = releaseFlgFilter;
    }

    /**
     * Set the deleteFlgFilter
     *
     * @param deleteFlgFilter the deleteFlgFilter to set
     */
    public void setDeleteFlgFilter(Boolean deleteFlgFilter) {
        this.deleteFlgFilter = deleteFlgFilter;
    }


    /**
     * Set the typeKeySearchFilter
     *
     * @param typeKeySearchFilter the typeKeySearchFilter to set
     */
    public void setTypeKeySearchFilter(String typeKeySearchFilter) {
        this.typeKeySearchFilter = typeKeySearchFilter;
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
     * Set the originKindFilter
     *
     * @param originKindFilter the originKindFilter to set
     */
    public void setOriginKindFilter(String originKindFilter) {
        this.originKindFilter = originKindFilter;
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
	 * Set officeCode
	 * @param officeCode the officeCode to set
	 */
	public void setOfficeCode(String officeCode) {
		this.officeCode = this.buildFilterString(officeCode, FilterKind.LEFT.getValue());
	}
}
