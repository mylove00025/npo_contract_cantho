package com.osp.npo.core.document;


import com.osp.npo.core.AbstractList;
import com.osp.npo.core.document.DocumentInfo;


/**
 * Generate by script
 * Generate date: 7/13/2011 4:00:13 PM
 * @version $Revision$ 
 */
public class DocumentList extends AbstractList {


    /**
     * <P>Generate Instance.</P>
     *
     */
    public DocumentList() {
        super();
    }


    /**
     * <P>Get object Info from List</P>
     *
     * @param index Index
     * @return object Info
     */
    public DocumentInfo get(int index) {
        return ((DocumentInfo) this.list.get(index));
    }


    /**
     * <P>Add object Info to List.</P>
     *
     * @param info object Info
     * @return List of ojbect after add object Info
     */
    public boolean add(DocumentInfo info) {
        return this.list.add(info);
    }
}
