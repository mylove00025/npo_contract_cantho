package com.osp.npo.common.demo;

import java.util.Calendar;

import com.osp.npo.common.util.CopyrightUtil;

/**
 * Trial version config
 * 
 * @author HaiNT
 * @version $Revision$
 */
public class NpoTrial {

	public static Boolean IS_TRIAL = Boolean.FALSE;
	
	public static Calendar START_DATE = Calendar.getInstance();
	
	public static final int TRIAL_DAYS = 30;
	
	/**
	 * Check trial using
	 * 
	 * @param now
	 * @return true if can use, false if can not use
	 */
	public static Boolean checkTrial(Calendar now) {
		
		if (NpoTrial.IS_TRIAL) {
			
			String invalid = CopyrightUtil.getRegistryTrialInvalid();
			
			if (invalid == null || !"0".equals(invalid)) {
				return Boolean.FALSE;
			} else {
				
				long useDays = now.getTimeInMillis() - NpoTrial.START_DATE.getTimeInMillis();
				useDays = useDays / (1000 * 60 * 60 * 24);
				
				boolean valid = TRIAL_DAYS > useDays;
				
				if (!valid) {
					CopyrightUtil.setRegistryTrialInvalid("1");
				}
				
				return valid;
			}
		} else {
			return Boolean.TRUE;
		}
	}
}
