package com.pcwk.ehr.selectedmenu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.pcwk.ehr.selectedmenu.SelectedMenuVO;

@Repository
public class SelectedMenuDaoImpl implements SelectedMenuDao {

	final static org.slf4j.Logger LOG = LoggerFactory.getLogger(SelectedMenuDaoImpl.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	RowMapper<SelectedMenuVO> rowMapper = new RowMapper<SelectedMenuVO>() {

		public SelectedMenuVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			SelectedMenuVO tmpVO = new SelectedMenuVO();

			tmpVO.setMemberNum(rs.getInt("memberNum"));
			tmpVO.setMenuNum(rs.getString("menuNum"));
			tmpVO.setSelectDt(rs.getString("selectDt"));
			return tmpVO;
		}
	};

	public SelectedMenuDaoImpl() {}
	
	// 메뉴찜 테이블을 최신순으로 리스트로 뽑아낸다.
		@SuppressWarnings({ "deprecation" })
		public List<SelectedMenuVO> getAll(SelectedMenuVO select) {
			List<SelectedMenuVO> list = new ArrayList<SelectedMenuVO>();
			StringBuilder sb = new StringBuilder(100);
			sb.append(" SELECT menu_num,     \n");
			sb.append(" 	   TO_CHAR(selectDt,'YYYY/MM/DD HH24MISS') selectDt  \n");
			sb.append(" FROM menu_select   \n");
			//최신일자 부터 정렬
			sb.append(" ORDER BY selectDt DESC    \n");
			sb.append(" WHERE member_num = ?    \n");

			LOG.debug("sql=\n" + sb.toString());
			Object[] args = {select.getMenuNum()};
			list = this.jdbcTemplate.query(sb.toString(), args, rowMapper);

			for (SelectedMenuVO vo : list) {
				LOG.debug("vo:" + vo);
			}

			return list;
		}
		
		/**
		 * 찜 등록
		 * 
		 * @param inVO
		 * @return :성공(1)/실패(0)
		 * @throws ClassNotFoundException
		 * @throws SQLException
		 */
		public int doInsert(final SelectedMenuVO select) throws ClassNotFoundException, SQLException {
			int flag = 0;
			StringBuilder sb = new StringBuilder();
			sb.append(" INSERT INTO menu_select (memberNum,menuNum,selectDt) \n");
			sb.append(" VALUES (?,?,sysdate)                                \n");
			LOG.debug("=========================================");
			LOG.debug("sql=\n" + sb.toString());
			LOG.debug("param=" + select.toString());
			LOG.debug("=========================================");

			Object[] args = { select.getMemberNum(), select.getMenuNum()};
			LOG.debug("args=" + args);
			flag = this.jdbcTemplate.update(sb.toString(), args);
			LOG.debug("flag=" + flag);

			return flag;
		}
		
		/*
		 * 찜 취소
		 * WHERE memberNum = ? , menuNum = ? 특정 회원이 특정 메뉴의 찜을 취소한다
		 */
		public int doDelete(SelectedMenuVO select) throws SQLException {
			int flag = 0;
			StringBuilder sb = new StringBuilder();
			sb.append(" DELETE FROM menu_select \n");
			sb.append(" WHERE memberNum = ? , menuNum = ?      \n");
			LOG.debug("=========================================");
			LOG.debug("sql=\n" + sb.toString());
			LOG.debug("param=" + select.toString());
			LOG.debug("=========================================");
			Object[] args = { select.getMemberNum(), select.getMenuNum()};
			LOG.debug("args=" + args);
			flag = this.jdbcTemplate.update(sb.toString(), args);		
			LOG.debug("flag=" + flag);
			return flag;
		}	
	
	
}
