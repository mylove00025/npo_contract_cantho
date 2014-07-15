/**
 * 
 */
package com.osp.npo.app.viewhelper;

import java.util.List;

import com.osp.npo.app.form.ContractCertifyForm;
import com.osp.npo.core.contract.ContractInfo;
import com.osp.npo.core.contract.ContractKindInfo;

/**
 * @author SonHD
 * @version $Revision: 27248 $
 */
public class ContractCertifyViewHelper extends AbstractPageListViewHelper {
    public static final String SESSION_KEY = "contractCertifyViewHelper";
    
    private String notaryDateFilter;    
    private String notaryDateFromFilter;    
    private String notaryDateToFilter;
    private String notaryDayFilter;
    private String notaryMonMonthFilter;
    private String notaryMonYearFilter;
    private String notaryYearFilter;
    private List<ContractInfo> contractList;
    private List<ContractKindInfo> contractKindList;
    private Long[] chkID;
    private String chkAllID;
    
    /**
     * Get the notaryDateFilter
     *
     * @return the notaryDateFilter
     */
    public String getNotaryDateFilter() {
        return notaryDateFilter;
    }
    /**
     * Set the notaryDateFilter
     *
     * @param notaryDateFilter the notaryDateFilter to set
     */
    public void setNotaryDateFilter(String notaryDateFilter) {
        this.notaryDateFilter = notaryDateFilter;
    }
    /**
     * Get the notaryDateFromFilter
     *
     * @return the notaryDateFromFilter
     */
    public String getNotaryDateFromFilter() {
        return notaryDateFromFilter;
    }
    /**
     * Set the notaryDateFromFilter
     *
     * @param notaryDateFromFilter the notaryDateFromFilter to set
     */
    public void setNotaryDateFromFilter(String notaryDateFromFilter) {
        this.notaryDateFromFilter = notaryDateFromFilter;
    }
    /**
     * Get the notaryDateToFilter
     *
     * @return the notaryDateToFilter
     */
    public String getNotaryDateToFilter() {
        return notaryDateToFilter;
    }
    /**
     * Set the notaryDateToFilter
     *
     * @param notaryDateToFilter the notaryDateToFilter to set
     */
    public void setNotaryDateToFilter(String notaryDateToFilter) {
        this.notaryDateToFilter = notaryDateToFilter;
    }

    /**
     * Get the contractList
     *
     * @return the contractList
     */
    public List<ContractInfo> getContractList() {
        return contractList;
    }
    /**
     * Set the contractList
     *
     * @param contractList the contractList to set
     */
    public void setContractList(List<ContractInfo> contractList) {
        this.contractList = contractList;
    }
    
    /**
     * Get the notaryDayFilter
     *
     * @return the notaryDayFilter
     */
    public String getNotaryDayFilter() {
        return notaryDayFilter;
    }
    /**
     * Set the notaryDayFilter
     *
     * @param notaryDayFilter the notaryDayFilter to set
     */
    public void setNotaryDayFilter(String notaryDayFilter) {
        this.notaryDayFilter = notaryDayFilter;
    }
    
    /**
     * Get the notaryMonMonthFilter
     *
     * @return the notaryMonMonthFilter
     */
    public String getNotaryMonMonthFilter() {
        return notaryMonMonthFilter;
    }
    /**
     * Set the notaryMonMonthFilter
     *
     * @param notaryMonMonthFilter the notaryMonMonthFilter to set
     */
    public void setNotaryMonMonthFilter(String notaryMonMonthFilter) {
        this.notaryMonMonthFilter = notaryMonMonthFilter;
    }
    /**
     * Get the notaryMonYearFilter
     *
     * @return the notaryMonYearFilter
     */
    public String getNotaryMonYearFilter() {
        return notaryMonYearFilter;
    }
    /**
     * Set the notaryMonYearFilter
     *
     * @param notaryMonYearFilter the notaryMonYearFilter to set
     */
    public void setNotaryMonYearFilter(String notaryMonYearFilter) {
        this.notaryMonYearFilter = notaryMonYearFilter;
    }
    /**
     * Get the notaryYearFilter
     *
     * @return the notaryYearFilter
     */
    public String getNotaryYearFilter() {
        return notaryYearFilter;
    }
    
    public List<ContractKindInfo> getContractKindList() {
		return contractKindList;
	}
	public void setContractKindList(List<ContractKindInfo> contractKindList) {
		this.contractKindList = contractKindList;
	}
	
	
	public Long[] getChkID() {
		return chkID;
	}
	public void setChkID(Long[] chkID) {
		this.chkID = chkID;
	}
	public String getChkAllID() {
		return chkAllID;
	}
	public void setChkAllID(String chkAllID) {
		this.chkAllID = chkAllID;
	}
	/**
     * Set the notaryYearFilter
     *
     * @param notaryYearFilter the notaryYearFilter to set
     */
    public void setNotaryYearFilter(String notaryYearFilter) {
        this.notaryYearFilter = notaryYearFilter;
    }
    public void reset(ContractCertifyForm form) {
        this.notaryDateFilter = form.getNotaryDateFilter();
        this.notaryDateFromFilter = form.getNotaryDateFromFilter();
        this.notaryDateToFilter = form.getNotaryDateToFilter();
        this.notaryDayFilter = form.getNotaryDayFilter();
        this.notaryMonMonthFilter = form.getNotaryMonMonthFilter();
        this.notaryMonYearFilter = form.getNotaryMonYearFilter();
        this.notaryYearFilter = form.getNotaryYearFilter();
        this.chkID = form.getChkID();
      }
}