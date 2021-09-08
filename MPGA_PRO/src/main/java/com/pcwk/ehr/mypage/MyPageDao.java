package com.pcwk.ehr.mypage;

import java.sql.SQLException;
import java.util.List;





public interface MyPageDao {
	
	MyPageVO doSelectOneProfileImg(MyPageVO inVO) throws ClassNotFoundException, SQLException;
	
	MyPageVO doSelectOnePersonal(MyPageVO inVO) throws ClassNotFoundException, SQLException;
	
	MyPageVO doSelectOneSelect(MyPageVO inVO) throws ClassNotFoundException, SQLException;
	
	MyPageVO doSelectOneComment(MyPageVO inVO) throws ClassNotFoundException, SQLException;
	
	int doUpdateProfileImg (MyPageVO myPage) throws SQLException;
	
	int doUpdatePersonal (MyPageVO myPage) throws SQLException;
	
	int doUpdateSelect (MyPageVO myPage) throws SQLException;
	
	int doUpdateComment (MyPageVO myPage) throws SQLException;
	
	List<?> doRetrieve(MyPageVO myPage) throws SQLException;

	int doInsert(MyPageVO myPageVO);

	int doDelete(MyPageVO myPageVO); 

}
