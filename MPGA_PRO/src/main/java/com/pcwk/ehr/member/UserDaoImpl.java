package com.pcwk.ehr.member;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.pcwk.ehr.member.UserVO;

public class UserDaoImpl implements UserDao {

	final Logger LOG = LoggerFactory.getLogger(getClass());

	private DataSource dataSource;

	private JdbcTemplate jdbcTemplate;

	RowMapper<UserVO> rowMapper = new RowMapper<UserVO>() {

		public UserVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			UserVO tmpVO = new UserVO();

			tmpVO.setId(rs.getString("u_id"));
			tmpVO.setNickName(rs.getString("name"));
			
			return tmpVO;
		}

	};

	public UserDaoImpl() {
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;

		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public int doInsert(final UserVO user) {
		int flag = 0;

		StringBuilder sb = new StringBuilder();
		sb.append(" INTO MEMBER (MEMBER_NUM, SEQ, ID, NICKNAME, PHONE_NUM, EMAIL, PW, BIRTHDAY, SEX, MOD_DT, REG_NUM) \n");
		sb.append(" VALUES (?,?,?,?,?,?,?,?,?,sysdate,?) \n");

		Object[] args = { user.getMemberNum(), user.getSeq(), user.getId(), user.getNickName(), user.getPhoneNum(),
				user.getEmail(), user.getPw(), user.getBirthday(), user.getSex(), user.getModDt(), user.getRegNum() };

		flag = this.jdbcTemplate.update(sb.toString(), args);

		return flag;
	}
	
	//쓸필요가 없다.
	@SuppressWarnings("deprecation")
	public UserVO doSelectOne(UserVO inVO) throws ClassNotFoundException, SQLException {
		UserVO outVO = null;

		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT id, 	 	 	\n");
		sb.append("        nickname  	\n");		
		sb.append(" FROM member 	 	\n");
		sb.append(" WHERE  id = ? 	 	\n");
		sb.append(" 	   nickname = ? \n");
		LOG.debug("==============================================");
		LOG.debug("=sql=\n" + sb.toString());
		
		Object[] args = { inVO.getId() };
		LOG.debug("=args=" + args);
		LOG.debug("==============================================");
		outVO = this.jdbcTemplate.queryForObject(sb.toString(), args, rowMapper);
		LOG.debug("==============================================");
		LOG.debug("=outVO=\n" + outVO.toString());
		LOG.debug("==============================================");

		return outVO;
	}
	
	//아이디, 닉네임 인증시 데이터 비교할때 사용.
	@Override
	public List<?> doRetrieve(UserVO user) throws SQLException {
		
		return null;
	}

	@Override
	public List<UserVO> getAll() {
		
		return null;
	}

	@Override
	public int getCount() throws ClassNotFoundException, SQLException {
		
		return 0;
	}

	@Override
	public void deleteAll() throws SQLException {
		
		
	}

	@Override
	public int doDelete(UserVO user) throws SQLException {
		
		return 0;
	}

	@Override
	public int doUpdate(UserVO user) throws SQLException {
		
		return 0;
	}

	

	
	  

}
