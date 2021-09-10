package com.pcwk.ehr.brand;

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
import com.pcwk.ehr.brand.BrandVO;
import com.pcwk.ehr.brand.BrandDao;

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
	BrandDao dao;

	BrandVO brand01;
	BrandVO brand02;
	BrandVO brand03;
	
	SearchVO  searchVO;

	@Before
	public void setUp() throws Exception {
		brand01 = new BrandVO("B_01_01", "LOGO_01", "www.do01", "맛좋은 치킨", "BHC", "", 10);
		brand02 = new BrandVO("B_01_02", "LOGO_02", "www.do02", "구미의 맛", "교촌치킨", "", 20);
		brand03 = new BrandVO("B_01_03", "LOGO_03", "www.do03", "가족같은 치킨", "노랑통닭", "", 30);

	}

	@After
	public void tearDown() throws Exception {
	}

	
	@Test 
	@Ignore
	public void mybatisDelete() throws ClassNotFoundException,SQLException {
	
		searchVO.setSearchDiv("3");
		searchVO.setSearchWord("j");
	
		List<BrandVO> list = (List<BrandVO>)dao.doRetrieve(searchVO);
		for(BrandVO vo:list) {
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
		flag = dao.doInsert(brand01);
		assertThat(flag, is(1));

		// 브랜드 수정 + 업데이트
		brand01.setbLogoImg(brand01.getbLogoImg() + "_U");
		brand01.setbUrl(brand01.getbUrl() + "_U");
		brand01.setbItr(brand01.getbItr() + "_U");
		brand01.setbName(brand01.getbName() + "_U");
		brand01.setRegNum(5);

		flag = dao.doUpdate(brand01);
		assertThat(flag, is(1));

		// 변경된 데이터 조회
		BrandVO bdVO = dao.doSelectOne(brand01);
		isSamebrand(bdVO, brand01);
	}

	@Test
	//@Ignore
	public void getAllTest() throws SQLException, ClassNotFoundException {
		// 전체 데이터 삭제
		dao.deleteAll();

		// 데이터 입력(3건)
		int flag = dao.doInsert(brand01);
		assertThat(flag, is(1));

		flag += dao.doInsert(brand02);
		assertThat(flag, is(2));

		flag += dao.doInsert(brand03);
		assertThat(flag, is(3));

		// 데이터 조회(데이터 3개)
		List<BrandVO> list = dao.getAll();

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

		dao.doSelectOne(brand01);

	}

	@Test
	//@Ignore
	public void doDelete() throws SQLException, ClassNotFoundException {
		int flag = 0;

		// 기존 데이터 삭제
		dao.deleteAll();

		// 데이터 입력
		flag = dao.doInsert(brand01);
		assertThat(flag, is(1));

		// 삭제
		flag = dao.doDelete(brand01);
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
			// dao.doDelete(brand01);
			// dao.doDelete(brand02);
			// dao.doDelete(brand03);

			// 등록
			int flag = dao.doInsert(brand01);
			assertThat(flag, is(1));

			// 1건등록 확인
			assertThat(dao.getCount(), is(1));

			// 2건등록
			flag = dao.doInsert(brand02);
			assertThat(flag, is(1));

			// 2건등록 확인
			assertThat(dao.getCount(), is(2));

			// 3건등록
			flag = dao.doInsert(brand03);
			assertThat(flag, is(1));
			assertThat(dao.getCount(), is(3));

			// 한건 조회
			BrandVO outVO_01 = dao.doSelectOne(brand01);

			isSamebrand(outVO_01, brand01);

			// 한건 조회
			BrandVO outVO_02 = dao.doSelectOne(brand02);
			isSamebrand(outVO_02, brand02);

			// 한건 조회
			BrandVO outVO_03 = dao.doSelectOne(brand03);
			isSamebrand(outVO_03, brand03);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void isSamebrand(BrandVO outVO, BrandVO brand) {
		assertThat(outVO.getbCode(), is(brand.getbCode()));
		assertThat(outVO.getbLogoImg(), is(brand.getbLogoImg()));
		assertThat(outVO.getbUrl(), is(brand.getbUrl()));
		assertThat(outVO.getbItr(), is(brand.getbItr()));
		assertThat(outVO.getbName(), is(brand.getbName()));
		assertThat(outVO.getRegNum(), is(brand.getRegNum()));

	}

}
