package com.pcwk.ehr.commentlike;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.pcwk.ehr.member.UserVO;
import com.pcwk.ehr.profile.ProfileImgVO;

public class CommentLikeDaoImpl implements CommentLikeDao {

	final Logger LOG = LoggerFactory.getLogger(getClass());
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	SqlSessionTemplate sqlsessiontemplate;
	final String NAMESPACE = "com.pcwk.ehr.commentlike";
	
	RowMapper<CommentLikeVO> rowMapper = new RowMapper<CommentLikeVO>() {

		public CommentLikeVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			CommentLikeVO tmpVO = new CommentLikeVO();

			tmpVO.setcLike(rs.getString("member_Num"));
			tmpVO.setSeq(rs.getInt("seq"));
			tmpVO.setcLike(rs.getString("cLike"));
			tmpVO.setcLikeDate(rs.getString("cLikeDate"));
			
			return tmpVO;
		}

	};
	
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
		sb.append(" 		member_Num,				 					 \n");
		sb.append("			mod_dt,										 \n");
		sb.append(" 		c_like					 					 \n");
		sb.append("FROM		c_like_date	 								 \n");
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
	@SuppressWarnings("deprecation")
	@Override
	public CommentLikeVO doSelectOne(CommentLikeVO inVO)throws SQLException {
	CommentLikeVO outVO = null;

	String statement = NAMESPACE + ".doSelectOne";

	LOG.debug("=========================================");
	LOG.debug("inVO=" + inVO.toString());
	LOG.debug("statement=" + statement);
	LOG.debug("=========================================");
	
	outVO = this.sqlsessiontemplate.selectOne(statement, inVO);
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
	public int doDelete(CommentLikeVO commentLike) throws SQLException {
		int flag = 0;
		StringBuilder sb = new StringBuilder();
		LOG.debug("=========================================");
		LOG.debug("param=" + commentLike.toString());
		LOG.debug("=========================================");
	
		String statement = NAMESPACE + ".doDelete";
		flag = this.sqlsessiontemplate.delete(statement, commentLike);
		
		LOG.debug("flag=" + flag);
		return flag;
			
	}

	

	@Override
	public int doInsert(CommentLikeVO commentLike) throws SQLException {
		int flag = 0;

		LOG.debug("=======================================");
		LOG.debug("param=" + commentLike.toString());
		LOG.debug("=======================================");

		String statement = NAMESPACE + ".doInsert";
		
		flag = this.sqlsessiontemplate.insert(statement, commentLike);
				
		LOG.debug("flag=" + flag);
		return flag;
	}
	
	
}

