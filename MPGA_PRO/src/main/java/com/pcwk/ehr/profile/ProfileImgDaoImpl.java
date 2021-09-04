package com.pcwk.ehr.profile;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class ProfileImgDaoImpl implements ProfileImgDao {

	final Logger  LOG = LoggerFactory.getLogger(getClass());
	private JdbcTemplate jdbcTemplate;

	RowMapper<ProfileImgVO> rowMapper = new RowMapper<ProfileImgVO>() {

		public ProfileImgVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			ProfileImgVO tmpVO = new ProfileImgVO();

			tmpVO.setSeq(rs.getInt("seq"));
			tmpVO.setProImgPath(rs.getString("pro_img_path"));
			tmpVO.setModDt(rs.getString("mod_dt"));
			tmpVO.setRegNum(rs.getInt("reg_num"));

			return tmpVO;

		}
	};

	public ProfileImgDaoImpl() {
	}

	
	@Override
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	/**
	 * 프로필 이미지 리스트
	 * @return
	 */
	
	
	@Override
	@SuppressWarnings({ "deprecation" })
	public List<ProfileImgVO> getAll() {
		List<ProfileImgVO> list = new ArrayList<ProfileImgVO>();
		StringBuilder sb = new StringBuilder(100);
		sb.append("SELECT 	seq,					 	  				 \n");
		sb.append(" 		pro_img_path,			 					 \n");
		sb.append("			mod_dt,										 \n");
		sb.append(" 		reg_num					 					 \n");
		sb.append("FROM		profile_img	 								 \n");
		sb.append("ORDER BY seq											 \n");
		LOG.debug("=====================================");
		LOG.debug("sql=\n" + sb.toString());

		Object[] args = {};
		list = this.jdbcTemplate.query(sb.toString(), args, rowMapper);

		for (ProfileImgVO vo : list) {
			LOG.debug("vo" + vo);
		}

		return list;
	}

	
	/**
	 * 프로필 조회
	 * @param inVO
	 * @return UserVO
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	@Override
	@SuppressWarnings("deprecation")
	public ProfileImgVO doSelectOne(ProfileImgVO inVO) throws ClassNotFoundException, SQLException {
		ProfileImgVO outVO = null;

		// 2.
		StringBuilder sb = new StringBuilder(50);
		sb.append(" SELECT seq,                                     	 \n");
		sb.append("        pro_img_path,                                 \n");
		sb.append(" 	   TO_CHAR(mod_dt,'YYYY/MM/DD HH24MISS') mod_dt, \n");
		sb.append(" 	   reg_num										 \n");
		sb.append(" FROM profile_img                                     \n");
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

	
	
	/**
	 * 프로필 등록
	 * @param img
	 * @return :성공(1)/실패(0)
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	
	@Override
	public int doInsert(final ProfileImgVO img) throws ClassNotFoundException, SQLException {
		int flag = 0;
		StringBuilder sb = new StringBuilder();
		sb.append(" INSERT INTO profile_img (seq,pro_img_path,mod_dt,reg_num)  \n");
		sb.append(" VALUES (?,?,sysdate,?)                               \n");
		LOG.debug("=========================================");
		LOG.debug("sql=\n" + sb.toString());
		LOG.debug("param=" + img.toString());
		LOG.debug("=========================================");

		Object[] args = { img.getSeq(), 
						  img.getProImgPath(), 
						  img.getModDt(),
						  img.getRegNum(),};
		LOG.debug("args=" + args);
		flag = this.jdbcTemplate.update(sb.toString(), args);
		LOG.debug("flag=" + flag);

		return flag;
	}
	
	
	/**
	 * 프로필 삭제
	 * @param img
	 * @return :성공(1)/실패(0)
	 * @throws SQLException
	 */
	
	@Override
	public int doDelete(ProfileImgVO img) throws SQLException {
		int flag = 0;
		StringBuilder sb = new StringBuilder();
		sb.append(" DELETE FROM profile_img 						 	 \n");
		sb.append(" WHERE seq = ?      								     \n");
		LOG.debug("=========================================");
		LOG.debug("sql=\n" + sb.toString());
		LOG.debug("param=" + img.toString());
		LOG.debug("=========================================");
		Object[] args = { img.getSeq()};
		LOG.debug("args=" + args);
		flag = this.jdbcTemplate.update(sb.toString(), args);		
		LOG.debug("flag=" + flag);
		
		return flag;
	}
	
	
	/**
	 * 프로필 수정
	 * @param brand
	 * @return :성공(1)/실패(0)
	 * @throws SQLException
	 */
	
	@Override
	public int doUpdate(ProfileImgVO img) throws SQLException {
        int flag = 0;
        
        StringBuilder sb = new StringBuilder();	
        sb.append(" UPDATE profile_img     		 						 \n");
        sb.append(" SET               	 							 	 \n");
        sb.append("   	  seq     		 = ?,	  						 \n");
        sb.append("   	  pro_img_path   = ?,  						 	 \n");
        sb.append("   	  mod_dt		 = sysdate,  		   			 \n");
        sb.append("   	  reg_num  		 = ?  							 \n");
        sb.append(" WHERE seq 			 = ?        					 \n");
		LOG.debug("=========================================");
		LOG.debug("sql=\n" + sb.toString());
		LOG.debug("param=" + img.toString());
		LOG.debug("=========================================");		
		Object[] args = { img.getSeq(), 
						  img.getProImgPath(), 
						  img.getModDt(),
						  img.getRegNum(),};
		LOG.debug("args=" + args);
		flag = this.jdbcTemplate.update(sb.toString(), args);
		LOG.debug("flag=" + flag);
		
		return flag;
	}
	
	
	@Override
	public List<?> doRetrieve(ProfileImgVO img) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
