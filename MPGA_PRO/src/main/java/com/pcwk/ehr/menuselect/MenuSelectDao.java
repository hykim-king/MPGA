package com.pcwk.ehr.menuselect;

import java.sql.SQLException;
import java.util.List;

public interface MenuSelectDao {

	// 메뉴찜 테이블을 최신순으로 리스트로 뽑아낸다.
	List<MenuSelectVO> getAll(MenuSelectVO select);

	/**
	 * 찜 등록
	 * 
	 * @param inVO
	 * @return :성공(1)/실패(0)
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	int doInsert(MenuSelectVO select) throws ClassNotFoundException, SQLException;

	/*
	 * 찜 취소
	 * WHERE memberNum = ? , menuNum = ? 특정 회원이 특정 메뉴의 찜을 취소한다
	 */
	int doDelete(MenuSelectVO select) throws SQLException;

}