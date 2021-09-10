package com.pcwk.ehr.brandmenu;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.pcwk.ehr.SearchVO;
import com.pcwk.ehr.brand.BrandVO;

@Repository
public class BrandMenuDaoImpl implements BrandMenuDao {

	final Logger  LOG = LoggerFactory.getLogger(getClass());
	
	@Autowired
	SqlSessionTemplate   sqlSessionTemplate;

	final String NAMESPACE = "com.pcwk.ehr.brandmenu";
	
	public BrandMenuDaoImpl() {}	
	
	
	/**
	 * 브랜드 메뉴 전체 조회
	 * @return list
	 */
	
	
	@Override
	@SuppressWarnings({ "deprecation" })
	public List<BrandMenuVO> getAll() {
		List<BrandMenuVO> list = new ArrayList<BrandMenuVO>();
		
		String statement = this.NAMESPACE +".getAll";
		
		list = this.sqlSessionTemplate.selectList(statement);
		for (BrandMenuVO vo : list) {
			LOG.debug("vo:" + vo);
		}
		return list;
	}
	
	
	/**
	 * 브랜드메뉴 검색
	 * @param searchVO
	 * @return list
	 * @throws SQLException
	 */
	
	@Override
	public List<?> doRetrieve(SearchVO searchVO) throws SQLException {
		List<BrandMenuVO>   list = new ArrayList<BrandMenuVO>();
		
		String statement = this.NAMESPACE +".doRetrieve";
		LOG.debug("=========================================");
		LOG.debug("statement" + statement);
		LOG.debug("searchVO" + searchVO);
		LOG.debug("=========================================");		
		
		list = this.sqlSessionTemplate.selectList(statement, searchVO);
		
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
	
	@Override
	@SuppressWarnings("deprecation")
	public int getCount() throws ClassNotFoundException, SQLException {
		int cnt = 0;

		String statement = this.NAMESPACE +".getCount";
		
		cnt = this.sqlSessionTemplate.selectOne(statement);
		LOG.debug("=========================================");
		LOG.debug("cnt=" + cnt);
		LOG.debug("=========================================");

		return cnt;
	}


	
	/**
	 * 브랜드 메뉴 조회
	 * @param inVO
	 * @return brandMenuVO
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */

	@Override
	@SuppressWarnings("deprecation")
	public BrandMenuVO doSelectOne(BrandMenuVO inVO) throws ClassNotFoundException, SQLException {
		BrandMenuVO outVO = null;

		String statement = this.NAMESPACE+".doSelectOne";
		
		
		LOG.debug("=========================================");
		LOG.debug("inVO=" + inVO.toString());
		LOG.debug("statement=" + statement);
		LOG.debug("=========================================");

		outVO = this.sqlSessionTemplate.selectOne(statement, inVO);
		LOG.debug("outVO=" + outVO);
		return outVO;
	}
	
	
	/**
	 * 브랜드 전체삭제
	 * @throws SQLException
	 */
	@Override
	public void deleteAll() throws SQLException {
		//NAMESPACE +"."+id
		String statement = NAMESPACE + ".deleteAll";
		int flag = sqlSessionTemplate.delete(statement);
		LOG.debug("=========================================");
		LOG.debug("flag=" + flag);
		LOG.debug("=========================================");		
	}
	
	
	
	/**
	 * 메뉴 등록
	 * @param inVO
	 * @return :성공(1)/실패(0)
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	
	@Override
	public int doInsert(final BrandMenuVO brandmenu) throws ClassNotFoundException, SQLException {
		int flag = 0;
		LOG.debug("=========================================");
		LOG.debug("param=" + brandmenu.toString());
		LOG.debug("=========================================");

		String statement = NAMESPACE + ".doInsert";
		
		flag = sqlSessionTemplate.insert(statement, brandmenu);
		LOG.debug("flag=" + flag);

		return flag;
	}
	
	
	/**
	 * 메뉴 삭제
	 * @param brandmenu
	 * @return :성공(1)/실패(0)
	 * @throws SQLException
	 */
	
	@Override
	public int doDelete (BrandMenuVO brandmenu) throws SQLException {
		int flag = 0;
		LOG.debug("=========================================");
		LOG.debug("param=" + brandmenu.toString());
		LOG.debug("=========================================");
		
		String statement = NAMESPACE + ".doDelete";
		
		flag = this.sqlSessionTemplate.delete(statement, brandmenu);
		
		LOG.debug("flag=" + flag);
		return flag;
	}
	
	
	
	
	
	/**
	 * 브랜드 메뉴 수정
	 * @param brandmenu
	 * @return :성공(1)/실패(0)
	 * @throws SQLException
	 */
	
	@Override
	public int doUpdate(BrandMenuVO brandmenu) throws SQLException {
		 int flag = 0;
	        
			LOG.debug("=========================================");
			LOG.debug("param=" + brandmenu.toString());
			LOG.debug("=========================================");		
			
			
			String statement  = NAMESPACE +".doUpdate";
			flag = sqlSessionTemplate.update(statement, brandmenu);
			LOG.debug("flag=" + flag);
			
			return flag;
		}

	}
