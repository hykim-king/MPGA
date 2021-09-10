package com.pcwk.ehr.brandmenu;

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
import com.pcwk.ehr.brandmenu.BrandMenuDao;

//메소드 수행 순서: method ASCENDING ex)a~z
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringJUnit4ClassRunner.class) // JUnit기능 스프링 프레임으로 확장
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" }) /// applicationContext.xml 설정파일 read

public class JBrandTestDao {
	final Logger LOG = LoggerFactory.getLogger(getClass());

	@Autowired
	ApplicationContext context;

	@Autowired
	BrandMenuDao dao;

	BrandMenuVO brandmenu01;
	BrandMenuVO brandmenu02;
	BrandMenuVO brandmenu03;
	
	SearchVO  searchVO;

	@Before
	public void setUp() throws Exception {
		brandmenu01 = new BrandMenuVO("M_01_01", "MENU_01", "양념치킨", "허니콤보", "Rd", "",  "",10);
		brandmenu02 = new BrandMenuVO("M_01_02", "MENU_02", "간장치킨", "투움바치킨", "FFF", "", "", 20);
		brandmenu03 = new BrandMenuVO("M_01_03", "MENU_03", "후라이드치킨", "치킨맛이에요", "DDD", "", "", 30);

	}

	@After
	public void tearDown() throws Exception {
	}

	
	@Test 
	@Ignore
	public void mybatisDelete() throws ClassNotFoundException,SQLException {
	
		searchVO.setSearchDiv("3");
		searchVO.setSearchWord("j");
	
		List<BrandMenuVO> list = (List<BrandMenuVO>)dao.doRetrieve(searchVO);
		for(BrandMenuVO vo:list) {
			LOG.debug("=vo="+vo);
		}
		
		assertThat(list.size(), is(10));
		
	}
	

	@Test
	//@Ignore
	public void doUpdate() throws SQLException, ClassNotFoundException {
		int flag = 0;

		// 브랜드 삭제
		dao.deleteAll();

		// 브랜드 등록
		flag = dao.doInsert(brandmenu01);
		assertThat(flag, is(1));

		// 브랜드 수정 + 업데이트
		brandmenu01.setbCode(brandmenu01.getbCode() + "_U");
		brandmenu01.setMenuName(brandmenu01.getMenuName() + "_U");
		brandmenu01.setMenuInfo(brandmenu01.getMenuInfo() + "_U");
		brandmenu01.setMenuImg(brandmenu01.getMenuImg() + "_U");
		brandmenu01.setRegNum(5);
		

		flag = dao.doUpdate(brandmenu01);
		assertThat(flag, is(1));

		// 변경된 데이터 조회
		BrandMenuVO bmVO = dao.doSelectOne(brandmenu01);
		isSamebrand(bmVO, brandmenu01);
	}

	@Test
	//@Ignore
	public void getAllTest() throws SQLException, ClassNotFoundException {
		// 전체 데이터 삭제
		dao.deleteAll();

		// 데이터 입력(3건)
		int flag = dao.doInsert(brandmenu01);
		assertThat(flag, is(1));

		flag += dao.doInsert(brandmenu02);
		assertThat(flag, is(2));

		flag += dao.doInsert(brandmenu03);
		assertThat(flag, is(3));

		// 데이터 조회(데이터 3개)
		List<BrandMenuVO> list = dao.getAll();

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

		dao.doSelectOne(brandmenu01);

	}

	@Test
	//@Ignore
	public void doDelete() throws SQLException, ClassNotFoundException {
		int flag = 0;

		// 기존 데이터 삭제
		dao.deleteAll();

		// 데이터 입력
		flag = dao.doInsert(brandmenu01);
		assertThat(flag, is(1));

		// 삭제
		flag = dao.doDelete(brandmenu01);
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
			// dao.doDelete(brandmenu01);
			// dao.doDelete(brandmenu02);
			// dao.doDelete(brandmenu03);

			// 등록
			int flag = dao.doInsert(brandmenu01);
			assertThat(flag, is(1));

			// 1건등록 확인
			assertThat(dao.getCount(), is(1));

			// 2건등록
			flag = dao.doInsert(brandmenu02);
			assertThat(flag, is(1));

			// 2건등록 확인
			assertThat(dao.getCount(), is(2));

			// 3건등록
			flag = dao.doInsert(brandmenu03);
			assertThat(flag, is(1));
			assertThat(dao.getCount(), is(3));

			// 한건 조회
			BrandMenuVO outVO_01 = dao.doSelectOne(brandmenu01);

			isSamebrand(outVO_01, brandmenu01);

			// 한건 조회
			BrandMenuVO outVO_02 = dao.doSelectOne(brandmenu02);
			isSamebrand(outVO_02, brandmenu02);

			// 한건 조회
			BrandMenuVO outVO_03 = dao.doSelectOne(brandmenu03);
			isSamebrand(outVO_03, brandmenu03);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void isSamebrand(BrandMenuVO outVO, BrandMenuVO brand) {
		assertThat(outVO.getMenuNum(), is(brand.getMenuNum()));
		assertThat(outVO.getbCode(), is(brand.getbCode()));
		assertThat(outVO.getMenuName(), is(brand.getMenuName()));
		assertThat(outVO.getMenuInfo(), is(brand.getMenuInfo()));
		assertThat(outVO.getMenuImg(), is(brand.getMenuImg()));
		assertThat(outVO.getRegNum(), is(brand.getRegNum()));

	}

}
