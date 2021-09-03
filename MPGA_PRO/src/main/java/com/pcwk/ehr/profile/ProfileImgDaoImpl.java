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
	private DataSource dataSource;
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

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	/**
	 * 프로필 이미지 리스트
	 * @return
	 */
	
	@SuppressWarnings({ "deprecation" })
	public List<ProfileImgVO> getAll() {
		List<ProfileImgVO> list = new ArrayList<ProfileImgVO>();
		StringBuilder sb = new StringBuilder(100);
		sb.append("SELECT 	seq					 	  				  	 \n");
		sb.append(" 		pro_img_path			 					 \n");
		sb.append("			mod_dt										 \n");
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
	 * 프로필 이미지 등록 및 수정
	 * @param inVO
	 * @return ProfileImgVO
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	
	@SuppressWarnings({ "deprecation" })
	public int doMerge(ProfileImgVO img) throws SQLException {
		int flag = 0;
		
		StringBuilder sb = new StringBuilder();	
		sb.append(" MERGE INTO 	profile_img							 	 \n");
		sb.append("	USING DUAL											 \n");
		sb.append("	ON	(				)								 \n");
		sb.append("	WHEN MATCHED THEN									 \n");
		sb.append("	UPDATE SET	(				)						 \n");
		sb.append("	WHEN MATCHED THEN 									 \n");
		sb.append("	INSERT (seq,pro_img_path,mod_dt,reg_num)			 \n");
		sb.append("	VALUES (?,?,sysdate,?)								 \n");
		LOG.debug("=======================================");
		LOG.debug("sql=\n" + sb.toString());

		Object[] args = {};
		LOG.debug("args" + args);
		LOG.debug("=======================================");
		flag = this.jdbcTemplate.update(sb.toString(), args, rowMapper);


		return flag;
	}
	
}
