package com.pcwk.ehr.selectedmenu;

import java.sql.SQLException;
import java.util.List;

public interface SelectedMenuDao {

	// 메뉴찜 테이블을 최신순으로 리스트로 뽑아낸다.
	List<SelectedMenuVO> getAll(SelectedMenuVO select);

	/**
	 * 찜 등록
	 * 
	 * @param inVO
	 * @return :성공(1)/실패(0)
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	int doInsert(SelectedMenuVO select) throws ClassNotFoundException, SQLException;

	/*
	 * 찜 취소
	 * WHERE memberNum = ? , menuNum = ? 특정 회원이 특정 메뉴의 찜을 취소한다
	 */
	int doDelete(SelectedMenuVO select) throws SQLException;

}