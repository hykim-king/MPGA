package com.pcwk.ehr.profile;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

public interface ProfileImgDao {

	void setDataSource(DataSource dataSource);

	/**
	 * 프로필 이미지 리스트
	 * @return
	 */

	List<ProfileImgVO> getAll();

	/**
	 * 이미지 조회
	 * @param inVO
	 * @return UserVO
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	ProfileImgVO doSelectOne(ProfileImgVO inVO) throws ClassNotFoundException, SQLException;

	/**
	 * 브랜드 등록
	 * @param img
	 * @return :성공(1)/실패(0)
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */

	int doInsert(ProfileImgVO img) throws ClassNotFoundException, SQLException;

	/**
	 * 브랜드 삭제
	 * @param img
	 * @return :성공(1)/실패(0)
	 * @throws SQLException
	 */

	int doDelete(ProfileImgVO img) throws SQLException;

	/**
	 * 브랜드 수정
	 * @param brand
	 * @return :성공(1)/실패(0)
	 * @throws SQLException
	 */

	int doUpdate(ProfileImgVO img) throws SQLException;

	List<?> doRetrieve(ProfileImgVO img) throws SQLException;

}