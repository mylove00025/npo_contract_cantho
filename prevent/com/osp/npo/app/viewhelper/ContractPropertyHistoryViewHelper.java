package com.osp.npo.app.viewhelper;

import java.util.List;
import com.osp.npo.core.prevent.DataPreventHistoryInfo;

/**
 *
 * Data Prevent View Helper
 *
 * @author GiangVT
 * @version $Revision$
 */
public class ContractPropertyHistoryViewHelper {

    public static final String SESSION_KEY = "contractPropertyViewHelper";

    private List<DataPreventHistoryInfo> lstHistoryInfo;

    /** TÃƒÂ i sÃ¡ÂºÂ£n bÃƒÂ¡o chÃ¡ÂºÂ·n */
    private String propertyTypeName;

    /** Thong tin tai san */
    private String propertyInfo;

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
    private String releaseDocDate;

    /** Ngày nh?n công van yêu c?u gi?i t?a */
    private String releaseDocReceiveDate;

    /** Ngày nh?p công van yêu c?u gi?i t?a */
    private String releaseInputDate;

    /** Trích y?u n?i dung công van yêu c?u gi?i t?a */
    private String releaseDocSummary;

    /** Tên file dính kèm CV gi?i t?a */
    private String releaseFileName;

    /** Luu du?ng d?n ch?a file dính kèm CV gi?i t?a */
    private String releaseFilePath;

    /** Ghi chú gi?i t?a */
    private String releaseNote;

    /**
     * @return the propertyTypeName
     */
    public String getPropertyTypeName() {
        return propertyTypeName;
    }

    /**
     * @param propertyTypeName the propertyTypeName to set
     */
    public void setPropertyTypeName(String propertyTypeName) {
        this.propertyTypeName = propertyTypeName;
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
     * @return the preventPersonInfo
     */
    public String getPreventPersonInfo() {
        return preventPersonInfo;
    }

    /**
     * @param preventPersonInfo the preventPersonInfo to set
     */
    public void setPreventPersonInfo(String preventPersonInfo) {
        this.preventPersonInfo = preventPersonInfo;
    }

    /**
     * @return the preventInBookNumber
     */
    public String getPreventInBookNumber() {
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
        return preventDocSummary;
    }

    /**
     * @param preventDocSummary the preventDocSummary to set
     */
    public void setPreventDocSummary(String preventDocSummary) {
        this.preventDocSummary = preventDocSummary;
    }

    /**
     * @return the preventFileName
     */
    public String getPreventFileName() {
        return preventFileName;
    }

    /**
     * @param preventFileName the preventFileName to set
     */
    public void setPreventFileName(String preventFileName) {
        this.preventFileName = preventFileName;
    }

    /**
     * @return the preventFilePath
     */
    public String getPreventFilePath() {
        return preventFilePath;
    }

    /**
     * @param preventFilePath the preventFilePath to set
     */
    public void setPreventFilePath(String preventFilePath) {
        this.preventFilePath = preventFilePath;
    }

    /**
     * @return the preventNote
     */
    public String getPreventNote() {
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
     * @return the releaseRegistAgency
     */
    public String getReleaseRegistAgency() {
        return releaseRegistAgency;
    }

    /**
     * @param releaseRegistAgency the releaseRegistAgency to set
     */
    public void setReleaseRegistAgency(String releaseRegistAgency) {
        this.releaseRegistAgency = releaseRegistAgency;
    }

    /**
     * @return the releaseInBookNumber
     */
    public String getReleaseInBookNumber() {
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
        return releaseDocSummary;
    }

    /**
     * @param releaseDocSummary the releaseDocSummary to set
     */
    public void setReleaseDocSummary(String releaseDocSummary) {
        this.releaseDocSummary = releaseDocSummary;
    }

    /**
     * @return the releaseFileName
     */
    public String getReleaseFileName() {
        return releaseFileName;
    }

    /**
     * @param releaseFileName the releaseFileName to set
     */
    public void setReleaseFileName(String releaseFileName) {
        this.releaseFileName = releaseFileName;
    }

    /**
     * @return the releaseFilePath
     */
    public String getReleaseFilePath() {
        return releaseFilePath;
    }

    /**
     * @param releaseFilePath the releaseFilePath to set
     */
    public void setReleaseFilePath(String releaseFilePath) {
        this.releaseFilePath = releaseFilePath;
    }

    /**
     * @return the releaseNote
     */
    public String getReleaseNote() {
        return releaseNote;
    }

    /**
     * @param releaseNote the releaseNote to set
     */
    public void setReleaseNote(String releaseNote) {
        this.releaseNote = releaseNote;
    }

    /**
     * @return the lstHistoryInfo
     */
    public List<DataPreventHistoryInfo> getLstHistoryInfo() {
        return lstHistoryInfo;
    }

    /**
     * @param lstHistoryInfo the lstHistoryInfo to set
     */
    public void setLstHistoryInfo(List<DataPreventHistoryInfo> lstHistoryInfo) {
        this.lstHistoryInfo = lstHistoryInfo;
    }
}