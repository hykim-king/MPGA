package com.pcwk.ehr.comment;

import java.sql.SQLException;

public interface CommentLikeService {

	
	public CommentLikeVO doSelectOne(CommentLikeVO inVO) throws ClassNotFoundException, SQLException;
	
    public int doInsert(CommentLikeVO img) throws ClassNotFoundException, SQLException;
	
    public int doDelete(CommentLikeVO img) throws SQLException;
	
    public int doUpdate(CommentLikeVO img) throws SQLException;
	
}