package com.osp.npo.core.prevent;


import com.osp.npo.common.global.Constants;
import com.osp.npo.common.util.EditString;
import com.osp.npo.common.util.SystemMessageProperties;
import com.osp.npo.core.AbstractInfo;
import java.sql.Timestamp;


/**
 * Generate by script
 * Generate date: 1/22/2011 8:59:06 AM
 * @version $Revision: 29514 $
 */
public class DataPreventInfo extends AbstractInfo {

    /** id DLNC */
    private Long id;

    /** Tài s?n b? ch?n */
    private Long propertyId;

    /** Synchronize ID */
    private String synchronizeId;

    /** Phân lo?i d? li?u ngan ch?n: */
    private String originKind;

    /** C? xóa d? li?u */
    private Boolean deleteFlg;

    /** Ðon v? dang ký CV ngan ch?n */
    private String preventRegistAgency;

    /** S? vào s? công van yêu c?u */
    private String preventInBookNumber;

    /** Thông tin ngu?i (don v?) g?i yêu c?u ngan ch?n */
    private String preventPersonInfo;

    /** S? công van yêu c?u ngan ch?n */
    private String preventDocNumber;

    /** Ngày công van yêu c?u ngan ch?n */
    private Timestamp preventDocDate;

    /** Ngày nh?n công van yêu c?u ngan ch?n */
    private Timestamp preventDocReceiveDate;

    /** Ngày nh?p công van yêu c?u ngan ch?n */
    private Timestamp preventInputDate;

    /** Trích y?u n?i dung công van yêu c?u ngan ch?n */
    private String preventDocSummary;

    /** Tên file dính kèm CV ngan ch?n */
    private String preventFileName;

    /** Luu du?ng d?n ch?a file dính kèm CV ngan ch?n */
    private String preventFilePath;

    /** Ghi chú ngan ch?n */
    private String preventNote;

    /** Tình tr?ng gi?i t?a:  */
    private Boolean releaseFlg;

    /** Ðon v? dang ký CV gi?i t?a */
    private String releaseRegistAgency;

    /** S? vào s? công van gi?i t?a */
    private String releaseInBookNumber;

    /** Thông tin ngu?i (don v?) g?i yêu c?u gi?i t?a */
    private String releasePersonInfo;

    /** S? công van yêu c?u gi?i t?a */
    private String releaseDocNumber;

    /** Ngày công van yêu c?u gi?i t?a */
    private Timestamp releaseDocDate;

    /** Ngày nh?n công van yêu c?u gi?i t?a */
    private Timestamp releaseDocReceiveDate;

    /** Ngày nh?p công van yêu c?u gi?i t?a */
    private Timestamp releaseInputDate;

    /** Trích y?u n?i dung công van yêu c?u gi?i t?a */
    private String releaseDocSummary;

    /** Tên file dính kèm CV gi?i t?a */
    private String releaseFileName;

    /** Luu du?ng d?n ch?a file dính kèm CV gi?i t?a */
    private String releaseFilePath;

    /** Ghi chú gi?i t?a */
    private String releaseNote;

    /** id ngu?i t?o */
    private Long entryUserId;

    /** Tên ngu?i t?o */
    private String entryUserName;

    /** Ngày t?o */
    private Timestamp entryDateTime;

    /** id ngu?i c?p nh?t cu?i */
    private Long updateUserId;

    /** Tên ngu?i c?p nh?t cu?i */
    private String updateUserName;

    /** Ngày c?p nh?t cu?i */
    private Timestamp updateDateTime;

    // info from property prevent info

    /** Loai tài s?n ch?n:  */
    private String type;

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
    private Timestamp landIssueDate;

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
    
    /** Nhà d?t - Ð?a bàn phường xã */
    private String landStreet;

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
    private Timestamp carIssueDate;

    /** Ô tô, Motor - S? khung  */
    private String carFrameNumber;

    /** Ô tô, Motor - S? máy */
    private String carMachineNumber;
    
    /** Lucene Thông tin tài sản hiển thị */
    private String lucenePropertyInfoDisp;
    
