package com.osp.npo.app.form;

import java.io.IOException;
import java.sql.Timestamp;

import org.apache.struts.upload.FormFile;
import org.apache.struts.validator.ValidatorForm;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;


import com.osp.npo.app.message.MessageUtil;
import com.osp.npo.app.viewhelper.DataPreventViewHelper;
import com.osp.npo.common.util.EditString;
import com.osp.npo.common.util.RelateDateTime;

/**
 *
 * Form for regist or edit Data prevent
 *
 * @author GiangVT
 * @version $Revision: 27190 $
 */
public class DataPreventForm extends ValidatorForm {

    private static final long serialVersionUID = 6228628135708467634L;
    public static final String UPLOAD_FOLDER_KEY = "system_prevent_data_folder";
    public static final String LAND_TYPE = "01";
    public static final String CAR_TYPE = "02";
    public static final String OTHER_TYPE = "99";

    /** TÃƒÂ i sÃ¡ÂºÂ£n bÃƒÂ¡o chÃ¡ÂºÂ·n */
    private String propertyType;

//    /** QuÃ¡ÂºÂ­n huyÃ¡Â»â€¡n nÃ†Â¡i chÃ¡Â»Â©a tÃƒÂ i sÃ¡ÂºÂ£n Ã„â€˜Ã¡ÂºÂ¥t */
//    private Long district;

    /** id DLNC */
    private Long id;

    /** Tài s?n b? ch?n */
    private Long propertyId;

    /** Phân lo?i d? li?u ngan ch?n: */
    private String originKind;

    /** Thông tin ngu?i (don v?) g?i yêu c?u ngan ch?n */
    private String preventPersonInfo;

    /** S? vào s? công van yêu c?u */
    private String preventInBookNumber;

    /** S? công van yêu c?u ngan ch?n */
    private String preventDocNumber;

    /** Ngày công van yêu c?u ngan ch?n */
    private String preventDocDate;

    /** Ngày nh?n công van yêu c?u ngan ch?n */
    private String preventDocReceiveDate;

    /** Ngày nh?p công van yêu c?u ngan ch?n */
    private String preventInputDate;

    /** Trích y?u n?i dung công van yêu c?u ngan ch?n */
    private String preventDocSummary;

    /** Ghi chú ngan ch?n */
    private String preventNote;

    /** Tình tr?ng gi?i t?a:  */
    private Boolean releaseFlg;

    /** S? vào s? công van gi?i t?a */
    private String releaseInBookNumber;

    /** Thông tin ngu?i (don v?) g?i yêu c?u gi?i t?a */
    private String releasePersonInfo;

    /** S? công van yêu c?u gi?i t?a */
    private String releaseDocNumber;

    /** Ngày công van yêu c?u gi?i t?a */
    private String releaseDocDate;

    /** Ngày nh?n công van yêu c?u gi?i t?a */
    private String releaseDocReceiveDate;

    /** Ngày nh?p công van yêu c?u gi?i t?a */
    private String releaseInputDate;

    /** Trích y?u n?i dung công van yêu c?u gi?i t?a */
    private String releaseDocSummary;

    /** Ghi chú gi?i t?a */
    private String releaseNote;

    // info from property prevent info

    /** Thong tin tai san */
    private String propertyInfo;

    /** Thong tin chu so huu */
    private String ownerInfo;

    /** Thông tin khác */
    private String otherInfo;

    /** Nhà d?t - S? gi?y ch?ng nh?n */
    private String landCertificate;

    /** Nhà d?t - Noi c?p GCN */
    private String landIssuePlace;

    /** Nhà d?t - Ngày c?p GCN */
    private String landIssueDate;

    /** Nhà d?t -S? t? b?n d? */
    private String landMapNumber;

    /** Nhà d?t -S? th?a d?t */
    private String landNumber;

    /** Nhà d?t -Ð?a ch? th?a d?t */
    private String landAddress;

    /** Nhà d?t - Di?n tích */
    private String landArea;

    /** Nhà d?t - Di?n tích s? d?ng chung */
    private String landPublicArea;

    /** Nhà d?t - Di?n tích s? d?ng riêng */
    private String landPrivateArea;

    /** Nhà d?t - M?c dích s? d?ng */
    private String landUsePurpose;

    /** Nhà d?t - M?c dích s? d?ng */
    private String landUsePeriod;

