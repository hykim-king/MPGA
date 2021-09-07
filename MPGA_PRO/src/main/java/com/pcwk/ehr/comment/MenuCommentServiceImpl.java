package com.pcwk.ehr.comment;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;


public class MenuCommentServiceImpl implements MenuCommentService {
	
	@Autowired
	MenuCommentDao menucommetdao;
	
	public MenuCommentServiceImpl() {
		
	}
	
	@Override
	public int doInsert(MenuCommentVO comment) throws SQLException{
		return menucommetdao.doInsert(comment);
	}
	
	//셀렉트원!
	@Override
	public MenuCommentVO doSelectOne(MenuCommentVO inVO) {
		return menucommetdao.SelectOne(inVO);
	}

	//수정! (다시 수정해야함)
	@Override
	public int doUpdate(MenuCommentVO comment) throws SQLException{
		return menucommetdao.doInsert(comment);
	}

	//삭제! 
	@Override
	public int doDelete(MenuCommentVO comment) throws SQLException{
		return menucommetdao.doInsert(comment);
	}

}
