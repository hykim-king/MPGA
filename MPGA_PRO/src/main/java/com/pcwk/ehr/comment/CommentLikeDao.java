package com.pcwk.ehr.comment;

import java.sql.SQLException;

public interface CommentLikeDao {

	//등록!
	int doSelectOne(CommentLikeVO commentLike) throws SQLException;

	//카운트!
	CommentLikeVO doReadCnt(CommentLikeVO inVO) throws SQLException;

	CommentLikeVO doDelete(CommentLikeVO commentLike) throws SQLException;

}