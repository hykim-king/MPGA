package com.pcwk.ehr;

public class StringUtil {
	
	/**
	 * val가 Null이면 rep로 대처.
	 * @param val
	 * @param rep
	 * @return
	 */
	public static String nvl(String val, String rep) {
		if(null==val) {
			val=rep;
		}
		
		return val.trim();
	}

}
