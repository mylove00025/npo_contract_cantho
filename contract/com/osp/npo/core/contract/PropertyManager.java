package com.osp.npo.core.contract;


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
 * Generate date: 11/29/2010 10:15:29 AM
 */
public class PropertyManager extends AbstractManager {

    private Long idFilter;
    
    private Long contractIdFilter;
    
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
    
    private List<String> subKeys;
    
    /**
     * <P>Generate instance</P>
     * 
     * @param  connection  Connection
     */
    public PropertyManager(Connection connection) {
        super(connection);
    }


    /**
     * <P>Add new infomation</P>
     * 
     * @param  info  Infomation that need add
     * @return  PreparedStatement#executeUpdate Return's Value
     * @throws SQLException
     */
    public int insert(PropertyInfo info) throws SQLException {

        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" INSERT INTO ");
        sqlBuffer.append("npo_property");
        sqlBuffer.append(" ( ");
        sqlBuffer.append("type,");
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
        sqlBuffer.append("land_district,");
        sqlBuffer.append("land_street,");
        sqlBuffer.append("land_province,");
        sqlBuffer.append("car_license_number,");
        sqlBuffer.append("car_regist_number,");
        sqlBuffer.append("car_issue_place,");
        sqlBuffer.append("car_issue_date,");
        sqlBuffer.append("car_frame_number,");
        sqlBuffer.append("car_machine_number");
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
            psSetString(ps, i++, info.getLandDistrict());
            psSetString(ps, i++, info.getLandStreet());
            psSetLong(ps, i++, info.getLandProvince());
            psSetString(ps, i++, info.getCarLicenseNumber());
            psSetString(ps, i++, info.getCarRegistNumber());
            psSetString(ps, i++, info.getCarIssuePlace());
            psSetTimestamp(ps, i++, info.getCarIssueDate());
            psSetString(ps, i++, info.getCarFrameNumber());
            psSetString(ps, i++, info.getCarMachineNumber());

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
        sqlBuffer.append(" npo_property ");
        sqlBuffer.append(" WHERE ");
        sqlBuffer.append(" id = ? ");

        this.setSql(sqlBuffer.toString());

        PreparedStatement ps = null;
        int result;

