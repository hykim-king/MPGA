package com.pcwk.ehr.commentlike;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


public class CommentLikeDaoImpl implements CommentLikeDao {

	final Logger LOG = LoggerFactory.getLogger(getClass());
	@Autowired
	SqlSessionTemplate sqlsessiontemplate;
	
	final String NAMESPACE = "com.pcwk.ehr.commentlike";

	public CommentLikeDaoImpl() {
			
	}
	
	
	
	@Override
	@SuppressWarnings({ "deprecation" })
	public List<CommentLikeVO> getAll() {
		List<CommentLikeVO> list = new ArrayList<CommentLikeVO>();

		String statement = NAMESPACE + ".getAll";

		list = this.sqlsessiontemplate.selectList(statement);

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



	@Override
	public void setDataSource(DataSource dataSource) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public Object getCount() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}

