package com.pcwk.ehr.member;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pcwk.ehr.member.UserVO;
import com.google.gson.Gson;

import com.pcwk.ehr.MessageVO;
import com.pcwk.ehr.Rank;
import com.pcwk.ehr.SearchVO;
import com.pcwk.ehr.StringUtil;
import com.pcwk.ehr.member.UserService;

/**
 * view(화면) -> Controller로 param을 받는다. -> param to VO -> Service -> flag
 * 
 * @author PC CAFE 8F B-110
 *
 */
@Controller
public class UserController {

	final Logger LOG = LoggerFactory.getLogger(getClass());

	@Autowired
	UserService service;

	public UserController() {
	}

	// member.doSelectOne.do?uId=pcwk_01
	@RequestMapping(value = "member/doSelectOne.do", method = RequestMethod.GET)
	public String doSelectOne(UserVO inVO, Model model) throws ClassNotFoundException, SQLException {
		LOG.debug("=============================");
		LOG.debug("=doSelectOne=");
		LOG.debug("=param=" + inVO);
		LOG.debug("=============================");

		UserVO outVO = service.doSelectOne(inVO);
		LOG.debug("=outVO=" + outVO);
		model.addAttribute("vo", outVO);
		return "member/member_mng";
	}

	@RequestMapping(value = "member/doInsert.do", method = RequestMethod.POST, produces = "application/json; charset = utf-8")
	@ResponseBody
	public String doInsert(HttpServletRequest req) throws ClassNotFoundException, SQLException {
		UserVO inVO = new UserVO();
		MessageVO messageVO = new MessageVO();
		// request -> VO
		String memberNumStr = req.getParameter("memberNum");
		inVO.setMemberNum(Integer.valueOf("memberNumStr"));
		
		String seqStr = req.getParameter("seq");
		inVO.setSeq(Integer.valueOf("seqStr"));
		
		inVO.setId(req.getParameter("id"));
		inVO.setNickName(req.getParameter("nickname"));
		inVO.setPhoneNum(req.getParameter("phoneNum"));
		inVO.setEmail(req.getParameter("email"));
		inVO.setPw(req.getParameter("pw"));
		inVO.setBirthday(req.getParameter("birthday"));
		inVO.setSex(req.getParameter("sex"));
		inVO.setModDt(req.getParameter("modDt"));
		
		String regNumStr = req.getParameter("regNum");
		inVO.setRegNum(Integer.valueOf("regNumStr"));
		

		String mRankStr = StringUtil.nvl(req.getParameter("level"), "1");
		inVO.setRank(Rank.valueOf(mRankStr)); // 등급 : Default : 1
		

		

		LOG.debug("=============================");
		LOG.debug("=inVO=" + inVO);
		LOG.debug("=============================");

		int flag = this.service.doInsert(inVO);

		String messageStr = "";
		if (1 == flag) {
			messageStr = "등록 되었습니다.";
		} else {
			messageStr = "등록 실패.";
		}
		messageVO.setMsgId(String.valueOf(flag));
		messageVO.setMsgContents(messageStr);

		Gson gson = new Gson();
		String gsonStr = gson.toJson(messageVO);
		LOG.debug("=============================");
		LOG.debug("=gsonStr=" + gsonStr);
		LOG.debug("=============================");

		return gsonStr;
	}

	// member/doDelete.do?uId=pcwk_01
	@RequestMapping(value = "member/doDelete.do", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String doDelete(UserVO user, HttpServletRequest req) throws SQLException {
		UserVO inVO = new UserVO();
		MessageVO messageVO = new MessageVO();
		LOG.debug("=============================");
		LOG.debug("=doDelete=");
		LOG.debug("=param=" + user);
		LOG.debug("=============================");
		String userId = req.getParameter("uId");
		inVO.setId(userId);
		LOG.debug("=param=" + inVO);
		int flag = this.service.doDelete(inVO);

		String resultMsg = "";
		if (1 == flag) {
			resultMsg = "삭제 되었습니다.";
		} else {
			resultMsg = "삭제 실패.";
		}
		messageVO.setMsgId(String.valueOf(flag));
		messageVO.setMsgContents(resultMsg);

		// MessageVO -> JSON
		Gson gson = new Gson();
		String jsonStr = gson.toJson(messageVO);
		LOG.debug("=============================");
		LOG.debug("=jsonStr=" + jsonStr);
		LOG.debug("=============================");

		return jsonStr;

	}

	@RequestMapping(value="member/doUpdate.do"
			,method = RequestMethod.POST
			,produces = "application/json;charset=UTF-8"
			)
	@ResponseBody
	public String doUpdate(UserVO user) throws SQLException{
        MessageVO  messageVO = new MessageVO();
		LOG.debug("=====================================");
		LOG.debug("=user="+user);
		LOG.debug("=====================================");	
		
		if(null == user.getRank()) {
			user.setRank(Rank.BASIC);
		}
		
		int flag  = this.service.doUpdate(user);
		
		String messageStr = "";
		
		if(1==flag) {
			messageStr = "수정 되었습니다.";
		}else {
			messageStr = "수정 실패";
		}
		messageVO.setMsgId(String.valueOf(flag));
		messageVO.setMsgContents(messageStr);
		LOG.debug("=====================================");
		LOG.debug("=messageVO="+messageVO);
		LOG.debug("=====================================");	
		
		Gson gson=new Gson();
		String jsonStr = gson.toJson(messageVO);
		LOG.debug("=jsonStr="+jsonStr);
		return jsonStr;
	}

	@RequestMapping(value="member/doRetrieve.do"
			,method=RequestMethod.GET
			,produces="application/json;charset=UTF-8")
	@ResponseBody
	public String doRetrieve(SearchVO search) throws SQLException{
		
		//Default: pageSize=10, pageNum=1
		//페이지 Num
		if(0==search.getPageNum()) {
			search.setPageNum(1);
		}
		      
		//pageSize
		if(0==search.getPageSize()) {
			search.setPageSize(10);
		}		
		
		LOG.debug("=====================================");
		LOG.debug("=search=");
		LOG.debug("=search="+search);
		LOG.debug("=====================================");		
		
		List<UserVO> list = (List<UserVO>) this.service.doRetrieve(search);
		
		for(UserVO vo   :list) {
			LOG.debug("=vo="+vo);
		}
		
		Gson gson=new Gson();
		String jsonList = gson.toJson(list);
		LOG.debug("=====================================");
		LOG.debug("=jsonList="+jsonList);
		LOG.debug("=====================================");				
		
		
		return jsonList;
	}	

}
