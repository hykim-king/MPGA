package com.pcwk.ehr.member;

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

import com.pcwk.ehr.Rank;
import com.pcwk.ehr.SearchVO;
import com.pcwk.ehr.member.UserVO;

//메소드 수행 순서: method ASCENDING ex)a~z
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringJUnit4ClassRunner.class) //JUnit기능 스프링 프레임으로 확장
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml", 
								   "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"}) ///applicationContext.xml 설정파일 read

public class JUserDaoTest {
	
	final Logger LOG = LoggerFactory.getLogger(getClass());

	@Autowired
	ApplicationContext context;
	
	@Autowired
	UserDao dao;
	
	UserVO user01;
	UserVO user02;
	UserVO user03;
	
	SearchVO  searchVO;
	
	@Before
	public void setUp() throws Exception {
		//context = new GenericXmlApplicationContext("/applicationContext.xml");
		//dao = context.getBean("userDao", UserDao.class);
		/*
		 *  사용자 레벨은 : BASIC,SILVER,GOLD
			사용자가 처음 가입 하면 : BASIC
			가입이후 50회 이상 로그인 하면 : SILVER
			SILVER 레벨이면서 30번 이상 추천을 받으면 GOLD로 레벨 UP.

		 */
		//public UserVO(String uId, String name, String passwd, Level level, int login, int recommend) {
		//	public UserVO(String uId, String name, String passwd, Level level, int login, int recommend, String email,
		//  String regDt) {
		user01 = new UserVO(1,1,"pcwk_01","balmong","01012345678","jamesol@naver.com","pcwk1234","120922","1","",1,Rank.BASIC, 10);
	
		searchVO = new SearchVO();
		searchVO.setPageSize(10);
		searchVO.setPageNum(1);
		LOG.debug("=========================");
		LOG.debug("=context="+context);
		LOG.debug("=dao="+dao);
		LOG.debug("=========================");		
	}

	@After
	public void tearDown() throws Exception {
		
	}
	
	@Test
	@Ignore
	public void mybatisDelete() throws ClassNotFoundException, SQLException {
//		int flag = 0;
//		flag =dao.doInsert(user01);
//		assertThat(flag, is(1));
//		
//		
//		UserVO vsUser = dao.doSelectOne(user01);
//		isSameUser(vsUser, user01);
//		
//		flag = dao.doDelete(user01);
//		assertThat(flag, is(1));
		searchVO.setSearchDiv("30");
		searchVO.setSearchWord("james000001");
		
		List<UserVO> list = (List<UserVO>)dao.doRetrieve(searchVO);
		for(UserVO vo :list) {
			LOG.debug("=vo="+vo);
		}
		
		//여기에 문제.
		assertThat(list.size(), is(10));
	}

	//-통과
	@Test
	//@Ignore
	public void doUpdate() throws SQLException, ClassNotFoundException {
		//1. 기존데이터 All 삭제
		//2. 신규로 1건 입력
		//3. VO 데이터 수정 + update
		//4. 비교 : 데이터 조회
		
		int flag  = 0;
		//1.
		dao.deleteAll();
		
		
		//2.
		flag = dao.doInsert(user01);
		assertThat(flag, is(1));
		
		//3. VO 데이터 수정 + update
		user01.setNickName(user01.getNickName()+"_U");
		user01.setPw(user01.getPw()+"_U");
		
		//email
		user01.setEmail(user01.getEmail()+"U");
		
		//3.1
		flag = dao.doUpdate(user01);
		assertThat(flag, is(1));
		
		//4. 변경된 데이터 조회
		UserVO vsVO = dao.doSelectOne(user01);
		
		isSameUser(vsVO,user01);
	}
	
