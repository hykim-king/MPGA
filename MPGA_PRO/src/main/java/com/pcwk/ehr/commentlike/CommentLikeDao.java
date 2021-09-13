package com.pcwk.ehr.commentlike;

import java.sql.SQLException;
import java.util.List;

public interface CommentLikeDao {

	List<CommentLikeVO> getAll();

	int getCount() throws ClassNotFoundException, SQLException;

	int getLikeCount() throws SQLException;

	CommentLikeVO doSelectOne(CommentLikeVO inVO) throws ClassNotFoundException, SQLException;

	int doUpdate(CommentLikeVO commentLike) throws SQLException;

	int doInsert(CommentLikeVO commentLike) throws SQLException;

	int doDelete(CommentLikeVO commentLike) throws SQLException;

	void deleteAll() throws SQLException;

}