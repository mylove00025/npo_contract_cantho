package com.osp.npo.app.action;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.actions.MappingDispatchAction;

import com.osp.npo.app.context.CommonContext;
import com.osp.npo.common.util.DBConnection;
import com.osp.npo.common.util.SystemMessageProperties;
import com.osp.npo.common.util.SystemProperties;
import com.osp.npo.core.AbstractInfo;
import com.osp.npo.logger.NpoLogMessage;
import com.osp.npo.logger.NpoLogger;


/**
 * <p>
 * MappingDispatchAction class
 * </p>
 * 
 * @author Nguyen Thanh Hai
 * @version $Revision: 30478 $
 */
public class BaseMDAction extends MappingDispatchAction {

	
	private static final String PROPERTY_SEPERATE_CHAR = ",";
	private static final String SPACE = " ";
	private static final String PARENTHESIS_OPEN = "(";
	private static final String PARENTHESIS_CLOSE = ")";
	
	private static final String AUTHORITY_CHECK_KEY         = "authority_check";
	private static final String AUTHORITY_CONTRACT_KEY 	    = "authority_01";
	private static final String AUTHORITY_PREVENT_DATA_KEY 	= "authority_02";
	private static final String AUTHORITY_BANK_REPORT_KEY 	= "authority_03";
	private static final String AUTHORITY_ADMIN_KEY         = "authority_04";
	private static final String AUTHORITY_ANNOUNCEMENT_KEY  = "authority_05";
	private static final String AUTHORITY_CNTR_DEL			= "authority_11";
	private static final String AUTHORITY_PRV_DEL           = "authority_12";
	private static final String AUTHORITY_VIEW_REPORT       = "authority_13";	
	private static final String AUTHORITY_TEMP_CONTRACT     = "authority_14";
	private static final String AUTHORITY_TEMP_CNTR_DEL     = "authority_15";
	
	
	
	private static final int MAX_LINE_DEFAULT = 20;
	private static final String MAX_LINE_KEY  = "record_per_page";
	
	private static final String TRUE_VALUE  = "true";
	private static final String AJAX_PATH  = "/ajax";
	

    /** Connection */
    private Connection connection = null;


    /** DB Connection */
    private DBConnection dbConnection = null;


    /** Stores process data result */
    private int result = 0;
    
    /** Common Context */
    private CommonContext context;

    /** Logger */
    public static NpoLogger logger = (NpoLogger)NpoLogger.getLogger(
            BaseMDAction.class.getName());
    
    /**
     * Basic execute method
     * 
     * @param mapping
     * @param form
     * @param req
     * @param res
     * @return
     * @throws ServletException
     */
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, SQLException, Exception {
    	
    	String path = mapping.getPath();
    	
    	context = (CommonContext) request.getSession().getAttribute(CommonContext.SESSION_KEY);
    	if (isCheckTimeout(path) && context == null && path.indexOf("/login") < 0) {
            return mapping.findForward("nologin");
        }
    	
    	
    	//Comment by HaiNT 2011-01-10
//    	//Check trial
//    	if (!NpoTrial.checkTrial(Calendar.getInstance())) {
//    		return mapping.findForward("trial");
//    	}

    	
    	//Check authority
    	if (context != null && !checkAuthority(path, context)) {
    		ActionErrors errors = new ActionErrors();
    		errors.add("", new ActionMessage("err_access_deny"));
    		saveErrors(request, errors);
    		
    		return mapping.findForward("commonerror");
    	}
    	
        // ActionForward actionForward = (mapping.findForward("error"));
        ActionForward actionForward = (mapping.findForward("success"));

        NpoLogMessage logMessage = new NpoLogMessage(request);

        /** write log config */
        logMessage.select("WEB0001");
        logger.logging(logMessage);
        
        try {
            /** Connect to DB */
            this.dbConnection = new DBConnection("jdbc/datasource");
            this.connection = dbConnection.openConnection();
            
            //Comment by HaiNT 2011-01-10
//            if (context != null && context.isDemoSystem() && !NpoDemo.checkDemoSystem(this, request, path)) {
//                return mapping.findForward("demo");
//            }
            
            actionForward = super.execute(mapping, form, request, response);           

        } catch (SQLException sqlError) {
            /** write log */
            logWrite(sqlError, logMessage);
            if (!response.isCommitted()) {
                throw sqlError;
            }
        } catch (Exception exception) {
            /** write log */
            logWrite(exception, logMessage);
            if (!response.isCommitted()) {
                throw exception;
            }
        } finally {
            
            try {
                if (connection != null && !connection.isClosed() && !connection.getAutoCommit()) {
                    /** Process rollback */
                	
                	if (!path.startsWith(AJAX_PATH)) {
                		connection.rollback();
                	}
                }
            } catch (Exception ex) {
                // write log
                logWrite(ex, logMessage);
                if (!response.isCommitted()) {
                    throw ex;
                }
            } finally {
                try {
                    if (connection != null && !connection.isClosed()) {
                        /** Close connection */
                        connection.close();
                    }
                } catch (Exception ex) {
                    //Nothing
                }
            }
        }

        return (actionForward);
    }