    /** Lucene Thông tin tài sản */
    private String lucenePropertyInfo;
    
     
     

    /**
     * <P>Generate Instance.</P>
     *
     */
    public DataPreventInfo() {
        super();
    }


    /**
     * <P>Get id DLNC </P>
     *
     * @return id DLNC
     */
    public Long getId() {
        return this.id;
    }

    /**
     * <P>Set id DLNC. </P>
     *
     * @param id id DLNC
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * <P>Get Tài s?n b? ch?n </P>
     *
     * @return Tài s?n b? ch?n
     */
    public Long getPropertyId() {
        return this.propertyId;
    }

    /**
     * <P>Set Tài s?n b? ch?n. </P>
     *
     * @param propertyId Tài s?n b? ch?n
     */
    public void setPropertyId(Long propertyId) {
        this.propertyId = propertyId;
    }

    /**
     * <P>Get Phân lo?i d? li?u ngan ch?n:
 </P>
     *
     * @return Phân lo?i d? li?u ngan ch?n:

     */
    public String getOriginKind() {
        return this.originKind;
    }

    /**
     * <P>Set Phân lo?i d? li?u ngan ch?n:
. </P>
     *
     * @param originKind Phân lo?i d? li?u ngan ch?n:

     */
    public void setOriginKind(String originKind) {
        this.originKind = originKind;
    }

    /**
     * <P>Get C? xóa d? li?u </P>
     *
     * @return C? xóa d? li?u
     */
    public Boolean getDeleteFlg() {
        return this.deleteFlg;
    }

    /**
     * <P>Set C? xóa d? li?u. </P>
     *
     * @param deleteFlg C? xóa d? li?u
     */
    public void setDeleteFlg(Boolean deleteFlg) {
        this.deleteFlg = deleteFlg;
    }

    /**
     * <P>Get Ðon v? dang ký CV ngan ch?n </P>
     *
     * @return Ðon v? dang ký CV ngan ch?n
     */
    public String getPreventRegistAgency() {
        return this.preventRegistAgency;
    }

    /**
     * <P>Set Ðon v? dang ký CV ngan ch?n. </P>
     *
     * @param preventRegistAgency Ðon v? dang ký CV ngan ch?n
     */
    public void setPreventRegistAgency(String preventRegistAgency) {
        this.preventRegistAgency = preventRegistAgency;
    }

    /**
     * <P>Get S? vào s? công van yêu c?u </P>
     *
     * @return S? vào s? công van yêu c?u
     */
    public String getPreventInBookNumber() {
        return this.preventInBookNumber;
    }

    /**
     * <P>Set S? vào s? công van yêu c?u. </P>
     *
     * @param preventInBookNumber S? vào s? công van yêu c?u
     */
    public void setPreventInBookNumber(String preventInBookNumber) {
        this.preventInBookNumber = preventInBookNumber;
    }

    /**
     * <P>Get Thông tin ngu?i (don v?) g?i yêu c?u ngan ch?n </P>
     *
     * @return Thông tin ngu?i (don v?) g?i yêu c?u ngan ch?n
     */
    public String getPreventPersonInfo() {
        return this.preventPersonInfo;
    }
    
    /**
     * <P>Get Thông tin ngu?i (don v?) g?i yêu c?u ngan ch?n </P>
     *
     * @return Thông tin ngu?i (don v?) g?i yêu c?u ngan ch?n
     */
    public String getPreventPersonInfoDisp() {
        return EditString.replaceChangeLine(this.preventPersonInfo);
    }

    /**
     * <P>Set Thông tin ngu?i (don v?) g?i yêu c?u ngan ch?n. </P>
     *
     * @param preventPersonInfo Thông tin ngu?i (don v?) g?i yêu c?u ngan ch?n
     */
    public void setPreventPersonInfo(String preventPersonInfo) {
        this.preventPersonInfo = preventPersonInfo;
    }

    /**
     * <P>Get S? công van yêu c?u ngan ch?n </P>
     *
     * @return S? công van yêu c?u ngan ch?n
     */
    public String getPreventDocNumber() {
        return this.preventDocNumber;
    }