        try {
            Connection c = this.getConnection();
            ps = c.prepareStatement(this.getSql());

            psSetLong(ps, 1, id);

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
    public int update(PropertyInfo info) throws SQLException, IOException {

        ArrayList<String> sqlList = new ArrayList<String>();
        ArrayList<Object> prmList = new ArrayList<Object>();

        //Evaluate Null value, create parameter list for SQL Statement.
        makeUpdateList(info, sqlList, prmList);

        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" UPDATE ");
        sqlBuffer.append("npo_property");
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
    public PropertyList select(boolean forUpdate, int offset, int limit) throws SQLException, IOException {

        ArrayList<Object> prmList = new ArrayList<Object>();
        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" SELECT ");
        sqlBuffer.append(" npr.id, ");
        sqlBuffer.append(" npr.type, ");
        sqlBuffer.append(" npr.property_info, ");
        sqlBuffer.append(" npr.owner_info, ");
        sqlBuffer.append(" npr.other_info, ");
        sqlBuffer.append(" npr.land_district, ");
        sqlBuffer.append(" npr.land_street, ");
        sqlBuffer.append(" nc.id as contract_id, ");
        sqlBuffer.append(" nc.notary_date, ");
        sqlBuffer.append(" nc.summary, ");
        sqlBuffer.append(" nct.name as template_name ");
        
        sqlBuffer.append(" FROM ");
        sqlBuffer.append(" npo_property npr");
        
        sqlBuffer.append(" INNER JOIN ");
        sqlBuffer.append(" npo_contract_property ncp ");
        sqlBuffer.append(" ON ");
        sqlBuffer.append(" ncp.property_id = npr.id ");
        
        sqlBuffer.append(" INNER JOIN ");
        sqlBuffer.append(" npo_contract nc ");
        sqlBuffer.append(" ON ");
        sqlBuffer.append(" ncp.contract_id = nc.id ");
        
        sqlBuffer.append(" INNER JOIN ");
        sqlBuffer.append(" npo_contract_template nct ");
        sqlBuffer.append(" ON ");
        sqlBuffer.append(" nct.id = nc.contract_template_id ");
        
        sqlBuffer.append(getBaseSQL(prmList));
        appendOrderField(sqlBuffer);
        if ((offset >= 0) && (limit >= 0)) {
            sqlBuffer.append(" LIMIT ? ");
            sqlBuffer.append(" OFFSET ? ");
        }
        if (forUpdate) {
            sqlBuffer.append(" FOR UPDATE ");
        }
        this.setSql(sqlBuffer.toString());
        
        appendOrderField(sqlBuffer);

        PreparedStatement ps = null;
        ResultSet rs = null;
        PropertyList list = null;
        try {
            Connection c = this.getConnection();
            ps = c.prepareStatement(this.getSql());

            int i = 1;
            for (int j = 0; j < prmList.size(); j++) {
                psSetObject(ps, i++, prmList.get(j));
            }
            if ((offset >= 0) && (limit >= 0)) {
                psSetObject(ps, i++, limit);
                psSetObject(ps, i++, offset);
            }
            rs = ps.executeQuery();

            PropertyInfo info = null;
            list = new PropertyList();
            while (rs.next()) {
                info = new PropertyInfo();
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
    public PropertyList selectByContract(boolean forUpdate) throws SQLException, IOException {

        ArrayList<Object> prmList = new ArrayList<Object>();
        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" SELECT ");
        sqlBuffer.append(" npr.id, ");
        sqlBuffer.append(" npr.type, ");
        sqlBuffer.append(" npr.property_info, ");
        sqlBuffer.append(" npr.owner_info, ");
        sqlBuffer.append(" npr.other_info, ");
        sqlBuffer.append(" npr.land_district, ");
        sqlBuffer.append(" npr.land_street, ");
        sqlBuffer.append(" npr.land_certificate, ");
        sqlBuffer.append(" npr.land_issue_place, ");
        sqlBuffer.append(" npr.land_issue_date, ");
        sqlBuffer.append(" npr.land_map_number, ");
        sqlBuffer.append(" npr.land_number, ");
        sqlBuffer.append(" npr.land_address, ");
        sqlBuffer.append(" npr.land_area, ");
        sqlBuffer.append(" npr.land_public_area, ");        
        sqlBuffer.append(" npr.land_private_area, ");
        sqlBuffer.append(" npr.land_use_purpose, ");
        sqlBuffer.append(" npr.land_use_period, ");
        sqlBuffer.append(" npr.land_use_origin, ");
        sqlBuffer.append(" npr.land_associate_property, ");
        sqlBuffer.append(" npr.car_license_number, ");
        sqlBuffer.append(" npr.car_regist_number, ");        
        sqlBuffer.append(" npr.car_issue_place, ");
        sqlBuffer.append(" npr.car_issue_date, ");
        sqlBuffer.append(" npr.car_frame_number, ");
        sqlBuffer.append(" npr.car_machine_number ");
        
        sqlBuffer.append(" FROM ");
        sqlBuffer.append(" npo_property npr ");
        
        sqlBuffer.append(" INNER JOIN ");
        sqlBuffer.append(" npo_contract_property ncp ");
        sqlBuffer.append(" ON ");
        sqlBuffer.append(" ncp.property_id = npr.id ");
        
        sqlBuffer.append(" INNER JOIN ");
        sqlBuffer.append(" npo_contract nc ");
        sqlBuffer.append(" ON ");
        sqlBuffer.append(" ncp.contract_id = nc.id ");
        
        sqlBuffer.append(getBaseSQL(prmList));
        
        if(forUpdate) {
            sqlBuffer.append(" FOR UPDATE ");
        }
        this.setSql(sqlBuffer.toString());

        PreparedStatement ps = null;
        ResultSet rs = null;
        PropertyList list = null;
        try {
            Connection c = this.getConnection();
            ps = c.prepareStatement(this.getSql());

            int i = 1;
            for (int j = 0; j < prmList.size(); j++) {
                psSetObject(ps, i ++, prmList.get(j));
            }
            
            rs = ps.executeQuery();

            PropertyInfo info = null;
            list = new PropertyList();
            while(rs.next()) {
                info = new PropertyInfo();
                rsSetInfoByContract(rs, info);
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
        sqlBuffer.append(" npo_property npr ");
        
        sqlBuffer.append(" INNER JOIN ");
        sqlBuffer.append(" npo_contract_property ncp ");
        sqlBuffer.append(" ON ");
        sqlBuffer.append(" ncp.property_id = npr.id ");
        
        sqlBuffer.append(" INNER JOIN ");
        sqlBuffer.append(" npo_contract nc ");
        sqlBuffer.append(" ON ");
        sqlBuffer.append(" ncp.contract_id = nc.id ");
        
        sqlBuffer.append(" INNER JOIN ");
        sqlBuffer.append(" npo_contract_template nct ");
        sqlBuffer.append(" ON ");
        sqlBuffer.append(" nct.id = nc.contract_template_id ");
        
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
    private void rsSetInfoByContract(ResultSet rs, PropertyInfo info) throws SQLException {

        info.setId(rsGetLong(rs, "id"));
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
        //info.setLandProvince(rsGetLong(rs, "land_province"));
        info.setCarLicenseNumber(rsGetString(rs, "car_license_number"));
        info.setCarRegistNumber(rsGetString(rs, "car_regist_number"));
        info.setCarIssuePlace(rsGetString(rs, "car_issue_place"));
        info.setCarIssueDate(rsGetTimestamp(rs, "car_issue_date"));
        info.setCarFrameNumber(rsGetString(rs, "car_frame_number"));
        info.setCarMachineNumber(rsGetString(rs, "car_machine_number"));
    }
    
    /**
     * <P>Set ResultSet to Info instance </P>
     * 
     * @param  rs    ResultSet
     * @param  info  Info instance
     * @throws SQLException
     */
    private void rsSetInfo(ResultSet rs, PropertyInfo info) throws SQLException {

        info.setId(rsGetLong(rs, "id"));
        info.setType(rsGetString(rs, "type"));
        info.setPropertyInfo(rsGetString(rs, "property_info"));
        info.setOwnerInfo(rsGetString(rs, "owner_info"));
        info.setLandDistrict(rsGetString(rs, "land_district"));
        info.setLandStreet(rsGetString(rs, "land_street"));
        info.setContractId(rsGetLong(rs, "contract_id"));
        info.setNotaryDate(rsGetTimestamp(rs, "notary_date"));
        info.setContractSummary(rsGetString(rs, "summary"));
        info.setContractTemplate(rsGetString(rs, "template_name"));
        info.setOtherInfo(rsGetString(rs, "other_info"));
    }


    /**
     * <P>Create parameter</P>
     * 
     * @param  info  Update Info
     * @param sqlList  SQL List
     * @param prmList  Parameter List
     */
    private void makeUpdateList(PropertyInfo info, ArrayList<String> sqlList, ArrayList<Object> prmList) {

        addUpdateList(info.getType(), ",type=?", sqlList, prmList);
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
        addUpdateList(info.getLandDistrict(), ",land_district=?", sqlList, prmList);
        addUpdateList(info.getLandStreet(), ",land_street=?", sqlList, prmList);
        addUpdateList(info.getLandProvince(), ",land_province=?", sqlList, prmList);
        addUpdateList(info.getCarLicenseNumber(), ",car_license_number=?", sqlList, prmList);
        addUpdateList(info.getCarRegistNumber(), ",car_regist_number=?", sqlList, prmList);
        addUpdateList(info.getCarIssuePlace(), ",car_issue_place=?", sqlList, prmList);
        addUpdateList(info.getCarIssueDate(), ",car_issue_date=?", true, sqlList, prmList);
        addUpdateList(info.getCarFrameNumber(), ",car_frame_number=?", sqlList, prmList);
        addUpdateList(info.getCarMachineNumber(), ",car_machine_number=?", sqlList, prmList);
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
        if (whereString.length() > 0) {
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
            filterBuffer.append(" npr.id = ? ");
            prmList.add(this.idFilter);
        }
        if (this.contractIdFilter != null) {
            appendAnd(filterBuffer);
            filterBuffer.append(" nc.id = ? ");
            prmList.add(this.contractIdFilter);
        }
        
        if (this.typeFilter !=  null) {
            appendAnd(filterBuffer);
            filterBuffer.append(" npr.type LIKE ? ");
            prmList.add(this.typeFilter);
        }
        
        if (this.propertyInfoFilter !=  null) {
            appendAnd(filterBuffer);
            filterBuffer.append(" npr.property_info LIKE ? ");
            prmList.add(this.propertyInfoFilter);
        }
        
        if (this.landCertificateFilter !=  null) {
            appendAnd(filterBuffer);
            filterBuffer.append(" npr.land_certificate LIKE ? ");
            prmList.add(this.landCertificateFilter);
        }
        
        if (this.landMapNumberFilter !=  null) {
            appendAnd(filterBuffer);
            filterBuffer.append(" npr.land_map_number LIKE ? ");
            prmList.add(this.landMapNumberFilter);
        }
        
        if (this.landNumberFilter !=  null) {
            appendAnd(filterBuffer);
            filterBuffer.append(" npr.land_number LIKE ? ");
            prmList.add(this.landNumberFilter);
        }
        
        if (this.landAddressFilter !=  null) {
            appendAnd(filterBuffer);
            filterBuffer.append(" npr.land_address LIKE ? ");
            prmList.add(this.landAddressFilter);
        }
        
        if (this.carLicenseNumberFilter !=  null) {
            appendAnd(filterBuffer);
            filterBuffer.append(" npr.car_license_number LIKE ? ");
            prmList.add(this.carLicenseNumberFilter);
        }
        
        if (this.carRegistNumberFilter !=  null) {
            appendAnd(filterBuffer);
            filterBuffer.append(" npr.car_regist_number LIKE ? ");
            prmList.add(this.carRegistNumberFilter);
        }
        
        if (this.carFrameNumberFilter !=  null) {
            appendAnd(filterBuffer);
            filterBuffer.append(" npr.car_frame_number LIKE ? ");
            prmList.add(this.carFrameNumberFilter);
        }
        
        if (this.carMachineNumberFilter !=  null) {
            appendAnd(filterBuffer);
            filterBuffer.append(" npp.car_machine_number LIKE ? ");
            prmList.add(this.carMachineNumberFilter);
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
                    filterBuffer.append(" MATCH(npr.property_info, npr.owner_info, npr.other_info, nc.summary, nct.name ) ");
                    filterBuffer.append(" AGAINST(? IN BOOLEAN MODE) ");
                    prmList.add(subkey);
                    
                    if (subkey.charAt(0) == '"') {
                        subkey = subkey.substring(1, subkey.length() - 1);
                    }
                    
                    if (subkey.charAt(subkey.length() - 1) == '"') {
                        subkey = subkey.substring(0, subkey.length() - 2);
                    }
                    
                    appendOr(filterBuffer);
                    filterBuffer.append(" npr.property_info LIKE ? ");
                    prmList.add(buildFilterString(subkey, FilterKind.MIDDLE.getValue()));
                    
                    appendOr(filterBuffer);
                    filterBuffer.append(" npr.owner_info LIKE ? ");
                    prmList.add(buildFilterString(subkey, FilterKind.MIDDLE.getValue()));
                    
                    appendOr(filterBuffer);
                    filterBuffer.append(" npr.other_info LIKE ? ");
                    prmList.add(buildFilterString(subkey, FilterKind.MIDDLE.getValue()));
                    
                    appendOr(filterBuffer);
                    filterBuffer.append(" nc.summary LIKE ? ");
                    prmList.add(buildFilterString(subkey, FilterKind.MIDDLE.getValue()));
                    
                    appendOr(filterBuffer);
                    filterBuffer.append(" nct.name LIKE ? ");
                    prmList.add(buildFilterString(subkey, FilterKind.MIDDLE.getValue()));
                    
                    filterBuffer.append(" ) ");
                }
            }
            filterBuffer.append(" ) ");
        }
        
        return filterBuffer.toString();
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
     * Set the contractIdFilter
     *
     * @param contractIdFilter the contractIdFilter to set
     */
    public void setContractIdFilter(Long contractIdFilter) {
        this.contractIdFilter = contractIdFilter;
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
     * Set the subKeys
     *
     * @param subKeys the subKeys to set
     */
    public void setSubKeys(List<String> subKeys) {
        this.subKeys = subKeys;
    }
    
}
