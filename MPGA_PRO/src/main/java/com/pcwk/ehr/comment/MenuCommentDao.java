package com.pcwk.ehr.comment;

import java.sql.SQLException;

public interface MenuCommentDao {

	//등록!
	int doInsert(CommentLikeVO comment) throws SQLException;

	//셀렉트원!
	CommentLikeVO SelectOne(CommentLikeVO inVO);

	//수정! (다시 수정해야함)
	int doUpdate(CommentLikeVO comment) throws SQLException;

	//삭제! 
	int doDelete(CommentLikeVO comment) throws SQLException;

}