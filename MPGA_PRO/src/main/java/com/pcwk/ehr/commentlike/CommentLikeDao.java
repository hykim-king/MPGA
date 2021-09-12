package com.pcwk.ehr.commentlike;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

public interface CommentLikeDao {

	CommentLikeVO doSelectOne(CommentLikeVO commentLike) throws SQLException;

	CommentLikeVO doReadCnt(CommentLikeVO inVO);

	int doDelete(CommentLikeVO commentLike) throws SQLException;

	int doInsert(CommentLikeVO commentLike) throws SQLException;

	void setDataSource(DataSource dataSource);

	List<CommentLikeVO> getAll();

	void deleteAll();

	Object getCount();

}