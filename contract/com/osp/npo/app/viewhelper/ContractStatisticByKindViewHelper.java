package com.osp.npo.app.viewhelper;

import java.util.List;

import com.osp.npo.common.util.EditString;
import com.osp.npo.core.contractTotal.ContractKindTotalInfo;
import com.osp.npo.app.form.ContractStatisticByKindForm;

/**
 * <P>Contract Statistic View Helper</P>
 * 
 * @author HungPT 
 * @version $Revision: 18855 $
 */
public class ContractStatisticByKindViewHelper {
    
    public static final String SESSION_KEY = "contractStatisticByKindViewHelper";
    
    private static final String NULL_DATE_DISP = "......";
    
    private String notaryDateFilter;
    
    private String notaryDateFromFilter;
    
    private String notaryDateToFilter;
    
    private String notaryDateDisp;
    
    private String notaryDateFromDisp;
    
    private String notaryDateToDisp;
    
    private Long numberOfInternalContract;
    
    private Long numberOfExternalContract;
    
    private Long numberOfContract;
    
    private List<ContractKindTotalInfo> listContractByKind;

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
	 * Get notaryDateDisp
	 * @return the notaryDateDisp
	 */
	public String getNotaryDateDisp() {
		return notaryDateDisp;
	}

	/**
	 * Set notaryDateDisp
	 * @param notaryDateDisp the notaryDateDisp to set
	 */
	public void setNotaryDateDisp(String notaryDateDisp) {
		this.notaryDateDisp = notaryDateDisp;
	}

	/**
	 * Get notaryDateFromDisp
	 * @return the notaryDateFromDisp
	 */
	public String getNotaryDateFromDisp() {
		if (EditString.isNull(notaryDateFromDisp)) {
			return NULL_DATE_DISP;
		}
		return notaryDateFromDisp;
	}

	/**
	 * Set notaryDateFromDisp
	 * @param notaryDateFromDisp the notaryDateFromDisp to set
	 */
	public void setNotaryDateFromDisp(String notaryDateFromDisp) {
		this.notaryDateFromDisp = notaryDateFromDisp;
	}

	/**
	 * Get notaryDateToDisp
	 * @return the notaryDateToDisp
	 */
	public String getNotaryDateToDisp() {
		if (EditString.isNull(notaryDateToDisp)) {
			return NULL_DATE_DISP;
		}
		return notaryDateToDisp;
	}

	/**
	 * Set notaryDateToDisp
	 * @param notaryDateToDisp the notaryDateToDisp to set
	 */
	public void setNotaryDateToDisp(String notaryDateToDisp) {
		this.notaryDateToDisp = notaryDateToDisp;
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
     * Get the numberOfInternalContract
     *
     * @return the numberOfInternalContract
     */
    public Long getNumberOfInternalContract() {
        return numberOfInternalContract;
    }

    /**
     * Set the numberOfInternalContract
     *
     * @param numberOfInternalContract the numberOfInternalContract to set
     */
    public void setNumberOfInternalContract(Long numberOfInternalContract) {
        this.numberOfInternalContract = numberOfInternalContract;
    }

    /**
     * Get the numberOfExternalContract
     *
     * @return the numberOfExternalContract
     */
    public Long getNumberOfExternalContract() {
        return numberOfExternalContract;
    }

    /**
     * Set the numberOfExternalContract
     *
     * @param numberOfExternalContract the numberOfExternalContract to set
     */
    public void setNumberOfExternalContract(Long numberOfExternalContract) {
        this.numberOfExternalContract = numberOfExternalContract;
    }

    /**
     * Get the numberOfContract
     *
     * @return the numberOfContract
     */
    public Long getNumberOfContract() {
        return numberOfContract;
    }

    /**
     * Set the numberOfContract
     *
     * @param numberOfContract the numberOfContract to set
     */
    public void setNumberOfContract(Long numberOfContract) {
        this.numberOfContract = numberOfContract;
    }

    /**
     * Get the listContractByKind
     *
     * @return the listContractByKind
     */
    public List<ContractKindTotalInfo> getListContractByKind() {
        return listContractByKind;
    }

    /**
     * Set the listContractByKind
     *
     * @param listContractByKind the listContractByKind to set
     */
    public void setListContractByKind(List<ContractKindTotalInfo> listContractByKind) {
        this.listContractByKind = listContractByKind;
    }

    public void reset(ContractStatisticByKindForm form) {
        this.notaryDateFilter = form.getNotaryDateFilter();
    }
}