    /**
     * <P>Set S? công van yêu c?u ngan ch?n. </P>
     *
     * @param preventDocNumber S? công van yêu c?u ngan ch?n
     */
    public void setPreventDocNumber(String preventDocNumber) {
        this.preventDocNumber = preventDocNumber;
    }

    /**
     * <P>Get Ngày công van yêu c?u ngan ch?n </P>
     *
     * @return Ngày công van yêu c?u ngan ch?n
     */
    public Timestamp getPreventDocDate() {
        return this.preventDocDate;
    }

    /**
     * <P>Set Ngày công van yêu c?u ngan ch?n. </P>
     *
     * @param preventDocDate Ngày công van yêu c?u ngan ch?n
     */
    public void setPreventDocDate(Timestamp preventDocDate) {
        this.preventDocDate = preventDocDate;
    }

    /**
     * <P>Get Ngày nh?n công van yêu c?u ngan ch?n </P>
     *
     * @return Ngày nh?n công van yêu c?u ngan ch?n
     */
    public Timestamp getPreventDocReceiveDate() {
        return this.preventDocReceiveDate;
    }

    /**
     * <P>Set Ngày nh?n công van yêu c?u ngan ch?n. </P>
     *
     * @param preventDocReceiveDate Ngày nh?n công van yêu c?u ngan ch?n
     */
    public void setPreventDocReceiveDate(Timestamp preventDocReceiveDate) {
        this.preventDocReceiveDate = preventDocReceiveDate;
    }

    /**
     * <P>Get Ngày nh?p công van yêu c?u ngan ch?n </P>
     *
     * @return Ngày nh?p công van yêu c?u ngan ch?n
     */
    public Timestamp getPreventInputDate() {
        return this.preventInputDate;
    }

    /**
     * <P>Set Ngày nh?p công van yêu c?u ngan ch?n. </P>
     *
     * @param preventInputDate Ngày nh?p công van yêu c?u ngan ch?n
     */
    public void setPreventInputDate(Timestamp preventInputDate) {
        this.preventInputDate = preventInputDate;
    }

    /**
     * <P>Get Trích y?u n?i dung công van yêu c?u ngan ch?n </P>
     *
     * @return Trích y?u n?i dung công van yêu c?u ngan ch?n
     */
    public String getPreventDocSummary() {
        return this.preventDocSummary;
    }

    /**
     * <P>Set Trích y?u n?i dung công van yêu c?u ngan ch?n. </P>
     *
     * @param preventDocSummary Trích y?u n?i dung công van yêu c?u ngan ch?n
     */
    public void setPreventDocSummary(String preventDocSummary) {
        this.preventDocSummary = preventDocSummary;
    }

    /**
     * <P>Get Tên file dính kèm CV ngan ch?n </P>
     *
     * @return Tên file dính kèm CV ngan ch?n
     */
    public String getPreventFileName() {
        return this.preventFileName;
    }

    /**
     * <P>Set Tên file dính kèm CV ngan ch?n. </P>
     *
     * @param preventFileName Tên file dính kèm CV ngan ch?n
     */
    public void setPreventFileName(String preventFileName) {
        this.preventFileName = preventFileName;
    }

    /**
     * <P>Get Luu du?ng d?n ch?a file dính kèm CV ngan ch?n </P>
     *
     * @return Luu du?ng d?n ch?a file dính kèm CV ngan ch?n
     */
    public String getPreventFilePath() {
        return this.preventFilePath;
    }

    /**
     * <P>Set Luu du?ng d?n ch?a file dính kèm CV ngan ch?n. </P>
     *
     * @param preventFilePath Luu du?ng d?n ch?a file dính kèm CV ngan ch?n
     */
    public void setPreventFilePath(String preventFilePath) {
        this.preventFilePath = preventFilePath;
    }

    /**
     * <P>Get Ghi chú ngan ch?n </P>
     *
     * @return Ghi chú ngan ch?n
     */
    public String getPreventNote() {
        return this.preventNote;
    }

