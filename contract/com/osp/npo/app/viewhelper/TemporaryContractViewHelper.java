package com.osp.npo.app.viewhelper;

import java.util.List;

import com.osp.npo.app.form.TemporaryContractForm;
import com.osp.npo.common.util.EditString;
import com.osp.npo.core.temporaryContract.ContractCommentInfo;

/**
 * <P>Temporary Contract View Helper</P>
 * 
 * @author SonHD 
 * @version $Revision: 26067 $
 */
public class TemporaryContractViewHelper extends ContractViewHelper {
    
    public static final String SESSION_KEY = "temporaryContractViewHelper";

    private String contractComment;
    private String propertyType;
    private String notaryName;
    private String drafterName;
    private Boolean isExist = Boolean.FALSE;
    
    private Long tcid;
    
    private List<ContractCommentInfo> contractCommentList;
    
   
    /**
	 * Get tcid
	 * @return the tcid
	 */
	public Long getTcid() {
		return tcid;
	}

	/**
	 * Set tcid
	 * @param tcid the tcid to set
	 */
	public void setTcid(Long tcid) {
		this.tcid = tcid;
	}

	/**
	 * Get notaryName
	 * @return the notaryName
	 */
	public String getNotaryName() {
		return notaryName;
	}

	/**
	 * Set notaryName
	 * @param notaryName the notaryName to set
	 */
	public void setNotaryName(String notaryName) {
		this.notaryName = notaryName;
	}

	/**
	 * Get drafterName
	 * @return the drafterName
	 */
	public String getDrafterName() {
		return drafterName;
	}

	/**
	 * Set drafterName
	 * @param drafterName the drafterName to set
	 */
	public void setDrafterName(String drafterName) {
		this.drafterName = drafterName;
	}

	/**
	 * Get propertyType
	 * @return the propertyType
	 */
	public String getPropertyType() {
		return propertyType;
	}

	/**
	 * Set propertyType
	 * @param propertyType the propertyType to set
	 */
	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}

	/**
	 * Get contractComment
	 * @return the contractComment
	 */
	public String getContractComment() {
		return contractComment;
	}

	/**
	 * Set contractComment
	 * @param contractComment the contractComment to set
	 */
	public void setContractComment(String contractComment) {
		this.contractComment = contractComment;
	}

	/**
     * Get the contractList
     *
     * @return the contractList
     */
    public List<ContractCommentInfo> getContractCommentList() {
        return contractCommentList;
    }

    /**
     * Set the contractList
     *
     * @param contractList the contractList to set
     */
    public void setContractCommentList(List<ContractCommentInfo> contractCommentList) {
        this.contractCommentList = contractCommentList;
    }
    
    /**
     * Get propertyInfoDisp
     * @return
     */
    public String getPropertyInfoDisp() {
    	return EditString.replaceChangeLine(getPropertyInfo());
    }
    
    /**
     * Get RelationObjectADisp
     * @return
     */
    public String getRelationObjectADisp() {
    	return EditString.replaceChangeLine(getRelationObjectA());
    }
    
    /**
     * Get RelationObjectBDisp
     * @return
     */
    public String getRelationObjectBDisp() {
    	return EditString.replaceChangeLine(getRelationObjectB());
    }
    
    /**
     * Get RelationObjectCDisp
     * @return
     */
    public String getRelationObjectCDisp() {
    	return EditString.replaceChangeLine(getRelationObjectC());
    }

    /**
     * Get ContractSummaryDisp
     * @return
     */
    public String getContractSummaryDisp() {
    	return EditString.replaceChangeLine(getContractSummary());
    }
    
    /**
     * Get contractNoteDisp
     * @return
     */
    public String getContractNoteDisp() {
    	return EditString.replaceChangeLine(getContractNote());
    }
    
    
    /**
	 * @return the isExist
	 */
	public Boolean getIsExist() {
		return isExist;
	}

	/**
	 * @param isExist the isExist to set
	 */
	public void setIsExist(Boolean isExist) {
		this.isExist = isExist;
	}

	public void reset(TemporaryContractForm form) {
    	
    	setBankId(form.getBankId());
        setBankServiceFee(form.getBankServiceFee());
        setContractNumber(form.getContractNumber());
        setContractTemplateId(form.getContractTemplateId());
        setContractTemplateName(form.getContractTemplateName());
        setContractValue(form.getContractValue());
        setCostDraft(form.getCostDraft());
        setCostNotaryOutsite(form.getCostNotaryOutsite());
        setCostOtherDetermine(form.getCostOtherDetermine());
        setCostTotal(form.getCostTotal());
        setCostTt91(form.getCostTt91());
        setCrediterName(form.getCrediterName());
        setDrafterId(form.getDrafterId());
        
        setFormFile(form.getFormFile());
        setNotaryDate(form.getNotaryDate());
        setNotaryId(form.getNotaryId());
        setNotaryPlace(form.getNotaryPlace());
        setNotaryPlaceFlag(form.getNotaryPlaceFlag());
        setContractSummary(form.getContractSummary());
        setOriginalStorePlace(form.getOriginalStorePlace());
        setReceivedDate(form.getReceivedDate());
        setBankName(form.getBankName());
        setNotaryFamilyName(form.getNotaryFamilyName());
        setNotaryFirstName(form.getNotaryFirstName());
        setDrafterFamilyName(form.getDrafterFamilyName());
        setDrafterFirstName(form.getDrafterFirstName());
        
        setContractNote(form.getContractNote());
        setContractKindName(form.getContractKindName());
        setUserRequireContract(form.getUserRequireContract());
        setNumberCopyOfContract(form.getNumberCopyOfContract());
        setNumberOfPage(form.getNumberOfPage());

        setPropertyType(form.getPropertyType());
        setPropertyInfo(form.getPropertyInfo());
        setOtherInfo(form.getOwnerInfo());
        setOtherInfo(form.getOtherInfo());
        setLandCertificate(form.getLandCertificate());
        setLandIssuePlace(form.getLandIssuePlace());
        setLandIssueDate(form.getLandIssueDate());
        setLandMapNumber(form.getLandMapNumber());
        setLandNumber(form.getLandNumber());
        setLandAddress(form.getLandAddress());
        setLandArea(form.getLandArea());
        setLandPublicArea(form.getLandPublicArea());
        setLandPrivateArea(form.getLandPrivateArea());
        setLandUsePurpose(form.getLandUsePurpose());
        setLandUsePeriod(form.getLandUsePeriod());
        setLandUseOrigin(form.getLandUseOrigin());
        setLandAssociateProperty(form.getLandAssociateProperty());
        setCarLicenseNumber(form.getCarLicenseNumber());
        setCarRegistNumber(form.getCarRegistNumber());
        setCarIssuePlace(form.getCarIssuePlace());
        setCarIssueDate(form.getCarIssueDate());
        setCarFrameNumber(form.getCarFrameNumber());
        setCarMachineNumber(form.getCarMachineNumber());

        
        setContractKindId(form.getContractKindId());
        setRelationObjectA(form.getRelationObjectA());
        setRelationObjectB(form.getRelationObjectB());
        setRelationObjectC(form.getRelationObjectC());
        setIsExist(Boolean.FALSE);
    }    
}
