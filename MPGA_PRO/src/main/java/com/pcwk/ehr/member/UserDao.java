package com.pcwk.ehr.member;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {
	
	List<UserVO> getAll();

	int getCount() throws ClassNotFoundException, SQLException;

	/**
	 * 사용자 조회
	 * 
	 * @param inVO
	 * @return UserVO
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	UserVO doSelectOne(UserVO inVO) throws ClassNotFoundException, SQLException;

	/**
	 * 전체삭제
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	void deleteAll() throws SQLException;

	/**
	 * 사용자 등록
	 * 
	 * @param inVO
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	int doInsert(UserVO user) throws ClassNotFoundException, SQLException;
	
	/**
	 * 사용자 삭제
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	int doDelete(UserVO user) throws SQLException;
	
	/**\
	 * 수정
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	int doUpdate(UserVO user) throws SQLException;
	
	/**
	 * 목록조회
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	List<?> doRetrieve(UserVO user) throws SQLException;

}
