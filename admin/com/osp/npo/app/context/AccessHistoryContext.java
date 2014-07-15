package com.osp.npo.app.context;

/**
 * <P>Contract context</P>
 * 
 * @author truongnd 
 * @version $Revision: 20030 $
 */
public class AccessHistoryContext {
    
    public static final String SESSION_KEY = "accessHistoryContext";
    
    
    private Byte accessTypeFilter;
    
    private String accessDateFilter;
    
    private String accessDateFromFilter;
    
    private String accessDateToFilter;
    
    private Long userIdFilter;
    
    private Boolean isHidePanelSearch = Boolean.FALSE;
    
    private Boolean isAdvanceSearch = Boolean.FALSE;


    /**
     * Get the accessTypeFilter
     *
     * @return the accessTypeFilter
     */
    public Byte getAccessTypeFilter() {
        return accessTypeFilter;
    }

    /**
     * Set the accessTypeFilter
     *
     * @param accessTypeFilter the accessTypeFilter to set
     */
    public void setAccessTypeFilter(Byte accessTypeFilter) {
        this.accessTypeFilter = accessTypeFilter;
    }




    /**
     * Get the accessDateFilter
     *
     * @return the accessDateFilter
     */
    public String getAccessDateFilter() {
        return accessDateFilter;
    }

    /**
     * Set the accessDateFilter
     *
     * @param accessDateFilter the accessDateFilter to set
     */
    public void setAccessDateFilter(String accessDateFilter) {
        this.accessDateFilter = accessDateFilter;
    }

    /**
     * Get the accessDateFromFilter
     *
     * @return the accessDateFromFilter
     */
    public String getAccessDateFromFilter() {
        return accessDateFromFilter;
    }

    /**
     * Set the accessDateFromFilter
     *
     * @param accessDateFromFilter the accessDateFromFilter to set
     */
    public void setAccessDateFromFilter(String accessDateFromFilter) {
        this.accessDateFromFilter = accessDateFromFilter;
    }

    /**
     * Get the accessDateToFilter
     *
     * @return the accessDateToFilter
     */
    public String getAccessDateToFilter() {
        return accessDateToFilter;
    }

    /**
     * Set the accessDateToFilter
     *
     * @param accessDateToFilter the accessDateToFilter to set
     */
    public void setAccessDateToFilter(String accessDateToFilter) {
        this.accessDateToFilter = accessDateToFilter;
    }


    /**
     * Get the userIdFilter
     *
     * @return the userIdFilter
     */
    public Long getUserIdFilter() {
        return userIdFilter;
    }

    /**
     * Set the userIdFilter
     *
     * @param userIdFilter the userIdFilter to set
     */
    public void setUserIdFilter(Long userIdFilter) {
        this.userIdFilter = userIdFilter;
    }

    /**
     * Get the isHidePanelSearch
     *
     * @return the isHidePanelSearch
     */
    public Boolean getIsHidePanelSearch() {
        return isHidePanelSearch;
    }

    /**
     * Set the isHidePanelSearch
     *
     * @param isHidePanelSearch the isHidePanelSearch to set
     */
    public void setIsHidePanelSearch(Boolean isHidePanelSearch) {
        this.isHidePanelSearch = isHidePanelSearch;
    }

    /**
     * Get the isAdvanceSearch
     *
     * @return the isAdvanceSearch
     */
    public Boolean getIsAdvanceSearch() {
        return isAdvanceSearch;
    }

    /**
     * Set the isAdvanceSearch
     *
     * @param isAdvanceSearch the isAdvanceSearch to set
     */
    public void setIsAdvanceSearch(Boolean isAdvanceSearch) {
        this.isAdvanceSearch = isAdvanceSearch;
    }


    public void clear() {
        this.accessTypeFilter = null;
        this.accessDateFilter = null;
        this.accessDateFromFilter = null;
        this.accessDateToFilter = null;
        this.userIdFilter = null;
    }
}
