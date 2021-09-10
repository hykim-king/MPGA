package com.pcwk.ehr.brand;

import java.sql.SQLException;
import java.util.List;

import com.pcwk.ehr.SearchVO;

public interface BrandDao {

	/**
	 * 브랜드 전체 조회
	 * @return list
	 */

	List<BrandVO> getAll();

	/**
	 * 브랜드 검색
	 * @param searchVO
	 * @return list
	 * @throws SQLException
	 */

	List<?> doRetrieve(SearchVO searchVO) throws SQLException;

	/**
	 * 등록 브랜드 건수
	 * @return cnt
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	int getCount() throws ClassNotFoundException, SQLException;

	/**
	 * 브랜드 단건 조회
	 * @param inVO
	 * @return brandVO
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	BrandVO doSelectOne(BrandVO inVO) throws ClassNotFoundException, SQLException;

	/**
	 * 브랜드 전체삭제
	 * @throws SQLException
	 */
	void deleteAll() throws SQLException;

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

}