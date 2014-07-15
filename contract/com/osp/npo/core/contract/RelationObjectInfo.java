package com.osp.npo.core.contract;


import com.osp.npo.core.AbstractInfo;
import java.sql.Timestamp;


/**
 * Generate by script
 * Generate date: 10/28/2010 12:04:18 PM
 */
public class RelationObjectInfo extends AbstractInfo {


    /** id t? tang */
    private Long id;

    /** Xác d?nh là công dân hay t? ch?c:
 */
    private String type;

    /** Tên t? ch?c, công dân */
    private String name;

    /** + Mã s? dang ký kinh doanh v?i t? ch?c.
 */
    private String code;

    /** Ð?a ch? công dân, t? ch?c */
    private String address;

    /** Ði?n tho?i công dân, t? ch?c */
    private String telephone;

    /** fax */
    private String fax;

    /** Nam sinh c?a công dân */
    private String birthyear;

    /** Tên ngu?i d?i di?n */
    private String typicalPersonalName;

    /** S? ch?ng minh ngu?i d?i di?n */
    private String typicalPersonalIdentityCard;

    /** Nam sinh ngu?i d?i di?n */
    private String typicalPersonalBirthyear;

    /** Ði?n tho?i c? d?nh ngu?i d?i di?n */
    private String typicalPersonalTelephone;

    /** Ði?n tho?i di d?ng ngu?i d?i di?n */
    private String typicalPersonalMobile;

    /** Fax ngu?i d?i di?n */
    private String typicalPersonalFax;

    /** Email ngu?i d?i di?n */
    private String typicalPersonalEmail;

    /** Ð?a ch? ngu?i d?i di?n */
    private String typicalPersonalAddress;

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


    /**
     * <P>Generate Instance.</P>
     *
     */
    public RelationObjectInfo() {
        super();
    }


    /**
     * <P>Get id t? tang </P>
     *
     * @return id t? tang
     */
    public Long getId() {
        return this.id;
    }

    /**
     * <P>Set id t? tang. </P>
     *
     * @param id id t? tang
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * <P>Get Xác d?nh là công dân hay t? ch?c:
 </P>
     *
     * @return Xác d?nh là công dân hay t? ch?c:

     */
    public String getType() {
        return this.type;
    }

    /**
     * <P>Set Xác d?nh là công dân hay t? ch?c:
. </P>
     *
     * @param type Xác d?nh là công dân hay t? ch?c:

     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * <P>Get Tên t? ch?c, công dân </P>
     *
     * @return Tên t? ch?c, công dân
     */
    public String getName() {
        return this.name;
    }

    /**
     * <P>Set Tên t? ch?c, công dân. </P>
     *
     * @param name Tên t? ch?c, công dân
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * <P>Get + Mã s? dang ký kinh doanh v?i t? ch?c.
 </P>
     *
     * @return + Mã s? dang ký kinh doanh v?i t? ch?c.

     */
    public String getCode() {
        return this.code;
    }

    /**
     * <P>Set + Mã s? dang ký kinh doanh v?i t? ch?c.
. </P>
     *
     * @param code + Mã s? dang ký kinh doanh v?i t? ch?c.

     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * <P>Get Ð?a ch? công dân, t? ch?c </P>
     *
     * @return Ð?a ch? công dân, t? ch?c
     */
    public String getAddress() {
        return this.address;
    }

    /**
     * <P>Set Ð?a ch? công dân, t? ch?c. </P>
     *
     * @param address Ð?a ch? công dân, t? ch?c
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * <P>Get Ði?n tho?i công dân, t? ch?c </P>
     *
     * @return Ði?n tho?i công dân, t? ch?c
     */
    public String getTelephone() {
        return this.telephone;
    }

    /**
     * <P>Set Ði?n tho?i công dân, t? ch?c. </P>
     *
     * @param telephone Ði?n tho?i công dân, t? ch?c
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    /**
     * <P>Get fax </P>
     *
     * @return fax
     */
    public String getFax() {
        return this.fax;
    }

    /**
     * <P>Set fax. </P>
     *
     * @param fax fax
     */
    public void setFax(String fax) {
        this.fax = fax;
    }

    /**
     * <P>Get Nam sinh c?a công dân </P>
     *
     * @return Nam sinh c?a công dân
     */
    public String getBirthyear() {
        return this.birthyear;
    }

    /**
     * <P>Set Nam sinh c?a công dân. </P>
     *
     * @param birthyear Nam sinh c?a công dân
     */
    public void setBirthyear(String birthyear) {
        this.birthyear = birthyear;
    }

