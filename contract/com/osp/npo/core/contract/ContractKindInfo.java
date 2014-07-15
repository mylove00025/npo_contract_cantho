package com.osp.npo.core.contract;


import com.osp.npo.core.AbstractInfo;
import java.sql.Timestamp;


/**
 * Generate by script
 * Generate date: 10/28/2010 12:04:18 PM
 */
public class ContractKindInfo extends AbstractInfo {


    /** id lo?i hop dong */
    private Long id;

    /** Tên lo?i h?p d?ng */
    private String name;

    /** Lo?i h?p d?ng cha */
    private Long parentKindId;

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

    /** number of children */
    private int childrenNumber;
    
    private Long count;
    
    private String notaryUser;
    
    private Long notaryId;


    /**
     * <P>Generate Instance.</P>
     *
     */
    public ContractKindInfo() {
        super();
    }


    /**
     * <P>Get id lo?i hop dong </P>
     *
     * @return id lo?i hop dong
     */
    public Long getId() {
        return this.id;
    }

    /**
     * <P>Set id lo?i hop dong. </P>
     *
     * @param id id lo?i hop dong
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * <P>Get Tên lo?i h?p d?ng </P>
     *
     * @return Tên lo?i h?p d?ng
     */
    public String getName() {
        return this.name;
    }

    /**
     * <P>Set Tên lo?i h?p d?ng. </P>
     *
     * @param name Tên lo?i h?p d?ng
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * <P>Get Lo?i h?p d?ng cha </P>
     *
     * @return Lo?i h?p d?ng cha
     */
    public Long getParentKindId() {
        return this.parentKindId;
    }

    /**
     * <P>Set Lo?i h?p d?ng cha. </P>
     *
     * @param parentKindId Lo?i h?p d?ng cha
     */
    public void setParentKindId(Long parentKindId) {
        this.parentKindId = parentKindId;
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


    /**
     * @return the childrenNumber
     */
    public int getChildrenNumber() {
        return childrenNumber;
    }


    /**
     * @param childrenNumber the childrenNumber to set
     */
    public void setChildrenNumber(int childrenNumber) {
        this.childrenNumber = childrenNumber;
    }


	/**
	 * @param count the count to set
	 */
	public void setCount(Long count) {
		this.count = count;
	}


	/**
	 * @return the count
	 */
	public Long getCount() {
		return count;
	}


	/**
	 * @param notaryUser the notaryUser to set
	 */
	public void setNotaryUser(String notaryUser) {
		this.notaryUser = notaryUser;
	}


	/**
	 * @return the notaryUser
	 */
	public String getNotaryUser() {
		return notaryUser;
	}


	/**
	 * @param notaryId the notaryId to set
	 */
	public void setNotaryId(Long notaryId) {
		this.notaryId = notaryId;
	}


	/**
	 * @return the notaryId
	 */
	public Long getNotaryId() {
		return notaryId;
	}
}
