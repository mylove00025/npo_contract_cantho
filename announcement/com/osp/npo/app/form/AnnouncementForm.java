/**
 * 
 */
package com.osp.npo.app.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;
import org.apache.struts.validator.ValidatorForm;

import com.osp.npo.app.message.MessageUtil;
import com.osp.npo.app.viewhelper.AnnouncementViewHelper;
import com.osp.npo.common.util.EditString;

/**
 * @author PhuongNT
 * @version $Revision: 20626 $
 */
public class AnnouncementForm extends ValidatorForm {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2567704601038926619L;
	private Long aid;
    private String kind;
    private String confirmrequest;
    private String importanceType;
    private String popupDisplayFlg;
    private String popupDisplayDay;
    private String title;   
    private String content;
    private String senderInfo;
    private String sendDateTime;
    private String attachFileName;
    private String attachFilePath;
    
    private FormFile formFile;   
   
  

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
	public String getSendDateTime() {
		return sendDateTime;
	}

	/**
	 * @param sendDateTime the sendDateTime to set
	 */
	public void setSendDateTime(String sendDateTime) {
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

	public void clear() {
		this.kind = null;
        this.title = null;
        this.content = null;
        this.senderInfo = null;
        this.importanceType = null;
    }

	/*
     * (non-Javadoc)
     * 
     * @see org.apache.struts.action.ActionForm#validate(org.apache.struts.action.ActionMapping,
     *      javax.servlet.http.HttpServletRequest)
     */
    @Override
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {  
        
    	AnnouncementViewHelper announcementViewHelper = (AnnouncementViewHelper)request.getSession().getAttribute(AnnouncementViewHelper.SESSION_KEY);
        if (announcementViewHelper == null) {
            return new ActionErrors();
        }     
        
        ActionErrors errors = super.validate(mapping, request);
        MessageUtil messageUtil = new MessageUtil();
        
        if (EditString.isNull(getTitle().trim())) {
            errors.add(messageUtil.createActionMessages("title", request, "err_not_input_data", "item_announcement_title"));
        } else {
        	if (getTitle().trim().length() > 200) {
        		errors.add(messageUtil.createActionMessages("title", request, "err_max_length", "item_announcement_title","200"));
        	}
        }
        
        if (!EditString.isNull(getPopupDisplayDay()) && !EditString.isNumber(getPopupDisplayDay())) {
        	errors.add(messageUtil.createActionMessages("popupDisplayDay", request, "err_not_regular", "item_announcement_popup_day"));
        }
        
        if (errors.size() > 0) {
        	announcementViewHelper.reset(this);
        }
        
        return errors;
    }
}