	//-통과
	@Test
	@Ignore
	public void getAllTest() throws SQLException, ClassNotFoundException {
		//1.전체 삭제
		//2.데이터 입력(3건)
		//3.전체조회=3건인지 확인
		
		//1.
		dao.deleteAll();
		
		//2.
		int flag = dao.doInsert(user01);
		assertThat(flag, is(1));
		
		/*
		 * flag+= dao.doInsert(user02); assertThat(flag, is(2));
		 * 
		 * flag+= dao.doInsert(user03); assertThat(flag, is(3));
		 */
		
		//3.
		List<UserVO> list = dao.getAll();
		
		assertThat(list.size(), is(1));
	}
	
	//비교표현식 - 통과
	@Test
	@Ignore
	public void testAssert() {
		LOG.debug("=========================");
		LOG.debug("=testAssert()=");
		LOG.debug("=========================");	
		
		
		//assertThat(테스트 대상, Matcher구문);
		//예상은 2021-08-19 였었는데 실제는 2021-08-20
		//assertThat("2021-08-20", is("2021-08-20"));
		
		//assertThat("시작 날짜 비교","2021-08-20", is("2021-08-19"));
		
		//배열지원
		String[] names = {"Tom","JIMMY","SCOTT"};
		String[] anotherNames = {"Tom","JIMMY","SCOTT"};
		assertArrayEquals(names,anotherNames);
		
		//객체 A와 B가 같은지
		//assertEquals(a, b);
		
		//객체 A와 B가 같은지: c오차범위
		//assertEquals(a, b,c);
		
		//객체 A와 B가 같은 객체인지
		//assertSame(names, anotherNames);
		
		//assertTrue(a)
		//assertTrue()
		//조건 A가 참인가를 확인한다.		
	}
	
	
	//failures: 1 통과?
	@Test(expected = EmptyResultDataAccessException.class)
	@Ignore
	public void getFailure() throws ClassNotFoundException, SQLException {
		LOG.debug("=========================");
		LOG.debug("=getFailure()=");
		LOG.debug("=========================");
		// 삭제
		dao.deleteAll();

		dao.doSelectOne(user01);

	}
	
	//-통과
	@Test
	@Ignore
	public void doDelete() throws SQLException, ClassNotFoundException {
		//1.기존 데이터 삭제
		//2.데이터 입력
		//3.삭제
		//4.잔연 데이터 건수 확인
		int flag = 0;
		//1.
		dao.deleteAll();

		//2.
		flag = dao.doInsert(user01);
		assertThat(flag, is(1));
		
		//3.
		flag = dao.doDelete(user01);
		assertThat(flag, is(1));
		
		//4.
		int cnt = dao.getCount();
		assertThat(cnt, is(0));
		
		
	}
	
	//통과
	// 1/1000초
	@Test(timeout = 20000)
	@Ignore
	public void addAndGet() {

		try {
			// 전체삭제
			dao.deleteAll();
			//dao.doDelete(user01);
			//dao.doDelete(user02);
			//dao.doDelete(user03);

			// 등록
			int flag = dao.doInsert(user01);
			assertThat(flag, is(1));

			// 1건등록 확인
			assertThat(dao.getCount(), is(1));

			// 2건등록
			//flag = dao.doInsert(user02);
			//assertThat(flag, is(1));

			// 2건등록 확인
			//assertThat(dao.getCount(), is(2));

			// 3건등록
			//flag = dao.doInsert(user03);
			//assertThat(flag, is(1));
			//assertThat(dao.getCount(), is(3));

			// 한건 조회
			UserVO outVO_01 = dao.doSelectOne(user01);

			isSameUser(outVO_01, user01);

			// 한건 조회
			//UserVO outVO_02 = dao.doSelectOne(user02);
			//isSameUser(outVO_02, user02);

			// 한건 조회
			//UserVO outVO_03 = dao.doSelectOne(user03);
			//isSameUser(outVO_03, user03);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void isSameUser(UserVO outVO, UserVO user) {
		assertThat(outVO.getId(), is(user.getId()));
		assertThat(outVO.getNickName(), is(user.getNickName()));
		assertThat(outVO.getPw(), is(user.getPw()));
		
		assertThat(outVO.getEmail(), is(user.getEmail()));
		
	}
	

}