    /**
     * <P>Set Ghi chú ngan ch?n. </P>
     *
     * @param preventNote Ghi chú ngan ch?n
     */
    public void setPreventNote(String preventNote) {
        this.preventNote = preventNote;
    }

    /**
     * <P>Get Tình tr?ng gi?i t?a:
 </P>
     *
     * @return Tình tr?ng gi?i t?a:

     */
    public Boolean getReleaseFlg() {
        return this.releaseFlg;
    }

    /**
     * <P>Set Tình tr?ng gi?i t?a:
. </P>
     *
     * @param releaseFlg Tình tr?ng gi?i t?a:

     */
    public void setReleaseFlg(Boolean releaseFlg) {
        this.releaseFlg = releaseFlg;
    }

    /**
     * <P>Get Ðon v? dang ký CV gi?i t?a </P>
     *
     * @return Ðon v? dang ký CV gi?i t?a
     */
    public String getReleaseRegistAgency() {
        return this.releaseRegistAgency;
    }

    /**
     * <P>Set Ðon v? dang ký CV gi?i t?a. </P>
     *
     * @param releaseRegistAgency Ðon v? dang ký CV gi?i t?a
     */
    public void setReleaseRegistAgency(String releaseRegistAgency) {
        this.releaseRegistAgency = releaseRegistAgency;
    }

    /**
     * <P>Get S? vào s? công van gi?i t?a </P>
     *
     * @return S? vào s? công van gi?i t?a
     */
    public String getReleaseInBookNumber() {
        return this.releaseInBookNumber;
    }

    /**
     * <P>Set S? vào s? công van gi?i t?a. </P>
     *
     * @param releaseInBookNumber S? vào s? công van gi?i t?a
     */
    public void setReleaseInBookNumber(String releaseInBookNumber) {
        this.releaseInBookNumber = releaseInBookNumber;
    }

    /**
     * <P>Get Thông tin ngu?i (don v?) g?i yêu c?u gi?i t?a </P>
     *
     * @return Thông tin ngu?i (don v?) g?i yêu c?u gi?i t?a
     */
    public String getReleasePersonInfo() {
        return this.releasePersonInfo;
    }

    /**
     * <P>Set Thông tin ngu?i (don v?) g?i yêu c?u gi?i t?a. </P>
     *
     * @param releasePersonInfo Thông tin ngu?i (don v?) g?i yêu c?u gi?i t?a
     */
    public void setReleasePersonInfo(String releasePersonInfo) {
        this.releasePersonInfo = releasePersonInfo;
    }

    /**
     * <P>Get S? công van yêu c?u gi?i t?a </P>
     *
     * @return S? công van yêu c?u gi?i t?a
     */
    public String getReleaseDocNumber() {
        return this.releaseDocNumber;
    }

    /**
     * <P>Set S? công van yêu c?u gi?i t?a. </P>
     *
     * @param releaseDocNumber S? công van yêu c?u gi?i t?a
     */
    public void setReleaseDocNumber(String releaseDocNumber) {
        this.releaseDocNumber = releaseDocNumber;
    }

    /**
     * <P>Get Ngày công van yêu c?u gi?i t?a </P>
     *
     * @return Ngày công van yêu c?u gi?i t?a
     */
    public Timestamp getReleaseDocDate() {
        return this.releaseDocDate;
    }

    /**
     * <P>Set Ngày công van yêu c?u gi?i t?a. </P>
     *
     * @param releaseDocDate Ngày công van yêu c?u gi?i t?a
     */
    public void setReleaseDocDate(Timestamp releaseDocDate) {
        this.releaseDocDate = releaseDocDate;
    }

    /**
     * <P>Get Ngày nh?n công van yêu c?u gi?i t?a </P>
     *
     * @return Ngày nh?n công van yêu c?u gi?i t?a
     */
    public Timestamp getReleaseDocReceiveDate() {
        return this.releaseDocReceiveDate;
    }

