package com.osp.npo.app.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;
import org.apache.struts.validator.ValidatorForm;

import com.osp.npo.app.message.MessageUtil;
import com.osp.npo.app.viewhelper.ContractTemplateRegistViewHelper;

/**
 * <P>Contract List Form</P>
 * 
 * @author KienLT
 * @version $Revision$
 */
public class ContractTemplateRegistForm extends ValidatorForm {
    
    private String contractTemplateName;
    private Long contractKindId;
    private String contractTemplateDescription;
    private FormFile formFile;
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
     * Get the contractTemplateDescription
     *
     * @return the contractTemplateDescription
     */
    public String getContractTemplateDescription() {
        if(contractTemplateDescription != null) {
            return contractTemplateDescription.trim();
        }
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
     * Get the contractTemplateName
     *
     * @return the contractTemplateName
     */
    public String getContractTemplateName() {
        if(contractTemplateName != null) {
            return contractTemplateName.trim();
        }
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
        return relateObjectATitle;
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
        return relateObjectBTitle;
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
        return relateObjectCTitle;
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

    /**
     * 
     */
    private static final long serialVersionUID = 99351699825278177L;

    /*
     * (non-Javadoc)
     * 
     * @see org.apache.struts.action.ActionForm#validate(org.apache.struts.action.ActionMapping,
     *      javax.servlet.http.HttpServletRequest)
     */
    @Override
    public ActionErrors validate(ActionMapping mapping,
            HttpServletRequest request) {
        
        ContractTemplateRegistViewHelper view = (ContractTemplateRegistViewHelper)
            request.getSession().getAttribute(ContractTemplateRegistViewHelper.SESSION_KEY);
        if (view == null) {
            return new ActionErrors();
        }
        
        ActionErrors errors = super.validate(mapping, request);
        MessageUtil messageUtil = new MessageUtil();
//        if((getContractTemplateName()==null) || ("".equals(getContractTemplateName().trim()))) {
//            errors.add(messageUtil.createActionMessages("contractTemplateName", request, "err_not_input_data", "item_contract_template_name"));
//        }
        if(getContractKindId()==null || getContractKindId()<=0) {
            errors.add(messageUtil.createActionMessages("contractKind", request, "err_not_input_data", "item_contract_kind"));
        }
//        if(getFormFile().getFileName()==null || "".equals(getFormFile().getFileName().trim())) {
//            errors.add(messageUtil.createActionMessages("", request, "err_not_input_data", "item_file_attach"));
//        }
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
