package com.pcwk.ehr.comment;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;

public class CommentLikeServiceImpl implements CommentLikeService {

	@Autowired
	CommentLikeDao commentlikedao;
	
	public CommentLikeServiceImpl() {
		
	}

	int doSelectOne(CommentLikeVO commentLike) throws SQLException{
		return commentlikedao.doSelectOne(commentLike);
		
	}

	//카운트!
	CommentLikeVO doReadCnt(CommentLikeVO inVO) throws SQLException {
		return commentlikedao.doReadCnt(inVO);
		
	}

	CommentLikeVO doDelete(CommentLikeVO commentLike) throws SQLException {
		return commentlikedao.doDelete(commentLike);
		
	}
}
