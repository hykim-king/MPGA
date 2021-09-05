package com.pcwk.ehr.member;

import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pcwk.ehr.member.UserVO;
import com.pcwk.ehr.member.UserService;
	
	/**
	 * view(화면) -> Controller로 param을 받는다.
	 * 			 -> param to VO -> Service
	 * 			 ->	flag
	 * @author PC CAFE 8F B-110
	 *
	 */
	@Controller
	public class UserController {
		
		final Logger LOG = LoggerFactory.getLogger(getClass());
		
		@Autowired
		UserService service;
		
		public UserController() {}
		
		//member.doSelectOne.do?uId=pcwk_01
		@RequestMapping(value = "member/doSelectOne.do", method = RequestMethod.GET)
		public String doSelectOne(UserVO inVO, Model model) throws ClassNotFoundException, SQLException{
			LOG.debug("=============================");
			LOG.debug("=doSelectOne=");
			LOG.debug("=param="+inVO);
			LOG.debug("=============================");
			
			UserVO outVO = service.doSelectOne(inVO);
			LOG.debug("=outVO="+outVO);
			model.addAttribute("vo", outVO);
			return "member/member_mng";
		}
		
		public String doInsert(final UserVO user) throws ClassNotFoundException, SQLException{
			
			return "";
		}
		
		
		public String doDelete(UserVO user) throws SQLException{
			
			return "";
		}
		
		public String doUpdate(UserVO user) throws SQLException{
			
			return "";
		}
		
		public String doRetrieve(UserVO user) throws SQLException{
			
			return "";
		}
		
	}


