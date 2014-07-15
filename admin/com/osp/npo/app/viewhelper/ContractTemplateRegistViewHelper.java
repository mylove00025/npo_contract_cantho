package com.osp.npo.app.viewhelper;

import java.util.List;

import org.apache.struts.upload.FormFile;

import com.osp.npo.app.form.ContractTemplateRegistForm;
import com.osp.npo.core.contract.ContractKindTreeNode;


/**
 * Contract View Helper
 * 
 * @author KienLT
 * @version $Revision: 26924 $
 */
public class ContractTemplateRegistViewHelper extends AbstractPageListViewHelper {
    
    public static final String SESSION_KEY = "contractTemplateRegistViewHelper";
    
    private String contractTemplateName;
    private String contractTemplateDescription;
    private FormFile formFile;   
    private Long contractKindId;
    private List<ContractKindTreeNode> contractKindTreeNodeList;
    private String contractTemplateCode;
    private int relateObjectNumber;
    private String relateObjectATitle;
    private String relateObjectBTitle;
    private String relateObjectCTitle;
    private Boolean mortageCancelFunc;
    private Boolean periodFlag;
    
       
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

	public void reset(ContractTemplateRegistForm f) {     
        contractTemplateName = f.getContractTemplateName();
        contractTemplateDescription = f.getContractTemplateDescription();
        contractKindId = f.getContractKindId();
        formFile = f.getFormFile(); 
        contractTemplateCode = f.getContractTemplateCode();
        relateObjectNumber = f.getRelateObjectNumber();        
    }
}