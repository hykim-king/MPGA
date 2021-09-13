package com.pcwk.ehr.menucomment;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pcwk.ehr.SearchMineVO;
import com.pcwk.ehr.SearchVO;
import com.pcwk.ehr.brandmenu.BrandMenuVO;
import com.pcwk.ehr.menuscore.MenuScoreVO;

@Repository
public class MenuCommentDaoImpl implements MenuCommentDao {

	final Logger LOG = LoggerFactory.getLogger(getClass());
	
	@Autowired
	SqlSessionTemplate   sqlSessionTemplate;
	
	final String NAMESPACE = "com.pcwk.ehr.menucomment";

	public MenuCommentDaoImpl() {
	
	}
	
	
	
	/**
	 * 내가 쓴 댓글 목록
	 * @param searchMineVO
	 * @return list
	 * @throws SQLException
	 */
	@Override
	public List<?> menuCommentList(SearchMineVO searchMineVO) throws SQLException {		
		List<MenuCommentVO>   list = new ArrayList<MenuCommentVO>();

		String statement = this.NAMESPACE+".getMenuCommentList";                                  
		
		LOG.debug("========================");
		LOG.debug("param: " + statement);
		LOG.debug("statement: " + searchMineVO);
		LOG.debug("========================");
		
		list = this.sqlSessionTemplate.selectList(statement, searchMineVO);
		
		for (MenuCommentVO vo : list) {
			LOG.debug("vo:" + vo);
		}		
		return list;
	}
	
	
	/**
	 *   댓글 전체 조회
	 * @return list
	 */	 
	@Override
	@SuppressWarnings({ "deprecation" })
	public List<MenuCommentVO> getAll() {
		List<MenuCommentVO> list = new ArrayList<MenuCommentVO>();

		String statement = NAMESPACE + ".getAll";

		list = this.sqlSessionTemplate.selectList(statement);
		for (MenuCommentVO vo : list) {
			LOG.debug("vo" + vo);
		}

		return list;
	}

	
	
	/**
	 * 등록 댓글 건수
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
	 * 댓글 등록
	 * @param inVO
	 * @return :성공(1)/실패(0)
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	@Override
	public int doInsert(MenuCommentVO comment) throws SQLException {
		int flag = 0;

		LOG.debug("=======================================");
		LOG.debug("param=" + comment.toString());
		LOG.debug("=======================================");

		String statement = NAMESPACE + ".doInsert";
		flag = this.sqlSessionTemplate.insert(statement, comment);
				
		LOG.debug("flag=" + flag);
		return flag;

	}
	
	
	
	
	
	/**
	 *   댓글 전체삭제
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
	 *   댓글 단건 조회
	 * @param inVO
	 * @return brandMenuVO
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	 
	@Override
	@SuppressWarnings("deprecation")
	public MenuCommentVO doSelectOne(MenuCommentVO inVO) throws ClassNotFoundException, SQLException {
		MenuCommentVO outVO = null;
		
		String statement = NAMESPACE + ".doSelectOne";

		LOG.debug("=========================================");
		LOG.debug("inVO=" + inVO.toString());
		LOG.debug("statement=" + statement);
		LOG.debug("=========================================");
		
		outVO = this.sqlSessionTemplate.selectOne(statement, inVO);
		LOG.debug("outVO=" + outVO);

		return outVO;

	}



	/**
	 *   댓글 수정
	 * @param brandmenu
	 * @return :성공(1)/실패(0)
	 * @throws SQLException
	 */
	@Override
	public int doUpdate(MenuCommentVO comment) throws SQLException {
		int flag = 0;
	
		LOG.debug("=========================================");
		LOG.debug("param=" + comment.toString());
		LOG.debug("=========================================");
		
		String statement = NAMESPACE + ".doUpdate";
		flag = this.sqlSessionTemplate.update(statement, comment);
		
		LOG.debug("flag=" + flag);
		return flag;
	}



	
	/**
	 * 댓글 삭제
	 * @param brandmenu
	 * @return :성공(1)/실패(0)
	 * @throws SQLException
	 */
	@Override
	public int doDelete(MenuCommentVO comment) throws SQLException {
		int flag = 0;
		
		LOG.debug("=========================================");
		LOG.debug("param=" + comment.toString());
		LOG.debug("=========================================");
		
		String statement = NAMESPACE + ".doDelete";
		flag = this.sqlSessionTemplate.delete(statement, comment);
		
		LOG.debug("flag=" + flag);
		return flag;
	}

}