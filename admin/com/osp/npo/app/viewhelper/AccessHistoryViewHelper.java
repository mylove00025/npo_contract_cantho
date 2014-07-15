/**
 * 
 */
package com.osp.npo.app.viewhelper;

import java.util.List;

import com.osp.npo.app.form.AccessHistoryForm;
import com.osp.npo.core.accessHistory.AccessHistoryInfo;
import com.osp.npo.core.user.UserInfo;

/**
 * @author Truongnd
 * @version $Revision: 19279 $
 */
public class AccessHistoryViewHelper extends AbstractPageListViewHelper {
    public static final String SESSION_KEY = "accessHistoryViewHelper";
    private Long userIdFilter;
    private String clientInfoFilter;    
    private String executeDateTimeFilter;    
    private String accessDateToFilter;
    private String acccessDateFromFilter;   
    private Byte accessTypeFilter;
    private String type;
    private List<AccessHistoryInfo> accList;
    private List<UserInfo> userList;
    
    /**
     * Get the userIdFilter
     *
     * @return the userIdFilter
     */
    public Byte getAccessTypeFilter() {
        return accessTypeFilter;
    }
    /**
     * Set the userIdFilter
     *
     * @param userIdFilter the userIdFilter to set
     */
    public void setAccessTypeFilter(Byte accessTypeFilter) {
        this.accessTypeFilter = accessTypeFilter;
    }
    
    /**
     * Get the clientInfoFilter
     *
     * @return the clientInfoFilter
     */
    public String getClientInfoFilter() {
        return clientInfoFilter;
    }
    /**
     * Set the clientInfoFilter
     *
     * @param clientInfoFilter the clientInfoFilter to set
     */
    public void setClientInfoFilter(String clientInfoFilter) {
        this.clientInfoFilter = clientInfoFilter;
    }
    /**
     * Get the executeDateTimeFilter
     *
     * @return the executeDateTimeFilter
     */
    public String getExecuteDateTimeFilter() {
        return executeDateTimeFilter;
    }
    /**
     * Set the executeDateTimeFilter
     *
     * @param executeDateTimeFilter the executeDateTimeFilter to set
     */
    public void setExecuteDateTimeFilter(String executeDateTimeFilter) {
        this.executeDateTimeFilter = executeDateTimeFilter;
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
     * Get the contractList
     *
     * @return the contractList
     */
    public List<AccessHistoryInfo> getAccList() {
        return accList;
    }
    /**
     * Set the contractList
     *
     * @param contractList the contractList to set
     */
    public void setAccList(List<AccessHistoryInfo> accList) {
        this.accList = accList;
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
    public void reset(AccessHistoryForm accessHistoryForm) {
        this.executeDateTimeFilter = accessHistoryForm.getExecuteDateTimeFilter();
        this.accessDateToFilter = accessHistoryForm.getAccessDateToFilter();
        this.acccessDateFromFilter = accessHistoryForm.getAccessDateFromFilter();
        this.userIdFilter = accessHistoryForm.getUserIdFilter();
        this.accessTypeFilter = accessHistoryForm.getAccessTypeFilter();
    }
	public void setType(String type) {
		this.type = type;
	}
	public String getType() {
		return type;
	}
	public void setUserList(List<UserInfo> userList) {
		this.userList = userList;
	}
	public List<UserInfo> getUserList() {
		return userList;
	}
	public void setAccessDateFromFilter(String acccessDateFromFilter) {
		this.acccessDateFromFilter = acccessDateFromFilter;
	}
	public String getAccessDateFromFilter() {
		return acccessDateFromFilter;
	}
	
}
