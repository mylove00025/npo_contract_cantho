package com.osp.npo.core.contract;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.osp.npo.common.util.SystemMessageProperties;
import com.osp.npo.core.AbstractManager;
import com.osp.npo.core.user.UserInfo;
import com.osp.npo.core.user.UserList;

/**
 * Generate by script
 * Generate date: 10/28/2010 12:04:18 PM
 */
public class ContractByNotaryManager extends AbstractManager {

    public static final String SESSION_KEY = "contractContext";

    private Timestamp notaryDateFromFilter;

    private Timestamp notaryDateToFilter;

    private Long notaryIdFilter;
    
    private Boolean notaryPlaceFilter;

    /**
     * <P>Generate instance</P>
     *
     * @param  connection  Connection
     */
    public ContractByNotaryManager(Connection connection) {
        super(connection);
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
        sqlBuffer.append(" nc.notary_date, ");
        sqlBuffer.append(" nc.notary_id, ");
        sqlBuffer.append(" nu1.family_name as notary_family_name, ");
        sqlBuffer.append(" nu1.first_name as notary_first_name, ");       
        sqlBuffer.append(" nc.summary as contract_sumary ");

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
     * <P>Get total cost TT91</P>
     *
     * @return  Total cost
     * @throws SQLException
     * @throws IOException
     */
    public Long selectTotalCostTT91() throws SQLException, IOException {

        ArrayList<Object> prmList = new ArrayList<Object>();
        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" SELECT ");
        sqlBuffer.append(" SUM(CAST(cost_tt91 AS UNSIGNED)) AS A ");
        sqlBuffer.append(" FROM ");
        sqlBuffer.append(" npo_contract nc ");
        sqlBuffer.append(getBaseSQL(prmList));

        this.setSql(sqlBuffer.toString());

        PreparedStatement ps = null;
        ResultSet rs = null;
        
        Long result;
        try {
            Connection c = this.getConnection();
            ps = c.prepareStatement(this.getSql());

            int i = 1;
            for (int j = 0; j < prmList.size(); j++) {
                psSetObject(ps, i ++, prmList.get(j));
            }
           
            rs = ps.executeQuery();

            rs.next();
            result = rs.getLong(1);
            
        } finally {
            close(ps, rs);
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
        sqlBuffer.append(" npo_contract nc ");

        sqlBuffer.append(" INNER JOIN ");
        sqlBuffer.append(" npo_contract_template nct ");
        sqlBuffer.append(" ON ");
        sqlBuffer.append(" nc.contract_template_id = nct.id ");

        sqlBuffer.append(" INNER JOIN ");
        sqlBuffer.append(" npo_user nu1 ");
        sqlBuffer.append(" ON ");
        sqlBuffer.append(" nc.notary_id = nu1.id ");

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
    private void rsSetInfo(ResultSet rs,ContractInfo info) throws SQLException {

        info.setId(rsGetLong(rs, "id"));
        info.setContractNumber(rsGetString(rs, "contract_number"));
        info.setContractTemplateName(rsGetString(rs, "contract_name"));
        info.setNotaryDate(rsGetTimestamp(rs, "notary_date"));
        info.setRelationObjectA(rsGetString(rs, "relation_object_A"));
        info.setRelationObjectB(rsGetString(rs, "relation_object_B"));
        info.setRelationObjectC(rsGetString(rs, "relation_object_C"));        
        
        if (rsGetString(rs, "relateObjectATitle")!= null && !rsGetString(rs, "relateObjectATitle").equals(SystemMessageProperties.getSystemProperty("item_relation_object")))
    		info.setRelateObjectATitle(rsGetString(rs, "relateObjectATitle"));
        else 
            info.setRelateObjectATitle(SystemMessageProperties.getSystemProperty("item_relation_objectA"));
        
        if (rsGetString(rs, "relateObjectBTitle")!= null && !rsGetString(rs, "relateObjectBTitle").equals(SystemMessageProperties.getSystemProperty("item_relation_object")))
            info.setRelateObjectBTitle(rsGetString(rs, "relateObjectBTitle"));
        
        else 
            info.setRelateObjectBTitle(SystemMessageProperties.getSystemProperty("item_relation_objectB"));
        
        if (rsGetString(rs, "relateObjectCTitle")!= null && !rsGetString(rs, "relateObjectCTitle").equals(SystemMessageProperties.getSystemProperty("item_relation_object")))
            info.setRelateObjectCTitle(rsGetString(rs, "relateObjectCTitle"));
        else 
            info.setRelateObjectCTitle(SystemMessageProperties.getSystemProperty("item_relation_objectC"));
        
        info.setNotaryId(rsGetLong(rs, "notary_id"));
        info.setNotaryFamilyName(rsGetString(rs, "notary_family_name"));
        info.setNotaryFirstName(rsGetString(rs, "notary_first_name"));
        info.setContractSummary(rsGetString(rs, "contract_sumary"));
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

        if (this.notaryIdFilter !=  null) {
            appendAnd(filterBuffer);
            filterBuffer.append(" nc.notary_id = ? ");
            prmList.add(this.notaryIdFilter);
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
        
        return filterBuffer.toString();
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
     * Set the notaryIdFilter
     *
     * @param notaryIdFilter the notaryIdFilter to set
     */
    public void setNotaryIdFilter(Long notaryIdFilter) {
        this.notaryIdFilter = notaryIdFilter;
    }

    /**
     * Set the notaryPlaceFilter
     *
     * @param notaryPlaceFilter the notaryPlaceFilter to set
     */
    public void setNotaryPlaceFilter(Boolean notaryPlaceFilter) {
        this.notaryPlaceFilter = notaryPlaceFilter;
    }
    
}
