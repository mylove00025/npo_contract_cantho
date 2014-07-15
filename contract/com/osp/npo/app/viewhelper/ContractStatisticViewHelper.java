package com.osp.npo.app.viewhelper;

import java.util.List;

import com.osp.npo.common.util.EditString;
import com.osp.npo.app.form.ContractStatisticForm;
import com.osp.npo.core.contractTotal.ContractBankTotalInfo;
import com.osp.npo.core.contractTotal.ContractUserTotalInfo;


/**
 * <P>Contract Statistic View Helper</P>
 * 
 * @author HungPT 
 * @version $Revision: 18855 $
 */
public class ContractStatisticViewHelper {
    
    public static final String SESSION_KEY = "contractStatisticViewHelper";
    
    private static final String NULL_DATE_DISP = "......";
    
    private String notaryDateFilter;
    
    private String notaryDateFromFilter;
    
    private String notaryDateToFilter;
    
    private String notaryDateDisp;
    
    private String notaryDateFromDisp;
    
    private String notaryDateToDisp;
    
    private Integer totalContract;
    
    private Integer totalErrorContract;
    
    private List<ContractUserTotalInfo> listContractByNotary;
    
    private List<ContractUserTotalInfo> listContractByDrafter;
    
    private List<ContractBankTotalInfo> listContractByBank;

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
     * Get the totalContract
     *
     * @return the totalContract
     */
    public Integer getTotalContract() {
        return totalContract;
    }

    /**
     * Set the totalContract
     *
     * @param totalContract the totalContract to set
     */
    public void setTotalContract(Integer totalContract) {
        this.totalContract = totalContract;
    }

    /**
     * Get the totalContractByNotary
     *
     * @return the totalContractByNotary
     */
    public Integer getTotalContractByNotary() {
        if (listContractByNotary == null) {
        	return 0;
        }
        
        int total = 0;
        for(ContractUserTotalInfo info : listContractByNotary) {
        	total += info.getNumberOfContract();
        }
        
        return total;
    }
    
    /**
     * Get the totalContractByNotary
     *
     * @return the totalContractByNotary
     */
    public Integer getTotalErrorContractByNotary() {
        if (listContractByNotary == null) {
        	return 0;
        }
        
        int total = 0;
        for(ContractUserTotalInfo info : listContractByNotary) {
        	total += info.getNumberOfErrorContract();
        }
        
        return total;
    }

    /**
     * Get the totalContractByDrafter
     *
     * @return the totalContractByDrafter
     */
    public Integer getTotalContractByDrafter() {
    	if (listContractByDrafter == null) {
        	return 0;
        }
        
        int total = 0;
        for(ContractUserTotalInfo info : listContractByDrafter) {
        	total += info.getNumberOfContract();
        }
        
        return total;
    }
    
    /**
     * Get the totalContractByDrafter
     *
     * @return the totalContractByDrafter
     */
    public Integer getTotalErrorContractByDrafter() {
    	if (listContractByDrafter == null) {
        	return 0;
        }
        
        int total = 0;
        for(ContractUserTotalInfo info : listContractByDrafter) {
        	total += info.getNumberOfErrorContract();
        }
        
        return total;
    }


    /**
     * Get the totalContractByBank
     *
     * @return the totalContractByBank
     */
    public Integer getTotalContractByBank() {
    	if (listContractByBank == null) {
        	return 0;
        }
        
        int total = 0;
        for(ContractBankTotalInfo info : listContractByBank) {
        	total += info.getNumberOfContract();
        }
        
        return total;
    }

    
    /**
     * Get the totalErrorContract
     *
     * @return the totalErrorContract
     */
    public Integer getTotalErrorContract() {
        return totalErrorContract;
    }

    /**
     * Set the totalErrorContract
     *
     * @param totalErrorContract the totalErrorContract to set
     */
    public void setTotalErrorContract(Integer totalErrorContract) {
        this.totalErrorContract = totalErrorContract;
    }

    /**
     * Get the listContractByNotary
     *
     * @return the listContractByNotary
     */
    public List<ContractUserTotalInfo> getListContractByNotary() {
        return listContractByNotary;
    }

    /**
     * Set the listContractByNotary
     *
     * @param listContractByNotary the listContractByNotary to set
     */
    public void setListContractByNotary(List<ContractUserTotalInfo> listContractByNotary) {
        this.listContractByNotary = listContractByNotary;
    }

    /**
     * Get the listContractByDrafter
     *
     * @return the listContractByDrafter
     */
    public List<ContractUserTotalInfo> getListContractByDrafter() {
        return listContractByDrafter;
    }

    /**
     * Set the listContractByDrafter
     *
     * @param listContractByDrafter the listContractByDrafter to set
     */
    public void setListContractByDrafter(List<ContractUserTotalInfo> listContractByDrafter) {
        this.listContractByDrafter = listContractByDrafter;
    }

    /**
     * Get the listContractByBank
     *
     * @return the listContractByBank
     */
    public List<ContractBankTotalInfo> getListContractByBank() {
        return listContractByBank;
    }

    /**
     * Set the listContractByBank
     *
     * @param listContractByBank the listContractByBank to set
     */
    public void setListContractByBank(List<ContractBankTotalInfo> listContractByBank) {
        this.listContractByBank = listContractByBank;
    }

    public void reset(ContractStatisticForm form) {
        this.notaryDateFilter = form.getNotaryDateFilter();
    }
}
