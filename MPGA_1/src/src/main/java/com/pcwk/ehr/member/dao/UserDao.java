package com.pcwk.ehr.member.dao;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import com.pcwk.ehr.member.domain.UserVO;

public interface UserDao {


	List<UserVO> getAll();

	/**
	 * 등록 건수
	 * 
	 * @return 등록 건수
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	int getCount() throws ClassNotFoundException, SQLException;

	/**
	 * 사용자 조회
	 * 
	 * @param inVO
	 * @return UserVO
	 * @throws ClassNotFoundException
	 * @throws SQLException
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
	 * @return :성공(1)/실패(0)
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	int doInsert(UserVO user) throws ClassNotFoundException, SQLException;

	/**
	 * 사용자 삭제
	 * @param user
	 * @return:성공(1)/실패(0)
	 * @throws SQLException
	 */
	int doDelete(UserVO user) throws SQLException;
	
	/**
	 * 수정
	 * @param user
	 * @return:성공(1)/실패(0)
	 * @throws SQLException
	 */
	int doUpdate(UserVO user) throws SQLException;			
	
	/**
	 * 목록조회
	 * @param user
	 * @return List<?>
	 * @throws SQLException
	 */
	List<?> doRetrieve(UserVO user) throws SQLException;		
	
	
}

