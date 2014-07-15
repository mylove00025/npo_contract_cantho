package com.osp.npo.service;


import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;


import com.osp.npo.common.global.Constants.FilterKind;
import com.osp.npo.core.OrderField;
import com.osp.npo.core.basicData.ProvinceManager;
import com.osp.npo.core.basicData.ProvinceInfo;
import com.osp.npo.core.basicData.ProvinceList;
import com.osp.npo.core.basicData.DistrictManager;
import com.osp.npo.core.basicData.DistrictInfo;
import com.osp.npo.core.basicData.DistrictList;
import com.osp.npo.core.basicData.BankManager;
import com.osp.npo.core.basicData.BankInfo;
import com.osp.npo.core.basicData.BankList;


/**
 * Generate by script
 * Generate date: 10/13/2010 3:47:47 PM
 * @version $Revision: 26924 $
 */
public class BasicDataService extends AbstractService {


    /** Province Manager Object */
    private ProvinceManager provinceManager;


    /** District Manager Object */
    private DistrictManager districtManager;


    /** Bank Manager Object */
    private BankManager bankManager;




    /** <P> Service constructor </P>*/
    public BasicDataService(Connection connection) {
        super(connection);
        this.provinceManager = new ProvinceManager (connection);
        this.districtManager = new DistrictManager (connection);
        this.bankManager = new BankManager (connection);
    }


    /**
     * <P> entry ProvinceInfo object to database </P>
     *
     * @param info
     * @return number of record insert.
     * @throws SQLException
     */
    public int entryProvince(ProvinceInfo info) throws SQLException{
        return this.provinceManager.insert(info);
    }


    /**
     * <P> modify ProvinceInfo object to database </P>
     *
     * @param info
     * @return number of record update.
     * @throws SQLException
     * @throws IOException
     */
    public int modifyProvince(ProvinceInfo info) throws SQLException, IOException{
        return this.provinceManager.update(info);
    }


    /**
     * <P> remove Province by id</P>
     *
     * @param id
     * @return number of record update.
     * @throws SQLException
     */
    public int removeProvince(Long id) throws SQLException{
        return this.provinceManager.delete(id);
    }


    /**
     * <P> query Province list from database </P>
     *
     * @param forUpdate
     * @param  page current page
     * @param  maxLine maximum line of a page
     * @return number of record query
     * @throws SQLException
     * @throws IOException
    */
    public ProvinceList queryProvince(boolean forUpdate, int page, int maxLine)
            throws SQLException, IOException{
        /* Calculate start position of page */
        int offset = (page - 1) * maxLine;
        return this.provinceManager.select(forUpdate, offset, maxLine);
    }


    /**
     * <P> query all of Province list from database </P>
     *
     * @param forUpdate
     * @return number of record query
     * @throws SQLException
     * @throws IOException
    */
    public ProvinceList queryAllProvince(boolean forUpdate)
            throws SQLException, IOException{
        /* if limit < 0 or offset < 0 then select all */
        return this.provinceManager.select(forUpdate, -1, -1);
    }


    /**
     * <P> count total Province </P>
     *
     * @param forUpdate
     * @return number of count record
     * @throws SQLException
     * @throws IOException
    */
    public int countTotalProvince()
            throws SQLException, IOException{
        return this.provinceManager.countTotal();
    }


    /**
     * <P> entry DistrictInfo object to database </P>
     *
     * @param info
     * @return number of record insert.
     * @throws SQLException
     */
    public int entryDistrict(DistrictInfo info) throws SQLException{
        return this.districtManager.insert(info);
    }


    /**
     * <P> modify DistrictInfo object to database </P>
     *
     * @param info
     * @return number of record update.
     * @throws SQLException
     * @throws IOException
     */
    public int modifyDistrict(DistrictInfo info) throws SQLException, IOException{
        return this.districtManager.update(info);
    }


