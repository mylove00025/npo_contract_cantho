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

    /** X�c d?nh l� c�ng d�n hay t? ch?c:
 */
    private String type;

    /** T�n t? ch?c, c�ng d�n */
    private String name;

    /** + M� s? dang k� kinh doanh v?i t? ch?c.
 */
    private String code;

    /** �?a ch? c�ng d�n, t? ch?c */
    private String address;

    /** �i?n tho?i c�ng d�n, t? ch?c */
    private String telephone;

    /** fax */
    private String fax;

    /** Nam sinh c?a c�ng d�n */
    private String birthyear;

    /** T�n ngu?i d?i di?n */
    private String typicalPersonalName;

    /** S? ch?ng minh ngu?i d?i di?n */
    private String typicalPersonalIdentityCard;

    /** Nam sinh ngu?i d?i di?n */
    private String typicalPersonalBirthyear;

    /** �i?n tho?i c? d?nh ngu?i d?i di?n */
    private String typicalPersonalTelephone;

    /** �i?n tho?i di d?ng ngu?i d?i di?n */
    private String typicalPersonalMobile;

    /** Fax ngu?i d?i di?n */
    private String typicalPersonalFax;

    /** Email ngu?i d?i di?n */
    private String typicalPersonalEmail;

    /** �?a ch? ngu?i d?i di?n */
    private String typicalPersonalAddress;

    /** id ngu?i t?o */
    private Long entryUserId;

    /** T�n ngu?i t?o */
    private String entryUserName;

    /** Ng�y t?o */
    private Timestamp entryDateTime;

    /** id ngu?i c?p nh?t cu?i */
    private Long updateUserId;

    /** T�n ngu?i c?p nh?t cu?i */
    private String updateUserName;

    /** Ng�y c?p nh?t cu?i */
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
     * <P>Get X�c d?nh l� c�ng d�n hay t? ch?c:
 </P>
     *
     * @return X�c d?nh l� c�ng d�n hay t? ch?c:

     */
    public String getType() {
        return this.type;
    }

    /**
     * <P>Set X�c d?nh l� c�ng d�n hay t? ch?c:
. </P>
     *
     * @param type X�c d?nh l� c�ng d�n hay t? ch?c:

     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * <P>Get T�n t? ch?c, c�ng d�n </P>
     *
     * @return T�n t? ch?c, c�ng d�n
     */
    public String getName() {
        return this.name;
    }

    /**
     * <P>Set T�n t? ch?c, c�ng d�n. </P>
     *
     * @param name T�n t? ch?c, c�ng d�n
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * <P>Get + M� s? dang k� kinh doanh v?i t? ch?c.
 </P>
     *
     * @return + M� s? dang k� kinh doanh v?i t? ch?c.

     */
    public String getCode() {
        return this.code;
    }

    /**
     * <P>Set + M� s? dang k� kinh doanh v?i t? ch?c.
. </P>
     *
     * @param code + M� s? dang k� kinh doanh v?i t? ch?c.

     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * <P>Get �?a ch? c�ng d�n, t? ch?c </P>
     *
     * @return �?a ch? c�ng d�n, t? ch?c
     */
    public String getAddress() {
        return this.address;
    }

    /**
     * <P>Set �?a ch? c�ng d�n, t? ch?c. </P>
     *
     * @param address �?a ch? c�ng d�n, t? ch?c
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * <P>Get �i?n tho?i c�ng d�n, t? ch?c </P>
     *
     * @return �i?n tho?i c�ng d�n, t? ch?c
     */
    public String getTelephone() {
        return this.telephone;
    }

    /**
     * <P>Set �i?n tho?i c�ng d�n, t? ch?c. </P>
     *
     * @param telephone �i?n tho?i c�ng d�n, t? ch?c
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
     * <P>Get Nam sinh c?a c�ng d�n </P>
     *
     * @return Nam sinh c?a c�ng d�n
     */
    public String getBirthyear() {
        return this.birthyear;
    }

    /**
     * <P>Set Nam sinh c?a c�ng d�n. </P>
     *
     * @param birthyear Nam sinh c?a c�ng d�n
     */
    public void setBirthyear(String birthyear) {
        this.birthyear = birthyear;
    }

    /**
     * <P>Get T�n ngu?i d?i di?n </P>
     *
     * @return T�n ngu?i d?i di?n
     */
    public String getTypicalPersonalName() {
        return this.typicalPersonalName;
    }

    /**
     * <P>Set T�n ngu?i d?i di?n. </P>
     *
     * @param typicalPersonalName T�n ngu?i d?i di?n
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
     * <P>Get �i?n tho?i c? d?nh ngu?i d?i di?n </P>
     *
     * @return �i?n tho?i c? d?nh ngu?i d?i di?n
     */
    public String getTypicalPersonalTelephone() {
        return this.typicalPersonalTelephone;
    }

    /**
     * <P>Set �i?n tho?i c? d?nh ngu?i d?i di?n. </P>
     *
     * @param typicalPersonalTelephone �i?n tho?i c? d?nh ngu?i d?i di?n
     */
    public void setTypicalPersonalTelephone(String typicalPersonalTelephone) {
        this.typicalPersonalTelephone = typicalPersonalTelephone;
    }

    /**
     * <P>Get �i?n tho?i di d?ng ngu?i d?i di?n </P>
     *
     * @return �i?n tho?i di d?ng ngu?i d?i di?n
     */
    public String getTypicalPersonalMobile() {
        return this.typicalPersonalMobile;
    }

    /**
     * <P>Set �i?n tho?i di d?ng ngu?i d?i di?n. </P>
     *
     * @param typicalPersonalMobile �i?n tho?i di d?ng ngu?i d?i di?n
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
     * <P>Get �?a ch? ngu?i d?i di?n </P>
     *
     * @return �?a ch? ngu?i d?i di?n
     */
    public String getTypicalPersonalAddress() {
        return this.typicalPersonalAddress;
    }

    /**
     * <P>Set �?a ch? ngu?i d?i di?n. </P>
     *
     * @param typicalPersonalAddress �?a ch? ngu?i d?i di?n
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
     * <P>Get T�n ngu?i t?o </P>
     *
     * @return T�n ngu?i t?o
     */
    public String getEntryUserName() {
        return this.entryUserName;
    }

    /**
     * <P>Set T�n ngu?i t?o. </P>
     *
     * @param entryUserName T�n ngu?i t?o
     */
    public void setEntryUserName(String entryUserName) {
        this.entryUserName = entryUserName;
    }

    /**
     * <P>Get Ng�y t?o </P>
     *
     * @return Ng�y t?o
     */
    public Timestamp getEntryDateTime() {
        return this.entryDateTime;
    }

    /**
     * <P>Set Ng�y t?o. </P>
     *
     * @param entryDateTime Ng�y t?o
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
     * <P>Get T�n ngu?i c?p nh?t cu?i </P>
     *
     * @return T�n ngu?i c?p nh?t cu?i
     */
    public String getUpdateUserName() {
        return this.updateUserName;
    }

    /**
     * <P>Set T�n ngu?i c?p nh?t cu?i. </P>
     *
     * @param updateUserName T�n ngu?i c?p nh?t cu?i
     */
    public void setUpdateUserName(String updateUserName) {
        this.updateUserName = updateUserName;
    }

    /**
     * <P>Get Ng�y c?p nh?t cu?i </P>
     *
     * @return Ng�y c?p nh?t cu?i
     */
    public Timestamp getUpdateDateTime() {
        return this.updateDateTime;
    }

    /**
     * <P>Set Ng�y c?p nh?t cu?i. </P>
     *
     * @param updateDateTime Ng�y c?p nh?t cu?i
     */
    public void setUpdateDateTime(Timestamp updateDateTime) {
        this.updateDateTime = updateDateTime;
    }
}
