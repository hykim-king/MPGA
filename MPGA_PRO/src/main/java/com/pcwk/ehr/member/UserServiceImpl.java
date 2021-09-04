package com.pcwk.ehr.member;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.MailSender;

import com.pcwk.ehr.member.UserDao;

public class UserServiceImpl implements UserService {
	
	final Logger LOG = LoggerFactory.getLogger(getClass());
	
	@Autowired
	UserDao userDao;
	
    //mail
	@Autowired
	@Qualifier("dummyMailSender")  
	private MailSender mailSender;

	public UserServiceImpl() {
	}

	@Override
	public int add(UserVO user) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void upgradeLevels() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UserVO doSelectOne(UserVO inVO) throws ClassNotFoundException, SQLException {
		
		return userDao.doSelectOne(inVO);
	}

	@Override
	public int doInsert(UserVO user) throws ClassNotFoundException, SQLException {
		
		return userDao.doInsert(user);
	}

	@Override
	public int doDelete(UserVO user) throws SQLException {
		
		return userDao.doDelete(user);
	}

	@Override
	public int doUpdate(UserVO user) throws SQLException {
		
		return userDao.doUpdate(user);
	}

	@Override
	public List<?> doRetrieve(UserVO user) throws SQLException {
		
		return userDao.doRetrieve(user);
	}

}
