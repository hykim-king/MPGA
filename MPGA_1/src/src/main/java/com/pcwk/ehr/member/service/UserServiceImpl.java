package com.pcwk.ehr.member.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.mail.internet.MimeMessage;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.pcwk.ehr.Level;
import com.pcwk.ehr.member.dao.UserDao;
import com.pcwk.ehr.member.domain.UserVO;

@Service
public class UserServiceImpl implements UserService {

	final Logger LOG = LoggerFactory.getLogger(getClass());

	// 상수
	public static final int MIN_LOGCOUNT_FOR_SILVER = 50;// BASIC->SILVER 로그인 횟수
	public static final int MIN_RECCOMEND_FOR_GOLD = 30;// SILVER->GOLD 추천 횟수
	
	@Autowired
	UserDao userDao;

	// mail
	@Autowired
	@Qualifier("dummyMailSender")
	private MailSender mailSender;

	public UserServiceImpl() {
	}

	
	private void sendUpgradeMail(UserVO user) {
		// mail 전송에 필요한 : TO, Title, Contents
		try {

			SimpleMailMessage mailMessage = new SimpleMailMessage();

			// email TO
			mailMessage.setTo(user.getEmail());
			mailMessage.setFrom("jamesol@naver.com");
			mailMessage.setSubject("등업 안내");
			mailMessage.setText("사용자의 등급이 " + user.getLevel().name());

			mailSender.send(mailMessage);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 최초 회원 가입시 등급 : BASIC
	 * 
	 * @param user
	 * @return flag
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public int add(UserVO user) throws ClassNotFoundException, SQLException {
		int flag = 0;
		UserVO inVO = user;
		if (null == inVO.getLevel()) {
			inVO.setLevel(Level.BASIC);
		}

		flag = userDao.doInsert(inVO);

		return flag;
	}

	//
	// user.getLevel() == Level.BASIC && user.getLogin() >=50

	/**
	 * 업그레이드 가능 확인 메소드
	 * 
	 * @param user
	 * @return boolean(가능/불가능)
	 */
	private Boolean canUpgradeLevel(UserVO user) {
		Level currentLevel = user.getLevel();

		switch (currentLevel) {
		case BASIC:
			return (user.getLogin() >= MIN_LOGCOUNT_FOR_SILVER);
		case SILVER:
			return (user.getRecommend() >= MIN_RECCOMEND_FOR_GOLD);
		case GOLD:
			return false;
		default:
			throw new IllegalArgumentException("Unknown Level:" + currentLevel);
		}

	}

	// private -> protected
	protected void upgradeLevel(UserVO user) throws SQLException {
		
//		  if("pcwk_04".equals(user.getuId())) { throw new
//		  TestUserServiceException("트랜젝션 테스트:"+user.getuId()); }
	 

		user.upgradeLevel();
		this.userDao.doUpdate(user);
	}

	/**
	 * 1.전 회원을 조회 한다. 1.1.전 회원준 1건을 추출한다. 1.2.회원이 등업 대상인지 확인 한다. BASIC -> SILVER :
	 * 50회 이상 로그인 SILVER -> GOLD : 30회 이상 추천 GOID -> : 대상 아님 1.3. 등업한다.
	 * 
	 * @throws SQLException
	 */
	public void upgradeLevels() throws Exception {

		// 1.
		List<UserVO> list = userDao.getAll();
		// 1.1.
		for (UserVO user : list) {
			if (canUpgradeLevel(user) == true) {
				upgradeLevel(user);
				this.sendUpgradeMail(user);
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
	public List<?> doRetrieve(UserVO user) throws SQLException {
		
		return userDao.doRetrieve(user);
	}

}
