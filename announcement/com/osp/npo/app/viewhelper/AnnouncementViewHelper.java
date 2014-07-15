/**
 * 
 */
package com.osp.npo.app.viewhelper;

import java.sql.Timestamp;
import java.util.List;

import org.apache.struts.upload.FormFile;

import com.osp.npo.app.form.AnnouncementForm;
import com.osp.npo.core.announcement.AnnouncementInfo;

/**
 * @author PhuongNT
 * @version $Revision: 27055 $
 */
public class AnnouncementViewHelper extends AbstractPageListViewHelper {
    
    public static final String SESSION_KEY = "announcementViewHelper";
    
    private Long aid;
    private String kind;
    private String confirmrequest;
    private String importanceType;
    private String popupDisplayFlg;
    private String popupDisplayDay;
    private String title;   
    private String content;
    private String senderInfo;
    private Timestamp sendDateTime;
    private String attachFileName;
    private String attachFilePath;
    
    private FormFile formFile;   
   
    private List<AnnouncementInfo> lstAnnouncementInfo;
  

	/**
	 * @return the aid
	 */
	public Long getAid() {
		return aid;
	}

	/**
	 * @param aid the aid to set
	 */
	public void setAid(Long aid) {
		this.aid = aid;
	}

	/**
	 * @return the kind
	 */
	public String getKind() {
		return kind;
	}

	/**
	 * @param kind the kind to set
	 */
	public void setKind(String kind) {
		this.kind = kind;
	}

	/**
	 * @return the confirmrequest
	 */
	public String getConfirmrequest() {
		return confirmrequest;
	}

	/**
	 * @param confirmrequest the confirmrequest to set
	 */
	public void setConfirmrequest(String confirmrequest) {
		this.confirmrequest = confirmrequest;
	}

	/**
	 * @return the importanceType
	 */
	public String getImportanceType() {
		return importanceType;
	}

	/**
	 * @param importanceType the importanceType to set
	 */
	public void setImportanceType(String importanceType) {
		this.importanceType = importanceType;
	}

	/**
	 * @return the popupDisplayFlg
	 */
	public String getPopupDisplayFlg() {
		return popupDisplayFlg;
	}

	/**
	 * @param popupDisplayFlg the popupDisplayFlg to set
	 */
	public void setPopupDisplayFlg(String popupDisplayFlg) {
		this.popupDisplayFlg = popupDisplayFlg;
	}

	/**
	 * @return the popupDisplayDay
	 */
	public String getPopupDisplayDay() {
		return popupDisplayDay;
	}

	/**
	 * @param popupDisplayDay the popupDisplayDay to set
	 */
	public void setPopupDisplayDay(String popupDisplayDay) {
		this.popupDisplayDay = popupDisplayDay;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the senderInfo
	 */
	public String getSenderInfo() {
		return senderInfo;
	}

	/**
	 * @param senderInfo the senderInfo to set
	 */
	public void setSenderInfo(String senderInfo) {
		this.senderInfo = senderInfo;
	}

	/**
	 * @return the sendDateTime
	 */
	public Timestamp getSendDateTime() {
		return sendDateTime;
	}

	/**
	 * @param sendDateTime the sendDateTime to set
	 */
	public void setSendDateTime(Timestamp sendDateTime) {
		this.sendDateTime = sendDateTime;
	}

	/**
	 * @return the attachFileName
	 */
	public String getAttachFileName() {
		return attachFileName;
	}

	/**
	 * @param attachFileName the attachFileName to set
	 */
	public void setAttachFileName(String attachFileName) {
		this.attachFileName = attachFileName;
	}

	/**
	 * @return the attachFilePath
	 */
	public String getAttachFilePath() {
		return attachFilePath;
	}

	/**
	 * @param attachFilePath the attachFilePath to set
	 */
	public void setAttachFilePath(String attachFilePath) {
		this.attachFilePath = attachFilePath;
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
	 * @return the formFile
	 */
	public FormFile getFormFile() {
		return formFile;
	}

	/**
	 * @param formFile the formFile to set
	 */
	public void setFormFile(FormFile formFile) {
		this.formFile = formFile;
	}

	public void reset(AnnouncementForm form) {
        this.kind = form.getKind();
        this.title = form.getTitle();
        this.content = form.getContent();
        this.senderInfo = form.getSenderInfo();
        this.importanceType = form.getImportanceType();
        this.formFile = form.getFormFile();
        this.popupDisplayDay = form.getPopupDisplayDay();
    }
	
}
