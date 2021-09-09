package com.pcwk.ehr.comment;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.sql.SQLException;

import org.hamcrest.core.IsSame;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//메소드 수행 순서: method ASCENDING ex)a~z
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringJUnit4ClassRunner.class) // JUnit기능 스프링 프레임으로 확장
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" }) /// applicationContext.xml 설정파일 read

public class JCommentDaoTest {

	final Logger LOG = LoggerFactory.getLogger(getClass());
	
	@Autowired
	ApplicationContext context;

	@Autowired
	MenuCommentDao dao;
	
	MenuCommentVO menucomment01;
	MenuCommentVO menucomment02;
	MenuCommentVO menucomment03;
	
	@Before
	
	@After
	public void tearDown() throws Exception {
		LOG.debug("================");
		LOG.debug("=@After tearDown()=");
		LOG.debug("================");
	}
	
	@Test
	public void mybatisDelete() throws SQLException {
		int flag = dao.doInsert(menucomment01);
		assertThat(flag, is(1));
	
		
		flag = dao.doDelete(menucomment01);
		assertThat(flag, is(1));
	}

}
