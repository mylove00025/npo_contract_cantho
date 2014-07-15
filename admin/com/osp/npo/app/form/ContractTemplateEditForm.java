package com.osp.npo.app.form;

import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;
import org.apache.struts.validator.ValidatorForm;

import com.osp.npo.app.message.MessageUtil;
import com.osp.npo.app.viewhelper.ContractTemplateEditViewHelper;
import com.osp.npo.common.util.EditString;
import com.osp.npo.core.contract.ContractKindTreeNode;

/**
 * <P>Contract List Form</P>
 * 
 * @author KienLT
 * @version $Revision$
 */
public class ContractTemplateEditForm extends ValidatorForm {
    
    /**
     * 
     */
    private static final long serialVersionUID = 1313015431967502175L;
    private String contractTemplateName;
    private List<ContractKindTreeNode> contractKindTreeNodeList;
    private String contractTemplateDescription;
    private FormFile formFile;
    private String fileName;
    private Boolean activeFlg;
    private String updateUserName;
    private Timestamp updateDateTime;
    private Long contractKindId;
    private String contractTemplateCode;
    private int relateObjectNumber; 
    private String relateObjectATitle;
    private String relateObjectBTitle;
    private String relateObjectCTitle;
    private Boolean mortageCancelFunc;
    private Boolean periodFlag;
    
    /**
     * Get the contractKindId
     *
     * @return the contractKindId
     */
    public Long getContractKindId() {
        return contractKindId;
    }
    /**
     * Set the contractKindId
     *
     * @param contractKindId the contractKindId to set
     */
    public void setContractKindId(Long contractKindId) {
        this.contractKindId = contractKindId;
    }
    /**
     * Get the contractTemplateName
     *
     * @return the contractTemplateName
     */
    public String getContractTemplateName() {
        return contractTemplateName;
    }
    /**
     * Set the contractTemplateName
     *
     * @param contractTemplateName the contractTemplateName to set
     */
    public void setContractTemplateName(String contractTemplateName) {
        this.contractTemplateName = contractTemplateName;
    }
    /**
     * Get the contractKindTreeNodeList
     *
     * @return the contractKindTreeNodeList
     */
    public List<ContractKindTreeNode> getContractKindTreeNodeList() {
        return contractKindTreeNodeList;
    }
    /**
     * Set the contractKindTreeNodeList
     *
     * @param contractKindTreeNodeList the contractKindTreeNodeList to set
     */
    public void setContractKindTreeNodeList(List<ContractKindTreeNode> contractKindTreeNodeList) {
        this.contractKindTreeNodeList = contractKindTreeNodeList;
    }
    /**
     * Get the contractTemplateDescription
     *
     * @return the contractTemplateDescription
     */
    public String getContractTemplateDescription() {
        return contractTemplateDescription;
    }
    /**
     * Set the contractTemplateDescription
     *
     * @param contractTemplateDescription the contractTemplateDescription to set
     */
    public void setContractTemplateDescription(String contractTemplateDescription) {
        this.contractTemplateDescription = contractTemplateDescription;
    }
    /**
     * Get the formFile
     *
     * @return the formFile
     */
    public FormFile getFormFile() {
        return formFile;
    }
    /**
     * Set the formFile
     *
     * @param formFile the formFile to set
     */
    public void setFormFile(FormFile formFile) {
        this.formFile = formFile;
    }
    /**
     * Get the fileName
     *
     * @return the fileName
     */
    public String getFileName() {
        return fileName;
    }
    /**
     * Set the fileName
     *
     * @param fileName the fileName to set
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    /**
     * Get the activeFlg
     *
     * @return the activeFlg
     */
    public Boolean getActiveFlg() {
        return activeFlg;
    }
    /**
     * Set the activeFlg
     *
     * @param activeFlg the activeFlg to set
     */
    public void setActiveFlg(Boolean activeFlg) {
        this.activeFlg = activeFlg;
    }
    /**
     * Get the updateUserName
     *
     * @return the updateUserName
     */
    public String getUpdateUserName() {
        return updateUserName;
    }
    /**
     * Set the updateUserName
     *
     * @param updateUserName the updateUserName to set
     */
    public void setUpdateUserName(String updateUserName) {
        this.updateUserName = updateUserName;
    }
    /**
     * Get the updateDateTime
     *
     * @return the updateDateTime
     */
    public Timestamp getUpdateDateTime() {
        return updateDateTime;
    }
    /**
     * Set the updateDateTime
     *
     * @param updateDateTime the updateDateTime to set
     */
    public void setUpdateDateTime(Timestamp updateDateTime) {
        this.updateDateTime = updateDateTime;
    }
    
