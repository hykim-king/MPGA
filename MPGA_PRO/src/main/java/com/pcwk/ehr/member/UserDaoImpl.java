package com.pcwk.ehr.member;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate; 


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
			tmpVO.setPw(rs.getString("passwd"));
			//컬럼추가 20210825
			tmpVO.setLevel(Level.valueOf(rs.getInt("u_level")));
			tmpVO.setLogin(rs.getInt("login"));
			tmpVO.setRecommend(rs.getInt("recommend"));
			
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
		
		Object[] args = { user.getMemberNum(), user.getSeq(), user.getId(), user.getNickName(), user.getPhoneNum(), user.getEmail(), user.getPw(),
						  user.getBirthday(), user.getSex(), user.getModDt(), user.getRegNum()};
		
		flag = this.jdbcTemplate.update(sb.toString(), args);
		
		return flag;
	}
	
	@SuppressWarnings("deprecation")
	public UserVO doSelectOne(UserVO inVO) throws ClassNotFoundException, SQLException {
		UserVO outVO = null;

		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT u_id, 	 \n");
		sb.append("        name, 	 \n");
		sb.append("        passwd,   \n");
		//컬럼추가 20210825
		sb.append(" 	   u_level,  \n");
		sb.append(" 	   login, 	 \n");
		sb.append(" 	   recommend \n");
		sb.append(" FROM hr_member \n");
		sb.append(" WHERE u_id = ? \n");
		LOG.debug("==============================================");
		LOG.debug("=sql=\n" + sb.toString());
		
		
		Object[] args = {inVO.getId()};
		LOG.debug("=args=" + args);
		LOG.debug("==============================================");
		outVO = this.jdbcTemplate.queryForObject(sb.toString(), args, rowMapper);
		
		LOG.debug("==============================================");
		LOG.debug("=outVO=\n" + outVO.toString());
		LOG.debug("==============================================");

		return outVO;
	}
	
	/*
	 * public List<?> doRetrieve(UserVO user) throws SQLException { // TODO
	 * Auto-generated method stub return null; }
	 * 
	 * @Override public List<UserVO> getAll() { // TODO Auto-generated method stub
	 * return null; }
	 * 
	 * @Override public int getCount() throws ClassNotFoundException, SQLException {
	 * // TODO Auto-generated method stub return 0; }
	 * 
	 * @Override public void deleteAll() throws SQLException { // TODO
	 * Auto-generated method stub
	 * 
	 * }
	 * 
	 * @Override public int doDelete(UserVO user) throws SQLException { // TODO
	 * Auto-generated method stub return 0; }
	 * 
	 * @Override public int doUpdate(UserVO user) throws SQLException { // TODO
	 * Auto-generated method stub return 0; }
	 */
	
	

}
