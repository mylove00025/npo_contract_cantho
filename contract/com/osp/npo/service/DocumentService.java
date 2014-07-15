package com.osp.npo.service;


import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;


import com.osp.npo.common.global.Constants.FilterKind;
import com.osp.npo.core.OrderField;
import com.osp.npo.core.document.DocumentManager;
import com.osp.npo.core.document.DocumentInfo;
import com.osp.npo.core.document.DocumentList;


/**
 * Generate by script
 * Generate date: 7/13/2011 3:42:15 PM
 * @version $Revision$ 
 */
public class DocumentService extends AbstractService {


    /** Document Manager Object */
    private DocumentManager documentManager;




    /** <P> Service constructor </P>*/
    public DocumentService(Connection connection) {
        super(connection);
        this.documentManager = new DocumentManager (connection);
    }


    /**
     * <P> entry DocumentInfo object to database </P>
     *
     * @param info
     * @return number of record insert.
     * @throws SQLException
     */
    public int entryDocument(DocumentInfo info) throws SQLException{
        return this.documentManager.insert(info);
    }


    /**
     * <P> modify DocumentInfo object to database </P>
     *
     * @param info
     * @return number of record update.
     * @throws SQLException
     * @throws IOException
     */
    public int modifyDocument(DocumentInfo info) throws SQLException, IOException{
        return this.documentManager.update(info);
    }


    /**
     * <P> remove Document by id</P>
     *
     * @param id
     * @return number of record update.
     * @throws SQLException
     */
    public int removeDocument(Long id) throws SQLException{
        return this.documentManager.delete(id);
    }


    /**
     * <P> query Document list from database </P>
     *
     * @param forUpdate
     * @param  page current page
     * @param  maxLine maximum line of a page
     * @return number of record query
     * @throws SQLException
     * @throws IOException
    */
    public DocumentList queryDocument(boolean forUpdate, int page, int maxLine)
            throws SQLException, IOException{
        /* Calculate start position of page */
        int offset = (page - 1) * maxLine;
        return this.documentManager.select(forUpdate, offset, maxLine);
    }


    /**
     * <P> query all of Document list from database </P>
     *
     * @param forUpdate
     * @return number of record query
     * @throws SQLException
     * @throws IOException
    */
    public DocumentList queryAllDocument(boolean forUpdate)
            throws SQLException, IOException{
        /* if limit < 0 or offset < 0 then select all */
        return this.documentManager.select(forUpdate, -1, -1);
    }


    /**
     * <P> count total Document </P>
     *
     * @param forUpdate
     * @return number of count record
     * @throws SQLException
     * @throws IOException
    */
    public int countTotalDocument()
            throws SQLException, IOException{
        return this.documentManager.countTotal();
    }
    
    /**
     * <P>
     * count total  by filter
     * </P>
     *
     * @param forUpdate
     * @return number of count record
     * @throws SQLException
     * @throws IOException
     */
    public int countTotalDocumentByFilter() throws SQLException, IOException {
        return this.documentManager.countTotalByFilter();
    }

    /**
     * 
     * @param nameFilter
     * @param kind
     */
    public void setNameFilter(String nameFilter,FilterKind kind) {
        this.documentManager.setNameFilter(nameFilter, kind);
    }
    /**
     * 
     * @param nameFilter
     * @param kind
     */
    public void setNameCheckFilter(String nameCheckFilter,FilterKind kind) {
        this.documentManager.setNameCheckFilter(nameCheckFilter, kind);
    }
    /**
     * 
     * @param nameFilter
     * @param kind
     */
    public void setDocumentIdFilter(Long documentIdFilter) {
        this.documentManager.setDocumentIdFilter(documentIdFilter);
    }
    
    
    /**
     * 
     * @param PreviousIdFilter
     * @param kind
     */
    public void setPreviousIdFilter(Long previousIdFilter) {
        this.documentManager.setPreviousIdFilter(previousIdFilter);
    }
    /**
     * Add order field for table npo_contract_kind
     * @param orderField
     */
    public void addOrderFieldName(OrderField orderField) {
        this.documentManager.addOrderField(orderField);
    }
    
}
