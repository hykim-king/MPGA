package com.pcwk.ehr.menucomment;

import java.sql.SQLException;
import java.util.List;

import com.pcwk.ehr.SearchMineVO;
import com.pcwk.ehr.SearchVO;

public interface MenuCommentDao {

	/**
	 * 내가 쓴 댓글 목록
	 * @param searchMineVO
	 * @return list
	 * @throws SQLException
	 */
	List<?> menuCommentList(SearchMineVO searchMineVO) throws SQLException;

	/**
	 * 댓글 전체 조회
	 * @return list
	 */
	List<MenuCommentVO> getAll();

	/**
	 * 등록 댓글 건수
	 * @return cnt
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	int getCount() throws ClassNotFoundException, SQLException;

	/**
	 * 댓글 등록
	 * @param inVO
	 * @return :성공(1)/실패(0)
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	int doInsert(MenuCommentVO comment) throws SQLException;

	/**
	 * 댓글 전체삭제
	 * @throws SQLException
	 */
	void deleteAll() throws SQLException;

	/**
	 * 댓글 단건 조회
	 * @param inVO
	 * @return brandMenuVO
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */

	MenuCommentVO doSelectOne(MenuCommentVO inVO) throws ClassNotFoundException, SQLException;

	/**
	 * 댓글 수정
	 * @param brandmenu
	 * @return :성공(1)/실패(0)
	 * @throws SQLException
	 */
	int doUpdate(MenuCommentVO comment) throws SQLException;

	/**
	 * 댓글 삭제
	 * @param brandmenu
	 * @return :성공(1)/실패(0)
	 * @throws SQLException
	 */
	int doDelete(MenuCommentVO comment) throws SQLException;

}