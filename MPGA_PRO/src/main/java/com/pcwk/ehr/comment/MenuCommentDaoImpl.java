package com.pcwk.ehr.comment;

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

import com.pcwk.ehr.commentlike.CommentLikeVO;

public class MenuCommentDaoImpl implements MenuCommentDao {

	final Logger LOG = LoggerFactory.getLogger(getClass());
	
	@Autowired
	SqlSessionTemplate sqlsessiontemplate;
	
	final String NAMESPACE = "com.pcwk.ehr.comment";

	public MenuCommentDaoImpl() {
	
	}
	
	
	@Override
	@SuppressWarnings({ "deprecation" })
	public List<MenuCommentVO> getAll() {
		List<MenuCommentVO> list = new ArrayList<MenuCommentVO>();

		String statement = NAMESPACE + ".getAll";

		list = this.sqlsessiontemplate.selectList(statement);

		for (MenuCommentVO vo : list) {
			LOG.debug("vo" + vo);
		}

		return list;
	}

	// 등록!

	public int doInsert(MenuCommentVO comment) throws SQLException {
		int flag = 0;

		LOG.debug("=======================================");
		LOG.debug("param=" + comment.toString());
		LOG.debug("=======================================");

		String statement = NAMESPACE + ".doInsert";
		
		flag = this.sqlsessiontemplate.insert(statement, comment);
				
		LOG.debug("flag=" + flag);
		return flag;

	}

	// 셀렉트원!
	@Override
	@SuppressWarnings("deprecation")
	public MenuCommentVO doSelectOne(MenuCommentVO inVO) throws ClassNotFoundException, SQLException {
		MenuCommentVO outVO = null;
		
		String statement = NAMESPACE + ".doSelectOne";

		LOG.debug("=========================================");
		LOG.debug("inVO=" + inVO.toString());
		LOG.debug("statement=" + statement);
		LOG.debug("=========================================");
		
		outVO = this.sqlsessiontemplate.selectOne(statement, inVO);
		LOG.debug("outVO=" + outVO);

		return outVO;

	}

	// 수정
	@Override
	public int doUpdate(MenuCommentVO comment) throws SQLException {
		int flag = 0;
	
		LOG.debug("=========================================");
		LOG.debug("param=" + comment.toString());
		LOG.debug("=========================================");
		
		String statement = NAMESPACE + ".doUpdate";
		flag = this.sqlsessiontemplate.update(statement, comment);
		
		LOG.debug("flag=" + flag);
		return flag;
	}

	// 삭제!
	@Override
	public int doDelete(MenuCommentVO comment) throws SQLException {
		int flag = 0;
		
		LOG.debug("=========================================");
		LOG.debug("param=" + comment.toString());
		LOG.debug("=========================================");
		
		String statement = NAMESPACE + ".doDelete";
		flag = this.sqlsessiontemplate.delete(statement, comment);
		
		LOG.debug("flag=" + flag);
		return flag;
	}


	@Override
	public void setDataSource(DataSource dataSource) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public MenuCommentVO SelectOne(MenuCommentVO inVO) {
		// TODO Auto-generated method stub
		return null;
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