package com.osp.npo.app.plugin;

import java.sql.Connection;
import java.sql.Date;
import java.util.Calendar;
import java.util.Map;
import java.util.Timer;

import javax.servlet.ServletException;

import org.apache.struts.action.ActionServlet;
import org.apache.struts.action.PlugIn;
import org.apache.struts.config.ModuleConfig;
import org.apache.struts.config.PlugInConfig;

import com.osp.npo.app.task.DiagnosticTask;
import com.osp.npo.app.task.LuceneIndexTask;
import com.osp.npo.app.task.LuceneOptimizeTask;
import com.osp.npo.app.task.SynchronizeDBTask;
import com.osp.npo.common.demo.NpoTrial;
import com.osp.npo.common.exception.CopyrightException;
import com.osp.npo.common.util.CopyrightUtil;
import com.osp.npo.common.util.DBConnection;
import com.osp.npo.common.util.EditString;
import com.osp.npo.common.util.FileUtil;
import com.osp.npo.core.common.SystemConfigInfo;
import com.osp.npo.logger.NpoLogMessage;
import com.osp.npo.logger.NpoLogger;
import com.osp.npo.service.CommonService;


/**
 * InitSystemPlugin class
 * 
 * @version $Revision: 29785 $
 */
public class InitSystemPlugin implements PlugIn {

	private static final String INIT_TIME = "init.time";
	private static final String COPYRIGHT_CUSTOMER_ID = "copyright.customer.id";
	private static final String COPYRIGHT_KEY = "copyright.key";
	private static final String LUCENE_INDEXING_PERIOD = "lucene.index.period";
	
	private static String authenticationId;
	private static String authenticationCode;

    private Timer timer;
    private Timer timer2;
    private Timer timer3;
    private Timer timer4;
    
    /** Connection */
    private Connection connection = null;

    /** DB Connection */
    private DBConnection dbConnection = null;

    public static NpoLogger logger = (NpoLogger) NpoLogger
            .getLogger(InitSystemPlugin.class.getName());



    public void destroy() {

        if (timer != null) {
            timer.cancel();
        }
        
        if (timer2 != null) {
        	timer2.cancel();
        }
        
        if (timer3 != null) {
        	timer3.cancel();
        }
        
        if (timer4 != null) {
        	timer4.cancel();
        }
    }



    public void init(ActionServlet servlet, ModuleConfig config)
            throws ServletException {

        try {

        	initNpoSystem(config);
        	
        } catch (CopyrightException ex) {
        	throw new ServletException(ex);
        } catch (Exception ex) {
            NpoLogMessage logMessage = new NpoLogMessage();
            logWrite(ex, logMessage);
        } finally {
        	//Delete log files
        	FileUtil.deleteLogFile();
        }
    }
    

    /**
	 * Get authenticationId
	 * @return the authenticationId
	 */
	public static String getAuthenticationId() {
		return authenticationId;
	}


	/**
	 * Get authenticationCode
	 * @return the authenticationCode
	 */
	public static String getAuthenticationCode() {
		return authenticationCode;
	}


