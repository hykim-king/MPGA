package com.pcwk.ehr.commentlike;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CommentLikeDaoImpl implements CommentLikeDao  {

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
		
		String statement = this.NAMESPACE +".getAll";
		
		list = this.sqlsessiontemplate.selectList(statement);
		
		for (CommentLikeVO vo : list) {
			LOG.debug("vo:" + vo);
		}

		return list;
	}
	
	 
	@Override
	@SuppressWarnings("deprecation")
	public int getCount() throws ClassNotFoundException, SQLException {
		int cnt = 0;

		String statement = this.NAMESPACE +".getCount";
		
		cnt = this.sqlsessiontemplate.selectOne(statement);
		LOG.debug("=========================================");
		LOG.debug("cnt=" + cnt);
		LOG.debug("=========================================");

		return cnt;
	}
	 
	 
	 
	@Override
	public int getLikeCount() throws SQLException {
		int cnt = 0;

		String statement = this.NAMESPACE +".getLikeCount";
		
		cnt = this.sqlsessiontemplate.selectOne(statement);
		LOG.debug("=========================================");
		LOG.debug("cnt=" + cnt);
		LOG.debug("=========================================");

		return cnt;
	}
	
	 
	@Override
	@SuppressWarnings("deprecation")
	public CommentLikeVO doSelectOne(CommentLikeVO inVO) throws ClassNotFoundException, SQLException {
		CommentLikeVO outVO = null;

		String statement = this.NAMESPACE+".doSelectOne";
		
		
		LOG.debug("=========================================");
		LOG.debug("inVO=" + inVO.toString());
		LOG.debug("statement=" + statement);
		LOG.debug("=========================================");

		outVO = this.sqlsessiontemplate.selectOne(statement, inVO);
		LOG.debug("outVO=" + outVO);
		return outVO;
	}
	
	
	 
	 
	 
	@Override
	public int doUpdate(CommentLikeVO commentLike) throws SQLException {
		int flag = 0;
		
		LOG.debug("=========================================");
		LOG.debug("param=" + commentLike.toString());
		LOG.debug("=========================================");
	
		String statement = NAMESPACE + ".doUpdate";
		flag = this.sqlsessiontemplate.update(statement, commentLike);
		
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
	public int doDelete(CommentLikeVO commentLike) throws SQLException {
		int flag = 0;
		LOG.debug("=========================================");
		LOG.debug("param=" + commentLike.toString());
		LOG.debug("=========================================");
		
		String statement = NAMESPACE + ".doDelete";
		
		flag = this.sqlsessiontemplate.delete(statement, commentLike);
		
		LOG.debug("flag=" + flag);
		return flag;
	}
	

	 
	@Override
	public void deleteAll() throws SQLException {

		//NAMESPACE +"."+id
		String statement = NAMESPACE + ".deleteAll";
		int flag = sqlsessiontemplate.delete(statement);
		LOG.debug("=========================================");
		LOG.debug("flag=" + flag);
		LOG.debug("=========================================");		
	}
}

