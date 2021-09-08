package com.pcwk.ehr.commentlike;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.pcwk.ehr.member.UserVO;

public class CommentLikeDaoImpl implements CommentLikeDao {

	final Logger LOG = LoggerFactory.getLogger(getClass());
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	
	RowMapper<CommentLikeVO> rowMapper = new RowMapper<CommentLikeVO>() {

		public CommentLikeVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			CommentLikeVO tmpVO = new CommentLikeVO();

			tmpVO.setcLike(rs.getString("u_id"));
			tmpVO.setcLikeDate(rs.getString("memberNum"));
			
			return tmpVO;
		}

	};
	
	
	//등록!
	@Override
	public CommentLikeVO doSelectOne(final CommentLikeVO commentLike)throws SQLException {
	CommentLikeVO outVO = null;
	
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
	outVO = this.jdbcTemplate.queryForObject(sb.toString(), args, rowMapper);
	LOG.debug("outVO=" + outVO);
	return outVO;
	
	}
	
	//카운트!
	@Override
	public CommentLikeVO doReadCnt (CommentLikeVO inVO) {
		CommentLikeVO outVO = null;
		
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT COUNT(*)cnt FROM comment_like");
		return outVO;
	}
	
	@Override
	public int doDelete (CommentLikeVO commentLike) {
		
		return 0;
			
	}

	

	@Override
	public int doInsert(CommentLikeVO commentLike) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}

