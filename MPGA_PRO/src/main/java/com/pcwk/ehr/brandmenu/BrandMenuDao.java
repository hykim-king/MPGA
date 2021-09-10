package com.pcwk.ehr.brandmenu;

import java.sql.SQLException;
import java.util.List;

import com.pcwk.ehr.SearchVO;

public interface BrandMenuDao {

	/**
	 * 브랜드 메뉴 전체 조회
	 * @return list
	 */

	List<BrandMenuVO> getAll();

	/**
	 * 브랜드메뉴 검색
	 * @param searchVO
	 * @return list
	 * @throws SQLException
	 */

	List<?> doRetrieve(SearchVO searchVO) throws SQLException;

	/**
	 * 등록 메뉴 건수
	 * @return cnt
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */

	int getCount() throws ClassNotFoundException, SQLException;

	/**
	 * 브랜드 메뉴 조회
	 * @param inVO
	 * @return brandMenuVO
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */

	BrandMenuVO doSelectOne(BrandMenuVO inVO) throws ClassNotFoundException, SQLException;

	/**
	 * 브랜드 전체삭제
	 * @throws SQLException
	 */
	void deleteAll() throws SQLException;

	/**
	 * 메뉴 등록
	 * @param inVO
	 * @return :성공(1)/실패(0)
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */

	int doInsert(BrandMenuVO brandmenu) throws ClassNotFoundException, SQLException;

	/**
	 * 메뉴 삭제
	 * @param brandmenu
	 * @return :성공(1)/실패(0)
	 * @throws SQLException
	 */

	int doDelete(BrandMenuVO brandmenu) throws SQLException;

	/**
	 * 브랜드 메뉴 수정
	 * @param brandmenu
	 * @return :성공(1)/실패(0)
	 * @throws SQLException
	 */

	int doUpdate(BrandMenuVO brandmenu) throws SQLException;

}