package com.pcwk.ehr.member;

import java.sql.SQLException;
import java.util.List;

import com.pcwk.ehr.SearchVO;

public interface UserDao {
	
	public int sameNickCheck(UserVO vo) throws Exception;
	
	public int sameIdCheck(UserVO vo) throws Exception;
	
	public int samePWCheck(UserVO vo) throws Exception;

	int doInsert(UserVO user) throws ClassNotFoundException, SQLException;

	//쓸필요가 없다.
	UserVO doSelectOne(UserVO inVO) throws ClassNotFoundException, SQLException;

	//아이디, 닉네임 인증시 데이터 비교할때 사용.
	List<?> doRetrieve(SearchVO searchVO) throws SQLException;

	List<UserVO> getAll();

	int getCount() throws ClassNotFoundException, SQLException;

	void deleteAll() throws SQLException;

	int doDelete(UserVO user) throws SQLException;

	int doUpdate(UserVO user) throws SQLException;

}