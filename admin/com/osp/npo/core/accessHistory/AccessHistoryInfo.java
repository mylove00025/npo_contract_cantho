package com.osp.npo.core.accessHistory;


import com.osp.npo.common.util.SystemMessageProperties;
import com.osp.npo.core.AbstractInfo;
import java.sql.Timestamp;


/**
 * Generate by script
 * Generate date: 06/24/2011 8:55:45 AM
 * @version $Revision$ 
 */
public class AccessHistoryInfo extends AbstractInfo {


    /** History ID */
    private Long hid;

    /** User ID */
    private Long usid;

    /** Execute person */
    private String executePerson;

    /** Client machine information */
    private String clientInfo;

    /** Execute date time */
    private Timestamp executeDateTime;

    /** Access type:
 */
    private Byte accessType;
    
    /** Access type:
     */
    private String type;
    
    private static final String LOGIN = "login";
    private static final String LOGOUT = "logout";



    /**
     * <P>Generate Instance.</P>
     *
     */
    public AccessHistoryInfo() {
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
     * <P>Get User ID </P>
     *
     * @return User ID
     */
    public Long getUsid() {
        return this.usid;
    }

    /**
     * <P>Set User ID. </P>
     *
     * @param usid User ID
     */
    public void setUsid(Long usid) {
        this.usid = usid;
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
     * <P>Get Access type:
 </P>
     *
     * @return Access type:

     */
    public Byte getAccessType() {
        return this.accessType;
    }

    /**
     * <P>Set Access type:
. </P>
     *
     * @param accessType Access type:

     */
    public void setAccessType(Byte accessType) {
        this.accessType = accessType;
    }
    
    public void setType() {
    	if (this.accessType==0){
    		this.type = SystemMessageProperties.getSystemProperty(LOGIN);
    	}
    	else{
    		this.type = SystemMessageProperties.getSystemProperty(LOGOUT);
    	}
    }


	public void setType(String type) {
		this.type = type;
	}


	public String getType() {
		return type;
	}
    
}
