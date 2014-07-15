package com.osp.npo.app.viewhelper;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import org.apache.struts.upload.FormFile;

import com.osp.npo.app.form.ContractForm;
import com.osp.npo.core.basicData.BankInfo;
import com.osp.npo.core.basicData.DistrictInfo;
import com.osp.npo.core.basicData.ProvinceInfo;
import com.osp.npo.core.contract.ContractKindInfo;
import com.osp.npo.core.contract.ContractKindTreeNode;
import com.osp.npo.core.contract.ContractTemplateInfo;
import com.osp.npo.core.contract.PropertyInfo;
import com.osp.npo.core.user.UserInfo;

/**
 * <P>Contract View Helper</P>
 *
 * @author HungPT
 * @version $Revision$
 */
public class ContractViewHelper {

    public static final String SESSION_KEY = "contractViewHelper";

    private Long contractId;

    private Long contractKindId;

    private String contractKindName;
    
    private String contractTemplateCode;
    
    private int relateObjectNumber;

    private String contractNumber;
    
    private String contractNumber2;

    private Long contractTemplateId;

    private String contractTemplateName;

    private String relationObject;
    
    private String relationObjectA;

    private String relationObjectB;

    private String relationObjectC;

    private String contractValue;

    private Long notaryId;

    private Long drafterId;

    private String receivedDate;

    private String notaryDate;

    private String notaryPlace;

    private Boolean notaryPlaceFlag;

    private String contractSummary;

    private String costTt91;

    private String costDraft;

    private String costNotaryOutsite;

    private String costOtherDetermine;

    private String costTotal;

    private Long bankId;

    private String crediterName;

    private String bankServiceFee;

    private String fileName;
    
    private String fileNameDisp;

    private String filePath;

    private FormFile formFile;

    private String originalStorePlace;

    private Boolean errorStatus;

    private String errorDescription;

    private String errorAgent;

    private Boolean additionStatus;

    private String additionDescription;

    private Boolean cancellationStatus;

    private String cancellationDescription;

    private Long cancellationRelationContractId;

    private List<ContractTemplateInfo> contractTemplateList;

    private List<UserInfo> notaryList;

    private List<UserInfo> drafterList;

    private List<BankInfo> bankList;

    private String bankName;

    private List<PropertyInfo> propertyList;

    private List<PropertyInfo> propertyTypeList;

    private List<ProvinceInfo> provinceList;

    private List<DistrictInfo> districtList;

    private List<ContractKindInfo> contractKindList;

    private List<ContractKindTreeNode> contractKindTree;

    private String notaryFamilyName;

    private String notaryFirstName;

    private String drafterFamilyName;

    private String drafterFirstName;

    private String errorUserFamilyName;

    private String errorUserFirstName;

    private String userRequireContract;

    private String numberCopyOfContract;

    private String numberOfPage;
    
    private String contractNote;
    
    private Long cancellationContractId;
    
    private Long appendixId;

    //Property
    private Long propertyId;
    
    private String type;

    private String propertyInfo;

    private String ownerInfo;

    private String otherInfo;

    private String landCertificate;

    private String landIssuePlace;

    private String landIssueDate;

    private String landMapNumber;

    private String landNumber;

    private String landAddress;

    private String landArea;

    private String landPublicArea;

    private String landPrivateArea;

    private String landUsePurpose;

    private String landUsePeriod;

    private String landUseOrigin;
    
    private String landDistrict;
    
    private String landDistrictName;
    
    private String landStreet;

    private Long landProvince;
    
    private String landAssociateProperty;

    private String carLicenseNumber;

    private String carRegistNumber;

    private String carIssuePlace;

    private String carIssueDate;

    private String carFrameNumber;

    private String carMachineNumber;
    //End Property

    //Many Property
    private String titlePopup;

    private String propertyTypePopup;

    private String propertyCodeLandPopup;

    private String propertyCodeVehiclePopup;

    private String propertyCodeOtherPopup;

    private Long provinceLandPopup;

    private String provinceLandNamePopup;

    private Long provinceVehiclePopup;

    private String provinceVehicleNamePopup;

    private Long districtPopup;

    private String districtLandNamePopup;

    private String mapNumberPopup;

    private String landNumberPopup;

    private String landAddressPopup;

    private String frameNumberPopup;

    private String machineNumberPopup;

    private String ownerNamePopup;

    private String ownerIdCardPopup;

    private String ownerAddressPopup;

    private String propertyOtherInfoPopup;

    private String givenDateVehiclePopup;

    private String givenDateLandPopup;
    
    private String entryUserName;
    
    private String entryDateTime;
    
    private String updateUserName;
    
    private String updateDateTime;
    
    private String userModify;
    
    private Boolean fromRegistScreen = Boolean.FALSE;

    private Boolean fromContractList = Boolean.TRUE;
    
    private Boolean fromTemporaryContract = Boolean.FALSE;

    private Boolean fileExisted = Boolean.FALSE;

    private String numberProperty = "1";
    
    private Boolean contractStatus = Boolean.FALSE;
    
    private String contractPeriod;
    
    private Boolean contractPeriodFlag;
    
    private Boolean mortageCancelDisplayFlag;
    
    private Boolean mortageCancelFlag;
    
    private String mortageCancelDate;
    
    private String mortageCancelNote;
    
    private String relateObjectATitle;
    
    private String relateObjectBTitle;
    
    private String relateObjectCTitle;
    
    //Kieu nhap tai san, TRUE: nhap chi tiet, FALSE: Nhap don gian
    private Boolean isDetailPropertyEntry = Boolean.FALSE;

    /**
     * Get the contractId
     *
     * @return the contractId
     */
    public Long getContractId() {
        return contractId;
    }

