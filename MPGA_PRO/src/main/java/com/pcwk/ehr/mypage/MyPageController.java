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
	public String doSelectOneProfileImg(MyPageVO inVO) throws ClassNotFoundException, SQLException {
		LOG.debug("=============================");
		LOG.debug("=doSelectOne=");
		LOG.debug("=param=" + inVO);
		LOG.debug("=============================");

		MyPageVO outVO = service.doSelectOneProfileImg(inVO);
		LOG.debug("=outVO=" + outVO);
		return "member/member_mng";
		
		 
	}
	
	@RequestMapping(value = "member/doSelectOne.do", method = RequestMethod.GET)
	public String doSelectOnePersonal(MyPageVO inVO) throws ClassNotFoundException, SQLException {
		LOG.debug("=============================");
		LOG.debug("=doSelectOne=");
		LOG.debug("=param=" + inVO);
		LOG.debug("=============================");

		MyPageVO outVO = service.doSelectOnePersonal(inVO);
		LOG.debug("=outVO=" + outVO);
		return "member/member_mng";
		
		 
	}
	
	@RequestMapping(value = "member/doSelectOne.do", method = RequestMethod.GET)
	public String doSelectOneSelect(MyPageVO inVO) throws ClassNotFoundException, SQLException {
		LOG.debug("=============================");
		LOG.debug("=doSelectOne=");
		LOG.debug("=param=" + inVO);
		LOG.debug("=============================");

		MyPageVO outVO = service.doSelectOneSelect(inVO);
		LOG.debug("=outVO=" + outVO);
		return "member/member_mng";
		
		 
	}
	
	@RequestMapping(value = "member/doSelectOne.do", method = RequestMethod.GET)
	public String doSelectOneComment(MyPageVO inVO) throws ClassNotFoundException, SQLException {
		LOG.debug("=============================");
		LOG.debug("=doSelectOne=");
		LOG.debug("=param=" + inVO);
		LOG.debug("=============================");

		MyPageVO outVO = service.doSelectOneComment(inVO);
		LOG.debug("=outVO=" + outVO);
		return "member/member_mng";
		
		 
	}
	
	public String doUpdateProfileImg(MyPageVO myPageVO) throws SQLException {
		return null;
	}
	
	public String doUpdatePersonal(MyPageVO myPageVO) throws SQLException {
		return null;
	}
	
	public String doUpdateSelect(MyPageVO myPageVO) throws SQLException {
		return null;
	}
	
	public String doUpdateComment(MyPageVO myPageVO) throws SQLException {
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
