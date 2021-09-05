package com.pcwk.ehr.comment;

import java.sql.SQLException;

public interface CommentLikeDao {

	//등록!
	int doSelectOne(CommentLikeVO commentLike) throws SQLException;

	//카운트!
	CommentLikeVO doReadCnt(CommentLikeVO inVO);

	CommentLikeVO doDelete(CommentLikeVO commentLike);

}