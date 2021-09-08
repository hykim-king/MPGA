package com.pcwk.ehr.mypage;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pcwk.ehr.mypage.MyPageDao;

@Service
public class MyServiceImpl implements MyPageService {
	
	final Logger LOG = LoggerFactory.getLogger(getClass());
	
	@Autowired
	MyPageDao myPageDao;

	@Override
	public MyPageVO doSelectOneProfileImg(MyPageVO inVO) throws ClassNotFoundException, SQLException {
		
		return myPageDao.doSelectOneProfileImg(inVO);
	}
	
	@Override
	public MyPageVO doSelectOnePersonal(MyPageVO inVO) throws ClassNotFoundException, SQLException {
		
		return myPageDao.doSelectOnePersonal(inVO);
	}
	
	@Override
	public MyPageVO doSelectOneSelect(MyPageVO inVO) throws ClassNotFoundException, SQLException {
		
		return myPageDao.doSelectOneSelect(inVO);
	}
	
	@Override
	public MyPageVO doSelectOneComment(MyPageVO inVO) throws ClassNotFoundException, SQLException {
		
		return myPageDao.doSelectOneComment(inVO);
	}

	@Override
	public int doUpdateProfileImg(MyPageVO myPageVO) throws SQLException {
		
		return myPageDao.doUpdateProfileImg(myPageVO);
	}
	@Override
	public int doUpdatePersonal(MyPageVO myPageVO) throws SQLException {
		
		return myPageDao.doUpdatePersonal(myPageVO);
	}
	@Override
	public int doUpdateSelect(MyPageVO myPageVO) throws SQLException {
		
		return myPageDao.doUpdateSelect(myPageVO);
	}
	@Override
	public int doUpdateComment(MyPageVO myPageVO) throws SQLException {
		
		return myPageDao.doUpdateComment(myPageVO);
	}

	@Override
	public List<?> doRetrieve(MyPageVO myPageVO) throws SQLException {
		
		return myPageDao.doRetrieve(myPageVO);
	}

	
	
	
	
	
	@Override
	public int doInsert(MyPageVO myPageVO) throws ClassNotFoundException, SQLException {
		
		return myPageDao.doInsert(myPageVO);
	}

	@Override
	public int doDelete(MyPageVO myPageVO) throws SQLException {
		
		return myPageDao.doDelete(myPageVO);
	}



}	
