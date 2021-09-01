package com.pcwk.ehr.brand;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class BrandDaoImpl implements brandDao {
	final static Logger LOG = Logger.getLogger(BrandDaoImpl.class);
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	RowMapper<BrandVO> rowMapper = new RowMapper<BrandVO>() {

		public BrandVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			BrandVO tmpVO = new BrandVO();

			tmpVO.setbCode(rs.getString("b_cod"));
			tmpVO.setbLogoImg(rs.getString("b_logo_img"));
			tmpVO.setbUrl(rs.getString("b_url"));
			tmpVO.setbItr(rs.getString("b_itr"));
			tmpVO.setbName(rs.getString("b_name"));
			tmpVO.setModDt(rs.getString("mod_dt"));
			tmpVO.setRegNum(rs.getInt("reg_num"));

			return tmpVO;
		}
	};

	public BrandDaoImpl() {
	}
	
	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	@SuppressWarnings({ "deprecation" })
	public List<BrandVO> getAll() {
		List<BrandVO> list = new ArrayList<BrandVO>();
		StringBuilder sb = new StringBuilder(100);
		sb.append(" SELECT b_cod,                                         \n");
		sb.append("        b_logo_img,                                    \n");
		sb.append("        b_url,                                    	  \n");                                      
		sb.append(" 	   b_itr,                                    	  \n");
		sb.append(" 	   b_name,                                        \n");
		sb.append(" 	   mod_dt,                                   	  \n");
		sb.append(" 	   reg_num,		                                  \n");
		sb.append(" FROM brand	                                          \n");
		sb.append(" ORDER BY b_cod                                        \n");

		LOG.debug("sql=\n" + sb.toString());
		Object[] args = {};
		list = this.jdbcTemplate.query(sb.toString(), args, rowMapper);

		for (BrandVO vo : list) {
			LOG.debug("vo:" + vo);
		}

		return list;
	}
	
	/**
	 * 등록 브랜드 건수
	 * @return cnt
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	
	@Override
	@SuppressWarnings("deprecation")
	public int getCount() throws ClassNotFoundException, SQLException {
		int cnt = 0;

		StringBuilder sb = new StringBuilder(50);
		sb.append(" SELECT COUNT(*) cnt FROM brand					      \n");
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
	 * 브랜드 조회
	 * @param inVO
	 * @return brandVO
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	
	@Override
	@SuppressWarnings("deprecation")
	public BrandVO doSelectOne(BrandVO inVO) throws ClassNotFoundException, SQLException {
		BrandVO outVO = null;

		StringBuilder sb = new StringBuilder(50);
		sb.append(" SELECT b_cod,                                         \n");
		sb.append("        b_logo_img,                                    \n");
		sb.append("        b_url,                                    	  \n");                                      
		sb.append(" 	   b_itr,                                    	  \n");
		sb.append(" 	   b_name,                                        \n");
		sb.append(" 	   mod_dt,                                   	  \n");
		sb.append(" 	   reg_num,		                                  \n");
		sb.append(" FROM   brand	                                      \n");
		sb.append(" WHERE  b_cod = ?  									  \n");
		LOG.debug("=========================================");
		LOG.debug("sql=\n" + sb.toString());

		Object[] args = { inVO.getbCode() };
		LOG.debug("args=" + args);
		LOG.debug("=========================================");
		outVO = this.jdbcTemplate.queryForObject(sb.toString(), args, rowMapper);

		LOG.debug("=========================================");
		LOG.debug("outVO=\n" + outVO.toString());
		LOG.debug("=========================================");

		return outVO;
	}
	
	
	/**
	 * 브랜드 등록
	 * @param inVO
	 * @return :성공(1)/실패(0)
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	
	@Override
	public int doInsert(final BrandVO brand) throws ClassNotFoundException, SQLException {
		int flag = 0;
		StringBuilder sb = new StringBuilder();
		sb.append(" INSERT INTO brand (b_cod,b_logo_img,b_url,b_itr,b_name,mod_dt,reg_num) \n");
		sb.append(" VALUES (?,?,?,?,?,?,sysdate)                                 	       \n");
		LOG.debug("=========================================");
		LOG.debug("sql=\n" + sb.toString());
		LOG.debug("param=" + brand.toString());
		LOG.debug("=========================================");

		Object[] args = { brand.getbCode(), 
						  brand.getbLogoImg(), 
						  brand.getbUrl(),
						  brand.getbItr(),
						  brand.getbName(),
						  brand.getModDt(), 
						  brand.getRegNum() };
		LOG.debug("args=" + args);
		flag = this.jdbcTemplate.update(sb.toString(), args);
		LOG.debug("flag=" + flag);

		return flag;
	}
	
	
	/**
	 * 브랜드 삭제
	 * @param brand
	 * @return :성공(1)/실패(0)
	 * @throws SQLException
	 */
	
	@Override
	public int doDelete(BrandVO brand) throws SQLException {
		int flag = 0;
		StringBuilder sb = new StringBuilder();
		sb.append(" DELETE FROM hr_member \n");
		sb.append(" WHERE u_id = ?        \n");
		LOG.debug("=========================================");
		LOG.debug("sql=\n" + sb.toString());
		LOG.debug("param=" + brand.toString());
		LOG.debug("=========================================");
		Object[] args = { brand.getbCode()};
		LOG.debug("args=" + args);
		flag = this.jdbcTemplate.update(sb.toString(), args);		
		LOG.debug("flag=" + flag);
		
		return flag;
	}
	
	
	/**
	 * 브랜드 수정
	 * @param brand
	 * @return :성공(1)/실패(0)
	 * @throws SQLException
	 */
	
	@Override
	public int doUpdate(BrandVO brand) throws SQLException {
        int flag = 0;
        
        StringBuilder sb = new StringBuilder();
        sb.append(" UPDATE hr_member       \n");
        sb.append(" SET               	   \n");
        sb.append("     name      = ?,	   \n");
        sb.append("     passwd    = ?,     \n");
        sb.append("     u_level   = ?,     \n");
        sb.append("     login     = ?,     \n");
        sb.append("     recommend = ?,     \n");
        sb.append("     email 	  = ?,     \n");
        sb.append("     reg_dt = sysdate   \n");
        sb.append(" WHERE u_id = ?         \n");
		LOG.debug("=========================================");
		LOG.debug("sql=\n" + sb.toString());
		LOG.debug("param=" + brand.toString());
		LOG.debug("=========================================");		
		Object[] args = { brand.getbCode(), 
				  brand.getbLogoImg(), 
				  brand.getbUrl(),
				  brand.getbItr(),
				  brand.getbName(),
				  brand.getModDt(), 
				  brand.getRegNum() };
		LOG.debug("args=" + args);
		flag = this.jdbcTemplate.update(sb.toString(), args);
		LOG.debug("flag=" + flag);
		
		return flag;
	}
	
	
	@Override
	public List<?> doRetrieve(BrandVO brand) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
