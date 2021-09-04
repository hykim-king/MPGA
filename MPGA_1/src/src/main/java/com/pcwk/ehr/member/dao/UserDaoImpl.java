package com.pcwk.ehr.member.dao;

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

import com.pcwk.ehr.Level;
import com.pcwk.ehr.member.domain.UserVO;

@Repository
public class UserDaoImpl implements UserDao {
	final static Logger LOG = LoggerFactory.getLogger(UserDaoImpl.class);

	@Autowired
	JdbcTemplate jdbcTemplate;

	RowMapper<UserVO> rowMapper = new RowMapper<UserVO>() {

		public UserVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			UserVO tmpVO = new UserVO();

			tmpVO.setuId(rs.getString("u_id"));
			tmpVO.setName(rs.getString("name"));
			tmpVO.setPasswd(rs.getString("passwd"));
			// 2021/08/25 추가컬럼
			tmpVO.setLevel(Level.valueOf(rs.getInt("u_level")));
			tmpVO.setLogin(rs.getInt("login"));
			tmpVO.setRecommend(rs.getInt("recommend"));
			
			// 2021/08/30 추가컬럼
			tmpVO.setEmail(rs.getString("email"));
			tmpVO.setRegDt(rs.getString("reg_dt"));
			return tmpVO;
		}
	};

	public UserDaoImpl() {
		
	}

	@SuppressWarnings({ "deprecation" })
	public List<UserVO> getAll() {
		List<UserVO> list = new ArrayList<UserVO>();
		StringBuilder sb = new StringBuilder(100);
		sb.append(" SELECT u_id,     \n");
		sb.append("        name,     \n");
		sb.append("        passwd,   \n");
		// 2021/08/25 추가컬럼
		sb.append(" 	   u_level,  \n");
		sb.append(" 	   login,    \n");
		sb.append(" 	   recommend,                                    \n");
		// 2021/08/30 추가컬럼: email,reg_dt
		sb.append(" 	   email,                                        \n");
		sb.append(" 	   TO_CHAR(reg_dt,'YYYY/MM/DD HH24MISS') reg_dt  \n");
		sb.append(" FROM hr_member   \n");
		sb.append(" ORDER BY u_id    \n");

		LOG.debug("sql=\n" + sb.toString());
		Object[] args = {};
		list = this.jdbcTemplate.query(sb.toString(), args, rowMapper);

		for (UserVO vo : list) {
			LOG.debug("vo:" + vo);
		}

		return list;
	}

	/**
	 * 등록 건수
	 * 
	 * @return 등록 건수
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	@SuppressWarnings("deprecation")
	public int getCount() throws ClassNotFoundException, SQLException {
		int cnt = 0;

		// 2.
		StringBuilder sb = new StringBuilder(50);
		sb.append(" SELECT COUNT(*) cnt FROM hr_member	\n");
		LOG.debug("=========================================");
		LOG.debug("sql=\n" + sb.toString());
		LOG.debug("=========================================");

		Object[] args = {};
		cnt = this.jdbcTemplate.queryForObject(sb.toString(), args, Integer.class);

		LOG.debug("=========================================");
		LOG.debug("cnt=" + cnt);
		LOG.debug("=========================================");

		return cnt;
	}

	/**
	 * 사용자 조회
	 * 
	 * @param inVO
	 * @return UserVO
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	@SuppressWarnings("deprecation")
	public UserVO doSelectOne(UserVO inVO) throws ClassNotFoundException, SQLException {
		UserVO outVO = null;

		// 2.
		StringBuilder sb = new StringBuilder(50);
		sb.append(" SELECT u_id,	                                     \n");
		sb.append("        name,                                         \n");
		sb.append(" 	   passwd,                                       \n");
		// 2021/08/25 추가컬럼                                           
		sb.append(" 	   u_level,                                      \n");
		sb.append(" 	   login,                                        \n");
		sb.append(" 	   recommend,                                    \n");
		// 2021/08/30 추가컬럼: email,reg_dt
		sb.append(" 	   email,                                        \n");
		sb.append(" 	   TO_CHAR(reg_dt,'YYYY/MM/DD HH24MISS') reg_dt  \n");
		sb.append(" FROM hr_member                                       \n");
		sb.append(" WHERE u_id = ?                                       \n");
		LOG.debug("=========================================");
		LOG.debug("sql=\n" + sb.toString());

		Object[] args = { inVO.getuId() };
		LOG.debug("args=" + args);
		LOG.debug("=========================================");
		outVO = this.jdbcTemplate.queryForObject(sb.toString(), args, rowMapper);

		LOG.debug("=========================================");
		LOG.debug("outVO=\n" + outVO.toString());
		LOG.debug("=========================================");

		return outVO;
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
				sb.append(" DELETE FROM hr_member \n");
				LOG.debug("=========================================");
				LOG.debug("sql=\n" + sb.toString());
				LOG.debug("=========================================");

				return con.prepareStatement(sb.toString());
			}
		});

	}

	/**
	 * 사용자 등록
	 * 
	 * @param inVO
	 * @return :성공(1)/실패(0)
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public int doInsert(final UserVO user) throws ClassNotFoundException, SQLException {
		int flag = 0;
		StringBuilder sb = new StringBuilder();
		sb.append(" INSERT INTO HR_MEMBER ( u_id,name,passwd,u_level,login,recommend,email,reg_dt     ) \n");
		sb.append(" VALUES (?,?,?,?,?,?, ?,sysdate)                                                     \n");
		LOG.debug("=========================================");
		LOG.debug("sql=\n" + sb.toString());
		LOG.debug("param=" + user.toString());
		LOG.debug("=========================================");

		Object[] args = { user.getuId(), user.getName(), user.getPasswd(), user.getLevel().getValue(), user.getLogin(),
				user.getRecommend(),user.getEmail()   };
		LOG.debug("args=" + args);
		flag = this.jdbcTemplate.update(sb.toString(), args);
		LOG.debug("flag=" + flag);

		return flag;
	}

	public int doDelete(UserVO user) throws SQLException {
		int flag = 0;
		StringBuilder sb = new StringBuilder();
		sb.append(" DELETE FROM hr_member \n");
		sb.append(" WHERE u_id = ?        \n");
		LOG.debug("=========================================");
		LOG.debug("sql=\n" + sb.toString());
		LOG.debug("param=" + user.toString());
		LOG.debug("=========================================");
		Object[] args = { user.getuId()};
		LOG.debug("args=" + args);
		flag = this.jdbcTemplate.update(sb.toString(), args);		
		LOG.debug("flag=" + flag);
		return flag;
	}

	public int doUpdate(UserVO user) throws SQLException {
        int flag = 0;
        
        StringBuilder sb = new StringBuilder();
        sb.append(" UPDATE hr_member          \n");
        sb.append(" SET                       \n");
        sb.append("     name      = ?,        \n");
        sb.append("     passwd    = ?,        \n");
        sb.append("     u_level   = ?,        \n");
        sb.append("     login     = ?,        \n");
        sb.append("     recommend = ?,        \n");
        //2021/08/30 추가 컬럼:email,reg_dt
        sb.append("     email     = ?,        \n");
        sb.append("     reg_dt    = sysdate   \n");
        sb.append(" WHERE u_id = ?            \n");
		LOG.debug("=========================================");
		LOG.debug("sql=\n" + sb.toString());
		LOG.debug("param=" + user.toString());
		LOG.debug("=========================================");		
		Object[] args = { user.getName(), 
				          user.getPasswd(), 
				          user.getLevel().getValue(), 
				          user.getLogin(),
				          user.getRecommend(),
				          user.getEmail(),
				          user.getuId()  };		
		
		flag = this.jdbcTemplate.update(sb.toString(), args);
		
		LOG.debug("flag=" + flag);
		return flag;
	}

	public List<?> doRetrieve(UserVO user) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
