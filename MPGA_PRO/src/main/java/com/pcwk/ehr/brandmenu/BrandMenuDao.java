package com.pcwk.ehr.brandmenu;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

public interface BrandMenuDao {

	void setDataSource(DataSource dataSource);

	List<BrandMenuVO> getAll();

	/**
	 * 등록 메뉴 건수
	 * @return cnt
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */

	int getCount() throws ClassNotFoundException, SQLException;

	/**
	 * 메뉴  조회
	 * @param inVO
	 * @return brandmenuVO
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */

	BrandMenuVO doSelectOne(BrandMenuVO inVO) throws ClassNotFoundException, SQLException;

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
	 * 메뉴 수정
	 * @param brandmenu
	 * @return :성공(1)/실패(0)
	 * @throws SQLException
	 */

	int doUpdate(BrandMenuVO brandmenu) throws SQLException;

	List<?> doRetrieve(BrandMenuVO brandmenu) throws SQLException;

	Object getmCode();

}