package com.osp.npo.core.contract;

import java.sql.Timestamp;
import com.osp.npo.core.AbstractInfo;

/**
 * Generate by script
 * Generate date: 11/29/2010 10:15:29 AM
 */
public class ContractPropertyInfo extends AbstractInfo {


    /** ID c?a h?p d?ng */
    private Long contractId;

    /** ID c?a tài s?n */
    private Long propertyId;

    /** Ten mau hop dong */
    private String templateName;

    /** notary date */
    private Timestamp notaryDate;

    /** contract number */
    private String contractNumber;

    /**
     * <P>Generate Instance.</P>
     *
     */
    public ContractPropertyInfo() {
        super();
    }


    /**
     * <P>Get ID c?a h?p d?ng </P>
     *
     * @return ID c?a h?p d?ng
     */
    public Long getContractId() {
        return this.contractId;
    }

    /**
     * <P>Set ID c?a h?p d?ng. </P>
     *
     * @param contractId ID c?a h?p d?ng
     */
    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }

    /**
     * <P>Get ID c?a tài s?n </P>
     *
     * @return ID c?a tài s?n
     */
    public Long getPropertyId() {
        return this.propertyId;
    }

    /**
     * <P>Set ID c?a tài s?n. </P>
     *
     * @param propertyId ID c?a tài s?n
     */
    public void setPropertyId(Long propertyId) {
        this.propertyId = propertyId;
    }


    /**
     * @return the templateName
     */
    public String getTemplateName() {
        return templateName;
    }


    /**
     * @param templateName the templateName to set
     */
    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }


    /**
     * @return the notaryDate
     */
    public Timestamp getNotaryDate() {
        return notaryDate;
    }


    /**
     * @param notaryDate the notaryDate to set
     */
    public void setNotaryDate(Timestamp notaryDate) {
        this.notaryDate = notaryDate;
    }


    /**
     * @return the contractNumber
     */
    public String getContractNumber() {
        return contractNumber;
    }


    /**
     * @param contractNumber the contractNumber to set
     */
    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }
}
