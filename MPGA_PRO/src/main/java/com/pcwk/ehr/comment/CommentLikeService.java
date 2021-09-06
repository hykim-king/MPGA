package com.pcwk.ehr.comment;

import java.sql.SQLException;

public interface CommentLikeService {

	
	public int doSelectOne(CommentLikeVO inVO) throws ClassNotFoundException, SQLException;
	
    public int doInsert(CommentLikeVO Commentlike) throws ClassNotFoundException, SQLException;
	
    public int doDelete(CommentLikeVO Commentlike) throws SQLException;
	
    public int doUpdate(CommentLikeVO Commentlike) throws SQLException;
	
}