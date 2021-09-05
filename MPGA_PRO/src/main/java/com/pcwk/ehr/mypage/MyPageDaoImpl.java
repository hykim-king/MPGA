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
			// 2021/08/25 추가컬럼.
			tmpVO.setSelectDate(rs.getString("select_date"));
			tmpVO.setcLike(rs.getString("c_like")); 
			
			return tmpVO;
		}
	};

	public MyPageDaoImpl() {
		super();
	}
	
	@SuppressWarnings({ "deprecation" })
	public MyPageVO doSelectOneProfileImg(MyPageVO inVO) throws ClassNotFoundException, SQLException {
		MyPageVO outVO = null;
		
		StringBuilder sb = new StringBuilder(50);
		sb.append(" SELECT pro_img_path,	                                   \n");
		sb.append(" FROM   profile_img                                          \n");
		sb.append(" WHERE  seq = ?                                         \n");
		LOG.debug("=========================================");
		LOG.debug("sql=\n" + sb.toString());
		
		//어떤 내용으로 사용되는지 알아보기.
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
	public MyPageVO doSelectOnePersonal(MyPageVO inVO) throws ClassNotFoundException, SQLException {
		MyPageVO outVO = null;

		// 2.
		StringBuilder sb = new StringBuilder(50);
		sb.append(" SELECT nickname,	                                   \n");
		sb.append("		   m_rank 										   \n");
		sb.append(" FROM   member                                          \n");
		sb.append(" WHERE  member_num = ?                                         \n");
		LOG.debug("=========================================");
		LOG.debug("sql=\n" + sb.toString());
		
		//어떤 내용으로 사용되는지 알아보기.
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
	public MyPageVO doSelectOneSelect(MyPageVO inVO) throws ClassNotFoundException, SQLException {
		MyPageVO outVO = null;

		// 2.
		StringBuilder sb = new StringBuilder(50);
		sb.append(" SELECT select_date,	                            \n");
		sb.append(" FROM   menu_select                              \n");		
		sb.append(" WHERE  member_num = ?                           \n");
		sb.append(" 	   menu_num   = ? 				   			\n");
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
	public MyPageVO doSelectOneComment(MyPageVO inVO) throws ClassNotFoundException, SQLException {
		MyPageVO outVO = null;

		// 2.
		StringBuilder sb = new StringBuilder(50);
		sb.append(" SELECT contents,	                            \n");
		sb.append(" FROM   menu_comment                         \n");		
		sb.append(" WHERE  menu_num = ?                         \n");
		sb.append(" 	   seq	      = ? 				   	    \n");
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
	public int doUpdateProfileImg(MyPageVO myPage) throws SQLException {
		int flag = 0;
        
        StringBuilder sb = new StringBuilder();
        sb.append(" UPDATE profile_img         \n");
        sb.append(" SET                        \n");
        sb.append("     profileImg = ?        \n");
        //2021/08/30 추가 컬럼:email,reg_dt
        sb.append(" WHERE seq = ?             \n");
		LOG.debug("=========================================");
		LOG.debug("sql=\n" + sb.toString());
		LOG.debug("param=" + myPage.toString());
		LOG.debug("=========================================");		
		Object[] args = { myPage.getProfileImg() };
				          
		
		flag = this.jdbcTemplate.update(sb.toString(), args);
		
		LOG.debug("flag=" + flag);
		return flag;
		
	}
	
	@SuppressWarnings({ "deprecation" })
	public int doUpdatePersonal(MyPageVO myPage) throws SQLException {
		int flag = 0;
        
        StringBuilder sb = new StringBuilder();
        sb.append(" UPDATE member              \n");
        sb.append(" SET                        \n");
        sb.append("     nickName   = ?,        \n");
        sb.append("     rank   	   = ?         \n");
        //2021/08/30 추가 컬럼:email,reg_dt
        sb.append(" WHERE member_num = ?       \n");
		LOG.debug("=========================================");
		LOG.debug("sql=\n" + sb.toString());
		LOG.debug("param=" + myPage.toString());
		LOG.debug("=========================================");		
		Object[] args = { 
				          myPage.getNickName(), 
				          myPage.getRank(),
				        };		
		
		flag = this.jdbcTemplate.update(sb.toString(), args);
		
		LOG.debug("flag=" + flag);
		return flag;
		
	}
	
	@SuppressWarnings({ "deprecation" })
	public int doUpdateSelect(MyPageVO myPage) throws SQLException {
		int flag = 0;
        
        StringBuilder sb = new StringBuilder();
        sb.append(" UPDATE menu_select         \n");
        sb.append(" SET                        \n");
        sb.append("     selectDate = sysdate,  \n");
        //2021/08/30 추가 컬럼:email,reg_dt
        sb.append(" WHERE member_num = ?       \n");
        sb.append("       menu_num   = ?       \n");
		LOG.debug("=========================================");
		LOG.debug("sql=\n" + sb.toString());
		LOG.debug("param=" + myPage.toString());
		LOG.debug("=========================================");		
		Object[] args = { 
				          myPage.getSelectDate()
				        };		
		
		flag = this.jdbcTemplate.update(sb.toString(), args);
		
		LOG.debug("flag=" + flag);
		return flag;
		
	}
	
	@SuppressWarnings({ "deprecation" })
	public int doUpdateComment(MyPageVO myPage) throws SQLException {
		int flag = 0;
        
        StringBuilder sb = new StringBuilder();
        sb.append(" UPDATE comment_like        \n");
        sb.append(" SET                        \n");
        sb.append("     cLike 	   = ?,        \n");
        //2021/08/30 추가 컬럼:email,reg_dt
        sb.append(" WHERE member_num = ?       \n");
        sb.append(" 	  c_like = ?           \n");
		LOG.debug("=========================================");
		LOG.debug("sql=\n" + sb.toString());
		LOG.debug("param=" + myPage.toString());
		LOG.debug("=========================================");		
		Object[] args = { 
				          myPage.getcLike()  
				        };		
		
		flag = this.jdbcTemplate.update(sb.toString(), args);
		
		LOG.debug("flag=" + flag);
		return flag;
		
	}

	@SuppressWarnings({ "deprecation" })
	public List<?> doRetrieve(MyPageVO myPage) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MyPageVO doSelectOne(MyPageVO inVO) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int doUpdate(MyPageVO myPage) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int doInsert(MyPageVO myPageVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int doDelete(MyPageVO myPageVO) {
		// TODO Auto-generated method stub
		return 0;
	}

}
