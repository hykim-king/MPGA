package com.pcwk.ehr.commentlike;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;

public class CommentLikeServiceImpl implements CommentLikeService {

	@Autowired
	CommentLikeDao commentlikedao;
	
	public CommentLikeServiceImpl() {
		
	}

	public CommentLikeVO doSelectOne(CommentLikeVO commentLike) throws SQLException{
		return commentlikedao.doSelectOne(commentLike);
		
	}
	public int  doInsert(CommentLikeVO commentLike) throws SQLException {
		return commentlikedao.doInsert(commentLike);
	}

	//카운트!
	public CommentLikeVO doReadCnt(CommentLikeVO inVO) throws SQLException {
		return commentlikedao.doReadCnt(inVO);
		
	}
	 public int doDelete(CommentLikeVO commentLike) throws SQLException {
		return commentlikedao.doDelete(commentLike);
		
	}

	@Override
	public int doUpdate(CommentLikeVO img) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}
}
