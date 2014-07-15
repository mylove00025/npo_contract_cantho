package com.osp.npo.core.user;


import com.osp.npo.core.AbstractInfo;


/**
 * Generate by script
 * Generate date: 10/14/2010 11:03:35 AM
 * @version $Revision: 17060 $
 */
public class UserAuthorityInfo extends AbstractInfo {


    /** id ng??i dung */
    private Long userId;

    /** id quy?n c?a ng??i dung */
    private String authorityCode;


    /**
     * <P>Generate Instance.</P>
     *
     */
    public UserAuthorityInfo() {
        super();
    }


    /**
     * <P>Get id ng??i dung </P>
     *
     * @return id ng??i dung
     */
    public Long getUserId() {
        return this.userId;
    }

    /**
     * <P>Set id ng??i dung. </P>
     *
     * @param userId id ng??i dung
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * <P>Get id quy?n c?a ng??i dung </P>
     *
     * @return id quy?n c?a ng??i dung
     */
    public String getAuthorityCode() {
        return this.authorityCode;
    }

    /**
     * <P>Set id quy?n c?a ng??i dung. </P>
     *
     * @param authorityCode id quy?n c?a ng??i dung
     */
    public void setAuthorityCode(String authorityCode) {
        this.authorityCode = authorityCode;
    }
}
