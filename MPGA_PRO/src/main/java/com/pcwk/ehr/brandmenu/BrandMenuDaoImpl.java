package com.pcwk.ehr.brandmenu;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class BrandMenuDaoImpl implements BrandMenuDao {
	final Logger  LOG = LoggerFactory.getLogger(getClass());
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	RowMapper<BrandMenuVO> rowMapper = new RowMapper<BrandMenuVO>() {

		public BrandMenuVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			BrandMenuVO tmpVO = new BrandMenuVO();

			
			tmpVO.setmNum(rs.getString("m_num"));
			tmpVO.setbCode(rs.getString("b_cod"));
			tmpVO.setmName(rs.getString("m_name"));
			tmpVO.setmInfo(rs.getString("m_info"));
			tmpVO.setmImg(rs.getString("m_img"));
			tmpVO.setmRegdt(rs.getString("m_reg_num"));
			tmpVO.setModDt(rs.getString("mod_dt"));
			tmpVO.setRegNum(rs.getInt("reg_num"));

			return tmpVO;
		}
	};
	private Object menu;
	

	public BrandMenuDaoImpl() {
	}
	
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	
	@SuppressWarnings({ "deprecation" })
	public List<BrandMenuVO> getAll() {
		List<BrandMenuVO> list = new ArrayList<BrandMenuVO>();
		StringBuilder sb = new StringBuilder(100);
		sb.append(" SELECT m_num,                                      \n");
		sb.append("        b_cod,                                         \n");
		sb.append("        m_name,                                    	  \n");                                      
		sb.append(" 	   m_info,                                    	  \n");
		sb.append(" 	   m_iMG,                                         \n");
		sb.append(" 	   m_Regdt,                                    \n");
		sb.append(" 	   mod_dt,                                   	  \n");
		sb.append(" 	   reg_num,	                                  \n");
		sb.append(" FROM   menu	                                          \n");
		sb.append(" ORDER BY b_cod                                        \n");

		LOG.debug("sql=\n" + sb.toString());
		Object[] args = {};
		list = this.jdbcTemplate.query(sb.toString(), args, rowMapper);

		for (BrandMenuVO vo : list) {
			LOG.debug("vo:" + vo);
		}

		return list;
	}
	
	/**
	 * 등록 메뉴 건수
	 * @return cnt
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	
	@SuppressWarnings("deprecation")
	public int getCount() throws ClassNotFoundException, SQLException {
		int cnt = 0;

		StringBuilder sb = new StringBuilder(50);
		sb.append(" SELECT COUNT(*) cnt FROM brandMenu					      \n");
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
	 * 메뉴 조회
	 * @param inVO
	 * @return brandMenuVO
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */

	@SuppressWarnings("deprecation")
	public BrandMenuVO doSelectOne(BrandMenuDao inVO) throws ClassNotFoundException, SQLException {
		BrandMenuVO outVO = null;
		
		StringBuilder sb = new StringBuilder(50);
		sb.append(" SELECT menu_num,                                      \n");
		sb.append("        b_cod,                                         \n");
		sb.append("        m_name,                                    	  \n");                                      
		sb.append(" 	   m_info,                                    	  \n");
		sb.append(" 	   m_img,                                         \n");
		sb.append(" 	   m_regdt,                                       \n");
		sb.append(" 	   mod_dt,                                   	  \n");
		sb.append(" 	   reg_num,		                                  \n");
		sb.append(" FROM   menu	                                          \n");
		sb.append(" WHERE  b_cod = ?                                        \n");
		
		
		LOG.debug("=========================================");
		LOG.debug("sql=\n" + sb.toString());

		Object[] args = { inVO.getmCode() };
		LOG.debug("args=" + args);
		LOG.debug("=========================================");
		outVO = this.jdbcTemplate.queryForObject(sb.toString(), args, rowMapper);

		LOG.debug("=========================================");
		LOG.debug("outVO=\n" + outVO.toString());
		LOG.debug("=========================================");

		return outVO;
	}
	
	
	/**
	 * 메뉴 등록
	 * @param inVO
	 * @return :성공(1)/실패(0)
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	
	public int doInsert(final BrandMenuVO brandmenu) throws ClassNotFoundException, SQLException {
		int flag = 0;
		StringBuilder sb = new StringBuilder();
		sb.append(" INSERT INTO menu (m_num,m_cod,m_name,m_info,m_img,m_regdt,mod_dt,reg_num) \n");
		sb.append(" VALUES (?,?,?,?,?,?,?,sysdate)                                 	                \n");
		LOG.debug("=========================================");
		LOG.debug("sql=\n" + sb.toString());
		LOG.debug("param=" + brandmenu.toString());
		LOG.debug("=========================================");

		Object[] args = { brandmenu.getmNum(),
						  brandmenu.getbCode(),
						  brandmenu.getmImg(),
						  brandmenu.getmInfo(),
						  brandmenu.getmName(),
						  brandmenu.getModDt(),
						  brandmenu.getmRegdt(),
						  brandmenu.getRegNum() };
		
		LOG.debug("args=" + args);
		flag = this.jdbcTemplate.update(sb.toString(), args);
		LOG.debug("flag=" + flag);

		return flag;
	}
	
	
	/**
	 * 메뉴 삭제
	 * @param brandmenu
	 * @return :성공(1)/실패(0)
	 * @throws SQLException
	 */
	
	public int doDelete (BrandMenuVO brandmenu) throws SQLException {
		int flag = 0;
		StringBuilder sb = new StringBuilder();
		sb.append(" DELETE FROM hr_member \n");
		sb.append(" WHERE u_id = ?        \n");
		LOG.debug("=========================================");
		LOG.debug("sql=\n" + sb.toString());
		LOG.debug("param=" + brandmenu.toString());
		LOG.debug("=========================================");
		Object[] args = { brandmenu.getbCode()};
		LOG.debug("args=" + args);
		flag = this.jdbcTemplate.update(sb.toString(), args);		
		LOG.debug("flag=" + flag);
		
		return flag;
	}
	
	
	/**
	 * 브랜드 수정
	 * @param brandmenu
	 * @return :성공(1)/실패(0)
	 * @throws SQLException
	 */
	
	public int doUpdate(BrandMenuVO brandmenu) throws SQLException {
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
		LOG.debug("param=" + brandmenu.toString());
		LOG.debug("=========================================");		
		Object[] args = { 
						   	  brandmenu.getmNum(),
							  brandmenu.getbCode(),
							  brandmenu.getmImg(),
							  brandmenu.getmInfo(),
							  brandmenu.getmName(),
							  brandmenu.getModDt(),
							  brandmenu.getmRegdt(),
							  brandmenu.getRegNum() };

		
		LOG.debug("args=" + args);
		flag = this.jdbcTemplate.update(sb.toString(), args);
		LOG.debug("flag=" + flag);
		
		return flag;
	}
	
	
	public List<?> doRetrieve(BrandMenuDao brand) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public BrandMenuVO doSelectOne(BrandMenuVO inVO) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<?> doRetrieve(BrandMenuVO brand) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Object getmCode() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
