package com.pcwk.ehr.profileImg;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.pcwk.ehr.SearchVO;

public class ProfileImgServiceImpl {
	
	final Logger LOG = LoggerFactory.getLogger(ProfileImgServiceImpl.class);

	@Autowired
	private ProfileImgDaoImpl profileImgDao;
	
	public ProfileImgServiceImpl() {}
	
	//프로필 검색
	public List<?> doRetrieve(SearchVO searchVO) throws SQLException{
		return profileImgDao.doRetrieve(searchVO);
		}
	//프로필 단건 조회
	public ProfileImgVO doSelectOne(ProfileImgVO inVO) throws ClassNotFoundException, SQLException{
		return profileImgDao.doSelectOne(inVO);
		}
	//프로필 등록
	public int doInsert(ProfileImgVO img) throws ClassNotFoundException, SQLException{
		return profileImgDao.doInsert(img);
		}
	//프로필 삭제
	public int doDelete(ProfileImgVO img) throws SQLException{
		return profileImgDao.doDelete(img);
		}
	//프로필 수정
	public int doUpdate(ProfileImgVO img) throws SQLException{
		return profileImgDao.doUpdate(img);
		}
}
