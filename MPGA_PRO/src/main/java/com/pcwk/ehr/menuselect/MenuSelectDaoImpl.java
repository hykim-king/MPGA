package com.pcwk.ehr.menuselect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.pcwk.ehr.menuselect.MenuSelectVO;
import com.pcwk.ehr.notice.vo.NoticeVO;

@Repository
public class MenuSelectDaoImpl implements MenuSelectDao{

	@Autowired
	private SqlSession session;
	static String namespace = "com.pcwk.ehr.menuselect";

	//찜 등록
	@Override
	public int menuSelectInsert(final MenuSelectVO select) throws Exception {
		return session.insert(namespace+".menuSelectInsert", select);
	}
	
	//찜 취소
	@Override
	public int menuSelectDelete(MenuSelectVO select) throws Exception {
		return session.delete(namespace+".menuSelectInsert", select);	
	}	

	// 메뉴찜 테이블을 최신순으로 리스트로 뽑아낸다.

	@Override
	public List<MenuSelectVO> menuSelectRead(MenuSelectVO select) throws Exception {
		List<MenuSelectVO> list = new ArrayList<MenuSelectVO>();	
			for (MenuSelectVO vo : list) {	
			}
			return session.selectList(namespace+".menuSelectRead");
	}
}
