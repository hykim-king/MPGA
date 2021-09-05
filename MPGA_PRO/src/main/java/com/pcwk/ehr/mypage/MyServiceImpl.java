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
	public MyPageVO deSelectOne(MyPageVO inVO) throws ClassNotFoundException, SQLException {
		
		return myPageDao.doSelectOne(inVO);
	}

	@Override
	public int doUpdate(MyPageVO myPageVO) throws SQLException {
		
		return myPageDao.doUpdate(myPageVO);
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
