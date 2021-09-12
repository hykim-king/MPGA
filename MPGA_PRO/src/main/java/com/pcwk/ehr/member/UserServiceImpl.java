package com.pcwk.ehr.member;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.MailSender;


import com.pcwk.ehr.Rank;
import com.pcwk.ehr.SearchVO;
import com.pcwk.ehr.commentlike.CommentLikeVO;
import com.pcwk.ehr.member.UserDao;
import com.pcwk.ehr.member.UserVO;

public class UserServiceImpl implements UserService {
	
	final Logger LOG = LoggerFactory.getLogger(getClass());
	
	@Autowired
	UserDao userDao;

	public UserServiceImpl() {
	}

	@Override
	public int add(UserVO user) throws ClassNotFoundException, SQLException {
		int flag = 0;
		UserVO inVO = user;
		if (null == inVO.getRank()) {
			inVO.setRank(Rank.BASIC);
		}

		flag = userDao.doInsert(inVO);

		return flag;
	}
	
	private Boolean canUpgradeRank(UserVO user) {
		Rank currentLevel = user.getRank();

		switch (currentLevel) {
		case BASIC:
			return (user.getCountLike() >= MIN_CLIKECOUNT_FOR_SILVER);
		case SILVER:
			return (user.getCountLike() >= MIN_CLIKECOUNT_FOR_GOLD);
		case GOLD:
			return false;
		default:
			throw new IllegalArgumentException("Unknown Level:" + currentLevel);
		}

	}
	
	protected void upgradeRank(UserVO user) throws SQLException {

		
//		  if("pcwk_04".equals(user.getuId())) { //사용자 정의 예외 발생 throw new
//		   throw new TestUserServiceException("트랜잭션 테스트:"+user.getuId()); 
//		  }
		 

		user.upgradeRank();
		this.userDao.doUpdate(user);
	}

	@Override
	public void upgradeRanks() throws Exception {
		// 1.
		List<UserVO> list = userDao.getAll();
		// 1.1.
		for (UserVO user : list) {
			if (canUpgradeRank(user) == true) {
				upgradeRank(user);
				
			}
		} 
		
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
	public List<?> doRetrieve(SearchVO search) throws SQLException {
		
		return userDao.doRetrieve(search);
	}

}
