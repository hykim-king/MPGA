package com.pcwk.ehr.comment;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;

public class CommentLikeDaoImpl {

	final Logger LOG = Logger.getLogger(getClass());
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	
	public int doSelectOne(final CommentLikeVO commentLike)throws SQLException {
	int flag = 0;
	
	StringBuilder sb=new StringBuilder(100);
	sb.append(" INSERT INTO comment_like(member_num,seq,c_like,c_like_date) \n");
	sb.append(" VALUES (?,?,?,sysdate)						  			    \n");
	LOG.debug("=======================================");
	LOG.debug("sql=\n" + sb.toString());
	LOG.debug("param=" + commentLike.toString());
	LOG.debug("=======================================");
	
	Object[] args = { commentLike.getSeq(),
					  commentLike.getMemberNum(),
					  commentLike.getSeq(),
					  commentLike.getcLike(),
					  commentLike.getcLikeDate()
					};
	LOG.debug("args=" + args);
	flag = this.jdbcTemplate.update(sb.toString(), args);
	LOG.debug("flag=" + flag);
	return flag;
	
	}
	
	public CommentLikeVO doReadCnt (CommentLikeVO inVO) {
		CommentLikeVO outVO = null;
		
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT COUNT(*)cnt FROM comment_like");
		return outVO;
	}
	
	
}