    /**
     * <P> remove District by id</P>
     *
     * @param id
     * @return number of record update.
     * @throws SQLException
     */
    public int removeDistrict(Long id) throws SQLException{
        return this.districtManager.delete(id);
    }


    /**
     * <P> query District list from database </P>
     *
     * @param forUpdate
     * @param  page current page
     * @param  maxLine maximum line of a page
     * @return number of record query
     * @throws SQLException
     * @throws IOException
    */
    public DistrictList queryDistrict(boolean forUpdate, int page, int maxLine)
            throws SQLException, IOException{
        /* Calculate start position of page */
        int offset = (page - 1) * maxLine;
        return this.districtManager.select(forUpdate, offset, maxLine);
    }

    /**
     * <P> query District Info from database </P>
     *
     * @throws SQLException
     * @throws IOException
    */
    public DistrictInfo queryDistrictById(Long districtId)
            throws SQLException, IOException{
     
        return this.districtManager.selectDistrictById(districtId);
    }

    /**
     * <P> query all of District list from database </P>
     *
     * @param forUpdate
     * @return number of record query
     * @throws SQLException
     * @throws IOException
    */
    public DistrictList queryAllDistrict(boolean forUpdate)
            throws SQLException, IOException{
        /* if limit < 0 or offset < 0 then select all */
        return this.districtManager.select(forUpdate, -1, -1);
    }


    /**
     * <P> count total District </P>
     *
     * @param forUpdate
     * @return number of count record
     * @throws SQLException
     * @throws IOException
    */
    public int countTotalDistrict()
            throws SQLException, IOException{
        return this.districtManager.countTotal();
    }


    /**
     * <P> entry BankInfo object to database </P>
     *
     * @param info
     * @return number of record insert.
     * @throws SQLException
     */
    public int entryBank(BankInfo info) throws SQLException{
        return this.bankManager.insert(info);
    }


    /**
     * <P> modify BankInfo object to database </P>
     *
     * @param info
     * @return number of record update.
     * @throws SQLException
     * @throws IOException
     */
    public int modifyBank(BankInfo info) throws SQLException, IOException{
        return this.bankManager.update(info);
    }


    /**
     * <P> remove Bank by id</P>
     *
     * @param id
     * @return number of record update.
     * @throws SQLException
     */
    public int removeBank(Long id) throws SQLException{
        return this.bankManager.delete(id);
    }


    /**
     * <P> query Bank list from database </P>
     *
     * @param forUpdate
     * @param  page current page
     * @param  maxLine maximum line of a page
     * @return number of record query
     * @throws SQLException
     * @throws IOException
    */
    public BankList queryBank(boolean forUpdate, int page, int maxLine)
            throws SQLException, IOException{
        /* Calculate start position of page */
        int offset = (page - 1) * maxLine;
        return this.bankManager.select(forUpdate, offset, maxLine);
    }


    /**
     * <P> query all of Bank list from database </P>
     *
     * @param forUpdate
     * @return number of record query
     * @throws SQLException
     * @throws IOException
    */
    public BankList queryAllBank(boolean forUpdate)
            throws SQLException, IOException{
        /* if limit < 0 or offset < 0 then select all */
        return this.bankManager.select(forUpdate, -1, -1);
    }

    
    /**
     * <P> Query Bank by ID </P>
     *
     * @param forUpdate
     * @return number of record query
     * @throws SQLException
     * @throws IOException
    */
    public BankInfo queryBankById(Long id, boolean forUpdate)
            throws SQLException, IOException{
    	
    	BankManager bMgr = new BankManager(getConnection());
    	bMgr.setIdFilter(id);

    	BankList list = bMgr.select(forUpdate, -1, -1);
    	
    	if (list.size() > 0) {
    		return list.get(0);
    	} else {
    		return null;
    	}
    }
    

    /**
     * <P> count total Bank </P>
     *
     * @param forUpdate
     * @return number of count record
     * @throws SQLException
     * @throws IOException
    */
    public int countTotalBank()
            throws SQLException, IOException{
        return this.bankManager.countTotal();
    }

