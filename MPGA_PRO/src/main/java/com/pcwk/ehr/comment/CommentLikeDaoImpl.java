package com.pcwk.ehr.comment;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.pcwk.ehr.profile.ProfileImgVO;

public class CommentLikeDaoImpl implements CommentLikeDao {

	final Logger LOG = LoggerFactory.getLogger(getClass());
	private JdbcTemplate jdbcTemplate;
	
	RowMapper<CommentLikeVO> rowMapper = new RowMapper<CommentLikeVO>() {

		public CommentLikeVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			CommentLikeVO tmpVO = new CommentLikeVO();

			tmpVO.setSeq(rs.getInt("seq"));
			tmpVO.setMemberNum(rs.getInt("member_num"));
			tmpVO.setcLike(rs.getString("c_like"));
			tmpVO.setcLikeDate(rs.getString("c_like_date"));

			return tmpVO;

		}
	};
	
	public CommentLikeDaoImpl() {
	}

	
	@Override
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	
	@Override
	@SuppressWarnings({ "deprecation" })
	public List<CommentLikeVO> getAll() {
		List<CommentLikeVO> list = new ArrayList<CommentLikeVO>();
		StringBuilder sb = new StringBuilder(100);
		sb.append("SELECT 	seq,					 	  				 \n");
		sb.append(" 		member_num,			 					 	 \n");
		sb.append("			c_like,										 \n");
		sb.append(" 		c_like_date					 				 \n");
		sb.append("FROM		comment_like	 							 \n");
		sb.append("ORDER BY seq											 \n");
		LOG.debug("=====================================");
		LOG.debug("sql=\n" + sb.toString());

		Object[] args = {};
		list = this.jdbcTemplate.query(sb.toString(), args, rowMapper);

		for (CommentLikeVO vo : list) {
			LOG.debug("vo" + vo);
		}

		return list;
	}
	
	
	
	//등록!
	@Override
	@SuppressWarnings("deprecation")
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
	
	//카운트!
	@Override
	public CommentLikeVO doReadCnt (CommentLikeVO inVO) {
		CommentLikeVO outVO = null;
		
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT COUNT(*)cnt FROM comment_like");
		return outVO;
	}
	
	@Override	
		public int doDelete(CommentLikeVO CommentLike) throws SQLException {
		
			int flag = 0;
			StringBuilder sb = new StringBuilder();
			sb.append(" DELETE FROM comment_like \n");
			sb.append(" WHERE seq = ?            \n");
			LOG.debug("=========================================");
			LOG.debug("sql=\n" + sb.toString());
			LOG.debug("param=" + CommentLike.toString());
			LOG.debug("=========================================");
			Object[] args = { CommentLike.getSeq() };
			LOG.debug("args=" + args);
			flag = this.jdbcTemplate.update(sb.toString(), args);
			LOG.debug("flag=" + flag);
			
			return flag;

		}

	
}

