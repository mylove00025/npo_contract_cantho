package com.osp.npo.app.task;

import java.util.TimerTask;

import com.osp.npo.app.engine.SynchronizeDBEngine;
import com.osp.npo.logger.NpoLogMessage;
import com.osp.npo.logger.NpoLogger;

/**
 * Expired prevent data auto update timer task class
 * 
 * @author HaiNT
 * @version $Revision: 16984 $
 */
public class SynchronizeDBTask extends TimerTask {

	/** Logger */
    public static NpoLogger logger = (NpoLogger) NpoLogger
    	.getLogger(SynchronizeDBTask.class.getName());
    
	@Override
	public void run() {
		NpoLogMessage logMsg = new NpoLogMessage();
        logMsg.select("WEB2001",
                new Object[] {SynchronizeDBTask.class.getName()});
        logger.logging(logMsg);

        try {

        	SynchronizeDBEngine engine = SynchronizeDBEngine.instance();
        	engine.synchronizeData();

        } catch (Exception ex) {
            logWrite(ex, logMsg);
        }

        logMsg.select("WEB2002",
                new Object[] {SynchronizeDBTask.class.getName()});
        logger.logging(logMsg);
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
