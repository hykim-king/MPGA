package com.pcwk.ehr;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.pcwk.ehr.member.domain.UserVO;

//메소드 수행 순서: method ASCENDING ex)a~z
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class) //JUnit기능 스프링 프레임으로 확장
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml",
									"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})///applicationContext.xml 설정파일 read

public class JUserControllerTest02 {

	final Logger LOG = LoggerFactory.getLogger(getClass());
	@Autowired
	WebApplicationContext webApplicationContext;
	
	//브라우저 대신할 Mock
	MockMvc mockMvc;
	
	UserVO user01;
	UserVO user02;
	UserVO user03;
	
	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		
		user01 = new UserVO("pcwk_01", "이상무01", "1234_1",Level.BASIC,1,0,"romtree@naver.com","");
		user02 = new UserVO("pcwk_02", "이상무02", "1234_2",Level.SILVER,51,0,"romtree@naver.com","");
		user03 = new UserVO("pcwk_03", "이상무03", "1234_3",Level.GOLD,71,31,"romtree@naver.com","");	
	}
	
	@Test
	public void doSelectOne() throws Exception {
		//param
		MockHttpServletRequestBuilder createMessage =
				MockMvcRequestBuilders.get("/member/doSelectOne.do")
				.param("uId", user01.getuId());
		
		//호출, 예상 결과
		ResultActions resultActions = this.mockMvc.perform(createMessage)
										.andExpect(status().isOk());
		
		String result = resultActions.andDo(print())
				.andReturn()
				.getResponse().getContentAsString();
		LOG.debug("======================");
		LOG.debug("result"+result);
		LOG.debug("======================");
	}
	
	
	
	
	
	@Test
	public void beans() {
		LOG.debug("webApplicationContext"+webApplicationContext);
		assertThat(webApplicationContext, is(notNullValue()));
		
		
	}
}
