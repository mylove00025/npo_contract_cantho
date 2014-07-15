package com.osp.npo.core.basicData;


import com.osp.npo.core.AbstractInfo;
import java.sql.Timestamp;


/**
 * Generate by script
 * Generate date: 10/28/2010 12:04:18 PM
 * @version $Revision: 17059 $
 */
public class BankInfo extends AbstractInfo {


    /** id ngân hàng */
    private Long id;

    /** Tên ngân hàng */
    private String name;

    /** Mã s? d? s?p x?p */
    private Long orderNumber;

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
    public BankInfo() {
        super();
    }


    /**
     * <P>Get id ngân hàng </P>
     *
     * @return id ngân hàng
     */
    public Long getId() {
        return this.id;
    }

    /**
     * <P>Set id ngân hàng. </P>
     *
     * @param id id ngân hàng
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * <P>Get Tên ngân hàng </P>
     *
     * @return Tên ngân hàng
     */
    public String getName() {
        return this.name;
    }

    /**
     * <P>Set Tên ngân hàng. </P>
     *
     * @param name Tên ngân hàng
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * <P>Get Mã s? d? s?p x?p </P>
     *
     * @return Mã s? d? s?p x?p
     */
    public Long getOrderNumber() {
        return this.orderNumber;
    }

    /**
     * <P>Set Mã s? d? s?p x?p. </P>
     *
     * @param orderNumber Mã s? d? s?p x?p
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