    /**
     * <P>
     * Get connection
     * </P>
     * 
     * @return connection
     */
    public Connection getConnection() {
        return this.connection;
    }


    /**
     * <P>
     * Get process data result
     * </P>
     * 
     * @param result
     *            process data result
     */
    public void setResult(int result) {
        this.result = result;
    }


    /**
     * <P>
     * Get process data result
     * </P>
     * 
     * @return result process data result
     */
    public int getResult() {
        return this.result;
    }


    /**
     * <P>
     * Operate page transition
     * </P>
     * 
     * @param direction
     *            page transition direction
     * @param page
     *            current page
     * @param totalPage
     *            total page
     * @return page number
     */
    public int pageTransition(String direction, int page, int totalPage) {

    	if (direction == null) {
    		direction = "";
    	}
    	
        if (direction.equalsIgnoreCase("first")) {
            page = 1;
        } else if (direction.equalsIgnoreCase("ahead")) {
            if (1 > (page - 1)) {
                page = totalPage;
            } else {
                --page;
            }
        } else if (direction.equalsIgnoreCase("next")) {
            if (totalPage < (page + 1)) {
                page = 1;
            } else {
                ++page;
            }
        } else if (direction.equalsIgnoreCase("end")) {
            page = totalPage;
        } else {
            if (page > totalPage) {
                page = totalPage;
            }
        }

        return page;
    }


    /**
     * <P>
     * Calculate total number of page
     * </P>
     * 
     * @param totalCount
     *            total number of record
     * @param lineMax
     *            number of record diplay in a page
     * @return total number of paga
     */
    public int pageCalculation(int totalCount, int lineMax) {

        int totalPage = totalCount / lineMax;

        if (0 < (totalCount % lineMax)) {
            ++totalPage;
        }

        return totalPage;
    }
    
    
    /**
     * Get max line of page
     * 
     * @return max line
     */
    public int getLineMax() {
    	if (context != null) {
    		String maxLine = context.getSystemConfigValue(MAX_LINE_KEY);
    		try {
    			return Integer.parseInt(maxLine);
    		} catch (NumberFormatException nfe) {
    		    nfe.printStackTrace();
    		}
    	}
    	
    	return MAX_LINE_DEFAULT;
    }

    
    /**
     * <P>Write log when exception occur</P>
     * 
     * @param Exception Exception
     */
    public void logWrite(Exception ex, NpoLogMessage logMessage) {

        /** Log setting */
        Object[] values = {
            ex.getClass().getName(),
            ex.getMessage(),
            ex.getStackTrace()[0] };

       logMessage.select("WEB9001", values);
       logger.logging(logMessage, ex);
    }
    
    
    /**
     * Create screen title
     * 
     * @param sreenId
     */
    public void createTitle(String screenId) {
        String screenTitle = SystemMessageProperties.getSystemProperty(screenId);
        
        if (context != null) {
            context.setScreenId(screenId);
            context.setScreenTitle(screenTitle);
            if (screenId != null && !screenId.isEmpty()) {
                context.setSubMenu(screenId.substring(0, 3));
            }
        }
    }

    /**
     * Create entry user information
     * 
     * @param info
     */
    public void createEntryUserInfo(AbstractInfo info) {
    	/* Entry user */
    	info.setEntryUserId(context.getUserInfo().getId());
    	info.setEntryUserName(context.getUserInfo().getFamilyName() + SPACE + context.getUserInfo().getFirstName() + SPACE
    			+ PARENTHESIS_OPEN + context.getUserInfo().getAccount() + PARENTHESIS_CLOSE);
    	info.setEntryDateTime(new Timestamp(Calendar.getInstance().getTimeInMillis()));
    	
    	/* Update user */
    	info.setUpdateUserId(context.getUserInfo().getId());
    	info.setUpdateUserName(context.getUserInfo().getFamilyName() + SPACE + context.getUserInfo().getFirstName() + SPACE
    			+ PARENTHESIS_OPEN + context.getUserInfo().getAccount() + PARENTHESIS_CLOSE);
    	info.setUpdateDateTime(new Timestamp(Calendar.getInstance().getTimeInMillis()));
    }
    
