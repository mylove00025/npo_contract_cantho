package com.osp.npo.service;


import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;


import com.osp.npo.common.global.Constants.FilterKind;
import com.osp.npo.core.OrderField;
import com.osp.npo.core.customer.CustomerManager;
import com.osp.npo.core.customer.CustomerInfo;
import com.osp.npo.core.customer.CustomerList;


/**
 * Generate by script
 * Generate date: 04/22/2011 2:22:58 PM
 * @version $Revision$ 
 */
public class CustomerService extends AbstractService {


    /** Customer Manager Object */
    private CustomerManager customerManager;




    /** <P> Service constructor </P>*/
    public CustomerService(Connection connection) {
        super(connection);
        this.customerManager = new CustomerManager (connection);
    }


    /**
     * <P> entry CustomerInfo object to database </P>
     *
     * @param info
     * @return number of record insert.
     * @throws SQLException
     */
    public int entryCustomer(CustomerInfo info) throws SQLException{
        return this.customerManager.insert(info);
    }


    /**
     * <P> modify CustomerInfo object to database </P>
     *
     * @param info
     * @return number of record update.
     * @throws SQLException
     * @throws IOException
     */
    public int modifyCustomer(CustomerInfo info) throws SQLException, IOException{
        return this.customerManager.update(info);
    }


    /**
     * <P> remove Customer by id</P>
     *
     * @param id
     * @return number of record update.
     * @throws SQLException
     */
    public int removeCustomer(Long id) throws SQLException{
        return this.customerManager.delete(id);
    }


    /**
     * <P> query Customer list from database </P>
     *
     * @param forUpdate
     * @param  page current page
     * @param  maxLine maximum line of a page
     * @return number of record query
     * @throws SQLException
     * @throws IOException
    */
    public CustomerList queryCustomer(boolean forUpdate, int page, int maxLine)
            throws SQLException, IOException{
        /* Calculate start position of page */
        int offset = (page - 1) * maxLine;
        return this.customerManager.select(forUpdate, offset, maxLine);
    }


    /**
     * <P> query all of Customer list from database </P>
     *
     * @param forUpdate
     * @return number of record query
     * @throws SQLException
     * @throws IOException
    */
    public CustomerList queryAllCustomer(boolean forUpdate)
            throws SQLException, IOException{
        /* if limit < 0 or offset < 0 then select all */
        return this.customerManager.select(forUpdate, -1, -1);
    }


    /**
     * <P> count total Customer </P>
     *
     * @param forUpdate
     * @return number of count record
     * @throws SQLException
     * @throws IOException
    */
    public int countTotalCustomer()
            throws SQLException, IOException{
        return this.customerManager.countTotal();
    }
    
    /**
     * Set the customerFilter
     *
     * @param typeKeySearchFilter the typeKeySearchFilter to set
     */
    public void setCustomerFilter(String customerFilter, FilterKind kind) {
        this.customerManager.setCustomerFilter(customerFilter, kind);
    }
    
    /**
     * Add order field for table npo_customer
     * @param orderField
     */
    public void addOrderFieldCustomer(OrderField orderField) {
        this.customerManager.addOrderField(orderField);
    }
}
