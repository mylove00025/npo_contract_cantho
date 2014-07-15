package com.osp.npo.core.temporaryContract;


import com.osp.npo.common.util.EditString;
import com.osp.npo.core.AbstractInfo;
import java.sql.Timestamp;


/**
 * Generate by script
 * Generate date: 04/26/2011 10:04:43 AM
 * @version $Revision$ 
 */
public class ContractCommentInfo extends AbstractInfo {


    /** Comment ID */
    private Long ccid;

    /** Temporary contract ID */
    private Long tcid;

    /** Comment content */
    private String comment;

    /** Creator ID */
    private Long entryUserId;

    /** Creator name */
    private String entryUserName;

    /** Create date time */
    private Timestamp entryDateTime;

    /** Last update user ID */
    private Long updateUserId;

    /** Last update user name */
    private String updateUserName;

    /** Last update user date time */
    private Timestamp updateDateTime;


    /**
     * <P>Generate Instance.</P>
     *
     */
    public ContractCommentInfo() {
        super();
    }


    /**
     * <P>Get Comment ID </P>
     *
     * @return Comment ID
     */
    public Long getCcid() {
        return this.ccid;
    }

    /**
     * <P>Set Comment ID. </P>
     *
     * @param ccid Comment ID
     */
    public void setCcid(Long ccid) {
        this.ccid = ccid;
    }

    /**
     * <P>Get Temporary contract ID </P>
     *
     * @return Temporary contract ID
     */
    public Long getTcid() {
        return this.tcid;
    }

    /**
     * <P>Set Temporary contract ID. </P>
     *
     * @param tcid Temporary contract ID
     */
    public void setTcid(Long tcid) {
        this.tcid = tcid;
    }

    /**
     * <P>Get Comment content </P>
     *
     * @return Comment content
     */
    public String getComment() {
        return this.comment;
    }

    /**
     * <P>Get Comment content </P>
     *
     * @return Comment content
     */
    public String getCommentDisp() {
        return EditString.replaceChangeLine(this.comment);
    }
    
    /**
     * <P>Set Comment content. </P>
     *
     * @param comment Comment content
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * <P>Get Creator ID </P>
     *
     * @return Creator ID
     */
    public Long getEntryUserId() {
        return this.entryUserId;
    }

    /**
     * <P>Set Creator ID. </P>
     *
     * @param entryUserId Creator ID
     */
    public void setEntryUserId(Long entryUserId) {
        this.entryUserId = entryUserId;
    }

    /**
     * <P>Get Creator name </P>
     *
     * @return Creator name
     */
    public String getEntryUserName() {
        return this.entryUserName;
    }

    /**
     * <P>Set Creator name. </P>
     *
     * @param entryUserName Creator name
     */
    public void setEntryUserName(String entryUserName) {
        this.entryUserName = entryUserName;
    }

    /**
     * <P>Get Create date time </P>
     *
     * @return Create date time
     */
    public Timestamp getEntryDateTime() {
        return this.entryDateTime;
    }

    /**
     * <P>Set Create date time. </P>
     *
     * @param entryDateTime Create date time
     */
    public void setEntryDateTime(Timestamp entryDateTime) {
        this.entryDateTime = entryDateTime;
    }

    /**
     * <P>Get Last update user ID </P>
     *
     * @return Last update user ID
     */
    public Long getUpdateUserId() {
        return this.updateUserId;
    }

    /**
     * <P>Set Last update user ID. </P>
     *
     * @param updateUserId Last update user ID
     */
    public void setUpdateUserId(Long updateUserId) {
        this.updateUserId = updateUserId;
    }

    /**
     * <P>Get Last update user name </P>
     *
     * @return Last update user name
     */
    public String getUpdateUserName() {
        return this.updateUserName;
    }

    /**
     * <P>Set Last update user name. </P>
     *
     * @param updateUserName Last update user name
     */
    public void setUpdateUserName(String updateUserName) {
        this.updateUserName = updateUserName;
    }

    /**
     * <P>Get Last update user date time </P>
     *
     * @return Last update user date time
     */
    public Timestamp getUpdateDateTime() {
        return this.updateDateTime;
    }

    /**
     * <P>Set Last update user date time. </P>
     *
     * @param updateDateTime Last update user date time
     */
    public void setUpdateDateTime(Timestamp updateDateTime) {
        this.updateDateTime = updateDateTime;
    }
}
