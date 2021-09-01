package com.pcwk.ehr.comment;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;

public class MenuCommentDaoImpl {

	final Logger LOG = Logger.getLogger(getClass());
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	
	public int doInsert(final CommentVO comment)throws SQLException {
	int flag = 0;
	
	StringBuilder sb=new StringBuilder(100);
	sb.append(" INSERT INTO menu_comment(seq,menu_num,member_num,contents,reg_dt) \n");
	sb.append(" VALUES (?,?,?,?,sysdate)						  				  \n");
	LOG.debug("=======================================");
	LOG.debug("sql=\n" + sb.toString());
	LOG.debug("param=" + comment.toString());
	LOG.debug("=======================================");
	
	Object[] args = { comment.getSeq(),
				   	  comment.getMenuNum(),
					  comment.getMemberNum(),
					  comment.getContents(),
					  comment.getRegDt()
					};
	LOG.debug("args=" + args);
	this.jdbcTemplate.update(sb.toString(), args);
	LOG.debug("flag=" + flag);
	return flag;
	
	}
	
	public CommentVO SelectOne (CommentVO inVO) {
		CommentVO outVO = null;
		
		StringBuilder sb = new StringBuilder();
		sb.append("  ");
		return outVO;
		
		
	}
	
}