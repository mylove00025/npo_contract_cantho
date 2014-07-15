package com.osp.npo.app.listener;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.osp.npo.app.action.BaseMDAction;
import com.osp.npo.app.context.CommonContext;
import com.osp.npo.common.util.DBConnection;
import com.osp.npo.core.accessHistory.AccessHistoryInfo;
import com.osp.npo.core.user.UserInfo;
import com.osp.npo.logger.NpoLogMessage;
import com.osp.npo.logger.NpoLogger;
import com.osp.npo.service.AccessHistoryService;

/**
 * Session listener
 * 
 * @author haint
 */
public class SessionListener implements HttpSessionListener {

	/** Logger */
    public static NpoLogger logger = (NpoLogger)NpoLogger.getLogger(
            BaseMDAction.class.getName());
    
	@Override
	public void sessionCreated(HttpSessionEvent event) {

	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		
		CommonContext ctx = (CommonContext) event.getSession().getAttribute(CommonContext.SESSION_KEY);
		if (ctx != null && ctx.getUserInfo()!= null) {
			UserInfo userInfo = ctx.getUserInfo();
			
			NpoLogMessage logMessage = new NpoLogMessage();
			
			Connection connection = null;
			try {
	            /** Connect to DB */
				DBConnection dbConnection = new DBConnection("jdbc/datasource");
				connection = dbConnection.openConnection();
	            
				//Access history
				AccessHistoryService accessHistoryService = new AccessHistoryService(connection);
				AccessHistoryInfo accessHistoryInfo = new AccessHistoryInfo();
				
				accessHistoryInfo.setUsid(userInfo.getId());
				accessHistoryInfo.setExecutePerson(userInfo.getFullName()+" ("+userInfo.getAccount()+")");
				accessHistoryInfo.setAccessType((byte) 1);
				accessHistoryInfo.setExecuteDateTime(new Timestamp(Calendar.getInstance().getTimeInMillis()));
				accessHistoryInfo.setClientInfo(ctx.getClientInfo());
				accessHistoryService.entryAccessHistory(accessHistoryInfo);
				connection.commit();
			
			} catch (SQLException sqlError) {
	            /** write log */
	            logWrite(sqlError, logMessage);
	        } catch (Exception exception) {
	            /** write log */
	            logWrite(exception, logMessage);
	        } finally {
	            
	            try {
	                if (connection != null && !connection.isClosed() && !connection.getAutoCommit()) {
	                    /** Process rollback */
	                    connection.rollback();
	                }
	            } catch (Exception ex) {
	                // write log
	                logWrite(ex, logMessage);
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
		}
		
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
}
