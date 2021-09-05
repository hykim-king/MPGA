package com.pcwk.ehr.mypage;

import java.sql.SQLException;
import java.util.List;

import com.pcwk.ehr.member.UserVO;

public interface MyPageService {
	
	MyPageVO deSelectOne(MyPageVO inVO) throws ClassNotFoundException, SQLException;
	
	int doUpdate(MyPageVO myPageVO) throws SQLException;
	
	List<?> doRetrieve(MyPageVO myPageVO) throws SQLException;
	
	int doInsert(MyPageVO myPageVO) throws ClassNotFoundException, SQLException;
	
	int doDelete(MyPageVO myPageVO) throws SQLException;



	
}




