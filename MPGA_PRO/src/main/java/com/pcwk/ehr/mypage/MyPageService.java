package com.pcwk.ehr.mypage;

import java.sql.SQLException;
import java.util.List;

public interface MyPageService {

	MyPageVO doSelectOneProfileImg(MyPageVO inVO) throws ClassNotFoundException, SQLException;

	MyPageVO doSelectOnePersonal(MyPageVO inVO) throws ClassNotFoundException, SQLException;

	MyPageVO doSelectOneSelect(MyPageVO inVO) throws ClassNotFoundException, SQLException;

	MyPageVO doSelectOneComment(MyPageVO inVO) throws ClassNotFoundException, SQLException;

	int doUpdateProfileImg(MyPageVO myPageVO) throws SQLException;

	int doUpdatePersonal(MyPageVO myPageVO) throws SQLException;

	int doUpdateSelect(MyPageVO myPageVO) throws SQLException;

	int doUpdateComment(MyPageVO myPageVO) throws SQLException;

	List<?> doRetrieve(MyPageVO myPageVO) throws SQLException;

	int doInsert(MyPageVO myPageVO) throws ClassNotFoundException, SQLException;

	int doDelete(MyPageVO myPageVO) throws SQLException;

}