package com.osp.npo.app.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.osp.npo.app.message.MessageUtil;

/**
 * Login Form
 *
 * @author HungPT
 * @version $Revision$  
 */
public class LoginForm extends ActionForm {
	
    private static final long serialVersionUID = -3918011908868755113L;
    private String userName = null;
	private String password = null;

	/**
	 * @return the userName
	 */
	public String getUserName() {
		if (userName != null) {
			userName = userName.trim();
		}
		return userName;
	}

	/**
	 * @param userName
	 *            the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		if (password != null) {
			password = password.trim();
		}
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.struts.action.ActionForm#validate(org.apache.struts.action.ActionMapping,
	 *      javax.servlet.http.HttpServletRequest)
	 */
	@Override
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		// TODO Auto-generated method stub
		Boolean result = true;
		ActionErrors errors = new ActionErrors();
				
		// user name and password are all empty 
		if (result 
				&& (getPassword() == null || getPassword().length() == 0) 
				&& (getUserName() == null || getUserName().length() == 0)) {
			result = false;
			errors.add(new MessageUtil()
				.createActionMessages("", "COM001_not_input_username_and_password"));			
		}
		// password is empty
		if (result 
				&& (getPassword() == null || getPassword().length() == 0)) {
			result = false;
			errors.add(new MessageUtil()
				.createActionMessages("", "COM001_not_input_password"));
		}
		// user name is empty
		if (result 
				&& (getUserName() == null || getUserName().length() == 0)) {
			result = false;
			errors.add(new MessageUtil()
				.createActionMessages("", "COM001_not_input_username"));
		}
		return errors;
	}
}
