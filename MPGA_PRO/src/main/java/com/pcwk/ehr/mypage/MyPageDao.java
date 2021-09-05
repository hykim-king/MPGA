package com.pcwk.ehr.mypage;

import java.sql.SQLException;
import java.util.List;





public interface MyPageDao {
	
	MyPageVO doSelectOne(MyPageVO inVO) throws ClassNotFoundException, SQLException;
	
	int doUpdate (MyPageVO myPage) throws SQLException;
	
	List<?> doRetrieve(MyPageVO myPage) throws SQLException;

	int doInsert(MyPageVO myPageVO);

	int doDelete(MyPageVO myPageVO); 

}