    /**
     * Create update user information
     * 
     * @param info
     */
    public void createUpdateUserInfo(AbstractInfo info) {
    	/* Update user */
    	info.setUpdateUserId(context.getUserInfo().getId());
    	info.setUpdateUserName(context.getUserInfo().getFamilyName() + SPACE + context.getUserInfo().getFirstName() + SPACE
    			+ PARENTHESIS_OPEN + context.getUserInfo().getAccount() + PARENTHESIS_CLOSE);
    	info.setUpdateDateTime(new Timestamp(Calendar.getInstance().getTimeInMillis()));
    }
    
    /**
     * Save errors
     * 
     * @param request
     * @param errors
     */
    public void saveNpoErrors(HttpServletRequest request, ActionErrors errors) {
        saveErrors(request, errors);
    }
    
    /**
     * Get client information from request
     * 
     * @param request
     * @return client information
     */
    public String getClientInfo(HttpServletRequest request) {
    	String clientInfo = request.getRemoteAddr() + " [" + request.getSession().getId() + "]";
    	return clientInfo;
    }
    
    /**
     * Kiem tra quyen truy cap path tuong ung
     * 
     * @param path Path truy cap
     * @param context CommonContext
     * @return true neu duoc phep truy cap, false neu khong duoc phep truy cap
     */
    private boolean checkAuthority(String path, CommonContext context) {
    	
    	// Kiem tra xem co check authority hay khong
    	if (!TRUE_VALUE.equalsIgnoreCase(SystemProperties.getProperty(AUTHORITY_CHECK_KEY))) {
    		return true;
    	}
    	
    	// Kiem tra quyen hop dong
    	if (checkPathExist(path, AUTHORITY_CONTRACT_KEY) && !context.isContractManagement()) {
    		return false;
    	}
    	
    	// Kiem tra quyen tao moi du lieu ngan chan
    	if (checkPathExist(path, AUTHORITY_PREVENT_DATA_KEY) && !context.isPreventData()) {
    		return false;
    	}
    	
    	// Kiem tra quyen bao cao ngan hang
    	if (checkPathExist(path, AUTHORITY_BANK_REPORT_KEY) && !context.isBankReport()) {
    		return false;
    	}
    	
    	// Kiem tra quyen quan tri he thong
    	if (checkPathExist(path, AUTHORITY_ADMIN_KEY) && !context.isAdmin()) {
    		return false;
    	}
    	
    	// Kiem tra quyen quan tri thong bao
        if (checkPathExist(path, AUTHORITY_ANNOUNCEMENT_KEY) && !context.isAnnouncementManagement()) {
            return false;
        }
        
        // Kiem tra quyen xoa hop dong
        if (checkPathExist(path, AUTHORITY_CNTR_DEL) && !context.isContractDelete()) {
            return false;
        }
        
        // Kiem tra quyen xoa du lieu ngan chan
        if (checkPathExist(path, AUTHORITY_PRV_DEL) && !context.isPreventDataDelete()) {
            return false;
        }
        
        // Kiem tra quyen xem bao cao
        if (checkPathExist(path, AUTHORITY_VIEW_REPORT) && !context.isViewContractReport()) {
            return false;
        }
        
        // Kiem tra quyen hop dong cho ky
        if (checkPathExist(path, AUTHORITY_TEMP_CONTRACT) && !context.isTemporaryContractManagement()) {
            return false;
        }
        
        // Kiem tra quyen xoa du lieu ngan chan
        if (checkPathExist(path, AUTHORITY_TEMP_CNTR_DEL) && !context.isTemporaryContractDelete()) {
            return false;
        }
    	
    	return true;
    }
    
    
    /**
     * Kiem tra path co thuoc quyen tuong ung hay khong
     * 
     * @param path Path nhap vao
     * @param key Key tuong ung trong file system.properties
     * @return true neu ton tai, false neu khong ton tai
     */
    private boolean checkPathExist(String path, String key) {
    	String[] arrPaths = SystemProperties.getProperty(key).split(PROPERTY_SEPERATE_CHAR);
    	for (String item : arrPaths) {
			if (path.equals(item.trim())) {
				return true;
			}
		}
    	
    	return false;
    }
    
    /**
     * <p>Get check timeout flag</p>
     * 
     * @param path
     * @return true: check; false: notcheck
     */
    private boolean isCheckTimeout(String path) {
        if (path.startsWith(AJAX_PATH)) {
            return false;
        }
        
        return true;
    }
}
