package com.osp.npo.app.task;

import java.util.TimerTask;

import com.osp.npo.app.engine.LuceneEngine;
import com.osp.npo.logger.NpoLogMessage;
import com.osp.npo.logger.NpoLogger;

/**
 * Expired prevent data auto update timer task class
 * 
 * @author HaiNT
 * @version $Revision: 16984 $
 */
public class LuceneOptimizeTask extends TimerTask {

	/** Logger */
    public static NpoLogger logger = (NpoLogger) NpoLogger
    	.getLogger(LuceneOptimizeTask.class.getName());
    
	@Override
	public void run() {
		NpoLogMessage logMsg = new NpoLogMessage();

        try {
        	logMsg.select("WEB2001",
                    new Object[] {LuceneOptimizeTask.class.getName()});
            logger.logging(logMsg);
        	
        	LuceneEngine engine = LuceneEngine.instance();
        	engine.processOptimizing();

        	logMsg.select("WEB2002",
                    new Object[] {LuceneOptimizeTask.class.getName()});
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
