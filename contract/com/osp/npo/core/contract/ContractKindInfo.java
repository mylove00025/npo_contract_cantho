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

    /** T�n lo?i h?p d?ng */
    private String name;

    /** Lo?i h?p d?ng cha */
    private Long parentKindId;

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
     * <P>Get T�n lo?i h?p d?ng </P>
     *
     * @return T�n lo?i h?p d?ng
     */
    public String getName() {
        return this.name;
    }

    /**
     * <P>Set T�n lo?i h?p d?ng. </P>
     *
     * @param name T�n lo?i h?p d?ng
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
