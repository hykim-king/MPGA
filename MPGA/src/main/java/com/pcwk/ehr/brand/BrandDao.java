package com.pcwk.ehr.brand;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

public interface BrandDao {

	void setDataSource(DataSource dataSource);

	List<BrandVO> getAll();

	/**
	 * 등록 브랜드 건수
	 * @return cnt
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */

	int getCount() throws ClassNotFoundException, SQLException;

	/**
	 * 브랜드 조회
	 * @param inVO
	 * @return brandVO
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */

	BrandVO doSelectOne(BrandVO inVO) throws ClassNotFoundException, SQLException;

	/**
	 * 브랜드 등록
	 * @param inVO
	 * @return :성공(1)/실패(0)
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */

	int doInsert(BrandVO brand) throws ClassNotFoundException, SQLException;

	/**
	 * 브랜드 삭제
	 * @param brand
	 * @return :성공(1)/실패(0)
	 * @throws SQLException
	 */

	int doDelete(BrandVO brand) throws SQLException;

	/**
	 * 브랜드 수정
	 * @param brand
	 * @return :성공(1)/실패(0)
	 * @throws SQLException
	 */

	int doUpdate(BrandVO brand) throws SQLException;

	List<?> doRetrieve(BrandVO brand) throws SQLException;

}