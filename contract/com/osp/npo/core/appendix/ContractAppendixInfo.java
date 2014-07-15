package com.osp.npo.core.appendix;


import com.osp.npo.core.AbstractInfo;


/**
 * Generate by script
 * Generate date: 04/22/2011 3:02:07 PM
 * @version $Revision$ 
 */
public class ContractAppendixInfo extends AbstractInfo {


    /** Main contract ID */
    private Long mainCid;

    /** Appendix contract ID */
    private Long appendixCid;


    /**
     * <P>Generate Instance.</P>
     *
     */
    public ContractAppendixInfo() {
        super();
    }


    /**
     * <P>Get Main contract ID </P>
     *
     * @return Main contract ID
     */
    public Long getMainCid() {
        return this.mainCid;
    }

    /**
     * <P>Set Main contract ID. </P>
     *
     * @param mainCid Main contract ID
     */
    public void setMainCid(Long mainCid) {
        this.mainCid = mainCid;
    }

    /**
     * <P>Get Appendix contract ID </P>
     *
     * @return Appendix contract ID
     */
    public Long getAppendixCid() {
        return this.appendixCid;
    }

    /**
     * <P>Set Appendix contract ID. </P>
     *
     * @param appendixCid Appendix contract ID
     */
    public void setAppendixCid(Long appendixCid) {
        this.appendixCid = appendixCid;
    }
}