    /**
     * Get the contractTemplateCode
     *
     * @return the contractTemplateCode
     */
    public String getContractTemplateCode() {
        return contractTemplateCode;
    }
    /**
     * Set the contractTemplateCode
     *
     * @param contractTemplateCode the contractTemplateCode to set
     */
    public void setContractTemplateCode(String contractTemplateCode) {
        this.contractTemplateCode = contractTemplateCode;
    }
    /**
     * Get the relateObjectNumber
     *
     * @return the relateObjectNumber
     */
    public int getRelateObjectNumber() {
        return relateObjectNumber;
    }
    /**
     * Set the relateObjectNumber
     *
     * @param relateObjectNumber the relateObjectNumber to set
     */
    public void setRelateObjectNumber(int relateObjectNumber) {
        this.relateObjectNumber = relateObjectNumber;
    }
    
    /**
	 * @param relateObjectATitle the relateObjectATitle to set
	 */
	public void setRelateObjectATitle(String relateObjectATitle) {
		this.relateObjectATitle = relateObjectATitle;
	}

	/**
	 * @return the relateObjectATitle
	 */
	public String getRelateObjectATitle() {
		if(relateObjectATitle != null) {
            return relateObjectATitle.trim();
        }
        return EditString.replaceChangeLine(relateObjectATitle);
	}

	/**
	 * @param relateObjectBTitle the relateObjectBTitle to set
	 */
	public void setRelateObjectBTitle(String relateObjectBTitle) {
		this.relateObjectBTitle = relateObjectBTitle;
	}

	/**
	 * @return the relateObjectBTitle
	 */
	public String getRelateObjectBTitle() {
		if(relateObjectBTitle != null) {
            return relateObjectBTitle.trim();
        }
        return EditString.replaceChangeLine(relateObjectBTitle);
	}

	/**
	 * @param relateObjectCTitle the relateObjectCTitle to set
	 */
	public void setRelateObjectCTitle(String relateObjectCTitle) {
		this.relateObjectCTitle = relateObjectCTitle;
	}

	/**
	 * @return the relateObjectCTitle
	 */
	public String getRelateObjectCTitle() {
		if(relateObjectCTitle != null) {
            return relateObjectCTitle.trim();
        }
        return EditString.replaceChangeLine(relateObjectCTitle);
	}
	
	/**
	 * @param mortageCancelFunc the mortageCancelFunc to set
	 */
	public void setMortageCancelFunc(Boolean mortageCancelFunc) {
		this.mortageCancelFunc = mortageCancelFunc;
	}

	/**
	 * @return the mortageCancelFunc
	 */
	public Boolean getMortageCancelFunc() {
		return mortageCancelFunc;
	}

	/**
	 * @param periodFlag the periodFlag to set
	 */
	public void setPeriodFlag(Boolean periodFlag) {
		this.periodFlag = periodFlag;
	}

	/**
	 * @return the periodFlag
	 */
	public Boolean getPeriodFlag() {
		return periodFlag;
	}
    /*
     * (non-Javadoc)
     * 
     * @see org.apache.struts.action.ActionForm#validate(org.apache.struts.action.ActionMapping,
     *      javax.servlet.http.HttpServletRequest)
     */
    @Override
    public ActionErrors validate(ActionMapping mapping,
            HttpServletRequest request) {
        
        ContractTemplateEditViewHelper view = (ContractTemplateEditViewHelper)
            request.getSession().getAttribute(ContractTemplateEditViewHelper.SESSION_KEY);
        if (view == null) {
            return new ActionErrors();
        }
        ActionErrors errors = super.validate(mapping, request);
        MessageUtil messageUtil = new MessageUtil();
        if(getFormFile() != null) {
            if(getFormFile().getFileName() != null && getFormFile().getFileName().length()>100) {
                errors.add(messageUtil.createActionMessages("formFile", request, "err_max_length", "item_file_name", "100"));
            }
        }
        if (errors.size() > 0) {
            view.reset(this);
        }
        
        return errors;
    }
}
