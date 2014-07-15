package com.osp.npo.app.viewhelper;


/**
 * <P>Temporary Contract View Helper</P>
 * 
 * @author SonHD 
 * @version $Revision: 23797 $
 */
public class TemporaryContractCommentEditViewHelper {
    
    public static final String SESSION_KEY = "temporaryContractCommentEditViewHelper";

    private Long ccid;
    private String comment;
    
	public Long getCcid() {
		return ccid;
	}
	public void setCcid(Long ccid) {
		this.ccid = ccid;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
    
}
