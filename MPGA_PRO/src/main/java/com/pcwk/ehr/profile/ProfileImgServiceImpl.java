package com.pcwk.ehr.profile;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class ProfileImgServiceImpl implements ProfileImgService{

	@Autowired
	ProfileImgDao profileImgDao;
	
	public ProfileImgServiceImpl() {
	}
	
	public ProfileImgVO doSelectOne(ProfileImgVO inVO) throws ClassNotFoundException, SQLException{
		return profileImgDao.doSelectOne(inVO);
	}
			
	public int doInsert(final ProfileImgVO img) throws ClassNotFoundException, SQLException{
		return profileImgDao.doInsert(img);
	}
	public int doDelete(ProfileImgVO img) throws SQLException{
		return profileImgDao.doDelete(img);
	}
	public int doUpdate(ProfileImgVO img) throws SQLException{
		return profileImgDao.doUpdate(img);
	}
	public List<?> doRetrieve(ProfileImgVO img) throws SQLException{
		return profileImgDao.doRetrieve(img);
	}
	

}
