package com.pcwk.ehr.profileImg;

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
public class ProfileImgDaoImpl implements ProfileImgDao {
	
	final Logger  LOG = LoggerFactory.getLogger(getClass());

	@Autowired
	SqlSessionTemplate   sqlSessionTemplate;

	final String NAMESPACE = "com.pcwk.ehr.profileImg";
	
	public ProfileImgDaoImpl() {}

	
	
	
	/**
	 * 프로필 이미지 조회
	 * @return
	 */
	@Override
	@SuppressWarnings({ "deprecation" })
	public List<ProfileImgVO> getAll() {
		List<ProfileImgVO> list = new ArrayList<ProfileImgVO>();
		String statement = this.NAMESPACE +".getAll";
		
		list = this.sqlSessionTemplate.selectList(statement);
		for (ProfileImgVO vo : list) {
			LOG.debug("vo:" + vo);
		}
		return list;
	}

	
	
	
	/**
	 * 프로필 이미지 검색
	 * @param searchVO
	 * @return list
	 * @throws SQLException
	 */
	@Override
	public List<?> doRetrieve(SearchVO searchVO) throws SQLException {
		List<ProfileImgVO>   list = new ArrayList<ProfileImgVO>();
		
		String statement = this.NAMESPACE +".doRetrieve";
		LOG.debug("=========================================");
		LOG.debug("statement" + statement);
		LOG.debug("searchVO" + searchVO);
		LOG.debug("=========================================");		
		
		list = this.sqlSessionTemplate.selectList(statement, searchVO);
		
		for (ProfileImgVO vo : list) {
			LOG.debug("vo:" + vo);
		}		
		return list;
	}
	
	
	
	
	/**
	 * 등록 프로필 건수
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
	 * 프로필 전체삭제
	 * @throws SQLException
	 */
	@Override
	public void deleteAll() throws SQLException {
		String statement = NAMESPACE + ".deleteAll";
		int flag = sqlSessionTemplate.delete(statement);
		LOG.debug("=========================================");
		LOG.debug("flag=" + flag);
		LOG.debug("=========================================");		
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
		LOG.debug("=========================================");
		LOG.debug("param=" + img.toString());
		LOG.debug("=========================================");

		String statement = NAMESPACE + ".doInsert";
		
		flag = sqlSessionTemplate.insert(statement, img);
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
		LOG.debug("=========================================");
		LOG.debug("param=" + img.toString());
		LOG.debug("=========================================");

		String statement = NAMESPACE + ".doDelete";
		
		flag = this.sqlSessionTemplate.delete(statement, img);
		
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
       
        LOG.debug("=========================================");
		LOG.debug("param=" + img.toString());
		LOG.debug("=========================================");		
		
		
		String statement  = NAMESPACE +".doUpdate";
		flag = sqlSessionTemplate.update(statement, img);
		LOG.debug("flag=" + flag);
		
		return flag;
	}

}