    /** Nhà d?t - M?c dích s? d?ng */
    private String landUseOrigin;

    /** Nhà d?t - Ð?a bàn T?nh/Thành */
    private String landDistrict;

    /** Nhà d?t - Ð?a bàn Qu?n/Huy?n  */
    private Long landProvince;

    /** Tai san gan lien voi dat */
    private String landAssociateProperty;

    /** Ô tô, Motor - Bi?n ki?m soát */
    private String carLicenseNumber;

    /** Ô tô, Motor - S? dang ký */
    private String carRegistNumber;

    /** Ô tô, Motor - Noi c?p GCN */
    private String carIssuePlace;

    /** Ô tô, Motor  - Ngày c?p GCN */
    private String carIssueDate;

    /** Ô tô, Motor - S? khung  */
    private String carFrameNumber;

    /** Ô tô, Motor - S? máy */
    private String carMachineNumber;

    /** remove file */
    private Boolean filePreventExisted;

    /** remove file release */
    private Boolean fileReleaseExisted;

    /** Remove file flag */
    private Boolean isSimpleInsert;

    /** File */
    private FormFile formFilePrevent;

    /** File */
    private FormFile formFileRelease;

    /** checking from regist screen to */
    private Boolean fromRegistScreen;
    
    private String landStreet;

    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {

        DataPreventViewHelper view = (DataPreventViewHelper)request.getSession().getAttribute(DataPreventViewHelper.SESSION_KEY);
        if (view == null) {
            return new ActionErrors();
        }

        ActionErrors errors = super.validate(mapping, request);
        if (errors == null) {
            errors = new ActionErrors();
        }

        MessageUtil messageUtil = new MessageUtil();

        if (!EditString.isNull(getPreventDocDate())) {
            Timestamp send = RelateDateTime.toTimestamp(false, getPreventDocDate());
            if (send == null) {
                errors.add(messageUtil.createActionMessages("preventDocDate", request, "err_not_regular", "item_prevent_doc_date"));
            }
        }

        if (!EditString.isNull(getPreventDocReceiveDate())) {
            Timestamp send = RelateDateTime.toTimestamp(false, getPreventDocReceiveDate());
            if (send == null) {
                errors.add(messageUtil.createActionMessages("preventDocReceiveDate", request, "err_not_regular", "item_prevent_doc_receive_data"));
            }
        }


        if (!EditString.isNull(getPreventInputDate())) {
            Timestamp send = RelateDateTime.toTimestamp(false, getPreventInputDate());
            if (send == null) {
                errors.add(messageUtil.createActionMessages("preventInputDate", request, "err_not_regular", "item_prevent_input_date"));
            }
        }

        if (!EditString.isNull(getReleaseDocDate())) {
            Timestamp send = RelateDateTime.toTimestamp(false, getReleaseDocDate());
            if (send == null) {
                errors.add(messageUtil.createActionMessages("releaseDocDate", request, "err_not_regular", "item_release_doc_date"));
            }
        }

        if (!EditString.isNull(getReleaseDocReceiveDate())) {
            Timestamp send = RelateDateTime.toTimestamp(false, getReleaseDocReceiveDate());
            if (send == null) {
                errors.add(messageUtil.createActionMessages("releaseDocReceiveDate", request, "err_not_regular", "item_release_receive_date"));
            }
        }

        if (!EditString.isNull(getReleaseInputDate())) {
            Timestamp send = RelateDateTime.toTimestamp(false, getReleaseInputDate());
            if (send == null) {
                errors.add(messageUtil.createActionMessages("releaseInputDate", request, "err_not_regular", "item_release_input_date"));
            }
        }

        if (!EditString.isNull(getLandIssueDate())) {
            Timestamp send = RelateDateTime.toTimestamp(false, getLandIssueDate());
            if (send == null) {
                errors.add(messageUtil.createActionMessages("landIssueDate", request, "err_not_regular", "item_land_issue_date"));
            }
        }

        if (!EditString.isNull(getCarIssueDate())) {
            Timestamp send = RelateDateTime.toTimestamp(false, getCarIssueDate());
            if (send == null) {
                errors.add(messageUtil.createActionMessages("carIssueDate", request, "err_not_regular", "item_car_issue_date"));
            }
        }

        if (getFilePreventExisted() == null || getFilePreventExisted() == Boolean.FALSE) {
            if (getFormFilePrevent() != null) {
                if (getFormFilePrevent().getFileName().length() > 100) {
                    errors.add(messageUtil.createActionMessages("formFilePrevent", request, "err_max_length", "item_file_name", "100"));
                }

                try {
                    if (getFormFilePrevent().getFileData().length > 20971520) {
                        errors.add(messageUtil.createActionMessages("formFilePrevent", "err_file_content_over_max"));
                    }
                } catch (IOException e) {
                    errors.add(messageUtil.createActionMessages("formFilePrevent", "err_cannot_upload_file"));
                }
            }
        }

        if (getFileReleaseExisted() == null || getFileReleaseExisted() == Boolean.FALSE) {
            if (getFormFileRelease() != null) {
                if (getFormFileRelease().getFileName().length() > 100) {
                    errors.add(messageUtil.createActionMessages("formFileRelease", request, "err_max_length", "item_file_name", "100"));
                }

                try {
                    if (getFormFileRelease() != null && getFormFileRelease().getFileData().length > 20971520) {
                        errors.add(messageUtil.createActionMessages("formFileRelease", "err_file_content_over_max"));
                    }
                } catch (IOException e) {
                    errors.add(messageUtil.createActionMessages("formFileRelease", "err_cannot_upload_file"));
                }
            }
        }

        if (errors != null) {
            if (errors.size() > 0) {
                view.reset(this);
            }
        }
        return errors;

    }