	/**
     * 
     * @param config
     * @throws Exception
     */
    private void initNpoSystem(ModuleConfig config) throws CopyrightException, Exception {


        /* Duration is 60 seconds */
        long synchronizePeriod = 60 * 1000;
        
        //Copyright
        String customerID = "";
        String copyrightKey = "";
        
        String initTime = "";
        
        /* Lucene indexing period: 5 seconds */
        long indexPeriod = 5 * 1000;
        
        /* Get parameter from config file */
        PlugInConfig[] plugInConfigs = config.findPlugInConfigs();
        for (int i = 0; i < plugInConfigs.length; i++) {
            if (plugInConfigs[i].getClassName().equals(
                    this.getClass().getName())) {
				@SuppressWarnings("unchecked")
				Map<String, String> props = plugInConfigs[i].getProperties();
                try {
                	if (props.containsKey(INIT_TIME)) {
                		initTime = props.get(INIT_TIME);
                    }
                	
                    if (props.containsKey(COPYRIGHT_CUSTOMER_ID)) {
                        customerID = props.get(COPYRIGHT_CUSTOMER_ID);
                    }
                    
                    if (props.containsKey(COPYRIGHT_KEY)) {
                    	copyrightKey = props.get(COPYRIGHT_KEY);
                    }
                    
                    if (props.containsKey(LUCENE_INDEXING_PERIOD)) {
                    	try {
                    		indexPeriod = Long.parseLong(props.get(LUCENE_INDEXING_PERIOD)) * 1000;
                    	} finally {};
                    }
                    
                } catch (Exception ex) {
                	throw new CopyrightException("Cannot read copyright key.");
                }
            }
        }
        
        //Comment by HaiNT 2011-01-10
//        if (customerID != null && customerID.length() == 10) {
//        	NpoTrial.IS_TRIAL = Boolean.FALSE;
//        } else {
//        	NpoTrial.IS_TRIAL = Boolean.TRUE;
//        	NpoTrial.START_DATE.setTimeInMillis(Long.parseLong(customerID));
//        }
        
        if (NpoTrial.IS_TRIAL) {
        	if (initTime != null && !"".equals(initTime)) {
        		NpoTrial.START_DATE.setTimeInMillis(Long.parseLong(initTime));
        		
        		//Check trial time
        		if (!NpoTrial.checkTrial(Calendar.getInstance())) {
        			throw new CopyrightException("Trial time expired.");
        		}
        	} else {
        		throw new CopyrightException("Trial version request init time.");
        	}
        }
        
        //Authenticate Copyright
        if (!CopyrightUtil.authenticate(customerID, copyrightKey)) {
        	throw new CopyrightException("Copyright is not valid.");
        }
        
        authenticationId = customerID;
        authenticationCode = copyrightKey;

        SynchronizeDBTask synchronizeDBTask = new SynchronizeDBTask();
        
        timer = new Timer();
        
        Calendar cal = Calendar.getInstance();
        Date firstTime = new Date(cal.getTimeInMillis());
        
        /** Connect to DB */
        this.dbConnection = new DBConnection("jdbc/datasource");
        this.connection = dbConnection.openConnection();
        
        CommonService commonService = new CommonService(connection);
        
        String synPeriod = "";
        SystemConfigInfo systemConfigInfo = commonService.querySystemConfigByKey("synchronize_period", Boolean.FALSE);
        if (systemConfigInfo != null) {
            synPeriod = commonService.querySystemConfigByKey("synchronize_period", Boolean.FALSE).getConfigValue();
        }
        
        if (!EditString.isNull(synPeriod) && EditString.isNumber(synPeriod)) {
            long synPeriodVal = Long.parseLong(synPeriod) * 1000;
            if (synPeriodVal > 0) {
                synchronizePeriod = synPeriodVal;
            }
            
        }
        timer.schedule(synchronizeDBTask, firstTime, synchronizePeriod);
        
        synchronized (synchronizeDBTask) {
            synchronizeDBTask.wait(1000);
        }
        
        timer2 = new Timer();
        LuceneIndexTask luceneIndexTask = new LuceneIndexTask();
        timer2.schedule(luceneIndexTask, firstTime, indexPeriod);

        synchronized (luceneIndexTask) {
        	luceneIndexTask.wait(1000);
        }
        
        timer3 = new Timer();
        cal.set(Calendar.HOUR_OF_DAY, 12);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        Date firstTimeOptimize = new Date(cal.getTimeInMillis());
        
        LuceneOptimizeTask luceneOptimizeTask = new LuceneOptimizeTask();
        timer3.schedule(luceneOptimizeTask, firstTimeOptimize, 86400000);

        synchronized (luceneOptimizeTask) {
        	luceneOptimizeTask.wait(1000);
        }
        
        timer4 = new Timer();
        cal.set(Calendar.HOUR_OF_DAY, 12);
        cal.set(Calendar.MINUTE, 30);
        cal.set(Calendar.SECOND, 0);
        Date firstTimeDiagnostic = new Date(cal.getTimeInMillis());
        
        DiagnosticTask diagnosticTask = new DiagnosticTask();
        timer4.schedule(diagnosticTask, firstTimeDiagnostic, 86400000);

        synchronized (diagnosticTask) {
        	diagnosticTask.wait(1000);
        }
    }


    /**
     * 
     * @param Exception Exception
     */
    private void logWrite(Exception ex, NpoLogMessage logMessage) {

        Object[] values = {ex.getClass().getName(), ex.getMessage(),
                ex.getStackTrace()[0]};

        logMessage.select("WEB9001", values);
        logger.logging(logMessage, ex);
    }
}
