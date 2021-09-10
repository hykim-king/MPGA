package com.pcwk.ehr.profileImg;

import java.sql.SQLException;
import java.util.List;

import com.pcwk.ehr.SearchVO;

public interface ProfileImgDao {

	/**
	 * 프로필 이미지 조회
	 * @return
	 */
	List<ProfileImgVO> getAll();

	/**
	 * 프로필 이미지 검색
	 * @param searchVO
	 * @return list
	 * @throws SQLException
	 */
	List<?> doRetrieve(SearchVO searchVO) throws SQLException;

	/**
	 * 등록 프로필 건수
	 * @return cnt
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	int getCount() throws ClassNotFoundException, SQLException;

	/**
	 * 프로필 조회
	 * @param inVO
	 * @return UserVO
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	ProfileImgVO doSelectOne(ProfileImgVO inVO) throws ClassNotFoundException, SQLException;

	/**
	 * 프로필 전체삭제
	 * @throws SQLException
	 */
	void deleteAll() throws SQLException;

	/**
	 * 프로필 등록
	 * @param img
	 * @return :성공(1)/실패(0)
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	int doInsert(ProfileImgVO img) throws ClassNotFoundException, SQLException;

	/**
	 * 프로필 삭제
	 * @param img
	 * @return :성공(1)/실패(0)
	 * @throws SQLException
	 */
	int doDelete(ProfileImgVO img) throws SQLException;

	/**
	 * 프로필 수정
	 * @param brand
	 * @return :성공(1)/실패(0)
	 * @throws SQLException
	 */
	int doUpdate(ProfileImgVO img) throws SQLException;

}