    /**
     * <P> Get max order number </P>
     *
     * @param forUpdate
     * @return number of count record
     * @throws SQLException
     * @throws IOException
    */
    public long getMaxOrderNumber()
            throws SQLException, IOException{
        return this.bankManager.getMaxOrderNumber();
    }

    /**
     * <P> Get min order number </P>
     *
     * @param forUpdate
     * @return number of count record
     * @throws SQLException
     * @throws IOException
    */
    public long getMinOrderNumber()
            throws SQLException, IOException{
        return this.bankManager.getMinOrderNumber();
    }

    /**
     * Add order field for table npo_bank
     * @param orderField
     */
    public void addOrderFieldBank(OrderField orderField) {
        this.bankManager.addOrderField(orderField);
    }

    /**
     * Determine record is existed in database based on attributes
     *
     * @param entity
     * @param nameKeyAndValueKey
     * @return TRUE if its was existed
     */
    public Boolean isExistInDB(String entity, Object[][] nameKeyAndValueKey) throws SQLException, IOException {
        return bankManager.isExistInDB(entity, nameKeyAndValueKey);
    }

    /**
     * Set the lowerOrderNumberFilter
     *
     * @param lowerOrderNumberFilter the lowerOrderNumberFilter to set
     */
    public void setLowerOrderNumberFilter(Long lowerOrderNumberFilter) {
        this.bankManager.setLowerOrderNumberFilter(lowerOrderNumberFilter);
    }

    /**
     * Set the upperOrderNumberFilter
     *
     * @param upperOrderNumberFilter the upperOrderNumberFilter to set
     */
    public void setUpperOrderNumberFilter(Long upperOrderNumberFilter) {
        this.bankManager.setUpperOrderNumberFilter(upperOrderNumberFilter);
    }

    /**
     * Set the bank id filter
     *
     * @param idFilter the idFilter to set
     */
    public void setBankIdFilter(Long bankIdFilter) {
        this.bankManager.setIdFilter(bankIdFilter);
    }

    /**
     * <P> query a bank of list from database </P>
     *
     * @param forUpdate
     * @return number of record query
     * @throws SQLException
     * @throws IOException
    */
    public BankInfo getBank(boolean forUpdate)
            throws SQLException, IOException{
        return this.bankManager.getBank(forUpdate);
    }


    /**
     * Set the bank's Name
     *
     * @param bankNameFilter
     * @param kind
     */
    public void setBankNameFilter(String bankNameFilter, FilterKind kind) {
        this.bankManager.setBankNameFilter(bankNameFilter, kind);
    }

    /**
     * Set province id filter
     *
     * @param accountIdFilter
     * @param kind  Filter kind (FULL, LEFT, MIDDLE)
     */
    public void setProvinceIdFilter(Long provinceIdFilter) {

        this.districtManager.setProvinceIdFilter(provinceIdFilter);
    }
    
    /**
     * Set province name filter
     *
     * @param accountIdFilter
     * @param kind  Filter kind (FULL, LEFT, MIDDLE)
     */
    public void setProvinceNameFilter(String provinceNameFilter, FilterKind kind) {

        this.provinceManager.setProvinceNameFilter(provinceNameFilter, kind);
    }
    
    /**
     * Set district name filter
     *
     * @param accountIdFilter
     * @param kind  Filter kind (FULL, LEFT, MIDDLE)
     */
    public void setDistrictNameFilter(String districtNameFilter, FilterKind kind) {

        this.districtManager.setDistrictNameFilter(districtNameFilter, kind);
    }

    /**
     * Add order field for table npo_province
     * @param orderField
     */
    public void addOrderFieldProvince(OrderField orderField) {
        this.provinceManager.addOrderField(orderField);
    }

    /**
     * Add order field for table npo_district
     * @param orderField
     */
    public void addOrderFieldDistrict(OrderField orderField) {
        this.districtManager.addOrderField(orderField);
    }
}
