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

public class MenuCommentDaoImpl implements MenuCommentDao {

	final Logger LOG = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	SqlSessionTemplate sqlsessiontemplate;
	final String NAMESPACE = "com.pcwk.ehr.comment";
	
	RowMapper<MenuCommentVO> rowMapper = new RowMapper<MenuCommentVO>() {
		
		public MenuCommentVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			MenuCommentVO tmpVO = new MenuCommentVO();
			
			tmpVO.setSeq(rs.getInt("seq"));
			tmpVO.setMemberNum(rs.getInt("member_num"));
			tmpVO.setMenuNum(rs.getString("menu_num"));
			tmpVO.setContents(rs.getString("contents"));
			tmpVO.setRegDt(rs.getString("reg_dt"));

			return tmpVO;

		}
	};

	public MenuCommentDaoImpl() {
	
	}
	
	@Override
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	@SuppressWarnings({ "deprecation" })
	public List<MenuCommentVO> getAll() {
		List<MenuCommentVO> list = new ArrayList<MenuCommentVO>();
		StringBuilder sb = new StringBuilder(100);
		sb.append("SELECT 	seq,					 	  				 \n");
		sb.append(" 		member_num,			 					 	 \n");
		sb.append("			menu_num,									 \n");
		sb.append(" 		contents					 				 \n");
		sb.append(" 		reg_dt					 					 \n");
		sb.append("FROM		menu_comment	 							 \n");
		sb.append("ORDER BY seq											 \n");
		LOG.debug("=====================================");
		LOG.debug("sql=\n" + sb.toString());

		Object[] args = {};
		list = this.jdbcTemplate.query(sb.toString(), args, rowMapper);

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
	public MenuCommentVO SelectOne(MenuCommentVO inVO) {
		// TODO Auto-generated method stub
		return null;
	}
}