    /**
     * <P>Get Tên ngu?i d?i di?n </P>
     *
     * @return Tên ngu?i d?i di?n
     */
    public String getTypicalPersonalName() {
        return this.typicalPersonalName;
    }

    /**
     * <P>Set Tên ngu?i d?i di?n. </P>
     *
     * @param typicalPersonalName Tên ngu?i d?i di?n
     */
    public void setTypicalPersonalName(String typicalPersonalName) {
        this.typicalPersonalName = typicalPersonalName;
    }

    /**
     * <P>Get S? ch?ng minh ngu?i d?i di?n </P>
     *
     * @return S? ch?ng minh ngu?i d?i di?n
     */
    public String getTypicalPersonalIdentityCard() {
        return this.typicalPersonalIdentityCard;
    }

    /**
     * <P>Set S? ch?ng minh ngu?i d?i di?n. </P>
     *
     * @param typicalPersonalIdentityCard S? ch?ng minh ngu?i d?i di?n
     */
    public void setTypicalPersonalIdentityCard(String typicalPersonalIdentityCard) {
        this.typicalPersonalIdentityCard = typicalPersonalIdentityCard;
    }

    /**
     * <P>Get Nam sinh ngu?i d?i di?n </P>
     *
     * @return Nam sinh ngu?i d?i di?n
     */
    public String getTypicalPersonalBirthyear() {
        return this.typicalPersonalBirthyear;
    }

    /**
     * <P>Set Nam sinh ngu?i d?i di?n. </P>
     *
     * @param typicalPersonalBirthyear Nam sinh ngu?i d?i di?n
     */
    public void setTypicalPersonalBirthyear(String typicalPersonalBirthyear) {
        this.typicalPersonalBirthyear = typicalPersonalBirthyear;
    }

    /**
     * <P>Get Ði?n tho?i c? d?nh ngu?i d?i di?n </P>
     *
     * @return Ði?n tho?i c? d?nh ngu?i d?i di?n
     */
    public String getTypicalPersonalTelephone() {
        return this.typicalPersonalTelephone;
    }

    /**
     * <P>Set Ði?n tho?i c? d?nh ngu?i d?i di?n. </P>
     *
     * @param typicalPersonalTelephone Ði?n tho?i c? d?nh ngu?i d?i di?n
     */
    public void setTypicalPersonalTelephone(String typicalPersonalTelephone) {
        this.typicalPersonalTelephone = typicalPersonalTelephone;
    }

    /**
     * <P>Get Ði?n tho?i di d?ng ngu?i d?i di?n </P>
     *
     * @return Ði?n tho?i di d?ng ngu?i d?i di?n
     */
    public String getTypicalPersonalMobile() {
        return this.typicalPersonalMobile;
    }

    /**
     * <P>Set Ði?n tho?i di d?ng ngu?i d?i di?n. </P>
     *
     * @param typicalPersonalMobile Ði?n tho?i di d?ng ngu?i d?i di?n
     */
    public void setTypicalPersonalMobile(String typicalPersonalMobile) {
        this.typicalPersonalMobile = typicalPersonalMobile;
    }

    /**
     * <P>Get Fax ngu?i d?i di?n </P>
     *
     * @return Fax ngu?i d?i di?n
     */
    public String getTypicalPersonalFax() {
        return this.typicalPersonalFax;
    }

    /**
     * <P>Set Fax ngu?i d?i di?n. </P>
     *
     * @param typicalPersonalFax Fax ngu?i d?i di?n
     */
    public void setTypicalPersonalFax(String typicalPersonalFax) {
        this.typicalPersonalFax = typicalPersonalFax;
    }

    /**
     * <P>Get Email ngu?i d?i di?n </P>
     *
     * @return Email ngu?i d?i di?n
     */
    public String getTypicalPersonalEmail() {
        return this.typicalPersonalEmail;
    }

    /**
     * <P>Set Email ngu?i d?i di?n. </P>
     *
     * @param typicalPersonalEmail Email ngu?i d?i di?n
     */
    public void setTypicalPersonalEmail(String typicalPersonalEmail) {
        this.typicalPersonalEmail = typicalPersonalEmail;
    }

    /**
     * <P>Get Ð?a ch? ngu?i d?i di?n </P>
     *
     * @return Ð?a ch? ngu?i d?i di?n
     */
    public String getTypicalPersonalAddress() {
        return this.typicalPersonalAddress;
    }

    /**
     * <P>Set Ð?a ch? ngu?i d?i di?n. </P>
     *
     * @param typicalPersonalAddress Ð?a ch? ngu?i d?i di?n
     */
    public void setTypicalPersonalAddress(String typicalPersonalAddress) {
        this.typicalPersonalAddress = typicalPersonalAddress;
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
}