    /**
     * <P>Set Ngày nh?n công van yêu c?u gi?i t?a. </P>
     *
     * @param releaseDocReceiveDate Ngày nh?n công van yêu c?u gi?i t?a
     */
    public void setReleaseDocReceiveDate(Timestamp releaseDocReceiveDate) {
        this.releaseDocReceiveDate = releaseDocReceiveDate;
    }

    /**
     * <P>Get Ngày nh?p công van yêu c?u gi?i t?a </P>
     *
     * @return Ngày nh?p công van yêu c?u gi?i t?a
     */
    public Timestamp getReleaseInputDate() {
        return this.releaseInputDate;
    }

    /**
     * <P>Set Ngày nh?p công van yêu c?u gi?i t?a. </P>
     *
     * @param releaseInputDate Ngày nh?p công van yêu c?u gi?i t?a
     */
    public void setReleaseInputDate(Timestamp releaseInputDate) {
        this.releaseInputDate = releaseInputDate;
    }

    /**
     * <P>Get Trích y?u n?i dung công van yêu c?u gi?i t?a </P>
     *
     * @return Trích y?u n?i dung công van yêu c?u gi?i t?a
     */
    public String getReleaseDocSummary() {
        return this.releaseDocSummary;
    }

    /**
     * <P>Set Trích y?u n?i dung công van yêu c?u gi?i t?a. </P>
     *
     * @param releaseDocSummary Trích y?u n?i dung công van yêu c?u gi?i t?a
     */
    public void setReleaseDocSummary(String releaseDocSummary) {
        this.releaseDocSummary = releaseDocSummary;
    }

    /**
     * <P>Get Tên file dính kèm CV gi?i t?a </P>
     *
     * @return Tên file dính kèm CV gi?i t?a
     */
    public String getReleaseFileName() {
        return this.releaseFileName;
    }

    /**
     * <P>Set Tên file dính kèm CV gi?i t?a. </P>
     *
     * @param releaseFileName Tên file dính kèm CV gi?i t?a
     */
    public void setReleaseFileName(String releaseFileName) {
        this.releaseFileName = releaseFileName;
    }

    /**
     * <P>Get Luu du?ng d?n ch?a file dính kèm CV gi?i t?a </P>
     *
     * @return Luu du?ng d?n ch?a file dính kèm CV gi?i t?a
     */
    public String getReleaseFilePath() {
        return this.releaseFilePath;
    }

    /**
     * <P>Set Luu du?ng d?n ch?a file dính kèm CV gi?i t?a. </P>
     *
     * @param releaseFilePath Luu du?ng d?n ch?a file dính kèm CV gi?i t?a
     */
    public void setReleaseFilePath(String releaseFilePath) {
        this.releaseFilePath = releaseFilePath;
    }

    /**
     * <P>Get Ghi chú gi?i t?a </P>
     *
     * @return Ghi chú gi?i t?a
     */
    public String getReleaseNote() {
        return this.releaseNote;
    }

    /**
     * <P>Set Ghi chú gi?i t?a. </P>
     *
     * @param releaseNote Ghi chú gi?i t?a
     */
    public void setReleaseNote(String releaseNote) {
        this.releaseNote = releaseNote;
    }

    /**
     * <P>Get id ngu?i t?o </P>
     *
     * @return id ngu?i t?o
     */
    public Long getEntryUserId() {
        return this.entryUserId;
    }

    /**
     * <P>Set id ngu?i t?o. </P>
     *
     * @param entryUserId id ngu?i t?o
     */
    public void setEntryUserId(Long entryUserId) {
        this.entryUserId = entryUserId;
    }

    /**
     * <P>Get Tên ngu?i t?o </P>
     *
     * @return Tên ngu?i t?o
     */
    public String getEntryUserName() {
        return this.entryUserName;
    }

    /**
     * <P>Set Tên ngu?i t?o. </P>
     *
     * @param entryUserName Tên ngu?i t?o
     */
    public void setEntryUserName(String entryUserName) {
        this.entryUserName = entryUserName;
    }

    /**
     * <P>Get Ngày t?o </P>
     *
     * @return Ngày t?o
     */
    public Timestamp getEntryDateTime() {
        return this.entryDateTime;
    }

