package com.pcwk.ehr.comment;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

public interface CommentLikeDao {

	//등록!
	int doSelectOne(CommentLikeVO commentLike) throws SQLException;

	//카운트!
	CommentLikeVO doReadCnt(CommentLikeVO inVO) throws SQLException;

	int doDelete(CommentLikeVO commentLike) throws SQLException;

	void setDataSource(DataSource dataSource);

	List<CommentLikeVO> getAll();

}