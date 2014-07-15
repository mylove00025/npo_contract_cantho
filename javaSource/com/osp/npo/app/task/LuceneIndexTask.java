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
public class LuceneIndexTask extends TimerTask {

	/** Logger */
    public static NpoLogger logger = (NpoLogger) NpoLogger
    	.getLogger(LuceneIndexTask.class.getName());
    
	@Override
	public void run() {
		NpoLogMessage logMsg = new NpoLogMessage();

        try {

        	LuceneEngine engine = LuceneEngine.instance();
        	engine.processIndexing();

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
