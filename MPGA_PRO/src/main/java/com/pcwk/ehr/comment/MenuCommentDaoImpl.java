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

import com.pcwk.ehr.comment.MenuCommentVO;
import com.pcwk.ehr.profile.ProfileImgVO;

public class MenuCommentDaoImpl implements MenuCommentDao {

	final Logger LOG = LoggerFactory.getLogger(getClass());
	private JdbcTemplate jdbcTemplate;
	
	RowMapper<MenuCommentVO> rowMapper = new RowMapper<MenuCommentVO>() {

		public MenuCommentVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			MenuCommentVO tmpVO = new MenuCommentVO();

			tmpVO.setSeq(rs.getInt("seq"));
			tmpVO.setMenuNum(rs.getString("menu_num"));
			tmpVO.setMemberNum(rs.getInt("member_num"));
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
	};

	@Override
	@SuppressWarnings({ "deprecation" })
	public List<MenuCommentVO> getAll() {
		List<MenuCommentVO> list = new ArrayList<MenuCommentVO>();
		StringBuilder sb = new StringBuilder(100);
		sb.append("SELECT 	seq,					 	  				 \n");
		sb.append(" 		menu_num,			 					     \n");
		sb.append("			member_num,								     \n");
		sb.append(" 		contents					 			     \n");
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
	@Override
	public int doInsert(final MenuCommentVO comment) throws SQLException {
		int flag = 0;

		StringBuilder sb = new StringBuilder(100);
		sb.append(" INSERT INTO menu_comment(seq,menu_num,member_num,contents,reg_dt) \n");
		sb.append(" VALUES (?,?,?,?,sysdate)						  				  \n");
		LOG.debug("=======================================");
		LOG.debug("sql=\n" + sb.toString());
		LOG.debug("param=" + comment.toString());
		LOG.debug("=======================================");

		Object[] args = { comment.getSeq(), comment.getMenuNum(), comment.getMemberNum(), comment.getContents(),
				comment.getRegDt() };
		LOG.debug("args=" + args);
		this.jdbcTemplate.update(sb.toString(), args);
		LOG.debug("flag=" + flag);
		return flag;

	}

		
	public MenuCommentVO SelectOne(MenuCommentVO inVO) {
		MenuCommentVO outVO = null;

		StringBuilder sb = new StringBuilder(50);
		sb.append(" SELECT seq,                                     	 \n");
		sb.append("        menu_num,                                 	 \n");
		sb.append(" 	   member_num,									 \n");
		sb.append(" 	   reg_num										 \n");
		b.append(" 	  	   contents										 \n");
		b.append(" 	   	   reg_dt										 \n");
		sb.append(" FROM menu_comment                                     \n");
		sb.append(" WHERE seq = ?                                        \n");
		LOG.debug("=========================================");
		LOG.debug("sql=\n" + sb.toString());

		Object[] args = { inVO.getSeq() };
		LOG.debug("args=" + args);
		LOG.debug("=========================================");
		outVO = this.jdbcTemplate.queryForObject(sb.toString(), args, rowMapper);

		LOG.debug("=========================================");
		LOG.debug("outVO=\n" + outVO.toString());
		LOG.debug("=========================================");
		
		return outVO;

	}

	// 수정! (다시 수정해야함)
	@Override
	public int doUpdate(MenuCommentVO comment) throws SQLException {
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
						  comment.getSeq()};
						  
		LOG.debug("args=" + args);
		flag = this.jdbcTemplate.update(sb.toString(), args);
		LOG.debug("flag=" + flag);
		
		return flag;
	}
	// 삭제!
	@Override
	public int doDelete(MenuCommentVO comment) throws SQLException {
		int flag = 0;
		StringBuilder sb = new StringBuilder();
		sb.append(" DELETE FROM menu_comment \n");
		sb.append(" WHERE seq = ?           \n");
		LOG.debug("=========================================");
		LOG.debug("sql=\n" + sb.toString());
		LOG.debug("param=" + comment.toString());
		LOG.debug("=========================================");
		Object[] args = { comment.getSeq() };
		LOG.debug("args=" + args);
		flag = this.jdbcTemplate.update(sb.toString(), args);
		LOG.debug("flag=" + flag);
		return flag;

	}

}