    /**
     * <P>Set Ngày t?o. </P>
     *
     * @param entryDateTime Ngày t?o
     */
    public void setEntryDateTime(Timestamp entryDateTime) {
        this.entryDateTime = entryDateTime;
    }

    /**
     * <P>Get id ngu?i c?p nh?t cu?i </P>
     *
     * @return id ngu?i c?p nh?t cu?i
     */
    public Long getUpdateUserId() {
        return this.updateUserId;
    }

    /**
     * <P>Set id ngu?i c?p nh?t cu?i. </P>
     *
     * @param updateUserId id ngu?i c?p nh?t cu?i
     */
    public void setUpdateUserId(Long updateUserId) {
        this.updateUserId = updateUserId;
    }

    /**
     * <P>Get Tên ngu?i c?p nh?t cu?i </P>
     *
     * @return Tên ngu?i c?p nh?t cu?i
     */
    public String getUpdateUserName() {
        return this.updateUserName;
    }

    /**
     * <P>Set Tên ngu?i c?p nh?t cu?i. </P>
     *
     * @param updateUserName Tên ngu?i c?p nh?t cu?i
     */
    public void setUpdateUserName(String updateUserName) {
        this.updateUserName = updateUserName;
    }

    /**
     * <P>Get Ngày c?p nh?t cu?i </P>
     *
     * @return Ngày c?p nh?t cu?i
     */
    public Timestamp getUpdateDateTime() {
        return this.updateDateTime;
    }

    /**
     * <P>Set Ngày c?p nh?t cu?i. </P>
     *
     * @param updateDateTime Ngày c?p nh?t cu?i
     */
    public void setUpdateDateTime(Timestamp updateDateTime) {
        this.updateDateTime = updateDateTime;
    }