    /**
     * @return the propertyType
     */
    public String getPropertyType() {
        return propertyType;
    }

    /**
     * @param propertyType the propertyType to set
     */
    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

//    /**
//     * @return the district
//     */
//    public Long getDistrict() {
//        return district;
//    }
//
//    /**
//     * @param district the district to set
//     */
//    public void setDistrict(Long district) {
//        this.district = district;
//    }

    /**
     * @return the otherInfo
     */
    public String getOtherInfo() {
        if (otherInfo != null) {
            return otherInfo.trim();
        }
        return otherInfo;
    }

    /**
     * @param otherInfo the otherInfo to set
     */
    public void setOtherInfo(String otherInfo) {
        this.otherInfo = otherInfo;
    }

    /**
     * @return the formFilePrevent
     */
    public FormFile getFormFilePrevent() {
        return formFilePrevent;
    }

    /**
     * @param formFilePrevent the formFilePrevent to set
     */
    public void setFormFilePrevent(FormFile formFilePrevent) {
        this.formFilePrevent = formFilePrevent;
    }

    /**
     * @return the formFileRelease
     */
    public FormFile getFormFileRelease() {
        return formFileRelease;
    }

    /**
     * @param formFileRelease the formFileRelease to set
     */
    public void setFormFileRelease(FormFile formFileRelease) {
        this.formFileRelease = formFileRelease;
    }

    /**
     * @return the fromRegistScreen
     */
    public Boolean getFromRegistScreen() {
        return fromRegistScreen;
    }

