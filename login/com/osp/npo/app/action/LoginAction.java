package com.osp.npo.app.action;

import java.sql.Timestamp;
import java.util.Calendar;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.osp.npo.app.context.CommonContext;
import com.osp.npo.app.form.LoginForm;
import com.osp.npo.common.global.Constants.FilterKind;
import com.osp.npo.common.util.Crypter;
import com.osp.npo.core.accessHistory.AccessHistoryInfo;
import com.osp.npo.core.user.UserAuthorityList;
import com.osp.npo.core.user.UserInfo;
import com.osp.npo.core.user.UserList;
import com.osp.npo.service.AccessHistoryService;
import com.osp.npo.service.CommonService;
import com.osp.npo.service.UserService;


/**
 * Login Action
 *
 * @author HungPT
 * @version $Revision$
 */
public class LoginAction extends BaseMDAction {
	
    private static final String SUCCESS = "success";
    private static final String JSESSIONID = "JSESSIONID";
    private String forwardName = null;

	/**
	 * Action when login
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward login(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Boolean success = true;
		forwardName = SUCCESS;
		
		// get user input data: user name and password 		 		
		LoginForm loginForm = (LoginForm) form;
		String userName = loginForm.getUserName();
		String password = loginForm.getPassword();
		// set cookie to response
		HttpSession session = request.getSession();
		Cookie cookie = new Cookie(JSESSIONID, session.getId());
		response.addCookie(cookie);
		// get instance of UserService 
		UserService userService = new UserService(getConnection());
		// set filter 
		userService.setAccountIdFilter(userName, FilterKind.FULL);
		userService.setActiveFlgFilter(Boolean.TRUE);
		// get list user, after set filter
		UserList list = userService.queryAllUser(false);
		// check size of list user, one user is expected value
		UserInfo userInfo = null;
		if (list.size() != 1) {
			success = false;
		} else {
			userInfo = list.get(0);
			if (!Crypter.matches(userInfo.getPassword(), password)) {
				success = false;
			}
		}
		
		if (success) {
			
			// common context, that stores user information 
			CommonContext commonContext = new CommonContext();
			commonContext.setUserInfo(userInfo);
			// query authority by user ID
			UserAuthorityList authorityList = new UserAuthorityList();
			authorityList = userService.queryUserAuthorityByUsid(false, userInfo.getId());
			// save user authority in common context
			for (int i = 0; i < authorityList.size(); i++) {
				commonContext.getAuthorityList().add(authorityList.get(i));
			}
			
			if (session.getAttribute(CommonContext.SESSION_KEY) != null) {
				session.removeAttribute(CommonContext.SESSION_KEY);
			}
			
			CommonService cs = new CommonService(getConnection());
			commonContext.setSystemConfigList(cs.queryAllSystemConfig(false));
			
			session.setAttribute(CommonContext.SESSION_KEY, commonContext);
			
			userInfo.setLastLoginDate(new Timestamp(Calendar.getInstance().getTimeInMillis()));
            userService.modifyUser(userInfo);
            
            //Access history
			AccessHistoryService accessHistoryService = new AccessHistoryService(getConnection());
			AccessHistoryInfo accessHistoryInfo = new AccessHistoryInfo();
			
			accessHistoryInfo.setUsid(userInfo.getId());
			accessHistoryInfo.setExecutePerson(userInfo.getFullName()+" ("+userInfo.getAccount()+")");
			accessHistoryInfo.setAccessType((byte) 0);
			accessHistoryInfo.setExecuteDateTime(userInfo.getLastLoginDate());
			accessHistoryInfo.setClientInfo(this.getClientInfo(request));
			accessHistoryService.entryAccessHistory(accessHistoryInfo);
			
			commonContext.setClientInfo(this.getClientInfo(request));
            
            getConnection().commit();
			
			return mapping.findForward(forwardName); 
		} else {
			// save error message to request
			ActionMessage actionMessage = new ActionMessage("COM001_not_wrong_username_password");
			ActionMessages msgs = new ActionMessages();
			msgs.add(ActionMessages.GLOBAL_MESSAGE, actionMessage);
			saveMessages(request, msgs);
			return mapping.getInputForward();
		}		
	}
    
	/**
	 * Action when logout
	 * 
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward logout(ActionMapping mapping, ActionForm form, 
            HttpServletRequest request, HttpServletResponse response) throws Exception {
		
        request.getSession().invalidate();
        
        return mapping.findForward(SUCCESS);
    }
}
