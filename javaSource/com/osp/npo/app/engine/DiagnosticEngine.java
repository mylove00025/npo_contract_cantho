package com.osp.npo.app.engine;

import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.rpc.ServiceException;

import com.osp.npo.app.plugin.InitSystemPlugin;
import com.osp.npo.common.util.DBConnection;
import com.osp.npo.common.util.EditString;
import com.osp.npo.core.diagnostic.DiagnosticCommand;
import com.osp.npo.logger.NpoLogMessage;
import com.osp.npo.logger.NpoLogger;
import com.osp.npo.service.CommonService;
import com.osp.npo.service.DiagnosticService;
import com.osp.npo.ws.DiagnosticWsInfo;
import com.osp.npo.ws.NpoWS;
import com.osp.npo.ws.NpoWSServiceLocator;
import com.osp.npo.ws.WebserviceInfo;

/**
 * Diagnostic Engine
 * 
 * @author haint
 * @version $Revision: 29726 $
 */
public class DiagnosticEngine {
	static private DiagnosticEngine _instance;
	
	private boolean isRunning = false;
	
	/** Connection */
	private Connection connection = null;

	/** DB Connection */
	private DBConnection dbConnection = null;
	
    
	/** Logger */
	public static NpoLogger logger = (NpoLogger) NpoLogger
			.getLogger(DiagnosticEngine.class.getName());
	
	
	/**
	 * The constructor could be made private to prevent others from
	 * instantiating this class. But this would also make it impossible to
	 * create instances of Singleton subclasses.
	 */
	protected DiagnosticEngine() {
		// ...
	}

	/**
	 * @return The unique instance of this class.
	 */
	static public DiagnosticEngine instance() {
		if (null == _instance) {
			_instance = new DiagnosticEngine();
		}
		return _instance;
	}
	
	/**
	 * Process indexing for lucene search
	 */
	public void diagnostic() {
		if (isRunning) {
			return;
		}

		NpoLogMessage logMessage = new NpoLogMessage();
		logMessage.select("WEB9001");

		try {
			isRunning = true;

			/** Connect to DB */
			this.dbConnection = new DBConnection("jdbc/datasource");
			this.connection = dbConnection.openConnection();

			CommonService commonService = new CommonService(connection);
			String synchronizeUrl = commonService.querySystemConfigByKey("synchronize_webservice_url", Boolean.FALSE).getConfigValue();
			
			if (!EditString.isNull(synchronizeUrl)) {
				//Call web service synchronize database
				NpoWSServiceLocator service = new NpoWSServiceLocator();
	            NpoWS port = null;
	            
	            try {
	            	port = service.getNpoWSPort(new URL(synchronizeUrl));
	            } catch (ServiceException ex) {
	            	/** Write log */
	                logger.logging(logMessage, ex);
	            }
	            
	            if (port != null) {
	            	
	            	DiagnosticService dgService = new DiagnosticService(connection);
	            	
	            	List<DiagnosticWsInfo> diagnosticInfoList = new ArrayList<DiagnosticWsInfo>();
	            	
	            	DiagnosticWsInfo dwsInfo1 = new DiagnosticWsInfo();
	            	dwsInfo1.setCommandCode(DiagnosticCommand.SYNC_REMAIN_COUNT);
	            	dwsInfo1.setNumberResult(dgService.countSyncRemained());
	            	diagnosticInfoList.add(dwsInfo1);
	            	
	            	DiagnosticWsInfo dwsInfo2 = new DiagnosticWsInfo();
	            	dwsInfo2.setCommandCode(DiagnosticCommand.SYNC_ERR_COUNT);
	            	dwsInfo2.setNumberResult(dgService.countSyncError());
	            	diagnosticInfoList.add(dwsInfo2);
	            	
	            	DiagnosticWsInfo dwsInfo3 = new DiagnosticWsInfo();
	            	dwsInfo3.setCommandCode(DiagnosticCommand.OFFICE_DATA_PREVENT_COUNT);
	            	dwsInfo3.setNumberResult(dgService.countDataPreventByOffice(InitSystemPlugin.getAuthenticationId()));
	            	diagnosticInfoList.add(dwsInfo3);
	            	
	            	DiagnosticWsInfo dwsInfo4 = new DiagnosticWsInfo();
	            	dwsInfo4.setCommandCode(DiagnosticCommand.TOTAL_DATA_PREVENT_COUNT);
	            	dwsInfo4.setNumberResult(dgService.countTotalDataPrevent());
	            	diagnosticInfoList.add(dwsInfo4);
	            	
	            	DiagnosticWsInfo dwsInfo5 = new DiagnosticWsInfo();
	            	dwsInfo5.setCommandCode(DiagnosticCommand.OFFICE_TRANSACTION_COUNT);
	            	dwsInfo5.setNumberResult(dgService.countTransactionByOffice(InitSystemPlugin.getAuthenticationId()));
	            	diagnosticInfoList.add(dwsInfo5);
	            	
	            	DiagnosticWsInfo dwsInfo6 = new DiagnosticWsInfo();
	            	dwsInfo6.setCommandCode(DiagnosticCommand.TOTAL_TRANSACTION_COUNT);
	            	dwsInfo6.setNumberResult(dgService.countTotalTransaction());
	            	diagnosticInfoList.add(dwsInfo6);
	            	
	            	DiagnosticWsInfo dwsInfo7 = new DiagnosticWsInfo();
	            	dwsInfo7.setCommandCode(DiagnosticCommand.OFFICE_CONTRACT_COUNT);
	            	dwsInfo7.setNumberResult(dgService.countContract());
	            	diagnosticInfoList.add(dwsInfo7);
	            	
	            	DiagnosticWsInfo dwsInfo8 = new DiagnosticWsInfo();
	            	dwsInfo8.setCommandCode(DiagnosticCommand.DUPLIATE_CONTRACT_ID_COUNT);
	            	dwsInfo8.setNumberResult(dgService.countDuplicateContractId());
	            	diagnosticInfoList.add(dwsInfo8);
	            	
	            	DiagnosticWsInfo dwsInfo9 = new DiagnosticWsInfo();
	            	dwsInfo9.setCommandCode(DiagnosticCommand.DUPLIATE_SYNC_ID_COUNT);
	            	dwsInfo9.setNumberResult(dgService.countDuplicateSyncId());
	            	diagnosticInfoList.add(dwsInfo9);
	            	
	            	WebserviceInfo info = new WebserviceInfo();
                    info.setAuthenticationId(InitSystemPlugin.getAuthenticationId());
                    info.setAccount(commonService.querySystemConfigByKey("synchronize_account", Boolean.FALSE).getConfigValue());
                    info.setPassword(commonService.querySystemConfigByKey("synchronize_password", Boolean.FALSE).getConfigValue());
                    info.setDiagnosticInfoList(diagnosticInfoList.toArray(new DiagnosticWsInfo[diagnosticInfoList.size()]));
                    
                    port.checkData(info);
	            }
			}

        } catch (SQLException sqlError) {
            /** Write log */
            logger.logging(logMessage, sqlError);

        } catch (Exception exception) {
        	/** Write log */
            logger.logging(logMessage, exception);

        } finally {

            try {
                if (connection != null && !connection.isClosed() && !connection.getAutoCommit()) {
                    /** Rollback connection */
                    connection.rollback();
                }
            } catch (Exception ex) {
                logger.logging(logMessage, ex);
            } finally {
                try {
                    if (connection != null) {
                        /** Close connection */
                        connection.close();
                    }
                } catch (Exception ex) {
                    //Nothing
                }
            }
            
            isRunning = false;
        }

	}
}
