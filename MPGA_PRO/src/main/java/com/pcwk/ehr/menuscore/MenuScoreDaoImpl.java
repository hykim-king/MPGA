package com.pcwk.ehr.menuscore;

import java.sql.SQLException;
import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.pcwk.ehr.menuscore.MenuScoreVO;

public class MenuScoreDaoImpl implements MenuScoreDao {

	final static org.slf4j.Logger LOG = LoggerFactory.getLogger(MenuScoreDaoImpl.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	RowMapper<MenuScoreVO> rowMapper = new RowMapper<MenuScoreVO>() {

		public MenuScoreVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			MenuScoreVO tmpVO = new MenuScoreVO();

			tmpVO.setMemberNum(rs.getInt("member_num"));
			tmpVO.setMenuNum(rs.getString("menu_num"));
			tmpVO.setScore(rs.getInt("score"));
			tmpVO.setScoreDt(rs.getString("scoreDt"));
			return tmpVO;
		}
	};
	
	public MenuScoreDaoImpl() {}

	
	// 메뉴 별점테이블을 최신순으로 리스트로 뽑아낸다.
	@SuppressWarnings({ "deprecation" })
	public List<MenuScoreVO> getAll(MenuScoreVO grade) {
		List<MenuScoreVO> list = new ArrayList<MenuScoreVO>();
		StringBuilder sb = new StringBuilder(100);
		sb.append(" SELECT member_num,     \n");
		sb.append("        menu_num,     \n");
		sb.append("        score,   \n");
		sb.append(" 	   TO_CHAR(scoreDt,'YYYY/MM/DD HH24MISS') scoreDt  \n");
		sb.append(" FROM menu_score   \n");
		//최신일자 부터 정렬
		sb.append(" ORDER BY scoreDt DESC    \n");
		sb.append(" WHERE menu_num = ?    \n");

		LOG.debug("sql=\n" + sb.toString());
		Object[] args = {grade.getMenuNum()};
		list = this.jdbcTemplate.query(sb.toString(), args, rowMapper);

		for (MenuScoreVO vo : list) {
			LOG.debug("vo:" + vo);
		}

		return list;
	}
	

	/**
	 *  특정 메뉴에 몇명이 별점을 부여했는가 + 특정 메뉴의 평균 별점
	 *  WHERE menu_num = ? 구문으로 특정메뉴에 몇개의 데이터가 들어가 있는지 카운트한다
	 *  TRUNC(AVG(score),1) 별점을 평균내어 소숫점 첫째 자리까지 자른 수치
	 * @return 별점 등록 건수
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	@SuppressWarnings("deprecation")
	public   int getAvg(MenuScoreVO grade) throws ClassNotFoundException, SQLException {
		int avg_score= 0;
		StringBuilder sb = new StringBuilder(100);
		sb.append(" SELECT TRUNC(AVG(score),1) AS avg_score,     \n");
		sb.append(" FROM menu_score                              \n");
		sb.append(" WHERE menu_num = ?                           \n");
		LOG.debug("=========================================");
		LOG.debug("sql=\n" + sb.toString());
		LOG.debug("=========================================");
		
		Object[] args = {grade.getMenuNum()};
		
		avg_score = this.jdbcTemplate.queryForObject(sb.toString(), args, Integer.class);
		LOG.debug("=========================================");
		LOG.debug("avg_score=" + avg_score);
		LOG.debug("=========================================");

		return avg_score;
		
	}
	
	/**
	 * 특정메뉴에 등록된 별점건수
	 * 
	 * @return 등록 건수
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	@SuppressWarnings("deprecation")
	public int getCount(MenuScoreVO grade) throws ClassNotFoundException, SQLException {
		int cnt = 0;
		
		StringBuilder sb = new StringBuilder(100);
		sb.append(" SELECT COUNT(*) cnt FROM hr_member WHERE menu_num = ?	\n");
		LOG.debug("=========================================");
		LOG.debug("sql=\n" + sb.toString());
		LOG.debug("=========================================");

		Object[] args = {grade.getMenuNum()};
		cnt = this.jdbcTemplate.queryForObject(sb.toString(), args, Integer.class);

		LOG.debug("=========================================");
		LOG.debug("cnt=" + cnt);
		LOG.debug("=========================================");

		return cnt;
	}
	
	
	
	

	/**
	 * 전체삭제
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void deleteAll() throws SQLException {

		jdbcTemplate.update(new PreparedStatementCreator() {

			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				StringBuilder sb = new StringBuilder();
				sb.append(" DELETE FROM menu_score \n");
				LOG.debug("=========================================");
				LOG.debug("sql=\n" + sb.toString());
				LOG.debug("=========================================");

				return con.prepareStatement(sb.toString());
			}
		});

	}

	/**
	 * 별점 등록
	 * 
	 * @param inVO
	 * @return :성공(1)/실패(0)
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public int doInsert(final MenuScoreVO grade) throws ClassNotFoundException, SQLException {
		int flag = 0;
		StringBuilder sb = new StringBuilder();
		sb.append(" INSERT INTO menu_score (memberNum,menuNum,score,scoreDt) \n");
		sb.append(" VALUES (?,?,?,sysdate)                                                     \n");
		LOG.debug("=========================================");
		LOG.debug("sql=\n" + sb.toString());
		LOG.debug("param=" + grade.toString());
		LOG.debug("=========================================");

		Object[] args = { grade.getMemberNum(), grade.getMenuNum(), grade.getScore()};
		LOG.debug("args=" + args);
		flag = this.jdbcTemplate.update(sb.toString(), args);
		LOG.debug("flag=" + flag);

		return flag;
	}
	
	/*
	 * WHERE memberNum = ? , menuNum = ? 특정 회원이 특정 메뉴에서 별점을 취소한다
	 */
	public int doDelete(MenuScoreVO grade) throws SQLException {
		int flag = 0;
		StringBuilder sb = new StringBuilder();
		sb.append(" DELETE FROM menu_score \n");
		sb.append(" WHERE memberNum = ? , menuNum = ?      \n");
		LOG.debug("=========================================");
		LOG.debug("sql=\n" + sb.toString());
		LOG.debug("param=" + grade.toString());
		LOG.debug("=========================================");
		Object[] args = { grade.getMemberNum(), grade.getMenuNum()};
		LOG.debug("args=" + args);
		flag = this.jdbcTemplate.update(sb.toString(), args);		
		LOG.debug("flag=" + flag);
		return flag;
	}
	
	/*
	 * WHERE memberNum = ? 특정회원을 찾아 score = ? 별점을 변경한다
	 * 별점 변경
	 */
	public int doUpdate(MenuScoreVO grade) throws SQLException {
        int flag = 0;
        
        StringBuilder sb = new StringBuilder();
        sb.append(" UPDATE menu_score         \n");
        sb.append(" SET                       \n");
        sb.append("     score       = ?,      \n");
        sb.append("     scoreDt     = sysdate \n");
        sb.append(" WHERE memberNum = ? , menuNum = ?      \n");
		LOG.debug("=========================================");
		LOG.debug("sql=\n" + sb.toString());
		LOG.debug("param=" + grade.toString());
		LOG.debug("=========================================");		
		Object[] args = { grade.getScore(),grade.getMemberNum(), grade.getMenuNum() };		
		
		flag = this.jdbcTemplate.update(sb.toString(), args);
		
		LOG.debug("flag=" + flag);
		return flag;
	}





}
