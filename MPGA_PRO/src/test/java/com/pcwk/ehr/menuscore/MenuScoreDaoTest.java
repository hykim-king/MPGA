package com.pcwk.ehr.menuscore;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.sql.SQLException;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.pcwk.ehr.menuscore.MenuScoreService;
import com.pcwk.ehr.menuscore.MenuScoreVO;
import com.pcwk.ehr.menuscore.MenuScoreDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/resources/mybatis-config.xml" })
public class MenuScoreDaoTest {
	private final Logger log = LoggerFactory.getLogger(MenuScoreDaoTest.class);

	@Autowired
	private MenuScoreDao dao;

	MenuScoreVO user01;



	// 등록 테스트
	@Test
	
	public void testDoInsert() throws Exception {
		user01 = new MenuScoreVO();
		user01.setMemberNum(1234);
		user01.setMenuNum("123456");
		user01.setScore(5);
		
		try {
			dao.menuScoreInsert(user01);
		} catch (Exception e) {
			log.debug("실패!");
			e.printStackTrace();
		}
	}

// 업데이트 테스트
	@Test
	public void testDoUpdate() throws SQLException, ClassNotFoundException {
		user01 = new MenuScoreVO();
		user01.setMemberNum(1234);
		user01.setMenuNum("123456");
		user01.setScore(1);
		try {
			dao.menuScoreUpdate(user01);
		} catch (Exception e) {
			log.debug("실패!");
			e.printStackTrace();
		}
	}

// 삭제 테스트
	@Test
	
	public void testDoDelete() {
		user01 = new MenuScoreVO();
		user01.setMemberNum(1234);
		user01.setMenuNum("123456");

		try {
			dao.menuScoreDelete(user01);
			log.info("성공하였습니다.");
		} catch (Exception e) {
			log.info("실패하였습니다.");
			e.printStackTrace();
		}
	}
}
