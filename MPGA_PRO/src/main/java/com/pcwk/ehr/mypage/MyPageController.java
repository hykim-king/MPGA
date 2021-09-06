package com.pcwk.ehr.mypage;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pcwk.ehr.member.UserVO;

import org.springframework.web.bind.annotation.RequestMapping;

public class MyPageController {
	
	final Logger LOG = LoggerFactory.getLogger(getClass());
	
	@Autowired
	MyPageService service;
	
	public MyPageController() {}
	
	@RequestMapping(value = "member/doSelectOne.do", method = RequestMethod.GET)
	public String doSelectOne(MyPageVO inVO) throws ClassNotFoundException, SQLException {
		LOG.debug("=============================");
		LOG.debug("=doSelectOne=");
		LOG.debug("=param=" + inVO);
		LOG.debug("=============================");

		MyPageVO outVO = service.doSelectOne(inVO);
		LOG.debug("=outVO=" + outVO);
		return "member/member_mng";
		
		
	}
	
	public String doUpdate(MyPageVO myPageVO) throws SQLException {
		return null;
	}
	
	public String doRetrieve(MyPageVO myPageVO) throws SQLException {
		return null;
	}
	
	public String doInsert(MyPageVO myPageVO) throws ClassNotFoundException, SQLException {
		return null;
	}
	
	public String doDelete(MyPageVO myPageVO) throws SQLException {
		return null;
	}

}
