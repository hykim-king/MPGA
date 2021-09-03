package com.pcwk.ehr.comment;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;

import com.pcwk.ehr.member.domain.UserVO;

public class MenuCommentDaoImpl {

	final Logger LOG = Logger.getLogger(getClass());
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	
	
	//등록!
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
	
	//셀렉트원!
	public CommentVO SelectOne (CommentVO inVO) {
		CommentVO outVO = null;
		
		StringBuilder sb = new StringBuilder();
		sb.append("  ");
		return outVO;
		
		
	}
	
	//수정! (다시 수정해야함)
	public int doUpdate (CommentVO comment) throws SQLException {
        int flag = 0;
        
        StringBuilder sb = new StringBuilder();
        sb.append(" UPDATE menu_comment          \n");
        sb.append("      					     \n");
        sb.append("        					     \n");
        sb.append("         					 \n");
        LOG.debug("=========================================");
		LOG.debug("sql=\n" + sb.toString());
		LOG.debug("param=" + comment.toString());
		LOG.debug("=========================================");	
		Object[] args = { comment.getContents(),
						  comment.getMemberNum(),
						  comment.getMenuNum(),
						  comment.getRegDt(),
						  comment.getSeq()
		};
		
	}
	
	//삭제! 
	public int doDelete(CommentVO comment) throws SQLException {
		int flag = 0;
		StringBuilder sb = new StringBuilder();
		sb.append(" DELETE FROM menu_comment \n");
		sb.append(" WHERE seq = ?           \n");
		LOG.debug("=========================================");
		LOG.debug("sql=\n" + sb.toString());
		LOG.debug("param=" + comment.toString());
		LOG.debug("=========================================");
		Object[] args = { comment.getSeq()};
		LOG.debug("args=" + args);
		flag = this.jdbcTemplate.update(sb.toString(), args);		
		LOG.debug("flag=" + flag);
		return flag;
			
	}
	
}
	
