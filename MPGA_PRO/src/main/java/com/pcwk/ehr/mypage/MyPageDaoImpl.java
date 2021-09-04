package com.pcwk.ehr.mypage;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.pcwk.ehr.M_Rank;



@Repository
public class MyPageDaoImpl implements MyPageDao {
	
	final Logger LOG = LoggerFactory.getLogger(getClass());

	private DataSource dataSource;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;	
	
	//?
	RowMapper<MyPageVO> rowMapper = new RowMapper<MyPageVO>() {

		public MyPageVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			MyPageVO tmpVO = new MyPageVO();

			tmpVO.setProfileImg(rs.getString("pro_img_path"));
			tmpVO.setNickName(rs.getString("nickname"));
			// 2021/08/25 추가컬럼
			tmpVO.setRank(M_Rank.valueOf(rs.getString("u_rank")));
			tmpVO.setSelectDate(rs.getString("select_date"));
			tmpVO.setcLike(rs.getString("c_like")); 
			
			return tmpVO;
		}
	};

	public MyPageDaoImpl() {
		super();
	}

	@SuppressWarnings({ "deprecation" })
	public MyPageVO doSelectOne(MyPageVO inVO) throws ClassNotFoundException, SQLException {
		MyPageVO outVO = null;

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

		Object[] args = { inVO.getNickName() };
		LOG.debug("args=" + args);
		LOG.debug("=========================================");
		outVO = this.jdbcTemplate.queryForObject(sb.toString(), args, rowMapper);

		LOG.debug("=========================================");
		LOG.debug("outVO=\n" + outVO.toString());
		LOG.debug("=========================================");

		return outVO;
	}

	@SuppressWarnings({ "deprecation" })
	public int doUpdate(MyPageVO myPage) throws SQLException {
		int flag = 0;
        
        StringBuilder sb = new StringBuilder();
        sb.append(" UPDATE hr_member           \n");
        sb.append(" SET                        \n");
        sb.append("     profileImg = ?,        \n");
        sb.append("     nickName   = ?,        \n");
        sb.append("     rank   	   = ?,        \n");
        sb.append("     selectDate = sysdate,  \n");
        sb.append("     cLike 	   = ?,        \n");
        //2021/08/30 추가 컬럼:email,reg_dt
        sb.append(" WHERE u_id = ?             \n");
		LOG.debug("=========================================");
		LOG.debug("sql=\n" + sb.toString());
		LOG.debug("param=" + myPage.toString());
		LOG.debug("=========================================");		
		Object[] args = { myPage.getProfileImg(), 
				          myPage.getNickName(), 
				          myPage.getRank(),
				          myPage.getSelectDate(),
				          myPage.getcLike()  };		
		
		flag = this.jdbcTemplate.update(sb.toString(), args);
		
		LOG.debug("flag=" + flag);
		return flag;
		
	}

	@SuppressWarnings({ "deprecation" })
	public List<?> doRetrieve(MyPageVO myPage) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
