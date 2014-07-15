package com.osp.npo.core.user;


import com.osp.npo.core.AbstractInfo;
import java.sql.Timestamp;


/**
 * Generate by script
 * Generate date: 10/14/2010 11:03:35 AM
 * @version $Revision: 17060 $
 */
public class RoleInfo extends AbstractInfo {


    /** Ma s? ch?c v?
 */
    private String code;

    /** Ten ch?c v? */
    private String name;

    /** id ng??i t?o */
    private Long entryUserId;

    /** Ten ng??i t?o */
    private String entryUserName;

    /** Ngay t?o */
    private Timestamp entryDateTime;

    /** id ng??i c?p nh?t cu?i */
    private Long updateUserId;

    /** Ten ng??i c?p nh?t cu?i */
    private String updateUserName;

    /** Ngay c?p nh?t cu?i */
    private Timestamp updateDateTime;


    /**
     * <P>Generate Instance.</P>
     *
     */
    public RoleInfo() {
        super();
    }


    /**
     * <P>Get Ma s? ch?c v?
 </P>
     *
     * @return Ma s? ch?c v?

     */
    public String getCode() {
        return this.code;
    }

    /**
     * <P>Set Ma s? ch?c v?
. </P>
     *
     * @param code Ma s? ch?c v?

     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * <P>Get Ten ch?c v? </P>
     *
     * @return Ten ch?c v?
     */
    public String getName() {
        return this.name;
    }

    /**
     * <P>Set Ten ch?c v?. </P>
     *
     * @param name Ten ch?c v?
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * <P>Get id ng??i t?o </P>
     *
     * @return id ng??i t?o
     */
    public Long getEntryUserId() {
        return this.entryUserId;
    }

    /**
     * <P>Set id ng??i t?o. </P>
     *
     * @param entryUserId id ng??i t?o
     */
    public void setEntryUserId(Long entryUserId) {
        this.entryUserId = entryUserId;
    }

    /**
     * <P>Get Ten ng??i t?o </P>
     *
     * @return Ten ng??i t?o
     */
    public String getEntryUserName() {
        return this.entryUserName;
    }

    /**
     * <P>Set Ten ng??i t?o. </P>
     *
     * @param entryUserName Ten ng??i t?o
     */
    public void setEntryUserName(String entryUserName) {
        this.entryUserName = entryUserName;
    }

    /**
     * <P>Get Ngay t?o </P>
     *
     * @return Ngay t?o
     */
    public Timestamp getEntryDateTime() {
        return this.entryDateTime;
    }

    /**
     * <P>Set Ngay t?o. </P>
     *
     * @param entryDateTime Ngay t?o
     */
    public void setEntryDateTime(Timestamp entryDateTime) {
        this.entryDateTime = entryDateTime;
    }

    /**
     * <P>Get id ng??i c?p nh?t cu?i </P>
     *
     * @return id ng??i c?p nh?t cu?i
     */
    public Long getUpdateUserId() {
        return this.updateUserId;
    }

    /**
     * <P>Set id ng??i c?p nh?t cu?i. </P>
     *
     * @param updateUserId id ng??i c?p nh?t cu?i
     */
    public void setUpdateUserId(Long updateUserId) {
        this.updateUserId = updateUserId;
    }

    /**
     * <P>Get Ten ng??i c?p nh?t cu?i </P>
     *
     * @return Ten ng??i c?p nh?t cu?i
     */
    public String getUpdateUserName() {
        return this.updateUserName;
    }

    /**
     * <P>Set Ten ng??i c?p nh?t cu?i. </P>
     *
     * @param updateUserName Ten ng??i c?p nh?t cu?i
     */
    public void setUpdateUserName(String updateUserName) {
        this.updateUserName = updateUserName;
    }

    /**
     * <P>Get Ngay c?p nh?t cu?i </P>
     *
     * @return Ngay c?p nh?t cu?i
     */
    public Timestamp getUpdateDateTime() {
        return this.updateDateTime;
    }

    /**
     * <P>Set Ngay c?p nh?t cu?i. </P>
     *
     * @param updateDateTime Ngay c?p nh?t cu?i
     */
    public void setUpdateDateTime(Timestamp updateDateTime) {
        this.updateDateTime = updateDateTime;
    }
}
