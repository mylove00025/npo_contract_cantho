package com.osp.npo.app.task;

import java.util.TimerTask;

import com.osp.npo.app.engine.DiagnosticEngine;
import com.osp.npo.logger.NpoLogMessage;
import com.osp.npo.logger.NpoLogger;

/**
 * Expired prevent data auto update timer task class
 * 
 * @author HaiNT
 * @version $Revision: 16984 $
 */
public class DiagnosticTask extends TimerTask {

	/** Logger */
    public static NpoLogger logger = (NpoLogger) NpoLogger
    	.getLogger(DiagnosticTask.class.getName());
    
	@Override
	public void run() {
		NpoLogMessage logMsg = new NpoLogMessage();

        try {
        	logMsg.select("WEB2001",
                    new Object[] {DiagnosticTask.class.getName()});
            logger.logging(logMsg);
        	
        	DiagnosticEngine engine = DiagnosticEngine.instance();
        	engine.diagnostic();

        	logMsg.select("WEB2002",
                    new Object[] {DiagnosticTask.class.getName()});
            logger.logging(logMsg);
        } catch (Exception ex) {
            logWrite(ex, logMsg);
        }

    }


    /**
     * <P>Exception Write log</P>
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
