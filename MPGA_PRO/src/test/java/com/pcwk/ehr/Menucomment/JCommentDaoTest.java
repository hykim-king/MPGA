package com.pcwk.ehr.Menucomment;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pcwk.ehr.SearchVO;
import com.pcwk.ehr.menucomment.MenuCommentDao;
import com.pcwk.ehr.menucomment.MenuCommentVO;

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
	public void setUp() throws Exception {
		menucomment01 = new MenuCommentVO(1, "LOGO_01", 1, "comment01", "");
		menucomment02 = new MenuCommentVO(2, "LOGO_02", 2, "comment02", "");
		menucomment03 = new MenuCommentVO(3, "LOGO_03", 3, "comment03", "");

		LOG.debug("=========================");
		LOG.debug("=context="+context);
		LOG.debug("=dao="+dao);
		LOG.debug("=========================");		

	}
	
	
	@After
	public void tearDown() throws Exception {
		LOG.debug("================");
		LOG.debug("=@After tearDown()=");
		LOG.debug("================");
	}
	
	@Test
	//@Ignore
	public void doUpdate() throws SQLException, ClassNotFoundException {
		int flag = 0;

		// 삭제
		dao.deleteAll();

		// 등록
		flag = dao.doInsert(menucomment01);
		assertThat(flag, is(1));

		// 수정 + 업데이트
		menucomment01.setMenuNum(menucomment01.getMenuNum() + "_U");
		menucomment01.setMemberNum(2);
		menucomment01.setContents(menucomment01.getContents() + "_U");
		menucomment01.setRegDt(menucomment01.getRegDt());
		
	}

	@Test
	//@Ignore
	public void getAllTest() throws SQLException, ClassNotFoundException {
		// 전체 데이터 삭제
		dao.deleteAll();

		// 데이터 입력(3건)
		int flag = dao.doInsert(menucomment01);
		assertThat(flag, is(1));

		flag += dao.doInsert(menucomment02);
		assertThat(flag, is(2));

		flag += dao.doInsert(menucomment03);
		assertThat(flag, is(3));

		// 데이터 조회(데이터 3개)
		List<MenuCommentVO> list = dao.getAll();

		assertThat(list.size(), is(3));
	}

	@Test
	//@Ignore
	public void testAssert() {
		LOG.debug("=========================");
		LOG.debug("=testAssert()=");
		LOG.debug("=========================");	
		
		String[] names = {"Tom","JIMMY","SCOTT"};
		String[] anotherNames = {"Tom","JIMMY","SCOTT"};
		assertArrayEquals(names,anotherNames);
	}
	
	
	
	@Test(expected = EmptyResultDataAccessException.class)
	@Ignore
	public void getFailure() throws ClassNotFoundException, SQLException {
		LOG.debug("=========================");
		LOG.debug("=getFailure()=");
		LOG.debug("=========================");
		// 삭제
		dao.deleteAll();

		dao.doSelectOne(menucomment01);

	}

	@Test
	//@Ignore
	public void doDelete() throws SQLException, ClassNotFoundException {
		int flag = 0;

		// 기존 데이터 삭제
		dao.deleteAll();

		// 데이터 입력
		flag = dao.doInsert(menucomment01);
		assertThat(flag, is(1));

		// 삭제
		flag = dao.doDelete(menucomment01);
		assertThat(flag, is(1));

		// 남은 데이터 건수 확인
		int cnt = dao.getCount();
		assertThat(cnt, is(0));

	}

	// 1/1000초
	@Test(timeout = 20000)
	//@Ignore
	public void addAndGet() {

		try {
			// 전체삭제
			dao.deleteAll();

			// 등록
			int flag = dao.doInsert(menucomment01);
			assertThat(flag, is(1));

			// 1건등록 확인
			assertThat(dao.getCount(), is(1));

			// 2건등록
			flag = dao.doInsert(menucomment02);
			assertThat(flag, is(1));

			// 2건등록 확인
			assertThat(dao.getCount(), is(2));

			// 3건등록
			flag = dao.doInsert(menucomment03);
			assertThat(flag, is(1));
			assertThat(dao.getCount(), is(3));

			// 한건 조회
			MenuCommentVO outVO_01 = dao.doSelectOne(menucomment01);

			isSameMenuComment(outVO_01, menucomment01);

			// 한건 조회
			MenuCommentVO outVO_02 = dao.doSelectOne(menucomment02);
			isSameMenuComment(outVO_02, menucomment02);

			// 한건 조회
			MenuCommentVO outVO_03 = dao.doSelectOne(menucomment03);
			isSameMenuComment(outVO_03, menucomment03);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void isSameMenuComment(MenuCommentVO outVO, MenuCommentVO menucomment) {
		assertThat(outVO.getMenuNum(), is(menucomment.getMenuNum()));
		assertThat(outVO.getMemberNum(), is(menucomment.getMemberNum()));
		assertThat(outVO.getContents(), is(menucomment.getContents()));
		assertThat(outVO.getRegDt(), is(menucomment.getRegDt()));

	}

}
