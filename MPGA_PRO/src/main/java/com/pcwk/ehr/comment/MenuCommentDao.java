package com.pcwk.ehr.comment;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

public interface MenuCommentDao {

	
	int doInsert(MenuCommentVO comment) throws SQLException;

	
	MenuCommentVO SelectOne(MenuCommentVO inVO);

	
	int doUpdate(MenuCommentVO comment) throws SQLException;

	 
	int doDelete(MenuCommentVO comment) throws SQLException;

	MenuCommentVO doSelectOne(MenuCommentVO inVO) throws ClassNotFoundException, SQLException;

	void setDataSource(DataSource dataSource);

	List<MenuCommentVO> getAll();


	void deleteAll();


	Object getCount();

}