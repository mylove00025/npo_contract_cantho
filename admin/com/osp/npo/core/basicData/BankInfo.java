package com.osp.npo.core.basicData;


import com.osp.npo.core.AbstractInfo;
import java.sql.Timestamp;


/**
 * Generate by script
 * Generate date: 10/28/2010 12:04:18 PM
 * @version $Revision: 17059 $
 */
public class BankInfo extends AbstractInfo {


    /** id ng�n h�ng */
    private Long id;

    /** T�n ng�n h�ng */
    private String name;

    /** M� s? d? s?p x?p */
    private Long orderNumber;

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
    public BankInfo() {
        super();
    }


    /**
     * <P>Get id ng�n h�ng </P>
     *
     * @return id ng�n h�ng
     */
    public Long getId() {
        return this.id;
    }

    /**
     * <P>Set id ng�n h�ng. </P>
     *
     * @param id id ng�n h�ng
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * <P>Get T�n ng�n h�ng </P>
     *
     * @return T�n ng�n h�ng
     */
    public String getName() {
        return this.name;
    }

    /**
     * <P>Set T�n ng�n h�ng. </P>
     *
     * @param name T�n ng�n h�ng
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * <P>Get M� s? d? s?p x?p </P>
     *
     * @return M� s? d? s?p x?p
     */
    public Long getOrderNumber() {
        return this.orderNumber;
    }

    /**
     * <P>Set M� s? d? s?p x?p. </P>
     *
     * @param orderNumber M� s? d? s?p x?p
     */
    public void setOrderNumber(Long orderNumber) {
        this.orderNumber = orderNumber;
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
