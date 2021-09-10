package com.pcwk.ehr.ProfileImg;

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
import com.pcwk.ehr.profileImg.ProfileImgDao;
import com.pcwk.ehr.profileImg.ProfileImgVO;

//메소드 수행 순서: method ASCENDING ex)a~z
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringJUnit4ClassRunner.class) // JUnit기능 스프링 프레임으로 확장
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" }) /// applicationContext.xml 설정파일 read

public class JProfileImgTestDao {
	final Logger LOG = LoggerFactory.getLogger(getClass());

	@Autowired
	ApplicationContext context;

	@Autowired
	ProfileImgDao dao;

	ProfileImgVO profileImg01;
	ProfileImgVO profileImg02;
	ProfileImgVO profileImg03;
	
	SearchVO  searchVO;

	@Before
	public void setUp() throws Exception {
		profileImg01 = new ProfileImgVO(01, "imgPath_01",  "", 10);
		profileImg02 = new ProfileImgVO(02, "imgPath_02", "", 20);
		profileImg03 = new ProfileImgVO(03, "imgPath_03", "", 30);

	}

	@After
	public void tearDown() throws Exception {
	}

	
	@Test 
	@Ignore
	public void mybatisDelete() throws ClassNotFoundException,SQLException {
	
		searchVO.setSearchDiv("3");
		searchVO.setSearchWord("j");
	
		List<ProfileImgVO> list = (List<ProfileImgVO>)dao.doRetrieve(searchVO);
		for(ProfileImgVO vo:list) {
			LOG.debug("=vo="+vo);
		}
		
		assertThat(list.size(), is(1));
		
	}
	

	@Test
	//@Ignore
	public void doUpdate() throws SQLException, ClassNotFoundException {
		int flag = 0;

		// 브랜드 삭제
		dao.deleteAll();

		// 브랜드 등록
		flag = dao.doInsert(profileImg01);
		assertThat(flag, is(1));

		// 브랜드 수정 + 업데이트
		profileImg01.setProImgPath(profileImg01.getProImgPath() + "_U");
		profileImg01.setRegNum(50);

		flag = dao.doUpdate(profileImg01);
		assertThat(flag, is(1));

		// 변경된 데이터 조회
		ProfileImgVO imgVO = dao.doSelectOne(profileImg01);
		isSamebrand(imgVO, profileImg01);
	}

	@Test
	//@Ignore
	public void getAllTest() throws SQLException, ClassNotFoundException {
		// 전체 데이터 삭제
		dao.deleteAll();

		// 데이터 입력(3건)
		int flag = dao.doInsert(profileImg01);
		assertThat(flag, is(1));

		flag += dao.doInsert(profileImg02);
		assertThat(flag, is(2));

		flag += dao.doInsert(profileImg03);
		assertThat(flag, is(3));

		// 데이터 조회(데이터 3개)
		List<ProfileImgVO> list = dao.getAll();

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

		dao.doSelectOne(profileImg01);

	}

	@Test
	//@Ignore
	public void doDelete() throws SQLException, ClassNotFoundException {
		int flag = 0;

		// 기존 데이터 삭제
		dao.deleteAll();

		// 데이터 입력
		flag = dao.doInsert(profileImg01);
		assertThat(flag, is(1));

		// 삭제
		flag = dao.doDelete(profileImg01);
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
			// dao.doDelete(profileImg01);
			// dao.doDelete(brand02);
			// dao.doDelete(brand03);

			// 등록
			int flag = dao.doInsert(profileImg01);
			assertThat(flag, is(1));

			// 1건등록 확인
			assertThat(dao.getCount(), is(1));

			// 2건등록
			flag = dao.doInsert(profileImg02);
			assertThat(flag, is(1));

			// 2건등록 확인
			assertThat(dao.getCount(), is(2));

			// 3건등록
			flag = dao.doInsert(profileImg03);
			assertThat(flag, is(1));
			assertThat(dao.getCount(), is(3));

			// 한건 조회
			ProfileImgVO outVO_01 = dao.doSelectOne(profileImg01);

			isSamebrand(outVO_01, profileImg01);

			// 한건 조회
			ProfileImgVO outVO_02 = dao.doSelectOne(profileImg02);
			isSamebrand(outVO_02, profileImg02);

			// 한건 조회
			ProfileImgVO outVO_03 = dao.doSelectOne(profileImg03);
			isSamebrand(outVO_03, profileImg03);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void isSamebrand(ProfileImgVO outVO, ProfileImgVO brand) {
		assertThat(outVO.getSeq(), is(brand.getSeq()));
		assertThat(outVO.getProImgPath(), is(brand.getProImgPath()));
		assertThat(outVO.getRegNum(), is(brand.getRegNum()));

	}

}