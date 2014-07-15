package com.osp.npo.app.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import com.osp.npo.app.message.MessageUtil;
import com.osp.npo.common.util.EditString;

public class SystemConfigForm extends ActionForm {

    private static final long serialVersionUID = 4877081921563923309L;

    private String notaryOfficeName;
    private String notaryOfficeAddress;
    private String recordPerPage;
    private String synchronizeWebserviceUrl;
    private String synchronizePeriod;
    private String synchronizeRecord;
    private String synchronizeAccount;
    private String synchronizePassword;
    
    // For PCC1
    private String synchronizeAuto;
    
    private String synchronizeAutoPeriod;

    @Override
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();
        MessageUtil messageUtil = new MessageUtil();

        if (!EditString.isNull(getNotaryOfficeName()) && getNotaryOfficeName().length() > 100) {
            errors.add(messageUtil.createActionMessages("notaryOfficeName", request, "err_max_length", "item_notary_office_name", "100"));
        }

        if (!EditString.isNull(getNotaryOfficeAddress()) && getNotaryOfficeAddress().length() > 100) {
            errors.add(messageUtil.createActionMessages("notaryOfficeAddress", request, "err_max_length", "item_notary_office_address", "100"));
        }

        if (!EditString.isNull(getRecordPerPage())) {
            if (getNotaryOfficeAddress().length() > 100) {
                errors.add(messageUtil.createActionMessages("recordPerPage", request, "err_max_length", "item_record_per_page", "100"));
            } else {
                try {
                    Integer.parseInt(getRecordPerPage());
                } catch (Exception e) {
                    errors.add(messageUtil.createActionMessages("recordPerPage", request, "err_not_regular", "item_record_per_page"));
                }
            }
        }

        if (!EditString.isNull(getSynchronizeWebserviceUrl()) && getSynchronizeWebserviceUrl().length() > 100) {
            errors.add(messageUtil.createActionMessages("synchronizeWebserviceUrl", request, "err_max_length", "item_synchronize_webservice_url", "100"));
        }

        if (!EditString.isNull(getSynchronizePeriod()) && getSynchronizePeriod().length() > 100) {
            errors.add(messageUtil.createActionMessages("synchronizePeriod", request, "err_max_length", "item_synchronize_period", "100"));
        }

        if (!EditString.isNull(getRecordPerPage())) {
            if (getNotaryOfficeAddress().length() > 100) {
                errors.add(messageUtil.createActionMessages("synchronizeRecord", request, "err_max_length", "item_synchronize_record", "100"));
            } else {
                try {
                    Integer.parseInt(getRecordPerPage());
                } catch (Exception e) {
                    errors.add(messageUtil.createActionMessages("synchronizeRecord", request, "err_not_regular", "item_synchronize_record"));
                }
            }
        }

        if (!EditString.isNull(getSynchronizeAccount()) && getSynchronizeAccount().length() > 100) {
            errors.add(messageUtil.createActionMessages("synchronizeAccount", request, "err_max_length", "item_synchronize_account", "100"));
        }

        if (!EditString.isNull(getSynchronizePassword()) && getSynchronizePassword().length() > 100) {
            errors.add(messageUtil.createActionMessages("synchronizePassword", request, "err_max_length", "item_synchronize_password", "100"));
        }
        
        if (!EditString.isNull(getSynchronizeAuto()) && getSynchronizeAuto().length() > 2) {
            errors.add(messageUtil.createActionMessages("synchronizeAuto", request, "err_max_length", "item_synchronize_auto", "2"));
        }
        
        if (!EditString.isNull(getSynchronizeAutoPeriod()) && getSynchronizeAutoPeriod().length() > 100) {
            errors.add(messageUtil.createActionMessages("synchronizeAutoPeriod", request, "err_max_length", "item_synchronize_auto_period", "100"));
        }

        return errors;
    }

    /**
     * @return the notaryOfficeName
     */
    public String getNotaryOfficeName() {
        return notaryOfficeName;
    }

    /**
     * @param notaryOfficeName
     *            the notaryOfficeName to set
     */
    public void setNotaryOfficeName(String notaryOfficeName) {
        this.notaryOfficeName = notaryOfficeName;
    }

    /**
     * @return the notaryOfficeAddress
     */
    public String getNotaryOfficeAddress() {
        return notaryOfficeAddress;
    }

    /**
     * @param notaryOfficeAddress
     *            the notaryOfficeAddress to set
     */
    public void setNotaryOfficeAddress(String notaryOfficeAddress) {
        this.notaryOfficeAddress = notaryOfficeAddress;
    }

    /**
     * @return the recordPerPage
     */
    public String getRecordPerPage() {
        return recordPerPage;
    }

    /**
     * @param recordPerPage
     *            the recordPerPage to set
     */
    public void setRecordPerPage(String recordPerPage) {
        this.recordPerPage = recordPerPage;
    }

    /**
     * @return the synchronizeWebserviceUrl
     */
    public String getSynchronizeWebserviceUrl() {
        return synchronizeWebserviceUrl;
    }

    /**
     * @param synchronizeWebserviceUrl
     *            the synchronizeWebserviceUrl to set
     */
    public void setSynchronizeWebserviceUrl(String synchronizeWebserviceUrl) {
        this.synchronizeWebserviceUrl = synchronizeWebserviceUrl;
    }

    /**
     * @return the synchronizePeriod
     */
    public String getSynchronizePeriod() {
        return synchronizePeriod;
    }

    /**
     * @param synchronizePeriod
     *            the synchronizePeriod to set
     */
    public void setSynchronizePeriod(String synchronizePeriod) {
        this.synchronizePeriod = synchronizePeriod;
    }

    /**
     * @return the synchronizeRecord
     */
    public String getSynchronizeRecord() {
        return synchronizeRecord;
    }

    /**
     * @param synchronizeRecord
     *            the synchronizeRecord to set
     */
    public void setSynchronizeRecord(String synchronizeRecord) {
        this.synchronizeRecord = synchronizeRecord;
    }

    /**
     * @return the synchronizeAccount
     */
    public String getSynchronizeAccount() {
        return synchronizeAccount;
    }

    /**
     * @param synchronizeAccount
     *            the synchronizeAccount to set
     */
    public void setSynchronizeAccount(String synchronizeAccount) {
        this.synchronizeAccount = synchronizeAccount;
    }

    /**
     * @return the synchronizePassword
     */
    public String getSynchronizePassword() {
        return synchronizePassword;
    }

    /**
     * @param synchronizePassword
     *            the synchronizePassword to set
     */
    public void setSynchronizePassword(String synchronizePassword) {
        this.synchronizePassword = synchronizePassword;
    }

	public String getSynchronizeAuto() {
		return synchronizeAuto;
	}

	public void setSynchronizeAuto(String synchronizeAuto) {
		this.synchronizeAuto = synchronizeAuto;
	}

	public String getSynchronizeAutoPeriod() {
		return synchronizeAutoPeriod;
	}

	public void setSynchronizeAutoPeriod(String synchronizeAutoPeriod) {
		this.synchronizeAutoPeriod = synchronizeAutoPeriod;
	}
    
}
