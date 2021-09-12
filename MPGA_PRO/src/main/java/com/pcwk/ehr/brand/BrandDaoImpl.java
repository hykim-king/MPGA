package com.pcwk.ehr.brand;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.pcwk.ehr.SearchVO;

@Repository
public class BrandDaoImpl implements BrandDao {
	final Logger  LOG = LoggerFactory.getLogger(getClass());
		
	@Autowired
	SqlSessionTemplate   sqlSessionTemplate;

	final String NAMESPACE = "com.pcwk.ehr.brand";
	
	public BrandDaoImpl() {}	
	
	
	
	/**
	 * 브랜드 전체 조회
	 * @return list
	 */
	
	@Override
	@SuppressWarnings({ "deprecation" })
	public List<BrandVO> getAll() {
		List<BrandVO> list = new ArrayList<BrandVO>();
		
		String statement = this.NAMESPACE +".getAll";
		
		list = this.sqlSessionTemplate.selectList(statement);
		for (BrandVO vo : list) {
			LOG.debug("vo:" + vo);
		}
		return list;
	}
	
	/**
	 * 브랜드 단건 조회
	 * @param searchVO
	 * @return list
	 * @throws SQLException
	 */
	
	@Override
	public List<?> doRetrieve(SearchVO searchVO) throws SQLException {
		List<BrandVO>   list = new ArrayList<BrandVO>();
		
		String statement = this.NAMESPACE +".doRetrieve";
		LOG.debug("=========================================");
		LOG.debug("statement" + statement);
		LOG.debug("searchVO" + searchVO);
		LOG.debug("=========================================");		
		
		list = this.sqlSessionTemplate.selectList(statement, searchVO);
		
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

		String statement = this.NAMESPACE +".getCount";
		
		cnt = this.sqlSessionTemplate.selectOne(statement);
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
	 * 브랜드 등록
	 * @param inVO
	 * @return :성공(1)/실패(0)
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	@Override
	public int doInsert(final BrandVO brand) throws ClassNotFoundException, SQLException {
		int flag = 0;
		LOG.debug("=========================================");
		LOG.debug("param=" + brand.toString());
		LOG.debug("=========================================");

		String statement = NAMESPACE + ".doInsert";
		
		flag = sqlSessionTemplate.insert(statement, brand);
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
		LOG.debug("=========================================");
		LOG.debug("param=" + brand.toString());
		LOG.debug("=========================================");
		
		String statement = NAMESPACE + ".doDelete";
		
		flag = this.sqlSessionTemplate.delete(statement, brand);
		
		LOG.debug("flag=" + flag);
		return flag;
	}
	
	
	
	
	
	
	/**
	 * 브랜드 수정
	 * @param brand
	 * @return :성공(1)/실패(0)
	 * @throws SQLException
	 */ 
	
	public int doUpdate(BrandVO brand) throws SQLException {
        int flag = 0;
        
		LOG.debug("=========================================");
		LOG.debug("param=" + brand.toString());
		LOG.debug("=========================================");		
		
		
		String statement  = NAMESPACE +".doUpdate";
		flag = sqlSessionTemplate.update(statement, brand);
		LOG.debug("flag=" + flag);
		
		return flag;
	}

}
