package com.pcwk.ehr.comment;

import java.sql.SQLException;

public interface CommentLikeDao {

	//등록!
	CommentLikeVO doSelectOne(CommentLikeVO commentLike) throws SQLException;

	//카운트!
	CommentLikeVO doReadCnt(CommentLikeVO inVO);

	int doDelete(CommentLikeVO commentLike);

	int doInsert(CommentLikeVO commentLike);

}