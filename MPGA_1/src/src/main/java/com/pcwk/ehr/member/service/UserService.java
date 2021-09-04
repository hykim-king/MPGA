package com.pcwk.ehr.member.service;

import java.sql.SQLException;
import java.util.List;

import com.pcwk.ehr.member.domain.UserVO;

public interface UserService {

	/**
	 * 최초 회원 가입시 등급 : BASIC
	 * 
	 * @param user
	 * @return flag
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	int add(UserVO user) throws ClassNotFoundException, SQLException;

	/**
	 * 1.전 회원을 조회 한다. 1.1.전 회원준 1건을 추출한다. 1.2.회원이 등업 대상인지 확인 한다. BASIC -> SILVER :
	 * 50회 이상 로그인 SILVER -> GOLD : 30회 이상 추천 GOID -> : 대상 아님 1.3. 등업한다.
	 * 
	 * @throws SQLException
	 */
	void upgradeLevels() throws Exception;
	public UserVO doSelectOne(UserVO inVO) throws ClassNotFoundException, SQLException;
	
	public int doInsert(final UserVO user) throws ClassNotFoundException, SQLException;
	
	public int doDelete(UserVO user) throws SQLException;
	
	public int doUpdate(UserVO user) throws SQLException; 
	
	public List<?> doRetrieve(UserVO user) throws SQLException;

}