package com.pcwk.ehr.profile;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;

public class profileImgImpl {

	final static Logger LOG = Logger.getLogger(profileImgImpl.class);
	
	private DataSource dataSource;

	private JdbcTemplate jdbcTemplate;
}