    /**
     * Set the contractId
     *
     * @param contractId the contractId to set
     */
    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }

    /**
     * Get the contractKindName
     *
     * @return the contractKindName
     */
    public String getContractKindName() {
        return contractKindName;
    }

    /**
     * Set the contractKindName
     *
     * @param contractKindName the contractKindName to set
     */
    public void setContractKindName(String contractKindName) {
        this.contractKindName = contractKindName;
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
     * Get the contractNumber
     *
     * @return the contractNumber
     */
    public String getContractNumber() {
        return contractNumber;
    }

    /**
     * Set the contractNumber
     *
     * @param contractNumber the contractNumber to set
     */
    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    /**
     * Get the contractTemplateId
     *
     * @return the contractTemplateId
     */
    public Long getContractTemplateId() {
        return contractTemplateId;
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
     * Set the contractTemplateId
     *
     * @param contractTemplateId the contractTemplateId to set
     */
    public void setContractTemplateId(Long contractTemplateId) {
        this.contractTemplateId = contractTemplateId;
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
     * Get the contractValue
     *
     * @return the contractValue
     */
    public String getContractValue() {
        if (contractValue != null) {
            if(contractValue.trim() == "") {
                return "";
            }
            else {
                try {
                    return NumberFormat.getNumberInstance(Locale.GERMANY).format(Long.parseLong(contractValue.trim()));
                } catch (Exception e) {
                    return contractValue.trim();
                }
            }
        }
        return contractValue;
    }

    /**
     * Set the contractValue
     *
     * @param contractValue the contractValue to set
     */
    public void setContractValue(String contractValue) {
        this.contractValue = contractValue;
    }

    /**
     * Get the notaryId
     *
     * @return the notaryId
     */
    public Long getNotaryId() {
        return notaryId;
    }

    /**
     * Set the notaryId
     *
     * @param notaryId the notaryId to set
     */
    public void setNotaryId(Long notaryId) {
        this.notaryId = notaryId;
    }

    /**
     * Get the drafterId
     *
     * @return the drafterId
     */
    public Long getDrafterId() {
        return drafterId;
    }

    /**
     * Set the drafterId
     *
     * @param drafterId the drafterId to set
     */
    public void setDrafterId(Long drafterId) {
        this.drafterId = drafterId;
    }

    /**
     * Get the receivedDate
     *
     * @return the receivedDate
     */
    public String getReceivedDate() {
        return receivedDate;
    }

    /**
     * Set the receivedDate
     *
     * @param receivedDate the receivedDate to set
     */
    public void setReceivedDate(String receivedDate) {
        this.receivedDate = receivedDate;
    }

    /**
     * Get the notaryDate
     *
     * @return the notaryDate
     */
    public String getNotaryDate() {
        return notaryDate;
    }

    /**
     * Set the notaryDate
     *
     * @param notaryDate the notaryDate to set
     */
    public void setNotaryDate(String notaryDate) {
        this.notaryDate = notaryDate;
    }

    /**
     * Get the notaryPlace
     *
     * @return the notaryPlace
     */
    public String getNotaryPlace() {
        return notaryPlace;
    }

    /**
     * Set the notaryPlace
     *
     * @param notaryPlace the notaryPlace to set
     */
    public void setNotaryPlace(String notaryPlace) {
        this.notaryPlace = notaryPlace;
    }

    /**
     * Get the notaryPlaceFlag
     *
     * @return the notaryPlaceFlag
     */
    public Boolean getNotaryPlaceFlag() {
        return notaryPlaceFlag;
    }

    /**
     * Set the notaryPlaceFlag
     *
     * @param notaryPlaceFlag the notaryPlaceFlag to set
     */
    public void setNotaryPlaceFlag(Boolean notaryPlaceFlag) {
        this.notaryPlaceFlag = notaryPlaceFlag;
    }

    /**
     * Get the costTt91
     *
     * @return the costTt91
     */
    public String getCostTt91() {
        if (costTt91 != null) {
            if(costTt91.trim() == "") {
                return "";
            }
            else {
                try {
                    return NumberFormat.getNumberInstance(Locale.GERMANY).format(Long.parseLong(costTt91.trim()));
                } catch (Exception e) {
                    return costTt91.trim();
                }
            }
        }
        return costTt91;
    }

    /**
     * Set the costTt91
     *
     * @param costTt91 the costTt91 to set
     */
    public void setCostTt91(String costTt91) {
        this.costTt91 = costTt91;
    }

    /**
     * Get the costDraft
     *
     * @return the costDraft
     */
    public String getCostDraft() {
        if (costDraft != null) {
            if(costDraft.trim() == "") {
                return "";
            }
            else {
                try {
                    return NumberFormat.getNumberInstance(Locale.GERMANY).format(Long.parseLong(costDraft.trim()));
                } catch (Exception e) {
                    return costDraft.trim();
                }
            }
        }
        return costDraft;
    }

    /**
     * Set the costDraft
     *
     * @param costDraft the costDraft to set
     */
    public void setCostDraft(String costDraft) {
        this.costDraft = costDraft;
    }

    /**
     * Get the costNotaryOutsite
     *
     * @return the costNotaryOutsite
     */
    public String getCostNotaryOutsite() {
        if (costNotaryOutsite != null) {
            if(costNotaryOutsite.trim() == "") {
                return "";
            }
            else {
                try {
                    return NumberFormat.getNumberInstance(Locale.GERMANY).format(Long.parseLong(costNotaryOutsite.trim()));
                } catch (Exception e) {
                    return costNotaryOutsite.trim();
                }
            }
        }
        return costNotaryOutsite;
    }

    /**
     * Set the costNotaryOutsite
     *
     * @param costNotaryOutsite the costNotaryOutsite to set
     */
    public void setCostNotaryOutsite(String costNotaryOutsite) {
        this.costNotaryOutsite = costNotaryOutsite;
    }

    /**
     * Get the costOtherDetermine
     *
     * @return the costOtherDetermine
     */
    public String getCostOtherDetermine() {
        if (costOtherDetermine != null) {
            if(costOtherDetermine.trim() == "") {
                return "";
            }
            else {
                try {
                    return NumberFormat.getNumberInstance(Locale.GERMANY).format(Long.parseLong(costOtherDetermine.trim()));
                } catch (Exception e) {
                    return costOtherDetermine.trim();
                }
            }
        }
        return costOtherDetermine;
    }

    /**
     * Set the costOtherDetermine
     *
     * @param costOtherDetermine the costOtherDetermine to set
     */
    public void setCostOtherDetermine(String costOtherDetermine) {
        this.costOtherDetermine = costOtherDetermine;
    }

    /**
     * Get the costTotal
     *
     * @return the costTotal
     */
    public String getCostTotal() {
        if (costTotal != null) {
            if(costTotal.trim() == "") {
                return "";
            }
            else {
                try {
                    return NumberFormat.getNumberInstance(Locale.GERMANY).format(Long.parseLong(costTotal.trim()));
                } catch (Exception e) {
                    return costTotal.trim();
                }
            }
        }
        return costTotal;
    }

    /**
     * Set the costTotal
     *
     * @param costTotal the costTotal to set
     */
    public void setCostTotal(String costTotal) {
        this.costTotal = costTotal;
    }

    /**
     * Get the bankId
     *
     * @return the bankId
     */
    public Long getBankId() {
        return bankId;
    }

    /**
     * Set the bankId
     *
     * @param bankId the bankId to set
     */
    public void setBankId(Long bankId) {
        this.bankId = bankId;
    }

    /**
     * Get the crediterName
     *
     * @return the crediterName
     */
    public String getCrediterName() {
        return crediterName;
    }

    /**
     * Set the crediterName
     *
     * @param crediterName the crediterName to set
     */
    public void setCrediterName(String crediterName) {
        this.crediterName = crediterName;
    }

    /**
     * Get the bankServiceFee
     *
     * @return the bankServiceFee
     */
    public String getBankServiceFee() {
        if (bankServiceFee != null) {
            if(bankServiceFee.trim() == "") {
                return "";
            }
            else {
                try {
                    return NumberFormat.getNumberInstance(Locale.GERMANY).format(Long.parseLong(bankServiceFee.trim()));
                } catch (Exception e) {
                    return bankServiceFee.trim();
                }
            }
        }
        return bankServiceFee;
    }

    /**
     * Set the bankServiceFee
     *
     * @param bankServiceFee the bankServiceFee to set
     */
    public void setBankServiceFee(String bankServiceFee) {
        this.bankServiceFee = bankServiceFee;
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
     * Get the filePath
     *
     * @return the filePath
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * Set the filePath
     *
     * @param filePath the filePath to set
     */
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Get the originalStorePlace
     *
     * @return the originalStorePlace
     */
    public String getOriginalStorePlace() {
        return originalStorePlace;
    }

    /**
     * Set the originalStorePlace
     *
     * @param originalStorePlace the originalStorePlace to set
     */
    public void setOriginalStorePlace(String originalStorePlace) {
        this.originalStorePlace = originalStorePlace;
    }

    /**
     * Get the contractTemplateList
     *
     * @return the contractTemplateList
     */
    public List<ContractTemplateInfo> getContractTemplateList() {
        return contractTemplateList;
    }

    /**
     * Set the contractTemplateList
     *
     * @param contractTemplateList the contractTemplateList to set
     */
    public void setContractTemplateList(List<ContractTemplateInfo> contractTemplateList) {
        this.contractTemplateList = contractTemplateList;
    }

    /**
     * Get the notaryList
     *
     * @return the notaryList
     */
    public List<UserInfo> getNotaryList() {
        return notaryList;
    }

    /**
     * Set the notaryList
     *
     * @param notaryList the notaryList to set
     */
    public void setNotaryList(List<UserInfo> notaryList) {
        this.notaryList = notaryList;
    }
    
    /**
     * Get size of notaryList
     *
     * @return size of notaryList
     */
    public int getNotaryListSize() {
    	if (notaryList == null) {
    		return 0;
    	}
        return notaryList.size();
    }

    /**
     * Get the drafterList
     *
     * @return the drafterList
     */
    public List<UserInfo> getDrafterList() {
        return drafterList;
    }

    /**
     * Set the drafterList
     *
     * @param drafterList the drafterList to set
     */
    public void setDrafterList(List<UserInfo> drafterList) {
        this.drafterList = drafterList;
    }

    /**
     * Get the bankList
     *
     * @return the bankList
     */
    public List<BankInfo> getBankList() {
        return bankList;
    }

    /**
     * Set the bankList
     *
     * @param bankList the bankList to set
     */
    public void setBankList(List<BankInfo> bankList) {
        this.bankList = bankList;
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
     * Get the errorStatus
     *
     * @return the errorStatus
     */
    public Boolean getErrorStatus() {
        return errorStatus;
    }

    /**
     * Set the errorStatus
     *
     * @param errorStatus the errorStatus to set
     */
    public void setErrorStatus(Boolean errorStatus) {
        this.errorStatus = errorStatus;
    }

    /**
     * Get the errorDescription
     *
     * @return the errorDescription
     */
    public String getErrorDescription() {
        return errorDescription;
    }

    /**
     * Get the errorUserFamilyName
     *
     * @return the errorUserFamilyName
     */
    public String getErrorUserFamilyName() {
        return errorUserFamilyName;
    }

    /**
     * Set the errorUserFamilyName
     *
     * @param errorUserFamilyName the errorUserFamilyName to set
     */
    public void setErrorUserFamilyName(String errorUserFamilyName) {
        this.errorUserFamilyName = errorUserFamilyName;
    }

    /**
     * Get the errorUserFirstName
     *
     * @return the errorUserFirstName
     */
    public String getErrorUserFirstName() {
        return errorUserFirstName;
    }

    /**
     * Set the errorUserFirstName
     *
     * @param errorUserFirstName the errorUserFirstName to set
     */
    public void setErrorUserFirstName(String errorUserFirstName) {
        this.errorUserFirstName = errorUserFirstName;
    }

    /**
     * Set the errorDescription
     *
     * @param errorDescription the errorDescription to set
     */
    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }

    /**
     * Get the errorAgent
     *
     * @return the errorAgent
     */
    public String getErrorAgent() {
        return errorAgent;
    }

    /**
     * Set the errorAgent
     *
     * @param errorAgent the errorAgent to set
     */
    public void setErrorAgent(String errorAgent) {
        this.errorAgent = errorAgent;
    }

    /**
     * Get the bankName
     *
     * @return the bankName
     */
    public String getBankName() {
        return bankName;
    }

    /**
     * Set the bankName
     *
     * @param bankName the bankName to set
     */
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    /**
     * Get the propertyList
     *
     * @return the propertyList
     */
    public List<PropertyInfo> getPropertyList() {
        return propertyList;
    }

    /**
     * Set the propertyList
     *
     * @param propertyList the propertyList to set
     */
    public void setPropertyList(List<PropertyInfo> propertyList) {
        this.propertyList = propertyList;
    }

    /**
     * Get the propertyTypeList
     *
     * @return the propertyTypeList
     */
    public List<PropertyInfo> getPropertyTypeList() {
        return propertyTypeList;
    }

    /**
     * Set the propertyTypeList
     *
     * @param propertyTypeList the propertyTypeList to set
     */
    public void setPropertyTypeList(List<PropertyInfo> propertyTypeList) {
        this.propertyTypeList = propertyTypeList;
    }

    /**
     * Get the provinceList
     *
     * @return the provinceList
     */
    public List<ProvinceInfo> getProvinceList() {
        return provinceList;
    }

    /**
     * Set the provinceList
     *
     * @param provinceList the provinceList to set
     */
    public void setProvinceList(List<ProvinceInfo> provinceList) {
        this.provinceList = provinceList;
    }

    /**
     * Get the districtList
     *
     * @return the districtList
     */
    public List<DistrictInfo> getDistrictList() {
        return districtList;
    }

    /**
     * Set the districtList
     *
     * @param districtList the districtList to set
     */
    public void setDistrictList(List<DistrictInfo> districtList) {
        this.districtList = districtList;
    }

    /**
     * Get the propertyId
     *
     * @return the propertyId
     */
    public Long getPropertyId() {
        return propertyId;
    }

    /**
     * Set the propertyId
     *
     * @param propertyId the propertyId to set
     */
    public void setPropertyId(Long propertyId) {
        this.propertyId = propertyId;
    }

    /**
     * Get the notaryFamilyName
     *
     * @return the notaryFamilyName
     */
    public String getNotaryFamilyName() {
        return notaryFamilyName;
    }

    /**
     * Set the notaryFamilyName
     *
     * @param notaryFamilyName the notaryFamilyName to set
     */
    public void setNotaryFamilyName(String notaryFamilyName) {
        this.notaryFamilyName = notaryFamilyName;
    }

    /**
     * Get the notaryFirstName
     *
     * @return the notaryFirstName
     */
    public String getNotaryFirstName() {
        return notaryFirstName;
    }

    /**
     * Set the notaryFirstName
     *
     * @param notaryFirstName the notaryFirstName to set
     */
    public void setNotaryFirstName(String notaryFirstName) {
        this.notaryFirstName = notaryFirstName;
    }

    /**
     * Get the drafterFamilyName
     *
     * @return the drafterFamilyName
     */
    public String getDrafterFamilyName() {
        return drafterFamilyName;
    }

    /**
     * Set the drafterFamilyName
     *
     * @param drafterFamilyName the drafterFamilyName to set
     */
    public void setDrafterFamilyName(String drafterFamilyName) {
        this.drafterFamilyName = drafterFamilyName;
    }

    /**
     * Get the drafterFirstName
     *
     * @return the drafterFirstName
     */
    public String getDrafterFirstName() {
        return drafterFirstName;
    }

    /**
     * Get the contractNote
     *
     * @return the contractNote
     */
    public String getContractNote() {
        if (contractNote != null) {
            return contractNote.trim();
        }
        return contractNote;
    }

    /**
     * Set the contractNote
     *
     * @param contractNote the contractNote to set
     */
    public void setContractNote(String contractNote) {
        this.contractNote = contractNote;
    }

    /**
     * Set the drafterFirstName
     *
     * @param drafterFirstName the drafterFirstName to set
     */
    public void setDrafterFirstName(String drafterFirstName) {
        this.drafterFirstName = drafterFirstName;
    }

    /**
     * Get the fromRegistScreen
     *
     * @return the fromRegistScreen
     */
    public Boolean getFromRegistScreen() {
        return fromRegistScreen;
    }

    /**
     * Set the fromRegistScreen
     *
     * @param fromRegistScreen the fromRegistScreen to set
     */
    public void setFromRegistScreen(Boolean fromRegistScreen) {
        this.fromRegistScreen = fromRegistScreen;
    }

    /**
     * Get the titlePopup
     *
     * @return the titlePopup
     */
    public String getTitlePopup() {
        return titlePopup;
    }

    /**
     * Set the titlePopup
     *
     * @param titlePopup the titlePopup to set
     */
    public void setTitlePopup(String titlePopup) {
        this.titlePopup = titlePopup;
    }

    /**
     * Get the propertyTypePopup
     *
     * @return the propertyTypePopup
     */
    public String getPropertyTypePopup() {
        return propertyTypePopup;
    }

    /**
     * Set the propertyTypePopup
     *
     * @param propertyTypePopup the propertyTypePopup to set
     */
    public void setPropertyTypePopup(String propertyTypePopup) {
        this.propertyTypePopup = propertyTypePopup;
    }

    /**
     * Get the propertyCodeLandPopup
     *
     * @return the propertyCodeLandPopup
     */
    public String getPropertyCodeLandPopup() {
        return propertyCodeLandPopup;
    }

    /**
     * Set the propertyCodeLandPopup
     *
     * @param propertyCodeLandPopup the propertyCodeLandPopup to set
     */
    public void setPropertyCodeLandPopup(String propertyCodeLandPopup) {
        this.propertyCodeLandPopup = propertyCodeLandPopup;
    }

    /**
     * Get the propertyCodeVehiclePopup
     *
     * @return the propertyCodeVehiclePopup
     */
    public String getPropertyCodeVehiclePopup() {
        return propertyCodeVehiclePopup;
    }

    /**
     * Set the propertyCodeVehiclePopup
     *
     * @param propertyCodeVehiclePopup the propertyCodeVehiclePopup to set
     */
    public void setPropertyCodeVehiclePopup(String propertyCodeVehiclePopup) {
        this.propertyCodeVehiclePopup = propertyCodeVehiclePopup;
    }

    /**
     * Get the propertyCodeOtherPopup
     *
     * @return the propertyCodeOtherPopup
     */
    public String getPropertyCodeOtherPopup() {
        return propertyCodeOtherPopup;
    }

    /**
     * Set the propertyCodeOtherPopup
     *
     * @param propertyCodeOtherPopup the propertyCodeOtherPopup to set
     */
    public void setPropertyCodeOtherPopup(String propertyCodeOtherPopup) {
        this.propertyCodeOtherPopup = propertyCodeOtherPopup;
    }

    /**
     * Get the provinceLandPopup
     *
     * @return the provinceLandPopup
     */
    public Long getProvinceLandPopup() {
        return provinceLandPopup;
    }

    /**
     * Set the provinceLandPopup
     *
     * @param provinceLandPopup the provinceLandPopup to set
     */
    public void setProvinceLandPopup(Long provinceLandPopup) {
        this.provinceLandPopup = provinceLandPopup;
    }

    /**
     * Get the provinceVehiclePopup
     *
     * @return the provinceVehiclePopup
     */
    public Long getProvinceVehiclePopup() {
        return provinceVehiclePopup;
    }

    /**
     * Set the provinceVehiclePopup
     *
     * @param provinceVehiclePopup the provinceVehiclePopup to set
     */
    public void setProvinceVehiclePopup(Long provinceVehiclePopup) {
        this.provinceVehiclePopup = provinceVehiclePopup;
    }

    /**
     * Get the districtPopup
     *
     * @return the districtPopup
     */
    public Long getDistrictPopup() {
        return districtPopup;
    }

    /**
     * Set the districtPopup
     *
     * @param districtPopup the districtPopup to set
     */
    public void setDistrictPopup(Long districtPopup) {
        this.districtPopup = districtPopup;
    }

    /**
     * Get the mapNumberPopup
     *
     * @return the mapNumberPopup
     */
    public String getMapNumberPopup() {
        return mapNumberPopup;
    }

    /**
     * Set the mapNumberPopup
     *
     * @param mapNumberPopup the mapNumberPopup to set
     */
    public void setMapNumberPopup(String mapNumberPopup) {
        this.mapNumberPopup = mapNumberPopup;
    }

    /**
     * Get the landNumberPopup
     *
     * @return the landNumberPopup
     */
    public String getLandNumberPopup() {
        return landNumberPopup;
    }

    /**
     * Set the landNumberPopup
     *
     * @param landNumberPopup the landNumberPopup to set
     */
    public void setLandNumberPopup(String landNumberPopup) {
        this.landNumberPopup = landNumberPopup;
    }

    /**
     * Get the landAddressPopup
     *
     * @return the landAddressPopup
     */
    public String getLandAddressPopup() {
        return landAddressPopup;
    }

    /**
     * Set the landAddressPopup
     *
     * @param landAddressPopup the landAddressPopup to set
     */
    public void setLandAddressPopup(String landAddressPopup) {
        this.landAddressPopup = landAddressPopup;
    }

    /**
     * Get the frameNumberPopup
     *
     * @return the frameNumberPopup
     */
    public String getFrameNumberPopup() {
        return frameNumberPopup;
    }

    /**
     * Set the frameNumberPopup
     *
     * @param frameNumberPopup the frameNumberPopup to set
     */
    public void setFrameNumberPopup(String frameNumberPopup) {
        this.frameNumberPopup = frameNumberPopup;
    }

    /**
     * Get the machineNumberPopup
     *
     * @return the machineNumberPopup
     */
    public String getMachineNumberPopup() {
        return machineNumberPopup;
    }

    /**
     * Set the machineNumberPopup
     *
     * @param machineNumberPopup the machineNumberPopup to set
     */
    public void setMachineNumberPopup(String machineNumberPopup) {
        this.machineNumberPopup = machineNumberPopup;
    }

    /**
     * Get the ownerNamePopup
     *
     * @return the ownerNamePopup
     */
    public String getOwnerNamePopup() {
        return ownerNamePopup;
    }

    /**
     * Set the ownerNamePopup
     *
     * @param ownerNamePopup the ownerNamePopup to set
     */
    public void setOwnerNamePopup(String ownerNamePopup) {
        this.ownerNamePopup = ownerNamePopup;
    }

    /**
     * Get the ownerIdCardPopup
     *
     * @return the ownerIdCardPopup
     */
    public String getOwnerIdCardPopup() {
        return ownerIdCardPopup;
    }

    /**
     * Set the ownerIdCardPopup
     *
     * @param ownerIdCardPopup the ownerIdCardPopup to set
     */
    public void setOwnerIdCardPopup(String ownerIdCardPopup) {
        this.ownerIdCardPopup = ownerIdCardPopup;
    }

    /**
     * Get the propertyOtherInfoPopup
     *
     * @return the propertyOtherInfoPopup
     */
    public String getPropertyOtherInfoPopup() {
        return propertyOtherInfoPopup;
    }

    /**
     * Set the propertyOtherInfoPopup
     *
     * @param propertyOtherInfoPopup the propertyOtherInfoPopup to set
     */
    public void setPropertyOtherInfoPopup(String propertyOtherInfoPopup) {
        this.propertyOtherInfoPopup = propertyOtherInfoPopup;
    }

    /**
     * Get the givenDateVehiclePopup
     *
     * @return the givenDateVehiclePopup
     */
    public String getGivenDateVehiclePopup() {
        return givenDateVehiclePopup;
    }

    /**
     * Set the givenDateVehiclePopup
     *
     * @param givenDateVehiclePopup the givenDateVehiclePopup to set
     */
    public void setGivenDateVehiclePopup(String givenDateVehiclePopup) {
        this.givenDateVehiclePopup = givenDateVehiclePopup;
    }

    /**
     * Get the givenDateLandPopup
     *
     * @return the givenDateLandPopup
     */
    public String getGivenDateLandPopup() {
        return givenDateLandPopup;
    }

    /**
     * Set the givenDateLandPopup
     *
     * @param givenDateLandPopup the givenDateLandPopup to set
     */
    public void setGivenDateLandPopup(String givenDateLandPopup) {
        this.givenDateLandPopup = givenDateLandPopup;
    }


    /**
     * Get the fromContractList
     *
     * @return the fromContractList
     */
    public Boolean getFromContractList() {
        return fromContractList;
    }

    /**
     * Set the fromContractList
     *
     * @param fromContractList the fromContractList to set
     */
    public void setFromContractList(Boolean fromContractList) {
        this.fromContractList = fromContractList;
    }

    /**
     * Get the contractSummary
     *
     * @return the contractSummary
     */
    public String getContractSummary() {
        return contractSummary;
    }

    /**
     * Set the contractSummary
     *
     * @param contractSummary the contractSummary to set
     */
    public void setContractSummary(String contractSummary) {
        this.contractSummary = contractSummary;
    }

    /**
     * Get the contractKindList
     *
     * @return the contractKindList
     */
    public List<ContractKindInfo> getContractKindList() {
        return contractKindList;
    }

    /**
     * Set the contractKindList
     *
     * @param contractKindList the contractKindList to set
     */
    public void setContractKindList(List<ContractKindInfo> contractKindList) {
        this.contractKindList = contractKindList;
    }

    /**
     * Get the contractKindTree
     *
     * @return the contractKindTree
     */
    public List<ContractKindTreeNode> getContractKindTree() {
        return contractKindTree;
    }

    /**
     * Set the contractKindTree
     *
     * @param contractKindTree the contractKindTree to set
     */
    public void setContractKindTree(List<ContractKindTreeNode> contractKindTree) {
        this.contractKindTree = contractKindTree;
    }

    /**
     * Get the provinceLandNamePopup
     *
     * @return the provinceLandNamePopup
     */
    public String getProvinceLandNamePopup() {
        return provinceLandNamePopup;
    }

    /**
     * Set the provinceLandNamePopup
     *
     * @param provinceLandNamePopup the provinceLandNamePopup to set
     */
    public void setProvinceLandNamePopup(String provinceLandNamePopup) {
        this.provinceLandNamePopup = provinceLandNamePopup;
    }

    /**
     * Get the provinceVehicleNamePopup
     *
     * @return the provinceVehicleNamePopup
     */
    public String getProvinceVehicleNamePopup() {
        return provinceVehicleNamePopup;
    }

    /**
     * Set the provinceVehicleNamePopup
     *
     * @param provinceVehicleNamePopup the provinceVehicleNamePopup to set
     */
    public void setProvinceVehicleNamePopup(String provinceVehicleNamePopup) {
        this.provinceVehicleNamePopup = provinceVehicleNamePopup;
    }

    /**
     * Get the districtLandNamePopup
     *
     * @return the districtLandNamePopup
     */
    public String getDistrictLandNamePopup() {
        return districtLandNamePopup;
    }

    /**
     * Set the districtLandNamePopup
     *
     * @param districtLandNamePopup the districtLandNamePopup to set
     */
    public void setDistrictLandNamePopup(String districtLandNamePopup) {
        this.districtLandNamePopup = districtLandNamePopup;
    }

    /**
     * Get the fileExisted
     *
     * @return the fileExisted
     */
    public Boolean getFileExisted() {
        return fileExisted;
    }

    /**
     * Set the fileExisted
     *
     * @param fileExisted the fileExisted to set
     */
    public void setFileExisted(Boolean fileExisted) {
        this.fileExisted = fileExisted;
    }

    /**
     * Get the numberProperty
     *
     * @return the numberProperty
     */
    public String getNumberProperty() {
        return numberProperty;
    }

    /**
     * Set the numberProperty
     *
     * @param numberProperty the numberProperty to set
     */
    public void setNumberProperty(String numberProperty) {
        this.numberProperty = numberProperty;
    }

    /**
     * Get the ownerAddressPopup
     *
     * @return the ownerAddressPopup
     */
    public String getOwnerAddressPopup() {
        return ownerAddressPopup;
    }

    /**
     * Set the ownerAddressPopup
     *
     * @param ownerAddressPopup the ownerAddressPopup to set
     */
    public void setOwnerAddressPopup(String ownerAddressPopup) {
        this.ownerAddressPopup = ownerAddressPopup;
    }

    /**
     * Get the userRequireContract
     *
     * @return the userRequireContract
     */
    public String getUserRequireContract() {
        return userRequireContract;
    }

    /**
     * Set the userRequireContract
     *
     * @param userRequireContract the userRequireContract to set
     */
    public void setUserRequireContract(String userRequireContract) {
        this.userRequireContract = userRequireContract;
    }

    /**
     * Get the numberCopyOfContract
     *
     * @return the numberCopyOfContract
     */
    public String getNumberCopyOfContract() {
        return numberCopyOfContract;
    }

    /**
     * Set the numberCopyOfContract
     *
     * @param numberCopyOfContract the numberCopyOfContract to set
     */
    public void setNumberCopyOfContract(String numberCopyOfContract) {
        this.numberCopyOfContract = numberCopyOfContract;
    }

    /**
     * Get the numberOfPage
     *
     * @return the numberOfPage
     */
    public String getNumberOfPage() {
        return numberOfPage;
    }

    /**
     * Set the numberOfPage
     *
     * @param numberOfPage the numberOfPage to set
     */
    public void setNumberOfPage(String numberOfPage) {
        this.numberOfPage = numberOfPage;
    }

    /**
     * Get the additionStatus
     *
     * @return the additionStatus
     */
    public Boolean getAdditionStatus() {
        return additionStatus;
    }

    /**
     * Set the additionStatus
     *
     * @param additionStatus the additionStatus to set
     */
    public void setAdditionStatus(Boolean additionStatus) {
        this.additionStatus = additionStatus;
    }

    /**
     * Get the additionDescription
     *
     * @return the additionDescription
     */
    public String getAdditionDescription() {
        return additionDescription;
    }

    /**
     * Set the additionDescription
     *
     * @param additionDescription the additionDescription to set
     */
    public void setAdditionDescription(String additionDescription) {
        this.additionDescription = additionDescription;
    }

    /**
     * Get the cancellationStatus
     *
     * @return the cancellationStatus
     */
    public Boolean getCancellationStatus() {
        return cancellationStatus;
    }

    /**
     * Set the cancellationStatus
     *
     * @param cancellationStatus the cancellationStatus to set
     */
    public void setCancellationStatus(Boolean cancellationStatus) {
        this.cancellationStatus = cancellationStatus;
    }

    /**
     * Get the cancellationDescription
     *
     * @return the cancellationDescription
     */
    public String getCancellationDescription() {
        return cancellationDescription;
    }

    /**
     * Set the cancellationDescription
     *
     * @param cancellationDescription the cancellationDescription to set
     */
    public void setCancellationDescription(String cancellationDescription) {
        this.cancellationDescription = cancellationDescription;
    }

    /**
     * Get the cancellationRelationContractId
     *
     * @return the cancellationRelationContractId
     */
    public Long getCancellationRelationContractId() {
        return cancellationRelationContractId;
    }

    /**
     * Set the cancellationRelationContractId
     *
     * @param cancellationRelationContractId the cancellationRelationContractId to set
     */
    public void setCancellationRelationContractId(Long cancellationRelationContractId) {
        this.cancellationRelationContractId = cancellationRelationContractId;
    }
    
    /**
     * Get the relationObjectA
     *
     * @return the relationObjectA
     */
    public String getRelationObjectA() {
        return relationObjectA;
    }

    /**
     * Set the relationObjectA
     *
     * @param relationObjectA the relationObjectA to set
     */
    public void setRelationObjectA(String relationObjectA) {
        this.relationObjectA = relationObjectA;
    }

    /**
     * Get the relationObjectB
     *
     * @return the relationObjectB
     */
    public String getRelationObjectB() {
        return relationObjectB;
    }

    /**
     * Set the relationObjectB
     *
     * @param relationObjectB the relationObjectB to set
     */
    public void setRelationObjectB(String relationObjectB) {
        this.relationObjectB = relationObjectB;
    }

    /**
     * Get the relationObjectC
     *
     * @return the relationObjectC
     */
    public String getRelationObjectC() {
        return relationObjectC;
    }

    /**
     * Set the relationObjectC
     *
     * @param relationObjectC the relationObjectC to set
     */
    public void setRelationObjectC(String relationObjectC) {
        this.relationObjectC = relationObjectC;
    }
    
    /**
     * Get the relationObject
     *
     * @return the relationObject
     */
    public String getRelationObject() {
        return relationObject;
    }

    /**
     * Set the relationObject
     *
     * @param relationObject the relationObject to set
     */
    public void setRelationObject(String relationObject) {
        this.relationObject = relationObject;
    }

    /**
     * Get the contractStatus
     *
     * @return the contractStatus
     */
    public Boolean getContractStatus() {
        return contractStatus;
    }

    /**
     * Set the contractStatus
     *
     * @param contractStatus the contractStatus to set
     */
    public void setContractStatus(Boolean contractStatus) {
        this.contractStatus = contractStatus;
    }
    
    /**
     * Get the type
     *
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * Set the type
     *
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Get the propertyInfo
     *
     * @return the propertyInfo
     */
    public String getPropertyInfo() {
        return propertyInfo;
    }

    /**
     * Set the propertyInfo
     *
     * @param propertyInfo the propertyInfo to set
     */
    public void setPropertyInfo(String propertyInfo) {
        this.propertyInfo = propertyInfo;
    }

    /**
     * Get the ownerInfo
     *
     * @return the ownerInfo
     */
    public String getOwnerInfo() {
        return ownerInfo;
    }

    /**
     * Set the ownerInfo
     *
     * @param ownerInfo the ownerInfo to set
     */
    public void setOwnerInfo(String ownerInfo) {
        this.ownerInfo = ownerInfo;
    }

    /**
     * Get the otherInfo
     *
     * @return the otherInfo
     */
    public String getOtherInfo() {
        return otherInfo;
    }

    /**
     * Set the otherInfo
     *
     * @param otherInfo the otherInfo to set
     */
    public void setOtherInfo(String otherInfo) {
        this.otherInfo = otherInfo;
    }

    /**
     * Get the landCertificate
     *
     * @return the landCertificate
     */
    public String getLandCertificate() {
        return landCertificate;
    }

    /**
     * Set the landCertificate
     *
     * @param landCertificate the landCertificate to set
     */
    public void setLandCertificate(String landCertificate) {
        this.landCertificate = landCertificate;
    }

    /**
     * Get the landIssuePlace
     *
     * @return the landIssuePlace
     */
    public String getLandIssuePlace() {
        return landIssuePlace;
    }

    /**
     * Set the landIssuePlace
     *
     * @param landIssuePlace the landIssuePlace to set
     */
    public void setLandIssuePlace(String landIssuePlace) {
        this.landIssuePlace = landIssuePlace;
    }

    /**
     * Get the landIssueDate
     *
     * @return the landIssueDate
     */
    public String getLandIssueDate() {
        return landIssueDate;
    }

    /**
     * Set the landIssueDate
     *
     * @param landIssueDate the landIssueDate to set
     */
    public void setLandIssueDate(String landIssueDate) {
        this.landIssueDate = landIssueDate;
    }

    /**
     * Set the carIssueDate
     *
     * @param carIssueDate the carIssueDate to set
     */
    public void setCarIssueDate(String carIssueDate) {
        this.carIssueDate = carIssueDate;
    }

    /**
     * Get the landMapNumber
     *
     * @return the landMapNumber
     */
    public String getLandMapNumber() {
        return landMapNumber;
    }

    /**
     * Set the landMapNumber
     *
     * @param landMapNumber the landMapNumber to set
     */
    public void setLandMapNumber(String landMapNumber) {
        this.landMapNumber = landMapNumber;
    }

    /**
     * Get the landNumber
     *
     * @return the landNumber
     */
    public String getLandNumber() {
        return landNumber;
    }

    /**
     * Set the landNumber
     *
     * @param landNumber the landNumber to set
     */
    public void setLandNumber(String landNumber) {
        this.landNumber = landNumber;
    }

    /**
     * Get the landAddress
     *
     * @return the landAddress
     */
    public String getLandAddress() {
        return landAddress;
    }

    /**
     * Set the landAddress
     *
     * @param landAddress the landAddress to set
     */
    public void setLandAddress(String landAddress) {
        this.landAddress = landAddress;
    }

    /**
     * Get the landArea
     *
     * @return the landArea
     */
    public String getLandArea() {
        return landArea;
    }

    /**
     * Set the landArea
     *
     * @param landArea the landArea to set
     */
    public void setLandArea(String landArea) {
        this.landArea = landArea;
    }

    /**
     * Get the landPublicArea
     *
     * @return the landPublicArea
     */
    public String getLandPublicArea() {
        return landPublicArea;
    }

    /**
     * Set the landPublicArea
     *
     * @param landPublicArea the landPublicArea to set
     */
    public void setLandPublicArea(String landPublicArea) {
        this.landPublicArea = landPublicArea;
    }

    /**
     * Get the landPrivateArea
     *
     * @return the landPrivateArea
     */
    public String getLandPrivateArea() {
        return landPrivateArea;
    }

    /**
     * Set the landPrivateArea
     *
     * @param landPrivateArea the landPrivateArea to set
     */
    public void setLandPrivateArea(String landPrivateArea) {
        this.landPrivateArea = landPrivateArea;
    }

    /**
     * Get the landUsePurpose
     *
     * @return the landUsePurpose
     */
    public String getLandUsePurpose() {
        return landUsePurpose;
    }

    /**
     * Set the landUsePurpose
     *
     * @param landUsePurpose the landUsePurpose to set
     */
    public void setLandUsePurpose(String landUsePurpose) {
        this.landUsePurpose = landUsePurpose;
    }

    /**
     * Get the landUsePeriod
     *
     * @return the landUsePeriod
     */
    public String getLandUsePeriod() {
        return landUsePeriod;
    }

    /**
     * Set the landUsePeriod
     *
     * @param landUsePeriod the landUsePeriod to set
     */
    public void setLandUsePeriod(String landUsePeriod) {
        this.landUsePeriod = landUsePeriod;
    }

    /**
     * Get the landUseOrigin
     *
     * @return the landUseOrigin
     */
    public String getLandUseOrigin() {
        return landUseOrigin;
    }

    /**
     * Set the landUseOrigin
     *
     * @param landUseOrigin the landUseOrigin to set
     */
    public void setLandUseOrigin(String landUseOrigin) {
        this.landUseOrigin = landUseOrigin;
    }

    /**
     * Get the landDistrict
     *
     * @return the landDistrict
     */
    public String getLandDistrict() {
        return landDistrict;
    }

    /**
     * Set the landDistrict
     *
     * @param landDistrict the landDistrict to set
     */
    public void setLandDistrict(String landDistrict) {
        this.landDistrict = landDistrict;
    }

    /**
     * Get the landProvince
     *
     * @return the landProvince
     */
    public Long getLandProvince() {
        return landProvince;
    }

    /**
     * Set the landProvince
     *
     * @param landProvince the landProvince to set
     */
    public void setLandProvince(Long landProvince) {
        this.landProvince = landProvince;
    }
    
    /**
     * Get the landAssociateProperty
     *
     * @return the landAssociateProperty
     */
    public String getLandAssociateProperty() {
        return landAssociateProperty;
    }

    /**
     * Set the landAssociateProperty
     *
     * @param landAssociateProperty the landAssociateProperty to set
     */
    public void setLandAssociateProperty(String landAssociateProperty) {
        this.landAssociateProperty = landAssociateProperty;
    }

    /**
     * Get the carLicenseNumber
     *
     * @return the carLicenseNumber
     */
    public String getCarLicenseNumber() {
        return carLicenseNumber;
    }

    /**
     * Set the carLicenseNumber
     *
     * @param carLicenseNumber the carLicenseNumber to set
     */
    public void setCarLicenseNumber(String carLicenseNumber) {
        this.carLicenseNumber = carLicenseNumber;
    }

    /**
     * Get the carRegistNumber
     *
     * @return the carRegistNumber
     */
    public String getCarRegistNumber() {
        return carRegistNumber;
    }

    /**
     * Set the carRegistNumber
     *
     * @param carRegistNumber the carRegistNumber to set
     */
    public void setCarRegistNumber(String carRegistNumber) {
        this.carRegistNumber = carRegistNumber;
    }

    /**
     * Get the carIssuePlace
     *
     * @return the carIssuePlace
     */
    public String getCarIssuePlace() {
        return carIssuePlace;
    }

    /**
     * Set the carIssuePlace
     *
     * @param carIssuePlace the carIssuePlace to set
     */
    public void setCarIssuePlace(String carIssuePlace) {
        this.carIssuePlace = carIssuePlace;
    }

    /**
     * Get the carFrameNumber
     *
     * @return the carFrameNumber
     */
    public String getCarFrameNumber() {
        return carFrameNumber;
    }

    /**
     * Set the carFrameNumber
     *
     * @param carFrameNumber the carFrameNumber to set
     */
    public void setCarFrameNumber(String carFrameNumber) {
        this.carFrameNumber = carFrameNumber;
    }

    /**
     * Get the carMachineNumber
     *
     * @return the carMachineNumber
     */
    public String getCarMachineNumber() {
        return carMachineNumber;
    }

    /**
     * Set the carMachineNumber
     *
     * @param carMachineNumber the carMachineNumber to set
     */
    public void setCarMachineNumber(String carMachineNumber) {
        this.carMachineNumber = carMachineNumber;
    }
    
    /**
     * Get the carIssueDate
     *
     * @return the carIssueDate
     */
    public String getCarIssueDate() {
        return carIssueDate;
    }
    
    /**
     * Get the isDetailPropertyEntry
     *
     * @return the isDetailPropertyEntry
     */
    public Boolean getIsDetailPropertyEntry() {
        return isDetailPropertyEntry;
    }

    /**
     * Set the isDetailPropertyEntry
     *
     * @param isDetailPropertyEntry the isDetailPropertyEntry to set
     */
    public void setIsDetailPropertyEntry(Boolean isDetailPropertyEntry) {
        this.isDetailPropertyEntry = isDetailPropertyEntry;
    }
    
    /**
     * Get the cancellationContractId
     *
     * @return the cancellationContractId
     */
    public Long getCancellationContractId() {
        return cancellationContractId;
    }

    /**
     * Set the cancellationContractId
     *
     * @param cancellationContractId the cancellationContractId to set
     */
    public void setCancellationContractId(Long cancellationContractId) {
        this.cancellationContractId = cancellationContractId;
    }

    

    /**
     * Get the entryUserName
     *
     * @return the entryUserName
     */
    public String getEntryUserName() {
        return entryUserName;
    }

    /**
     * Set the entryUserName
     *
     * @param entryUserName the entryUserName to set
     */
    public void setEntryUserName(String entryUserName) {
        this.entryUserName = entryUserName;
    }

    /**
     * Get the entryDateTime
     *
     * @return the entryDateTime
     */
    public String getEntryDateTime() {
        return entryDateTime;
    }

    /**
     * Set the entryDateTime
     *
     * @param entryDateTime the entryDateTime to set
     */
    public void setEntryDateTime(String entryDateTime) {
        this.entryDateTime = entryDateTime;
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
    public String getUpdateDateTime() {
        return updateDateTime;
    }

    /**
     * Set the updateDateTime
     *
     * @param updateDateTime the updateDateTime to set
     */
    public void setUpdateDateTime(String updateDateTime) {
        this.updateDateTime = updateDateTime;
    }

    /**
     * Get the userModify
     *
     * @return the userModify
     */
    public String getUserModify() {
        return userModify;
    }

    /**
     * Set the userModify
     *
     * @param userModify the userModify to set
     */
    public void setUserModify(String userModify) {
        this.userModify = userModify;
    }
    
    /**
     * Get the fileNameDisp
     *
     * @return the fileNameDisp
     */
    public String getFileNameDisp() {
        return fileNameDisp;
    }

    /**
     * Set the fileNameDisp
     *
     * @param fileNameDisp the fileNameDisp to set
     */
    public void setFileNameDisp(String fileNameDisp) {
        this.fileNameDisp = fileNameDisp;
    }

    public void reset(ContractForm form) {
        this.additionStatus = form.getAdditionStatus();
        this.additionDescription = form.getAdditionDescription();
        this.bankId = form.getBankId();
        this.bankServiceFee = form.getBankServiceFee();
        this.cancellationStatus = form.getCancellationStatus();
        this.cancellationDescription = form.getCancellationDescription();
        this.contractNumber = form.getContractNumber();
        this.contractTemplateId = form.getContractTemplateId();
        this.contractTemplateName= form.getContractTemplateName();
        this.contractValue = form.getContractValue();
        this.costDraft = form.getCostDraft();
        this.costNotaryOutsite = form.getCostNotaryOutsite();
        this.costOtherDetermine = form.getCostOtherDetermine();
        this.costTotal = form.getCostTotal();
        this.costTt91 = form.getCostTt91();
        this.crediterName = form.getCrediterName();
        this.drafterId = form.getDrafterId();
        this.errorAgent = form.getErrorAgent();
        this.errorDescription = form.getErrorDescription();
        this.errorStatus = form.getErrorStatus();
        this.formFile = form.getFormFile();
        this.notaryDate = form.getNotaryDate();
        this.notaryId = form.getNotaryId();
        this.notaryPlace = form.getNotaryPlace();
        this.notaryPlaceFlag = form.getNotaryPlaceFlag();
        this.contractSummary = form.getContractSummary();
        this.originalStorePlace = form.getOriginalStorePlace();
        this.receivedDate = form.getReceivedDate();
        this.bankName = form.getBankName();
        this.notaryFamilyName = form.getNotaryFamilyName();
        this.notaryFirstName = form.getNotaryFirstName();
        this.drafterFamilyName = form.getDrafterFamilyName();
        this.drafterFirstName = form.getDrafterFirstName();
        this.errorUserFamilyName = form.getErrorUserFamilyName();
        this.errorUserFirstName = form.getErrorUserFirstName();
        this.contractNote = form.getContractNote();
        this.contractKindName = form.getContractKindName();
        this.userRequireContract = form.getUserRequireContract();
        this.numberCopyOfContract = form.getNumberCopyOfContract();
        this.numberOfPage = form.getNumberOfPage();

        this.type = form.getType();
        this.propertyInfo = form.getPropertyInfo();
        this.ownerInfo = form.getOwnerInfo();
        this.otherInfo = form.getOtherInfo();
        this.landCertificate = form.getLandCertificate();
        this.landIssuePlace = form.getLandIssuePlace();
        this.landIssueDate = form.getLandIssueDate();
        this.landMapNumber = form.getLandMapNumber();
        this.landNumber = form.getLandNumber();
        this.landAddress = form.getLandAddress();
        this.landArea = form.getLandArea();
        this.landPublicArea = form.getLandPublicArea();
        this.landPrivateArea = form.getLandPrivateArea();
        this.landUsePurpose = form.getLandUsePurpose();
        this.landUsePeriod = form.getLandUsePeriod();
        this.landUseOrigin = form.getLandUseOrigin();
        this.landDistrict = form.getLandDistrict();
        this.landProvince = form.getLandProvince();
        this.landAssociateProperty = form.getLandAssociateProperty();
        this.carLicenseNumber = form.getCarLicenseNumber();
        this.carRegistNumber = form.getCarRegistNumber();
        this.carIssuePlace = form.getCarIssuePlace();
        this.carIssueDate = form.getCarIssueDate();
        this.carFrameNumber = form.getCarFrameNumber();
        this.carMachineNumber = form.getCarMachineNumber();

        this.districtPopup = form.getDistrictPopup();
        this.contractKindId = form.getContractKindId();
        this.relationObjectA = form.getRelationObjectA();
        this.relationObjectB = form.getRelationObjectB();
        this.relationObjectC = form.getRelationObjectC();
        this.relationObject = form.getRelationObject();
        
        this.isDetailPropertyEntry = form.getIsDetailPropertyEntry();
        this.contractPeriod = form.getContractPeriod();
        this.mortageCancelFlag = form.getMortageCancelFlag();
        this.mortageCancelDate = form.getMortageCancelDate();
        this.mortageCancelNote = form.getMortageCancelNote();
    }

	/**
	 * @param appendixId the appendixId to set
	 */
	public void setAppendixId(Long appendixId) {
		this.appendixId = appendixId;
	}

	/**
	 * @return the appendixId
	 */
	public Long getAppendixId() {
		return appendixId;
	}

	/**
	 * Get fromTemporaryContract
	 * @return the fromTemporaryContract
	 */
	public Boolean getFromTemporaryContract() {
		return fromTemporaryContract;
	}

	/**
	 * Set fromTemporaryContract
	 * @param fromTemporaryContract the fromTemporaryContract to set
	 */
	public void setFromTemporaryContract(Boolean fromTemporaryContract) {
		this.fromTemporaryContract = fromTemporaryContract;
	}

	/**
	 * @return the contractNumber2
	 */
	public String getContractNumber2() {
		return contractNumber2;
	}

	/**
	 * @param contractNumber2 the contractNumber2 to set
	 */
	public void setContractNumber2(String contractNumber2) {
		this.contractNumber2 = contractNumber2;
	}

	/**
	 * @param contractPeriod the contractPeriod to set
	 */
	public void setContractPeriod(String contractPeriod) {
		this.contractPeriod = contractPeriod;
	}

	/**
	 * @return the contractPeriod
	 */
	public String getContractPeriod() {
		return contractPeriod;
	}

	/**
	 * @param mortagCancelFlag the mortagCancelFlag to set
	 */
	public void setMortageCancelFlag(Boolean mortageCancelFlag) {
		this.mortageCancelFlag = mortageCancelFlag;
	}

	/**
	 * @return the mortagCancelFlag
	 */
	public Boolean getMortageCancelFlag() {
		return mortageCancelFlag;
	}

	/**
	 * @param mortageCancelDate the mortageCancelDate to set
	 */
	public void setMortageCancelDate(String mortageCancelDate) {
		this.mortageCancelDate = mortageCancelDate;
	}

	/**
	 * @return the mortageCancelDate
	 */
	public String getMortageCancelDate() {
		return mortageCancelDate;
	}

	/**
	 * @param mortageCancelNote the mortageCancelNote to set
	 */
	public void setMortageCancelNote(String mortageCancelNote) {
		this.mortageCancelNote = mortageCancelNote;
	}

	/**
	 * @return the mortageCancelNote
	 */
	public String getMortageCancelNote() {
		return mortageCancelNote;
	}

	/**
	 * @param landStreet the landStreet to set
	 */
	public void setLandStreet(String landStreet) {
		this.landStreet = landStreet;
	}

	/**
	 * @return the landStreet
	 */
	public String getLandStreet() {
		return landStreet;
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
	 * @param contractPeriodFlag the contractPeriodFlag to set
	 */
	public void setContractPeriodFlag(Boolean contractPeriodFlag) {
		this.contractPeriodFlag = contractPeriodFlag;
	}

	/**
	 * @return the contractPeriodFlag
	 */
	public Boolean getContractPeriodFlag() {
		return contractPeriodFlag;
	}

	/**
	 * @param mortageCancelDisplayFlag the mortageCancelDisplayFlag to set
	 */
	public void setMortageCancelDisplayFlag(Boolean mortageCancelDisplayFlag) {
		this.mortageCancelDisplayFlag = mortageCancelDisplayFlag;
	}

	/**
	 * @return the mortageCancelDisplayFlag
	 */
	public Boolean getMortageCancelDisplayFlag() {
		return mortageCancelDisplayFlag;
	}

	/**
	 * @param string the landDistrictName to set
	 */
	public void setLandDistrictName(String string) {
		this.landDistrictName = string;
	}

	/**
	 * @return the landDistrictName
	 */
	public String getLandDistrictName() {
		return landDistrictName;
	}

	
	
}
