package com.mpga.java;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class NoticeDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	
	
	public NoticeDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Notice> list() {
		String sql = "SELECT * FROM NOTICE";
		
		List<Notice> listNotice = jdbcTemplate.query(sql, 
				BeanPropertyRowMapper.newInstance(Notice.class));
		
		return listNotice;
	}
	
	public void save(Notice notice) {
		
	}
	
	public Notice get(int seq) {
		return null;
	}
	
	public void update(Notice notice) {
		
	}
	
	public void delete(int seq) {
		
	}
	
}
