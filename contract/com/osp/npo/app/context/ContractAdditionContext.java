/**
 * 
 */
package com.osp.npo.app.context;

/**
 * @author SonHD
 * 
 */
public class ContractAdditionContext extends BaseSelectionDeleteContext {
    /** session key */
    public static final String SESSION_KEY = "contractAdditionContext";
    
    private String searchDate;
    private String fromDate;
    private String toDate;
    /**
     * Get the searchDate
     *
     * @return the searchDate
     */
    public String getSearchDate() {
        return searchDate;
    }
    /**
     * Set the searchDate
     *
     * @param searchDate the searchDate to set
     */
    public void setSearchDate(String searchDate) {
        this.searchDate = searchDate;
    }
    /**
     * Get the fromDate
     *
     * @return the fromDate
     */
    public String getFromDate() {
        return fromDate;
    }
    /**
     * Set the fromDate
     *
     * @param fromDate the fromDate to set
     */
    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }
    /**
     * Get the toDate
     *
     * @return the toDate
     */
    public String getToDate() {
        return toDate;
    }
    /**
     * Set the toDate
     *
     * @param toDate the toDate to set
     */
    public void setToDate(String toDate) {
        this.toDate = toDate;
    }
    /**
     * 
     */
    public void clear() {
        
    }
}
