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
	 * 프로필 이미지 등록 및 수정
	 * @param inVO
	 * @return ProfileImgVO
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	int doMerge(ProfileImgVO img) throws SQLException;

}