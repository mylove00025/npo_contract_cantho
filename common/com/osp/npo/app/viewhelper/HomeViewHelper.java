package com.osp.npo.app.viewhelper;

import java.util.List;

import com.osp.npo.core.announcement.AnnouncementInfo;
import com.osp.npo.core.contract.ContractKindInfo;
import com.osp.npo.core.contract.ContractKindTreeNode;
import com.osp.npo.core.contract.ContractStatisticalInfo;

/**
 *
 * Context of home page
 *
 * @author Giangvt
 * @version $Revision: 20577 $
 */
public class HomeViewHelper {

    public static final String SESSION_KEY = "homeViewHelper";
    private List<ContractStatisticalInfo> lstContractStatisticalInfo;
    private List<ContractStatisticalInfo> lstContractStatisticalForDrafterInfo;
    private Long countTotalInDay;
    private Long countTotalInWeek;
    private Long countTotalInMonth;
    private Long countTotalInYear;
    private Long countTotalAllTime;
    private List<ContractKindTreeNode> lstContractKindTreeNode;
    private List<AnnouncementInfo> lstAnnouncementInfo;
    private List<ContractKindInfo> lstContractKind;
    private AnnouncementInfo announcementInfo;
    private String isShowPopup;
    
    /**
     * @return the lstContractStatisticalInfo
     */
    public List<ContractStatisticalInfo> getLstContractStatisticalInfo() {
        return lstContractStatisticalInfo;
    }
    /**
     * @param lstContractStatisticalInfo the lstContractStatisticalInfo to set
     */
    public void setLstContractStatisticalInfo(List<ContractStatisticalInfo> lstContractStatisticalInfo) {
        this.lstContractStatisticalInfo = lstContractStatisticalInfo;
    }
    /**
     * @return the countTotalInDay
     */
    public Long getCountTotalInDay() {
        return countTotalInDay;
    }
    /**
     * @param countTotalInDay the countTotalInDay to set
     */
    public void setCountTotalInDay(Long countTotalInDay) {
        this.countTotalInDay = countTotalInDay;
    }
    /**
     * @return the countTotalInWeek
     */
    public Long getCountTotalInWeek() {
        return countTotalInWeek;
    }
    /**
     * @param countTotalInWeek the countTotalInWeek to set
     */
    public void setCountTotalInWeek(Long countTotalInWeek) {
        this.countTotalInWeek = countTotalInWeek;
    }
    /**
     * @return the countTotalInMonth
     */
    public Long getCountTotalInMonth() {
        return countTotalInMonth;
    }
    /**
     * @param countTotalInMonth the countTotalInMonth to set
     */
    public void setCountTotalInMonth(Long countTotalInMonth) {
        this.countTotalInMonth = countTotalInMonth;
    }
    /**
     * @return the countTotalInYear
     */
    public Long getCountTotalInYear() {
        return countTotalInYear;
    }
    /**
     * @param countTotalInYear the countTotalInYear to set
     */
    public void setCountTotalInYear(Long countTotalInYear) {
        this.countTotalInYear = countTotalInYear;
    }
    /**
     * @return the countTotalAllTime
     */
    public Long getCountTotalAllTime() {
        return countTotalAllTime;
    }
    /**
     * @param countTotalAllTime the countTotalAllTime to set
     */
    public void setCountTotalAllTime(Long countTotalAllTime) {
        this.countTotalAllTime = countTotalAllTime;
    }
    /**
     * @return the lstContractKindTreeNode
     */
    public List<ContractKindTreeNode> getLstContractKindTreeNode() {
        return lstContractKindTreeNode;
    }
    /**
     * @param lstContractKindTreeNode the lstContractKindTreeNode to set
     */
    public void setLstContractKindTreeNode(List<ContractKindTreeNode> lstContractKindTreeNode) {
        this.lstContractKindTreeNode = lstContractKindTreeNode;
    }
    /**
     * @return the lstContractStatisticalForDrafterInfo
     */
    public List<ContractStatisticalInfo> getLstContractStatisticalForDrafterInfo() {
        return lstContractStatisticalForDrafterInfo;
    }
    /**
     * @param lstContractStatisticalForDrafterInfo the lstContractStatisticalForDrafterInfo to set
     */
    public void setLstContractStatisticalForDrafterInfo(List<ContractStatisticalInfo> lstContractStatisticalForDrafterInfo) {
        this.lstContractStatisticalForDrafterInfo = lstContractStatisticalForDrafterInfo;
    }
	/**
	 * @return the lstAnnouncementInfo
	 */
	public List<AnnouncementInfo> getLstAnnouncementInfo() {
		return lstAnnouncementInfo;
	}
	/**
	 * @param lstAnnouncementInfo the lstAnnouncementInfo to set
	 */
	public void setLstAnnouncementInfo(List<AnnouncementInfo> lstAnnouncementInfo) {
		this.lstAnnouncementInfo = lstAnnouncementInfo;
	}
	/**
	 * @return the lstContractKind
	 */
	public List<ContractKindInfo> getLstContractKind() {
		return lstContractKind;
	}
	/**
	 * @param lstContractKind the lstContractKind to set
	 */
	public void setLstContractKind(List<ContractKindInfo> lstContractKind) {
		this.lstContractKind = lstContractKind;
	}
	/**
	 * @return the announcementInfo
	 */
	public AnnouncementInfo getAnnouncementInfo() {
		return announcementInfo;
	}
	/**
	 * @param announcementInfo the announcementInfo to set
	 */
	public void setAnnouncementInfo(AnnouncementInfo announcementInfo) {
		this.announcementInfo = announcementInfo;
	}
	/**
	 * @return the isShowPopup
	 */
	public String getIsShowPopup() {
		return isShowPopup;
	}
	/**
	 * @param isShowPopup the isShowPopup to set
	 */
	public void setIsShowPopup(String isShowPopup) {
		this.isShowPopup = isShowPopup;
	}
    
	public int getPersonCount() {
		int count = 0;
		if (this.lstContractStatisticalInfo != null) {
			count += this.lstContractStatisticalInfo.size();
		}
		if (this.lstContractStatisticalForDrafterInfo != null) {
			count += this.lstContractStatisticalForDrafterInfo.size();
		}
		
		return count;
	}
}
