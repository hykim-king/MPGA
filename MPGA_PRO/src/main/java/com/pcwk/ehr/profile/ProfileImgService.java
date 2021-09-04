package com.pcwk.ehr.profile;

import java.sql.SQLException;
import java.util.List;

public interface ProfileImgService {

	/**
	 * 최초 회원가입 시 이미지 : 기본
	 * @param img
	 * @return
	 * @throws SQLException
	 */
	
	public ProfileImgVO doSelectOne(ProfileImgVO inVO) throws ClassNotFoundException, SQLException;
	
	public int doInsert(final ProfileImgVO img) throws ClassNotFoundException, SQLException;
	
	public int doDelete(ProfileImgVO img) throws SQLException;
	
	public int doUpdate(ProfileImgVO img) throws SQLException;
	
	public List<?> doRetrieve(ProfileImgVO img) throws SQLException;

}
