package com.osp.npo.core.contractHistory;


import com.osp.npo.common.global.Constants;
import com.osp.npo.common.util.EditString;
import com.osp.npo.core.AbstractInfo;
import java.sql.Timestamp;


/**
 * Generate by script
 * Generate date: 4/26/2011 4:55:34 PM
 * @version $Revision$ 
 */
public class ContractHistoryInfo extends AbstractInfo {


    /** History ID */
    private Long hid;

    /** Contract ID */
    private Long contractId;

    /** Contract number */
    private String contractNumber;

    /** Client machine information */
    private String clientInfo;

    /** Execute date time */
    private Timestamp executeDateTime;

    /** Execute person */
    private String executePerson;

    /** Execute content */
    private String executeContent;

    /** Contract content */
    private String contractContent;


    /**
     * <P>Generate Instance.</P>
     *
     */
    public ContractHistoryInfo() {
        super();
    }


    /**
     * <P>Get History ID </P>
     *
     * @return History ID
     */
    public Long getHid() {
        return this.hid;
    }

    /**
     * <P>Set History ID. </P>
     *
     * @param hid History ID
     */
    public void setHid(Long hid) {
        this.hid = hid;
    }

    /**
     * <P>Get Contract ID </P>
     *
     * @return Contract ID
     */
    public Long getContractId() {
        return this.contractId;
    }

    /**
     * <P>Set Contract ID. </P>
     *
     * @param contractId Contract ID
     */
    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }

    /**
     * <P>Get Contract number </P>
     *
     * @return Contract number
     */
    public String getContractNumber() {
        return this.contractNumber;
    }

    /**
     * <P>Set Contract number. </P>
     *
     * @param contractNumber Contract number
     */
    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    /**
     * <P>Get Client machine information </P>
     *
     * @return Client machine information
     */
    public String getClientInfo() {
        return this.clientInfo;
    }

    /**
     * <P>Set Client machine information. </P>
     *
     * @param clientInfo Client machine information
     */
    public void setClientInfo(String clientInfo) {
        this.clientInfo = clientInfo;
    }

    /**
     * <P>Get Execute date time </P>
     *
     * @return Execute date time
     */
    public Timestamp getExecuteDateTime() {
        return this.executeDateTime;
    }

    /**
     * <P>Set Execute date time. </P>
     *
     * @param executeDateTime Execute date time
     */
    public void setExecuteDateTime(Timestamp executeDateTime) {
        this.executeDateTime = executeDateTime;
    }

    /**
     * <P>Get Execute person </P>
     *
     * @return Execute person
     */
    public String getExecutePerson() {
        return this.executePerson;
    }

    /**
     * <P>Set Execute person. </P>
     *
     * @param executePerson Execute person
     */
    public void setExecutePerson(String executePerson) {
        this.executePerson = executePerson;
    }

    /**
     * <P>Get Execute content </P>
     *
     * @return Execute content
     */
    public String getExecuteContent() {
        return this.executeContent;
    }

    /**
     * <P>Set Execute content. </P>
     *
     * @param executeContent Execute content
     */
    public void setExecuteContent(String executeContent) {
        this.executeContent = executeContent;
    }

    /**
     * <P>Get Contract content </P>
     *
     * @return Contract content
     */
    public String getContractContent() {
        return this.contractContent;
    }
    
    public String getContractContentNew(){
    	return EditString.replaceChangeLine(contractContent);
    }
    
    public String getContractContentDisp(){
    	return EditString.getDisp(getContractContentNew(), Constants.LENGTH_OUTPUT_LIMIT);
    }

    /**
     * <P>Set Contract content. </P>
     *
     * @param contractContent Contract content
     */
    public void setContractContent(String contractContent) {
        this.contractContent = contractContent;
    }
}