    /**
     * @param fromRegistScreen the fromRegistScreen to set
     */
    public void setFromRegistScreen(Boolean fromRegistScreen) {
        this.fromRegistScreen = fromRegistScreen;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the propertyId
     */
    public Long getPropertyId() {
        return propertyId;
    }

    /**
     * @param propertyId the propertyId to set
     */
    public void setPropertyId(Long propertyId) {
        this.propertyId = propertyId;
    }

    /**
     * @return the originKind
     */
    public String getOriginKind() {
        return originKind;
    }

    /**
     * @param originKind the originKind to set
     */
    public void setOriginKind(String originKind) {
        this.originKind = originKind;
    }

    /**
     * @return the preventInBookNumber
     */
    public String getPreventInBookNumber() {
        if (preventInBookNumber != null) {
            return preventInBookNumber.trim();
        }
        return preventInBookNumber;
    }

    /**
     * @param preventInBookNumber the preventInBookNumber to set
     */
    public void setPreventInBookNumber(String preventInBookNumber) {
        this.preventInBookNumber = preventInBookNumber;
    }

    /**
     * @return the preventDocNumber
     */
    public String getPreventDocNumber() {
        if (preventDocNumber != null) {
            return preventDocNumber.trim();
        }
        return preventDocNumber;
    }

    /**
     * @param preventDocNumber the preventDocNumber to set
     */
    public void setPreventDocNumber(String preventDocNumber) {
        this.preventDocNumber = preventDocNumber;
    }

    /**
     * @return the preventDocDate
     */
    public String getPreventDocDate() {
        return preventDocDate;
    }

    /**
     * @param preventDocDate the preventDocDate to set
     */
    public void setPreventDocDate(String preventDocDate) {
        this.preventDocDate = preventDocDate;
    }

    /**
     * @return the preventDocReceiveDate
     */
    public String getPreventDocReceiveDate() {
        return preventDocReceiveDate;
    }

    /**
     * @param preventDocReceiveDate the preventDocReceiveDate to set
     */
    public void setPreventDocReceiveDate(String preventDocReceiveDate) {
        this.preventDocReceiveDate = preventDocReceiveDate;
    }

    /**
     * @return the preventInputDate
     */
    public String getPreventInputDate() {
        return preventInputDate;
    }

    /**
     * @param preventInputDate the preventInputDate to set
     */
    public void setPreventInputDate(String preventInputDate) {
        this.preventInputDate = preventInputDate;
    }

    /**
     * @return the preventDocSummary
     */
    public String getPreventDocSummary() {
        if (preventDocSummary != null) {
            return preventDocSummary.trim();
        }
        return preventDocSummary;
    }

    /**
     * @param preventDocSummary the preventDocSummary to set
     */
    public void setPreventDocSummary(String preventDocSummary) {
        this.preventDocSummary = preventDocSummary;
    }

    /**
     * @return the preventNote
     */
    public String getPreventNote() {
        if (preventNote != null) {
            return preventNote.trim();
        }
        return preventNote;
    }

    /**
     * @param preventNote the preventNote to set
     */
    public void setPreventNote(String preventNote) {
        this.preventNote = preventNote;
    }

    /**
     * @return the releaseFlg
     */
    public Boolean getReleaseFlg() {
        return releaseFlg;
    }

    /**
     * @param releaseFlg the releaseFlg to set
     */
    public void setReleaseFlg(Boolean releaseFlg) {
        this.releaseFlg = releaseFlg;
    }

    /**
     * @return the releaseInBookNumber
     */
    public String getReleaseInBookNumber() {
        if (releaseInBookNumber != null) {
            return releaseInBookNumber.trim();
        }
        return releaseInBookNumber;
    }

    /**
     * @param releaseInBookNumber the releaseInBookNumber to set
     */
    public void setReleaseInBookNumber(String releaseInBookNumber) {
        this.releaseInBookNumber = releaseInBookNumber;
    }

    /**
     * @return the releasePersonInfo
     */
    public String getReleasePersonInfo() {
        if (releasePersonInfo != null) {
            return releasePersonInfo.trim();
        }
        return releasePersonInfo;
    }

    /**
     * @param releasePersonInfo the releasePersonInfo to set
     */
    public void setReleasePersonInfo(String releasePersonInfo) {
        this.releasePersonInfo = releasePersonInfo;
    }

    /**
     * @return the releaseDocNumber
     */
    public String getReleaseDocNumber() {
        if (releaseDocNumber != null) {
            return releaseDocNumber.trim();
        }
        return releaseDocNumber;
    }

    /**
     * @param releaseDocNumber the releaseDocNumber to set
     */
    public void setReleaseDocNumber(String releaseDocNumber) {
        this.releaseDocNumber = releaseDocNumber;
    }

    /**
     * @return the releaseDocDate
     */
    public String getReleaseDocDate() {
        return releaseDocDate;
    }

    /**
     * @param releaseDocDate the releaseDocDate to set
     */
    public void setReleaseDocDate(String releaseDocDate) {
        this.releaseDocDate = releaseDocDate;
    }

    /**
     * @return the releaseDocReceiveDate
     */
    public String getReleaseDocReceiveDate() {
        return releaseDocReceiveDate;
    }

    /**
     * @param releaseDocReceiveDate the releaseDocReceiveDate to set
     */
    public void setReleaseDocReceiveDate(String releaseDocReceiveDate) {
        this.releaseDocReceiveDate = releaseDocReceiveDate;
    }

    /**
     * @return the releaseInputDate
     */
    public String getReleaseInputDate() {
        return releaseInputDate;
    }

    /**
     * @param releaseInputDate the releaseInputDate to set
     */
    public void setReleaseInputDate(String releaseInputDate) {
        this.releaseInputDate = releaseInputDate;
    }

    /**
     * @return the releaseDocSummary
     */
    public String getReleaseDocSummary() {
        if (releaseDocSummary != null) {
            return releaseDocSummary.trim();
        }
        return releaseDocSummary;
    }

    /**
     * @param releaseDocSummary the releaseDocSummary to set
     */
    public void setReleaseDocSummary(String releaseDocSummary) {
        this.releaseDocSummary = releaseDocSummary;
    }

    /**
     * @return the releaseNote
     */
    public String getReleaseNote() {
        if (releaseNote != null) {
            return releaseNote.trim();
        }
        return releaseNote;
    }

    /**
     * @param releaseNote the releaseNote to set
     */
    public void setReleaseNote(String releaseNote) {
        this.releaseNote = releaseNote;
    }

    /**
     * @return the propertyInfo
     */
    public String getPropertyInfo() {
        if (propertyInfo != null) {
            return propertyInfo.trim();
        }
        return propertyInfo;
    }

    /**
     * @param propertyInfo the propertyInfo to set
     */
    public void setPropertyInfo(String propertyInfo) {
        this.propertyInfo = propertyInfo;
    }

    /**
     * @return the ownerInfo
     */
    public String getOwnerInfo() {
        if (ownerInfo != null) {
            return ownerInfo.trim();
        }
        return ownerInfo;
    }

    /**
     * @param ownerInfo the ownerInfo to set
     */
    public void setOwnerInfo(String ownerInfo) {
        this.ownerInfo = ownerInfo;
    }

    /**
     * @return the landCertificate
     */
    public String getLandCertificate() {
        if (getPropertyType() != null && getPropertyType().equals("01")) {
            if (landCertificate != null) {
                return landCertificate.trim();
            }
            return landCertificate;
        } else {
            return null;
        }
    }

    /**
     * @param landCertificate the landCertificate to set
     */
    public void setLandCertificate(String landCertificate) {
        this.landCertificate = landCertificate;
    }

    /**
     * @return the landIssuePlace
     */
    public String getLandIssuePlace() {
        if (getPropertyType() != null && getPropertyType().equals("01")) {
            if (landIssuePlace != null) {
                return landIssuePlace.trim();
            }
            return landIssuePlace;
        } else {
            return null;
        }
    }

    /**
     * @param landIssuePlace the landIssuePlace to set
     */
    public void setLandIssuePlace(String landIssuePlace) {
        this.landIssuePlace = landIssuePlace;
    }

    /**
     * @return the landIssueDate
     */
    public String getLandIssueDate() {
        if (getPropertyType() != null && getPropertyType().equals("01")) {
            return landIssueDate;
        } else {
            return null;
        }
    }

    /**
     * @param landIssueDate the landIssueDate to set
     */
    public void setLandIssueDate(String landIssueDate) {
        this.landIssueDate = landIssueDate;
    }

    /**
     * @return the landMapNumber
     */
    public String getLandMapNumber() {
        if (getPropertyType() != null && getPropertyType().equals("01")) {
            if (landMapNumber != null) {
                return landMapNumber.trim();
            }
            return landMapNumber;
        } else {
            return null;
        }
    }

    /**
     * @param landMapNumber the landMapNumber to set
     */
    public void setLandMapNumber(String landMapNumber) {
        this.landMapNumber = landMapNumber;
    }

    /**
     * @return the landNumber
     */
    public String getLandNumber() {
        if (getPropertyType() != null && getPropertyType().equals("01")) {
            if (landNumber != null) {
                return landNumber.trim();
            }
            return landNumber;
        } else {
            return null;
        }
    }

    /**
     * @param landNumber the landNumber to set
     */
    public void setLandNumber(String landNumber) {
        this.landNumber = landNumber;
    }

    /**
     * @return the landAddress
     */
    public String getLandAddress() {
        if (getPropertyType() != null && getPropertyType().equals("01")) {
            if (landAddress != null) {
                return landAddress.trim();
            }
            return landAddress;
        } else {
            return null;
        }
    }

    /**
     * @param landAddress the landAddress to set
     */
    public void setLandAddress(String landAddress) {
        this.landAddress = landAddress;
    }

    /**
     * @return the landArea
     */
    public String getLandArea() {
        if (getPropertyType() != null && getPropertyType().equals("01")) {
            if (landArea != null) {
                return landArea.trim();
            }
            return landArea;
        } else {
            return null;
        }
    }

    /**
     * @param landArea the landArea to set
     */
    public void setLandArea(String landArea) {
        this.landArea = landArea;
    }

    /**
     * @return the landPublicArea
     */
    public String getLandPublicArea() {
        if (getPropertyType() != null && getPropertyType().equals("01")) {
            if (landPublicArea != null) {
                return landPublicArea.trim();
            }
            return landPublicArea;
        } else {
            return null;
        }
    }

    /**
     * @param landPublicArea the landPublicArea to set
     */
    public void setLandPublicArea(String landPublicArea) {
        this.landPublicArea = landPublicArea;
    }

    /**
     * @return the landPrivateArea
     */
    public String getLandPrivateArea() {
        if (getPropertyType() != null && getPropertyType().equals("01")) {
            if (landPrivateArea != null) {
                return landPrivateArea.trim();
            }
            return landPrivateArea;
        } else {
            return null;
        }
    }

    /**
     * @param landPrivateArea the landPrivateArea to set
     */
    public void setLandPrivateArea(String landPrivateArea) {
        this.landPrivateArea = landPrivateArea;
    }

    /**
     * @return the landUsePurpose
     */
    public String getLandUsePurpose() {
        if (getPropertyType() != null && getPropertyType().equals("01")) {
            if (landUsePurpose != null) {
                return landUsePurpose.trim();
            }
            return landUsePurpose;
        } else {
            return null;
        }
    }

    /**
     * @param landUsePurpose the landUsePurpose to set
     */
    public void setLandUsePurpose(String landUsePurpose) {
        this.landUsePurpose = landUsePurpose;
    }

    /**
     * @return the landUsePeriod
     */
    public String getLandUsePeriod() {
        if (getPropertyType() != null && getPropertyType().equals("01")) {
            if (landUsePeriod != null) {
                return landUsePeriod.trim();
            }
            return landUsePeriod;
        } else {
            return null;
        }
    }

    /**
     * @param landUsePeriod the landUsePeriod to set
     */
    public void setLandUsePeriod(String landUsePeriod) {
        this.landUsePeriod = landUsePeriod;
    }

    /**
     * @return the landUseOrigin
     */
    public String getLandUseOrigin() {
        if (getPropertyType() != null && getPropertyType().equals("01")) {
            if (landUseOrigin != null) {
                return landUseOrigin.trim();
            }
            return landUseOrigin;
        } else {
            return null;
        }
    }

    /**
     * @param landUseOrigin the landUseOrigin to set
     */
    public void setLandUseOrigin(String landUseOrigin) {
        this.landUseOrigin = landUseOrigin;
    }

    /**
     * @return the landDistrict
     */
    public String getLandDistrict() {
        if (getPropertyType() != null && getPropertyType().equals("01")) {
            return landDistrict;
        } else {
            return null;
        }
    }

    /**
     * @param landDistrict the landDistrict to set
     */
    public void setLandDistrict(String landDistrict) {
        this.landDistrict = landDistrict;
    }

    /**
     * @return the landProvince
     */
    public Long getLandProvince() {
        if (getPropertyType() != null && getPropertyType().equals("01")) {
            return landProvince;
        } else {
            return null;
        }
    }

    /**
     * @param landProvince the landProvince to set
     */
    public void setLandProvince(Long landProvince) {
        this.landProvince = landProvince;
    }

    /**
     * @return the landAssociateProperty
     */
    public String getLandAssociateProperty() {
        if (getPropertyType() != null && getPropertyType().equals("01")) {
            if (landAssociateProperty != null) {
                return landAssociateProperty.trim();
            }
            return landAssociateProperty;
        } else {
            return null;
        }
    }

    /**
     * @param landAssociateProperty the landAssociateProperty to set
     */
    public void setLandAssociateProperty(String landAssociateProperty) {
        this.landAssociateProperty = landAssociateProperty;
    }

    /**
     * @return the carLicenseNumber
     */
    public String getCarLicenseNumber() {
        if (getPropertyType() != null && getPropertyType().equals("02")) {
            if (carLicenseNumber != null) {
                return carLicenseNumber.trim();
            }
            return carLicenseNumber;
        } else {
            return null;
        }
    }

    /**
     * @param carLicenseNumber the carLicenseNumber to set
     */
    public void setCarLicenseNumber(String carLicenseNumber) {
        this.carLicenseNumber = carLicenseNumber;
    }

    /**
     * @return the carRegistNumber
     */
    public String getCarRegistNumber() {
        if (getPropertyType() != null && getPropertyType().equals("02")) {
            if (carRegistNumber != null) {
                return carRegistNumber.trim();
            }
            return carRegistNumber;
        } else {
            return null;
        }
    }

    /**
     * @param carRegistNumber the carRegistNumber to set
     */
    public void setCarRegistNumber(String carRegistNumber) {
        this.carRegistNumber = carRegistNumber;
    }

    /**
     * @return the carIssuePlace
     */
    public String getCarIssuePlace() {
        if (getPropertyType() != null && getPropertyType().equals("02")) {
            if (carIssuePlace != null) {
                return carIssuePlace.trim();
            }
            return carIssuePlace;
        } else {
            return null;
        }
    }

    /**
     * @param carIssuePlace the carIssuePlace to set
     */
    public void setCarIssuePlace(String carIssuePlace) {
        this.carIssuePlace = carIssuePlace;
    }

    /**
     * @return the carIssueDate
     */
    public String getCarIssueDate() {
        if (getPropertyType() != null && getPropertyType().equals("02")) {
            return carIssueDate;
        } else {
            return null;
        }
    }

    /**
     * @param carIssueDate the carIssueDate to set
     */
    public void setCarIssueDate(String carIssueDate) {
        this.carIssueDate = carIssueDate;
    }

    /**
     * @return the carFrameNumber
     */
    public String getCarFrameNumber() {
        if (getPropertyType() != null && getPropertyType().equals("02")) {
            if (carFrameNumber != null) {
                return carFrameNumber.trim();
            }
            return carFrameNumber;
        } else {
            return null;
        }
    }

    /**
     * @param carFrameNumber the carFrameNumber to set
     */
    public void setCarFrameNumber(String carFrameNumber) {
        this.carFrameNumber = carFrameNumber;
    }

    /**
     * @return the carMachineNumber
     */
    public String getCarMachineNumber() {
        if (getPropertyType() != null && getPropertyType().equals("02")) {
            if (carMachineNumber != null) {
                return carMachineNumber.trim();
            }
            return carMachineNumber;
        } else {
            return null;
        }
    }

    /**
     * @param carMachineNumber the carMachineNumber to set
     */
    public void setCarMachineNumber(String carMachineNumber) {
        this.carMachineNumber = carMachineNumber;
    }

    /**
     * @return the filePreventExisted
     */
    public Boolean getFilePreventExisted() {
        return filePreventExisted;
    }

    /**
     * @param filePreventExisted the filePreventExisted to set
     */
    public void setFilePreventExisted(Boolean filePreventExisted) {
        this.filePreventExisted = filePreventExisted;
    }

    /**
     * @return the fileReleaseExisted
     */
    public Boolean getFileReleaseExisted() {
        return fileReleaseExisted;
    }

    /**
     * @param fileReleaseExisted the fileReleaseExisted to set
     */
    public void setFileReleaseExisted(Boolean fileReleaseExisted) {
        this.fileReleaseExisted = fileReleaseExisted;
    }

    /**
     * @return the isSimpleInsert
     */
    public Boolean getIsSimpleInsert() {
        return isSimpleInsert;
    }

    /**
     * @param isSimpleInsert the isSimpleInsert to set
     */
    public void setIsSimpleInsert(Boolean isSimpleInsert) {
        this.isSimpleInsert = isSimpleInsert;
    }

    /**
     * @return the preventPersonInfo
     */
    public String getPreventPersonInfo() {
        if (preventPersonInfo != null) {
            return preventPersonInfo.trim();
        }
        return preventPersonInfo;
    }

    /**
     * @param preventPersonInfo the preventPersonInfo to set
     */
    public void setPreventPersonInfo(String preventPersonInfo) {
        this.preventPersonInfo = preventPersonInfo;
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
		 if (landStreet != null) {
	            return landStreet.trim();
	        }
	        return landStreet;
	}
}