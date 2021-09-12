package com.pcwk.ehr.menuselect;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pcwk.ehr.menuselect.MenuSelectService;
import com.pcwk.ehr.menuselect.MenuSelectDao;
import com.pcwk.ehr.menuselect.MenuSelectVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/resources/mybatis-config.xml" })
public class MenuSelectDaoTest {
	private final Logger log = LoggerFactory.getLogger(MenuSelectControllerTest.class);

	@Autowired
	private MenuSelectDao dao;

	@Autowired
	ApplicationContext context;

	@Autowired
	MenuSelectVO user01;
	MenuSelectVO user02;
	MenuSelectVO user03;

	// 등록 테스트
	@Test
	public void testDoInsert() {

		user01.setMemberNum(1234);
		user01.setMenuNum("123456");

		try {
			dao.menuSelectInsert(user01);
		} catch (Exception e) {
			log.debug("실패!");
			e.printStackTrace();
		}
	}

	// 삭제 테스트
	@Test
	public void testDoDelete() {
		try {
			dao.menuSelectDelete(user01);
			log.info("성공하였습니다.");
		} catch (Exception e) {
			log.info("실패하였습니다.");
			e.printStackTrace();
		}
	}
}