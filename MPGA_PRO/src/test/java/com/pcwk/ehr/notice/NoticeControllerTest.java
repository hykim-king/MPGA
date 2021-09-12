package com.pcwk.ehr.notice;


import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.handler;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.SQLException;
import java.util.Locale;

import javax.servlet.http.Cookie;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.google.gson.Gson;
import com.pcwk.ehr.notice.controller.NoticeController;
import com.pcwk.ehr.notice.dao.NoticeDAO;
import com.pcwk.ehr.notice.vo.NoticeVO;
import com.pcwk.ehr.notice.service.NoticeService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
									"file:src/main/resources/mybatis-config.xml",
									"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class NoticeControllerTest {
	
	private final Logger LOG = LoggerFactory.getLogger(getClass());
	

	   
	@Autowired
	public NoticeController homeController;
	private MockMvc mockMvc;
	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(homeController).build();
		
				
	}
	
	@Test
	public void notice() throws Exception {
		RequestBuilder reqBuilder = MockMvcRequestBuilders.get("/noticeGetAll.do").contentType(MediaType.APPLICATION_JSON);
		mockMvc.perform(reqBuilder).andExpect(status().isOk()).andDo(print());

	}
	
//	@Test
//	public void noticeReadTest() throws Exception {
//		MockHttpServletRequestBuilder builder =
//				get("/noticeDoRead.do?set=${seq}")
//				.param("seq", "2")
//				.cookie(new Cookie("name", "Hoon"))
//				.locale(Locale.KOREA);
//		mockMvc.perform(builder)
//			.andExpect(handler().handlerType(NoticeController.class))
//			.andExpect(handler().methodName("add")//
//	}
	
}
