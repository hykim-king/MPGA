package com.pcwk.ehr;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestServiceException extends RuntimeException {
	final Logger LOG = LoggerFactory.getLogger(getClass());
	
	public TestServiceException() {}
	
	public TestServiceException(String msg) {
		super(msg);		
		LOG.debug("+++++++++++++++++++++++++++++++++++");
		LOG.debug("+TestUserServiceException:"+msg);
		LOG.debug("+++++++++++++++++++++++++++++++++++");

		
	}
	
	
}
