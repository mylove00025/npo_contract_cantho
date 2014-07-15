package com.osp.npo.app.viewhelper;

/**
 * AbstractPageSelDelListViewHelper class
 * 
 * @author haint
 * @version $Revision: 17052 $
 */
abstract public class AbstractPageSelDelListViewHelper extends
        AbstractPageListViewHelper {


    private String[] chkID;


    
    public String[] getChkID() {
        return chkID;
    }


    
    public void setChkID(String[] chkID) {
        this.chkID = chkID;
    }
}
