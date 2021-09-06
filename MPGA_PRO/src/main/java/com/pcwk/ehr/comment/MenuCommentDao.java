package com.pcwk.ehr.comment;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

public interface MenuCommentDao {

	//등록!
	int doInsert(MenuCommentVO comment) throws SQLException;

	//셀렉트원!
	MenuCommentVO SelectOne(MenuCommentVO inVO);

	//수정! (다시 수정해야함)
	int doUpdate(MenuCommentVO comment) throws SQLException;

	//삭제! 
	int doDelete(MenuCommentVO comment) throws SQLException;

	void setDataSource(DataSource dataSource);

	List<MenuCommentVO> getAll();

}