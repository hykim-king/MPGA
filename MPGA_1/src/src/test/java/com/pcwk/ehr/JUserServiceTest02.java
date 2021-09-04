package com.pcwk.ehr;


import static org.hamcrest.CoreMatchers.notNullValue;
import static com.pcwk.ehr.member.service.UserServiceImpl.MIN_LOGCOUNT_FOR_SILVER;
import static com.pcwk.ehr.member.service.UserServiceImpl.MIN_RECCOMEND_FOR_GOLD;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.mail.MailSender;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.pcwk.ehr.Level;
import com.pcwk.ehr.member.dao.UserDao;
import com.pcwk.ehr.member.domain.UserVO;
import com.pcwk.ehr.member.service.UserService;
import com.pcwk.ehr.member.service.UserServiceImpl;

//메소드 수행 순서: method ASCENDING ex)a~z
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringJUnit4ClassRunner.class) // JUnit기능 스프링 프레임으로 확장
@ContextConfiguration(locations ={"file:src/main/webapp/WEB-INF/spring/root-context.xml",
									"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})// applicationContext.xml 설정파일 read
public class JUserServiceTest02 {
	final Logger LOG = Logger.getLogger(getClass());

	@Autowired
	UserService userService;

	@Autowired
	UserDao userDao;
	List<UserVO> list;

	@Autowired
	@Qualifier("dummyMailSender")
	MailSender mailSender;
	
	
	@Before
	public void setUp() throws Exception {
		LOG.debug("====setUp()======");
		list = Arrays.asList(new UserVO("pcwk_01", "이상무01", "1234_1", Level.BASIC, MIN_LOGCOUNT_FOR_SILVER - 1, 0,"romtree@naver.com","")// BASIC
				, new UserVO("pcwk_02", "이상무02", "1234_2", Level.BASIC, MIN_LOGCOUNT_FOR_SILVER, 10,"romtree@naver.com","")// BASIC - > SILVER
				, new UserVO("pcwk_03", "이상무03", "1234_3", Level.SILVER, MIN_LOGCOUNT_FOR_SILVER + 1, 29,"romtree@naver.com","")// SILVER
				, new UserVO("pcwk_04", "이상무04", "1234_4", Level.SILVER, 51, MIN_RECCOMEND_FOR_GOLD,"romtree@naver.com","")// SILVER - > GOLD
				, new UserVO("pcwk_05", "이상무05", "1234_5", Level.GOLD, 52, MIN_RECCOMEND_FOR_GOLD + 2,"romtree@naver.com","")// GOLD
		);
	}



	@Test
//	@Ignore
	public void add() throws SQLException, ClassNotFoundException {
		// *. Level이 null이면 : Level.BASIC
		// *. Level이 있는 경우는 : 해당 Level로 등록

		// 1. 기존 데이터 삭제

		// 2. Level이 null
		// 2.1. Level이 있는 경우
		// 2.2. 데이터 입력
		// 3. 입력데이터 조회
		// 4. 비교

		int flag = 0;

		// 1.
		for (UserVO vo : list) {
			this.userDao.doDelete(vo);
		}

		// 2.
		UserVO userWithLevel = list.get(4);// GOLD
		UserVO userWithOutLevel = list.get(0);// BASIC -> NULL
		userWithOutLevel.setLevel(null);

		flag = this.userService.add(userWithLevel);
		assertThat(flag, is(1));
		flag = this.userService.add(userWithOutLevel);
		assertThat(flag, is(1));

		// userWithLevel -> GOLD
		// userWithOutLevel -> BASIC
		UserVO userWithLevelRead = this.userDao.doSelectOne(userWithLevel);
		assertThat(userWithLevelRead.getLevel(), is(Level.GOLD));

		UserVO userWithoutLevelRead = this.userDao.doSelectOne(userWithOutLevel);

		assertThat(userWithoutLevelRead.getLevel(), is(Level.BASIC));

	}

	@Test
//	@Ignore
	public void upgradeLevels() throws Exception {
		// 1. 전체삭제
		// 2. list 데이터 입력(5건)
		int flag = 0;

		// 1.
		userDao.deleteAll();

		// 2.
		for (UserVO vo : list) {
			flag += userDao.doInsert(vo);
		}

		assertThat(flag, is(5));

		this.userService.upgradeLevels();

		checkLevel(list.get(0), false);
		checkLevel(list.get(1), true);
		checkLevel(list.get(2), false);
		checkLevel(list.get(3), true);
		checkLevel(list.get(4), false);

	}

	/**
	 * true가 전달되면 등업
	 * 
	 * @param user
	 * @param upgraded
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	private void checkLevel(UserVO user, boolean upgraded) throws ClassNotFoundException, SQLException {
		UserVO upDateUser = this.userDao.doSelectOne(user);

		// 등업되면 -> nextLevel
		if (upgraded) {
			assertThat(upDateUser.getLevel(), is(user.getLevel().nextLevel()));
			// 그렇치 않으면 -> 현재 Level로
		} else {
			assertThat(upDateUser.getLevel(), is(user.getLevel()));
		}

	}

	@Test
	public void bean() {
		LOG.debug("==============================");
		LOG.debug("=userService=" + userService);
		LOG.debug("=userDao=" + userDao);
		LOG.debug("=mailSender=" + mailSender);
		
		LOG.debug("==============================");
		assertThat(userService, is(notNullValue()));
		assertThat(userDao, is(notNullValue()));
		assertThat(mailSender, is(notNullValue()));
	}

}
