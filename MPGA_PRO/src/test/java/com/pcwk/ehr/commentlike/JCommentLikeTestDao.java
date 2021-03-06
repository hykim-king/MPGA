package com.pcwk.ehr.commentlike;

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

//메소드 수행 순서: method ASCENDING ex)a~z
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringJUnit4ClassRunner.class) // JUnit기능 스프링 프레임으로 확장
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" }) /// applicationContext.xml 설정파일 read

public class JCommentLikeTestDao {
	final Logger LOG = LoggerFactory.getLogger(getClass());

	@Autowired
	ApplicationContext context;

	@Autowired
	CommentLikeDao dao;

	CommentLikeVO commentlike01;
	CommentLikeVO commentlike02;
	CommentLikeVO commentlike03;

	
	
	@Before
	public void setUp() throws Exception {
		commentlike01 = new CommentLikeVO(5,8,1);
		commentlike02 = new CommentLikeVO(2,7,2);
		commentlike03 = new CommentLikeVO(4,3,3);

	}

	
	
	@After
	public void tearDown() throws Exception {
	}
	
	
	

	@Test
	//@Ignore
	public void doUpdate() throws SQLException, ClassNotFoundException {
		int flag = 0;

		// 브랜드 삭제
		dao.deleteAll();

		// 브랜드 등록
		flag = dao.doInsert(commentlike01);
		assertThat(flag, is(1));

		// 브랜드 수정 + 업데이트
		commentlike01.setcLike(0);

		flag = dao.doUpdate(commentlike01);
		assertThat(flag, is(1));

		// 변경된 데이터 조회
		CommentLikeVO bdVO = dao.doSelectOne(commentlike01);
		isSamebrand(bdVO, commentlike01);
	}

	
	
	
	@Test
	//@Ignore
	public void getAllTest() throws SQLException, ClassNotFoundException {
		// 전체 데이터 삭제
		dao.deleteAll();

		// 데이터 입력(3건)
		int flag = dao.doInsert(commentlike01);
		assertThat(flag, is(1));

		flag += dao.doInsert(commentlike02);
		assertThat(flag, is(2));

		flag += dao.doInsert(commentlike03);
		assertThat(flag, is(3));

		// 데이터 조회(데이터 3개)
		List<CommentLikeVO> list = dao.getAll();

		assertThat(list.size(), is(3));
	}

	
	
	
	
	@Test(expected = EmptyResultDataAccessException.class)
	@Ignore
	public void getFailure() throws ClassNotFoundException, SQLException {
		LOG.debug("=========================");
		LOG.debug("=getFailure()=");
		LOG.debug("=========================");
		// 삭제
		dao.deleteAll();

		dao.doSelectOne(commentlike01);

	}

	
	
	@Test
	//@Ignore
	public void doDelete() throws SQLException, ClassNotFoundException {
		int flag = 0;

		// 기존 데이터 삭제
		dao.deleteAll();

		// 데이터 입력
		flag = dao.doInsert(commentlike01);
		assertThat(flag, is(1));

		// 삭제
		flag = dao.doDelete(commentlike01);
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
			// dao.doDelete(commentlike01);
			// dao.doDelete(commentlike02);
			// dao.doDelete(commentlike03);

			// 등록
			int flag = dao.doInsert(commentlike01);
			assertThat(flag, is(1));

			// 1건등록 확인
			assertThat(dao.getCount(), is(1));

			// 2건등록
			flag = dao.doInsert(commentlike02);
			assertThat(flag, is(1));

			// 2건등록 확인
			assertThat(dao.getCount(), is(2));

			// 3건등록
			flag = dao.doInsert(commentlike03);
			assertThat(flag, is(1));
			assertThat(dao.getCount(), is(3));

			// 한건 조회
			CommentLikeVO outVO_01 = dao.doSelectOne(commentlike01);

			isSamebrand(outVO_01, commentlike01);

			// 한건 조회
			CommentLikeVO outVO_02 = dao.doSelectOne(commentlike02);
			isSamebrand(outVO_02, commentlike02);

			// 한건 조회
			CommentLikeVO outVO_03 = dao.doSelectOne(commentlike03);
			isSamebrand(outVO_03, commentlike03);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	

	public void isSamebrand(CommentLikeVO outVO, CommentLikeVO brand) {
		assertThat(outVO.getcLike(), is(brand.getcLike()));
		assertThat(outVO.getMemberNum(), is(brand.getMemberNum()));
		assertThat(outVO.getSeq(), is(brand.getSeq()));

	}

}
