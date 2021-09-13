package com.pcwk.ehr.member;

import java.sql.SQLException;
import java.util.List;

import com.pcwk.ehr.SearchVO;

public interface UserService {

	// 상수
	int MIN_CLIKECOUNT_FOR_SILVER = 10;// BASIC->SILVER 로그인 횟수
	int MIN_CLIKECOUNT_FOR_GOLD = 100;// SILVER->GOLD 추천 횟수

	int add(UserVO user) throws ClassNotFoundException, SQLException;

	void upgradeRanks() throws Exception;

	UserVO doSelectOne(UserVO inVO) throws ClassNotFoundException, SQLException;

	int doInsert(UserVO user) throws ClassNotFoundException, SQLException;

	int doDelete(UserVO user) throws SQLException;

	int doUpdate(UserVO user) throws SQLException;

	List<?> doRetrieve(SearchVO search) throws SQLException;
	
	/*
	 * int sameIdCheck(UserVO vo) throws Exception;
	 * 
	 * int samePWCheck(UserVO vo) throws Exception;
	 * 
	 * int sameNickCheck(UserVO vo) throws Exception;
	 */

}