    /**
     * @return the type
     */
    public String getType() {
        return type;
    }


    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }


    /**
     * @return the propertyInfo
     */
    public String getPropertyInfo() {
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
        return ownerInfo;
    }


    /**
     * @param ownerInfo the ownerInfo to set
     */
    public void setOwnerInfo(String ownerInfo) {
        this.ownerInfo = ownerInfo;
    }


    /**
     * @return the otherInfo
     */
    public String getOtherInfo() {
        return otherInfo;
    }


    /**
     * @param otherInfo the otherInfo to set
     */
    public void setOtherInfo(String otherInfo) {
        this.otherInfo = otherInfo;
    }


    /**
     * @return the landCertificate
     */
    public String getLandCertificate() {
        return landCertificate;
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
        return landIssuePlace;
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
    public Timestamp getLandIssueDate() {
        return landIssueDate;
    }


    /**
     * @param landIssueDate the landIssueDate to set
     */
    public void setLandIssueDate(Timestamp landIssueDate) {
        this.landIssueDate = landIssueDate;
    }


    /**
     * @return the landMapNumber
     */
    public String getLandMapNumber() {
        return landMapNumber;
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
        return landNumber;
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
        return landAddress;
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
        return landArea;
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
        return landPublicArea;
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
        return landPrivateArea;
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
        return landUsePurpose;
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
        return landUsePeriod;
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
        return landUseOrigin;
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
        return landDistrict;
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
        return landProvince;
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
        return landAssociateProperty;
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
        return carLicenseNumber;
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
        return carRegistNumber;
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
        return carIssuePlace;
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
    public Timestamp getCarIssueDate() {
        return carIssueDate;
    }


    /**
     * @param carIssueDate the carIssueDate to set
     */
    public void setCarIssueDate(Timestamp carIssueDate) {
        this.carIssueDate = carIssueDate;
    }


    /**
     * @return the carFrameNumber
     */
    public String getCarFrameNumber() {
        return carFrameNumber;
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
        return carMachineNumber;
    }


    /**
     * @param carMachineNumber the carMachineNumber to set
     */
    public void setCarMachineNumber(String carMachineNumber) {
        this.carMachineNumber = carMachineNumber;
    }

    /**
     * Get the propertyInfoDisp
     *
     * @return the propertyInfoDisp
     */
    public String getPropertyInfoDisp() {
        return EditString.replaceChangeLine(propertyInfo);
    }

    /**
     * <P>Get the ownerInfoDisp </P>
     *
     * @return ownerInfoDisp
     */
    public String getOwnerInfoDisp() {
        return EditString.replaceChangeLine(ownerInfo);
    }

    /**
     * <P>Get the info </P>
     *
     * @return info
     */
    public String getInfo() {
        String info = "";
        String landArea = getLandArea2();
        if ("01".equals(type)&&!"".equals(landArea)) {
        	info += getLandArea2();
        }
        info += propertyInfo;
        if (!EditString.isNull(ownerInfo)) {
            info += Constants.SEMI_COLON + SystemMessageProperties.getSystemProperty("item_owner")
                + Constants.COLON + Constants.SPACE + ownerInfo;
        }
        if (!EditString.isNull(otherInfo)) {
            info += Constants.SEMI_COLON + SystemMessageProperties.getSystemProperty("item_other_info")
                + Constants.COLON + Constants.SPACE + otherInfo;
        }
        return EditString.replaceChangeLine(info);
    }
    
    /**
     * <P>Get the info </P>
     *
     * @return info
     */
    public String getPropertyInfoLucene() {
        String info = "";
        String landArea = getLandArea2();
        if ("01".equals(type)&&!"".equals(landArea)) {
        	info += getLandArea2();
        }
        info += propertyInfo;
        if (!EditString.isNull(ownerInfo)) {
            info += Constants.SEMI_COLON + SystemMessageProperties.getSystemProperty("item_owner")
                + Constants.COLON + Constants.SPACE + ownerInfo;
        }
        if (!EditString.isNull(otherInfo)) {
            info += Constants.SEMI_COLON + SystemMessageProperties.getSystemProperty("item_other_info")
                + Constants.COLON + Constants.SPACE + otherInfo;
        }
        return EditString.replaceChangeLine(info);
    }

    /**
     * <P>Get the infoDisp </P>
     *
     * @return infoDisp
     */
    public String getInfoDisp() {
        return EditString.getDisp(getInfo(), Constants.LENGTH_OUTPUT_LIMIT);
    }


    /**
     * @return the synchronizeId
     */
    public String getSynchronizeId() {
        return synchronizeId;
    }


    /**
     * @param synchronizeId the synchronizeId to set
     */
    public void setSynchronizeId(String synchronizeId) {
        this.synchronizeId = synchronizeId;
    }


	/**
	 * @param lucenePropertyInfoDisp the lucenePropertyInfoDisp to set
	 */
	public void setLucenePropertyInfoDisp(String lucenePropertyInfoDisp) {
		this.lucenePropertyInfoDisp = lucenePropertyInfoDisp;
	}


	/**
	 * @return the lucenePropertyInfoDisp
	 */
	public String getLucenePropertyInfoDisp() {
		return lucenePropertyInfoDisp;
	}


	/**
	 * @param lucenePropertyInfo the lucenePropertyInfo to set
	 */
	public void setLucenePropertyInfo(String lucenePropertyInfo) {
		this.lucenePropertyInfo = lucenePropertyInfo;
	}


	/**
	 * @return the lucenePropertyInfo
	 */
	public String getLucenePropertyInfo() {
		return lucenePropertyInfo;
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
	
	public String getLandArea2(){
		String landArea = "";
		if ((getLandDistrict()!=null && !"".equals(getLandDistrict().trim()))||(getLandStreet()!=null && !"".equals(getLandStreet().trim()))) {
			landArea += SystemMessageProperties.getSystemProperty("item_area") + Constants.COLON + Constants.SPACE;
			landArea += landStreet + Constants.SPACE; 
			if (getLandDistrict()!=null && getLandStreet()!=null && !"".equals(getLandDistrict().trim()) && !"".equals(getLandStreet().trim())) {
				landArea += "-" + Constants.SPACE;
			}
			landArea += landDistrict;
		}
		if (!"".equals(landArea)) landArea += Constants.ENTER;
		return landArea;
	}
}
