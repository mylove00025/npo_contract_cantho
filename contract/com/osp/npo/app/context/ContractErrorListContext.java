/**
 * 
 */
package com.osp.npo.app.context;

/**
 * @author SonHD
 * @version $Revision: 19673 $
 */
public class ContractErrorListContext {

    public static final String SESSION_KEY = "contractErrorListContext";
    
    private String fromDateFilter;
    private String toDateFilter;
    private String searchDateFilter;
    private Long notaryIdFilter;
    private Long drafterIdFilter;
    
    /**
     * Get the fromDateFilter
     *
     * @return the fromDateFilter
     */
    public String getFromDateFilter() {
        return fromDateFilter;
    }
    /**
     * Set the fromDateFilter
     *
     * @param fromDateFilter the fromDateFilter to set
     */
    public void setFromDateFilter(String fromDateFilter) {
        this.fromDateFilter = fromDateFilter;
    }
    /**
     * Get the toDateFilter
     *
     * @return the toDateFilter
     */
    public String getToDateFilter() {
        return toDateFilter;
    }
    /**
     * Set the toDateFilter
     *
     * @param toDateFilter the toDateFilter to set
     */
    public void setToDateFilter(String toDateFilter) {
        this.toDateFilter = toDateFilter;
    }
    /**
     * Get the searchDateFilter
     *
     * @return the searchDateFilter
     */
    public String getSearchDateFilter() {
        return searchDateFilter;
    }
    /**
     * Set the searchDateFilter
     *
     * @param searchDateFilter the searchDateFilter to set
     */
    public void setSearchDateFilter(String searchDateFilter) {
        this.searchDateFilter = searchDateFilter;
    }
    /**
     * Get the notaryIdFilter
     *
     * @return the notaryIdFilter
     */
    public Long getNotaryIdFilter() {
        return notaryIdFilter;
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
     * Get the drafterIdFilter
     *
     * @return the drafterIdFilter
     */
    public Long getDrafterIdFilter() {
        return drafterIdFilter;
    }
    /**
     * Set the drafterIdFilter
     *
     * @param drafterIdFilter the drafterIdFilter to set
     */
    public void setDrafterIdFilter(Long drafterIdFilter) {
        this.drafterIdFilter = drafterIdFilter;
    }
    
    public void clear()
    {
        this.drafterIdFilter = null;
        this.notaryIdFilter = null;
        this.fromDateFilter = null;
        this.toDateFilter = null;
        this.searchDateFilter = null;        
    }
}
