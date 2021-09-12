package com.pcwk.ehr.menuscore;

import java.sql.SQLException;
import javax.sql.DataSource;

import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.SqlSession;
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

@Repository
public class MenuScoreDaoImpl implements MenuScoreDao, MenuScoreService {

	@Autowired
	private SqlSession session;
	static String namespace = "com.pcwk.ehr.menuscore";
	
	//별점 등록
	@Override
	public void menuScoreInsert(final MenuScoreVO score) throws Exception {
		session.insert(namespace+".menuScoreInsert", score);
	}
	
	//별점 삭제
	@Override
	public void menuScoreDelete(MenuScoreVO score) throws Exception {
		session.delete(namespace+".menuScoreDelete", score);
	}
	
	//별점 변경
	@Override
	public void menuScoreUpdate(MenuScoreVO score) throws Exception {
		session.update(namespace+".menuScoreUpdate", score);
	}
	
	//별점 평균
	@Override
	public  int menuScoreAvg(MenuScoreVO score) throws Exception {
		int avg_score = 0;
		avg_score=session.selectOne(namespace+".menuScoreAvg", score);
		return avg_score;
	}
	
	//별점의 부여한 사람의 수
	@Override
	public  int menuScoreCount(MenuScoreVO score) throws Exception {
		int cnt = 0;
		cnt = session.selectOne(namespace+".menuScoreCount", score);
		return cnt;
	}
}
